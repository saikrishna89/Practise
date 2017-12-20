package com.qc  ;

import com4j.*;

/**
 * Represents an instance of a Test in a test set.
 */
@IID("{5D6E98EC-5D16-4B4E-B1FB-55852AACD46D}")
public interface ITSTest4 extends com.qc.ITSTest3 {
  // Methods:
  /**
   * <p>
   * The ID of the Subject field.
   * </p>
   * <p>
   * Getter method for the COM property "SubjectId"
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(33) //= 0x21. The runtime will prefer the VTID if present
  @VTID(45)
  int subjectId();


  // Properties:
}
