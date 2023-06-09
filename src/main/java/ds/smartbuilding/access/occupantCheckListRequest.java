// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: access.proto

package ds.smartbuilding.access;

/**
 * Protobuf type {@code access.occupantCheckListRequest}
 */
public  final class occupantCheckListRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:access.occupantCheckListRequest)
    occupantCheckListRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use occupantCheckListRequest.newBuilder() to construct.
  private occupantCheckListRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private occupantCheckListRequest() {
    listOfNames_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private occupantCheckListRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            listOfNames_ = s;
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ds.smartbuilding.access.AccessServiceImpl.internal_static_access_occupantCheckListRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.smartbuilding.access.AccessServiceImpl.internal_static_access_occupantCheckListRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.smartbuilding.access.occupantCheckListRequest.class, ds.smartbuilding.access.occupantCheckListRequest.Builder.class);
  }

  public static final int LISTOFNAMES_FIELD_NUMBER = 1;
  private volatile java.lang.Object listOfNames_;
  /**
   * <code>string listOfNames = 1;</code>
   */
  public java.lang.String getListOfNames() {
    java.lang.Object ref = listOfNames_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      listOfNames_ = s;
      return s;
    }
  }
  /**
   * <code>string listOfNames = 1;</code>
   */
  public com.google.protobuf.ByteString
      getListOfNamesBytes() {
    java.lang.Object ref = listOfNames_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      listOfNames_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getListOfNamesBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, listOfNames_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getListOfNamesBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, listOfNames_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ds.smartbuilding.access.occupantCheckListRequest)) {
      return super.equals(obj);
    }
    ds.smartbuilding.access.occupantCheckListRequest other = (ds.smartbuilding.access.occupantCheckListRequest) obj;

    boolean result = true;
    result = result && getListOfNames()
        .equals(other.getListOfNames());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + LISTOFNAMES_FIELD_NUMBER;
    hash = (53 * hash) + getListOfNames().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.smartbuilding.access.occupantCheckListRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.smartbuilding.access.occupantCheckListRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.smartbuilding.access.occupantCheckListRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.smartbuilding.access.occupantCheckListRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.smartbuilding.access.occupantCheckListRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.smartbuilding.access.occupantCheckListRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.smartbuilding.access.occupantCheckListRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.smartbuilding.access.occupantCheckListRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.smartbuilding.access.occupantCheckListRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.smartbuilding.access.occupantCheckListRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.smartbuilding.access.occupantCheckListRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.smartbuilding.access.occupantCheckListRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ds.smartbuilding.access.occupantCheckListRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code access.occupantCheckListRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:access.occupantCheckListRequest)
      ds.smartbuilding.access.occupantCheckListRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.smartbuilding.access.AccessServiceImpl.internal_static_access_occupantCheckListRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.smartbuilding.access.AccessServiceImpl.internal_static_access_occupantCheckListRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.smartbuilding.access.occupantCheckListRequest.class, ds.smartbuilding.access.occupantCheckListRequest.Builder.class);
    }

    // Construct using ds.smartbuilding.access.occupantCheckListRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      listOfNames_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.smartbuilding.access.AccessServiceImpl.internal_static_access_occupantCheckListRequest_descriptor;
    }

    @java.lang.Override
    public ds.smartbuilding.access.occupantCheckListRequest getDefaultInstanceForType() {
      return ds.smartbuilding.access.occupantCheckListRequest.getDefaultInstance();
    }

    @java.lang.Override
    public ds.smartbuilding.access.occupantCheckListRequest build() {
      ds.smartbuilding.access.occupantCheckListRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.smartbuilding.access.occupantCheckListRequest buildPartial() {
      ds.smartbuilding.access.occupantCheckListRequest result = new ds.smartbuilding.access.occupantCheckListRequest(this);
      result.listOfNames_ = listOfNames_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ds.smartbuilding.access.occupantCheckListRequest) {
        return mergeFrom((ds.smartbuilding.access.occupantCheckListRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.smartbuilding.access.occupantCheckListRequest other) {
      if (other == ds.smartbuilding.access.occupantCheckListRequest.getDefaultInstance()) return this;
      if (!other.getListOfNames().isEmpty()) {
        listOfNames_ = other.listOfNames_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ds.smartbuilding.access.occupantCheckListRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.smartbuilding.access.occupantCheckListRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object listOfNames_ = "";
    /**
     * <code>string listOfNames = 1;</code>
     */
    public java.lang.String getListOfNames() {
      java.lang.Object ref = listOfNames_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        listOfNames_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string listOfNames = 1;</code>
     */
    public com.google.protobuf.ByteString
        getListOfNamesBytes() {
      java.lang.Object ref = listOfNames_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        listOfNames_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string listOfNames = 1;</code>
     */
    public Builder setListOfNames(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      listOfNames_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string listOfNames = 1;</code>
     */
    public Builder clearListOfNames() {
      
      listOfNames_ = getDefaultInstance().getListOfNames();
      onChanged();
      return this;
    }
    /**
     * <code>string listOfNames = 1;</code>
     */
    public Builder setListOfNamesBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      listOfNames_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:access.occupantCheckListRequest)
  }

  // @@protoc_insertion_point(class_scope:access.occupantCheckListRequest)
  private static final ds.smartbuilding.access.occupantCheckListRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.smartbuilding.access.occupantCheckListRequest();
  }

  public static ds.smartbuilding.access.occupantCheckListRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<occupantCheckListRequest>
      PARSER = new com.google.protobuf.AbstractParser<occupantCheckListRequest>() {
    @java.lang.Override
    public occupantCheckListRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new occupantCheckListRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<occupantCheckListRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<occupantCheckListRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.smartbuilding.access.occupantCheckListRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

