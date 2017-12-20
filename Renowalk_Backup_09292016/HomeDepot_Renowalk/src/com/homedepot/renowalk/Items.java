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

public class Items extends TestDriver {
	RenowalkModules objRWModules = new RenowalkModules();
	RenowalkHome objRWHome = new RenowalkHome();
	AppMessages objAppMessages = new AppMessages();

	//RW-225_Items_TC001_View Items_View Items Ascending
	@SuppressWarnings("static-access")
	public Reporter TC31909(Reporter obj) throws Exception
	{
		Boolean bLoginFlag = false;	
		log.info("Execution of Function TC31909 Started..");
		

		try {
					
			obj.repAddData( "View Items", "", "", "");
			
			//fnSelectCorpOffice(sCorporation, sOffice);
			fnSelectCorpOffice(sCorporation, sOffice);
			
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items Link",true);
			
			fnLoadingPageWait();
			
			fnSelectFromComboBoxXpath(objRWModules.Common_ViewModules_ComboPageSize_xp, "VIEW ALL");
			fnLoadingPageWait();
			
			HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWModules.Common_ViewModules_Table_xp, "Items");
			fnCheckSortedList(mTableData,"Name",1);
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31909 Failed!", e );
		}
		finally {
			
			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			
			log.info("Execution of Function TC31909 Completed");
		}
		return obj;
	} //End of function TC31909	
	
	
	//RW-225_Items_TC001_View Items_View Items Ascending
	@SuppressWarnings("static-access")
	public Reporter TC31910(Reporter obj) throws Exception
	{
		Boolean bLoginFlag = false;	
		log.info("Execution of Function TC31910 Started..");
		

		try {
					
				obj.repAddData( "View Items", "", "", "");
				//fnSelectFromComboBoxXpath(objRWModules.Common_AllModules_ComboCorporateName_xp, "Select");
				fnSelectCorpOffice("Select", sOffice);
				ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items Link",true);
				fnVerifyDialogBox("OfficeCode",1);
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31910 Failed!", e );
		}
		finally {
			
			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			
			log.info("Execution of Function TC31910 Completed");
		}
		return obj;
	} //End of function TC31910	
	
	//RW-225_Items_TC003_View Items_Verify columns
	@SuppressWarnings("static-access")
	public Reporter TC31911(Reporter obj) throws Exception
	{
		Boolean bLoginFlag = false;	
		log.info("Execution of Function TC31911 Started..");
		

		try {
					
				obj.repAddData( "View Items", "", "", "");
				fnSelectCorpOffice(sCorporation, sOffice);
				ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items Link",true);
										
				WebElement eleTable = driver.findElement(By.xpath(objRWModules.Common_ViewModules_Table_xp));
				List<WebElement> arrHeaderColumns = eleTable.findElements(By.xpath("./thead/tr/th"));  //Get the header
				System.out.println("Rows Size>>>>"+arrHeaderColumns.size());
				fnVerifyHeaders(arrHeaderColumns,0,"Item Name");
				fnVerifyHeaders(arrHeaderColumns,1,"Row Type");
				fnVerifyHeaders(arrHeaderColumns,2,"GL Code");
				fnVerifyHeaders(arrHeaderColumns,3,"Default Material");
				fnVerifyHeaders(arrHeaderColumns,4,"Default Labor");
				fnVerifyHeaders(arrHeaderColumns,5,"Required");
			
				HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWModules.Common_ViewModules_Table_xp, "Items");
				boolean bCopyEditDelete = true;
				boolean bCheckBox = true;
				int iRow = 0;
				for(iRow=1;iRow<=mTableData.size();iRow++)
				{
					String[] arrCopyEditDelete = mTableData.get(iRow).get(7).toString().trim().split(";;");
					if(!arrCopyEditDelete[0].toString().trim().equalsIgnoreCase("Copy") && !arrCopyEditDelete[1].toString().trim().equalsIgnoreCase("Edit") && !arrCopyEditDelete[2].toString().trim().equalsIgnoreCase("Delete"))
					{
						bCopyEditDelete = false;
						break;
					}
					
					if(!mTableData.get(iRow).get(8).toString().trim().equalsIgnoreCase("checkbox"))
					{
						bCheckBox = false;
						break;
					}
				
				}
				
				if(bCopyEditDelete==true && bCheckBox==true)
				{
					obj.repAddData( "Verify Copy, Edit, Delete and Checkbox Options", "Copy, Edit, Delete and Checkbox Options should be displayed in front of each row", "Copy, Edit, Delete and Checkbox Options are displayed in front of each row", "Pass");
				}
				else
				{
					obj.repAddData( "Verify Copy, Edit, Delete and Checkbox Options", "Copy, Edit, Delete and Checkbox Options should be displayed in front of each row", "Copy, Edit, Delete and Checkbox Options are not displayed for row = "+iRow, "Fail");
				}
		}
		
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31911 Failed!", e );
		}
		finally {
			
			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			
			log.info("Execution of Function TC31911 Completed");
		}
		return obj;
	} //End of function TC31911	
	
	
	//RW-225_Items_TC005_View Items_Verify ADD ITEM option
	@SuppressWarnings("static-access")
	public Reporter TC31912(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31912 Started..");

		try {
					
			obj.repAddData( "Availability of DELETE SELECTED button", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items Link",true);
			fnLoadingPageWait();
			
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnDeleteSelected_xp,"'DELETE SELECTED' button",true,true);
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31912 Failed!", e );
		}
		finally {

			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC31912 Completed");
		}
		return obj;
	} //End of function TC31912	
	
	//RW-225_Items_TC005_View Items_Verify ADD ITEM option
	@SuppressWarnings("static-access")
	public Reporter TC31913(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31913 Started..");

		try {
					
			obj.repAddData( "Availability of ADD ITEM button", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items Link",true);
			fnLoadingPageWait();
			
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31913 Failed!", e );
		}
		finally {

			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC31913 Completed");
		}
		return obj;
	} //End of function TC31913	
	
	
	//RW-225_Items_TC006_View Items_Verify no items for no property
	@SuppressWarnings("static-access")
	public Reporter TC31914(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31914 Started..");

		try {
					
			obj.repAddData( "Verify No Items for No Property", "", "", "");
			/*fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items Link",true);
			fnLoadingPageWait();*/
			
			//Write Code here once no property is there 

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31914 Failed!", e );
		}
		finally {

			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC31914 Completed");
		}
		return obj;
	} //End of function TC31914	
	
	//RW-225_Items_TC007_View Items_Verify table heading displayed by default
	@SuppressWarnings("static-access")
	public Reporter TC31915(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31915 Started..");

		try {
					
			obj.repAddData( "Verify table heading displayed by default", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items Link",true);
			fnLoadingPageWait();
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_LabelCurrentItems_xp,"'Current Items' label",true,true);
			

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31915 Failed!", e );
		}
		finally {

			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC31915 Completed");
		}
		return obj;
	} //End of function TC31915	
	
	//RW-225_Items_TC008_View Items_Verify loading icon
	@SuppressWarnings("static-access")
	public Reporter TC31916(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31916 Started..");

		try {
					
			obj.repAddData( "Verify loading icon", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items Link",true);
			fnLoadingPageWait();			//Currently not coming. loading icon should come on every click on left hand side. Defect already raised.

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31916 Failed!", e );
		}
		finally {

			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC31916 Completed");
		}
		return obj;
	} //End of function TC31916	
	
	
	//RW-225_Items_TC009_View Items_Availability of Pagination options
	@SuppressWarnings("static-access")
	public Reporter TC31917(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31917 Started..");

		try {
					
			obj.repAddData( "Availability of Pagination Options", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items Link",true);
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
			log.error( "Function TC31917 Failed!", e );
		}
		finally {

			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC31917 Completed");
		}
		return obj;
	} //End of function TC31917	
	
	
	//RW-225_Items_TC010_View Items_Validate Current Items table using pagination option
	@SuppressWarnings("static-access")
	public Reporter TC31918(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31918 Started..");

		try {
					
			obj.repAddData( "Items Table Count for VIEW ALL Option", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items Link",true);
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
			log.error( "Function TC31918 Failed!", e );
		}
		finally {

			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC31918 Completed");
		}
		return obj;
	} //End of function TC31918	
	

	
	//RW-225_Items_TC011_View Items_Validate Pagination for option 10 for current page
	@SuppressWarnings("static-access")
	public Reporter TC31919(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31919 Started..");

		try {
					
			obj.repAddData("Validate Pagination for Option 10", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items Link",true);
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
			log.error( "Function TC31919 Failed!", e );
		}
		finally {

			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC31919 Completed");
		}
		return obj;
	} //End of function TC31919	
	
	//RW-225_Items_TC012_View Items_Validate Pagination for option 10 for all the pages
	@SuppressWarnings("static-access")
	public Reporter TC31920(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31920 Started..");

		try {
					
			obj.repAddData("Validate Pagination for Option 10", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items Link",true);
			fnLoadingPageWait();	
							
			HighlightElementByXpath(objRWModules.Common_ViewModules_ComboPageSize_xp);
			Select select = new Select(driver.findElement(By.xpath(objRWModules.Common_ViewModules_ComboPageSize_xp)));
			List<WebElement> arrPageSize = select.getOptions();
			System.out.println("Page Combobox Size>>>>"+arrPageSize.size());
			
			fnVerifyComboBoxValues(arrPageSize, 0, "10 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 1, "20 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 2, "VIEW ALL");
			obj.repAddData("Select option '10 PER PAGE' and verify all pages", "", "", "");
			select.selectByVisibleText("10 PER PAGE");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			fnVerifyNumofRecords("10");  //First time validation
			
			boolean bMultiPageExists = fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_LabelTotalPages_xp, "Total No of Pages", false,true);
			if(bMultiPageExists==true)
			{
				int iCurrentPage = 1;
				String sTotalPages = fnGetGUITextXpath(RenowalkModules.Common_ViewModules_LabelTotalPages_xp);
				while(iCurrentPage<Integer.parseInt(sTotalPages))
				{
					ClickByXpath(RenowalkModules.Common_ViewModules_BtnNextLink_xp, "Next button", false);
					fnVerifyNumofRecords("10");
					iCurrentPage++;
				}
			}
			else
			{
				obj.repAddData( "Verify Pagination for all pages", "Pagination for all pages with option 10 should be validated", "Pagination for all pages with option 10 cannot be validated as no of records are less than 10", "Pass");
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31920 Failed!", e );
		}
		finally {

			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC31920 Completed");
		}
		return obj;
	} //End of function TC31920	
	

	//RW-225_Items_TC013_View Items_Validate Pagination for option 10 with specific page
	@SuppressWarnings("static-access")
	public Reporter TC31921(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31921 Started..");

		try {
					
			obj.repAddData("Validate pagination for any specific page with option 10", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items Link",true);
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
			//fnVerifyNumofRecords("10");
			
			boolean bElementFound = fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",false,true);
			int iRows = fnGetTableRowsCount(objRWModules.Common_ViewModules_Table_xp); 
			
			if(bElementFound==true || iRows>10)
			{
				String sTotalPageNum = driver.findElement(By.xpath(RenowalkModules.Common_ViewModules_LabelTotalPages_xp)).getText();
				int iTotalPageNum =  Integer.parseInt(sTotalPageNum);
				int iRandomNum = fnRandomNum(1,iTotalPageNum);
				SendKeyByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp, String.valueOf(iRandomNum),"Page Number");
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
			log.error( "Function TC31921 Failed!", e );
		}
		finally {

			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC31921 Completed");
		}
		return obj;
	} //End of function TC31921	
	

	//RW-225_Items_TC014_View Items_Validate Pagination for option 20 for current page
	@SuppressWarnings("static-access")
	public Reporter TC31922(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31922 Started..");

		try {
					
			obj.repAddData("Validate Pagination for Option 20", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items Link",true);
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
			log.error( "Function TC31922 Failed!", e );
		}
		finally {

			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC31922 Completed");
		}
		return obj;
	} //End of function TC31922	
	
	//RW-225_Items_TC015_View Items_Validate Pagination for option 20 for all the pages
	@SuppressWarnings("static-access")
	public Reporter TC31923(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31923 Started..");

		try {
					
			obj.repAddData("Validate Pagination for Option 20", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items Link",true);
			fnLoadingPageWait();	
							
			HighlightElementByXpath(objRWModules.Common_ViewModules_ComboPageSize_xp);
			Select select = new Select(driver.findElement(By.xpath(objRWModules.Common_ViewModules_ComboPageSize_xp)));
			List<WebElement> arrPageSize = select.getOptions();
			System.out.println("Page Combobox Size>>>>"+arrPageSize.size());
			
			fnVerifyComboBoxValues(arrPageSize, 0, "10 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 1, "20 PER PAGE");
			fnVerifyComboBoxValues(arrPageSize, 2, "VIEW ALL");
			obj.repAddData("Select option '20 PER PAGE' and verify all pages", "", "", "");
			select.selectByVisibleText("20 PER PAGE");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			fnVerifyNumofRecords("20");  //First time validation
			
			boolean bMultiPageExists = fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_LabelTotalPages_xp, "Total No of Pages", false,true);
			if(bMultiPageExists==true)
			{
				int iCurrentPage = 1;
				String sTotalPages = fnGetGUITextXpath(RenowalkModules.Common_ViewModules_LabelTotalPages_xp);
				while(iCurrentPage<Integer.parseInt(sTotalPages))
				{
					ClickByXpath(RenowalkModules.Common_ViewModules_BtnNextLink_xp, "Next button", false);
					fnVerifyNumofRecords("20");
					iCurrentPage++;
				}
			}
			else
			{
				obj.repAddData( "Verify Pagination for all pages", "Pagination for all pages with option 20 should be validated", "Pagination for all pages with option 20 cannot be validated as no of records are less than 20", "Pass");
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31923 Failed!", e );
		}
		finally {

			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC31923 Completed");
		}
		return obj;
	} //End of function TC31923	
	

	//RW-225_Items_TC016_View Items_Validate Pagination for option 20 with specific page
	@SuppressWarnings("static-access")
	public Reporter TC31924(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31924 Started..");

		try {
					
			obj.repAddData("Validate pagination for any specific page with option 20", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items Link",true);
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
			//fnVerifyNumofRecords("20");
			
			boolean bElementFound = fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",false,true);
			int iRows = fnGetTableRowsCount(objRWModules.Common_ViewModules_Table_xp); 
			
			if(bElementFound==true || iRows>20)
			{
				String sTotalPageNum = driver.findElement(By.xpath(RenowalkModules.Common_ViewModules_LabelTotalPages_xp)).getText();
				int iTotalPageNum =  Integer.parseInt(sTotalPageNum);
				int iRandomNum = fnRandomNum(1,iTotalPageNum);
				SendKeyByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp, String.valueOf(iRandomNum),"Page Number");
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
			log.error( "Function TC31924 Failed!", e );
		}
		finally {

			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC31924 Completed");
		}
		return obj;
	} //End of function TC31924	
	

	//RW-225_Items_TC017_View Items_Validate for Page Counter and Navigation
	@SuppressWarnings("static-access")
	public Reporter TC31925(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31925 Started..");

		try {
					
			obj.repAddData("Validate Page Counter and Navigation", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items Link",true);
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
			
			obj.repAddData("Select option '20 PER PAGE'", "", "", "");
			select.selectByVisibleText("20 PER PAGE");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			if(bElementFound==true || iRows>20)
			{
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_BtnPreviousLink_xp,"'Previous' button",true,true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_BtnNextLink_xp,"'Next' button",true,true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",true,true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_LabelTotalPages_xp, "Total No of Pages", true,true);
			}
			else
			{
				obj.repAddData( "Verify Pagination", "Pagination for any page with option '20 PER PAGE' should be validated", "Pagination with option '20 PER PAGE' cannot be validated as no of records are less than 20", "Pass");
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31925 Failed!", e );
		}
		finally {

			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC31925 Completed");
		}
		return obj;
	} //End of function TC31925	
	
	
	//Spencer Tests
	//Add Item
	
	//RW-239_Items_TC001_ADD ITEM_Verify ADD ITEM view
	@SuppressWarnings("static-access")
	public Reporter TC37193(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37193 Started..");

		try {
					
			obj.repAddData( "Verify Add Item Page View", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			obj.repAddData( "Navigated successfully to Add Item page, verifying all fields now...", "", "", "");
			///Check all Add Item fields
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_ItemName_nm,"Name",true,true);
			//Row Type
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_RowTypeSelector_nm,"Row Type",true,true);
			//Required check box
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_RequiredCheckbox_nm,"Required",true,true);
			//Non-budget Item check box
			fnCheckFieldDisplayById(RenowalkModules.Items_AddItem_NonBudgetCheckbox_id,"Non-Budget Item",true,true);
			//Default Material
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_DefaultMaterial_nm,"Default Material",true,true);
			//Default Labor
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_DefaultLabor_nm,"Default Labor",true,true);
			//Default Hours
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_DefaultHours_nm,"Default Hours",true,true);
			//GL Code
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_GLCode_nm, "GL Code",true,true);
			//Category
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_Category_nm, "Category",true,true);
			//Sub Category
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_Subcategory_nm, "Subcategory",true,true);
			//Comments
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_ItemComment_nm,"Comment Box",true,true);
			//Products
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_AddItem_ProductsPanelHeader_xp,"Products:",true,true);
			obj.repAddData("Found all objects. Closing form.", "", "", "");
			
			//Cancel Post Condition
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37193 Failed!", e );
		}
		finally {

			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC35862 Completed");
		}
		return obj;
	}
	//End of function TC37193
	
	//RW-239_Items_TC002_ADD ITEM_Verify the Row Type values
	@SuppressWarnings("static-access")
	public Reporter TC37194(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37194 Started..");

		try {
					
			obj.repAddData( "Verify Add Item Row Type values", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			obj.repAddData( "Navigated successfully to Add Item page, verifying row type fields now...", "", "", "");
			//Row Type
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_RowTypeSelector_nm,"Row Type",true,true);
			HighlightElementByName(objRWModules.Items_AddItem_RowTypeSelector_nm);
			Select select = new Select(driver.findElement(By.name(objRWModules.Items_AddItem_RowTypeSelector_nm)));
			List<WebElement> arrRowTypes = select.getOptions();
			//System.out.println("Row Type Option>>>>"+arrRowTypes.size());
			fnVerifyComboBoxValues(arrRowTypes, 1, "Always Added");
			fnVerifyComboBoxValues(arrRowTypes, 2, "Basic Comment");
			fnVerifyComboBoxValues(arrRowTypes, 3, "Default Package Kit");
			fnVerifyComboBoxValues(arrRowTypes, 4, "Increment Row Type");
			fnVerifyComboBoxValues(arrRowTypes, 5, "Multiple Sku Display");
			fnVerifyComboBoxValues(arrRowTypes, 6, "Optional Increment Row Type");
			fnVerifyComboBoxValues(arrRowTypes, 7, "Package Row Type");
			fnVerifyComboBoxValues(arrRowTypes, 8, "Tenant Only");
			fnVerifyComboBoxValues(arrRowTypes, 9, "Whole Budget Percent");
			fnVerifyComboBoxValues(arrRowTypes, 10, "Whole House SqFT");
			//Cancel out
			obj.repAddData("Found all Row Type options. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37194 Failed!", e );
		}
		finally {

			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC37194 Completed");
		}
		return obj;
	}
	//End of Function 37194
	
	//37195 through 37204 (10 items) begin
	//RW-239_Items_TC003_ADD ITEM_Verify Prompt for required fields_Always Added Row Type
	@SuppressWarnings("static-access")
	public Reporter TC37195(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37195 Started..");
		try {
			
			obj.repAddData( "Verify Add Item required texts for Always Added type", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Always Added");
			
			//Enter and clear name field
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);

			String sItemName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sItemName);
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgItemNameRequired_xp, "Item name Error Message", true, true);

			String sItemNameMsg = driver.findElement(By.xpath(objRWModules.Items_AddItem_ErrorMsgItemNameRequired_xp)).getText().toString().trim();
			if(sItemNameMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	
			
			obj.repAddData("Verified Item Name Required error message.", "", "", "");
			
			String sDefaultMaterial, sDefaultLabor = new String();
			sDefaultMaterial = sDefaultLabor = Integer.toString(fnRandomNum( 2, 20));
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultMaterial_nm, "Default Material text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultMaterial_nm)).sendKeys(sDefaultMaterial);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultMaterial_nm)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgDefaultMaterialRequired_xp, "Default Material Error Message", true, true);

			String sDefaultMaterialMsg = driver.findElement(By.xpath(objRWModules.Items_AddItem_ErrorMsgDefaultMaterialRequired_xp)).getText().toString().trim();
			if(sDefaultMaterialMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	
			
			obj.repAddData("Verified Default Material Required error message.", "", "", "");
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultLabor_nm, "Default Labor text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultLabor_nm)).sendKeys(sDefaultLabor);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultLabor_nm)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgDefaultLaborRequired_xp, "Default Labor Error Message", true, true);
			
			String sDefaultLaborMsg = driver.findElement(By.xpath(objRWModules.Items_AddItem_ErrorMsgDefaultLaborRequired_xp)).getText().toString().trim();
			if(sDefaultLaborMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	
			
			
			
			//Cancel out
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
			ClickByXpath(objRWModules.Common_CancelModule_BtnYes,"Cancel Confirm",false);;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37195 Failed!", e );
		}
		return obj;
	}
	//End of Function 37195
	//RW-239_Items_TC004_ADD ITEM_Verify Prompt for required fields_Basic Comment Row Type
	@SuppressWarnings("static-access")
	public Reporter TC37196(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37196 Started..");
		try {
			
			obj.repAddData( "Verify Add Item required texts for Basic Comment type", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Basic Comment");
			
			//Enter and clear name field
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);

			String sItemName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sItemName);
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgItemNameRequired_xp, "Item name Error Message", true, true);

			String sItemNameMsg = driver.findElement(By.xpath(objRWModules.Items_AddItem_ErrorMsgItemNameRequired_xp)).getText().toString().trim();
			if(sItemNameMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	
			
			obj.repAddData("Verified Item Name Required error message.", "", "", "");
			
			String sDefaultMaterial, sDefaultLabor = new String();
			sDefaultMaterial = sDefaultLabor = Integer.toString(fnRandomNum( 2, 20));
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultMaterial_nm, "Default Material text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultMaterial_nm)).sendKeys(sDefaultMaterial);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultMaterial_nm)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgDefaultMaterialRequired_xp, "Default Material Error Message", true, true);

			String sDefaultMaterialMsg = driver.findElement(By.xpath(objRWModules.Items_AddItem_ErrorMsgDefaultMaterialRequired_xp)).getText().toString().trim();
			if(sDefaultMaterialMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	
			
			obj.repAddData("Verified Default Material Required error message.", "", "", "");
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultLabor_nm, "Default Labor text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultLabor_nm)).sendKeys(sDefaultLabor);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultLabor_nm)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgDefaultLaborRequired_xp, "Default Labor Error Message", true, true);
			
			String sDefaultLaborMsg = driver.findElement(By.xpath(objRWModules.Items_AddItem_ErrorMsgDefaultLaborRequired_xp)).getText().toString().trim();
			if(sDefaultLaborMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	
			
			
			
			//Cancel out
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
			ClickByXpath(objRWModules.Common_CancelModule_BtnYes,"Cancel Confirm",false);;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37196 Failed!", e );
		}
		return obj;
	}
	//End of Function 37196
	//RW-239_Items_TC005_ADD ITEM_Verify Prompt for required fields_Default Package Kit Row Type
	@SuppressWarnings("static-access")
	public Reporter TC37197(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37197 Started..");
		try {
			
			obj.repAddData( "Verify Add Item required texts for Default Package Kit type", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Default Package Kit");
			
			//Enter and clear name field
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);

			String sItemName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sItemName);
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgItemNameRequired_xp, "Item name Error Message", true, true);

			String sItemNameMsg = driver.findElement(By.xpath(objRWModules.Items_AddItem_ErrorMsgItemNameRequired_xp)).getText().toString().trim();
			if(sItemNameMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	
			
			obj.repAddData("Verified Item Name Required error message.", "", "", "");
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Select");
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgRowTypeRequired_xp, "Row Type Required error message", true, true);
			
			String sRowTypeMsg = driver.findElement(By.xpath(objRWModules.Items_AddItem_ErrorMsgRowTypeRequired_xp)).getText().toString().trim();
			if(sRowTypeMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	
			
			
			
			//Cancel out
			obj.repAddData("Verified Row Type Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
			ClickByXpath(objRWModules.Common_CancelModule_BtnYes,"Cancel Confirm",false);;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37197 Failed!", e );
		}
		return obj;
	}
	//End of Function 37197
	//RW-239_Items_TC006_ADD ITEM_Verify Prompt for required fields_Increment Row Type Row Type
	@SuppressWarnings("static-access")
	public Reporter TC37198(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37198 Started..");
		try {
			
			obj.repAddData( "Verify Add Item required texts for Increment Row type", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Increment Row Type");
			
			//Enter and clear name field
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);

			String sItemName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sItemName);
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgItemNameRequired_xp, "Item name Error Message", true, true);

			String sItemNameMsg = driver.findElement(By.xpath(objRWModules.Items_AddItem_ErrorMsgItemNameRequired_xp)).getText().toString().trim();
			if(sItemNameMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	
			
			obj.repAddData("Verified Item Name Required error message.", "", "", "");
			
			String sDefaultMaterial, sDefaultLabor = new String();
			sDefaultMaterial = sDefaultLabor = Integer.toString(fnRandomNum( 2, 20));
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultMaterial_nm, "Default Material text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultMaterial_nm)).sendKeys(sDefaultMaterial);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultMaterial_nm)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgDefaultMaterialRequired_xp, "Default Material Error Message", true, true);

			String sDefaultMaterialMsg = driver.findElement(By.xpath(objRWModules.Items_AddItem_ErrorMsgDefaultMaterialRequired_xp)).getText().toString().trim();
			if(sDefaultMaterialMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	
			
			obj.repAddData("Verified Default Material Required error message.", "", "", "");
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultLabor_nm, "Default Labor text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultLabor_nm)).sendKeys(sDefaultLabor);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultLabor_nm)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgDefaultLaborRequired_xp, "Default Labor Error Message", true, true);
			
			String sDefaultLaborMsg = driver.findElement(By.xpath(objRWModules.Items_AddItem_ErrorMsgDefaultLaborRequired_xp)).getText().toString().trim();
			if(sDefaultLaborMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Select");
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgRowTypeRequired_xp, "Row Type Required error message", true, true);
			
			String sRowTypeMsg = driver.findElement(By.xpath(objRWModules.Items_AddItem_ErrorMsgRowTypeRequired_xp)).getText().toString().trim();
			if(sRowTypeMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	
			
			
			
			//Cancel out
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
			ClickByXpath(objRWModules.Common_CancelModule_BtnYes,"Cancel Confirm",false);;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37198 Failed!", e );
		}
		return obj;
	}
	//End of Function 37198
	//RW-239_Items_TC007_ADD ITEM_Verify Prompt for required fields_Multiple SKU Display Row Type
	@SuppressWarnings("static-access")
	public Reporter TC37199(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37199 Started..");
		try {
			
			obj.repAddData( "Verify Add Item required texts for Multiple SKU Display type", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Multiple Sku Display");
			
			//Enter and clear name field
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);

			String sItemName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sItemName);
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgItemNameRequired_xp, "Item name Error Message", true, true);

			String sItemNameMsg = driver.findElement(By.xpath(objRWModules.Items_AddItem_ErrorMsgItemNameRequired_xp)).getText().toString().trim();
			if(sItemNameMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	
			
			obj.repAddData("Verified Item Name Required error message.", "", "", "");
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Select");
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgRowTypeRequired_xp, "Row Type Required error message", true, true);
			
			String sRowTypeMsg = driver.findElement(By.xpath(objRWModules.Items_AddItem_ErrorMsgRowTypeRequired_xp)).getText().toString().trim();
			if(sRowTypeMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	
			
			
			
			//Cancel out
			obj.repAddData("Verified Row Type Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
			ClickByXpath(objRWModules.Common_CancelModule_BtnYes,"Cancel Confirm",false);;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37199 Failed!", e );
		}
		return obj;
	}
	//End of Function 37199
	//RW-239_Items_TC008_ADD ITEM_Verify Prompt for required fields_Optional Incremental Row Type Row Type
	@SuppressWarnings("static-access")
	public Reporter TC37200(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37200 Started..");
		try {
			
			obj.repAddData( "Verify Add Item required texts for Optional Increment Row type", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Optional Increment Row Type");
			
			//Enter and clear name field
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);

			String sItemName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sItemName);
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgItemNameRequired_xp, "Item name Error Message", true, true);

			String sItemNameMsg = driver.findElement(By.xpath(objRWModules.Items_AddItem_ErrorMsgItemNameRequired_xp)).getText().toString().trim();
			if(sItemNameMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	
			
			obj.repAddData("Verified Item Name Required error message.", "", "", "");
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Select");
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgRowTypeRequired_xp, "Row Type Required error message", true, true);
			
			String sRowTypeMsg = driver.findElement(By.xpath(objRWModules.Items_AddItem_ErrorMsgRowTypeRequired_xp)).getText().toString().trim();
			if(sRowTypeMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	
			
			
			
			//Cancel out
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
			ClickByXpath(objRWModules.Common_CancelModule_BtnYes,"Cancel Confirm",false);;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37200 Failed!", e );
		}
		return obj;
	}
	//End of Function 37200
	//RW-239_Items_TC009_ADD ITEM_Verify Prompt for required fields_Package Row Type Row Type
	@SuppressWarnings("static-access")
	public Reporter TC37201(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37201 Started..");
		try {
			
			obj.repAddData( "Verify Add Item required texts for Package Row type", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Package Row Type");
			
			//Enter and clear name field
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);

			String sItemName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sItemName);
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgItemNameRequired_xp, "Item name Error Message", true, true);

			String sItemNameMsg = driver.findElement(By.xpath(objRWModules.Items_AddItem_ErrorMsgItemNameRequired_xp)).getText().toString().trim();
			if(sItemNameMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	
			
			obj.repAddData("Verified Item Name Required error message.", "", "", "");
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Select");
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgRowTypeRequired_xp, "Row Type Required error message", true, true);
			
			String sRowTypeMsg = driver.findElement(By.xpath(objRWModules.Items_AddItem_ErrorMsgRowTypeRequired_xp)).getText().toString().trim();
			if(sRowTypeMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	
			
			
			
			//Cancel out
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
			ClickByXpath(objRWModules.Common_CancelModule_BtnYes,"Cancel Confirm",false);
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37201 Failed!", e );
		}
		return obj;
	}
	//End of Function 37201
	//RW-239_Items_TC010_ADD ITEM_Verify Prompt for required fields_Tenant Only Row Type
	@SuppressWarnings("static-access")
	public Reporter TC37202(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37202 Started..");
		try {
			
			obj.repAddData( "Verify Add Item required texts for Tenant Only type", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Tenant Only");
			
			//Enter and clear name field
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);

			String sItemName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sItemName);
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgItemNameRequired_xp, "Item name Error Message", true, true);

			String sItemNameMsg = driver.findElement(By.xpath(objRWModules.Items_AddItem_ErrorMsgItemNameRequired_xp)).getText().toString().trim();
			if(sItemNameMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	
			
			obj.repAddData("Verified Item Name Required error message.", "", "", "");
			
			String sDefaultMaterial, sDefaultLabor = new String();
			sDefaultMaterial = sDefaultLabor = Integer.toString(fnRandomNum( 2, 20));
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultMaterial_nm, "Default Material text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultMaterial_nm)).sendKeys(sDefaultMaterial);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultMaterial_nm)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgDefaultMaterialRequired_xp, "Default Material Error Message", true, true);

			String sDefaultMaterialMsg = driver.findElement(By.xpath(objRWModules.Items_AddItem_ErrorMsgDefaultMaterialRequired_xp)).getText().toString().trim();
			if(sDefaultMaterialMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	
			
			obj.repAddData("Verified Default Material Required error message.", "", "", "");
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultLabor_nm, "Default Labor text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultLabor_nm)).sendKeys(sDefaultLabor);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultLabor_nm)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgDefaultLaborRequired_xp, "Default Labor Error Message", true, true);
			
			String sDefaultLaborMsg = driver.findElement(By.xpath(objRWModules.Items_AddItem_ErrorMsgDefaultLaborRequired_xp)).getText().toString().trim();
			if(sDefaultLaborMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	
			
			
			
			//Cancel out
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
			ClickByXpath(objRWModules.Common_CancelModule_BtnYes,"Cancel Confirm",false);
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37202 Failed!", e );
		}
		return obj;
	}
	//End of Function 37202
	//RW-239_Items_TC011_ADD ITEM_Verify Prompt for required fields_Whole Budget Percent Row Type
	@SuppressWarnings("static-access")
	public Reporter TC37203(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37203 Started..");
		try {
			
			obj.repAddData( "Verify Add Item required texts for Whole Budget Percent Row type", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Whole Budget Percent");
			
			//Enter and clear name field
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);

			String sItemName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sItemName);
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgItemNameRequired_xp, "Item name Error Message", true, true);

			String sItemNameMsg = driver.findElement(By.xpath(objRWModules.Items_AddItem_ErrorMsgItemNameRequired_xp)).getText().toString().trim();
			if(sItemNameMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	
			
			obj.repAddData("Verified Item Name Required error message.", "", "", "");
			
			String sDefaultPercent = new String();
			sDefaultPercent = Integer.toString(fnRandomNum( 1, 90));
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_BudgetPercent_nm, "Budget Percent text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_BudgetPercent_nm)).sendKeys(sDefaultPercent);
			driver.findElement(By.name(objRWModules.Items_AddItem_BudgetPercent_nm)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgBudgetPercentRequired_xp, "Default Material Error Message", true, true);

			String sDefaultMaterialMsg = driver.findElement(By.xpath(objRWModules.Items_AddItem_ErrorMsgBudgetPercentRequired_xp)).getText().toString().trim();
			if(sDefaultMaterialMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	
			
			obj.repAddData("Verified Default Material Required error message.", "", "", "");
			
			//Cancel out
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
			ClickByXpath(objRWModules.Common_CancelModule_BtnYes,"Cancel Confirm",false);
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37203 Failed!", e );
		}
		return obj;
	}
	//End of Function 37203
	//RW-239_Items_TC012_ADD ITEM_Verify Prompt for required fields_Whole House SqFT Row Type
	@SuppressWarnings("static-access")
	public Reporter TC37204(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37204 Started..");
		try {
			
			obj.repAddData( "Verify Add Item required texts for Whole House SqFT Row Type", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Whole House SqFT");
			
			//Enter and clear name field
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);

			String sItemName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sItemName);
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgItemNameRequired_xp, "Item name Error Message", true, true);

			String sItemNameMsg = driver.findElement(By.xpath(objRWModules.Items_AddItem_ErrorMsgItemNameRequired_xp)).getText().toString().trim();
			if(sItemNameMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	
			
			obj.repAddData("Verified Item Name Required error message.", "", "", "");
			
			String sMaterialRate, sLaborRate = new String();
			sMaterialRate = sLaborRate = Integer.toString(fnRandomNum( 2, 20));
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_MaterialRate_nm, "Default Material text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_MaterialRate_nm)).sendKeys(sMaterialRate);
			driver.findElement(By.name(objRWModules.Items_AddItem_MaterialRate_nm)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgMaterialRateRequired_xp, "Material Rate Error Message", true, true);

			String sMaterialRateMsg = driver.findElement(By.xpath(objRWModules.Items_AddItem_ErrorMsgMaterialRateRequired_xp)).getText().toString().trim();
			if(sMaterialRateMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	
			
			obj.repAddData("Verified Default Material Required error message.", "", "", "");
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_LaborRate_nm, "Default Labor text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_LaborRate_nm)).sendKeys(sLaborRate);
			driver.findElement(By.name(objRWModules.Items_AddItem_LaborRate_nm)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgLaborRateRequired_xp, "Labor Rate Error Message", true, true);
			
			String sLaborRateMsg = driver.findElement(By.xpath(objRWModules.Items_AddItem_ErrorMsgLaborRateRequired_xp)).getText().toString().trim();
			if(sLaborRateMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}	
			
			
			
			//Cancel out
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
			ClickByXpath(objRWModules.Common_CancelModule_BtnYes,"Cancel Confirm",false);
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37204 Failed!", e );
		}
		return obj;
	}
	//End of Function 37204
	//37195 through 37204 (10 items) end
	
	//RW-239_Items_TC017_ADD ITEM_Verify Numeric value fields
	@SuppressWarnings("static-access")
	public Reporter TC37210(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37210 Started..");
		try {
			
			obj.repAddData( "Verify numeric value fields only accept numbers", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			//Enter and clear name field
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);

			String sItemName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultMaterial_nm, "Default Material text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultMaterial_nm)).sendKeys(sItemName);
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgDefaultMaterialNumber_xp, "Default Material Numerical Error Message", true, true);
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultLabor_nm, "Default Labor text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultLabor_nm)).sendKeys(sItemName);
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgDefaultLaborNumber_xp, "Default Labor Numerical Error Message", true, true);
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultHours_nm, "Default Hours text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultHours_nm)).sendKeys(sItemName);
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_ErrorMsgDefaultHoursNumber_xp, "Default Labor Numerical Error Message", true, true);
			
			
			
			//Cancel out
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
			ClickByXpath(objRWModules.Common_CancelModule_BtnYes,"Cancel Confirm",false);;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37210 Failed!", e );
		}
		return obj;
	}
	//End of Function TC37210
	
	//37212 through 37229 (10 items, not consecutive) begin SAVE functions
	//RW-239_Items_TC021_ADD ITEM_Verify SAVE for ADD ITEM Always Added Row Type
	@SuppressWarnings("static-access")
	public Reporter TC37212(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37212 Started..");
		try {
			
			obj.repAddData( "Verify Save New Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Always Added");
			
			//Enter and clear name field
			
			String sDefaultString = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sDefaultString);
			
			//Click and verify checkboxes
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_PriceOverride_xp,"Price Override Box",true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_AddItem_PriceOverride_xp,"Price Override Box",true,true);
			
			//Generate and input Default Material, Default labor and Default Hours amounts
			String sDefaultMaterial, sDefaultLabor, sDefaultHours = new String();
			sDefaultMaterial = sDefaultLabor = sDefaultHours = Integer.toString(fnRandomNum( 2, 20));
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultMaterial_nm, "Default Material text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultMaterial_nm)).sendKeys(sDefaultMaterial);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultLabor_nm, "Default Labor text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultLabor_nm)).sendKeys(sDefaultLabor);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultHours_nm, "Default Hours text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultHours_nm)).sendKeys(sDefaultHours);
			
			//Input default string data for GLCode and Category
			driver.findElement(By.name(objRWModules.Items_AddItem_GLCode_nm)).sendKeys(sDefaultString);
			driver.findElement(By.name(objRWModules.Items_AddItem_Category_nm)).sendKeys(sDefaultString);
			
			//Open and Add a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_ItemComment_nm)).sendKeys(sDefaultString);
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddComment_xp,"Add New Comment",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_SecondItemComment_nm,"New comment box",true,true);
			
			//Save Item, Click Yes
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",false);  //post condition
			fnVerifyDialogBox("Add",0);
			
			//Verify item appears in UI after saving (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37212 Failed!", e );
		}
		return obj;
	}
	//End of Function 37212
	//RW-239_Items_TC019_ADD ITEM_Verify SAVE for ADD ITEM Basic Comment Row Type
	@SuppressWarnings("static-access")
	public Reporter TC37213(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37213 Started..");
		try {
			
			obj.repAddData( "Verify Save New Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Basic Comment");
			
			//Enter and clear name field
			
			String sDefaultString = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sDefaultString);
			
			//Click and verify checkboxes
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_PriceOverride_xp,"Price Override Box",true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_AddItem_PriceOverride_xp,"Price Override Box",true,true);
			
			//Generate and input Default Material, Default labor and Default Hours amounts
			String sDefaultMaterial, sDefaultLabor, sDefaultHours, sDefaultInt = new String();
			sDefaultMaterial = sDefaultLabor = sDefaultHours = sDefaultInt = Integer.toString(fnRandomNum( 2, 20));
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultMaterial_nm, "Default Material text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultMaterial_nm)).sendKeys(sDefaultMaterial);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultLabor_nm, "Default Labor text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultLabor_nm)).sendKeys(sDefaultLabor);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultHours_nm, "Default Hours text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultHours_nm)).sendKeys(sDefaultHours);
			
			//Input default string data for GLCode and Category
			driver.findElement(By.name(objRWModules.Items_AddItem_GLCode_nm)).sendKeys(sDefaultString);
			driver.findElement(By.name(objRWModules.Items_AddItem_Category_nm)).sendKeys(sDefaultString);
			
			//Open and Add a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_ItemComment_nm)).sendKeys(sDefaultString);
			ClickByName(RenowalkModules.Items_AddItem_RateNameComment_nm,"Rate Name",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_RateNameComment_nm)).sendKeys(sDefaultInt);
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddComment_xp,"Add New Comment",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_SecondItemComment_nm,"New comment box",true,true);
			
			//Save Item, Click Yes
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",false);  //post condition
			fnVerifyDialogBox("Add",0);
			
			//Verify item appears in UI after saving (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37213 Failed!", e );
		}
		return obj;
	}
	//End of Function 37213
	
	@SuppressWarnings("static-access")
	public Reporter TC37215(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37215 Started..");
		try {
			
			obj.repAddData( "Verify Save New Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Default Package Kit");
			
			//Enter and clear name field
			
			String sDefaultString = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sDefaultString);
			
			//Click and verify checkboxes
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox");
			
			//Generate and input Default Int
			String sDefaultInt = new String();
			sDefaultInt = Integer.toString(fnRandomNum( 2, 20));
			
			//Input default string data for GLCode and Category
			driver.findElement(By.name(objRWModules.Items_AddItem_GLCode_nm)).sendKeys(sDefaultString);
			driver.findElement(By.name(objRWModules.Items_AddItem_Category_nm)).sendKeys(sDefaultString);
			
			//Open and Add a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_ItemComment_nm)).sendKeys(sDefaultString);
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddComment_xp,"Add New Comment",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_SecondItemComment_nm,"New comment box",true,true);
			
			//Save Item, Click Yes
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",false);  //post condition
			fnVerifyDialogBox("Add",0);
			
			//Verify item appears in UI after saving (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37215 Failed!", e );
		}
		return obj;
	}
	//End of Function 37215
	
	@SuppressWarnings("static-access")
	public Reporter TC37217(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37217 Started..");
		try {
			
			obj.repAddData( "Verify Save New Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Increment Row Type");
			
			//Enter and clear name field
			
			String sDefaultString = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sDefaultString);
			
			//Click and verify checkboxes
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox");
			
			//Generate and input Default Material, Default labor and Default Hours amounts
			String sDefaultMaterial, sDefaultLabor, sDefaultHours, sDefaultInt = new String();
			sDefaultMaterial = sDefaultLabor = sDefaultHours = sDefaultInt = Integer.toString(fnRandomNum( 2, 20));
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultMaterial_nm, "Default Material text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultMaterial_nm)).sendKeys(sDefaultMaterial);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultLabor_nm, "Default Labor text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultLabor_nm)).sendKeys(sDefaultLabor);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultHours_nm, "Default Hours text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultHours_nm)).sendKeys(sDefaultHours);
			
			//Input default string data for GLCode and Category
			driver.findElement(By.name(objRWModules.Items_AddItem_GLCode_nm)).sendKeys(sDefaultString);
			driver.findElement(By.name(objRWModules.Items_AddItem_Category_nm)).sendKeys(sDefaultString);
			
			//Open and Add a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_ItemComment_nm)).sendKeys(sDefaultString);
			ClickByName(RenowalkModules.Items_AddItem_RateNameComment_nm,"Rate Name",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_RateNameComment_nm)).sendKeys(sDefaultInt);
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddComment_xp,"Add New Comment",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_SecondItemComment_nm,"New comment box",true,true);
			
			//Save Item, Click Yes
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",false);  //post condition
			fnVerifyDialogBox("Add",0);
			
			//Verify item appears in UI after saving (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37217 Failed!", e );
		}
		return obj;
	}
	//End of Function TC37217
	@SuppressWarnings("static-access")
	public Reporter TC37219(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37219 Started..");
		try {
			
			obj.repAddData( "Verify Save New Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Multiple Sku Display");
			
			//Enter and clear name field
			
			String sDefaultString = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sDefaultString);
			
			//Click and verify checkboxes
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox");
			
			//Generate and input Default Int
			String sDefaultInt = new String();
			sDefaultInt = Integer.toString(fnRandomNum( 2, 20));
			
			//Input default string data for GLCode and Category
			driver.findElement(By.name(objRWModules.Items_AddItem_GLCode_nm)).sendKeys(sDefaultString);
			driver.findElement(By.name(objRWModules.Items_AddItem_Category_nm)).sendKeys(sDefaultString);
			
			//Open and Add a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_ItemComment_nm)).sendKeys(sDefaultString);
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddComment_xp,"Add New Comment",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_SecondItemComment_nm,"New comment box",true,true);
			
			//Save Item, Click Yes
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",false);  //post condition
			fnVerifyDialogBox("Add",0);
			
			//Verify item appears in UI after saving (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37219 Failed!", e );
		}
		return obj;
	}
	//End of Function TC37219
	@SuppressWarnings("static-access")
	public Reporter TC37221(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37221 Started..");
		try {
			
			obj.repAddData( "Verify Save New Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Optional Increment Row Type");
			
			//Enter and clear name field
			
			String sDefaultString = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sDefaultString);
			
			//Click and verify checkboxes
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox");
			
			//Generate and input Default Int
			String sDefaultInt = new String();
			sDefaultInt = Integer.toString(fnRandomNum( 2, 20));
			
			//Input default string data for GLCode and Category
			driver.findElement(By.name(objRWModules.Items_AddItem_GLCode_nm)).sendKeys(sDefaultString);
			driver.findElement(By.name(objRWModules.Items_AddItem_Category_nm)).sendKeys(sDefaultString);
			
			//Open and Add a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_ItemComment_nm)).sendKeys(sDefaultString);
			ClickByName(RenowalkModules.Items_AddItem_RateNameComment_nm,"Rate Name",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_RateNameComment_nm)).sendKeys(sDefaultInt);
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddComment_xp,"Add New Comment",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_SecondItemComment_nm,"New comment box",true,true);
			
			//Save Item, Click Yes
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",false);  //post condition
			fnVerifyDialogBox("Add",0);
			
			//Verify item appears in UI after saving (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37221 Failed!", e );
		}
		return obj;
	}
	//End of Function TC37221
	@SuppressWarnings("static-access")
	public Reporter TC37223(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37223 Started..");
		try {
			
			obj.repAddData( "Verify Save New Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Package Row Type");
			
			//Enter and clear name field
			
			String sDefaultString = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sDefaultString);
			
			//Click and verify checkboxes
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox");
			
			//Generate and input Default Int
			String sDefaultInt = new String();
			sDefaultInt = Integer.toString(fnRandomNum( 2, 20));
			
			//Input default string data for GLCode and Category
			driver.findElement(By.name(objRWModules.Items_AddItem_GLCode_nm)).sendKeys(sDefaultString);
			driver.findElement(By.name(objRWModules.Items_AddItem_Category_nm)).sendKeys(sDefaultString);
			
			//Open and Add a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_ItemComment_nm)).sendKeys(sDefaultString);
			ClickByName(RenowalkModules.Items_AddItem_RateNameComment_nm,"Rate Name",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_RateNameComment_nm)).sendKeys(sDefaultInt);
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddComment_xp,"Add New Comment",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_SecondItemComment_nm,"New comment box",true,true);
			
			//Save Item, Click Yes
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",false);  //post condition
			fnVerifyDialogBox("Add",0);
			
			//Verify item appears in UI after saving (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37223 Failed!", e );
		}
		return obj;
	}
	//End of Function TC37223
	@SuppressWarnings("static-access")
	public Reporter TC37225(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37225 Started..");
		try {
			
			obj.repAddData( "Verify Save New Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Tenant Only");
			
			//Enter and clear name field
			
			String sDefaultString = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sDefaultString);
			
			//Click and verify checkboxes
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_PriceOverride_xp,"Price Override Box",true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_AddItem_PriceOverride_xp,"Price Override Box",true,true);
			
			//Generate and input Default Material, Default labor and Default Hours amounts
			String sDefaultMaterial, sDefaultLabor, sDefaultHours, sDefaultInt = new String();
			sDefaultMaterial = sDefaultLabor = sDefaultHours = sDefaultInt = Integer.toString(fnRandomNum( 2, 20));
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultMaterial_nm, "Default Material text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultMaterial_nm)).sendKeys(sDefaultMaterial);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultLabor_nm, "Default Labor text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultLabor_nm)).sendKeys(sDefaultLabor);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultHours_nm, "Default Hours text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultHours_nm)).sendKeys(sDefaultHours);
			
			//Input default string data for GLCode and Category
			driver.findElement(By.name(objRWModules.Items_AddItem_GLCode_nm)).sendKeys(sDefaultString);
			driver.findElement(By.name(objRWModules.Items_AddItem_Category_nm)).sendKeys(sDefaultString);
			
			//Open and Add a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_ItemComment_nm)).sendKeys(sDefaultString);
			ClickByName(RenowalkModules.Items_AddItem_RateNameComment_nm,"Rate Name",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_RateNameComment_nm)).sendKeys(sDefaultInt);
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddComment_xp,"Add New Comment",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_SecondItemComment_nm,"New comment box",true,true);
			
			//Save Item, Click Yes
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",false);  //post condition
			fnVerifyDialogBox("Add",0);
			
			//Verify item appears in UI after saving (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37225 Failed!", e );
		}
		return obj;
	}
	//End of Function TC37225
	@SuppressWarnings("static-access")
	public Reporter TC37227(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37227 Started..");
		try {
			
			obj.repAddData( "Verify Add Item saves for Whole Budget Percent Row type", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Whole Budget Percent");
			
			//Enter and clear name field
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);

			String sItemName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sItemName);
			
			String sDefaultPercent = new String();
			sDefaultPercent = Integer.toString(fnRandomNum( 1, 90));
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_BudgetPercent_nm, "Budget Percent text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_BudgetPercent_nm)).sendKeys(sDefaultPercent);
			
			
			
			//Save Item, Click Yes
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",false);  //post condition
			fnVerifyDialogBox("Add",0);
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37227 Failed!", e );
		}
		return obj;
	}
	//End of Function TC37227
	@SuppressWarnings("static-access")
	public Reporter TC37229(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37229 Started..");
		try {
			
			obj.repAddData( "Verify Add Item saves for Whole House SqFT Row Type", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Whole House SqFT");
			
			//Enter and clear name field
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);

			String sItemName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sItemName);
			
			String sMaterialRate, sLaborRate = new String();
			sMaterialRate = sLaborRate = Integer.toString(fnRandomNum( 2, 20));
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_MaterialRate_nm, "Default Material text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_MaterialRate_nm)).sendKeys(sMaterialRate);
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_LaborRate_nm, "Default Labor text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_LaborRate_nm)).sendKeys(sLaborRate);	
			
			//Save Item, Click Yes
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",false);  //post condition
			fnVerifyDialogBox("Add",0);
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37229 Failed!", e );
		}
		return obj;
	}
	//End of Function TC37229
	//37212 through 37229 (10 items, not consecutive) begin SAVE functions
	
	//RW-239_Items_TC029_ADD ITEM_Verify CANCEL (Discard) for ADD ITEM Always Added Row Type
	@SuppressWarnings("static-access")
	public Reporter TC37231(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37231 Started..");
		try {
			
			obj.repAddData( "Verify Add Item Page View", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Always Added");
			
			//Enter and clear name field
			
			String sDefaultString = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sDefaultString);
			
			//Click and verify checkboxes
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_PriceOverride_xp,"Price Override Box",true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_AddItem_PriceOverride_xp,"Price Override Box",true,true);
			
			//Generate and input Default Material, Default labor and Default Hours amounts
			String sDefaultMaterial, sDefaultLabor, sDefaultHours = new String();
			sDefaultMaterial = sDefaultLabor = sDefaultHours = Integer.toString(fnRandomNum( 2, 20));
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultMaterial_nm, "Default Material text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultMaterial_nm)).sendKeys(sDefaultMaterial);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultLabor_nm, "Default Labor text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultLabor_nm)).sendKeys(sDefaultLabor);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultHours_nm, "Default Hours text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultHours_nm)).sendKeys(sDefaultHours);
			
			//Input default string data for GLCode and Category
			driver.findElement(By.name(objRWModules.Items_AddItem_GLCode_nm)).sendKeys(sDefaultString);
			driver.findElement(By.name(objRWModules.Items_AddItem_Category_nm)).sendKeys(sDefaultString);
			
			//Open and Add a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_ItemComment_nm)).sendKeys(sDefaultString);
			
			//Cancel out, then click Yes when prompted
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(1);
			
			//Check DB to ensure object was NOT saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37231 Failed!", e );
		}
		return obj;
	}
	//End of Function 37231
	
	@SuppressWarnings("static-access")
	public Reporter TC37249(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37249 Started..");
		try {
			
			obj.repAddData( "Verify Add Item Page View", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Always Added");
			
			//Enter and clear name field
			
			String sDefaultString = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sDefaultString);
			
			//Click and verify checkboxes
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_PriceOverride_xp,"Price Override Box",true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_AddItem_PriceOverride_xp,"Price Override Box",true,true);
			
			
			
			//Generate and input Default Material, Default labor and Default Hours amounts
			String sDefaultMaterial, sDefaultLabor, sDefaultHours = new String();
			sDefaultMaterial = sDefaultLabor = sDefaultHours = Integer.toString(fnRandomNum( 2, 20));
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultMaterial_nm, "Default Material text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultMaterial_nm)).sendKeys(sDefaultMaterial);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultLabor_nm, "Default Labor text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultLabor_nm)).sendKeys(sDefaultLabor);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultHours_nm, "Default Hours text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultHours_nm)).sendKeys(sDefaultHours);
			
			//Input default string data for GLCode and Category
			driver.findElement(By.name(objRWModules.Items_AddItem_GLCode_nm)).sendKeys(sDefaultString);
			driver.findElement(By.name(objRWModules.Items_AddItem_Category_nm)).sendKeys(sDefaultString);
			
			//Open and Add a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_ItemComment_nm)).sendKeys(sDefaultString);
			
			//Cancel out, then click No when prompted
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(0);
			
			//Check DB to ensure object was NOT saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37249 Failed!", e );
		}
		return obj;
	}
	//End of Function 37250
	
	@SuppressWarnings("static-access")
	public Reporter TC37232(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37232 Started..");
		try {
			
			obj.repAddData( "Verify Cancel (Discard) New Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Basic Comment");
			
			//Enter and clear name field
			
			String sDefaultString = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sDefaultString);
			
			//Click and verify checkboxes
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_PriceOverride_xp,"Price Override Box",true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_AddItem_PriceOverride_xp,"Price Override Box",true,true);
			
			//Generate and input Default Material, Default labor and Default Hours amounts
			String sDefaultMaterial, sDefaultLabor, sDefaultHours, sDefaultInt = new String();
			sDefaultMaterial = sDefaultLabor = sDefaultHours = sDefaultInt = Integer.toString(fnRandomNum( 2, 20));
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultMaterial_nm, "Default Material text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultMaterial_nm)).sendKeys(sDefaultMaterial);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultLabor_nm, "Default Labor text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultLabor_nm)).sendKeys(sDefaultLabor);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultHours_nm, "Default Hours text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultHours_nm)).sendKeys(sDefaultHours);
			
			//Input default string data for GLCode and Category
			driver.findElement(By.name(objRWModules.Items_AddItem_GLCode_nm)).sendKeys(sDefaultString);
			driver.findElement(By.name(objRWModules.Items_AddItem_Category_nm)).sendKeys(sDefaultString);
			
			//Open and Add a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_ItemComment_nm)).sendKeys(sDefaultString);
			ClickByName(RenowalkModules.Items_AddItem_RateNameComment_nm,"Rate Name",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_RateNameComment_nm)).sendKeys(sDefaultInt);
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddComment_xp,"Add New Comment",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_SecondItemComment_nm,"New comment box",true,true);
			
			//Cancel out, then click Yes when prompted
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(1);
			
			//Verify item appears in UI after saving (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37232 Failed!", e );
		}
		return obj;
	}
	//End of Function TC37232
	
	@SuppressWarnings("static-access")
	public Reporter TC37250(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37250 Started..");
		try {
			
			obj.repAddData( "Verify Cancel (Not Discard) New Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Basic Comment");
			
			//Enter and clear name field
			
			String sDefaultString = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sDefaultString);
			
			//Click and verify checkboxes
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_PriceOverride_xp,"Price Override Box",true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_AddItem_PriceOverride_xp,"Price Override Box",true,true);
			
			//Generate and input Default Material, Default labor and Default Hours amounts
			String sDefaultMaterial, sDefaultLabor, sDefaultHours, sDefaultInt = new String();
			sDefaultMaterial = sDefaultLabor = sDefaultHours = sDefaultInt = Integer.toString(fnRandomNum( 2, 20));
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultMaterial_nm, "Default Material text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultMaterial_nm)).sendKeys(sDefaultMaterial);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultLabor_nm, "Default Labor text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultLabor_nm)).sendKeys(sDefaultLabor);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultHours_nm, "Default Hours text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultHours_nm)).sendKeys(sDefaultHours);
			
			//Input default string data for GLCode and Category
			driver.findElement(By.name(objRWModules.Items_AddItem_GLCode_nm)).sendKeys(sDefaultString);
			driver.findElement(By.name(objRWModules.Items_AddItem_Category_nm)).sendKeys(sDefaultString);
			
			//Open and Add a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_ItemComment_nm)).sendKeys(sDefaultString);
			ClickByName(RenowalkModules.Items_AddItem_RateNameComment_nm,"Rate Name",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_RateNameComment_nm)).sendKeys(sDefaultInt);
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddComment_xp,"Add New Comment",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_SecondItemComment_nm,"New comment box",true,true);
			
			//Cancel out, then click Yes when prompted
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(0);
			
			//Verify item does not appear in UI after cancelling (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37250 Failed!", e );
		}
		return obj;
	}
	//End of Function TC37250
	
	@SuppressWarnings("static-access")
	public Reporter TC37234(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37234 Started..");
		try {
			
			obj.repAddData( "Verify Cancel (Discard) New Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Default Package Kit");
			
			//Enter and clear name field
			
			String sDefaultString = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sDefaultString);
			
			//Click and verify checkboxes
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox");
			
			//Generate and input Default Int
			String sDefaultInt = new String();
			sDefaultInt = Integer.toString(fnRandomNum( 2, 20));
			
			//Input default string data for GLCode and Category
			driver.findElement(By.name(objRWModules.Items_AddItem_GLCode_nm)).sendKeys(sDefaultString);
			driver.findElement(By.name(objRWModules.Items_AddItem_Category_nm)).sendKeys(sDefaultString);
			
			//Open and Add a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_ItemComment_nm)).sendKeys(sDefaultString);
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddComment_xp,"Add New Comment",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_SecondItemComment_nm,"New comment box",true,true);
			
			//Cancel out, then click Yes when prompted
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(1);
			
			//Verify item does not appear in UI after canceling (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37234 Failed!", e );
		}
		return obj;
	}
	//End of Function TC37234
	
	@SuppressWarnings("static-access")
	public Reporter TC37251(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37251 Started..");
		try {
			
			obj.repAddData( "Verify Cancel (Not Discard) New Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Default Package Kit");
			
			//Enter and clear name field
			
			String sDefaultString = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sDefaultString);
			
			//Click and verify checkboxes
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox");
			
			//Generate and input Default Int
			String sDefaultInt = new String();
			sDefaultInt = Integer.toString(fnRandomNum( 2, 20));
			
			//Input default string data for GLCode and Category
			driver.findElement(By.name(objRWModules.Items_AddItem_GLCode_nm)).sendKeys(sDefaultString);
			driver.findElement(By.name(objRWModules.Items_AddItem_Category_nm)).sendKeys(sDefaultString);
			
			//Open and Add a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_ItemComment_nm)).sendKeys(sDefaultString);
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddComment_xp,"Add New Comment",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_SecondItemComment_nm,"New comment box",true,true);
			
			//Cancel out, then click No when prompted
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(0);
			
			//Verify item does not appear in UI after canceling (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37251 Failed!", e );
		}
		return obj;
	}
	//End of Function TC37234
	
	@SuppressWarnings("static-access")
	public Reporter TC37236(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37236 Started..");
		try {
			
			obj.repAddData( "Verify Cancel (Discard) New Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Increment Row Type");
			
			//Enter and clear name field
			
			String sDefaultString = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sDefaultString);
			
			//Click and verify checkboxes
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox");
			
			//Generate and input Default Material, Default labor and Default Hours amounts
			String sDefaultMaterial, sDefaultLabor, sDefaultHours, sDefaultInt = new String();
			sDefaultMaterial = sDefaultLabor = sDefaultHours = sDefaultInt = Integer.toString(fnRandomNum( 2, 20));
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultMaterial_nm, "Default Material text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultMaterial_nm)).sendKeys(sDefaultMaterial);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultLabor_nm, "Default Labor text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultLabor_nm)).sendKeys(sDefaultLabor);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultHours_nm, "Default Hours text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultHours_nm)).sendKeys(sDefaultHours);
			
			//Input default string data for GLCode and Category
			driver.findElement(By.name(objRWModules.Items_AddItem_GLCode_nm)).sendKeys(sDefaultString);
			driver.findElement(By.name(objRWModules.Items_AddItem_Category_nm)).sendKeys(sDefaultString);
			
			//Open and Add a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_ItemComment_nm)).sendKeys(sDefaultString);
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddComment_xp,"Add New Comment",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_SecondItemComment_nm,"New comment box",true,true);
			
			//Cancel out, then click Yes when prompted
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(1);
			
			//Verify item does not appear in UI after cancelling (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37236 Failed!", e );
		}
		return obj;
	}
	//End of Function TC37236
	
	@SuppressWarnings("static-access")
	public Reporter TC37252(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37252 Started..");
		try {
			
			obj.repAddData( "Verify Cancel (Not Discard) New Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Increment Row Type");
			
			//Enter and clear name field
			
			String sDefaultString = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sDefaultString);
			
			//Click and verify checkboxes
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox");
			
			//Generate and input Default Material, Default labor and Default Hours amounts
			String sDefaultMaterial, sDefaultLabor, sDefaultHours, sDefaultInt = new String();
			sDefaultMaterial = sDefaultLabor = sDefaultHours = sDefaultInt = Integer.toString(fnRandomNum( 2, 20));
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultMaterial_nm, "Default Material text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultMaterial_nm)).sendKeys(sDefaultMaterial);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultLabor_nm, "Default Labor text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultLabor_nm)).sendKeys(sDefaultLabor);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultHours_nm, "Default Hours text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultHours_nm)).sendKeys(sDefaultHours);
			
			//Input default string data for GLCode and Category
			driver.findElement(By.name(objRWModules.Items_AddItem_GLCode_nm)).sendKeys(sDefaultString);
			driver.findElement(By.name(objRWModules.Items_AddItem_Category_nm)).sendKeys(sDefaultString);
			
			//Open and Add a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_ItemComment_nm)).sendKeys(sDefaultString);
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddComment_xp,"Add New Comment",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_SecondItemComment_nm,"New comment box",true,true);
			
			//Cancel out, then click Yes when prompted
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(0);
			
			//Verify item does not appear in UI after canceling (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37252 Failed!", e );
		}
		return obj;
	}
	//End of Function TC37236
	
	@SuppressWarnings("static-access")
	public Reporter TC37238(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37238 Started..");
		try {
			
			obj.repAddData( "Verify Cancel (Discard) New Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Multiple Sku Display");
			
			//Enter and clear name field
			
			String sDefaultString = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sDefaultString);
			
			//Click and verify checkboxes
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox");
			
			//Generate and input Default Int
			String sDefaultInt = new String();
			sDefaultInt = Integer.toString(fnRandomNum( 2, 20));
			
			//Input default string data for GLCode and Category
			driver.findElement(By.name(objRWModules.Items_AddItem_GLCode_nm)).sendKeys(sDefaultString);
			driver.findElement(By.name(objRWModules.Items_AddItem_Category_nm)).sendKeys(sDefaultString);
			
			//Open and Add a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_ItemComment_nm)).sendKeys(sDefaultString);
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddComment_xp,"Add New Comment",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_SecondItemComment_nm,"New comment box",true,true);
			
			//Cancel out, then click Yes when prompted
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(1);
			
			//Verify item does not appear in UI after canceling (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37238 Failed!", e );
		}
		return obj;
	}
	//End of Function TC37238
	
	@SuppressWarnings("static-access")
	public Reporter TC37253(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37253 Started..");
		try {
			
			obj.repAddData( "Verify Cancel (Not Discard) New Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Multiple Sku Display");
			
			//Enter and clear name field
			
			String sDefaultString = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sDefaultString);
			
			//Click and verify checkboxes
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox");
			
			//Generate and input Default Int
			String sDefaultInt = new String();
			sDefaultInt = Integer.toString(fnRandomNum( 2, 20));
			
			//Input default string data for GLCode and Category
			driver.findElement(By.name(objRWModules.Items_AddItem_GLCode_nm)).sendKeys(sDefaultString);
			driver.findElement(By.name(objRWModules.Items_AddItem_Category_nm)).sendKeys(sDefaultString);
			
			//Open and Add a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_ItemComment_nm)).sendKeys(sDefaultString);
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddComment_xp,"Add New Comment",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_SecondItemComment_nm,"New comment box",true,true);
			
			//Cancel out, then click No when prompted
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(0);
			
			//Verify item does not appear in UI after canceling (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37253 Failed!", e );
		}
		return obj;
	}
	//End of Function TC37253
	
	@SuppressWarnings("static-access")
	public Reporter TC37240(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37240 Started..");
		try {
			
			obj.repAddData( "Verify Cancel (Discard) New Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Optional Increment Row Type");
			
			//Enter and clear name field
			
			String sDefaultString = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sDefaultString);
			
			//Click and verify checkboxes
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox");
			
			//Generate and input Default Int
			String sDefaultInt = new String();
			sDefaultInt = Integer.toString(fnRandomNum( 2, 20));
			
			//Input default string data for GLCode and Category
			driver.findElement(By.name(objRWModules.Items_AddItem_GLCode_nm)).sendKeys(sDefaultString);
			driver.findElement(By.name(objRWModules.Items_AddItem_Category_nm)).sendKeys(sDefaultString);
			
			//Open and Add a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_ItemComment_nm)).sendKeys(sDefaultString);
			ClickByName(RenowalkModules.Items_AddItem_RateNameComment_nm,"Rate Name",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_RateNameComment_nm)).sendKeys(sDefaultInt);
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddComment_xp,"Add New Comment",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_SecondItemComment_nm,"New comment box",true,true);
			
			//Cancel out, then click Yes when prompted
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(1);
			
			//Verify item does not appear in UI after canceling (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37240 Failed!", e );
		}
		return obj;
	}
	//End of Function TC37240
	
	@SuppressWarnings("static-access")
	public Reporter TC37254(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37254 Started..");
		try {
			
			obj.repAddData( "Verify Cancel (Not Discard) New Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Optional Increment Row Type");
			
			//Enter and clear name field
			
			String sDefaultString = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sDefaultString);
			
			//Click and verify checkboxes
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox");
			
			//Generate and input Default Int
			String sDefaultInt = new String();
			sDefaultInt = Integer.toString(fnRandomNum( 2, 20));
			
			//Input default string data for GLCode and Category
			driver.findElement(By.name(objRWModules.Items_AddItem_GLCode_nm)).sendKeys(sDefaultString);
			driver.findElement(By.name(objRWModules.Items_AddItem_Category_nm)).sendKeys(sDefaultString);
			
			//Open and Add a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_ItemComment_nm)).sendKeys(sDefaultString);
			ClickByName(RenowalkModules.Items_AddItem_RateNameComment_nm,"Rate Name",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_RateNameComment_nm)).sendKeys(sDefaultInt);
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddComment_xp,"Add New Comment",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_SecondItemComment_nm,"New comment box",true,true);
			
			//Cancel out, then click No when prompted
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(0);
			
			//Verify item does not appear in UI after canceling (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37254 Failed!", e );
		}
		return obj;
	}
	//End of Function TC37254
	
	@SuppressWarnings("static-access")
	public Reporter TC37242(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37242 Started..");
		try {
			
			obj.repAddData( "Verify Cancel (Discard) New Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Package Row Type");
			
			//Enter and clear name field
			
			String sDefaultString = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sDefaultString);
			
			//Click and verify checkboxes
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox");
			
			//Generate and input Default Int
			String sDefaultInt = new String();
			sDefaultInt = Integer.toString(fnRandomNum( 2, 20));
			
			//Input default string data for GLCode and Category
			driver.findElement(By.name(objRWModules.Items_AddItem_GLCode_nm)).sendKeys(sDefaultString);
			driver.findElement(By.name(objRWModules.Items_AddItem_Category_nm)).sendKeys(sDefaultString);
			
			//Open and Add a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_ItemComment_nm)).sendKeys(sDefaultString);
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddComment_xp,"Add New Comment",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_SecondItemComment_nm,"New comment box",true,true);
			
			//Cancel out, then click Yes when prompted
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(1);
			
			//Verify item does not appear in UI after canceling (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37242 Failed!", e );
		}
		return obj;
	}
	//End of Function TC37242
	
	@SuppressWarnings("static-access")
	public Reporter TC37255(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37255 Started..");
		try {
			
			obj.repAddData( "Verify Cancel (Not Discard) New Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Package Row Type");
			
			//Enter and clear name field
			
			String sDefaultString = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sDefaultString);
			
			//Click and verify checkboxes
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox");
			
			//Generate and input Default Int
			String sDefaultInt = new String();
			sDefaultInt = Integer.toString(fnRandomNum( 2, 20));
			
			//Input default string data for GLCode and Category
			driver.findElement(By.name(objRWModules.Items_AddItem_GLCode_nm)).sendKeys(sDefaultString);
			driver.findElement(By.name(objRWModules.Items_AddItem_Category_nm)).sendKeys(sDefaultString);
			
			//Open and Add a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_ItemComment_nm)).sendKeys(sDefaultString);
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddComment_xp,"Add New Comment",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_SecondItemComment_nm,"New comment box",true,true);
			
			//Cancel out, then click No when prompted
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(0);
			
			//Verify item does not appear in UI after canceling (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37255 Failed!", e );
		}
		return obj;
	}
	//End of Function TC37255
	
	@SuppressWarnings("static-access")
	public Reporter TC37244(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37244 Started..");
		try {
			
			obj.repAddData( "Verify Cancel (Discard) New Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Tenant Only");
			
			//Enter and clear name field
			
			String sDefaultString = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sDefaultString);
			
			//Click and verify checkboxes
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_PriceOverride_xp,"Price Override Box",true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_AddItem_PriceOverride_xp,"Price Override Box",true,true);
			
			//Generate and input Default Material, Default labor and Default Hours amounts
			String sDefaultMaterial, sDefaultLabor, sDefaultHours, sDefaultInt = new String();
			sDefaultMaterial = sDefaultLabor = sDefaultHours = sDefaultInt = Integer.toString(fnRandomNum( 2, 20));
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultMaterial_nm, "Default Material text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultMaterial_nm)).sendKeys(sDefaultMaterial);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultLabor_nm, "Default Labor text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultLabor_nm)).sendKeys(sDefaultLabor);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultHours_nm, "Default Hours text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultHours_nm)).sendKeys(sDefaultHours);
			
			//Input default string data for GLCode and Category
			driver.findElement(By.name(objRWModules.Items_AddItem_GLCode_nm)).sendKeys(sDefaultString);
			driver.findElement(By.name(objRWModules.Items_AddItem_Category_nm)).sendKeys(sDefaultString);
			
			//Open and Add a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_ItemComment_nm)).sendKeys(sDefaultString);
			ClickByName(RenowalkModules.Items_AddItem_RateNameComment_nm,"Rate Name",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_RateNameComment_nm)).sendKeys(sDefaultInt);
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddComment_xp,"Add New Comment",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_SecondItemComment_nm,"New comment box",true,true);
			
			//Cancel out, then click Yes when prompted
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(1);
			
			//Verify item does not appear in UI after canceling (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37244 Failed!", e );
		}
		return obj;
	}
	//End of Function TC37244
	
	@SuppressWarnings("static-access")
	public Reporter TC37256(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37256 Started..");
		try {
			
			obj.repAddData( "Verify Cancel (Not Discard) New Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Tenant Only");
			
			//Enter and clear name field
			
			String sDefaultString = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sDefaultString);
			
			//Click and verify checkboxes
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxRequired_xp,"Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox",true);
			fnCheckSelectedCheckBoxByXPath(RenowalkModules.Items_AddItem_NonBudgetCheckbox_xp,"Non-Budget checkbox");
			
			ClickByXpath(RenowalkModules.Items_AddItem_PriceOverride_xp,"Price Override Box",true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_AddItem_PriceOverride_xp,"Price Override Box",true,true);
			
			//Generate and input Default Material, Default labor and Default Hours amounts
			String sDefaultMaterial, sDefaultLabor, sDefaultHours, sDefaultInt = new String();
			sDefaultMaterial = sDefaultLabor = sDefaultHours = sDefaultInt = Integer.toString(fnRandomNum( 2, 20));
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultMaterial_nm, "Default Material text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultMaterial_nm)).sendKeys(sDefaultMaterial);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultLabor_nm, "Default Labor text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultLabor_nm)).sendKeys(sDefaultLabor);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultHours_nm, "Default Hours text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_DefaultHours_nm)).sendKeys(sDefaultHours);
			
			//Input default string data for GLCode and Category
			driver.findElement(By.name(objRWModules.Items_AddItem_GLCode_nm)).sendKeys(sDefaultString);
			driver.findElement(By.name(objRWModules.Items_AddItem_Category_nm)).sendKeys(sDefaultString);
			
			//Open and Add a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_ItemComment_nm)).sendKeys(sDefaultString);
			ClickByName(RenowalkModules.Items_AddItem_RateNameComment_nm,"Rate Name",true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_RateNameComment_nm)).sendKeys(sDefaultInt);
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddComment_xp,"Add New Comment",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_SecondItemComment_nm,"New comment box",true,true);
			
			//Cancel out, then click No when prompted
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(0);
			
			//Verify item does not appear in UI after canceling (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37256 Failed!", e );
		}
		return obj;
	}
	//End of Function TC37256
	
	@SuppressWarnings("static-access")
	public Reporter TC37246(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37246 Started..");
		try {
			
			obj.repAddData( "Verify Add Item Cancel (Discard) for Whole Budget Percent Row type", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Whole Budget Percent");
			
			//Enter and clear name field
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);

			String sItemName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sItemName);
			
			String sDefaultPercent = new String();
			sDefaultPercent = Integer.toString(fnRandomNum( 1, 90));
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_BudgetPercent_nm, "Budget Percent text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_BudgetPercent_nm)).sendKeys(sDefaultPercent);
			
			
			
			//Cancel out, then click Yes when prompted
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(1);
			
			//Verify item does not appear in UI after canceling (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37246 Failed!", e );
		}
		return obj;
	}
	//End of Function TC37246
	
	@SuppressWarnings("static-access")
	public Reporter TC37257(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37257 Started..");
		try {
			
			obj.repAddData( "Verify Add Item Cancel (Not Discard) for Whole Budget Percent Row type", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Whole Budget Percent");
			
			//Enter and clear name field
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);

			String sItemName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sItemName);
			
			String sDefaultPercent = new String();
			sDefaultPercent = Integer.toString(fnRandomNum( 1, 90));
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_BudgetPercent_nm, "Budget Percent text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_BudgetPercent_nm)).sendKeys(sDefaultPercent);
			
			
			
			//Cancel out, then click No when prompted
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(0);
			
			//Verify item does not appear in UI after canceling (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37257 Failed!", e );
		}
		return obj;
	}
	//End of Function TC37257
	
	@SuppressWarnings("static-access")
	public Reporter TC37248(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37248 Started..");
		try {
			
			obj.repAddData( "Verify Add Item Cancel (Discard) for Whole House SqFT Row Type", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Whole House SqFT");
			
			//Enter and clear name field
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);

			String sItemName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sItemName);
			
			String sMaterialRate, sLaborRate = new String();
			sMaterialRate = sLaborRate = Integer.toString(fnRandomNum( 2, 20));
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_MaterialRate_nm, "Default Material text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_MaterialRate_nm)).sendKeys(sMaterialRate);
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_LaborRate_nm, "Default Labor text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_LaborRate_nm)).sendKeys(sLaborRate);	
			
			//Cancel out, then click Yes when prompted
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(1);
			
			//Verify item does not appear in UI after canceling (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37248 Failed!", e );
		}
		return obj;
	}
	//End of Function TC37248
	
	@SuppressWarnings("static-access")
	public Reporter TC37258(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC37258 Started..");
		try {
			
			obj.repAddData( "Verify Add Item Cancel (Not Discard) for Whole House SqFT Row Type", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Whole House SqFT");
			
			//Enter and clear name field
			
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_InputItemName_xp, "Item Name text box", true, true);

			String sItemName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Items_AddItem_InputItemName_xp)).sendKeys(sItemName);
			
			String sMaterialRate, sLaborRate = new String();
			sMaterialRate = sLaborRate = Integer.toString(fnRandomNum( 2, 20));
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_MaterialRate_nm, "Default Material text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_MaterialRate_nm)).sendKeys(sMaterialRate);
			
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_LaborRate_nm, "Default Labor text box", true, true);
			driver.findElement(By.name(objRWModules.Items_AddItem_LaborRate_nm)).sendKeys(sLaborRate);	
			
			//Cancel out, then click No when prompted
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(0);
			
			//Verify item does not appear in UI after canceling (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37258 Failed!", e );
		}
		return obj;
	}
	//End of Function TC37258
	
	
	public Reporter TC38658(Reporter obj) throws Exception {
		try {
			
			
			obj.repAddData( "Verify Products section within Add Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_ProductsPanelHeader_xp,"Open Products section",true);
			
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_SKU_nm, "Product SKU field",true,true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_MultiPakSKU_nm,"Product Multi-Pak SKU field",true,true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_MultiPakQty_nm,"Product Multi-Pak quantity field",true,true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_DefaultStoreNumber_nm,"Product default store number field",true,true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_Description_nm, "Product description field",true,true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_ProductPrice_nm, "Product price field", true, true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_ProductTierID_nm, "Product tier select", true, true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_ProductDefaultLabor_nm, "Product default labor field",true,true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_ProductDefaultHours_nm, "Product default hours field",true,true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_ProductGLCode_nm, "Product GL Code field",true,true);
			
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC38658 Failed!", e );
		}
		return obj;
	}
	
	public Reporter TC38659(Reporter obj) throws Exception {
		try {
			
			
			obj.repAddData( "Verify Products section within Add Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_ProductsPanelHeader_xp,"Open Products section",true);
			
			driver.findElement(By.name(RenowalkModules.Items_AddItem_SKU_nm)).sendKeys("1");
			
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddProduct_xp,"Add Product button",true);
			ClickByXpath(RenowalkModules.Items_AddItem_CloseProductSKUSearchBox_xp,"Close Product SKU search popups",true);
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddProduct_xp,"Add Product button",true);
			
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_AddItem_SecondProductRow_xp,"New product row shown",true,true);
			
			//cancel out
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(1);
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC38659 Failed!", e );
		}
		return obj;
	}
	
	public Reporter TC38661(Reporter obj) throws Exception {
		try {
			
			
			obj.repAddData( "Verify Products section within Add Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);

			ClickByXpath(RenowalkModules.Items_AddItem_ProductsPanelHeader_xp,"Open Products section",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Default Package Kit");
			
			
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_DefaultQty_nm,"Default quantity field",true,true);
			
			//cancel out
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(1);
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC38661 Failed!", e );
		}
		return obj;
	}
	
	public Reporter TC38662(Reporter obj) throws Exception {
		try {
			obj.repAddData( "Verify Products section within Add Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_ProductsPanelHeader_xp,"Open Products section",true);
			
			driver.findElement(By.name(RenowalkModules.Items_AddItem_SKU_nm)).sendKeys("1");
			
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddProduct_xp,"Add Product button",true);
			
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_AddItem_SearchSKUBox_xp,"Search SKU popup box",true,true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_AddItem_SearchSKUSearchField_xp,"Search SKU input field",true,true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_CloseProductSKUSearchBox_xp,"Close Product SKU search popups",true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddProduct_xp,"Add Product button",true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_AddItem_SecondProductRow_xp,"New product row shown",true,true);
			
			//cancel out
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(1);
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC38662 Failed!", e );
		}
		return obj;
	}
	
	public Reporter TC38663(Reporter obj) throws Exception {
		try {
			obj.repAddData( "Verify Products section within Add Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_ProductsPanelHeader_xp,"Open Products section",true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_ProductSearchIcon_xp,"SKU search icon",true);
			
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_AddItem_SearchSKUBox_xp,"Search SKU popup box",true,true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_AddItem_SearchSKUSearchField_xp,"Search SKU input field",true,true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_CloseProductSKUSearchBox_xp,"Close Product SKU search popups",true);
			
			//cancel out
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC38663 Failed!", e );
		}
		return obj;
	}
	
	public Reporter TC38668(Reporter obj) throws Exception {
		try {
			
			
			obj.repAddData( "Verify Products section within Add Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			ClickByXpath(RenowalkModules.Items_AddItem_ProductsPanelHeader_xp,"Open Products section",true);
			
			driver.findElement(By.name(RenowalkModules.Items_AddItem_SKU_nm)).sendKeys("1");
			
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddProduct_xp,"Add Product button",true);
			ClickByXpath(RenowalkModules.Items_AddItem_CloseProductSKUSearchBox_xp,"Close Product SKU search popups",true);
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddProduct_xp,"Add Product button",true);
			
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_AddItem_SecondProductRow_xp,"New product row shown",true,true);
			
			ClickElementDragTo(RenowalkModules.Items_AddItem_FirstProductRow_xp,RenowalkModules.Items_AddItem_SecondProductRow_xp,"xpath","xpath");
			
			String productNo2SKU = driver.findElement(By.name(RenowalkModules.Items_AddItem_SKU_nm.replace('0',	'1'))).getText();
			if (productNo2SKU.equals("1"))
			{
				obj.repAddData("Testing drag and drop.","Expected to see 1 in second product SKU field","Saw " + productNo2SKU + ".","Pass");
			}
			
			//cancel out
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(1);
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC38668 Failed!", e );
		}
		return obj;
	}
	
	public Reporter TC37692(Reporter obj) throws Exception {
		log.info("Execution of Function TC37692 Started..");
		try {
			
			obj.repAddData( "Verify Comments Field for Add Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			//Open and Check a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_ItemComment_nm,"Item Comment field",true,true);
			
			//Cancel out, then click Yes when prompted
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(1);
			
			//Verify item appears in UI after saving (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37692 Failed!", e );
		}
		return obj;
	}
	
	@SuppressWarnings("static-access")
	public Reporter TC36798(Reporter obj) throws Exception
	{
		log.info("Execution of Function TC36798 Started..");
		try {
			
			obj.repAddData( "Verify Comment Rate show for certain row type items", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Basic Comment");
			
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_ItemComment_nm,"Item Comment field",true,true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_RateNameComment_nm,"Rate Name",true,true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Optional Increment Row Type");
			
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_ItemComment_nm,"Item Comment field",true,true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_RateNameComment_nm,"Rate Name",true,true);
			
			fnSelectFromComboBoxXpath(RenowalkModules.Items_AddItem_ComboRowType_xp,"Tenant Only");

			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_ItemComment_nm,"Item Comment field",true,true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_RateNameComment_nm,"Rate Name",true,true);
			
			//Cancel out, then click Yes when prompted
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(1);
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC36798 Failed!", e );
		}
		return obj;
	}
	
	public Reporter TC36801(Reporter obj) throws Exception {
		log.info("Execution of Function TC36801 Started..");
		try {
			
			obj.repAddData( "Verify Comments Field for Add Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			//Open and Check a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_ItemComment_nm,"Item Comment field",true,true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_ItemComment_nm)).sendKeys("Test");
			if (ElementFound(RenowalkModules.Items_AddItem_BtnAddCommentDisabled_xp))
			{
				obj.repAddData("Checking for Disabled 'Add New Comment' button","Add Comment should be working and enabled","Add Comment is working and enabled, Disabled variant is hidden from page","Pass");
			}
			
			
			//Cancel out, then click Yes when prompted
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(1);
			
			//Verify item appears in UI after saving (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC36801 Failed!", e );
		}
		return obj;
	}
	
	public Reporter TC36803(Reporter obj) throws Exception {
		log.info("Execution of Function TC36803 Started..");
		try {
			
			obj.repAddData( "Verify Comments Field for Add Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			//Open and Check a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_ItemComment_nm,"Item Comment field",true,true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_AddItem_BtnAddCommentDisabled_xp,"Comment Button disabled",true,true);
			
			
			//Cancel out, then click Yes when prompted
			obj.repAddData("Verified button is disabled. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			
			//Verify item appears in UI after saving (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC36803 Failed!", e );
		}
		return obj;
	}
	
	public Reporter TC36805(Reporter obj) throws Exception {
		log.info("Execution of Function TC36801 Started..");
		try {
			
			obj.repAddData( "Verify Comments Field for Add Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			//Open and Check a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_ItemComment_nm,"Item Comment field",true,true);
			driver.findElement(By.name(RenowalkModules.Items_AddItem_ItemComment_nm)).sendKeys("Test");
			ClickByXpath(RenowalkModules.Items_AddItem_BtnAddComment_xp,"Add Comment",true);
			String iC2 = RenowalkModules.Items_AddItem_ItemComment_nm.replace('0', '1');
			fnCheckFieldDisplayByName(iC2,"New Item Comment field",true,true);
			driver.findElement(By.name(iC2)).sendKeys("Test");
			
			ClickElementDragTo(RenowalkModules.Items_AddItem_ItemComment_nm,iC2,"name","name");
			
			
			
			
			//Cancel out, then click Yes when prompted
			obj.repAddData("Verified Default Labor Required error message. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			fnVerifyCancelForm(1);
			
			//Verify item appears in UI after saving (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC36801 Failed!", e );
		}
		return obj;
	}
	
	public Reporter TC36807(Reporter obj) throws Exception {
		log.info("Execution of Function TC36807 Started..");
		try {
			
			obj.repAddData( "Verify Comments Field for Add Item", "", "", "");
			//Set Corp and Office, load Item page
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp, "Items",true);
			fnLoadingPageWait();
			//To Add Item page
			fnCheckFieldDisplayByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp,"'ADD ITEM' button",true,true);
			ClickByXpath(RenowalkModules.Items_ViewItem_BtnAddItem_xp, "ADD ITEM",true);
			
			//Open and Check a Comment
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_ItemComment_nm,"Item Comment field",true,true);
			ClickByXpath(RenowalkModules.Items_AddItem_BtnDeleteComment_xp,"Delete Comment",true);
			
			if (!ElementFound(RenowalkModules.Items_AddItem_FirstItemComment_xp))
			{
				obj.repAddData("Confirming comment was deleted", "First comment field should not be shown.", "Comment field was missing", "Pass");
			}
			else { obj.repAddData("Confirming comment was deleted", "First comment field should not be shown.", "Comment field was still located!", "Fail"); }
			
			
			//Cancel out, then click Yes when prompted
			obj.repAddData("Verified comment delete functionality. Closing form.", "", "", "");
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",true);
			
			//Verify item appears in UI after saving (if using fnVerify 1 flag)
			//Check DB to ensure object was saved or stored in any way
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC36807 Failed!", e );
		}
		return obj;
	}
	
	//bxk8854
	///////////////////////////////////////Row Type Test Starts here///////////////////////////////////////////////////////////////////////////
	
	//RW-279_Items_TC001_Row Type_Verify that select if default under Row Type
	@SuppressWarnings("static-access")
	public Reporter TC36781(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC36781 Started..");

		try {
					
			obj.repAddData( "Verify that When ADD ITEM is Clicked, the default Row Type is 'Select'", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp,"Items Link", true);
			ClickByXpath(objRWModules.Items_ViewItem_BtnAddItem_xp, "Add Item", true);
			
			HighlightElementByXpath(objRWModules.Items_AddItem_ComboRowType_xp);
			
			Select rowType = new Select(driver.findElement(By.xpath(objRWModules.Items_AddItem_ComboRowType_xp)));
			List<WebElement> arrPageSize = rowType.getOptions();
			System.out.println("Page Combobox Size>>>>"+arrPageSize.size());
			
			//Verify the values in the select Box
			fnVerifyComboBoxValues(arrPageSize, 0, "Select");
			fnVerifyComboBoxValues(arrPageSize, 1, "Always Added");
			fnVerifyComboBoxValues(arrPageSize, 2, "Basic Comment");
			fnVerifyComboBoxValues(arrPageSize, 3, "Default Package Kit");
			fnVerifyComboBoxValues(arrPageSize, 4, "Increment Row Type");
			fnVerifyComboBoxValues(arrPageSize, 5, "Multiple Sku Display");
			fnVerifyComboBoxValues(arrPageSize, 6, "Optional Increment Row Type");
			fnVerifyComboBoxValues(arrPageSize, 7, "Package Row Type");
			fnVerifyComboBoxValues(arrPageSize, 8, "Tenant Only");
			fnVerifyComboBoxValues(arrPageSize, 9, "Whole Budget Percent");
			fnVerifyComboBoxValues(arrPageSize, 10, "Whole House SqFT");			
			
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);  //post condition

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC36781 Failed!", e );
		}
		finally {

			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC36781 Completed");
		}
		return obj;
	} //End of function TC36781
	
	
	//RW-279_Items_TC002_Row Type_Verify the format of the page after selecting "Always Added" for Row Type
	@SuppressWarnings("static-access")
	public Reporter TC36782(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC36782 Started..");

		try {
					
			obj.repAddData( "Verify the format of the page after selecting 'Always Added' for Row Type", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp,"Items Link", true);
			ClickByXpath(objRWModules.Items_ViewItem_BtnAddItem_xp, "Add Item", true);
			
			HighlightElementByXpath(objRWModules.Items_AddItem_ComboRowType_xp);
			
			//Select Always Added from Select Box
			Select rowType = new Select(driver.findElement(By.xpath(objRWModules.Items_AddItem_ComboRowType_xp)));
			rowType.selectByVisibleText("Always Added");
			
			//Validate all Fields
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_ItemName_nm,"Item Name text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_RowTypeSelector_nm,"Row Type combo box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required check box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxNonBudgetItem_xp,"Non Budget Item check box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxPriceOverride_xp,"Price Override check box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultMaterial_nm,"Default Material text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultLabor_nm,"Default Labor text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultHours_nm,"Defaault Hours text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_GLCode_nm,"GL Code text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_Category_nm,"Category text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_Subcategory_nm,"Sub Category box", true, true);
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_ItemComment_nm,"Comment Box",true,true);
			
			//verifying the Required check box
			fnCheckSelectedCheckBoxByXPath(objRWModules.Items_AddItem_CheckBoxPriceOverride_xp, "Price Override");
			
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);  //post condition
			fnVerifyCancelForm(1);

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC36782 Failed!", e );
		}
		finally {

			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC36782 Completed");
		}
		return obj;
	} //End of function TC36782
	
	//RW-279_Items_TC003_Row Type_Verify the format of the page after selecting Basic Comment for Row Type
	@SuppressWarnings("static-access")
	public Reporter TC36783(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC36783 Started..");

		try {
					
			obj.repAddData( "Verify the format of the page after selecting 'Basic Comment' for Row Type ", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp,"Items Link", true);
			ClickByXpath(objRWModules.Items_ViewItem_BtnAddItem_xp, "Add Item", true);
			
			HighlightElementByXpath(objRWModules.Items_AddItem_ComboRowType_xp);
			
			//Select Always Added from Select Box
			Select rowType = new Select(driver.findElement(By.xpath(objRWModules.Items_AddItem_ComboRowType_xp)));
			rowType.selectByVisibleText("Basic Comment");
			
			//Validate all Fields
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_ItemName_nm,"Item Name text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_RowTypeSelector_nm,"Row Type combo box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxRequired_xp,"Required check box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required check box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxNonBudgetItem_xp,"Non Budget Item check box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxPriceOverride_xp,"Price Override check box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultMaterial_nm,"Default Material text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultLabor_nm,"Default Labor text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultHours_nm,"Default Hours text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_GLCode_nm,"GL Code text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_Category_nm,"Category text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_Subcategory_nm,"Sub Category box", true, true);
			ClickByXpath(RenowalkModules.Items_AddItem_OpenCommentsSection_xp,"+",true);
			fnCheckFieldDisplayByName(RenowalkModules.Items_AddItem_ItemComment_nm,"Comment Box",true,true);
			
			//verifying the Required check box
			fnCheckSelectedCheckBoxByXPath(objRWModules.Items_AddItem_CheckBoxPriceOverride_xp, "Price Override");
			
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);  //post condition
			fnVerifyCancelForm(1);

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC36783 Failed!", e );
		}
		finally {

			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC36783 Completed");
		}
		return obj;
	} //End of function TC36783
	
	//RW-279_Items_TC004_Row Type_Verify the format of the page after selecting Default Package Kit for Row Type
	@SuppressWarnings("static-access")
	public Reporter TC36784(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC36784 Started..");

		try {
					
			obj.repAddData( "Verify the format of the page after selecting 'Default Package Kit' for Row Type ", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp,"Items Link", true);
			ClickByXpath(objRWModules.Items_ViewItem_BtnAddItem_xp, "Add Item", true);
			
			HighlightElementByXpath(objRWModules.Items_AddItem_ComboRowType_xp);
			
			//Select 'Default Package Kit' from Select Box
			Select rowType = new Select(driver.findElement(By.xpath(objRWModules.Items_AddItem_ComboRowType_xp)));
			rowType.selectByVisibleText("Default Package Kit");
			
			//Validate all Fields
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_ItemName_nm,"Item Name text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_RowTypeSelector_nm,"Row Type combo box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxRequired_xp,"Required check box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required check box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxNonBudgetItem_xp,"Non Budget Item check box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_GLCode_nm,"GL Code text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_Category_nm,"Category text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_Subcategory_nm,"Sub Category box", true, true);
			ClickByXpath(objRWModules.Items_AddItem_OpenCommentsSection_xp,"Open Description",true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_ItemComment_nm,"Comment Box",true,true);
			
			ClickByXpath(objRWModules.Items_AddItem_ProductsPanelHeader_xp,"Open Products",true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultQty_nm,"Default Quantity",true,true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_SKU_nm,"SKU",true,true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_MultiPakSKU_nm,"Multi Pak SKU",true,true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultStoreNumber_nm,"Default Store Number",true,true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_Description_nm,"Description",true,true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_ProductDefaultLabor_nm,"Product Default Labor",true,true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_ProductDefaultHours_nm,"Product Default Hours",true,true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_ProductGLCode_nm,"Product GL Code",true,true);

			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);  //post condition
			fnVerifyCancelForm(1);

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC36784 Failed!", e );
		}
		finally {

			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC36784 Completed");
		}
		return obj;
	} //End of function TC36784
	
	
	//RW-279_Items_TC005_Row Type_Verify the format of the page after selecting Increment Row Type for Row Type
	@SuppressWarnings("static-access")
	public Reporter TC36785(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC36785 Started..");

		try {
					
			obj.repAddData( "Verify the format of the page after selecting 'Increment Row Type' for Row Type ", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp,"Items Link", true);
			ClickByXpath(objRWModules.Items_ViewItem_BtnAddItem_xp, "Add Item", true);
			
			HighlightElementByXpath(objRWModules.Items_AddItem_ComboRowType_xp);
			
			//Select 'Increment Row Type' from Select Box
			Select rowType = new Select(driver.findElement(By.xpath(objRWModules.Items_AddItem_ComboRowType_xp)));
			rowType.selectByVisibleText("Increment Row Type");
			
			//Validate all Fields
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_ItemName_nm,"Item Name text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_RowTypeSelector_nm,"Row Type combo box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxRequired_xp,"Required check box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required check box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxNonBudgetItem_xp,"Non Budget Item check box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultMaterial_nm,"Default Material text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultLabor_nm,"Default Labor text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultHours_nm,"Default Hours text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_GLCode_nm,"GL Code text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_Category_nm,"Category text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_Subcategory_nm,"Sub Category box", true, true);
			ClickByXpath(objRWModules.Items_AddItem_OpenCommentsSection_xp,"Open Description",true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_ItemComment_nm,"Comment Box",true,true);
			
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);  //post condition
			fnVerifyCancelForm(1);

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC36785 Failed!", e );
		}
		finally {

			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC36785 Completed");
		}
		return obj;
	} //End of function TC36785
	
	//RW-279_Items_TC006_Row Type_Verify the format of the page after selecting Multiple Sku Display for Row Type
	@SuppressWarnings("static-access")
	public Reporter TC36786(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC36786 Started..");

		try {
					
			obj.repAddData( "Verify the format of the page after selecting 'Multiple SKU' for Row Type ", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp,"Items Link", true);
			ClickByXpath(objRWModules.Items_ViewItem_BtnAddItem_xp, "Add Item", true);
			
			HighlightElementByXpath(objRWModules.Items_AddItem_ComboRowType_xp);
			
			//Select 'Multiple SKU' from Select Box
			Select rowType = new Select(driver.findElement(By.xpath(objRWModules.Items_AddItem_ComboRowType_xp)));
			rowType.selectByVisibleText("Multiple Sku Display");
			
			//Validate all Fields
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_ItemName_nm,"Item Name text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_RowTypeSelector_nm,"Row Type combo box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxRequired_xp,"Required check box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required check box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxNonBudgetItem_xp,"Non Budget Item check box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_GLCode_nm,"GL Code text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_Category_nm,"Category text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_Subcategory_nm,"Sub Category box", true, true);
			ClickByXpath(objRWModules.Items_AddItem_OpenCommentsSection_xp,"Open Description",true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_ItemComment_nm,"Comment Box",true,true);
			
			//Product Comments
			ClickByXpath(objRWModules.Items_AddItem_ProductsPanelHeader_xp,"Open Products",true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_SKU_nm,"SKU",true,true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_MultiPakSKU_nm,"Multi Pak SKU",true,true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultStoreNumber_nm,"Default Store Number",true,true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_Description_nm,"Description",true,true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_ProductDefaultLabor_nm,"Product Default Labor",true,true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_ProductDefaultHours_nm,"Product Default Hours",true,true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_ProductGLCode_nm,"Product GL Code",true,true);
			
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);  //post condition
			fnVerifyCancelForm(1);

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC36786 Failed!", e );
		}
		finally {

			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC36786 Completed");
		}
		return obj;
	} //End of function TC36786
	
	//RW-279_Items_TC007_Verify the format of the page after selecting Optional Increment Display for Row Type
	@SuppressWarnings("static-access")
	public Reporter TC36787(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC36787 Started..");

		try {
					
			obj.repAddData( "Verify the format of the page after selecting 'Optional Increment Display' for Row Type ", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp,"Items Link", true);
			ClickByXpath(objRWModules.Items_ViewItem_BtnAddItem_xp, "Add Item", true);
			
			HighlightElementByXpath(objRWModules.Items_AddItem_ComboRowType_xp);
			
			//Select 'Optional Increment Display' from Select Box
			Select rowType = new Select(driver.findElement(By.xpath(objRWModules.Items_AddItem_ComboRowType_xp)));
			rowType.selectByVisibleText("Optional Increment Row Type");
			
			//Validate all Fields
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_ItemName_nm,"Item Name text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_RowTypeSelector_nm,"Row Type combo box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxRequired_xp,"Required check box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required check box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxNonBudgetItem_xp,"Non Budget Item check box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_GLCode_nm,"GL Code text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_Category_nm,"Category text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_Subcategory_nm,"Sub Category box", true, true);
			ClickByXpath(objRWModules.Items_AddItem_OpenCommentsSection_xp,"Open Description",true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_ItemComment_nm,"Comment Box",true,true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultPrice_nm,"Default Price",true,true);
			
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);  //post condition
			fnVerifyCancelForm(1);

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC36787 Failed!", e );
		}
		finally {

			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC36787 Completed");
		}
		return obj;
	} //End of function TC36787
	
	
	//RW-279_Items_TC008_Verify the format of the page after selecting Package Row Type for Row Type
	@SuppressWarnings("static-access")
	public Reporter TC36788(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC36788 Started..");

		try {
					
			obj.repAddData( "Verify the format of the page after selecting 'Package Row Type' for Row Type ", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp,"Items Link", true);
			ClickByXpath(objRWModules.Items_ViewItem_BtnAddItem_xp, "Add Item", true);
			
			HighlightElementByXpath(objRWModules.Items_AddItem_ComboRowType_xp);
			
			//Select 'Package Row Type' from Select Box
			Select rowType = new Select(driver.findElement(By.xpath(objRWModules.Items_AddItem_ComboRowType_xp)));
			rowType.selectByVisibleText("Package Row Type");
			
			//Validate all Fields
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_ItemName_nm,"Item Name text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_RowTypeSelector_nm,"Row Type combo box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxRequired_xp,"Required check box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required check box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxNonBudgetItem_xp,"Non Budget Item check box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_GLCode_nm,"GL Code text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_Category_nm,"Category text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_Subcategory_nm,"Sub Category box", true, true);
			ClickByXpath(objRWModules.Items_AddItem_OpenCommentsSection_xp,"Open Description",true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_ItemComment_nm,"Comment Box",true,true);
			
			//Product Comments
			ClickByXpath(objRWModules.Items_AddItem_ProductsPanelHeader_xp,"Open Products",true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_SKU_nm,"SKU",true,true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_MultiPakSKU_nm,"Multi Pak SKU",true,true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_MultiPakQty_nm,"Multi Pak Qty",true,true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultStoreNumber_nm,"Default Store Number",true,true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_Description_nm,"Description",true,true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_ProductDefaultLabor_nm,"Product Default Labor",true,true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_ProductDefaultHours_nm,"Product Default Hours",true,true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_ProductGLCode_nm,"Product GL Code",true,true);
			
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);  //post condition
			fnVerifyCancelForm(1);

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC36788 Failed!", e );
		}
		finally {

			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC36788 Completed");
		}
		return obj;
	} //End of function TC36788
	
	//RW-279_Items_TC009_Verify the format of the page after Selecting Tenant Only for Row Type
	@SuppressWarnings("static-access")
	public Reporter TC36789(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC36789 Started..");

		try {
					
			obj.repAddData( "Verify the format of the page after selecting 'Tenant Only' for Row Type ", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp,"Items Link", true);
			ClickByXpath(objRWModules.Items_ViewItem_BtnAddItem_xp, "Add Item", true);
			
			HighlightElementByXpath(objRWModules.Items_AddItem_ComboRowType_xp);
			
			//Select 'Tenant Only' from Select Box
			Select rowType = new Select(driver.findElement(By.xpath(objRWModules.Items_AddItem_ComboRowType_xp)));
			rowType.selectByVisibleText("Tenant Only");
			
			//Validate all Fields
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_ItemName_nm,"Item Name text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_RowTypeSelector_nm,"Row Type combo box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxRequired_xp,"Required check box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required check box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxPriceOverride_xp,"Price Override check box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxNonBudgetItem_xp,"Non Budget Item check box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultMaterial_nm,"Default Material text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultLabor_nm,"Default Labor text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultHours_nm,"Default Hours text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_GLCode_nm,"GL Code text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_Category_nm,"Category text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_Subcategory_nm,"Sub Category box", true, true);
			ClickByXpath(objRWModules.Items_AddItem_OpenCommentsSection_xp,"Open Description",true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_ItemComment_nm,"Comment Box",true,true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultPrice_nm,"Default Price",true,true);

			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);  //post condition
			fnVerifyCancelForm(1);

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC36789 Failed!", e );
		}
		finally {

			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC36789 Completed");
		}
		return obj;
	} //End of function TC36789
	
	
	//RW-279_Items_TC010_Verify the format of the page after selecting Whole Budget Percent for Row Type
	@SuppressWarnings("static-access")
	public Reporter TC36790(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC36790 Started..");

		try {
					
			obj.repAddData( "Verify the format of the page after selecting 'Whole Budget Percent' for Row Type ", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp,"Items Link", true);
			ClickByXpath(objRWModules.Items_ViewItem_BtnAddItem_xp, "Add Item", true);
			
			HighlightElementByXpath(objRWModules.Items_AddItem_ComboRowType_xp);
			
			//Select 'Whole Budget Percent' from Select Box
			Select rowType = new Select(driver.findElement(By.xpath(objRWModules.Items_AddItem_ComboRowType_xp)));
			rowType.selectByVisibleText("Whole Budget Percent");
			
			//Validate all Fields
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_ItemName_nm,"Item Name text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_RowTypeSelector_nm,"Row Type combo box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required check box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxNonBudgetItem_xp,"Non Budget Item check box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_PercentBudget_nm,"Percent Budget text box", true, true);

			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_GLCode_nm,"GL Code text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_Category_nm,"Category text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_Subcategory_nm,"Sub Category box", true, true);
			

			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);  //post condition
			fnVerifyCancelForm(1);

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC36790 Failed!", e );
		}
		finally {

			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC36790 Completed");
		}
		return obj;
	} //End of function TC36790
	
	//RW-279_Items_TC011_Verify the format of the page after selecting Whole House SqFT  for Row Type
	@SuppressWarnings("static-access")
	public Reporter TC36791(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC36791 Started..");

		try {
					
			obj.repAddData( "Verify the format of the page after selecting 'Whole House SqFt' for Row Type ", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			
			ClickByXpath(objRWModules.Items_GenItem_LinkItemsOption_xp,"Items Link", true);
			ClickByXpath(objRWModules.Items_ViewItem_BtnAddItem_xp, "Add Item", true);
			
			HighlightElementByXpath(objRWModules.Items_AddItem_ComboRowType_xp);
			
			//Select 'Whole House SqFt' from Select Box
			Select rowType = new Select(driver.findElement(By.xpath(objRWModules.Items_AddItem_ComboRowType_xp)));
			rowType.selectByVisibleText("Whole House SqFT");
			
			//Validate all Fields
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_ItemName_nm,"Item Name text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_RowTypeSelector_nm,"Row Type combo box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxRequired_xp,"Required check box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxPictureRequired_xp,"Picture Required check box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Items_AddItem_CheckBoxNonBudgetItem_xp,"Non Budget Item check box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_MaterialRate_nm,"Material Rate text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_LaborRate_nm,"Labor Rate text box", true, true);

			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_DefaultHours_nm,"Default Hours text box", true, true);

			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_GLCode_nm,"GL Code text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_Category_nm,"Category text box", true, true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_Subcategory_nm,"Sub Category box", true, true);
			ClickByXpath(objRWModules.Items_AddItem_OpenCommentsSection_xp,"Open Description",true);
			fnCheckFieldDisplayByName(objRWModules.Items_AddItem_ItemComment_nm,"Comment Box",true,true);

			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);  //post condition
			fnVerifyCancelForm(1);

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC36791 Failed!", e );
		}
		finally {

			if(!testCaseStatus)
			{
				Reporter.iTotalFail++;	
			}
			else
			{
				Reporter.iTotalPass++;
			}
			log.info("Execution of Function TC36791 Completed");
		}
		return obj;
	} //End of function TC36791
	
	
}