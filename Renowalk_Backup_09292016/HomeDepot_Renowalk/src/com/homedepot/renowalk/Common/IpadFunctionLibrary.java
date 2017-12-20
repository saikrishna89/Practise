package com.homedepot.renowalk.Common;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.seleniumhq.jetty7.util.log.Log;

import com.homedepot.renowalk.TestDriver;
import com.homedepot.renowalk.ObjectRepository.RenowalkIpad;
import com.homedepot.renowalk.ObjectRepository.RenowalkModules;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.ios.IOSElement;

import com.homedepot.renowalk.Common.FunctionLibrary;

public class IpadFunctionLibrary extends FunctionLibrary
{
	RenowalkIpad objRWIpad = new RenowalkIpad();

	@SuppressWarnings("static-access")
	public void AppLogin(String userName, String password) throws Exception
	{
		try {
				IOSElement user = iosdriver.findElement(By.xpath(objRWIpad.InputUserName_xp));
				IOSElement pwd = iosdriver.findElement(By.xpath(objRWIpad.InputPassword_xp));
				IOSElement Login = iosdriver.findElement(By.name(objRWIpad.LoginBtn_nm));
				user.clear();
				user.setValue(userName);
				pwd.setValue(password);
				Login.click();
				//Select from Office
				IOSClickByXpath(objRWIpad.Main_ComboBox_SelectOffice_xp, "Select Office", true);
				
				IOSElement mypropertyHeading = iosdriver.findElement(By.name(objRWIpad.MyPropertiesHeading_nm));
				//IOSClickIfDisplayedByName(objRWIpad.RemindMeNextBtn_nm, objRWIpad.RemindMeNextBtn_nm, true);
				Thread.sleep(5000);
				if (mypropertyHeading.getText().equalsIgnoreCase("My Properties")){
					TestDriver.bIpadLoginFlag=true;
				}
				else
				{
					obj.repAddData( "Login to App with UserName: "+userName+" password:" + password , " should be successful", " Failed", "Fail");
				}
				
				
			} catch (Exception e) {
			System.out.println("--No Such Element Found--");
			obj.repAddData("Login to App with UserName: "+userName+" password:" + password, " should be successful", " Failed", "Fail");
			throw(e);
		}
	}
	
	@SuppressWarnings("static-access")
	public void AppLogOut() throws Exception
	{
		try {
			IOSElement Logout = iosdriver.findElement(By.name(objRWIpad.LogoutBtn_nm));
			Logout.click();
			Thread.sleep(5000);
			IOSElement user = iosdriver.findElement(By.xpath(objRWIpad.InputUserName_xp));
			if (user.isDisplayed()){
				obj.repAddData( "LogOut of App ", " should be sucessfull", " Sucess", "Pass");
				TestDriver.bLoginFlag=false;
				iosdriver.closeApp();
				iosdriver.quit();
				iosdriver = null;
			}
			else
				obj.repAddData( "LogOut of App ", " should be sucessfull", " Failed", "Fail");
		} catch (Exception e) {
			System.out.println("--No Such Element Found--");
			obj.repAddData("LogOut of App ", " should be sucessfull", " Failed", "Fail");
			throw(e);
		}
	}
	
	public void IOSdeleteProperty()
	{
		try {
			IOSElement propertyName;
			propertyName = iosdriver.findElement(By.xpath(objRWIpad.PropertyName_xp));
			propertyName.swipe(SwipeElementDirection.LEFT,500);
			
			IOSClickByName(objRWIpad.General_BtnDelete_nm, "Delete Button", true);
			IOSClickByName(objRWIpad.General_BtnOk_nm, "Ok Button", true);
			
			
		} catch (Exception e) {
			System.out.println("--No Such Element Found--");
			
		}
	}
	
	
	public File IOSTakeScreenShot(){
		File scrFile = ((TakesScreenshot) iosdriver).getScreenshotAs(OutputType.FILE);
		return scrFile;
	}
	
	public List<MobileElement> getTableCellsByXpath(String xPath){
		IOSElement eleTable =  iosdriver.findElement(By.xpath(xPath));
		List<MobileElement> rows = eleTable.findElementsByClassName("UIATableCell");
		
		return rows;
		
	}
	
	public void IOSVerifyTableCellspropertyByXpath(String xPath, String attribute, String ExpectedValues) throws Exception{
		try{
			List<MobileElement> rows = getTableCellsByXpath( xPath);
			String actual = null;
			for (MobileElement e : rows ){
				if (actual!=null)
					actual = actual + "|" + e.getAttribute(attribute);
				else
					actual = e.getAttribute(attribute);
			}
			
			if (ExpectedValues.equals(actual))
				obj.repAddData( "Verify List of Cell Value By Attribute : "+ attribute, "Expected Values = "+ ExpectedValues, "Actual Values = "+ actual, "Pass");
			else
				obj.repAddData( "Verify List of Cell Value By Attribute : "+ attribute, "Expected Values = "+ ExpectedValues, "Actual Values = "+ actual, "Fail");
		} catch (Exception e) {
			obj.repAddData( "Verify List of Cell Value By Attribute : "+ attribute, "Expected Values = "+ ExpectedValues, "Exception occured : " + e.toString(), "Fail");
		
		}
	}
	
//	private Point getCenter(MobileElement element) {
//
//	      Point upperLeft = element.getLocation();
//	      Dimension dimensions = element.getSize();
//	      return new Point(upperLeft.getX() + dimensions.getWidth()/2, upperLeft.getY() + dimensions.getHeight()/2);
//	    }
//	
//	private void ScrolltoDisplay(MobileElement element, Point center)
//	{
//		Integer j = 10;
//		for( Integer i=1; i<=10; i++ )
//		{
//			iosdriver.swipe(center.getX(), center.getY(), center.getX(), center.getY()-j, 1);
//			j = j+5;
//			if (element.isDisplayed())
//				break;
//		}
//	}
	
	public void IOSScrolltoDisplay(String name)
	{
		iosdriver.scrollTo(name);	
	}
	
	
	public void IOSClickTableCellByXpath(String TablexPath, String CellName) throws Exception{
		try{
			String click = null;
			//Point center = new Point(1,1);
			List<MobileElement> rows = getTableCellsByXpath( TablexPath);
			for (MobileElement e : rows ){
//				if (e.isDisplayed())
//					center = getCenter(e);
				if (e.getAttribute("name").equals(CellName))
					if (!e.isDisplayed()){
						//ScrolltoDisplay(e,center);
						IOSScrolltoDisplay(CellName);
						e.click();
						click = "done";
						break;
					}
					else{
						e.click();
						click = "done";
						break;
					}
			}
			
			if (click.equals("done"))
				obj.repAddData( "Action on Table Cell Name : "+ CellName, "Should be Clicked", "Clicked", "Pass");
			else
				obj.repAddData( "Action on Table Cell Name : "+ CellName, "Should be Clicked", " Not Clicked", "Fail");
		} catch (Exception e) {
			obj.repAddData( "Action on Table Cell Name : "+ CellName, "Should be Clicked", "Exception occured : " + e.toString(), "Fail");
		
		}
	}
	
	
	
