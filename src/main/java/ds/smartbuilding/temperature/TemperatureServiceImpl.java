// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: temperature.proto

package ds.smartbuilding.temperature;

public final class TemperatureServiceImpl {
  private TemperatureServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_temperature_setTempRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_temperature_setTempRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_temperature_setTempResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_temperature_setTempResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_temperature_getTempRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_temperature_getTempRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_temperature_getTempResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_temperature_getTempResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021temperature.proto\022\013temperature\"7\n\016setT" +
      "empRequest\022\020\n\010areaCode\030\001 \001(\t\022\023\n\013temperat" +
      "ure\030\002 \001(\001\"&\n\017setTempResponse\022\023\n\013msgRespo" +
      "nse\030\001 \001(\t\"\"\n\016getTempRequest\022\020\n\010areaCode\030" +
      "\001 \001(\t\"&\n\017getTempResponse\022\023\n\013temperature\030" +
      "\001 \001(\0012\244\001\n\022TemperatureService\022F\n\007setTemp\022" +
      "\033.temperature.setTempRequest\032\034.temperatu" +
      "re.setTempResponse\"\000\022F\n\007getTemp\022\033.temper" +
      "ature.getTempRequest\032\034.temperature.getTe" +
      "mpResponse\"\000B8\n\034ds.smartbuilding.tempera" +
      "tureB\026TemperatureServiceImplP\001b\006proto3"
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
    internal_static_temperature_setTempRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_temperature_setTempRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_temperature_setTempRequest_descriptor,
        new java.lang.String[] { "AreaCode", "Temperature", });
    internal_static_temperature_setTempResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_temperature_setTempResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_temperature_setTempResponse_descriptor,
        new java.lang.String[] { "MsgResponse", });
    internal_static_temperature_getTempRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_temperature_getTempRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_temperature_getTempRequest_descriptor,
        new java.lang.String[] { "AreaCode", });
    internal_static_temperature_getTempResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_temperature_getTempResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_temperature_getTempResponse_descriptor,
        new java.lang.String[] { "Temperature", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}