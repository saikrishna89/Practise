package com.homedepot.renowalk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Objects;
import com.homedepot.renowalk.ObjectRepository.RenowalkHome;
import com.homedepot.renowalk.ObjectRepository.RenowalkModules;
import com.homedepot.renowalk.ReportManager.Reporter;
import com.homedepot.renowalk.UtilManager.AppMessages;
import com.homedepot.renowalk.UtilManager.FilloUtil;


public class General extends TestDriver
{
	RenowalkModules objRWModules = new RenowalkModules();
	RenowalkHome objRWHome = new RenowalkHome();
	AppMessages objAppMessages = new AppMessages();
			
			///////////////////////////////////////SetContext Tests Begin Here///////////////////////////////////////////////////////////////////////////
			
			//RW-93_SetContext_TC001_Set Corporation and Offices Context_View Drop down boxes
			@SuppressWarnings("static-access")
			public Reporter TC27130(Reporter obj) throws Exception
			{
				//Boolean bLoginFlag = true;	
				log.info("Execution of Function TC27130 Started..");

				try {

					obj.repAddData( "Viewing the Home page", "", "", "");
					//fnSelectCorpOffice(sCorporation, sOffice);
					fnCheckFieldDisplayByXpath(objRWModules.Common_AllModules_ComboCorporateSelect_xp, "Corporation Menu", true, true);
					
					//May need to include some sort of check for the office menu:
					//fnCheckFieldDisplayByXpath(objRWModules.Common_AllModules_ComboOfficeSelect_xp, "Office Menu", true, true);
					
					

				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC27130 Failed!", e );
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
					log.info("Execution of Function TC27130 Completed");
				}
				return obj;
			} //End of function TC27130
			
			
			//RW-93_SetContext_TC002_Set Corporation and Offices Context_Verify for corporation drop down box
			@SuppressWarnings("static-access")
			public Reporter TC27131(Reporter obj) throws Exception
			{
				//Boolean bLoginFlag = true;	
				log.info("Execution of Function TC27131 Started..");

				try {
							
					obj.repAddData( "Viewing the Corporations in the Corporations field", "", "", "");
					
					//open the menu:
					ClickByXpath(objRWModules.Common_AllModules_ComboCorporateSelect_xp,"Corporation Drop Down", true);
					
					//check to see that the values are sorted:
					fnCheckDropDownSorting(objRWModules.Common_AllModules_ComboCorporateName_xp,"Corporation", "Select");
					
					//close the menu:
					ClickByXpath(objRWModules.Common_AllModules_ComboCorporateSelect_xp,"Corporation Drop Down", false);
		
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC27131 Failed!", e );
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
					log.info("Execution of Function TC27131 Completed");
				}
				return obj;
			} //End of function TC27131
			
			
			//RW-93_SetContext_TC003_Set Corporation and Offices Context_Verify for Office drop down box for a Corporation
			@SuppressWarnings("static-access")
			public Reporter TC27132(Reporter obj) throws Exception
			{
				//Boolean bLoginFlag = true;	
				log.info("Execution of Function TC27132 Started..");

				try {
							
					obj.repAddData( "Viewing the Office in the Offices field", "", "", "");
					
					fnSelectCorpOffice(sCorporation, sOffice);
					
					//open the offices pull-down
					ClickByXpath(objRWModules.Common_AllModules_ComboOfficeSelect_xp,"Corporation Drop Down", true);
					
					//check to see that the values are sorted in ascending order:
					fnCheckDropDownSorting(objRWModules.Common_AllModules_ComboOfficeCode_xp, "Office", "Select");
					
					//close the offices pull-down
					ClickByXpath(objRWModules.Common_AllModules_ComboOfficeSelect_xp,"Corporation Drop Down", false);
					
					//Need to add DB code to verify office data
		
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC27132 Failed!", e );
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
					log.info("Execution of Function TC27132 Completed");
				}
				return obj;
			} //End of function TC27132
			
			
			//RW-93_SetContext_TC004_Set Corporation and Offices Context_Check default value in Corporation Select Box
			@SuppressWarnings("static-access")
			public Reporter TC27133(Reporter obj) throws Exception
			{
				//Boolean bLoginFlag = true;	
				log.info("Execution of Function TC27133 Started..");

				try {
							
					obj.repAddData( "Verifying default value in Corporations field", "", "", "");
					
					driver.navigate().refresh();
					
					fnCheckFieldDisplayByXpath(objRWModules.Common_AllModules_ComboCorporateText_xp, "Select", true, true);
					
		
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC27133 Failed!", e );
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
					log.info("Execution of Function TC27133 Completed");
				}
				return obj;
			} //End of function TC27133
			
			
			//RW-93_SetContext_TC006_Set Corporation and Offices Context_Verify for Office text box for a single Office
			@SuppressWarnings("static-access")
			public Reporter TC27135(Reporter obj) throws Exception
			{
				//Boolean bLoginFlag = true;	
				log.info("Execution of Function TC27135 Started..");

				try {
							
					obj.repAddData( "Verifying Office text box when only one Office in Corporation", "", "", "");
					
					//Selects a corporation with a single office
					fnSelectCorpOffice("aaa", sOffice);
					
					fnCheckFieldDisplayByXpath(objRWModules.Common_AllModules_ComboOfficeText_xp, "Text Box", true, true);
					
		
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC27135 Failed!", e );
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
					log.info("Execution of Function TC27135 Completed");
				}
				return obj;
			} //End of function TC27135
			
			
			
