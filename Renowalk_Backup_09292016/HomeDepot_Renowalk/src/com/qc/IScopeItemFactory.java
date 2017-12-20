package com.qc  ;

import com4j.*;

/**
 * ScopeItem Factory
 */
@IID("{C0461045-0539-42AD-83DD-13DD397B6362}")
public interface IScopeItemFactory extends com.qc.IBaseFactoryEx {
  // Methods:
  /**
   * <p>
   * Returns the names of the entities' tables that support QPM.
   * </p>
   * <p>
   * Getter method for the COM property "SupportsQPMContentEntitiesTables"
   * </p>
   * @return  Returns a value of type com.qc.IList
   */

  @DISPID(9) //= 0x9. The runtime will prefer the VTID if present
  @VTID(17)
  com.qc.IList supportsQPMContentEntitiesTables();


  @VTID(17)
  @ReturnValue(type=NativeType.VARIANT,defaultPropertyThrough={com.qc.IList.class})
  java.lang.Object supportsQPMContentEntitiesTables(
    int index);

  // Properties:
}
