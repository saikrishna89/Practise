package com.homedepot.renowalk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.Page;
import com.google.common.base.Objects;
import com.homedepot.renowalk.ObjectRepository.RenowalkHome;
import com.homedepot.renowalk.ObjectRepository.RenowalkModules;
import com.homedepot.renowalk.ReportManager.Reporter;
import com.homedepot.renowalk.UtilManager.AppMessages;

public class Users extends TestDriver {
	RenowalkModules objRWModules = new RenowalkModules();
	RenowalkHome objRWHome = new RenowalkHome();
	AppMessages objAppMessages = new AppMessages();

	// Users_TC001_Users_Verify Table Headers_Label_AddUserButton
	@SuppressWarnings("static-access")
	public Reporter TC41975(Reporter obj) throws Exception {
		// Boolean bLoginFlag = true;
		log.info("Execution of Function TC41975 Started..");

		try {

			obj.repAddData("Viewing Users", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			fnLoadingPageWait();
			ClickByXpath(objRWModules.Users_GenOffice_LinkOfficesOption_xp, "Users Link", true);
			fnLoadingPageWait();
			// verify labels
			fnCheckFieldDisplayById(RenowalkModules.USERS_USERSLABEL_ID, "'Users label'", true, true);			
			// verifies 'add user' button
			fnCheckFieldDisplayByXpath(RenowalkModules.Users_BtnAddItem_xp, "'ADD USER' button", true, true);
			fnCheckFieldDisplayById(RenowalkModules.USERS_CURRENTUSERS_LABEL_ID, "'Current users label'", true, true);
			// verify headers
			WebElement eleTable = driver.findElement(By.xpath(RenowalkModules.Common_ViewModules_Table_xp));
			List<WebElement> arrHeaderColumns = eleTable.findElements(By.xpath("./thead/tr/th")); // Get the header
																									
			System.out.println("Rows Size>>>>" + arrHeaderColumns.size());
			// verifying headers
			fnVerifyHeaders(arrHeaderColumns, 0, "User Name");
			fnVerifyHeaders(arrHeaderColumns, 1, "Full Name");
			fnVerifyHeaders(arrHeaderColumns, 2, "Email");
			fnVerifyHeaders(arrHeaderColumns, 3, "Office(s)");
			fnVerifyHeaders(arrHeaderColumns, 4, "Active");
			System.out.println("headers done!!");

		} catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			// bLoginFlag=false;
			obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
					"Exception found in current test.", "Fail");
			log.error("Function TC41975 Failed!", e);
		} finally {

			/*
			 * if((bLoginFlag==true && driver!=null) ) { fnSignOut(); }
			 */

			if (!testCaseStatus) {
				Reporter.iTotalFail++;
			} else {
				Reporter.iTotalPass++;
			}
			/*
			 * obj.repGenerateResult(Test_Case_Name, header);
			 * obj.repGenerateIndexReport(indexHeader); header = null; //Enable
			 * after testing
			 */ log.info("Execution of Function TC41975 Completed");
		}
		return obj;
	} // End of function TC41975

	// Users_TC002_Users_Verify_Officelist_Combobox
	@SuppressWarnings("static-access")
	public Reporter TC41976(Reporter obj) throws Exception {
		// Boolean bLoginFlag = true;
		log.info("Execution of Function TC41976 Started..");

		try {

			obj.repAddData("availability of select office combo box", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			fnLoadingPageWait();
			ClickByXpath(objRWModules.Users_GenOffice_LinkOfficesOption_xp, "Users Link", true);
			fnLoadingPageWait();
			// verify select office drop down
			fnVerifyComboBoxValue(RenowalkModules.USERS_SELECTOFFICE_COMBOBOX_XP, "AutoTestOffice");			

		} catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			// bLoginFlag=false;
			obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
					"Exception found in current test.", "Fail");
			log.error("Function TC41976 Failed!", e);
		} finally {

			if (!testCaseStatus) {
				Reporter.iTotalFail++;
			} else {
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC41976 Completed");
		}
		return obj;
	} // End of function TC27058

	// Users_TC003_Users_Show_Inactivecheckbox
	@SuppressWarnings("static-access")
	public Reporter TC41977(Reporter obj) throws Exception {
		// Boolean bLoginFlag = true;
		log.info("Execution of Function TC41977 Started..");

		try {
			obj.repAddData("availability of select office combo box", "", "", "");			
			fnSelectCorpOffice(sCorporation, sOffice);
			fnLoadingPageWait();
			ClickByXpath(objRWModules.Users_GenOffice_LinkOfficesOption_xp, "Users Link", true);
			fnLoadingPageWait();
			verifyCheckBoxIsNotCheckedById(RenowalkModules.USERS_SHOWINACTIVE_CHECKBOX_ID, "Show Inactive Checkbox");

		} catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			// bLoginFlag=false;
			obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
					"Exception found in current test.", "Fail");
			log.error("Function TC41977 Failed!", e);
		} finally {

			if (!testCaseStatus) {
				Reporter.iTotalFail++;
			} else {
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC41977 Completed");
		}
		return obj;
	} // End of function TC41977

	// Users_TC004_Users_Verify_Pagination_Options
	@SuppressWarnings("static-access")
	public Reporter TC41978(Reporter obj) throws Exception {
		// Boolean bLoginFlag = true;
		log.info("Execution of Function TC41978 Started..");

		try {

			obj.repAddData("Availability of Pagination Options", "", "", "");
			// fnSelectCorpOffice(sCorporation, sOffice);
			// fnLoadingPageWait();
			ClickByXpath(objRWModules.Users_GenOffice_LinkOfficesOption_xp, "Users Link", true);
			fnLoadingPageWait();
			HighlightElementByXpath(objRWModules.Common_ViewModules_ComboPageSize_xp);
			Select select = new Select(driver.findElement(By.xpath(objRWModules.Common_ViewModules_ComboPageSize_xp)));
			List<WebElement> arrPageSize = select.getOptions();
			System.out.println("Page Combobox Size>>>>" + arrPageSize.size());
			fnVerifyComboBoxValues(arrPageSize, 0, "10 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 1, "20 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 2, "VIEW ALL");

		} catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			// bLoginFlag=false;
			obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
					"Exception found in current test.", "Fail");
			log.error("Function TC41978 Failed!", e);
		} finally {

			if (!testCaseStatus) {
				Reporter.iTotalFail++;
			} else {
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC41978 Completed");
		}
		return obj;
	} // End of function TC41978

	// Users_TC005_Users_Verify_Tableviews
	@SuppressWarnings("static-access")
	public Reporter TC41979(Reporter obj) throws Exception {
		// Boolean bLoginFlag = true;
		log.info("Execution of Function TC41979 Started..");

		try {
			obj.repAddData("Verify table records", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			fnLoadingPageWait();
			ClickByXpath(objRWModules.Users_GenOffice_LinkOfficesOption_xp, "Users Link", true);
			ClickByXpath(RenowalkModules.USERS_SELECTOFFICE_COMBOBOX_XP, "select office drop down", true);
			fnLoadingPageWait();
			ClickByXpath(RenowalkModules.USERS_SELECTOFC_OPTION_AUTOTESTOFFICE_XP, "Auto test office", true);			
			fnLoadingPageWait();
			ClickById(RenowalkModules.USERS_SHOW_INACTIVE_CB_ID, "Click on show inactive search box", true);
			fnLoadingPageWait();
			fnSelectFromComboBoxXpath(objRWModules.Common_ViewModules_ComboPageSize_xp,"VIEW ALL");
			fnLoadingPageWait();			
			HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWModules.Common_ViewModules_Table_xp, "Users");
			mTableData.size();
			int iActiveCount = 0;
			int iInactiveCount = 0;
			for(int i=1;i<=mTableData.size();i++)
			{
				String sUserType = mTableData.get(i).get(5).toString();
				
				if(sUserType.equalsIgnoreCase("Active"))
				{
					iActiveCount= iActiveCount+1;
				}
				else if(sUserType.equalsIgnoreCase("Inactive"))
				{
					iInactiveCount= iInactiveCount+1;
				}				
			}
			System.out.println("Active users count : "+iActiveCount);
			System.out.println("Inactive users count : "+iInactiveCount);
			
			if (iActiveCount > 0 || iInactiveCount > 0) {
				obj.repAddData("Verify no. of counts for active/inactive users", "Users list should be verified",
						"Active/Inactive users list verified successfully. Total Users # : " + mTableData.size()
								+ " Active Users # : " + String.valueOf(iActiveCount) + " Inctive Users # : "
								+ String.valueOf(iInactiveCount),"Pass");
			} else {
				obj.repAddData("Verify no. of counts for active/inactive users", "Users list should be verified",
						"Active/Inactive users list not found. Total Users # : " + mTableData.size()
								+ " Active Users # : " + String.valueOf(iActiveCount) + " Inctive Users # : "
								+ String.valueOf(iInactiveCount),"Fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			// bLoginFlag=false;
			obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
					"Exception found in current test.", "Fail");
			log.error("Function TC41979 Failed!", e);
		} finally {

			if (!testCaseStatus) {
				Reporter.iTotalFail++;
			} else {
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC41979 Completed");
		}
		return obj;
	}          // End of function TC41979

	// Users_TC006_Users_Active_data_Verifications
	@SuppressWarnings("static-access")
	public Reporter TC41980(Reporter obj) throws Exception {

		log.info("Execution of Function TC41980 Started..");

		try {

			fnSelectCorpOffice(sCorporation, sOffice);
			fnLoadingPageWait();
			ClickByXpath(objRWModules.Users_GenOffice_LinkOfficesOption_xp, "Users Link", true);
			fnLoadingPageWait();
			boolean allAreActive = true;
			// Find all div which has a span whose title =active
			List<WebElement> elements = driver.findElements(By.xpath(RenowalkModules.USERS_CHECKACTIVERECORDS_XP));
			// Check if any element has a class containing ng-hide. If yes, test failed, otherwise test passed
			for (WebElement element : elements) {
				HighlightElement(element);
				if (StringUtils.contains(element.getAttribute("class"), "ng-hide")) {
					// if element has a class ng-hide. break
					allAreActive = false;
					break;
				}
			}

			if (allAreActive == true) {
				obj.repAddData("All Records should be active", "All Records are active", "All Records are active",
						"Pass");
			} else {
				obj.repAddData("All Records should be active", "All Records are active",
						"One or more Records are not active", "Fail");
			}

		} catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
					"Exception found in current test.", "Fail");
			log.error("Function TC41980 Failed!", e);
		} finally {

			if (!testCaseStatus) {
				Reporter.iTotalFail++;
			} else {
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC41980 Completed");
		}
		return obj;
	}      // End of function TC41980

	// Users_TC007_Verify_SuperUser_Buttons
	@SuppressWarnings("static-access")
	public Reporter TC41981(Reporter obj) throws Exception {

		log.info("Execution of Function TC41981 Started..");

		try {			
			if(bLoginFlag==true) 
			{
			fnCheckFieldDisplayByXpath(RenowalkModules.Corporations_GenCorp_LinkCorporationsOption_xp,"Corporations link", true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions link", true,true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices link", true,true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Users_GenOffice_LinkOfficesOption_xp, "Users link", true,true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_GenProp_LinkPropertyOption_xp, "Property link", true,true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Utilities_GenProp_LinkUtilitiesOption_xp, " Utilities link",true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.ProductTiers_GenProd_LinkProductTiersOption_xp,"Product Tiers  link", true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_GenItem_LinkItemsOption_xp, " Items link", true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Groups_GenGroups_LinkGroupOption_xp, " Groups link", true,	true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_LinkFlowOption_xp, "Flow link", true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.ipadVersioning_GenProp_LinkIpadVersioningOption_XP,"iPad Versioning link", true, true);
			
			 fnSignOut(true);
			}
			else
			{
				log.info("Login with super user not successful");
				System.out.println("Login with super user not successful");
			}

		} catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
					"Exception found in current test.", "Fail");
			log.error("Function TC41981 Failed!", e);
		} finally {

			if (!testCaseStatus) {
				Reporter.iTotalFail++;
			} else {
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC41981 Completed");
		}
		return obj;
	}  //// End of function TC41981

	// Users_TC008_Verify_CorporateAdmin_Buttons
	@SuppressWarnings("static-access")
	public Reporter TC41982(Reporter obj) throws Exception {

		log.info("Execution of Function TC41982 Started..");

		try {				
			if(bLoginFlag==true) 
			{
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.Corporations_GenCorp_LinkCorporationsOption_xp,"Corporations link", true);
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions link", true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices link", true,true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Users_GenOffice_LinkOfficesOption_xp, "Users link", true,true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Property_GenProp_LinkPropertyOption_xp, "Property link", true,true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Utilities_GenProp_LinkUtilitiesOption_xp, " Utilities link",true, true);
				fnCheckFieldDisplayByXpath(RenowalkModules.ProductTiers_GenProd_LinkProductTiersOption_xp,"Product Tiers  link", true, true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Items_GenItem_LinkItemsOption_xp, " Items link", true, true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Groups_GenGroups_LinkGroupOption_xp, "Groups link", true,	true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_LinkFlowOption_xp, "Flow link", true, true);
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.ipadVersioning_GenProp_LinkIpadVersioningOption_XP,"iPad Versioning link", true);			
				fnSignOut(true);
			}
			else
			{
				log.info("Login with Corporate admin not successful");
				System.out.println("Login with Corporate admin not successful");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
					"Exception found in current test.", "Fail");
			log.error("Function TC41982 Failed!", e);
		} finally {

			if (!testCaseStatus) {
				Reporter.iTotalFail++;
			} else {
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC41982 Completed");
		}
		return obj;
	}  // End of function TC41982

	// Users_TC009_Verify_OfficeAdmin_Buttons
	@SuppressWarnings("static-access")
	public Reporter TC41983(Reporter obj) throws Exception {

		log.info("Execution of Function TC41983 Started..");

		try {
				
			if(bLoginFlag==true) 
			{
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.Corporations_GenCorp_LinkCorporationsOption_xp,"Corporations link", true);
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions link", true);
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices link", true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Users_GenOffice_LinkOfficesOption_xp, "Users link", true,true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Property_GenProp_LinkPropertyOption_xp, "Property link", true,true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Utilities_GenProp_LinkUtilitiesOption_xp, " Utilities link",true, true);
				fnCheckFieldDisplayByXpath(RenowalkModules.ProductTiers_GenProd_LinkProductTiersOption_xp,"Product Tiers  link", true, true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Items_GenItem_LinkItemsOption_xp, " Items link", true, true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Groups_GenGroups_LinkGroupOption_xp, " Groups link", true,	true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddFlow_LinkFlowOption_xp, "Flow link", true, true);
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.ipadVersioning_GenProp_LinkIpadVersioningOption_XP,"iPad Versioning  link", true); 
				fnSignOut(true);
			}
			else
			{
				log.info("Login with Office admin not successful");
				System.out.println("Login with Office admin not successful");
			}		

		} catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
					"Exception found in current test.", "Fail");
			log.error("Function TC41983 Failed!", e);
		} finally {

			if (!testCaseStatus) {
				Reporter.iTotalFail++;
			} else {
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC41983 Completed");
		}
		return obj;
	}  // End of function TC41983

	// Users_TC010_Verify_office reviewer_Buttons
	@SuppressWarnings("static-access")
	public Reporter TC41984(Reporter obj) throws Exception {

		log.info("Execution of Function TC41984 Started..");

		try {			
			if(bLoginFlag==true) 
			{
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.Corporations_GenCorp_LinkCorporationsOption_xp,"Corporations link", true);
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions link", true);
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices link", true);
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.Users_GenOffice_LinkOfficesOption_xp, "Users link", true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Property_GenProp_LinkPropertyOption_xp, "Property link", true,true);
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.Utilities_GenProp_LinkUtilitiesOption_xp, " Utilities link",true);
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.ProductTiers_GenProd_LinkProductTiersOption_xp,"Product Tiers  link", true);
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.Items_GenItem_LinkItemsOption_xp, " Items link", true);
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.Groups_GenGroups_LinkGroupOption_xp, " Groups link", true);
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.Flow_AddFlow_LinkFlowOption_xp, "Flow link", true);
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.ipadVersioning_GenProp_LinkIpadVersioningOption_XP,"iPad Versioning link", true);			
			    fnSignOut(true);
			}
			else
			{
				log.info("Login with super Office reviewer successful");
				System.out.println("Login with Office reviewer not successful");
			}		

		} catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
					"Exception found in current test.", "Fail");
			log.error("Function TC41984 Failed!", e);
		} finally {

			if (!testCaseStatus) {
				Reporter.iTotalFail++;
			} else {
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC41984 Completed");
		}
		return obj;
	} // End of function TC41984
	
	//Users_TC011_Verify_Limited_Reviewer_Buttons
		@SuppressWarnings("static-access")
		public Reporter TC41985(Reporter obj) throws Exception {

			log.info("Execution of Function TC41985 Started..");

			try {
			
				if(bLoginFlag==true) 
				{
					fnCheckFieldDoesNotExistByXpath(RenowalkModules.Corporations_GenCorp_LinkCorporationsOption_xp,"Corporations link", true);
					fnCheckFieldDoesNotExistByXpath(RenowalkModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions link", true);
					fnCheckFieldDoesNotExistByXpath(RenowalkModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices link", true);
					fnCheckFieldDoesNotExistByXpath(RenowalkModules.Users_GenOffice_LinkOfficesOption_xp, "Users link", true);
					fnCheckFieldDisplayByXpath(RenowalkModules.Property_GenProp_LinkPropertyOption_xp, "Property link", true,true);
					fnCheckFieldDoesNotExistByXpath(RenowalkModules.Utilities_GenProp_LinkUtilitiesOption_xp, " Utilities link",true);
					fnCheckFieldDoesNotExistByXpath(RenowalkModules.ProductTiers_GenProd_LinkProductTiersOption_xp,"Product Tiers  link", true);
					fnCheckFieldDoesNotExistByXpath(RenowalkModules.Items_GenItem_LinkItemsOption_xp, " Items link", true);
					fnCheckFieldDoesNotExistByXpath(RenowalkModules.Groups_GenGroups_LinkGroupOption_xp, " Groups link", true);
					fnCheckFieldDoesNotExistByXpath(RenowalkModules.Flow_AddFlow_LinkFlowOption_xp, "Flow link", true);
					fnCheckFieldDoesNotExistByXpath(RenowalkModules.ipadVersioning_GenProp_LinkIpadVersioningOption_XP,"iPad Versioning  link", true); 
					fnSignOut(true);
				}
				else
				{
					log.info("Login with Limited reviewer not successful");
					System.out.println("Login with Limited reviewer not successful");
				}
				
				 
			} catch (Exception e) {
				e.printStackTrace();
				testCaseStatus = false;
				obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
						"Exception found in current test.", "Fail");
				log.error("Function TC41985 Failed!", e);
			} finally {

				if (!testCaseStatus) {
					Reporter.iTotalFail++;
				} else {
					Reporter.iTotalPass++;
				}
				log.info("Execution of Function TC41985 Completed");
			}
			return obj;
		}  //End of function TC41985
		
	// Users_TC012_Verify_AppUser_Buttons
	@SuppressWarnings("static-access")
	public Reporter TC41986(Reporter obj) throws Exception {

		log.info("Execution of Function TC41986 Started..");

		try {			
			if(bLoginFlag==true)
			{
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.Corporations_GenCorp_LinkCorporationsOption_xp,"Corporations link", true);
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions link", true);
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices link", true);
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.Users_GenOffice_LinkOfficesOption_xp, "Users link", true);
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.Property_GenProp_LinkPropertyOption_xp, "Property link", true);
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.Utilities_GenProp_LinkUtilitiesOption_xp, " Utilities link",true);
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.ProductTiers_GenProd_LinkProductTiersOption_xp,"Product Tiers  link", true);
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.Items_GenItem_LinkItemsOption_xp, " Items link", true);
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.Groups_GenGroups_LinkGroupOption_xp, " Groups link", true);
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.Flow_AddFlow_LinkFlowOption_xp, "Flow button", true);
				fnCheckFieldDoesNotExistByXpath(RenowalkModules.ipadVersioning_GenProp_LinkIpadVersioningOption_XP,"iPad Versioning  link", true); 			
				fnCheckFieldDisplayByXpath(RenowalkModules.IPADVERSIONING_POPUP_XP, "Dialogue box with Ipad only permissions", true, true);
				fnCheckFieldDisplayByXpath(RenowalkModules.IPADVERSIONING_POPUP_LINKTO_IPADAPP_XP, "Link to ipad app", true, true);		
				fnCheckFieldDisplayByXpath(RenowalkModules.IPADVERSIONING_POPUP_LOGOUT_BTN_XP, "Log out button", true, true);
				ClickByXpath(RenowalkModules.IPADVERSIONING_POPUP_LOGOUT_BTN_XP, "Log out button", true);
				
				//fnSignOut(true);
			}
			else
			{
				log.info("Login with app user not successful");
				System.out.println("Login with app user not successful");
			}
			
	
		} catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
					"Exception found in current test.", "Fail");
			log.error("Function TC41986 Failed!", e);
		} finally {

			if (!testCaseStatus) {
				Reporter.iTotalFail++;
			} else {
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC41986 Completed");
		}
		return obj;
	} // End of function TC41986
	
	
	//Users_TC013_Verify_all_NonTHDfields
		@SuppressWarnings("static-access")
		public Reporter TC41987(Reporter obj) throws Exception {

			log.info("Execution of Function TC41987 Started..");

			try {			
				obj.repAddData("Verify all non THD fields", "", "", "");
				fnSelectCorpOffice(sCorporation, sOffice);
				fnLoadingPageWait();
				ClickByXpath(objRWModules.Users_GenOffice_LinkOfficesOption_xp, "Users Link", true);
				fnLoadingPageWait();
				ClickByXpath(RenowalkModules.Users_BtnAddItem_xp, "Add user button", true);
				fnLoadingPageWait();
				fnCheckFieldDisplayById(RenowalkModules.USERS_CANCEL_BTN_ID, "Cancel button", true, true);
				fnCheckFieldDisplayByXpath(RenowalkModules.USERS_DISABLED_SAVE_BTN_XP, "disabled save button", true, true);
				verifyCheckBoxIsNotCheckedByXpath(RenowalkModules.USERS_THDASSOCIATE_CHECKBOX_XP, "THD associate");
				fnCheckFieldDisplayById(RenowalkModules.USERS_USEREMAIL_LABEL_ID, "User Email label", true, true);
				fnCheckFieldDisplayByXpath(RenowalkModules.USERS_EMAIL_INPUT_XP, "User email input text box", true, true);
				fnCheckFieldDisplayById(RenowalkModules.USERS_FIRSTNAME_LABEL_ID, "First name label", true, true);
				fnCheckFieldDisplayByXpath(RenowalkModules.USERS_FIRSTNAME_INPUT_XP, "first name input text box", true, true);
				fnCheckFieldDisplayById(RenowalkModules.USERS_LASTNAME_LABEL_ID, "last name label", true, true);
				fnCheckFieldDisplayByXpath(RenowalkModules.USERS_LASTNAME_INPUT_XP, "last name input text box", true, true);
				fnCheckFieldDisplayById(RenowalkModules.USERS_SECURITYROLE_LABEL_ID, "Security role", true, true);				
				Select securityRole = new Select(driver.findElement(By.xpath(RenowalkModules.USERS_SECURITYROLE_COMBOBOX_XP)));
				List<WebElement> arrSecurityRole = securityRole.getOptions();
				HighlightElementByXpath(RenowalkModules.USERS_SECURITYROLE_COMBOBOX_XP);
				fnVerifyComboBoxValues(arrSecurityRole, 1, "App User");
				fnVerifyComboBoxValues(arrSecurityRole, 2, "Limited Reviewer");
				fnVerifyComboBoxValues(arrSecurityRole, 3, "Office Reviewer");
				fnVerifyComboBoxValues(arrSecurityRole, 4, "Office Admin");
				fnVerifyComboBoxValues(arrSecurityRole, 5, "Corporate Admin");
				
				fnCheckFieldDisplayByXpath(RenowalkModules.USERS_CORPORATION_LABEL_XP, "Corporations label", true, true);

				Select corporationValues = new Select(driver.findElement(By.xpath(RenowalkModules.USERS_CORPORATION_COMBOBOX_XP)));
				List<WebElement> arrCorporationValues = corporationValues.getOptions();
				
				HighlightElementByXpath(RenowalkModules.USERS_CORPORATION_COMBOBOX_XP);
				fnVerifyComboBoxValue(RenowalkModules.USERS_CORPORATION_COMBOBOX_XP, "AutoTestCorp");			
				fnCheckFieldDisplayById(RenowalkModules.USERS_OFFICENAME_LABEL_ID, "Office name label", true, true);				
				fnCheckFieldDisplayByName(RenowalkModules.USERS_OFFICES_BTN_NAME, "Offices button", true, true);
				fnCheckFieldDisplayById(RenowalkModules.USERS_PHONENUMBER_LABEL_ID, "Phone number label", true, true);
				fnCheckFieldDisplayByXpath(RenowalkModules.USERS_PHONENUMBER_INPUT_XP, "phone number input text box", true, true);
				verifyCheckBoxIsCheckedByXpath(RenowalkModules.USERS_ACTIVECHECKBOX_XP,"Active check box");	
				ClickById(RenowalkModules.USERS_CANCEL_BTN_ID, "Cancel button", true);
				
		
			} catch (Exception e) {
				e.printStackTrace();
				testCaseStatus = false;
				obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
						"Exception found in current test.", "Fail");
				log.error("Function TC41987 Failed!", e);
			} finally {

				if (!testCaseStatus) {
					Reporter.iTotalFail++;
				} else {
					Reporter.iTotalPass++;
				}
				log.info("Execution of Function TC41987 Completed");
			}
			return obj;
		} // End of function TC41987
	
	// Users_TC014_Verify_all_THDfields
	@SuppressWarnings("static-access")
	public Reporter TC41988(Reporter obj) throws Exception {

		log.info("Execution of Function TC41988 Started..");

		try {
			obj.repAddData("Verify all THD fields", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			fnLoadingPageWait();
			ClickByXpath(objRWModules.Users_GenOffice_LinkOfficesOption_xp, "Users Link", true);
			fnLoadingPageWait();
			ClickByXpath(RenowalkModules.Users_BtnAddItem_xp, "Add user button", true);
			fnLoadingPageWait();
			fnCheckFieldDisplayById(RenowalkModules.USERS_CANCEL_BTN_ID, "Cancel button", true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.USERS_DISABLED_SAVE_BTN_XP, "disabled save button", true, true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.USERS_THDASSOCIATE_CHECKBOX_XP, "THD associalte checkbox");
			fnCheckFieldDisplayById(RenowalkModules.USERS_LDAPID_LABEL_ID, "LDAP ID label", true,true);
			fnCheckFieldDisplayByXpath(RenowalkModules.USERS_LDAP_INPUT_XP, "LDAP ID input text box", true, true);
			fnCheckFieldDisplayById(RenowalkModules.USERS_FIRSTNAME_LABEL_ID, "First name label", true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.USERS_FIRSTNAME_READONLY_INPUT_XP, "First name read only box", true, true);
			fnCheckFieldDisplayById(RenowalkModules.USERS_LASTNAME_LABEL_ID, "last name label", true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.USERS_LASTNAME_READONLY_INPUT_XP, "First name read only box", true, true);
			fnCheckFieldDisplayById(RenowalkModules.USERS_SECURITYROLE_LABEL_ID, "Security role", true, true);
			
			Select securityRole = new Select(driver.findElement(By.xpath(RenowalkModules.USERS_SECURITYROLE_COMBOBOX_XP)));
			List<WebElement> arrSecurityRole = securityRole.getOptions();
			HighlightElementByXpath(RenowalkModules.USERS_SECURITYROLE_COMBOBOX_XP);
			fnVerifyComboBoxValues(arrSecurityRole, 1, "App User");
			fnVerifyComboBoxValues(arrSecurityRole, 2, "Limited Reviewer");
			fnVerifyComboBoxValues(arrSecurityRole, 3, "Office Reviewer");
			fnVerifyComboBoxValues(arrSecurityRole, 4, "Office Admin");
			fnVerifyComboBoxValues(arrSecurityRole, 5, "Corporate Admin");
			fnVerifyComboBoxValues(arrSecurityRole, 6, "Corporate PAR");

			fnCheckFieldDisplayByXpath(RenowalkModules.USERS_CORPORATION_LABEL_XP, "Corporations label", true, true);		
			HighlightElementByXpath(RenowalkModules.USERS_CORPORATION_COMBOBOX_XP);
			
			fnCheckFieldDisplayById(RenowalkModules.USERS_OFFICENAME_LABEL_ID, "Office name label", true, true);
			fnCheckFieldDisplayByName(RenowalkModules.USERS_OFFICES_BTN_NAME, "Offices button", true, true);		
			fnCheckFieldDisplayById(RenowalkModules.USERS_PHONENUMBER_LABEL_ID, "Phone number label", true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.USERS_PHONENUMBER_INPUT_XP, "phone number input text box", true,true);
			verifyCheckBoxIsCheckedByXpath(RenowalkModules.USERS_ACTIVECHECKBOX_XP, "Active check box");
			ClickById(RenowalkModules.USERS_CANCEL_BTN_ID, "Cancel button", true);
			fnVerifyDialogBox("LeaveCurrentPage", 1);
			

		} catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
					"Exception found in current test.", "Fail");
			log.error("Function TC41988 Failed!", e);
		} finally {

			if (!testCaseStatus) {
				Reporter.iTotalFail++;
			} else {
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC41988 Completed");
		}
		return obj;
	} // End of function TC41988
	
