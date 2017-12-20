package com.homedepot.renowalk;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jboss.netty.util.internal.SystemPropertyUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.homedepot.renowalk.Common.BusinessFunctionLibrary;
import com.homedepot.renowalk.ConfigManager.FileLocSetter;
import com.homedepot.renowalk.ObjectRepository.RenowalkHome;
import com.homedepot.renowalk.ObjectRepository.RenowalkModules;
import com.homedepot.renowalk.ReportManager.Reporter;
import com.homedepot.renowalk.UtilManager.AppMessages;

public class Property extends TestDriver {
	RenowalkModules objRWModules = new RenowalkModules();
	RenowalkHome objRWHome = new RenowalkHome();
	AppMessages objAppMessages = new AppMessages();
	BusinessFunctionLibrary objBusinessFunctionLibrary = new BusinessFunctionLibrary();
	FileInputStream fileInput1;
	XSSFWorkbook wb1;
	XSSFSheet ws1;
	//RW-74_Property_TC001_View Property_View Property
	@SuppressWarnings("static-access")
	public Reporter TC31928(Reporter obj) throws Exception
	{
		Boolean bLoginFlag = false;	
		log.info("Execution of Function TC31928 Started..");
		

		try {
					
			obj.repAddData( "View Properties", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);			
			ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);
			
			fnLoadingPageWait();
			
			ClickByXpath(RenowalkModules.Common_BtnSorting_xp, "Sorting button", true);
			HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWModules.Common_ViewModules_Table_xp, "Property");
			
			fnCheckSortedList(mTableData,"Last Activity",7);
			
			fnCheckDateSorting(mTableData, "Last Activity", 7, "DEFAULT");

			ClickByXpath(RenowalkModules.Common_BtnSorting_xp, "Sorting button", true);
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
	

	//RW-74_Property_TC002_View Property_Property option without selecting office
	@SuppressWarnings("static-access")
	public Reporter TC31929(Reporter obj) throws Exception
	{
		Boolean bLoginFlag = false;	
		log.info("Execution of Function TC31929 Started..");
		

		try {
					
				obj.repAddData( "View Groups", "", "", "");
				
				fnSelectCorpOffice(sCorporation, sOffice);			
				ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);
				
				fnLoadingPageWait();
				
		}
		
