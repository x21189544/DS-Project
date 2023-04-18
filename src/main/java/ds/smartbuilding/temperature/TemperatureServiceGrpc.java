package ds.smartbuilding.temperature;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 *define services
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: temperature.proto")
public final class TemperatureServiceGrpc {

  private TemperatureServiceGrpc() {}

  public static final String SERVICE_NAME = "temperature.TemperatureService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.smartbuilding.temperature.setTempRequest,
      ds.smartbuilding.temperature.setTempResponse> getSetTempMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setTemp",
      requestType = ds.smartbuilding.temperature.setTempRequest.class,
      responseType = ds.smartbuilding.temperature.setTempResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.smartbuilding.temperature.setTempRequest,
      ds.smartbuilding.temperature.setTempResponse> getSetTempMethod() {
    io.grpc.MethodDescriptor<ds.smartbuilding.temperature.setTempRequest, ds.smartbuilding.temperature.setTempResponse> getSetTempMethod;
    if ((getSetTempMethod = TemperatureServiceGrpc.getSetTempMethod) == null) {
      synchronized (TemperatureServiceGrpc.class) {
        if ((getSetTempMethod = TemperatureServiceGrpc.getSetTempMethod) == null) {
          TemperatureServiceGrpc.getSetTempMethod = getSetTempMethod = 
              io.grpc.MethodDescriptor.<ds.smartbuilding.temperature.setTempRequest, ds.smartbuilding.temperature.setTempResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "temperature.TemperatureService", "setTemp"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartbuilding.temperature.setTempRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartbuilding.temperature.setTempResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TemperatureServiceMethodDescriptorSupplier("setTemp"))
                  .build();
          }
        }
     }
     return getSetTempMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.smartbuilding.temperature.getTempRequest,
      ds.smartbuilding.temperature.getTempResponse> getGetTempMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getTemp",
      requestType = ds.smartbuilding.temperature.getTempRequest.class,
      responseType = ds.smartbuilding.temperature.getTempResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.smartbuilding.temperature.getTempRequest,
      ds.smartbuilding.temperature.getTempResponse> getGetTempMethod() {
    io.grpc.MethodDescriptor<ds.smartbuilding.temperature.getTempRequest, ds.smartbuilding.temperature.getTempResponse> getGetTempMethod;
    if ((getGetTempMethod = TemperatureServiceGrpc.getGetTempMethod) == null) {
      synchronized (TemperatureServiceGrpc.class) {
        if ((getGetTempMethod = TemperatureServiceGrpc.getGetTempMethod) == null) {
          TemperatureServiceGrpc.getGetTempMethod = getGetTempMethod = 
              io.grpc.MethodDescriptor.<ds.smartbuilding.temperature.getTempRequest, ds.smartbuilding.temperature.getTempResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "temperature.TemperatureService", "getTemp"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartbuilding.temperature.getTempRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartbuilding.temperature.getTempResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TemperatureServiceMethodDescriptorSupplier("getTemp"))
                  .build();
          }
        }
     }
     return getGetTempMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TemperatureServiceStub newStub(io.grpc.Channel channel) {
    return new TemperatureServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TemperatureServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TemperatureServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TemperatureServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TemperatureServiceFutureStub(channel);
  }

  /**
   * <pre>
   *define services
   * </pre>
   */
  public static abstract class TemperatureServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void setTemp(ds.smartbuilding.temperature.setTempRequest request,
        io.grpc.stub.StreamObserver<ds.smartbuilding.temperature.setTempResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSetTempMethod(), responseObserver);
    }

    /**
     */
    public void getTemp(ds.smartbuilding.temperature.getTempRequest request,
        io.grpc.stub.StreamObserver<ds.smartbuilding.temperature.getTempResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTempMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetTempMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.smartbuilding.temperature.setTempRequest,
                ds.smartbuilding.temperature.setTempResponse>(
                  this, METHODID_SET_TEMP)))
          .addMethod(
            getGetTempMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.smartbuilding.temperature.getTempRequest,
                ds.smartbuilding.temperature.getTempResponse>(
                  this, METHODID_GET_TEMP)))
          .build();
    }
  }

  /**
   * <pre>
   *define services
   * </pre>
   */
  public static final class TemperatureServiceStub extends io.grpc.stub.AbstractStub<TemperatureServiceStub> {
    private TemperatureServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TemperatureServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TemperatureServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TemperatureServiceStub(channel, callOptions);
    }

    /**
     */
    public void setTemp(ds.smartbuilding.temperature.setTempRequest request,
        io.grpc.stub.StreamObserver<ds.smartbuilding.temperature.setTempResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetTempMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTemp(ds.smartbuilding.temperature.getTempRequest request,
        io.grpc.stub.StreamObserver<ds.smartbuilding.temperature.getTempResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTempMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *define services
   * </pre>
   */
  public static final class TemperatureServiceBlockingStub extends io.grpc.stub.AbstractStub<TemperatureServiceBlockingStub> {
    private TemperatureServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TemperatureServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TemperatureServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TemperatureServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.smartbuilding.temperature.setTempResponse setTemp(ds.smartbuilding.temperature.setTempRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetTempMethod(), getCallOptions(), request);
    }

    /**
     */
    public ds.smartbuilding.temperature.getTempResponse getTemp(ds.smartbuilding.temperature.getTempRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTempMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *define services
   * </pre>
   */
  public static final class TemperatureServiceFutureStub extends io.grpc.stub.AbstractStub<TemperatureServiceFutureStub> {
    private TemperatureServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TemperatureServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TemperatureServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TemperatureServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.smartbuilding.temperature.setTempResponse> setTemp(
        ds.smartbuilding.temperature.setTempRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetTempMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.smartbuilding.temperature.getTempResponse> getTemp(
        ds.smartbuilding.temperature.getTempRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTempMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_TEMP = 0;
  private static final int METHODID_GET_TEMP = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TemperatureServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TemperatureServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_TEMP:
          serviceImpl.setTemp((ds.smartbuilding.temperature.setTempRequest) request,
              (io.grpc.stub.StreamObserver<ds.smartbuilding.temperature.setTempResponse>) responseObserver);
          break;
        case METHODID_GET_TEMP:
          serviceImpl.getTemp((ds.smartbuilding.temperature.getTempRequest) request,
              (io.grpc.stub.StreamObserver<ds.smartbuilding.temperature.getTempResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TemperatureServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TemperatureServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.smartbuilding.temperature.TemperatureServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TemperatureService");
    }
  }

  private static final class TemperatureServiceFileDescriptorSupplier
      extends TemperatureServiceBaseDescriptorSupplier {
    TemperatureServiceFileDescriptorSupplier() {}
  }

  private static final class TemperatureServiceMethodDescriptorSupplier
      extends TemperatureServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TemperatureServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TemperatureServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TemperatureServiceFileDescriptorSupplier())
              .addMethod(getSetTempMethod())
              .addMethod(getGetTempMethod())
              .build();
        }
      }
    }
    return result;
  }
}
