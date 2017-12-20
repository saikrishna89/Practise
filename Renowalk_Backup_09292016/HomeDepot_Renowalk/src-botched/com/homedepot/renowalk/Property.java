package com.homedepot.renowalk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.ArrayUtils;
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
import com.sun.corba.se.spi.orbutil.fsm.Input;

public class Property extends TestDriver {
	RenowalkModules objRWModules = new RenowalkModules();
	RenowalkHome objRWHome = new RenowalkHome();
	AppMessages objAppMessages = new AppMessages();
	//RW-74_Property_TC001_View Property_View Property
	@SuppressWarnings("static-access")
	public Reporter TC31928(Reporter obj) throws Exception
	{
		Boolean bLoginFlag = false;	
		log.info("Execution of Function TC31928 Started..");
		

		try {
					
			obj.repAddData( "View Properties", "", "", "");
			
			ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);
			
			fnLoadingPageWait();

			HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWModules.Common_ViewModules_Table_xp, "Property");
			fnCheckSortedList(mTableData,"Last Activity",7);
			
			fnCheckDateSorting(mTableData, "Last Activity", 7, "DEFAULT");

			//ClickByXpath(RenowalkModules.Common_BtnSorting_xp, "Sorting button", true);
			//mTableData = fnGetTableData(objRWModules.Common_ViewModules_Table_xp, "Property");
			//fnLoadingPageWait();
			//fnCheckDateSorting(mTableData, "Last Activity", 7, "ASC");
			//fnCheckDateSorting(mTableData, "Last Activity", 7, "DESC");
			////////////////////Sorting Logic End////////////////////////////

		}
		
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31928 Failed!", e );
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
			
			log.info("Execution of Function TC31928 Completed");
		}
		return obj;
	} //End of function TC31928	
	

	//RW-75_Property_TC001_Add Property_Verify to see Add Property form
	@SuppressWarnings("static-access")
	public Reporter TC31951(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31951 Started..");

		try {
			obj.repAddData( "Adding the Property", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Property_ViewOffice_BtnAddProperty_xp, "Add Property button",true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputProjectName_xp,"Project Name text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputAddress_xp, "Address text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputCity_xp, "City text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputState_xp, "State text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputZipCode_xp, "ZipCode text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputCounty_xp, "County text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputMainSquareFT_xp, "Main Square Feet text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputNumberBedrooms_xp, "Number of Bedrooms text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ComboNumberBathroom_xp, "Number of Bathrooms select box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputYearBuilt_xp, "Year Built text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputComment_xp, "Year Built text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ComboWalkAssigned_xp, "Walk Assigned Select box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputGateCode_xp, "Gate Code text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputLockBox_xp, "Lock Box text box", true, true);				
			ClickByXpath(objRWModules.Property_AddProperty_BtnCancel_xp, "Cancel button",false);  //post condition
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
			log.error( "Function TC31951 Failed!", e );
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
			log.info("Execution of Function TC31951 Completed");
		}
		return obj;
	} //End of function TC31951

	
	//RW-75_Property_TC002_Add Property_Verify to see Add Property form Required fields
	@SuppressWarnings("static-access")
	public Reporter TC31952(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31952 Started..");

		try {
			obj.repAddData( "Required Fields label", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Property_ViewOffice_BtnAddProperty_xp, "Add Property button",true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputProjectNameRequired_xp,"Project Name Field required", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputAddressRequired_xp, "Address Field required", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputCityFieldRequired_xp, "City Field required", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputStateFieldRequired_xp, "State Field required", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputZipCodeFieldRequired_xp,"Project Name Field required", true, true);
					
			ClickByXpath(objRWModules.Property_AddProperty_BtnCancel_xp, "Cancel button",false);  //post condition
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
			log.error( "Function TC31952 Failed!", e );
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
			log.info("Execution of Function TC31952 Completed");
		}
		return obj;
	} //End of function TC31952

	
	//RW-75_Property_TC003_Add Property_Verify to see the prompt for required fields
	@SuppressWarnings("static-access")
	public Reporter TC31953(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31953 Started..");

		try {

			obj.repAddData( "Validating the Property Page", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Property_ViewOffice_BtnAddProperty_xp, "Add Property button",true);

			//Check for Project Name Validation
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputProjectName_xp, "Project Name text box", true, true);

			String sProjectName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputProjectName_xp)).sendKeys(sProjectName);
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputProjectName_xp)).clear();

			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ProjectNameErrorMsgRequired_xp, "Project name Error Message", true, true);

			String sProjectNameMsg = driver.findElement(By.xpath(objRWModules.Property_AddProperty_ProjectNameErrorMsgRequired_xp)).getText().toString().trim();
			if(sProjectNameMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}			

			//Check for Address field Validation
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputAddress_xp, "Address text box", true, true);

			String sAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Address").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputAddress_xp)).sendKeys(sAddress);
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputAddress_xp)).clear();

			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_AddressErrorMsgRequired_xp, "Address Error Message", true, true);

			String sAddressMsg = driver.findElement(By.xpath(objRWModules.Property_AddProperty_AddressErrorMsgRequired_xp)).getText().toString().trim();
			if(sAddressMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}			

			//Check for City field Validation
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputCity_xp, "City text box", true, true);

			String sCity = mTestPhaseData.get(TestDriver.iTC_ID).get("City").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputCity_xp)).sendKeys(sCity);
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputCity_xp)).clear();

			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_CityErrorMsgRequired_xp, "City Error Message", true, true);

			String sCityMsg = driver.findElement(By.xpath(objRWModules.Property_AddProperty_CityErrorMsgRequired_xp)).getText().toString().trim();
			if(sCityMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	

			//Check for State field Validation
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputState_xp, "State text box", true, true);

			String sState = mTestPhaseData.get(TestDriver.iTC_ID).get("City").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputState_xp)).sendKeys(sState);
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputState_xp)).clear();

			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_StateErrorMsgRequired_xp, "State Error Message", true, true);

			String sStateMsg = driver.findElement(By.xpath(objRWModules.Property_AddProperty_StateErrorMsgRequired_xp)).getText().toString().trim();
			if(sStateMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	

			//Check for ZipCode field Validation
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputZipCode_xp, "ZipCode text box", true, true);

			String sZipCode = mTestPhaseData.get(TestDriver.iTC_ID).get("City").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputZipCode_xp)).sendKeys(sZipCode);
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputZipCode_xp)).clear();

			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ZipCodeErrorMsgRequired_xp, "ZipCode Error Message", true, true);

			String sZipCodeMsg = driver.findElement(By.xpath(objRWModules.Property_AddProperty_ZipCodeErrorMsgRequired_xp)).getText().toString().trim();
			if(sZipCodeMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	


			//*This field is required
			ClickByXpath(objRWModules.Property_AddProperty_BtnCancel_xp, "Cancel button",false);  //post condition

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
			log.error( "Function TC31953 Failed!", e );
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

			log.info("Execution of Function TC31953 Completed");
		}
		return obj;
	} //End of function TC31953	

	//RW-75_Property_TC006_Add Property_Verify Number of Bathrooms dropdown values
	@SuppressWarnings("static-access")
	public Reporter TC31956(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31956 Started..");

		try {

			obj.repAddData( "Availability of Number of Bathrooms Options", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Property_ViewOffice_BtnAddProperty_xp, "Add Property button",true);

			HighlightElementByXpath(objRWModules.Common_ViewModules_ComboPageSize_xp);
			Select select = new Select(driver.findElement(By.xpath(objRWModules.Property_AddProperty_ComboNumberBathroom_xp)));
			List<WebElement> arrNumberOfBathroom = select.getOptions();
			System.out.println("Number Of Bathroom Combobox Size>>>>"+arrNumberOfBathroom.size());

			fnVerifyComboBoxValues(arrNumberOfBathroom, 1, "1");
			fnVerifyComboBoxValues(arrNumberOfBathroom, 2, "1 ½");
			fnVerifyComboBoxValues(arrNumberOfBathroom, 3, "2");
			fnVerifyComboBoxValues(arrNumberOfBathroom, 4, "2 ½");
			fnVerifyComboBoxValues(arrNumberOfBathroom, 5, "3");
			fnVerifyComboBoxValues(arrNumberOfBathroom, 6, "3 ½");
			fnVerifyComboBoxValues(arrNumberOfBathroom, 7, "4");
			fnVerifyComboBoxValues(arrNumberOfBathroom, 8, "4 ½");
			fnVerifyComboBoxValues(arrNumberOfBathroom, 9, "5");
			fnVerifyComboBoxValues(arrNumberOfBathroom, 10, "5 ½");	

			ClickByXpath(objRWModules.Property_AddProperty_BtnCancel_xp, "Cancel button",false);  //post condition
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31956 Failed!", e );
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
			log.info("Execution of Function TC31956 Completed");
		}
		return obj;
	} //End of function TC31956	

	//RW-75_Property_TC007_Add Property_Verify Assigned user dropdown
	@SuppressWarnings("static-access")
	public Reporter TC31957(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC31957 Started..");

		try {

			obj.repAddData( "Viewing the Users in User field", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Property_ViewOffice_BtnAddProperty_xp, "Add Property button",true);

			ClickByXpath(objRWModules.Property_AddProperty_ComboWalkAssigned_xp, "Walk Assigned Combo Box",true);
			fnCheckComboBoxSorting(objRWModules.Property_AddProperty_ComboWalkAssigned_xp,"Walk Assigned", "Select");

			ClickByXpath(objRWModules.Property_AddProperty_BtnCancel_xp, "Cancel button",true); 
			fnLoadingPageWait();

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31957 Failed!", e );
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
			log.info("Execution of Function TC31957 Completed");
		}
		return obj;
	} //End of function TC31957


	//RW-75_Property_TC005_Add Property_Verify Number of Rooms Numeric only
	@SuppressWarnings("static-access")
	public Reporter TC31955(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31955 Started..");

		try {

			obj.repAddData( "Verify Number of Rooms Numeric only", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Property_ViewOffice_BtnAddProperty_xp, "Add Property button",true);

			//Filling Number of Bedrooms
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputNumberBedrooms_xp, "Number Bedrooms text box", true, true);

			String sNumberBedroomsNumeric = "2";
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputNumberBedrooms_xp)).sendKeys(sNumberBedroomsNumeric);
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputNumberBedrooms_xp)).clear();

			String sNumberBedroomsNonNumeric = "AutoTest";
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputNumberBedrooms_xp)).sendKeys(sNumberBedroomsNonNumeric);

			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_NumberBedroomErrorMsgRequired_xp, "Number Of Bedrooms not Nmeric Error Message", true, true);

			String sNumberBedroomsMsg = driver.findElement(By.xpath(objRWModules.Property_AddProperty_NumberBedroomErrorMsgRequired_xp)).getText().toString().trim();
			if(sNumberBedroomsMsg.equalsIgnoreCase(AppMessages.Property_AddProperty_ErrorMsgNumberBedrooms_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+AppMessages.Property_AddProperty_ErrorMsgNumberBedrooms_msg+"' should be shown", "'"+objAppMessages.Property_AddProperty_ErrorMsgNumberBedrooms_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+AppMessages.Property_AddProperty_ErrorMsgNumberBedrooms_msg+"' should be shown","'"+ objAppMessages.Property_AddProperty_ErrorMsgNumberBedrooms_msg+"' not shown", "Fail");
			}
			ClickByXpath(objRWModules.Property_AddProperty_BtnCancel_xp, "Cancel button",false);  //post condition

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31955 Failed!", e );
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
			log.info("Execution of Function TC31955 Completed");
		}
		return obj;
	} //End of function TC31955

	//RW-75_Property_TC008_Add Property_Verify Year build can not be greater than current year
	@SuppressWarnings("static-access")
	public Reporter TC31958(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31958 Started..");

		try {

			obj.repAddData( "Verify year built must not be greater than Current Year", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Property_ViewOffice_BtnAddProperty_xp, "Add Property button",true);

			//Filling Years Built
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputYearBuilt_xp, "Years built text box", true, true);

			String sYearBuiltLesserThanCurrentYear = "2010";
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputYearBuilt_xp)).sendKeys(sYearBuiltLesserThanCurrentYear);
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputYearBuilt_xp)).clear();

			String sYearsBuiltGreaterThanCurrentYear = "2016";
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputYearBuilt_xp)).sendKeys(sYearsBuiltGreaterThanCurrentYear);

			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_notPreviousYearErrorMsgRequired_xp, "Year Greater than Current year Error Message", true, true);

			String sYearBuiltMsg = driver.findElement(By.xpath(objRWModules.Property_AddProperty_notPreviousYearErrorMsgRequired_xp)).getText().toString().trim();
			if(sYearBuiltMsg.equalsIgnoreCase(objAppMessages.Property_AddProperty_ErrorMsgYearBuilt_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Property_AddProperty_ErrorMsgYearBuilt_msg+"' should be shown", "'"+objAppMessages.Property_AddProperty_ErrorMsgYearBuilt_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Property_AddProperty_ErrorMsgYearBuilt_msg+"' should be shown","'"+ objAppMessages.Property_AddProperty_ErrorMsgYearBuilt_msg+"' not shown", "Fail");
			}
			ClickByXpath(objRWModules.Property_AddProperty_BtnCancel_xp, "Cancel button",false);  //post condition

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31958 Failed!", e );
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
			log.info("Execution of Function TC31958 Completed");
		}
		return obj;
	} //End of function TC31958

	//method for save and cancel property

	

	//RW-75_Property_TC009_Add Property_Verify clicking Save on Add property
	@SuppressWarnings("static-access")
	public Reporter TC31959(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31959 Started..");

		try {

			obj.repAddData( "Save on Add Property", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Property_ViewOffice_BtnAddProperty_xp, "Add Property button",true);

			//Check for Project Name Validation
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputProjectName_xp, "Project Name text box", true, true);
			int iRandomNum = fnRandomNum(1,10000);
			String sProjectName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();		
			SendKeyByXpath(objRWModules.Property_AddProperty_InputProjectName_xp, sProjectName+iRandomNum, "Name");

			//Filling Address field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputAddress_xp, "Address text box", true, true);
			String sAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Address").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputAddress_xp)).sendKeys(sAddress);

			//Check for City field Validation
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputCity_xp, "City text box", true, true);
			String sCity = mTestPhaseData.get(TestDriver.iTC_ID).get("City").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputCity_xp)).sendKeys(sCity);

			//Filing State Field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputState_xp, "State text box", true, true);
			String sState = mTestPhaseData.get(TestDriver.iTC_ID).get("State").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputState_xp)).sendKeys(sState);

			//Filling ZipCode field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputZipCode_xp, "ZipCode text box", true, true);
			String sZipCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Zip").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputZipCode_xp)).sendKeys(sZipCode);

			//Filling County field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputCounty_xp, "County text box", true, true);
			String sCounty = mTestPhaseData.get(TestDriver.iTC_ID).get("County").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputCounty_xp)).sendKeys(sCounty);

			//Filling main Square feet field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputMainSquareFT_xp, "Main Square feet text box", true, true);
			String sMainSquareFT = mTestPhaseData.get(TestDriver.iTC_ID).get("MainSqFt").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputMainSquareFT_xp)).sendKeys(sMainSquareFT);

			//Filling Number of Bedrooms field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputNumberBedrooms_xp, "Number of Bedrooms text box", true, true);
			String sNumberBedrooms = mTestPhaseData.get(TestDriver.iTC_ID).get("NumberBedRooms").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputNumberBedrooms_xp)).sendKeys(sNumberBedrooms);

			//Select Number of Bathrooms combo box
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ComboNumberBathroom_xp, "Number of Bathroom select box", true, true);
			Select sNumberBathrooms = new Select(driver.findElement(By.xpath(objRWModules.Property_AddProperty_ComboNumberBathroom_xp)));
			sNumberBathrooms.selectByIndex(2);

			//Filling Years Built
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputYearBuilt_xp, "Years built text box", true, true);
			String sYearsBuilt = mTestPhaseData.get(TestDriver.iTC_ID).get("YearBuilt").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputYearBuilt_xp)).sendKeys(sYearsBuilt);

			//Filling Comments
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputComment_xp, "Comments text box", true, true);
			String sComments = mTestPhaseData.get(TestDriver.iTC_ID).get("Comment").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputComment_xp)).sendKeys(sComments);

			//Select Walk Assigned
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ComboWalkAssigned_xp, "Walk Assigned select box", true, true);
			Select sWalkAssigned = new Select(driver.findElement(By.xpath(objRWModules.Property_AddProperty_ComboWalkAssigned_xp)));
			sWalkAssigned.selectByIndex(1);

			//Filling Gate Code
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputGateCode_xp, "Gate Code text box", true, true);
			String sGateCode = mTestPhaseData.get(TestDriver.iTC_ID).get("GateCode").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputGateCode_xp)).sendKeys(sGateCode);

			//Filling Lock Box
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputLockBox_xp, "Lock Box text box", true, true);
			String sLockBox = mTestPhaseData.get(TestDriver.iTC_ID).get("LockBox").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputLockBox_xp)).sendKeys(sLockBox);

			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",true); 
			fnVerifyDialogBox("Add", 0);
			obj.repAddData( "Verify Office Name in Database", "", "", "");
			//Put db code here

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
			log.error( "Function TC31959 Failed!", e );
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

			log.info("Execution of Function TC31959 Completed");
		}
		return obj;
	} //End of function TC31959
	
	//RW-75_Property_TC010_Add Property_Verify clicking Cancel on Add property
	@SuppressWarnings("static-access")
	public Reporter TC31960(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31960 Started..");

		try {

			obj.repAddData( "Cancel on Add Property", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Property_ViewOffice_BtnAddProperty_xp, "Add Property button",true);

			//Check for Project Name Validation
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputProjectName_xp, "Project Name text box", true, true);
			int iRandomNum = fnRandomNum(1,10000);
			String sProjectName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();		
			SendKeyByXpath(objRWModules.Property_AddProperty_InputProjectName_xp, sProjectName+iRandomNum, "Name");

			//Filling Address field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputAddress_xp, "Address text box", true, true);
			String sAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Address").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputAddress_xp)).sendKeys(sAddress);

			//Check for City field Validation
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputCity_xp, "City text box", true, true);
			String sCity = mTestPhaseData.get(TestDriver.iTC_ID).get("City").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputCity_xp)).sendKeys(sCity);

			//Filing State Field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputState_xp, "State text box", true, true);
			String sState = mTestPhaseData.get(TestDriver.iTC_ID).get("State").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputState_xp)).sendKeys(sState);

			//Filling ZipCode field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputZipCode_xp, "ZipCode text box", true, true);
			String sZipCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Zip").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputZipCode_xp)).sendKeys(sZipCode);

			//Filling County field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputCounty_xp, "County text box", true, true);
			String sCounty = mTestPhaseData.get(TestDriver.iTC_ID).get("County").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputCounty_xp)).sendKeys(sCounty);

			//Filling main Square feet field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputMainSquareFT_xp, "Main Square feet text box", true, true);
			String sMainSquareFT = mTestPhaseData.get(TestDriver.iTC_ID).get("MainSqFt").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputMainSquareFT_xp)).sendKeys(sMainSquareFT);

			//Filling Number of Bedrooms field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputNumberBedrooms_xp, "Number of Bedrooms text box", true, true);
			String sNumberBedrooms = mTestPhaseData.get(TestDriver.iTC_ID).get("NumberBedRooms").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputNumberBedrooms_xp)).sendKeys(sNumberBedrooms);

			//Select Number of Bathrooms combo box
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ComboNumberBathroom_xp, "Number of Bathroom select box", true, true);
			Select sNumberBathrooms = new Select(driver.findElement(By.xpath(objRWModules.Property_AddProperty_ComboNumberBathroom_xp)));
			sNumberBathrooms.selectByIndex(2);

			//Filling Years Built
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputYearBuilt_xp, "Years built text box", true, true);
			String sYearsBuilt = mTestPhaseData.get(TestDriver.iTC_ID).get("YearBuilt").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputYearBuilt_xp)).sendKeys(sYearsBuilt);

			//Filling Comments
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputComment_xp, "Comments text box", true, true);
			String sComments = mTestPhaseData.get(TestDriver.iTC_ID).get("Comment").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputComment_xp)).sendKeys(sComments);

			//Select Walk Assigned
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ComboWalkAssigned_xp, "Walk Assigned select box", true, true);
			Select sWalkAssigned = new Select(driver.findElement(By.xpath(objRWModules.Property_AddProperty_ComboWalkAssigned_xp)));
			sWalkAssigned.selectByIndex(1);

			//Filling Gate Code
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputGateCode_xp, "Gate Code text box", true, true);
			String sGateCode = mTestPhaseData.get(TestDriver.iTC_ID).get("GateCode").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputGateCode_xp)).sendKeys(sGateCode);

			//Filling Lock Box
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputLockBox_xp, "Lock Box text box", true, true);
			String sLockBox = mTestPhaseData.get(TestDriver.iTC_ID).get("LockBox").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputLockBox_xp)).sendKeys(sLockBox);

			ClickByXpath(objRWModules.Property_AddProperty_BtnCancel_xp, "Cancel button",false);  //post condition
			obj.repAddData( "Verify Office Name in Database", "", "", "");
			//Put db code here

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
			log.error( "Function TC31960 Failed!", e );
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

			log.info("Execution of Function TC31960 Completed");
		}
		return obj;
	} //End of function TC31960
	
	
	//RW-75_Property_TC011_Add Property_Verify Add Property showing on tab
	@SuppressWarnings("static-access")
	public Reporter TC31961(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31961 Started..");

		try {

			obj.repAddData( "Checking Add Properties Tab", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Property_ViewOffice_BtnAddProperty_xp, "Add Property button",true);
			ClickByXpath(objRWModules.Property_AddProperty_PropertyWalkTab_xp, "Property Walk tab", true);
			ClickByXpath(objRWModules.Property_AddProperty_PropertyBudgetTab_xp, "Budget tab", true);
			ClickByXpath(objRWModules.Property_AddProperty_PropertyProjectTools_xp, "Project tools Walk tab", true);

			ClickByXpath(objRWModules.Property_AddProperty_BtnCancel_xp, "Cancel button",false);  //post condition
			

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
			log.error( "Function TC31961 Failed!", e );
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

			log.info("Execution of Function TC31961 Completed");
		}
		return obj;
	} //End of function TC31961
	

	//RW-91_Product Tiers_TC003_Add Product Tier_Verify current product tier display
	@SuppressWarnings("static-access")
	public Reporter TC31962(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31962 Started..");

		try {

			obj.repAddData( "Viewing the Properties page", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);

			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();
			
			ClickByXpath(objRWModules.Property_ViewOffice_BtnAddProperty_xp, "Add Property button",true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_AddForm_xp, "Add Property Form", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Common_ViewModules_Table_xp, "Properties Table", true, true);

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31962 Failed!", e );
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
			log.info("Execution of Function TC31962 Completed");
		}
		return obj;
	} //End of function TC31962
	
	
	//RW-75_Property_TC014_Add Property_Required Field Project Name Validation
	@SuppressWarnings("static-access")
	public Reporter TC33412(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC33412 Started..");

		try {

			obj.repAddData( "Required Field Project Name Validation", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Property_ViewOffice_BtnAddProperty_xp, "Add Property button",true);

			//Check for Project Name Validation
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputProjectName_xp, "Project Name text box", true, true);

			String sProjectName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputProjectName_xp)).sendKeys(sProjectName);


			//Filling Address field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputAddress_xp, "Address text box", true, true);

			String sAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Address").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputAddress_xp)).sendKeys(sAddress);

			//Check for City field Validation
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputCity_xp, "City text box", true, true);

			String sCity = mTestPhaseData.get(TestDriver.iTC_ID).get("City").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputCity_xp)).sendKeys(sCity);

			//Filing State Field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputState_xp, "State text box", true, true);

			String sState = mTestPhaseData.get(TestDriver.iTC_ID).get("State").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputState_xp)).sendKeys(sState);

			//Filling ZipCode field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputZipCode_xp, "ZipCode text box", true, true);

			String sZipCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Zip").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputZipCode_xp)).sendKeys(sZipCode);

			//Filling County field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputCounty_xp, "County text box", true, true);

			String sCounty = mTestPhaseData.get(TestDriver.iTC_ID).get("County").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputCounty_xp)).sendKeys(sCounty);

			//Filling main Square feet field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputMainSquareFT_xp, "Main Square feet text box", true, true);

			String sMainSquareFT = mTestPhaseData.get(TestDriver.iTC_ID).get("MainSqFt").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputMainSquareFT_xp)).sendKeys(sMainSquareFT);

			//Filling Number of Bedrooms field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputNumberBedrooms_xp, "Number of Bedrooms text box", true, true);

			String sNumberBedrooms = mTestPhaseData.get(TestDriver.iTC_ID).get("NumberBedRooms").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputNumberBedrooms_xp)).sendKeys(sNumberBedrooms);

			//Select Number of Bathrooms combo box
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ComboNumberBathroom_xp, "Number of Bathroom select box", true, true);

			Select sNumberBathrooms = new Select(driver.findElement(By.xpath(objRWModules.Property_AddProperty_ComboNumberBathroom_xp)));
			sNumberBathrooms.selectByIndex(2);

			//Filling Years Built
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputYearBuilt_xp, "Years built text box", true, true);

			String sYearsBuilt = mTestPhaseData.get(TestDriver.iTC_ID).get("YearBuilt").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputYearBuilt_xp)).sendKeys(sYearsBuilt);

			//Filling Comments
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputComment_xp, "Comments text box", true, true);

			String sComments = mTestPhaseData.get(TestDriver.iTC_ID).get("Comment").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputComment_xp)).sendKeys(sComments);

			//Select Walk Assigned
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ComboWalkAssigned_xp, "Walk Assigned select box", true, true);

			Select sWalkAssigned = new Select(driver.findElement(By.xpath(objRWModules.Property_AddProperty_ComboWalkAssigned_xp)));
			sWalkAssigned.selectByIndex(1);

			//Filling Gate Code
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputGateCode_xp, "Gate Code text box", true, true);

			String sGateCode = mTestPhaseData.get(TestDriver.iTC_ID).get("GateCode").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputGateCode_xp)).sendKeys(sGateCode);

			//Filling Lock Box
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputLockBox_xp, "Lock Box text box", true, true);

			String sLockBox = mTestPhaseData.get(TestDriver.iTC_ID).get("LockBox").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputLockBox_xp)).sendKeys(sLockBox);

			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputProjectName_xp)).clear();

			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ProjectNameErrorMsgRequired_xp, "Project name Error Message", true, true);

			String sProjectNameMsg = driver.findElement(By.xpath(objRWModules.Property_AddProperty_ProjectNameErrorMsgRequired_xp)).getText().toString().trim();
			if(sProjectNameMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}		

			//*This field is required
			ClickByXpath(objRWModules.Property_AddProperty_BtnCancel_xp, "Cancel button",false);  //post condition

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
			log.error( "Function TC33412 Failed!", e );
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

			log.info("Execution of Function TC33412 Completed");
		}
		return obj;
	} //End of function TC33412	



	//RW-75_Property_TC015_Add Property_Required Field Address Validation
	@SuppressWarnings("static-access")
	public Reporter TC33413(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC33413 Started..");

		try {

			obj.repAddData( "Required Field Address Validation", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Property_ViewOffice_BtnAddProperty_xp, "Add Property button",true);

			//Check for Project Name Validation
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputProjectName_xp, "Project Name text box", true, true);

			String sProjectName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputProjectName_xp)).sendKeys(sProjectName);


			//Filling Address field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputAddress_xp, "Address text box", true, true);

			String sAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Address").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputAddress_xp)).sendKeys(sAddress);

			//Check for City field Validation
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputCity_xp, "City text box", true, true);

			String sCity = mTestPhaseData.get(TestDriver.iTC_ID).get("City").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputCity_xp)).sendKeys(sCity);

			//Filing State Field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputState_xp, "State text box", true, true);

			String sState = mTestPhaseData.get(TestDriver.iTC_ID).get("State").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputState_xp)).sendKeys(sState);

			//Filling ZipCode field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputZipCode_xp, "ZipCode text box", true, true);

			String sZipCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Zip").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputZipCode_xp)).sendKeys(sZipCode);

			//Filling County field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputCounty_xp, "County text box", true, true);

			String sCounty = mTestPhaseData.get(TestDriver.iTC_ID).get("County").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputCounty_xp)).sendKeys(sCounty);

			//Filling main Square feet field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputMainSquareFT_xp, "Main Square feet text box", true, true);

			String sMainSquareFT = mTestPhaseData.get(TestDriver.iTC_ID).get("MainSqFt").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputMainSquareFT_xp)).sendKeys(sMainSquareFT);

			//Filling Number of Bedrooms field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputNumberBedrooms_xp, "Number of Bedrooms text box", true, true);

			String sNumberBedrooms = mTestPhaseData.get(TestDriver.iTC_ID).get("NumberBedRooms").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputNumberBedrooms_xp)).sendKeys(sNumberBedrooms);

			//Select Number of Bathrooms combo box
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ComboNumberBathroom_xp, "Number of Bathroom select box", true, true);

			Select sNumberBathrooms = new Select(driver.findElement(By.xpath(objRWModules.Property_AddProperty_ComboNumberBathroom_xp)));
			sNumberBathrooms.selectByIndex(2);

			//Filling Years Built
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputYearBuilt_xp, "Years built text box", true, true);

			String sYearsBuilt = mTestPhaseData.get(TestDriver.iTC_ID).get("YearBuilt").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputYearBuilt_xp)).sendKeys(sYearsBuilt);

			//Filling Comments
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputComment_xp, "Comments text box", true, true);

			String sComments = mTestPhaseData.get(TestDriver.iTC_ID).get("Comment").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputComment_xp)).sendKeys(sComments);

			//Select Walk Assigned
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ComboWalkAssigned_xp, "Walk Assigned select box", true, true);

			Select sWalkAssigned = new Select(driver.findElement(By.xpath(objRWModules.Property_AddProperty_ComboWalkAssigned_xp)));
			sWalkAssigned.selectByIndex(1);

			//Filling Gate Code
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputGateCode_xp, "Gate Code text box", true, true);

			String sGateCode = mTestPhaseData.get(TestDriver.iTC_ID).get("GateCode").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputGateCode_xp)).sendKeys(sGateCode);

			//Filling Lock Box
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputLockBox_xp, "Lock Box text box", true, true);

			String sLockBox = mTestPhaseData.get(TestDriver.iTC_ID).get("LockBox").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputLockBox_xp)).sendKeys(sLockBox);

			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputAddress_xp)).clear();

			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_AddressErrorMsgRequired_xp, "Address Error Message", true, true);

			String sAddressMsg = driver.findElement(By.xpath(objRWModules.Property_AddProperty_AddressErrorMsgRequired_xp)).getText().toString().trim();
			if(sAddressMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}		

			//*This field is required
			ClickByXpath(objRWModules.Property_AddProperty_BtnCancel_xp, "Cancel button",false);  //post condition

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
			log.error( "Function TC33413 Failed!", e );
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

			log.info("Execution of Function TC33413 Completed");
		}
		return obj;
	} //End of function TC33413	


	//RW-75_Property_TC016_Add Property_Required Field City Validation
	@SuppressWarnings("static-access")
	public Reporter TC33540(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC33540 Started..");

		try {

			obj.repAddData( "Required Field City Validation", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Property_ViewOffice_BtnAddProperty_xp, "Add Property button",true);

			//Check for Project Name Validation
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputProjectName_xp, "Project Name text box", true, true);

			String sProjectName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputProjectName_xp)).sendKeys(sProjectName);


			//Filling Address field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputAddress_xp, "Address text box", true, true);

			String sAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Address").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputAddress_xp)).sendKeys(sAddress);

			//Check for City field Validation
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputCity_xp, "City text box", true, true);

			String sCity = mTestPhaseData.get(TestDriver.iTC_ID).get("City").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputCity_xp)).sendKeys(sCity);

			//Filing State Field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputState_xp, "State text box", true, true);

			String sState = mTestPhaseData.get(TestDriver.iTC_ID).get("State").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputState_xp)).sendKeys(sState);

			//Filling ZipCode field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputZipCode_xp, "ZipCode text box", true, true);

			String sZipCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Zip").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputZipCode_xp)).sendKeys(sZipCode);

			//Filling County field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputCounty_xp, "County text box", true, true);

			String sCounty = mTestPhaseData.get(TestDriver.iTC_ID).get("County").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputCounty_xp)).sendKeys(sCounty);

			//Filling main Square feet field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputMainSquareFT_xp, "Main Square feet text box", true, true);

			String sMainSquareFT = mTestPhaseData.get(TestDriver.iTC_ID).get("MainSqFt").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputMainSquareFT_xp)).sendKeys(sMainSquareFT);

			//Filling Number of Bedrooms field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputNumberBedrooms_xp, "Number of Bedrooms text box", true, true);

			String sNumberBedrooms = mTestPhaseData.get(TestDriver.iTC_ID).get("NumberBedRooms").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputNumberBedrooms_xp)).sendKeys(sNumberBedrooms);

			//Select Number of Bathrooms combo box
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ComboNumberBathroom_xp, "Number of Bathroom select box", true, true);

			Select sNumberBathrooms = new Select(driver.findElement(By.xpath(objRWModules.Property_AddProperty_ComboNumberBathroom_xp)));
			sNumberBathrooms.selectByIndex(2);

			//Filling Years Built
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputYearBuilt_xp, "Years built text box", true, true);

			String sYearsBuilt = mTestPhaseData.get(TestDriver.iTC_ID).get("YearBuilt").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputYearBuilt_xp)).sendKeys(sYearsBuilt);

			//Filling Comments
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputComment_xp, "Comments text box", true, true);

			String sComments = mTestPhaseData.get(TestDriver.iTC_ID).get("Comment").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputComment_xp)).sendKeys(sComments);

			//Select Walk Assigned
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ComboWalkAssigned_xp, "Walk Assigned select box", true, true);

			Select sWalkAssigned = new Select(driver.findElement(By.xpath(objRWModules.Property_AddProperty_ComboWalkAssigned_xp)));
			sWalkAssigned.selectByIndex(1);

			//Filling Gate Code
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputGateCode_xp, "Gate Code text box", true, true);

			String sGateCode = mTestPhaseData.get(TestDriver.iTC_ID).get("GateCode").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputGateCode_xp)).sendKeys(sGateCode);

			//Filling Lock Box
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputLockBox_xp, "Lock Box text box", true, true);

			String sLockBox = mTestPhaseData.get(TestDriver.iTC_ID).get("LockBox").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputLockBox_xp)).sendKeys(sLockBox);

			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputCity_xp)).clear();

			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_CityErrorMsgRequired_xp, "City Error Message", true, true);

			String sCityMsg = driver.findElement(By.xpath(objRWModules.Property_AddProperty_CityErrorMsgRequired_xp)).getText().toString().trim();
			if(sCityMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}		

			//*This field is required
			ClickByXpath(objRWModules.Property_AddProperty_BtnCancel_xp, "Cancel button",false);  //post condition

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
			log.error( "Function TC33540 Failed!", e );
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

			log.info("Execution of Function TC33540 Completed");
		}
		return obj;
	} //End of function TC33540


	//RW-75_Property_TC017_Add Property_Required Field State Validation
	@SuppressWarnings("static-access")
	public Reporter TC33541(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC33541 Started..");

		try {

			obj.repAddData( "Required Field State Validation", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Property_ViewOffice_BtnAddProperty_xp, "Add Property button",true);

			//Check for Project Name Validation
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputProjectName_xp, "Project Name text box", true, true);

			String sProjectName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputProjectName_xp)).sendKeys(sProjectName);


			//Filling Address field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputAddress_xp, "Address text box", true, true);

			String sAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Address").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputAddress_xp)).sendKeys(sAddress);

			//Check for City field Validation
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputCity_xp, "City text box", true, true);

			String sCity = mTestPhaseData.get(TestDriver.iTC_ID).get("City").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputCity_xp)).sendKeys(sCity);

			//Filing State Field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputState_xp, "State text box", true, true);

			String sState = mTestPhaseData.get(TestDriver.iTC_ID).get("State").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputState_xp)).sendKeys(sState);

			//Filling ZipCode field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputZipCode_xp, "ZipCode text box", true, true);

			String sZipCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Zip").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputZipCode_xp)).sendKeys(sZipCode);

			//Filling County field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputCounty_xp, "County text box", true, true);

			String sCounty = mTestPhaseData.get(TestDriver.iTC_ID).get("County").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputCounty_xp)).sendKeys(sCounty);

			//Filling main Square feet field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputMainSquareFT_xp, "Main Square feet text box", true, true);

			String sMainSquareFT = mTestPhaseData.get(TestDriver.iTC_ID).get("MainSqFt").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputMainSquareFT_xp)).sendKeys(sMainSquareFT);

			//Filling Number of Bedrooms field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputNumberBedrooms_xp, "Number of Bedrooms text box", true, true);

			String sNumberBedrooms = mTestPhaseData.get(TestDriver.iTC_ID).get("NumberBedRooms").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputNumberBedrooms_xp)).sendKeys(sNumberBedrooms);

			//Select Number of Bathrooms combo box
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ComboNumberBathroom_xp, "Number of Bathroom select box", true, true);

			Select sNumberBathrooms = new Select(driver.findElement(By.xpath(objRWModules.Property_AddProperty_ComboNumberBathroom_xp)));
			sNumberBathrooms.selectByIndex(2);

			//Filling Years Built
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputYearBuilt_xp, "Years built text box", true, true);

			String sYearsBuilt = mTestPhaseData.get(TestDriver.iTC_ID).get("YearBuilt").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputYearBuilt_xp)).sendKeys(sYearsBuilt);

			//Filling Comments
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputComment_xp, "Comments text box", true, true);

			String sComments = mTestPhaseData.get(TestDriver.iTC_ID).get("Comment").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputComment_xp)).sendKeys(sComments);

			//Select Walk Assigned
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ComboWalkAssigned_xp, "Walk Assigned select box", true, true);

			Select sWalkAssigned = new Select(driver.findElement(By.xpath(objRWModules.Property_AddProperty_ComboWalkAssigned_xp)));
			sWalkAssigned.selectByIndex(1);

			//Filling Gate Code
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputGateCode_xp, "Gate Code text box", true, true);

			String sGateCode = mTestPhaseData.get(TestDriver.iTC_ID).get("GateCode").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputGateCode_xp)).sendKeys(sGateCode);

			//Filling Lock Box
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputLockBox_xp, "Lock Box text box", true, true);

			String sLockBox = mTestPhaseData.get(TestDriver.iTC_ID).get("LockBox").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputLockBox_xp)).sendKeys(sLockBox);

			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputState_xp)).clear();

			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_StateErrorMsgRequired_xp, "State Error Message", true, true);

			String sStateMsg = driver.findElement(By.xpath(objRWModules.Property_AddProperty_StateErrorMsgRequired_xp)).getText().toString().trim();
			if(sStateMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}		

			//*This field is required
			ClickByXpath(objRWModules.Property_AddProperty_BtnCancel_xp, "Cancel button",false);  //post condition

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
			log.error( "Function TC33541 Failed!", e );
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

			log.info("Execution of Function TC33541 Completed");
		}
		return obj;
	} //End of function TC33541

	//RW-75_Property_TC018_Add Property_Required Field ZipCode Validation
	@SuppressWarnings("static-access")
	public Reporter TC33542(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC33542 Started..");

		try {

			obj.repAddData( "Required Field ZipCode Validation", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Property_ViewOffice_BtnAddProperty_xp, "Add Property button",true);

			//Check for Project Name Validation
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputProjectName_xp, "Project Name text box", true, true);

			String sProjectName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputProjectName_xp)).sendKeys(sProjectName);


			//Filling Address field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputAddress_xp, "Address text box", true, true);

			String sAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Address").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputAddress_xp)).sendKeys(sAddress);

			//Check for City field Validation
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputCity_xp, "City text box", true, true);

			String sCity = mTestPhaseData.get(TestDriver.iTC_ID).get("City").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputCity_xp)).sendKeys(sCity);

			//Filing State Field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputState_xp, "State text box", true, true);

			String sState = mTestPhaseData.get(TestDriver.iTC_ID).get("State").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputState_xp)).sendKeys(sState);

			//Filling ZipCode field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputZipCode_xp, "ZipCode text box", true, true);

			String sZipCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Zip").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputZipCode_xp)).sendKeys(sZipCode);

			//Filling County field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputCounty_xp, "County text box", true, true);

			String sCounty = mTestPhaseData.get(TestDriver.iTC_ID).get("County").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputCounty_xp)).sendKeys(sCounty);

			//Filling main Square feet field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputMainSquareFT_xp, "Main Square feet text box", true, true);

			String sMainSquareFT = mTestPhaseData.get(TestDriver.iTC_ID).get("MainSqFt").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputMainSquareFT_xp)).sendKeys(sMainSquareFT);

			//Filling Number of Bedrooms field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputNumberBedrooms_xp, "Number of Bedrooms text box", true, true);

			String sNumberBedrooms = mTestPhaseData.get(TestDriver.iTC_ID).get("NumberBedRooms").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputNumberBedrooms_xp)).sendKeys(sNumberBedrooms);

			//Select Number of Bathrooms combo box
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ComboNumberBathroom_xp, "Number of Bathroom select box", true, true);

			Select sNumberBathrooms = new Select(driver.findElement(By.xpath(objRWModules.Property_AddProperty_ComboNumberBathroom_xp)));
			sNumberBathrooms.selectByIndex(2);

			//Filling Years Built
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputYearBuilt_xp, "Years built text box", true, true);

			String sYearsBuilt = mTestPhaseData.get(TestDriver.iTC_ID).get("YearBuilt").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputYearBuilt_xp)).sendKeys(sYearsBuilt);

			//Filling Comments
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputComment_xp, "Comments text box", true, true);

			String sComments = mTestPhaseData.get(TestDriver.iTC_ID).get("Comment").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputComment_xp)).sendKeys(sComments);

			//Select Walk Assigned
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ComboWalkAssigned_xp, "Walk Assigned select box", true, true);

			Select sWalkAssigned = new Select(driver.findElement(By.xpath(objRWModules.Property_AddProperty_ComboWalkAssigned_xp)));
			sWalkAssigned.selectByIndex(1);

			//Filling Gate Code
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputGateCode_xp, "Gate Code text box", true, true);

			String sGateCode = mTestPhaseData.get(TestDriver.iTC_ID).get("GateCode").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputGateCode_xp)).sendKeys(sGateCode);

			//Filling Lock Box
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputLockBox_xp, "Lock Box text box", true, true);

			String sLockBox = mTestPhaseData.get(TestDriver.iTC_ID).get("LockBox").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputLockBox_xp)).sendKeys(sLockBox);

			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputZipCode_xp)).clear();

			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ZipCodeErrorMsgRequired_xp, "ZipCode Error Message", true, true);

			String sZipCodeMsg = driver.findElement(By.xpath(objRWModules.Property_AddProperty_ZipCodeErrorMsgRequired_xp)).getText().toString().trim();
			if(sZipCodeMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}		

			//*This field is required
			ClickByXpath(objRWModules.Property_AddProperty_BtnCancel_xp, "Cancel button",false);  //post condition

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
			log.error( "Function TC33542 Failed!", e );
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

			log.info("Execution of Function TC33542 Completed");
		}
		return obj;
	} //End of function TC33542


	//RW-75_Property_TC019_Add Property_Required Field Address and City Validation
	@SuppressWarnings("static-access")
	public Reporter TC33543(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC33543 Started..");

		try {

			obj.repAddData( "Required Field Address and City Validation", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Property_ViewOffice_BtnAddProperty_xp, "Add Property button",true);

			//Check for Project Name Validation
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputProjectName_xp, "Project Name text box", true, true);

			String sProjectName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputProjectName_xp)).sendKeys(sProjectName);


			//Filling Address field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputAddress_xp, "Address text box", true, true);

			String sAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Address").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputAddress_xp)).sendKeys(sAddress);

			//Check for City field Validation
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputCity_xp, "City text box", true, true);

			String sCity = mTestPhaseData.get(TestDriver.iTC_ID).get("City").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputCity_xp)).sendKeys(sCity);

			//Filing State Field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputState_xp, "State text box", true, true);

			String sState = mTestPhaseData.get(TestDriver.iTC_ID).get("State").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputState_xp)).sendKeys(sState);

			//Filling ZipCode field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputZipCode_xp, "ZipCode text box", true, true);

			String sZipCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Zip").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputZipCode_xp)).sendKeys(sZipCode);

			//Filling County field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputCounty_xp, "County text box", true, true);

			String sCounty = mTestPhaseData.get(TestDriver.iTC_ID).get("County").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputCounty_xp)).sendKeys(sCounty);

			//Filling main Square feet field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputMainSquareFT_xp, "Main Square feet text box", true, true);

			String sMainSquareFT = mTestPhaseData.get(TestDriver.iTC_ID).get("MainSqFt").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputMainSquareFT_xp)).sendKeys(sMainSquareFT);

			//Filling Number of Bedrooms field
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputNumberBedrooms_xp, "Number of Bedrooms text box", true, true);

			String sNumberBedrooms = mTestPhaseData.get(TestDriver.iTC_ID).get("NumberBedRooms").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputNumberBedrooms_xp)).sendKeys(sNumberBedrooms);

			//Select Number of Bathrooms combo box
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ComboNumberBathroom_xp, "Number of Bathroom select box", true, true);

			Select sNumberBathrooms = new Select(driver.findElement(By.xpath(objRWModules.Property_AddProperty_ComboNumberBathroom_xp)));
			sNumberBathrooms.selectByIndex(2);

			//Filling Years Built
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputYearBuilt_xp, "Years built text box", true, true);

			String sYearsBuilt = mTestPhaseData.get(TestDriver.iTC_ID).get("YearBuilt").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputYearBuilt_xp)).sendKeys(sYearsBuilt);

			//Filling Comments
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputComment_xp, "Comments text box", true, true);

			String sComments = mTestPhaseData.get(TestDriver.iTC_ID).get("Comment").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputComment_xp)).sendKeys(sComments);

			//Select Walk Assigned
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ComboWalkAssigned_xp, "Walk Assigned select box", true, true);

			Select sWalkAssigned = new Select(driver.findElement(By.xpath(objRWModules.Property_AddProperty_ComboWalkAssigned_xp)));
			sWalkAssigned.selectByIndex(1);

			//Filling Gate Code
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputGateCode_xp, "Gate Code text box", true, true);

			String sGateCode = mTestPhaseData.get(TestDriver.iTC_ID).get("GateCode").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputGateCode_xp)).sendKeys(sGateCode);

			//Filling Lock Box
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputLockBox_xp, "Lock Box text box", true, true);

			String sLockBox = mTestPhaseData.get(TestDriver.iTC_ID).get("LockBox").toString().trim();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputLockBox_xp)).sendKeys(sLockBox);

			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputAddress_xp)).clear();
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputCity_xp)).clear();

			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_AddressErrorMsgRequired_xp, "Address Error Message", true, true);

			String sAddressMsg = driver.findElement(By.xpath(objRWModules.Property_AddProperty_AddressErrorMsgRequired_xp)).getText().toString().trim();
			if(sAddressMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}		

			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_CityErrorMsgRequired_xp, "City Error Message", true, true);

			String sCityMsg = driver.findElement(By.xpath(objRWModules.Property_AddProperty_CityErrorMsgRequired_xp)).getText().toString().trim();
			if(sCityMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}		

			//*This field is required
			ClickByXpath(objRWModules.Property_AddProperty_BtnCancel_xp, "Cancel button",false);  //post condition

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
			log.error( "Function TC33543 Failed!", e );
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

			log.info("Execution of Function TC33543 Completed");
		}
		return obj;
	} //End of function TC33543

	public Reporter TC31964(Reporter obj) throws Exception {
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31964 Started..");

		try {

			
			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();
			
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_SearchProperty_SecondProjectName_xp, "Project Name of Second Property shown", true, true);
			String sSearch = driver.findElement(By.xpath(RenowalkModules.Property_SearchProperty_SecondProjectName_xp)).getText();
			
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_SearchProperty_PropertySearchInput_xp, "Search input", true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_SearchProperty_PropertySearchButton_xp, "Search Button", true, true);
			
			driver.findElement(By.xpath(RenowalkModules.Property_SearchProperty_PropertySearchInput_xp)).sendKeys(sSearch);
			ClickByXpath(RenowalkModules.Property_SearchProperty_PropertySearchButton_xp,"Search button",true);
			
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_SearchProperty_FirstProjectName_xp, "Project Name of First Property shown", true, true);
			if ((driver.findElement(By.xpath(RenowalkModules.Property_SearchProperty_FirstProjectName_xp)).getText()).equals(sSearch)) {
				obj.repAddData("Checking search result for matching name", "First element's project name should match searched project name", "First element's project name matched search input", "Pass");
			}
			else {
				obj.repAddData("Checking search result for matching name", "First element's project name should match searched project name", "First element's project name did not match search input", "Fail");
			}
			
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
			log.error( "Function TC31964 Failed!", e );
		}
		return obj;
	}
	
	public Reporter TC31967(Reporter obj) throws Exception {
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31967 Started..");

		try {

			
			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();
			
			String[] headers = new String[] {"Status","Project Name","Address","City","County ","Assigned User","Last Activity "};
			List<WebElement> eleTable = driver.findElements(By.xpath("th"));
			String s;
			for (WebElement we : eleTable) {
				s = we.getText();
				for (String x : headers) {
					if (s.equals(x)) {
						ArrayUtils.removeElement(headers, x);
					}
				}
			}
			if (ArrayUtils.getLength(headers) != 0 ) {
				obj.repAddData("Checked for all elements present", "All elements should be present as Columns", "All elements were not present", "Fail");
			} else {
				obj.repAddData("Checked for all elements present", "All elements should be present as Columns", "All elements were accounted for", "Pass");
			}
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
			log.error( "Function TC31967 Failed!", e );
		}
		return obj;
	}
	
	public Reporter TC31969(Reporter obj) throws Exception {
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31969 Started..");

		try {

			
			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();
			
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_SearchProperty_PropertySearchInput_xp, "Search input", true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_SearchProperty_PropertySearchButton_xp, "Search Button", true, true);
			
			String sSearch = fnGenerateStr(8);
			driver.findElement(By.xpath(RenowalkModules.Property_SearchProperty_PropertySearchInput_xp)).sendKeys(sSearch);
			ClickByXpath(RenowalkModules.Property_SearchProperty_PropertySearchButton_xp,"Search button",true);
			if (driver.findElement(By.xpath(RenowalkModules.Property_SearchProperty_PropertySearchInput_xp)).getText().equals(sSearch)) {
				obj.repAddData("Checking search field after search", "Search field should reflect previous input", "Search still shows input value", "Pass");
			}
			else {
				obj.repAddData("Checking search field after search", "Search field should reflect previous input", "Search does not show input value", "Fail");
			}
			
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
			log.error( "Function TC31969 Failed!", e );
		}
		return obj;
	}
	
	public Reporter TC31970(Reporter obj) throws Exception {
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31970 Started..");

		try {

			
			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();
			
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_ViewOffice_BtnAddProperty_xp, "Add Property button", true, true);
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
			log.error( "Function TC31970 Failed!", e );
		}
		return obj;
	}
	
	public Reporter TC31971(Reporter obj) throws Exception {
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31971 Started..");

		try {

			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();
			
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_SearchProperty_PropertySearchInput_xp, "Property Search Button", true, true);
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
			log.error( "Function TC31971 Failed!", e );
		}
		return obj;
	}
	
	public Reporter TC31972(Reporter obj) throws Exception {
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31972 Started..");

		try {

			
			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();
			
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_SearchProperty_BtnDeleteSelected_xp, "Bulk Delete Button", true, true);
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
			log.error( "Function TC31972 Failed!", e );
		}
		return obj;
	}
	
	public Reporter TC31973(Reporter obj) throws Exception {
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31973 Started..");

		try {

			
			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();
			
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_SearchProperty_BtnDeleteSelected_xp, "Bulk Delete Button", true, true);
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
			log.error( "Function TC31973 Failed!", e );
		}
		return obj;
	}
	
	public Reporter TC31974(Reporter obj) throws Exception {
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31974 Started..");

		try {

			
			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();
			
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_SearchProperty_FirstEditButton_xp, "Individual Edit Button", true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_SearchProperty_FirstDeleteButton_xp, "Individual Delete Button", true, true);
			
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
			log.error( "Function TC31974 Failed!", e );
		}
		return obj;
	}
	public Reporter TC31975(Reporter obj) throws Exception {
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31975 Started..");

		try {

			
			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();
			
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_SearchProperty_CountySort_xp, "County Sort Button", true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_SearchProperty_LastActivitySort_xp, "Last Activity Sort Button", true, true);
			
			
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
			log.error( "Function TC31975 Failed!", e );
		}
		return obj;
	}
	
	public Reporter TC31979(Reporter obj) throws Exception {
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31979 Started..");

		try {

			
			fnSelectCorpOffice(sCorporation, sOffice);

			ClickByXpath("//li[@id='officeOption5']","Fifth office option (Should have 0 properties)",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();
			
			
			
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_SearchProperty_NoResultMsg_xp, "No results message", true, true);
			
			ClickByXpath("//li[@id='officeOption1']","First office option",true);
			fnLoadingPageWait();
			
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
			log.error( "Function TC31979 Failed!", e );
		}
		return obj;
	}
	
	public Reporter TC31981(Reporter obj) throws Exception {
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31981 Started..");

		try {

			
			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			HighlightElementByXpath(objRWModules.Common_ViewModules_ComboPageSize_xp);
			Select select = new Select(driver.findElement(By.xpath(objRWModules.Common_ViewModules_ComboPageSize_xp)));
			List<WebElement> arrPageSize = select.getOptions();
			System.out.println("Page Combobox Size>>>>"+arrPageSize.size());
			
			fnVerifyComboBoxValues(arrPageSize, 0, "10 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 1, "20 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 2, "VIEW ALL");
			
			
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
			log.error( "Function TC31981 Failed!", e );
		}
		return obj;
	}
	
	public Reporter TC31983(Reporter obj) throws Exception {
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31983 Started..");

		try {

			
			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();
			
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_SearchProperty_SecondProjectName_xp, "Project Name of Second Property shown", true, true);
			String sFirst = driver.findElement(By.xpath(RenowalkModules.Property_SearchProperty_FirstProjectName_xp)).getText();
			String sSecond = driver.findElement(By.xpath(RenowalkModules.Property_SearchProperty_SecondProjectName_xp)).getText();
			
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_SearchProperty_PropertySearchInput_xp, "Search input", true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_SearchProperty_PropertySearchButton_xp, "Search Button", true, true);
			
			driver.findElement(By.xpath(RenowalkModules.Property_SearchProperty_PropertySearchInput_xp)).sendKeys(sSecond);
			ClickByXpath(RenowalkModules.Property_SearchProperty_PropertySearchButton_xp,"Search button",true);
			
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_SearchProperty_FirstProjectName_xp, "Project Name of First Property shown", true, true);
			if ((driver.findElement(By.xpath(RenowalkModules.Property_SearchProperty_FirstProjectName_xp)).getText()).equals(sSecond)) {
				obj.repAddData("Checking search result for matching name", "First element's project name should match searched project name", "First element's project name matched search input", "Pass");
			}
			else {
				obj.repAddData("Checking search result for matching name", "First element's project name should match searched project name", "First element's project name did not match search input", "Fail");
			}
			
			driver.findElement(By.xpath(RenowalkModules.Property_SearchProperty_PropertySearchInput_xp)).clear();
			ClickByXpath(RenowalkModules.Property_SearchProperty_PropertySearchButton_xp,"Search button",true);
			
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_SearchProperty_FirstProjectName_xp, "Project Name of First Property shown", true, true);
			if ((driver.findElement(By.xpath(RenowalkModules.Property_SearchProperty_FirstProjectName_xp)).getText()).equals(sFirst)) {
				obj.repAddData("Verify fields have reset after clearing search", "First project name should be the same as before the test began", "First project name confirmed in correct position", "Pass");
			} else {
				obj.repAddData("Verify fields have reset after clearing search", "First project name should be the same as before the test began", "First project name confirmed in incorrect position", "Fail");
			}
			
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
			log.error( "Function TC31983 Failed!", e );
		}
		return obj;
	}
	
	public Reporter TC36889(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC36889 Started..");

		try {
			obj.repAddData( "Editing the Property", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Property_SearchProperty_FirstEditButton_xp, "Edit First Property button",true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputProjectName_xp,"Project Name text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputAddress_xp, "Address text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputCity_xp, "City text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputState_xp, "State text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputZipCode_xp, "ZipCode text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputCounty_xp, "County text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputMainSquareFT_xp, "Main Square Feet text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputNumberBedrooms_xp, "Number of Bedrooms text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ComboNumberBathroom_xp, "Number of Bathrooms select box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputYearBuilt_xp, "Year Built text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputComment_xp, "Year Built text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ComboWalkAssigned_xp, "Walk Assigned Select box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputGateCode_xp, "Gate Code text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputLockBox_xp, "Lock Box text box", true, true);				
			ClickByXpath(objRWModules.Property_AddProperty_BtnCancel_xp, "Cancel button",false);  //post condition
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
			log.error( "Function TC36889 Failed!", e );
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
			log.info("Execution of Function TC36889 Completed");
		}
		return obj;
	} //End of function TC36889
	
	public Reporter TC36890(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC36890 Started..");

		try {
			obj.repAddData( "Required Fields label", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Property_SearchProperty_FirstEditButton_xp, "Edit First Property button",true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputProjectNameRequired_xp,"Project Name Field required", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputAddressRequired_xp, "Address Field required", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputCityFieldRequired_xp, "City Field required", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputStateFieldRequired_xp, "State Field required", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputZipCodeFieldRequired_xp,"Project Name Field required", true, true);
					
			ClickByXpath(objRWModules.Property_AddProperty_BtnCancel_xp, "Cancel button",false);  //post condition
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
			log.error( "Function TC36890 Failed!", e );
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
			log.info("Execution of Function TC36890 Completed");
		}
		return obj;
	}
	
	public Reporter TC36892(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC36892 Started..");

		try {

			obj.repAddData( "Validating the Property Page", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Property_SearchProperty_FirstEditButton_xp, "Edit First Property button",true);

			//Check for Project Name Validation
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputProjectName_xp, "Project Name text box", true, true);

			String sTestString = "Test";
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputProjectName_xp)).sendKeys(sTestString);
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputProjectName_xp)).clear();

			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ProjectNameErrorMsgRequired_xp, "Project name Error Message", true, true);

			String sProjectNameMsg = driver.findElement(By.xpath(objRWModules.Property_AddProperty_ProjectNameErrorMsgRequired_xp)).getText().toString().trim();
			if(sProjectNameMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}			

			//Check for Address field Validation
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputAddress_xp, "Address text box", true, true);

			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputAddress_xp)).sendKeys(sTestString);
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputAddress_xp)).clear();

			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_AddressErrorMsgRequired_xp, "Address Error Message", true, true);

			String sAddressMsg = driver.findElement(By.xpath(objRWModules.Property_AddProperty_AddressErrorMsgRequired_xp)).getText().toString().trim();
			if(sAddressMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}			

			//Check for City field Validation
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputCity_xp, "City text box", true, true);

			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputCity_xp)).sendKeys(sTestString);
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputCity_xp)).clear();

			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_CityErrorMsgRequired_xp, "City Error Message", true, true);

			String sCityMsg = driver.findElement(By.xpath(objRWModules.Property_AddProperty_CityErrorMsgRequired_xp)).getText().toString().trim();
			if(sCityMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	

			//Check for State field Validation
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputState_xp, "State text box", true, true);

			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputState_xp)).sendKeys(sTestString);
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputState_xp)).clear();

			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_StateErrorMsgRequired_xp, "State Error Message", true, true);

			String sStateMsg = driver.findElement(By.xpath(objRWModules.Property_AddProperty_StateErrorMsgRequired_xp)).getText().toString().trim();
			if(sStateMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	

			//Check for ZipCode field Validation
			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_InputZipCode_xp, "ZipCode text box", true, true);
			
			String sTestInt = "12345";
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputZipCode_xp)).sendKeys(sTestInt);
			driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputZipCode_xp)).clear();

			fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ZipCodeErrorMsgRequired_xp, "ZipCode Error Message", true, true);

			String sZipCodeMsg = driver.findElement(By.xpath(objRWModules.Property_AddProperty_ZipCodeErrorMsgRequired_xp)).getText().toString().trim();
			if(sZipCodeMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	


			//*This field is required
			ClickByXpath(objRWModules.Property_AddProperty_BtnCancel_xp, "Cancel button",false);  //post condition

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
			log.error( "Function TC36892 Failed!", e );
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

			log.info("Execution of Function TC36892 Completed");
		}
		return obj;
	}
	
	public Reporter TC36894(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC36894 Started..");

		try {
			obj.repAddData( "Edit Property update button", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Property_SearchProperty_FirstEditButton_xp, "Edit First Property button",true);
			driver.findElement(By.xpath(RenowalkModules.Property_AddProperty_InputMainSquareFT_xp)).sendKeys("1");
			fnCheckFieldDisplayByXpath(objRWModules.Property_EditProperty_BtnUpdateProperty_xp,"Update property button", true, true);
			fnVerifyDialogBox("Update",0);
			
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
			log.error( "Function TC36894 Failed!", e );
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
			log.info("Execution of Function TC36894 Completed");
		}
		return obj;
	}
	
	public Reporter TC41924(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC41924 Started..");

		try {
			obj.repAddData( "Property Walk comment visibility check", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Property_SearchProperty_FirstEditButton_xp, "Edit First Property button",true);
			ClickByXpath(objRWModules.Property_PropertyWalk_PropertWalkTab_xp, "Property Walk tab",true);
			//Handle new properties Add New Walk button
			if (ElementFound(RenowalkModules.Property_PropertyWalk_AddNewWalkButton_xp)) {
				ClickByXpath(RenowalkModules.Property_PropertyWalk_AddNewWalkButton_xp,"Add New Walk Button",true);
			}
			ClickByXpath(objRWModules.Property_PropertyWalk_FirstGroupInList_xp, "First Group",true);
			ClickByXpath(objRWModules.Property_PropertyWalk_FirstItemCommentField_xp,"Comment Section",true);
			
			fnCheckFieldDisplayByXpath(objRWModules.Property_PropertyWalk_CommentPopupBox_xp,"Comment Popup Appears",true,true);
			
			
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
			log.error( "Function TC41924 Failed!", e );
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
			log.info("Execution of Function TC41924 Completed");
		}
		return obj;
	}
	
	public Reporter TC41925(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC41925 Started..");

		try {
			obj.repAddData( "Property Walk add comment dialog check", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Property_SearchProperty_FirstEditButton_xp, "Edit First Property button",true);
			ClickByXpath(objRWModules.Property_PropertyWalk_PropertWalkTab_xp, "Property Walk tab",true);
			if (ElementFound(RenowalkModules.Property_PropertyWalk_AddNewWalkButton_xp)) {
				ClickByXpath(RenowalkModules.Property_PropertyWalk_AddNewWalkButton_xp,"Add New Walk Button",true);
			}
			ClickByXpath(objRWModules.Property_PropertyWalk_FirstGroupInList_xp, "First Group",true);
			ClickByXpath(objRWModules.Property_PropertyWalk_FirstItemCommentField_xp,"Comment Section",true);
			
			fnCheckFieldDisplayByXpath(objRWModules.Property_PropertyWalk_CommentPopupBox_xp,"Comment Popup Appears",true,true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_PropertyWalk_AddCommentFromPopup_xp,"Add Comment Visible",true,true);
			
			
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
			log.error( "Function TC41925 Failed!", e );
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
			log.info("Execution of Function TC41925 Completed");
		}
		return obj;
	}
	
	public Reporter TC41927(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC41927 Started..");

		try {
			obj.repAddData( "Property Walk add comment text change", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Property_SearchProperty_FirstEditButton_xp, "Edit First Property button",true);
			ClickByXpath(objRWModules.Property_PropertyWalk_PropertWalkTab_xp, "Property Walk tab",true);
			if (ElementFound(RenowalkModules.Property_PropertyWalk_AddNewWalkButton_xp)) {
				ClickByXpath(RenowalkModules.Property_PropertyWalk_AddNewWalkButton_xp,"Add New Walk Button",true);
			}
			ClickByXpath(objRWModules.Property_PropertyWalk_FirstGroupInList_xp, "First Group",true);
			ClickByXpath(objRWModules.Property_PropertyWalk_FirstItemCommentField_xp,"Comment Section",true);
			
			fnCheckFieldDisplayByXpath(objRWModules.Property_PropertyWalk_CommentPopupBox_xp,"Comment Popup Appears",true,true);
			fnCheckFieldDisplayByXpath(objRWModules.Property_PropertyWalk_AddCommentFromPopup_xp,"Add Comment Button",true,true);
			ClickByXpath(objRWModules.Property_PropertyWalk_AddCommentFromPopup_xp,"Add Comment Button",true);
			
			if (driver.findElement(By.xpath(objRWModules.Property_PropertyWalk_FirstItemCommentField_xp)).getText() != "") {
				obj.repAddData("Verify adding comment modified comment text area","Text should not be empty","Text area was successfully modified","Pass");
			} else {
				obj.repAddData("Verify adding comment modified comment text area","Text should not be empty","Text area was not modified","Fail");
			}
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
			log.error( "Function TC41927 Failed!", e );
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
			log.info("Execution of Function TC41927 Completed");
		}
		return obj;
	}
	
	public Reporter TC41929(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC41929 Started..");

		try {
			obj.repAddData( "Property Walk Measurements verification", "", "", "");
			
			boolean bMeasurementsAlreadyShown = false;
			
			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Property_SearchProperty_FirstEditButton_xp, "Edit First Property button",true);
			ClickByXpath(objRWModules.Property_PropertyWalk_PropertWalkTab_xp, "Property Walk tab",true);
			if (ElementFound(RenowalkModules.Property_PropertyWalk_AddNewWalkButton_xp)) {
				ClickByXpath(RenowalkModules.Property_PropertyWalk_AddNewWalkButton_xp,"Add New Walk Button",true);
			}
			ClickByXpath(objRWModules.Property_PropertyWalk_FirstGroupInList_xp, "First Group",true);
			if(ElementFound(objRWModules.Property_PropertyWalk_MeasurementsArea_xp)) {
				bMeasurementsAlreadyShown = true;
			}
			
			if (bMeasurementsAlreadyShown == false) {
				ClickByXpath(RenowalkModules.Property_PropertyWalk_AddMeasurement_xp,"Opening Measurements Area",true);
			}
			
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_PropertyWalk_MeasurementsArea_xp,"Measurements area check",true,true);
			
			
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
			log.error( "Function TC41929 Failed!", e );
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
			log.info("Execution of Function TC41929 Completed");
		}
		return obj;
	}
	
	public Reporter TC41930(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC41929 Started..");

		try {
			obj.repAddData( "Property Walk Measurements verification", "", "", "");
			
			boolean bMeasurementsAlreadyShown = false;
			
			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Property_SearchProperty_FirstEditButton_xp, "Edit First Property button",true);
			ClickByXpath(objRWModules.Property_PropertyWalk_PropertWalkTab_xp, "Property Walk tab",true);
			if (ElementFound(RenowalkModules.Property_PropertyWalk_AddNewWalkButton_xp)) {
				ClickByXpath(RenowalkModules.Property_PropertyWalk_AddNewWalkButton_xp,"Add New Walk Button",true);
			}
			ClickByXpath(objRWModules.Property_PropertyWalk_FirstGroupInList_xp, "First Group",true);
			
			try { 
				fnCheckFieldDisplayByXpath(objRWModules.Property_PropertyWalk_MeasurementsArea_xp,"Measurement area already opened",true,true); 
				bMeasurementsAlreadyShown = true;
			} finally {  
				//do nothing
			}
			
			if (bMeasurementsAlreadyShown == false) {
				ClickByXpath(RenowalkModules.Property_PropertyWalk_AddMeasurement_xp,"Opening Measurements Area",true);
			}
			
			
			
			if (driver.findElement(By.xpath(objRWModules.Property_PropertyWalk_FirstItemCommentField_xp)).getText() != "") {
				obj.repAddData("Verify adding comment modified comment text area","Text should not be empty","Text area was successfully modified","Pass");
			} else {
				obj.repAddData("Verify adding comment modified comment text area","Text should not be empty","Text area was not modified","Fail");
			}
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
			log.error( "Function TC41929 Failed!", e );
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
			log.info("Execution of Function TC41929 Completed");
		}
		return obj;
	}
	
	
}