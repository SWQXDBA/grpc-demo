import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.TextFormat;
import error.RemoteFailsError;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import message.RequestMessage;
import message.ResponseMessage;
import message.TestBody;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GrpcClient {

    HashMap<String,ManagedChannel> channels = new HashMap<>();

    public void addServer(String serverName,int port){
        ManagedChannel channel =  ManagedChannelBuilder.forAddress("localhost",port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build();

        channels.put(serverName,channel);
    }


    /**
     * 往一个服务器发送消息
     * @param serverName 服务器名字 用以区分多个服务器
     * @param path 访问的api路径 用来判断是调用哪个接口
     * @param message 消息体
     * @param resultType 返回结果类型
     * @return
     */
    public <T> T callSingle(String serverName,String path,Object message,Class<T> resultType){

        //构建请求消息
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.path = path;
        requestMessage.bodyJson = JSON.toJSONString(message);

        final ManagedChannel channel = channels.get(serverName);

        //构建请求
        WebApiServiceGrpc.WebApiServiceBlockingStub stub = WebApiServiceGrpc.newBlockingStub(channel);
        final WebApi.Request request = WebApi.Request.newBuilder().setRequestMessageJson(JSON.toJSONString(requestMessage)).build();
        //发送请求
        final WebApi.Response response = stub.doRequest(request);

        final String responseMessageJson = response.getResponseMessageJson();
        System.out.println(responseMessageJson);
        final ResponseMessage responseMessage = JSON.parseObject(responseMessageJson, ResponseMessage.class);
        if (!responseMessage.success) {
            throw new RemoteFailsError(responseMessage.errorMessage);
        }

       return JSON.parseObject(responseMessage.bodyJson,resultType);

    }
    /**
     *
     * @param serverName 服务器名字 用以区分多个服务器
     * @param path 访问的api路径 用来判断是调用哪个接口
     * @param message 消息体
     * @return
     */
    public void sendSingle(String serverName,String path,Object message){
        //构建请求消息
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.path = path;
        requestMessage.bodyJson = JSON.toJSONString(message);

        final ManagedChannel channel = channels.get(serverName);

        //构建请求
        WebApiServiceGrpc.WebApiServiceBlockingStub stub = WebApiServiceGrpc.newBlockingStub(channel);
        final WebApi.Request request = WebApi.Request.newBuilder().setRequestMessageJson(JSON.toJSONString(requestMessage)).build();
        //发送请求
        stub.doRequest(request);
    }
    public static void main(String[] args) {
        GrpcClient client = new GrpcClient();
        client.addServer("server1",9090);

        TestBody testBody = new TestBody();
        testBody.nums = new int[]{1,2,3};
        testBody.map.put("key1",1);
        testBody.map.put("key2",2);
        final TestBody res = client.callSingle("server1", "test", testBody,TestBody.class);

        System.out.println(res);

    }
}
