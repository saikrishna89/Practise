package com.qc  ;

import com4j.*;

/**
 * For HP use. Services to manage analysis items.
 */
@IID("{E93A887B-8FBC-400E-8BD0-ECC2B064D7A5}")
public interface IAnalysisItemFactory extends com.qc.IBaseFactoryEx {
  // Methods:
  /**
   * <p>
   * Returns the list of those AnalysisItem objects from the list that appear on dashboard pages.
   * </p>
   * @param pIdsList Mandatory com.qc.IList parameter.
   * @param inPublicPagesOnly Mandatory boolean parameter.
   * @return  Returns a value of type com.qc.IList
   */

  @DISPID(9) //= 0x9. The runtime will prefer the VTID if present
  @VTID(17)
  com.qc.IList getItemsIncludedInPages(
    com.qc.IList pIdsList,
    boolean inPublicPagesOnly);


  // Properties:
}
