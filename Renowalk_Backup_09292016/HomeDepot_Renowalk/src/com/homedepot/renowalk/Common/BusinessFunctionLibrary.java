package com.homedepot.renowalk.Common;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.homedepot.renowalk.TestDriver;
import com.homedepot.renowalk.ObjectRepository.RenowalkModules;

import org.apache.bcel.verifier.VerifyDialog;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;


public class BusinessFunctionLibrary extends TestDriver {

	RenowalkModules objRWModules = new RenowalkModules();
	
	
	public String fnaddAndVerifyProperty(String sWalkAssignedStatus) throws Exception 
	 {
		 //sWalkAssignedStatus can be empty("") or any text.
		 try {
			 fnSelectCorpOffice(sCorporation, sOffice);
			 fnLoadingPageWait();
			 ClickByXpath(RenowalkModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			 fnLoadingPageWait();
			 ClickByXpath(RenowalkModules.Property_ViewOffice_BtnAddProperty_xp, "Add Property button",true);

				//Check for Project Name Validation
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_AddProperty_InputProjectName_xp, "Project Name text box", true, true);
				int iRandomNum = fnRandomNum(1,10000);
				String sProjectName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();		
				SendKeyByXpath(RenowalkModules.Property_AddProperty_InputProjectName_xp, sProjectName+iRandomNum, "Name");
				
				//Filling Property code field
				fnCheckFieldDisplayByXpath(RenowalkModules.Property_AddProperty_InputPropertyCode_xp, "Project Name text box", true, true);
				String sPropertyCode = mTestPhaseData.get(TestDriver.iTC_ID).get("PropertyCode").toString().trim();	
				SendKeyByXpath(RenowalkModules.Property_AddProperty_InputPropertyCode_xp, sPropertyCode+iRandomNum, "Name");
				
				
				//Filling Address field
				fnCheckFieldDisplayByXpath(RenowalkModules.Property_AddProperty_InputAddress_xp, "Address text box", true, true);
				String sAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Address").toString().trim();
				driver.findElement(By.xpath(RenowalkModules.Property_AddProperty_InputAddress_xp)).sendKeys(sAddress);

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
				
				if(sWalkAssignedStatus=="") {
					
//					fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ComboWalkAssigned_xp, "Walk Assigned select box", true, true);
//					Select sWalkAssigned = new Select(driver.findElement(By.xpath(objRWModules.Property_AddProperty_ComboWalkAssigned_xp)));								
//					sWalkAssigned.selectByIndex(1);	
				}
				else {
					
					//Select Walk Assigned
					fnCheckFieldDisplayByXpath(objRWModules.Property_AddProperty_ComboWalkAssigned_xp, "Walk Assigned select box", true, true);
					Select sWalkAssigned = new Select(driver.findElement(By.xpath(objRWModules.Property_AddProperty_ComboWalkAssigned_xp)));
					
					String sWalkAssignedValue = mTestPhaseData.get(TestDriver.iTC_ID).get("WalkAssignedUser").toString().trim();
					fnSelectFromComboBoxXpath(RenowalkModules.Property_AddProperty_ComboWalkAssigned_xp,sWalkAssignedValue);					
					
				}				

				//Filling Gate Code
				fnCheckFieldDisplayByXpath(RenowalkModules.Property_AddProperty_InputGateCode_xp, "Gate Code text box", true, true);
				String sGateCode = mTestPhaseData.get(TestDriver.iTC_ID).get("GateCode").toString().trim();
				driver.findElement(By.xpath(RenowalkModules.Property_AddProperty_InputGateCode_xp)).sendKeys(sGateCode);

				//Filling Lock Box
				fnCheckFieldDisplayByXpath(RenowalkModules.Property_AddProperty_InputLockBox_xp, "Lock Box text box", true, true);
				String sLockBox = mTestPhaseData.get(TestDriver.iTC_ID).get("LockBox").toString().trim();
				driver.findElement(By.xpath(objRWModules.Property_AddProperty_InputLockBox_xp)).sendKeys(sLockBox);

				ClickByXpath(RenowalkModules.Common_AddModule_BtnSave_xp, "Save button",true); 
				fnLoadingPageWait();
				fnVerifyDialogBox("Add", 0);
				
//				fnSelectFromComboBoxXpath(RenowalkModules.Common_ViewModules_ComboPageSize_xp,"VIEW ALL");
				SendKeyByXpath(RenowalkModules.Property_SearchProperty_PropertySearchInput_xp, sProjectName+iRandomNum, "Property name");
				ClickByXpath(RenowalkModules.Property_SearchProperty_PropertySearchButton_xp, "Search button", true);
				fnLoadingPageWait();
				
				if(sWalkAssignedStatus=="") {
					String actStatus = driver.findElement(By.xpath("//td[1]")).getText();	
					System.out.println("td[1] text is: "+actStatus);
					HighlightElementByXpath("//td[1]");
					Assert.assertEquals("Not Assigned", actStatus);							
				}
				else{
					String actStatus = driver.findElement(By.xpath("//td[1]")).getText();	
					Assert.assertEquals("Assigned Not Walked", actStatus);	
				}
				//verify propertyname
				String actProjectName=driver.findElement(By.xpath("//b[1]")).getText();
				String expAddress=sProjectName+iRandomNum;
//				Assert.assertEquals(sProjectName+iRandomNum, actProjectName);
				if(actProjectName.equalsIgnoreCase(expAddress)) {
					obj.repAddData("Verify Project name", "Verified Project name", "Verified Project name",	"Pass");	
					HighlightElementByXpath("//b[1]");
				}
				else{
					obj.repAddData("Verify Project name", "Not verified Project name", "Not verified Project name",	"Fail");		
					HighlightElementByXpath(actProjectName);
				}				
				//verify address
				String actAddress = driver.findElement(By.xpath("//td[3]")).getText();
			//	Assert.assertEquals(sAddress, expAddress);
				if(actAddress.equalsIgnoreCase(sAddress)) {
					obj.repAddData("Verify Address", "Verified Address", "Verified Address","Pass");	
					HighlightElementByXpath("//td[3]");
				}
				else{
					obj.repAddData("Verify Address", "Not verified Address", "Not verified Address","Fail");		
					HighlightElementByXpath(actAddress);
				}						
				//verify city
				String actCity = driver.findElement(By.xpath("//td[4]")).getText();
			//	Assert.assertEquals(sCity, actCity);
				if(actCity.equalsIgnoreCase(sCity)) {
					obj.repAddData("Verify City", "Verified City", "Verified city","Pass");	
					HighlightElementByXpath("//td[4]");
				}
				else{
					obj.repAddData("Verify City", "Not verified City", "Not verified city","Fail");		
					HighlightElementByXpath(actCity);
				}					
			//	obj.repAddData( "Verify Office Name in Database", "", "", "");
				//Put db code here
				 return sProjectName+iRandomNum;
		 } 
		
		 
		 catch (Exception e) {
			 System.out.println("fnaddAndVerifyProperty --------------Failed");  
			 TestDriver.log.error("fnaddAndVerifyProperty failed",e);
			 throw(e);
		 }
		
	 }		 // end fnAddAndSaveProperty
	
