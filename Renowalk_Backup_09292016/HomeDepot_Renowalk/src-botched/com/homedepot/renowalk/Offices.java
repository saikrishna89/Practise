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

public class Offices extends TestDriver {
	RenowalkModules objRWModules = new RenowalkModules();
	RenowalkHome objRWHome = new RenowalkHome();
	AppMessages objAppMessages = new AppMessages();
	
	//RW_Offices_TC001_View Offices_Viewing the Offices
	@SuppressWarnings("static-access")
	public Reporter TC27166(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27166 Started..");

		try {
					
			obj.repAddData( "Viewing the Offices", "", "", "");
			
			/*ClickByXpath(objRWModules.Corporations_GenCorp_LinkCorporationsOption_xp, "Corporations Link",true);
			fnLoadingPageWait();
			ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
			fnLoadingPageWait();*/
			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
			fnLoadingPageWait();

			fnSelectFromComboBoxXpath(objRWModules.Common_ViewModules_ComboPageSize_xp,"VIEW ALL");
			fnLoadingPageWait();
	/*		WebElement eleTable = driver.findElement(By.xpath(objRWHome.Main_ViewModules_Table_xp));

			List<WebElement> arrTableRows = eleTable.findElements(By.xpath("./tbody/tr"));  //Get the table data rows
			System.out.println("Data Rows Size>>>>"+arrTableRows.size());

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
				

			}*/
			
			HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWModules.Common_ViewModules_Table_xp, "Offices");
			fnCheckSortedList(mTableData,"Office Name",1);
			System.out.println("Sorted Functionality Tested Successfully");
						////////////////////Sorting Logic End////////////////////////////

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC27166 Failed!", e );
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
*/				log.info("Execution of Function TC27166 Completed");
		}
		return obj;
	} //End of function TC27166	
	
	//RW_Offices_TC002_View Offices_Viewing the Columns in Office Table
	@SuppressWarnings("static-access")
	public Reporter TC27167(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27167 Started..");

		try {
					
			obj.repAddData( "Viewing the Columns in Office Table", "", "", "");
			
			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
			fnLoadingPageWait();

			
			WebElement eleTable = driver.findElement(By.xpath(objRWModules.Common_ViewModules_Table_xp));
			List<WebElement> arrHeaderColumns = eleTable.findElements(By.xpath("./thead/tr/th"));  //Get the header
			System.out.println("Rows Size>>>>"+arrHeaderColumns.size());
			fnVerifyHeaders(arrHeaderColumns,0,"Office Name");
			fnVerifyHeaders(arrHeaderColumns,1,"Default Store");

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC27167 Failed!", e );
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
			log.info("Execution of Function TC27167 Completed");
		}
		return obj;
	} //End of function TC27167	
	
	
	//RW_Offices_TC003_View Offices_Availability of Add Office, Edit and Delete options
	@SuppressWarnings("static-access")
	public Reporter TC27168(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27168 Started..");

		try {
					
			obj.repAddData( "Availability of Add Office, Edit and Delete Options", "", "", "");
			
			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
			fnLoadingPageWait();

			fnCheckFieldDisplayByXpath(RenowalkModules.Offices_ViewOffice_BtnAddOffice_xp,"'Add Office' button",true,true);
			HighlightElement(driver.findElement(By.xpath(RenowalkModules.Offices_ViewOffice_BtnAddOffice_xp)));
			
			HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWModules.Common_ViewModules_Table_xp, "Offices");
			boolean bEditDelete = true;
			int iRow = 0;
			for(iRow=1;iRow<=mTableData.size();iRow++)
			{
				String[] arrEditDelete = mTableData.get(iRow).get(3).toString().trim().split(";;");
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
			log.error( "Function TC27168 Failed!", e );
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
			log.info("Execution of Function TC27168 Completed");
		}
		return obj;
	} //End of function TC27168	

	
	//RW_Offices_TC004_View Offices_Check Table Title
	@SuppressWarnings("static-access")
	public Reporter TC27170(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27170 Started..");

		try {
					
			obj.repAddData( "Check Office Table Title", "", "", "");
			
			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
			fnLoadingPageWait();

			fnCheckFieldDisplayByXpath(RenowalkModules.Offices_ViewOffice_LabelCurrentOffices_xp,"'Current Offices' label",true,true);
			HighlightElement(driver.findElement(By.xpath(RenowalkModules.Offices_ViewOffice_LabelCurrentOffices_xp)));

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC27170 Failed!", e );
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
			log.info("Execution of Function TC27170 Completed");
		}
		return obj;
	} //End of function TC27170	
	
	
	//RW_Offices_TC005_View Offices_Availability of Pagination options
	@SuppressWarnings("static-access")
	public Reporter TC27171(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27171 Started..");

		try {
					
			obj.repAddData( "Availability of Pagination Options", "", "", "");
			
			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
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
			log.error( "Function TC27171 Failed!", e );
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
			log.info("Execution of Function TC27171 Completed");
		}
		return obj;
	} //End of function TC27171	
	
	
	//RW_Offices_TC006_View Offices_Validate Office table count using pagination option
	@SuppressWarnings("static-access")
	public Reporter TC27172(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27172 Started..");

		try {
					
			obj.repAddData( "Office Table Count for VIEW ALL Option", "", "", "");
			
			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
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
			//driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
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
			log.error( "Function TC27172 Failed!", e );
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
			log.info("Execution of Function TC27172 Completed");
		}
		return obj;
	} //End of function TC27172	
	
	
	//RW_Offices_TC007_View Offices_Validate Office table records using pagination option
	@SuppressWarnings("static-access")
	public Reporter TC27173(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27173 Started..");

		try {
					
			obj.repAddData( "Office Table Records for VIEW ALL Option", "", "", "");
			
			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
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
			fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",true,false);
			fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_LabelTotalPages_xp, "Total No of Pages", true,false);
			
			WebElement eleTable = driver.findElement(By.xpath(RenowalkModules.Common_ViewModules_Table_xp));
			List<WebElement> arrTableRows = eleTable.findElements(By.xpath("./tbody/tr"));  //Get the table data rows
			System.out.println("Data Rows Size>>>>"+arrTableRows.size());
			
			//HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWHome.Main_ViewModules_Table_xp, "Offices");
			
			//Write DB code here
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC27173 Failed!", e );
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
			log.info("Execution of Function TC27173 Completed");
		}
		return obj;
	} //End of function TC27173	
	
	
	//RW_Offices_TC008_View Offices_Validate Pagination for option 10
	@SuppressWarnings("static-access")
	public Reporter TC27174(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27174 Started..");

		try {
					
			obj.repAddData("Validate Pagination for Option 10", "", "", "");
			
			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
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
			
			//HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWHome.Main_ViewModules_Table_xp, "Offices");
			
			//Write DB code here
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC27174 Failed!", e );
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
			log.info("Execution of Function TC27174 Completed");
		}
		return obj;
	} //End of function TC27174	
	
	
	//RW_Offices_TC009_View Offices_Validate Pagination for any page with option 10
	@SuppressWarnings("static-access")
	public Reporter TC27175(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27175 Started..");

		try {
					
			obj.repAddData("Validate pagination for any page with option 10", "", "", "");
			
			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
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
				SendKeyByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp, String.valueOf(iTotalPageNum),"Page Number");
			}
			else
			{
				obj.repAddData( "Validate Pagination for any page with option 10", "Pagination for any page with option 10 should be validated", "Pagination for any page with option 10 cannot be validated as no of records are less than 10", "Pass");
			}
			
			fnVerifyNumofRecords("10");
			
			//HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWHome.Main_ViewModules_Table_xp, "Offices");
			
			//Write DB code here
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC27175 Failed!", e );
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
			log.info("Execution of Function TC27175 Completed");
		}
		return obj;
	} //End of function TC27175	
	
	
	//RW_Offices_TC010_View Offices_Validate Pagination for option 20
	@SuppressWarnings("static-access")
	public Reporter TC27176(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27176 Started..");

		try {
					
			obj.repAddData("Validate Pagination for Option 20", "", "", "");
			
			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
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
			
			//HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWHome.Main_ViewModules_Table_xp, "Offices");
			
			//Write DB code here
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC27176 Failed!", e );
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
			log.info("Execution of Function TC27176 Completed");
		}
		return obj;
	} //End of function TC27176	
	
	
	//RW_Offices_TC011_View Offices_Validate Pagination for any page with option 20
	@SuppressWarnings("static-access")
	public Reporter TC27177(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27177 Started..");

		try {
					
			obj.repAddData("Validate pagination for any page with option 20", "", "", "");
			
			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
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
			
			//HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWHome.Main_ViewModules_Table_xp, "Offices");
			
			//Write DB code here
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC27177 Failed!", e );
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
			log.info("Execution of Function TC27177 Completed");
		}
		return obj;
	} //End of function TC27177	
	
	
	//RW_Offices_TC012_View Offices_Validate for Page Counter and Navigation
	@SuppressWarnings("static-access")
	public Reporter TC27178(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27178 Started..");

		try {
					
			obj.repAddData("Validate Page Counter and Navigation", "", "", "");
			
			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
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
			
			
			//HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWHome.Main_ViewModules_Table_xp, "Offices");
			
			//Write DB code here
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC27178 Failed!", e );
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
			log.info("Execution of Function TC27178 Completed");
		}
		return obj;
	} //End of function TC27178	
	
	//RW_Offices_TC013_View Offices_Validate for Previous Button for navigation
	@SuppressWarnings("static-access")
	public Reporter TC27179(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27179 Started..");

		try {
					
			obj.repAddData("Validate Previous Button for navigation", "", "", "");
						
			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
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
				//fnCheckEnableByXPath(RenowalkModules.Common_ViewModules_BtnPreviousLink_xp, "'Previous' button"); //For temperory purpose, comment this code once improvement RW-314 gets fixed
				fnCheckDisbleByXPath(RenowalkModules.Common_ViewModules_BtnPreviousLink_xp, "'Previous' button");//Once implemented, uncomment this line
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
			log.error( "Function TC27179 Failed!", e );
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
			log.info("Execution of Function TC27179 Completed");
		}
		return obj;
	} //End of function TC27179	
	
	//RW_Offices_TC014_View Offices_Validate for Next Button for navigation
	@SuppressWarnings("static-access")
	public Reporter TC27180(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27180 Started..");

		try {
					
			obj.repAddData("Validate Next Button for navigation", "", "", "");
						
			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
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
				String sTotalPageNum = driver.findElement(By.xpath(RenowalkModules.Common_ViewModules_LabelTotalPages_xp)).getText();
				int iTotalPageNum =  Integer.parseInt(sTotalPageNum);
				SendKeyByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp, String.valueOf(iTotalPageNum), "Page Number");
				
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_BtnNextLink_xp,"'Next' button",true,true);
				//fnCheckEnableByXPath(RenowalkModules.Common_ViewModules_BtnNextLink_xp, "'Next' button"); //For temperory purpose, comment this code once improvement RW-314 gets fixed
				fnCheckDisbleByXPath(RenowalkModules.Common_ViewModules_BtnNextLink_xp, "'Next' button");//Once implemented, uncomment this line
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
			log.error( "Function TC27180 Failed!", e );
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
			log.info("Execution of Function TC27180 Completed");
		}
		return obj;
	} //End of function TC27180	
	
	
	//RW-60_Offices_TC018_Add Office_Add Office Page
	@SuppressWarnings("static-access")
	public Reporter TC27184(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27184 Started..");
		
		try {
			obj.repAddData( "Adding the Office", "", "", "");
			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
			fnLoadingPageWait();
			ClickByXpath(objRWModules.Offices_ViewOffice_BtnAddOffice_xp, "Add Office button",true);
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp,"Office Name text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp, "Default Store Number text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputAddress_xp, "Address text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputCity_xp, "City text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputState_xp, "State text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputZipCode_xp, "ZipCode text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp, "Phone number text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp, "Quote EMail Address text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_ComboRegion_xp, "Region select box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp, "Property Walk Submit email address text box", true, true);
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
			log.error( "Function TC27184 Failed!", e );
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
*/				log.info("Execution of Function TC27184 Completed");
		}
		return obj;
	} //End of function TC27184
	
	
	//RW-60_Offices_TC019_Add Office_Validate add Office page fields
	@SuppressWarnings("static-access")
	public Reporter TC27185(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27185 Started..");

		try {
					
			obj.repAddData( "Validating the Office Page", "", "", "");

			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
			fnLoadingPageWait();
			ClickByXpath(objRWModules.Offices_ViewOffice_BtnAddOffice_xp, "Add Office button",true);
			
			//Check for Office Name Validation
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp, "Office Name text box", true, true);
			
			String sOfficeName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputOfficeName_xp)).sendKeys(sOfficeName);
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputOfficeName_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_OfficeNameErrorMsgRequired_xp, "Office name Error Message", true, true);

			String sOfficeNameMsg = driver.findElement(By.xpath(objRWModules.Offices_AddOffice_OfficeNameErrorMsgRequired_xp)).getText().toString().trim();
			if(sOfficeNameMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}			
			
			//Check for Default Store Number Validation
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp, "Default Store Number text box", true, true);
			
			String sDefaultStoreNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("StoreNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp)).sendKeys(sDefaultStoreNumber);
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_DefaultStoreNumberErrorMsgRequired_xp, "Default Store Number Error Message", true, true);

			String sDefaultStoreNumberMsg = driver.findElement(By.xpath(objRWModules.Offices_AddOffice_DefaultStoreNumberErrorMsgRequired_xp)).getText().toString().trim();
			if(sDefaultStoreNumberMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}			
			
			
			//check for Address field validation
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputAddress_xp, "Address text box", true, true);
			
			String sAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Address").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputAddress_xp)).sendKeys(sAddress);
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputAddress_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_AddressErrorMsgRequired_xp, "Address Error Message", true, true);

			String sAddressMsg = driver.findElement(By.xpath(objRWModules.Offices_AddOffice_AddressErrorMsgRequired_xp)).getText().toString().trim();
			if(sAddressMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}			
			
			//check for City field validation
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputCity_xp, "City text box", true, true);
			
			String sCity = mTestPhaseData.get(TestDriver.iTC_ID).get("City").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputCity_xp)).sendKeys(sCity);
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputCity_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_CityErrorMsgRequired_xp, "City Error Message", true, true);

			String sCityMsg = driver.findElement(By.xpath(objRWModules.Offices_AddOffice_CityErrorMsgRequired_xp)).getText().toString().trim();
			if(sCityMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}			
			
			//check for State field validation
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputState_xp, "State text box", true, true);
			
			String sState = mTestPhaseData.get(TestDriver.iTC_ID).get("State").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputState_xp)).sendKeys(sState);
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputState_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_StateErrorMsgRequired_xp, "State Error Message", true, true);

			String sStateMsg = driver.findElement(By.xpath(objRWModules.Offices_AddOffice_StateErrorMsgRequired_xp)).getText().toString().trim();
			if(sStateMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}			
			
			//check for Zip Code field validation
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputZipCode_xp, "Zip Code text box", true, true);

			
			String sZipCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Zip").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputZipCode_xp)).sendKeys(sZipCode);
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputZipCode_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_ZipCodeErrorMsgRequired_xp, "Zip Code Error Message", true, true);

			String sZipCodeMsg = driver.findElement(By.xpath(objRWModules.Offices_AddOffice_ZipCodeErrorMsgRequired_xp)).getText().toString().trim();
			if(sZipCodeMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}			
			
			//check for Phone Number field validation
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp, "Phone Number text box", true, true);
			
			String sPhoneNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("PhoneNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp)).sendKeys(sPhoneNumber);
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_PhoneNumberErrorMsgRequired_xp, "Phone Number Error Message", true, true);

			String sPhoneNumberMsg = driver.findElement(By.xpath(objRWModules.Offices_AddOffice_PhoneNumberErrorMsgRequired_xp)).getText().toString().trim();
			if(sPhoneNumberMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}		
			
			//check for Quote Email Address field validation
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp, "Quote Email Address text box", true, true);
			
			String sQuoteEmailAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Email").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp)).sendKeys(sQuoteEmailAddress);
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_QuoteEmailAddressErrorMsgRequired_xp, "Quote Email Address Error Message", true, true);

			String sQuoteEmailAddressMsg = driver.findElement(By.xpath(objRWModules.Offices_AddOffice_QuoteEmailAddressErrorMsgRequired_xp)).getText().toString().trim();
			if(sQuoteEmailAddressMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}		
			
			//*This field is required
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
			log.error( "Function TC27185 Failed!", e );
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
			
			log.info("Execution of Function TC27185 Completed");
		}
		return obj;
	} //End of function TC27185	
	
	//RW-60_Offices_TC020_Add Office_Required Field Office Name Validation
	@SuppressWarnings("static-access")
	public Reporter TC27186(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27186 Started..");

		try {
					
			obj.repAddData( "Required Field Office Name Validation", "", "", "");

			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
			fnLoadingPageWait();
			ClickByXpath(objRWModules.Offices_ViewOffice_BtnAddOffice_xp, "Add Office button",true);
			
			//Check for Office Name Validation
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp, "Office Name text box", true, true);
			
			String sOfficeName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputOfficeName_xp)).sendKeys(sOfficeName);
			
			//fill all fields with value
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp, "Default Store Number text box", true, true);
			String sDefaultStoreNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("StoreNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp)).sendKeys(sDefaultStoreNumber);


			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputAddress_xp, "Address text box", true, true);			
			String sAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Address").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputAddress_xp)).sendKeys(sAddress);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputCity_xp, "City text box", true, true);
			String sCity = mTestPhaseData.get(TestDriver.iTC_ID).get("City").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputCity_xp)).sendKeys(sCity);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputState_xp, "State text box", true, true);
			String sState = mTestPhaseData.get(TestDriver.iTC_ID).get("State").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputState_xp)).sendKeys(sState);
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputZipCode_xp, "Zip Code text box", true, true);
			String sZipCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Zip").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputZipCode_xp)).sendKeys(sZipCode);					
								
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp, "Phone Number text box", true, true);
			String sPhoneNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("PhoneNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp)).sendKeys(sPhoneNumber);					
							
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp, "Quote Email Address text box", true, true);
			String sQuoteEmailAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Email").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp)).sendKeys(sQuoteEmailAddress);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_ComboRegion_xp, "Region Select Box", true, true);
			Select region = new Select(driver.findElement(By.xpath(objRWModules.Offices_AddOffice_ComboRegion_xp)));
			region.selectByIndex(1);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp, "Property Walk Submit Email Address text box", true, true);
			String sPropertyWalkSubmitEmailAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Email").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp)).sendKeys(sPropertyWalkSubmitEmailAddress);
			
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputOfficeName_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_OfficeNameErrorMsgRequired_xp, "Office name Error Message", true, true);

			String sOfficeNameMsg = driver.findElement(By.xpath(objRWModules.Offices_AddOffice_OfficeNameErrorMsgRequired_xp)).getText().toString().trim();
			if(sOfficeNameMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}			
			//*This field is required
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
			log.error( "Function TC27186 Failed!", e );
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
			
			log.info("Execution of Function TC27186 Completed");
		}
		return obj;
	} //End of function TC27186	
	
	
	//RW-60_Offices_TC021_Add Office_Required Field Default Store Number Validation
	@SuppressWarnings("static-access")
	public Reporter TC27187(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27187 Started..");

		try {
					
			obj.repAddData( "Required Field Default Store Number Validation", "", "", "");

			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
			fnLoadingPageWait();
			ClickByXpath(objRWModules.Offices_ViewOffice_BtnAddOffice_xp, "Add Office button",true);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp, "Office Name text box", true, true);
			
			String sOfficeName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputOfficeName_xp)).sendKeys(sOfficeName);
			
			//fill all fields with value
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp, "Default Store Number text box", true, true);		
			String sDefaultStoreNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("StoreNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp)).sendKeys(sDefaultStoreNumber);


			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputAddress_xp, "Address text box", true, true);				
			String sAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Address").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputAddress_xp)).sendKeys(sAddress);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputCity_xp, "City text box", true, true);
			String sCity = mTestPhaseData.get(TestDriver.iTC_ID).get("City").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputCity_xp)).sendKeys(sCity);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputState_xp, "State text box", true, true);
			String sState = mTestPhaseData.get(TestDriver.iTC_ID).get("State").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputState_xp)).sendKeys(sState);
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputZipCode_xp, "Zip Code text box", true, true);
			String sZipCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Zip").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputZipCode_xp)).sendKeys(sZipCode);					
								
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp, "Phone Number text box", true, true);
			String sPhoneNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("PhoneNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp)).sendKeys(sPhoneNumber);					
							
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp, "Quote Email Address text box", true, true);
			String sQuoteEmailAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Email").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp)).sendKeys(sQuoteEmailAddress);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_ComboRegion_xp, "Region Select Box", true, true);
			Select region = new Select(driver.findElement(By.xpath(objRWModules.Offices_AddOffice_ComboRegion_xp)));
			region.selectByIndex(1);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp, "Property Walk Submit Email Address text box", true, true);
			String sPropertyWalkSubmitEmailAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Email").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp)).sendKeys(sPropertyWalkSubmitEmailAddress);
			
			
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_DefaultStoreNumberErrorMsgRequired_xp, "Default Store Number Error Message", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_DefaultStoreNumberErrorMsgRequired_xp);

			String sDefaultStoreNumberMsg = driver.findElement(By.xpath(objRWModules.Offices_AddOffice_DefaultStoreNumberErrorMsgRequired_xp)).getText().toString().trim();
			if(sDefaultStoreNumberMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}			
			
			//*This field is required
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
			log.error( "Function TC27187 Failed!", e );
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
			
			log.info("Execution of Function TC27187 Completed");
		}
		return obj;
	} //End of function TC27187	
	
	//RW-60_Offices_TC022_Add Office_Required Field Address Validation
	@SuppressWarnings("static-access")
	public Reporter TC27188(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27188 Started..");

		try {
					
			obj.repAddData( "Required Field Address Validation", "", "", "");

			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
			fnLoadingPageWait();
			ClickByXpath(objRWModules.Offices_ViewOffice_BtnAddOffice_xp, "Add Office button",true);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp, "Office Name text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp);
			
			String sOfficeName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputOfficeName_xp)).sendKeys(sOfficeName);
			
			//fill all fields with value
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp, "Default Store Number text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp);				
			String sDefaultStoreNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("StoreNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp)).sendKeys(sDefaultStoreNumber);


			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputAddress_xp, "Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputAddress_xp);					
			String sAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Address").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputAddress_xp)).sendKeys(sAddress);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputCity_xp, "City text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputCity_xp);
			String sCity = mTestPhaseData.get(TestDriver.iTC_ID).get("City").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputCity_xp)).sendKeys(sCity);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputState_xp, "State text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputState_xp);
			String sState = mTestPhaseData.get(TestDriver.iTC_ID).get("State").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputState_xp)).sendKeys(sState);
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputZipCode_xp, "Zip Code text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputZipCode_xp);
			String sZipCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Zip").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputZipCode_xp)).sendKeys(sZipCode);					
								
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp, "Phone Number text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp);
			String sPhoneNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("PhoneNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp)).sendKeys(sPhoneNumber);					
							
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp, "Quote Email Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp);
			String sQuoteEmailAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Email").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp)).sendKeys(sQuoteEmailAddress);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_ComboRegion_xp, "Region Select Box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_ComboRegion_xp);
			Select region = new Select(driver.findElement(By.xpath(objRWModules.Offices_AddOffice_ComboRegion_xp)));
			region.selectByIndex(1);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp, "Property Walk Submit Email Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp);
			String sPropertyWalkSubmitEmailAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Email").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp)).sendKeys(sPropertyWalkSubmitEmailAddress);
			
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputAddress_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_AddressErrorMsgRequired_xp, "Address Error Message", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_AddressErrorMsgRequired_xp);

			String sAddressMsg = driver.findElement(By.xpath(objRWModules.Offices_AddOffice_AddressErrorMsgRequired_xp)).getText().toString().trim();
			if(sAddressMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}			
			
			
			//*This field is required
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
			log.error( "Function TC27188 Failed!", e );
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
			
			log.info("Execution of Function TC27188 Completed");
		}
		return obj;
	} //End of function TC27188	
	
	
	//RW-60_Offices_TC023_Add Office_Required Field City Validation
	@SuppressWarnings("static-access")
	public Reporter TC27189(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27189 Started..");

		try {
					
			obj.repAddData( "Required Field City Validation", "", "", "");

			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
			fnLoadingPageWait();
			ClickByXpath(objRWModules.Offices_ViewOffice_BtnAddOffice_xp, "Add Office button",true);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp, "Office Name text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp);
			
			String sOfficeName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputOfficeName_xp)).sendKeys(sOfficeName);
			
			//fill all fields with value
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp, "Default Store Number text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp);				
			String sDefaultStoreNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("StoreNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp)).sendKeys(sDefaultStoreNumber);


			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputAddress_xp, "Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputAddress_xp);					
			String sAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Address").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputAddress_xp)).sendKeys(sAddress);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputCity_xp, "City text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputCity_xp);
			String sCity = mTestPhaseData.get(TestDriver.iTC_ID).get("City").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputCity_xp)).sendKeys(sCity);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputState_xp, "State text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputState_xp);
			String sState = mTestPhaseData.get(TestDriver.iTC_ID).get("State").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputState_xp)).sendKeys(sState);
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputZipCode_xp, "Zip Code text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputZipCode_xp);
			String sZipCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Zip").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputZipCode_xp)).sendKeys(sZipCode);					
								
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp, "Phone Number text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp);
			String sPhoneNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("PhoneNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp)).sendKeys(sPhoneNumber);					
							
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp, "Quote Email Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp);
			String sQuoteEmailAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Email").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp)).sendKeys(sQuoteEmailAddress);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_ComboRegion_xp, "Region Select Box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_ComboRegion_xp);
			Select region = new Select(driver.findElement(By.xpath(objRWModules.Offices_AddOffice_ComboRegion_xp)));
			region.selectByIndex(1);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp, "Property Walk Submit Email Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp);
			String sPropertyWalkSubmitEmailAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Email").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp)).sendKeys(sPropertyWalkSubmitEmailAddress);
			
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputCity_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_CityErrorMsgRequired_xp, "City Error Message", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_CityErrorMsgRequired_xp);

			String sCityMsg = driver.findElement(By.xpath(objRWModules.Offices_AddOffice_CityErrorMsgRequired_xp)).getText().toString().trim();
			if(sCityMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}			
			
			//*This field is required
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
			log.error( "Function TC27189 Failed!", e );
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
			
			log.info("Execution of Function TC27189 Completed");
		}
		return obj;
	} //End of function TC27189	
	
	
	//RW-60_Offices_TC024_Add Office_Required Field State Validation
	@SuppressWarnings("static-access")
	public Reporter TC27190(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27190 Started..");

		try {
					
			obj.repAddData( "Required Field State Validation", "", "", "");

			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
			fnLoadingPageWait();
			ClickByXpath(objRWModules.Offices_ViewOffice_BtnAddOffice_xp, "Add Office button",true);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp, "Office Name text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp);
			
			String sOfficeName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputOfficeName_xp)).sendKeys(sOfficeName);
			
			//fill all fields with value
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp, "Default Store Number text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp);				
			String sDefaultStoreNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("StoreNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp)).sendKeys(sDefaultStoreNumber);


			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputAddress_xp, "Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputAddress_xp);					
			String sAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Address").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputAddress_xp)).sendKeys(sAddress);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputCity_xp, "City text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputCity_xp);
			String sCity = mTestPhaseData.get(TestDriver.iTC_ID).get("City").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputCity_xp)).sendKeys(sCity);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputState_xp, "State text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputState_xp);
			String sState = mTestPhaseData.get(TestDriver.iTC_ID).get("State").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputState_xp)).sendKeys(sState);
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputZipCode_xp, "Zip Code text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputZipCode_xp);
			String sZipCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Zip").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputZipCode_xp)).sendKeys(sZipCode);					
								
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp, "Phone Number text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp);
			String sPhoneNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("PhoneNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp)).sendKeys(sPhoneNumber);					
							
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp, "Quote Email Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp);
			String sQuoteEmailAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Email").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp)).sendKeys(sQuoteEmailAddress);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_ComboRegion_xp, "Region Select Box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_ComboRegion_xp);
			Select region = new Select(driver.findElement(By.xpath(objRWModules.Offices_AddOffice_ComboRegion_xp)));
			region.selectByIndex(1);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp, "Property Walk Submit Email Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp);
			String sPropertyWalkSubmitEmailAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Email").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp)).sendKeys(sPropertyWalkSubmitEmailAddress);
			
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputState_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_StateErrorMsgRequired_xp, "State Error Message", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_StateErrorMsgRequired_xp);

			String sStateMsg = driver.findElement(By.xpath(objRWModules.Offices_AddOffice_StateErrorMsgRequired_xp)).getText().toString().trim();
			if(sStateMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}		
			
			
			//*This field is required
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
			log.error( "Function TC27190 Failed!", e );
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
			
			log.info("Execution of Function TC27190 Completed");
		}
		return obj;
	} //End of function TC27190
	
	
	//RW-60_Offices_TC025_Add Office_Required Field Zip Code Validation
	@SuppressWarnings("static-access")
	public Reporter TC27192(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27192 Started..");

		try {
					
			obj.repAddData( "Required Field Zip Code Validation", "", "", "");

			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
			fnLoadingPageWait();
			ClickByXpath(objRWModules.Offices_ViewOffice_BtnAddOffice_xp, "Add Office button",true);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp, "Office Name text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp);
			
			String sOfficeName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputOfficeName_xp)).sendKeys(sOfficeName);
			
			//fill all fields with value
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp, "Default Store Number text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp);				
			String sDefaultStoreNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("StoreNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp)).sendKeys(sDefaultStoreNumber);


			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputAddress_xp, "Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputAddress_xp);					
			String sAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Address").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputAddress_xp)).sendKeys(sAddress);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputCity_xp, "City text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputCity_xp);
			String sCity = mTestPhaseData.get(TestDriver.iTC_ID).get("City").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputCity_xp)).sendKeys(sCity);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputState_xp, "State text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputState_xp);
			String sState = mTestPhaseData.get(TestDriver.iTC_ID).get("State").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputState_xp)).sendKeys(sState);
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputZipCode_xp, "Zip Code text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputZipCode_xp);
			String sZipCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Zip").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputZipCode_xp)).sendKeys(sZipCode);					
								
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp, "Phone Number text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp);
			String sPhoneNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("PhoneNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp)).sendKeys(sPhoneNumber);					
							
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp, "Quote Email Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp);
			String sQuoteEmailAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Email").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp)).sendKeys(sQuoteEmailAddress);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_ComboRegion_xp, "Region Select Box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_ComboRegion_xp);
			Select region = new Select(driver.findElement(By.xpath(objRWModules.Offices_AddOffice_ComboRegion_xp)));
			region.selectByIndex(1);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp, "Property Walk Submit Email Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp);
			String sPropertyWalkSubmitEmailAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Email").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp)).sendKeys(sPropertyWalkSubmitEmailAddress);
			
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputZipCode_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_ZipCodeErrorMsgRequired_xp, "Zip Code Error Message", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_ZipCodeErrorMsgRequired_xp);

			String sZipCodeMsg = driver.findElement(By.xpath(objRWModules.Offices_AddOffice_ZipCodeErrorMsgRequired_xp)).getText().toString().trim();
			if(sZipCodeMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}			

			//*This field is required
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
			log.error( "Function TC27192 Failed!", e );
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
			
			log.info("Execution of Function TC27192 Completed");
		}
		return obj;
	} //End of function TC27192
	
	
	//RW-60_Offices_TC026_Add Office_Required Field Phone Number Validation
	@SuppressWarnings("static-access")
	public Reporter TC27191(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27191 Started..");

		try {
					
			obj.repAddData( "Required Field Phone Number Validation", "", "", "");

			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
			fnLoadingPageWait();
			ClickByXpath(objRWModules.Offices_ViewOffice_BtnAddOffice_xp, "Add Office button",true);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp, "Office Name text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp);
			
			String sOfficeName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputOfficeName_xp)).sendKeys(sOfficeName);
			
			//fill all fields with value
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp, "Default Store Number text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp);				
			String sDefaultStoreNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("StoreNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp)).sendKeys(sDefaultStoreNumber);


			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputAddress_xp, "Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputAddress_xp);					
			String sAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Address").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputAddress_xp)).sendKeys(sAddress);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputCity_xp, "City text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputCity_xp);
			String sCity = mTestPhaseData.get(TestDriver.iTC_ID).get("City").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputCity_xp)).sendKeys(sCity);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputState_xp, "State text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputState_xp);
			String sState = mTestPhaseData.get(TestDriver.iTC_ID).get("State").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputState_xp)).sendKeys(sState);
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputZipCode_xp, "Zip Code text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputZipCode_xp);
			String sZipCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Zip").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputZipCode_xp)).sendKeys(sZipCode);					
								
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp, "Phone Number text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp);
			String sPhoneNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("PhoneNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp)).sendKeys(sPhoneNumber);					
							
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp, "Quote Email Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp);
			String sQuoteEmailAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Email").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp)).sendKeys(sQuoteEmailAddress);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_ComboRegion_xp, "Region Select Box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_ComboRegion_xp);
			Select region = new Select(driver.findElement(By.xpath(objRWModules.Offices_AddOffice_ComboRegion_xp)));
			region.selectByIndex(1);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp, "Property Walk Submit Email Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp);
			String sPropertyWalkSubmitEmailAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Email").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp)).sendKeys(sPropertyWalkSubmitEmailAddress);
			
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_PhoneNumberErrorMsgRequired_xp, "Phone Number Error Message", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_PhoneNumberErrorMsgRequired_xp);

			String sPhoneNumberMsg = driver.findElement(By.xpath(objRWModules.Offices_AddOffice_PhoneNumberErrorMsgRequired_xp)).getText().toString().trim();
			if(sPhoneNumberMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}		

			//*This field is required
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
			log.error( "Function TC27191 Failed!", e );
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
			
			log.info("Execution of Function TC27191 Completed");
		}
		return obj;
	} //End of function TC27191
	
	//RW-60_Offices_TC027_Add Office_Required Field Quote Email Address Validation
	@SuppressWarnings("static-access")
	public Reporter TC27193(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27193 Started..");

		try {
					
			obj.repAddData( "Required Field Phone Number Validation", "", "", "");

			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
			fnLoadingPageWait();
			ClickByXpath(objRWModules.Offices_ViewOffice_BtnAddOffice_xp, "Add Office button",true);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp, "Office Name text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp);
			
			String sOfficeName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputOfficeName_xp)).sendKeys(sOfficeName);
			
			//fill all fields with value
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp, "Default Store Number text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp);				
			String sDefaultStoreNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("StoreNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp)).sendKeys(sDefaultStoreNumber);


			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputAddress_xp, "Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputAddress_xp);					
			String sAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Address").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputAddress_xp)).sendKeys(sAddress);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputCity_xp, "City text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputCity_xp);
			String sCity = mTestPhaseData.get(TestDriver.iTC_ID).get("City").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputCity_xp)).sendKeys(sCity);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputState_xp, "State text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputState_xp);
			String sState = mTestPhaseData.get(TestDriver.iTC_ID).get("State").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputState_xp)).sendKeys(sState);
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputZipCode_xp, "Zip Code text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputZipCode_xp);
			String sZipCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Zip").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputZipCode_xp)).sendKeys(sZipCode);					
								
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp, "Phone Number text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp);
			String sPhoneNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("PhoneNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp)).sendKeys(sPhoneNumber);					
							
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp, "Quote Email Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp);
			String sQuoteEmailAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Email").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp)).sendKeys(sQuoteEmailAddress);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_ComboRegion_xp, "Region Select Box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_ComboRegion_xp);
			Select region = new Select(driver.findElement(By.xpath(objRWModules.Offices_AddOffice_ComboRegion_xp)));
			region.selectByIndex(1);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp, "Property Walk Submit Email Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp);
			String sPropertyWalkSubmitEmailAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Email").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp)).sendKeys(sPropertyWalkSubmitEmailAddress);
			
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_QuoteEmailAddressErrorMsgRequired_xp, "Quote Email Address Error Message", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_QuoteEmailAddressErrorMsgRequired_xp);

			String sQuoteEmailAddressMsg = driver.findElement(By.xpath(objRWModules.Offices_AddOffice_QuoteEmailAddressErrorMsgRequired_xp)).getText().toString().trim();
			if(sQuoteEmailAddressMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}		

			//*This field is required
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
			log.error( "Function TC27193 Failed!", e );
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
			
			log.info("Execution of Function TC27193 Completed");
		}
		return obj;
	} //End of function TC27193
	
	
	//RW-60_Offices_TC028_Add Office_Required Field Address and City Validation
	@SuppressWarnings("static-access")
	public Reporter TC27194(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27194 Started..");

		try {
					
			obj.repAddData( "Required Field Address and City Validation", "", "", "");

			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
			fnLoadingPageWait();
			ClickByXpath(objRWModules.Offices_ViewOffice_BtnAddOffice_xp, "Add Office button",true);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp, "Office Name text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp);
			
			String sOfficeName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputOfficeName_xp)).sendKeys(sOfficeName);
			
			//fill all fields with value
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp, "Default Store Number text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp);				
			String sDefaultStoreNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("StoreNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp)).sendKeys(sDefaultStoreNumber);


			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputAddress_xp, "Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputAddress_xp);					
			String sAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Address").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputAddress_xp)).sendKeys(sAddress);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputCity_xp, "City text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputCity_xp);
			String sCity = mTestPhaseData.get(TestDriver.iTC_ID).get("City").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputCity_xp)).sendKeys(sCity);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputState_xp, "State text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputState_xp);
			String sState = mTestPhaseData.get(TestDriver.iTC_ID).get("State").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputState_xp)).sendKeys(sState);
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputZipCode_xp, "Zip Code text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputZipCode_xp);
			String sZipCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Zip").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputZipCode_xp)).sendKeys(sZipCode);					
								
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp, "Phone Number text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp);
			String sPhoneNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("PhoneNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp)).sendKeys(sPhoneNumber);					
							
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp, "Quote Email Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp);
			String sQuoteEmailAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Email").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp)).sendKeys(sQuoteEmailAddress);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_ComboRegion_xp, "Region Select Box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_ComboRegion_xp);
			Select region = new Select(driver.findElement(By.xpath(objRWModules.Offices_AddOffice_ComboRegion_xp)));
			region.selectByIndex(1);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp, "Property Walk Submit Email Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp);
			String sPropertyWalkSubmitEmailAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Email").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp)).sendKeys(sPropertyWalkSubmitEmailAddress);
			
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputAddress_xp)).clear();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputCity_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_AddressErrorMsgRequired_xp, "Address Error Message", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_AddressErrorMsgRequired_xp);

			String sAddressMsg = driver.findElement(By.xpath(objRWModules.Offices_AddOffice_AddressErrorMsgRequired_xp)).getText().toString().trim();
			if(sAddressMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}			
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_CityErrorMsgRequired_xp, "City Error Message", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_CityErrorMsgRequired_xp);

			String sCityMsg = driver.findElement(By.xpath(objRWModules.Offices_AddOffice_CityErrorMsgRequired_xp)).getText().toString().trim();
			if(sCityMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	
			
			//*This field is required
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
			log.error( "Function TC27194 Failed!", e );
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
			
			log.info("Execution of Function TC27194 Completed");
		}
		return obj;
	} //End of function TC27194	
	
	
	
	//RW-60_Offices_TC034_Add Office_Validate Office Name with duplicate Office name for same corporation
	@SuppressWarnings("static-access")
	public Reporter TC27245(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27245 Started..");

		try {
					
			obj.repAddData( "Adding a Duplicate Office name", "", "", "");

			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
			fnLoadingPageWait();
			ClickByXpath(objRWModules.Offices_ViewOffice_BtnAddOffice_xp, "Add Office button",true);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp, "Office Name text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp);
			
			int iRandomNum = fnRandomNum(1,10000);
			String sOfficeName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			SendKeyByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp, sOfficeName+iRandomNum, "Name");
			
			//Fill all values
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp, "Default Store Number text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp);				
			String sDefaultStoreNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("StoreNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp)).sendKeys(sDefaultStoreNumber);


			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputAddress_xp, "Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputAddress_xp);					
			String sAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Address").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputAddress_xp)).sendKeys(sAddress);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputCity_xp, "City text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputCity_xp);
			String sCity = mTestPhaseData.get(TestDriver.iTC_ID).get("City").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputCity_xp)).sendKeys(sCity);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputState_xp, "State text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputState_xp);
			String sState = mTestPhaseData.get(TestDriver.iTC_ID).get("State").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputState_xp)).sendKeys(sState);
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputZipCode_xp, "Zip Code text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputZipCode_xp);
			String sZipCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Zip").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputZipCode_xp)).sendKeys(sZipCode);					
								
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp, "Phone Number text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp);
			String sPhoneNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("PhoneNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp)).sendKeys(sPhoneNumber);					
							
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp, "Quote Email Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp);
			String sQuoteEmailAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Email").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp)).sendKeys(sQuoteEmailAddress);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_ComboRegion_xp, "Region Select Box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_ComboRegion_xp);
			Select region = new Select(driver.findElement(By.xpath(objRWModules.Offices_AddOffice_ComboRegion_xp)));
			region.selectByIndex(1);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp, "Property Walk Submit Email Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp);
			String sPropertyWalkSubmitEmailAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Email").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp)).sendKeys(sPropertyWalkSubmitEmailAddress);
			
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",true); 
			fnLoadingPageWait();
			
			//Again fill the form with same values
			ClickByXpath(objRWModules.Offices_ViewOffice_BtnAddOffice_xp, "Add Office button",true);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp, "Office Name text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp);
			SendKeyByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp, sOfficeName+iRandomNum, "Name");
			
			//Fill all values
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp, "Default Store Number text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp);				
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp)).sendKeys(sDefaultStoreNumber);


			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputAddress_xp, "Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputAddress_xp);					
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputAddress_xp)).sendKeys(sAddress);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputCity_xp, "City text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputCity_xp);
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputCity_xp)).sendKeys(sCity);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputState_xp, "State text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputState_xp);
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputState_xp)).sendKeys(sState);
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputZipCode_xp, "Zip Code text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputZipCode_xp);
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputZipCode_xp)).sendKeys(sZipCode);					
								
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp, "Phone Number text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp);
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp)).sendKeys(sPhoneNumber);					
							
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp, "Quote Email Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp);
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp)).sendKeys(sQuoteEmailAddress);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_ComboRegion_xp, "Region Select Box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_ComboRegion_xp);
			region.selectByIndex(1);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp, "Property Walk Submit Email Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp);
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp)).sendKeys(sPropertyWalkSubmitEmailAddress);
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",true);   //Once real time checking deployed for duplicate field, remove this line
			fnLoadingPageWait();
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_ErrorMsgDuplicateOfficeName_xp,"Duplicate Error Message", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_ErrorMsgDuplicateOfficeName_xp);
			String sErrorMsg =driver.findElement(By.xpath(objRWModules.Offices_AddOffice_ErrorMsgDuplicateOfficeName_xp)).getText().toString().trim();
			if(sErrorMsg.equalsIgnoreCase(objAppMessages.Offices_AddOffice_ErrorMsgDuplicateOfficeName_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Offices_AddOffice_ErrorMsgDuplicateOfficeName_msg+"' should be shown", "'"+objAppMessages.Offices_AddOffice_ErrorMsgDuplicateOfficeName_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Offices_AddOffice_ErrorMsgDuplicateOfficeName_msg+"' should be shown","'"+ objAppMessages.Offices_AddOffice_ErrorMsgDuplicateOfficeName_msg+"' not shown", "Fail");
			}
			
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
			log.error( "Function TC27245 Failed!", e );
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
			
			log.info("Execution of Function TC27245 Completed");
		}
		return obj;
	} //End of function TC27245
	
	
	//RW-60_Offices_TC032_Add Office_Save Office Details
	@SuppressWarnings("static-access")
	public Reporter TC27198(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27198 Started..");

		try {
					
			obj.repAddData( "Add and Save an Office", "", "", "");

			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
			fnLoadingPageWait();
			ClickByXpath(objRWModules.Offices_ViewOffice_BtnAddOffice_xp, "Add Office button",true);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp, "Office Name text box", true, true);
								
			int iRandomNum = fnRandomNum(1,10000);
			String sOfficeName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			SendKeyByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp, sOfficeName+iRandomNum, "Name");
			
			//Fill all values
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp, "Default Store Number text box", true, true);
			String sDefaultStoreNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("StoreNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp)).sendKeys(sDefaultStoreNumber);


			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputAddress_xp, "Address text box", true, true);		
			String sAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Address").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputAddress_xp)).sendKeys(sAddress);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputCity_xp, "City text box", true, true);
			String sCity = mTestPhaseData.get(TestDriver.iTC_ID).get("City").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputCity_xp)).sendKeys(sCity);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputState_xp, "State text box", true, true);
			String sState = mTestPhaseData.get(TestDriver.iTC_ID).get("State").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputState_xp)).sendKeys(sState);
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputZipCode_xp, "Zip Code text box", true, true);
			String sZipCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Zip").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputZipCode_xp)).sendKeys(sZipCode);					
								
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp, "Phone Number text box", true, true);
			String sPhoneNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("PhoneNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp)).sendKeys(sPhoneNumber);					
							
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp, "Quote Email Address text box", true, true);
			String sQuoteEmailAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Email").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp)).sendKeys(sQuoteEmailAddress);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_ComboRegion_xp, "Region Select Box", true, true);
			Select region = new Select(driver.findElement(By.xpath(objRWModules.Offices_AddOffice_ComboRegion_xp)));
			//region.selectByIndex(1);
			region.selectByVisibleText("Test");  //for demo purpose
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp, "Property Walk Submit Email Address text box", true, true);
			String sPropertyWalkSubmitEmailAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Email").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp)).sendKeys(sPropertyWalkSubmitEmailAddress);
			
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",true); 
			fnLoadingPageWait();
			
			//obj.repAddData( "Verify Office Name in Database", "", "", "");
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
			log.error( "Function TC27198 Failed!", e );
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
			
			log.info("Execution of Function TC27198 Completed");
		}
		return obj;
	} //End of function TC27198	
	
	
	//RW-60_Offices_TC033_Add Office_Cancel Adding Office Details
	@SuppressWarnings("static-access")
	public Reporter TC27199(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27199 Started..");

		try {
					
			obj.repAddData( "Cancelling an Office", "", "", "");
			
			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
			fnLoadingPageWait();
			ClickByXpath(objRWModules.Offices_ViewOffice_BtnAddOffice_xp, "Add Office button",true);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp, "Office Name text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp);
			
			int iRandomNum = fnRandomNum(1,10000);
			String sOfficeName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			SendKeyByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp, sOfficeName+iRandomNum, "Name");
			
			//Fill all values
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp, "Default Store Number text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp);				
			String sDefaultStoreNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("StoreNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp)).sendKeys(sDefaultStoreNumber);


			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputAddress_xp, "Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputAddress_xp);					
			String sAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Address").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputAddress_xp)).sendKeys(sAddress);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputCity_xp, "City text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputCity_xp);
			String sCity = mTestPhaseData.get(TestDriver.iTC_ID).get("City").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputCity_xp)).sendKeys(sCity);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputState_xp, "State text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputState_xp);
			String sState = mTestPhaseData.get(TestDriver.iTC_ID).get("State").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputState_xp)).sendKeys(sState);
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputZipCode_xp, "Zip Code text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputZipCode_xp);
			String sZipCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Zip").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputZipCode_xp)).sendKeys(sZipCode);					
								
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp, "Phone Number text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp);
			String sPhoneNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("PhoneNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp)).sendKeys(sPhoneNumber);					
							
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp, "Quote Email Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp);
			String sQuoteEmailAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Email").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp)).sendKeys(sQuoteEmailAddress);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_ComboRegion_xp, "Region Select Box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_ComboRegion_xp);
			Select region = new Select(driver.findElement(By.xpath(objRWModules.Offices_AddOffice_ComboRegion_xp)));
			region.selectByIndex(1);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp, "Property Walk Submit Email Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp);
			String sPropertyWalkSubmitEmailAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Email").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp)).sendKeys(sPropertyWalkSubmitEmailAddress);
			
			
			//*This field is required
			
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true); 
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
			log.error( "Function TC27199 Failed!", e );
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
			
			log.info("Execution of Function TC27199 Completed");
		}
		return obj;
	} //End of function TC27199	
	
	
	//RW-60_Offices_TC031_Add Office_Check View Offices
	@SuppressWarnings("static-access")
	public Reporter TC27197(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27197 Started..");

		try {
					
			obj.repAddData( "Viewing the Offices", "", "", "");

			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
			fnLoadingPageWait();

			HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWModules.Common_ViewModules_Table_xp, "Offices");
			fnCheckSortedList(mTableData,"Office Name",1);
			System.out.println("Sorted Functionality Tested Successfully");
			////////////////////Sorting Logic End////////////////////////////

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC27197 Failed!", e );
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
			log.info("Execution of Function TC27197 Completed");
		}
		return obj;
	} //End of function TC27197	
	
	
	//RW-60_Offices_TC029_Add Office_View Regions in Region field
	@SuppressWarnings("static-access")
	public Reporter TC27195(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27195 Started..");

		try {
					
			obj.repAddData( "Viewing the Regions in Region field", "", "", "");

			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
			fnLoadingPageWait();
			ClickByXpath(objRWModules.Offices_ViewOffice_BtnAddOffice_xp, "Add Office button",true);
			
			fnCheckComboBoxSorting(objRWModules.Offices_AddOffice_ComboRegion_xp,"Region", "Select Region");
			
			Thread.sleep(2000);
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true); 
			fnLoadingPageWait();

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC27195 Failed!", e );
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
			log.info("Execution of Function TC27195 Completed");
		}
		return obj;
	} //End of function TC27195	
	
	
	//RW-60_Offices_TC035_Add Office_Added Office in User page
	@SuppressWarnings("static-access")
	public Reporter TC27246(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC27246 Started..");

		try {
					
			obj.repAddData( "Added Office in User page", "", "", "");

			ClickByXpath(objRWModules.Offices_GenOffice_LinkOfficesOption_xp, "Offices Link",true);
			fnLoadingPageWait();
			ClickByXpath(objRWModules.Offices_ViewOffice_BtnAddOffice_xp, "Add Office button",true);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp, "Office Name text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp);
			
			int iRandomNum = fnRandomNum(1,10000);
			String sOfficeName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			SendKeyByXpath(objRWModules.Offices_AddOffice_InputOfficeName_xp, sOfficeName+iRandomNum, "Name");
			
			//Fill all values
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp, "Default Store Number text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp);				
			String sDefaultStoreNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("StoreNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputDefaultStoreNumber_xp)).sendKeys(sDefaultStoreNumber);


			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputAddress_xp, "Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputAddress_xp);					
			String sAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Address").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputAddress_xp)).sendKeys(sAddress);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputCity_xp, "City text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputCity_xp);
			String sCity = mTestPhaseData.get(TestDriver.iTC_ID).get("City").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputCity_xp)).sendKeys(sCity);

			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputState_xp, "State text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputState_xp);
			String sState = mTestPhaseData.get(TestDriver.iTC_ID).get("State").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputState_xp)).sendKeys(sState);
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputZipCode_xp, "Zip Code text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputZipCode_xp);
			String sZipCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Zip").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputZipCode_xp)).sendKeys(sZipCode);					
								
								
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp, "Phone Number text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp);
			String sPhoneNumber = mTestPhaseData.get(TestDriver.iTC_ID).get("PhoneNumber").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputPhoneNumber_xp)).sendKeys(sPhoneNumber);					
							
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp, "Quote Email Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp);
			String sQuoteEmailAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Email").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_InputQuoteEmailAddress_xp)).sendKeys(sQuoteEmailAddress);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_ComboRegion_xp, "Region Select Box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_ComboRegion_xp);
			Select region = new Select(driver.findElement(By.xpath(objRWModules.Offices_AddOffice_ComboRegion_xp)));
			region.selectByIndex(1);
			
			fnCheckFieldDisplayByXpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp, "Property Walk Submit Email Address text box", true, true);
			HighlightElementByXpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp);
			String sPropertyWalkSubmitEmailAddress = mTestPhaseData.get(TestDriver.iTC_ID).get("Email").toString().trim();
			driver.findElement(By.xpath(objRWModules.Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp)).sendKeys(sPropertyWalkSubmitEmailAddress);
			
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",true); 
			fnLoadingPageWait();
			
			obj.repAddData( "Verify Added Office in User page", "", "", "");
			//Put code here
			
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
			log.error( "Function TC27246 Failed!", e );
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
			
			log.info("Execution of Function TC27246 Completed");
		}
		return obj;
	} //End of function TC27246	

	
}