		catch (Exception e) { 
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31929 Failed!", e );
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
			
			log.info("Execution of Function TC31929 Completed");
		}
		return obj;
	} //End of function TC31929
	
	//RW-74_Property_TC003_View Property_Verify Columns in view
	@SuppressWarnings("static-access")
	public Reporter TC31930(Reporter obj) throws Exception
	{
		Boolean bLoginFlag = false;	
		log.info("Execution of Function TC31930 Started..");


		try {

			obj.repAddData( "View Groups", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);			
			ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);

			fnLoadingPageWait();

			WebElement eleTable = driver.findElement(By.xpath(objRWModules.Common_ViewModules_Table_xp));
			List<WebElement> arrHeaderColumns = eleTable.findElements(By.xpath("./thead/tr/th"));  //Get the header
			System.out.println("Rows Size>>>>"+arrHeaderColumns.size());
			fnVerifyHeaders(arrHeaderColumns,0,"Status");
			fnVerifyHeaders(arrHeaderColumns,1,"Project name");
			fnVerifyHeaders(arrHeaderColumns,2,"Address");
			fnVerifyHeaders(arrHeaderColumns,3,"City");
			fnVerifyHeaders(arrHeaderColumns,4,"County");
			fnVerifyHeaders(arrHeaderColumns,5,"Assigned User");
			fnVerifyHeaders(arrHeaderColumns,6,"Last Activity");
		}

		catch (Exception e) { 
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31930 Failed!", e );
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

			log.info("Execution of Function TC31930 Completed");
		}
		return obj;
	} //End of function TC31930
	
	//RW-74_Property_TC004_View Property_Check default Options in Properties column
	@SuppressWarnings("static-access")
	public Reporter TC31931(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31931 Started..");

		try {

			obj.repAddData( "Availability of ADD PROPERTY form", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);

			fnLoadingPageWait();

			fnCheckFieldDisplayByXpath(RenowalkModules.Property_ViewOffice_BtnAddProperty_xp,"'ADD PROPERTY' button",true,true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_SearchProperty_PropertyStatusSelect_xp,"'FILTER STATUS' button",true,true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_ViewProperty_BulkDeleteCheckBx_xp,"'BULK DELETE' button",true,true);
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31931 Failed!", e );
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
			log.info("Execution of Function TC31931 Completed");
		}
		return obj;
	} //End of function TC31931	
	
	
	//RW-74_Property_TC005_View Property_Check default value above Properties table
	@SuppressWarnings("static-access")
	public Reporter TC31932(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31932 Started..");

		try {

			obj.repAddData( "View Property_Check default value above Properties table", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);

			fnLoadingPageWait();

			Select selectStatus = new Select(driver.findElement(By.xpath(objRWModules.Property_SearchProperty_PropertyStatusSelect_xp)));
			List<WebElement> arrStatusSearch = selectStatus.getOptions();
			HighlightElementByXpath(objRWModules.Property_SearchProperty_PropertyStatusSelect_xp);

			fnVerifyComboBoxValues(arrStatusSearch, 0, "Select Status");
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31932 Failed!", e );
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
			log.info("Execution of Function TC31932 Completed");
		}
		return obj;
	} //End of function TC31932	
	
	//RW-74_Property_TC006_View Property_Verify search box above Properties table
	@SuppressWarnings("static-access")
	public Reporter TC31933(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31933 Started..");

		try {

			obj.repAddData( "View Property_Verify search box above Properties table", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);

			fnLoadingPageWait();
			
			fnCheckFieldDisplayById(RenowalkModules.Property_ViewProperty_id,"'View Property' button",true,true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_SearchProperty_PropertySearchInput_xp,"Property Search",true,true);
						
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31933 Failed!", e );
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
			log.info("Execution of Function TC31933 Completed");
		}
		return obj;
	} //End of function TC31933
	
	//RW-74_Property_TC007_View Property_Verify Sort (Up and Down) icon is available
	@SuppressWarnings("static-access")
	public Reporter TC31934(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31934 Started..");

		try {

			obj.repAddData( "View Property_Verify Sort (Up and Down) icon is available", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);

			fnLoadingPageWait();
			fnCheckFieldDisplayByXpath(RenowalkModules.Common_BtnSorting_County_xp,"Property Search",true,true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Common_BtnSorting_LastActivity_xp,"Property Search",true,true);

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31934 Failed!", e );
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
			log.info("Execution of Function TC31934 Completed");
		}
		return obj;
	} //End of function TC31934
	
	
	//RW-74_Property_TC008_View Property_Verify Sort (Up and Down) is available on county
	@SuppressWarnings("static-access")
	public Reporter TC31935(Reporter obj) throws Exception
	{
		Boolean bLoginFlag = false;	
		log.info("Execution of Function TC31935 Started..");


		try {

			obj.repAddData( "View Property_Verify Sort (Up and Down) is available on county", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);			
			ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);

			fnLoadingPageWait();

			ClickByXpath(RenowalkModules.Common_BtnSorting_County_xp, "Sorting button", true);
			HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWModules.Common_ViewModules_Table_xp, "Property");

			fnCheckSortedList(mTableData,"County",5);


			ClickByXpath(RenowalkModules.Common_BtnSorting_xp, "Sorting button", true);
			////////////////////Sorting Logic End////////////////////////////

		}

		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31935 Failed!", e );
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

			log.info("Execution of Function TC31935 Completed");
		}
		return obj;
	} //End of function TC31935
	
	
	//RW-74_Property_TC009_View Property_Verify Sort (Up and Down) is available on Last Activity column
	@SuppressWarnings("static-access")
	public Reporter TC31936(Reporter obj) throws Exception
	{
		Boolean bLoginFlag = false;	
		log.info("Execution of Function TC31936 Started..");


		try {

			obj.repAddData( "View Property_Verify Sort (Up and Down) is available on Last Activity column", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);			
			ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);

			fnLoadingPageWait();

			ClickByXpath(RenowalkModules.Common_BtnSorting_xp, "Sorting button", true);
			HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWModules.Common_ViewModules_Table_xp, "Property");
			fnCheckDateSorting(mTableData, "Last Activity", 7, "DEFAULT");
			
			ClickByXpath(RenowalkModules.Common_BtnSorting_xp, "Sorting button", true);
			fnCheckDateSorting(mTableData,"Last Activity",7, "DESC");
			
			

			ClickByXpath(RenowalkModules.Common_BtnSorting_xp, "Sorting button", true);
			////////////////////Sorting Logic End////////////////////////////

		}

		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31936 Failed!", e );
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

			log.info("Execution of Function TC31936 Completed");
		}
		return obj;
	} //End of function TC31936
	
	
	//RW-74_Property_TC010_View Property_View Update Property option
	@SuppressWarnings("static-access")
	public Reporter TC31937(Reporter obj) throws Exception
	{
		Boolean bLoginFlag = false;	
		log.info("Execution of Function TC31937 Started..");


		try {

			obj.repAddData( "View Property_View Update Property option", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);			
			ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);

			fnLoadingPageWait();
			
			ClickByXpath(objRWModules.Property_SearchProperty_FirstProjectName_xp, "First Project Name", true);
			HighlightElementByXpath(objRWModules.Property_EditProperty_CommonTable_xp);
			ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);

		}

		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31937 Failed!", e );
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

			log.info("Execution of Function TC31937 Completed");
		}
		return obj;
	} //End of function TC31937
		
	
	//RW-74_Property_TC011_View Property_Verify no office no message in the table
	@SuppressWarnings("static-access")
	public Reporter TC31938(Reporter obj) throws Exception
	{
		Boolean bLoginFlag = false;	
		log.info("Execution of Function TC31938 Started..");


		try {

			obj.repAddData( "Verify no office no message in the table", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);			
			ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);

			fnLoadingPageWait();

		}

		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31938 Failed!", e );
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

			log.info("Execution of Function TC31938 Completed");
		}
		return obj;
	} //End of function TC31938
	
	
	//RW-74_Property_TC012_View Property_Verify table heading displayed by default
	@SuppressWarnings("static-access")
	public Reporter TC31939(Reporter obj) throws Exception
	{
		Boolean bLoginFlag = false;	
		log.info("Execution of Function TC31939 Started..");


		try {

			obj.repAddData( "Verify table heading displayed by default", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);			
			ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);

			fnLoadingPageWait();
			fnCheckFieldDisplayByXpath(objRWModules.Offices_ViewProperty_LabelCurrentProperties_xp, "Properties Title", true, true);
			
		}

		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31939 Failed!", e );
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

			log.info("Execution of Function TC31939 Completed");
		}
		return obj;
	} //End of function TC31939
	
	
	//RW-74_Property_TC013_View Property_Verify view loading icon
	@SuppressWarnings("static-access")
	public Reporter TC31940(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31940 Started..");

		try {

			obj.repAddData( "Verify loading icon", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);

			fnLoadingPageWait();

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31940 Failed!", e );
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
			log.info("Execution of Function TC31940 Completed");
		}
		return obj;
	} //End of function TC31940	
	
	//RW-74_Property_TC014_View Property_Availability of Pagination options
	@SuppressWarnings("static-access")
	public Reporter TC31941(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31941 Started..");

		try {

			obj.repAddData( "Availability of Pagination Options", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);
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
			log.error( "Function TC31941 Failed!", e );
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
			log.info("Execution of Function TC31941 Completed");
		}
		return obj;
	} //End of function TC31941
	
	//RW-74_Property_TC015_View Property_Validate Properties table using pagination option
	@SuppressWarnings("static-access")
	public Reporter TC31942(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31942 Started..");

		try {

			obj.repAddData( "Properties Table Records for VIEW ALL Option", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();
			Select select = new Select(driver.findElement(By.xpath(objRWModules.Common_ViewModules_ComboPageSize_xp)));
			List<WebElement> arrPageSize = select.getOptions();
			System.out.println("Page Combobox Size>>>>"+arrPageSize.size());

			fnVerifyComboBoxValues(arrPageSize, 0, "10 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 1, "20 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 2, "VIEW ALL");
			obj.repAddData("Select option 'VIEW ALL'", "", "", "");
			select.selectByVisibleText("VIEW ALL");

			fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_BtnPreviousLink_xp,"'Previous' button",true,false);
			fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_BtnNextLink_xp,"'Next' button",true,false);
			Thread.sleep(5000);
			fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",true,false);
			fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_LabelTotalPages_xp, "Total No of Pages", true,false);

			WebElement eleTable = driver.findElement(By.xpath(RenowalkModules.Common_ViewModules_Table_xp));
			List<WebElement> arrTableRows = eleTable.findElements(By.xpath("./tbody/tr"));  //Get the table data rows
			System.out.println("Data Rows Size>>>>"+arrTableRows.size());


			//Write DB code here

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31942 Failed!", e );
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
			log.info("Execution of Function TC31942 Completed");
		}
		return obj;
	} //End of function TC31942
	
	//RW-74_Property_TC016_View Property_Validate Pagination for option 10 for current page
	@SuppressWarnings("static-access")
	public Reporter TC31943(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31943 Started..");

		try {

			obj.repAddData("Validate Pagination for Option 10", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			boolean bElementFound = fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",false,true);
			int iRows = fnGetTableRowsCount(objRWModules.Common_ViewModules_Table_xp);

			Select select = new Select(driver.findElement(By.xpath(objRWModules.Common_ViewModules_ComboPageSize_xp)));
			List<WebElement> arrPageSize = select.getOptions();
			System.out.println("Page Combobox Size>>>>"+arrPageSize.size());

			fnVerifyComboBoxValues(arrPageSize, 0, "10 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 1, "20 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 2, "VIEW ALL");
			obj.repAddData("Select option '10 PER PAGE'", "", "", "");
			select.selectByVisibleText("10 PER PAGE");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			fnVerifyNumofRecords("10");


			if(bElementFound==true || iRows>10)
			{
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_BtnPreviousLink_xp,"'Previous' button",true,true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_BtnNextLink_xp,"'Next' button",true,true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",true,true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_LabelTotalPages_xp, "Total No of Pages", true,true);
			}
			else
			{
				obj.repAddData( "Verify Pagination", "Pagination for any page with option 10 should be validated", "Pagination for any page with option 10 cannot be validated as no of records are less than 10", "Pass");
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31943 Failed!", e );
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
			log.info("Execution of Function TC31943 Completed");
		}
		return obj;
	} //End of function TC31943	


	//RW-74_Property_TC017_View Property_Validate Pagination for option 10 for all the pages
	@SuppressWarnings("static-access")
	public Reporter TC31944(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31944 Started..");

		try {

			obj.repAddData("Validate pagination for any page with option 10", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();
			Select select = new Select(driver.findElement(By.xpath(objRWModules.Common_ViewModules_ComboPageSize_xp)));
			List<WebElement> arrPageSize = select.getOptions();
			System.out.println("Page Combobox Size>>>>"+arrPageSize.size());

			fnVerifyComboBoxValues(arrPageSize, 0, "10 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 1, "20 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 2, "VIEW ALL");
			obj.repAddData("Select option '10 PER PAGE'", "", "", "");
			select.selectByVisibleText("10 PER PAGE");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			fnVerifyNumofRecords("10");

			boolean bElementFound = fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",false,true);
			int iRows = fnGetTableRowsCount(objRWModules.Common_ViewModules_Table_xp);

			if(bElementFound==true || iRows>10)
			{
				String sTotalPageNum = driver.findElement(By.xpath(RenowalkModules.Common_ViewModules_LabelTotalPages_xp)).getText();
				int iTotalPageNum =  Integer.parseInt(sTotalPageNum);
				iTotalPageNum = iTotalPageNum -1;
				SendKeyByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp, String.valueOf(iTotalPageNum), "Page Number");
			}
			else
			{
				obj.repAddData( "Validate Pagination for any page with option 10", "Pagination for any page with option 10 should be validated", "Pagination for any page with option 10 cannot be validated as no of records are less than 10", "Pass");
			}

			fnVerifyNumofRecords("10");

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31944 Failed!", e );
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
			log.info("Execution of Function TC31944 Completed");
		}
		return obj;
	} //End of function TC31944	
	
	//RW-74_Property_TC018_View Property_Validate Pagination for any page with option 10
	@SuppressWarnings("static-access")
	public Reporter TC31945(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31945 Started..");

		try {

			obj.repAddData("Validate pagination for any page with option 10", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			Select select = new Select(driver.findElement(By.xpath(objRWModules.Common_ViewModules_ComboPageSize_xp)));
			List<WebElement> arrPageSize = select.getOptions();
			System.out.println("Page Combobox Size>>>>"+arrPageSize.size());

			fnVerifyComboBoxValues(arrPageSize, 0, "10 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 1, "20 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 2, "VIEW ALL");
			obj.repAddData("Select option '10 PER PAGE'", "", "", "");
			select.selectByVisibleText("10 PER PAGE");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			fnVerifyNumofRecords("10");

			boolean bElementFound = fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",false,true);
			int iRows = fnGetTableRowsCount(objRWModules.Common_ViewModules_Table_xp);

			if(bElementFound==true || iRows>10)
			{
				String sTotalPageNum = driver.findElement(By.xpath(RenowalkModules.Common_ViewModules_LabelTotalPages_xp)).getText();
				int iTotalPageNum =  Integer.parseInt(sTotalPageNum);
				iTotalPageNum = iTotalPageNum -1;
				SendKeyByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp, String.valueOf(iTotalPageNum), "Page Number");
			}
			else
			{
				obj.repAddData( "Validate Pagination for any page with option 10", "Pagination for any page with option 10 should be validated", "Pagination for any page with option 10 cannot be validated as no of records are less than 10", "Pass");
			}

			fnVerifyNumofRecords("10");

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31945 Failed!", e );
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
			log.info("Execution of Function TC31945 Completed");
		}
		return obj;
	} //End of function TC31945
	
	
	//RW-74_Property_TC019_View Property_Validate Pagination for option 20 for current page
	@SuppressWarnings("static-access")
	public Reporter TC31946(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31946 Started..");

		try {

			obj.repAddData("Validate Pagination for Option 20", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			boolean bElementFound = fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",false,true);
			int iRows = fnGetTableRowsCount(objRWModules.Common_ViewModules_Table_xp);

			Select select = new Select(driver.findElement(By.xpath(objRWModules.Common_ViewModules_ComboPageSize_xp)));
			List<WebElement> arrPageSize = select.getOptions();
			System.out.println("Page Combobox Size>>>>"+arrPageSize.size());

			fnVerifyComboBoxValues(arrPageSize, 0, "10 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 1, "20 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 2, "VIEW ALL");
			obj.repAddData("Select option '20 PER PAGE'", "", "", "");
			select.selectByVisibleText("20 PER PAGE");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			fnVerifyNumofRecords("20");


			if(bElementFound==true || iRows>10)
			{
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_BtnPreviousLink_xp,"'Previous' button",true,true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_BtnNextLink_xp,"'Next' button",true,true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",true,true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_LabelTotalPages_xp, "Total No of Pages", true,true);
			}
			else
			{
				obj.repAddData( "Verify Pagination", "Pagination for any page with option 20 should be validated", "Pagination for any page with option 20 cannot be validated as no of records are less than 20", "Pass");
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31946 Failed!", e );
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
			log.info("Execution of Function TC31946 Completed");
		}
		return obj;
	} //End of function TC31946	


	//RW-74_Property_TC020_View Property_Validate Pagination for option 20 for all the pages
	@SuppressWarnings("static-access")
	public Reporter TC31947(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31947 Started..");

		try {

			obj.repAddData("Validate pagination for any page with option 20", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			Select select = new Select(driver.findElement(By.xpath(objRWModules.Common_ViewModules_ComboPageSize_xp)));
			List<WebElement> arrPageSize = select.getOptions();
			System.out.println("Page Combobox Size>>>>"+arrPageSize.size());

			fnVerifyComboBoxValues(arrPageSize, 0, "10 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 1, "20 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 2, "VIEW ALL");
			obj.repAddData("Select option '20 PER PAGE'", "", "", "");
			select.selectByVisibleText("20 PER PAGE");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			fnVerifyNumofRecords("20");

			boolean bElementFound = fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",false,true);
			int iRows = fnGetTableRowsCount(objRWModules.Common_ViewModules_Table_xp);
			if(bElementFound==true || iRows>10)
			{
				String sTotalPageNum = driver.findElement(By.xpath(RenowalkModules.Common_ViewModules_LabelTotalPages_xp)).getText();
				int iTotalPageNum =  Integer.parseInt(sTotalPageNum);
				iTotalPageNum = iTotalPageNum -1;
				SendKeyByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp, String.valueOf(iTotalPageNum), "Page Number");
			}
			else
			{
				obj.repAddData( "Validate Pagination for any page with option 20", "Pagination for any page with option 20 should be validated", "Pagination for any page with option 20 cannot be validated as no of records are less than 20", "Pass");
			}

			fnVerifyNumofRecords("20");

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31947 Failed!", e );
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
			log.info("Execution of Function TC31947 Completed");
		}
		return obj;
	} //End of function TC31947	
	
	//RW-74_Property_TC021_View Property_Validate Pagination for any page with option 20
	@SuppressWarnings("static-access")
	public Reporter TC31948(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31948 Started..");

		try {

			obj.repAddData("Validate Pagination for any page with option 20", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			Select select = new Select(driver.findElement(By.xpath(objRWModules.Common_ViewModules_ComboPageSize_xp)));
			List<WebElement> arrPageSize = select.getOptions();
			System.out.println("Page Combobox Size>>>>"+arrPageSize.size());

			fnVerifyComboBoxValues(arrPageSize, 0, "10 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 1, "20 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 2, "VIEW ALL");
			obj.repAddData("Select option '20 PER PAGE'", "", "", "");
			select.selectByVisibleText("20 PER PAGE");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			fnVerifyNumofRecords("20");

			boolean bElementFound = fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",false,true);
			int iRows = fnGetTableRowsCount(objRWModules.Common_ViewModules_Table_xp);
			if(bElementFound==true || iRows>10)
			{
				String sTotalPageNum = driver.findElement(By.xpath(RenowalkModules.Common_ViewModules_LabelTotalPages_xp)).getText();
				int iTotalPageNum =  Integer.parseInt(sTotalPageNum);
				iTotalPageNum = iTotalPageNum -1;
				SendKeyByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp, String.valueOf(iTotalPageNum), "Page Number");
			}
			else
			{
				obj.repAddData( "Validate Pagination for any page with option 20", "Pagination for any page with option 20 should be validated", "Pagination for any page with option 20 cannot be validated as no of records are less than 20", "Pass");
			}

			fnVerifyNumofRecords("20");

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31948 Failed!", e );
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
			log.info("Execution of Function TC31948 Completed");
		}
		return obj;
	} //End of function TC31948
	
	
	//RW-74_Property_TC022_View Property_Validate for Page Counter and Navigation
	@SuppressWarnings("static-access")
	public Reporter TC31949(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31949 Started..");

		try {

			obj.repAddData("Validate Page Counter and Navigation", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			boolean bElementFound = fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",false,true);
			int iRows = fnGetTableRowsCount(objRWModules.Common_ViewModules_Table_xp);

			Select select = new Select(driver.findElement(By.xpath(objRWModules.Common_ViewModules_ComboPageSize_xp)));
			List<WebElement> arrPageSize = select.getOptions();
			System.out.println("Page Combobox Size>>>>"+arrPageSize.size());

			fnVerifyComboBoxValues(arrPageSize, 0, "10 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 1, "20 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 2, "VIEW ALL");
			obj.repAddData("Select option 'VIEW ALL'", "", "", "");
			select.selectByVisibleText("VIEW ALL");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_BtnPreviousLink_xp,"'Previous' button",true,false);
			fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_BtnNextLink_xp,"'Next' button",true,false);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(5000);
			fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",true,false);
			fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_LabelTotalPages_xp, "Total No of Pages", true,false);

			obj.repAddData("Select option '10 PER PAGE'", "", "", "");
			select.selectByVisibleText("10 PER PAGE");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			if(bElementFound==true || iRows>10)
			{
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_BtnPreviousLink_xp,"'Previous' button",true,true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_BtnNextLink_xp,"'Next' button",true,true);
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				Thread.sleep(5000);
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",true,true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_LabelTotalPages_xp, "Total No of Pages", true,true);
			}
			else
			{
				obj.repAddData( "Verify Pagination", "Pagination for any page with option '10 PER PAGE' should be validated", "Pagination with option '10 PER PAGE' cannot be validated as no of records are less than 10", "Pass");
			}


		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31949 Failed!", e );
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
			log.info("Execution of Function TC31949 Completed");
		}
		return obj;
	} //End of function TC31949	
	
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
			fnVerifyCancelForm(1);

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
			fnVerifyCancelForm(1);

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

			String sYearsBuiltGreaterThanCurrentYear = "2017";
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
			fnVerifyCancelForm(1);

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
			//sWalkAssigned.selectByIndex(1);

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
			fnVerifyCancelForm(1);
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
			fnVerifyCancelForm(1); 
			
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
			fnVerifyCancelForm(1);

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
			fnVerifyCancelForm(1);

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
			fnVerifyCancelForm(1);

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
			fnVerifyCancelForm(1);

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
			fnVerifyCancelForm(1);

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
	
	public Reporter TC31965(Reporter obj) throws Exception {
		log.info("Execution of Function TC31965 Started..");

		try {

			
			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();
			
			HighlightElementByXpath(objRWModules.Property_SearchProperty_PropertyStatusSelect_xp);
			
			Select propertyStatus = new Select(driver.findElement(By.xpath(objRWModules.Property_SearchProperty_PropertyStatusSelect_xp)));
			propertyStatus.selectByIndex(1);
					
						
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
			log.error( "Function TC31965 Failed!", e );
		}
		return obj;
	}
	
	
	//RW-76_Property_TC003_View Property Search Criteria_Conditional Search
	public Reporter TC31966(Reporter obj) throws Exception {
		log.info("Execution of Function TC31966 Started..");

		try {
			
			obj.repAddData( "View Property Search Criteria_Conditional Search", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			String searchProjectName = driver.findElement(By.xpath(objRWModules.Property_SearchProperty_FirstProjectName_xp)).getText();
			driver.findElement(By.xpath(objRWModules.Property_SearchProperty_PropertySearchInput_xp)).sendKeys(searchProjectName);
			
			HighlightElementByXpath(objRWModules.Property_SearchProperty_FirstProjectName_xp);


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
			log.error( "Function TC31966 Failed!", e );
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
			
			WebElement eleTable = driver.findElement(By.xpath(objRWModules.Common_ViewModules_Table_xp));
			List<WebElement> arrHeaderColumns = eleTable.findElements(By.xpath("./thead/tr/th"));  //Get the header
			System.out.println("Rows Size>>>>"+arrHeaderColumns.size());
			fnVerifyHeaders(arrHeaderColumns,0,"Status");
			fnVerifyHeaders(arrHeaderColumns,1,"Project name");
			fnVerifyHeaders(arrHeaderColumns,2,"Address");
			fnVerifyHeaders(arrHeaderColumns,3,"City");
			fnVerifyHeaders(arrHeaderColumns,4,"County");
			fnVerifyHeaders(arrHeaderColumns,5,"Assigned User");
			fnVerifyHeaders(arrHeaderColumns,6,"Last Activity");
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
	
	//RW-76_Property_TC005_View Property Search Criteria_Verify Applicable Select filter or Selected Value present
	public Reporter TC31968(Reporter obj) throws Exception {
		log.info("Execution of Function TC31968 Started..");

		try {

			obj.repAddData( "View Property Search Criteria_Conditional Search", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);


			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();

			String searchProjectName = driver.findElement(By.xpath(objRWModules.Property_SearchProperty_FirstProjectName_xp)).getText();
			driver.findElement(By.xpath(objRWModules.Property_SearchProperty_PropertySearchInput_xp)).sendKeys(searchProjectName);

			HighlightElementByXpath(objRWModules.Property_SearchProperty_FirstProjectName_xp);

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
			log.error( "Function TC31968 Failed!", e );
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
	
	
	//RW-76_Property_TC009_View Property Search Criteria_Availability of Bulk Delete
	public Reporter TC31972(Reporter obj) throws Exception {
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31972 Started..");

		try {

			obj.repAddData( "View Property Search Criteria_Availability of Bulk Delete", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			
			
			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			ClickByXpath(objRWModules.Property_SearchProperty_FirstCheckBox_xp, "First Check Box",true);
			
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
			
			fnCheckFieldDisplayByXpath(RenowalkModules.Common_BtnSorting_County_xp, "County Sort Button", true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Common_BtnSorting_LastActivity_xp, "Last Activity Sort Button", true, true);
			
			
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
	
	//RW-76_Property_TC013_View Property Search Criteria_Verify clicking sort on County sorts by this column Up- descending Down- ascending
	@SuppressWarnings("static-access")
	public Reporter TC31976(Reporter obj) throws Exception
	{
		Boolean bLoginFlag = false;	
		log.info("Execution of Function TC31976 Started..");


		try {

			obj.repAddData( "Verify clicking sort on County sorts by this column Up- descending Down- ascending", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);			
			ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);

			fnLoadingPageWait();

			ClickByXpath(RenowalkModules.Common_BtnSorting_County_xp, "Sorting button", true);
			HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWModules.Common_ViewModules_Table_xp, "Property");

			fnCheckSortedList(mTableData,"County",5);


			ClickByXpath(RenowalkModules.Common_BtnSorting_xp, "Sorting button", true);
			////////////////////Sorting Logic End////////////////////////////

		}

		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31976 Failed!", e );
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

			log.info("Execution of Function TC31976 Completed");
		}
		return obj;
	} //End of function TC31976


	//RW-76_Property_TC014_View Property Search Criteria_Verify clicking sort on Last Activity sorts by this column Up- descending Down- ascending
	@SuppressWarnings("static-access")
	public Reporter TC31977(Reporter obj) throws Exception
	{
		Boolean bLoginFlag = false;	
		log.info("Execution of Function TC31977 Started..");


		try {

			obj.repAddData( "View Property Search Criteria_Verify clicking sort on Last Activity sorts by this column Up- descending Down- ascending", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);			
			ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);

			fnLoadingPageWait();

			ClickByXpath(RenowalkModules.Common_BtnSorting_xp, "Sorting button", true);
			HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWModules.Common_ViewModules_Table_xp, "Property");
			fnCheckDateSorting(mTableData, "Last Activity", 7, "DEFAULT");
			
			ClickByXpath(RenowalkModules.Common_BtnSorting_xp, "Sorting button", true);
			fnCheckDateSorting(mTableData,"Last Activity",7, "DESC");

			

			ClickByXpath(RenowalkModules.Common_BtnSorting_xp, "Sorting button", true);
			////////////////////Sorting Logic End////////////////////////////

		}

		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31977 Failed!", e );
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

			log.info("Execution of Function TC31977 Completed");
		}
		return obj;
	} //End of function TC31977
	
	//RW-76_Property_TC015_View Property Search Criteria_Verify Project Name in bold font and clickable
	@SuppressWarnings("static-access")
	public Reporter TC31978(Reporter obj) throws Exception
	{
		Boolean bLoginFlag = false;	
		log.info("Execution of Function TC31978 Started..");


		try {

			obj.repAddData( "View Property Search Criteria_Verify Project Name in bold font and clickable", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);			
			ClickByXpath(objRWModules.Property_GenProp_LinkPropertyOption_xp, "Property Link",true);

			fnLoadingPageWait();

			ClickByXpath(RenowalkModules.Property_SearchProperty_FirstProjectName_xp, "First Property", true);
			
			ClickByXpath(objRWModules.Property_AddProperty_BtnCancel_xp, "Cancel button",false);  //post condition

		}

		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31978 Failed!", e );
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

			log.info("Execution of Function TC31978 Completed");
		}
		return obj;
	} //End of function TC31978

	
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
	//Propery_TC001_AddAndVerifyWalkAssignedProperty
	public Reporter TC41997(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC41997 Started..");
		try {
			obj.repAddData( "Add and verify a property which is assigned not walked", "", "", "");
			 fnSelectCorpOffice(sCorporation, sOffice);
			 fnLoadingPageWait();
			//creates assigned not walked property
			String propertyName= objBusinessFunctionLibrary.fnaddAndVerifyProperty("xx");
			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();
			SendKeyByXpath(RenowalkModules.Property_SearchProperty_PropertySearchInput_xp, propertyName, "Property name");
			ClickByXpath(RenowalkModules.Property_SearchProperty_PropertySearchButton_xp, "Search button", true);
			fnLoadingPageWait();			
			ClickByXpath(RenowalkModules.Property_clickProperty_XP.replace("propertNameToBeclicked", propertyName), "Property name", true);
			fnLoadingPageWait();			
			String sAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Address").toString().trim();
			String sCity = mTestPhaseData.get(TestDriver.iTC_ID).get("City").toString().trim();
			String sState = mTestPhaseData.get(TestDriver.iTC_ID).get("State").toString().trim();
			String sZipCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Zip").toString().trim();			
			String expectedAddress=propertyName+" "+sAddress+", "+sCity+", "+sState+" "+sZipCode;
			System.out.println("Expected address :"+expectedAddress);			
			String actProjectName=driver.findElement(By.xpath(RenowalkModules.Property_VerifyAddress_ProjectName_xp)).getText();
			HighlightElementByXpath(RenowalkModules.Property_VerifyAddress_ProjectName_xp);
			String actAddress=driver.findElement(By.xpath(RenowalkModules.Property_VerifyAddress_xp)).getText();
			HighlightElementByXpath(RenowalkModules.Property_VerifyAddress_xp);
			String actCity=driver.findElement(By.xpath(RenowalkModules.Property_VerifyCity_xp)).getText();
			HighlightElementByXpath(RenowalkModules.Property_VerifyCity_xp);
			String actState=driver.findElement(By.xpath(RenowalkModules.Property_VerifyState_xp)).getText();
			HighlightElementByXpath(RenowalkModules.Property_VerifyState_xp);
			String actZip=driver.findElement(By.xpath(RenowalkModules.Property_VerifyZipcode_xp)).getText();
			HighlightElementByXpath(RenowalkModules.Property_VerifyZipcode_xp);
			String actualAddress= actProjectName+" "+actAddress+", "+actCity+", "+actState+" "+actZip;
			System.out.println("Actual address :"+actualAddress);			
		//	Assert.assertEquals(expectedAddress, actualAddress);	
			if(expectedAddress.equalsIgnoreCase(actualAddress)) {
				obj.repAddData("Verify Project name, Address, City, State and Zip ", "Verified Project name, Address, City, State and Zip ", "Verified Address",
						"Pass");				
			}
			else{
				obj.repAddData("Verify Project name, Address, City, State and Zip ", "Not Verified Project name, Address, City, State and Zip ", "Address not Verified",
						"Fail");				
			}			
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_PropertyTab_xp, "Additional information tab",true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_AdditionalInformation_xp, "Additional information tab",true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_PropertyWalk_xp, "Property walk tab", true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_Budget_xp, "Budget tab", true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_ProjectTools_xp, "Project tools", true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_ActivityLog_xp, "Activity log tab", true, true);			
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
			log.error( "Function TC41997 Failed!", e );
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
			log.info("Execution of Function TC41997 Completed");
		}
		return obj;
	}
	
	//Propery_TC002_AddAndVerifyNotAssignedProperty
	public Reporter TC41998(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC41998 Started..");

		try {
			obj.repAddData( "Add and verify a property which is assigned not walked", "", "", "");
			 fnSelectCorpOffice(sCorporation, sOffice);
			 fnLoadingPageWait();
			//creates not assigned
			String propertyName= objBusinessFunctionLibrary.fnaddAndVerifyProperty("");
			ClickByXpath(objRWModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link",true);
			fnLoadingPageWait();
			SendKeyByXpath(RenowalkModules.Property_SearchProperty_PropertySearchInput_xp, propertyName, "Property name");
			ClickByXpath(RenowalkModules.Property_SearchProperty_PropertySearchButton_xp, "Search button", true);
			fnLoadingPageWait();
			
			ClickByXpath(RenowalkModules.Property_clickProperty_XP.replace("propertNameToBeclicked", propertyName), "Property name", true);
			fnLoadingPageWait();					
			String sAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Address").toString().trim();
			String sCity = mTestPhaseData.get(TestDriver.iTC_ID).get("City").toString().trim();
			String sState = mTestPhaseData.get(TestDriver.iTC_ID).get("State").toString().trim();
			String sZipCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Zip").toString().trim();			
			String expectedAddress=propertyName+" "+sAddress+", "+sCity+", "+sState+" "+sZipCode;
			System.out.println("Expected address :"+expectedAddress);
			//for concatinating actual address
			String actProjectName=driver.findElement(By.xpath(RenowalkModules.Property_VerifyAddress_ProjectName_xp)).getText();
			HighlightElementByXpath(RenowalkModules.Property_VerifyAddress_ProjectName_xp);			
			String actAddress=driver.findElement(By.xpath(RenowalkModules.Property_VerifyAddress_xp)).getText();
			HighlightElementByXpath(RenowalkModules.Property_VerifyAddress_xp);
			String actCity=driver.findElement(By.xpath(RenowalkModules.Property_VerifyCity_xp)).getText();
			HighlightElementByXpath(RenowalkModules.Property_VerifyCity_xp);
			String actState=driver.findElement(By.xpath(RenowalkModules.Property_VerifyState_xp)).getText();
			HighlightElementByXpath(RenowalkModules.Property_VerifyState_xp);
			String actZip=driver.findElement(By.xpath(RenowalkModules.Property_VerifyZipcode_xp)).getText();			
			HighlightElementByXpath(RenowalkModules.Property_VerifyZipcode_xp);		
			String actualAddress= actProjectName+" "+actAddress+", "+actCity+", "+actState+" "+actZip;
			System.out.println("Actual address :"+actualAddress);				
		//	Assert.assertEquals(expectedAddress, actualAddress);
			if(expectedAddress.equalsIgnoreCase(actualAddress)) {
				obj.repAddData("Verify Project name, Address, City, State and Zip ", "Verified Project name, Address, City, State and Zip ", "Verified Address",
						"Pass");				
			}
			else{
				obj.repAddData("Verify Project name, Address, City, State and Zip ", "Not Verified Project name, Address, City, State and Zip ", "Address not Verified",
						"Fail");				
			}
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_PropertyTab_xp, "Additional information tab",true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_AdditionalInformation_xp, "Additional information tab",true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_PropertyWalk_xp, "Property walk tab", true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_Budget_xp, "Budget tab", true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_ProjectTools_xp, "Project tools", true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_ActivityLog_xp, "Activity log tab", true, true);
			
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
			log.error( "Function TC41998 Failed!", e );
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
			log.info("Execution of Function TC41998 Completed");
		}
		return obj;
	}
	
	//Propery_TC003_Verify quote email address in Office level and add invitationhomes if it is not there
		public Reporter TC41999(Reporter obj) throws Exception
		{
			//Boolean bLoginFlag = true;	
			log.info("Execution of Function TC41999 Started..");

			try {
				obj.repAddData( "Verify quote email address in Office level and add invitationhome if not there", "", "", "");
				fnSelectCorpOffice(sCorporation, sOffice);
				fnLoadingPageWait();
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
					fnVerifyDialogBox("Update", 0);					
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
				log.error( "Function TC41998 Failed!", e );
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
				log.info("Execution of Function TC41998 Completed");
			}
			return obj;
		}
		
	// Propery_TC004_Verify all invitation homes tabs in property level (Pre condition-TC41999)
	public Reporter TC42000(Reporter obj) throws Exception {
		// Boolean bLoginFlag = true;
		log.info("Execution of Function TC42000 Started..");

		try {
			obj.repAddData( "Verify all invitation homes tabs in property level (Pre condition-TC41999", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			fnLoadingPageWait();
			ClickByXpath(RenowalkModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link", true);
			fnLoadingPageWait();
			ClickByXpath("//b[1]", "first row project name link", true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_PropertyTab_xp, "Additional information tab", true,	true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_AdditionalInformation_xp, "Additional information tab",	true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_PropertyWalk_xp, "Property walk tab", true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_Budget_xp, "Budget tab", true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_ProjectTools_xp, "Project tools", true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_ActivityLog_xp, "Activity log tab", true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_IH_PTL_xp, "IH PTL tab", true, true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Property_IH_Budget_xp, "IH Budget tab", true, true);
			
		} catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			// bLoginFlag=false;
			obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
					"Exception found in current test.", "Fail");
			if (driver.findElement(By.xpath(objRWModules.Common_AddModule_BtnCancel_xp)).isEnabled()) {
				ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button", false); // post condition																									
			}
			log.error("Function TC42000 Failed!", e);
		} finally {
			if (!testCaseStatus) {
				Reporter.iTotalFail++;
			} else {
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC41998 Completed");
		}
		return obj;
	}
	
	// Property_TC005_Verify project tools if property is not assigned or assigned but not walked_
		public Reporter TC42001(Reporter obj) throws Exception {
			// Boolean bLoginFlag = true;
			log.info("Execution of Function TC42001 Started..");

			try {	
				obj.repAddData( "Verify project tools if property is not assigned or assigned but not walked  ", "", "", "");
				fnSelectCorpOffice(sCorporation, sOffice);
				 fnLoadingPageWait();
				 objBusinessFunctionLibrary.fnVerifyOrAddInviationHomeinOffice();
				 System.out.println("invitationhomes verification done");
				//creates assigned not walked property
				String propertyName= objBusinessFunctionLibrary.fnaddAndVerifyProperty("");
				ClickByXpath(RenowalkModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link", true);
				fnLoadingPageWait();
				SendKeyByXpath(RenowalkModules.Property_SearchProperty_PropertySearchInput_xp, propertyName, "Property name");
				ClickByXpath(RenowalkModules.Property_SearchProperty_PropertySearchButton_xp, "Search button", true);
				fnLoadingPageWait();				
				ClickByXpath(RenowalkModules.Property_clickProperty_XP.replace("propertNameToBeclicked", propertyName), "Property name", true);
				fnLoadingPageWait();
				objBusinessFunctionLibrary.fnVerifyPropetyStatusAndProjectToolsButtons();
			} catch (Exception e) {
				e.printStackTrace();
				testCaseStatus = false;
				// bLoginFlag=false;
				obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
						"Exception found in current test.", "Fail");
				if (driver.findElement(By.xpath(objRWModules.Common_AddModule_BtnCancel_xp)).isEnabled()) {
					ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button", false); // post condition																									
				}
				log.error("Function TC42001 Failed!", e);
			} finally {
				if (!testCaseStatus) {
					Reporter.iTotalFail++;
				} else {
					Reporter.iTotalPass++;
				}
				log.info("Execution of Function TC42001 Completed");
			}
			return obj;
		}

	// Property_TC006_Walk a property from property walk and Verify project tools
	public Reporter TC42002(Reporter obj) throws Exception {
		// Boolean bLoginFlag = true;
		log.info("Execution of Function TC42002 Started..");

		try {
			obj.repAddData("Walk a property from property walk and Verify project tools", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			fnLoadingPageWait();
			objBusinessFunctionLibrary.fnVerifyOrAddInviationHomeinOffice();
			System.out.println("invitationhomes verification done");
			// creates assigned not walked property
			String propertyName = objBusinessFunctionLibrary.fnaddAndVerifyProperty("");
			ClickByXpath(RenowalkModules.Property_GenProperty_LinkPropertyOption_xp, "Property Link", true);
			fnLoadingPageWait();
			SendKeyByXpath(RenowalkModules.Property_SearchProperty_PropertySearchInput_xp, propertyName,"Property name");
			ClickByXpath(RenowalkModules.Property_SearchProperty_PropertySearchButton_xp, "Search button", true);
			fnLoadingPageWait();
			ClickByXpath(RenowalkModules.Property_clickProperty_XP.replace("propertNameToBeclicked", propertyName),	"Property name", true);
			fnLoadingPageWait();
			ClickByXpath(RenowalkModules.Property_PropertyWalk_xp, "Property walk tab", true);
			fnLoadingPageWait();
			ClickByXpath(RenowalkModules.Property_PropertyWalk_CreateNewWalk_xp, "Create new walk button", true);
			fnLoadingPageWait();
			fnIHLoadingPageWait();
			ClickById(RenowalkModules.Property_PropertyWalk_SetWalk_id, "'SetWalked' button", true);
			fnLoadingPageWait();
			fnVerifyDialogBox("Update",0);
			ClickByXpath(RenowalkModules.Property_PropertyTab_xp, "Property tab", true);			
			objBusinessFunctionLibrary.fnVerifyPropetyStatusAndProjectToolsButtons();
			
		} catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			// bLoginFlag=false;
			obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
					"Exception found in current test.", "Fail");
			if (driver.findElement(By.xpath(objRWModules.Common_AddModule_BtnCancel_xp)).isEnabled()) {
				ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button", false); // post condition
																									
			}
			log.error("Function TC42002 Failed!", e);
		} finally {
			if (!testCaseStatus) {
				Reporter.iTotalFail++;
			} else {
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC42002 Completed");
		}
		return obj;
	}   
	// Property_TC007_IH PTL Basic property verification
		public Reporter TC42003(Reporter obj) throws Exception {
			// Boolean bLoginFlag = true;
			log.info("Execution of Function TC42003 Started..");
			try {
			obj.repAddData("IH PTL Basic property verification ", "", "", "");
			// selects Corporation-Invitation Homes and Office-Phoenix and return all the property data in a HashMap			
			HashMap<String, String> propLabelAndValue=objBusinessFunctionLibrary.fnSelectIHAndGetPropDetails("S1AP1814 - 756 N. Young Mesa 85203 - BW-109634");
			ClickByXpath(RenowalkModules.Property_IH_PTL_xp, "IH PTL tab", true);
			//fnIHLoadingPageWait();
			fnWaitForElementByID("PR_propertyAddress");
			//getting all the data in text boxes
			String address = driver.findElement(By.id("PR_propertyAddress")).getText();
			String dateCreated = driver.findElement(By.id("PR_dateCreated")).getText();
			String mainSquareFT = driver.findElement(By.id("PR_mainSquareFT")).getText();
			String bedBath = driver.findElement(By.id("PR_bedBath")).getText();
			String yearBuilt=driver.findElement(By.id("PR_yearBuilt")).getText();
			//expected property details from map			
			String expectedAddress = propLabelAndValue.get("address")+", "+propLabelAndValue.get("city") +", "+propLabelAndValue.get("state")+" "+propLabelAndValue.get("zip");
			String expectedSquareFootage = propLabelAndValue.get("squareFootage")+" sf";
			String expectedBedBath = propLabelAndValue.get("bed")+"bd. "+propLabelAndValue.get("bath")+"ba.";
			String expectedYearBuilt=propLabelAndValue.get("yearBuilt");
			//for comparison and reporting 
			objBusinessFunctionLibrary.fnVerifyBasicPropertyDetails(expectedAddress,address, "Address");
			objBusinessFunctionLibrary.fnVerifyBasicPropertyDetails(expectedSquareFootage,mainSquareFT, "Square Footage");
			objBusinessFunctionLibrary.fnVerifyBasicPropertyDetails(expectedBedBath,bedBath,"Bed & Bath");			
			objBusinessFunctionLibrary.fnVerifyBasicPropertyDetails(expectedYearBuilt,yearBuilt,"Year Built");
			//date not null
			if(StringUtils.isNotBlank(dateCreated)){
				obj.repAddData("Verify Date Created","Date should not be null","Date is not null","Pass");				
			}else{
				obj.repAddData("Verify Date Created","Date should not be null","Date is null","Fail");
			}
						
			} catch (Exception e) {
				e.printStackTrace();
				testCaseStatus = false;
				// bLoginFlag=false;
				obj.repAddData("Error Handler ", "There should not be any error/exception in the test","Exception found in current test.", "Fail");
				if (driver.findElement(By.xpath(objRWModules.Common_AddModule_BtnCancel_xp)).isEnabled()) {
					ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button", false); // post condition																										
				}
				log.error("Function TC42003 Failed!", e);
			} finally {
				if (!testCaseStatus) {
					Reporter.iTotalFail++;
				} else {
					Reporter.iTotalPass++;
				}
				log.info("Execution of Function TC42003 Completed");
			}
			return obj;
		}  
		//Property_TC008_IH Budget Basic property verification
		public Reporter TC42004(Reporter obj) throws Exception {
			// Boolean bLoginFlag = true;
			log.info("Execution of Function TC42004 Started..");

			try {
				obj.repAddData("IH Budget Basic property verification", "", "", "");
				//selects Corporation-Invitation Homes and Office-Phoenix and return all the property data in a map
				HashMap<String, String> propLabelAndValue=objBusinessFunctionLibrary.fnSelectIHAndGetPropDetails("S1AP1814 - 756 N. Young Mesa 85203 - BW-109634");
				ClickByXpath(RenowalkModules.Property_IH_Budget_xp, "IH Budget tab", true);
				// fnIHLoadingPageWait();
				fnWaitForElementByID("PB_propertyAddress");
				//getting all the data in text boxes
				String address = driver.findElement(By.id("PB_propertyAddress")).getText();
				String dateCreated = driver.findElement(By.id("PB_dateCreated")).getText();
				String mainSquareFT = driver.findElement(By.id("PB_mainSquareFT")).getText();
				String bedBath = driver.findElement(By.id("PB_bedBath")).getText();
				String yearBuilt=driver.findElement(By.id("PB_yearBuilt")).getText();
				//expected property details from map			
				String expectedAddress = propLabelAndValue.get("address")+", "+propLabelAndValue.get("city") +", "+propLabelAndValue.get("state")+" "+propLabelAndValue.get("zip");
				String expectedSquareFootage = propLabelAndValue.get("squareFootage")+" sf";
				String expectedBedBath = propLabelAndValue.get("bed")+"bd. "+propLabelAndValue.get("bath")+"ba.";
				String expectedYearBuilt=propLabelAndValue.get("yearBuilt");
				//for comparison and reporting 
				objBusinessFunctionLibrary.fnVerifyBasicPropertyDetails(expectedAddress,address, "Address");
				objBusinessFunctionLibrary.fnVerifyBasicPropertyDetails(expectedSquareFootage,mainSquareFT, "Square Footage");
				objBusinessFunctionLibrary.fnVerifyBasicPropertyDetails(expectedBedBath,bedBath,"Bed & Bath");
				objBusinessFunctionLibrary.fnVerifyBasicPropertyDetails(expectedYearBuilt,yearBuilt,"Year Built");
				//date null check
				if(StringUtils.isNotBlank(dateCreated)){
					obj.repAddData("Verify Date Created","Date should not be null","Date is not null","Pass");				
				}else{
					obj.repAddData("Verify Date Created","Date should not be null","Date is null","Fail");
				}				
			} catch (Exception e) {
				e.printStackTrace();
				testCaseStatus = false;
				// bLoginFlag=false;
				obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
						"Exception found in current test.", "Fail");
				if (driver.findElement(By.xpath(objRWModules.Common_AddModule_BtnCancel_xp)).isEnabled()) {
					ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button", false); // post condition																										
				}
				log.error("Function TC42004 Failed!", e);
			} finally {
				if (!testCaseStatus) {
					Reporter.iTotalFail++;
				} else {
					Reporter.iTotalPass++;
				}
				log.info("Execution of Function TC42004 Completed");
			}
			return obj;
		}  
//	Property_TC009_Tenant responsible basic property verification
		public Reporter TC42005(Reporter obj) throws Exception {
		// Boolean bLoginFlag = true;
		log.info("Execution of Function TC42005 Started..");
		try {
			obj.repAddData("Tenant responsible basic property verification", "", "", "");
			// selects Corporation-Invitation Homes and Office-Phoenix and return all the property data in a map
			HashMap<String, String> propLabelAndValue=objBusinessFunctionLibrary.fnSelectIHAndGetPropDetails("S1AP1814 - 756 N. Young Mesa 85203 - BW-109634");
			fnWaitForElementByXPath(RenowalkModules.Property_TenantResponsible_xp);
			ClickByXpath(RenowalkModules.Property_TenantResponsible_xp, "Tenanat responsible tab", true);			
			//getting all the data in text boxes
			String address = driver.findElement(By.id("PR_tenantPropertyAddress")).getText();
			//expected property details from map			
			String expectedAddress = propLabelAndValue.get("address")+", "+propLabelAndValue.get("city") +", "+propLabelAndValue.get("state")+" "+propLabelAndValue.get("zip");
			//for comparison and reporting 
			objBusinessFunctionLibrary.fnVerifyBasicPropertyDetails(expectedAddress,address, "Address");			
		} catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			// bLoginFlag=false;
			obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
					"Exception found in current test.", "Fail");
			if (driver.findElement(By.xpath(objRWModules.Common_AddModule_BtnCancel_xp)).isEnabled()) {
				ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button", false); // post condition	
			}
			log.error("Function TC42005 Failed!", e);
		} finally {
			if (!testCaseStatus) {
				Reporter.iTotalFail++;
			} else {
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC42005 Completed");
		}
		return obj;
	}

		