	public void fnVerifyOrAddInviationHomeinOffice() throws Exception 
	 {		 
		 try {
				ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
				fnLoadingPageWait();
				ClickByXpath(RenowalkModules.Offices_AutoTestOffice_xp, "AutoTestOffice link", true);
				fnLoadingPageWait();
				String actQuoteemail = driver.findElement(By.id("quoteEmailAddress")).getAttribute("value"); 
				System.out.println("Actual quote email : "+actQuoteemail);
				if(actQuoteemail.contains("invitationhomes")) {
					obj.repAddData("Verify quote email address for invitationhomes", "Verified quote email address for invitationhomes", "'invitationhomes' is present in quote email address","Pass");
					ClickById(RenowalkModules.Offices_CancelBTN_ID, "Cancel button", true);
					fnLoadingPageWait();
				}
				else {
					String[] quoteEmailSplit = actQuoteemail.split("@");
					String newEmail = quoteEmailSplit[0]+"invitationhomes@"+quoteEmailSplit[1];
					System.out.println("Modified string is : "+newEmail);	
					SendKeyById("quoteEmailAddress", newEmail, "updated email address");
					ClickById(RenowalkModules.USERS_SAVE_BTN_ID, "Update button", true);
					fnLoadingPageWait();
					fnVerifyDialogBox("Add", 0);					
				}		 
		 }		 
		 catch (Exception e) {
			 System.out.println("fnVerifyorAddInviationHomeinOffice --------------Failed");  
			 TestDriver.log.error("fnVerifyorAddInviationHomeinOffice failed",e);
			 throw(e);
		 }
		
	 }		 // end fnVerifyorAddInviationHomeinOffice
	