			///////////////////////////////////////SetContext Tests End Here///////////////////////////////////////////////////////////////////////////
			
			
			///////////////////////////////////////ToolOptions Starts End Here///////////////////////////////////////////////////////////////////////////
			
			
			//RW-248_Properties_Management_TC001_Project Tools Visible
			@SuppressWarnings("static-access")
			public Reporter TC36914(Reporter obj) throws Exception
			{
				//Boolean bLoginFlag = true;	
				log.info("Execution of Function TC36914 Started..");

				try {
							
					obj.repAddData( "Verifying that a variety of project tools are displayed", "", "", "");
					
					fnSelectCorpOffice(sCorporation, sOffice);
					
					//Navigate to Properties page:
					ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp,"Property Link", true);
					
					//Select the top Property:
					ClickByXpath(objRWModules.Property_ToolOptions_SelectPropertyNotWalked_xp,"Property Link", true);
					
					//Click on Project Tools Tab:
					ClickByXpath(objRWModules.Property_ToolOptions_ProjectToolsTab_xp,"Property Link", true);
					
					//Verify Project Tools Buttons:
					fnCheckFieldDisplayByXpath(objRWModules.Property_ProjectTools_ExportCSV_xp, "Export CSV Button", true, true);
					fnCheckFieldDisplayByXpath(objRWModules.Property_ProjectTools_PDF_xp, "PDF Button", true, true);
					fnCheckFieldDisplayByXpath(objRWModules.Property_ProjectTools_ScopeAndPhotos_xp, "Scope and Photos Button", true, true);
					fnCheckFieldDisplayByXpath(objRWModules.Property_ProjectTools_ApprovedScope_xp, "Approved Scope Button", true, true);
					fnCheckFieldDisplayByXpath(objRWModules.Property_ProjectTools_PhotoLink_xp, "Photo Link Button", true, true);
					fnCheckFieldDisplayByXpath(objRWModules.Property_ProjectTools_BidPhotoPDF_xp, "Bid Photos Button", true, true);
					fnCheckFieldDisplayByXpath(objRWModules.Property_ProjectTools_PhotosZip_xp, "Photos Zip Button", true, true);
					fnCheckFieldDisplayByXpath(objRWModules.Property_ProjectTools_BuildHDQuote_xp, "Build HD Quote Button", true, true);
					fnCheckFieldDisplayByXpath(objRWModules.Property_ProjectTools_SubmitBid_xp, "Submit Bid Button", true, true);	
					
					
		
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36914 Failed!", e );
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
					log.info("Execution of Function TC36914 Completed");
				}
				return obj;
			} //End of function TC36914
			
			
			//RW-248_Properties_Management_TC003_Project Tools buttons Shown in Disabled Mode
			@SuppressWarnings("static-access")
			public Reporter TC36916(Reporter obj) throws Exception
			{
				//Boolean bLoginFlag = true;	
				log.info("Execution of Function TC36916 Started..");

				try {
							
					obj.repAddData( "Verifying that a variety of project tools are displayed", "", "", "");
					
					fnSelectCorpOffice(sCorporation, sOffice);
					
					//Navigate to Properties page:
					ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp,"Property Link", true);
					
					//Select the top Property:
					ClickByXpath(objRWModules.Property_ToolOptions_SelectPropertyNotWalked_xp,"Property item", true);
					
					//Click on Project Tools Tab:
					ClickByXpath(objRWModules.Property_ToolOptions_ProjectToolsTab_xp,"Project Tools tab", true);
					
					//Check that buttons are disabled:
					fnCheckDisbleByXPath(objRWModules.Property_ProjectTools_ExportCSV_xp, "Export CSV Button");
					fnCheckDisbleByXPath(objRWModules.Property_ProjectTools_PDF_xp, "PDF Button");
					fnCheckDisbleByXPath(objRWModules.Property_ProjectTools_ScopeAndPhotos_xp, "Scope and Photos Button");
					fnCheckDisbleByXPath(objRWModules.Property_ProjectTools_ApprovedScope_xp, "Approved Scope Button");
					fnCheckDisbleByXPath(objRWModules.Property_ProjectTools_PhotoLink_xp, "Photo Link Button");
					fnCheckDisbleByXPath(objRWModules.Property_ProjectTools_BidPhotoPDF_xp, "Bid Photos Button");
					fnCheckDisbleByXPath(objRWModules.Property_ProjectTools_PhotosZip_xp, "Photos Zip Button");
					fnCheckDisbleByXPath(objRWModules.Property_ProjectTools_BuildHDQuote_xp, "Build HD Quote Button");
					fnCheckDisbleByXPath(objRWModules.Property_ProjectTools_SubmitBid_xp, "Submit Bids Button");	
					
		
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36916 Failed!", e );
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
					log.info("Execution of Function TC36916 Completed");
				}
				return obj;
			} //End of function TC36916
			
			
			//RW-248_Properties_Management_TC004_Check CSV V2, Final Photos PDF, etc options are not available
			@SuppressWarnings("static-access")
			public Reporter TC36917(Reporter obj) throws Exception
			{
				//Boolean bLoginFlag = true;	
				log.info("Execution of Function TC36917 Started..");

				try {
							
					obj.repAddData( "Verifying that certain project tools are not displayed", "", "", "");
					
					fnSelectCorpOffice(sCorporation, sOffice);
					
					//Navigate to Properties page:
					ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp,"Property Link", true);
					
					//Select the top Property:
					ClickByXpath(objRWModules.Property_ToolOptions_SelectPropertyNotWalked_xp,"Property item", true);
					
					//Click on Project Tools Tab:
					ClickByXpath(objRWModules.Property_ToolOptions_ProjectToolsTab_xp,"Property tab", true);
					
					//Verify Project Tools Buttons:
					fnCheckFieldDoesNotExistByXpath(objRWModules.Property_ProjectTools_ExportCSV2_xp, "Export CSV2 Button not shown", true);
					fnCheckFieldDoesNotExistByXpath(objRWModules.Property_ProjectTools_ExportCSV3_xp, "Export CSV3 not shown", true);
					fnCheckFieldDoesNotExistByXpath(objRWModules.Property_ProjectTools_FinalPhotosPDF_xp, "Final Photos PDF Button not shown", true);
					fnCheckFieldDoesNotExistByXpath(objRWModules.Property_ProjectTools_PunchList_xp, "Punch List not shown", true);
					fnCheckFieldDoesNotExistByXpath(objRWModules.Property_ProjectTools_InvoiceProject_xp, "Invoice Project Tools Button not shown", true);
					
					
		
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36914 Failed!", e );
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
					log.info("Execution of Function TC36917 Completed");
				}
				return obj;
			} //End of function TC36917
			
			
			
			
			//RW-248_Properties_Management_TC005_Verify Property Docs Tools
			@SuppressWarnings("static-access")
			public Reporter TC36918(Reporter obj) throws Exception
			{
				//Boolean bLoginFlag = true;	
				log.info("Execution of Function TC36918 Started..");

				try {
							
					obj.repAddData( "Verifying that a variety of project tools are displayed", "", "", "");
					
					fnSelectCorpOffice(sCorporation, sOffice);
					
					//Navigate to Properties page:
					ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp,"Property Link", true);
					
					//Select the top Property:
					ClickByXpath(objRWModules.Property_ToolOptions_SelectPropertyNotWalked_xp,"Property item", true);
					
					//Click on Project Tools Tab:
					ClickByXpath(objRWModules.Property_ToolOptions_ProjectToolsTab_xp,"Project Tools tab", true);
					
					List<String> arrButtons = new ArrayList<String>();
					arrButtons.clear();
					arrButtons.add(objRWModules.Property_ProjectTools_ExportCSV_xp);
					arrButtons.add(objRWModules.Property_ProjectTools_PDF_xp);
					arrButtons.add(objRWModules.Property_ProjectTools_ScopeAndPhotos_xp);
					arrButtons.add(objRWModules.Property_ProjectTools_ApprovedScope_xp);
					fnCheckButtonsUnderHeader(objRWModules.Property_ProjectTools_PropertyDocsHeader_xp, arrButtons, "Project Docs" , true);
					
		
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36918 Failed!", e );
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
					log.info("Execution of Function TC36918 Completed");
				}
				return obj;
			} //End of function TC36918
			
			
			
			//RW-248_Properties_Management_TC006_Verify Photo Docs Tools
			@SuppressWarnings("static-access")
			public Reporter TC36919(Reporter obj) throws Exception
			{
				//Boolean bLoginFlag = true;	
				log.info("Execution of Function TC36919 Started..");

				try {
							
					obj.repAddData( "Verifying that a variety of project tools are displayed", "", "", "");
					
					fnSelectCorpOffice(sCorporation, sOffice);
					
					//Navigate to Properties page:
					ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp,"Property Link", true);
					
					//Select the top Property:
					ClickByXpath(objRWModules.Property_ToolOptions_SelectPropertyNotWalked_xp,"Property item", true);
					
					//Click on Project Tools Tab:
					ClickByXpath(objRWModules.Property_ToolOptions_ProjectToolsTab_xp,"Project Tools tab", true);
					
					List<String> arrButtons = new ArrayList<String>();
					arrButtons.clear();
					arrButtons.add(objRWModules.Property_ProjectTools_PhotoLink_xp);
					arrButtons.add(objRWModules.Property_ProjectTools_BidPhotoPDF_xp);
					arrButtons.add(objRWModules.Property_ProjectTools_PhotosZip_xp);
					fnCheckButtonsUnderHeader(objRWModules.Property_ProjectTools_PhotoDocsHeader_xp, arrButtons, "Photo Docs" , true);
					
		
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36919 Failed!", e );
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
					log.info("Execution of Function TC36919 Completed");
				}
				return obj;
			} //End of function TC36919
			
			
			//RW-248_Properties_Management_TC007_Verify Product Ordering Tools
			@SuppressWarnings("static-access")
			public Reporter TC36920(Reporter obj) throws Exception
			{
				//Boolean bLoginFlag = true;	
				log.info("Execution of Function TC36920 Started..");

				try {
							
					obj.repAddData( "Verifying that a variety of project tools are displayed", "", "", "");
					
					fnSelectCorpOffice(sCorporation, sOffice);
					
					//Navigate to Properties page:
					ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp,"Property Link", true);
					
					//Select the top Property:
					ClickByXpath(objRWModules.Property_ToolOptions_SelectPropertyNotWalked_xp,"Property item", true);
					
					//Click on Project Tools Tab:
					ClickByXpath(objRWModules.Property_ToolOptions_ProjectToolsTab_xp,"Project Tools tab", true);
					
					List<String> arrButtons = new ArrayList<String>();
					arrButtons.clear();
					arrButtons.add(objRWModules.Property_ProjectTools_BuildHDQuote_xp);
					fnCheckButtonsUnderHeader(objRWModules.Property_ProjectTools_ProductOrderingHeader_xp, arrButtons, "Photo Docs" , true);
					
		
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36920 Failed!", e );
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
					log.info("Execution of Function TC36920 Completed");
				}
				return obj;
			} //End of function TC36920
			
			
			//RW-248_Properties_Management_TC008_Verify Home Depot Bids
			@SuppressWarnings("static-access")
			public Reporter TC36921(Reporter obj) throws Exception
			{
				//Boolean bLoginFlag = true;	
				log.info("Execution of Function TC36921 Started..");

				try {
							
					obj.repAddData( "Verifying that a variety of project tools are displayed", "", "", "");
					
					fnSelectCorpOffice(sCorporation, sOffice);
					
					//Navigate to Properties page:
					ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp,"Property Link", true);
					
					//Select the top Property:
					ClickByXpath(objRWModules.Property_ToolOptions_SelectPropertyNotWalked_xp,"Property item", true);
					
					//Click on Project Tools Tab:
					ClickByXpath(objRWModules.Property_ToolOptions_ProjectToolsTab_xp,"Project Tools tab", true);
					
					List<String> arrButtons = new ArrayList<String>();
					arrButtons.clear();
					arrButtons.add(objRWModules.Property_ProjectTools_SubmitBid_xp);
					fnCheckButtonsUnderHeader(objRWModules.Property_ProjectTools_HomeDepotBidsHeader_xp, arrButtons, "Home Depot Bids" , true);
					
		
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36921 Failed!", e );
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
					log.info("Execution of Function TC36921 Completed");
				}
				return obj;
			} //End of function TC36921
			
			
			
			///////////////////////////////////////ToolOptions Tests End Here///////////////////////////////////////////////////////////////////////////
			
			
			
			///////////////////////////////////////Spike/Dummy Starts Here////////////////////////////////////////////////////////////////////////////
			
			//RW-58_Regions_TC017_Add Region_Validate Region Name with duplicate Region name
			@SuppressWarnings("static-access")
			public Reporter TC1111111(Reporter obj) throws Exception
			{
				//Boolean bLoginFlag = true;	
				log.info("Execution of Function TC1111111 Started..");

				try {
							
					obj.repAddData( "Executing SoapUI Test", "", "", "");
					
					String[] cmdArray = new String[3];
					//Runtime.getRuntime().exec("C:\\Soap_Projects\\soap_selenium_launcher.bat C:\\Soap_Projects\\SeleniumIntegration-soapui-project.xml");
					
					 cmdArray[0] = "C:\\Soap_Projects\\soap_selenium_launcher.bat";

					   // second argument is a txt file we want to open with notepad
					   cmdArray[1] = "C:\\Soap_Projects\\SeleniumIntegration-soapui-project.xml";
					   cmdArray[2] = "TS";
					   //cmdArray[3] = "TC_2";

					   // print a message
					   System.out.println("Executing soap project from selenium..");

					   // create a process and execute cmdArray
					   Process process = Runtime.getRuntime().exec(cmdArray);
					   try {
						process.waitFor();
						if(process.exitValue()==0)
						{
							obj.repAddData( "Run SoapUI Test", "SoapUI Test should be passed", "SoapUI Test passed successfully", "Pass");
						}
						else
						{
							obj.repAddData( "Run SoapUI Test", "SoapUI Test should be passed", "SoapUI Test failed with exit value - "+process.exitValue(), "Fail");
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						obj.repAddData( "Run SoapUI Test", "SoapUI Test should be passed", "SoapUI Test failed with exit value - "+process.exitValue(), "Fail");
						e.printStackTrace();
					}
					   System.out.println("Execution Completed with Exit value "+process.exitValue());

									}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					if(driver.findElement(By.xpath(objRWModules.Common_AddModule_BtnCancel_xp)).isEnabled())
					{
						ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);  //post condition
					}
					log.error( "Function TC1111111 Failed!", e );
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
					
					log.info("Execution of Function TC1111111 Completed");
				}
				return obj;
			} //End of function TC1111111	
			
			//Renowalk - Regression - Login to Renowalk and Logout - 1
			@SuppressWarnings("static-access")
			public Reporter TC25701(Reporter obj) throws Exception
			{
				Boolean bLoginFlag = false;	
				log.info("Execution of Function fn25701 Started..");
				
		
				try {
							
					obj.repAddData( "View Properties", "", "", "");
					
					ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);
					
					fnLoadingPageWait();

					/*CheckId(objRWModules.Property_ViewProp_BtnAddProperty_id,"'Add Property' button",true);
					CheckXpath(objRWModules.Property_ViewProp_LabelProperties_xp,"'Properties' Label",true);
					
					HighlightElementById(objRWModules.Property_ViewProp_ComboStatus_id);
					Select select = new Select(driver.findElement(By.id(objRWModules.Property_ViewProp_ComboStatus_id)));
					String sString = select.getFirstSelectedOption().getText();
					
					if(sString.equalsIgnoreCase("Select Status"))
					{
						obj.repAddData( "Verify Status combo box", "'Select Status' should be selected in the combo box", "'Select Status' is selected in the combo box", "Pass");
					}
					else
					{
						obj.repAddData( "Verify Status combo box", "'Select Status' should be selected in the combo box", "'Select Status' is not selected in the combo box", "Fail");
					}
					
					CheckId(objRWModules.Property_ViewProp_InputSearchValue_id,"'Search Value' field",true);*/
					
					
					List<WebElement> arrTBodies = driver.findElements(By.xpath(objRWModules.Property_ViewProp_TableListItem_xp));
					System.out.println("TBodies Size>>>>"+arrTBodies.size());
					List<WebElement> arrRows = arrTBodies.get(0).findElements(By.xpath("./tr"));  //Get the header
					System.out.println("Rows Size>>>>"+arrRows.size());
					List<WebElement> arrColumns = arrRows.get(0).findElements(By.xpath("./th"));  //Get the header
						
					/*System.out.println("Column Size>>>>"+arrColumns.size());
					if(arrColumns.size()>0)
					{
					fnVerifyHeaders(arrColumns,0,"Status");
					fnVerifyHeaders(arrColumns,1,"Project Name");
					fnVerifyHeaders(arrColumns,2,"Address");
					fnVerifyHeaders(arrColumns,3,"City");
					fnVerifyHeaders(arrColumns,4,"County");
					fnVerifyHeaders(arrColumns,5,"Assigned User");
					fnVerifyHeaders(arrColumns,6,"Last Activity");
					}
					else
					{
						System.out.println("Property table is not loaded");
						log.info("Property table is not loaded");
					}
					
					List<WebElement> arrRecordRows = arrTBodies.get(1).findElements(By.xpath("./tr"));  //Get the header
					List<WebElement> arrRecordColumns = arrRecordRows.get(0).findElements(By.xpath("./td"));  //Get the header
					//String sParentProjName = arrRecordColumns.get(1).findElement(By.xpath("..")).getTagName();
					String sChildProjName = arrRecordColumns.get(1).findElement(By.xpath("*")).getTagName();

					if(sChildProjName.equalsIgnoreCase("b"))
					{
						obj.repAddData( "Check 'Project Name'", "'Project Name' should be in bold font", "'Project Name' is in bold font", "Pass");
					}
					else
					{
						obj.repAddData( "Check 'Project Name'", "'Project Name' should be in bold font", "'Project Name' is not in bold font", "Fail");
					}
					
					ClickByElement(arrRecordColumns.get(1), "First Project Name",true);  //Clicking on first project name
					//arrRecordColumns.get(1).click();  //Clicking on first project name
					fnLoadingPageWait();
					
					CheckId(objRWModules.Property_UpdateProp_BtnUpdateProperty_id,"'Update Property' page",true);
					ClickById(objRWModules.Property_GenProp_BtnCancelProperty_id,"'Cancel Property' page",false);
					
					*/
					////////////////////Sorting Logic////////////////////////////
					//fnCheckSorting(objRWModules.Property_ViewProp_TableListItem_xp, "County", 5);
					//fnCheckDateSorting(mTableData, "Last Activity", 7, "");
					////////////////////Sorting Logic End////////////////////////////
					
					
				
				}
				
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function fn25701 Failed!", e );
				}
				finally {
					
					if((bLoginFlag==true && driver!=null) )
					{
						fnSignOut();
					}
	
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
					/*obj.repGenerateResult(Test_Case_Name, header);
					obj.repGenerateIndexReport(indexHeader);
					header = null;    //Enable after testing
	*/				log.info("Execution of Function fn25701 Completed");
				}
				return obj;
			} //End of function fn25701	

		//Renowalk - Regression - Login to Renowalk and Logout - 1
			@SuppressWarnings("static-access")
			public Reporter TC25702(Reporter obj) throws Exception
			{
				//Boolean bLoginFlag = true;	
				log.info("Execution of Function TC25702 Started..");
				
		
				try {
							
					obj.repAddData( "Pagination Verification", "", "", "");
					
					/*ClickByXpath(objRWModules.Corporations_GenCorp_LinkCorporationsOption_xp, "Corporations Link",true);
					fnLoadingPageWait();
					ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
					fnLoadingPageWait();*/
					ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
					fnLoadingPageWait();
	
					CheckXpath(RenowalkModules.Offices_ViewOffice_BtnAddOffice_xp,"'Add Office' button",true,true);
					HighlightElement(driver.findElement(By.xpath(RenowalkModules.Offices_ViewOffice_BtnAddOffice_xp)));
					CheckXpath(RenowalkModules.Offices_ViewOffice_LabelCurrentOffices_xp,"'Current Offices' label",true,true);
					HighlightElement(driver.findElement(By.xpath(RenowalkModules.Offices_ViewOffice_LabelCurrentOffices_xp)));
					
					
					WebElement eleTable = driver.findElement(By.xpath(objRWModules.Common_ViewModules_Table_xp));
					List<WebElement> arrHeaderColumns = eleTable.findElements(By.xpath("./thead/tr/th"));  //Get the header
					System.out.println("Rows Size>>>>"+arrHeaderColumns.size());
					fnVerifyHeaders(arrHeaderColumns,0,"Region Name");
					fnVerifyHeaders(arrHeaderColumns,1,"Default Store");
					
					
					HighlightElementByXpath(objRWModules.Common_ViewModules_ComboPageSize_xp);
					Select select = new Select(driver.findElement(By.xpath(objRWModules.Common_ViewModules_ComboPageSize_xp)));
					List<WebElement> arrPageSize = select.getOptions();
					System.out.println("Page Combobox Size>>>>"+arrPageSize.size());
					
					/*fnVerifyComboBoxValues(arrPageSize, 0, "10 PER PAGE");
					fnVerifyComboBoxValues(arrPageSize, 1, "20 PER PAGE");
					fnVerifyComboBoxValues(arrPageSize, 2, "VIEW ALL");*/
					
					int iMultiPages = CheckXpath(RenowalkModules.Common_ViewModules_LabelTotalPages_xp, "Total No of Pages", false,true);
					
					if(iMultiPages>0)
					{
						String sTotalPageNum = driver.findElement(By.xpath(RenowalkModules.Common_ViewModules_LabelTotalPages_xp)).getText();
						int iTotalPageNum =  Integer.parseInt(sTotalPageNum);
						iTotalPageNum = iTotalPageNum -1;
						SendKeyByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp, String.valueOf(iTotalPageNum), "Page Number");
					}
				
					eleTable = driver.findElement(By.xpath(objRWModules.Common_ViewModules_Table_xp));
					List<WebElement> arrTableRows = eleTable.findElements(By.xpath("./tbody/tr"));  //Get the table data rows
					System.out.println("Data Rows Size>>>>"+arrTableRows.size());
					
				/*	if(arrTableRows.size()>=10)
					{
						CheckXpath(RenowalkModules.Common_ViewModules_BtnPreviousLink_xp,"'Previous' button",true);
						CheckXpath(RenowalkModules.Common_ViewModules_BtnNextLink_xp,"'Next' button",true);
						CheckXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",true);						
					}
					else
					{
						
					}*/
					
					//HashMap<Integer, ArrayList<String>> mTableData = new HashMap<Integer,ArrayList<String>>();
					
					HashMap<Integer, HashMap<Integer, String>> mTableData = new HashMap<Integer,HashMap<Integer, String>>();
					ArrayList<String> arrTableData = new ArrayList<String>();

					for(int iRow=0;iRow<arrTableRows.size();iRow++)
					{	
						//arrTableData.clear();
						String sColValue=null;
						mTableData.put(iRow+1, new HashMap<Integer, String>());
						
						List<WebElement> arrTableColumns = arrTableRows.get(iRow).findElements(By.xpath("./td"));  //Get the table data rows
						for(int iCol=0;iCol<arrTableColumns.size();iCol++)
						{
							List<WebElement> arrEditDelete;	
						
							switch (iCol) 
							{
								case 0: //sColValue = arrTableColumns.get(iCol).findElement(By.xpath("./b")).getText();//.toString();
										sColValue = arrTableColumns.get(iCol).findElement(By.xpath("./b")).getAttribute("innerText");
										System.out.println("sColValue"+sColValue);
										break;
								case 1: sColValue = arrTableColumns.get(iCol).getText().toString();
										break;
								case 2: arrEditDelete = arrTableColumns.get(iCol).findElements(By.xpath("./div/span"));
										String sEdit  = arrEditDelete.get(0).getAttribute("title");
										String sDelete = arrEditDelete.get(1).getAttribute("title");
										System.out.println(sEdit+sDelete);
										sColValue= sEdit+","+sDelete;
										break;
							}
							arrTableData.add(sColValue);
							
							mTableData.get(iRow+1).put(iCol+1,sColValue);
						}
						

					}
					
					fnCheckSortedList(mTableData,"Office Name",1);
					System.out.println("Data Retrieved Successfully");
					
					/*CheckId(objRWModules.Property_ViewProp_BtnAddProperty_id,"'Add Property' button",true);
					CheckXpath(objRWModules.Property_ViewProp_LabelProperties_xp,"'Properties' Label",true);
					
					HighlightElementById(objRWModules.Property_ViewProp_ComboStatus_id);
					Select select = new Select(driver.findElement(By.id(objRWModules.Property_ViewProp_ComboStatus_id)));
					String sString = select.getFirstSelectedOption().getText();
					
					if(sString.equalsIgnoreCase("Select Status"))
					{
						obj.repAddData( "Verify Status combo box", "'Select Status' should be selected in the combo box", "'Select Status' is selected in the combo box", "Pass");
					}
					else
					{
						obj.repAddData( "Verify Status combo box", "'Select Status' should be selected in the combo box", "'Select Status' is not selected in the combo box", "Fail");
					}
					
					CheckId(objRWModules.Property_ViewProp_InputSearchValue_id,"'Search Value' field",true);*/
				/*	
							
							List<WebElement> arrTBodies = driver.findElements(By.xpath(objRWModules.Property_ViewProp_TableListItem_xp));
							System.out.println("TBodies Size>>>>"+arrTBodies.size());
							List<WebElement> arrRows = arrTBodies.get(0).findElements(By.xpath("./tr"));  //Get the header
							System.out.println("Rows Size>>>>"+arrRows.size());
							List<WebElement> arrColumns = arrRows.get(0).findElements(By.xpath("./th"));  //Get the header
*/								
					/*System.out.println("Column Size>>>>"+arrColumns.size());
					if(arrColumns.size()>0)
					{
					fnVerifyHeaders(arrColumns,0,"Status");
					fnVerifyHeaders(arrColumns,1,"Project Name");
					fnVerifyHeaders(arrColumns,2,"Address");
					fnVerifyHeaders(arrColumns,3,"City");
					fnVerifyHeaders(arrColumns,4,"County");
					fnVerifyHeaders(arrColumns,5,"Assigned User");
					fnVerifyHeaders(arrColumns,6,"Last Activity");
					}
					else
					{
						System.out.println("Property table is not loaded");
						log.info("Property table is not loaded");
					}
					
					List<WebElement> arrRecordRows = arrTBodies.get(1).findElements(By.xpath("./tr"));  //Get the header
					List<WebElement> arrRecordColumns = arrRecordRows.get(0).findElements(By.xpath("./td"));  //Get the header
					//String sParentProjName = arrRecordColumns.get(1).findElement(By.xpath("..")).getTagName();
					String sChildProjName = arrRecordColumns.get(1).findElement(By.xpath("*")).getTagName();
	
					if(sChildProjName.equalsIgnoreCase("b"))
					{
						obj.repAddData( "Check 'Project Name'", "'Project Name' should be in bold font", "'Project Name' is in bold font", "Pass");
					}
					else
					{
						obj.repAddData( "Check 'Project Name'", "'Project Name' should be in bold font", "'Project Name' is not in bold font", "Fail");
					}
					
					ClickByElement(arrRecordColumns.get(1), "First Project Name",true);  //Clicking on first project name
					//arrRecordColumns.get(1).click();  //Clicking on first project name
					fnLoadingPageWait();
					
					CheckId(objRWModules.Property_UpdateProp_BtnUpdateProperty_id,"'Update Property' page",true);
					ClickById(objRWModules.Property_GenProp_BtnCancelProperty_id,"'Cancel Property' page",false);
					
					*/
					////////////////////Sorting Logic////////////////////////////
					//fnCheckSorting(objRWModules.Property_ViewProp_TableListItem_xp, "County", 5);
			//		fnCheckDateSorting(objRWModules.Property_ViewProp_TableListItem_xp, "Last Activity", 7);
					////////////////////Sorting Logic End////////////////////////////

				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function fn25701 Failed!", e );
				}
				finally {
					
					/*if((bLoginFlag==true && driver!=null) )
					{
						fnSignOut();
					}*/
	
					if(!testCaseStatus)
					{
						Reporter.iTotalFail++;	
					}
					else
					{
						Reporter.iTotalPass++;
					}
					/*obj.repGenerateResult(Test_Case_Name, header);
					obj.repGenerateIndexReport(indexHeader);
					header = null;    //Enable after testing
	*/				log.info("Execution of Function TC25702 Completed");
				}
				return obj;
			} //End of function TC25702	

					//Renowalk - Regression - Login to Renowalk and Logout - 1
					public Reporter TC26677(Reporter obj) throws Exception
					{
						Boolean bLoginFlag = false;	
						log.info("Execution of Function TC26677 Started..");
						obj.repAddData( "Home page", "", "", "");
						obj.repAddData( "Verify Renowalk home page", "Home page should be loaded", "Home page loaded successfully", "Pass");
						obj.repAddData( "Verify Renowalk ", "Home page should be loaded", "Home page loaded successfully", "Pass");
				  				
						try {
									
							//Write your code here
						}
						
						catch (Exception e) {
							e.printStackTrace();
							testCaseStatus = false;
							//bLoginFlag=false;
							obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
							log.error( "Function TC26677 Failed!", e );
						}
						finally {
							
							if((bLoginFlag==true && driver!=null) )
							{
								fnSignOut();
							}
			
							if(!testCaseStatus)
							{
								Reporter.iTotalFail++;	
							}
							else
							{
								Reporter.iTotalPass++;
							}
							/*obj.repGenerateResult(Test_Case_Name, header);
							obj.repGenerateIndexReport(indexHeader);
							header = null;    //Enable after testing
			*/				log.info("Execution of Function TC26677 Completed");
						}
						return obj;
					} //End of function TC26677	

				//Renowalk - Regression - Login to Renowalk and Logout - 2
				public Reporter TC157158(Reporter obj) throws Exception
				{
					Boolean bLoginFlag = true;	
					log.info("Execution of Function fn157158 Started..");
					obj.repAddData( "Verify Renowalk home page", "Home page should be loaded", "Home page loaded successfully", "Fail");
					obj.repAddData( "Verify Renowalk home page", "Home page should be loaded", "Home page loaded successfully", "Fail");
			  				
					try {
								
						//Write your code here
					}
					
					catch (Exception e) {
						e.printStackTrace();
						testCaseStatus = false;
						//bLoginFlag=false;
						obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
						log.error( "Function fn157158 Failed!", e );
					}
					finally {
						
						if((bLoginFlag==true && driver!=null) )
						{
							fnSignOut();
						}
		
						if(!testCaseStatus)
						{
							Reporter.iTotalFail++;	
						}
						else
						{
							Reporter.iTotalPass++;
						}
						/*obj.repGenerateResult(Test_Case_Name, header);
						obj.repGenerateIndexReport(indexHeader);
						header = null;    //Enable after testing
		*/				log.info("Execution of Function fn157158 Completed");
					}
					return obj;
				} //End of function fn157158	

		//Renowalk - Regression - Login to Renowalk and Logout - 3
		public Reporter TC157159(Reporter obj) throws Exception
		{
			Boolean bLoginFlag = false;
			obj.repAddData( "Home page", "", "", "");
			obj.repAddData( "Verify Renowalk home page", "Home page should be loaded", "Home page loaded successfully", "Pass");
			obj.repAddData( "Verify Renowalk home page", "Home page should be loaded", "Home page loaded successfully", "Fail");
			log.info("Execution of Function fn157159 Started..");
		  				
			try {
					
				//Write your code here
			}
			
			catch (Exception e) {
				e.printStackTrace();
				testCaseStatus = false;
				//bLoginFlag=false;
				obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
				log.error( "Function fn157159 Failed!", e );
			}
			finally {
				
				if((bLoginFlag==true && driver!=null) )
				{
					fnSignOut();
				}

				if(!testCaseStatus)
				{
					Reporter.iTotalFail++;	
				}
				else
				{
					Reporter.iTotalPass++;
				}

				log.info("Execution of Function fn157159 Completed");
			}
			return obj;
		} //End of function fn157159
		
		public Reporter TC805(Reporter obj) throws Exception {
			//log in and go to properties
			//click testproperty na
			//click budget
			try {
				driver.get("https://thd.nitrotransit.com/keystoneadmin/index.html");
				driver.findElement(By.id("username")).sendKeys("officeadmin1");
				driver.findElement(By.id("password")).sendKeys("chavali21");
				driver.findElement(By.id("submit_form")).click();
				driver.wait(2000);
				driver.findElement(By.xpath("//a[@class='tabs-nav-item NavigationTextColor' and @lang='Server/Property.html']")).click();
				driver.findElement(By.id("SearchValue")).sendKeys("TestPropertyNA");
				driver.findElement(By.name("btnSearch")).click();
				driver.findElement(By.xpath("//table[@class='alt-list property']/tbody/tr[1]/td/b/label")).click();
				driver.findElement(By.xpath("//a[text()='Budget']")).click();
				
			}
			catch (Exception e) {
				e.printStackTrace();
				testCaseStatus = false;
				//bLoginFlag=false;
				obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
				log.error( "Function TC805 Failed!", e );
			}
			finally {
				
				if((bLoginFlag==true && driver!=null) )
				{
					fnSignOut();
				}

				if(!testCaseStatus)
				{
					Reporter.iTotalFail++;	
				}
				else
				{
					Reporter.iTotalPass++;
				}

				log.info("Execution of Function fn157159 Completed");
			}
			return obj;	
		}
		
		public Reporter TC807(Reporter obj) throws Exception
		{
			try {
				driver.get("https://thd.nitrotransit.com/keystoneadmin/index.html");
				driver.findElement(By.id("username")).sendKeys("officeadmin1");
				driver.findElement(By.id("password")).sendKeys("chavali21");
				driver.findElement(By.id("submit_form")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//a[@class='tabs-nav-item NavigationTextColor' and @lang='Server/Property.html']")).click();
				Thread.sleep(10000);
				driver.findElement(By.id("SearchValue")).sendKeys("TestPropertyNA");
				driver.findElement(By.name("btnSearch")).click();
				Thread.sleep(10000);
				driver.findElement(By.xpath("//table[@class='alt-list property']/tbody/tr[1]/td/b/label")).click();
				Thread.sleep(25000);
				driver.findElement(By.xpath("//a[text()='Budget']")).click();
				Thread.sleep(10000);
				
				List<WebElement> headers = driver.findElements(By.xpath("//td[@id='PR_PWFlowGroupData']/h1"));
				List<List<String>> items = new ArrayList<List<String>>();
				int tick = 1;
				for (WebElement ele : headers) {
					List<WebElement> rowStore = driver.findElements(By.xpath("//td[@id='PR_PWFlowGroupData']/table["+tick+"]/tbody/tr"));
					rowStore.remove(0);
					for (WebElement rowEle : rowStore) {
						List<String> tempList = new ArrayList<String>();
						tempList.add(ele.getText());
						List<WebElement> rowChildEles = rowEle.findElements(By.xpath(".//td"));
						rowChildEles.remove(0);
						for (WebElement rcEle : rowChildEles) {
							String eleText = rcEle.getText().replace("$", "");
							if (eleText.equals("\u00a0")) {
								tempList.add("null");
							} else {
								tempList.add(eleText);
							}
						}
						items.add(tempList);
					}
					
					tick++;
				}
				FilloUtil.insertBudgetRecordSet("WEB", items);
				
				List<List<String>> iPadRecords = FilloUtil.getBudgetRecordSet("Ipad");
				List<List<String>> webRecords = FilloUtil.getBudgetRecordSet("Web");
				if (iPadRecords.size() == webRecords.size()){
					for (int i = 0; i < iPadRecords.size();i++) {
						boolean foundMatching = true;
						List<String> currentComparisonInfo = new ArrayList<String>();
						String[] compareResults = FilloUtil.compareRecords(iPadRecords.get(i), webRecords.get(i)).split(",");
						String sMismatchedAtIndex = "";
						currentComparisonInfo.add(iPadRecords.get(i).get(0));
						currentComparisonInfo.add(iPadRecords.get(i).get(1));
						currentComparisonInfo.add(webRecords.get(i).get(0));
						currentComparisonInfo.add(webRecords.get(i).get(1));
						
						if (compareResults[0].equals("true")) {
							//keep foundMatching equal to true
							currentComparisonInfo.add("Yes");
						} else {
							foundMatching = false;
							currentComparisonInfo.add("No");
						}
						if (compareResults[1].equals("None")) {
							//do nothing
						} else {
							switch (Integer.parseInt(compareResults[1])) {
								case 0: sMismatchedAtIndex = "Failed at Group Name";
								break;
								case 1: sMismatchedAtIndex = "Failed at Item Title";
								break;
								case 2: sMismatchedAtIndex = "Failed at Item Comments";
								break;
								case 3: sMismatchedAtIndex = "Failed at Item Quantity";
								break;
								case 4: sMismatchedAtIndex = "Failed at Item Unit Price";
								break;
								case 5: sMismatchedAtIndex = "Failed at Item Total Price";
								break;
							}
						}
						currentComparisonInfo.add(sMismatchedAtIndex);
						//Insert result sheet
						boolean b = FilloUtil.insertComparison(currentComparisonInfo);
						String sRes;
						if (b && foundMatching) { sRes = "Pass"; } else { sRes = "Fail"; }
						obj.repAddData("Compared "+i+" Records", "", "", sRes);
					}
				}
				
			}
			
			catch (Exception e) {
				e.printStackTrace();
				testCaseStatus = false;
				//bLoginFlag=false;
				obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
				log.error( "Function TC807 Failed!", e );
			}
			finally {
				
				if((bLoginFlag==true && driver!=null) )
				{
					fnSignOut();
				}

				if(!testCaseStatus)
				{
					Reporter.iTotalFail++;	
				}
				else
				{
					Reporter.iTotalPass++;
				}

				log.info("Execution of Function fn157159 Completed");
			}
			return obj;		
		}
		
		public Reporter TC808(Reporter obj) throws Exception
		{
			try {
				List<List<String>> iPadRecords = FilloUtil.getBudgetRecordSet("Ipad");
				List<List<String>> webRecords = FilloUtil.getBudgetRecordSet("Web");
				if (iPadRecords.size() == webRecords.size()){
					for (int i = 0; i < iPadRecords.size();i++) {
						boolean foundMatching = true;
						List<String> currentComparisonInfo = new ArrayList<String>();
						String[] compareResults = FilloUtil.compareRecords(iPadRecords.get(i), webRecords.get(i)).split(",");
						String sMismatchedAtIndex = "";
						currentComparisonInfo.add(iPadRecords.get(i).get(0));
						currentComparisonInfo.add(iPadRecords.get(i).get(1));
						currentComparisonInfo.add(webRecords.get(i).get(0));
						currentComparisonInfo.add(webRecords.get(i).get(1));
						
						if (compareResults[0].equals("true")) {
							//keep foundMatching equal to true
							currentComparisonInfo.add("Yes");
						} else {
							foundMatching = false;
							currentComparisonInfo.add("No");
						}
						if (compareResults[1].equals("None")) {
							//do nothing
						} else {
							switch (Integer.parseInt(compareResults[1])) {
								case 0: sMismatchedAtIndex = "Failed at Group Name";
								break;
								case 1: sMismatchedAtIndex = "Failed at Item Title";
								break;
								case 2: sMismatchedAtIndex = "Failed at Item Comments";
								break;
								case 3: sMismatchedAtIndex = "Failed at Item Quantity";
								break;
								case 4: sMismatchedAtIndex = "Failed at Item Unit Price";
								break;
								case 5: sMismatchedAtIndex = "Failed at Item Total Price";
								break;
							}
						}
						currentComparisonInfo.add(sMismatchedAtIndex);
						//Insert result sheet
						boolean b = FilloUtil.insertComparison(currentComparisonInfo);
						String sRes;
						if (b && foundMatching) { sRes = "Pass"; } else { sRes = "Fail"; }
						obj.repAddData("Compared "+i+" Records", "", "", sRes);
					}
				}
			}
			
			catch (Exception e) {
				e.printStackTrace();
				testCaseStatus = false;
				//bLoginFlag=false;
				obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
				log.error( "Function TCBUDGETCOMPARE Failed!", e );
			}
			finally {
				
				if((bLoginFlag==true && driver!=null) )
				{
					fnSignOut();
				}

				if(!testCaseStatus)
				{
					Reporter.iTotalFail++;	
				}
				else
				{
					Reporter.iTotalPass++;
				}

				log.info("Execution of Function TC808 Completed");
			}
			return obj;		
		}
} //End of Class