// Users_TC015_Create user-corporate admin
@SuppressWarnings("static-access")
public Reporter TC41989(Reporter obj) throws Exception {

	log.info("Execution of Function TC41989 Started..");

	try {		
		
		obj.repAddData("Verify Create  user-corporate admin", "", "", "");
		fnSelectCorpOffice(sCorporation, sOffice);
		fnLoadingPageWait();
		fnAddAndVerifyUser("Corporate Admin");				
		
	} catch (Exception e) {
		e.printStackTrace();
		testCaseStatus = false;
		obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
				"Exception found in current test.", "Fail");
		log.error("Function TC41989 Failed!", e);
	} finally {

		if (!testCaseStatus) {
			Reporter.iTotalFail++;
		} else {
			Reporter.iTotalPass++;
		}
		log.info("Execution of Function TC41989 Completed");
	}
	return obj;
} // End of function TC41989

//Users_TC016_Create user-Office admin
@SuppressWarnings("static-access")
public Reporter TC41990(Reporter obj) throws Exception {

	log.info("Execution of Function TC41990 Started..");

	try {
		
		obj.repAddData("Verify Create user-Office admin", "", "", "");
		fnSelectCorpOffice(sCorporation, sOffice);
		fnLoadingPageWait();
		fnAddAndVerifyUser("Office Admin");	
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
		testCaseStatus = false;
		obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
				"Exception found in current test.", "Fail");
		log.error("Function TC41990 Failed!", e);
	} finally {

		if (!testCaseStatus) {
			Reporter.iTotalFail++;
		} else {
			Reporter.iTotalPass++;
		}
		log.info("Execution of Function TC41990 Completed");
	}
	return obj;
} // End of function TC41990