	public boolean IOSElementFoundByXpath(String xPath) 
	{
		boolean result = false;
		List<IOSElement> eleList = iosdriver.findElements(By.xpath(xPath));
		if (eleList.size() == 1)
			result = true;
		return result;
	}
	
	public boolean IOSElementFoundByName(String name) 
	{
		boolean result = false;
		List<IOSElement> eleList = iosdriver.findElements(By.name(name));
		if (eleList.size() == 1)
			result = true;
		return result;
	}
	
	// perform one action from Keyboard
	public void IOSKeyboardAction(Keys action, String actionDescription) throws Exception
	{
		try {
			Actions act = new Actions(iosdriver);
			act.sendKeys(action).build().perform();
			Thread.sleep(1000);
			obj.repAddData( "Perform action from Keyboard", "'"+actionDescription+"' should be performed", "'"+actionDescription+"' performed", "Pass");
		} catch (Exception e) {
			System.out.println("--"+actionDescription+"--Not Performed");
			obj.repAddData( "Perform action from Keyboard", "'"+actionDescription+"' should be performed", "'"+actionDescription+"' not performed", "Fail");
			throw(e);
		}
	}
	
	
	public void IOSSendKeyById(String IDvalue, String key, String sFieldName) throws Exception
	{
		try {
			IOSElement ele = iosdriver.findElement(By.id(IDvalue));
			//HighlightElement(ele);
			ele.clear();
			ele.sendKeys(key);
			Thread.sleep(500);
			if(sFieldName.equalsIgnoreCase("Password") || sFieldName.contains("Password"))
			{
				obj.repAddData( "Enter data to "+sFieldName+" field", "<b>"+"*******"+"</b> should be entered", ""+"*******"+"</b> entered", "Pass");
			}
			else
			{	
				obj.repAddData( "Enter data to "+sFieldName+" field", "<b>"+key+"</b> should be entered", ""+key+"</b> entered", "Pass");
			}
		} catch (Exception e) {
			System.out.println("--No Such Element Found--");
			obj.repAddData( "Enter data to "+sFieldName+" field", "<b>"+key+"<b/> should be entered", "<b>"+key+"</b> not entered", "Fail");
			//throw(e);
		}
	}
	
	
	public void IOSSendKeyByXpath(String Xpath, String key, String sFieldName) throws Exception
	{
		try {
			IOSElement ele = iosdriver.findElement(By.xpath(Xpath));
			//HighlightElement(ele);
			ele.clear();
			ele.sendKeys(key);
			Thread.sleep(500);
			obj.repAddData( "Enter data to "+sFieldName+" field", "'"+key+"' should be entered", "'"+key+"' entered", "Pass");
		} catch (Exception e) {
			System.out.println("--No Such Element Found--");
			obj.repAddData("Enter data to "+sFieldName+" field", "'"+key+"' should be entered", "'"+key+"' not entered", "Fail");
			//throw(e);
		}
	}
	
	public void IOSSetTextByXpath(String Xpath, String key, String sFieldName) throws Exception
	{
		try {
			IOSElement ele = iosdriver.findElement(By.xpath(Xpath));
			//if (! ele.isDisplayed())
			//	IOSScrolltoDisplay(sFieldName);
			ele.clear();
			ele.setValue(key);
			Thread.sleep(500);
			obj.repAddData( "Enter data to "+sFieldName+" field", "'"+key+"' should be entered", "'"+key+"' entered", "Pass");
		} catch (Exception e) {
			System.out.println("--No Such Element Found--");
			obj.repAddData("Enter data to "+sFieldName+" field", "'"+key+"' should be entered", "'"+key+"' not entered", "Fail");
			//throw(e);
		}
	}
	
	public void IOSSendKeyByName(String value, String key, String sFieldName) throws Exception
	{
		try {
			IOSElement ele = iosdriver.findElement(By.name(value));
			//HighlightElement(ele);
			ele.clear();
			ele.sendKeys(key);
			Thread.sleep(500);
			obj.repAddData( "Enter data to "+sFieldName+" field", "<b>'"+key+"'</b> should be entered", "<b>'"+key+"'</b> entered", "Pass");
		} catch (Exception e) {
			System.out.println("--No Such Element Found--");
			obj.repAddData( "Enter data to "+sFieldName+" field", "<b>'"+key+"'</b> should be entered", "<b>'"+key+"'</b> not entered", "Fail");
			//throw(e);
		}
	}
	
	public void IOSSetTextByName(String value, String key, String sFieldName) throws Exception
	{
		try {
			IOSElement ele = iosdriver.findElement(By.name(value));
			if (! ele.isDisplayed())
				IOSScrolltoDisplay(sFieldName);
			ele.clear();
			ele.setValue(key);
			Thread.sleep(500);
			obj.repAddData( "Enter data to "+sFieldName+" field", "<b>'"+key+"'</b> should be entered", "<b>'"+key+"'</b> entered", "Pass");
		} catch (Exception e) {
			System.out.println("--No Such Element Found--");
			obj.repAddData( "Enter data to "+sFieldName+" field", "<b>'"+key+"'</b> should be entered", "<b>'"+key+"'</b> not entered", "Fail");
			//throw(e);
		}
	}
	
	
	public void SendKeyByElement(IOSElement ele, String key, String sFieldName) throws Exception
	{
		try {
			HighlightElement(ele);
			ele.clear();
			ele.sendKeys(key);
			Thread.sleep(500);
			obj.repAddData("Enter data to "+sFieldName+" field",
					"'" + key + "' should be entered", "'" + key + "' entered",
					"Pass");
		} catch (Exception e) {
			System.out.println("--No Such Element Found--");
			obj.repAddData( "Enter data to "+sFieldName+" field",
					"'" + key + "' should be entered", "'" + key
							+ "' not entered", "Fail");
			throw (e);
		}
	}
	
