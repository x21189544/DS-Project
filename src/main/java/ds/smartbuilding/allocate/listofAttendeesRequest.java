// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: allocation.proto

package ds.smartbuilding.allocate;

/**
 * <pre>
 *define messages
 * </pre>
 *
 * Protobuf type {@code allocate.listofAttendeesRequest}
 */
public  final class listofAttendeesRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:allocate.listofAttendeesRequest)
    listofAttendeesRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use listofAttendeesRequest.newBuilder() to construct.
  private listofAttendeesRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private listofAttendeesRequest() {
    listOfAttendees_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private listofAttendeesRequest(
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

            listOfAttendees_ = s;
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
    return ds.smartbuilding.allocate.AllocateServiceImpl.internal_static_allocate_listofAttendeesRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.smartbuilding.allocate.AllocateServiceImpl.internal_static_allocate_listofAttendeesRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.smartbuilding.allocate.listofAttendeesRequest.class, ds.smartbuilding.allocate.listofAttendeesRequest.Builder.class);
  }

  public static final int LISTOFATTENDEES_FIELD_NUMBER = 1;
  private volatile java.lang.Object listOfAttendees_;
  /**
   * <code>string listOfAttendees = 1;</code>
   */
  public java.lang.String getListOfAttendees() {
    java.lang.Object ref = listOfAttendees_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      listOfAttendees_ = s;
      return s;
    }
  }
  /**
   * <code>string listOfAttendees = 1;</code>
   */
  public com.google.protobuf.ByteString
      getListOfAttendeesBytes() {
    java.lang.Object ref = listOfAttendees_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      listOfAttendees_ = b;
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
    if (!getListOfAttendeesBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, listOfAttendees_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getListOfAttendeesBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, listOfAttendees_);
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
    if (!(obj instanceof ds.smartbuilding.allocate.listofAttendeesRequest)) {
      return super.equals(obj);
    }
    ds.smartbuilding.allocate.listofAttendeesRequest other = (ds.smartbuilding.allocate.listofAttendeesRequest) obj;

    boolean result = true;
    result = result && getListOfAttendees()
        .equals(other.getListOfAttendees());
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
    hash = (37 * hash) + LISTOFATTENDEES_FIELD_NUMBER;
    hash = (53 * hash) + getListOfAttendees().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.smartbuilding.allocate.listofAttendeesRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.smartbuilding.allocate.listofAttendeesRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.smartbuilding.allocate.listofAttendeesRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.smartbuilding.allocate.listofAttendeesRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.smartbuilding.allocate.listofAttendeesRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.smartbuilding.allocate.listofAttendeesRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.smartbuilding.allocate.listofAttendeesRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.smartbuilding.allocate.listofAttendeesRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.smartbuilding.allocate.listofAttendeesRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.smartbuilding.allocate.listofAttendeesRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.smartbuilding.allocate.listofAttendeesRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.smartbuilding.allocate.listofAttendeesRequest parseFrom(
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
  public static Builder newBuilder(ds.smartbuilding.allocate.listofAttendeesRequest prototype) {
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
   * <pre>
   *define messages
   * </pre>
   *
   * Protobuf type {@code allocate.listofAttendeesRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:allocate.listofAttendeesRequest)
      ds.smartbuilding.allocate.listofAttendeesRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.smartbuilding.allocate.AllocateServiceImpl.internal_static_allocate_listofAttendeesRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.smartbuilding.allocate.AllocateServiceImpl.internal_static_allocate_listofAttendeesRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.smartbuilding.allocate.listofAttendeesRequest.class, ds.smartbuilding.allocate.listofAttendeesRequest.Builder.class);
    }

    // Construct using ds.smartbuilding.allocate.listofAttendeesRequest.newBuilder()
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
      listOfAttendees_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.smartbuilding.allocate.AllocateServiceImpl.internal_static_allocate_listofAttendeesRequest_descriptor;
    }

    @java.lang.Override
    public ds.smartbuilding.allocate.listofAttendeesRequest getDefaultInstanceForType() {
      return ds.smartbuilding.allocate.listofAttendeesRequest.getDefaultInstance();
    }

    @java.lang.Override
    public ds.smartbuilding.allocate.listofAttendeesRequest build() {
      ds.smartbuilding.allocate.listofAttendeesRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.smartbuilding.allocate.listofAttendeesRequest buildPartial() {
      ds.smartbuilding.allocate.listofAttendeesRequest result = new ds.smartbuilding.allocate.listofAttendeesRequest(this);
      result.listOfAttendees_ = listOfAttendees_;
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
      if (other instanceof ds.smartbuilding.allocate.listofAttendeesRequest) {
        return mergeFrom((ds.smartbuilding.allocate.listofAttendeesRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.smartbuilding.allocate.listofAttendeesRequest other) {
      if (other == ds.smartbuilding.allocate.listofAttendeesRequest.getDefaultInstance()) return this;
      if (!other.getListOfAttendees().isEmpty()) {
        listOfAttendees_ = other.listOfAttendees_;
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
      ds.smartbuilding.allocate.listofAttendeesRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.smartbuilding.allocate.listofAttendeesRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object listOfAttendees_ = "";
    /**
     * <code>string listOfAttendees = 1;</code>
     */
    public java.lang.String getListOfAttendees() {
      java.lang.Object ref = listOfAttendees_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        listOfAttendees_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string listOfAttendees = 1;</code>
     */
    public com.google.protobuf.ByteString
        getListOfAttendeesBytes() {
      java.lang.Object ref = listOfAttendees_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        listOfAttendees_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string listOfAttendees = 1;</code>
     */
    public Builder setListOfAttendees(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      listOfAttendees_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string listOfAttendees = 1;</code>
     */
    public Builder clearListOfAttendees() {
      
      listOfAttendees_ = getDefaultInstance().getListOfAttendees();
      onChanged();
      return this;
    }
    /**
     * <code>string listOfAttendees = 1;</code>
     */
    public Builder setListOfAttendeesBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      listOfAttendees_ = value;
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


    // @@protoc_insertion_point(builder_scope:allocate.listofAttendeesRequest)
  }

  // @@protoc_insertion_point(class_scope:allocate.listofAttendeesRequest)
  private static final ds.smartbuilding.allocate.listofAttendeesRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.smartbuilding.allocate.listofAttendeesRequest();
  }

  public static ds.smartbuilding.allocate.listofAttendeesRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<listofAttendeesRequest>
      PARSER = new com.google.protobuf.AbstractParser<listofAttendeesRequest>() {
    @java.lang.Override
    public listofAttendeesRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new listofAttendeesRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<listofAttendeesRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<listofAttendeesRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.smartbuilding.allocate.listofAttendeesRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

