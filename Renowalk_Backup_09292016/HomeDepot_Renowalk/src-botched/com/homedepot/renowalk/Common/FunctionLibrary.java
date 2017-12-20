package com.homedepot.renowalk.Common;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.seleniumhq.jetty7.util.log.Log;






import com.homedepot.renowalk.TestDriver;
import com.homedepot.renowalk.ConfigManager.FileLocSetter;
import com.homedepot.renowalk.ObjectRepository.RenowalkHome;
import com.homedepot.renowalk.ObjectRepository.RenowalkModules;
import com.homedepot.renowalk.ReportManager.Reporter;
import com.homedepot.renowalk.UtilManager.AppMessages;
import com.homedepot.renowalk.UtilManager.DBUtil;

public class FunctionLibrary
{
	public static String sTestString = "";
	public static WebDriver driver = null;
	public static Properties prop=null; // properties file
	public static Properties objRepProp=null; // object repository property
	public static Reporter obj=new Reporter();
//	public static PrepareExcelReport objEx=new PrepareExcelReport();
	
	public static boolean step_fail; // keep track of total step fail for each testcase
	public static int mainStep; // keep track of main step for each testcases
	public static int subStep; // keep track of subStep for each mainStep
	public static boolean testCaseStatus; // keep track of the test flow
	public String strTimeDiff = null;
	
	DBUtil objDBUtility = new DBUtil();
	RenowalkModules objRWModules = new RenowalkModules();
	
