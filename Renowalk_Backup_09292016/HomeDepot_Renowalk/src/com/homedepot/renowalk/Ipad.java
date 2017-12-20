package com.homedepot.renowalk;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.homedepot.renowalk.ObjectRepository.RenowalkHome;
import com.homedepot.renowalk.ObjectRepository.RenowalkIpad;
import com.homedepot.renowalk.ObjectRepository.RenowalkModules;
import com.homedepot.renowalk.ReportManager.Reporter;
import com.homedepot.renowalk.UtilManager.AppMessages;

import Fillo.Connection;
import Fillo.Fillo;
import bsh.Capabilities;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSElement;

import com.homedepot.renowalk.Common.IpadFunctionLibrary;

public class Ipad extends TestDriver
{
	RenowalkIpad objRWIpad = new RenowalkIpad();
	RenowalkHome objRWHome = new RenowalkHome();
	AppMessages objAppMessages = new AppMessages();
	IpadFunctionLibrary IpadLib = new IpadFunctionLibrary();
	RenowalkModules objRWModules = new RenowalkModules();

			//TC1001_Login_ViewProperties_Page
			@SuppressWarnings("static-access")
			public Reporter TC1001(Reporter obj) throws Exception
			{
				//Boolean bLoginFlag = true;	
				log.info("Execution of Function TC1001 Started..");
				try {		
					obj.repAddData( "Login and View My Properties Page", "", "", "");
					
					//PreConditions
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSCheckDisplayedByName(objRWIpad.SettingIcon_nm, objRWIpad.SettingIcon_nm, true);
					IpadLib.IOSCheckDisplayedByName(objRWIpad.SyncIcon_nm, objRWIpad.SyncIcon_nm, true);
					IpadLib.IOSVeriyTextByName(objRWIpad.MyPropertiesHeading_nm, objRWIpad.MyPropertiesHeading_nm, true);
					IpadLib.IOSClickByXpath(objRWIpad.ListViewProperties_xp, "List View", true);
					
					//Post Condition
					IpadLib.IOSdeleteProperty();
					
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1001 Failed!", e );
				}
				finally {
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1001 Completed");
				}
				return obj;
			} //End of function TC1001	
		
			//TC1002_ViewProperties_Page_ListView_GridView
			@SuppressWarnings("static-access")
			public Reporter TC1002(Reporter obj) throws Exception
			{
				//Boolean bLoginFlag = true;	
				log.info("Execution of Function TC1002 Started..");
				try {		
					obj.repAddData( "Verify Properties in Grid and List View", "", "", "");
					
					//Precondition

					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					//Clicking on Grid View and checking if the properties are shown in Grid View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnGridView_xp, "Grid View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					//Post Condition
					IpadLib.IOSdeleteProperty();
					
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1002 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1002 Completed");
				}
				return obj;
			} //End of Testcase TC1002
			
			//TC1003 - Verify Newly added property shows up in  My Properties page
			@SuppressWarnings("static-access")
			public Reporter TC1003(Reporter obj) throws Exception
			{
				//Boolean bLoginFlag = true;	
				log.info("Execution of Function TC1003 Started..");
				try {		
					obj.repAddData( "Verify if user can able to see the newly added property in the Property page", "", "", "");
					
					//Precondition
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					//Post Condition
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					IpadLib.IOSdeleteProperty();
					
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1003 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1003 Completed");
				}
				return obj;
			} //End of Testcase TC1003

			
			
			//TC1004_Verify Property  Details page
			@SuppressWarnings("static-access")
			public Reporter TC1004(Reporter obj) throws Exception
			{
				//Boolean bLoginFlag = true;	
				log.info("Execution of Function TC1004 Started..");
				try {		
					obj.repAddData( "Verify Property  Details page", "", "", "");
					
					//Precondition
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.PropertyDetailsPagePropertyName_xp,"TestPropertyNA",true);
					IpadLib.IOSVeriyTextByName(objRWIpad.PropertyDetailsProjectNameLabel_nm,"Project Name  :",true);
					IpadLib.IOSVeriyTextByName(objRWIpad.PropertyDetailsAddressLabel_nm ,"Address  :",true);
					IpadLib.IOSVeriyTextByName(objRWIpad.PropertyDetailsCountyLabel_nm,"County :",true);
					IpadLib.IOSVeriyTextByName(objRWIpad.PropertyDetailsSQFTLabel_nm,"Main SQFT  :",true);
					IpadLib.IOSVeriyTextByName(objRWIpad.PropertyDetailsNumBedroomsLabel_nm,"# Bedrooms  :",true);
					IpadLib.IOSVeriyTextByName(objRWIpad.PropertyDetailsNumBathroomsLabel_nm,"# Bathrooms  :",true);
					IpadLib.IOSVeriyTextByName(objRWIpad.PropertyDetailsYearBuiltLabel_nm,"Year Built  :",true);
					IpadLib.IOSVeriyTextByName(objRWIpad.PropertyDetailsGateCodeLabel_nm,"Gate Code  :",true);
					IpadLib.IOSVeriyTextByName(objRWIpad.PropertyDetailsLockBoxLabel_nm,"Lock Box  :",true);
					
					
					//Post Condition
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					IpadLib.IOSdeleteProperty();
					//IpadLib.AppLogOut();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1004 Failed!", e );
				}
				finally {
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}

