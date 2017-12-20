package com.qc  ;

import com4j.*;

/**
 * For HP use. Services for managing baselines.
 */
@IID("{3D7543C1-9B84-457E-9A1A-CCB7D20663FA}")
public interface IBaselineFactory extends com.qc.IBaseFactoryEx {
  // Methods:
  /**
   * <p>
   * A list of IBaselineItem objects in which the entity participated.
   * </p>
   * @param pEntity Mandatory com.qc.IBaseField parameter.
   * @return  Returns a value of type com.qc.IList
   */

  @DISPID(9) //= 0x9. The runtime will prefer the VTID if present
  @VTID(17)
  com.qc.IList baselineItems(
    com.qc.IBaseField pEntity);


  // Properties:
}