	public void fnVerifyPropetyStatusAndProjectToolsButtons() throws Exception 
	 {		 
		 try {
			 // the control should be in property tab in property
			 String propertyStatus=driver.findElement(By.xpath(RenowalkModules.Property_PropertyStatus_InProperty_XP)).getText();
				ClickByXpath(RenowalkModules.Property_ProjectTools_xp, "Project tools tab", true);
				fnLoadingPageWait();
			 if(propertyStatus.equals("Not Assigned")||propertyStatus.equals("Assigned Not Walked")) {				
					fnCheckFieldDisplayByXpath(RenowalkModules.Property_ProjectTools_ExportCSV_Disabled_xp, "Disabled 'Export CSV' button", true, true);
					fnCheckFieldDisplayByXpath(RenowalkModules.Property_ProjectTools_PDF_Disabled_xp, "Disabled 'PDF' button", true, true);
					fnCheckFieldDisplayByXpath(RenowalkModules.Property_ProjectTools_PTLFinalized_Disabled_xp, "Disabled 'PTL finalized' button", true, true);
					fnCheckFieldDisplayByXpath(RenowalkModules.Property_ProjectTools_Property_GeneratePTLSpreadsheet_Disabled_xp, "Disabled 'Generate PTL spreadsheet' button", true, true);
					fnCheckFieldDisplayByXpath(RenowalkModules.Property_ProjectTools_AssignSalesforce_xp, "Assign salesforce button", true, true);
					obj.repAddData("Verify project tools tabs as property is Not assigned/assigned not walked", "Project tools(disabled buttons) should be verified", "Project tools(disabled buttons) verified","Pass");	
				}
				else if(propertyStatus.equals("Walked")) {
					fnCheckFieldDisplayByXpath(RenowalkModules.Property_ProjectTools_ExportCSV_XP, "Export CSV button", true, true);
					fnCheckFieldDisplayByXpath(RenowalkModules.Property_ProjectTools_PDF_XP, "PDF button", true, true);
					fnCheckFieldDisplayByXpath(RenowalkModules.Property_ProjectTools_PTLFinalized_XP, "PTL finalized", true, true);
					fnCheckFieldDisplayByXpath(RenowalkModules.Property_ProjectTools_GeneratePTLSpreadshoot_XP, "Generate PTL spreadsheets", true, true);
					fnCheckFieldDisplayByXpath(RenowalkModules.Property_ProjectTools_AssignSalesforce_xp, "Assign salesforce button", true, true);
					obj.repAddData("Verify project tools tabs as property is Walked", "Project tools(clickable buttons) should be verified", "Project tools(Clickable buttons) verified","Pass");
				}					
		 }		 
		 catch (Exception e) {
			 System.out.println("fnVerifyPropetyStatusAndProjectToolsButtons --------------Failed");  
			 TestDriver.log.error("fnVerifyPropetyStatusAndProjectToolsButtons failed",e);
			 throw(e);
		 }
		
	 }  //End of fnVerifyPropetyStatusAndProjectToolsButtons
	public HashMap<String, String> fnSelectIHAndGetPropDetails(String propertyName) throws Exception 
	 {		 
		 try {
				String sIHCorporation = mTestPhaseData.get(TestDriver.iTC_ID).get("Corporation").toString().trim();
				System.out.println("Corporatoon value is : "+sIHCorporation);
				String sIHOffice = mTestPhaseData.get(TestDriver.iTC_ID).get("Office").toString().trim();
				fnSelectCorpOfficeIHForceSelect(sIHCorporation, sIHOffice);			
				fnLoadingPageWait();
				ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
				fnLoadingPageWait();
				SendKeyByXpath(RenowalkModules.Property_SearchProperty_PropertySearchInput_xp, propertyName, "Property name");
				ClickByXpath(RenowalkModules.Property_SearchProperty_PropertySearchButton_xp, "Search button", true);
				fnLoadingPageWait();			
				ClickByXpath(RenowalkModules.Property_clickProperty_XP.replace("propertNameToBeclicked", propertyName), "Property name", true);
				fnLoadingPageWait();					
				//map for label and value
				HashMap<String, String> propertyDataMap = new HashMap<String, String>();
				//label(key) starts
//				String projNameLabel = driver.findElement(By.id("ProjectNameLabel")).getText();
//				System.out.println("Project name label is : "+projNameLabel);
//				String addressLabel = driver.findElement(By.id("AddressLabel")).getText();
//				String cityLabel = driver.findElement(By.id("CityLabel")).getText();
//				String stateLabel = driver.findElement(By.id("StateLabel")).getText();
//				String zipLabel = driver.findElement(By.id("ZipCodeLabel")).getText();
//				String countyLabel = driver.findElement(By.id("CountyLabel")).getText();
//				String mainSqFtLabel = driver.findElement(By.id("MainSqFtLabel")).getText();
//				String numberOfBedroomsLabel = driver.findElement(By.id("NumberBedroomLabel")).getText();
//				String numberOfBathroomsLabel = driver.findElement(By.id("NumberBathroomLabel")).getText();
//				String yearBuiltLabel = driver.findElement(By.id("YearBuiltLabel")).getText();
				//text box value(value) starts
				String projNameValue= driver.findElement(By.name("ProjectName")).getAttribute("value");
				System.out.println("Project name value : "+projNameValue);
				String addressValue = driver.findElement(By.name("Address")).getAttribute("value");
				String cityValue= driver.findElement(By.name("City")).getAttribute("value");
				String stateValue = driver.findElement(By.name("State")).getAttribute("value");
				String zipValue= driver.findElement(By.name("ZipCode")).getAttribute("value");
				String countyValue= driver.findElement(By.name("County")).getAttribute("value");
				String mainSqFtValue = driver.findElement(By.name("MainSqFt")).getAttribute("value");
				String numberOfBedroomsValue= driver.findElement(By.name("NumberBedroom")).getAttribute("value");
				String numberOfBathroomsValue= driver.findElement(By.name("NumberBathroom")).getAttribute("value");
				System.out.println("Number of bathrooms value : "+numberOfBathroomsValue);
				String yearBuiltValue = driver.findElement(By.name("YearBuilt")).getAttribute("value");
				//putting in map
				propertyDataMap.put("projectName", projNameValue);
				propertyDataMap.put("address", addressValue);
				propertyDataMap.put("city", cityValue);
				propertyDataMap.put("state", stateValue);
				propertyDataMap.put("zip", zipValue);
				propertyDataMap.put("county", countyValue);
				propertyDataMap.put("squareFootage", mainSqFtValue);
				propertyDataMap.put("bed", numberOfBedroomsValue);
				propertyDataMap.put("bath", numberOfBathroomsValue);
				propertyDataMap.put("yearBuilt", yearBuiltValue);
			 return propertyDataMap;				
		 }		 
		 catch (Exception e) {
			 System.out.println("fnSelectIHAndGetPropDetails --------------Failed");  
			 TestDriver.log.error("fnSelectIHAndGetPropDetails failed",e);
			 throw(e);
		 }
		
	 }  //End of fnVerifyPropetyStatusAndProjectToolsButtons
	