	public FunctionLibrary() 
	{
	
	}
	
	
	public void fnSetBrowserCapabilities()
	{ 
		String sBrowser = TestDriver.mEnvSheetData.get(TestDriver.iMasterRowId).get("Browser").toString().trim();
		if(sBrowser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", FileLocSetter.sProjPath+"chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("test-type");
			capabilities.setCapability("chrome.binary",FileLocSetter.sProjPath+"chromedriver.exe");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);   
			driver = new ChromeDriver(capabilities);
		}
		else if(sBrowser.equalsIgnoreCase("Firefox"))
		{
			 FirefoxProfile fp = new FirefoxProfile();
			 fp.setPreference("webdriver.load.strategy", "unstable"); // As of 2.19. from 2.9 - 2.18 use 'fast'
			 driver = new FirefoxDriver(fp);
			 
		}
		else if(sBrowser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", FileLocSetter.sProjPath+"IEDriverServer.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			//capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true); 
			driver = new InternetExplorerDriver(capabilities);
		}
		else if(sBrowser.equalsIgnoreCase("Safari"))
		{
			System.setProperty("webdriver.safari.noinstall", "true");
			DesiredCapabilities capabilities = DesiredCapabilities.safari();
			//capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true); 
			driver = new SafariDriver(capabilities);
		}
		driver.manage().window().maximize();
		
	}
	

	public int fnRandomNum(int min, int max) 
	{
	   // NOTE: Usually this should be a field rather than a method
	   // variable so that it is not re-seeded every call.
	   Random rand = new Random();
	   // nextInt is normally exclusive of the top value,
	   // so add 1 to make it inclusive
	   int randomNum = rand.nextInt((max - min) + 1) + min;

	   return randomNum;
	}
	
	public String fnGenerateStr(int length)
	{
		int i = 0;
		StringBuilder sBuilder = new StringBuilder();
		String sReturn;
		while (i < length)
		{
			char c = 't';
			sBuilder.append(c);
			i++;
		}
		sReturn = sBuilder.toString();
		return sReturn;
	}
	
	
	
		
	@SuppressWarnings({ "unchecked", "rawtypes"})
	public void fnExecuteFunction(String ClassName, String sFunctionName)
	{
		try {
			Class[] cArg = new Class[1];
			cArg[0] = obj.getClass();
			
			// load the ClassName at runtime
			Class clsObj = Class.forName(ClassName);
			Object obj1 = clsObj.newInstance();

			//String RowNum = Integer.toString(DriverScript.i);
			Method method = clsObj.getDeclaredMethod(sFunctionName,cArg);
			Reporter.iTotalExecuted++;
			method.invoke(obj1, obj);

		} catch (Exception e) {
			TestDriver.log.info("Test case failed for "+sFunctionName+". Check if the function is missing...");
		}
	}
	
	
	//WScript C:\\...\\client.vbs
	public void ExecuteCommand(String command) throws Exception
	{
		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);
		builder.redirectErrorStream(true);
		Process p = builder.start();

		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

		String line;
		while (true) {
			line = r.readLine();
			if (line == null) {
				break;
			}
			System.out.println(line);
		}
	}
	
	
	public void HighlightElementByName(String value) throws InterruptedException 
	{
		WebElement ele =  driver.findElement(By.name(value));
		
		String originalStyle = ele.getAttribute("style");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for(int i=0;i<2;i++)
		{
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red; width: 35%');", ele);
			Thread.sleep(500);
			js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", ele);
			Thread.sleep(500);
		}
	}
	
		
	public void HighlightElementById(String IDvalue) throws InterruptedException 
	{
		WebElement ele =  driver.findElement(By.id(IDvalue));
		
		String originalStyle = ele.getAttribute("style");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		for(int i=0;i<2;i++)
		{
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red; width: 35%');", ele);
			Thread.sleep(500);
			js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", ele);
			Thread.sleep(500);
		}
		
	}
	
	
	public void HighlightElementByXpath(String xPath) throws InterruptedException 
	{
		WebElement ele =  driver.findElement(By.xpath(xPath));
		
		String originalStyle = ele.getAttribute("style");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for(int i=0;i<2;i++)
		{
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red; width: 35%');", ele);
			Thread.sleep(150);
			js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", ele);
			Thread.sleep(150);
		}
	}
	
		
	public void HighlightElement(WebElement ele) throws InterruptedException 
	{	
		String originalStyle = ele.getAttribute("style");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		for(int i=0;i<2;i++)
		{
			js.executeScript("arguments[0].setAttribute('style', 'background: gold; border: 1px solid blue; width: 35%');", ele);
			Thread.sleep(150);
			js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", ele);
			Thread.sleep(150);
		}
	}
	
	
	public boolean ElementFound(String xPath) 
	{
		boolean result = false;
		List<WebElement> eleList = driver.findElements(By.xpath(xPath));
		if (eleList.size() == 1)
			result = true;
		return result;
	}
	
	//
	public int CheckXpath(WebDriver thisDriver, String value)  
	{
		int result = 0;
		try {
			List<WebElement> eleList = thisDriver.findElements(By.xpath(value));
			result = eleList.size();
		} catch (Exception e) {
		}
		return result;
	}
	
	/*public int CheckXpath(String value) {
		int result = 0;
		try {
			List<WebElement> eleList = driver.findElements(By.xpath(value));
			result = eleList.size();
		} catch (Exception e) {
			System.out.println("Xpath>>"+value+" not found.");
		}
		return result;
	}*/
	
	public int CheckXpath(String sLocator, String sReportText, boolean bReportFlag, boolean bScenarioFlag) {
		//Added bScenarioFlag to have reporting for both +ve and -ve scenarios.. bScenarioFlag will be false for -ve and vice-versa
		int result = 0;
		try {
			List<WebElement> eleList = driver.findElements(By.xpath(sLocator));
			result = eleList.size();
			String sText="";
			if(bReportFlag==true)
			{	
				if(result==1)
				{
					if(eleList.get(0).getText().trim().contains("Properties") && eleList.get(0).getText().trim().contains("Select Status"))
					{
						sText="Properties";
					}
					else
					{
						sText = eleList.get(0).getText().trim();
					}
					HighlightElement(eleList.get(0));
					obj.repAddData( "Verify "+sReportText, sReportText+" should be shown", sReportText+" shown successfully with value '"+sText+"'", "Pass");
				}
				else
				{
					if(bScenarioFlag==true)
					{
						obj.repAddData( "Verify "+sReportText, sReportText+" should be shown", sReportText+" not shown", "Fail");
					}
					else
					{
						obj.repAddData( "Verify "+sReportText, sReportText+" should not be shown", sReportText+" not shown", "Pass");
					}
					
				}
			}
			
		} catch (Exception e) {
			System.out.println("Id>>"+sLocator+" not found.");
			TestDriver.log.info("Id>>"+sLocator+" not found.");
		}
		return result;
	}
	
	public int CheckId(String sLocator, String sReportText, boolean bReportFlag) {
		int result = 0;
		String sText ="";
		try {
			List<WebElement> eleList = driver.findElements(By.id(sLocator));
			result = eleList.size();
			if(bReportFlag==true)
			{
				if(result==1)
				{
					sText = eleList.get(0).getText().trim();
					HighlightElement(eleList.get(0));
					obj.repAddData( "Verify "+sReportText, sReportText+" should be shown", sReportText+" shown successfully with value '"+sText+"'", "Pass");
				}
				else
				{
					obj.repAddData( "Verify "+sReportText, sReportText+" should be shown", sReportText+" not shown", "Fail");
				}
			}
			
		} catch (Exception e) {
			System.out.println("Id>>"+sLocator+" not found.");
			TestDriver.log.info("Id>>"+sLocator+" not found.");
		}
		return result;
	}
	
	public boolean CheckTextOnPage(String text)
	{
	boolean result = false;
	text=text.toLowerCase();
	result = driver.getPageSource().toLowerCase().contains(text);
	//System.out.println(driver.getPageSource().toString());
	return result;
	}
	
	// perform one action from Keyboard
	public void KeyboardAction(Keys action, String actionDescription) throws Exception
	{
		try {
			Actions act = new Actions(driver);
			act.sendKeys(action).build().perform();
			Thread.sleep(1000);
			obj.repAddData( "Perform action from Keyboard", "'"+actionDescription+"' should be performed", "'"+actionDescription+"' performed", "Pass");
		} catch (Exception e) {
			System.out.println("--"+actionDescription+"--Not Performed");
			obj.repAddData( "Perform action from Keyboard", "'"+actionDescription+"' should be performed", "'"+actionDescription+"' not performed", "Fail");
			throw(e);
		}
	}
	
	
	public void SendKeyById(String IDvalue, String key, String sFieldName) throws Exception
	{
		try {
			WebElement ele = driver.findElement(By.id(IDvalue));
			HighlightElement(ele);
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
	
	
	public void SendKeyByXpath(String Xpath, String key, String sFieldName) throws Exception
	{
		try {
			WebElement ele = driver.findElement(By.xpath(Xpath));
			HighlightElement(ele);
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
	
	public void SendKeyByName(String value, String key, String sFieldName) throws Exception
	{
		try {
			WebElement ele = driver.findElement(By.name(value));
			HighlightElement(ele);
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
	
	
	public void SendKeyByElement(WebElement ele, String key, String sFieldName) throws Exception
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
	
	public void ClickById(String IDvalue, String faceValue, boolean bReportFlag) throws Exception
	{
		try {
			WebElement ele;
			ele = driver.findElement(By.id(IDvalue));
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
	
	public void ClickByName(String value, String faceValue, boolean bReportFlag) throws Exception
	{
		try {
			WebElement ele;
			ele = driver.findElement(By.name(value));
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
	
	public void ClickByLinkText(String value, String faceValue, boolean bReportFlag) throws Exception
	{
		try {
			WebElement ele;
			ele = driver.findElement(By.linkText(value));
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
	
	public void ClickByPartialLinkText(String value, String faceValue, boolean bReportFlag) throws Exception
	{
		if(testCaseStatus)
		{
			try {
				WebElement ele;
				ele = driver.findElement(By.partialLinkText(value));
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
	
	public void ClickByTagName(String value, String faceValue, boolean bReportFlag) throws Exception
	{
		try {
			WebElement ele;
			ele = driver.findElement(By.tagName(value));
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
	
	
	public void ClickByXpath(String value, String faceValue, boolean bReportFlag) throws Exception
	{
		try {
			WebElement ele;
			ele = driver.findElement(By.xpath(value));
			HighlightElement(ele);
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
	
	
	
	public void ClickByElement(WebElement ele, String faceValue, boolean bReportFlag) throws Exception
	{
		try {
			Actions action = new Actions(driver);
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
	
	public void fnClickActiveElement(String sActiveEleMsg) throws Exception
	{
		try {
			obj.repAddData( "Click on '"	+ sActiveEleMsg + "'", "'" + sActiveEleMsg+ "' should be clicked", "'" + sActiveEleMsg + "' clicked","Pass");
			driver.switchTo().activeElement().click();
		} catch (Exception e) {
			System.out.println("fnClickActiveElement failed");
			obj.repAddData( "Click on '"	+ sActiveEleMsg + "'", "'" + sActiveEleMsg+ "' should be clicked", "'" + sActiveEleMsg+ "' not clicked", "Fail");
			throw(e);
		}
	}
	
		
	public void ClickByAction(String xpath, String faceValue) throws Exception
	{
		try {
			WebElement buttonClick =driver.findElement(By.xpath(xpath));
			HighlightElement(buttonClick);
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
	
	
	public void ClickNavigationNode(String value) throws Exception 
	{
		try {
			WebElement ele;
			ele = driver.findElement(By.xpath("//a[contains(@class,'navbar-topmenu-item')]//span[text()='"+value+"']"));
			HighlightElement(ele);
			if(ele.isDisplayed())
			{
				Actions action = new Actions(driver);
				action.click(ele).build().perform();
			}
			Thread.sleep(1000);
			obj.repAddData( "Click on tree node '"+value+"'", "'"+value+"' should be clicked", "'"+value+"' clicked", "Pass");
		} catch (Exception e) {
			System.out.println("--No Such Element Found--");
			obj.repAddData( "Click on tree node '"+value+"'", "'"+value+"' should be clicked", "'"+value+"' not clicked", "Fail");
			throw(e);
		}
	}
	
	
	public void fnClickNode(String Category, String Activity) throws Exception 
	{
		try {
			obj.repAddData(	"Advisor navigates to '"+Activity+"' under '"+Category+"' tab.", "", "", "");
			subStep = 1;

			if (driver.findElements(By.xpath("//tr[td/div/span[text()= '"+ Activity + "']]")).size() > 0)				
			{	
				ClickByXpath("//tr[td/div/span[contains(text(), '"+ Activity + "')]]", Activity, true);
			} 
			else 
			{
				DoubleClickByXpath("//tr[td/div/span[contains(text(), '"+ Category + "')]]", Category);
				Thread.sleep(500);
				ClickByXpath("//tr[td/div/span[text()= '"+ Activity + "']]", Activity, true);
			}
			
			obj.repAddData( "Advisor navigates to '"+Activity+"' under '"+Category+"' tab.", "'"+Activity+"' should be displayed", "'"+Activity+"' displayed", "Pass");
		}
		 catch (Exception e) {
			System.out.println("fnClicNode----------------failed");
			//throw(e);
		}
	}
	
	/**
	 * @param mLocator
	 * @param tLocator
	 * @param mByType
	 * @param tByType
	 * @throws Exception
	 * 
	 * Use mLocator (String) to pass the locator for the element you want Moved.
	 * Use tLocator (String) to pass the locator for the element want to move To.
	 * Use mByType and tByType (String) to tell the method which identified you want to use
	 * This method reflects this to the By. parameter in findElement.
	 * 
	 * THIS IS EXPERIMENTAL!!
	 */
	public void ClickElementDragTo(String mLocator, String tLocator, String mByType, String tByType) throws Exception
	{
		try {
			Actions action = new Actions(driver);
			
			Class<?> cBy = Class.forName("org.openqa.selenium.By");
			
			WebElement movingElement = null;
			WebElement toElement = null;
			
			Method[] allByMethods = cBy.getDeclaredMethods();
			for (Method m : allByMethods) {
				String methodName = m.getName();
				if (methodName.equals(mByType)) {
					m.setAccessible(true);
					By actionArg = (By) m.invoke(cBy, mLocator);
					movingElement = driver.findElement(actionArg);
				}
				if (methodName.equals(tByType)) {
					m.setAccessible(true);
					By actionArg = (By) m.invoke(cBy, tLocator);
					toElement = driver.findElement(actionArg);
				}
			}
			if (movingElement != null && toElement != null)
			{
				Action dragAndDrop = action.clickAndHold(movingElement)
						.release(toElement)
						.build();
				
				dragAndDrop.perform();
			}
			else { obj.repAddData("Drag element to element", "One or both elements located.", "One or both elements were not located.", "Fail"); }
			
			/* if(bReportFlag==true)
			{
			obj.repAddData( "Click and hold on '"	+ faceValue + "' then drag to " + tEle.getAttribute("name"), "'" + faceValue+ "' should be clicked and moved", "'" + faceValue + "' moved successfully","Pass");
			} */
		} catch (Exception e) {
			/* if(bReportFlag==true)
			{
			obj.repAddData( "Click and hold on '"	+ faceValue + "' then drag to " + tEle.getAttribute("name"), "'" + faceValue+ "' was not dragged", "Fail", "");
			} */
			throw(e);
		}
	}
	
	public void ClickTreeNode(String value) throws Exception {
		try {
			WebElement ele;
			ele = driver.findElement(By.xpath("//*[contains(@class,'x-tree-node-text') and contains(text(),'"+ value + "')]"));
			HighlightElement(ele);
			if (ele.isDisplayed()) {
				Actions action = new Actions(driver);
				action.doubleClick(ele).build().perform();
			}
			Thread.sleep(1000);
			obj.repAddData( "Click on tree node '"+ value + "'", "'" + value + "' should be clicked", "'"+ value + "' clicked", "Pass");
		} catch (Exception e) {
			System.out.println("--No Such Element Found--");
			obj.repAddData( "Click on tree node '"+ value + "'", "'" + value + "' should be clicked", "'"+ value + "' not clicked", "Fail");
			throw (e);
		}
	}
	
	
	
	public void DoubleClickByXpath(String value, String faceValue) throws Exception
	{
		try {
			WebElement ele;
			ele = driver.findElement(By.xpath(value));
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
	
	
	public void RightClickByXpath(String value, String faceValue) throws Exception
	{
		try {
			WebElement ele;
			ele = driver.findElement(By.xpath(value));
			HighlightElement(ele);
			if (ele.isDisplayed())
			{
				Actions action = new Actions(driver);
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
	
	
	
	public void DoubleClickByAction(String xpath, String faceValue) throws Exception
	{
		try {
			WebElement buttonClick =driver.findElement(By.xpath(xpath));
			HighlightElement(buttonClick);
			Thread.sleep(1000);
			obj.repAddData( "Double Click on '"+faceValue+"'", "'"+faceValue+"' should be Double Clicked", "'"+faceValue+"' Double Clicked", "Pass");
			if(buttonClick.isEnabled())
			{
				Actions action =new Actions(driver);
				action.doubleClick(buttonClick).perform();
			}
		} catch (Exception e) {
			System.out.println("--No Such Element Found--");
			obj.repAddData( "Double Click on '"+faceValue+"'", "'"+faceValue+"' should be Double Clicked", "'"+faceValue+"' not Double Clicked", "Fail");
			throw(e);
		}
	}
	
	public void fnCheckTitle(String text) throws Exception 
	{
		if(driver.getTitle().equalsIgnoreCase(text))
		{
			obj.repAddData( "Navigate to Login Window","'"+text+"' window should be displayed","'"+text+"' window displayed", "Pass");
		} else
		{
			obj.repAddData( "Navigate to Login Window","'"+text+"' window should be displayed","'"+text+"' window not displayed", "Fail");
			throw new Exception();
		}	
	}
	
	public Boolean fnRenowalkLogIn(String url, String user, String password) throws Exception
	{	
		Boolean bFlag = true;
		try {
			//fnSetBrowserCapabilities();
			WebDriverWait wait = new WebDriverWait(driver,35);
			obj.repAddData( "Sign In to the application","", "", "");
			driver.navigate().to(url);

			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(RenowalkHome.Main_BtnSignIn_xp)));
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RenowalkHome.Main_BtnSignIn_xp)));
			Thread.sleep(4000);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RenowalkHome.Main_BtnSignIn_xp)));
			fnCheckTitle(RenowalkHome.Main_TitleRenowalkPage_nm);
			SendKeyById(RenowalkHome.Main_InputUserId_id,user,"Username");
			SendKeyById(RenowalkHome.Main_InputPassword_id, password,"Password");
			
			
			//ClickByName(prop.getProperty("ButtonSignIn"), "Sign In Button"); // static ID	
			//ClickById(RenowalkHome.Main_BtnSignIn_id, "Login Button", true); // static ID
			ClickByXpath(RenowalkHome.Main_BtnSignIn_xp, "Login Button", true); 

			
			//if(CheckTextOnPage("Username or password are incorrect"))
			if(CheckTextOnPage("Unable to login, Please check your username and password."))
			{
				System.out.println("Username or password are incorrect");
				obj.repAddData( "Login to the application", "Login should be successful", "Login Failed", "Fail");
				TestDriver.log.info("Renowalk Login Failed - Username or password are incorrect");
				bFlag = false;
				//throw new Exception();
			}
			
			try{
				// wait for page to load here
				if(bFlag == true)
				{
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(RenowalkHome.Main_labelHomePageWelcome_xp)));
					WebElement ele = driver.findElement(By.xpath(RenowalkHome.Main_labelHomePageWelcome_xp));
					HighlightElement(ele);
					obj.repAddData( "Verify Renowalk home page", "Home page should be loaded", "Home page loaded successfully", "Pass");
					TestDriver.log.info( "Login Successful..Home page loaded successfully!");
					TestDriver.bLoginFlag=true;
				}
				
			}catch(Exception e){
				bFlag = false;
				TestDriver.log.error( "Home page not loaded!", e );
				System.out.println("Home Page Header not found");
			}
		/*	
			if(bFlag == true)
			{
				obj.repAddData( "Login to the application", "Login should be successful", "Logged in successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Login to the application", "Login should be successful", "Login Failed", "Fail");
			}
		*/			
		} catch (Exception e) {
			System.out.println("fnLogIn------------------Failed");
			bFlag = false;
			obj.repAddData( "Login to the application", "Login should be successful", "Login Failed", "Fail");
			TestDriver.log.error( "Renowalk Login Failed!", e );
			////throw(e);
		}
		
		return bFlag;
	}
	
	
	// Login to the Application
	public void fnLogIn(String url, String user, String password) throws Exception
	{	
		
		// add check Extension Number
		// add Hangup call if still on call
		// add change status to 'Break' if it is not
		
		try {
			
			obj.repAddData( "Sign In to the application","", "", "");
			
			driver.navigate().to(url);
			Thread.sleep(2000);
			//=====================
//			WebElement e = driver.findElement(By.linkText("Continue anyway"));
//			if(e.isDisplayed()) e.click();
			//=====================
			
			fnCheckTitle(prop.getProperty("pageTitle")); // check title
			
			SendKeyByName(prop.getProperty("InputUser"), user, "username");
			SendKeyByName(prop.getProperty("InputPassword"), password, "password");
			
			
			ClickById(prop.getProperty("ButtonSignIn"), "Sign In Button",true); // static ID	
			
			if(CheckTextOnPage("Username or password are incorrect"))
			{
				System.out.println("Username or password are incorrect");
				obj.repAddData( "Login to the application", "Should login", "Login not successfully", "Fail");
				throw new Exception();
			}
			
			try{
				// wait for page to load here
				WebDriverWait wait = new WebDriverWait(driver,20);
				wait.until(ExpectedConditions.elementToBeClickable(By.id(prop.getProperty("ButtonAdvisor")))); 
				// wait until AdvisorName button to be clickable
			}catch(Exception e){
				System.out.println("Advisor button not found");
			}
			
			
			Thread.sleep(2000);
			
			if(CheckTextOnPage("Home"))
			{
				obj.repAddData( "Login to the application", "Should login", "Login successfully", "Pass");
			} else
			{
				obj.repAddData( "Login to the application", "Should login", "Login not successfully", "Fail");
				throw new Exception();
			}
			
			if(CheckTextOnPage(prop.getProperty("Extenstion")))
			{
				System.out.println("CTI connection available");
			} else
			{
				obj.repAddData( "CTI connection", "CTI connection should be available", "CTI connection not found", "Fail");
				throw new Exception();
			}
		
			
		} catch (Exception e) {
			System.out.println("fnLogIn------------------Failed");
			//throw(e);
		}
	}

	//Sign out of the Application 
		 public void fnSignOut() throws Exception
		 {
			try {
					if(driver!=null)
					{
						if(driver.getPageSource().contains("Logout"))
						{
							obj.repAddData( "Sign out from the application","", "", "");
							WebElement ele;
							ele = driver.findElement(By.xpath("//*[contains(text(),'Logout')]"));
							HighlightElement(ele);				
													
							if (ele.isDisplayed()) 
							{
								ele.click();
							}
							obj.repAddData( "Logout of the application","Logout should be successful","Logged out successfully", "Pass");
							TestDriver.bLoginFlag=false;
						}
						driver.manage().deleteAllCookies();
						driver.quit();
						driver=null;
						
					}

			} catch (Exception e) {
				System.out.println("fnSignOut-----failed");
				obj.repAddData( "Logout of the application", "Logout should be successful","Logout failed", "Fail");
				driver.manage().deleteAllCookies();
				driver.quit();
				driver=null;
				throw(e);
			}	
		}
		 
	 public void fnDriverSignOut(String Name) throws Exception
	 {
		 try {
			 obj.repAddData( "Sign out from the application","", "", "");
			 ClickByAction("//span[starts-with(@id,'button') and @class='x-btn-inner x-btn-inner-center']/div[contains(text(),'"+Name+"')]", ""+Name+"");
			 ClickByAction("//span[contains(text(),'Sign Out') and @class='x-menu-item-text']", "Sign out option");
		 }catch (Exception e) {
			 System.out.println("DriverSignOut----------------Failed");
			 throw(e);
		 }
	 }
		

	public void fnSelectVehicle(String VIN) throws Exception 
	 {
		try {
			subStep = 1;
			obj.repAddData( "VIN search vehicles", "", "", "");
			ClickNavigationNode("Vehicles");
			SendKeyByXpath(prop.getProperty("InputVIN"),VIN, "VIN"); // prop
			KeyboardAction(Keys.ENTER, "Enter Key");
			DoubleClickByXpath("//span[text()='" + VIN + "']",
					"Vehicle with VIN: " + VIN);
		} catch (Exception e) {
			System.out.println("fnSelectVehicle--------------Failed");
			throw (e);
		}
	}
	
	
	public void fnChangeStatus(String TextValue) throws Exception
	{
		try {
			ClickByXpath(prop.getProperty("DropdownStatus"),"Status dropdown",true);

			List<WebElement> StatusDropDown = driver.findElements(By.xpath("//*[@id='idle_reason_pchelem']"));
			for (WebElement ele : StatusDropDown) {
				if (ele.getText().equalsIgnoreCase(TextValue)) {
					Thread.sleep(500);
					HighlightElement(ele);
					ClickByElement(ele, TextValue,true);
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("fnChangeStatus--------------Failed");
			//throw(e);
		}	
	}
	

		
	public void fnSelectFromComboBoxId(String SelectValue, String TextValue) throws Exception
	{
		try {
			
			WebElement select = driver.findElement(By.id(SelectValue));
			if(select.isDisplayed())
			{
				HighlightElementById(SelectValue);
				List<WebElement> options = select.findElements(By.tagName("option"));
				for (WebElement option : options)
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
			System.out.println("fnSelectFromComboBoxId--------------Failed");
			//throw(e);
		}	
	}
	
	
	public void fnSelectFromComboBoxXpath(String SelectValue, String TextValue) throws Exception
	{
		try {
			
			WebElement select = driver.findElement(By.xpath(SelectValue));
			if(select.isDisplayed())
			{
				HighlightElementByXpath(SelectValue);
				
				List<WebElement> options = select.findElements(By.tagName("option"));
				for (WebElement option : options)
				{
					if(TextValue.equalsIgnoreCase(option.getText().trim()))
					{
						Thread.sleep(1000);
						option.click();
						if(TextValue.equalsIgnoreCase("Select"))
						{
							TextValue = TextValue+ " (Pre-condition)";
						}
					    obj.repAddData( "Select '"+TextValue +"' from combo box", "'"+TextValue+"' should be selected", "'"+TextValue+"' is selected in the combo box", "Pass");
						Thread.sleep(1000);
						System.out.println("fnSelectFromComboBoxXpath--------------passed for " + TextValue);
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
	
	public void fnSelectFromJSComboBox(String SelectValue, String TextValue) throws Exception
	{
		try {
			
			WebElement select = driver.findElement(By.id(SelectValue));
			HighlightElementById(SelectValue);
			List<WebElement> options = select.findElements(By.tagName("option"));
			for (WebElement option : options)
			{
				if(TextValue.equalsIgnoreCase(option.getText().trim()))
				{
					Thread.sleep(1000);
					
					JavascriptExecutor js = (JavascriptExecutor)driver;
					
					String sGetDurationElement = "document.getElementById('"+SelectValue + "').style.display='block';";
					js.executeScript(sGetDurationElement);
					Select selectComboOption = new Select(driver.findElement(By.id(SelectValue)));
					Thread.sleep(4000);
					selectComboOption.selectByVisibleText(TextValue);
			
					obj.repAddData( "Select '"+TextValue +"' from combo box", "'"+TextValue+"' should be selected", "'"+TextValue+"' is selected in the combo box", "Pass");
					Thread.sleep(1000);
					System.out.println("fnSelectFromJSComboBox--------------passed for " + TextValue);
					break;
				}
			}

		} catch (Exception e) {
			obj.repAddData( "Select '"+TextValue +"' from combo box", "'"+TextValue+"' should be selected", "'"+TextValue+"' is not selected in the combo box", "Fail");
			System.out.println("fnSelectFromJSComboBox--------------Failed");
			//throw(e);
		}	
	}
	
		
	public void OpenNewTab() throws Exception
	{

		try {
			if (driver.findElements(By.id("button-1172-btnIconEl")).size() == 1) {
				HighlightElementById("button-1172-btnIconEl");

				Actions builder = new Actions(driver);
				// WebElement elementVisible
				// =driver.findElement(By.id("button-1172-btnIconEl"));
				builder.sendKeys(Keys.CONTROL).sendKeys(Keys.SHIFT + "n").build().perform();

				// org.openqa.selenium.interactions.Action
				// submitTheTransperentButton = builder.build();

				// submitTheTransperentButton.perform();

				/*
				 * driver.findElement(By.id("button-1172-btnIconEl")).sendKeys(Keys
				 * .CONTROL +"t"); ArrayList<String> tabs = new
				 * ArrayList<String> (driver.getWindowHandles());
				 * driver.switchTo().window(tabs.get(1));
				 */
			}
		} catch (Exception e) {
			System.out.println("OpenNewTab()--------------Failed");
			throw(e);
		}
	}
	
	public void fnEnterInfo(String label, String value) throws Exception
	{	
		try
		{
			if(CheckXpath(driver,"//table")>1)
			{
				List<WebElement>eleList = driver.findElements(By.xpath("//table"));
				for(WebElement ele : eleList)
				{
					System.out.println(ele.getText());
					if (ele.getText().equalsIgnoreCase(label))
					{
						ele.findElement(By.tagName("input")).sendKeys(value);
						obj.repAddData( "Enter data",value+" should be entered", value+" is entered successfully", "Pass");
						break;
					}
				}
			}
			
		}
		catch(Exception e) {
			System.out.println("Failed to fetch "+label+ " And "+value);
			obj.repAddData( "Enter data",value+" should be entered", value+" is not entered successfully", "Fail");
			//throw(e);
		}
	}
	

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	 public void fnSwitchTab(int num) throws Exception
	 {	
		 try {
			 List<WebElement> Tab = driver.findElements(By.xpath(prop.getProperty("ListTab")));
			 Tab.get(num).click();
		 } catch (Exception e) {
			 System.out.println("fnSwitchTab----------------Failed");
			 //throw(e);
		 }
	 }
	
	 
	 public void fnFilesToArchive(String sSrcPath, String sDestPath) throws Exception
		{
			try {
				
				System.out.println("In function fnFilesToArchive...............");
					File fSourceFolder = new File(sSrcPath);
					String sDestinationFolder = sDestPath;
					
					File[] listFiles = fSourceFolder.listFiles();
					
					for(int i=0; i<listFiles.length; i++)
					{
						File fSourceFilePath = new File(sSrcPath+"\\"+listFiles[i].getName());
						fSourceFilePath.renameTo(new File(sDestinationFolder+"\\"+listFiles[i].getName()));
						fSourceFilePath.delete();
					}
				
			} catch (Exception e) {
				System.out.println("fnFilesToArchive--------------Failed");
				//throw(e);
			}	
		}
	 

		 
	/* public void fnClickNode(String Activity, String Subactivity) throws Exception
	 {
		 try {
			 //driver.switchTo().defaultContent();
			 //driver.switchTo().frame("advisorDesktop");
			 //driver.switchTo().frame("cframe_ww1");
			 
			 fnSwitchToFrame();
			 fnSwitchToFrame(RenowalkModules.FrameActivity1_nm);
			// fnGetIframe("cframe_ww");
			 Actions action = new Actions(driver);
		     WebElement MainTree = driver.findElement(By.xpath("//span[starts-with(@id,'activityListTree_T') and @title='" + Activity + "']"));
		   
			
		    	HighlightElement(MainTree);
				if (MainTree .isDisplayed()) {
                action.doubleClick(MainTree).build().perform();
				} 
				//Thread.sleep(3000);
				String MainID= MainTree.getAttribute("id").toString();
			 WebElement SubTree = driver.findElement(By.xpath("//span[starts-with(@id,'activityListTree_T') and not(contains(@id,'"+MainID+"')) and @title='" + Subactivity + "']"));
				HighlightElement(SubTree);
				if (SubTree.isDisplayed()) {
                action.doubleClick(SubTree).build().perform();
                obj.repAddData( "Click on "+Activity+"->"+Subactivity, Activity+"->"+Subactivity+" should be clicked",  Activity+"->"+Subactivity+" clicked successfully", "Pass");
				}
			 
		 } catch (Exception e) {
				System.out.println("fnClickNode--------------Failed");
				obj.repAddData( "Click on "+Activity+"->"+Subactivity, Activity+"->"+Subactivity+" should be clicked",  Activity+"->"+Subactivity+" not clicked", "Fail");
				throw(e);
			}
	 }*/
	 
	 public String fnTimeDifference(Date BeginTransac, Date EndTransac) throws Exception
	 {
		 
		try {
			
			double  diff = (double) (EndTransac.getTime()  - BeginTransac.getTime());
			//if ((diff / 60) != 0) {
			//	strTimeDiff = ((diff / 60) + "Min" + " " + (diff % 60) + " " + "Secs");
			//	} else {
		
			
			double fActualTime = diff / 1000;
			
			strTimeDiff = String.valueOf(new DecimalFormat("##.###").format(fActualTime));
			    

				
		} catch (Exception e) {
			System.out.println("fnTimeDifference--------------Failed");
			//throw(e);
		}	
		return strTimeDiff;
	 }
	 /*
	 
		System.out.println("Text>>>>"+driver.switchTo().activeElement().getText());
		wait.until(ExpectedConditions.textToBePresentInElement(driver.switchTo().activeElement(),"OK"));	
		//System.out.println("After Wait>>>>"+driver.switchTo().activeElement().getText());
		driver.switchTo().activeElement().click();
	 */
	 
	 public void fnSwitchToActiveElement() throws Exception   //Switch to main advisor frame
		{
			try {
				
				driver.switchTo().activeElement();
				
			} catch (Exception e) {
				System.out.println("fnSwitchToActiveElement--------------Failed");
				//throw(e);
			}	
		}
	 
	 public void fnSwitchToFrame() throws Exception   //Switch to main advisor frame
		{
			try {
				
				driver.switchTo().defaultContent();
				//driver.switchTo().frame(RenowalkMain.FrameAdvisor_nm);
				
			} catch (Exception e) {
				System.out.println("fnSwitchToframe--------------Failed");
				throw(e);
			}	
		}
	 
	 public void fnSwitchToFrame(String sFrameName) throws Exception   //Switch to a frame passed in function
		{
			try {
				
				driver.switchTo().frame(sFrameName);
				
			} catch (Exception e) {
				System.out.println("fnSwitchToFrame--------------Failed");
				throw(e);
			}	
		}
	 
	 //public void fnGetIframe(String prefix) throws Exception   //Earlier name
	 public void fnGetSwitchProfileActivityFrame(String prefix) throws Exception   //New name
	 {
		try {
			    List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
			    for (WebElement iframe : iframes) {
			        if (iframe.getAttribute("id").startsWith(prefix)) {
			        	//driver.switchTo().frame(iframe.getAttribute("id"));
			        	fnSwitchToFrame(iframe.getAttribute("id"));
			        	break;
			        // TODO your stuff.	
			        }
				}
				
		} catch (Exception e) {
			System.out.println("fnGetIframe--------------Failed");
			throw(e);
		}	
	 }
	 
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
	 
	 public void fnSwitchToGISFrame() throws Exception
		{
			try {
				
				driver.switchTo().frame("testframe");
				driver.switchTo().frame("ggisframe");
				
			} catch (Exception e) {
				System.out.println("fnSwitchToGISframe--------------Failed");
				//throw(e);
			}	
		}
	 
	 	 
	 public ArrayList<String> fnGetWebElementList(List<WebElement> webOfferingName) throws Exception
		{
		 	ArrayList<String> arrWebElementList = new ArrayList<String>();
		 	
			try {
				
				for(WebElement ele : webOfferingName)
				{
					
					//if (!ele.getText().isEmpty())
					//{
						arrWebElementList.add(ele.getText().replace("Select Price Plan", "").trim());
						System.out.println(ele.getText());
						
					//}
				}
				
			} catch (Exception e) {
				System.out.println("fnGetWebElementList--------------Failed");
				//throw(e);
			}
			
			return arrWebElementList;
		}
	 
	public int fnGetOfferingIndex(ArrayList<String> arrOfferingName, String sOfferingName) throws Exception
	 {
		 	int index = 0;
		 	
			try {
				
				for(int i=0;i<arrOfferingName.size();i++)
				{
					if(arrOfferingName.get(i).toString().equalsIgnoreCase(sOfferingName))
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
 
 
	 public String fnGetGUITextXpath(String value) throws Exception
	 {
		 String guiValue = null;
		 try {
			 WebElement ele;
			 ele = driver.findElement(By.xpath(value));
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

	 public String fnGetGUITextID(String value) throws Exception
	 {
		 String guiValue = null;
		 try {
			 WebElement ele;
			 ele = driver.findElement(By.id(value));
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
		public void fnWaitForObjectExit(int intSec, String strXpath, String sEventName) throws Exception
	    {
	    
	                    
			try {
	                                    
				WebDriverWait wait = new WebDriverWait(driver,intSec);  //306
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

		/* Shameem - Review all three asc order function and delete if needed
		public ArrayList<String> fnGetIframeAscOrder(String prefix) throws Exception
		 {
			 ArrayList<String> arrFrameNumber = new ArrayList<String>();
			 int temp;
			try {
					JavascriptExecutor js = (JavascriptExecutor) driver;
				    List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
				    for (WebElement iframe : iframes) {
				       // if (iframe.getAttribute("id").startsWith(prefix)) {
				        if (iframe.getAttribute("id").startsWith(prefix)) {
				        	//You may get cd_frame_id_ attribute in any of the profile activity frame
				    	//	boolean bAttributeFlag = (Boolean) js.executeScript("return arguments[0].hasAttribute('cd_frame_id_');",iframe);
				    	//	System.out.println(bAttributeFlag);
				       // 	if(bAttributeFlag==false)
				       // 	{
				        		String[] arrNum = iframe.getAttribute("id").toString().split("_");
				        		arrFrameNumber.add(arrNum[2]);
				       // 	}
				        }
					}
			
				    for(int i = 0; i < arrFrameNumber.size(); i++)
				    {
				        for(int j = 1; j < (arrFrameNumber.size() -i); j++)
				        {
				            //if numbers[j-1] > numbers[j], swap the elements
				            if(Integer.parseInt(arrFrameNumber.get(j-1)) > Integer.parseInt(arrFrameNumber.get(j)))
				            {
				            	temp = Integer.parseInt(arrFrameNumber.get(j-1));
				            	arrFrameNumber.set(j-1, arrFrameNumber.get(j));
				            	arrFrameNumber.set(j, String.valueOf(temp));
				            }
				        }
				    }
				    
					
			} catch (Exception e) {
				System.out.println("fnGetIframeAscOrder--------------Failed");
				DriverScript.log.error("fnGetIframeAscOrder--------------Failed",e);
				////throw(e);
			}
			
			return arrFrameNumber;
		 }
	*/
		
		public ArrayList<String> fnGetIframeAscOrder(String prefix) throws Exception
        {
                        ArrayList<String> arrFrameNumber = new ArrayList<String>();
                        int temp;
                        try {
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
                        for (WebElement iframe : iframes) {
                                        // if (iframe.getAttribute("id").startsWith(prefix)) {
                        				System.out.println(iframe.getAttribute("id"));
                                        if (iframe.getAttribute("id").startsWith(prefix)) {
                                                        //arrFrameNumber.add(iframe.getAttribute("id"));
                                                        boolean bAttributeFlag = (Boolean) js.executeScript("return arguments[0].hasAttribute('cd_frame_id_');",iframe);
                                                        System.out.println(bAttributeFlag);
                                                        if(bAttributeFlag==false)
                                                        {
                                                                        String[] arrNum = iframe.getAttribute("id").toString().split("_");
                                                                        arrFrameNumber.add(arrNum[2]);
                                                        }
                                        }
                        }

                        for(int i = 0; i < arrFrameNumber.size(); i++)
                        {
                                        for(int j = 1; j < (arrFrameNumber.size() -i); j++)
                                        {
                                                        //if numbers[j-1] > numbers[j], swap the elements
                                                        if(Integer.parseInt(arrFrameNumber.get(j-1)) > Integer.parseInt(arrFrameNumber.get(j)))
                                                        {
                                                                        temp = Integer.parseInt(arrFrameNumber.get(j-1));
                                                                        arrFrameNumber.set(j-1, arrFrameNumber.get(j));
                                                                        arrFrameNumber.set(j, String.valueOf(temp));
                                                        }
                                        }
                        }


        } catch (Exception e) {
        System.out.println("fnGetIframeAscOrder--------------Failed");
        TestDriver.log.error("fnGetIframeAscOrder--------------Failed",e);
        ////throw(e);
        }

        return arrFrameNumber;
        }

		public ArrayList<String> fnGetAllIframeAscOrder(String prefix) throws Exception
        {
                        ArrayList<String> arrFrameNumber = new ArrayList<String>();
                        int temp;
                        try {
                        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
                        for (WebElement iframe : iframes) {
                                        // if (iframe.getAttribute("id").startsWith(prefix)) {
                        				System.out.println(iframe.getAttribute("id"));
                                        if (iframe.getAttribute("id").startsWith(prefix)) {
                                                        //arrFrameNumber.add(iframe.getAttribute("id"));
                                                       
                                        String[] arrNum = iframe.getAttribute("id").toString().split("_");
                                        arrFrameNumber.add(arrNum[2]);
                                        }
                        }

                        for(int i = 0; i < arrFrameNumber.size(); i++)
                        {
                                        for(int j = 1; j < (arrFrameNumber.size() -i); j++)
                                        {
                                                        //if numbers[j-1] > numbers[j], swap the elements
                                                        if(Integer.parseInt(arrFrameNumber.get(j-1)) > Integer.parseInt(arrFrameNumber.get(j)))
                                                        {
                                                                        temp = Integer.parseInt(arrFrameNumber.get(j-1));
                                                                        arrFrameNumber.set(j-1, arrFrameNumber.get(j));
                                                                        arrFrameNumber.set(j, String.valueOf(temp));
                                                        }
                                        }
                        }


        } catch (Exception e) {
        System.out.println("fnGetAllIframeAscOrder--------------Failed");
        TestDriver.log.error("fnGetAllIframeAscOrder--------------Failed",e);
        ////throw(e);
        }

        return arrFrameNumber;
        }
		
		public ArrayList<String> fnGetIframeAscOrder_old(String prefix) throws Exception
		 {
			 ArrayList<String> arrFrameNumber = new ArrayList<String>();
			 int temp;
			try {

				    List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
				    for (WebElement iframe : iframes) {
				        if (iframe.getAttribute("id").startsWith(prefix)) {
				        	//arrFrameNumber.add(iframe.getAttribute("id"));
				        	String[] arrNum = iframe.getAttribute("id").toString().split("_");
		    				arrFrameNumber.add(arrNum[2]);
				        }
					}
			
				    for(int i = 0; i < arrFrameNumber.size(); i++)
				    {
				        for(int j = 1; j < (arrFrameNumber.size() -i); j++)
				        {
				            //if numbers[j-1] > numbers[j], swap the elements
				            if(Integer.parseInt(arrFrameNumber.get(j-1)) > Integer.parseInt(arrFrameNumber.get(j)))
				            {
				            	temp = Integer.parseInt(arrFrameNumber.get(j-1));
				            	arrFrameNumber.set(j-1, arrFrameNumber.get(j));
				            	arrFrameNumber.set(j, String.valueOf(temp));
				            }
				        }
				    }
				    
					
			} catch (Exception e) {
				System.out.println("fnGetIframeAscOrder--------------Failed");
				TestDriver.log.error("fnGetIframeAscOrder--------------Failed",e);
				////throw(e);
			}
			
			return arrFrameNumber;
		 }
		
/*		public void fnCloseActivitiesTC() throws Exception
	    {
			System.out.println("In Close Activities");
	                  try {
	                	  
	                	    fnSwitchToFrame();
                            String sCallType ="";
                            sCallType = driver.findElement(By.id(RenowalkMain.CallTypeTitle_id)).getText();
	                	  
	                	    fnSwitchToFrame();
	                	    fnSwitchToFrame(RenowalkModules.FrameActivity1_nm);//       driver.switchTo().frame("cframe_ww1");
	                        //WebElement rootElement = driver.findElement(By.id("currentActivitesList"));
	                	    WebElement rootElement = driver.findElement(By.id(RenowalkModules.CurrentActivitiesList_id));
	                        
	                        List<WebElement> webActivities = rootElement.findElements(By.tagName("li"));
	                      //ArrayList<String> arrFrameNumber = fnGetIframeAscOrder(Activities.FrameProfileActivity_nm);  //this is taking frames other than cd_frame_id_
	                        ArrayList<String> arrFrameNumber = fnGetAllIframeAscOrder(RenowalkModules.FrameProfileActivity_nm);  //This is taking all the frames
	                        int iActivityFrameCount =0;
	                               for(int i =0 ; i <webActivities.size(); i++)
	                                      {
	                            	   			
				                            	 fnSwitchToFrame();
				                            	 fnSwitchToFrame(RenowalkModules.FrameActivity1_nm);
	                                             webActivities.get(i).click();
	                                             //Switch frame
	                                             fnSwitchToFrame();
				                            	 fnSwitchToFrame(RenowalkModules.FrameActivity1_nm);
	                                             //fnGetSwitchProfileActivityFrame(Activities.ProfileActivityFrame_nm);
	                                             System.out.println(webActivities.get(i).getAttribute("class"));
	                                             
	                                             if(webActivities.get(i).getAttribute("class").equalsIgnoreCase("activityListItemActive"))
	                                             {
	                                            	 //driver.switchTo().frame("custProfileActivityIframe_activity_"+arrFrameNumber.get(iActivityFrameCount).toString());
	                                            	 fnSwitchToFrame(RenowalkModules.FrameProfileActivity_nm+arrFrameNumber.get(iActivityFrameCount).toString());
	                                            	 iActivityFrameCount=iActivityFrameCount+1;
	                                            	 
	                                            	 if(driver.findElements(By.xpath("//*[contains(@id,'cancel') and contains(@type,'button')]")).size() != 0)
	                                                 {
	                                                        if(driver.findElement(By.xpath("//*[contains(@id,'cancel') and contains(@type,'button')]")).isEnabled() && driver.findElement(By.xpath("//*[contains(@id,'cancel') and contains(@type,'button')]")).isDisplayed())
	                                                        {
	                                                               driver.findElement(By.xpath("//*[contains(@id,'cancel') and contains(@type,'button')]")).click();
	                                                        }
	                                                 }
	                                                 else  if(driver.findElements(By.xpath("//*[contains(@id,'done') and contains(@type,'button')]")).size() != 0)//Need to put extra code if we see any new activity input on screen
	                                                 {
	                                                	 if(sCallType.contains("Emergency"))   
	                                                	 {
	                                                		 ClickById(RenowalkMain.AccidentalKeyPressCheck_id,"Check Accidental key Press"); //For checking Accidental press key in case of Emergency Call
	                                                		 driver.findElement(By.id("done_btn_1")).click();
	                                                	 }
	                                                	 else if(driver.findElement(By.xpath("//*[contains(@id,'done') and contains(@type,'button')]")).isEnabled() && driver.findElement(By.xpath("//*[contains(@id,'done') and contains(@type,'button')]")).isDisplayed())
	                                                     {
	                                                           driver.findElement(By.xpath("//*[contains(@id,'done') and contains(@type,'button')]")).click();
	                                                     }
	                                                 }
	                                                
	                                                 else  if(driver.findElements(By.xpath("//*[contains(@id,'decline') and contains(@type,'button')]")).size() != 0)
	                                                 {
	                                                        if(driver.findElement(By.xpath("//*[contains(@id,'decline') and contains(@type,'button')]")).isEnabled() && driver.findElement(By.xpath("//*[contains(@id,'decline') and contains(@type,'button')]")).isDisplayed())
	                                                        {
	                                                               driver.findElement(By.xpath("//*[contains(@id,'decline') and contains(@type,'button')]")).click();
	                                                        }
	                                                 }
	                                            	 
	                                                  else  if(driver.findElements(By.xpath("//*[contains(@id,'close') and contains(@type,'button')]")).size() != 0)
	                                                 {
	                                                        if(driver.findElement(By.xpath("//*[contains(@id,'close') and contains(@type,'button')]")).isEnabled() && driver.findElement(By.xpath("//*[contains(@id,'close') and contains(@type,'button')]")).isDisplayed())
	                                                        {
	                                                               driver.findElement(By.xpath("//*[contains(@id,'close') and contains(@type,'button')]")).click();
	                                                        }
	                                                 }
	                                            	
	                                             }
	                                             else
	                                             {
	                                            	 System.out.println("Activity "+i+" already closed..");
	                                             }
	                                            
	                                                   
	                                            
	                               }
	                  }catch (Exception e) {
	                        System.out.println("fnCloseActivitiesTC--------------Failed");
	                        DriverScript.log.error("fnCloseActivitiesTC--------------Failed",e);
	                        ////throw(e);
	                  }
	                  
	                
	                  
	                  
	    }
		public void fnCloseActivities() throws Exception
	    {
			System.out.println("In Close Activities");
	                  try {
	                	  
	                	    fnSwitchToFrame();
                            String sCallType ="";
                            sCallType = driver.findElement(By.id(RenowalkMain.CallTypeTitle_id)).getText();
	                	  
	                	    fnSwitchToFrame();
	                	    fnSwitchToFrame(RenowalkModules.FrameActivity1_nm);//       driver.switchTo().frame("cframe_ww1");
	                        //WebElement rootElement = driver.findElement(By.id("currentActivitesList"));
	                	    WebElement rootElement = driver.findElement(By.id(RenowalkModules.CurrentActivitiesList_id));
	                        
	                        List<WebElement> webActivities = rootElement.findElements(By.tagName("li"));
	                        //ArrayList<String> arrFrameNumber = fnGetIframeAscOrder(Activities.FrameProfileActivity_nm);  //this is taking frames other than cd_frame_id_
	                        ArrayList<String> arrFrameNumber = fnGetAllIframeAscOrder(RenowalkModules.FrameProfileActivity_nm);  //This is taking all the frames
	                        int iActivityFrameCount =0;
	                               for(int i =0 ; i <webActivities.size(); i++)
	                                      {
	                            	   			
				                            	 fnSwitchToFrame();
				                            	 fnSwitchToFrame(RenowalkModules.FrameActivity1_nm);
	                                             webActivities.get(i).click();
	                                             //Switch frame
	                                             fnSwitchToFrame();
				                            	 fnSwitchToFrame(RenowalkModules.FrameActivity1_nm);
	                                             //fnGetSwitchProfileActivityFrame(Activities.ProfileActivityFrame_nm);
	                                             System.out.println(webActivities.get(i).getAttribute("class"));
	                                             
	                                             if(webActivities.get(i).getAttribute("class").equalsIgnoreCase("activityListItemActive"))
	                                             {
	                                            	 //driver.switchTo().frame("custProfileActivityIframe_activity_"+arrFrameNumber.get(iActivityFrameCount).toString());
	                                            	 fnSwitchToFrame(RenowalkModules.FrameProfileActivity_nm+arrFrameNumber.get(iActivityFrameCount).toString());
	                                            	 iActivityFrameCount=iActivityFrameCount+1;
	                                            	 
	                                            	 if(driver.findElements(By.xpath("//*[contains(@id,'cancel') and contains(@type,'button')]")).size() != 0)
	                                                 {
	                                                        if(driver.findElement(By.xpath("//*[contains(@id,'cancel') and contains(@type,'button')]")).isEnabled() && driver.findElement(By.xpath("//*[contains(@id,'cancel') and contains(@type,'button')]")).isDisplayed())
	                                                        {
	                                                               driver.findElement(By.xpath("//*[contains(@id,'cancel') and contains(@type,'button')]")).click();
	                                                        }
	                                                 }
	                                                 else  if(driver.findElements(By.xpath("//*[contains(@id,'done') and contains(@type,'button')]")).size() != 0)//Need to put extra code if we see any new activity input on screen
	                                                 {
	                                                	 if(sCallType.contains("Emergency"))   
	                                                	 {
	                                                		 ClickById(RenowalkMain.AccidentalKeyPressCheck_id,"Check Accidental key Press"); //For checking Accidental press key in case of Emergency Call
	                                                		 driver.findElement(By.id("done_btn_1")).click();
	                                                	 }
	                                                	 else if(driver.findElement(By.xpath("//*[contains(@id,'done') and contains(@type,'button')]")).isEnabled() && driver.findElement(By.xpath("//*[contains(@id,'done') and contains(@type,'button')]")).isDisplayed())
	                                                     {
	                                                           driver.findElement(By.xpath("//*[contains(@id,'done') and contains(@type,'button')]")).click();
	                                                     }
	                                                 }
	                                                
	                                                 else  if(driver.findElements(By.xpath("//*[contains(@id,'decline') and contains(@type,'button')]")).size() != 0)
	                                                 {
	                                                        if(driver.findElement(By.xpath("//*[contains(@id,'decline') and contains(@type,'button')]")).isEnabled() && driver.findElement(By.xpath("//*[contains(@id,'decline') and contains(@type,'button')]")).isDisplayed())
	                                                        {
	                                                               driver.findElement(By.xpath("//*[contains(@id,'decline') and contains(@type,'button')]")).click();
	                                                        }
	                                                 }
	                                            	 
	                                                  else  if(driver.findElements(By.xpath("//*[contains(@id,'close') and contains(@type,'button')]")).size() != 0)
	                                                 {
	                                                        if(driver.findElement(By.xpath("//*[contains(@id,'close') and contains(@type,'button')]")).isEnabled() && driver.findElement(By.xpath("//*[contains(@id,'close') and contains(@type,'button')]")).isDisplayed())
	                                                        {
	                                                               driver.findElement(By.xpath("//*[contains(@id,'close') and contains(@type,'button')]")).click();
	                                                        }
	                                                 }
	                                            	 
	                                            	// obj.repAddData("Open Activities", "Advisor should close all open activities","Advisor closed all open activities", "Pass");
	                                             }
	                                             else
	                                             {
	                                            	 System.out.println("Activity "+i+" already closed..");
	                                             }
	                                            
	                                                   
	                                            
	                               }
	                  }catch (Exception e) {
	                        System.out.println("fnCloseActivities--------------Failed");
	                        DriverScript.log.error("fnCloseActivities--------------Failed",e);
	                        ////throw(e);
	                  }
	                  
	                
	                  
	                  
	    }*/
		
		/*public void fnCloseUnexpectedPages() throws Exception
	    {
	    
			  try{
				   fnSwitchToFrame();
				   fnSwitchToFrame(RenowalkModules.FrameActivity2_nm);

				   //ClickById("closeButton","Close button");//'reporting not needed
				   if(driver.findElement(By.id(RenowalkMain.BtnUnexpectedClose_id)).isDisplayed())
				   {
					   driver.findElement(By.id(RenowalkMain.BtnUnexpectedClose_id)).click();
				   }
				   fnSwitchToFrame();
				   //ClickById("closeImg_ww2","Close Page"); //'reporting not needed
				   if (driver.findElements(By.id(RenowalkMain.IconUnexpectedClose_id)).size()>0)
					{
					   driver.findElement(By.id(RenowalkMain.IconUnexpectedClose_id)).click(); 
					}
         		}
             catch(Exception e){System.out.println("fnCloseUnexpectedPages not found");
           	}
             try{
           	  	fnSwitchToFrame();
           	  	fnSwitchToFrame(RenowalkModules.FrameActivity2_nm);
	                List<WebElement> textEnrollment = driver.findElements(By.xpath("//span[contains(text(),'Enrollment')]"));
	                if (textEnrollment.size()>0)
	                { 
		              	//driver.findElement(By.xpath("//*td[@class='x7j',contains(text(),'Cancel']")).click();
	                	 if(driver.findElements(By.xpath("//*[contains(@id,'cancel') and contains(@type,'button')]")).size() != 0)
                         {
                                if(driver.findElement(By.xpath("//*[contains(@id,'cancel') and contains(@type,'button')]")).isEnabled() && driver.findElement(By.xpath("//*[contains(@id,'cancel') and contains(@type,'button')]")).isDisplayed())
                                {
                                       driver.findElement(By.xpath("//*[contains(@id,'cancel') and contains(@type,'button')]")).click();
                                }
                         }
	                }
                       
             }
             catch(Exception e){System.out.println("fnCloseUnexpectedPages not found");
             DriverScript.log.error("fnCloseUnexpectedPages--------------Failed",e);}   
	    }*/
		
		public void fnInitializeGlobalVariables() throws Exception
		{
			try {
				
				mainStep=0;
				subStep=0;
				testCaseStatus=true;
				
			} catch (Exception e) {
				System.out.println("fnInitializeGlobalVariables--------------Failed");
				TestDriver.log.error("fnInitializeGlobalVariables--------------Failed",e);
			}	
		}
		
		/*public void fnHistory(String Activity) throws Exception
		{

		     try
		     {
	    	    	 
		     obj.repAddData("Advisor wants to find Transaction Details for last activity history","", "", "");
		     Date today = new Date();
	    	 String sActivityDate = new SimpleDateFormat("MM-dd-yyyy").format(today);
	    	 
		     Thread.sleep(4000);
		     fnSwitchToFrame();
		     fnSwitchToFrame(RenowalkModules.FrameActivity1_nm);
     
		     // Select History Tab
		     ClickByXpath(RenowalkMain.TabHistoryTab_xp, "History Tab");      
		     Thread.sleep(10000);
		     fnSwitchToFrame(RenowalkMain.FrameHistory_id);
		     Thread.sleep(15000);
		     //int rowcountbasic=(driver.findElements(By.xpath("//*[@id='history_summarytable']/table[2]/tbody/tr")).size()); //*[@id='history_summarytable']/table[2]/tbody/tr[2]/td[4]
		     int rowcountbasic=driver.findElements(By.xpath(RenowalkMain.TabHistorySummary_xp)).size(); //*[@id='history_summarytable']/table[2]/tbody/tr[2]/td[4]
	
			 for(int i=2;i<=rowcountbasic;i++) 
			 {
				 String sActivityStatus ="";
			     WebElement DescriptionAvailable=driver.findElement(By.xpath(RenowalkMain.TabHistorySummary_xp+"["+i+"]/td[4]"));
			     if (DescriptionAvailable.getText().equalsIgnoreCase(Activity))
			     {
			      
					     obj.repAddData("Activity History Details", "Activity History Details should be found", "Activity History Details is found for '" + Activity + "'", "Pass");
					     ClickByXpath("//input[starts-with(@id,'history_summarytable:"+(i-2)+"')]", Activity + " Radio button");
					     Thread.sleep(5000);
					     
					     sActivityStatus = driver.findElement(By.xpath(RenowalkMain.TabHistorySummary_xp+"["+i+"]/td[5]")).getText().toString().trim();
					     
					     int colcount1=(driver.findElements(By.xpath(RenowalkMain.TabHistoryDetail_xp+"/td")).size());
					     String DescriptionDetArray[][]=  new String [2][colcount1];
					     String sFinalValue1 = "";
				      
					     for(int j=1;j<(colcount1+1);j++)
					     {
					    	 	
					    	 	try {
									DescriptionDetArray[0][j-1] = driver.findElement(By.xpath(RenowalkMain.TabHistoryDetail_xp+"[1]/th["+j+"]")).getText();
									DescriptionDetArray[1][j-1]= driver.findElement(By.xpath(RenowalkMain.TabHistoryDetail_xp+"[2]/td["+j+"]")).getText();
								} catch (Exception e) {
									DescriptionDetArray[1][j-1]="";
									DriverScript.log.error("",e);
								}
				      
							     //DescriptionDet[j]=" '" + DescriptionDetArray[0][j] + "': '" + DescriptionDetArray[1][j] + "' ";
							    if(!DescriptionDetArray[0][j-1].toString().equalsIgnoreCase(""))
							    {
							     sFinalValue1 =  "'" + sFinalValue1 + "''" + DescriptionDetArray[0][j-1].toString() + "': '" + DescriptionDetArray[1][j-1].toString() + "' "+",\n";
							    }
					     }
					     sFinalValue1 = sFinalValue1.substring(0, sFinalValue1.length()-1);
				     
					     obj.repAddData("Activity History Details", "Activity History Details should be found", "Activity History Details is found as " + sFinalValue1, "Pass");
					     if(sFinalValue1.contains(DriverScript.sUsername) && sFinalValue1.contains(sActivityDate))
					     {
					    	 obj.repAddData("Verify Vehicle History details", "Advisor Id and Date should be verified", "Advisor Id = "+DriverScript.sUsername+ " and Date = " +sActivityDate+" are verified", "Pass");
					     }
					     else
					     {
					    	 obj.repAddData("Verify Vehicle History details", "Advisor Id and Date should be verified", "Advisor Id = "+DriverScript.sUsername+ " and Date = " +sActivityDate+" not correct", "Fail");
					     }
				    
					     if(sActivityStatus.equalsIgnoreCase("Closed"))
					     {	 
						     int rowcount2=(driver.findElements(By.xpath(RenowalkMain.TabHistoryTransc_xp)).size());
						     String TransactionDetArray[][]= new String [rowcount2][2]; 
						     String sFinalValue2 = "";

						     for(int k=2;(k<rowcount2+1);k++)
						     {
						    	 try {
									 TransactionDetArray[k-2][0] = driver.findElement(By.xpath(RenowalkMain.TabHistoryTransc_xp+"["+k+"]/td[1]")).getText();
									 TransactionDetArray[k-2][1]= driver.findElement(By.xpath(RenowalkMain.TabHistoryTransc_xp+"["+k+"]/td[2]")).getText();
								} catch (Exception e) {
									TransactionDetArray[k-2][1]="";
									DriverScript.log.error("",e);
								}
						    	 //DescriptionDet[j]=" '" + DescriptionDetArray[0][j] + "': '" + DescriptionDetArray[1][j] + "' ";
							     sFinalValue2 ="'" + sFinalValue2 + "' '" + TransactionDetArray[k-2][0].toString() + "': '" + TransactionDetArray[k-2][1].toString() + "' "+",";
					     	 }
					     	 
						     sFinalValue2 = sFinalValue2.substring(0, sFinalValue2.length()-1);
					     	 obj.repAddData("Activity History Transaction Details", "Activity History Transaction Details should be found", "Activity History Transaction Details is found as '" + sFinalValue2 + "'", "Pass");
						  }
					     else
					     {
					    	 obj.repAddData("Activity History Transaction Details", "Activity History Transaction Details should be found", "Activity History Transaction Details not found as '" + Activity + "'" +" is not Closed", "Pass");
					     }
				     	 
					     break;
			     
			     }  //End of If DescriptionAvailable condition
	 
			 } //End of For loop
		 
		   }catch (Exception e) {
		    System.out.println("History Transaction Verifiation --------------Failed");    
		    DriverScript.log.error("fnHistory failed",e);
		    }
		}*/
		         
		/*public void fnChangeStatusToReady() throws Exception
	    {
		    try{
		    
			    fnSwitchToFrame();
			    if (driver.findElements(By.xpath("//*[@id='idle_reason_pchelem']/option[1]")).size()>0)
			    {
			         if (driver.findElement(By.xpath("//*[@id='idle_reason_pchelem']/option[1]")).getText().toString().equalsIgnoreCase("Go Ready"))
			         {
			        	 fnHangupCurrentCall();
			        	 fnMasterWrapCall();
			         }
			    }
			        fnSelectFromComboBox("idle_reason_pchelem","Ready");
		    }
		    catch(Exception e){
		    	System.out.println("In Exception");
			}
	    
	    }*/
	     
	    /* public void fnChangeStatusToBreak() throws Exception
	     {
	    	 try{
	    		 fnSwitchToFrame();
	            fnSelectFromComboBox(RenowalkMain.VehStatusComboBox_id,"Break");
	            
	    	 }
	    	 catch(Exception e){
	  		System.out.println("In Exception");
	  		}
	    	 
	     }*/
	     
	    /* public void fnAdvisorSearch(String sType) throws Exception
	     {
	    	try{
				
				
				fnSwitchToFrame();

				obj.repAddData("Account Search","", "", "");
				ClickById(RenowalkMain.IconAccountSearch_id, "Search Account");

				fnSwitchToFrame(RenowalkModules.FrameActivity2_nm);
				Thread.sleep(3000);
				if (sType.equalsIgnoreCase("VIN"))
				{
					SendKeyById(RenowalkMain.EditVin_id,fnGetData("VIN"),"");
					ClickById(RenowalkMain.BtnSearchByVin_id, "Search Button");
				}
				else if(sType.equalsIgnoreCase("STID"))
				{
					ClickByXpath(RenowalkMain.LinkAdvancedSearch_xp, "Advanced Search Button");
					SendKeyById(RenowalkMain.EditStid_id,fnGetData("Station_ID"),"");
					ClickById(RenowalkMain.BtnSearchBySTIDNum_id, "Search Button");
				}
				else if(sType.equalsIgnoreCase("Account"))
				{
					SendKeyById(RenowalkMain.EditAccountNumber_id,fnGetData("OnStarAcccount"),"");
					ClickById(RenowalkMain.BtnSearchByAccountNum_id, "Search Button");
				}

				Thread.sleep(1000);
				if(driver.findElement(By.id(RenowalkMain.BtnNext_id)).isEnabled())
				{
					ClickById(RenowalkMain.BtnNext_id, "Next");
				}
				else
				{
					obj.repAddData( "Click on Next button", "Next button should be clicked", "Next button not clicked", "Fail");
					ClickById(RenowalkMain.BtnCancel_id, "Cancel button (as Next button NOT enabled)");//Hit Cancel button as next button is not enabled and no search result populated
					
				}
				
	     }catch(Exception e){
	 		System.out.println("In Exception");
	 		DriverScript.log.info("fnAccountSearch in Exception" + e);
	 	}
				
	     }*/
	     
	     public static String fnGetData(String ColumnName) throws Exception
	     {
	    	 String ColumnData=null;
	    	try{  
	    	ColumnData=TestDriver.mTestPhaseData.get(TestDriver.iTC_ID).get(ColumnName);
	    	}
	    	
	    	catch(Exception e){}
	    	
	    	return ColumnData;
	     }
	     
	     
	  /*   public void fnSTIDSearch() throws Exception
			{
				try{
					obj.repAddData("Advisor Search with Station ID", "", "", "");
					fnSwitchToFrame();				
					ClickById(RenowalkMain.IconAccountSearch_id, "Account Search Button"); 
					
					// Switch to frame FrameActivity
					fnSwitchToFrame(RenowalkModules.FrameActivity2_nm);
					Thread.sleep(3000);
					ClickByXpath(RenowalkMain.LinkAdvancedSearch_xp, "Advanced Search Button");
					SendKeyById(RenowalkMain.EditStid_id, fnGetData("Station_ID"),"");
					Thread.sleep(1000);
					ClickById(RenowalkMain.BtnSearchBySTIDNum_id, "Search by STID button");
					Thread.sleep(3000);
					ClickById(RenowalkMain.BtnNext_id, "Next Button");
					
				}
		      	catch (Exception e) {
				System.out.println("fnSearchSTID--------------Failed");
				throw(e);
		  		}
			}*/
	     
	 /*public void fnHangupCurrentCall() throws Exception
	  {
	     try{
    	 	fnSwitchToFrame();
			 if (fnGetGUITextID(RenowalkMain.TextAgentState_id).equalsIgnoreCase("On Call"))
			 {
				 if (fnGetGUITextID(RenowalkMain.TextCallState_id).equalsIgnoreCase("Hold") || fnGetGUITextID(RenowalkMain.TextCallState_id).equalsIgnoreCase("Ringing"))
				 {
					 driver.findElement(By.id(RenowalkMain.IconLine1_id)).click();
				 //ClickById("line1_pchelem","Line 1 icon"); no reporting
				 }
				 	driver.findElement(By.id(RenowalkMain.BtnHangup_id)).click();
			 //ClickById("hangupButton_pchelem","Hang up Button"); No reporting
			 }
	     }
	     catch(Exception e)
		     {
		     System.out.println("Error in fnHangupCurrentCall....\n" +e);
		     DriverScript.log.error("Error in fnHangupCurrentCall....\n" +e);
		     }
	     }
	 */
	 public String fnGetGVSIframe(String sFrameName) throws Exception
	 {
		String sFlag="false";
		try {
			    List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
			    for (WebElement iframe : iframes) {
			        if (iframe.getAttribute("id").equalsIgnoreCase(sFrameName)) {
			        	System.out.println(iframe.getAttribute("id").toString());
			        	sFlag="true";
			        	driver.switchTo().frame(iframe.getAttribute("id"));
			        	break;
			        // TODO your stuff.
			        }
				}
				
		} catch (Exception e) {
			System.out.println("fnGVSGetIframe--------------Failed");
			throw(e);
		}	
		
		return sFlag;
	 }
	 
	 
	 public void fnOpenDashboard() throws Exception
	 {
		 try {
	            String line;
	            boolean bFlag = true; 
	            Process p = Runtime.getRuntime().exec(System.getenv("windir") +"\\system32\\"+"tasklist.exe");
	            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
	            while ((line = input.readLine()) != null) {
	              //  System.out.println("Task>>>"+line); //<-- Parse data here.
	                if(line.contains("Dashboardw.exe"))
	                {
	                	bFlag = false;
	                	break;
	                }
	            }
	            input.close();
	            
	            if(bFlag == true)
	            {
	            	System.out.println("Dashboard is not opened. Run OpenDashboardQTP.vbs script");
	            	//ExecuteCommand(FileLoc.sDashboardPath+"OpenDashboardQTP.vbs");	
	            }
	            else
	            {
	            	System.out.println("Dashboard is already opened.");
	            }

		} catch (Exception e) {
			System.out.println("fnOpenDashboard--------------Failed");
			System.out.println("Error in fnOpenDashboard....\n" +e);
		    TestDriver.log.error("Error in fnOpenDashboard....\n" +e);
			throw(e);
		}	
		
	 }
	 
	/* public void fnCallSimulator(String STIDchange, String CallingCodeChange,String CallType) throws Exception
	 {
			try
			{   
				fnSwitchToFrame();
				driver.findElement(By.xpath("//*[@id='menubar_navigationMenu']/span[2]/span[2]")).click();
				KeyboardAction(Keys.ARROW_DOWN, "Arrow Down");
				KeyboardAction(Keys.ARROW_DOWN, "Arrow Down");
				KeyboardAction(Keys.ARROW_DOWN, "Arrow Down");
				KeyboardAction(Keys.ENTER, "Enter");  
				 if (driver.findElements(By.xpath(RenowalkMain.IconCallSimulator_xp)).size()==1)
				    {
				    ClickByXpath(RenowalkMain.IconCallSimulator_xp,"Simulator icon");
				    }
				
				fnSwitchToFrame();
				fnSwitchToFrame(RenowalkModules.FrameActivity2_nm);
				String InboundCellData=driver.findElement(By.xpath("//*[@id='processInboundTextId']")).getText();
				System.out.println(InboundCellData);
				String[] IndividualCellData = InboundCellData.split("\\|");
				String InboundCellDataNew="";
				
				int ParametersType=0;
				Thread.sleep(5000);
				if(STIDchange.equalsIgnoreCase("Default") && CallingCodeChange.equalsIgnoreCase("Default")) ParametersType=1;
				if(STIDchange.equalsIgnoreCase("Default") && !(CallingCodeChange.equalsIgnoreCase("Default"))) ParametersType=2;
				if(!(STIDchange.equalsIgnoreCase("Default")) && CallingCodeChange.equalsIgnoreCase("Default")) ParametersType=3;
				if(!(STIDchange.equalsIgnoreCase("Default")) && !(CallingCodeChange.equalsIgnoreCase("Default"))) ParametersType=4;
				
				switch(ParametersType)
				{ 
					case 1:
					{
						System.out.println("No change in STID or Calling Code is required");
						break;
					}
					case 2:
					{
						for (int i=1;i<=IndividualCellData.length;i++) 
						{
							if (IndividualCellData[i-1].contains("VcmCallingCode:"))
							{
								IndividualCellData[i-1]=IndividualCellData[i-1].replace(IndividualCellData[i-1],"VcmCallingCode:"+CallingCodeChange+"");
							}
								InboundCellDataNew=InboundCellDataNew+"|"+IndividualCellData[i-1];
						}
						InboundCellDataNew = InboundCellDataNew.substring(1,InboundCellDataNew.length())+"|";
						System.out.println(InboundCellDataNew);
						driver.findElement(By.xpath("//*[@id='processInboundTextId']")).clear();
						driver.findElement(By.xpath("//*[@id='processInboundTextId']")).sendKeys(InboundCellDataNew);
						break;
					}
					case 3:
					{
						for (int i=1;i<=IndividualCellData.length;i++) 
						{
							if (IndividualCellData[i-1].contains("VcmStId:"))
							{
								IndividualCellData[i-1]=IndividualCellData[i-1].replace(IndividualCellData[i-1],"VcmStId:"+STIDchange+"");
							}
								InboundCellDataNew=InboundCellDataNew+"|"+IndividualCellData[i-1];
						}
						InboundCellDataNew = InboundCellDataNew.substring(1,InboundCellDataNew.length())+"|";
						System.out.println(InboundCellDataNew);
						driver.findElement(By.xpath("//*[@id='processInboundTextId']")).clear();
						driver.findElement(By.xpath("//*[@id='processInboundTextId']")).sendKeys(InboundCellDataNew);
						break;
					}
					case 4:
					{
						for (int i=1;i<=IndividualCellData.length;i++) 
						{
							if (IndividualCellData[i-1].contains("VcmStId:"))
							{
								IndividualCellData[i-1]=IndividualCellData[i-1].replace(IndividualCellData[i-1],"VcmStId:"+STIDchange+"");
							}
							if (IndividualCellData[i-1].contains("VcmCallingCode:"))
							{
								IndividualCellData[i-1]=IndividualCellData[i-1].replace(IndividualCellData[i-1],"VcmCallingCode:"+CallingCodeChange+"");
							}
								InboundCellDataNew=InboundCellDataNew+"|"+IndividualCellData[i-1];
						}
						InboundCellDataNew = InboundCellDataNew.substring(1,InboundCellDataNew.length())+"|";
						System.out.println(InboundCellDataNew);
						driver.findElement(By.xpath("//*[@id='processInboundTextId']")).clear();
						driver.findElement(By.xpath("//*[@id='processInboundTextId']")).sendKeys(InboundCellDataNew);
						break;
					}
						
				}	
				
				int CallTypeCount=0;
				
				Thread.sleep(2000);
				if (CallType.equalsIgnoreCase("AACN")) CallTypeCount =1;
				if (CallType.equalsIgnoreCase("Emergency")) CallTypeCount =2;
				if (CallType.equalsIgnoreCase("LIEC")) CallTypeCount =3;
				if (CallType.equalsIgnoreCase("Failed TBT")) CallTypeCount =4;
				if (CallType.equalsIgnoreCase("Landline")) CallTypeCount =5;
				if (CallType.equalsIgnoreCase("Blue Button")) CallTypeCount =6;
				if (CallType.equalsIgnoreCase("Use Calling Code From Above")) CallTypeCount =7;
				if (CallType.equalsIgnoreCase("eNav")) CallTypeCount =8;
				if (CallType.equalsIgnoreCase("Lost Client")) CallTypeCount =9;
				if (CallType.equalsIgnoreCase("Emergency Transfer")) CallTypeCount =10;
				if (CallType.equalsIgnoreCase("Non-Emergency Transfer")) CallTypeCount =11;
				if (CallType.equalsIgnoreCase("Route to Group")) CallTypeCount =12;
				if (CallType.equalsIgnoreCase("Use Prefetch Passthrough Data")) CallTypeCount =13;
				
	
				switch(CallTypeCount)
				{ 
					case 1:
					{
						ClickById(RenowalkMain.RadioAACN_id, "AACN");
						break;
					}
					case 2:
					{
						ClickById(RenowalkMain.RadioEmergency_id, "Emergency");
						break;
					}
					case 3:
					{
						ClickById(RenowalkMain.RadioLIEC_id, "LIEC");
						break;
					}
					case 4:
					{
						ClickById(RenowalkMain.RadioFailedTBT_id, "Failed TBT");
						break;
					}
					case 5:
					{
						ClickById(RenowalkMain.RadioLandline_id, "Landline");
						break;
					}
					case 6:
					{
						ClickById(RenowalkMain.RadioBlueButton_id, "Blue Button");
						break;
					}
					case 7:
					{
						ClickById(RenowalkMain.RadioUseCallingCodeFromAbove_id, "Use Calling Code From Above");
						break;
					}
					case 8:
					{
						ClickById(RenowalkMain.RadioeNav_id, "eNav");
						break;
					}
					case 9:
					{
						ClickById(RenowalkMain.RadioLostClient_id, "Lost Client");
						break;
					}
					case 10:
					{
						ClickById(RenowalkMain.RadioEmergencyTransfer_id, "Emergency Transfer");
						break;
					}
					case 11:
					{
						ClickById(RenowalkMain.RadioNonEmergencyTransfer_id, "Non-Emergency Transfer");
						break;
					}
					case 12:
					{
						ClickById(RenowalkMain.RadioRoutetoGroup_id, "Route to Group");
						break;
					}
					case 13:
					{
						ClickById(RenowalkMain.RadioUsePrefetchPassthroughData_id, "Use Prefetch Passthrough Data");
						break;
					}
					default :
					{
						System.out.println(""+CallType+" not successful");
						throw new Exception();
					}
					
				} // end of switch
			Thread.sleep(5000);
			ClickById("processInboundButtonId", "Process Inbound Call Button");
		 
	 }catch (Exception e) {
         System.out.println("fnCloseActivities--------------Failed");
         DriverScript.log.error("fnCloseActivities--------------Failed",e);
         ////throw(e);
	 		}
	 }*/
	 
	/* public void fnClickCommonButton(String sButtonType) throws Exception
     {
    	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	try{
    		sButtonType =sButtonType.toLowerCase();
    		String xButton_xp="//*[contains(@id,'"+sButtonType+"') and contains(@type,'button')]";
    		boolean bButtonClick=true;
    		 
    		 for (int i=0;i<3;i++)
    		 {
    			 DriverScript.bSwitchFrame = false;
    			 fnSwitchToFrame();
    		
    			try {
					fnSwitchToFrame(RenowalkModules.FrameActivity_nm+i);
					 try {
							//fnGetSwitchProfileActivityFrame(Activities.FrameProfileActivity_nm);
						 	fnGetSwitchCurrentProfileActivityFrame(RenowalkModules.FrameProfileActivity_nm);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			    		 
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	if(DriverScript.bSwitchFrame == true)		
		    	{
		    		 
		    		 try {
		    				 
		    				 if (driver.findElements(By.xpath(xButton_xp)).size()==1)
		    				 {

							        if(driver.findElement(By.xpath(xButton_xp)).isEnabled() && driver.findElement(By.xpath(xButton_xp)).isDisplayed())
							        {
							               ClickByXpath(xButton_xp,sButtonType+" button");
							               break;
							        }
							        else
							        {
							        	bButtonClick=false;
							        }
		    				 }
							 
		    				
						} catch (Exception e) {
							DriverScript.log.error("Couldn't click on Cancel button", e);
						}
		    		 }
		    		 
		    		
		    		 
		    		 //} //if flag true
    		 }//For loop
    		 if (bButtonClick==false)
		        {
		        	obj.repAddData(sButtonType+" button", "Click on "+sButtonType+" button",sButtonType+" button not found", "Fail");
		        }
    	}//try 
    	catch(Exception e){
    	throw(e);
    	}
     }
	 */
	 
/*	 public void fnOverridePIN() throws Exception
	 {
		 obj.repAddData("Override PIN", "", "", "");
		fnSwitchToFrame();
	 	fnSwitchToFrame(RenowalkModules.FrameActivity1_nm);
	 	//fnGetSwitchProfileActivityFrame(Activities.FrameProfileActivity_nm);
	 	fnGetSwitchCurrentProfileActivityFrame(RenowalkModules.FrameProfileActivity_nm);
		if(driver.findElements(By.id(RenowalkModules.OverrideCheckPIN_id)).size()==1)
		 {
    		try{
    		 ClickById(RenowalkModules.OverrideCheckPIN_id,"Override checkbox");
    		 fnSelectFromComboBox(RenowalkModules.Reason_id,"Emergency");
    		 ClickById(RenowalkModules.BtnContinue_id,"Continue button");
    		 Thread.sleep(2000);
    		}
    		catch(Exception e){}
    		 }
	 }
	 */
	 // Shameem - review this code and merge with landing page vin validation
	 public void fnLandingPage() throws Exception
	 {	String value;
		 if (driver.findElements(By.xpath("//*[@id='testformname']")).size()==1)
		 {
			 value=driver.findElement(By.xpath("//*[@id='testformname']")).getText();
			 if (value.contains("Account / Subscriber / Vehicle Overview"))
			 {
				 obj.repAddData("Landing Page", "Landing page should display", "Landing page displayed", "Pass");
			 }
			 else
			 {
				 obj.repAddData("Landing Page", "Landing page should display", "Landing page not displayed", "Fail"); 
			 }
		 }
	 }
	 
	 public void fnVerifyActivityEntitlement(String description, String Flag) throws Exception
	 {
		 
		try {Thread.sleep(1000);
			String xEntitleinfoPath="//*[@id='entitlement_table']/table[2]/tbody/tr";
			List <WebElement> Entitleinfo= driver.findElements(By.xpath(xEntitleinfoPath));

			for(int k=3;k<=Entitleinfo.size();k++)
			{
				String sText=driver.findElement(By.xpath(xEntitleinfoPath+"["+k+"]/td[2]")).getText();
				System.out.print(sText);
				if(driver.findElement(By.xpath(xEntitleinfoPath+"["+k+"]/td[1]")).getText().equalsIgnoreCase(description) && sText.equalsIgnoreCase(Flag))
				    {
						obj.repAddData("Service Entitlement", "Service Entitlement should Display", description +" is Displayed with <b>"+ Flag.toUpperCase() +"</b> in Application", "Pass");
						break;
					}
					
			}
		} catch (Exception e) {
			System.out.print("Failed");
		}

	 }
	 
	/* public void fnSwitchSubActivity(String SubActivityName) throws Exception
	 {
		try {
			fnSwitchToFrame();
			fnSwitchToFrame(RenowalkModules.FrameActivity1_nm);
			List <WebElement> eLists =driver.findElements(By.xpath(RenowalkModules.ListCurrentActiveList_xp));
			Actions Action =new Actions(driver);
			for(WebElement eList :eLists)
			{
				if (eList.getText().equalsIgnoreCase(SubActivityName))
				{
					HighlightElement(eList);
					Action.doubleClick(eList).build().perform();
					break;
				}
			}
		} catch (Exception e) {
			DriverScript.log.error("fnSwitchSubActivity................Failed");
		}
	 }*/
	 
	/* public String fnGetFrameCustomerActivity(String SubActivityName) throws Exception
	 {
		String CustFrame = null;
		fnSwitchToFrame();
	    	//fnSwitchToFrame(RenowalkModules.FrameActivity1_nm);//       driver.switchTo().frame("cframe_ww1");
	    	//WebElement rootElement = driver.findElement(By.id("currentActivitesList"));
	    	WebElement rootElement = driver.findElement(By.id(RenowalkModules.CurrentActivitiesList_id));
	    	List<WebElement> webActivities = rootElement.findElements(By.tagName("li"));
	    	
	    	for(int i=1;i<webActivities.size(); i++)
	    	{
	    		if (webActivities.get(i).getText().equalsIgnoreCase(SubActivityName))
	    		{
	    			CustFrame ="custProfileActivityIframe_activity_"+i;
	    		}
	    	}
	    	
	    return CustFrame;
	 }*/
	
	/* public void fnCheckSTIDdetails(String VIN) throws Exception
	 {
			WebDriverWait wait = new WebDriverWait(driver,180);
			fnSwitchToFrame();
			fnSwitchToFrame(RenowalkModules.FrameActivity1_nm);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("summary"));
		//	wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//*[@id='_id77']")), VIN));
			String DeviceType=fnGetGUITextID("_id109");
			obj.repAddData( "Device Type should", " Device type should be present", "Device type is present as '" + DeviceType + "' ", "Pass");
			String HardwareType=fnGetGUITextID("hardwareLabelId");
			obj.repAddData( "Hardware Type", " Hardware type should be present", "Hardware type is present as '" + HardwareType + "' ", "Pass");
			fnSwitchToFrame();
			String CellularType=fnGetGUITextID("messageCol_ww1");
			obj.repAddData( "Cellular Type", " Cellular type should be present", "Cellular type is present as '" + CellularType + "' ", "Pass");
			
		}*/

	 public void fnMatchText(String sxpath, String object, String text) throws Exception

	 {
		try
		{
		if (driver.findElement(By.xpath(sxpath)).getText().contentEquals(text))
				{	
			obj.repAddData(""+object+" text verification", ""+object+" text should be found be verified", ""+object+" text is verified as '" + text + "'", "Pass");	
				}
		else
				{
			obj.repAddData(""+object+" text verification", ""+object+" text should be found be verified", ""+object+" text is not verified as '" + text + "'", "Fail");
				}					
		} catch (Exception e) {
	    System.out.println("History Transaction Verifiation --------------Failed");    
	    TestDriver.log.error("fnHistory failed",e);
	    }
	 }
	 
	/* public void HandleButton() throws Exception
	 {
		 
		 try {
			if (driver.findElements(By.id(RenowalkModules.ManagePackage_RenewPackages_BtnQuote_id)).size()==1)
				{
					ClickById(RenowalkModules.ManagePackage_RenewPackages_BtnQuote_id,"Quote Button");
					Thread.sleep(3000);
				}
			else if(driver.findElements(By.id(RenowalkModules.IssueResolution_Compensation_BtnNext)).size()==1)
				{
					ClickById(RenowalkModules.IssueResolution_Compensation_BtnNext,"Next button");
					Thread.sleep(3000);
				}
			else
				{
					obj.repAddData("Click on 'Quote' button", "'Quote' button should be visible and clickable", "'Quote' button is not clicked", "Fail");
					throw new Exception();
				}
		} catch (Exception e) {
			DriverScript.log.error("Failed to quote");
		}
	 }*/
	 
	/* public void fnHistory_CreateCase_(String Activity) throws Exception
     {

                     try
                     
                     {
                           
                     obj.repAddData("Advisor wants to find Transaction Details for last activity history","", "", "");
                     Thread.sleep(4000);
                    
                     fnSwitchToFrame();
                     fnSwitchToFrame(RenowalkModules.FrameActivity1_nm);
                    
                     // Select History Tab
                     ClickByXpath(RenowalkMain.TabHistoryTab_xp, "History Tab");
                     
                     Thread.sleep(10000);
                     fnSwitchToFrame(RenowalkMain.FrameHistory_id);
                     Thread.sleep(15000);
                    
                     int rowcountbasic=driver.findElements(By.xpath(RenowalkMain.TabHistorySummary_xp)).size();
                     boolean bActivityFound = false;
                     
                     for(int iPageLoop=0;iPageLoop<3;iPageLoop++)
                     {
	                      for(int i=2;i<rowcountbasic;i++) 
	                      {
                                     WebElement DescriptionAvailable=driver.findElement(By.xpath(RenowalkMain.TabHistorySummary_xp+"["+i+"]/td[4]"));
                                     
                                 if (DescriptionAvailable.getText().equalsIgnoreCase(Activity))
                                 {
                                	 bActivityFound = true;
                                     obj.repAddData("Activity History Details", "Activity History Details should be found", "Activity History Details is found for '" + Activity + "'", "Pass");
                                     ClickByXpath("//input[starts-with(@id,'history_summarytable:"+(i-2)+"')]", " '"+ Activity + "' Radiobutton is selected");
                                     Thread.sleep(5000);
                     
                                     int colcount1=(driver.findElements(By.xpath(RenowalkMain.TabHistoryDetail_xp+"/td")).size());
                                     String DescriptionDetArray[][]=
                                     
                      
                                     new String [2][colcount1];
                                     String sFinalValue1 = "";
                     
                                     for(int j=1;j<(colcount1+1);j++)
                                     {
                                        DescriptionDetArray[0][j-1]=  driver.findElement(By.xpath(RenowalkMain.TabHistoryDetail_xp+"[1]/th["+j+"]")).getText();
                                        DescriptionDetArray[1][j-1]= driver.findElement(By.xpath(RenowalkMain.TabHistoryDetail_xp+"[2]/td["+j+"]")).getText();
                                        sFinalValue1 =  "'" + sFinalValue1 + "''" + DescriptionDetArray[0][j-1].toString() + "': '" + DescriptionDetArray[1][j-1].toString() + "' "+",";
                                     }
                                     sFinalValue1 = sFinalValue1.substring(0, sFinalValue1.length()-1);
                                
                                     obj.repAddData("Activity History Details", "Activity History Details should be found", "Activity History Details is found as '" + sFinalValue1 + "'", "Pass");
                                    
                                     // Display Create Case History
                                     String sFinalValue2 = "";

                                     sFinalValue2 ="'" + sFinalValue2 + "' '" + driver.findElement(By.xpath(RenowalkMain.QueueName_xp)).getText().toString() + "': '" + driver.findElement(By.xpath(RenowalkMain.QueueValue_xp)).getText().toString() + "' "+", 'Notes Creation Date :" + driver.findElement(By.xpath(RenowalkMain.NotesCreationDate_xp)).getText().toString() + "', '" + driver.findElement(By.xpath(RenowalkMain.NotesText_xp)).getText().toString() + "' "+",";
                                     String Str1="", Str2="", Str3="", Str4="";
                                     for(int k=1;k<=4;k++)
                                     {
                                 
                                                try {
                                                                             Str1 = driver.findElement(By.xpath(RenowalkMain.CreateCaseLabel_xp+k+"]/td[1]")).getText().toString();
                                                                           
                                                }catch(Exception e){
                                                            Str1="";
                                                }
                                                try {
                                                             Str2 = driver.findElement(By.xpath(RenowalkMain.CreateCaseLabel_xp+k+"]/td[2]")).getText().toString();
                                                           
                                                }catch(Exception e){
                                                            Str2="";
                                                }
                                                                try {
                                                             Str3 = driver.findElement(By.xpath(RenowalkMain.CreateCaseLabel_xp+k+"]/td[3]")).getText().toString();
                                                                           
                                                }catch(Exception e){
                                                            Str3="";
                                                }
                                                                try {
                                                             Str4 = driver.findElement(By.xpath(RenowalkMain.CreateCaseLabel_xp+k+"]/td[4]")).getText().toString();
                                                                           
                                                }catch(Exception e){
                                                            Str4="";
                                                }
                                                sFinalValue2 = "'" + sFinalValue2 + "' '" + Str1 + "': '" + Str2 + "' "+"," + Str3 + "': '" + Str4 + "' "+",";
                                     }
                             
           
                             
                                 			sFinalValue2 = sFinalValue2.substring(0, sFinalValue2.length()-1);
                                
                                            obj.repAddData("Activity History Transaction Details", "Activity History Transaction Details should be found", "Activity History Transaction Details is found as '" + sFinalValue2 + "'", "Pass");
                                 
                                            break;
                                 }  //If condition ends
                                     
                             }//i row for loop ends
	                      
	                      if(bActivityFound == true)
	                      {
	                    	  break;
	                      }
	                      else
	                      {
	                    	  driver.findElement(By.xpath(RenowalkMain.HistoryNextLink_xp)).click();
	                    	  System.out.println("Click the Next button and again check for the activity : "+Activity);
	                    	  DriverScript.log.info("Click the Next button and again check for the activity : "+Activity);
	   
	                      }
	                      
                     	} //iPageLoop ends
                     
                     }//try ends 
                     catch (Exception e) {
                     System.out.println("History Transaction Verifiation --------------Failed");   
                   
                     }
                     }*/
	 
	/* public void fnSelectActiveActivity() throws Exception
     {
           System.out.println("In Select Active Activity");
           try {
                                   
		         fnSwitchToFrame();
		         String sCallType ="";
		         sCallType = driver.findElement(By.id(RenowalkMain.CallTypeTitle_id)).getText();
                                   
                 fnSwitchToFrame();
                 fnSwitchToFrame(RenowalkModules.FrameActivity1_nm);
                 WebElement rootElement = driver.findElement(By.id(RenowalkModules.CurrentActivitiesList_id));
                        
                 List<WebElement> webActivities = rootElement.findElements(By.tagName("li"));
                 //ArrayList<String> arrFrameNumber = fnGetIframeAscOrder(Activities.FrameProfileActivity_nm);
                 int iActivityFrameCount =0;
                 
                 for(int i =0 ; i <webActivities.size(); i++)
                 {
                                                                
                      fnSwitchToFrame();
                      fnSwitchToFrame(RenowalkModules.FrameActivity1_nm);
                      webActivities.get(i).click();
                      //Switch frame
                      fnSwitchToFrame();
                      fnSwitchToFrame(RenowalkModules.FrameActivity1_nm);
                      System.out.println(webActivities.get(i).getAttribute("class"));
                     
                      if(webActivities.get(i).getAttribute("class").equalsIgnoreCase("activityListItemActive"))
                      {
                          webActivities.get(i).click();
                      }
                      else
                      {
                          //System.out.println("Activity "+i+" already closed..");
                      }
      
                 }
               }catch (Exception e) {
                         System.out.println("fnSelectActiveActivity--------------Failed");
                         DriverScript.log.error("fnSelectActiveActivity--------------Failed",e);
                         ////throw(e);
               }
            
     }*/
	 
	 public void fnVerifyHeaders(List<WebElement> arrColumns, int iLoc, String sExpectedText) throws Exception

	 {
		try
		{
			if(arrColumns.get(iLoc).getText().equalsIgnoreCase(sExpectedText))
			{
				HighlightElement(arrColumns.get(iLoc));
				obj.repAddData( "Verify '"+sExpectedText+"' in the Header", "'"+sExpectedText+"' should be shown in the header", "'"+sExpectedText+"' shown successfully in the header", "Pass");
			}
			else
			{
				obj.repAddData( "Verify '"+sExpectedText+"' in the Header", "'"+sExpectedText+"' should be shown in the header", "'"+sExpectedText+"' not shown in the header", "Fail");
			}
			
			if(sExpectedText.equalsIgnoreCase("County") || sExpectedText.equalsIgnoreCase("Last Activity"))
			{
				WebElement ele = arrColumns.get(iLoc).findElement(By.xpath("./img[@src='images/sort-arrows.png']"));
				if(ele.isDisplayed())
				{
					HighlightElement(ele);
					obj.repAddData( "Verify 'Sort (Up and Down)' in the Header for '"+sExpectedText+"'", "'Sort (Up and Down)' should be shown in the header for '"+sExpectedText+"'", "'Sort (Up and Down)' shown successfully in the header for '"+sExpectedText+"'", "Pass");
				}
				else
				{
					obj.repAddData( "Verify 'Sort (Up and Down)' in the Header for '"+sExpectedText+"'", "'Sort (Up and Down)' should be shown in the header for '"+sExpectedText+"'", "'Sort (Up and Down)' not shown in the header for '"+sExpectedText+"'", "Fail");
				}
				
			}
		} catch (Exception e) {
	    System.out.println("fnVerifyHeaders --------------Failed");    
	    TestDriver.log.error("fnVerifyHeaders failed",e);
	    }
	 }
	 
	 public void fnLoadingPageWait() throws Exception

	 {
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,20);
			CheckId(RenowalkModules.Property_GenProp_ImagePageLoading_id,"'Loading...' icon",true);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(RenowalkModules.Property_GenProp_MsgPageLoading_id)));	 //Wait for loading message to disappear

		} catch (Exception e) {
	    System.out.println("fnLoadingPageWait --------------Failed");    
	    TestDriver.log.error("fnLoadingPageWait failed",e);
	    }
	 }
	 
	 public void fnVerifyDialogBox(String sActionType, int iVerifyType) throws Exception

	 {  ///sActionType = Add, Update ,Delete, OfficeCode
		 // iVerifyType = 0 for only text verification
		// iVerifyType = 1 for text verification and button click, applicable for OfficeCode only
		try
		{
			boolean bFlag = false;
			WebDriverWait wait = new WebDriverWait(driver,20);
						
			if(ElementFound(RenowalkModules.Common_AddModule_TextDialogBox) )
			{
					WebElement ele = driver.findElement(By.xpath(RenowalkModules.Common_AddModule_TextDialogBox));
					HighlightElement(ele);
					String sText = ele.getText().toString().trim();
					
					if(sActionType.equalsIgnoreCase("Add"))
					{
						if(sText.equalsIgnoreCase(AppMessages.Common_AddModule_DialogBox_msg))
						{
							bFlag = true;
						}
		
					}
					else if(sActionType.equalsIgnoreCase("Update"))
					{
						if(sText.equalsIgnoreCase(AppMessages.Common_UpdateModule_DialogBox_msg))
						{
							bFlag = true;
						}
		
					}
					else if(sActionType.equalsIgnoreCase("Delete"))
					{
						if(sText.equalsIgnoreCase(AppMessages.Common_DeleteModule_DialogBox_msg))
						{
							bFlag = true;
						}
		
					}
					else if(sActionType.equalsIgnoreCase("OfficeCode"))
					{
						if(sText.equalsIgnoreCase(AppMessages.Common_ViewModule_DialogBoxOfficeCode_msg))
						{
							bFlag = true;
						}
		
					}
					
					
					if(iVerifyType==1)
					{
						try {
							ClickByXpath(RenowalkModules.Common_AddModule_BtnDialogBox, "OK button", true);
						} catch (Exception e) {
							bFlag = false;
							System.out.println("OK button not displayed");
							obj.repAddData( "Click OK button",  "OK button should be clicked", "OK button not clicked", "Fail");
							e.printStackTrace();
							TestDriver.log.info("Dialog box OK click failed", e);
						}
					}
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(RenowalkModules.Common_AddModule_TextDialogBox)));	 //Wait for dialog message to disappear
					
					if(bFlag==true)
					{
						obj.repAddData( "Check '"+sActionType+"' Message", "'"+sActionType+"' message should be displayed properly","Correct message displayed as '"+sText+"'", "Pass");
					}
					else
					{
						obj.repAddData( "Check '"+sActionType+"' Message",  "'"+sActionType+"' message should be displayed properly", "Wrong message displayed as '"+sText+"'", "Fail");
					}
			}
			else
			{
				obj.repAddData( "Check '"+sActionType+"' Message", "'"+sActionType+"' message should be displayed properly","Dialog box not available", "Fail");
			}

		} catch (Exception e) {
	    System.out.println("fnVerifyDialogBox --------------Failed");    
	    TestDriver.log.error("fnVerifyDialogBox failed",e);
	    }
	 }
	 
	 
	 public void fnVerifyCancelForm(int iButton) throws Exception

	 {  
		 //iButton = 1 for Yes and 0 for No
		 try
		 {

			 WebDriverWait wait = new WebDriverWait(driver,20);
			 if(iButton == 1)
			 {
				 try {
					 ClickByXpath(RenowalkModules.Common_CancelModule_BtnYes, "YES button", true);
				 } catch (Exception e) {

					 obj.repAddData( "Click YES button",  "YES button should be clicked", "YES button not clicked", "Fail");
					 e.printStackTrace();
					 TestDriver.log.info("Dialog box Yes Button click failed", e);
				 }
			 }
			 else
			 {
				 try {
					 ClickByXpath(RenowalkModules.Common_CancelModule_BtnNo, "NO button", true);
				 } catch (Exception e) {

					 obj.repAddData( "Click NO button",  "NO button should be clicked", "NO button not clicked", "Fail");
					 e.printStackTrace();
					 TestDriver.log.info("Dialog box NO Button click failed", e);
				 }

			 }

			 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(RenowalkModules.Common_CancelModule_TextDialogBox)));	 //Wait for dialog message to disappear



		 } catch (Exception e) {
			 TestDriver.log.error("fnVerifyDialogBox failed",e);
		 }
	 }
	 
	 
	 
	 public void fnCheckSortedList(HashMap<Integer, HashMap<Integer, String>> mTableData, String sColumnName, int iColNum) throws Exception

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
			
			for(int i=0; i<mTableData.size();i++)
			{
				arrInitialList.add(mTableData.get(i+1).get(iColNum).toString().replaceAll("_", "").toUpperCase());
			}
				
		    Collections.sort(arrInitialList);
			
			arrExpSortedList = arrInitialList; //Expected value after sorting
			
			for(int i=0; i<mTableData.size();i++)
			{
					arrActSortedList.add(mTableData.get(i+1).get(iColNum).toString().toUpperCase());  //Actual value without sorting
			}
			
			System.out.println("Expected Sorting Done");
		
			if(arrActSortedList.equals(arrExpSortedList))
			{
				obj.repAddData( "Verify Sorting on '"+sColumnName+"' column", "'"+sColumnName+"' values should be sorted in ascending order", "'"+sColumnName+"' values are sorted in ascending order", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Sorting on '"+sColumnName+"' column", "'"+sColumnName+"' values should be sorted in ascending order", "'"+sColumnName+"' values are not sorted in ascending order", "Fail");
			}
		
			////////////////////Sorting Logic End////////////////////////////
		} catch (Exception e) {
	    System.out.println("fnCheckSorting --------------Failed");    
	    TestDriver.log.error("fnCheckSorting failed",e);
	    }
	 }
	 
	 public void fnCheckSorting(String sTableXPath, String sColumnName, int iColNum) throws Exception

	 {
		try
		{
			////////////////////Sorting Logic////////////////////////////
			List<WebElement> arrTBodies = driver.findElements(By.xpath(sTableXPath));
			List<WebElement> arrColumns = arrTBodies.get(0).findElements(By.xpath("./tr/th"));  //Get the header
			
			List<String> arrInitialList = new ArrayList<String>();
			List<String> arrExpSortedList = new ArrayList<String>();
			List<String> arrActSortedList = new ArrayList<String>();
			
			arrInitialList.clear();
			arrExpSortedList.clear();
			arrActSortedList.clear();
			
			for(int iRec=1;iRec<arrTBodies.size();iRec++)
			{
				arrInitialList.add(arrTBodies.get(iRec).findElement(By.xpath("./tr/td["+iColNum+"]")).getText().trim().toUpperCase());
				
			}
			
			Collections.sort(arrInitialList);
/*			if(sColumnName.equalsIgnoreCase("Last Activity"))  // On clicking last activity sort, it first get in descending order 
			{
				Collections.reverse(arrInitialList); 
			}*/

			arrExpSortedList = arrInitialList;
			System.out.println("Initial Expected Sorting Done");
			
			WebElement eleCountySortBtn = arrColumns.get(iColNum-1).findElement(By.xpath(RenowalkModules.Common_BtnSorting_xp));
			eleCountySortBtn.click();
			fnLoadingPageWait();
			
			arrTBodies = driver.findElements(By.xpath(sTableXPath));
			for(int iRec=1;iRec<arrTBodies.size();iRec++)
			{
				arrActSortedList.add(arrTBodies.get(iRec).findElement(By.xpath("./tr/td["+iColNum+"]")).getText().trim().toUpperCase());
				
			}
			System.out.println("Sorted List Done");
			if(arrActSortedList.equals(arrExpSortedList))
			{
				obj.repAddData( "Verify Sorting on '"+sColumnName+"' column", "'"+sColumnName+"' values should be sorted in ascending order", "'"+sColumnName+"' values are sorted in ascending order", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Sorting on '"+sColumnName+"' column", "'"+sColumnName+"' values should be sorted in ascending order", "'"+sColumnName+"' values are not sorted in ascending order", "Fail");
			}
			
			Collections.reverse(arrExpSortedList);
			arrColumns = arrTBodies.get(0).findElements(By.xpath("./tr/th"));
			eleCountySortBtn = arrColumns.get(iColNum-1).findElement(By.xpath(RenowalkModules.Common_BtnSorting_xp));
			eleCountySortBtn.click();
			fnLoadingPageWait();
			
			arrTBodies = driver.findElements(By.xpath(sTableXPath));
			arrActSortedList.clear();
			for(int iRec=1;iRec<arrTBodies.size();iRec++)
			{
				arrActSortedList.add(arrTBodies.get(iRec).findElement(By.xpath("./tr/td["+iColNum+"]")).getText().trim().toUpperCase());
				
			}
			System.out.println("Sorted List Done");
			if(arrActSortedList.equals(arrExpSortedList))
			{
				obj.repAddData( "Verify Sorting on '"+sColumnName+"' column", "'"+sColumnName+"' values should be sorted in descending order", "'"+sColumnName+"' values are sorted in descending order", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Sor	ting on '"+sColumnName+"' column", "'"+sColumnName+"' values should be sorted in descending order", "'"+sColumnName+"' values are not sorted in descending order", "Fail");
			}
			////////////////////Sorting Logic End////////////////////////////
		} catch (Exception e) {
	    System.out.println("fnCheckSorting --------------Failed");    
	    TestDriver.log.error("fnCheckSorting failed",e);
	    }
	 }
	 
	 //Checks for buttons under specified headers
	 public void fnCheckButtonsUnderHeader(String sHeaderXPath, List<String> arrButtons, String sHeaderName, boolean bReportFlag ) throws Exception
	 //add option to check if verified...
	 {
		try
		{

			//Find the header
			WebElement eleHeader = driver.findElement(By.xpath(sHeaderXPath));
			
			WebElement eleParent = eleHeader.findElement(By.xpath("..")).findElement(By.xpath(".."));
			
			System.out.println(eleParent.getText());

			System.out.println("ASDFASDFASDFAsd");
			
			List<WebElement> arrButtonActual  = eleParent.findElements(By.xpath("./button"));
			
			
			List<String> arrButtonInputs = new ArrayList<String>();
			List<String> arrButtonLabels = new ArrayList<String>();
			arrButtonLabels.clear();
			arrButtonInputs.clear();
			
			//Create array of button labels from the app
			for(int iRec=0;iRec<arrButtons.size();iRec++)
			{
				arrButtonInputs.add(driver.findElement(By.xpath(arrButtons.get(iRec))).getText());
				System.out.println(driver.findElement(By.xpath(arrButtons.get(iRec))).getText());
				System.out.println(iRec);
				//System.out.println(arrButtonActual.size());
				arrButtonLabels.add(arrButtonActual.get(iRec).getText());
				System.out.println(arrButtonLabels.get(iRec));
			}
				
		
			if(arrButtonInputs.equals(arrButtonLabels))
			{
				obj.repAddData( "Verify Buttons under '"+sHeaderName+"' Header", "'"+sHeaderName+"'", "'"+sHeaderName+"' Buttons are correct", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Buttons under '"+sHeaderName+"' Header", "'"+sHeaderName+"'", "'"+sHeaderName+"' Buttons are incorrect or missing", "Fail");
			}
			

		} catch (Exception e) {
	    System.out.println("fnCheckButtonsUnderHeader --------------Failed");    
	    TestDriver.log.error("fnCheckButtonsUnderHeader failed",e);
	    }
	 }
	 
	 
	 
	 
	 
	 
	 public void fnCheckDateSorting(HashMap<Integer, HashMap<Integer, String>> mTableData, String sColumnName, int iColNum, String sSortType) throws Exception

	 {
		try
		{  //sSortType can be DEFAULT, ASC , DESC
			////////////////////Sorting Logic////////////////////////////
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");

			List<Date> arrInitialList = new ArrayList<Date>();
			List<Date> arrExpSortedList = new ArrayList<Date>();
			List<Date> arrActSortedList = new ArrayList<Date>();
			//List<Date> arrTempList = new ArrayList<Date>();
						
			arrInitialList.clear();
			arrExpSortedList.clear();
			arrActSortedList.clear();
			arrActSortedList.clear();
			
			for(int i=0; i<mTableData.size();i++)
			{
				String sExpLastActivity = mTableData.get(i+1).get(iColNum).toString().trim();
				Date dtExpLastActivity = formatter.parse(sExpLastActivity);
				System.out.println(dtExpLastActivity);
				arrInitialList.add(dtExpLastActivity);
			}
			
			arrActSortedList = arrInitialList;
			
			Collections.sort(arrInitialList);
			if(sSortType.equalsIgnoreCase("DEFAULT") || sSortType.equalsIgnoreCase("ASC"))
			{
				if(sColumnName.equalsIgnoreCase("Last Activity"))  // On clicking last activity sort, it first get in descending order 
				{
					Collections.reverse(arrInitialList); 
				}
				
				arrExpSortedList = arrInitialList;  //In sorted descending order
				
				if(arrExpSortedList.equals(arrActSortedList))
				{
					obj.repAddData( "Verify Default Sorting on '"+sColumnName+"' column", "'"+sColumnName+"' values should be sorted in descending order", "'"+sColumnName+"' values are sorted in descending order", "Pass");
				}
				else
				{
					obj.repAddData( "Verify Default Sorting on '"+sColumnName+"' column", "'"+sColumnName+"' values should be sorted in descending order", "'"+sColumnName+"' values are not sorted in descending order", "Fail");
				}
			}
			else if(sSortType.equalsIgnoreCase("ASC"))
			{
				arrExpSortedList = arrInitialList;
				
				if(arrExpSortedList.equals(arrActSortedList))
				{
					obj.repAddData( "Verify Sorting on '"+sColumnName+"' column", "'"+sColumnName+"' values should be sorted in ascending order", "'"+sColumnName+"' values are sorted in ascending order", "Pass");
				}
				else
				{
					obj.repAddData( "Verify Sor	ting on '"+sColumnName+"' column", "'"+sColumnName+"' values should be sorted in ascending order", "'"+sColumnName+"' values are not sorted in ascending order", "Fail");
				}
			}
			////////////////////Sorting Logic End////////////////////////////
		} catch (Exception e) {
	    System.out.println("fnCheckDateSorting --------------Failed");    
	    TestDriver.log.error("fnCheckDateSorting failed",e);
	    }
	 }
	 
	 
	 public void fnCheckDateSorting_old(String sTableXPath, String sColumnName, int iColNum, String sSortType) throws Exception

	 {
		try
		{  //sSortType can be DEFAULT, ASC , DESC
			////////////////////Sorting Logic////////////////////////////
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
			
			WebElement eleTable = driver.findElement(By.xpath(sTableXPath));
			List<WebElement> arrColumns = eleTable.findElements(By.xpath("./thead/tr/th"));  //Get the header
			List<WebElement> arrTBodies = eleTable.findElements(By.xpath("./tbody/tr"));
			WebElement eleCountySortBtn;
			
			List<Date> arrInitialList = new ArrayList<Date>();
			List<Date> arrExpSortedList = new ArrayList<Date>();
			List<Date> arrActSortedList = new ArrayList<Date>();
			List<Date> arrTempList = new ArrayList<Date>();
			
			arrInitialList.clear();
			arrExpSortedList.clear();
			arrActSortedList.clear();
			
			for(int iRec=1;iRec<arrTBodies.size();iRec++)
			{
				String sExpLastActivity = arrTBodies.get(iRec).findElement(By.xpath("./td["+iColNum+"]")).getText().trim();
				System.out.println(sExpLastActivity);
				Date dtExpLastActivity = formatter.parse(sExpLastActivity);
				System.out.println(dtExpLastActivity);
				arrInitialList.add(dtExpLastActivity);
			}
			
			arrTempList = arrInitialList;
			
			Collections.sort(arrInitialList);
			if(sSortType.equalsIgnoreCase("DEFAULT"))
			{
				if(sColumnName.equalsIgnoreCase("Last Activity"))  // On clicking last activity sort, it first get in descending order 
				{
					Collections.reverse(arrInitialList); 
				}
				
				arrExpSortedList = arrInitialList;  //In sorted descending order
				
				if(arrExpSortedList.equals(arrTempList))
				{
					obj.repAddData( "Verify Default Sorting on '"+sColumnName+"' column", "'"+sColumnName+"' values should be sorted in descending order", "'"+sColumnName+"' values are sorted in descending order", "Pass");
				}
				else
				{
					obj.repAddData( "Verify Default Sorting on '"+sColumnName+"' column", "'"+sColumnName+"' values should be sorted in descending order", "'"+sColumnName+"' values are not sorted in descending order", "Fail");
				}
			}
			//System.out.println("Initial Expected Sorting Done");
			
			else if(sSortType.equalsIgnoreCase("DESC"))
			{
				eleCountySortBtn = arrColumns.get(iColNum-1).findElement(By.xpath(RenowalkModules.Common_BtnSorting_xp));
				//eleCountySortBtn.click();
				ClickByElement(eleCountySortBtn,"'Sort Icon'",true);
				fnLoadingPageWait();
				
				arrTBodies = driver.findElements(By.xpath(sTableXPath));
				for(int iRec=1;iRec<arrTBodies.size();iRec++)
				{
					String sActLastActivity = arrTBodies.get(iRec).findElement(By.xpath("./tr/td["+iColNum+"]")).getText().trim();
					System.out.println(sActLastActivity);
					Date dtActLastActivity = formatter.parse(sActLastActivity);
					System.out.println(dtActLastActivity);
					arrActSortedList.add(dtActLastActivity);
					
				}
				System.out.println("Sorted List Done");
				if(arrActSortedList.equals(arrExpSortedList))
				{
					obj.repAddData( "Verify Sorting on '"+sColumnName+"' column", "'"+sColumnName+"' values should be sorted in descending order", "'"+sColumnName+"' values are sorted in descending order", "Pass");
				}
				else
				{
					obj.repAddData( "Verify Sorting on '"+sColumnName+"' column", "'"+sColumnName+"' values should be sorted in descending order", "'"+sColumnName+"' values are not sorted in descending order", "Fail");
				}
			}
			else if(sSortType.equalsIgnoreCase("ASC"))
			{
				Collections.reverse(arrExpSortedList);
				arrColumns = arrTBodies.get(0).findElements(By.xpath("./tr/th"));
				eleCountySortBtn = arrColumns.get(iColNum-1).findElement(By.xpath(RenowalkModules.Common_BtnSorting_xp));
				//eleCountySortBtn.click();
				ClickByElement(eleCountySortBtn,"'Sort Icon'",true);
				fnLoadingPageWait();
				
				arrTBodies = driver.findElements(By.xpath(sTableXPath));
				arrActSortedList.clear();
				for(int iRec=1;iRec<arrTBodies.size();iRec++)
				{
					String sActLastActivity = arrTBodies.get(iRec).findElement(By.xpath("./tr/td["+iColNum+"]")).getText().trim();
					System.out.println(sActLastActivity);
					Date dtActLastActivity = formatter.parse(sActLastActivity);
					System.out.println(dtActLastActivity);
					arrActSortedList.add(dtActLastActivity);
					
				}
				System.out.println("Sorted List Done");
				if(arrActSortedList.equals(arrExpSortedList))
				{
					obj.repAddData( "Verify Sorting on '"+sColumnName+"' column", "'"+sColumnName+"' values should be sorted in ascending order", "'"+sColumnName+"' values are sorted in ascending order", "Pass");
				}
				else
				{
					obj.repAddData( "Verify Sor	ting on '"+sColumnName+"' column", "'"+sColumnName+"' values should be sorted in ascending order", "'"+sColumnName+"' values are not sorted in ascending order", "Fail");
				}
			}
			////////////////////Sorting Logic End////////////////////////////
		} catch (Exception e) {
	    System.out.println("fnCheckDateSorting --------------Failed");    
	    TestDriver.log.error("fnCheckDateSorting failed",e);
	    }
	 }
	 
	 public void fnVerifyComboBoxValues(List<WebElement> arrPageSize, int iLoc, String sValue) throws Exception

	 {
		try
		{
			if(arrPageSize.get(iLoc).getText().toString().trim().equalsIgnoreCase(sValue))
			{
				obj.repAddData( "Verify Page Size Combo box for value '"+sValue+"'", "'"+sValue+"' value should be shown in the Page Size Combo box", "'"+sValue+"' is shown in the Page Size Combo box", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Page Size Combo box for value '"+sValue+"'", "'"+sValue+"' value should be shown in the Page Size Combo box", "'"+sValue+"' is not shown in the Page Size Combo box", "Fail");
			}
			
		} catch (Exception e) {
	    System.out.println("fnVerifyComboBoxValues --------------Failed");    
	    TestDriver.log.error("fnVerifyComboBoxValues failed",e);
	    }
	 }
	 
	 
	 public HashMap<Integer, HashMap<Integer, String>> fnGetTableData(String sTablePath, String sModuleName) throws Exception

	 {
		 HashMap<Integer, HashMap<Integer, String>> mTableData = new HashMap<Integer,HashMap<Integer, String>>();
		try
		{
			WebElement eleTable = driver.findElement(By.xpath(sTablePath));
			List<WebElement> arrTableRows = eleTable.findElements(By.xpath("./tbody/tr"));  //Get the table data rows
			System.out.println("Data Rows Size>>>>"+arrTableRows.size());
			
			for(int iRow=0;iRow<arrTableRows.size();iRow++)
			{	
				//arrTableData.clear();
				String sColValue=null;
				mTableData.put(iRow+1, new HashMap<Integer, String>());  //Map row starts with 1
				
				List<WebElement> arrTableColumns = arrTableRows.get(iRow).findElements(By.xpath("./td"));  //Get the table data rows
				for(int iCol=0;iCol<arrTableColumns.size();iCol++)
				{
					List<WebElement> arrEditDelete;	
					List<WebElement> arrCopyEditDelete;	
					
					if(sModuleName.equalsIgnoreCase("Offices"))
					{
						switch (iCol) 
						{
							case 0: 
									sColValue = arrTableColumns.get(iCol).findElement(By.xpath("./b")).getText();//.toString();
									//sColValue = arrTableColumns.get(iCol).findElement(By.xpath("./b")).getAttribute("innerText");
									break;
							case 1: 
									sColValue = arrTableColumns.get(iCol).getText().toString();
									break;
							case 2: 
									arrEditDelete = arrTableColumns.get(iCol).findElements(By.xpath("./div/span"));
									String sEdit  = arrEditDelete.get(0).getAttribute("title");
									String sDelete = arrEditDelete.get(1).getAttribute("title");
									//System.out.println(sEdit+sDelete);
									sColValue= sEdit+";;"+sDelete;
									break;
						}
					}
					else if(sModuleName.equalsIgnoreCase("Corporations") || sModuleName.equalsIgnoreCase("Regions")) 
					{
						switch (iCol) 
						{
							case 0: 
									sColValue = arrTableColumns.get(iCol).findElement(By.xpath("./b")).getText();//.toString();
									//sColValue = arrTableColumns.get(iCol).findElement(By.xpath("./b")).getAttribute("innerText");  //For Chrome, not supported in  FF
									break;
							case 1: 
									arrEditDelete = arrTableColumns.get(iCol).findElements(By.xpath("./div/span"));
									String sEdit  = arrEditDelete.get(0).getAttribute("title");
									String sDelete = arrEditDelete.get(1).getAttribute("title");
									//System.out.println(sEdit+sDelete);
									sColValue= sEdit+";;"+sDelete;
									break;
						}
					}
					else if(sModuleName.equalsIgnoreCase("Property")) 
					{
						switch (iCol) 
						{
							case 1: 
									sColValue = arrTableColumns.get(iCol).findElement(By.xpath("./b")).getText();//.toString();
									//sColValue = arrTableColumns.get(iCol).findElement(By.xpath("./b")).getAttribute("innerText");  //For Chrome, not supported in  FF
									break;
							case 0: case 2: case 3: case 4: case 5: case 6:
								    sColValue = arrTableColumns.get(iCol).getText().toString();
							        break;
							case 7: 
									arrEditDelete = arrTableColumns.get(iCol).findElements(By.xpath("./div/span"));
									String sEdit  = arrEditDelete.get(0).getAttribute("title");
									String sDelete = arrEditDelete.get(1).getAttribute("title");
									//System.out.println(sEdit+sDelete);
									sColValue= sEdit+";;"+sDelete;
									break;
						}
					}
					
					else if(sModuleName.equalsIgnoreCase("Items")) 
					{
						switch (iCol) 
						{
							case 0: 
									sColValue = arrTableColumns.get(iCol).findElement(By.xpath("./b")).getText();//.toString();
									//sColValue = arrTableColumns.get(iCol).findElement(By.xpath("./b")).getAttribute("innerText");  //For Chrome, not supported in  FF
									break;
							case 1: case 2: case 3: case 4: case 5:
								    sColValue = arrTableColumns.get(iCol).getText().toString();
							        break;
							case 6: 
									arrCopyEditDelete = arrTableColumns.get(iCol).findElements(By.xpath("./div/span"));
									String sCopy  = arrCopyEditDelete.get(0).getAttribute("title");
									String sEdit = arrCopyEditDelete.get(1).getAttribute("title");
									String sDelete = arrCopyEditDelete.get(2).getAttribute("title");
									//System.out.println(sEdit+sDelete);
									sColValue= sCopy+";;"+sEdit+";;"+sDelete;
									break;
							case 7	: 
								    String sCheckbox = arrTableColumns.get(iCol).findElement(By.xpath("./input")).getAttribute("type");
								    sColValue = sCheckbox;
						}
					}
					
					else if(sModuleName.equalsIgnoreCase("Groups")) 
					{
						switch (iCol) 
						{
							case 0: 
									sColValue = arrTableColumns.get(iCol).findElement(By.xpath("./b")).getText();//.toString();
									//sColValue = arrTableColumns.get(iCol).findElement(By.xpath("./b")).getAttribute("innerText");  //For Chrome, not supported in  FF
									break;
							case 1: case 2: case 3: case 4:
								    sColValue = arrTableColumns.get(iCol).getText().toString();
							        break;
							case 5: 
									arrCopyEditDelete = arrTableColumns.get(iCol).findElements(By.xpath("./div/span"));
									String sCopy  = arrCopyEditDelete.get(0).getAttribute("title");
									String sEdit = arrCopyEditDelete.get(1).getAttribute("title");
									String sDelete = arrCopyEditDelete.get(2).getAttribute("title");
									//System.out.println(sEdit+sDelete);
									sColValue= sCopy+";;"+sEdit+";;"+sDelete;
									break;
							case 6	: 
								    String sCheckbox = arrTableColumns.get(iCol).findElement(By.xpath("./input")).getAttribute("type");
								    sColValue = sCheckbox;
						}
					}
					
					

					mTableData.get(iRow+1).put(iCol+1,sColValue);
				}
				

			}
			
		} catch (Exception e) {
	    System.out.println("fnGetTableData --------------Failed");    
	    TestDriver.log.error("fnGetTableData failed",e);
	    }
		
		return mTableData;
	 }
	 
	 
	 
	 
	 
	 
	 public boolean fnCheckFieldDisplayById(String sLocator, String sReportText, boolean bReportFlag, boolean bScenarioFlag) throws Exception 
		{
		 	boolean bElementFound = false;
			try {
				WebElement ele;
				ele = driver.findElement(By.id(sLocator));
				String sText = "";
								
				if(bReportFlag==true)
				{	
					if(bScenarioFlag==true)
					{
						if(ele.isDisplayed())
						{
							HighlightElementById(sLocator);
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
				System.out.println("fnCheckFieldDisplayById --------------Failed");  
				 TestDriver.log.error("fnCheckFieldDisplayById failed",e);
				throw(e);
			}
			return bElementFound;
		}
	 
	 public boolean fnCheckFieldDisplayByName(String sLocator, String sReportText, boolean bReportFlag, boolean bScenarioFlag) throws Exception 
		{
		 	boolean bElementFound = false;
			try {
				WebElement ele;
				ele = driver.findElement(By.name(sLocator));
				String sText = "";
								
				if(bReportFlag==true)
				{	
					if(bScenarioFlag==true)
					{
						if(ele.isDisplayed())
						{
							HighlightElementByName(sLocator);
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
				System.out.println("fnCheckFieldDisplayByName --------------Failed");  
				 TestDriver.log.error("fnCheckFieldDisplayByName failed",e);
				throw(e);
			}
			return bElementFound;
		}
	 
	 public boolean fnCheckFieldDisplayByXpath(String sLocator, String sReportText, boolean bReportFlag, boolean bScenarioFlag) throws Exception 
		{
		 	boolean bElementFound = false;
			try {
				WebElement ele;
				ele = driver.findElement(By.xpath(sLocator));
				String sText = "";
				
				if(bReportFlag==true)
				{	
					if(bScenarioFlag==true)
					{
						if(ele.isDisplayed())
						{   
							HighlightElementByXpath(sLocator);			//test and see nothing breaks	
							bElementFound = true;
							if(sLocator.contains("select"))
							{
								sText = driver.findElement(By.xpath(sLocator)).getAttribute("name");
							}
							else
							{
								sText = ele.getText().trim();
							}
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
				System.out.println("fnCheckFieldDisplayByXpath --------------Failed");  
				 TestDriver.log.error("fnCheckFieldDisplayByXpath failed",e);
				throw(e);
			}
			return bElementFound;
		}
	 
	 
	 
	 public boolean fnCheckFieldDoesNotExistByXpath(String sLocator, String sReportText, boolean bReportFlag) throws Exception 
		{
		 	boolean bElementFound = false;
			try {
				WebElement ele;
				//ele = driver.findElement(By.xpath(sLocator));
				
				if(bReportFlag==true)
				{	
						if(driver.findElements(By.xpath(sLocator)).size() < 1)
						{   bElementFound = true;
							obj.repAddData( "Verify "+sReportText, sReportText+" should not be shown", sReportText+" not shown on the screen", "Pass");
							
						}
						else
						{
							obj.repAddData( "Verify "+sReportText, sReportText+" should not be shown", sReportText+" shown on the screen", "Fail");
						}
				}
				else
				{
					if(driver.findElements(By.xpath(sLocator)).size() < 1)
					{
						bElementFound = true;
					}
					else
					{
						bElementFound = false;
					}
				}
					
			} catch (Exception e) {
				System.out.println("fnCheckFieldDoesNotExistByXpath --------------Failed");  
				 TestDriver.log.error("fnCheckFieldDoesNotExistByXpath failed",e);
				throw(e);
			}
			return bElementFound;
		}
	 
	 
	 
	 public void fnVerifyNumofRecords(String sPageOption) throws Exception 
		{
		 	boolean bElementFound = false;
			try {
				WebElement eleTable = driver.findElement(By.xpath(RenowalkModules.Common_ViewModules_Table_xp));
				List<WebElement> arrTableRows = eleTable.findElements(By.xpath("./tbody/tr"));  //Get the table data rows
				System.out.println("Data Rows Size>>>>"+arrTableRows.size());
				String sTotalPages = "";
				if(driver.findElement(By.xpath(RenowalkModules.Common_ViewModules_InputPageNum_xp)).isDisplayed())
				{
					sTotalPages = fnGetGUITextXpath(RenowalkModules.Common_ViewModules_LabelTotalPages_xp);
				}
				
				if(arrTableRows.size()==Integer.parseInt(sPageOption))
				{
					obj.repAddData( "Verify No of Records for Option '"+sPageOption+" PER PAGE'", sPageOption+" records should be shown", arrTableRows.size()+" records shown successfully", "Pass");

				}
				else if(arrTableRows.size()<Integer.parseInt(sPageOption))
				{
					//bElementFound = fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",true,false);
					bElementFound = fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",false,true);
					if(bElementFound==true && !sTotalPages.equalsIgnoreCase(""))  //for last page having less records
					{
						obj.repAddData( "Verify No of Records for Option '"+sPageOption+" PER PAGE'", sPageOption+" or less records should be shown", arrTableRows.size()+" records shown successfully", "Pass");
					}
					else if(bElementFound==false && sTotalPages.equalsIgnoreCase(""))  //for first page having less records
					{
						obj.repAddData( "Verify No of Records for Option '"+sPageOption+" PER PAGE'", sPageOption+" or less records should be shown", arrTableRows.size()+" records shown successfully", "Pass");
					}
					else
					{
						obj.repAddData( "Verify No of Records for Option '"+sPageOption+" PER PAGE'", sPageOption+" or less records should be shown", arrTableRows.size()+" records shown but pagination is still present", "Fail");
					}
				}
				else
				{
					obj.repAddData( "Verify No of Records for Option '"+sPageOption+" PER PAGE'", sPageOption+" or less  records should be shown", sPageOption+" or less  records not shown", "Fail");
				}
					
			} catch (Exception e) {
				System.out.println("fnVerifyNumofRecords --------------Failed");  
				 TestDriver.log.error("fnVerifyNumofRecords failed",e);
				throw(e);
			}
		}
	 
	 public void fnCheckEnableByXPath(String sLocator, String sControlName) throws Exception 
		{
			try {
				WebElement eleTable = driver.findElement(By.xpath(sLocator));
				
				if(eleTable.isEnabled())
				{
					obj.repAddData( "Verify "+sControlName, sControlName+" should be enabled", sControlName+" is enabled", "Pass");
				}
				else
				{
					obj.repAddData( "Verify "+sControlName, sControlName+" should be enabled", sControlName+" is not enabled", "Fail");
				}
					
			} catch (Exception e) {
				System.out.println("fnCheckEnableByXPath --------------Failed");  
				 TestDriver.log.error("fnCheckEnableByXPath failed",e);
				throw(e);
			}
		}
	 
	 public void fnCheckDisbleByXPath(String sLocator, String sControlName) throws Exception 
		{
			try {
				WebElement eleTable = driver.findElement(By.xpath(sLocator));
				
				if(!eleTable.isEnabled())
				{
					obj.repAddData( "Verify "+sControlName, sControlName+" should be disabled", sControlName+" is disabled", "Pass");
				}
				else
				{
					obj.repAddData( "Verify "+sControlName, sControlName+" should be disabled", sControlName+" is not disabled", "Fail");
				}
					
			} catch (Exception e) {
				System.out.println("fnCheckDisbleByXPath --------------Failed");  
				 TestDriver.log.error("fnCheckDisbleByXPath failed",e);
				throw(e);
			}
		}
	 
	 public int fnGetTableRowsCount(String sLocator) throws Exception 
		{
		 	int iRows = 0;
			try {
				WebElement eleTable = driver.findElement(By.xpath(sLocator));
				List<WebElement> arrTableRows = eleTable.findElements(By.xpath("./tbody/tr"));  //Get the table data rows
				iRows = arrTableRows.size();
				System.out.println("Data Rows Size>>>>"+arrTableRows.size());
					
			} catch (Exception e) {
				System.out.println("fnGetTableRowsCount --------------Failed");  
				 TestDriver.log.error("fnGetTableRowsCount failed",e);
				throw(e);
			}
			return iRows;
		}
	 
		public void fnVerifyComboBoxValue(String SelectValue, String TextValue) throws Exception
		{
			try {
				
				boolean bFlag = false;
				WebElement select = driver.findElement(By.xpath(SelectValue));
				if(select.isDisplayed())
				{
					HighlightElementByXpath(SelectValue);
					List<WebElement> options = select.findElements(By.tagName("option"));
					for (WebElement option : options)
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
				System.out.println("fnVerifyComboBoxValue--------------Failed");
				TestDriver.log.error("fnVerifyComboBoxValue--------------Failed", e);
				//throw(e);
			}	
		}
		
		
		 public void fnCheckComboBoxSorting(String sComboBoxLocator, String sFieldName, String sDefaultValue) throws Exception

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
				
				WebElement select = driver.findElement(By.xpath(sComboBoxLocator));
				
				if(select.isDisplayed())
				{
					HighlightElementByXpath(sComboBoxLocator);
					List<WebElement> options = select.findElements(By.tagName("option"));
					for (WebElement option : options)
					{
						
						System.out.println(option.getText().toString().trim());
						
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
		    System.out.println("fnCheckComboBoxSorting --------------Failed");    
		    TestDriver.log.error("fnCheckComboBoxSorting failed",e);
		    }
		 }
		 
		 
		 public void fnCheckDropDownSorting(String sDropDownLocator, String sFieldName, String sDefaultValue) throws Exception

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
				
				//WebElement select = driver.findElement(By.xpath(sDropDownLocator));
				
				
				
				WebElement eleCorpList = driver.findElement(By.xpath(sDropDownLocator));

				List<WebElement> arrCorpList = eleCorpList.findElements(By.xpath("./li"));  //Get the table data rows
				System.out.println("Data Rows Size>>>>"+arrCorpList.size());

				for(WebElement eleCorp : arrCorpList)
				{
					String sCorpName = eleCorp.findElement(By.xpath("./div")).getText();
					if(!sCorpName.equalsIgnoreCase(sDefaultValue))
					{
						System.out.println(sCorpName.trim().toUpperCase());
						arrInitialList.add(sCorpName.trim().toUpperCase());
						arrActSortedList.add(sCorpName.trim().toUpperCase());
					}

				}
				
				Collections.sort(arrInitialList);
				
				
				
				
				

				arrExpSortedList = arrInitialList;
				
				System.out.println(arrExpSortedList);
				System.out.println(arrActSortedList);
				
				
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
		    System.out.println("fnCheckComboBoxSorting --------------Failed");    
		    TestDriver.log.error("fnCheckComboBoxSorting failed",e);
		    }
		 }
		 
		 //bxk8854
		 /*
		  * Method to verify if the check box is selected
		  */
		 public void fnCheckSelectedCheckBoxByXPath(String sLocator, String checkBoxName) throws Exception 
		 {
			 try {
				 WebElement checkBox = driver.findElement(By.xpath(sLocator));
				 boolean isChecked = false;				 
				 isChecked = checkBox.findElement(By.xpath(sLocator)).isSelected();
				 HighlightElementByXpath(sLocator);
				 if(isChecked == true)
				 {
					 obj.repAddData( "Verify "+checkBoxName+" should be selected", checkBoxName+" is selected", checkBoxName+" is selected", "Pass");
				 }
				 else
				 {
					 obj.repAddData( "Verify "+checkBoxName+" should be selected", checkBoxName+" is not selected", checkBoxName+" is not selected", "Fail");
				 }

			 } catch (Exception e) {
				 System.out.println("fnCheckEnableByXPath --------------Failed");  
				 TestDriver.log.error("fnCheckEnableByXPath failed",e);
				 throw(e);
			 }
		 }
		 
		 
		 
		 
		 public void fnSelectCorpOffice_old(String sCorp, String sOffice) throws Exception

		 {
			try
			{
				fnSelectFromComboBoxXpath(RenowalkModules.Common_AllModules_ComboCorporateName_xp,sCorp);

			    if(ElementFound(RenowalkModules.Common_AllModules_ComboOfficeCode_xp)) 
			    {
				    WebDriverWait waitForOfficeCode = new WebDriverWait(driver, 5);
				    waitForOfficeCode.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RenowalkModules.Common_AllModules_ComboOfficeCode_xp)));

				    fnSelectFromComboBoxXpath(RenowalkModules.Common_AllModules_ComboOfficeCode_xp, sOffice);
			    }
			} catch (Exception e) {
		    System.out.println("fnSelectCorpOffice --------------Failed");    
		    TestDriver.log.error("fnSelectCorpOffice failed",e);
		    }
		 }
		 
		 public void fnSelectCorpOffice(String sCorp, String sOffice) throws Exception

		 {
			try
			{
				//fnSelectFromComboBoxXpath(RenowalkModules.Common_AllModules_ComboCorporateName_xp,sCorp);
				String sDeafaultValue = driver.findElement(By.xpath("//*[@id='corporationSelect']/div")).getText();
				System.out.println("ddfdsf>>>>>>>>>"+sDeafaultValue+"<<<<<<<<<<<<ghfdghgf");
				if(sDeafaultValue.trim().equalsIgnoreCase("Select") || sCorp.equalsIgnoreCase("Select"))
				{
					ClickById("corporationSelect", "Corporation Drop-down", false);
					//WebElement eleCorpList = driver.findElement(By.xpath("//ul[@class='dropdown-menu contextSelect corporationSelect ng-isolate-scope' and @aria-labelledby='dropdownMenu1']"));
					WebElement eleCorpList = driver.findElement(By.xpath(RenowalkModules.Common_AllModules_ComboCorporateName_xp));

					List<WebElement> arrCorpList = eleCorpList.findElements(By.xpath("./li"));  //Get the table data rows
					System.out.println("Data Rows Size>>>>"+arrCorpList.size());

					for(WebElement eleCorp : arrCorpList)
					{
						String sCorpName = eleCorp.findElement(By.xpath("./div")).getText();
						System.out.println(sCorpName);
						if(sCorpName.equalsIgnoreCase(sCorp))
						{
							eleCorp.click();
							break;
						}

					}
					//make sure it should select office code
					///fnVerifyDialogBox("OfficeCode", 1);  //Remove after testing
					Thread.sleep(2000);

					if(ElementFound(RenowalkModules.Common_AllModules_ComboOfficeSelect_xp)) 
					{	
						ClickById("officeSelect", "Office Drop-down", false);
						WebElement eleOfficeList = driver.findElement(By.xpath(RenowalkModules.Common_AllModules_ComboOfficeCode_xp));
						List<WebElement> arrOfficeList = eleOfficeList.findElements(By.xpath("./li"));  //Get the table data rows
						System.out.println("Data Rows Size>>>>"+arrOfficeList.size());

						for(WebElement eleOffice : arrOfficeList)
						{
							String sOfficeName = eleOffice.findElement(By.xpath("./div")).getText();
							System.out.println(sOfficeName);
							if(sOfficeName.equalsIgnoreCase(sOffice))
							{
								eleOffice.click();
								break;
							}

						}
					}

				}
				else
				{
					System.out.println("Corporation is already selected");
				}

			    /*if(ElementFound(RenowalkModules.Common_AllModules_ComboOfficeCode_xp)) 
			    {
				    WebDriverWait waitForOfficeCode = new WebDriverWait(driver, 5);
				    waitForOfficeCode.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RenowalkModules.Common_AllModules_ComboOfficeCode_xp)));

				    fnSelectFromComboBoxXpath(RenowalkModules.Common_AllModules_ComboOfficeCode_xp, sOffice);
			    }*/
			} catch (Exception e) {
		    System.out.println("fnSelectCorpOffice --------------Failed");    
		    TestDriver.log.error("fnSelectCorpOffice failed",e);
		    }
		 }
		 
		 /* public Actions fnCreateCustomActionsObj(WebDriver driver)
		 {
			 Actions builder = new Actions(driver);
			 return builder;
		 } */
	 
} // end of BaseClass