						log.info("Execution of Function TC1004 Completed");
				}
				return obj;
			} //End of function TC1004
			
			//TC1005 - Verify Changing Property Info 
			@SuppressWarnings("static-access")
			public Reporter TC1005(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1005 Started..");
				try {		
					obj.repAddData( "Verifying editing Property Info", "", "", "");
					
					//Precondition
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
				
					IpadLib.IOSVeriyTextByXpath(objRWIpad.PropertyDetailsPagePropertyName_xp,"TestPropertyNA",true);
					IpadLib.IOSVeriyTextByName(objRWIpad.PropertyDetailsProjectNameLabel_nm,"Project Name  :",true);
					IpadLib.IOSVeriyTextByName(objRWIpad.PropertyDetailsAddressLabel_nm ,"Address  :",true);
					IpadLib.IOSVeriyTextByName(objRWIpad.PropertyDetailsCountyLabel_nm,"County :",true);
					IpadLib.IOSVeriyTextByName(objRWIpad.PropertyDetailsSQFTLabel_nm,"Main SQFT  :",true);
					IpadLib.IOSVeriyTextByName(objRWIpad.PropertyDetailsNumBedroomsLabel_nm,"# Bedrooms  :",true);
					IpadLib.IOSVeriyTextByName(objRWIpad.PropertyDetailsNumBathroomsLabel_nm,"# Bathrooms  :",true);
					IpadLib.IOSVeriyTextByName(objRWIpad.PropertyDetailsYearBuiltLabel_nm,"Year Built  :",true);
					IpadLib.IOSVeriyTextByName(objRWIpad.PropertyDetailsGateCodeLabel_nm,"Gate Code  :",true);
					IpadLib.IOSVeriyTextByName(objRWIpad.PropertyDetailsLockBoxLabel_nm,"Lock Box  :",true);
					
					//Post Condition
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					IpadLib.IOSdeleteProperty();
					
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1005 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1005 Completed");
				}
				return obj;
			} //End of function TC1005
			
			//TC1006 Verifying Validating the Tool Box
			@SuppressWarnings("static-access")
			public Reporter TC1006(Reporter obj) throws Exception
			{
				//Boolean bLoginFlag = true;	
				log.info("Execution of Function TC1006 Started..");
				try {		
					obj.repAddData( "Verifying tool box", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					
					IpadLib.IOSCheckDisplayedByName(objRWIpad.PropertyDetailsToolbox_nm, "Property Details", true);
					IpadLib.IOSClickByName(objRWIpad.PropertyDetailsToolbox_nm, "Property Details", true);
					
					IpadLib.IOSCheckDisplayedByXpath(objRWIpad.PropertyDetailsToolboxCompass_xp,"Compass",true);
					IpadLib.IOSCheckDisplayedByXpath(objRWIpad.PropertyDetailsToolboxCalc_xp,"Calculator",true);
					//IpadLib.IOSCheckDisplayedByXpath(objRWIpad.PropertyDetailsToolboxPhoto_xp,"Photo Annotate",true);
					IpadLib.IOSCheckDisplayedByXpath(objRWIpad.PropertyDetailsToolboxLevel_xp,"Level",true);
					IpadLib.IOSCheckDisplayedByXpath(objRWIpad.PropertyDetailsToolboxRoof_xp,"Roof Pitch",true);
					//IpadLib.IOSCheckDisplayedByXpath(objRWIpad.PropertyDetailsToolboxSave_xp,"Save All Photos",true);
					
					//Just for checking purpose
					iosdriver.tap(1, 165, 35, 500);
					
					//click on Back button for Log Out
					//Post Conditions
					IpadLib.IOSCheckDisplayedByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
					
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1006 Failed!", e );
				}
				finally {
				
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1006 Completed");
				}
				return obj;
			} //End of function TC1006
			
			//TC1007 - Verifying Selecting Tools 'Compass'
			@SuppressWarnings("static-access")
			public Reporter TC1007(Reporter obj) throws Exception
			{
				//Boolean bLoginFlag = true;	
				log.info("Execution of Function TC1007 Started..");
				try {		
					obj.repAddData( "Verifying Compass Option", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					//Precondition

					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
										
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
										
		
					IpadLib.IOSCheckDisplayedByName(objRWIpad.PropertyDetailsToolbox_nm, "Tool Box", true);
					IpadLib.IOSClickByName(objRWIpad.PropertyDetailsToolbox_nm, "Tool Box", true);
					
					//Click on Compass Option
					IpadLib.IOSCheckDisplayedByXpath(objRWIpad.PropertyDetailsToolboxCompass_xp,"Compass",true);
					IpadLib.IOSClickByXpath(objRWIpad.PropertyDetailsToolboxCompass_xp,"Compass",true);
					
					//Check for all compass options
					IpadLib.IOSCheckDisplayedByName(objRWIpad.CompassHeader_nm,objRWIpad.CompassHeader_nm,true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button",true);
					
					//Post Conditions
					//click on Back button for Log Out
					IpadLib.IOSCheckDisplayedByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1007 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
					
					log.info("Execution of Function TC1007 Completed");
				}
				return obj;
			} //End of function TC1007
			
			//TC1008 - Verifying Selecting Tools 'Calculator'
			@SuppressWarnings("static-access")
			public Reporter TC1008(Reporter obj) throws Exception
			{
				//Boolean bLoginFlag = true;	
				log.info("Execution of Function TC1008 Started..");
				try {		
					obj.repAddData( "Verify Calculator Option", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
										
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
										
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					IpadLib.IOSCheckDisplayedByName(objRWIpad.PropertyDetailsToolbox_nm, "Tool Box", true);
					IpadLib.IOSClickByName(objRWIpad.PropertyDetailsToolbox_nm, "Tool Box", true);
					
					//click on Calculator Option
					IpadLib.IOSCheckDisplayedByXpath(objRWIpad.PropertyDetailsToolboxCalc_xp,"Calculator",true);
					IpadLib.IOSClickByXpath(objRWIpad.PropertyDetailsToolboxCalc_xp,"Calculator",true);
					
					//Verify for All calculator Options
					IpadLib.IOSCheckDisplayedByXpath(objRWIpad.CalcEquationViewer_xp,"Calculator Viewer",true);
					IpadLib.IOSCheckDisplayedByName(objRWIpad.ToolboxToolBackButton_nm,"Back Button",true);
					IpadLib.IOSCheckDisplayedByName(objRWIpad.CalculatorHeader_nm,"Calculator Header",true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm,"Back Button",true);
					
					//Post Conditions
					//click on Back button for Log Out
					IpadLib.IOSCheckDisplayedByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
			
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1008 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1008 Completed");
				}
				return obj;
			} //End of function TC1008
			
			
			//TC1009 - Verifying Selecting Tools 'Photo Annotator'
			@SuppressWarnings("static-access")
			public Reporter TC1009(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1009 Started..");
				try {		
					obj.repAddData( "Checking the Photo Annotate Option from properties option", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					//Precondition

					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
										
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
										
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					IpadLib.IOSCheckDisplayedByName(objRWIpad.PropertyDetailsToolbox_nm, "Tool Box", true);
					IpadLib.IOSClickByName(objRWIpad.PropertyDetailsToolbox_nm, "Tool Box", true);
					
					//Clicking on Photo Annotate Option
					IpadLib.IOSCheckDisplayedByXpath(objRWIpad.PropertyDetailsToolboxPhoto_xp,"Photo Annotate",true);
					IpadLib.IOSClickByXpath(objRWIpad.PropertyDetailsToolboxPhoto_xp,"Photo Annotate",true);
					
					//Verify all the options present in Photo Annotate option
					IpadLib.IOSCheckDisplayedByXpath(objRWIpad.PhotoAnnotatePropertyName_xp,"Property Name",true);
					IpadLib.IOSCheckDisplayedByName(objRWIpad.PhotoAnnotateCameraIcon_nm,"Camera Option",true);
					IpadLib.IOSCheckDisplayedByName(objRWIpad.PhotoAnnotateHeader_nm,"Photo Annotate Header",true);
					//Tapping on Back Button
					iosdriver.tap(1, 20, 22, 1500);

					//Post Conditions
					//click on Back button for Log Out
					IpadLib.IOSCheckDisplayedByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1009 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1009 Completed");
				}
				return obj;
			} //End of function TC1009
			
			
			//TC1010 - Verifying Selecting Tools 'Level'
			@SuppressWarnings("static-access")
			public Reporter TC1010(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1010 Started..");
				try {		
					obj.repAddData( "Checking the 'Level' Option from properties option", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					//Precondition
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
										
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
										
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					IpadLib.IOSCheckDisplayedByName(objRWIpad.PropertyDetailsToolbox_nm, "Tool Box", true);
					IpadLib.IOSClickByName(objRWIpad.PropertyDetailsToolbox_nm, "Tool Box", true);
					
					//Clicking on Level Option
					IpadLib.IOSCheckDisplayedByXpath(objRWIpad.PropertyDetailsToolboxLevel_xp,"Level",true);
					IpadLib.IOSClickByXpath(objRWIpad.PropertyDetailsToolboxLevel_xp,"Level",true);
					
					//Verify all the options present in Level option
					IpadLib.IOSCheckDisplayedByName(objRWIpad.Property_Settings_Level_LevelHeader_name, "Level Header", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm,"Back Button",true);

					//Post Conditions
					//click on Back button for Log Out
					IpadLib.IOSCheckDisplayedByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1010 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1010 Completed");
				}
				return obj;
			} //End of function TC1010
			

			//TC1011 - Verifying Selecting Tools 'RoofPitch'
			@SuppressWarnings("static-access")
			public Reporter TC1011(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1011 Started..");
				try {		
					obj.repAddData( "Checking the 'Roof Pitch' Option from properties option", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
										
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
										
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
										
					
					IpadLib.IOSCheckDisplayedByName(objRWIpad.PropertyDetailsToolbox_nm, "Tool Box", true);
					IpadLib.IOSClickByName(objRWIpad.PropertyDetailsToolbox_nm, "Tool Box", true);
					
					//Clicking on Level Option
					IpadLib.IOSCheckDisplayedByXpath(objRWIpad.PropertyDetailsToolboxRoof_xp,"Roof Pitch",true);
					IpadLib.IOSClickByXpath(objRWIpad.PropertyDetailsToolboxRoof_xp,"Roof Pitch",true);
					
					//Verify all the options present in Roof Pitch option
					IpadLib.IOSClickByName(objRWIpad.Property_Settings_RoofPitch_BtnCancel_name,"Cancel Button",true);

					//Post Conditions
					//click on Back button for Log Out
					IpadLib.IOSCheckDisplayedByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1011 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1011 Completed");
				}
				return obj;
			} //End of function TC1011
			
			//TC1012 - Verifying Selecting Tools 'Save All Photos to Camera'
			@SuppressWarnings("static-access")
			public Reporter TC1012(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1012 Started..");
				try {		
					obj.repAddData( "Checking the 'Save All Photos to Camera' Option from properties option", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					//Precondition

					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
										
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
										
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
										
					
					IpadLib.IOSCheckDisplayedByName(objRWIpad.PropertyDetailsToolbox_nm, "Tool Box", true);
					IpadLib.IOSClickByName(objRWIpad.PropertyDetailsToolbox_nm, "Tool Box", true);
					
					//Clicking on Level Option
					IpadLib.IOSCheckDisplayedByXpath(objRWIpad.PropertyDetailsToolboxSave_xp,"Save Photos",true);
					IpadLib.IOSClickByXpath(objRWIpad.PropertyDetailsToolboxSave_xp,"Save Photos",true);
					
					//Click on OK Button to save all photos
					IpadLib.IOSClickByName(objRWIpad.General_BtnOk_nm, "Ok Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					IpadLib.IOSCheckDisplayedByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1012 Failed!", e );
				}
				finally {
					
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1012 Completed");
				}
				return obj;
			} //End of function TC1012
			
			//TC1013 - Verifying Cancel Camera screen option
			@SuppressWarnings("static-access")
			public Reporter TC1013(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1013 Started..");
				try {		
					obj.repAddData( "Verifying Cancel Camera screen option", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					//Precondition

					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
										
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
										
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
										
					
					IpadLib.IOSCheckDisplayedByName(objRWIpad.PropertyDetailsToolbox_nm, "Tool Box", true);
					IpadLib.IOSClickByName(objRWIpad.PropertyDetailsToolbox_nm, "Tool Box", true);
					
					//Clicking on Level Option
					IpadLib.IOSCheckDisplayedByXpath(objRWIpad.PropertyDetailsToolboxSave_xp,"Save Photos",true);
					IpadLib.IOSClickByXpath(objRWIpad.PropertyDetailsToolboxSave_xp,"Save Photos",true);
					
					//Click on OK Button to save all photos
					IpadLib.IOSClickByName(objRWIpad.General_BtnOk_nm, "Ok Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					IpadLib.IOSCheckDisplayedByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1013 Failed!", e );
				}
				finally {
					
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1013 Completed");
				}
				return obj;
			} //End of function TC1013
			
			//TC1014 - Verifying Canceling 'Calculator' Screen
			@SuppressWarnings("static-access")
			public Reporter TC1014(Reporter obj) throws Exception
			{
				
				log.info("Execution of Function TC1014 Started..");
				try {		
					obj.repAddData( "Verify if the User can able to click on Cancel in Calculator", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
										
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
										
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					IpadLib.IOSCheckDisplayedByName(objRWIpad.PropertyDetailsToolbox_nm, "Tool Box", true);
					IpadLib.IOSClickByName(objRWIpad.PropertyDetailsToolbox_nm, "Tool Box", true);
					
					//click on Calculator Option
					IpadLib.IOSCheckDisplayedByXpath(objRWIpad.PropertyDetailsToolboxCalc_xp,"Calculator",true);
					IpadLib.IOSClickByXpath(objRWIpad.PropertyDetailsToolboxCalc_xp,"Calculator",true);
					
					//Verify for All calculator Options
					IpadLib.IOSCheckDisplayedByXpath(objRWIpad.CalcEquationViewer_xp,"Calculator Viewer",true);
					IpadLib.IOSCheckDisplayedByName(objRWIpad.ToolboxToolBackButton_nm,"Back Button",true);
					IpadLib.IOSCheckDisplayedByName(objRWIpad.CalculatorHeader_nm,"Calculator Header",true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm,"Back Button",true);
					
					//Post Conditions
					//click on Back button for Log Out
					IpadLib.IOSCheckDisplayedByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1014 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1014 Completed");
				}
				return obj;
			} //End of function TC1014
			
			//TC1015 - Verifying Canceling the 'Photo Annotator'
			@SuppressWarnings("static-access")
			public Reporter TC1015(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1015 Started..");
				try {		
					obj.repAddData( "Checking the Cancel option in Photo Annotate screen", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
										
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
										
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					IpadLib.IOSCheckDisplayedByName(objRWIpad.PropertyDetailsToolbox_nm, "Tool Box", true);
					IpadLib.IOSClickByName(objRWIpad.PropertyDetailsToolbox_nm, "Tool Box", true);
					
					//Clicking on Photo Annotate Option
					IpadLib.IOSCheckDisplayedByXpath(objRWIpad.PropertyDetailsToolboxPhoto_xp,"Photo Annotate",true);
					IpadLib.IOSClickByXpath(objRWIpad.PropertyDetailsToolboxPhoto_xp,"Photo Annotate",true);
					
					//Verify all the options present in Photo Annotate option
					IpadLib.IOSCheckDisplayedByXpath(objRWIpad.PhotoAnnotatePropertyName_xp,"Property Name",true);
					IpadLib.IOSCheckDisplayedByName(objRWIpad.PhotoAnnotateCameraIcon_nm,"Camera Option",true);
					IpadLib.IOSCheckDisplayedByName(objRWIpad.PhotoAnnotateHeader_nm,"Photo Annotate Header",true);
					//Tapping on Back Button
					iosdriver.tap(1, 20, 22, 1500);

					//Post Conditions
					//click on Back button for Log Out
					IpadLib.IOSCheckDisplayedByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1015 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1015 Completed");
				}
				return obj;
			} //End of function TC1015
			
			//TC1016 - Verifying canceling Tools option 'RoofPitch'
			@SuppressWarnings("static-access")
			public Reporter TC1016(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1016 Started..");
				try {		
					obj.repAddData( "Verifying canceling Tools option 'RoofPitch'", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
										
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
										
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					IpadLib.IOSCheckDisplayedByName(objRWIpad.PropertyDetailsToolbox_nm, "Tool Box", true);
					IpadLib.IOSClickByName(objRWIpad.PropertyDetailsToolbox_nm, "Tool Box", true);
					
					//Clicking on Level Option
					IpadLib.IOSCheckDisplayedByXpath(objRWIpad.PropertyDetailsToolboxRoof_xp,"Roof Pitch",true);
					IpadLib.IOSClickByXpath(objRWIpad.PropertyDetailsToolboxRoof_xp,"Roof Pitch",true);
					
					//Verify all the options present in Roof Pitch option
					IpadLib.IOSClickByName(objRWIpad.Property_Settings_RoofPitch_BtnCancel_name,"Cancel Button",true);

					//Post Conditions
					//click on Back button for Log Out
					IpadLib.IOSCheckDisplayedByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1016 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1016 Completed");
				}
				return obj;
			} //End of function TC1016
			
			//TC1017 - Take Picture using Photos Option
			@SuppressWarnings("static-access")
			public Reporter TC1017(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1017 Started..");
				try {		
					obj.repAddData( "Verifying Taking Picture option", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
										
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
										
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
										
					
					//click on Add Button
					IpadLib.IOSCheckDisplayedByName(objRWIpad.Property_Photos_AddPhotos_nm, "Add Button", true);
					IpadLib.IOSClickByName(objRWIpad.Property_Photos_AddPhotos_nm, "Add Button", true);
					
					//click on Take Picture
					IpadLib.IOSClickByName(objRWIpad.Property_Photos_TakePicture_nm, "Take Picture", true);
					IpadLib.IOSClickByName(objRWIpad.Property_Photos_BtnCamera_nm, "Camera Button", true);
					
					//click on save Button
					IpadLib.IOSClickByXpath(objRWIpad.Property_Photos_BtnSave_xp, "Save Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					IpadLib.IOSCheckDisplayedByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1017 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1017 Completed");
				}
				return obj;
			} //End of function TC1017
			
			//TC1018 - Take Picture using Photos Option
			@SuppressWarnings("static-access")
			public Reporter TC1018(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1018 Started..");
				try {		
					obj.repAddData( "Verifying Taking Picture option from IPAD library", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
										
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
										
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
				
					
					//click on Add Button
					IpadLib.IOSCheckDisplayedByName(objRWIpad.Property_Photos_AddPhotos_nm, "Add Button", true);
					IpadLib.IOSClickByName(objRWIpad.Property_Photos_AddPhotos_nm, "Add Button", true);
					
					//click on choose photos from Ipad Library
					IpadLib.IOSClickByName(objRWIpad.Property_Photos_ChoosePicture_nm, "Choose Picture", true);
					IpadLib.IOSClickByName(objRWIpad.Property_Photos_CameraRoll_nm, "Camera Roll", true);
					
					//select Picture
					IpadLib.IOSClickByXpath(objRWIpad.Property_Photos_SelectPhoto_xp, "Select Photo", true);
					
					//Tap any where on the screen to close the Photos list view
					TouchAction actionTap = new TouchAction(iosdriver);
					actionTap.press(671, 24).perform().tap(671, 24);
					
					//Post Conditions
					//click on Back button for Log Out
					IpadLib.IOSCheckDisplayedByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1018 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1018 Completed");
				}
				return obj;
			} //End of function TC1018
			
			//TC1019 - Delete Pictures using Photos Option
			@SuppressWarnings("static-access")
			public Reporter TC1019(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1019 Started..");
				try {		
					obj.repAddData( "Verifying deleting Picture option from Photos", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
										
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
										
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Add Button
					IpadLib.IOSCheckDisplayedByName(objRWIpad.Property_Photos_AddPhotos_nm, "Add Button", true);
					IpadLib.IOSClickByName(objRWIpad.Property_Photos_AddPhotos_nm, "Add Button", true);
					
					//click on Take Picture
					IpadLib.IOSClickByName(objRWIpad.Property_Photos_TakePicture_nm, "Take Picture", true);
					IpadLib.IOSClickByName(objRWIpad.Property_Photos_BtnCamera_nm, "Camera Button", true);
					
					//click on save Button
					IpadLib.IOSClickByXpath(objRWIpad.Property_Photos_BtnSave_xp, "Save Button", true);
					
		
					//click on edit Button
					IpadLib.IOSCheckDisplayedByName(objRWIpad.Property_Photos_BtnEdit_nm, "Edit Button", true);
					IpadLib.IOSClickByName(objRWIpad.Property_Photos_BtnEdit_nm, "Edit Button", true);
					
					//Click on Delete Icon
					IpadLib.IOSClickByXpath(objRWIpad.Property_Photos_BtnMinus_xp, "Delete Icon", true);
					
					//click on Delete Button
					IpadLib.IOSClickByXpath(objRWIpad.Property_Photos_BtnDelete_xp, "Delete Button", true);
					
					//click on Done Button
					IpadLib.IOSCheckDisplayedByName(objRWIpad.Property_Photos_BtnDone_nm, "Done Button", true);
					IpadLib.IOSClickByName(objRWIpad.Property_Photos_BtnDone_nm, "Done Button", true);
					
					//Tap any where on the screen to close the Photos list view
					TouchAction actionTap = new TouchAction(iosdriver);
					actionTap.press(671, 24).perform().tap(671, 24);
					
					//Post Conditions
					//click on Back button for Log Out
					IpadLib.IOSCheckDisplayedByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
					
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1019 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1019 Completed");
				}
				return obj;
			} //End of function TC1019
			
			
			
			
			//TC1020 - Verify the Navigation Button
			@SuppressWarnings("static-access")
			public Reporter TC1020(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1020 Started..");
				try {		
					obj.repAddData( "Verifying Navigation Button", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
										
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
										
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Add Button
					IpadLib.IOSCheckDisplayedByName(objRWIpad.Property_Photos_AddPhotos_nm, "Add Button", true);
					IpadLib.IOSClickByName(objRWIpad.Property_Photos_AddPhotos_nm, "Add Button", true);
					
					//click on Take Picture
					IpadLib.IOSClickByName(objRWIpad.Property_Photos_TakePicture_nm, "Take Picture", true);
					IpadLib.IOSClickByName(objRWIpad.Property_Photos_BtnCamera_nm, "Camera Button", true);
					
					//click on save Button
					IpadLib.IOSClickByXpath(objRWIpad.Property_Photos_BtnSave_xp, "Save Button", true);
					
					//click on edit Button
					IpadLib.IOSCheckDisplayedByName(objRWIpad.Property_Photos_BtnEdit_nm, "Edit Button", true);
					IpadLib.IOSClickByName(objRWIpad.Property_Photos_BtnEdit_nm, "Edit Button", true);
					
					//Click on Delete Icon
					IpadLib.IOSClickByXpath(objRWIpad.Property_Photos_BtnMinus_xp, "Delete Icon", true);
					
					//click on Delete Button
					IpadLib.IOSClickByXpath(objRWIpad.Property_Photos_BtnDelete_xp, "Delete Button", true);
					
					//click on Done Button
					IpadLib.IOSCheckDisplayedByName(objRWIpad.Property_Photos_BtnDone_nm, "Done Button", true);
					IpadLib.IOSClickByName(objRWIpad.Property_Photos_BtnDone_nm, "Done Button", true);
					
					//Tap any where on the screen to close the Photos list view
					TouchAction actionTap = new TouchAction(iosdriver);
					actionTap.press(671, 24).perform().tap(671, 24);
					
					//Post Conditions
					//click on Back button for Log Out
					IpadLib.IOSCheckDisplayedByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
					
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1020 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1020 Completed");
				}
				return obj;
			} //End of function TC1020
			
			//TC1021 - Verify Home Style Button
			@SuppressWarnings("static-access")
			public Reporter TC1021(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1021 Started..");
				try {		
					obj.repAddData( "Verifying editing Home Style Button", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					//Precondition

					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
										
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
										
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
										
					
					//Click on Home Style Button
					//Home style selection
					IpadLib.IOSClickByXpath(objRWIpad.Property_BtnHomeStyle_xp, "Home Style Button", true);
					IpadLib.IOSClickByXpath(objRWIpad.Property_PopUpHomeStyle_xp, "Select Home Style", true);
					
					//Post Conditions
					//click on Back button for Log Out
					IpadLib.IOSCheckDisplayedByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1021 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1021 Completed");
				}
				return obj;
			} //End of function TC1021
			
			
			//TC1022 - Verify Exterior Type Button
			@SuppressWarnings("static-access")
			public Reporter TC1022(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1022 Started..");
				try {		
					obj.repAddData( "Verifying editing Exterior Type Button", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					//Precondition

					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
										
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
										
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					
					//Click on Home Style Button
					//Home style selection
					IpadLib.IOSClickByXpath(objRWIpad.Property_BtnExteriorType_xp, "Exterior Type Button", true);
					IpadLib.IOSClickByXpath(objRWIpad.Property_PopUpExteriorType_xp, "Exterior Type Style", true);
					
					//Post Conditions
					//click on Back button for Log Out
					IpadLib.IOSCheckDisplayedByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
					
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1022 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1022 Completed");
				}
				return obj;
			} //End of function TC1022
			
			//TC1023 - Verify availability of Back Button
			@SuppressWarnings("static-access")
			public Reporter TC1023(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1023 Started..");
				try {		
					obj.repAddData( "Verifying availability of Back Button", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					//Precondition

					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
										
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
										
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//Post Conditions
					//click on Back button for Log Out
					IpadLib.IOSCheckDisplayedByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
					
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1023 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1023 Completed");
				}
				return obj;
			} //End of function TC1023
			
			//TC1024 - Verify availability of Next Button
			@SuppressWarnings("static-access")
			public Reporter TC1024(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1024 Started..");
				try {		
					obj.repAddData( "Verifying availability of Next Button", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					//Precondition

					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
										
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
										
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//checking the availability of Next Button
					IpadLib.IOSCheckDisplayedByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
					
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1024 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1024 Completed");
				}
				return obj;
			} //End of function TC1024
			
			//TC1025 - Verify availability of Edit Button in Group Page
			@SuppressWarnings("static-access")
			public Reporter TC1025(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1024 Started..");
				try {		
					obj.repAddData( "Verifying availability of Edit Button in Group Page", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					//Precondition

					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
										
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
														
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
					
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1025 Failed!", e );
				}
				finally {
				
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1025 Completed");
				}
				return obj;
			} //End of function TC1025
			
			
			//TC1026 - Verify adding Group
			@SuppressWarnings("static-access")
			public Reporter TC1026(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1026 Started..");
				try {		
					obj.repAddData( "Verifying Adding Group", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//click on Add Group button
					IpadLib.IOSClickByXpath(objRWIpad.Group_AddGroup_BtnAdd_xp, "Add group Selection", true);
					IpadLib.IOSClickByXpath(objRWIpad.Group_AddGroup_ExteriorPopUp_xp, "Exterior Group Selection", true);
					
					//Filling Group Name
					IpadLib.IOSSetTextByXpath(objRWIpad.Group_AddGroup_DialogBoxName_xp,"Auto Test Group", "Group Name");
					IpadLib.IOSClickByName(objRWIpad.Group_AddGroup_BtnAddGroup_nm, "Add Button", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
					
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1026 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1026 Completed");
				}
				return obj;
			} //End of function TC1026
			
			//TC1027 - Verify selecting Group
			@SuppressWarnings("static-access")
			public Reporter TC1027(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1027 Started..");
				try {		
					obj.repAddData( "Verify if the User can select the added group", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group name "Exterior"
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "0");
					
					//Test starts
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroups_BtnAddGroup_xp, "Add Group Button", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_TableView_xp, "Exterior");
					String groupName = "TestGroupName";
					IpadLib.IOSSetTextByXpath(objRWIpad.Groups_ViewGroups_TxtBxGroupNamePopOver_xp,groupName, "Group Name");
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_BtnAdd_nm, "Add Button", true);
					
					//Select the added Property
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "14");
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_ViewGroups_GroupNameHeading_xp, groupName, true);
										
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1027 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1027 Completed");
				}
				return obj;
			} //End of function TC1027
			
			
			//TC1028 - Verify List in Service Type
			@SuppressWarnings("static-access")
			public Reporter TC1028(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1028 Started..");
				try {		
					obj.repAddData( "Verify if the user can able to see the List(Service, Remove, Replace) in service type", "", "", "");
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group name "Exterior"
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "0");
					
					//Test starts
					IpadLib.IOSClickByName(objRWIpad.Groups_ServiceType_nm, "Service Type", true);
					String serviceType = "Service|Remove|Replace";
					IpadLib.IOSVerifyTableCellspropertyByXpath(objRWIpad.Groups_ServiceType_ServiceTypeTableCells_xp, "name", serviceType);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ServiceType_ServiceTypeTableCells_xp, "Service");
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1028 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1028 Completed");
				}
				return obj;
			} //End of function TC1028
			
			//TC1029 - Verify selecting Service Button
			@SuppressWarnings("static-access")
			public Reporter TC1029(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1029 Started..");
				try {		
					obj.repAddData( "Verify if the user can able to select Service option from service type List", "", "", "");
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group name "Exterior"
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "1");
					
					//Test starts
					IpadLib.IOSClickByName(objRWIpad.Groups_ServiceType_nm, "Service Type", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ServiceType_ServiceTypeTableCells_xp, "Service");
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1029 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1029 Completed");
				}
				return obj;
			} //End of function TC1029
			
			//TC1030 - Verify selecting Remove Button
			@SuppressWarnings("static-access")
			public Reporter TC1030(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1030 Started..");
				try {		
					obj.repAddData( "Verify if the user can able to select Remove option from service type List", "", "", "");
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group name "Exterior"
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "1");
					
					//Test starts
					IpadLib.IOSClickByName(objRWIpad.Groups_ServiceType_nm, "Service Type", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ServiceType_ServiceTypeTableCells_xp, "Remove");
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1030 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1030 Completed");
				}
				return obj;
			} //End of function TC1030
			
			//TC1031 - Verify selecting Replace Button
			@SuppressWarnings("static-access")
			public Reporter TC1031(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1031 Started..");
				try {		
					obj.repAddData( "Verify if the user can able to select Replace option from service type List", "", "", "");
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group name "Exterior"
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "1");
					
					//Test starts
					IpadLib.IOSClickByName(objRWIpad.Groups_ServiceType_nm, "Service Type", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ServiceType_ServiceTypeTableCells_xp, "Replace");
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1031 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1031 Completed");
				}
				return obj;
			} //End of function TC1031
			
			
			//TC1032 - Verify validating the Items Values
			@SuppressWarnings("static-access")
			public Reporter TC1032(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1032 Started..");
				try {		
					obj.repAddData( "Verifying Exterior Items get added to the Group", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					IpadLib.IOSClickByXpath(objRWIpad.ListViewProperty1Name_xp, "Property 1", true);
					IpadLib.IOSCheckDisplayedByXpath(objRWIpad.PropertyDetailsPagePropertyName_xp,"Property Details Page",true);
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					IpadLib.IOSClickByName(objRWIpad.Group_ViewGroup_Exterior_nm, "Exterior", true);
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Group_ViewGroup_ExteriorHeading_nm, "Exterior", true);					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_TotalEstimate_xp, "$35.00", true);
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Group_ViewGroup_PressureWashHeading_nm, "Pressure Wash", true);
					
					//click on Pressure wash text area
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_PressureWashTextArea_xp, "Pressure Wash Text area", true);
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_PressureWashComment_xp, "Pressure Wash comment", true);
					
					//Verify the Price of the Pressure Wash
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_PressureWashPrice_xp, "300.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_TotalEstimate_xp, "$335.00", true);
					
					//Clearing all Values
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_PressureWashTextArea_xp, "Pressure Wash Text area", true);
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_PressureWashDeleteComment_xp, "Delete comment Button", true);
					IpadLib.IOSClickByName(objRWIpad.KeyBoard_HideKeyBoard_nm, "Hide Keyboard Button", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_PressureWashPrice_xp, "0", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1032 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1032 Completed");
				}
				return obj;
			} //End of function TC1032
			
			
			//TC1033 - Verify scope of work for Exterior Item
			@SuppressWarnings("static-access")
			public Reporter TC1033(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1032 Started..");
				try {		
					obj.repAddData( "Verify scope of work for Exterior Item", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					IpadLib.IOSClickByXpath(objRWIpad.ListViewProperty1Name_xp, "Property 1", true);
					IpadLib.IOSCheckDisplayedByXpath(objRWIpad.PropertyDetailsPagePropertyName_xp,"Property Details Page",true);
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					IpadLib.IOSClickByName(objRWIpad.Group_ViewGroup_Exterior_nm, "Exterior", true);
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Group_ViewGroup_ExteriorHeading_nm, "Exterior", true);					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_TotalEstimate_xp, "$35.00", true);
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Group_ViewGroup_PressureWashHeading_nm, "Pressure Wash", true);
					
					//click on Pressure wash text area
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_PressureWashTextArea_xp, "Pressure Wash Text area", true);
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_PressureWashComment_xp, "Pressure Wash comment", true);
					
					//Verify the Price of the Pressure Wash
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_PressureWashPrice_xp, "300.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_TotalEstimate_xp, "$335.00", true);
					
					//Clicking on Next Button for Scope of Work
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_TotalEstimate_xp, "Scope of work Button", true);
					
					//verifying all Items in Scope of work page
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Total_xp, "335.00", true);
					
					//Exterior Validation
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Exterior_ExteriorHeading_xp, "Exterior", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Exterior_ExteriorItemsList_xp, "Pressure Wash", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Exterior_ExteriorPrice_xp, "300.00", true);
					
					//Interior Validation
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Interior_InteriorHeading_xp, "Interior", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Interior_InteriorItemsList_xp, "Trim Bucket", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Interior_InteriorPrice_xp, "35.00", true);
					
					//click on Back button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					
					//Clearing all Values
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_PressureWashTextArea_xp, "Pressure Wash Text area", true);
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_PressureWashDeleteComment_xp, "Delete comment Button", true);
					IpadLib.IOSClickByName(objRWIpad.KeyBoard_HideKeyBoard_nm, "Hide Keyboard Button", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_PressureWashPrice_xp, "0", true);
					
					
					IpadLib .IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1033 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1033 Completed");
				}
				return obj;
			} //End of function TC1033
			
			//TC1034 - Verify the Exterior Item- "Exterior Paint" gets added to the group
			@SuppressWarnings("static-access")
			public Reporter TC1034(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1034 Started..");
				try {		
					obj.repAddData( "Verify adding to the Group the Exterior Paint All Item", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					IpadLib.IOSClickByXpath(objRWIpad.ListViewProperty1Name_xp, "Property 1", true);
					IpadLib.IOSCheckDisplayedByXpath(objRWIpad.PropertyDetailsPagePropertyName_xp,"Property Details Page",true);
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					IpadLib.IOSClickByName(objRWIpad.Group_ViewGroup_Exterior_nm, "Exterior", true);
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Group_ViewGroup_ExteriorHeading_nm, "Exterior", true);					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_TotalEstimate_xp, "$35.00", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_ExteriorPaintAllHeading_xp, "Exterior Paint - All", true);
					
					//click on Exterior Paint All
					IpadLib.IOSClickByName(objRWIpad.Group_ViewGroup_ExteriorPaintAllUpArrow_nm, "Up Arrow Button", true);
					IpadLib.IOSClickByName(objRWIpad.Group_ViewGroup_ExteriorPaintAllUpArrow_nm, "Up Arrow Button", true);
					
					//Verify the Price of the Exterior Paint All
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_ExteriorPaintPrice_xp, "1.90", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_TotalEstimate_xp, "$36.90", true);
				
			
					//Clearing all Values
					IpadLib.IOSClickByName(objRWIpad.Group_ViewGroup_ExteriorPaintAllDownArrow_nm, "Down Arrow Button", true);
					IpadLib.IOSClickByName(objRWIpad.Group_ViewGroup_ExteriorPaintAllDownArrow_nm, "Down Arrow Button", true);
					
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1034 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1034 Completed");
				}
				return obj;
			} //End of function TC1034
			
			//TC1035 - Verify the Exterior Item- "Exterior Paint" gets added to the Scope Of work
			@SuppressWarnings("static-access")
			public Reporter TC1035(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1035 Started..");
				try {		
					obj.repAddData( "Verify scope of work for Exterior Paint All Item", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					IpadLib.IOSClickByXpath(objRWIpad.ListViewProperty1Name_xp, "Property 1", true);
					IpadLib.IOSCheckDisplayedByXpath(objRWIpad.PropertyDetailsPagePropertyName_xp,"Property Details Page",true);
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					IpadLib.IOSClickByName(objRWIpad.Group_ViewGroup_Exterior_nm, "Exterior", true);
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Group_ViewGroup_ExteriorHeading_nm, "Exterior", true);					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_TotalEstimate_xp, "$35.00", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_ExteriorPaintAllHeading_xp, "Exterior Paint - All", true);
					
					//click on Exterior Paint All
					IpadLib.IOSClickByName(objRWIpad.Group_ViewGroup_ExteriorPaintAllUpArrow_nm, "Up Arrow Button", true);
					IpadLib.IOSClickByName(objRWIpad.Group_ViewGroup_ExteriorPaintAllUpArrow_nm, "Up Arrow Button", true);
					
					//Verify the Price of the Exterior Paint All
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_ExteriorPaintPrice_xp, "1.90", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_TotalEstimate_xp, "$36.90", true);
					
					//Clicking on Next Button for Scope of Work
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_TotalEstimate_xp, "Scope of work Button", true);
					
					//verifying all Items in Scope of work page
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Total_xp, "36.90", true);
					
					//Exterior Validation
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Exterior_ExteriorHeading_xp, "Exterior", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Exterior_ExteriorItemsList_xp, "Exterior Paint - All", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Exterior_ExteriorPricePaintAll_xp, "1.90", true);
					
					//Interior Validation
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Interior_InteriorHeadingPaintAll_xp, "Interior", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Interior_InteriorItemsListPaintAll_xp, "Trim Bucket", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Interior_InteriorPricePaintAll_xp, "35.00", true);
					
					//click on Back button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
				
			
					//Clearing all Values
					IpadLib.IOSClickByName(objRWIpad.Group_ViewGroup_ExteriorPaintAllDownArrow_nm, "Down Arrow Button", true);
					IpadLib.IOSClickByName(objRWIpad.Group_ViewGroup_ExteriorPaintAllDownArrow_nm, "Down Arrow Button", true);
					
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1035 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1035 Completed");
				}
				return obj;
			} //End of function TC1035
			
			//TC1036 - Verify the Scope of Work for 'Mailbox' to group
			@SuppressWarnings("static-access")
			public Reporter TC1036(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1036 Started..");
				try {		
					obj.repAddData( "Verify if the User can select Mailbox SKU to group and Validate in Scope of work", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Property_myProperties_myPropertiesTxt_nm, "My Properties", true);
					
					IpadLib.IOSClickByXpath(objRWIpad.ListViewProperty1Name_xp, "Property 1", true);
					IpadLib.IOSCheckDisplayedByXpath(objRWIpad.PropertyDetailsPagePropertyName_xp,"Property Details Page",true);
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					IpadLib.IOSClickByName(objRWIpad.Group_ViewGroup_Exterior_nm, "Exterior", true);
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Group_ViewGroup_ExteriorHeading_nm, "Exterior", true);					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_TotalEstimate_xp, "$35.00", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_ExteriorMailboxHeading_xp, "Mailbox", true);
					
					//verify the Price before selection of Mailbox
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_ExteriorMailboxTotal_xp, "0.00", true);
					
					//click on Exterior MailBox
					IpadLib.IOSClickByName(objRWIpad.Group_ViewGroup_ExteriorMailboxArrow_nm, "Arrow Button", true);
					
					//select Black Horizontal Wall-Mount mailbox
					IpadLib.IOSClickByName(objRWIpad.Group_ViewGroup_ExteriorMailbox_SKUBlackHorizontalWallMount_nm, "Black Horizontal Wall-Mount Mailbox", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_ExteriorMailbox_SKUBlackHorizontalWallMountQty_xp, "1", true);
					
					//select Black TownHouse Wall-Mount mailbox
					IpadLib.IOSClickByName(objRWIpad.Group_ViewGroup_ExteriorMailbox_SKUBlackTownHouseWallMount_nm, "Black TownHouse Wall-Mount Mailbox", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_ExteriorMailbox_SKUBlackTownHouseWallMountQty_xp, "1", true);
					
					//verify the total price of the Mailbox after selection
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_ExteriorMailboxTotal_xp, "112.46", true);
					
					//close the Mailbox 
					IpadLib.IOSClickByName(objRWIpad.Group_ViewGroup_ExteriorMailboxDownArrow_nm, "Down Arrow Button", true);
					
					//Verify the Price of the Exterior Paint All
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_TotalEstimate_xp, "$147.46", true);
					
					//Clicking on Next Button for Scope of Work
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_TotalEstimate_xp, "Scope of work Button", true);
					
					//verifying all Items in Scope of work page
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Total_xp, "147.46", true);
					
					//Exterior Validation
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Exterior_ExteriorHeading_xp, "Exterior", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Exterior_ExteriorMailbox_SKUBlackHorizontalWallMountText_xp, "Black Horizontal Wall-Mount Mailbox", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Exterior_ExteriorMailbox_SKUBlackHorizontalWallMountPrice_xp, "54.97", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Exterior_ExteriorMailbox_SKUBlackTownHouseWallMountText_xp, "Black Townhouse Wall-Mount Mailbox", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Exterior_ExteriorMailbox_SKUBlackTownHouseWallMountPrice_xp, "57.49", true);
					
					//Interior Validation
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Interior_InteriorMailboxHeading_xp, "Interior", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Interior_InteriorMailboxList_xp, "Trim Bucket", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Interior_InteriorMailboxPrice_xp, "35.00", true);
					
					//click on Back button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
				
			
					//Clearing all Values
					IpadLib.IOSClickByName(objRWIpad.Group_ViewGroup_ExteriorMailboxArrow_nm, "Arrow Button", true);
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_ExteriorMailbox_SKUBlackHorizontalWallMountQty_xp, "Opening KeyPad", true);
					IpadLib.IOSClickByName(objRWIpad.Exterior_ExteriorButtonClearKeypad_nm, "Clear Button Button", true);
					IpadLib.IOSClickByName(objRWIpad.Exterior_ExteriorButtonDownKeypad_nm, "KeyPad Down Button", true);
					
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_ExteriorMailbox_SKUBlackTownHouseWallMountQty_xp, "Opening KeyPad", true);
					IpadLib.IOSClickByName(objRWIpad.Exterior_ExteriorButtonClearKeypad_nm, "Clear Button Button", true);
					IpadLib.IOSClickByName(objRWIpad.Exterior_ExteriorButtonDownKeypad_nm, "KeyPad Down Button", true);
					IpadLib.IOSClickByName(objRWIpad.Group_ViewGroup_ExteriorMailboxDownArrow_nm, "Down Arrow Button", true);
				
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1036 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1036 Completed");
				}
				return obj;
			} //End of function TC1036
			
			//TC1037 - Verify the Table cells
			@SuppressWarnings("static-access")
			public Reporter TC1037(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1037 Started..");
				try {		
					obj.repAddData( "Verify the Table cells", "", "", "");
					
					//Precondition

					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
										
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
										
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "1");
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1037 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1037 Completed");
				}
				return obj;
			} //End of function TC1037
			
			
			
			
			//BXK8854 
			//New Scenarios for Ipad Automation
			/*
			 * This test case will automate the Ipad flow for
			 * Exterior Group
			 */
			//TC1040 - Verify the Flow for Exterior Group
			@SuppressWarnings("static-access")
			public Reporter TC1040(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1040 Started..");
				try {		
					obj.repAddData( "Verify if the User can walk through the entire flow for Exterior Group", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					Thread.sleep(10000);
									
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group - Exterior
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "0");
					
					//Exterior verification
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_ExteriorTitle_nm, "Exterior", true);
					
					//Pressure Wash 
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_Exterior_PressureWash_Title_nm, "Pressure Wash", true);	
					IpadLib.IOSClickByName(objRWIpad.Groups_ServiceType_nm, "Service Type", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ServiceType_ServiceTypeTableCells_xp, "Service");
					IpadLib.IOSClickByXpath(objRWIpad.Groups_Exterior_PressureWash_TextView_xp, "Pressure Wash Text View", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_Exterior_PressureWash_Comment_xp, "Pressure Wash Comments", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Exterior_PressureWash_Price_xp, "300.00", true);
					
					
					//Exterior-Paint All
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Exterior_ExteriorPaintAll_Title_xp, "Exterior Paint - All", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Exterior_ExteriorPaintAll_UpArrow_nm, "Up Arrow Button", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Exterior_ExteriorPaintAll_UpArrow_nm, "Up Arrow Button", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Exterior_ExteriorPaintAll_Price_xp, "1.90", true);
					
					//LandScape
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_Exterior_LanscapeTitle_nm, "Landscape", true);
					IpadLib.IOSSetTextByXpath(objRWIpad.Groups_Exterior_Landscape_TextView_xp, "Test Auto Comment", "LandScape Text");
					IpadLib.IOSClickByName(objRWIpad.KeyBoard_HideKeyBoard_nm, "Hide KeyBoard Button", true);
					IpadLib.IOSSetTextByXpath(objRWIpad.Groups_Exterior_Landscape_Price_xp, "100", "LandScape Price");
					IpadLib.IOSClickByName(objRWIpad.Exterior_ExteriorButtonDownKeypad_nm, "Hide Keypad Button", true);
					
					//MailBox
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Exterior_MailBox_Title_xp, "Mailbox", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_ServiceType_nm, "Service Type", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ServiceType_ServiceTypeTableCells_xp, "Replace");
					IpadLib.IOSClickByName(objRWIpad.Groups_Exterior_MailBox_SKUSideArrow_nm, "Side Arrow Button", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Exterior_MailBox_BlackHorizontalWallMount_nm, "Black Horizontal Wall Mount Mailbox", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Exterior_MailBox_BlackTownHouseWallMount_nm, "Black TownHouse Wall Mount Mailbox", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Exterior_MailBox_SKUDownArrow_nm, "Down Arrow Button", true);
					
					
					
					//Verifying the Total for this Group Page
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "516.90", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					
					//Scope Of Work - Exterior
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Exterior_TotalPrice_xp, "516.90", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_ExteriorTitle_xp, "Exterior", true);
					//Sub Exterior
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Exterior_PressureWash_Title_xp, "Pressure Wash", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Exterior_PressureWash_Price_xp, "300.00", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Exterior_ExteriorPaintAll_Title_xp, "Exterior Paint - All", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Exterior_ExteriorPaintAll_Price_xp, "1.90", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Exterior_LandScape_Title_xp, "Landscape", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Exterior_LandScape_Price_xp, "100.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Exterior_BlackHorizontalWallMount_Title_xp, "Black Horizontal Wall-Mount Mailbox", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Exterior_BlackHorizontalWallMount_Price_xp, "40.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Exterior_BlackTownHouseWallMount_Title_xp, "Black Townhouse Wall-Mount Mailbox", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Exterior_BlackTownHouseWallMount_Price_xp, "40.00", true);
					
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1040 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1040 Completed");
				}
				return obj;
			} //End of function TC1040
			
			//TC1041 - Verify the Flow for Interior
			@SuppressWarnings("static-access")
			public Reporter TC1041(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1041 Started..");
				try {		
					obj.repAddData( "Verify if the User can walk through the entire flow for Interior Group", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
					
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
				
					}
					
					Thread.sleep(10000);
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "1");
					
					//Interior Walk Through
					//Interior verification
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_InteriorTitle_nm, "Interior", true);
					
					//Interior Paint
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Interior_InteriorPaint_Title_xp, "Interior Paint", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_InteriorPaint_UpArrow_nm, "Up Arrow Button", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_InteriorPaint_UpArrow_nm, "Up Arrow Button", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_ServiceType_nm, "Service Type", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ServiceType_ServiceTypeTableCells_xp, "Service");
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Interior_InteriorPaint_Price_xp, "2.90", true);
					
					//Tenant
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Interior_Tenant_Title_xp, "Tenant", true);
					IpadLib.IOSSetTextByXpath(objRWIpad.Groups_Interior_Tenant_TextView_xp, "Test Comment", "Text View for Tenant");
					IpadLib.IOSClickByName(objRWIpad.KeyBoard_HideKeyBoard_nm, "Hide Keyboard Button", true);
					IpadLib.IOSSetTextByXpath(objRWIpad.Groups_Interior_Tenant_TextArea_xp, "100", "Text View for Tenant");
					IpadLib.IOSClickByName(objRWIpad.Exterior_ExteriorButtonDownKeypad_nm, "Hide Keypad Button", true);

					
					//calculating the Floor Type
					IpadLib.IOSSetTextByXpath(objRWIpad.Groups_Interior_Flooring_Width_xp, "2", "Width Text box");
					IpadLib.IOSClickByName(objRWIpad.Exterior_ExteriorButtonDownKeypad_nm, "Hide Keypad Button", true);
					IpadLib.IOSSetTextByXpath(objRWIpad.Groups_Interior_Flooring_Length_xp, "2", "Length Text box");
					IpadLib.IOSClickByName(objRWIpad.Exterior_ExteriorButtonDownKeypad_nm, "Hide Keypad Button", true);
					
					//select carpet for current floor
					IpadLib.IOSClickByXpath(objRWIpad.Groups_Interior_Flooring_BtnCurrentFlooring_xp, "Current Flooring", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_Interior_Flooring_CurrentFlooringTableCells_xp, "Carpet");
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_Flooring_BtnReplaceWith_nm, "Replace With Radio Button", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_Interior_Flooring_BtnNewFlooring_xp, "New Flooring", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_Interior_Flooring_NewFlooringTableCells_xp, "Tile"); 
					
					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$163.90", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Interior_TotalPrice_xp, "163.90", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Interior_Heading_xp, "Interior", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Interior_Flooring_Heading_xp, "Flooring", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Interior_Flooring_Title_xp, "SqFt of Tile", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Interior_Flooring_Area_xp, "4", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Interior_Flooring_Unit_xp, "26.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Interior_Flooring_Price_xp, "26.00", true);
						
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1041 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1041 Completed");
				}
				return obj;
			} //End of function TC1041
			
			//TC1042 - Verify the Flow for Appliances
			@SuppressWarnings("static-access")
			public Reporter TC1042(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1042 Started..");
				try {		
					obj.repAddData( "Verify if the User can walk through the entire flow for Appliances Group", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
					
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
				
					}
					
					Thread.sleep(10000);
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "2");
					
					//Appliances Group Walk Through
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_AppliancesTitle_nm, "Appliances", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Appliances_ApplianceInstallation_Title_xp, "Appliance Installation", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_ServiceType_nm, "Service Type", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ServiceType_ServiceTypeTableCells_xp, "Service");
					IpadLib.IOSClickByXpath(objRWIpad.Groups_Appliances_TextView_xp, "Appliance Installation Text view", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_Appliances_TextViewComment_xp, "Appliance Installation Comments", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Appliances_TextArea_xp, "150.00", true);
					
					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$185.00", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//Scope of Work
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Interior_TotalPrice_xp, "185.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Appliance_Interior_Heading_xp, "Interior", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Appliance_TrimBucket_Title_xp, "Trim Bucket", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Appliance_TrimBucket_Price_xp, "35.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Appliance_ApplianceInstallation_Title_xp, "Appliance Installation", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Appliance_ApplianceInstallation_Price_xp, "150.00", true);
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1042 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1042 Completed");
				}
				return obj;
			} //End of function TC1042
			
			//TC1043 - Verify the Flow for Entry
			@SuppressWarnings("static-access")
			public Reporter TC1043(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1043 Started..");
				try {		
					obj.repAddData( "Verify if the User can walk through the entire flow for Entry Group", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
					
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
				
					}
					
					Thread.sleep(5000);
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "3");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_EnrtyTitle_nm, "Entry", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Entry_ExteriorDoors_Title_xp, "Exterior Doors", true);
					
					IpadLib.IOSClickByName(objRWIpad.Groups_ServiceType_nm, "Service Type", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ServiceType_ServiceTypeTableCells_xp, "Service");
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Side Arrow", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_SKU1_nm, "6-Panel Primed Steel Slab Entry Door", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Down Arrow", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Entry_ExteriorDoors_Price_xp, "60.00", true);
					
					//calculating the Floor Type
					IpadLib.IOSSetTextByXpath(objRWIpad.Groups_Interior_Flooring_Width_xp, "2", "Width Text box");
					IpadLib.IOSClickByName(objRWIpad.Exterior_ExteriorButtonDownKeypad_nm, "Hide Keypad Button", true);
					IpadLib.IOSSetTextByXpath(objRWIpad.Groups_Interior_Flooring_Length_xp, "2", "Length Text box");
					IpadLib.IOSClickByName(objRWIpad.Exterior_ExteriorButtonDownKeypad_nm, "Hide Keypad Button", true);
					
					//Painting Option
					//select carpet for current floor
					IpadLib.IOSClickByXpath(objRWIpad.Groups_Interior_Flooring_BtnCurrentFlooring_xp, "Current Flooring", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_Interior_Flooring_CurrentFlooringTableCells_xp, "Carpet");
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_Flooring_BtnReplaceWith_nm, "Replace With Radio Button", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_Interior_Flooring_BtnNewFlooring_xp, "New Flooring", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_Interior_Flooring_NewFlooringTableCells_xp, "Tile");
					
					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$121.00", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_TotalPrice_xp, "121.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_FlooringHeading_xp, "Flooring", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_FlooringTitle_xp, "SqFt of Tile", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_FlooringPrice_xp, "26.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_InteriorHeading_xp, "Interior", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_InteriorTitle_xp, "Trim Bucket", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_InteriorPrice_xp, "35.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_EntryHeading_xp, "Entry", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_EntryTitle_xp, "Premium 6-Panel Primed Steel Slab Entry Door", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_EntryPrice_xp, "60.00", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1043 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1043 Completed");
				}
				return obj;
			} //End of function TC1043
			
			//TC1044 - Verify the Flow for Living Room
			@SuppressWarnings("static-access")
			public Reporter TC1044(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1044 Started..");
				try {		
					obj.repAddData( "Verify if the User can walk through the entire flow for Living Room Group", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
					
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
				
					}
					
					Thread.sleep(8000);
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "4");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_LivingRoomTitle_nm, "Living Room", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_LivingRoom_CeilingFan_Title_xp, "Ceiling Fans", true);
					
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Arrow1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_LivingRoom_CeilingSKU1_nm, "SKU1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Arrow Down", true);
					
					//calculating the Floor Type
					IpadLib.IOSSetTextByXpath(objRWIpad.Groups_Interior_Flooring_Width_xp, "2", "Width Text box");
					IpadLib.IOSClickByName(objRWIpad.Exterior_ExteriorButtonDownKeypad_nm, "Hide Keypad Button", true);
					IpadLib.IOSSetTextByXpath(objRWIpad.Groups_Interior_Flooring_Length_xp, "2", "Length Text box");
					IpadLib.IOSClickByName(objRWIpad.Exterior_ExteriorButtonDownKeypad_nm, "Hide Keypad Button", true);
					
					//Painting Option
					//select carpet for current floor
					IpadLib.IOSClickByXpath(objRWIpad.Groups_Interior_Flooring_BtnCurrentFlooring_xp, "Current Flooring", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_Interior_Flooring_CurrentFlooringTableCells_xp, "Carpet");
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_Flooring_BtnReplaceWith_nm, "Replace With Radio Button", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_Interior_Flooring_BtnNewFlooring_xp, "New Flooring", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_Interior_Flooring_NewFlooringTableCells_xp, "Tile");
					
					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$61.00", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_TotalPrice_xp, "61.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_FlooringHeading_xp, "Flooring", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_FlooringTitle_xp, "SqFt of Tile", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_FlooringPrice_xp, "26.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_InteriorHeading_xp, "Interior", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_InteriorTitle_xp, "Trim Bucket", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_LivingRoom_InteriorPrice_xp, "35.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_LivingRoom_LivingRoomHeading_xp, "Living Room", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_LivingRoom_LivingRoomTitle_xp, "42", true);
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1044 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1044 Completed");
				}
				return obj;
			} //End of function TC1044
			
			
			//TC1045 - Verify the Flow for Bed Room2
			@SuppressWarnings("static-access")
			public Reporter TC1045(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1045 Started..");
				try {		
					obj.repAddData( "Verify if the User can walk through the entire flow for Living Room Group", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
					
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
				
					}
					
					Thread.sleep(8000);
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "4");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_LivingRoomTitle_nm, "Living Room", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_LivingRoom_CeilingFan_Title_xp, "Ceiling Fans", true);
					
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Arrow1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_LivingRoom_CeilingSKU1_nm, "SKU1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Arrow Down", true);
					
					//calculating the Floor Type
					IpadLib.IOSSetTextByXpath(objRWIpad.Groups_Interior_Flooring_Width_xp, "2", "Width Text box");
					IpadLib.IOSClickByName(objRWIpad.Exterior_ExteriorButtonDownKeypad_nm, "Hide Keypad Button", true);
					IpadLib.IOSSetTextByXpath(objRWIpad.Groups_Interior_Flooring_Length_xp, "2", "Length Text box");
					IpadLib.IOSClickByName(objRWIpad.Exterior_ExteriorButtonDownKeypad_nm, "Hide Keypad Button", true);
					
					//Painting Option
					//select carpet for current floor
					IpadLib.IOSClickByXpath(objRWIpad.Groups_Interior_Flooring_BtnCurrentFlooring_xp, "Current Flooring", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_Interior_Flooring_CurrentFlooringTableCells_xp, "Carpet");
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_Flooring_BtnReplaceWith_nm, "Replace With Radio Button", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_Interior_Flooring_BtnNewFlooring_xp, "New Flooring", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_Interior_Flooring_NewFlooringTableCells_xp, "Tile");
					
					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$61.00", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_TotalPrice_xp, "61.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_FlooringHeading_xp, "Flooring", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_FlooringTitle_xp, "SqFt of Tile", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_FlooringPrice_xp, "26.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_InteriorHeading_xp, "Interior", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_InteriorTitle_xp, "Trim Bucket", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_LivingRoom_InteriorPrice_xp, "35.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_LivingRoom_LivingRoomHeading_xp, "Living Room", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_LivingRoom_LivingRoomTitle_xp, "42", true);
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1045 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1045 Completed");
				}
				return obj;
			} //End of function TC1045
			
			
			//TC1046 - Verify the Flow for Bed Room3
			@SuppressWarnings("static-access")
			public Reporter TC1046(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1045 Started..");
				try {		
					obj.repAddData( "Verify if the User can walk through the entire flow for Living Room Group", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
					
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
				
					}
					
					Thread.sleep(8000);
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "4");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_LivingRoomTitle_nm, "Living Room", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_LivingRoom_CeilingFan_Title_xp, "Ceiling Fans", true);
					
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Arrow1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_LivingRoom_CeilingSKU1_nm, "SKU1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Arrow Down", true);
					
					//calculating the Floor Type
					IpadLib.IOSSetTextByXpath(objRWIpad.Groups_Interior_Flooring_Width_xp, "2", "Width Text box");
					IpadLib.IOSClickByName(objRWIpad.Exterior_ExteriorButtonDownKeypad_nm, "Hide Keypad Button", true);
					IpadLib.IOSSetTextByXpath(objRWIpad.Groups_Interior_Flooring_Length_xp, "2", "Length Text box");
					IpadLib.IOSClickByName(objRWIpad.Exterior_ExteriorButtonDownKeypad_nm, "Hide Keypad Button", true);
					
					//Painting Option
					//select carpet for current floor
					IpadLib.IOSClickByXpath(objRWIpad.Groups_Interior_Flooring_BtnCurrentFlooring_xp, "Current Flooring", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_Interior_Flooring_CurrentFlooringTableCells_xp, "Carpet");
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_Flooring_BtnReplaceWith_nm, "Replace With Radio Button", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_Interior_Flooring_BtnNewFlooring_xp, "New Flooring", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_Interior_Flooring_NewFlooringTableCells_xp, "Tile");
					
					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$61.00", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_TotalPrice_xp, "61.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_FlooringHeading_xp, "Flooring", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_FlooringTitle_xp, "SqFt of Tile", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_FlooringPrice_xp, "26.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_InteriorHeading_xp, "Interior", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_InteriorTitle_xp, "Trim Bucket", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_LivingRoom_InteriorPrice_xp, "35.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_LivingRoom_LivingRoomHeading_xp, "Living Room", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_LivingRoom_LivingRoomTitle_xp, "42", true);
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1046 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1046 Completed");
				}
				return obj;
			} //End of function TC1046
			
			//TC1047 - Verify if the User can walk through the entire flow for Family Room Group
			@SuppressWarnings("static-access")
			public Reporter TC1047(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1047 Started..");
				try {		
					obj.repAddData( "Verify if the User can walk through the entire flow for Family Room Group", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
					
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
				
					}
					Thread.sleep(8000);
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "5");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_FamilyRoomTitle_nm, "Family Room", true);
					
					//Drywall Repair
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_InteriorPaint_UpArrow_nm, "Up Arrow Button", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_InteriorPaint_UpArrow_nm, "Up Arrow Button", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_ServiceType_nm, "Service Type", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ServiceType_ServiceTypeTableCells_xp, "Service");
					
					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$107.90", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_TotalPrice_xp, "107.90", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_FamilyRoom_Heading_xp, "Family Room", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_FamilyRoom_Drywall_Title_xp, "Drywall Repair", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_FamilyRoom_Drywall_Price_xp, "72.90", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1047 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1047 Completed");
				}
				return obj;
			} //End of function TC1047
			
			
			//TC1048 - Verify the flow for Dining Room 
			@SuppressWarnings("static-access")
			public Reporter TC1048(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1048 Started..");
				try {		
					obj.repAddData( "Verify if the User can walk through the entire flow for Dining Room Group", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
					
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
				
					}
					Thread.sleep(8000);
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "6");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_DiningRoomTitle_nm, "Dining Room", true);
					
					//Kitchen and Dining
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_DiningRoom_KitchenDining_Title_xp, "Kitchen and Dining Lighting", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Arrow1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_DiningRoom_KitchenDiningSKU2_nm, "SKU2", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Arrow Down", true);
					
					//Drywall Repair
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_InteriorPaint_UpArrow_nm, "Up Arrow Button", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_ServiceType_nm, "Service Type", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ServiceType_ServiceTypeTableCells_xp, "Service");
					
					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$91.45", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_TotalPrice_xp, "91.45", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_DiningRoom_Heading_xp, "Dining Room", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_KitchenDining_Price_xp, "20.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_DryWallRepair_Title_xp, "Drywall Repair", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_DryWallRepair_Price_xp, "36.45", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1048 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1048 Completed");
				}
				return obj;
			} //End of function TC1048
			
			//TC1049 - Verify the flow for Kitchen 
			@SuppressWarnings("static-access")
			public Reporter TC1049(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1049 Started..");
				try {		
					obj.repAddData( "Verify if the User can walk through the entire flow for Kitchen Group", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
					
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
				
					}
					Thread.sleep(8000);
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "7");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_KitchenTitle_nm, "Kitchen", true);
					
					//Kitchen and Dining
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Kitchen_KitchenDining_Title_xp, "Kitchen and Dining Lighting", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Arrow1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Kitchen_KitchenDiningSKU1_nm, "SKU1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Arrow Down", true);
					
					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$55.00", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_TotalPrice_xp, "55.00", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Kitchen_Heading_xp, "Kitchen", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Kitchen_Price_xp, "20.00", true);
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();

				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1049 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1049 Completed");
				}
				return obj;
			} //End of function TC1049
			
			
			//TC1050 - Verify the flow for Master Bedroom
			@SuppressWarnings("static-access")
			public Reporter TC1050(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1050 Started..");
				try {		
					obj.repAddData( "Verify if the User can walk through the entire flow for Master BedRoom Group", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
					
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
				
					}
					Thread.sleep(8000);
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "8");
					
					//Bedroom Lighting
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_MasterBedroom_BedroomLighting_xp, "Bedroom Lighting", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_MasterBedroom_SKUArrow_xp, "Arrow1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_MasterBedRoom_LightingSKU1_nm, "SKU1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Arrow Down", true);
					
					
					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$55.00", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_MasterBedroom_Heading_xp, "Master Bedroom", true);
					
						
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
					
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1050 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1050 Completed");
				}
				return obj;
			} //End of function TC1050
			
			//TC1051 - Verify the flow for Master Bathroom
			@SuppressWarnings("static-access")
			public Reporter TC1051(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1051 Started..");
				try {		
					obj.repAddData( "Verify if the User can walk through the entire flow for Master BathRoom Group", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
					
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
				
					}
					Thread.sleep(8000);
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "8");
					
					//Bedroom Lighting
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_MasterBedroom_BedroomLighting_xp, "Bedroom Lighting", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_MasterBedroom_SKUArrow_xp, "Arrow1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_MasterBedRoom_LightingSKU1_nm, "SKU1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Arrow Down", true);
					
					
					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$55.00", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_MasterBedroom_Heading_xp, "Master Bedroom", true);
					
						
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1051 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1051 Completed");
				}
				return obj;
			} //End of function TC1051
			
			
			//TC1052 - Verify the flow for Hallways
			@SuppressWarnings("static-access")
			public Reporter TC1052(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1052 Started..");
				try {		
					obj.repAddData( "Verify if the User can walk through the entire flow for hallway Group", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
					
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
				
					}
					Thread.sleep(8000);
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "10");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_HallwaysTitle_nm, "Hallways", true);
					
					
					//Hall Lights
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Hallways_HallLight_Title_xp, "Hall Light", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Arrow1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Hallways_SKU1_nm, "SKU1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Arrow Down", true);
					
					//Drywall Repair
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_InteriorPaint_UpArrow_nm, "Up Arrow Button", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_ServiceType_nm, "Service Type", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ServiceType_ServiceTypeTableCells_xp, "Service");
					

					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$91.45", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Hallways_Heading_xp, "Hallways", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Hallways_TotalPrice_xp, "91.45", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Hallways_Light_Title_xp, "Brushed Nickel 2-Light Flush Mount", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Hallways_Light_Price_xp, "20.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Hallways_Drywall_Title_xp, "Drywall Repair", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Hallways_Drywall_Price_xp, "36.45", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1052 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1052 Completed");
				}
				return obj;
			} //End of function TC1052
			
			//TC1053 - Verify the flow for Laundry
			@SuppressWarnings("static-access")
			public Reporter TC1053(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1053 Started..");
				try {		
					obj.repAddData( "Verify if the User can walk through the entire flow for Laundry Group", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
					
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
				
					}
					Thread.sleep(8000);
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "11");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_LaundryTitle_nm, "Laundry Room", true);
					
					
					//Lights
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Laundry_Lighting_Title_xp, "Lighting", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Arrow1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Laundry_SKU1_nm, "SKU1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Arrow Down", true);
					
					//Drywall Repair
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_InteriorPaint_UpArrow_nm, "Up Arrow Button", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_ServiceType_nm, "Service Type", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ServiceType_ServiceTypeTableCells_xp, "Service");
					

					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$71.45", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Laundry_Heading_xp, "Laundry Room", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Laundry_TotalPrice_xp, "71.45", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Laundry_Light_Title_xp, "13/16 in. High-Carbon Steel Service Entrance Cable Staple - Graphite Metallic (25-Pack)", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Laundry_Drywall_Title_xp, "Drywall Repair", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Laundry_Drywall_Price_xp, "36.45", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();

				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1053 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1053 Completed");
				}
				return obj;
			} //End of function TC1053
			
			
			//TC1054 - Verify the flow for Garage or Carport
			@SuppressWarnings("static-access")
			public Reporter TC1054(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1054 Started..");
				try {		
					obj.repAddData( "Verify if the User can walk through the entire flow for Garage or Carport", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
					
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
				
					}
					Thread.sleep(8000);
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "12");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_GarageTitle_nm, "Garage or Carport", true);
					
					
					//Garage Door
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Garage_Door_Title_xp, "Garage Door", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Arrow1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Garage_SKU1_nm, "SKU1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Arrow Down", true);
					

					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$170.00", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Garage_Heading_xp, "Garage or Carport", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Laundry_TotalPrice_xp, "170.00", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1054 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1054 Completed");
				}
				return obj;
			} //End of function TC1054
			
			
			//TC1055 - Verify the flow for Basement
			@SuppressWarnings("static-access")
			public Reporter TC1055(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1055 Started..");
				try {		
					obj.repAddData( "Verify if the User can walk through the entire flow for Basement", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
					
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
				
					}
					Thread.sleep(8000);
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "13");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_BasementTitle_nm, "Basement", true);
					
					//Interior Paint
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Basement_InteriorPaint_Title_xp, "Interior Paint", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_InteriorPaint_UpArrow_nm, "Up Arrow Button", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_ServiceType_nm, "Service Type", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ServiceType_ServiceTypeTableCells_xp, "Service");
					
					
					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$36.45", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Basement_Heading_xp, "Basement", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Basement_TotalPrice_xp, "36.45", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Basement_Title_xp, "Interior Paint", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Basement_Price_xp, "1.45", true);
										
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1055 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1055 Completed");
				}
				return obj;
			} //End of function TC1055
			
			//TC1056 - Verify the Flow for the Entire Group
			//Property walk for a Property
			@SuppressWarnings("static-access")
			public Reporter TC1056(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1056 Started..");
				try {
					//Import Fillo
					Fillo fillo = new Fillo();
					Connection connection = fillo.getConnection("/Users/skedas/Bharat/Professional/sampleTry/IPAD_Nitro.xlsx");
					
					
					
					obj.repAddData( "Verify if the User can walk through the entire flow for All the Groups", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//EXTERIOR FLOW
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "0");
					
					//Exterior verification
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_ExteriorTitle_nm, "Exterior", true);
					
					//Pressure Wash 
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_Exterior_PressureWash_Title_nm, "Pressure Wash", true);	
					IpadLib.IOSClickByXpath(objRWIpad.Groups_Exterior_PressureWash_TextView_xp, "Pressure Wash Text View", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_Exterior_PressureWash_Comment_xp, "Pressure Wash Comments", true);
					
					//Exterior-Paint All
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Exterior_ExteriorPaintAll_Title_xp, "Exterior Paint - All", true);
					
					IpadLib.IOSClickByName(objRWIpad.Groups_Exterior_ExteriorPaintAll_UpArrow_nm, "Up Arrow Button", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Exterior_ExteriorPaintAll_UpArrow_nm, "Up Arrow Button", true);
					
					//LandScape
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_Exterior_LanscapeTitle_nm, "Landscape", true);
					IpadLib.IOSSetTextByXpath(objRWIpad.Groups_Exterior_Landscape_TextView_xp, "Test Auto Comment", "LandScape Text");
					IpadLib.IOSClickByName(objRWIpad.KeyBoard_HideKeyBoard_nm, "Hide KeyBoard Button", true);
					IpadLib.IOSSetTextByXpath(objRWIpad.Groups_Exterior_Landscape_Price_xp, "100", "LandScape Price");
					IpadLib.IOSClickByName(objRWIpad.Exterior_ExteriorButtonDownKeypad_nm, "Hide Keypad Button", true);
					
					//MailBox
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Exterior_MailBox_Title_xp, "Mailbox", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Exterior_MailBox_SKUSideArrow_nm, "Side Arrow Button", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Exterior_MailBox_BlackHorizontalWallMount_nm, "Black Horizontal Wall Mount Mailbox", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Exterior_MailBox_BlackTownHouseWallMount_nm, "Black TownHouse Wall Mount Mailbox", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Exterior_MailBox_SKUDownArrow_nm, "Down Arrow Button", true);
					
					//INTERIOR FLOW
					//Interior verification
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "1");
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_InteriorTitle_nm, "Interior", true);
					
					//Interior Paint
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Interior_InteriorPaint_Title_xp, "Interior Paint", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_InteriorPaint_UpArrow_nm, "Up Arrow Button", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_InteriorPaint_UpArrow_nm, "Up Arrow Button", true);
					
					
					//Paint Materials
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Interior_PaintMaterials_Title_xp, "Paint Materials", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_PaintMaterials_SideArrow_nm, "SKU Arrow", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_PaintMaterials_SKUPaint2_nm, "Behr Ppi Flat 1050 Upw 5Gal", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_PaintMaterials_DownArrow_nm, "Down Arrow", true);
					
		
					
					//APPLIANCES FLOW
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "2");
					
					//Appliances Group Walk Through
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_AppliancesTitle_nm, "Appliances", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Appliances_ApplianceInstallation_Title_xp, "Appliance Installation", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_Appliances_TextView_xp, "Appliance Installation Text view", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_Appliances_TextViewComment_xp, "Appliance Installation Comments", true);
					
					//ENTRY FLOW

					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "3");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_EnrtyTitle_nm, "Entry", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Entry_ExteriorDoors_Title_xp, "Exterior Doors", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Side Arrow", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_SKU1_nm, "6-Panel Primed Steel Slab Entry Door", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Down Arrow", true);
					
					
					//LIVING ROOM FLOW
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "4");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_LivingRoomTitle_nm, "Living Room", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_LivingRoom_CeilingFan_Title_xp, "Ceiling Fans", true);
					
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Arrow1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_LivingRoom_CeilingSKU1_nm, "SKU1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Arrow Down", true);
					
					
					//FAMILY ROOM FLOW
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "5");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_FamilyRoomTitle_nm, "Family Room", true);
					
					//Ceiling Fans
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_FamilyRoom_CeilingFan_Title_xp, "Ceiling Fans", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Arrow1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_BedRoom_CeilingSKU1_nm, "SKU1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Arrow Down", true);
					
					//Drywall Repair
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_FamilyRoom_DrywallRepair_Title_xp, "Drywall Repair", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_InteriorPaint_UpArrow_nm, "Up Arrow Button", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_InteriorPaint_UpArrow_nm, "Up Arrow Button", true);
					
					
					//DINING ROOM FLOW
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "6");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_DiningRoomTitle_nm, "Dining Room", true);
					
					//Kitchen and Dining
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_DiningRoom_KitchenDining_Title_xp, "Kitchen and Dining Lighting", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Arrow1", true);
					//IpadLib.IOSClickByName(objRWIpad.Groups_DiningRoom_KitchenDiningSKU1_nm, "SKU1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Arrow Down", true);
					
					//Drywall Repair
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_DiningRoom_DrywallRepair_Title_xp, "Drywall Repair", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_InteriorPaint_UpArrow_nm, "Up Arrow Button", true);
					
					//KITCHEN FLOW
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "7");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_KitchenTitle_nm, "Kitchen", true);
					
					//Kitchen and Dining
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Kitchen_KitchenDining_Title_xp, "Kitchen and Dining Lighting", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Arrow1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Kitchen_KitchenDiningSKU1_nm, "SKU1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Arrow Down", true);
					
					//MASTER BEDROOM FLOW
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "8");
					
					//Ceiling Fans
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_LivingRoom_CeilingFan_Title_xp, "Ceiling Fans", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Arrow1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_BedRoom_CeilingSKU1_nm, "SKU1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Arrow Down", true);
					
					//MASTER BATHROOM FLOW
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "9");
					
					//Bathroom faucets and Sinks
					//IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_MasterBathroom_BathroomFaucetsSinks_xp, "Bathroom Faucets and Sinks", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Arrow1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_MasterBathroom_SKU1_nm, "SKU1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Arrow Down", true);
					
					//HALLWAYS FLOW
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "10");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_HallwaysTitle_nm, "Hallways", true);
					
					
					//Hall Lights
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Hallways_HallLight_Title_xp, "Hall Light", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Arrow1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Hallways_SKU1_nm, "SKU1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Arrow Down", true);
					
					//Drywall Repair
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_DiningRoom_DrywallRepair_Title_xp, "Drywall Repair", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_InteriorPaint_UpArrow_nm, "Up Arrow Button", true);
					
					//LAUNDRY ROOM FLOW
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "11");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_LaundryTitle_nm, "Laundry Room", true);
					
					
					//Drywall Repair
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_DiningRoom_DrywallRepair_Title_xp, "Drywall Repair", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_InteriorPaint_UpArrow_nm, "Up Arrow Button", true);
					
					//GARAGE OR CARPORT FLOW
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "12");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_GarageTitle_nm, "Garage or Carport", true);
					
					
					//Garage Door
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Garage_Door_Title_xp, "Garage Door", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Arrow1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Garage_SKU1_nm, "SKU1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Arrow Down", true);
					
					//BASEMENT FLOW
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "13");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_BasementTitle_nm, "Basement", true);
					
					//Interior Paint
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Basement_InteriorPaint_Title_xp, "Interior Paint", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_InteriorPaint_UpArrow_nm, "Up Arrow Button", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
									
									
					//SCOPE OF WORK
					IpadLib.IOSCheckDisplayedByName(objRWIpad.ScopeOfWork_MyProperties_nm, "My Properties", true);
					
					//Check for Budget Page
					Thread.sleep(15000);
					
					
					//GROUP1
					
					String GroupOne_name = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Exterior_ExteriorHeading_xp);
					String GroupOne_ItemOne_Title = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Exterior_ExteriorOne_Title_xp);
					String GroupOne_ItemOne_Comments = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Exterior_ExteriorOne_Comments_xp);
					String GroupOne_ItemOne_Quantity = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Exterior_ExteriorOne_Qty_xp);
					String GroupOne_ItemOne_UnitPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Exterior_ExteriorOne_UnitPrice_xp);
					String GroupOne_ItemOne_TotalPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Exterior_ExteriorOne_TotalPrice_xp);
					
					String insertGroupOneItemone = "INSERT INTO Ipad(GroupName, ItemTitle, ItemComments, ItemQuantity, ItemUnitPrice, ItemTotalPrice) VALUES ('" +GroupOne_name+ "', '" +GroupOne_ItemOne_Title+ "', '" +GroupOne_ItemOne_Comments+ "', '" +GroupOne_ItemOne_Quantity+ "', '" +GroupOne_ItemOne_UnitPrice+ "', '" +GroupOne_ItemOne_TotalPrice+ "')";
					connection.executeUpdate(insertGroupOneItemone);
					
					String GroupOne_ItemTwo_Title = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Exterior_ExteriorTwo_Title_xp);
					String GroupOne_ItemTwo_Comments = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Exterior_ExteriorTwo_Comments_xp);
					String GroupOne_ItemTwo_Quantity = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Exterior_ExteriorTwo_Qty_xp);
					String GroupOne_ItemTwo_UnitPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Exterior_ExteriorTwo_UnitPrice_xp);
					String GroupOne_ItemTwo_TotalPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Exterior_ExteriorTwo_TotalPrice_xp);
					
					String insertGroupOneItemTwo = "INSERT INTO Ipad(GroupName, ItemTitle, ItemComments, ItemQuantity, ItemUnitPrice, ItemTotalPrice) VALUES ('" +GroupOne_name+ "', '" +GroupOne_ItemTwo_Title+ "', '" +GroupOne_ItemTwo_Comments+ "', '" +GroupOne_ItemTwo_Quantity+ "', '" +GroupOne_ItemTwo_UnitPrice+ "', '" +GroupOne_ItemTwo_TotalPrice+ "')";
					connection.executeUpdate(insertGroupOneItemTwo);
					
					String GroupOne_ItemThree_Title = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Exterior_ExteriorThree_Title_xp);
					String GroupOne_ItemThree_Comments = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Exterior_ExteriorThree_Comments_xp);
					String GroupOne_ItemThree_Quantity = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Exterior_ExteriorThree_Qty_xp);
					String GroupOne_ItemThree_UnitPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Exterior_ExteriorThree_UnitPrice_xp);
					String GroupOne_ItemThree_TotalPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Exterior_ExteriorThree_TotalPrice_xp);
					
					String insertGroupOneItemThree = "INSERT INTO Ipad(GroupName, ItemTitle, ItemComments, ItemQuantity, ItemUnitPrice, ItemTotalPrice) VALUES ('" +GroupOne_name+ "', '" +GroupOne_ItemThree_Title+ "', '" +GroupOne_ItemThree_Comments+ "', '" +GroupOne_ItemThree_Quantity+ "', '" +GroupOne_ItemThree_UnitPrice+ "', '" +GroupOne_ItemThree_TotalPrice+ "')";
					connection.executeUpdate(insertGroupOneItemThree);
					
					String GroupOne_ItemFour_Title = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Exterior_ExteriorFour_Title_xp);
					String GroupOne_ItemFour_Comments = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Exterior_ExteriorFour_Comments_xp);
					String GroupOne_ItemFour_Quantity = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Exterior_ExteriorFour_Qty_xp);
					String GroupOne_ItemFour_UnitPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Exterior_ExteriorFour_UnitPrice_xp);
					String GroupOne_ItemFour_TotalPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Exterior_ExteriorFour_TotalPrice_xp);
					
					String insertGroupOneItemFour = "INSERT INTO Ipad(GroupName, ItemTitle, ItemComments, ItemQuantity, ItemUnitPrice, ItemTotalPrice) VALUES ('" +GroupOne_name+ "', '" +GroupOne_ItemFour_Title+ "', '" +GroupOne_ItemFour_Comments+ "', '" +GroupOne_ItemFour_Quantity+ "', '" +GroupOne_ItemFour_UnitPrice+ "', '" +GroupOne_ItemFour_TotalPrice+ "')";
					connection.executeUpdate(insertGroupOneItemFour);
					
					String GroupOne_ItemFive_Title = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Exterior_ExteriorFive_Title_xp);
					String GroupOne_ItemFive_Comments = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Exterior_ExteriorFive_Comments_xp);
					String GroupOne_ItemFive_Quantity = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Exterior_ExteriorFive_Qty_xp);
					String GroupOne_ItemFive_UnitPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Exterior_ExteriorFive_UnitPrice_xp);
					String GroupOne_ItemFive_TotalPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Exterior_ExteriorFive_TotalPrice_xp);
					
					String insertGroupOneItemFive = "INSERT INTO Ipad(GroupName, ItemTitle, ItemComments, ItemQuantity, ItemUnitPrice, ItemTotalPrice) VALUES ('" +GroupOne_name+ "', '" +GroupOne_ItemFive_Title+ "', '" +GroupOne_ItemFive_Comments+ "', '" +GroupOne_ItemFive_Quantity+ "', '" +GroupOne_ItemFive_UnitPrice+ "', '" +GroupOne_ItemFive_TotalPrice+ "')";
					connection.executeUpdate(insertGroupOneItemFive);
					
					//Group 2
					String GroupTwo_name = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Interior_InteriorHeading_xp);
					String GroupTwo_ItemOne_Title = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Interior_InteriorOne_Title_xp);
					String GroupTwo_ItemOne_Comments = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Interior_InteriorOne_Comments_xp);
					String GroupTwo_ItemOne_Quantity = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Interior_InteriorOne_Qty_xp);
					String GroupTwo_ItemOne_UnitPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Interior_InteriorOne_UnitPrice_xp);
					String GroupTwo_ItemOne_TotalPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Interior_Interior_TotalPrice_xp);
					
					String insertGroupTwoItemone = "INSERT INTO Ipad(GroupName, ItemTitle, ItemComments, ItemQuantity, ItemUnitPrice, ItemTotalPrice) VALUES ('" +GroupTwo_name+ "', '" +GroupTwo_ItemOne_Title+ "', '" +GroupTwo_ItemOne_Comments+ "', '" +GroupTwo_ItemOne_Quantity+ "', '" +GroupTwo_ItemOne_UnitPrice+ "', '" +GroupTwo_ItemOne_TotalPrice+ "')";
					connection.executeUpdate(insertGroupTwoItemone);
					
					String GroupTwo_ItemTwo_Title = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Interior_InteriorTwo_Title_xp);
					String GroupTwo_ItemTwo_Comments = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Interior_InteriorTwo_Comments_xp);
					String GroupTwo_ItemTwo_Quantity = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Interior_InteriorTwo_Qty_xp);
					String GroupTwo_ItemTwo_UnitPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Interior_InteriorTwo_UnitPrice_xp);
					String GroupTwo_ItemTwo_TotalPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Interior_InteriorTwo_TotalPrice_xp);
					
					String insertGroupTwoItemTwo = "INSERT INTO Ipad(GroupName, ItemTitle, ItemComments, ItemQuantity, ItemUnitPrice, ItemTotalPrice) VALUES ('" +GroupTwo_name+ "', '" +GroupTwo_ItemTwo_Title+ "', '" +GroupTwo_ItemTwo_Comments+ "', '" +GroupTwo_ItemTwo_Quantity+ "', '" +GroupTwo_ItemTwo_UnitPrice+ "', '" +GroupTwo_ItemTwo_TotalPrice+ "')";
					connection.executeUpdate(insertGroupTwoItemTwo);
					
					String GroupTwo_ItemThree_Title = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Interior_InteriorThree_Title_xp);
					String GroupTwo_ItemThree_Comments = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Interior_InteriorThree_Comments_xp);
					String GroupTwo_ItemThree_Quantity = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Interior_InteriorThree_Qty_xp);
					String GroupTwo_ItemThree_UnitPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Interior_InteriorThree_UnitPrice_xp);
					String GroupTwo_ItemThree_TotalPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Interior_InteriorThree_TotalPrice_xp);
					
					String insertGroupTwoItemThree = "INSERT INTO Ipad(GroupName, ItemTitle, ItemComments, ItemQuantity, ItemUnitPrice, ItemTotalPrice) VALUES ('" +GroupTwo_name+ "', '" +GroupTwo_ItemThree_Title+ "', '" +GroupTwo_ItemThree_Comments+ "', '" +GroupTwo_ItemThree_Quantity+ "', '" +GroupTwo_ItemThree_UnitPrice+ "', '" +GroupTwo_ItemThree_TotalPrice+ "')";
					connection.executeUpdate(insertGroupTwoItemThree);
					
					//GROUP3
					String GroupThree_name = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Appliances_AppliancesHeading_xp);
					String GroupThree_ItemOne_Title = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Appliances_AppliancesOne_Title_xp);
					String GroupThree_ItemOne_Comments = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Appliances_AppliancesOne_Comments_xp);
					String GroupThree_ItemOne_Quantity = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Appliances_AppliancesOne_Qty_xp);
					String GroupThree_ItemOne_UnitPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Appliances_AppliancesOne_UnitPrice_xp);
					String GroupThree_ItemOne_TotalPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Appliances_AppliancesOne_TotalPrice_xp);
					
					String insertGroupThreeItemone = "INSERT INTO Ipad(GroupName, ItemTitle, ItemComments, ItemQuantity, ItemUnitPrice, ItemTotalPrice) VALUES ('" +GroupThree_name+ "', '" +GroupThree_ItemOne_Title+ "', '" +GroupThree_ItemOne_Comments+ "', '" +GroupThree_ItemOne_Quantity+ "', '" +GroupThree_ItemOne_UnitPrice+ "', '" +GroupThree_ItemOne_TotalPrice+ "')";
					connection.executeUpdate(insertGroupThreeItemone);
					
					//GROUP4
					String GroupFour_name = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Entry_EntryHeading_xp);
					String GroupFour_ItemOne_Title = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Entry_EntryOne_Title_xp);
					String GroupFour_ItemOne_Comments = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Entry_EntryOne_Comments_xp);
					String GroupFour_ItemOne_Quantity = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Entry_EntryOne_Qty_xp);
					String GroupFour_ItemOne_UnitPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Entry_EntryOne_UnitPrice_xp);
					String GroupFour_ItemOne_TotalPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Entry_EntryOne_TotalPrice_xp);
					
					String insertGroupFourItemone = "INSERT INTO Ipad(GroupName, ItemTitle, ItemComments, ItemQuantity, ItemUnitPrice, ItemTotalPrice) VALUES ('" +GroupFour_name+ "', '" +GroupFour_ItemOne_Title+ "', '" +GroupFour_ItemOne_Comments+ "', '" +GroupFour_ItemOne_Quantity+ "', '" +GroupFour_ItemOne_UnitPrice+ "', '" +GroupFour_ItemOne_TotalPrice+ "')";
					connection.executeUpdate(insertGroupFourItemone);
					
					//GROUP5
					String GroupFive_name = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_LivingRoom_LivingRoomHeading_xp);
					String GroupFive_ItemOne_Title = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_LivingRoom_LivingRoomOne_Title_xp);
					String GroupFive_ItemOne_Comments = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_LivingRoom_LivingRoomOne_Comments_xp);
					String GroupFive_ItemOne_Quantity = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_LivingRoom_LivingRoomOne_Qty_xp);
					String GroupFive_ItemOne_UnitPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_LivingRoom_LivingRoomOne_UnitPrice_xp);
					String GroupFive_ItemOne_TotalPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_LivingRoom_LivingRoomOne_TotalPrice_xp);
					
					String insertGroupFiveItemone = "INSERT INTO Ipad(GroupName, ItemTitle, ItemComments, ItemQuantity, ItemUnitPrice, ItemTotalPrice) VALUES ('" +GroupFive_name+ "', '" +GroupFive_ItemOne_Title+ "', '" +GroupFive_ItemOne_Comments+ "', '" +GroupFive_ItemOne_Quantity+ "', '" +GroupFive_ItemOne_UnitPrice+ "', '" +GroupFive_ItemOne_TotalPrice+ "')";
					connection.executeUpdate(insertGroupFiveItemone);
					
					//GROUP6
					String GroupSix_name = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_FamilyRoom_FamilyRoomHeading_xp);
					String GroupSix_ItemOne_Title = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_FamilyRoom_FamilyRoomOne_Title_xp);
					String GroupSix_ItemOne_Comments = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_FamilyRoom_FamilyRoomOne_Comments_xp);
					String GroupSix_ItemOne_Quantity = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_FamilyRoom_FamilyRoomOne_Qty_xp);
					String GroupSix_ItemOne_UnitPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_FamilyRoom_FamilyRoomOne_UnitPrice_xp);
					String GroupSix_ItemOne_TotalPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_FamilyRoom_FamilyRoomOne_TotalPrice_xp);
					
					String insertGroupSixItemone = "INSERT INTO Ipad(GroupName, ItemTitle, ItemComments, ItemQuantity, ItemUnitPrice, ItemTotalPrice) VALUES ('" +GroupSix_name+ "', '" +GroupSix_ItemOne_Title+ "', '" +GroupSix_ItemOne_Comments+ "', '" +GroupSix_ItemOne_Quantity+ "', '" +GroupSix_ItemOne_UnitPrice+ "', '" +GroupSix_ItemOne_TotalPrice+ "')";
					connection.executeUpdate(insertGroupSixItemone);
					
					String GroupSix_ItemTwo_Title = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_FamilyRoom_FamilyRoomTwo_Title_xp);
					String GroupSix_ItemTwo_Comments = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_FamilyRoom_FamilyRoomTwo_Comments_xp);
					String GroupSix_ItemTwo_Quantity = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_FamilyRoom_FamilyRoomTwo_Qty_xp);
					String GroupSix_ItemTwo_UnitPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_FamilyRoom_FamilyRoomTwo_UnitPrice_xp);
					String GroupSix_ItemTwo_TotalPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_FamilyRoom_FamilyRoomTwo_TotalPrice_xp);
					
					String insertGroupSixItemTwo = "INSERT INTO Ipad(GroupName, ItemTitle, ItemComments, ItemQuantity, ItemUnitPrice, ItemTotalPrice) VALUES ('" +GroupSix_name+ "', '" +GroupSix_ItemTwo_Title+ "', '" +GroupSix_ItemTwo_Comments+ "', '" +GroupSix_ItemTwo_Quantity+ "', '" +GroupSix_ItemTwo_UnitPrice+ "', '" +GroupSix_ItemTwo_TotalPrice+ "')";
					connection.executeUpdate(insertGroupSixItemTwo);
					
					//GROUP7
					String GroupSeven_name = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_DiningRoom_DiningRoomHeading_xp);
					String GroupSeven_ItemOne_Title = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_DiningRoom_DiningRoomOne_Title_xp);
					String GroupSeven_ItemOne_Comments = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_DiningRoom_DiningRoomOne_Comments_xp);
					String GroupSeven_ItemOne_Quantity = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_DiningRoom_DiningRoomOne_Qty_xp);
					String GroupSeven_ItemOne_UnitPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_DiningRoom_DiningRoomOne_UnitPrice_xp);
					String GroupSeven_ItemOne_TotalPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_DiningRoom_DiningRoomOne_TotalPrice_xp);
					
					String insertGroupSevenItemone = "INSERT INTO Ipad(GroupName, ItemTitle, ItemComments, ItemQuantity, ItemUnitPrice, ItemTotalPrice) VALUES ('" +GroupSeven_name+ "', '" +GroupSeven_ItemOne_Title+ "', '" +GroupSeven_ItemOne_Comments+ "', '" +GroupSeven_ItemOne_Quantity+ "', '" +GroupSeven_ItemOne_UnitPrice+ "', '" +GroupSeven_ItemOne_TotalPrice+ "')";
					connection.executeUpdate(insertGroupSevenItemone);
					
					String GroupSeven_ItemTwo_Title = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_DiningRoom_DiningRoomTwo_Title_xp);
					String GroupSeven_ItemTwo_Comments = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_DiningRoom_DiningRoomTwo_Comments_xp);
					String GroupSeven_ItemTwo_Quantity = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_DiningRoom_DiningRoomTwo_Qty_xp);
					String GroupSeven_ItemTwo_UnitPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_DiningRoom_DiningRoomTwo_UnitPrice_xp);
					String GroupSeven_ItemTwo_TotalPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_DiningRoom_DiningRoomTwo_TotalPrice_xp);
					
					String insertGroupSevenItemTwo = "INSERT INTO Ipad(GroupName, ItemTitle, ItemComments, ItemQuantity, ItemUnitPrice, ItemTotalPrice) VALUES ('" +GroupSeven_name+ "', '" +GroupSeven_ItemTwo_Title+ "', '" +GroupSeven_ItemTwo_Comments+ "', '" +GroupSeven_ItemTwo_Quantity+ "', '" +GroupSeven_ItemTwo_UnitPrice+ "', '" +GroupSeven_ItemTwo_TotalPrice+ "')";
					connection.executeUpdate(insertGroupSevenItemTwo);
					
					//GROUP8
					String GroupEight_name = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Kitchen_KitchenHeading_xp);
					String GroupEight_ItemOne_Title = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Kitchen_KitchenOne_Title_xp);
					String GroupEight_ItemOne_Comments = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Kitchen_KitchenOne_Comments_xp);
					String GroupEight_ItemOne_Quantity = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Kitchen_KitchenOne_Qty_xp);
					String GroupEight_ItemOne_UnitPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Kitchen_KitchenOne_UnitPrice_xp);
					String GroupEight_ItemOne_TotalPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Kitchen_KitchenOne_TotalPrice_xp);
					
					String insertGroupEightItemone = "INSERT INTO Ipad(GroupName, ItemTitle, ItemComments, ItemQuantity, ItemUnitPrice, ItemTotalPrice) VALUES ('" +GroupEight_name+ "', '" +GroupEight_ItemOne_Title+ "', '" +GroupEight_ItemOne_Comments+ "', '" +GroupEight_ItemOne_Quantity+ "', '" +GroupEight_ItemOne_UnitPrice+ "', '" +GroupEight_ItemOne_TotalPrice+ "')";
					connection.executeUpdate(insertGroupEightItemone);
					 
					//GROUP9
					String GroupNine_name = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_MasterBedroom_MasterBedroomHeading_xp);
					String GroupNine_ItemOne_Title = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_MasterBedroom_MasterBedroomOne_Title_xp);
					String GroupNine_ItemOne_Comments = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_MasterBedroom_MasterBedroomOne_Comments_xp);
					String GroupNine_ItemOne_Quantity = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_MasterBedroom_MasterBedroomOne_Qty_xp);
					String GroupNine_ItemOne_UnitPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_MasterBedroom_MasterBedroomOne_UnitPrice_xp);
					String GroupNine_ItemOne_TotalPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_MasterBedroom_MasterBedroomOne_TotalPrice_xp);
					
					String insertGroupNineItemone = "INSERT INTO Ipad(GroupName, ItemTitle, ItemComments, ItemQuantity, ItemUnitPrice, ItemTotalPrice) VALUES ('" +GroupNine_name+ "', '" +GroupNine_ItemOne_Title+ "', '" +GroupNine_ItemOne_Comments+ "', '" +GroupNine_ItemOne_Quantity+ "', '" +GroupNine_ItemOne_UnitPrice+ "', '" +GroupNine_ItemOne_TotalPrice+ "')";
					connection.executeUpdate(insertGroupNineItemone);
					
					//GROUP10
					String GroupTen_name = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_MasterBathroom_MasterBathroomHeading_xp);
					String GroupTen_ItemOne_Title = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_MasterBathroom_MasterBathroomOne_Title_xp);
					String GroupTen_ItemOne_Comments = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_MasterBathroom_MasterBathroomOne_Comments_xp);
					String GroupTen_ItemOne_Quantity = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_MasterBathroom_MasterBathroomOne_Qty_xp);
					String GroupTen_ItemOne_UnitPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_MasterBathroom_MasterBathroomOne_UnitPrice_xp);
					String GroupTen_ItemOne_TotalPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_MasterBathroom_MasterBathroomOne_TotalPrice_xp);
					
					String insertGroupTenItemone = "INSERT INTO Ipad(GroupName, ItemTitle, ItemComments, ItemQuantity, ItemUnitPrice, ItemTotalPrice) VALUES ('" +GroupTen_name+ "', '" +GroupTen_ItemOne_Title+ "', '" +GroupTen_ItemOne_Comments+ "', '" +GroupTen_ItemOne_Quantity+ "', '" +GroupTen_ItemOne_UnitPrice+ "', '" +GroupTen_ItemOne_TotalPrice+ "')";
					connection.executeUpdate(insertGroupTenItemone);
					
					//GROUP11
					String GroupEleven_name = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Hallway_HallwayHeading_xp);
					String GroupEleven_ItemOne_Title = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Hallway_HallwayOne_Title_xp);
					String GroupEleven_ItemOne_Comments = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Hallway_HallwayOne_Comments_xp);
					String GroupEleven_ItemOne_Quantity = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Hallway_HallwayOne_Qty_xp);
					String GroupEleven_ItemOne_UnitPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Hallway_HallwayOne_UnitPrice_xp);
					String GroupEleven_ItemOne_TotalPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Hallway_HallwayOne_TotalPrice_xp);
					
					String insertGroupElevenItemone = "INSERT INTO Ipad(GroupName, ItemTitle, ItemComments, ItemQuantity, ItemUnitPrice, ItemTotalPrice) VALUES ('" +GroupEleven_name+ "', '" +GroupEleven_ItemOne_Title+ "', '" +GroupEleven_ItemOne_Comments+ "', '" +GroupEleven_ItemOne_Quantity+ "', '" +GroupEleven_ItemOne_UnitPrice+ "', '" +GroupEleven_ItemOne_TotalPrice+ "')";
					connection.executeUpdate(insertGroupElevenItemone);
					
					String GroupEleven_ItemTwo_Title = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Hallway_HallwayTwo_Title_xp);
					String GroupEleven_ItemTwo_Comments = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Hallway_HallwaymTwo_Comments_xp);
					String GroupEleven_ItemTwo_Quantity = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Hallway_HallwayTwo_Qty_xp);
					String GroupEleven_ItemTwo_UnitPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Hallway_HallwayTwo_UnitPrice_xp);
					String GroupEleven_ItemTwo_TotalPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Hallway_HallwayTwo_TotalPrice_xp);
					
					String insertGroupElevenItemTwo = "INSERT INTO Ipad(GroupName, ItemTitle, ItemComments, ItemQuantity, ItemUnitPrice, ItemTotalPrice) VALUES ('" +GroupEleven_name+ "', '" +GroupEleven_ItemTwo_Title+ "', '" +GroupEleven_ItemTwo_Comments+ "', '" +GroupEleven_ItemTwo_Quantity+ "', '" +GroupEleven_ItemTwo_UnitPrice+ "', '" +GroupEleven_ItemTwo_TotalPrice+ "')";
					connection.executeUpdate(insertGroupElevenItemTwo);
					
					//GROUP12
					String GroupTwelve_name = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_LaundryRoom_LaundryRoomHeading_xp);
					String GroupTwelve_ItemOne_Title = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_LaundryRoom_LaundryRoomOne_Title_xp);
					String GroupTwelve_ItemOne_Comments = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_LaundryRoom_LaundryRoomOne_Comments_xp);
					String GroupTwelve_ItemOne_Quantity = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_LaundryRoom_LaundryRoomOne_Qty_xp);
					String GroupTwelve_ItemOne_UnitPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_LaundryRoom_LaundryRoomOne_UnitPrice_xp);
					String GroupTwelve_ItemOne_TotalPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_LaundryRoom_LaundryRoomOne_TotalPrice_xp);
					
					String insertGroupTwelveItemone = "INSERT INTO Ipad(GroupName, ItemTitle, ItemComments, ItemQuantity, ItemUnitPrice, ItemTotalPrice) VALUES ('" +GroupTwelve_name+ "', '" +GroupTwelve_ItemOne_Title+ "', '" +GroupTwelve_ItemOne_Comments+ "', '" +GroupTwelve_ItemOne_Quantity+ "', '" +GroupTwelve_ItemOne_UnitPrice+ "', '" +GroupTwelve_ItemOne_TotalPrice+ "')";
					connection.executeUpdate(insertGroupTwelveItemone);
					
					
					//GROUP13
					String GroupThirteen_name = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Garage_GarageHeading_xp);
					String GroupThirteen_ItemOne_Title = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Garage_GarageOne_Title_xp);
					String GroupThirteen_ItemOne_Comments = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Garage_GarageOne_Comments_xp);
					String GroupThirteen_ItemOne_Quantity = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Garage_GarageOne_Qty_xp);
					String GroupThirteen_ItemOne_UnitPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Garage_GarageOne_UnitPrice_xp);
					String GroupThirteen_ItemOne_TotalPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Garage_GarageOne_TotalPrice_xp);
					
					String insertGroupThirteenItemone = "INSERT INTO Ipad(GroupName, ItemTitle, ItemComments, ItemQuantity, ItemUnitPrice, ItemTotalPrice) VALUES ('" +GroupThirteen_name+ "', '" +GroupThirteen_ItemOne_Title+ "', '" +GroupThirteen_ItemOne_Comments+ "', '" +GroupThirteen_ItemOne_Quantity+ "', '" +GroupThirteen_ItemOne_UnitPrice+ "', '" +GroupThirteen_ItemOne_TotalPrice+ "')";
					connection.executeUpdate(insertGroupThirteenItemone);
					
					//GROUP14
					String GroupFourteen_name = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Basement_BasementHeading_xp);
					String GroupFourteen_ItemOne_Title = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Basement_BasementOne_Title_xp);
					String GroupFourteen_ItemOne_Comments = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Basement_BasementOne_Comments_xp);
					String GroupFourteen_ItemOne_Quantity = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Basement_BasementOne_Qty_xp);
					String GroupFourteen_ItemOne_UnitPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Basement_BasementOne_UnitPrice_xp);
					String GroupFourteen_ItemOne_TotalPrice = IpadLib.IOSGetGUITextXpath(objRWIpad.Budget_Basement_BasementOne_TotalPrice_xp);
					
					String insertGroupFourteenItemone = "INSERT INTO Ipad(GroupName, ItemTitle, ItemComments, ItemQuantity, ItemUnitPrice, ItemTotalPrice) VALUES ('" +GroupFourteen_name+ "', '" +GroupFourteen_ItemOne_Title+ "', '" +GroupFourteen_ItemOne_Comments+ "', '" +GroupFourteen_ItemOne_Quantity+ "', '" +GroupFourteen_ItemOne_UnitPrice+ "', '" +GroupFourteen_ItemOne_TotalPrice+ "')";
					connection.executeUpdate(insertGroupFourteenItemone);
					
				
					connection.close();
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1056 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1056 Completed");
				}
				return obj;
			} //End of function TC1056
			
			//TC1057 - Verify adding the Group in Property Walk
			@SuppressWarnings("static-access")
			public Reporter TC1057(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1057 Started..");
				try {		
					obj.repAddData( "Verify if the User can add the group in the property walk", "", "", "");
					
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
										
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
										
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group name "Exterior"
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "0");
					
					//Test starts
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroups_BtnAddGroup_xp, "Add Group Button", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_TableView_xp, "Exterior");
					IpadLib.IOSSetTextByXpath(objRWIpad.Groups_ViewGroups_TxtBxGroupNamePopOver_xp,"TestGroupName", "Test Auto Group");
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_BtnAdd_nm, "Add Button", true);
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1057 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1057 Completed");
				}
				return obj;
			} //End of function TC1057
			
			//TC1058 - Verify editing the group in Property walk
			@SuppressWarnings("static-access")
			public Reporter TC1058(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1058 Started..");
				try {		
					obj.repAddData( "Verify if the user can edit the group in the property walk", "", "", "");
					
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					//Clicking on List View and verifying whether the properties are shown in List View
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
										
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
										
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "0");
					
					//Test Starts here
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroups_BtnAddGroup_xp, "Add Group Button", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_TableView_xp, "Exterior");
					IpadLib.IOSSetTextByXpath(objRWIpad.Groups_ViewGroups_TxtBxGroupNamePopOver_xp,"Test Auto Group", "Group Name");
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_BtnAdd_nm, "Add Button", true);
					
					//Editing the Added Group
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_BtnEdit_nm, "Edit Button", true);
					IpadLib.IOSSetTextByXpath(objRWIpad.Groups_EditGroup_TxtBxGroupName_xp,"Test Edited Group", "Group Name");
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_BtnDone_nm, "Done Button", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1058 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1058 Completed");
				}
				return obj;
			} //End of function TC1058
			
			
			//TC1059 - Verify deleting the group in Property walk
			@SuppressWarnings("static-access")
			public Reporter TC1059(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1059 Started..");
				try {		
					obj.repAddData( "Verify if the user can delete the group in the property walk", "", "", "");
					
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
										
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
										
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "0");
					
					//Test Starts here
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroups_BtnAddGroup_xp, "Add Group Button", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_TableView_xp, "Exterior");
					IpadLib.IOSSetTextByXpath(objRWIpad.Groups_ViewGroups_TxtBxGroupNamePopOver_xp,"Test Auto Group", "Group Name");
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_BtnAdd_nm, "Add Button", true);
					
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_BtnEdit_nm, "Edit Button", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_BtnMinus_xp, "Minus Button", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_BtnDelete_xp, "Delete Button", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_BtnDone_nm, "Done Button", true);
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1059 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1059 Completed");
				}
				return obj;
			} //End of function TC1059
			
			//TC1060 - Verify adding comments in the group page
			@SuppressWarnings("static-access")
			public Reporter TC1060(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1060 Started..");
				try {		
					obj.repAddData( "verify if the user can add comments in the Group page", "", "", "");
					
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
										
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
										
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
										
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "0");
					
					//Test starts here
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_BtnAddComment_nm, "Comment Button", true);
					IpadLib.IOSSetTextByXpath(objRWIpad.Groups_ViewGroup_CommentArea_xp,"Test Comment", "Comments Area");
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_BtnAdd_nm, "Add Comment", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1060 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1060 Completed");
				}
				return obj;
			} //End of function TC1060
			
			
			//TC1061 - Verify canceling adding comments in the group page
			@SuppressWarnings("static-access")
			public Reporter TC1061(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1061 Started..");
				try {		
					obj.repAddData( "Verify if the User can cancel adding the comments in the group page", "", "", "");
					
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
										
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
										
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "0");
					
					//Test starts here
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_BtnAddComment_nm, "Add Comment Button", true);
					IpadLib.IOSSetTextByXpath(objRWIpad.Groups_ViewGroup_CommentArea_xp,"Test Comment", "Comments Area");
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_BtnCancel_nm, "Cancel Comment", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1061 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1061 Completed");
				}
				return obj;
			} //End of function TC1061
			
			//TC1062 - Verify the paint option for the Interior Group
			@SuppressWarnings("static-access")
			public Reporter TC1062(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1062 Started..");
				try {		
					obj.repAddData( "Verify if the User can see the Paint option in Interior group", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
										
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
										
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "1");
					
					//Test starts here
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_PaintIcon_nm, "paint Icon", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_PaintIconAdd_nm, "paint Icon", true);
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1062 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1062 Completed");
				}
				return obj;
			} //End of function TC1062
			
			//TC1063 - Verify compass option in the Property walk
			@SuppressWarnings("static-access")
			public Reporter TC1063(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1063 Started..");
				try {		
					obj.repAddData( "Verify if the user can see the compass option in the group page", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
										
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
										
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
										
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "0");
					
					//Test starts here
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_CompassIcon_nm, "Compass Button", true);
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroup_CompassText_nm, "Compass", true);
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1063 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1063 Completed");
				}
				return obj;
			} //End of function TC1063
			
			//TC1064 - Verify the Camera option for Item 'Pressure Wash' in Exterior Group
			@SuppressWarnings("static-access")
			public Reporter TC1064(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1064 Started..");
				try {		
					obj.repAddData( "Verify if the user can take picture for Pressure Wash in the Exterior Group", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}

					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "0");
					
					//Test starts here

					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_Camera_xp, "camera Button", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_CameraPlusBtn_xp, "Add Pic Button", true);				
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroup_CameraOptionsTableCells_xp, "Take Picture");
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_CameraIcon_nm, "Camera Icon", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_BtnSaveCameraPic_xp, "Save Pic Button", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1064 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1064 Completed");
				}
				return obj;
			} //End of function TC1064
			
			
			//TC1065 - Verify the Camera option for the Interior Group
			@SuppressWarnings("static-access")
			public Reporter TC1065(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1065 Started..");
				try {		
					obj.repAddData( "Verify if the user can take picture using camera option for Interior Group", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "1");
					
					//Test starts here

					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_Camera_xp, "camera Button", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_CameraPlusBtn_xp, "Add Pic Button", true);				
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroup_CameraOptionsTableCells_xp, "Take Picture");
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_CameraIcon_nm, "Camera Icon", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_BtnSaveCameraPic_xp, "Save Pic Button", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1065 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1065 Completed");
				}
				return obj;
			} //End of function TC1065
			
			//TC1066 - Verify the Camera option for Item 'Appliance Installation' in Appliances Group
			@SuppressWarnings("static-access")
			public Reporter TC1066(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1066 Started..");
				try {		
					obj.repAddData( "Verify if the User can take picture for Item 'Appliance Installation' in Appliances Group", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "2");
					
					//Test starts here

					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_Camera_xp, "camera Button", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_CameraPlusBtn_xp, "Add Pic Button", true);				
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroup_CameraOptionsTableCells_xp, "Take Picture");
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_CameraIcon_nm, "Camera Icon", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_BtnSaveCameraPic_xp, "Save Pic Button", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1066 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1066 Completed");
				}
				return obj;
			} //End of function TC1066
			
		
			//TC1067 - Verify the Camera option for Item 'Exterior Doors' in Entry Group
			@SuppressWarnings("static-access")
			public Reporter TC1067(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1067 Started..");
				try {		
					obj.repAddData( "Verify if the User can take picture for Item 'Exterior Doors' in Entry Group", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "3");
					
					//Test starts here

					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_CameraNew_xp, "camera Button", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_CameraPlusBtn_xp, "Add Pic Button", true);				
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroup_CameraOptionsTableCells_xp, "Take Picture");
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_CameraIcon_nm, "Camera Icon", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_BtnSaveCameraPic_xp, "Save Pic Button", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1067 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1067 Completed");
				}
				return obj;
			} //End of function TC1067
			
			//TC1068 - Verify the Camera option for Item 'Ceiling Fans' in Living Room Group
			@SuppressWarnings("static-access")
			public Reporter TC1068(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1068 Started..");
				try {		
					obj.repAddData( "Verify if the User can take picture for Item 'Ceiling Fans' in Living Room Group", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "4");
					
					//Test starts here

					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_CameraNew_xp, "camera Button", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_CameraPlusBtn_xp, "Add Pic Button", true);				
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroup_CameraOptionsTableCells_xp, "Take Picture");
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_CameraIcon_nm, "Camera Icon", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_BtnSaveCameraPic_xp, "Save Pic Button", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1068 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1068 Completed");
				}
				return obj;
			} //End of function TC1068
			
			//TC1069 - Verify the Camera option for Item 'Ceiling Fans' in Family Room Group
			@SuppressWarnings("static-access")
			public Reporter TC1069(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1069 Started..");
				try {		
					obj.repAddData( "Verify if the User can take picture for Item 'Ceiling Fans' in Family Room Group", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "5");
					
					//Test starts here

					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_CameraNew_xp, "camera Button", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_CameraPlusBtn_xp, "Add Pic Button", true);				
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroup_CameraOptionsTableCells_xp, "Take Picture");
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_CameraIcon_nm, "Camera Icon", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_BtnSaveCameraPic_xp, "Save Pic Button", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1069 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1069 Completed");
				}
				return obj;
			} //End of function TC1069
			
			//TC1070 - Verify the Camera option for Item 'Kitchen and Dining Lighting' in Dining Room Group
			@SuppressWarnings("static-access")
			public Reporter TC1070(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1070 Started..");
				try {		
					obj.repAddData( "Verify if the User can take picture for Item 'Kitchen and Dining Lighting' in Dining Room Group", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "6");
					
					//Test starts here

					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_CameraNew_xp, "camera Button", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_CameraPlusBtn_xp, "Add Pic Button", true);				
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroup_CameraOptionsTableCells_xp, "Take Picture");
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_CameraIcon_nm, "Camera Icon", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_BtnSaveCameraPic_xp, "Save Pic Button", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1070 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1070 Completed");
				}
				return obj;
			} //End of function TC1070
			
			//TC1071 - Verify the Camera option for Item 'Kitchen and Dining Lighting' in Kitchen Group
			@SuppressWarnings("static-access")
			public Reporter TC1071(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1071 Started..");
				try {		
					obj.repAddData( "Verify if the User can take picture for Item 'Kitchen and Dining Lighting' in Kitchen Group", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "7");
					
					//Test starts here

					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_CameraNew_xp, "camera Button", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_CameraPlusBtn_xp, "Add Pic Button", true);				
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroup_CameraOptionsTableCells_xp, "Take Picture");
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_CameraIcon_nm, "Camera Icon", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_BtnSaveCameraPic_xp, "Save Pic Button", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1071 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1071 Completed");
				}
				return obj;
			} //End of function TC1071
			
			//TC1072 - Verify the Camera option for Item 'Ceiling Fans' in Master Bedroom Group
			@SuppressWarnings("static-access")
			public Reporter TC1072(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1072 Started..");
				try {		
					obj.repAddData( "Verify if the User can take picture for Item 'Ceiling Fans' in Master Bedroom Group", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "7");
					
					//Test starts here

					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_CameraNew_xp, "camera Button", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_CameraPlusBtn_xp, "Add Pic Button", true);				
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroup_CameraOptionsTableCells_xp, "Take Picture");
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_CameraIcon_nm, "Camera Icon", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_BtnSaveCameraPic_xp, "Save Pic Button", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1072 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1072 Completed");
				}
				return obj;
			} //End of function TC1072
			
			//TC1073 - Verify the Camera option for Item 'Bathroom Faucets and Sinks' in Master Bathroom Group
			@SuppressWarnings("static-access")
			public Reporter TC1073(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1073 Started..");
				try {		
					obj.repAddData( "Verify if the User can take picture for Item 'Bathroom Faucets and Sinks' in Master Bathroom Group", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "9");
					
					//Test starts here

					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_CameraNew_xp, "camera Button", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_CameraPlusBtn_xp, "Add Pic Button", true);				
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroup_CameraOptionsTableCells_xp, "Take Picture");
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_CameraIcon_nm, "Camera Icon", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_BtnSaveCameraPic_xp, "Save Pic Button", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1073 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1073 Completed");
				}
				return obj;
			} //End of function TC1073
			
			//TC1074 - Verify the Camera option for Item 'Hall Light' in Hallways Group
			@SuppressWarnings("static-access")
			public Reporter TC1074(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1074 Started..");
				try {		
					obj.repAddData( "Verify if the User can take picture for Item 'Hall Light' in Hallways Group", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}

					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "10");
					
					//Test starts here

					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_CameraNew_xp, "camera Button", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_CameraPlusBtn_xp, "Add Pic Button", true);				
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroup_CameraOptionsTableCells_xp, "Take Picture");
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_CameraIcon_nm, "Camera Icon", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_BtnSaveCameraPic_xp, "Save Pic Button", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1074 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1074 Completed");
				}
				return obj;
			} //End of function TC1074
			
			//TC1075 - Verify the Camera option for Item 'Lighting' in Laundry Room Group
			@SuppressWarnings("static-access")
			public Reporter TC1075(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1074 Started..");
				try {		
					obj.repAddData( "Verify if the User can take picture for Item 'Lighting' in Laundry Room Group", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "11");
					
					//Test starts here

					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_CameraNew_xp, "camera Button", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_CameraPlusBtn_xp, "Add Pic Button", true);				
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroup_CameraOptionsTableCells_xp, "Take Picture");
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_CameraIcon_nm, "Camera Icon", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_BtnSaveCameraPic_xp, "Save Pic Button", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1075 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1075 Completed");
				}
				return obj;
			} //End of function TC1075
			
			//TC1076 - Verify the Camera option for Item 'Garage Paint' in Garage or carport Group
			@SuppressWarnings("static-access")
			public Reporter TC1076(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1076 Started..");
				try {		
					obj.repAddData( "Verify if the User can take picture for Item 'Garage Paint' in Garage or carport Group", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "12");
					
					//Test starts here

					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_Camera_xp, "camera Button", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_CameraPlusBtn_xp, "Add Pic Button", true);				
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroup_CameraOptionsTableCells_xp, "Take Picture");
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_CameraIcon_nm, "Camera Icon", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_BtnSaveCameraPic_xp, "Save Pic Button", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1076 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1076 Completed");
				}
				return obj;
			} //End of function TC1076
			
			//TC1077 - Verify the Camera option for Item 'Interior Paint' in Basement Group
			@SuppressWarnings("static-access")
			public Reporter TC1077(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1077 Started..");
				try {		
					obj.repAddData( "Verify if the User can take picture for Item 'Interior Paint' in Basement Group", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "13");
					
					//Test starts here

					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_Camera_xp, "camera Button", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_CameraPlusBtn_xp, "Add Pic Button", true);				
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroup_CameraOptionsTableCells_xp, "Take Picture");
					IpadLib.IOSClickByName(objRWIpad.Groups_ViewGroup_CameraIcon_nm, "Camera Icon", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_ViewGroup_BtnSaveCameraPic_xp, "Save Pic Button", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1077 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1077 Completed");
				}
				return obj;
			} //End of function TC1077
			
			
			//TC1078 - Verify the Scope of work page
			@SuppressWarnings("static-access")
			public Reporter TC1078(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1078 Started..");
				try {		
					obj.repAddData( "Verify if the User can see the Scope of work page after clicking on the Total amount in group page", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
									
									
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1078 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1078 Completed");
				}
				return obj;
			} //End of function TC1078
			
			//TC1079 - Verify the email option in scope of work page
			@SuppressWarnings("static-access")
			public Reporter TC1079(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1079 Started..");
				try {		
					obj.repAddData( "Verify if the User can see the Email option in the Scope of work page", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
									
									
					//SCOPE OF WORK
					IpadLib.IOSCheckDisplayedByName(objRWIpad.ScopeOfWork_Email_nm, "Email Option", true);
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1079 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1079 Completed");
				}
				return obj;
			} //End of function TC1079
			
			//TC1080 - Verify 'My Properties' option in Scope of Work page
			@SuppressWarnings("static-access")
			public Reporter TC1080(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1080 Started..");
				try {		
					obj.repAddData( "Verify if the User can see the 'My Properties' option in the scope of work page", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
									
									
					//SCOPE OF WORK
					IpadLib.IOSCheckDisplayedByName(objRWIpad.ScopeOfWork_MyProperties_nm, "My Properties", true);
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1080 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1080 Completed");
				}
				return obj;
			} //End of function TC1080
			
			//TC1081 - Verify the 'Submit For Review' button available in Scope of Work page
			@SuppressWarnings("static-access")
			public Reporter TC1081(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1081 Started..");
				try {		
					obj.repAddData( "Verify if the User can see the availability of 'Submit For Review' Button in scope of work page", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}

					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
									
									
					//SCOPE OF WORK
					IpadLib.IOSCheckDisplayedByName(objRWIpad.ScopeOfWork_SubmitForReview_nm, "Submit For Review Button", true);
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1081 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1081 Completed");
				}
				return obj;
			} //End of function TC1081
			
			//TC1082 - Verify the Scope Of Work for the Exterior Group
			@SuppressWarnings("static-access")
			public Reporter TC1082(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1082 Started..");
				try {		
					obj.repAddData( "Verify if the User can see the Scope of Work for Exterior Group", "", "", "");
	
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					Thread.sleep(10000);
									
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group - Exterior
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "0");
					
					//Exterior verification
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_ExteriorTitle_nm, "Exterior", true);
					
					//Pressure Wash 
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_Exterior_PressureWash_Title_nm, "Pressure Wash", true);	
					IpadLib.IOSClickByXpath(objRWIpad.Groups_Exterior_PressureWash_TextView_xp, "Pressure Wash Text View", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_Exterior_PressureWash_Comment_xp, "Pressure Wash Comments", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Exterior_PressureWash_Price_xp, "300.00", true);
					
					
					
					//Verifying the Total for this Group Page
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$335.00", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					
					//Scope Of Work - Exterior
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Exterior_TotalPrice_xp, "335.00", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_ExteriorTitle_xp, "Exterior", true);
					//Sub Exterior
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Exterior_PressureWash_Title_xp, "Pressure Wash", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Exterior_PressureWash_Price_xp, "300.00", true);
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1082 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1082 Completed");
				}
				return obj;
			} //End of function TC1082
			
			//TC1083 - Verify the Scope Of Work for the Interior Group
			@SuppressWarnings("static-access")
			public Reporter TC1083(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1083 Started..");
				try {		
					obj.repAddData( "Verify if the User can see the Scope of Work for Interior Group", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
					
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
				
					}
					
					Thread.sleep(10000);
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "1");
					
					//Interior Walk Through
					//Interior verification
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_InteriorTitle_nm, "Interior", true);
					
					//Interior Paint
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Interior_InteriorPaint_Title_xp, "Interior Paint", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_InteriorPaint_UpArrow_nm, "Up Arrow Button", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_InteriorPaint_UpArrow_nm, "Up Arrow Button", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Interior_InteriorPaint_Price_xp, "2.90", true);
					
					
					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$37.90", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Interior_TotalPrice_xp, "37.90", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Interior_Flooring_Heading_xp, "Interior", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Interior_Flooring_Title_xp, "Interior Paint", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Interior_Flooring_Area_xp, "2", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Interior_Flooring_Unit_xp, "1.45", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Interior_Flooring_Price_xp, "2.90", true);
						
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();

				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1083 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1083 Completed");
				}
				return obj;
			} //End of function TC1083
			
			//TC1084 - Verify the Scope Of Work for the Appliances Group
			@SuppressWarnings("static-access")
			public Reporter TC1084(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1084 Started..");
				try {		
					obj.repAddData( "Verify if the User can see the Scope of Work for Appliances Group", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "2");
					
					//Appliances Group Walk Through
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_AppliancesTitle_nm, "Appliances", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Appliances_ApplianceInstallation_Title_xp, "Appliance Installation", true);
					
					IpadLib.IOSClickByXpath(objRWIpad.Groups_Appliances_TextView_xp, "Appliance Installation Text view", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_Appliances_TextViewComment_xp, "Appliance Installation Comments", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Appliances_TextArea_xp, "150.00", true);
					
					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$185.00", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//Scope of Work
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_TotalPrice_xp, "185.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Heading_xp, "Appliances", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Title_xp, "Appliance Installation", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_QtyWithComment_xp, "1", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_UnitPriceWithComment_xp, "150.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_PriceWithComment_xp, "150.00", true);
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1084 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1084 Completed");
				}
				return obj;
			} //End of function TC1084
			
			//TC1085 - Verify the Scope Of Work for the Entry Group
			@SuppressWarnings("static-access")
			public Reporter TC1085(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1085 Started..");
				try {		
					obj.repAddData( "Verify if the User can see the Scope of Work for Entry Group", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "3");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_EnrtyTitle_nm, "Entry", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Entry_ExteriorDoors_Title_xp, "Exterior Doors", true);
					
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Side Arrow", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_SKU1_nm, "6-Panel Primed Steel Slab Entry Door", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Down Arrow", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Entry_ExteriorDoors_Price_xp, "60.00", true);
					
					
					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$95.00", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_TotalPrice_xp, "95.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Heading_xp, "Entry", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Title_xp, "Premium 6-Panel Primed Steel Slab Entry Door", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_QtyWithNoComment_xp, "1", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_UnitPriceWithNoComment_xp, "60.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_PriceWithNoComment_xp, "60.00", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1085 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1085 Completed");
				}
				return obj;
			} //End of function TC1085
			
			//TC1086 - Verify the Scope Of Work for the Living Room Group
			@SuppressWarnings("static-access")
			public Reporter TC1086(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1086 Started..");
				try {		
					obj.repAddData( "Verify if the User can see the Scope of Work for Living room Group", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
					
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
				
					}
					
					Thread.sleep(8000);
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "4");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_LivingRoomTitle_nm, "Living Room", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_LivingRoom_CeilingFan_Title_xp, "Ceiling Fans", true);
					
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Arrow1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_LivingRoom_CeilingSKU1_nm, "SKU1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Arrow Down", true);
					
					//calculating the Floor Type
					IpadLib.IOSSetTextByXpath(objRWIpad.Groups_Interior_Flooring_Width_xp, "2", "Width Text box");
					IpadLib.IOSClickByName(objRWIpad.Exterior_ExteriorButtonDownKeypad_nm, "Hide Keypad Button", true);
					IpadLib.IOSSetTextByXpath(objRWIpad.Groups_Interior_Flooring_Length_xp, "2", "Length Text box");
					IpadLib.IOSClickByName(objRWIpad.Exterior_ExteriorButtonDownKeypad_nm, "Hide Keypad Button", true);
					
					//Painting Option
					//select carpet for current floor
					IpadLib.IOSClickByXpath(objRWIpad.Groups_Interior_Flooring_BtnCurrentFlooring_xp, "Current Flooring", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_Interior_Flooring_CurrentFlooringTableCells_xp, "Carpet");
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_Flooring_BtnReplaceWith_nm, "Replace With Radio Button", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_Interior_Flooring_BtnNewFlooring_xp, "New Flooring", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_Interior_Flooring_NewFlooringTableCells_xp, "Tile");
					
					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$61.00", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_TotalPrice_xp, "61.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_FlooringHeading_xp, "Flooring", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_FlooringTitle_xp, "SqFt of Tile", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_FlooringPrice_xp, "26.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_InteriorHeading_xp, "Interior", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_InteriorTitle_xp, "Trim Bucket", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_LivingRoom_InteriorPrice_xp, "35.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_LivingRoom_LivingRoomHeading_xp, "Living Room", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_LivingRoom_LivingRoomTitle_xp, "42", true);
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1086 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1086 Completed");
				}
				return obj;
			} //End of function TC1086
			
			//TC1087 - Verify the Scope Of Work for the Family Room Group
			@SuppressWarnings("static-access")
			public Reporter TC1087(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1087 Started..");
				try {		
					obj.repAddData( "Verify if the User can see the Scope of Work for Family room Group", "", "", "");
					
					//Clicking on List View and verifying whether the properties are shown in List View
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
					
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
				
					}
					
					Thread.sleep(8000);
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "4");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_LivingRoomTitle_nm, "Living Room", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_LivingRoom_CeilingFan_Title_xp, "Ceiling Fans", true);
					
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Arrow1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_LivingRoom_CeilingSKU1_nm, "SKU1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Arrow Down", true);
					
					//calculating the Floor Type
					IpadLib.IOSSetTextByXpath(objRWIpad.Groups_Interior_Flooring_Width_xp, "2", "Width Text box");
					IpadLib.IOSClickByName(objRWIpad.Exterior_ExteriorButtonDownKeypad_nm, "Hide Keypad Button", true);
					IpadLib.IOSSetTextByXpath(objRWIpad.Groups_Interior_Flooring_Length_xp, "2", "Length Text box");
					IpadLib.IOSClickByName(objRWIpad.Exterior_ExteriorButtonDownKeypad_nm, "Hide Keypad Button", true);
					
					//Painting Option
					//select carpet for current floor
					IpadLib.IOSClickByXpath(objRWIpad.Groups_Interior_Flooring_BtnCurrentFlooring_xp, "Current Flooring", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_Interior_Flooring_CurrentFlooringTableCells_xp, "Carpet");
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_Flooring_BtnReplaceWith_nm, "Replace With Radio Button", true);
					IpadLib.IOSClickByXpath(objRWIpad.Groups_Interior_Flooring_BtnNewFlooring_xp, "New Flooring", true);
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_Interior_Flooring_NewFlooringTableCells_xp, "Tile");
					
					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$61.00", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_TotalPrice_xp, "61.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_FlooringHeading_xp, "Flooring", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_FlooringTitle_xp, "SqFt of Tile", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_FlooringPrice_xp, "26.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_InteriorHeading_xp, "Interior", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Entry_InteriorTitle_xp, "Trim Bucket", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_LivingRoom_InteriorPrice_xp, "35.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_LivingRoom_LivingRoomHeading_xp, "Living Room", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_LivingRoom_LivingRoomTitle_xp, "42", true);
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1087 Failed!", e );
				}
				finally {
					
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1087 Completed");
				}
				return obj;
			} //End of function TC1087
			
			
			//TC1088 - Verify the Scope Of Work for the Dining Room Group
			@SuppressWarnings("static-access")
			public Reporter TC1088(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1088 Started..");
				try {		
					obj.repAddData( "Verify if the User can see the Scope of Work for Dining room Group", "", "", "");
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "6");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_DiningRoomTitle_nm, "Dining Room", true);
					
					//Kitchen and Dining
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_DiningRoom_KitchenDining_Title_xp, "Kitchen and Dining Lighting", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Arrow1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_DiningRoom_KitchenDiningSKU2_nm, "SKU2", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Arrow Down", true);
					
					
					
					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$55.00", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_TotalPrice_xp, "55.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Heading_xp, "Dining Room", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Title_xp, "11\" 2Lt White Swirl Flushmount", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_QtyWithNoComment_xp, "1", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_UnitPriceWithNoComment_xp, "20.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_PriceWithNoComment_xp, "20.00", true);
					
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1088 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1088 Completed");
				}
				return obj;
			} //End of function TC1088
			
			
			//TC1089 - Verify the Scope Of Work for the Kitchen Group
			@SuppressWarnings("static-access")
			public Reporter TC1089(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1089 Started..");
				try {		
					obj.repAddData( "Verify if the User can see the Scope of Work for Kitchen Group", "", "", "");
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}

					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "7");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_KitchenTitle_nm, "Kitchen", true);
					
					//Kitchen and Dining
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Kitchen_KitchenDining_Title_xp, "Kitchen and Dining Lighting", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Arrow1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Kitchen_KitchenDiningSKU1_nm, "SKU1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Arrow Down", true);
					
					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$55.00", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_TotalPrice_xp, "55.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Heading_xp, "Kitchen", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Title_xp, "11\" 2Lt Bronze Swirl Flush Mount", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_QtyWithNoComment_xp, "1", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_UnitPriceWithNoComment_xp, "20.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_PriceWithNoComment_xp, "20.00", true);
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1089 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1089 Completed");
				}
				return obj;
			} //End of function TC1089
			
			//TC1090 - Verify the Scope Of Work for the Master Bedroom Group
			@SuppressWarnings("static-access")
			public Reporter TC1090(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1090 Started..");
				try {		
					obj.repAddData( "Verify if the User can see the Scope of Work for Master Bedroom Group", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}

					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "7");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_KitchenTitle_nm, "Kitchen", true);
					
					//Kitchen and Dining
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Kitchen_KitchenDining_Title_xp, "Kitchen and Dining Lighting", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Arrow1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Kitchen_KitchenDiningSKU1_nm, "SKU1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Arrow Down", true);
					
					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$55.00", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_TotalPrice_xp, "55.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Heading_xp, "Kitchen", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Title_xp, "11\" 2Lt Bronze Swirl Flush Mount", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_QtyWithNoComment_xp, "1", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_UnitPriceWithNoComment_xp, "20.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_PriceWithNoComment_xp, "20.00", true);
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1090 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1090 Completed");
				}
				return obj;
			} //End of function TC1090
			
			//TC1091 - Verify the Scope Of Work for the Master Bathroom Group
			@SuppressWarnings("static-access")
			public Reporter TC1091(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1091 Started..");
				try {		
					obj.repAddData( "Verify if the User can see the Scope of Work for Master Bathroom Group", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}

					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "7");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_KitchenTitle_nm, "Kitchen", true);
					
					//Kitchen and Dining
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Kitchen_KitchenDining_Title_xp, "Kitchen and Dining Lighting", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Arrow1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Kitchen_KitchenDiningSKU1_nm, "SKU1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Arrow Down", true);
					
					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$55.00", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_TotalPrice_xp, "55.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Heading_xp, "Kitchen", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Title_xp, "11\" 2Lt Bronze Swirl Flush Mount", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_QtyWithNoComment_xp, "1", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_UnitPriceWithNoComment_xp, "20.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_PriceWithNoComment_xp, "20.00", true);
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1091 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1091 Completed");
				}
				return obj;
			} //End of function TC1091
			
			//TC1092 - Verify the Scope Of Work for the Hallway Group
			@SuppressWarnings("static-access")
			public Reporter TC1092(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1092 Started..");
				try {		
					obj.repAddData( "Verify if the User can see the Scope of Work for Hallway Group", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "10");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_HallwaysTitle_nm, "Hallways", true);
					
					
					//Hall Lights
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Hallways_HallLight_Title_xp, "Hall Light", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Arrow1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Hallways_SKU1_nm, "SKU1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Arrow Down", true);
					
					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$55.00", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Heading_xp, "Hallways", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_TotalPrice_xp, "55.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Title_xp, "Brushed Nickel 2-Light Flush Mount", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_QtyWithNoComment_xp, "1", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_UnitPriceWithNoComment_xp, "20.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_PriceWithNoComment_xp, "20.00", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1092 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1092 Completed");
				}
				return obj;
			} //End of function TC1092
			
			//TC1093 - Verify the Scope Of Work for the Laundry Room Group
			@SuppressWarnings("static-access")
			public Reporter TC1093(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1093 Started..");
				try {		
					obj.repAddData( "Verify if the User can see the Scope of Work for Laundry Room Group", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "10");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_HallwaysTitle_nm, "Hallways", true);
					
					
					//Hall Lights
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Hallways_HallLight_Title_xp, "Hall Light", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Arrow1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Hallways_SKU1_nm, "SKU1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Arrow Down", true);
					
					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$55.00", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Heading_xp, "Hallways", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_TotalPrice_xp, "55.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Title_xp, "Brushed Nickel 2-Light Flush Mount", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_QtyWithNoComment_xp, "1", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_UnitPriceWithNoComment_xp, "20.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_PriceWithNoComment_xp, "20.00", true);
					
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1093 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1093 Completed");
				}
				return obj;
			} //End of function TC1093
			
			//TC1094 - Verify the Scope Of Work for the Garage or Carport Group
			@SuppressWarnings("static-access")
			public Reporter TC1094(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1094 Started..");
				try {		
					obj.repAddData( "Verify if the User can see the Scope of Work for Garage or Carport Group", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "12");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_GarageTitle_nm, "Garage or Carport", true);
					
					
					//Garage Door
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Garage_Door_Title_xp, "Garage Door", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_Arrow1_nm, "Arrow1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Garage_SKU1_nm, "SKU1", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Entry_ExteriorDoors_DOwnArrow_nm, "Arrow Down", true);
					

					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$170.00", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_TotalPrice_xp, "170.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Heading_xp, "Garage or Carport", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Title_xp, "9\"x7\" Hdb Wht Noninsul Garage Door", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_QtyWithNoComment_xp, "1", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_UnitPriceWithNoComment_xp, "135.00", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_PriceWithNoComment_xp, "135.00", true);
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1094 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1094 Completed");
				}
				return obj;
			} //End of function TC1094
			
			//TC1095 - Verify the Scope Of Work for the Basement Group
			@SuppressWarnings("static-access")
			public Reporter TC1095(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC1095 Started..");
				try {		
					obj.repAddData( "Verify if the User can see the Scope of Work for Basement Group", "", "", "");
					
					//click on Download button for the Property
					IpadLib.IOSClickByXpath(objRWIpad.Property_myProperties_BtnListView_xp, "List View", true);
					boolean elementFound = IpadLib.IOSElementFoundByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm);
					if(elementFound == true){
						IpadLib.IOSClickByName(objRWIpad.Properties_MyProperties_ListCloudDownloadButton_nm, "List Cloud Download Button", true);
					}
					
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Properties_MyProperties_PropertiesNameTableCells_xp, "TestPropertyNA");
					
					iosdriver.rotate(ScreenOrientation.LANDSCAPE);
					
					//click on Next Button
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolNextButton_nm, "Next Button", true);
					
					//Click on Group based on Name
					IpadLib.IOSClickTableCellByXpath(objRWIpad.Groups_ViewGroups_GroupNameTableCells_xp, "13");
					
					IpadLib.IOSVeriyTextByName(objRWIpad.Groups_ViewGroups_BasementTitle_nm, "Basement", true);
					
					//Interior Paint
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Groups_Basement_InteriorPaint_Title_xp, "Interior Paint", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_InteriorPaint_UpArrow_nm, "Up Arrow Button", true);
					IpadLib.IOSClickByName(objRWIpad.Groups_Interior_InteriorPaint_UpArrow_nm, "Up Arrow Button", true);
	
					//verify the Total price
					IpadLib.IOSVeriyTextByXpath(objRWIpad.Group_ViewGroup_Total_xp, "$37.90", true);
					
					//click on Next Button
					IpadLib.IOSClickByXpath(objRWIpad.Group_ViewGroup_Total_xp, "Scope Of Work Button", true);
					
					//SCOPE OF WORK
					IpadLib.IOSVeriyTextByName(objRWIpad.ScopeOfWork_Title_nm, "Scope of Work", true);
					
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_TotalPrice_xp, "37.90", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Heading_xp, "Basement", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_Title_xp, "Interior Paint", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_QtyWithNoComment_xp, "2", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_UnitPriceWithNoComment_xp, "1.45", true);
					IpadLib.IOSVeriyTextByXpath(objRWIpad.ScopeOfWork_PriceWithNoComment_xp, "2.90", true);
										
					
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					
					//Post Conditions
					//click on Back button for Log Out
					
					iosdriver.rotate(ScreenOrientation.PORTRAIT);
					IpadLib.IOSClickByName(objRWIpad.ToolboxToolBackButton_nm, "Back Button", true);
					IpadLib.IOSdeleteProperty();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					obj.repAddData( "Error Handler ", "Error/exception occured in the test", "Exception is: " + e.toString(), "Fail");
					log.error( "Function TC1095 Failed!", e );
				}
				finally {
					
		
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
				log.info("Execution of Function TC1095 Completed");
				}
				return obj;
			} //End of function TC1095
			
} //End of Class