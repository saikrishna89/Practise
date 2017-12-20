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

public class Regions extends TestDriver {
	RenowalkModules objRWModules = new RenowalkModules();
	RenowalkHome objRWHome = new RenowalkHome();
	AppMessages objAppMessages = new AppMessages();

	//RW-57_Regions_TC001_View Regions_Viewing the Regions
	@SuppressWarnings("static-access")
	public Reporter TC27073(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27073 Started..");

		try {		
					
			obj.repAddData( "Viewing the Regions", "", "", "");

			ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
			fnLoadingPageWait();

			fnSelectFromComboBoxXpath(objRWModules.Common_ViewModules_ComboPageSize_xp,"VIEW ALL");
			fnLoadingPageWait();
			
			HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWModules.Common_ViewModules_Table_xp, "Regions");
			fnCheckSortedList(mTableData,"Region Name",1);
			System.out.println("Sorted Functionality Tested Successfully");
			////////////////////Sorting Logic End////////////////////////////

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC27073 Failed!", e );
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
*/				log.info("Execution of Function TC27073 Completed");
		}
		return obj;
	} //End of function TC27073	
	
	
	//RW-57_Regions_TC002_View Regions_Availability of Add Region option
	@SuppressWarnings("static-access")
	public Reporter TC27075(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27075 Started..");

		try {
					
			obj.repAddData( "Availability of Add Region option", "", "", "");
			
			ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
			fnLoadingPageWait();

			fnCheckFieldDisplayByXpath(RenowalkModules.Regions_ViewRegion_BtnAddRegion_xp,"'Add Region' button",true,true);
			HighlightElement(driver.findElement(By.xpath(RenowalkModules.Regions_ViewRegion_BtnAddRegion_xp)));
			
			WebElement eleTable = driver.findElement(By.xpath(objRWModules.Common_ViewModules_Table_xp));
			List<WebElement> arrHeaderColumns = eleTable.findElements(By.xpath("./thead/tr/th"));  //Get the header
			System.out.println("Rows Size>>>>"+arrHeaderColumns.size());
			fnVerifyHeaders(arrHeaderColumns,0,"Region Name");  //There is one improvement RW-286. Once implemented, change it to Region Name

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC27075 Failed!", e );
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
			log.info("Execution of Function TC27075 Completed");
		}
		return obj;
	} //End of function TC27075	
	
	
	//RW-57_Regions_TC003_View Regions_Availability of edit and delete options
	@SuppressWarnings("static-access")
	public Reporter TC27077(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27077 Started..");

		try {
					
			obj.repAddData( "Availability of Edit and Delete Options", "", "", "");
			
			ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
			fnLoadingPageWait();
			
			HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWModules.Common_ViewModules_Table_xp, "Regions");
			boolean bEditDelete = true;
			int iRow = 0;
			System.out.println("mTableData.keySet().size()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+mTableData.keySet().size());
			for(iRow=1;iRow<=mTableData.size();iRow++)
			{
				String[] arrEditDelete = mTableData.get(iRow).get(2).toString().trim().split(";;");
				if(!arrEditDelete[0].toString().trim().equalsIgnoreCase("Edit") && !arrEditDelete[1].toString().trim().equalsIgnoreCase("Delete"))
				{
					bEditDelete = false;
					break;
				}
			
			}
			
			if(bEditDelete==true)
			{
				obj.repAddData( "Verify Edit and Delete Options", "Edit and Delete Options should be displayed in front of each row", "Edit and Delete Options are displayed in front of each row", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Edit and Delete Options", "Edit and Delete Options should be displayed in front of each row", "Edit and Delete Options are not displayed for row = "+iRow, "Fail");
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC27077 Failed!", e );
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
			log.info("Execution of Function TC27077 Completed");
		}
		return obj;
	} //End of function TC27077	

	
	//RW-57_Regions_TC004_View Regions_Check table title
	@SuppressWarnings("static-access")
	public Reporter TC27078(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27078 Started..");

		try {
					
			obj.repAddData( "Check Region Table Title", "", "", "");
			
			ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
			fnLoadingPageWait();

			fnCheckFieldDisplayByXpath(RenowalkModules.Regions_ViewRegion_LabelCurrentRegions_xp,"'Current Regions' label",true,true);
			HighlightElement(driver.findElement(By.xpath(RenowalkModules.Regions_ViewRegion_LabelCurrentRegions_xp)));

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC27078 Failed!", e );
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
			log.info("Execution of Function TC27078 Completed");
		}
		return obj;
	} //End of function TC27078	
	
	
	//RW-57_Regions_TC018_View Regions_Availability of Pagination options
	@SuppressWarnings("static-access")
	public Reporter TC27146(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27146 Started..");

		try {
					
			obj.repAddData( "Availability of Pagination Options", "", "", "");
			
			ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
			fnLoadingPageWait();

			Select select = new Select(driver.findElement(By.xpath(objRWModules.Common_ViewModules_ComboPageSize_xp)));
			List<WebElement> arrPageSize = select.getOptions();
			System.out.println("Page Combobox Size>>>>"+arrPageSize.size());
			
			fnVerifyComboBoxValues(arrPageSize, 0, "10 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 1, "20 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 2, "VIEW ALL");
			
			fnLoadingPageWait();
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC27146 Failed!", e );
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
			log.info("Execution of Function TC27146 Completed");
		}
		return obj;
	} //End of function TC27146	
	
	
	//RW-57_Regions_TC019_View Regions_Validate Region table count using pagination option
	@SuppressWarnings("static-access")
	public Reporter TC27147(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27147 Started..");

		try {
					
			obj.repAddData( "Region Table Count for VIEW ALL Option", "", "", "");
			
			ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
			fnLoadingPageWait();

			HighlightElementByXpath(objRWModules.Common_ViewModules_ComboPageSize_xp);
			Select select = new Select(driver.findElement(By.xpath(objRWModules.Common_ViewModules_ComboPageSize_xp)));
			List<WebElement> arrPageSize = select.getOptions();
			System.out.println("Page Combobox Size>>>>"+arrPageSize.size());
			
			fnVerifyComboBoxValues(arrPageSize, 0, "10 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 1, "20 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 2, "VIEW ALL");
			obj.repAddData("Select option 'VIEW ALL'", "", "", "");
			select.selectByVisibleText("VIEW ALL");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			WebElement eleTable = driver.findElement(By.xpath(objRWModules.Common_ViewModules_Table_xp));
			List<WebElement> arrTableRows = eleTable.findElements(By.xpath("./tbody/tr"));  //Get the table data rows
			System.out.println("Data Rows Size>>>>"+arrTableRows.size());
			
			//Write DB code here
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC27147 Failed!", e );
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
			log.info("Execution of Function TC27147 Completed");
		}
		return obj;
	} //End of function TC27147	
	
	
	//RW-57_Regions_TC020_View Regions_Validate Region table records using pagination option
	@SuppressWarnings("static-access")
	public Reporter TC27148(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27148 Started..");

		try {
					
			obj.repAddData( "Region Table Records for VIEW ALL Option", "", "", "");
			
			ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
			fnLoadingPageWait();

			HighlightElementByXpath(objRWModules.Common_ViewModules_ComboPageSize_xp);
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
			log.error( "Function TC27148 Failed!", e );
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
			log.info("Execution of Function TC27148 Completed");
		}
		return obj;
	} //End of function TC27148	
	
	
	//RW-57_Regions_TC021_View Regions_Validate Pagination for option 10
	@SuppressWarnings("static-access")
	public Reporter TC27149(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27149 Started..");

		try {
					
			obj.repAddData("Validate Pagination for Option 10", "", "", "");
			
			ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
			fnLoadingPageWait();
			
			boolean bElementFound = fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",false,true);
			int iRows = fnGetTableRowsCount(objRWModules.Common_ViewModules_Table_xp);
			
			HighlightElementByXpath(objRWModules.Common_ViewModules_ComboPageSize_xp);
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
			log.error( "Function TC27149 Failed!", e );
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
			log.info("Execution of Function TC27149 Completed");
		}
		return obj;
	} //End of function TC27149	
	
	
	//RW-57_Regions_TC022_View Regions_Validate Pagination for any page with option 10
	@SuppressWarnings("static-access")
	public Reporter TC27150(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27150 Started..");

		try {
					
			obj.repAddData("Validate pagination for any page with option 10", "", "", "");
			
			ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
			fnLoadingPageWait();

			HighlightElementByXpath(objRWModules.Common_ViewModules_ComboPageSize_xp);
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
			log.error( "Function TC27150 Failed!", e );
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
			log.info("Execution of Function TC27150 Completed");
		}
		return obj;
	} //End of function TC27150	
	
	
	//RW-57_Regions_TC023_View Regions_Validate Pagination for option 20
	@SuppressWarnings("static-access")
	public Reporter TC27151(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27151 Started..");

		try {
					
			obj.repAddData("Validate Pagination for Option 20", "", "", "");
			
			ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
			fnLoadingPageWait();
			
			boolean bElementFound = fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",false,true);
			int iRows = fnGetTableRowsCount(objRWModules.Common_ViewModules_Table_xp);
			
			HighlightElementByXpath(objRWModules.Common_ViewModules_ComboPageSize_xp);
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
			log.error( "Function TC27151 Failed!", e );
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
			log.info("Execution of Function TC27151 Completed");
		}
		return obj;
	} //End of function TC27151	
	
	
	//RW-57_Regions_TC024_View Regions_Validate Pagination for any page with option 20
	@SuppressWarnings("static-access")
	public Reporter TC27152(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27152 Started..");

		try {
					
			obj.repAddData("Validate pagination for any page with option 20", "", "", "");
			
			ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
			fnLoadingPageWait();

			HighlightElementByXpath(objRWModules.Common_ViewModules_ComboPageSize_xp);
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
			log.error( "Function TC27152 Failed!", e );
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
			log.info("Execution of Function TC27152 Completed");
		}
		return obj;
	} //End of function TC27152	
	
	
	//RW-57_Regions_TC025_View Regions_Validate for Page Counter and Navigation
	@SuppressWarnings("static-access")
	public Reporter TC27153(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27153 Started..");

		try {
					
			obj.repAddData("Validate Page Counter and Navigation", "", "", "");
			
			ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
			fnLoadingPageWait();

			boolean bElementFound = fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",false,true);
			int iRows = fnGetTableRowsCount(objRWModules.Common_ViewModules_Table_xp);
			
			HighlightElementByXpath(objRWModules.Common_ViewModules_ComboPageSize_xp);
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
			Thread.sleep(5000);
			fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",true,false);
			fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_LabelTotalPages_xp, "Total No of Pages", true,false);
			
			obj.repAddData("Select option '10 PER PAGE'", "", "", "");
			select.selectByVisibleText("10 PER PAGE");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			if(bElementFound==true || iRows>10)
			{
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_BtnPreviousLink_xp,"'Previous' button",true,true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_BtnNextLink_xp,"'Next' button",true,true);
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
			log.error( "Function TC27153 Failed!", e );
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
			log.info("Execution of Function TC27153 Completed");
		}
		return obj;
	} //End of function TC27153	
	
	//RW-57_Regions_TC026_View Regions_Validate for Previous Button for navigation
	@SuppressWarnings("static-access")
	public Reporter TC27154(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC27154 Started..");

		try {
					
			obj.repAddData("Validate Previous Button for navigation", "", "", "");
						
			ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
			fnLoadingPageWait();
			
			boolean bElementFound = fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",false,true);
			int iRows = fnGetTableRowsCount(objRWModules.Common_ViewModules_Table_xp);
			
			HighlightElementByXpath(objRWModules.Common_ViewModules_ComboPageSize_xp);
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
				SendKeyByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp, "1", "Page Number");
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_BtnPreviousLink_xp,"'Previous' button",true,true);
				fnCheckDisbleByXPath(RenowalkModules.Common_ViewModules_BtnPreviousLink_xp, "'Previous' button"); //For temperory purpose, comment this code once improvement RW-314 gets fixed
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
			log.error( "Function TC27154 Failed!", e );
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
			log.info("Execution of Function TC27154 Completed");
		}
		return obj;
	} //End of function TC27154	
	
	//RW-57_Regions_TC027_View Regions_Validate for Next Button for navigation
	@SuppressWarnings("static-access")
	public Reporter TC27155(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27155 Started..");

		try {
					
			obj.repAddData("Validate Next Button for navigation", "", "", "");
						
			ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
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
				String sTotalPageNum = driver.findElement(By.xpath(RenowalkModules.Common_ViewModules_LabelTotalPages_xp)).getText();
				int iTotalPageNum =  Integer.parseInt(sTotalPageNum);
				SendKeyByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp, String.valueOf(iTotalPageNum), "Page Number");
				
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_BtnNextLink_xp,"'Next' button",true,true);
				fnCheckDisbleByXPath(RenowalkModules.Common_ViewModules_BtnNextLink_xp, "'Next' button"); //For temperory purpose, comment this code once improvement RW-314 gets fixed
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
			log.error( "Function TC27155 Failed!", e );
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
			log.info("Execution of Function TC27155 Completed");
		}
		return obj;
	} //End of function TC27155	
	
	
	//RW-58_Regions_TC007-Add Region_Add Region Page
	@SuppressWarnings("static-access")
	public Reporter TC27084(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27084 Started..");

		try {
					
			obj.repAddData( "Adding the Region", "", "", "");

			ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
			fnLoadingPageWait();
			
			ClickByXpath(objRWModules.Regions_ViewRegion_BtnAddRegion_xp, "Add Region button",true);
			fnCheckFieldDisplayById(objRWModules.Regions_AddRegion_InputRegionName_id,"Region Name text box", true, true);
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);  //post condition

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
			log.error( "Function TC27084 Failed!", e );
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
			log.info("Execution of Function TC27084 Completed");
		}
		return obj;
	} //End of function TC27084	
	
	
	//RW-58_Regions_TC008_Add Region_Validate add region name
	@SuppressWarnings("static-access")
	public Reporter TC27081(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27081 Started..");

		try {
					
			obj.repAddData( "Validating the Region", "", "", "");

			ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Regions_ViewRegion_BtnAddRegion_xp, "Add Region button",true);
			fnCheckFieldDisplayById(objRWModules.Regions_AddRegion_InputRegionName_id,"Region Name text box", true, true);
			HighlightElementById(objRWModules.Regions_AddRegion_InputRegionName_id);
			
			String sName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.id(objRWModules.Regions_AddRegion_InputRegionName_id)).sendKeys(sName);
			driver.findElement(By.id(objRWModules.Regions_AddRegion_InputRegionName_id)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Regions_AddRegion_ErrorMsgRequired_xp,"Required Error Message", true, true);
			String sErrorMsg =driver.findElement(By.xpath(objRWModules.Regions_AddRegion_ErrorMsgRequired_xp)).getText().toString().trim();
			if(sErrorMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}
			
			//*This field is required
			
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);  //post condition
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
			log.error( "Function TC27081 Failed!", e );
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
			
			log.info("Execution of Function TC27081 Completed");
		}
		return obj;
	} //End of function TC27081	
	
	
	//RW-58_Regions_TC009_Add Region_Check View regions
	@SuppressWarnings("static-access")
	public Reporter TC27085(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27085 Started..");

		try {
					
			obj.repAddData( "Viewing the Regions", "", "", "");

			ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
			fnLoadingPageWait();

			HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWModules.Common_ViewModules_Table_xp, "Regions");
			fnCheckSortedList(mTableData,"Region Name",1);
			System.out.println("Sorted Functionality Tested Successfully");
			////////////////////Sorting Logic End////////////////////////////

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC27085 Failed!", e );
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
			log.info("Execution of Function TC27085 Completed");
		}
		return obj;
	} //End of function TC27085	
	
	
	//RW-58_Regions_TC010_Add Region_Save Region Name
	@SuppressWarnings("static-access")
	public Reporter TC27083(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27083 Started..");

		try {
					
			obj.repAddData( "Add and Save a Region", "", "", "");

			ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Regions_ViewRegion_BtnAddRegion_xp, "Add Region button",true);
			fnCheckFieldDisplayById(objRWModules.Regions_AddRegion_InputRegionName_id,"Region Name text box", true, true);
			
			int iRandomNum = fnRandomNum(1,10000);
			String sName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			SendKeyById(objRWModules.Regions_AddRegion_InputRegionName_id, sName+iRandomNum, "Name");
			//*This field is required
			
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",true); 
			fnVerifyDialogBox("Add",0);

			obj.repAddData( "Verify Region Name in Database", "", "", "");
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
			log.error( "Function TC27083 Failed!", e );
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
			
			log.info("Execution of Function TC27083 Completed");
		}
		return obj;
	} //End of function TC27083	
	
	
	//RW-58_Regions_TC011_Add Region_Validate Region Name with Non Alphanumeric characters
	@SuppressWarnings("static-access")
	public Reporter TC27082(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27082 Started..");

		try {
					
			obj.repAddData( "Add and Save a Region with Special Characters", "", "", "");

			ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Regions_ViewRegion_BtnAddRegion_xp, "Add Region button",true);
			fnCheckFieldDisplayById(objRWModules.Regions_AddRegion_InputRegionName_id,"Region Name text box", true, true);
			HighlightElementById(objRWModules.Regions_AddRegion_InputRegionName_id);
			
			String sName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			String sRandomName ="";
			for(int i=1 ; i<sName.length();i++)
			{
				int iRandomNum = fnRandomNum(1,sName.length()-1);
				sRandomName= sRandomName+sName.charAt(iRandomNum);
				
			}
			SendKeyById(objRWModules.Regions_AddRegion_InputRegionName_id, sRandomName, "Name");
			//*This field is required
			
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",true); 
			fnVerifyDialogBox("Add",0);
			obj.repAddData( "Verify Region Name in Database", "", "", "");
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
			log.error( "Function TC27082 Failed!", e );
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
			
			log.info("Execution of Function TC27082 Completed");
		}
		return obj;
	} //End of function TC27082	
	
	//RW-58_Regions_TC012_Add Region_Validate region Name with characters length more than 80
	@SuppressWarnings("static-access")
	public Reporter TC27086(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27086 Started..");

		try {
					
			obj.repAddData( "Add and Save a Region with length more than 80", "", "", "");

			ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Regions_ViewRegion_BtnAddRegion_xp, "Add Region button",true);
			fnCheckFieldDisplayById(objRWModules.Regions_AddRegion_InputRegionName_id,"Region Name text box", true, true);
			HighlightElementById(objRWModules.Regions_AddRegion_InputRegionName_id);
			
			int iRandomNum = fnRandomNum(1,10000);
			String sName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			SendKeyById(objRWModules.Regions_AddRegion_InputRegionName_id, sName+iRandomNum, "Name");
			
			fnCheckFieldDisplayByXpath(objRWModules.Regions_AddRegion_ErrorMsgMaxLength_xp,"Max Length Error Message", true, true);
			HighlightElementByXpath(objRWModules.Regions_AddRegion_ErrorMsgMaxLength_xp);
			String sErrorMsg =driver.findElement(By.xpath(objRWModules.Regions_AddRegion_ErrorMsgMaxLength_xp)).getText().toString().trim();
			if(sErrorMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg))
			{
				obj.repAddData( "Verify Max Length Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Max Length Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg+"' not shown", "Fail");
			}
			
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);  //post condition
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
			log.error( "Function TC27086 Failed!", e );
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
			
			log.info("Execution of Function TC27086 Completed");
		}
		return obj;
	} //End of function TC27086	
	
	//RW-58_Regions_TC013_Add Region_Validate Region Name with characters length 80 and special characters
	@SuppressWarnings("static-access")
	public Reporter TC27088(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27088 Started..");

		try {
					
			obj.repAddData( "Add and Save a Region with characters length 80 and special characters", "", "", "");

			ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Regions_ViewRegion_BtnAddRegion_xp, "Add Region button",true);
			fnCheckFieldDisplayById(objRWModules.Regions_AddRegion_InputRegionName_id,"Region Name text box", true, true);
			HighlightElementById(objRWModules.Regions_AddRegion_InputRegionName_id);
			
			int iRandomNum = fnRandomNum(10000000,99999999);
			String sName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			SendKeyById(objRWModules.Regions_AddRegion_InputRegionName_id, sName+iRandomNum, "Name");
			System.out.println("Size>>>>>>>>>>>>>>>"+sName.length()+String.valueOf(iRandomNum).length());
			
			if(driver.findElement(By.xpath(objRWModules.Common_AddModule_BtnSave_xp)).isEnabled())
			{
				ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",true);
				fnVerifyDialogBox("Add",0);
			}
			else
			{
				obj.repAddData( "Click on Save button", "Save button should be clicked","Save button not clicked", "Fail");
				ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);  //post condition
			}
			
			obj.repAddData( "Verify Region Name in Database", "", "", "");
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
			log.error( "Function TC27088 Failed!", e );
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
			
			log.info("Execution of Function TC27088 Completed");
		}
		return obj;
	} //End of function TC27088	
	
			
	//RW-58_Regions_TC014_Add Region_Cancel adding region name
	@SuppressWarnings("static-access")
	public Reporter TC27090(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27090 Started..");

		try {
					
			obj.repAddData( "Cancelling a Region", "", "", "");

			ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Regions_ViewRegion_BtnAddRegion_xp, "Add Region button",true);
			fnCheckFieldDisplayById(objRWModules.Regions_AddRegion_InputRegionName_id,"Region Name text box", true, true);
			HighlightElementById(objRWModules.Regions_AddRegion_InputRegionName_id);
			
			int iRandomNum = fnRandomNum(1,10000);
			String sName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			SendKeyById(objRWModules.Regions_AddRegion_InputRegionName_id, sName+iRandomNum,"Name");
			//*This field is required
			
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true); 
			fnVerifyCancelForm(1);
			obj.repAddData( "Verify Region Name in Database", "", "", "");
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
			log.error( "Function TC27090 Failed!", e );
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
			
			log.info("Execution of Function TC27090 Completed");
		}
		return obj;
	} //End of function TC27090	
	
	
	//RW-58_Regions_TC015_Add Region_Added Region in Office page
	@SuppressWarnings("static-access")
	public Reporter TC27087(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27087 Started..");

		try {
					
			obj.repAddData( "Add and Save a Region", "", "", "");

			ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Regions_ViewRegion_BtnAddRegion_xp, "Add Region button",true);
			fnCheckFieldDisplayById(objRWModules.Regions_AddRegion_InputRegionName_id,"Region Name text box", true, true);
			
			int iRandomNum = fnRandomNum(1,10000);
			String sName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			SendKeyById(objRWModules.Regions_AddRegion_InputRegionName_id, sName+iRandomNum, "Name");
			//*This field is required
			
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",true); 
			fnVerifyDialogBox("Add",0); 
			
			obj.repAddData( "Verify Region Name in Database", "", "", "");
			//Put db code here
			
			obj.repAddData( "Viewing the Offices", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			
			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
			fnLoadingPageWait();
			
			ClickByXpath(objRWModules.Offices_ViewOffice_BtnAddOffice_xp, "Add button",true);
			
			obj.repAddData( "Verifying Region on Office Page", "", "", "");
			fnVerifyComboBoxValue(objRWModules.Offices_AddOffice_ComboRegion_xp, sName+iRandomNum);
			//fnCheckComboBoxSorting(objRWModules.Offices_AddOffice_ComboRegion_xp,"Region", "Select Region");
			
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false); 
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
			log.error( "Function TC27087 Failed!", e );
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
			
			log.info("Execution of Function TC27087 Completed");
		}
		return obj;
	} //End of function TC27087	

	
	//RW-58_Regions_TC016_Add Region_Validate Region Name with blank characters
	@SuppressWarnings("static-access")
	public Reporter TC27089(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27089 Started..");

		try {
					
			obj.repAddData( "Validating the Region Name with blank characters", "", "", "");

			ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Regions_ViewRegion_BtnAddRegion_xp, "Add Region button",true);
			fnCheckFieldDisplayById(objRWModules.Regions_AddRegion_InputRegionName_id,"Region Name text box", true, true);
			HighlightElementById(objRWModules.Regions_AddRegion_InputRegionName_id);
			
			String sName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.id(objRWModules.Regions_AddRegion_InputRegionName_id)).sendKeys(sName);
			driver.findElement(By.id(objRWModules.Regions_AddRegion_InputRegionName_id)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Regions_AddRegion_ErrorMsgRequired_xp,"Required Error Message", true, true);
			HighlightElementByXpath(objRWModules.Regions_AddRegion_ErrorMsgRequired_xp);
			String sErrorMsg =driver.findElement(By.xpath(objRWModules.Regions_AddRegion_ErrorMsgRequired_xp)).getText().toString().trim();
			if(sErrorMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}

			//*This field is required
			
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);  //post condition
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
			log.error( "Function TC27089 Failed!", e );
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
			
			log.info("Execution of Function TC27089 Completed");
		}
		return obj;
	} //End of function TC27089	
	
	
	//RW-58_Regions_TC017_Add Region_Validate Region Name with duplicate Region name
	@SuppressWarnings("static-access")
	public Reporter TC27091(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27091 Started..");

		try {
					
			obj.repAddData( "Adding a Duplicate Region Name", "", "", "");

			ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Regions_ViewRegion_BtnAddRegion_xp, "Add Region button",true);
			fnCheckFieldDisplayById(objRWModules.Regions_AddRegion_InputRegionName_id,"Region Name text box", true, true);
			HighlightElementById(objRWModules.Regions_AddRegion_InputRegionName_id);
			
			int iRandomNum = fnRandomNum(1,10000);
			String sName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			SendKeyById(objRWModules.Regions_AddRegion_InputRegionName_id, sName+iRandomNum,"Name");
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",true); 
			fnVerifyDialogBox("Add",0);
			ClickByXpath(objRWModules.Regions_ViewRegion_BtnAddRegion_xp, "Add Region button",true);
			SendKeyById(objRWModules.Regions_AddRegion_InputRegionName_id, sName+iRandomNum,"Name");
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",true);   //Once real time checking deployed for duplicate field, remove this line
			
			
			fnCheckFieldDisplayByXpath(objRWModules.Regions_AddRegion_ErrorMsgDuplicate_xp,"Duplicate Error Message", true, true);
			HighlightElementByXpath(objRWModules.Regions_AddRegion_ErrorMsgDuplicate_xp);
			String sErrorMsg =driver.findElement(By.xpath(objRWModules.Regions_AddRegion_ErrorMsgDuplicate_xp)).getText().toString().trim();
			if(sErrorMsg.equalsIgnoreCase(objAppMessages.Regions_AddRegion_ErrorMsgDuplicate_msg))
			{
				obj.repAddData( "Verify Duplicate Error Message", "'"+objAppMessages.Regions_AddRegion_ErrorMsgDuplicate_msg+"' should be shown", "'"+objAppMessages.Regions_AddRegion_ErrorMsgDuplicate_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Duplicate Error Message", "'"+objAppMessages.Regions_AddRegion_ErrorMsgDuplicate_msg+"' should be shown","'"+ objAppMessages.Regions_AddRegion_ErrorMsgDuplicate_msg+"' not shown", "Fail");
			}
			
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);  //post condition
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
			log.error( "Function TC27091 Failed!", e );
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
			
			log.info("Execution of Function TC27091 Completed");
		}
		return obj;
	} //End of function TC27091	
	
}