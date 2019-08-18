/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.jundy.client;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class RuleSet extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -7942855220261206575L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"RuleSet\",\"namespace\":\"com.jundy.client\",\"fields\":[{\"name\":\"enable_insurance\",\"type\":\"boolean\",\"default\":false},{\"name\":\"require_delivery_method_to_complete_order\",\"type\":\"boolean\",\"default\":false},{\"name\":\"shopping_cart_ttl\",\"type\":\"int\",\"default\":600},{\"name\":\"configurable_customer_info_obj_fields\",\"type\":[\"null\",\"string\"],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<RuleSet> ENCODER =
      new BinaryMessageEncoder<RuleSet>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<RuleSet> DECODER =
      new BinaryMessageDecoder<RuleSet>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<RuleSet> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<RuleSet> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<RuleSet>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this RuleSet to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a RuleSet from a ByteBuffer. */
  public static RuleSet fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public boolean enable_insurance;
  @Deprecated public boolean require_delivery_method_to_complete_order;
  @Deprecated public int shopping_cart_ttl;
  @Deprecated public java.lang.CharSequence configurable_customer_info_obj_fields;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public RuleSet() {}

  /**
   * All-args constructor.
   * @param enable_insurance The new value for enable_insurance
   * @param require_delivery_method_to_complete_order The new value for require_delivery_method_to_complete_order
   * @param shopping_cart_ttl The new value for shopping_cart_ttl
   * @param configurable_customer_info_obj_fields The new value for configurable_customer_info_obj_fields
   */
  public RuleSet(java.lang.Boolean enable_insurance, java.lang.Boolean require_delivery_method_to_complete_order, java.lang.Integer shopping_cart_ttl, java.lang.CharSequence configurable_customer_info_obj_fields) {
    this.enable_insurance = enable_insurance;
    this.require_delivery_method_to_complete_order = require_delivery_method_to_complete_order;
    this.shopping_cart_ttl = shopping_cart_ttl;
    this.configurable_customer_info_obj_fields = configurable_customer_info_obj_fields;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return enable_insurance;
    case 1: return require_delivery_method_to_complete_order;
    case 2: return shopping_cart_ttl;
    case 3: return configurable_customer_info_obj_fields;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: enable_insurance = (java.lang.Boolean)value$; break;
    case 1: require_delivery_method_to_complete_order = (java.lang.Boolean)value$; break;
    case 2: shopping_cart_ttl = (java.lang.Integer)value$; break;
    case 3: configurable_customer_info_obj_fields = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'enable_insurance' field.
   * @return The value of the 'enable_insurance' field.
   */
  public java.lang.Boolean getEnableInsurance() {
    return enable_insurance;
  }

  /**
   * Sets the value of the 'enable_insurance' field.
   * @param value the value to set.
   */
  public void setEnableInsurance(java.lang.Boolean value) {
    this.enable_insurance = value;
  }

  /**
   * Gets the value of the 'require_delivery_method_to_complete_order' field.
   * @return The value of the 'require_delivery_method_to_complete_order' field.
   */
  public java.lang.Boolean getRequireDeliveryMethodToCompleteOrder() {
    return require_delivery_method_to_complete_order;
  }

  /**
   * Sets the value of the 'require_delivery_method_to_complete_order' field.
   * @param value the value to set.
   */
  public void setRequireDeliveryMethodToCompleteOrder(java.lang.Boolean value) {
    this.require_delivery_method_to_complete_order = value;
  }

  /**
   * Gets the value of the 'shopping_cart_ttl' field.
   * @return The value of the 'shopping_cart_ttl' field.
   */
  public java.lang.Integer getShoppingCartTtl() {
    return shopping_cart_ttl;
  }

  /**
   * Sets the value of the 'shopping_cart_ttl' field.
   * @param value the value to set.
   */
  public void setShoppingCartTtl(java.lang.Integer value) {
    this.shopping_cart_ttl = value;
  }

  /**
   * Gets the value of the 'configurable_customer_info_obj_fields' field.
   * @return The value of the 'configurable_customer_info_obj_fields' field.
   */
  public java.lang.CharSequence getConfigurableCustomerInfoObjFields() {
    return configurable_customer_info_obj_fields;
  }

  /**
   * Sets the value of the 'configurable_customer_info_obj_fields' field.
   * @param value the value to set.
   */
  public void setConfigurableCustomerInfoObjFields(java.lang.CharSequence value) {
    this.configurable_customer_info_obj_fields = value;
  }

  /**
   * Creates a new RuleSet RecordBuilder.
   * @return A new RuleSet RecordBuilder
   */
  public static com.jundy.client.RuleSet.Builder newBuilder() {
    return new com.jundy.client.RuleSet.Builder();
  }

  /**
   * Creates a new RuleSet RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new RuleSet RecordBuilder
   */
  public static com.jundy.client.RuleSet.Builder newBuilder(com.jundy.client.RuleSet.Builder other) {
    return new com.jundy.client.RuleSet.Builder(other);
  }

  /**
   * Creates a new RuleSet RecordBuilder by copying an existing RuleSet instance.
   * @param other The existing instance to copy.
   * @return A new RuleSet RecordBuilder
   */
  public static com.jundy.client.RuleSet.Builder newBuilder(com.jundy.client.RuleSet other) {
    return new com.jundy.client.RuleSet.Builder(other);
  }

  /**
   * RecordBuilder for RuleSet instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<RuleSet>
    implements org.apache.avro.data.RecordBuilder<RuleSet> {

    private boolean enable_insurance;
    private boolean require_delivery_method_to_complete_order;
    private int shopping_cart_ttl;
    private java.lang.CharSequence configurable_customer_info_obj_fields;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.jundy.client.RuleSet.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.enable_insurance)) {
        this.enable_insurance = data().deepCopy(fields()[0].schema(), other.enable_insurance);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.require_delivery_method_to_complete_order)) {
        this.require_delivery_method_to_complete_order = data().deepCopy(fields()[1].schema(), other.require_delivery_method_to_complete_order);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.shopping_cart_ttl)) {
        this.shopping_cart_ttl = data().deepCopy(fields()[2].schema(), other.shopping_cart_ttl);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.configurable_customer_info_obj_fields)) {
        this.configurable_customer_info_obj_fields = data().deepCopy(fields()[3].schema(), other.configurable_customer_info_obj_fields);
        fieldSetFlags()[3] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing RuleSet instance
     * @param other The existing instance to copy.
     */
    private Builder(com.jundy.client.RuleSet other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.enable_insurance)) {
        this.enable_insurance = data().deepCopy(fields()[0].schema(), other.enable_insurance);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.require_delivery_method_to_complete_order)) {
        this.require_delivery_method_to_complete_order = data().deepCopy(fields()[1].schema(), other.require_delivery_method_to_complete_order);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.shopping_cart_ttl)) {
        this.shopping_cart_ttl = data().deepCopy(fields()[2].schema(), other.shopping_cart_ttl);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.configurable_customer_info_obj_fields)) {
        this.configurable_customer_info_obj_fields = data().deepCopy(fields()[3].schema(), other.configurable_customer_info_obj_fields);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'enable_insurance' field.
      * @return The value.
      */
    public java.lang.Boolean getEnableInsurance() {
      return enable_insurance;
    }

    /**
      * Sets the value of the 'enable_insurance' field.
      * @param value The value of 'enable_insurance'.
      * @return This builder.
      */
    public com.jundy.client.RuleSet.Builder setEnableInsurance(boolean value) {
      validate(fields()[0], value);
      this.enable_insurance = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'enable_insurance' field has been set.
      * @return True if the 'enable_insurance' field has been set, false otherwise.
      */
    public boolean hasEnableInsurance() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'enable_insurance' field.
      * @return This builder.
      */
    public com.jundy.client.RuleSet.Builder clearEnableInsurance() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'require_delivery_method_to_complete_order' field.
      * @return The value.
      */
    public java.lang.Boolean getRequireDeliveryMethodToCompleteOrder() {
      return require_delivery_method_to_complete_order;
    }

    /**
      * Sets the value of the 'require_delivery_method_to_complete_order' field.
      * @param value The value of 'require_delivery_method_to_complete_order'.
      * @return This builder.
      */
    public com.jundy.client.RuleSet.Builder setRequireDeliveryMethodToCompleteOrder(boolean value) {
      validate(fields()[1], value);
      this.require_delivery_method_to_complete_order = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'require_delivery_method_to_complete_order' field has been set.
      * @return True if the 'require_delivery_method_to_complete_order' field has been set, false otherwise.
      */
    public boolean hasRequireDeliveryMethodToCompleteOrder() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'require_delivery_method_to_complete_order' field.
      * @return This builder.
      */
    public com.jundy.client.RuleSet.Builder clearRequireDeliveryMethodToCompleteOrder() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'shopping_cart_ttl' field.
      * @return The value.
      */
    public java.lang.Integer getShoppingCartTtl() {
      return shopping_cart_ttl;
    }

    /**
      * Sets the value of the 'shopping_cart_ttl' field.
      * @param value The value of 'shopping_cart_ttl'.
      * @return This builder.
      */
    public com.jundy.client.RuleSet.Builder setShoppingCartTtl(int value) {
      validate(fields()[2], value);
      this.shopping_cart_ttl = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'shopping_cart_ttl' field has been set.
      * @return True if the 'shopping_cart_ttl' field has been set, false otherwise.
      */
    public boolean hasShoppingCartTtl() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'shopping_cart_ttl' field.
      * @return This builder.
      */
    public com.jundy.client.RuleSet.Builder clearShoppingCartTtl() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'configurable_customer_info_obj_fields' field.
      * @return The value.
      */
    public java.lang.CharSequence getConfigurableCustomerInfoObjFields() {
      return configurable_customer_info_obj_fields;
    }

    /**
      * Sets the value of the 'configurable_customer_info_obj_fields' field.
      * @param value The value of 'configurable_customer_info_obj_fields'.
      * @return This builder.
      */
    public com.jundy.client.RuleSet.Builder setConfigurableCustomerInfoObjFields(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.configurable_customer_info_obj_fields = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'configurable_customer_info_obj_fields' field has been set.
      * @return True if the 'configurable_customer_info_obj_fields' field has been set, false otherwise.
      */
    public boolean hasConfigurableCustomerInfoObjFields() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'configurable_customer_info_obj_fields' field.
      * @return This builder.
      */
    public com.jundy.client.RuleSet.Builder clearConfigurableCustomerInfoObjFields() {
      configurable_customer_info_obj_fields = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public RuleSet build() {
      try {
        RuleSet record = new RuleSet();
        record.enable_insurance = fieldSetFlags()[0] ? this.enable_insurance : (java.lang.Boolean) defaultValue(fields()[0]);
        record.require_delivery_method_to_complete_order = fieldSetFlags()[1] ? this.require_delivery_method_to_complete_order : (java.lang.Boolean) defaultValue(fields()[1]);
        record.shopping_cart_ttl = fieldSetFlags()[2] ? this.shopping_cart_ttl : (java.lang.Integer) defaultValue(fields()[2]);
        record.configurable_customer_info_obj_fields = fieldSetFlags()[3] ? this.configurable_customer_info_obj_fields : (java.lang.CharSequence) defaultValue(fields()[3]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<RuleSet>
    WRITER$ = (org.apache.avro.io.DatumWriter<RuleSet>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<RuleSet>
    READER$ = (org.apache.avro.io.DatumReader<RuleSet>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}