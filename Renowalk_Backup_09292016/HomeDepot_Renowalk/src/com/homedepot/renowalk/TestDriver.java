package com.homedepot.renowalk;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.net.InetAddress;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleStatement;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.homedepot.renowalk.Common.FunctionLibrary;
import com.homedepot.renowalk.ConfigManager.FileLocSetter;
import com.homedepot.renowalk.ReportManager.Reporter;
import com.homedepot.renowalk.UtilManager.DBUtil;
import com.homedepot.renowalk.UtilManager.ExcelUtil;
import com.homedepot.renowalk.UtilManager.PropUtil;

//public class DriverScript extends TestCaseSpecificClass {
public class TestDriver extends FunctionLibrary{

	String header = null;
	static String sIndexHeader = null;
	public static boolean bLoginFlag = false;
	public static int iRowId;
	public static int iTotalTestSetRows;
	public static int iMasterRowId;
	public static String sMachine = null;
	public static String sSkillSet = null;
	public static String sAppLink = null; 
	public static String sCorporation = null;
	public static String sOffice = null;
	public static String sUsername = null;
	public static String sPassword = null;
	public static boolean bIpadLoginFlag = false;
	
	public static String sWorkingDirPath;

	public static String sHtmlLink = null; // sHtmlLink to index file
	public static String sFolderPath = null; // local report folder

	public static String sEnvironment; // IDT5, etc
	public static String sPhase; // Smoke, Regression, SIT
	public static String sModule; // Groups, Items, Flows, Property <-- to be implemented later
	public static String sRelease; // sRelease build: 5.2, 5.3, etc.s
	public static String sApplication; // GPS Europe
	public static String sReportName; //Test Suite Name

	public static int iTC_ID; // keep track of the testID
	public static String sTest_Case_ID; // keep track of the testID
	public static String sTest_Case_Name; // keep track of the tcName
	public static String sTest_Case_Description; // keep track of the test desc
	public static String sAPI_Test; //Keep track of API Test Flag

	public static String Production; // Pre_Production or Production
	
	public static OracleResultSet rset=null;
	public static OracleStatement stmt=null;
	public static OracleConnection ocon=null;
	
	public static  HashMap<Integer, HashMap<String, String>> mEnvSheetData=null;
	public static  HashMap<Integer, HashMap<String, String>> mTestSetSheetData=null;
	public static  HashMap<Integer, HashMap<String, String>> mTestPhaseData=null;
	
	public static String sSoapActionUrl;
	public static String sIndexHTMLFileName="";
	
	public static Logger log = Logger.getLogger(TestDriver.class.getName());//
	
	public int tCounter = 0;
	public int tCount = 0;
	
	public String currentTC = null;
	public String stCounter = null;
	public String stCount = null;
	
	public JFrame testUI = new JFrame("TestUI");
	public JLabel tcIDindicator;
	public JLabel tcCountCurrent;
	
