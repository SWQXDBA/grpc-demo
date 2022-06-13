import io.grpc.stub.StreamObserver;

public class ServerApiService extends WebApiServiceGrpc.WebApiServiceImplBase {
    @Override
    public void doRequest(WebApi.Request request, StreamObserver<WebApi.Response> responseObserver) {

    }
}
