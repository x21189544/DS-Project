// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lighting.proto

package ds.smartbuilding.lighting;

public final class LightServiceImpl {
  private LightServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_lighting_lightOnRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_lighting_lightOnRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_lighting_lightOffRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_lighting_lightOffRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_lighting_lightResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_lighting_lightResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016lighting.proto\022\010lighting\"\"\n\016lightOnReq" +
      "uest\022\020\n\010areaCode\030\001 \001(\t\"#\n\017lightOffReques" +
      "t\022\020\n\010areaCode\030\001 \001(\t\"$\n\rlightResponse\022\023\n\013" +
      "msgResponse\030\001 \001(\t2\220\001\n\014LightService\022>\n\007li" +
      "ghtOn\022\030.lighting.lightOnRequest\032\027.lighti" +
      "ng.lightResponse\"\000\022@\n\010lightOff\022\031.lightin" +
      "g.lightOffRequest\032\027.lighting.lightRespon" +
      "se\"\000B/\n\031ds.smartbuilding.lightingB\020Light" +
      "ServiceImplP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_lighting_lightOnRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_lighting_lightOnRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_lighting_lightOnRequest_descriptor,
        new java.lang.String[] { "AreaCode", });
    internal_static_lighting_lightOffRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_lighting_lightOffRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_lighting_lightOffRequest_descriptor,
        new java.lang.String[] { "AreaCode", });
    internal_static_lighting_lightResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_lighting_lightResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_lighting_lightResponse_descriptor,
        new java.lang.String[] { "MsgResponse", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