//		Property_TC010_Advanced office_Disable add/edit property
		@SuppressWarnings("static-access")		
		public Reporter TC42006(Reporter obj) throws Exception {

			log.info("Execution of Function TC42006 Started..");
			try {						
				obj.repAddData("Advanced office_Disable add/edit property", "", "", "");
				objBusinessFunctionLibrary.checkIfUncheckedAddOrEditPropInOfficeLevel();					
						
			} catch (Exception e) {
				e.printStackTrace();
				testCaseStatus = false;
				obj.repAddData("Error Handler ", "There should not be any error/exception in the test",
						"Exception found in current test.", "Fail");
				log.error("Function TC42006 Failed!", e);
			} finally {

				if (!testCaseStatus) {
					Reporter.iTotalFail++;
				} else {
					Reporter.iTotalPass++;
				}
				log.info("Execution of Function TC42006 Completed");
			}
			return obj;
		} // End of function TC42006
			
//			Property_TC011_verify add property when add/edit property is disabled
			public Reporter TC42007(Reporter obj) throws Exception {
			// Boolean bLoginFlag = true;
			log.info("Execution of Function TC42007 Started..");
			try {
				obj.repAddData("Advanced office_Disable add/edit property", "", "", "");
				objBusinessFunctionLibrary.checkIfUncheckedAddOrEditPropInOfficeLevel();	
					ClickByXpath(RenowalkModules.Property_GenProp_LinkPropertyOption_xp, "Property link", true);					
					fnLoadingPageWait();
					fnCheckFieldDisplayByXpath(RenowalkModules.Property_Disabled_AddProperty_Button, "Disabled add property button", true, true);
					WebElement ele = driver.findElement(By.xpath("//b[1]"));
					
					if(ele.isEnabled()) {
						HighlightElement(ele);
						ele.click();
						fnLoadingPageWait();
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_Disabled_ProjectName_textbox, "Disabled project name textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_Disabled_Propertycode_textbox, "Disabled property code textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_Disabled_Address_textbox, "Disabled address textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_Disabled_City_textbox, "Disabled city textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_Disabled_State_textbox, "Disabled state textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_Disabled_Zipcode_textbox, "Disabled zipcode textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_Disabled_County_textbox, "Disabled County textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_Disabled_MainSqFt_textbox, "Disabled main sq ft textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_Disabled_NoOfbedRooms_textbox, "Disabled No.of bed rooms textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_Disabled_NoOfBathRooms_combo, "Disabled No.of bathrooms textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_Disabled_YearBuilt_textbox, "Disabled year built textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_Disabled_Comments_textbox, "Disabled comments textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_Disabled_WalkAssigned_Combo, "Disabled walkassigned combo box", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_Disabled_PropertyStatus_Combo, "Disabled Property status combo box", true, true);						
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_Disabled_Gatecode_textbox, "Disabled gate code textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_Disabled_Lockbox_textbox, "Disabled lockbox textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_Disabled_DueDate_xp, "Disabled due date calendar", true, true);					
						
					}
					
					objBusinessFunctionLibrary.unCheckIfcheckedAddOrEditPropInOfficeLevel();
										
				} catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					// bLoginFlag=false;
					obj.repAddData("Error Handler ", "There should not be any error/exception in the test","Exception found in current test.", "Fail");
					if (driver.findElement(By.xpath(objRWModules.Common_AddModule_BtnCancel_xp)).isEnabled()) {
						ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button", false); // post condition	
					}
					log.error("Function TC42007 Failed!", e);
				} finally {
					if (!testCaseStatus) {
						Reporter.iTotalFail++;
					} else {
						Reporter.iTotalPass++;
					}
					log.info("Execution of Function TC42007 Completed");
				}
				return obj;
			} //end of function TC42007
			
