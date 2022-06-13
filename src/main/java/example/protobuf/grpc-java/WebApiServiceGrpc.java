package example.protobuf.grpc;

import example.protobuf.java.WebApi;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.47.0)",
    comments = "Source: WebApi.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WebApiServiceGrpc {

  private WebApiServiceGrpc() {}

  public static final String SERVICE_NAME = "WebApiService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<WebApi.Request,
      WebApi.Response> getDoRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "doRequest",
      requestType = WebApi.Request.class,
      responseType = WebApi.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<WebApi.Request,
      WebApi.Response> getDoRequestMethod() {
    io.grpc.MethodDescriptor<WebApi.Request, WebApi.Response> getDoRequestMethod;
    if ((getDoRequestMethod = WebApiServiceGrpc.getDoRequestMethod) == null) {
      synchronized (WebApiServiceGrpc.class) {
        if ((getDoRequestMethod = WebApiServiceGrpc.getDoRequestMethod) == null) {
          WebApiServiceGrpc.getDoRequestMethod = getDoRequestMethod =
              io.grpc.MethodDescriptor.<WebApi.Request, WebApi.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "doRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  WebApi.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  WebApi.Response.getDefaultInstance()))
              .setSchemaDescriptor(new WebApiServiceMethodDescriptorSupplier("doRequest"))
              .build();
        }
      }
    }
    return getDoRequestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WebApiServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WebApiServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WebApiServiceStub>() {
        @Override
        public WebApiServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WebApiServiceStub(channel, callOptions);
        }
      };
    return WebApiServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WebApiServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WebApiServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WebApiServiceBlockingStub>() {
        @Override
        public WebApiServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WebApiServiceBlockingStub(channel, callOptions);
        }
      };
    return WebApiServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WebApiServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WebApiServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WebApiServiceFutureStub>() {
        @Override
        public WebApiServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WebApiServiceFutureStub(channel, callOptions);
        }
      };
    return WebApiServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class WebApiServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void doRequest(WebApi.Request request,
                          io.grpc.stub.StreamObserver<WebApi.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDoRequestMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDoRequestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                WebApi.Request,
                WebApi.Response>(
                  this, METHODID_DO_REQUEST)))
          .build();
    }
  }

  /**
   */
  public static final class WebApiServiceStub extends io.grpc.stub.AbstractAsyncStub<WebApiServiceStub> {
    private WebApiServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected WebApiServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WebApiServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void doRequest(WebApi.Request request,
                          io.grpc.stub.StreamObserver<WebApi.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDoRequestMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class WebApiServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<WebApiServiceBlockingStub> {
    private WebApiServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected WebApiServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WebApiServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public WebApi.Response doRequest(WebApi.Request request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDoRequestMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class WebApiServiceFutureStub extends io.grpc.stub.AbstractFutureStub<WebApiServiceFutureStub> {
    private WebApiServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected WebApiServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WebApiServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<WebApi.Response> doRequest(
        WebApi.Request request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDoRequestMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DO_REQUEST = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WebApiServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WebApiServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DO_REQUEST:
          serviceImpl.doRequest((WebApi.Request) request,
              (io.grpc.stub.StreamObserver<WebApi.Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class WebApiServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WebApiServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return WebApi.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WebApiService");
    }
  }

  private static final class WebApiServiceFileDescriptorSupplier
      extends WebApiServiceBaseDescriptorSupplier {
    WebApiServiceFileDescriptorSupplier() {}
  }

  private static final class WebApiServiceMethodDescriptorSupplier
      extends WebApiServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WebApiServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (WebApiServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WebApiServiceFileDescriptorSupplier())
              .addMethod(getDoRequestMethod())
              .build();
        }
      }
    }
    return result;
  }
}