//Users_TC016_Create_Office reviewer_user
@SuppressWarnings("static-access")
public Reporter TC41991(Reporter obj) throws Exception {

	log.info("Execution of Function TC41991 Started..");

	try {		
		int iRandomNumber=fnRandomNum(11111,99999);		
		obj.repAddData("Verify Create user-Office reviewer", "", "", "");
		fnSelectCorpOffice(sCorporation, sOffice);
		fnLoadingPageWait();
		fnAddAndVerifyUser("Office Reviewer");	
				
	} catch (Exception e) {
		e.printStackTrace();
		testCaseStatus = false;
		obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
				"Exception found in current test.", "Fail");
		log.error("Function TC41991 Failed!", e);
	} finally {

		if (!testCaseStatus) {
			Reporter.iTotalFail++;
		} else {
			Reporter.iTotalPass++;
		}
		log.info("Execution of Function TC41991 Completed");
	}
	return obj;
} // End of function TC41991

//Users_TC018_Edit User Corporate admin 
@SuppressWarnings("static-access")
public Reporter TC41992(Reporter obj) throws Exception {

	log.info("Execution of Function TC41992 Started..");

	try {	
			
		obj.repAddData("Edit user-corporate admin to Office admin", "", "", "");
		fnSelectCorpOffice(sCorporation, sOffice);
		fnLoadingPageWait();
		String sUserName = fnAddAndVerifyUser("Corporate Admin");
		fnLoadingPageWait();
		ClickByXpath(RenowalkModules.USERS_EDITUSER_XP.replace("autoUserName", sUserName), "User edit button", true);
		fnLoadingPageWait();
		fnSelectFromComboBoxXpath(RenowalkModules.USERS_SECURITYROLE_COMBOBOX_XP,"Office Admin");
		fnSelectFromComboBoxXpath(RenowalkModules.USERS_CORPORATION_COMBOBOX_XP, "AutoTestCorp");
		ClickByName(RenowalkModules.USERS_OFFICES_BTN_NAME, "Office dropdown", true);
		ClickByXpath(RenowalkModules.USERS_AUTOTESTOFFICE_FROM_COMBOBOX_XPATH, "Auto test office from dropdown", true);		
		ClickById(RenowalkModules.USERS_SAVE_BTN_ID, "Update button", true);
		fnVerifyDialogBox("Update",0);
		fnVerifyUser(sUserName);		
				
	} catch (Exception e) {
		e.printStackTrace();
		testCaseStatus = false;
		obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
				"Exception found in current test.", "Fail");
		log.error("Function TC41992 Failed!", e);
	} finally {

		if (!testCaseStatus) {
			Reporter.iTotalFail++;
		} else {
			Reporter.iTotalPass++;
		}
		log.info("Execution of Function TC41992 Completed");
	}
	return obj;
} // End of function TC41992