	public Boolean IOSVerifyElementPropertyByXpath(String xpath, String propertyname, String Value, boolean bReportFlag)
	{
		Boolean Act =false;
		try {
			IOSElement ele;
			ele = iosdriver.findElement(By.xpath(xpath));
			String propertyvalue = ele.getAttribute(propertyname);
			System.out.println(propertyvalue+"----------"+Value);
			if (propertyvalue.equals(Value)){
				Act = true;
				if(bReportFlag==true)
					obj.repAddData( "VerifyElementProperty '"+propertyname+"'", "Expected Property Value: '"+Value+"'", "Actual Property Value: '"+propertyvalue+"'", "Pass");
			}
			else{
				//obj.repAddData( "VerifyElementProperty '"+propertyname+"'", "Expected Property Value: '"+Value+"'", "Actual Property Value: '"+propertyvalue+"'", "Fail");
			}
			//return Act;
		} catch (Exception e) {
			System.out.println("--No Such Element Found--");
			if(bReportFlag==true)
			{
				try {
					obj.repAddData( "VerifyElementProperty '"+propertyname+"'", "Expected Property Value: '"+Value+"'", "Exception occured Exception Msg: "+e.toString(), "Fail");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			//throw(e);
		}
		return Act;
	}
	
	public void IOSCheckDisplayedByXpath(String value, String faceValue, boolean bReportFlag) throws Exception
	{
		try {
			IOSElement ele;
			
			ele = iosdriver.findElement(By.xpath(value));
			//if (IOSElementFoundByXpath(value)){
				if (ele.isDisplayed()){
					if(bReportFlag==true)
						obj.repAddData( "CheckDisplayed '"+faceValue+"'", "'"+faceValue+"' should be Displayed", "'"+faceValue+"' is Displayed", "Pass");
				}
			//}
			else{
				if(bReportFlag==true)
				{
				obj.repAddData( "CheckDisplayed '"+faceValue+"'", "'"+faceValue+"' should be Displayed", "'"+faceValue+"' not Displayed", "Fail");
				}
			}
		} catch (Exception e) {
			System.out.println("--No Such Element Found--");
			if(bReportFlag==true)
			{
			obj.repAddData( "CheckDisplayed '"+faceValue+"'", "'"+faceValue+"' should be Displayed", "Exception occured Exception Msg: "+e.toString(), "Fail");
			}
			throw(e);
		}
	}
	
	
	public void IOSCheckNotDisplayedByXpath(String value, String faceValue, boolean bReportFlag) throws Exception
	{
		try {
			IOSElement ele;
			
			ele = iosdriver.findElement(By.xpath(value));
			//if (IOSElementFoundByXpath(value)){
				if (!ele.isDisplayed()){
					if(bReportFlag==true)
						obj.repAddData( "CheckDisplayed '"+faceValue+"'", "'"+faceValue+"' should not be Displayed", "'"+faceValue+"' is not Displayed", "Pass");
				}
			//}
			else{
				if(bReportFlag==true)
				{
				obj.repAddData( "CheckDisplayed '"+faceValue+"'", "'"+faceValue+"' should not be Displayed", "'"+faceValue+"' is Displayed", "Fail");
				}
			}
		} catch (Exception e) {
			System.out.println("--No Such Element Found--");
			if(bReportFlag==true)
			{
			obj.repAddData( "CheckDisplayed '"+faceValue+"'", "'"+faceValue+"' should not be Displayed", "Exception occured Exception Msg: "+e.toString(), "Fail");
			}
			throw(e);
		}
	}
	
	public void IOSCheckDisplayedByName(String value, String faceValue, boolean bReportFlag) throws Exception
	{
		try {
			IOSElement ele;
			
			ele = iosdriver.findElement(By.name(value));
//			Actions actions = new Actions(iosdriver);
//		    actions.moveToElement(ele);
			boolean b = ele.isDisplayed();
			//if (IOSElementFoundByName(value)){
				if (b){
					if(bReportFlag==true)
						obj.repAddData( "CheckDisplayed '"+faceValue+"'", "'"+faceValue+"' should be Displayed", "'"+faceValue+"' is Displayed", "Pass");
				}
			//}
			else{
				if(bReportFlag==true)
				{
				obj.repAddData( "CheckDisplayed '"+faceValue+"'", "'"+faceValue+"' should be Displayed", "'"+faceValue+"' not Displayed", "Fail");
				}
			}
		} catch (Exception e) {
			System.out.println("--No Such Element Found--");
			if(bReportFlag==true)
			{
			obj.repAddData( "CheckDisplayed '"+faceValue+"'", "'"+faceValue+"' should be Displayed", "Exception occured Exception Msg: "+e.toString(), "Fail");
			}
			throw(e);
		}
	}
	
	public void IOSClickByXpath(String value, String faceValue, boolean bReportFlag) throws Exception
	{
		try {
			IOSElement ele;
			ele = iosdriver.findElement(By.xpath(value));
			//HighlightElement(ele);
			if (!ele.isDisplayed()){
				iosdriver.scrollTo(ele.getAttribute("name"));
				ele.click();
			}
			else
				ele.click();
			Thread.sleep(1000);
			if(bReportFlag==true)
			{
			obj.repAddData( "Click on '"+faceValue+"'", "'"+faceValue+"' should be clicked", "'"+faceValue+"' is clicked", "Pass");
			}
		} catch (Exception e) {
			System.out.println("--No Such Element Found--");
			if(bReportFlag==true)
			{
			obj.repAddData( "Click on '"+faceValue+"'", "'"+faceValue+"' should be clicked", "'"+faceValue+"' not clicked", "Fail");
			}
			throw(e);
		}
	}
	
	public void IOSClickIfDisplayedByXpath(String value, String faceValue, boolean bReportFlag) throws Exception
	{
		try {
			IOSElement ele;
			
			ele = iosdriver.findElement(By.xpath(value));
			if (ElementFound(value)){
				if (ele.isDisplayed())
					ele.click();
				Thread.sleep(1000);
				if(bReportFlag==true)
				{
				obj.repAddData( "Click on '"+faceValue+"'", "'"+faceValue+"' should be clicked", "'"+faceValue+"' is clicked", "Pass");
				}
			}
			else{
				if(bReportFlag==true)
				{
				obj.repAddData( "Click on '"+faceValue+"'", "'"+faceValue+"' should be clicked", "'"+faceValue+"' not found", "Pass");
				}
			}
		} catch (Exception e) {
			System.out.println("--No Such Element Found--");
			if(bReportFlag==true)
			{
			obj.repAddData( "Click on '"+faceValue+"'", "'"+faceValue+"' should be clicked", "'"+faceValue+"' not clicked", "Fail");
			}
			throw(e);
		}
	}
	
	
	public void IOSClickIfDisplayedByName(String value, String faceValue, boolean bReportFlag) throws Exception
	{
		try {
			IOSElement ele;
			
			ele = iosdriver.findElement(By.name(value));
			if (IOSElementFoundByName(value)){
				if (ele.isDisplayed())
					ele.click();
				Thread.sleep(1000);
				if(bReportFlag==true)
				{
				obj.repAddData( "Click on '"+faceValue+"'", "'"+faceValue+"' should be clicked", "'"+faceValue+"' is clicked", "Pass");
				}
			}
			else{
				if(bReportFlag==true)
				{
				obj.repAddData( "Click on '"+faceValue+"'", "'"+faceValue+"' should be clicked", "'"+faceValue+"' not found", "Pass");
				}
			}
		} catch (Exception e) {
			System.out.println("--No Such Element Found--");
			if(bReportFlag==true)
			{
			obj.repAddData( "Click on '"+faceValue+"'", "'"+faceValue+"' should be clicked", "'"+faceValue+"' not clicked", "Fail");
			}
			throw(e);
		}
	}
	
	public void IOSClickById(String IDvalue, String faceValue, boolean bReportFlag) throws Exception
	{
		try {
			IOSElement ele;
			ele = iosdriver.findElement(By.id(IDvalue));
			HighlightElement(ele);
			ele.click();
			Thread.sleep(1000);
			if(bReportFlag==true)
			{
				obj.repAddData( "Click on '"+faceValue+"'", "'"+faceValue+"' should be clicked", "'"+faceValue+"' clicked", "Pass");
			}
		} catch (Exception e) {
			System.out.println("--No Such Element Found--");
			if(bReportFlag==true)
			{
			obj.repAddData( "Click on '"+faceValue+"'", "'"+faceValue+"' should be clicked", "'"+faceValue+"' not clicked", "Fail");
			}
			throw(e);
		}
	}
	
	public void IOSClickByName(String value, String faceValue, boolean bReportFlag) throws Exception
	{
		try {
			IOSElement ele;
			ele = iosdriver.findElement(By.name(value));
			//HighlightElement(ele);
			ele.click();
			Thread.sleep(1000);
			if(bReportFlag==true)
			{
			obj.repAddData( "Click on '"+faceValue+"'", "'"+faceValue+"' should be clicked", "'"+faceValue+"' clicked", "Pass");
			}
		} catch (Exception e) {
			System.out.println("--No Such Element Found--");
			if(bReportFlag==true)
			{
			obj.repAddData( "Click on '"+faceValue+"'", "'"+faceValue+"' should be clicked", "'"+faceValue+"' not clicked", "Fail");
			}
			//throw(e);
		}
	}
	
	 public void IOSVeriyTextByXpath(String sLocator, String expectedText, boolean bReportFlag) throws Exception 
		{
			try {
				IOSElement ele;
				ele = iosdriver.findElement(By.xpath(sLocator));
				String sText = "";
				sText = ele.getText().trim();
				if(bReportFlag==true)
				{	
					if(sText.equals(expectedText))
					{
						obj.repAddData( "VerifyText: ", "Expected Text to be Displayed: '"+ expectedText+"'", "Actual Text Displayed: '"+sText+"'", "Pass");
							
					}
					else
					{
						obj.repAddData( "VerifyText: ", "Expected Text to be Displayed: '"+ expectedText+"'", "Actual Text Displayed: '"+sText+"'", "Fail");
					}
				}
					
			} catch (Exception e) {
				System.out.println("VeriyTextByXpath --------------Failed");  
				 TestDriver.log.error("VeriyTextByXpath failed",e);
				throw(e);
			}
		}
	 
	 public void IOSVeriyTextByName(String sLocator, String expectedText, boolean bReportFlag) throws Exception 
		{
			try {
				IOSElement ele;
				ele = iosdriver.findElement(By.name(sLocator));
				String sText = "";
				sText = ele.getText().trim();
				if(bReportFlag==true)
				{	
					if(sText.equals(expectedText))
					{
						obj.repAddData( "VerifyText: ", "Expected Text to be Displayed: '"+ expectedText+"'", "Actual Text Displayed: '"+sText+"'", "Pass");
							
					}
					else
					{
						obj.repAddData( "VerifyText: ", "Expected Text to be Displayed: '"+ expectedText+"'", "Actual Text Displayed: '"+sText+"'", "Fail");
					}
				}
					
			} catch (Exception e) {
				System.out.println("VeriyTextByName --------------Failed");  
				 TestDriver.log.error("VeriyTextByName failed",e);
				throw(e);
			}
		}
	
	
	
	public void IOSClickByLinkText(String value, String faceValue, boolean bReportFlag) throws Exception
	{
		try {
			IOSElement ele;
			ele = iosdriver.findElement(By.linkText(value));
			HighlightElement(ele);
			ele.click();
			Thread.sleep(1000);
			if(bReportFlag==true)
			{
			obj.repAddData( "Click on '"+faceValue+"'", "'"+faceValue+"' should be clicked", "'"+faceValue+"' clicked", "Pass");
			}
		} catch (Exception e) {
			System.out.println("--No Such Element Found--");
			if(bReportFlag==true)
			{
			obj.repAddData( "Click on '"+faceValue+"'", "'"+faceValue+"' should be clicked", "'"+faceValue+"' not clicked", "Fail");
			}
			throw(e);
		}
	}
	
	public void IOSClickByPartialLinkText(String value, String faceValue, boolean bReportFlag) throws Exception
	{
		if(testCaseStatus)
		{
			try {
				IOSElement ele;
				ele = iosdriver.findElement(By.partialLinkText(value));
				HighlightElement(ele);
				ele.click();
				Thread.sleep(1000);
				if(bReportFlag==true)
				{
				obj.repAddData( "Click on '"+faceValue+"'", "'"+faceValue+"' should be clicked", "'"+faceValue+"' clicked", "Pass");
				}
			} catch (Exception e) {
				System.out.println("--No Such Element Found--");
				if(bReportFlag==true)
				{
				obj.repAddData( "Click on '"+faceValue+"'", "'"+faceValue+"' should be clicked", "'"+faceValue+"' not clicked", "Fail");
				}
			}
		} else return;
	}
	
	public void IOSClickByTagName(String value, String faceValue, boolean bReportFlag) throws Exception
	{
		try {
			IOSElement ele;
			ele = iosdriver.findElement(By.tagName(value));
			HighlightElement(ele);
			ele.click();
			Thread.sleep(1000);
			if(bReportFlag==true)
			{
			obj.repAddData( "Click on '"+faceValue+"'", "'"+faceValue+"' should be clicked", "'"+faceValue+"' clicked", "Pass");
			}
		} catch (Exception e) {
			System.out.println("--No Such Element Found--");
			if(bReportFlag==true)
			{
			obj.repAddData( "Click on '"+faceValue+"'", "'"+faceValue+"' should be clicked", "'"+faceValue+"' not clicked", "Fail");
			}
			throw(e);
		}
	}
	
	
	
	public void IOSClickByElement(IOSElement ele, String faceValue, boolean bReportFlag) throws Exception
	{
		try {
			Actions action = new Actions(iosdriver);
			action.click(ele).perform();
			if(bReportFlag==true)
			{
			obj.repAddData( "Click on '"	+ faceValue + "'", "'" + faceValue+ "' should be clicked", "'" + faceValue + "' clicked","Pass");
			}
		} catch (Exception e) {
			System.out.println("Click by Element on line 373 failed");
			if(bReportFlag==true)
			{
			obj.repAddData( "Click on '"	+ faceValue + "'", "'" + faceValue+ "' should be clicked", "'" + faceValue+ "' not clicked", "Fail");
			}
			throw(e);
		}
	}
	
	public void IOSClickActiveElement(String sActiveEleMsg) throws Exception
	{
		try {
			obj.repAddData( "Click on '"	+ sActiveEleMsg + "'", "'" + sActiveEleMsg+ "' should be clicked", "'" + sActiveEleMsg + "' clicked","Pass");
			iosdriver.switchTo().activeElement().click();
		} catch (Exception e) {
			System.out.println("fnClickActiveElement failed");
			obj.repAddData( "Click on '"	+ sActiveEleMsg + "'", "'" + sActiveEleMsg+ "' should be clicked", "'" + sActiveEleMsg+ "' not clicked", "Fail");
			throw(e);
		}
	}
	
		
	public void IOSClickByAction(String xpath, String faceValue) throws Exception
	{
		try {
			IOSElement buttonClick =iosdriver.findElement(By.xpath(xpath));
			//HighlightElement(buttonClick);
			Thread.sleep(1000);
			
			if(buttonClick.isEnabled())
			{
				Actions action =new Actions(driver);
				action.click(buttonClick).build().perform();
				obj.repAddData( "Click on '"+faceValue+"'", "'"+faceValue+"' should be clicked", "'"+faceValue+"' clicked", "Pass");
			}
		} catch (Exception e) {
			System.out.println("--No Such Element Found--");
			obj.repAddData( "Click on '"+faceValue+"'", "'"+faceValue+"' should be clicked", "'"+faceValue+"' not clicked", "Fail");
			throw(e);
		}
	}
	
	
	public void IOSDoubleClickByXpath(String value, String faceValue) throws Exception
	{
		try {
			IOSElement ele;
			ele = iosdriver.findElement(By.xpath(value));
			HighlightElement(ele);
			if (ele.isDisplayed())
			{
				Actions action = new Actions(driver);
				action.doubleClick(ele).build().perform();
			}
			Thread.sleep(1000);
			obj.repAddData( "Double Click on '"+faceValue+"'", "'"+faceValue+"' should be Double Clicked", "'"+faceValue+"' Double Clicked", "Pass");
		} catch (Exception e) {
			System.out.println("--No Such Element Found--");
			obj.repAddData( "Double Click on '"+faceValue+"'", "'"+faceValue+"' should be Double Clicked", "'"+faceValue+"' not Double Clicked", "Fail");
			throw(e);
		}
	}
	
	
	public void IOSRightClickByXpath(String value, String faceValue) throws Exception
	{
		try {
			IOSElement ele;
			ele = iosdriver.findElement(By.xpath(value));
			HighlightElement(ele);
			if (ele.isDisplayed())
			{
				Actions action = new Actions(iosdriver);
				action.contextClick(ele).build().perform();
			}
			Thread.sleep(1000);
			obj.repAddData( "RightClick on '"+faceValue+"'", "'"+faceValue+"' should be RightClicked", "'"+faceValue+"' RightClicked", "Pass");
		} catch (Exception e) {
			System.out.println("--No Such Element Found--");
			obj.repAddData( "RightClick on '"+faceValue+"'", "'"+faceValue+"' should be RightClicked", "'"+faceValue+"' not RightClicked", "Fail");
			throw(e);
		}
	}
	
	
	
	public void IOSDoubleClickByAction(String xpath, String faceValue) throws Exception
	{
		try {
			IOSElement buttonClick =iosdriver.findElement(By.xpath(xpath));
			//HighlightElement(buttonClick);
			Thread.sleep(1000);
			obj.repAddData( "Double Click on '"+faceValue+"'", "'"+faceValue+"' should be Double Clicked", "'"+faceValue+"' Double Clicked", "Pass");
			if(buttonClick.isEnabled())
			{
				Actions action =new Actions(iosdriver);
				action.doubleClick(buttonClick).perform();
			}
		} catch (Exception e) {
			System.out.println("--No Such Element Found--");
			obj.repAddData( "Double Click on '"+faceValue+"'", "'"+faceValue+"' should be Double Clicked", "'"+faceValue+"' not Double Clicked", "Fail");
			throw(e);
		}
	}
	
	public void IOSSelectFromComboBoxId(String SelectValue, String TextValue) throws Exception
	{
		try {
			
			IOSElement select = iosdriver.findElement(By.id(SelectValue));
			if(select.isDisplayed())
			{
				HighlightElementById(SelectValue);
				List<MobileElement> options = select.findElements(By.tagName("option"));
				for (MobileElement option : options)
				{
					if(TextValue.equalsIgnoreCase(option.getText().trim()))
					{
						Thread.sleep(1000);
						option.click();
					    obj.repAddData( "Select '"+TextValue +"' from combo box", "'"+TextValue+"' should be selected", "'"+TextValue+"' is selected in the combo box", "Pass");
						Thread.sleep(1000);
						System.out.println("fnSelectFromComboBoxId--------------passed for " + TextValue);
					    break;
					}
				}
			}
	

		} catch (Exception e) {

			obj.repAddData( "Select '"+TextValue +"' from combo box", "'"+TextValue+"' should be selected", "'"+TextValue+"' is not selected in the combo box", "Fail");
			System.out.println("IOSSelectFromComboBoxId--------------Failed");
			//throw(e);
		}	
	}
	
	
	public void IOSSelectFromComboBoxXpath(String SelectValue, String TextValue) throws Exception
	{
		try {
			
			IOSElement select = iosdriver.findElement(By.xpath(SelectValue));
			if(select.isDisplayed())
			{
				HighlightElementById(SelectValue);
				List<MobileElement> options = select.findElements(By.tagName("option"));
				for (MobileElement option : options)
				{
					if(TextValue.equalsIgnoreCase(option.getText().trim()))
					{
						Thread.sleep(1000);
						option.click();
					    obj.repAddData( "Select '"+TextValue +"' from combo box", "'"+TextValue+"' should be selected", "'"+TextValue+"' is selected in the combo box", "Pass");
						Thread.sleep(1000);
						System.out.println("IOSSelectFromComboBoxXpath--------------passed for " + TextValue);
					    break;
					}
				}
			}
	

		} catch (Exception e) {

			obj.repAddData( "Select '"+TextValue +"' from combo box", "'"+TextValue+"' should be selected", "'"+TextValue+"' is not selected in the combo box", "Fail");
			System.out.println("fnSelectFromComboBoxXpath--------------Failed");
			//throw(e);
		}	
	}
	
	public void IOSSelectFromJSComboBox(String SelectValue, String TextValue) throws Exception
	{
		try {
			
			IOSElement select = iosdriver.findElement(By.id(SelectValue));
			HighlightElementById(SelectValue);
			List<MobileElement> options = select.findElements(By.tagName("option"));
			for (MobileElement option : options)
			{
				if(TextValue.equalsIgnoreCase(option.getText().trim()))
				{
					Thread.sleep(1000);
					
					JavascriptExecutor js = (JavascriptExecutor)iosdriver;
					
					String sGetDurationElement = "document.getElementById('"+SelectValue + "').style.display='block';";
					js.executeScript(sGetDurationElement);
					Select selectComboOption = new Select(iosdriver.findElement(By.id(SelectValue)));
					Thread.sleep(4000);
					selectComboOption.selectByVisibleText(TextValue);
			
					obj.repAddData( "Select '"+TextValue +"' from combo box", "'"+TextValue+"' should be selected", "'"+TextValue+"' is selected in the combo box", "Pass");
					Thread.sleep(1000);
					System.out.println("IOSSelectFromJSComboBox--------------passed for " + TextValue);
					break;
				}
			}

		} catch (Exception e) {
			obj.repAddData( "Select '"+TextValue +"' from combo box", "'"+TextValue+"' should be selected", "'"+TextValue+"' is not selected in the combo box", "Fail");
			System.out.println("IOSSelectFromJSComboBox--------------Failed");
			//throw(e);
		}	
	}
	 
	 public void IOSSwitchToActiveElement() throws Exception   //Switch to main advisor frame
		{
			try {
				
				iosdriver.switchTo().activeElement();
				
			} catch (Exception e) {
				System.out.println("IOSSwitchToActiveElement--------------Failed");
				//throw(e);
			}	
		}
	 
	 public void IOSSwitchToFrame() throws Exception   //Switch to main advisor frame
		{
			try {
				
				iosdriver.switchTo().defaultContent();
				//driver.switchTo().frame(RenowalkMain.FrameAdvisor_nm);
				
			} catch (Exception e) {
				System.out.println("IOSSwitchToframe--------------Failed");
				throw(e);
			}	
		}
	 
	 public void IOSSwitchToFrame(String sFrameName) throws Exception   //Switch to a frame passed in function
		{
			try {
				
				iosdriver.switchTo().frame(sFrameName);
				
			} catch (Exception e) {
				System.out.println("IOSSwitchToFrame--------------Failed");
				throw(e);
			}	
		}
	 
//	 //public void fnGetIframe(String prefix) throws Exception   //Earlier name
//	 public void fnGetSwitchProfileActivityFrame(String prefix) throws Exception   //New name
//	 {
//		try {
//			    List<IOSElement> iframes = driver.findElements(By.tagName("iframe"));
//			    for (IOSElement iframe : iframes) {
//			        if (iframe.getAttribute("id").startsWith(prefix)) {
//			        	//driver.switchTo().frame(iframe.getAttribute("id"));
//			        	fnSwitchToFrame(iframe.getAttribute("id"));
//			        	break;
//			        // TODO your stuff.	
//			        }
//				}
//				
//		} catch (Exception e) {
//			System.out.println("fnGetIframe--------------Failed");
//			throw(e);
//		}	
//	 }
	 
	/* public void fnGetSwitchCurrentProfileActivityFrame(String prefix) throws Exception   //New name
	 {
		try {
			ArrayList<String> arrFrameNumber = fnGetAllIframeAscOrder(RenowalkModules.FrameProfileActivity_nm);
            driver.switchTo().frame("custProfileActivityIframe_activity_"+arrFrameNumber.get(arrFrameNumber.size()-1).toString());
				
		} catch (Exception e) {
			System.out.println("fnGetSwitchCurrentProfileActivityFrame--------------Failed");
			throw(e);
		}	
	 }*/
	 
	
	 	 
	 public ArrayList<String> fnGetIOSElementList(List<IOSElement> webOfferingName) throws Exception
		{
		 	ArrayList<String> arrIOSElementList = new ArrayList<String>();
		 	
			try {
				
				for(IOSElement ele : webOfferingName)
				{
					
					//if (!ele.getText().isEmpty())
					//{
						arrIOSElementList.add(ele.getText().replace("Select Price Plan", "").trim());
						System.out.println(ele.getText());
						
					//}
				}
				
			} catch (Exception e) {
				System.out.println("fnGetWebElementList--------------Failed");
				//throw(e);
			}
			
			return arrIOSElementList;
		}
	 
	
	public int fnGetPackageIndex(ArrayList<String> arrPackageName,ArrayList<String> arrOfferingName, String PackageName, String sOfferingName) throws Exception
	 {
		 	int index = -1;
		 	
			try {
				
				for(int i=0;i<arrOfferingName.size();i++)
				{
					if(arrOfferingName.get(i).toString().equalsIgnoreCase(sOfferingName) && arrPackageName.get(i).toString().equalsIgnoreCase(PackageName))
					{
						index=i;
						break;
					}
				}
				
			} catch (Exception e) {
				System.out.println("fnGetWebElementList--------------Failed");
				//throw(e);
			}
			
			return index;		
	 		
	 }
	 
	 public void fnArchiveResults(File fResultFile,File fDest) throws Exception
		{
			try {
				
				if (!fDest.exists())
				{
					fDest.mkdirs();
				}
				
				FileUtils.copyFileToDirectory(fResultFile, fDest);
				
			} catch (Exception e) {
				System.out.println("fnArchiveResults--------------Failed");
				//throw(e);
			}	
		}
 
 
	 public String IOSGetGUITextXpath(String value) throws Exception
	 {
		 String guiValue = null;
		 try {
			 IOSElement ele;
			 ele = iosdriver.findElement(By.xpath(value));
			 //HighlightElement(ele);
			 guiValue  = ele.getText();
			 Thread.sleep(1000); 
			 if (guiValue.equalsIgnoreCase(""))
			 { 
				 guiValue=ele.getAttribute("value");
			 }
			 //obj.repAddData( "Return GUI Text '", " Return GUI Text", "Return GUI Value Success - " +guiValue, "Pass");
	
		 } catch (Exception e) {
			 System.out.println("--No Such Element Found--");
			// obj.repAddData( "Return GUI Text '", " Return GUI Text", "Return GUI Value NOT Success.", "Fail");
			 //throw(e);
		 }
	
		 return guiValue;

	 }

	 public String IOSGetGUITextID(String value) throws Exception
	 {
		 String guiValue = null;
		 try {
			 IOSElement ele;
			 ele = iosdriver.findElement(By.id(value));
			 //HighlightElement(ele);
			 guiValue  = ele.getText();
			 Thread.sleep(1000);
			 if (guiValue.equalsIgnoreCase(""))
			 { 
				 guiValue=ele.getAttribute("value");
			 }
			 //obj.repAddData( "Return GUI Text '", " Return GUI Text", "Return GUI Value Success - " +guiValue, "Pass");
		
		
		 } catch (Exception e) {
			 System.out.println("--No Such Element Found--");
			// obj.repAddData( "Return GUI Text '", " Return GUI Text", "Return GUI Value NOT Success.", "Fail");
			 //throw(e);
		 }
	
		 return guiValue;

	 }
		
	
		//public void fnWaitForObjectExit(int intSec, String strXpath, String sMessage) throws Exception
		public void IOSWaitForObjectExit(int intSec, String strXpath, String sEventName) throws Exception
	    {
	    
	                    
			try {
	                                    
				WebDriverWait wait = new WebDriverWait(iosdriver,intSec);  //306
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(strXpath)));
	                                    
                                   
				if (driver.findElement(By.xpath(strXpath)).isDisplayed()){
					HighlightElement(driver.findElement(By.xpath(strXpath)));
					obj.repAddData( "Wait for '"+sEventName+"'", "'"+sEventName+"' should be displayed", "'"+sEventName+"' displayed", "Pass");
				}   
				
			} catch (Exception e) {
				//obj.repAddData( "Wait for '"+sEventName+"'", "'"+sEventName+"' should be displayed", "'"+sEventName+"' not displayed", "Fail");
	            TestDriver.log.info(sEventName + " is not visible on the screen.. Test execution waited for "+ intSec+ " seconds.");                        
				throw(e);
	                    }
	    }
	 