	public void fnVerifyBasicPropertyDetails(String expectedResult,String actualResult,String reportedElement) throws Exception 
	 {		 
		 try {
			 if(StringUtils.equals(expectedResult, actualResult)){
					obj.repAddData(reportedElement+" should be verified",reportedElement+" should match",reportedElement+" matched","Pass");
					
				}else{
					obj.repAddData(reportedElement+" should be verified",reportedElement+" should match",reportedElement+" not matched","Fail");
				}					
		 }		 
		 catch (Exception e) {
			 System.out.println("fnVerifyBasicPropertyDetails --------------Failed");  
			 TestDriver.log.error("fnVerifyBasicPropertyDetails failed",e);
			 throw(e);
		 }
		
	 }  //End of fnVerifyBasicPropertyDetails
	
	public void fnSelectCorpOfficeIHForceSelect(String sCorp, String sOffice) throws Exception

	 {
		try
		{
			String sDeafaultValue = driver.findElement(By.xpath("//*[@id='corporationSelect']/div")).getText();			
			
				ClickById("corporationSelect", "Corporation Drop-down", false);
				WebElement eleCorpList = driver.findElement(By.xpath(RenowalkModules.Common_AllModules_ComboCorporateName_xp));

				List<WebElement> arrCorpList = eleCorpList.findElements(By.xpath("./li"));  //Get the table data rows

				for(WebElement eleCorp : arrCorpList)
				{
					String sCorpName = eleCorp.findElement(By.xpath("./div")).getText();
					if(sCorpName.equalsIgnoreCase(sCorp))
					{
						eleCorp.click();
						break;
					}

				}
				//make sure it should select office code
				Thread.sleep(1000);
//				ClickByXpath(RenowalkModules.Common_AddModule_BtnDialogBox, "Ok button", true);
//				Thread.sleep(3000);
				//call this if we are selecting corp and office from diff corp and office
//				fnVerifyDialogBox("OfficeCode", 1);
					ClickById("officeSelect", "Office Drop-down", false);
					WebElement eleOfficeList = driver.findElement(By.xpath(RenowalkModules.Common_AllModules_ComboOfficeCode_xp));
					List<WebElement> arrOfficeList = eleOfficeList.findElements(By.xpath("./li"));  //Get the table data rows

					for(WebElement eleOffice : arrOfficeList)
					{
						String sOfficeName = eleOffice.findElement(By.xpath("./div")).getText();
						if(sOfficeName.equalsIgnoreCase(sOffice))
						{
							eleOffice.click();
							break;
						}
					}			
			
		} catch (Exception e) {
	    System.out.println("fnSelectCorpOffice --------------Failed");    
	    TestDriver.log.error("fnSelectCorpOffice failed",e);
	    }
	 }
	
