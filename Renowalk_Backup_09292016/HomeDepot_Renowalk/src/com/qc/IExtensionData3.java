package com.qc  ;

import com4j.*;

/**
 * For HP use. The properties of an extension as they appear in the extension.xml file.
 */
@IID("{28F27B65-8D35-4A8F-B9A1-6BAFA55F591B}")
public interface IExtensionData3 extends com.qc.IExtensionData2 {
  // Methods:
  /**
   * <p>
   * The extension list on which it depends.
   * </p>
   * <p>
   * Getter method for the COM property "DependsOn"
   * </p>
   * @return  Returns a value of type com.qc.IList
   */

  @DISPID(11) //= 0xb. The runtime will prefer the VTID if present
  @VTID(17)
  com.qc.IList dependsOn();


  @VTID(17)
  @ReturnValue(type=NativeType.VARIANT,defaultPropertyThrough={com.qc.IList.class})
  java.lang.Object dependsOn(
    int index);

  // Properties:
}
