package com.qc  ;

import com4j.*;

/**
 * Information about a project.
 */
@IID("{654E31D2-9EBA-4789-92A0-E0473430164D}")
public interface IProjectDescriptor2 extends com.qc.IProjectDescriptor {
  // Methods:
  /**
   * <p>
   * Returns true if the project is a unicode project.
   * </p>
   * <p>
   * Getter method for the COM property "IsUnicode"
   * </p>
   * @return  Returns a value of type boolean
   */

  @DISPID(6) //= 0x6. The runtime will prefer the VTID if present
  @VTID(12)
  boolean isUnicode();


  /**
   * <p>
   * Returns true if the current user can connect to the project.
   * </p>
   * <p>
   * Getter method for the COM property "CanLogin"
   * </p>
   * @return  Returns a value of type boolean
   */

  @DISPID(7) //= 0x7. The runtime will prefer the VTID if present
  @VTID(13)
  boolean canLogin();


  // Properties:
}