//Users_TC019_Edit user-Office admin to Office reviewer
@SuppressWarnings("static-access")
public Reporter TC41993(Reporter obj) throws Exception {

	log.info("Execution of Function TC41993 Started..");

	try {	
			
		obj.repAddData("Edit user-Office admin to Office reviewer", "", "", "");
		fnSelectCorpOffice(sCorporation, sOffice);
		fnLoadingPageWait();
		String sUserName = fnAddAndVerifyUser("Office Admin");
		fnLoadingPageWait();
		ClickByXpath(RenowalkModules.USERS_EDITUSER_XP.replace("autoUserName", sUserName), "User edit button", true);
		fnLoadingPageWait();
		fnSelectFromComboBoxXpath(RenowalkModules.USERS_SECURITYROLE_COMBOBOX_XP,"Office Reviewer");
		ClickById(RenowalkModules.USERS_SAVE_BTN_ID, "Update button", true);
		fnVerifyDialogBox("Update",0);
		fnVerifyUser(sUserName);		
				
	} catch (Exception e) {
		e.printStackTrace();
		testCaseStatus = false;
		obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
				"Exception found in current test.", "Fail");
		log.error("Function TC41993 Failed!", e);
	} finally {

		if (!testCaseStatus) {
			Reporter.iTotalFail++;
		} else {
			Reporter.iTotalPass++;
		}
		log.info("Execution of Function TC41993 Completed");
	}
	return obj;
} // End of function TC41993

