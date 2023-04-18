package ds.smartbuilding.allocate;

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
    comments = "Source: allocation.proto")
public final class AllocateServiceGrpc {

  private AllocateServiceGrpc() {}

  public static final String SERVICE_NAME = "allocate.AllocateService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.smartbuilding.allocate.listofAttendeesRequest,
      ds.smartbuilding.allocate.meetingRoomResponse> getAllocateRoomMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "allocateRoom",
      requestType = ds.smartbuilding.allocate.listofAttendeesRequest.class,
      responseType = ds.smartbuilding.allocate.meetingRoomResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.smartbuilding.allocate.listofAttendeesRequest,
      ds.smartbuilding.allocate.meetingRoomResponse> getAllocateRoomMethod() {
    io.grpc.MethodDescriptor<ds.smartbuilding.allocate.listofAttendeesRequest, ds.smartbuilding.allocate.meetingRoomResponse> getAllocateRoomMethod;
    if ((getAllocateRoomMethod = AllocateServiceGrpc.getAllocateRoomMethod) == null) {
      synchronized (AllocateServiceGrpc.class) {
        if ((getAllocateRoomMethod = AllocateServiceGrpc.getAllocateRoomMethod) == null) {
          AllocateServiceGrpc.getAllocateRoomMethod = getAllocateRoomMethod = 
              io.grpc.MethodDescriptor.<ds.smartbuilding.allocate.listofAttendeesRequest, ds.smartbuilding.allocate.meetingRoomResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "allocate.AllocateService", "allocateRoom"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartbuilding.allocate.listofAttendeesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartbuilding.allocate.meetingRoomResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AllocateServiceMethodDescriptorSupplier("allocateRoom"))
                  .build();
          }
        }
     }
     return getAllocateRoomMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AllocateServiceStub newStub(io.grpc.Channel channel) {
    return new AllocateServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AllocateServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AllocateServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AllocateServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AllocateServiceFutureStub(channel);
  }

  /**
   * <pre>
   *define services
   * </pre>
   */
  public static abstract class AllocateServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<ds.smartbuilding.allocate.listofAttendeesRequest> allocateRoom(
        io.grpc.stub.StreamObserver<ds.smartbuilding.allocate.meetingRoomResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getAllocateRoomMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAllocateRoomMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ds.smartbuilding.allocate.listofAttendeesRequest,
                ds.smartbuilding.allocate.meetingRoomResponse>(
                  this, METHODID_ALLOCATE_ROOM)))
          .build();
    }
  }

  /**
   * <pre>
   *define services
   * </pre>
   */
  public static final class AllocateServiceStub extends io.grpc.stub.AbstractStub<AllocateServiceStub> {
    private AllocateServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AllocateServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AllocateServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AllocateServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.smartbuilding.allocate.listofAttendeesRequest> allocateRoom(
        io.grpc.stub.StreamObserver<ds.smartbuilding.allocate.meetingRoomResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getAllocateRoomMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   *define services
   * </pre>
   */
  public static final class AllocateServiceBlockingStub extends io.grpc.stub.AbstractStub<AllocateServiceBlockingStub> {
    private AllocateServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AllocateServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AllocateServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AllocateServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   *define services
   * </pre>
   */
  public static final class AllocateServiceFutureStub extends io.grpc.stub.AbstractStub<AllocateServiceFutureStub> {
    private AllocateServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AllocateServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AllocateServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AllocateServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_ALLOCATE_ROOM = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AllocateServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AllocateServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ALLOCATE_ROOM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.allocateRoom(
              (io.grpc.stub.StreamObserver<ds.smartbuilding.allocate.meetingRoomResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AllocateServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AllocateServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.smartbuilding.allocate.AllocateServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AllocateService");
    }
  }

  private static final class AllocateServiceFileDescriptorSupplier
      extends AllocateServiceBaseDescriptorSupplier {
    AllocateServiceFileDescriptorSupplier() {}
  }

  private static final class AllocateServiceMethodDescriptorSupplier
      extends AllocateServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AllocateServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AllocateServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AllocateServiceFileDescriptorSupplier())
              .addMethod(getAllocateRoomMethod())
              .build();
        }
      }
    }
    return result;
  }
}
