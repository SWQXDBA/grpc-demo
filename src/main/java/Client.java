import com.google.protobuf.TextFormat;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {
    public static void main(String[] args) {
        ManagedChannel channel =  ManagedChannelBuilder.forAddress("localhost",9090)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build();


        final GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);
        final Hello.HelloRequest request = Hello.HelloRequest.newBuilder().setRequest("我是request").build();
        final Hello.HelloReply reply = stub.sayHello(request);
        System.out.println(TextFormat.printer().escapingNonAscii(false).printToString(reply));

    }
}