	public void checkIfNotChecked(String xpath, String faceValue) throws Exception{
		String cssClass=driver.findElement(By.xpath(xpath)).getAttribute("class");
		if(!cssClass.contains("ui-icon-check")){
			ClickByXpath(xpath, faceValue, true);
		}
	}
	
	public void checkIfUncheckedAddOrEditPropInOfficeLevel() throws Exception

	 {
		try
		{
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(RenowalkModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices link", true);
			fnLoadingPageWait();
			String sOfficeName = mTestPhaseData.get(TestDriver.iTC_ID).get("Office").toString().trim();
			ClickByXpath(RenowalkModules.Offices_OfficeNameReplace_XP.replace("officeNameReplace", sOfficeName), sOfficeName+" Office name", true);
			fnLoadingPageWait();
			ClickByXpath(RenowalkModules.Offices_Advance_XP, "'Advance' button", true);
			WebElement addEditCheckbox=driver.findElement(By.xpath(RenowalkModules.Offices_Advance_addeditCheckbox_XP));
			if(addEditCheckbox.isSelected()) {
				ClickById(RenowalkModules.Offices_CancelBTN_ID, "Cancel button", true);
				fnLoadingPageWait();
			}
			else {
				ClickByXpath(RenowalkModules.Offices_Advance_addeditCheckbox_XP, "Add/Edit property checkbox", true);
				ClickById(RenowalkModules.USERS_SAVE_BTN_ID, "Update button", true);
				fnLoadingPageWait();				
			}
			fnLoadingPageWait();
			fnVerifyDialogBox("Update", 0);				
			
		} catch (Exception e) {
	    System.out.println("fnSelectCorpOffice --------------Failed");    
	    TestDriver.log.error("fnSelectCorpOffice failed",e);
	    }
	 }
	
	public void unCheckIfcheckedAddOrEditPropInOfficeLevel() throws Exception

	 {
		try
		{
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(RenowalkModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices link", true);
			fnLoadingPageWait();
			String sOfficeName = mTestPhaseData.get(TestDriver.iTC_ID).get("Office").toString().trim();
			ClickByXpath(RenowalkModules.Offices_OfficeNameReplace_XP.replace("officeNameReplace", sOfficeName), sOfficeName+" Office name", true);
			fnLoadingPageWait();
			ClickByXpath(RenowalkModules.Offices_Advance_XP, "'Advance' button", true);
			WebElement addEditCheckbox=driver.findElement(By.xpath(RenowalkModules.Offices_Advance_addeditCheckbox_XP));
			if(addEditCheckbox.isSelected()) {
				ClickByXpath(RenowalkModules.Offices_Advance_addeditCheckbox_XP, "Add/Edit property checkbox", true);
				ClickById(RenowalkModules.USERS_SAVE_BTN_ID, "Update button", true);
				fnLoadingPageWait();					
			}
			else {
				ClickById(RenowalkModules.Offices_CancelBTN_ID, "Cancel button", true);
				fnLoadingPageWait();
			}
			fnLoadingPageWait();
			fnVerifyDialogBox("Update", 0);				
			
		} catch (Exception e) {
	    System.out.println("fnSelectCorpOffice --------------Failed");    
	    TestDriver.log.error("fnSelectCorpOffice failed",e);
	    }
	 }
	
	
	public void fnEnterWalkedPropertyNameGoToPropertyWalk() throws Exception
	 {
		try
		{		
			fnSelectCorpOffice(sCorporation, sOffice);
			 fnLoadingPageWait();
			 ClickByXpath(RenowalkModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			 fnLoadingPageWait();
			 String sProjectName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();		
			 
			 SendKeyByXpath(RenowalkModules.Property_SearchProperty_PropertySearchInput_xp, sProjectName, "Property name");
				ClickByXpath(RenowalkModules.Property_SearchProperty_PropertySearchButton_xp, "Search button", true);
				fnLoadingPageWait();
				ClickByXpath(RenowalkModules.Property_clickProperty_XP.replace("propertNameToBeclicked", sProjectName), "Property name", true);
				fnLoadingPageWait();
				ClickByXpath(RenowalkModules.Property_PropertyWalk_xp, "Property walk button", true);
				fnIHLoadingPageWait();			
			
		} catch (Exception e) {
	    System.out.println("fnSelectCorpOffice --------------Failed");    
	    TestDriver.log.error("fnSelectCorpOffice failed",e);
	    }
	 }
	 
	
} // End of class
