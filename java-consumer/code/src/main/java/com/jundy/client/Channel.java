/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.jundy.client;
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public enum Channel {
  INTERNET, IVR, PBO, PHONE  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"Channel\",\"namespace\":\"com.jundy.client\",\"symbols\":[\"INTERNET\",\"IVR\",\"PBO\",\"PHONE\"],\"default\":\"INTERNET\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
}