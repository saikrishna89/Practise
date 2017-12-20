package com.homedepot.renowalk.UtilManager;

//import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;


import com.homedepot.renowalk.TestDriver;
import com.qc.ClassFactory;
import com.qc.IBaseFactory;
import com.qc.IList;
import com.qc.IRun;
import com.qc.IRunFactory;
import com.qc.IStep;
import com.qc.ITDConnection;
import com.qc.ITSTest;
import com.qc.ITestSet;
import com.qc.ITestSetFolder;
import com.qc.ITestSetTreeManager;

import com4j.Com4jObject;

//@SuppressWarnings("unused")
public class ALMUtil {

	public static ArrayList<String> PreviousResult = new ArrayList<String>();
	public static ArrayList<String> arrTestRunID = new ArrayList<String>();
	public static ArrayList<String> arrTestStatus = new ArrayList<String>();
	private String testSetPath;
	private String testSetName;
	private ITDConnection connection;
	
	public ALMUtil(String testSetPath,String testSetName) {
		this.testSetPath = testSetPath;
		this.testSetName = testSetName;
	}

	public void openConnection(String almUrl,String domainName,String projectName,String userId,String password) {
		ITDConnection connection = ClassFactory.createTDConnection();
		connection.initConnectionEx(almUrl);
		System.out.println("ALM Connection Successful >>> "+connection.connected());
		connection.connectProjectEx(domainName, projectName, userId, password);
		System.out.println("Connected Successfully to Domain : "+domainName +" and Project : "+projectName+" >>> "+connection.projectConnected());
		this.connection = connection;
	}
	
	public void releaseALMConnection() {
		if(this.connection != null) {
			connection.disconnectProject();
			connection.releaseConnection();
		}
	}
	
	
	public void updateTestCaseStatusToALM(String testCaseName,String result) throws Exception {
		boolean testCaseUpdate = false;
		SimpleDateFormat dateFormat_date = null;
		SimpleDateFormat dateFormat_time =null;
		PreviousResult.clear();
		arrTestRunID.clear();
		arrTestStatus.clear();
		
		HashMap<String, String> mALMTestRunIDStatus = new HashMap<String, String>();
		
		if(this.connection == null) {
			throw new Exception("Error: No ALM Connection is open. Please call openConnection() method to open an ALM connection");
		}
		
		if(testSetName != null && testCaseName != null) {
			ITestSetTreeManager sTestSetTreeManager = (connection.testSetTreeManager()).queryInterface(ITestSetTreeManager.class);
			ITestSetFolder sTestSetFactory = (sTestSetTreeManager.nodeByPath(testSetPath)).queryInterface(ITestSetFolder.class);
			
			IList testSets = sTestSetFactory.findTestSets("", false, "");
			
			for(Com4jObject testSetObj : testSets) {
				
				ITestSet testSet = testSetObj.queryInterface(ITestSet.class);
				if(this.testSetName.equalsIgnoreCase(testSet.name())) {
					IBaseFactory testFactory = testSet.tsTestFactory().queryInterface(IBaseFactory.class);
					IList testInstances = testFactory.newList("");
					
					for(Com4jObject testInstanceObj : testInstances) {
						ITSTest testInstance = testInstanceObj.queryInterface(ITSTest.class);
						//if(testCaseName.equalsIgnoreCase(testInstance.name())) {  //Now using unique test id instead of test name
						if(TestDriver.sTest_Case_ID.equalsIgnoreCase(testInstance.testId().toString())) {
							System.out.println("Success for Test Case Id>>>"+testInstance.testId());
							try {
								dateFormat_date = new SimpleDateFormat("MM/dd/yyyy");
								dateFormat_time = new SimpleDateFormat("hh:mm:ss a");
								//dateFormat = new SimpleDateFormat("MM/dd/YYYY");
							//	dateFormat1 = new SimpleDateFormat("hh:mm:ss a");
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							Date date = new Date();
							Calendar cal = Calendar.getInstance();
							System.out.println("  Test Instance: %s"+testInstance.name());
							testInstance.field("TC_STATUS", result);
							testInstance.field("TC_EXEC_DATE", dateFormat_date.format(date));
							testInstance.field("TC_EXEC_TIME", dateFormat_time.format(cal.getTime()));
							testInstance.post();
							testCaseUpdate = true;
							System.out.println("TestCase Result updated in HP ALM successfully as "+result);
							TestDriver.log.info("TestCase Result updated in HP ALM successfully as "+result);
							
							IRunFactory runFactory = testInstance.runFactory().queryInterface(IRunFactory.class);
							
							int i=0;
							IList run1 = runFactory.newList("");
							
							if(run1 !=null) {
								
									for(Com4jObject stepInstanceObj : run1) 
									{
										
										IRun sRun = stepInstanceObj.queryInterface(IRun.class);
										//Com4jObject sHistory = sRun.history();
										//ITDFilter2 filter = testFactory.filter().queryInterface(ITDFilter2.class);
										
										String sTestRunID = "";
										String sTestRunStatus = "";
										String sTestRunName = "";
										
										sTestRunID = sRun.field("RN_RUN_ID").toString();
										sTestRunStatus = sRun.field("RN_STATUS").toString();
										sTestRunName = sRun.field("RN_RUN_NAME").toString();
										
										if(!sTestRunName.contains("Fast_Run"))
										{
										mALMTestRunIDStatus.put(sTestRunID, sTestRunStatus);
										arrTestRunID.add(i, sTestRunID);
										
											run1.toString();
										//	sRun.field("RN_EXECUTION_DATE").toString();
											System.out.println(sRun.id());
											System.out.println(sRun.name());
											System.out.println(sRun.testSetID());
											i=i+1;
										}
	
									}//for
									Collections.sort(arrTestRunID, Collections.reverseOrder());
								
							}//If
							
							for(int iHist=0; iHist<5; iHist++)
							{
								String sHistStatus =null;
								String sTestRunStatus =null;
								if(iHist<mALMTestRunIDStatus.size())
								{
									sTestRunStatus = mALMTestRunIDStatus.get(arrTestRunID.get(iHist));

									if(sTestRunStatus.contains("Passed")) {
										sHistStatus = "P";
									}
									else if(sTestRunStatus.contains("Failed")) {
										sHistStatus = "F";
									}

								}
								
								if (sHistStatus != null)
								{
									PreviousResult.add(sHistStatus);
									System.out.println(sHistStatus);

								}
							}
							
							String runName = runFactory.uniqueRunName();
							IRun run = (IRun) runFactory.addItem(runName).queryInterface(IRun.class);
							run.copyDesignSteps();
							run.status(result);
							run.post();
							
							IBaseFactory stepFactory = run.stepFactory().queryInterface(IBaseFactory.class);
							IList steps = stepFactory.newList("");
							
							if(steps != null)
								System.out.println("Total Steps:::" + steps.count());
							
							for(Com4jObject stepInstanceObj : steps) {
								IStep step = stepInstanceObj.queryInterface(IStep.class);
								step.field("ST_STATUS",result);
								step.post();								
							}
							break;
							
						}
					}
				}
			}
			
		}
		
		if(!testCaseUpdate) {
			System.out.println("WARNING: ALMUtility could not update the result into ALM for "+"test case \"" + testCaseName + "\" under TEST SET \"" + testSetName + "\"");
			TestDriver.log.info("WARNING: ALMUtility could not update the result into ALM for "+"test case \"" + testCaseName + "\" under TEST SET \"" + testSetName + "\"");
		}
	}
	

	
}