//Users_TC020_Edit user Office reviewer to limited reviewer
@SuppressWarnings("static-access")
public Reporter TC41994(Reporter obj) throws Exception {

	log.info("Execution of Function TC41994 Started..");

	try {	
			
		obj.repAddData("Edit user Office reviewer to limited reviewer", "", "", "");
		fnSelectCorpOffice(sCorporation, sOffice);
		fnLoadingPageWait();
		String sUserName = fnAddAndVerifyUser("Office Reviewer");
		fnLoadingPageWait();
		ClickByXpath(RenowalkModules.USERS_EDITUSER_XP.replace("autoUserName", sUserName), "User edit button", true);
		fnLoadingPageWait();
		fnSelectFromComboBoxXpath(RenowalkModules.USERS_SECURITYROLE_COMBOBOX_XP,"Limited Reviewer");
		ClickById(RenowalkModules.USERS_SAVE_BTN_ID, "Update button", true);
		fnVerifyDialogBox("Update",0);
		fnVerifyUser(sUserName);		
				
	} catch (Exception e) {
		e.printStackTrace();
		testCaseStatus = false;
		obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
				"Exception found in current test.", "Fail");
		log.error("Function TC41994 Failed!", e);
	} finally {

		if (!testCaseStatus) {
			Reporter.iTotalFail++;
		} else {
			Reporter.iTotalPass++;
		}
		log.info("Execution of Function TC41994 Completed");
	}
	return obj;
} // End of function TC41994