//			Property_Property_TC012_Advanced office_Enable add/edit property
				public Reporter TC42008(Reporter obj) throws Exception {
				// Boolean bLoginFlag = true;
				log.info("Execution of Function TC42008 Started..");
				try {
					obj.repAddData("Advanced office_Disable add/edit property", "", "", "");
					objBusinessFunctionLibrary.unCheckIfcheckedAddOrEditPropInOfficeLevel();									
								
				} catch (Exception e) {
					e.printStackTrace();
					testCaseStatus = false;
					// bLoginFlag=false;
					obj.repAddData("Error Handler ", "There should not be any error/exception in the test","Exception found in current test.", "Fail");
					if (driver.findElement(By.xpath(objRWModules.Common_AddModule_BtnCancel_xp)).isEnabled()) {
						ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button", false); // post condition	
					}
					log.error("Function TC42008 Failed!", e);
				} finally {
					if (!testCaseStatus) {
						Reporter.iTotalFail++;
					} else {
						Reporter.iTotalPass++;
					}
					log.info("Execution of Function TC42008 Completed");
				}
				return obj;
			} //end of function TC42008
				
//			Property_TC013_verify add property button when add/edit property is Enabled
			public Reporter TC42009(Reporter obj) throws Exception {
			// Boolean bLoginFlag = true;
			log.info("Execution of Function TC42009 Started..");
			try {
				obj.repAddData("Advanced office_Disable add/edit property", "", "", "");
				objBusinessFunctionLibrary.unCheckIfcheckedAddOrEditPropInOfficeLevel();
					ClickByXpath(RenowalkModules.Property_GenProp_LinkPropertyOption_xp, "Property link", true);					
					fnLoadingPageWait();
					fnCheckFieldDisplayByXpath(RenowalkModules.Property_ViewOffice_BtnAddProperty_xp, "Enabled add property button", true, true);
					WebElement ele = driver.findElement(By.xpath("//b[1]"));
					
					if(ele.isEnabled()) {
						HighlightElement(ele);
						ele.click();
						fnLoadingPageWait();
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_AddProperty_InputProjectName_xp, "Enabled project name textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_AddProperty_InputPropertyCode_xp, "Enabled property code textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_AddProperty_InputAddress_xp, "Enabled address textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_AddProperty_InputCity_xp, "Enabled city textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_AddProperty_InputState_xp, "Enabled state textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_AddProperty_InputZipCode_xp, "Enabled zipcode textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_AddProperty_InputCounty_xp, "Enabled County textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_AddProperty_InputMainSquareFT_xp, "Enabled main sq ft textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_AddProperty_InputNumberBedrooms_xp, "Enabled No.of bed rooms textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_AddProperty_ComboNumberBathroom_xp, "Enabled No.of bathrooms textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_AddProperty_InputYearBuilt_xp, "Enabled year built textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_AddProperty_InputComment_xp, "Enabled comments textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_AddProperty_ComboWalkAssigned_xp, "Enabled walkassignede textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_AddProperty_PropertyStatus_xp, "Enabled Property status combo box", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_AddProperty_InputGateCode_xp, "Enabled gate code textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_AddProperty_InputLockBox_xp, "Enabled lockbox textbox", true, true);
						fnCheckFieldDisplayByXpath(RenowalkModules.Property_AddProperty_DueDate_xp, "Enabled Due date textbox", true, true);													
					}
					
					
										
				} catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			// bLoginFlag=false;
			obj.repAddData("Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			if (driver.findElement(By.xpath(objRWModules.Common_AddModule_BtnCancel_xp)).isEnabled()) {
				ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button", false); // post condition
			}
			log.error("Function TC42009 Failed!", e);
				} 
			finally {
					if (!testCaseStatus) {
						Reporter.iTotalFail++;
					} else {
						Reporter.iTotalPass++;
					}
					log.info("Execution of Function TC42009 Completed");
				}
				return obj;
			} //end of function TC42009	
			