	ExcelUtil objExcelUtility = new ExcelUtil();
	PropUtil objPropertiesUtility = new PropUtil();
	DBUtil objDBUtility = new DBUtil();
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod");
		}
		
	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod");
	}
	
	@Test(enabled = false)
	@BeforeTest
	public void beforeTest() {
		System.out.println("@BeforeTest");
		
		try {
	//		ExecuteCommand("C:\\Automation\\killprocess.bat");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		prop = objPropertiesUtility.fnLoadObjects(FileLocSetter.sConfigPath, "global.properties");
	    		
	}

	@AfterTest
	public void afterTest() {
		System.out.println("@AfterTest");
		if (driver != null)
			driver.quit();
	}
	
	public void createTestUI() {
		JPanel leftP = new JPanel();
		JPanel rightP = new JPanel();
		
		stCounter = "Completed " + String.valueOf(tCounter) + "out of ";
		stCount = String.valueOf(tCount) + " tests.";
		
		tcIDindicator = new JLabel("Current Test Case: " + currentTC);
		tcCountCurrent = new JLabel("Working..." + "        Located " + stCount);
		
		leftP.add(tcIDindicator);
		rightP.add(tcCountCurrent);
		
		GridLayout tuLayout = new GridLayout(2,1);
		testUI.setLayout(tuLayout);
		testUI.add(leftP);
		testUI.add(rightP);
		testUI.setSize(350, 350);
		testUI.pack();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
	    Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
	    int x = (int) rect.getMaxX() - testUI.getWidth();
	    int y = 0;
	    testUI.setLocation(x, y);
		testUI.setVisible(true);
		testUI.setAlwaysOnTop(true);
	}
	
	private void updateTestUICount() {
		tCounter++;
		stCounter = "Completed " + String.valueOf(tCounter) + " out of ";
		stCount = String.valueOf(tCount) + " tests.";
		tcCountCurrent.setText(stCounter + stCount);
	}
	
	public void updateTestUICurrent() {
		tcIDindicator.setText("Current Test Case: " + currentTC);
		testUI.repaint();
	}
	
	public void testUIcontrol(){
		updateTestUICount();
		testUI.repaint();
	}

// ============================================================ DRIVER SCRIPT ============================================================

	@Test
	public void run() throws Exception {

		try {
			//String sWorkingDir = System.getProperty("user.dir");	
			//sWorkingDirPath=sWorkingDir;
			String sPackageClass = "";
			sPackageClass = this.getClass().getPackage().getName();
			System.out.println(sPackageClass);
			DOMConfigurator.configure(FileLocSetter.sConfigPath+"log4j.xml");
				
			//SimpleDateFormat logFileDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			//System.setProperty("current.date", logFileDateFormat.format(new Date()));
			log.info("------------------Test Execution Started--------------------\n\n");
			
			mEnvSheetData = objExcelUtility.fnGetExcelData(FileLocSetter.sTestDataPath+ FileLocSetter.sFileName,"Environment", "");
			
			
			
			for (int masterRow = 1; masterRow <= mEnvSheetData.size(); masterRow++) 
			{	
				//iMasterRowId = Integer.toString(masterRow);
				iMasterRowId = masterRow;

				if(mEnvSheetData.get(masterRow).get("Execution_Flag").equalsIgnoreCase("Y")) 
				{
//					fnSetBrowserCapabilities();
					sEnvironment = mEnvSheetData.get(masterRow).get("Environment");
					sApplication = mEnvSheetData.get(masterRow).get("Application");
					sPhase = mEnvSheetData.get(masterRow).get("Phase");
					sRelease = mEnvSheetData.get(masterRow).get("Release");
					sReportName = mEnvSheetData.get(masterRow).get("ReportName");
					sAppLink=mEnvSheetData.get(masterRow).get("AppLink").toString().trim();
					sCorporation = mEnvSheetData.get(masterRow).get("Corporation").toString().trim();
					sOffice = mEnvSheetData.get(masterRow).get("Office").toString().trim();
				
					sIndexHeader = Reporter.repGenerateIndexHeader(sEnvironment, sApplication, sPhase);

					mTestSetSheetData = objExcelUtility.fnGetExcelData(FileLocSetter.sTestDataPath+ FileLocSetter.sFileName,"TestSet",""); //Get TestSet hash map 
					mTestPhaseData = objExcelUtility.fnGetExcelData(FileLocSetter.sTestDataPath+ FileLocSetter.sFileName,"TestData", "Test_Case_ID");    //Get Smoke/SIT/Regression hash map 
					
				
					/////////////////////////////////////////////
					//for (int iTCRow = 1; iTCRow <=mTestSetSheetData.size(); iTCRow++)
					for (int iTCRow = 1; iTCRow <=iTotalTestSetRows; iTCRow++)
					{
						if(mTestSetSheetData.containsKey(iTCRow))
						{
							if( mTestSetSheetData.get(iTCRow).get(sPhase).equalsIgnoreCase("Y"))  //Test case check
							{
								tCount++;
							}
						}
					}
					
					
					createTestUI();
					
					//Iterates through hashes and runs all flagged tests
					for (int iTCRow = 1; iTCRow <=iTotalTestSetRows; iTCRow++)
					{
						//RowId = Integer.toString(iTCRow);
						iRowId=iTCRow;
						sUsername= mEnvSheetData.get(masterRow).get("Username").toString().trim();
						sPassword= mEnvSheetData.get(masterRow).get("Password").toString().trim();
						
						if(mTestSetSheetData.containsKey(iTCRow))
						{
						
							sTest_Case_ID = mTestSetSheetData.get(iTCRow).get("Test_Case_ID");
							iTC_ID = Integer.parseInt(sTest_Case_ID);
							sModule = mTestSetSheetData.get(iTCRow).get("Module");
							
							
							if( mTestSetSheetData.get(iTCRow).get(sPhase).equalsIgnoreCase("Y"))  //Test case check
							{	
							   sIndexHTMLFileName="index.html";   //in case data is missing for a test case, index.html would be default index file, else will be overridden as below 
							   try {
										if(mTestPhaseData.get(iTC_ID)!=null)
										{
											sIndexHTMLFileName = "index_"+InetAddress.getLocalHost().getHostName()+".html";
											//Overriding with specific user id/password if any, else use credential from master sheet
											if(!mTestPhaseData.get(iTC_ID).get("Username").equalsIgnoreCase("") && !mTestPhaseData.get(iTC_ID).get("Password").equalsIgnoreCase(""))
											{
												 sUsername= mTestPhaseData.get(iTC_ID).get("Username").toString().trim();
												 sPassword= mTestPhaseData.get(iTC_ID).get("Password").toString().trim();
											}
										 }
										 else
										 {
											log.info("Test case warning for Test Case ID"+sTest_Case_ID+". Function or Data missing...");
										 }
									} catch (Exception e) {
										
										log.error("Test case failed for Test Case ID"+sTest_Case_ID+". Data missing or Web service failure ",e);
									}	
						
									try 
									{
										sTest_Case_Name = mTestSetSheetData.get(iTCRow).get("Test_Case_Name");
										sTest_Case_Description = mTestSetSheetData.get(iTCRow).get("Test_Case_Description");
										sAPI_Test = mTestSetSheetData.get(iTCRow).get("API_Test");
										
										header = Reporter.repGenerateHeader(sReportName, sTest_Case_Name, sApplication, sTest_Case_Description);
										fnInitializeGlobalVariables();
										
										if(sUsername.contains(",") && sPassword.contains(","))
										{
											String[] arrUsername = null;
											String[] arrPassword = null;
											
											arrUsername = sUsername.split(",");
											arrPassword = sPassword.split(",");
											
											for(int i=0;i<arrUsername.length;i++)
											{
												sUsername = arrUsername[i].toString().trim();			
												sPassword = arrPassword[i].toString().trim();
												
												if (bLoginFlag==false && !sAPI_Test.equalsIgnoreCase("Y"))
												{
													fnSetBrowserCapabilities();
													bLoginFlag = fnRenowalkLogIn(sAppLink,sUsername, sPassword);
												}
												if(bLoginFlag==true || sAPI_Test.equalsIgnoreCase("Y"))
												{
													currentTC = mTestSetSheetData.get(iTCRow).get("FunctionName");
													updateTestUICurrent();
													fnExecuteFunction(sPackageClass+ "."+sModule+"_testcases", currentTC);
													fnCheckHandleModalDiv();
													testUIcontrol();
												}
											}
	
										}
										else
										{
											if (bLoginFlag==false && !sAPI_Test.equalsIgnoreCase("Y"))
											{
												fnSetBrowserCapabilities();
												bLoginFlag = fnRenowalkLogIn(sAppLink,sUsername, sPassword);
											}
											if(bLoginFlag==true || sAPI_Test.equalsIgnoreCase("Y"))
											{
												currentTC = mTestSetSheetData.get(iTCRow).get("FunctionName");
												updateTestUICurrent();
												fnExecuteFunction(sPackageClass+ "."+sModule, currentTC);
												fnCheckHandleModalDiv();
												testUIcontrol();
											}
										}
										
										obj.repGenerateResult(sTest_Case_Name, header);
										obj.repGenerateIndexReport(sIndexHeader);
										header = null;   
										
										
										
									} catch (Exception e) 
									{
										System.out.println("@@@ Exception in executeTest @@@");
										System.out.println(e);
										
									}
								
							}
						}
						else
						{
							System.out.println("No Test Case present at row : " + iTCRow);
							//log.info("No Test Case present at row : " + iTCRow);
						}
						
					} //End Test case loop
					
						try {
							if (driver!=null)
							{
								fnSignOut(true);
								//driver.quit();
								//driver=null;
							}	
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						finally
						{
							log.info("------------------Test Execution Completed------------------\n\n");
							System.out.println("Local HTML report folder: " + sFolderPath);
							System.out.println("Local HTML report index: " + sFolderPath + "\\" + sIndexHTMLFileName);
							obj.createTestResultsWithTimestamp(sFolderPath);	
							//obj.fnWriteResultsToATMDB(sHtmlLink);
							Reporter.openHTMLreport();
							Reporter.iSlNo = 0;
							Reporter.iTotalExecuted = 0;
							Reporter.iTotalPass = 0;
							Reporter.iTotalFail = 0;
						}
				}
			} // End of Suite/Master sheet loop

			
		} catch (Exception e) {
			if (driver!=null)
			{
				fnSignOut(true);
			}
			System.out.println(e);
		}

		finally {
			obj = null;
		}

	}


// ============================================================ DRIVER SCRIPT ============================================================

} // end of Test
