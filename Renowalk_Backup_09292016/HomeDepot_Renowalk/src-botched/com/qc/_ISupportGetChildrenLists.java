package com.qc  ;

import com4j.*;

/**
 * For HP use. _ISupportGetChildrenLists Interface.
 */
@IID("{571138B3-FBBE-4B57-97F5-B61E325AEFBA}")
public interface _ISupportGetChildrenLists extends Com4jObject {
  // Methods:
  /**
   * <p>
   * For HP use. Returns children factory lists from the given parents
   * </p>
   * @param filter Mandatory com.qc.ITDFilter parameter.
   * @param parents Mandatory com.qc.IList parameter.
   * @return  Returns a value of type com.qc.IList
   */

  @VTID(3)
  com.qc.IList getChildrenLists(
    com.qc.ITDFilter filter,
    com.qc.IList parents);


  // Properties:
}
