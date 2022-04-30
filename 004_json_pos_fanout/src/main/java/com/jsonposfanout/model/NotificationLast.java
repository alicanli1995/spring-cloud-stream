/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.jsonposfanout.model;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class NotificationLast extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 8936365009805977216L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"NotificationLast\",\"namespace\":\"com.jsonposfanout.model\",\"fields\":[{\"name\":\"InvoiceNumber\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"CustomerCardNo\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"TotalAmount\",\"type\":[\"null\",\"double\"]},{\"name\":\"EarnedLoyaltyPoints\",\"type\":[\"null\",\"double\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<NotificationLast> ENCODER =
      new BinaryMessageEncoder<NotificationLast>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<NotificationLast> DECODER =
      new BinaryMessageDecoder<NotificationLast>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<NotificationLast> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<NotificationLast> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<NotificationLast>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this NotificationLast to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a NotificationLast from a ByteBuffer. */
  public static NotificationLast fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public String InvoiceNumber;
  @Deprecated public String CustomerCardNo;
  @Deprecated public Double TotalAmount;
  @Deprecated public Double EarnedLoyaltyPoints;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public NotificationLast() {}

  /**
   * All-args constructor.
   * @param InvoiceNumber The new value for InvoiceNumber
   * @param CustomerCardNo The new value for CustomerCardNo
   * @param TotalAmount The new value for TotalAmount
   * @param EarnedLoyaltyPoints The new value for EarnedLoyaltyPoints
   */
  public NotificationLast(String InvoiceNumber, String CustomerCardNo, Double TotalAmount, Double EarnedLoyaltyPoints) {
    this.InvoiceNumber = InvoiceNumber;
    this.CustomerCardNo = CustomerCardNo;
    this.TotalAmount = TotalAmount;
    this.EarnedLoyaltyPoints = EarnedLoyaltyPoints;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public Object get(int field$) {
    switch (field$) {
    case 0: return InvoiceNumber;
    case 1: return CustomerCardNo;
    case 2: return TotalAmount;
    case 3: return EarnedLoyaltyPoints;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: InvoiceNumber = (String)value$; break;
    case 1: CustomerCardNo = (String)value$; break;
    case 2: TotalAmount = (Double)value$; break;
    case 3: EarnedLoyaltyPoints = (Double)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'InvoiceNumber' field.
   * @return The value of the 'InvoiceNumber' field.
   */
  public String getInvoiceNumber() {
    return InvoiceNumber;
  }

  /**
   * Sets the value of the 'InvoiceNumber' field.
   * @param value the value to set.
   */
  public void setInvoiceNumber(String value) {
    this.InvoiceNumber = value;
  }

  /**
   * Gets the value of the 'CustomerCardNo' field.
   * @return The value of the 'CustomerCardNo' field.
   */
  public String getCustomerCardNo() {
    return CustomerCardNo;
  }

  /**
   * Sets the value of the 'CustomerCardNo' field.
   * @param value the value to set.
   */
  public void setCustomerCardNo(String value) {
    this.CustomerCardNo = value;
  }

  /**
   * Gets the value of the 'TotalAmount' field.
   * @return The value of the 'TotalAmount' field.
   */
  public Double getTotalAmount() {
    return TotalAmount;
  }

  /**
   * Sets the value of the 'TotalAmount' field.
   * @param value the value to set.
   */
  public void setTotalAmount(Double value) {
    this.TotalAmount = value;
  }

  /**
   * Gets the value of the 'EarnedLoyaltyPoints' field.
   * @return The value of the 'EarnedLoyaltyPoints' field.
   */
  public Double getEarnedLoyaltyPoints() {
    return EarnedLoyaltyPoints;
  }

  /**
   * Sets the value of the 'EarnedLoyaltyPoints' field.
   * @param value the value to set.
   */
  public void setEarnedLoyaltyPoints(Double value) {
    this.EarnedLoyaltyPoints = value;
  }

  /**
   * Creates a new NotificationLast RecordBuilder.
   * @return A new NotificationLast RecordBuilder
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Creates a new NotificationLast RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new NotificationLast RecordBuilder
   */
  public static Builder newBuilder(Builder other) {
    return new Builder(other);
  }

  /**
   * Creates a new NotificationLast RecordBuilder by copying an existing NotificationLast instance.
   * @param other The existing instance to copy.
   * @return A new NotificationLast RecordBuilder
   */
  public static Builder newBuilder(NotificationLast other) {
    return new Builder(other);
  }

  /**
   * RecordBuilder for NotificationLast instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<NotificationLast>
    implements org.apache.avro.data.RecordBuilder<NotificationLast> {

    private String InvoiceNumber;
    private String CustomerCardNo;
    private Double TotalAmount;
    private Double EarnedLoyaltyPoints;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.InvoiceNumber)) {
        this.InvoiceNumber = data().deepCopy(fields()[0].schema(), other.InvoiceNumber);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.CustomerCardNo)) {
        this.CustomerCardNo = data().deepCopy(fields()[1].schema(), other.CustomerCardNo);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.TotalAmount)) {
        this.TotalAmount = data().deepCopy(fields()[2].schema(), other.TotalAmount);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.EarnedLoyaltyPoints)) {
        this.EarnedLoyaltyPoints = data().deepCopy(fields()[3].schema(), other.EarnedLoyaltyPoints);
        fieldSetFlags()[3] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing NotificationLast instance
     * @param other The existing instance to copy.
     */
    private Builder(NotificationLast other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.InvoiceNumber)) {
        this.InvoiceNumber = data().deepCopy(fields()[0].schema(), other.InvoiceNumber);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.CustomerCardNo)) {
        this.CustomerCardNo = data().deepCopy(fields()[1].schema(), other.CustomerCardNo);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.TotalAmount)) {
        this.TotalAmount = data().deepCopy(fields()[2].schema(), other.TotalAmount);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.EarnedLoyaltyPoints)) {
        this.EarnedLoyaltyPoints = data().deepCopy(fields()[3].schema(), other.EarnedLoyaltyPoints);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'InvoiceNumber' field.
      * @return The value.
      */
    public String getInvoiceNumber() {
      return InvoiceNumber;
    }

    /**
      * Sets the value of the 'InvoiceNumber' field.
      * @param value The value of 'InvoiceNumber'.
      * @return This builder.
      */
    public Builder setInvoiceNumber(String value) {
      validate(fields()[0], value);
      this.InvoiceNumber = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'InvoiceNumber' field has been set.
      * @return True if the 'InvoiceNumber' field has been set, false otherwise.
      */
    public boolean hasInvoiceNumber() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'InvoiceNumber' field.
      * @return This builder.
      */
    public Builder clearInvoiceNumber() {
      InvoiceNumber = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'CustomerCardNo' field.
      * @return The value.
      */
    public String getCustomerCardNo() {
      return CustomerCardNo;
    }

    /**
      * Sets the value of the 'CustomerCardNo' field.
      * @param value The value of 'CustomerCardNo'.
      * @return This builder.
      */
    public Builder setCustomerCardNo(String value) {
      validate(fields()[1], value);
      this.CustomerCardNo = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'CustomerCardNo' field has been set.
      * @return True if the 'CustomerCardNo' field has been set, false otherwise.
      */
    public boolean hasCustomerCardNo() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'CustomerCardNo' field.
      * @return This builder.
      */
    public Builder clearCustomerCardNo() {
      CustomerCardNo = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'TotalAmount' field.
      * @return The value.
      */
    public Double getTotalAmount() {
      return TotalAmount;
    }

    /**
      * Sets the value of the 'TotalAmount' field.
      * @param value The value of 'TotalAmount'.
      * @return This builder.
      */
    public Builder setTotalAmount(Double value) {
      validate(fields()[2], value);
      this.TotalAmount = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'TotalAmount' field has been set.
      * @return True if the 'TotalAmount' field has been set, false otherwise.
      */
    public boolean hasTotalAmount() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'TotalAmount' field.
      * @return This builder.
      */
    public Builder clearTotalAmount() {
      TotalAmount = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'EarnedLoyaltyPoints' field.
      * @return The value.
      */
    public Double getEarnedLoyaltyPoints() {
      return EarnedLoyaltyPoints;
    }

    /**
      * Sets the value of the 'EarnedLoyaltyPoints' field.
      * @param value The value of 'EarnedLoyaltyPoints'.
      * @return This builder.
      */
    public Builder setEarnedLoyaltyPoints(Double value) {
      validate(fields()[3], value);
      this.EarnedLoyaltyPoints = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'EarnedLoyaltyPoints' field has been set.
      * @return True if the 'EarnedLoyaltyPoints' field has been set, false otherwise.
      */
    public boolean hasEarnedLoyaltyPoints() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'EarnedLoyaltyPoints' field.
      * @return This builder.
      */
    public Builder clearEarnedLoyaltyPoints() {
      EarnedLoyaltyPoints = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public NotificationLast build() {
      try {
        NotificationLast record = new NotificationLast();
        record.InvoiceNumber = fieldSetFlags()[0] ? this.InvoiceNumber : (String) defaultValue(fields()[0]);
        record.CustomerCardNo = fieldSetFlags()[1] ? this.CustomerCardNo : (String) defaultValue(fields()[1]);
        record.TotalAmount = fieldSetFlags()[2] ? this.TotalAmount : (Double) defaultValue(fields()[2]);
        record.EarnedLoyaltyPoints = fieldSetFlags()[3] ? this.EarnedLoyaltyPoints : (Double) defaultValue(fields()[3]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<NotificationLast>
    WRITER$ = (org.apache.avro.io.DatumWriter<NotificationLast>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<NotificationLast>
    READER$ = (org.apache.avro.io.DatumReader<NotificationLast>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
