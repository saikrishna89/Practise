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

public class Flow extends TestDriver {
	RenowalkModules objRWModules = new RenowalkModules();
	RenowalkHome objRWHome = new RenowalkHome();
	AppMessages objAppMessages = new AppMessages();
	
	
			public Reporter TC36943(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC36943 Started..");

				try {
							
					obj.repAddData( "Verify Flow Page View", "", "", "");
					//Set Corp and Office, load Flow page
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Items",true);
					fnLoadingPageWait();
					
					///Check view
					ClickByXpath(RenowalkModules.Flow_AddFlow_BtnAddFlow_xp,"Add Flow",true);
					
					//Check for JSON upload module
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_JsonUploadLabel_xp,"Json Upload Box",true,true);
					//Required check for JSON import submit button
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_ImportJson_xp,"Import Json Button",true,true);
					//Check for an existing flow in the list
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FirstCurrentFlows_xp,"First Current Flow in list",true,true);
					//Check for options area
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FirstFlowOptions_xp,"First flow's options",true,true);
					//Check for Export button
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FirstFlowExport_xp,"First flow's export",true,true);
					//Check for Edit button
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FirstFlowEdit_xp,"First flow's edit",true,true);
					//Check for Delete button 
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FirstFlowDelete_xp,"First flow's delete",true,true);
					
					
					obj.repAddData("Found all objects. Closing Page.", "", "", "");
					//Cancel Post Condition
					ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
				
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36943 Failed!", e );
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
					log.info("Execution of Function TC36943 Completed");
				}
				return obj;
			}
			
			public Reporter TC36944(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC36944 Started..");

				try {
							
					obj.repAddData( "Verify Add Flow Page View", "", "", "");
					//Set Corp and Office, load Flow page
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Items",true);
					fnLoadingPageWait();
					
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp,"Add Flow button",true);
					fnLoadingPageWait();
					
					///Check view
					//Check for JSON upload module
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_JsonUploadLabel_xp,"Json Upload Box",true,true);
					//Check for Delete before Import checkbox
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_DeleteBeforeCheck_nm,"Delete before Import checkbox",true,true);
					//Required check for JSON import submit button
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_ImportJson_xp,"Import Json Button",true,true);
					//Check for flow name input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowNameInput_nm,"Flow name input field",true,true);
					//Check for flow description input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm,"Flow name input field",true,true);
					//Check for Flooring section table
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FlowFlooringSection_xp,"First flow's export",true,true);
					
					obj.repAddData("Found all objects. Closing Page.", "", "", "");
					//Cancel Post Condition
					ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36944 Failed!", e );
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
					log.info("Execution of Function TC36944 Completed");
				}
				return obj;
			}
			
			public Reporter TC36945(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC36945 Started..");

				try {
							
					obj.repAddData( "Verify Add Flow Page View", "", "", "");
					//Set Corp and Office, load Flow page
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Items",true);
					fnLoadingPageWait();
					
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp,"Add Flow button",true);
					fnLoadingPageWait();
					
					///Check view
					//Check for Name input required indicator
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FlowNameReqIndicator_xp,"Name required indicator",true,true);
					//Check for Description input required indicator
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FlowDescReqIndicator_xp,"Description required indicator",true,true);
					
					obj.repAddData("Found all objects. Closing Page.", "", "", "");
					
					//Cancel Post Condition
					ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36945 Failed!", e );
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
					log.info("Execution of Function TC36945 Completed");
				}
				return obj;
			}
			
			public Reporter TC36946(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC36946 Started..");

				try {
							
					obj.repAddData( "Verify Add Flow Page View", "", "", "");
					//Set Corp and Office, load Flow page
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Items",true);
					fnLoadingPageWait();
					
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp,"Add Flow button",true);
					fnLoadingPageWait();
					
					///Check view
					//Check for flow name input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowNameInput_nm,"Flow name input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowNameInput_nm)).sendKeys("TestName");
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowNameInput_nm)).clear();
					
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FlowNameRequiredMsg_xp,"Flow name required message",true,true);
					
					//Check for flow description input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm,"Flow name input field",true,true);
					
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm)).sendKeys("TestName");
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm)).clear();
					
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FlowDescRequiredMsg_xp,"Flow description required message",true,true);
					
					obj.repAddData("Found all objects. Closing Page.", "", "", "");
					
					//Cancel Post Condition
					ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
					fnVerifyCancelForm(1);
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36946 Failed!", e );
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
					log.info("Execution of Function TC36946 Completed");
				}
				return obj;
			}
			
			public Reporter TC36948(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC36948 Started..");

				try {
							
					obj.repAddData( "Verify Add Flow Page View", "", "", "");
					//Set Corp and Office, load Flow page
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Items",true);
					fnLoadingPageWait();
					
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp,"Add Flow button",true);
					fnLoadingPageWait();
					
					///Check view
					//Check for flow name input and message
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowNameInput_nm,"Flow name input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowNameInput_nm)).sendKeys(fnGenerateStr(256));
					
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FlowNameLengthMsg_xp,"Flow name length error message",true,true);
					
					//Check for flow description input and message
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm,"Flow description input field",true,true);
					
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm)).sendKeys(fnGenerateStr(4001));
					
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FlowDescLengthMsg_xp,"Flow description length error message",true,true);
					
					
					//Check for flow labor rate input and message
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowHourlyRate_nm,"Flow labor rate input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowHourlyRate_nm)).sendKeys(String.valueOf(fnRandomNum(1000, 1005)));
					
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FlowLaborRateLengthMsg_xp,"Flow labor rate length error message",true,true);
					
					//Check for flow waste pct input and message
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FlowCarpetWastePctInput_xp,"Flow waste percentage input field",true,true);
					
					driver.findElement(By.xpath(RenowalkModules.Flow_AddFlow_FlowCarpetWastePctInput_xp)).sendKeys(String.valueOf(fnRandomNum(1000, 1005)));
					
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FlowCarpetWastePctLengthMsg_xp,"Waste percentage length message",true,true);
					
					obj.repAddData("Found all objects. Closing Page.", "", "", "");
					
					//Cancel Post Condition
					ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
					fnVerifyCancelForm(1);
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36948 Failed!", e );
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
					log.info("Execution of Function TC36948 Completed");
				}
				return obj;
			}
			
			public Reporter TC36953(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC36953 Started..");

				try {
					String testName = "TestNameXX";
					obj.repAddData( "Verify Add Flow Page View", "", "", "");
					//Set Corp and Office, load Flow page
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Items",true);
					fnLoadingPageWait();
					
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp,"Add Flow button",true);
					fnLoadingPageWait();
					
					///Check view
					//Fill flow name input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowNameInput_nm,"Flow name input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowNameInput_nm)).sendKeys(testName);
					
					//Fill flow description input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm,"Flow description input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm)).sendKeys(testName);
					
					obj.repAddData("Saving Flow.", "", "", "");
					
					//Save flow
					ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",false);
					fnVerifyDialogBox("Add",0);
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FlowNameFindInList_xp.replaceAll("TOKEN", testName),"Saved test name in list",true,true);
					
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36953 Failed!", e );
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
					log.info("Execution of Function TC36953 Completed");
				}
				return obj;
			}
			
			public Reporter TC36956(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC36956 Started..");

				try {
					String testName = "TestName09";
					obj.repAddData( "Verify Add Flow Page View", "", "", "");
					//Set Corp and Office, load Flow page
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Flow",true);
					fnLoadingPageWait();
					
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp,"Add Flow button",true);
					fnLoadingPageWait();
					
					///Check view
					//Check for flow name input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowNameInput_nm,"Flow name input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowNameInput_nm)).sendKeys(testName);
					
					//Check for flow description input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm,"Flow description input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm)).sendKeys(testName);
					
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_PaintColorInput_xp,"Paint color input",true,true);
					driver.findElement(By.xpath(RenowalkModules.Flow_AddFlow_PaintColorInput_xp)).sendKeys(fnGenerateStr(60));
					
					
					
					//Save flow
					ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",false);
					fnVerifyDialogBox("Add",0);
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36956 Failed!", e );
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
					log.info("Execution of Function TC36956 Completed");
				}
				return obj;
			}
			
			public Reporter TC36957(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC36957 Started..");

				try {
					String testName = "TestName10";
					obj.repAddData( "Verify Add Flow Page View", "", "", "");
					//Set Corp and Office, load Flow page
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Items",true);
					fnLoadingPageWait();
					
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp,"Add Flow button",true);
					fnLoadingPageWait();
					
					///Check view
					//Check for flow name input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowNameInput_nm,"Flow name input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowNameInput_nm)).sendKeys(testName);
					
					//Check for flow description input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm,"Flow description input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm)).sendKeys(testName);
					
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_PaintColorInput_xp,"Paint color input",true,true);
					driver.findElement(By.xpath(RenowalkModules.Flow_AddFlow_PaintColorInput_xp)).sendKeys(fnGenerateStr(61));
					
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_PaintColorLengthMsg_xp,"Paint color length error message",true,true);
					
					
					obj.repAddData("Found all objects. Closing Page.", "", "", "");
					
					//Cancel Post Condition
					ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
					fnVerifyCancelForm(1);
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36957 Failed!", e );
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
					log.info("Execution of Function TC36957 Completed");
				}
				return obj;
			}
			
			public Reporter TC36958(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC36958 Started..");

				try {
					String testName = "TestName11";
					obj.repAddData( "Verify Add Flow Page View", "", "", "");
					//Set Corp and Office, load Flow page
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Flows",true);
					fnLoadingPageWait();
					
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp,"Add Flow button",true);
					fnLoadingPageWait();
					
					///Check view
					//Fill flow name input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowNameInput_nm,"Flow name input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowNameInput_nm)).sendKeys(testName);
					
					//Fill flow description input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm,"Flow description input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm)).sendKeys(testName);
					
					driver.findElement(By.xpath(RenowalkModules.Flow_AddFlow_FlowCarpetRemovalInput_xp)).sendKeys("0000011111000");
					
					obj.repAddData("Found all objects. Closing Page.", "", "", "");
					
					//Save flow
					ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",false);
					fnVerifyDialogBox("Add",0);
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36958 Failed!", e );
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
					log.info("Execution of Function TC----- Completed");
				}
				return obj;
			}
			
			public Reporter TC36959(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC36959 Started..");

				try {
					String testName = "TestName12";
					obj.repAddData( "Verify Add Flow Page View", "", "", "");
					//Set Corp and Office, load Flow page
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Items",true);
					fnLoadingPageWait();
					
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp,"Add Flow button",true);
					fnLoadingPageWait();
					
					///Check view
					//Fill flow name input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowNameInput_nm,"Flow name input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowNameInput_nm)).sendKeys(testName);
					
					//Fill flow description input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm,"Flow description input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm)).sendKeys(testName);
					
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FlowCarpetRemovalInput_xp,"Flow paint color input",true,true);
					driver.findElement(By.xpath(RenowalkModules.Flow_AddFlow_FlowCarpetRemovalInput_xp)).sendKeys("00000111110000");
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_CarpetRemovalLengthMsg_xp,"Carpet removal length error message",true,true);
					
					obj.repAddData("Found all objects. Closing Page.", "", "", "");
					
					//Cancel Post Condition
					ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
					fnVerifyCancelForm(1);
					
					fnLoadingPageWait();
					
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36959 Failed!", e );
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
					log.info("Execution of Function TC36959 Completed");
				}
				return obj;
			}
			
			public Reporter TC36960(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC36960 Started..");

				try {
					String testName = "TestName13";
					obj.repAddData( "Verify Add Flow Page View", "", "", "");
					//Set Corp and Office, load Flow page
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Items",true);
					fnLoadingPageWait();
					
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp,"Add Flow button",true);
					fnLoadingPageWait();
					
					///Check view
					//Fill flow name input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowNameInput_nm,"Flow name input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowNameInput_nm)).sendKeys(testName);
					
					//Fill flow description input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm,"Flow description input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm)).sendKeys(testName);
					
					//Check for flow labor rate input and message
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FlowCarpetWastePctInput_xp,"Flow waste percent input field",true,true);
					driver.findElement(By.xpath(RenowalkModules.Flow_AddFlow_FlowCarpetWastePctInput_xp)).sendKeys("123");
					
					//Save flow
					ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",false);
					fnVerifyDialogBox("Add",0);
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36960 Failed!", e );
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
					log.info("Execution of Function TC36960 Completed");
				}
				return obj;
			}
			
			public Reporter TC36961(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC36961 Started..");

				try {
					String testName = "TestName14";
					obj.repAddData( "Verify Add Flow Page View", "", "", "");
					//Set Corp and Office, load Flow page
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Items",true);
					fnLoadingPageWait();
					
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp,"Add Flow button",true);
					fnLoadingPageWait();
					
					///Check view
					//Fill flow name input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowNameInput_nm,"Flow name input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowNameInput_nm)).sendKeys(testName);
					
					//Fill flow description input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm,"Flow description input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm)).sendKeys(testName);
					
					//Check for flow labor rate input and message
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FlowCarpetWastePctInput_xp,"Flow waste percent input field",true,true);
					driver.findElement(By.xpath(RenowalkModules.Flow_AddFlow_FlowCarpetWastePctInput_xp)).sendKeys("1234");
					
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FlowCarpetWastePctLengthMsg_xp,"waste percent length error message",true,true);
					
					//Cancel Post Condition
					ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
					fnVerifyCancelForm(1);
					
					fnLoadingPageWait();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36961 Failed!", e );
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
					log.info("Execution of Function TC36961 Completed");
				}
				return obj;
			}
			
			public Reporter TC36962(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC36962 Started..");

				try {
					String testName = "TestName15xx";
					obj.repAddData( "Verify Add Flow Page View", "", "", "");
					//Set Corp and Office, load Flow page
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Items",true);
					fnLoadingPageWait();
					
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp,"Add Flow button",true);
					fnLoadingPageWait();
					
					///Check view
					//Fill flow name input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowNameInput_nm,"Flow name input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowNameInput_nm)).sendKeys(testName);
					
					//Fill flow description input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm,"Flow description input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm)).sendKeys(testName);
					
					//Check for flow Carpet labor rate input and message
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FlowCarpetLaborInput_xp,"Flow carpet labor input field",true,true);
					driver.findElement(By.xpath(RenowalkModules.Flow_AddFlow_FlowCarpetLaborInput_xp)).sendKeys("1234567890123");
					
					//Save flow
					ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",false);
					fnVerifyDialogBox("Add",0);
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36962 Failed!", e );
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
					log.info("Execution of Function TC36962 Completed");
				}
				return obj;
			}
			
			public Reporter TC36963(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC36963 Started..");

				try {
					String testName = "TestName16";
					obj.repAddData( "Verify Add Flow Page View", "", "", "");
					//Set Corp and Office, load Flow page
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Items",true);
					fnLoadingPageWait();
					
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp,"Add Flow button",true);
					fnLoadingPageWait();
					
					///Check view
					//Fill flow name input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowNameInput_nm,"Flow name input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowNameInput_nm)).sendKeys(testName);
					
					//Fill flow description input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm,"Flow description input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm)).sendKeys(testName);
					
					//Check for flow labor rate input and message
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FlowCarpetLaborInput_xp,"Flow carpet labor input field",true,true);
					driver.findElement(By.xpath(RenowalkModules.Flow_AddFlow_FlowCarpetLaborInput_xp)).sendKeys("12345678901234");
					
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_CarpetLaborLengthMsg_xp,"Removal length error message",true,true);
					
					//Cancel Post Condition
					ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
					fnVerifyCancelForm(1);
					fnLoadingPageWait();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36963 Failed!", e );
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
					log.info("Execution of Function TC36963 Completed");
				}
				return obj;
			}
			
			public Reporter TC36964(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC36964 Started..");

				try {
					String testName = "TestName17";
					obj.repAddData( "Verify Add Flow Page View", "", "", "");
					//Set Corp and Office, load Flow page
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Items",true);
					fnLoadingPageWait();
					
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp,"Add Flow button",true);
					fnLoadingPageWait();
					
					///Check view
					//Fill flow name input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowNameInput_nm,"Flow name input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowNameInput_nm)).sendKeys(testName);
					
					//Fill flow description input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm,"Flow description input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm)).sendKeys(testName);
					
					//Check for flow Carpet labor rate input and message
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_CarpetPadCoveragePerSkuInput_xp,"Carpet coverage per SKU input field",true,true);
					driver.findElement(By.xpath(RenowalkModules.Flow_AddFlow_CarpetPadCoveragePerSkuInput_xp)).sendKeys("4444");
					
					//Save flow
					ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",false);
					fnVerifyDialogBox("Add",0);
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36964 Failed!", e );
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
					log.info("Execution of Function TC36964 Completed");
				}
				return obj;
			}
			
			public Reporter TC36965(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC36963 Started..");

				try {
					String testName = "TestName18";
					obj.repAddData( "Verify Add Flow Page View", "", "", "");
					//Set Corp and Office, load Flow page
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Items",true);
					fnLoadingPageWait();
					
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp,"Add Flow button",true);
					fnLoadingPageWait();
					
					///Check view
					//Fill flow name input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowNameInput_nm,"Flow name input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowNameInput_nm)).sendKeys(testName);
					
					//Fill flow description input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm,"Flow description input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm)).sendKeys(testName);
					
					//Check for flow labor rate input and message
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_CarpetPadCoveragePerSkuInput_xp,"Carpet pad coverage per SKU input field",true,true);
					driver.findElement(By.xpath(RenowalkModules.Flow_AddFlow_CarpetPadCoveragePerSkuInput_xp)).sendKeys("55555");
					
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_CarpetPadCoveragePerSkuLengthMsg_xp,"Carpet labor length error message",true,true);
					
					//Cancel Post Condition
					ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
					fnVerifyCancelForm(1);
					fnLoadingPageWait();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36965 Failed!", e );
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
					log.info("Execution of Function TC36965 Completed");
				}
				return obj;
			}
			
			public Reporter TC36966(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC36966 Started..");

				try {
					String testName = "TestName19";
					obj.repAddData( "Verify Add Flow Page View", "", "", "");
					//Set Corp and Office, load Flow page
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Items",true);
					fnLoadingPageWait();
					
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp,"Add Flow button",true);
					fnLoadingPageWait();
					
					///Check view
					//Fill flow name input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowNameInput_nm,"Flow name input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowNameInput_nm)).sendKeys(testName);
					
					//Fill flow description input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm,"Flow description input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm)).sendKeys(testName);
					
					//Check for flow Carpet labor rate input and message
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_PaintSkuInput_xp,"Flow paint SKU field",true,true);
					driver.findElement(By.xpath(RenowalkModules.Flow_AddFlow_PaintSkuInput_xp)).sendKeys("0000011111");
					
					//Save flow
					ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",false);
					fnVerifyDialogBox("Add",0);
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36966 Failed!", e );
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
					log.info("Execution of Function TC36966 Completed");
				}
				return obj;
			}
			
			public Reporter TC36967(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC36965 Started..");

				try {
					String testName = "TestName20";
					obj.repAddData( "Verify Add Flow Page View", "", "", "");
					//Set Corp and Office, load Flow page
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Items",true);
					fnLoadingPageWait();
					
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp,"Add Flow button",true);
					fnLoadingPageWait();
					
					///Check view
					//Fill flow name input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowNameInput_nm,"Flow name input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowNameInput_nm)).sendKeys(testName);
					
					//Fill flow description input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm,"Flow description input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm)).sendKeys(testName);
					
					//Check for flow labor rate input and message
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_PaintSkuInput_xp,"Paint SKU input field",true,true);
					driver.findElement(By.xpath(RenowalkModules.Flow_AddFlow_PaintSkuInput_xp)).sendKeys("00000111110");
					
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_PaintColorSkuLengthMsg_xp,"Paint SKU length error message",true,true);
					
					//Cancel Post Condition
					ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
					fnVerifyCancelForm(1);
					fnLoadingPageWait();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36967 Failed!", e );
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
					log.info("Execution of Function TC36967 Completed");
				}
				return obj;
			}
			
			public Reporter TC36968(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC36968 Started..");

				try {
					String testName = "TestName21";
					obj.repAddData( "Verify Add Flow Page View", "", "", "");
					//Set Corp and Office, load Flow page
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Items",true);
					fnLoadingPageWait();
					
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp,"Add Flow button",true);
					fnLoadingPageWait();
					
					///Check view
					//Fill flow name input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowNameInput_nm,"Flow name input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowNameInput_nm)).sendKeys(testName);
					
					//Fill flow description input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm,"Flow description input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm)).sendKeys(testName);
					
					//Check for flow Carpet labor rate input and message
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_CarpetStoreNumberInput_xp,"Carpet Store number field",true,true);
					driver.findElement(By.xpath(RenowalkModules.Flow_AddFlow_CarpetStoreNumberInput_xp)).sendKeys("4444");
					
					//Save flow
					ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",false);
					fnVerifyDialogBox("Add",0);
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36968 Failed!", e );
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
					log.info("Execution of Function TC36968 Completed");
				}
				return obj;
			}
			
			public Reporter TC36969(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC36969 Started..");

				try {
					String testName = "TestName22";
					obj.repAddData( "Verify Add Flow Page View", "", "", "");
					//Set Corp and Office, load Flow page
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Items",true);
					fnLoadingPageWait();
					
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp,"Add Flow button",true);
					fnLoadingPageWait();
					
					///Check view
					//Fill flow name input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowNameInput_nm,"Flow name input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowNameInput_nm)).sendKeys(testName);
					
					//Fill flow description input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm,"Flow description input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm)).sendKeys(testName);
					
					//Check for flow labor rate input and message
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_CarpetStoreNumberInput_xp,"Carpet Store number input field",true,true);
					driver.findElement(By.xpath(RenowalkModules.Flow_AddFlow_CarpetStoreNumberInput_xp)).sendKeys("55555");
					
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_CarpetStoreLengthMsg_xp,"Carpet store length error message",true,true);
					
					//Cancel Post Condition
					ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
					fnVerifyCancelForm(1);
					fnLoadingPageWait();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36969 Failed!", e );
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
					log.info("Execution of Function TC36969 Completed");
				}
				return obj;
			}
			
			public Reporter TC36970(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC36970 Started..");

				try {
					String testName = "TestName23";
					obj.repAddData( "Verify Add Flow Page View", "", "", "");
					//Set Corp and Office, load Flow page
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Items",true);
					fnLoadingPageWait();
					
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp,"Add Flow button",true);
					fnLoadingPageWait();
					
					///Check view
					//Fill flow name input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowNameInput_nm,"Flow name input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowNameInput_nm)).sendKeys(testName);
					
					//Fill flow description input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm,"Flow description input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm)).sendKeys(testName);
					
					//Check for flow Carpet labor rate input and message
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_CarpetMaterialInput_xp,"Carpet Material input field",true,true);
					driver.findElement(By.xpath(RenowalkModules.Flow_AddFlow_CarpetMaterialInput_xp)).sendKeys("0000011111000");
					
					//Save flow
					ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",false);
					fnVerifyDialogBox("Add",0);
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36970 Failed!", e );
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
					log.info("Execution of Function TC36970 Completed");
				}
				return obj;
			}
			
			public Reporter TC36971(Reporter obj) throws Exception
			{
				log.info("Execution of Function TC36971 Started..");

				try {
					String testName = "TestName24";
					obj.repAddData( "Verify Add Flow Page View", "", "", "");
					//Set Corp and Office, load Flow page
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Items",true);
					fnLoadingPageWait();
					
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp,"Add Flow button",true);
					fnLoadingPageWait();
					
					///Check view
					//Fill flow name input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowNameInput_nm,"Flow name input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowNameInput_nm)).sendKeys(testName);
					
					//Fill flow description input
					fnCheckFieldDisplayByName(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm,"Flow description input field",true,true);
					driver.findElement(By.name(RenowalkModules.Flow_AddFlow_FlowDescriptionInput_nm)).sendKeys(testName);
					
					//Check for flow labor rate input and message
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_CarpetMaterialInput_xp,"Carpet material input field",true,true);
					driver.findElement(By.xpath(RenowalkModules.Flow_AddFlow_CarpetMaterialInput_xp)).sendKeys("00000111110000");
					
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_CarpetMaterialLengthMsg_xp,"Carpet material length error message",true,true);
					
					//Cancel Post Condition
					ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
					fnVerifyCancelForm(1);
					fnLoadingPageWait();
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC36971 Failed!", e );
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
					log.info("Execution of Function TC36971 Completed");
				}
				return obj;
			}
			
			public Reporter TC38549(Reporter obj) throws Exception
			{
				try {
					obj.repAddData( "Viewing the Add Flow page", "", "", "");
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Flows Link",true);
					fnLoadingPageWait();
					
	
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp, "Add Flow button",true);
					
					fnCheckFieldDisplayByXpath(objRWModules.Flow_AddFlow_SortableItemList_xp, "Sortable List Area", true, true);
					
					obj.repAddData("Found all objects. Closing Page.", "", "", "");
					
					//Cancel Post Condition
					ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC38549 Failed!", e );
				}
				return obj;
			}
			
			public Reporter TC38555(Reporter obj) throws Exception 
			{
				try {
					obj.repAddData( "Viewing the Add Flow page", "", "", "");
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Flows Link",true);
					fnLoadingPageWait();
					
	
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp, "Add Flow button",true);
					
					fnCheckFieldDisplayByXpath(objRWModules.Flow_AddFlow_GroupsSearchBox_xp, "Group Search Query Input", true, true);
					fnCheckFieldDisplayByXpath(objRWModules.Flow_AddFlow_GroupsSearchBtn_xp, "Group Search button", true, true);
					fnCheckFieldDisplayByXpath(objRWModules.Flow_AddFlow_GroupsClearBtn_xp, "Group Clear Search button", true, true);
					
					obj.repAddData("Found all objects. Closing Page.", "", "", "");
					
					//Cancel Post Condition
					ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
				}
				catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC38555 Failed!", e );
				}
				return obj;
			}
			
			public Reporter TC38561(Reporter obj) throws Exception
			{
				try {
					obj.repAddData( "Viewing the Add Flow page", "", "", "");
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Common_AllModules_ComboOfficeSelect_xp, "Office Select",false);
					ClickByXpath("//li[@id='officeOption5']","Fifth office option (Should have 0 items and 0 groups)",true);
					fnLoadingPageWait();
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Flows Link",true);
					fnLoadingPageWait();
					
	
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp, "Add Flow button",true);
					
					if (!ElementFound(RenowalkModules.Flow_AddFlow_FirstItemVisible_xp))
					{
						obj.repAddData("Expected no groups, found no groups.","","","");
					}
					obj.repAddData("Found all objects. Closing Page.", "", "", "");
					
					//Cancel Post Condition
					ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
				}
				catch (Exception e){
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC38561 Failed!", e );
				}
				return obj;
			}
			
			
			
			public Reporter TC38589(Reporter obj) throws Exception
			{
				try {
					obj.repAddData( "Viewing the Add Flow page", "", "", "");
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Flows Link",true);
					fnLoadingPageWait();
					
	
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp, "Add Flow button",true);
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_ItemList_DragAndDropInstructions_xp,"Drag and drop instructions",true,true);
					obj.repAddData("Found all objects. Closing Page.", "", "", "");
					
					//Cancel Post Condition
					ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
					
				}
				catch (Exception e){
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC38589 Failed!", e );
				}
				return obj;
			}
			
			public Reporter TC38594(Reporter obj) throws Exception
			{
				try {
					obj.repAddData( "Viewing the Add Flow page", "", "", "");
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickById("officeSelect", "Office Drop-down", false);
					ClickByXpath("//li[@id='officeOption5']","Fifth office option (Should have 0 items and 0 groups)",true);
					fnLoadingPageWait();
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Flows Link",true);
					fnLoadingPageWait();
					
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp, "Add Flow button",true);
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_NoGroupsMessage_xp,"No Items message",true,true);
					
					ClickById("officeSelect", "Office Drop-down", false);
					ClickByXpath("//li[@id='officeOption1']","First office option",true);
					fnLoadingPageWait();
					
					//Cancel Post Condition
					ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
					obj.repAddData("Found all objects. Closing Page.", "", "", "");
				}
				catch (Exception e){
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC38594 Failed!", e );
				}
				return obj;
			}
			
			public Reporter TC38603(Reporter obj) throws Exception {
				try {
					obj.repAddData( "Viewing the Add Flow page", "", "", "");
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Flows Link",true);
					fnLoadingPageWait();
					
	
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp, "Add Flow button",true);
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_SortableItemList_xp,"Draggable Flow Groups list",true,true);
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FirstItemVisible_xp,"First Item visible",true,true);
					ClickElementDragTo(RenowalkModules.Flow_AddFlow_FirstItemVisible_xp,RenowalkModules.Flow_AddFlow_SortableItemList_xp,"xpath","xpath");
					obj.repAddData("Found all objects. Closing Page.", "", "", "");
					
					//Cancel Post Condition
					ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
				} catch (Exception e){
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC38603 Failed!", e );
				}
				return obj;
			}
			
			public Reporter TC38609(Reporter obj) throws Exception {
				try {
					obj.repAddData( "Viewing the Add Flow page", "", "", "");
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Flows Link",true);
					fnLoadingPageWait();
					
	
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp, "Add Flow button",true);
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FirstItemVisible_xp,"No Items message",false,true);
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_SortableItemList_xp,"Draggable Flow Groups list",false,true);
					ClickElementDragTo(RenowalkModules.Flow_AddFlow_FirstItemVisible_xp,RenowalkModules.Flow_AddFlow_SortableItemList_xp,"xpath","xpath");
					
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FirstItemDragSpace_xp,"Item in Flow Groups list",true,true);
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FirstItemDragBedroomRadio_xp,"Bedroom Group radio button for first element in Flow Groups list",true,true);
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FirstItemDragBathroomRadio_xp,"Bathroom Group radio button for first element in Flow Groups list",true,true);
					
					obj.repAddData("Found all objects. Closing Page.", "", "", "");
					
					//Cancel Post Condition
					ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
				} catch (Exception e){
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC38609 Failed!", e );
				}
				return obj;
			}
			
			public Reporter TC38613(Reporter obj) throws Exception {
				try {
					obj.repAddData( "Viewing the Add Flow page", "", "", "");
					fnSelectCorpOffice(sCorporation, sOffice);
					ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Flows Link",true);
					fnLoadingPageWait();
					
	
					ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp, "Add Flow button",true);
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FirstItemVisible_xp,"No Items message",true,true);
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_SortableItemList_xp,"Draggable Flow Groups list",true,true);
					ClickElementDragTo(RenowalkModules.Flow_AddFlow_FirstItemVisible_xp,RenowalkModules.Flow_AddFlow_SortableItemList_xp,"xpath","xpath");
					
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_FirstItemDragSpace_xp,"First item in right column",true,true);
					fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_SearchableItemList_xp,"Draggable Flow Groups list",true,true);
					ClickElementDragTo(RenowalkModules.Flow_AddFlow_FirstItemDragSpace_xp,RenowalkModules.Flow_AddFlow_SearchableItemList_xp,"xpath","xpath");
					
					if (!ElementFound(RenowalkModules.Flow_AddFlow_FirstItemDragSpace_xp))
						{
							obj.repAddData("Successfully removed item from draggable menu", "", "", "Pass");
						}
					
				} catch (Exception e){
					e.printStackTrace();
					testCaseStatus = false;
					//bLoginFlag=false;
					obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
					log.error( "Function TC38613 Failed!", e );
				}
				return obj;
			}
			
}