//			Property_TC014_Verify show groups_checked shows all groups
			public Reporter TC42010(Reporter obj) throws Exception {
			// Boolean bLoginFlag = true;
			log.info("Execution of Function TC42010 Started..");
			try {
				obj.repAddData("Advanced office_Disable add/edit property", "", "", "");
				objBusinessFunctionLibrary.fnEnterWalkedPropertyNameGoToPropertyWalk();				
				WebElement showAllGroupsCheckbox = driver.findElement(By.xpath(RenowalkModules.Property_PropertyWalk_ShowAllGroupsCheckbox_XP));
				if (showAllGroupsCheckbox.isSelected()) {

				} else {
				ClickByXpath(RenowalkModules.Property_PropertyWalk_ShowAllGroupsCheckbox_XP, "Show all groups checkbox",true);
				System.out.println("Show all groups unchecked");
				}
				String sListOfAllGroups = mTestPhaseData.get(TestDriver.iTC_ID).get("Groups").toString().trim();
				System.out.println("Groups are : " + sListOfAllGroups);
				String[] arrAllGroups = sListOfAllGroups.split(",");
				for (int i = 0; i < arrAllGroups.length; i++) {
					String xp = "//span[text()='actGroupName']";
					fnCheckFieldDisplayByXpath(xp.replace("actGroupName", arrAllGroups[i]), arrAllGroups[i], true, true);					
				}

		} catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			// bLoginFlag=false;
			obj.repAddData("Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			if (driver.findElement(By.xpath(objRWModules.Common_AddModule_BtnCancel_xp)).isEnabled()) {
				ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button", false); // post condition
			}
			log.error("Function TC42010 Failed!", e);
				} 
			finally {
					if (!testCaseStatus) {
						Reporter.iTotalFail++;
					} else {
						Reporter.iTotalPass++;
					}
					log.info("Execution of Function TC42010 Completed");
				}
				return obj;
			} //end of function TC42009		
			