//Users_TC021_Delete user Corporate admin
@SuppressWarnings("static-access")
public Reporter TC41995(Reporter obj) throws Exception {

	log.info("Execution of Function TC41995 Started..");

	try {	
			
		obj.repAddData("Delete user-Corporate admin (Create a new user-Corporate admin and delete the user)", "", "", "");
		fnSelectCorpOffice(sCorporation, sOffice);
		fnLoadingPageWait();
		String sUserName = fnAddAndVerifyUser("Corporate Admin");
		fnLoadingPageWait();
		ClickByXpath(RenowalkModules.USERS_DELETEUSER_XP.replace("userToBeDeleted", sUserName), "User delete button", true);
		fnLoadingPageWait();
		fnVerifyCancelForm(1);	
		fnVerifyDialogBox("Delete",0);		
		fnVerifyDeletedUser(sUserName);		
				
	} catch (Exception e) {
		e.printStackTrace();
		testCaseStatus = false;
		obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
				"Exception found in current test.", "Fail");
		log.error("Function TC41995 Failed!", e);
	} finally {

		if (!testCaseStatus) {
			Reporter.iTotalFail++;
		} else {
			Reporter.iTotalPass++;
		}
		log.info("Execution of Function TC41995 Completed");
	}
	return obj;
} // End of function TC41995

//Users_TC022_Verify user not deleted when clicks on no in delete user dialogue box
@SuppressWarnings("static-access")
public Reporter TC41996(Reporter obj) throws Exception {

	log.info("Execution of Function TC41996 Started..");

	try {	
			
		obj.repAddData("Verify user not deleted when clicks on no in delete user dialogue box", "", "", "");
		fnSelectCorpOffice(sCorporation, sOffice);
		fnLoadingPageWait();
		String sUserName = fnAddAndVerifyUser("Corporate Admin");
		fnLoadingPageWait();
		
		ClickByXpath(RenowalkModules.USERS_DELETEUSER_XP.replace("userToBeDeleted", sUserName), "User delete button", true);
		fnLoadingPageWait();
		fnVerifyCancelForm(2);			
		fnVerifyUser(sUserName);		
				
	} catch (Exception e) {
		e.printStackTrace();
		testCaseStatus = false;
		obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
				"Exception found in current test.", "Fail");
		log.error("Function TC41996 Failed!", e);
	} finally {

		if (!testCaseStatus) {
			Reporter.iTotalFail++;
		} else {
			Reporter.iTotalPass++;
		}
		log.info("Execution of Function TC41996 Completed");
	}
	return obj;
} // End of function TC41996



} // End of Class
