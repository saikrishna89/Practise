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

public class ProductTiers extends TestDriver {
	RenowalkModules objRWModules = new RenowalkModules();
	RenowalkHome objRWHome = new RenowalkHome();
	AppMessages objAppMessages = new AppMessages();

	//View Product Tier

	//RW-90_Product Tiers_TC001_View existing Product Tiers_View list of product tiers
	@SuppressWarnings("static-access")
	public Reporter TC31888(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31888 Started..");

		try {

			obj.repAddData( "Viewing the Product Tiers", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);

			ClickByXpath(objRWModules.ProductTiers_GenProd_LinkProductTiersOption_xp, "Product Tiers Link",true);
			fnLoadingPageWait();

			fnSelectFromComboBoxXpath(objRWModules.Common_ViewModules_ComboPageSize_xp, "VIEW ALL");
			fnLoadingPageWait();
			HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWModules.Common_ViewModules_Table_xp, "Product Tiers");
			fnCheckSortedList(mTableData,"Product Tiers",1);
			System.out.println("Sorted Functionality Tested Successfully");
			////////////////////Sorting Logic End////////////////////////////

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31888 Failed!", e );
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
			log.info("Execution of Function TC31888 Completed");
		}
		return obj;
	} //End of function TC31888	


	//RW-90_Product Tiers_TC002_View existing Product Tiers_Options to Add Product Tier
	@SuppressWarnings("static-access")
	public Reporter TC31889(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31889 Started..");

		try {

			obj.repAddData( "Availability of Add Product Tier option", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);

			ClickByXpath(objRWModules.ProductTiers_GenProd_LinkProductTiersOption_xp, "Product Tiers Link",true);
			fnLoadingPageWait();

			fnCheckFieldDisplayByXpath(RenowalkModules.ProductTiers_ViewProductTiers_BtnAddProductTier_xp,"'Add Product Tier' button",true,true);
			HighlightElement(driver.findElement(By.xpath(RenowalkModules.ProductTiers_ViewProductTiers_BtnAddProductTier_xp)));

			WebElement eleTable = driver.findElement(By.xpath(objRWModules.Common_ViewModules_Table_xp));
			List<WebElement> arrHeaderColumns = eleTable.findElements(By.xpath("./thead/tr/th"));  //Get the header
			System.out.println("Rows Size>>>>"+arrHeaderColumns.size());
			fnVerifyHeaders(arrHeaderColumns,0,"Product Tier Name");  //There is one improvement RW-286. Once implemented, change it to Product Tier

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31889 Failed!", e );
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
			log.info("Execution of Function TC31889 Completed");
		}
		return obj;
	} //End of function TC31889	


	//RW-90_Product Tiers_TC003_View existing Product Tiers_Options to edit or delete
	@SuppressWarnings("static-access")
	public Reporter TC31890(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31890 Started..");

		try {

			obj.repAddData( "Availability of Edit and Delete Options", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);

			ClickByXpath(objRWModules.ProductTiers_GenProd_LinkProductTiersOption_xp, "Product Tiers Link",true);
			fnLoadingPageWait();

			fnSelectFromComboBoxXpath(objRWModules.Common_ViewModules_ComboPageSize_xp, "VIEW ALL");
			fnLoadingPageWait();

			HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWModules.Common_ViewModules_Table_xp, "Product Tiers");
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
			log.error( "Function TC31890 Failed!", e );
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
			log.info("Execution of Function TC31890 Completed");
		}
		return obj;
	} //End of function TC31890	


	//RW-90_Product Tiers_TC004_View existing Product Tiers_Prompt to select office
	@SuppressWarnings("static-access")
	public Reporter TC31891(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31891 Started..");

		try {

			obj.repAddData( "Verify Select Office Prompt", "", "", "");
			fnSelectCorpOffice("Select", sOffice);
			fnVerifyDialogBox("OfficeCode", 1);
			ClickByXpath(objRWModules.ProductTiers_GenProd_LinkProductTiersOption_xp, "Product Tiers Link",true);
			fnVerifyDialogBox("OfficeCode", 1);	

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
			log.error( "Function TC31891 Failed!", e );
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

			log.info("Execution of Function TC31891 Completed");
		}
		return obj;
	} //End of function TC31891	

	//RW-90_Product Tiers_TC005_View existing Product Tiers_Availability of Pagination options
	@SuppressWarnings("static-access")
	public Reporter TC31892(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31892 Started..");

		try {

			obj.repAddData( "Availability of Pagination Options", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);

			ClickByXpath(objRWModules.ProductTiers_GenProd_LinkProductTiersOption_xp, "Product Tiers Link",true);
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
			log.error( "Function TC31892 Failed!", e );
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
			log.info("Execution of Function TC31892 Completed");
		}
		return obj;
	} //End of function TC31892	

	//RW-90_Product Tiers_TC006_View existing Product Tiers_Validate Current Product Tiers table using pagination option
	@SuppressWarnings("static-access")
	public Reporter TC31893(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31893 Started..");

		try {

			obj.repAddData( "Product Tier Table Count for VIEW ALL Option", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);

			ClickByXpath(objRWModules.ProductTiers_GenProd_LinkProductTiersOption_xp, "Product Tiers Link",true);
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
			log.error( "Function TC31893 Failed!", e );
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
			log.info("Execution of Function TC31893 Completed");
		}
		return obj;
	} //End of function TC31893	


	//RW-90_Product Tiers_TC007_View existing Product Tiers_Validate Pagination for option 10 for current page
	@SuppressWarnings("static-access")
	public Reporter TC31894(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31894 Started..");

		try {

			obj.repAddData("Validate Pagination for Option 10 for current page", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);

			ClickByXpath(objRWModules.ProductTiers_GenProd_LinkProductTiersOption_xp, "Product Tiers Link",true);
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
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_LabelPageNum_xp,"'Page Number' textbox",true,true);
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
			log.error( "Function TC31894 Failed!", e );
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
			log.info("Execution of Function TC31894 Completed");
		}
		return obj;
	} //End of function TC31894	

	//RW-90_Product Tiers_TC008_View existing Product Tiers_Validate Pagination for option 10 for all the pages
	@SuppressWarnings("static-access")
	public Reporter TC31895(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31895 Started..");

		try {

			obj.repAddData("Validate pagination for any page with option 10 for all the pages", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);

			ClickByXpath(objRWModules.ProductTiers_GenProd_LinkProductTiersOption_xp, "Product Tiers Link",true);
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
			log.error( "Function TC31895 Failed!", e );
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
			log.info("Execution of Function TC31895 Completed");
		}
		return obj;
	} //End of function TC31895	

	//RW-90_Product Tiers_TC009_View existing Product Tiers_Validate Pagination for option 10 with specific page
	@SuppressWarnings("static-access")
	public Reporter TC31896(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31896 Started..");

		try {

			obj.repAddData("Validate pagination for any page with option 10 with specific page", "", "", "");


			fnSelectCorpOffice(sCorporation, sOffice);

			ClickByXpath(objRWModules.ProductTiers_GenProd_LinkProductTiersOption_xp, "Product Tiers Link",true);
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
			log.error( "Function TC31896 Failed!", e );
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
			log.info("Execution of Function TC31896 Completed");
		}
		return obj;
	} //End of function TC31896	


	//RW-90_Product Tiers_TC010_View existing Product Tiers_Validate Pagination for option 20 for current page
	@SuppressWarnings("static-access")
	public Reporter TC31897(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31897 Started..");

		try {

			obj.repAddData("Validate Pagination for Option 20 for current page", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);

			ClickByXpath(objRWModules.ProductTiers_GenProd_LinkProductTiersOption_xp, "Product Tiers Link",true);
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
			Thread.sleep(5000);
			fnVerifyNumofRecords("20");
			boolean bElementFound = fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",false,true);
			int iRows = fnGetTableRowsCount(objRWModules.Common_ViewModules_Table_xp);

			if(bElementFound==true || iRows>20)
			{
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_BtnPreviousLink_xp,"'Previous' button",true,true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_BtnNextLink_xp,"'Next' button",true,true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_LabelPageNum_xp,"'Page Number' textbox",true,true);
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
			log.error( "Function TC31897 Failed!", e );
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
			log.info("Execution of Function TC31897 Completed");
		}
		return obj;
	} //End of function TC31897	

	//RW-90_Product Tiers_TC011_View existing Product Tiers_Validate Pagination for option 20 for all the pages
	@SuppressWarnings("static-access")
	public Reporter TC31898(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31898 Started..");

		try {

			obj.repAddData("Validate pagination for any page with option 20 for all the pages", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);

			ClickByXpath(objRWModules.ProductTiers_GenProd_LinkProductTiersOption_xp, "Product Tiers Link",true);
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
			Thread.sleep(5000);
			fnVerifyNumofRecords("20");

			boolean bElementFound = fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",false,true);
			int iRows = fnGetTableRowsCount(objRWModules.Common_ViewModules_Table_xp);

			if(bElementFound==true || iRows>20)
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
			log.error( "Function TC31898 Failed!", e );
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
			log.info("Execution of Function TC31898 Completed");
		}
		return obj;
	} //End of function TC31898	

	//RW-90_Product Tiers_TC012_View existing Product Tiers_Validate Pagination for option 20 with specific page
	@SuppressWarnings("static-access")
	public Reporter TC31899(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31899 Started..");

		try {

			obj.repAddData("Validate pagination for any page with option 20 with specific page", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);

			ClickByXpath(objRWModules.ProductTiers_GenProd_LinkProductTiersOption_xp, "Product Tiers Link",true);
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
			Thread.sleep(5000);
			fnVerifyNumofRecords("20");

			boolean bElementFound = fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",false,true);
			int iRows = fnGetTableRowsCount(objRWModules.Common_ViewModules_Table_xp);

			if(bElementFound==true || iRows>20)
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
			log.error( "Function TC31896 Failed!", e );
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
			log.info("Execution of Function TC31896 Completed");
		}
		return obj;
	} //End of function TC31896	


	//RW-90_Product Tiers_TC013_View existing Product Tiers_Validate for Page Counter and Navigation
	@SuppressWarnings("static-access")
	public Reporter TC31900(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31900 Started..");

		try {

			obj.repAddData("Validate Page Counter and Navigation", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);

			ClickByXpath(objRWModules.ProductTiers_GenProd_LinkProductTiersOption_xp, "Product Tiers Link",true);
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
			log.error( "Function TC31900 Failed!", e );
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
			log.info("Execution of Function TC31900 Completed");
		}
		return obj;
	} //End of function TC31900	

	//RW-90_Product Tiers_TC014_View existing Product Tiers_Loading icon shown
	@SuppressWarnings("static-access")
	public Reporter TC31901(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31901 Started..");

		try {

			obj.repAddData("Verify Loading Icon when page loads", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);

			ClickByXpath(objRWModules.ProductTiers_GenProd_LinkProductTiersOption_xp, "Product Tiers Link",true);
			fnLoadingPageWait();

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31901 Failed!", e );
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
			log.info("Execution of Function TC31901 Completed");
		}
		return obj;
	} //End of function TC31901	

	//RW-91_Product Tiers_TC001_Add Product Tier_Verify the prompt for ADD PRODUCT TIER
	@SuppressWarnings("static-access")
	public Reporter TC31903(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31903 Started..");

		try {

			obj.repAddData( "Adding the Product Tier", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);

			ClickByXpath(objRWModules.ProductTiers_GenProd_LinkProductTiersOption_xp, "Product Tiers Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.ProductTiers_ViewProductTiers_BtnAddProductTier_xp, "Add Product Tier button",true);
			fnCheckFieldDisplayById(objRWModules.ProductTiers_AddProductTier_InputProductTier_id,"Product Tier text box", true, true);
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
			log.error( "Function TC31903 Failed!", e );
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

			log.info("Execution of Function TC31903 Completed");
		}
		return obj;
	} //End of function TC31903	

	//RW-91_Product Tiers_TC002_Add Product Tier_Verify Name field
	@SuppressWarnings("static-access")
	public Reporter TC31904(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31904 Started..");

		try {

			obj.repAddData( "Validating the Product Tier", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);

			ClickByXpath(objRWModules.ProductTiers_GenProd_LinkProductTiersOption_xp, "Product Tiers Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.ProductTiers_ViewProductTiers_BtnAddProductTier_xp, "Add Product Tier button",true);
			fnCheckFieldDisplayById(objRWModules.ProductTiers_AddProductTier_InputProductTier_id,"Product Tier text box", true, true);

			String sProductTier = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.id(objRWModules.ProductTiers_AddProductTier_InputProductTier_id)).sendKeys(sProductTier);
			driver.findElement(By.id(objRWModules.ProductTiers_AddProductTier_InputProductTier_id)).clear();

			fnCheckFieldDisplayByXpath(objRWModules.ProductTiers_AddProductTier_ErrorMsgRequired_xp,"Required Error Message", true, true);
			String sErrorMsg = driver.findElement(By.xpath(objRWModules.ProductTiers_AddProductTier_ErrorMsgRequired_xp)).getText().toString().trim();
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
			log.error( "Function TC31904 Failed!", e );
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

			log.info("Execution of Function TC31904 Completed");
		}
		return obj;
	} //End of function TC31904	


	//RW-91_Product Tiers_TC003_Add Product Tier_Verify current product tier display
	@SuppressWarnings("static-access")
	public Reporter TC31905(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31905 Started..");

		try {

			obj.repAddData( "Viewing the Product Tiers", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);

			ClickByXpath(objRWModules.ProductTiers_GenProd_LinkProductTiersOption_xp, "Product Tiers Link",true);
			fnLoadingPageWait();


			HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWModules.Common_ViewModules_Table_xp, "Product Tiers");
			fnCheckSortedList(mTableData,"Name",1);
			System.out.println("Sorted Functionality Tested Successfully");
			////////////////////Sorting Logic End////////////////////////////

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC31905 Failed!", e );
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
			log.info("Execution of Function TC31905 Completed");
		}
		return obj;
	} //End of function TC31905	

	//RW-91_Product Tiers_TC004_Add Product Tier_Save Product Tier Name
	@SuppressWarnings("static-access")
	public Reporter TC31906(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31906 Started..");

		try {

			obj.repAddData( "Add and Save a Product Tier", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);

			ClickByXpath(objRWModules.ProductTiers_GenProd_LinkProductTiersOption_xp, "Product Tiers Link",true);
			fnLoadingPageWait();


			ClickByXpath(objRWModules.ProductTiers_ViewProductTiers_BtnAddProductTier_xp, "Add Product Tier button",true);
			fnCheckFieldDisplayById(objRWModules.ProductTiers_AddProductTier_InputProductTier_id,"Product Tier text box", true, true);

			int iRandomNum = fnRandomNum(1,10000);
			String sProductTier = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			SendKeyById(objRWModules.ProductTiers_AddProductTier_InputProductTier_id, sProductTier+iRandomNum, "Name");
			//*This field is required

			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",true); 			
			fnVerifyDialogBox("Add", 0);

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
			log.error( "Function TC31906 Failed!", e );
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

			log.info("Execution of Function TC31906 Completed");
		}
		return obj;
	} //End of function TC31906	

	//RW-91_Product Tiers_TC005_Add Product Tier_Cancel Product Tier Name
	@SuppressWarnings("static-access")
	public Reporter TC31907(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC31907 Started..");

		try {

			obj.repAddData( "Cancelling a Product Tier", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);

			ClickByXpath(objRWModules.ProductTiers_GenProd_LinkProductTiersOption_xp, "Product Tiers Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.ProductTiers_ViewProductTiers_BtnAddProductTier_xp, "Add Product Tier button",true);
			fnCheckFieldDisplayById(objRWModules.ProductTiers_AddProductTier_InputProductTier_id,"Product Tier text box", true, true);

			int iRandomNum = fnRandomNum(1,10000);
			String sProductTier = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			SendKeyById(objRWModules.ProductTiers_AddProductTier_InputProductTier_id, sProductTier+iRandomNum,"Name");
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
			log.error( "Function TC31907 Failed!", e );
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

			log.info("Execution of Function TC31907 Completed");
		}
		return obj;
	} //End of function TC31907	


	//RW-91_Product Tiers_TC008_Add Product Tier_Validate Product Tier Name with characters length more than 80
	@SuppressWarnings("static-access")
	public Reporter TC32900(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC32900 Started..");

		try {

			obj.repAddData( "Add and Save a Product Tier with length more than 80", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);

			ClickByXpath(objRWModules.ProductTiers_GenProd_LinkProductTiersOption_xp, "Product Tier Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.ProductTiers_ViewProductTiers_BtnAddProductTier_xp, "Add Product Tier button",true);
			fnCheckFieldDisplayById(objRWModules.ProductTiers_AddProductTier_InputProductTier_id,"Product Tier text box", true, true);

			int iRandomNum = fnRandomNum(1,10000);
			String sProductTier = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			SendKeyById(objRWModules.ProductTiers_AddProductTier_InputProductTier_id, sProductTier+iRandomNum, "Name");

			fnCheckFieldDisplayByXpath(objRWModules.ProductTiers_AddProductTier_ErrorMsgMaxLength_xp,"Max Length Error Message", true, true);
			String sErrorMsg =driver.findElement(By.xpath(objRWModules.ProductTiers_AddProductTier_ErrorMsgMaxLength_xp)).getText().toString().trim();
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
			log.error( "Function TC32900 Failed!", e );
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

			log.info("Execution of Function TC32900 Completed");
		}
		return obj;
	} //End of function TC32900	


	//RW-91_Product Tiers_TC009_Add Product Tier_Validate Product Tier with characters length 80 and special characters
	@SuppressWarnings("static-access")
	public Reporter TC32901(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC32901 Started..");

		try {

			obj.repAddData( "Add and Save a Product Tier with characters length 80 and special characters", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);

			ClickByXpath(objRWModules.ProductTiers_GenProd_LinkProductTiersOption_xp, "Product Tier Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.ProductTiers_ViewProductTiers_BtnAddProductTier_xp, "Add Product Tier button",true);
			fnCheckFieldDisplayById(objRWModules.ProductTiers_AddProductTier_InputProductTier_id,"Product Tier text box", true, true);

			int iRandomNum = fnRandomNum(10000000,99999999);
			String sProductTier = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			SendKeyById(objRWModules.ProductTiers_AddProductTier_InputProductTier_id, sProductTier+iRandomNum, "Name");
			System.out.println("Size>>>>>>>>>>>>>>>"+sProductTier.length()+String.valueOf(iRandomNum).length());

			if(driver.findElement(By.xpath(objRWModules.Common_AddModule_BtnSave_xp)).isEnabled())
			{
				ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",true);
				fnLoadingPageWait();
			}
			else
			{
				obj.repAddData( "Click on Save button", "Save button should be clicked","Save button not clicked", "Fail");
				ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);  //post condition
			}

			fnVerifyDialogBox("Add", 0);
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
			log.error( "Function TC32901 Failed!", e );
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

			log.info("Execution of Function TC32901 Completed");
		}
		return obj;
	} //End of function TC32901	

	//RW-91_Product Tiers_TC010_Add Product Tier_Validate Product Tier by adding a duplicate Product Tier Name
	@SuppressWarnings("static-access")
	public Reporter TC32902(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC32902 Started..");

		try {

			obj.repAddData( "Adding a Duplicate Product Tier", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);

			ClickByXpath(objRWModules.ProductTiers_GenProd_LinkProductTiersOption_xp, "Product Tier Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.ProductTiers_ViewProductTiers_BtnAddProductTier_xp, "Add Product Tier button",true);
			fnCheckFieldDisplayById(objRWModules.ProductTiers_AddProductTier_InputProductTier_id,"Product Tier text box", true, true);

			int iRandomNum = fnRandomNum(1,10000);
			String sProductTier = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			SendKeyById(objRWModules.ProductTiers_AddProductTier_InputProductTier_id, sProductTier+iRandomNum,"Name");
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",true); 

			fnVerifyDialogBox("Add", 0);

			ClickByXpath(objRWModules.ProductTiers_ViewProductTiers_BtnAddProductTier_xp, "Add Product Tier button",true);
			SendKeyById(objRWModules.ProductTiers_AddProductTier_InputProductTier_id, sProductTier+iRandomNum,"Name");

			fnCheckFieldDisplayByXpath(objRWModules.ProductTiers_AddProductTier_ErrorMsgDuplicate_xp,"Duplicate Error Message", true, true);
			String sErrorMsg =driver.findElement(By.xpath(objRWModules.ProductTiers_AddProductTier_ErrorMsgDuplicate_xp)).getText().toString().trim();
			if(sErrorMsg.equalsIgnoreCase(objAppMessages.ProductTiers_AddProductTier_ErrorMsgDuplicate_msg))
			{
				obj.repAddData( "Verify Duplicate Error Message", "'"+objAppMessages.ProductTiers_AddProductTier_ErrorMsgDuplicate_msg+"' should be shown", "'"+objAppMessages.ProductTiers_AddProductTier_ErrorMsgDuplicate_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Duplicate Error Message", "'"+objAppMessages.ProductTiers_AddProductTier_ErrorMsgDuplicate_msg+"' should be shown","'"+ objAppMessages.ProductTiers_AddProductTier_ErrorMsgDuplicate_msg+"' not shown", "Fail");
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
			log.error( "Function TC32902 Failed!", e );
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

			log.info("Execution of Function TC32902 Completed");
		}
		return obj;
	} //End of function TC32902	




	//RW-91_Product Tiers_TC010_Add Product Tier_Validate Product tier Name with blank characters
	@SuppressWarnings("static-access")
	public Reporter TC32903(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC32903 Started..");

		try {

			obj.repAddData( "Validating the Product Tier with blank characters", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);

			ClickByXpath(objRWModules.ProductTiers_GenProd_LinkProductTiersOption_xp, "Product Tiers Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.ProductTiers_ViewProductTiers_BtnAddProductTier_xp, "Add Product Tier button",true);
			fnCheckFieldDisplayById(objRWModules.ProductTiers_AddProductTier_InputProductTier_id,"Product Tier text box", true, true);

			String sProductTier = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.id(objRWModules.ProductTiers_AddProductTier_InputProductTier_id)).sendKeys(sProductTier);
			driver.findElement(By.id(objRWModules.ProductTiers_AddProductTier_InputProductTier_id)).clear();

			fnCheckFieldDisplayByXpath(objRWModules.ProductTiers_AddProductTier_ErrorMsgRequired_xp,"Required Error Message", true, true);
			String sErrorMsg =driver.findElement(By.xpath(objRWModules.ProductTiers_AddProductTier_ErrorMsgRequired_xp)).getText().toString().trim();
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
			log.error( "Function TC32903 Failed!", e );
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

			log.info("Execution of Function TC32903 Completed");
		}
		return obj;
	} //End of function TC32903	

	
}