//	Property_TC015_Verify show all groups checked shows few groups_Checks for description or price is not empty
			public Reporter TC42011(Reporter obj) throws Exception {
			// Boolean bLoginFlag = true;
			log.info("Execution of Function TC42010 Started..");
			try {
				obj.repAddData("Advanced office_Disable add/edit property", "", "", "");
				objBusinessFunctionLibrary.fnEnterWalkedPropertyNameGoToPropertyWalk();				
				WebElement showAllGroupsCheckbox = driver.findElement(By.xpath(RenowalkModules.Property_PropertyWalk_ShowAllGroupsCheckbox_XP));
				if (showAllGroupsCheckbox.isSelected()) {
					ClickByXpath(RenowalkModules.Property_PropertyWalk_ShowAllGroupsCheckbox_XP, "Show all groups checkbox",true);					
				} else {
				
				}
				//get excel data
				String sListOfAllGroups = mTestPhaseData.get(TestDriver.iTC_ID).get("Groups").toString().trim();
				//split excel data
				String[] arrAllGroups = sListOfAllGroups.split(",");
				
			for (int i = 0; i < arrAllGroups.length; i++) {
				//common group xpath
				String propWalkGrpName_XP = "//span[text()='actGroupName']";
				fnCheckFieldDisplayByXpath(propWalkGrpName_XP.replace("actGroupName", arrAllGroups[i]), arrAllGroups[i], true, true);				
				ClickByXpath(propWalkGrpName_XP.replace("actGroupName", arrAllGroups[i]), arrAllGroups[i], true);
				obj.repAddData("Verifying "+arrAllGroups[i]+" group", "", "", "");	
				
				//gets measurement table row
//				List<WebElement> measurementTable = driver.findElements(By.xpath("//table[contains (@class, 'groupMeasurements')]//tbody/tr"));
//				for (int k = 0; k < measurementTable.size(); k++) {					
//					String width = measurementTable.get(k).findElement(By.xpath("./td[2]//input")).getAttribute("value");
//					String length = measurementTable.get(k).findElement(By.xpath("./td[4]//input")).getAttribute("value");						
//					if(width=="0" && length=="0") {
//						System.out.println("No measurement data");
//					}
//					else  {
//						obj.repAddData("Verify "+arrAllGroups[i]+" measurement", "Measurement value should be there", "Measurement value: Width: "+width+", Length: "+length, "Pass");
//					}
//				}
				
				//gets property walk table rows
				List<WebElement> allRows = driver.findElements(By.xpath("//div[contains(@ng-if,'editingGroup')]/table[@id='listTable']/tbody/tr"));
				
				for (int j = 1; j < allRows.size(); j++) {					
					String description = allRows.get(j).findElement(By.xpath("./td[4]//textarea")).getAttribute("value");
					String itemPrice = allRows.get(j).findElement(By.xpath("./td[5]//input")).getAttribute("value");					
					if (description.isEmpty() && itemPrice.isEmpty()) {
						obj.repAddData("Verify " + arrAllGroups[i], "Description or Price should not be null",	"Description or Price is null", "Fail");
					} else {
						obj.repAddData("Verify " + arrAllGroups[i], "Description or Price should not be null",	"Description or Price is not null", "Pass");
					}
				}
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			// bLoginFlag=false;
			obj.repAddData("Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			if (driver.findElement(By.xpath(objRWModules.Common_AddModule_BtnCancel_xp)).isEnabled()) {
				ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button", false); // post condition
			}
			log.error("Function TC42010 Failed!", e);
				} 
			finally {
					if (!testCaseStatus) {
						Reporter.iTotalFail++;
					} else {
						Reporter.iTotalPass++;
					}
					log.info("Execution of Function TC42010 Completed");
				}
				return obj;
			} //end of function TC42009		
	
} //end of class