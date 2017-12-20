package com.test.indeed;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.indeed.Common.FunctionLibrary;

public class TestDriver extends FunctionLibrary{

	TestDriver TD = new TestDriver();
	
@BeforeTest
public void beforeMethod() {
	TD.openBrowser();
}

}
