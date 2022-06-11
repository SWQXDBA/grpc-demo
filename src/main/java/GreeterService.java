import io.grpc.stub.StreamObserver;

public class GreeterService extends GreeterGrpc.GreeterImplBase{
    @Override
    public void sayHello(Hello.HelloRequest request, StreamObserver<Hello.HelloReply> responseObserver) {
        final String request1 = request.getRequest();
        Hello.HelloReply.Builder reply = Hello.HelloReply.newBuilder();
        System.out.println(request1);
        reply.setReply("666,"+request1);

        responseObserver.onNext(reply.build());
        responseObserver.onCompleted();
    }
}
