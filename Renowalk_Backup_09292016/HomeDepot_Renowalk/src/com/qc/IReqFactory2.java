package com.qc  ;

import com4j.*;

/**
 * Services for managing requirements.
 */
@IID("{1F73BDFF-AC15-47FF-8264-88ADE733AAB7}")
public interface IReqFactory2 extends com.qc.IReqFactory {
  // Methods:
  /**
   * <p>
   * Gets a filtered list of child requirements.
   * </p>
   * @param fatherID Mandatory int parameter.
   * @param filter Optional parameter. Default value is 0
   * @return  Returns a value of type com.qc.IList
   */

  @DISPID(19) //= 0x13. The runtime will prefer the VTID if present
  @VTID(27)
  com.qc.IList getFilteredChildrenList(
    int fatherID,
    @Optional @DefaultValue("0") com.qc.ITDFilter filter);


  // Properties:
}
