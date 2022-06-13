package example.Main;

import com.alibaba.fastjson.JSON;
import example.Main.message.RequestMessage;
import example.Main.message.ResponseMessage;
import example.Main.message.TestBody;
import example.protobuf.java.WebApi;
import io.grpc.stub.StreamObserver;


public class ServerApiService extends example.protobuf.grpc.WebApiServiceGrpc.WebApiServiceImplBase {
    @Override
    public void doRequest(WebApi.Request request, StreamObserver<WebApi.Response> responseObserver) {
        final String requestMessageJson = request.getRequestMessageJson();
        final RequestMessage requestMessage = JSON.parseObject(requestMessageJson, RequestMessage.class);

        System.out.println("访问了"+ requestMessage.path);
        TestBody body =  JSON.parseObject(requestMessage.bodyJson, TestBody.class);
        System.out.println("来自客户端的body:"+body);

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.success = true;
        responseMessage.bodyJson = JSON.toJSONString(body);
        final String responseMessageJson = JSON.toJSONString(responseMessage);
        WebApi.Response response = WebApi.Response.newBuilder().setResponseMessageJson(responseMessageJson).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();


    }
}
