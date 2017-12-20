package com.qc  ;

import com4j.*;

/**
 * Extends IBaseFactory
 */
@IID("{33A6EC9D-8D08-4598-AD39-A614D9409ECC}")
public interface _IFactorySupportBatchLock extends Com4jObject {
  // Methods:
  /**
   * <p>
   * Locks the given items.
   * </p>
   * @param entities Mandatory com.qc.IList parameter.
   */

  @VTID(3)
  void lockList(
    com.qc.IList entities);


  // Properties:
}
