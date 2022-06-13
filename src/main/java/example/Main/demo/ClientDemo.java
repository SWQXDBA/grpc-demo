package example.Main.demo;

import example.Main.GrpcClient;
import example.Main.message.TestBody;

public class ClientDemo {
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