	 public void fnLoadingPageWait() throws Exception

	 {
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,20);
			//CheckId(RenowalkModules.Property_GenProp_ImagePageLoading_id,"'Loading...' icon",true);
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(RenowalkModules.Property_GenProp_MsgPageLoading_nm)));	 //Wait for loading message to disappear

		} catch (Exception e) {
	    System.out.println("fnLoadingPageWait --------------Failed");    
	    TestDriver.log.error("fnLoadingPageWait failed",e);
	    }
	 }
	 
	 
	 public boolean IOSCheckFieldDisplayById(String sLocator, String sReportText, boolean bReportFlag, boolean bScenarioFlag) throws Exception 
		{
		 	boolean bElementFound = false;
			try {
				IOSElement ele;
				ele = iosdriver.findElement(By .id(sLocator));
				String sText = "";
								
				if(bReportFlag==true)
				{	
					if(bScenarioFlag==true)
					{
						if(ele.isDisplayed())
						{
							bElementFound = true;
							sText = ele.getText().trim();
							obj.repAddData( "Verify "+sReportText, sReportText+" should be shown", sReportText+" shown successfully with value '"+sText+"'", "Pass");
							
						}
						else
						{
							obj.repAddData( "Verify "+sReportText, sReportText+" should be shown", sReportText+" not shown on the screen", "Fail");
						}
					}
					else if(bScenarioFlag==false)
					{
						if(!ele.isDisplayed())
						{   bElementFound = true;
							obj.repAddData( "Verify "+sReportText, sReportText+" should not be shown", sReportText+" not shown on the screen", "Pass");
							
						}
						else
						{
							obj.repAddData( "Verify "+sReportText, sReportText+" should not be shown", sReportText+" shown on the screen", "Fail");
						}
						
					}
				}
				else
				{
					if(ele.isDisplayed())
					{
						bElementFound = true;
					}
					else
					{
						bElementFound = false;
					}
				}
					
			} catch (Exception e) {
				System.out.println("IOSCheckFieldDisplayById --------------Failed");  
				 TestDriver.log.error("IOSCheckFieldDisplayById failed",e);
				throw(e);
			}
			return bElementFound;
		}
	 
	 public boolean IOSCheckFieldDisplayByName(String sLocator, String sReportText, boolean bReportFlag, boolean bScenarioFlag) throws Exception 
		{
		 	boolean bElementFound = false;
			try {
				IOSElement ele;
				ele = iosdriver.findElement(By.name(sLocator));
				String sText = "";
								
				if(bReportFlag==true)
				{	
					if(bScenarioFlag==true)
					{
						if(ele.isDisplayed())
						{
							bElementFound = true;
							sText = ele.getText().trim();
							obj.repAddData( "Verify "+sReportText, sReportText+" should be shown", sReportText+" shown successfully with value '"+sText+"'", "Pass");
							
						}
						else
						{
							obj.repAddData( "Verify "+sReportText, sReportText+" should be shown", sReportText+" not shown on the screen", "Fail");
						}
					}
					else if(bScenarioFlag==false)
					{
						if(!ele.isDisplayed())
						{   bElementFound = true;
							obj.repAddData( "Verify "+sReportText, sReportText+" should not be shown", sReportText+" not shown on the screen", "Pass");
							
						}
						else
						{
							obj.repAddData( "Verify "+sReportText, sReportText+" should not be shown", sReportText+" shown on the screen", "Fail");
						}
						
					}
				}
				else
				{
					if(ele.isDisplayed())
					{
						bElementFound = true;
					}
					else
					{
						bElementFound = false;
					}
				}
					
			} catch (Exception e) {
				System.out.println("IOSCheckFieldDisplayByName --------------Failed");  
				 TestDriver.log.error("IOSCheckFieldDisplayByName failed",e);
				throw(e);
			}
			return bElementFound;
		}
	 
	 public boolean IOSCheckFieldDisplayByXpath(String sLocator, String sReportText, boolean bReportFlag, boolean bScenarioFlag) throws Exception 
		{
		 	boolean bElementFound = false;
			try {
				IOSElement ele;
				ele = iosdriver.findElement(By.xpath(sLocator));
				String sText = "";
				
				if(bReportFlag==true)
				{	
					if(bScenarioFlag==true)
					{
						if(ele.isDisplayed())
						{   
							HighlightElementByXpath(sLocator);			//test and see nothing breaks	
							bElementFound = true;
							sText = ele.getText().trim();
							obj.repAddData( "Verify "+sReportText, sReportText+" should be shown", sReportText+" shown successfully with value '"+sText+"'", "Pass");
							
						}
						else
						{
							obj.repAddData( "Verify "+sReportText, sReportText+" should be shown", sReportText+" not shown on the screen", "Fail");
						}
					}
					else if(bScenarioFlag==false)
					{
						if(!ele.isDisplayed())
						{   bElementFound = true;
							obj.repAddData( "Verify "+sReportText, sReportText+" should not be shown", sReportText+" not shown on the screen", "Pass");
							
						}
						else
						{
							obj.repAddData( "Verify "+sReportText, sReportText+" should not be shown", sReportText+" shown on the screen", "Fail");
						}
						
					}
				}
				else
				{
					if(ele.isDisplayed())
					{
						bElementFound = true;
					}
					else
					{
						bElementFound = false;
					}
				}
					
			} catch (Exception e) {
				System.out.println("IOSCheckFieldDisplayByXpath --------------Failed");  
				 TestDriver.log.error("IOSCheckFieldDisplayByXpath failed",e);
				throw(e);
			}
			return bElementFound;
		}
	 
	 
	 public void IOSCheckEnableByXPath(String sLocator, String sControlName) throws Exception 
		{
			try {
				IOSElement eleTable = iosdriver.findElement(By.xpath(sLocator));
				
				if(eleTable.isEnabled())
				{
					obj.repAddData( "Verify "+sControlName, sControlName+" should be enabled", sControlName+" is enabled", "Pass");
				}
				else
				{
					obj.repAddData( "Verify "+sControlName, sControlName+" should be enabled", sControlName+" is not enabled", "Fail");
				}
					
			} catch (Exception e) {
				System.out.println("IOSCheckEnableByXPath --------------Failed");  
				 TestDriver.log.error("fnCheckEnableByXPath failed",e);
				throw(e);
			}
		}
	 
	 public void IOSCheckDisbleByXPath(String sLocator, String sControlName) throws Exception 
		{
			try {
				IOSElement eleTable = iosdriver.findElement(By.xpath(sLocator));
				
				if(!eleTable.isEnabled())
				{
					obj.repAddData( "Verify "+sControlName, sControlName+" should be disabled", sControlName+" is disabled", "Pass");
				}
				else
				{
					obj.repAddData( "Verify "+sControlName, sControlName+" should be disabled", sControlName+" is not disabled", "Fail");
				}
					
			} catch (Exception e) {
				System.out.println("IOSCheckDisbleByXPath --------------Failed");  
				 TestDriver.log.error("IOSCheckDisbleByXPath failed",e);
				throw(e);
			}
		}
	 
	 public int IOSGetTableRowsCount(String sLocator) throws Exception 
		{
		 	int iRows = 0;
			try {
				IOSElement eleTable = iosdriver.findElement(By.xpath(sLocator));
				List<MobileElement> arrTableRows = eleTable.findElements(By.xpath("./tbody/tr"));  //Get the table data rows
				iRows = arrTableRows.size();
				System.out.println("Data Rows Size>>>>"+arrTableRows.size());
					
			} catch (Exception e) {
				System.out.println("IOSGetTableRowsCount --------------Failed");  
				 TestDriver.log.error("IOSGetTableRowsCount failed",e);
				throw(e);
			}
			return iRows;
		}
	 
		public void IOSVerifyComboBoxValue(String SelectValue, String TextValue) throws Exception
		{
			try {
				
				boolean bFlag = false;
				IOSElement select = iosdriver.findElement(By.xpath(SelectValue));
				if(select.isDisplayed())
				{
					HighlightElementByXpath(SelectValue);
					List<MobileElement> options = select.findElements(By.tagName("option"));
					for (MobileElement option : options)
					{
						if(TextValue.equalsIgnoreCase(option.getText().trim()))
						{
							Thread.sleep(1000);
							option.click();
							bFlag = true;
							Thread.sleep(1000);
						    break;
						}
					}
					
					if(bFlag == true)
					{
						obj.repAddData( "Verify '"+TextValue+"' in the combo box", "'"+TextValue+"' should be displayed in the combo box", "'"+TextValue+"' displayed in the combo box", "Pass");
					}
					else
					{
						obj.repAddData(  "Verify '"+TextValue+"' in the combo box", "'"+TextValue+"' should be displayed in the combo box","'"+TextValue+"' not displayed in the combo box", "Fail");
					}
				}
				

			} catch (Exception e) {
				System.out.println("IOSVerifyComboBoxValue--------------Failed");
				TestDriver.log.error("IOSVerifyComboBoxValue--------------Failed", e);
				//throw(e);
			}	
		}
		
		
		 public void IOSCheckComboBoxSorting(String sComboBoxLocator, String sFieldName, String sDefaultValue) throws Exception

		 {
			try
			{
				////////////////////Sorting Logic////////////////////////////
				List<String> arrInitialList = new ArrayList<String>();
				List<String> arrExpSortedList = new ArrayList<String>();
				List<String> arrActSortedList = new ArrayList<String>();
				
				arrInitialList.clear();
				arrExpSortedList.clear();
				arrActSortedList.clear();
				
				IOSElement select = iosdriver.findElement(By.xpath(sComboBoxLocator));
				
				if(select.isDisplayed())
				{
					HighlightElementByXpath(sComboBoxLocator);
					List<MobileElement> options = select.findElements(By.tagName("option"));
					for (MobileElement option : options)
					{
						if(!option.getText().toString().trim().equalsIgnoreCase(sDefaultValue))
						{
							arrInitialList.add(option.getText().toString().toUpperCase());
							arrActSortedList.add(option.getText().toString().toUpperCase());
						}
					}
				
				}
				
				Collections.sort(arrInitialList);

				arrExpSortedList = arrInitialList;
				System.out.println("Initial Expected Sorting Done");
			

				if(arrActSortedList.equals(arrExpSortedList))
				{
					obj.repAddData( "Verify Sorting on '"+sFieldName+"' combo box", "'"+sFieldName+"' values should be sorted in ascending order", "'"+sFieldName+"' values are sorted in ascending order", "Pass");
				}
				else
				{
					obj.repAddData( "Verify Sorting on '"+sFieldName+"' combo box", "'"+sFieldName+"' values should be sorted in ascending order", "'"+sFieldName+"' values are not sorted in ascending order", "Fail");
				}
				
				////////////////////Sorting Logic End////////////////////////////
			} catch (Exception e) {
		    System.out.println("IOSCheckComboBoxSorting --------------Failed");    
		    TestDriver.log.error("IOSCheckComboBoxSorting failed",e);
		    }
		 }
	 
} // end of BaseClass

