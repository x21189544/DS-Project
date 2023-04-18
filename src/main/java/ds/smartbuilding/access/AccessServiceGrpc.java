package ds.smartbuilding.access;

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
    comments = "Source: access.proto")
public final class AccessServiceGrpc {

  private AccessServiceGrpc() {}

  public static final String SERVICE_NAME = "access.AccessService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.smartbuilding.access.occupantReportRequest,
      ds.smartbuilding.access.occupantReportResponse> getOccupantReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "occupantReport",
      requestType = ds.smartbuilding.access.occupantReportRequest.class,
      responseType = ds.smartbuilding.access.occupantReportResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.smartbuilding.access.occupantReportRequest,
      ds.smartbuilding.access.occupantReportResponse> getOccupantReportMethod() {
    io.grpc.MethodDescriptor<ds.smartbuilding.access.occupantReportRequest, ds.smartbuilding.access.occupantReportResponse> getOccupantReportMethod;
    if ((getOccupantReportMethod = AccessServiceGrpc.getOccupantReportMethod) == null) {
      synchronized (AccessServiceGrpc.class) {
        if ((getOccupantReportMethod = AccessServiceGrpc.getOccupantReportMethod) == null) {
          AccessServiceGrpc.getOccupantReportMethod = getOccupantReportMethod = 
              io.grpc.MethodDescriptor.<ds.smartbuilding.access.occupantReportRequest, ds.smartbuilding.access.occupantReportResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "access.AccessService", "occupantReport"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartbuilding.access.occupantReportRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartbuilding.access.occupantReportResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AccessServiceMethodDescriptorSupplier("occupantReport"))
                  .build();
          }
        }
     }
     return getOccupantReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.smartbuilding.access.occupantCheckListRequest,
      ds.smartbuilding.access.occupantCheckListResponse> getOccupantCheckListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "occupantCheckList",
      requestType = ds.smartbuilding.access.occupantCheckListRequest.class,
      responseType = ds.smartbuilding.access.occupantCheckListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ds.smartbuilding.access.occupantCheckListRequest,
      ds.smartbuilding.access.occupantCheckListResponse> getOccupantCheckListMethod() {
    io.grpc.MethodDescriptor<ds.smartbuilding.access.occupantCheckListRequest, ds.smartbuilding.access.occupantCheckListResponse> getOccupantCheckListMethod;
    if ((getOccupantCheckListMethod = AccessServiceGrpc.getOccupantCheckListMethod) == null) {
      synchronized (AccessServiceGrpc.class) {
        if ((getOccupantCheckListMethod = AccessServiceGrpc.getOccupantCheckListMethod) == null) {
          AccessServiceGrpc.getOccupantCheckListMethod = getOccupantCheckListMethod = 
              io.grpc.MethodDescriptor.<ds.smartbuilding.access.occupantCheckListRequest, ds.smartbuilding.access.occupantCheckListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "access.AccessService", "occupantCheckList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartbuilding.access.occupantCheckListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartbuilding.access.occupantCheckListResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AccessServiceMethodDescriptorSupplier("occupantCheckList"))
                  .build();
          }
        }
     }
     return getOccupantCheckListMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AccessServiceStub newStub(io.grpc.Channel channel) {
    return new AccessServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AccessServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AccessServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AccessServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AccessServiceFutureStub(channel);
  }

  /**
   * <pre>
   *define services
   * </pre>
   */
  public static abstract class AccessServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void occupantReport(ds.smartbuilding.access.occupantReportRequest request,
        io.grpc.stub.StreamObserver<ds.smartbuilding.access.occupantReportResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getOccupantReportMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.smartbuilding.access.occupantCheckListRequest> occupantCheckList(
        io.grpc.stub.StreamObserver<ds.smartbuilding.access.occupantCheckListResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getOccupantCheckListMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getOccupantReportMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.smartbuilding.access.occupantReportRequest,
                ds.smartbuilding.access.occupantReportResponse>(
                  this, METHODID_OCCUPANT_REPORT)))
          .addMethod(
            getOccupantCheckListMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ds.smartbuilding.access.occupantCheckListRequest,
                ds.smartbuilding.access.occupantCheckListResponse>(
                  this, METHODID_OCCUPANT_CHECK_LIST)))
          .build();
    }
  }

  /**
   * <pre>
   *define services
   * </pre>
   */
  public static final class AccessServiceStub extends io.grpc.stub.AbstractStub<AccessServiceStub> {
    private AccessServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AccessServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccessServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AccessServiceStub(channel, callOptions);
    }

    /**
     */
    public void occupantReport(ds.smartbuilding.access.occupantReportRequest request,
        io.grpc.stub.StreamObserver<ds.smartbuilding.access.occupantReportResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getOccupantReportMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.smartbuilding.access.occupantCheckListRequest> occupantCheckList(
        io.grpc.stub.StreamObserver<ds.smartbuilding.access.occupantCheckListResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getOccupantCheckListMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   *define services
   * </pre>
   */
  public static final class AccessServiceBlockingStub extends io.grpc.stub.AbstractStub<AccessServiceBlockingStub> {
    private AccessServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AccessServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccessServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AccessServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<ds.smartbuilding.access.occupantReportResponse> occupantReport(
        ds.smartbuilding.access.occupantReportRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getOccupantReportMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *define services
   * </pre>
   */
  public static final class AccessServiceFutureStub extends io.grpc.stub.AbstractStub<AccessServiceFutureStub> {
    private AccessServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AccessServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccessServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AccessServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_OCCUPANT_REPORT = 0;
  private static final int METHODID_OCCUPANT_CHECK_LIST = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AccessServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AccessServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_OCCUPANT_REPORT:
          serviceImpl.occupantReport((ds.smartbuilding.access.occupantReportRequest) request,
              (io.grpc.stub.StreamObserver<ds.smartbuilding.access.occupantReportResponse>) responseObserver);
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
        case METHODID_OCCUPANT_CHECK_LIST:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.occupantCheckList(
              (io.grpc.stub.StreamObserver<ds.smartbuilding.access.occupantCheckListResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AccessServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AccessServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.smartbuilding.access.AccessServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AccessService");
    }
  }

  private static final class AccessServiceFileDescriptorSupplier
      extends AccessServiceBaseDescriptorSupplier {
    AccessServiceFileDescriptorSupplier() {}
  }

  private static final class AccessServiceMethodDescriptorSupplier
      extends AccessServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AccessServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AccessServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AccessServiceFileDescriptorSupplier())
              .addMethod(getOccupantReportMethod())
              .addMethod(getOccupantCheckListMethod())
              .build();
        }
      }
    }
    return result;
  }
}
