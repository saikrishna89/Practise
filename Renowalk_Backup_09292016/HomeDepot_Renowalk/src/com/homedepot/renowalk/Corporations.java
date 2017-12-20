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

public class Corporations extends TestDriver {
	RenowalkModules objRWModules = new RenowalkModules();
	RenowalkHome objRWHome = new RenowalkHome();
	AppMessages objAppMessages = new AppMessages();
	
	//RW_Corporations_TC001_View Corporations_Viewing the Corporations
	@SuppressWarnings("static-access")
	public Reporter TC27057(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27057 Started..");

		try {
					
			obj.repAddData( "Viewing the Corporations", "", "", "");
		
			ClickByXpath(objRWModules.Corporations_GenCorp_LinkCorporationsOption_xp, "Corporations Link",true);
			fnLoadingPageWait();

			fnSelectFromComboBoxXpath(objRWModules.Common_ViewModules_ComboPageSize_xp,"VIEW ALL");
			fnLoadingPageWait();
			HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWModules.Common_ViewModules_Table_xp, "Corporations");
			fnCheckSortedList(mTableData,"Corporation Name",1);
			System.out.println("Sorted Functionality Tested Successfully");
			////////////////////Sorting Logic End////////////////////////////

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC27057 Failed!", e );
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
*/				log.info("Execution of Function TC27057 Completed");
		}
		return obj;
	} //End of function TC27057	
	
	
	//RW_Corporations_TC002_View Corporations_Availability of Add Corporation option
	@SuppressWarnings("static-access")
	public Reporter TC27058(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27058 Started..");

		try {
					
			obj.repAddData( "Availability of Add Corporation option", "", "", "");
			
			ClickByXpath(objRWModules.Corporations_GenCorp_LinkCorporationsOption_xp, "Corporations Link",true);
			fnLoadingPageWait();

			fnCheckFieldDisplayByXpath(RenowalkModules.Corporations_ViewCorporation_BtnAddCorporation_xp,"'Add Corporation' button",true,true);
			
			WebElement eleTable = driver.findElement(By.xpath(objRWModules.Common_ViewModules_Table_xp));
			List<WebElement> arrHeaderColumns = eleTable.findElements(By.xpath("./thead/tr/th"));  //Get the header
			System.out.println("Rows Size>>>>"+arrHeaderColumns.size());
			fnVerifyHeaders(arrHeaderColumns,0,"Corporation Name");  //There is one improvement RW-286. Once implemented, change it to Corporation Name

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC27058 Failed!", e );
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
			log.info("Execution of Function TC27058 Completed");
		}
		return obj;
	} //End of function TC27058	
	
	
	//RW_Corporations_TC003_View Corporations_Availability of edit and delete options
	@SuppressWarnings("static-access")
	public Reporter TC27059(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27059 Started..");

		try {
					
			obj.repAddData( "Availability of Edit and Delete Options", "", "", "");
			
			ClickByXpath(objRWModules.Corporations_GenCorp_LinkCorporationsOption_xp, "Corporations Link",true);
			fnLoadingPageWait();
			
			HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWModules.Common_ViewModules_Table_xp, "Corporations");
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
			log.error( "Function TC27059 Failed!", e );
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
			log.info("Execution of Function TC27059 Completed");
		}
		return obj;
	} //End of function TC27059	

	
	//RW_Corporations_TC004_View Corporations_Check table title
	@SuppressWarnings("static-access")
	public Reporter TC27060(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27060 Started..");

		try {
					
			obj.repAddData( "Check Corporation Table Title", "", "", "");
			
			ClickByXpath(objRWModules.Corporations_GenCorp_LinkCorporationsOption_xp, "Corporations Link",true);
			fnLoadingPageWait();

			fnCheckFieldDisplayByXpath(RenowalkModules.Corporations_ViewCorporation_LabelCurrentCorporations_xp,"'Current Corporations' label",true,true);

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC27060 Failed!", e );
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
			log.info("Execution of Function TC27060 Completed");
		}
		return obj;
	} //End of function TC27060	
	
	
	//RW_Corporations_TC017_View Corporations_Availability of Pagination options
	@SuppressWarnings("static-access")
	public Reporter TC27136(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27136 Started..");

		try {
					
			obj.repAddData( "Availability of Pagination Options", "", "", "");
			
			ClickByXpath(objRWModules.Corporations_GenCorp_LinkCorporationsOption_xp, "Corporations Link",true);
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
			log.error( "Function TC27136 Failed!", e );
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
			log.info("Execution of Function TC27136 Completed");
		}
		return obj;
	} //End of function TC27136	
	
	
	//RW_Corporations_TC018_View Corporations_Validate Corporation table count using pagination option
	@SuppressWarnings("static-access")
	public Reporter TC27137(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27137 Started..");

		try {
					
			obj.repAddData( "Corporation Table Count for VIEW ALL Option", "", "", "");
			
			ClickByXpath(objRWModules.Corporations_GenCorp_LinkCorporationsOption_xp, "Corporations Link",true);
			fnLoadingPageWait();
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
			log.error( "Function TC27137 Failed!", e );
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
			log.info("Execution of Function TC27137 Completed");
		}
		return obj;
	} //End of function TC27137	
	
	
	//RW_Corporations_TC019_View Corporations_Validate Corporation table records using pagination option
	@SuppressWarnings("static-access")
	public Reporter TC27138(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27138 Started..");

		try {
					
			obj.repAddData( "Corporation Table Records for VIEW ALL Option", "", "", "");
			
			ClickByXpath(objRWModules.Corporations_GenCorp_LinkCorporationsOption_xp, "Corporations Link",true);
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
			log.error( "Function TC27138 Failed!", e );
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
			log.info("Execution of Function TC27138 Completed");
		}
		return obj;
	} //End of function TC27138	
	
	
	//RW_Corporations_TC020_View Corporations_Validate Pagination for option 10
	@SuppressWarnings("static-access")
	public Reporter TC27139(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27139 Started..");

		try {
					
			obj.repAddData("Validate Pagination for Option 10", "", "", "");
			
			ClickByXpath(objRWModules.Corporations_GenCorp_LinkCorporationsOption_xp, "Corporations Link",true);
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
			log.error( "Function TC27139 Failed!", e );
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
			log.info("Execution of Function TC27139 Completed");
		}
		return obj;
	} //End of function TC27139	
	
	
	//RW_Corporations_TC021_View Corporations_Validate Pagination for any page with option 10
	@SuppressWarnings("static-access")
	public Reporter TC27140(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27140 Started..");

		try {
					
			obj.repAddData("Validate pagination for any page with option 10", "", "", "");
			
			ClickByXpath(objRWModules.Corporations_GenCorp_LinkCorporationsOption_xp, "Corporations Link",true);
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
			log.error( "Function TC27140 Failed!", e );
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
			log.info("Execution of Function TC27140 Completed");
		}
		return obj;
	} //End of function TC27140	
	
	
	//RW_Corporations_TC022_View Corporations_Validate Pagination for option 20
	@SuppressWarnings("static-access")
	public Reporter TC27141(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27141 Started..");

		try {
					
			obj.repAddData("Validate Pagination for Option 20", "", "", "");
			
			ClickByXpath(objRWModules.Corporations_GenCorp_LinkCorporationsOption_xp, "Corporations Link",true);
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
			log.error( "Function TC27141 Failed!", e );
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
			log.info("Execution of Function TC27141 Completed");
		}
		return obj;
	} //End of function TC27141	
	
	
	//RW_Corporations_TC023_View Corporations_Validate Pagination for any page with option 20
	@SuppressWarnings("static-access")
	public Reporter TC27142(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27142 Started..");

		try {
					
			obj.repAddData("Validate pagination for any page with option 20", "", "", "");
			
			ClickByXpath(objRWModules.Corporations_GenCorp_LinkCorporationsOption_xp, "Corporations Link",true);
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
			log.error( "Function TC27142 Failed!", e );
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
			log.info("Execution of Function TC27142 Completed");
		}
		return obj;
	} //End of function TC27142	
	
	
	//RW_Corporations_TC024_View Corporations_Validate for Page Counter and Navigation
	@SuppressWarnings("static-access")
	public Reporter TC27143(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27143 Started..");

		try {
					
			obj.repAddData("Validate Page Counter and Navigation", "", "", "");
			
			ClickByXpath(objRWModules.Corporations_GenCorp_LinkCorporationsOption_xp, "Corporations Link",true);
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
			log.error( "Function TC27143 Failed!", e );
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
			log.info("Execution of Function TC27143 Completed");
		}
		return obj;
	} //End of function TC27143	
	
	//RW_Corporations_TC025_View Corporations_Validate for Previous Button for navigation
	@SuppressWarnings("static-access")
	public Reporter TC27144(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC27144 Started..");

		try {
					
			obj.repAddData("Validate Previous Button for navigation", "", "", "");
						
			ClickByXpath(objRWModules.Corporations_GenCorp_LinkCorporationsOption_xp, "Corporations Link",true);
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
			Thread.sleep(5000);
			fnVerifyNumofRecords("10");
			
			
			if(bElementFound==true || iRows>10)
			{
				SendKeyByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp, "1", "Page Number");
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_BtnPreviousLink_xp,"'Previous' button",true,true);
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				Thread.sleep(5000);
				fnCheckDisbleByXPath(RenowalkModules.Common_ViewModules_BtnPreviousLink_xp, "'Previous' button"); //For temperory purpose, comment this code once improvement RW-314 gets fixed
				//fnCheckDisbleByXPath(RenowalkModules.Common_ViewModules_BtnPreviousLink_xp, "'Previous' button");//Once implemented, un-comment this line
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
			log.error( "Function TC27144 Failed!", e );
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
			log.info("Execution of Function TC27144 Completed");
		}
		return obj;
	} //End of function TC27144	
	
	//RW_Corporations_TC026_View Corporations_Validate for Next Button for navigation
	@SuppressWarnings("static-access")
	public Reporter TC27145(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27145 Started..");

		try {
					
			obj.repAddData("Validate Next Button for navigation", "", "", "");
						
			ClickByXpath(objRWModules.Corporations_GenCorp_LinkCorporationsOption_xp, "Corporations Link",true);
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
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				Thread.sleep(5000);
				fnCheckDisbleByXPath(RenowalkModules.Common_ViewModules_BtnNextLink_xp, "'Next' button"); //For temperory purpose, comment this code once improvement RW-314 gets fixed
				//fnCheckDisbleByXPath(RenowalkModules.Common_ViewModules_BtnPreviousLink_xp, "'Previous' button");//Once implemented, uncomment this line
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
			log.error( "Function TC27145 Failed!", e );
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
			log.info("Execution of Function TC27145 Completed");
		}
		return obj;
	} //End of function TC27145	

	
	//RW-46_Corporations_TC007_Add Corporation_Add Corporation Page
	@SuppressWarnings("static-access")
	public Reporter TC27063(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27063 Started..");

		try {
					
			obj.repAddData( "Adding the Corporation", "", "", "");
			
			ClickByXpath(objRWModules.Corporations_GenCorp_LinkCorporationsOption_xp, "Corporations Link",true);
			fnLoadingPageWait();
			
			ClickByXpath(objRWModules.Corporations_ViewCorporation_BtnAddCorporation_xp, "Add Corporation button",true);
			fnCheckFieldDisplayById(objRWModules.Corporations_AddCorporation_InputCorpName_id,"Corporation Name text box", true, true);
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
			log.error( "Function TC27063 Failed!", e );
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
*/				log.info("Execution of Function TC27063 Completed");
		}
		return obj;
	} //End of function TC27063	
	
	
	//RW-46_Corporations_TC008_Add Corporation_Validate add Corporation
	@SuppressWarnings("static-access")
	public Reporter TC27064(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27064 Started..");

		try {
					
			obj.repAddData( "Validating the Corporation", "", "", "");

			ClickByXpath(objRWModules.Corporations_GenCorp_LinkCorporationsOption_xp, "Corporations Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Corporations_ViewCorporation_BtnAddCorporation_xp, "Add Corporation button",true);
			fnCheckFieldDisplayById(objRWModules.Corporations_AddCorporation_InputCorpName_id,"Corporation Name text box", true, true);
			
			String sName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.id(objRWModules.Corporations_AddCorporation_InputCorpName_id)).sendKeys(sName);
			driver.findElement(By.id(objRWModules.Corporations_AddCorporation_InputCorpName_id)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Corporations_AddCorporation_ErrorMsgRequired_xp,"Required Error Message", true, true);
			String sErrorMsg =driver.findElement(By.xpath(objRWModules.Corporations_AddCorporation_ErrorMsgRequired_xp)).getText().toString().trim();
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
			log.error( "Function TC27064 Failed!", e );
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
			
			log.info("Execution of Function TC27064 Completed");
		}
		return obj;
	} //End of function TC27064	
	
	
	//RW-46_Corporations_TC009_Add Corporation_Check View Corporations
	@SuppressWarnings("static-access")
	public Reporter TC27065(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27065 Started..");

		try {
					
			obj.repAddData( "Viewing the Corporations", "", "", "");

			ClickByXpath(objRWModules.Corporations_GenCorp_LinkCorporationsOption_xp, "Corporations Link",true);
			fnLoadingPageWait();

			HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWModules.Common_ViewModules_Table_xp, "Corporations");
			fnCheckSortedList(mTableData,"Corporation Name",1);
			System.out.println("Sorted Functionality Tested Successfully");
			////////////////////Sorting Logic End////////////////////////////

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC27065 Failed!", e );
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
			log.info("Execution of Function TC27065 Completed");
		}
		return obj;
	} //End of function TC27065	
	
	
	//RW-46_Corporations_TC010_Add Corporation_Save Corporation Name
	@SuppressWarnings("static-access")
	public Reporter TC27066(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27066 Started..");

		try {
					
			obj.repAddData( "Add and Save a Corporation", "", "", "");

			ClickByXpath(objRWModules.Corporations_GenCorp_LinkCorporationsOption_xp, "Corporations Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Corporations_ViewCorporation_BtnAddCorporation_xp, "Add Corporation button",true);
			fnCheckFieldDisplayById(objRWModules.Corporations_AddCorporation_InputCorpName_id,"Corporation Name text box", true, true);
			
			int iRandomNum = fnRandomNum(1,10000);
			String sName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			SendKeyById(objRWModules.Corporations_AddCorporation_InputCorpName_id, sName+iRandomNum, "Name");
			//*This field is required
			
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",true); 
			fnVerifyDialogBox("Add",0);
			
			obj.repAddData( "Verify Corporation Name in Database", "", "", "");
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
			log.error( "Function TC27066 Failed!", e );
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
			
			log.info("Execution of Function TC27066 Completed");
		}
		return obj;
	} //End of function TC27066	
	
	
	//RW-46_Corporations_TC011_Add Corporation_Validate corporation Name with Non Alphanumeric characters
	@SuppressWarnings("static-access")
	public Reporter TC27067(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27067 Started..");

		try {
					
			obj.repAddData( "Add and Save a Corporation with Special Characters", "", "", "");

			ClickByXpath(objRWModules.Corporations_GenCorp_LinkCorporationsOption_xp, "Corporations Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Corporations_ViewCorporation_BtnAddCorporation_xp, "Add Corporation button",true);
			fnCheckFieldDisplayById(objRWModules.Corporations_AddCorporation_InputCorpName_id,"Corporation Name text box", true, true);
			
			String sName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			String sRandomName ="";
			for(int i=1 ; i<sName.length();i++)
			{
				int iRandomNum = fnRandomNum(1,sName.length()-1);
				sRandomName= sRandomName+sName.charAt(iRandomNum);
				
			}
			SendKeyById(objRWModules.Corporations_AddCorporation_InputCorpName_id, sRandomName, "Name");
			//*This field is required
			
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",true); 
			fnLoadingPageWait();
			fnVerifyDialogBox("Add",0);

			obj.repAddData( "Verify Corporation Name in Database", "", "", "");
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
			log.error( "Function TC27067 Failed!", e );
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
			
			log.info("Execution of Function TC27067 Completed");
		}
		return obj;
	} //End of function TC27067	
	
	//RW-46_Corporations_TC012_Add Corporation_Validate Corporation Name with characters length more than 80
	@SuppressWarnings("static-access")
	public Reporter TC27068(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27068 Started..");

		try {
					
			obj.repAddData( "Add and Save a Corporation with length more than 80", "", "", "");

			ClickByXpath(objRWModules.Corporations_GenCorp_LinkCorporationsOption_xp, "Corporations Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Corporations_ViewCorporation_BtnAddCorporation_xp, "Add Corporation button",true);
			fnCheckFieldDisplayById(objRWModules.Corporations_AddCorporation_InputCorpName_id,"Corporation Name text box", true, true);
			
			int iRandomNum = fnRandomNum(1,10000);
			String sName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			SendKeyById(objRWModules.Corporations_AddCorporation_InputCorpName_id, sName+iRandomNum, "Name");
			
			fnCheckFieldDisplayByXpath(objRWModules.Corporations_AddCorporation_ErrorMsgMaxLength_xp,"Max Length Error Message", true, true);
			String sErrorMsg =driver.findElement(By.xpath(objRWModules.Corporations_AddCorporation_ErrorMsgMaxLength_xp)).getText().toString().trim();
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
			log.error( "Function TC27068 Failed!", e );
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
			
			log.info("Execution of Function TC27068 Completed");
		}
		return obj;
	} //End of function TC27068	
	
	//RW-46_Corporations_TC013_Add Corporation_Validate Corporation Name with characters length 80 and special characters
	@SuppressWarnings("static-access")
	public Reporter TC27069(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27069 Started..");

		try {
					
			obj.repAddData( "Add and Save a Corporation with characters length 80 and special characters", "", "", "");

			ClickByXpath(objRWModules.Corporations_GenCorp_LinkCorporationsOption_xp, "Corporations Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Corporations_ViewCorporation_BtnAddCorporation_xp, "Add Corporation button",true);
			fnCheckFieldDisplayById(objRWModules.Corporations_AddCorporation_InputCorpName_id,"Corporation Name text box", true, true);
			
			int iRandomNum = fnRandomNum(10000000,99999999);
			String sName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			SendKeyById(objRWModules.Corporations_AddCorporation_InputCorpName_id, sName+iRandomNum, "Name");
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
					
			
			obj.repAddData( "Verify Corporation Name in Database", "", "", "");
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
			log.error( "Function TC27069 Failed!", e );
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
			
			log.info("Execution of Function TC27069 Completed");
		}
		return obj;
	} //End of function TC27069	
	
	
	//RW-46_Corporations_TC014_Add Corporation_Validate Corporation Name by adding a duplicate Corporation name
	@SuppressWarnings("static-access")
	public Reporter TC27070(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27070 Started..");

		try {
					
			obj.repAddData( "Adding a Duplicate Corporation Name", "", "", "");

			ClickByXpath(objRWModules.Corporations_GenCorp_LinkCorporationsOption_xp, "Corporations Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Corporations_ViewCorporation_BtnAddCorporation_xp, "Add Corporation button",true);
			fnCheckFieldDisplayById(objRWModules.Corporations_AddCorporation_InputCorpName_id,"Corporation Name text box", true, true);
			
			int iRandomNum = fnRandomNum(1,10000);
			String sName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			SendKeyById(objRWModules.Corporations_AddCorporation_InputCorpName_id, sName+iRandomNum,"Name");
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",true); 
			fnVerifyDialogBox("Add",0);	
			ClickByXpath(objRWModules.Corporations_ViewCorporation_BtnAddCorporation_xp, "Add Corporation button",true);
			SendKeyById(objRWModules.Corporations_AddCorporation_InputCorpName_id, sName+iRandomNum,"Name");
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",true);   //Once real time checking deployed for duplicate field, remove this line
			
			fnCheckFieldDisplayByXpath(objRWModules.Corporations_AddCorporation_ErrorMsgDuplicate_xp,"Duplicate Error Message", true, true);
			String sErrorMsg =driver.findElement(By.xpath(objRWModules.Corporations_AddCorporation_ErrorMsgDuplicate_xp)).getText().toString().trim();
			if(sErrorMsg.equalsIgnoreCase(objAppMessages.Corporations_AddCorporation_ErrorMsgDuplicate_msg))
			{
				obj.repAddData( "Verify Duplicate Error Message", "'"+objAppMessages.Corporations_AddCorporation_ErrorMsgDuplicate_msg+"' should be shown", "'"+objAppMessages.Corporations_AddCorporation_ErrorMsgDuplicate_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Duplicate Error Message", "'"+objAppMessages.Corporations_AddCorporation_ErrorMsgDuplicate_msg+"' should be shown","'"+ objAppMessages.Corporations_AddCorporation_ErrorMsgDuplicate_msg+"' not shown", "Fail");
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
			log.error( "Function TC27070 Failed!", e );
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
			
			log.info("Execution of Function TC27070 Completed");
		}
		return obj;
	} //End of function TC27070	
	
	//RW-46_Corporations_TC015_Add Corporation_Cancel adding Corporation name
	@SuppressWarnings("static-access")
	public Reporter TC27071(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27071 Started..");

		try {
					
			obj.repAddData( "Cancelling a Corporation", "", "", "");

			ClickByXpath(objRWModules.Corporations_GenCorp_LinkCorporationsOption_xp, "Corporations Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Corporations_ViewCorporation_BtnAddCorporation_xp, "Add Corporation button",true);
			fnCheckFieldDisplayById(objRWModules.Corporations_AddCorporation_InputCorpName_id,"Corporation Name text box", true, true);
			
			int iRandomNum = fnRandomNum(1,10000);
			String sName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			SendKeyById(objRWModules.Corporations_AddCorporation_InputCorpName_id, sName+iRandomNum,"Name");
			//*This field is required
			
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true); 
			fnVerifyCancelForm(1);
			obj.repAddData( "Verify Corporation Name in Database", "", "", "");
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
			log.error( "Function TC27071 Failed!", e );
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
			
			log.info("Execution of Function TC27071 Completed");
		}
		return obj;
	} //End of function TC27071	
	
	//RW-46_Corporations_TC016_Add Corporation_Validate Corporation Name with blank characters
	@SuppressWarnings("static-access")
	public Reporter TC27072(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27072 Started..");

		try {
					
			obj.repAddData( "Validating the Corporation Name with blank characters", "", "", "");

			ClickByXpath(objRWModules.Corporations_GenCorp_LinkCorporationsOption_xp, "Corporations Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Corporations_ViewCorporation_BtnAddCorporation_xp, "Add Corporation button",true);
			fnCheckFieldDisplayById(objRWModules.Corporations_AddCorporation_InputCorpName_id,"Corporation Name text box", true, true);
			
			String sName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.id(objRWModules.Corporations_AddCorporation_InputCorpName_id)).sendKeys(sName);
			driver.findElement(By.id(objRWModules.Corporations_AddCorporation_InputCorpName_id)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Corporations_AddCorporation_ErrorMsgRequired_xp,"Required Error Message", true, true);
			String sErrorMsg =driver.findElement(By.xpath(objRWModules.Corporations_AddCorporation_ErrorMsgRequired_xp)).getText().toString().trim();
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
			log.error( "Function TC27072 Failed!", e );
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
			
			log.info("Execution of Function TC27072 Completed");
		}
		return obj;
	} //End of function TC27072	
	
}