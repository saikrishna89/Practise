package com.qc  ;

import com4j.*;

/**
 * For HP use. Represents a requirement for which testing must be performed.
 */
@IID("{988F6D3B-2A82-461A-9154-6BA378F201C1}")
public interface IReq3 extends com.qc.IReq2 {
  // Methods:
  /**
   * <p>
   * For HP use.
   * </p>
   * @param settings Mandatory com.qc.ITraceabilityMatrixRelationSettings parameter.
   * @param tableName Mandatory Holder<java.lang.String> parameter.
   * @return  Returns a value of type com.qc.IList
   */

  @DISPID(47) //= 0x2f. The runtime will prefer the VTID if present
  @VTID(66)
  com.qc.IList getLinkedEntities(
    com.qc.ITraceabilityMatrixRelationSettings settings,
    Holder<java.lang.String> tableName);


  /**
   * <p>
   * Returns the list of test configurations that cover the current requirement and, optionally, cover those of its children that match the requirement filter.
   * </p>
   * @param recursive Optional parameter. Default value is false
   * @return  Returns a value of type com.qc.IList
   */

  @DISPID(48) //= 0x30. The runtime will prefer the VTID if present
  @VTID(67)
  com.qc.IList getCoverageTestConfigs(
    @Optional @DefaultValue("0") boolean recursive);


  /**
   * <p>
   * Returns the list of test configurations that cover the current requirement with filtered tests, and optionally, cover those of its descendents that match the requirement filter.
   * </p>
   * @param testIDs Mandatory java.lang.String parameter.
   * @param recursive Optional parameter. Default value is false
   * @return  Returns a value of type com.qc.IList
   */

  @DISPID(49) //= 0x31. The runtime will prefer the VTID if present
  @VTID(68)
  com.qc.IList getCoverageTestConfigsByTestIds(
    java.lang.String testIDs,
    @Optional @DefaultValue("0") boolean recursive);


  // Properties:
}
