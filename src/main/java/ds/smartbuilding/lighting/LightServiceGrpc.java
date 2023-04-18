package ds.smartbuilding.lighting;

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
    comments = "Source: lighting.proto")
public final class LightServiceGrpc {

  private LightServiceGrpc() {}

  public static final String SERVICE_NAME = "lighting.LightService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.smartbuilding.lighting.lightOnRequest,
      ds.smartbuilding.lighting.lightResponse> getLightOnMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "lightOn",
      requestType = ds.smartbuilding.lighting.lightOnRequest.class,
      responseType = ds.smartbuilding.lighting.lightResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.smartbuilding.lighting.lightOnRequest,
      ds.smartbuilding.lighting.lightResponse> getLightOnMethod() {
    io.grpc.MethodDescriptor<ds.smartbuilding.lighting.lightOnRequest, ds.smartbuilding.lighting.lightResponse> getLightOnMethod;
    if ((getLightOnMethod = LightServiceGrpc.getLightOnMethod) == null) {
      synchronized (LightServiceGrpc.class) {
        if ((getLightOnMethod = LightServiceGrpc.getLightOnMethod) == null) {
          LightServiceGrpc.getLightOnMethod = getLightOnMethod = 
              io.grpc.MethodDescriptor.<ds.smartbuilding.lighting.lightOnRequest, ds.smartbuilding.lighting.lightResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lighting.LightService", "lightOn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartbuilding.lighting.lightOnRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartbuilding.lighting.lightResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightServiceMethodDescriptorSupplier("lightOn"))
                  .build();
          }
        }
     }
     return getLightOnMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.smartbuilding.lighting.lightOffRequest,
      ds.smartbuilding.lighting.lightResponse> getLightOffMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "lightOff",
      requestType = ds.smartbuilding.lighting.lightOffRequest.class,
      responseType = ds.smartbuilding.lighting.lightResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.smartbuilding.lighting.lightOffRequest,
      ds.smartbuilding.lighting.lightResponse> getLightOffMethod() {
    io.grpc.MethodDescriptor<ds.smartbuilding.lighting.lightOffRequest, ds.smartbuilding.lighting.lightResponse> getLightOffMethod;
    if ((getLightOffMethod = LightServiceGrpc.getLightOffMethod) == null) {
      synchronized (LightServiceGrpc.class) {
        if ((getLightOffMethod = LightServiceGrpc.getLightOffMethod) == null) {
          LightServiceGrpc.getLightOffMethod = getLightOffMethod = 
              io.grpc.MethodDescriptor.<ds.smartbuilding.lighting.lightOffRequest, ds.smartbuilding.lighting.lightResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lighting.LightService", "lightOff"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartbuilding.lighting.lightOffRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartbuilding.lighting.lightResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightServiceMethodDescriptorSupplier("lightOff"))
                  .build();
          }
        }
     }
     return getLightOffMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LightServiceStub newStub(io.grpc.Channel channel) {
    return new LightServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LightServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LightServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LightServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LightServiceFutureStub(channel);
  }

  /**
   * <pre>
   *define services
   * </pre>
   */
  public static abstract class LightServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void lightOn(ds.smartbuilding.lighting.lightOnRequest request,
        io.grpc.stub.StreamObserver<ds.smartbuilding.lighting.lightResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLightOnMethod(), responseObserver);
    }

    /**
     */
    public void lightOff(ds.smartbuilding.lighting.lightOffRequest request,
        io.grpc.stub.StreamObserver<ds.smartbuilding.lighting.lightResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLightOffMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLightOnMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.smartbuilding.lighting.lightOnRequest,
                ds.smartbuilding.lighting.lightResponse>(
                  this, METHODID_LIGHT_ON)))
          .addMethod(
            getLightOffMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.smartbuilding.lighting.lightOffRequest,
                ds.smartbuilding.lighting.lightResponse>(
                  this, METHODID_LIGHT_OFF)))
          .build();
    }
  }

  /**
   * <pre>
   *define services
   * </pre>
   */
  public static final class LightServiceStub extends io.grpc.stub.AbstractStub<LightServiceStub> {
    private LightServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightServiceStub(channel, callOptions);
    }

    /**
     */
    public void lightOn(ds.smartbuilding.lighting.lightOnRequest request,
        io.grpc.stub.StreamObserver<ds.smartbuilding.lighting.lightResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLightOnMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void lightOff(ds.smartbuilding.lighting.lightOffRequest request,
        io.grpc.stub.StreamObserver<ds.smartbuilding.lighting.lightResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLightOffMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *define services
   * </pre>
   */
  public static final class LightServiceBlockingStub extends io.grpc.stub.AbstractStub<LightServiceBlockingStub> {
    private LightServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.smartbuilding.lighting.lightResponse lightOn(ds.smartbuilding.lighting.lightOnRequest request) {
      return blockingUnaryCall(
          getChannel(), getLightOnMethod(), getCallOptions(), request);
    }

    /**
     */
    public ds.smartbuilding.lighting.lightResponse lightOff(ds.smartbuilding.lighting.lightOffRequest request) {
      return blockingUnaryCall(
          getChannel(), getLightOffMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *define services
   * </pre>
   */
  public static final class LightServiceFutureStub extends io.grpc.stub.AbstractStub<LightServiceFutureStub> {
    private LightServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.smartbuilding.lighting.lightResponse> lightOn(
        ds.smartbuilding.lighting.lightOnRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLightOnMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.smartbuilding.lighting.lightResponse> lightOff(
        ds.smartbuilding.lighting.lightOffRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLightOffMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIGHT_ON = 0;
  private static final int METHODID_LIGHT_OFF = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LightServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LightServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIGHT_ON:
          serviceImpl.lightOn((ds.smartbuilding.lighting.lightOnRequest) request,
              (io.grpc.stub.StreamObserver<ds.smartbuilding.lighting.lightResponse>) responseObserver);
          break;
        case METHODID_LIGHT_OFF:
          serviceImpl.lightOff((ds.smartbuilding.lighting.lightOffRequest) request,
              (io.grpc.stub.StreamObserver<ds.smartbuilding.lighting.lightResponse>) responseObserver);
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

  private static abstract class LightServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LightServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.smartbuilding.lighting.LightServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LightService");
    }
  }

  private static final class LightServiceFileDescriptorSupplier
      extends LightServiceBaseDescriptorSupplier {
    LightServiceFileDescriptorSupplier() {}
  }

  private static final class LightServiceMethodDescriptorSupplier
      extends LightServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LightServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (LightServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LightServiceFileDescriptorSupplier())
              .addMethod(getLightOnMethod())
              .addMethod(getLightOffMethod())
              .build();
        }
      }
    }
    return result;
  }
}
