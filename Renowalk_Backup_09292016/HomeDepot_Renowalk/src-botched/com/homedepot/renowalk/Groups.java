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

public class Groups extends TestDriver {
	RenowalkModules objRWModules = new RenowalkModules();
	RenowalkHome objRWHome = new RenowalkHome();
	AppMessages objAppMessages = new AppMessages();
	//RW-240_Groups_TC001_View Groups_View Groups
	@SuppressWarnings("static-access")
	public Reporter TC35857(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35857 Started..");

		try {
					
			obj.repAddData( "Viewing the Groups", "", "", "");
			
			/*ClickByXpath(objRWModules.Corporations_GenCorp_LinkCorporationsOption_xp, "Corporations Link",true);
			fnLoadingPageWait();
			ClickByXpath(objRWModules.Regions_GenRegion_LinkRegionsOption_xp, "Regions Link",true);
			fnLoadingPageWait();*/
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Groups Link",true);
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
			
			HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWModules.Common_ViewModules_Table_xp, "Groups");
			fnCheckSortedList(mTableData,"Group Name",1);
			System.out.println("Sorted Functionality Tested Successfully");
						////////////////////Sorting Logic End////////////////////////////

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC35857 Failed!", e );
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
*/				log.info("Execution of Function TC35857 Completed");
		}
		return obj;
	} //End of function TC35857
	
	
	
	//RW-240_Groups_TC002_View Groups_Prompt to select office
	@SuppressWarnings("static-access")
	public Reporter TC35859(Reporter obj) throws Exception
	{
		Boolean bLoginFlag = false;	
		log.info("Execution of Function TC35859 Started..");
		

		try {
					
				obj.repAddData( "View Groups", "", "", "");
				
				//fnSelectFromComboBoxXpath(objRWModules.Common_AllModules_ComboCorporateName_xp, "Select");
				//ClickByXpath(objRWModules.Common_AllModules_ComboCorporateName_xp, "Corporation Selection",true);
				fnSelectCorpOffice("Select", "Select");
				//fnSelectCorpOffice(objRWModules.Common_AllModules_ComboCorporateName_xp, sOffice);
				ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Groups Link",true);
				fnVerifyDialogBox("OfficeCode",1);
				//Navigate back to home page so next test runs correctly
				ClickByXpath("//*[@id='sidebarLogo']", "Groups Link",false);
				fnSelectCorpOffice(sCorporation, sOffice);
				
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC35859 Failed!", e );
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
			
			log.info("Execution of Function TC35859 Completed");
		}
		return obj;
	} //End of function TC35859
	
	
	//RW-240_Groups_TC003_View Groups_verify columns
	@SuppressWarnings("static-access")
	public Reporter TC35860(Reporter obj) throws Exception
	{
		Boolean bLoginFlag = false;	
		log.info("Execution of Function TC35860 Started..");
		

		try {
					
				obj.repAddData( "View Groups", "", "", "");
				fnSelectCorpOffice(sCorporation, sOffice);
				ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Groups Link",true);
										
				WebElement eleTable = driver.findElement(By.xpath(objRWModules.Common_ViewModules_Table_xp));
				List<WebElement> arrHeaderColumns = eleTable.findElements(By.xpath("./thead/tr/th"));  //Get the header
				System.out.println("Rows Size>>>>"+arrHeaderColumns.size());
				fnVerifyHeaders(arrHeaderColumns,0,"Group Name");
				fnVerifyHeaders(arrHeaderColumns,1,"Max Number Per House");
				fnVerifyHeaders(arrHeaderColumns,2,"Include Measurements");
				fnVerifyHeaders(arrHeaderColumns,3,"Include Paint");
				fnVerifyHeaders(arrHeaderColumns,4,"Include Comment");
			
				HashMap<Integer, HashMap<Integer, String>> mTableData = fnGetTableData(objRWModules.Common_ViewModules_Table_xp, "Groups");
				boolean bCopyEditDelete = true;
				boolean bCheckBox = true;
				int iRow = 0;
				for(iRow=1;iRow<=mTableData.size();iRow++)
				{
					String[] arrCopyEditDelete = mTableData.get(iRow).get(6).toString().trim().split(";;");
					if(!arrCopyEditDelete[0].toString().trim().equalsIgnoreCase("Copy") && !arrCopyEditDelete[1].toString().trim().equalsIgnoreCase("Edit") && !arrCopyEditDelete[2].toString().trim().equalsIgnoreCase("Delete"))
					{
						bCopyEditDelete = false;
						break;
					}
					
					if(!mTableData.get(iRow).get(7).toString().trim().equalsIgnoreCase("checkbox"))
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
			log.error( "Function TC35860 Failed!", e );
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
			
			log.info("Execution of Function TC35860 Completed");
		}
		return obj;
	} //End of function TC35860	
	
	
	//RW-240_Groups_TC004_View Groups_verify option
	@SuppressWarnings("static-access")
	public Reporter TC35861(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35861 Started..");

		try {
					
			obj.repAddData( "Availability of DELETE SELECTED button", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Groups Link",true);
			fnLoadingPageWait();
			
			fnCheckFieldDisplayByXpath(RenowalkModules.Groups_ViewGroup_BtnDeleteSelected_xp,"'DELETE SELECTED' button",true,true);
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC35861 Failed!", e );
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
			log.info("Execution of Function TC35861 Completed");
		}
		return obj;
	} //End of function TC35861	
	
	//RW-240_Groups_TC005_View Groups_verify ADD GROUP
	@SuppressWarnings("static-access")
	public Reporter TC35862(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35862 Started..");

		try {
					
			obj.repAddData( "Availability of ADD GROUP button", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Groups Link",true);
			fnLoadingPageWait();
			
			fnCheckFieldDisplayByXpath(RenowalkModules.Groups_ViewGroup_BtnAddGroup_xp,"'ADD GROUP' button",true,true);
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC35861 Failed!", e );
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
	} //End of function TC35862	
	
	
	//RW-240_Groups_TC006_View Groups_verify Loading message
	@SuppressWarnings("static-access")
	public Reporter TC35863(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35863 Started..");

		try {
					
			obj.repAddData( "Verify loading icon", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Groups Link",true);
			fnLoadingPageWait();			//Currently not coming. loading icon should come on every click on left hand side. Defect already raised.

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC35863 Failed!", e );
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
			log.info("Execution of Function TC35863 Completed");
		}
		return obj;
	} //End of function TC35863
	
	
	//RW-240_Groups_TC007_View Groups_Availability of Pagination options
	@SuppressWarnings("static-access")
	public Reporter TC35914(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35914 Started..");

		try {
					
			obj.repAddData( "Availability of Pagination Options", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Groups Link",true);
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
			log.error( "Function TC35914 Failed!", e );
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
			log.info("Execution of Function TC35914 Completed");
		}
		return obj;
	} //End of function TC35914
	
	//RW-240_Groups_TC008_View Groups_Validate Current Groups table using pagination option
	@SuppressWarnings("static-access")
	public Reporter TC35866(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35866 Started..");

		try {
					
			obj.repAddData( "Groups Table Count for VIEW ALL Option", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Groups Link",true);
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
			log.error( "Function TC35866 Failed!", e );
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
			log.info("Execution of Function TC35866 Completed");
		}
		return obj;
	} //End of function TC35866	
	
	
	
	//RW-240_Groups_TC009_View Groups_Validate Pagination for option 10 for current page
	@SuppressWarnings("static-access")
	public Reporter TC35868(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35868 Started..");

		try {
					
			obj.repAddData("Validate Pagination for Option 10", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Groups Link",true);
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
			log.error( "Function TC35868 Failed!", e );
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
			log.info("Execution of Function TC35868 Completed");
		}
		return obj;
	} //End of function TC35868
	
	
	//RW-240_Groups_TC010_View Groups_Validate Pagination for option 10 for all the pages
	@SuppressWarnings("static-access")
	public Reporter TC35870(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35870 Started..");

		try {
					
			obj.repAddData("Validate Pagination for Option 10", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Groups Link",true);
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
			log.error( "Function TC35870 Failed!", e );
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
			log.info("Execution of Function TC35870 Completed");
		}
		return obj;
	} //End of function TC35870
	
	//RW-240_Groups_TC011_View Groups_Validate Pagination for any page with option 10
	@SuppressWarnings("static-access")
	public Reporter TC35872(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35872 Started..");

		try {
					
			obj.repAddData("Validate pagination for any specific page with option 10", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Groups Link",true);
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
			log.error( "Function TC35872 Failed!", e );
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
			log.info("Execution of Function TC35872 Completed");
		}
		return obj;
	} //End of function TC35872
	
	
	//RW-240_Groups_TC012_View Groups_Validate Pagination for option 20 for current page
	@SuppressWarnings("static-access")
	public Reporter TC35874(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35874 Started..");

		try {
					
			obj.repAddData("Validate Pagination for Option 20", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Groups Link",true);
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
			
			
			if(bElementFound==true || iRows>20)
			{
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_BtnPreviousLink_xp,"'Previous' button",true,true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_BtnNextLink_xp,"'Next' button",true,true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_InputPageNum_xp,"'Page Number' textbox",true,true);
				fnCheckFieldDisplayByXpath(RenowalkModules.Common_ViewModules_LabelTotalPages_xp, "Total No of Pages", true,true);
			}
			else
			{
				obj.repAddData( "Verify Pagination", "Pagination for any page with option 20 should be validated", "Pagination for any page with option 10 cannot be validated as no of records are less than 10", "Pass");
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC35874 Failed!", e );
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
			log.info("Execution of Function TC35874 Completed");
		}
		return obj;
	} //End of function TC35874
	
	
	//RW-240_Groups_TC013_View Groups_Validate Pagination for option 20 for all the pages
	@SuppressWarnings("static-access")
	public Reporter TC35876(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35876 Started..");

		try {
					
			obj.repAddData("Validate Pagination for Option 20", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Groups Link",true);
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
			log.error( "Function TC35876 Failed!", e );
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
			log.info("Execution of Function TC35876 Completed");
		}
		return obj;
	} //End of function TC35876
	
	//RW-240_Groups_TC014_View Groups_Validate Pagination for any page with option 20
	@SuppressWarnings("static-access")
	public Reporter TC35878(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35878 Started..");

		try {
					
			obj.repAddData("Validate pagination for any specific page with option 20", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Groups Link",true);
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
			//fnVerifyNumofRecords("10");
			
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
			log.error( "Function TC35878 Failed!", e );
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
			log.info("Execution of Function TC35878 Completed");
		}
		return obj;
	} //End of function TC35878
	
	
	//RW-240_Groups_TC015_View Groups_Validate for Page Counter and Navigation
	@SuppressWarnings("static-access")
	public Reporter TC35880(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35880 Started..");

		try {
					
			obj.repAddData("Validate Page Counter and Navigation", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Groups Link",true);
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
			log.error( "Function TC35880 Failed!", e );
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
			log.info("Execution of Function TC35880 Completed");
		}
		return obj;
	} //End of function TC35880
	
	
	//RW-240_Groups_TC016_View Groups_Previous Button for navigation
	@SuppressWarnings("static-access")
	public Reporter TC35882(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35882 Started..");

		try {
					
			obj.repAddData("Validate Previous Button for navigation", "", "", "");
						
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Groups Link",true);
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
			log.error( "Function TC35882 Failed!", e );
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
			log.info("Execution of Function TC35882 Completed");
		}
		return obj;
	} //End of function TC35882
	
	
	//RW-240_Groups_TC016_View Groups_Previous Button for navigation
	@SuppressWarnings("static-access")
	public Reporter TC35883(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35883 Started..");

		try {
					
			obj.repAddData("Validate Next Button for navigation", "", "", "");
						
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Groups Link",true);
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
			log.error( "Function TC35883 Failed!", e );
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
			log.info("Execution of Function TC35883 Completed");
		}
		return obj;
	} //End of function TC35883
	
	
	

	
	
	//RW-241_Groups_TC001_ADD GROUP_Verify to see ADD GROUP form
	@SuppressWarnings("static-access")
	public Reporter TC35887(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35887 Started..");

		try {
			obj.repAddData( "Adding the Group", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);
			

			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Group Link",true);
			fnLoadingPageWait();
			
			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Group button",true);
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputGroupName_xp,"Group Name text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputDescription_xp, "Description text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputMaxNumberperHouse_xp, "Maximum Number per House text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputGLCode_xp, "GL Code text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputPhotoFolderName_xp, "Photo Folder Name text box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_CheckBoxIncludeFlooring_xp, "Include Flooring Check box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_CheckBoxIncludeComment_xp, "Include Comment check box", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_CheckBoxDefaultPhotoGroup_xp, "Default Photo check box", true, true);
						
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
			log.error( "Function TC35887 Failed!", e );
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
			log.info("Execution of Function TC35887 Completed");
		}
		return obj;
	} //End of function TC35887
	
	//RW-241_Groups_TC002_ADD GROUP_Verify to see ADD GROUP form Required fields
	@SuppressWarnings("static-access")
	public Reporter TC35889(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35889 Started..");

		try {
			obj.repAddData( "Required Fields label", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Group Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Group button",true);
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputGroupNameFieldRequired_xp,"Group Name Field required", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputDescriptionFieldRequired_xp, "Description Field required", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputMaxNumberPerHouseFieldRequired_xp, "Max Number per House Field required", true, true);
			
					
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
			log.error( "Function TC35889 Failed!", e );
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
			log.info("Execution of Function TC35889 Completed");
		}
		return obj;
	} //End of function TC35889
	
	
	//RW-241_Groups_TC003_ADD GROUP_Verify to see the prompt for required fields
	@SuppressWarnings("static-access")
	public Reporter TC35891(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35891 Started..");

		try {

			obj.repAddData( "Validating the Group Page", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Group Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Group button",true);
			
			//Check for Group Name Validation
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputGroupName_xp, "Group Name text box", true, true);

			String sGroupName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputGroupName_xp)).sendKeys(sGroupName);
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputGroupName_xp)).clear();
			
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_ErrorMsgGroupNameRequired_xp, "Group name Error Message", true, true);

			String sGroupNameMsg = driver.findElement(By.xpath(objRWModules.Groups_AddGroup_ErrorMsgGroupNameRequired_xp)).getText().toString().trim();
			if(sGroupNameMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}			

			//Check for Description field Validation
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputDescription_xp, "Description text box", true, true);

			String sDescription = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputDescription_xp)).sendKeys(sDescription);
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputDescription_xp)).clear();

			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_ErrorMsgDescriptionRequired_xp, "Description Error Message", true, true);

			String sDescriptionMsg = driver.findElement(By.xpath(objRWModules.Groups_AddGroup_ErrorMsgDescriptionRequired_xp)).getText().toString().trim();
			if(sDescriptionMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgRequired_msg+"' not shown", "Fail");
			}			

			//Check for Max Number per House field Validation
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputMaxNumberperHouse_xp, "Maximum Number per House text box", true, true);

			String sMaxNumberPerHouse = mTestPhaseData.get(TestDriver.iTC_ID).get("NumberBedRooms").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputMaxNumberperHouse_xp)).sendKeys(sMaxNumberPerHouse);
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputMaxNumberperHouse_xp)).clear();

			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_ErrorMsgMaxNumberPerHouseRequired_xp, "max Number per House Error Message", true, true);

			String sMaxNumberPerHouseMsg = driver.findElement(By.xpath(objRWModules.Groups_AddGroup_ErrorMsgMaxNumberPerHouseRequired_xp)).getText().toString().trim();
			if(sMaxNumberPerHouseMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgRequired_msg))
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
			log.error( "Function TC35891 Failed!", e );
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

			log.info("Execution of Function TC35891 Completed");
		}
		return obj;
	} //End of function TC35891	
	
	
	//RW-241_Groups_TC004_ADD GROUP_Verify to see Items & Groups Items column
	@SuppressWarnings("static-access")
	public Reporter TC35893(Reporter obj) throws Exception
	{	
		log.info("Execution of Function TC35893 Started..");

		try {
					
			obj.repAddData( "Check Column names", "", "", "");
			
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Group Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Group button",true);

			fnCheckFieldDisplayByXpath(RenowalkModules.Groups_AddGroup_ItemsColumnName_xp,"'Items' label",true,true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Groups_AddGroup_GroupItemsColumnName_xp,"'Group Items' label",true,true);
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);  //post condition
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC35893 Failed!", e );
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
			log.info("Execution of Function TC35893 Completed");
		}
		return obj;
	} //End of function TC35893	
	
	//RW-241_Groups_TC005_ADD GROUP_Items column Search Criteria
	@SuppressWarnings("static-access")
	public Reporter TC35895(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35895 Started..");

		try {

			obj.repAddData( "Verifying Item Column Searching", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Group Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Group button",true);
			
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputItemSearch_xp, "Items search text box", true, true);

			String sItemName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputItemSearch_xp)).sendKeys(sItemName);
			ClickByXpath(objRWModules.Groups_AddGroup_BtnSearchItems_xp, "Search button",true); 
			

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
			log.error( "Function TC35895 Failed!", e );
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

			log.info("Execution of Function TC35895 Completed");
		}
		return obj;
	} //End of function TC35895	
	
	//RW-241_Groups_TC008_ADD GROUP_Verify option
	@SuppressWarnings("static-access")
	public Reporter TC35900(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35900 Started..");

		try {

			obj.repAddData( "Verifying Include Paint Option check box", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Group Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Group button",true);
			ClickByXpath(objRWModules.Groups_AddGroup_CheckBoxIncludeFlooring_xp, "Include Flooring Check box",false);
			
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_CheckBoxIncludePaint_xp,"'Include Paint' check box",true,true);				

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
			log.error( "Function TC35900 Failed!", e );
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

			log.info("Execution of Function TC35900 Completed");
		}
		return obj;
	} //End of function TC35900	
	
	
	//RW-241_Groups_TC010_ADD GROUP_Clicking SAVE with required field
	@SuppressWarnings("static-access")
	public Reporter TC35904(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35904 Started..");

		try {

			obj.repAddData( "Saving Group", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Group Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Group button",true);
			
			//Fill Group Name Validation
			int iRandomNum = fnRandomNum(1,10000);
			String sGroupName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			SendKeyByXpath(objRWModules.Groups_AddGroup_InputGroupName_xp, sGroupName+iRandomNum, "Group Name");
			
			//Fill description
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputDescription_xp, "Description text box", true, true);

			String sDescription = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputDescription_xp)).sendKeys(sDescription);

			//Fill Max Number per House field
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputMaxNumberperHouse_xp, "Maximum Number per House text box", true, true);

			String sMaxNumberPerHouse = mTestPhaseData.get(TestDriver.iTC_ID).get("NumberBedRooms").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputMaxNumberperHouse_xp)).sendKeys(sMaxNumberPerHouse);
			
			//Fill GL Code field
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputGLCode_xp, "GL Code text box", true, true);

			String sGLCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputGLCode_xp)).sendKeys(sGLCode);
			
			//Fill Photo Folder Name
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputPhotoFolderName_xp, "Photo Folder Name text box", true, true);

			String sPhotoFolderName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputPhotoFolderName_xp)).sendKeys(sPhotoFolderName);
			
			ClickByXpath(objRWModules.Groups_AddGroup_CheckBoxIncludeFlooring_xp, "Include flooring checkBox", true);
			ClickByXpath(objRWModules.Groups_AddGroup_CheckBoxDefaultPhotoGroup_xp, "Check default photo group", true);
			
			
			//*This field is required
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",false);  //post condition
			fnVerifyDialogBox("Add",0);
			

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
			log.error( "Function TC35904 Failed!", e );
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

			log.info("Execution of Function TC35904 Completed");
		}
		return obj;
	} //End of function TC35904
	
	
	//RW-241_Groups_TC010_ADD GROUP_Clicking SAVE with non required fields
	@SuppressWarnings("static-access")
	public Reporter TC35905(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35905 Started..");

		try {

			obj.repAddData( "Saving Group with only non required fields", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Group Link",true);
			fnLoadingPageWait();
			//fnVerifyCancelForm(1);

			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Group button",true);
			
			
			//Fill GL Code field
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputGLCode_xp, "GL Code text box", true, true);

			String sGLCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputGLCode_xp)).sendKeys(sGLCode);
			
			//Fill Photo Folder Name
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputPhotoFolderName_xp, "Photo Folder Name text box", true, true);

			String sPhotoFolderName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputPhotoFolderName_xp)).sendKeys(sPhotoFolderName);
			
			ClickByXpath(objRWModules.Groups_AddGroup_CheckBoxIncludeFlooring_xp, "Include flooring checkBox", true);
			ClickByXpath(objRWModules.Groups_AddGroup_CheckBoxDefaultPhotoGroup_xp, "Check default photo group", true);
			
			
			//*This field is required
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",false);  
			fnCheckFieldDisplayByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save Button", true, true);
			
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
			log.error( "Function TC35905 Failed!", e );
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

			log.info("Execution of Function TC35905 Completed");
		}
		return obj;
	} //End of function TC35905
	
	//RW-241_Groups_TC012_ADD GROUP_Clicking CANCEL with value
	@SuppressWarnings("static-access")
	public Reporter TC35906(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35906 Started..");

		try {

			obj.repAddData( "Cancel Adding Group", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Group Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Group button",true);
			
			//Fill Group Name Validation
			int iRandomNum = fnRandomNum(1,10000);
			String sGroupName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			SendKeyByXpath(objRWModules.Groups_AddGroup_InputGroupName_xp, sGroupName+iRandomNum, "Group Name");
			
			//Fill description
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputDescription_xp, "Description text box", true, true);

			String sDescription = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputDescription_xp)).sendKeys(sDescription);

			//Fill Max Number per House field
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputMaxNumberperHouse_xp, "Maximum Number per House text box", true, true);

			String sMaxNumberPerHouse = mTestPhaseData.get(TestDriver.iTC_ID).get("NumberBedRooms").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputMaxNumberperHouse_xp)).sendKeys(sMaxNumberPerHouse);
			
			//Fill GL Code field
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputGLCode_xp, "GL Code text box", true, true);

			String sGLCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputGLCode_xp)).sendKeys(sGLCode);
			
			//Fill Photo Folder Name
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputPhotoFolderName_xp, "Photo Folder Name text box", true, true);

			String sPhotoFolderName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputPhotoFolderName_xp)).sendKeys(sPhotoFolderName);
			
			ClickByXpath(objRWModules.Groups_AddGroup_CheckBoxIncludeFlooring_xp, "Include flooring checkBox", true);
			ClickByXpath(objRWModules.Groups_AddGroup_CheckBoxDefaultPhotoGroup_xp, "Check default photo group", true);
			
			
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
			log.error( "Function TC35906 Failed!", e );
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

			log.info("Execution of Function TC35906 Completed");
		}
		return obj;
	} //End of function TC35906
	
	
	//RW-241_Groups_TC013_ADD GROUP_Clicking CANCEL without any value
	@SuppressWarnings("static-access")
	public Reporter TC35915(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35915 Started..");

		try {
			obj.repAddData( "Cancelling Add Group", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);
			

			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Group Link",true);
			fnLoadingPageWait();
			
			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Group button",true);								
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
			log.error( "Function TC35915 Failed!", e );
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
			log.info("Execution of Function TC35915 Completed");
		}
		return obj;
	} //End of function TC35915
	
	//RW-241_Groups_TC014_ADD GROUP_Verify values into Max Numbers Per House field 
	@SuppressWarnings("static-access")
	public Reporter TC35907(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35907 Started..");

		try {

			obj.repAddData( "Verifying Max Number per House Field", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Group Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Group button",true);
			

			//Fill Max Number per House field with Number
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputMaxNumberperHouse_xp, "Maximum Number per House text box", true, true);

			String sMaxNumberPerHouseNumeric = mTestPhaseData.get(TestDriver.iTC_ID).get("NumberBedRooms").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputMaxNumberperHouse_xp)).sendKeys(sMaxNumberPerHouseNumeric);
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputMaxNumberperHouse_xp)).clear();
			
			//Fill Max Number per House field with Non Numeric
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputMaxNumberperHouse_xp, "Maximum Number per House text box", true, true);

			String sMaxNumberPerHouseNonNumeric = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputMaxNumberperHouse_xp)).sendKeys(sMaxNumberPerHouseNonNumeric);
			

			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_ErrorMsgNumericValueRequired_xp, "max Number per House Error Message", true, true);

			String sMaxNumberPerHouseMsg = driver.findElement(By.xpath(objRWModules.Groups_AddGroup_ErrorMsgNumericValueRequired_xp)).getText().toString().trim();
			if(sMaxNumberPerHouseMsg.equalsIgnoreCase(objAppMessages.Property_AddProperty_ErrorMsgNumberBedrooms_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Property_AddProperty_ErrorMsgNumberBedrooms_msg+"' should be shown", "'"+objAppMessages.Property_AddProperty_ErrorMsgNumberBedrooms_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Property_AddProperty_ErrorMsgNumberBedrooms_msg+"' should be shown","'"+ objAppMessages.Property_AddProperty_ErrorMsgNumberBedrooms_msg+"' not shown", "Fail");
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
			log.error( "Function TC35907 Failed!", e );
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

			log.info("Execution of Function TC35907 Completed");
		}
		return obj;
	} //End of function TC35907
	
	
	//Verify that the user may not add a group of the same name  
	@SuppressWarnings("static-access")
	public Reporter TC35908(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35908 Started..");

		try {

			obj.repAddData( "Verify Duplicate Group name", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Group Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Group button",true);
			
			//Fill Group Name Validation
			int iRandomNum = fnRandomNum(1,10000);
			String sGroupName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			SendKeyByXpath(objRWModules.Groups_AddGroup_InputGroupName_xp, sGroupName+iRandomNum, "Group Name");
			
			//Fill description
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputDescription_xp, "Description text box", true, true);

			String sDescription = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputDescription_xp)).sendKeys(sDescription);

			//Fill Max Number per House field
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputMaxNumberperHouse_xp, "Maximum Number per House text box", true, true);

			String sMaxNumberPerHouse = mTestPhaseData.get(TestDriver.iTC_ID).get("NumberBedRooms").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputMaxNumberperHouse_xp)).sendKeys(sMaxNumberPerHouse);
			
			//Fill GL Code field
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputGLCode_xp, "GL Code text box", true, true);

			String sGLCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputGLCode_xp)).sendKeys(sGLCode);
			
			//Fill Photo Folder Name
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputPhotoFolderName_xp, "Photo Folder Name text box", true, true);

			String sPhotoFolderName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputPhotoFolderName_xp)).sendKeys(sPhotoFolderName);
			
			ClickByXpath(objRWModules.Groups_AddGroup_CheckBoxIncludeFlooring_xp, "Include flooring checkBox", true);
			ClickByXpath(objRWModules.Groups_AddGroup_CheckBoxDefaultPhotoGroup_xp, "Check default photo group", true);
			
			
			//*This field is required
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",false);  //post condition
			fnVerifyDialogBox("Add",0);
			
			//Adding the same Group name
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Group Link",true);
			fnLoadingPageWait();
			//fnVerifyCancelForm(1);
			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Group button",true);
			
			//Filling same Group Name
			SendKeyByXpath(objRWModules.Groups_AddGroup_InputGroupName_xp, sGroupName+iRandomNum, "Group Name");
			
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_ErrorMsgDuplicate_xp, "Duplicate Group Name Error Message", true, true);

			String sGroupNameDuplicateMsg = driver.findElement(By.xpath(objRWModules.Groups_AddGroup_ErrorMsgDuplicate_xp)).getText().toString().trim();
			if(sGroupNameDuplicateMsg.equalsIgnoreCase(objAppMessages.Groups_AddGroup_ErrorMsgDuplicateGroupName_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Groups_AddGroup_ErrorMsgDuplicateGroupName_msg+"' should be shown", "'"+objAppMessages.Groups_AddGroup_ErrorMsgDuplicateGroupName_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Groups_AddGroup_ErrorMsgDuplicateGroupName_msg+"' should be shown","'"+ objAppMessages.Groups_AddGroup_ErrorMsgDuplicateGroupName_msg+"' not shown", "Fail");
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
			log.error( "Function TC35908 Failed!", e );
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

			log.info("Execution of Function TC35908 Completed");
		}
		return obj;
	} //End of function TC35908
	
	//Verify if the user entered ADD GROUP form with character length more than 80, it should throw an error  
	@SuppressWarnings("static-access")
	public Reporter TC35909(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35909 Started..");

		try {

			obj.repAddData( "Verify Group form with character length more than 80", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Group Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Group button",true);
			
			//Fill Group Name Validation with more than 80 characters
			int iRandomNum = fnRandomNum(1,10000);
			String sGroupName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			SendKeyByXpath(objRWModules.Groups_AddGroup_InputGroupName_xp, sGroupName+iRandomNum, "Group Name");
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_ErrorMsgMaximumLengthGroupName_xp, "Group Name maximum Length Error Message", true, true);

			String sGroupNameMaxLengthMsg = driver.findElement(By.xpath(objRWModules.Groups_AddGroup_ErrorMsgMaximumLengthGroupName_xp)).getText().toString().trim();
			if(sGroupNameMaxLengthMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg+"' not shown", "Fail");
			}
			
			
			//Fill description with more than 80 characters
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputDescription_xp, "Description text box", true, true);

			String sDescription = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputDescription_xp)).sendKeys(sDescription);
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_ErrorMsgMaximumLengthDescription_xp, "Description maximum Length Error Message", true, true);
			
			String sDescriptionMaxLengthMsg = driver.findElement(By.xpath(objRWModules.Groups_AddGroup_ErrorMsgMaximumLengthDescription_xp)).getText().toString().trim();
			if(sDescriptionMaxLengthMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg+"' not shown", "Fail");
			}
			
			
			//Fill Max Number per House field with more than 80 characters
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputMaxNumberperHouse_xp, "Maximum Number per House text box", true, true);

			String sMaxNumberPerHouse = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputMaxNumberperHouse_xp)).sendKeys(sMaxNumberPerHouse);
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_ErrorMsgMaximumLengthMaxNumberPerHouse_xp, "Maximum number per House Maxiumum Length Error Message", true, true);
			
			String sMaxNumberPerHouseMaxLengthMsg = driver.findElement(By.xpath(objRWModules.Groups_AddGroup_ErrorMsgMaximumLengthMaxNumberPerHouse_xp)).getText().toString().trim();
			if(sMaxNumberPerHouseMaxLengthMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg+"' not shown", "Fail");
			}
			
			
			//Fill GL Code field with more than 80 characters
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputGLCode_xp, "GL Code text box", true, true);

			String sGLCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputGLCode_xp)).sendKeys(sGLCode);
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_ErrorMsgMaximumLengthGLCode_xp, "GLCode Maxiumum Length Error Message", true, true);
			
			String sGLCodeMaxLengthMsg = driver.findElement(By.xpath(objRWModules.Groups_AddGroup_ErrorMsgMaximumLengthGLCode_xp)).getText().toString().trim();
			if(sGLCodeMaxLengthMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg+"' not shown", "Fail");
			}
			
			//Fill Photo Folder Name with more than 80 characters
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputPhotoFolderName_xp, "Photo Folder Name text box", true, true);

			String sPhotoFolderName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputPhotoFolderName_xp)).sendKeys(sPhotoFolderName);
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_ErrorMsgMaximumLength_PhotoFolderName_xp, "Photo Folder Name maxiumum Length Error Message", true, true);
			
			String sPhotoFolderNameMaxLengthMsg = driver.findElement(By.xpath(objRWModules.Groups_AddGroup_ErrorMsgMaximumLength_PhotoFolderName_xp)).getText().toString().trim();
			if(sPhotoFolderNameMaxLengthMsg.equalsIgnoreCase(objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg))
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg+"' should be shown", "'"+objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg+"' shown successfully", "Pass");
			}
			else
			{
				obj.repAddData( "Verify Required Error Message", "'"+objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg+"' should be shown","'"+ objAppMessages.Common_AddModule_ErrorMsgMaxLength_msg+"' not shown", "Fail");
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
			log.error( "Function TC35909 Failed!", e );
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

			log.info("Execution of Function TC35909 Completed");
		}
		return obj;
	} //End of function TC35909
	
	//RW-241_Groups_TC016_ADD GROUP_Validate ADD GROUP form with characters length 80 and special characters except Max Number Per House field
	@SuppressWarnings("static-access")
	public Reporter TC35910(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35910 Started..");

		try {

			obj.repAddData( "Saving Group with special characters", "", "", "");

			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Group Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Group button",true);
			
			//Fill Group Name Validation
			int iRandomNum = fnRandomNum(1,10000);
			String sGroupName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			SendKeyByXpath(objRWModules.Groups_AddGroup_InputGroupName_xp, sGroupName+iRandomNum, "Group Name");
			
			//Fill description
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputDescription_xp, "Description text box", true, true);

			String sDescription = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputDescription_xp)).sendKeys(sDescription);

			//Fill Max Number per House field
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputMaxNumberperHouse_xp, "Maximum Number per House text box", true, true);

			String sMaxNumberPerHouse = mTestPhaseData.get(TestDriver.iTC_ID).get("NumberBedRooms").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputMaxNumberperHouse_xp)).sendKeys(sMaxNumberPerHouse);
			
			//Fill GL Code field
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputGLCode_xp, "GL Code text box", true, true);

			String sGLCode = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputGLCode_xp)).sendKeys(sGLCode);
			
			//Fill Photo Folder Name
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_InputPhotoFolderName_xp, "Photo Folder Name text box", true, true);

			String sPhotoFolderName = mTestPhaseData.get(TestDriver.iTC_ID).get("Name").toString().trim();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_InputPhotoFolderName_xp)).sendKeys(sPhotoFolderName);
			
			ClickByXpath(objRWModules.Groups_AddGroup_CheckBoxIncludeFlooring_xp, "Include flooring checkBox", true);
			ClickByXpath(objRWModules.Groups_AddGroup_CheckBoxDefaultPhotoGroup_xp, "Check default photo group", true);
			
			
			//*This field is required
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",false);  //post condition
			fnVerifyDialogBox("Add",0);
			

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
			log.error( "Function TC35910 Failed!", e );
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

			log.info("Execution of Function TC35910 Completed");
		}
		return obj;
	} //End of function TC35910
	
	//RW-241_Groups_TC018_ADD GROUP_Verify Current Groups available
	@SuppressWarnings("static-access")
	public Reporter TC35912(Reporter obj) throws Exception
	{
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35912 Started..");

		try {

			obj.repAddData( "Viewing the Groups page", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Group Link",true);
			fnLoadingPageWait();

			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Group button",true);
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_AddForm_xp, "Add Group Form", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Common_ViewModules_Table_xp, "Groups Table", true, true);
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);  //post condition
			

		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC35912 Failed!", e );
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
			log.info("Execution of Function TC35912 Completed");
		}
		return obj;
	} //End of function TC35912
	
	//RW-241_Groups_TC006_ADD GROUP_Group column setting up
	@SuppressWarnings("static-access")
	public Reporter TC35896(Reporter obj) throws Exception {
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35896 Started..");

		tryblock: try {

			obj.repAddData( "Viewing the Groups page", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Group Link",true);
			fnLoadingPageWait();
			

			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Group button",true);
			
			if(fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_SortableItemList_xp, "Sortable List Area", true, true))
			{ }
			else { break tryblock; }
			
			ClickElementDragTo(objRWModules.Groups_AddGroup_FirstItemVisible_xp, objRWModules.Groups_AddGroup_SortableItemList_xp, "xpath", "xpath");					
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC35896 Failed!", e );
		}
		return obj;
	}
	//End of Function TC35896
	
	//RW-241_Groups_TC007_ADD GROUP_Group Items column Instructions
	@SuppressWarnings("static-access")
	public Reporter TC35898(Reporter obj) throws Exception {
		log.info("Execution of Function TC35898 started...");
		
		try {
			obj.repAddData( "Viewing the Groups page", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Group Link",true);
			fnLoadingPageWait();
			

			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Group button",true);
			
			fnCheckFieldDisplayByXpath(RenowalkModules.Groups_AddGroup_ItemList_DragAndDropInstructions_xp,"Drag and Drop instructions",true,true);
			
			//Simple test
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC35896 Failed!", e );
		}
		
		return obj;
	}
	//End of Function TC35898
	
	@SuppressWarnings("static-access")
	public Reporter TC35902(Reporter obj) throws Exception {
		try {
			obj.repAddData( "Viewing the Groups page", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Group Link",true);
			fnLoadingPageWait();
			

			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Group button",true);
			
			if (fnCheckFieldDisplayByXpath(RenowalkModules.Groups_AddGroup_FirstItemVisible_xp,"First item exists",false,true) && fnCheckFieldDisplayByXpath(RenowalkModules.Groups_AddGroup_SecondItemVisible_xp,"First item exists",false,true)) {
				obj.repAddData("Items list requirement check","There should be at least two Items currently in the database and visible to proceed", "Found two elements!","Pass");
				String s1 = driver.findElement(By.xpath(RenowalkModules.Groups_AddGroup_FirstItemVisible_xp)).getText();
				String s2 = driver.findElement(By.xpath(RenowalkModules.Groups_AddGroup_SecondItemVisible_xp)).getText();
				int orderCheck = s1.compareToIgnoreCase(s2);
				if (orderCheck < 0){
					obj.repAddData("Verifying that " + s1 + " is alphabetically before " + s2 + ".", "" + s1 + " should be alphabetically before " + s2 + ".", "" + s1 + " is alphabetically before " + s2 + ".", "Pass");
				}
				else if (orderCheck == 0){
					obj.repAddData("Verifying that " + s1 + " is alphabetically before " + s2 + ".", "" + s1 + " should be alphabetically before " + s2 + ".", "" + s1 + " is identical to " + s2 + ". Please try again with uniquely named Items.", "Fail");
				}
				else { 
					obj.repAddData("Verifying that " + s1 + " is alphabetically before " + s2 + ".", "" + s1 + " should be alphabetically before " + s2 + ".", "" + s1 + " is alphabetically after " + s2 + ".","Fail");
					testCaseStatus = false;
				}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC35896 Failed!", e );
		}
		
		
		return obj;
	}
	
	//RW-241_Groups_TC018_ADD GROUP_Verify added Group available in ADD FLOW
	@SuppressWarnings("static-access")
	public Reporter TC35911(Reporter obj) throws Exception {
		//Boolean bLoginFlag = true;	
		log.info("Execution of Function TC35911 Started..");

		tryblock: try {

			obj.repAddData( "Viewing the Add Flow page", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Flow_AddFlow_LinkFlowOption_xp, "Flows Link",true);
			fnLoadingPageWait();
			

			ClickByXpath(objRWModules.Flow_AddFlow_BtnAddFlow_xp, "Add Flow button",true);
			
			if(fnCheckFieldDisplayByXpath(objRWModules.Flow_AddFlow_SortableItemList_xp, "Sortable List Area", true, true))
			{ }
			else { break tryblock; }
			
			ClickElementDragTo(objRWModules.Flow_AddFlow_FirstItemVisible_xp, objRWModules.Flow_AddFlow_SortableItemList_xp, "xpath", "xpath");	
			obj.repAddData("Dragging an Item to the sortable menu area.", "Item should move successfully.", "Item moved successfully.", "Pass");
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC35911 Failed!", e );
		}
		return obj;
	}
	//End of Function TC35911
	
	
	//37262 IS IDENTICAL TO 35902
	
	public Reporter TC37267(Reporter obj) throws Exception{
		try {
			obj.repAddData( "Viewing the Add Group page", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Group Link",true);
			fnLoadingPageWait();
			

			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Group button",true);
			
			
			
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_ItemsSearchBox_xp, "Group Search Query Input", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_ItemsSearchBtn_xp, "Group Search button", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_ItemsClearBtn_xp, "Group Clear Search button", true, true);
			
			obj.repAddData("Found all objects. Closing Page.", "", "", "");
			
			//Cancel Post Condition
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37267 Failed!", e );
		}
		return obj;
	}
	
	public Reporter TC37272(Reporter obj) throws Exception{
		try {
			obj.repAddData( "Viewing the Add Group page", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Common_AllModules_ComboOfficeSelect_xp, "Office Select",false);
			ClickByXpath("//li[@id='officeOption5']","Fifth office option (Should have 0 items and 0 groups)",true);
			fnLoadingPageWait();
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Flows Link",true);
			fnLoadingPageWait();
			

			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Flow button",true);
			
			if (!ElementFound(RenowalkModules.Groups_AddGroup_FirstItemVisible_xp))
			{
				obj.repAddData("Expected no items, found no items.","","","");
			}
			else{
				obj.repAddData("Expected no items, found items.","","","Set-up Error");
				
			}
			
			obj.repAddData("Found all objects. Closing Page.", "", "", "");
			
			ClickByXpath(objRWModules.Common_AllModules_ComboOfficeSelect_xp, "Office Select",false);
			ClickByXpath("//li[@id='officeOption1']","First office option",true);
			
			//Cancel Post Condition
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
		}
		catch (Exception e){
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37272 Failed!", e );
		}
		return obj;
	}
	
	public Reporter TC37274(Reporter obj) throws Exception{
		try {
			obj.repAddData( "Viewing the Add Group page", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Group Link",true);
			fnLoadingPageWait();
			

			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Group button",true);
			
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_ItemsSearchBox_xp, "Item Search Query Input", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_ItemsSearchBtn_xp, "Item Search button", true, true);
			
			String tempString = driver.findElement(By.xpath(objRWModules.Groups_AddGroup_SecondItemVisible_xp)).getText();
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_ItemsSearchBox_xp)).sendKeys(tempString.substring(0,2));
			ClickByXpath(objRWModules.Groups_AddGroup_ItemsSearchBtn_xp,"Search button",true);
			
			if ((driver.findElement(By.xpath((objRWModules.Groups_AddGroup_FirstItemVisible_xp))).getText()).equals(tempString))
			{
				obj.repAddData("Checking to see if Search retrieved the requested item","Search should find the element it searched for","Search found the correct element","Pass");
			}
			else {
				obj.repAddData("Checking to see if Search retrieved the requested item","Search should find the element it searched for","Search did not succeed. Make sure that the second element was unique at to the 3rd letter","Fail");
			}
			
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
			log.error( "Function TC37274 Failed!", e );
		}
		return obj;
	}
	
	@SuppressWarnings("static-access")
	public Reporter TC37276(Reporter obj) throws Exception{
		try {
			obj.repAddData( "Viewing the Add Group page", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Common_AllModules_ComboOfficeSelect_xp, "Office Select",false);
			ClickByXpath("//li[@id='officeOption5']","Fifth office option (Should have 0 items and 0 groups)",true);
			fnLoadingPageWait();
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Group Link",true);
			fnLoadingPageWait();
			

			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Group button",true);
			
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_ItemsSearchBox_xp, "Group Search Query Input", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_ItemsSearchBtn_xp, "Group Search button", true, true);
			
			//need to adjust this
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_ItemsSearchBox_xp)).sendKeys("notANamexx1122ww");
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_NoItemsMessage_xp,"No Items message",true,true);
			
			
			
			obj.repAddData("Found all objects. Closing Page.", "", "", "");
			
			ClickByXpath(objRWModules.Common_AllModules_ComboOfficeSelect_xp, "Office Select",false);
			ClickByXpath("//li[@id='officeOption1']","Fifth office option",true);
			fnLoadingPageWait();
			
			//Cancel Post Condition
			ClickByXpath(objRWModules.Common_AddModule_BtnCancel_xp, "Cancel button",false);
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37276 Failed!", e );
		}
		return obj;
	}
	
	@SuppressWarnings("static-access")
	public Reporter TC37277(Reporter obj) throws Exception{
		try {
			obj.repAddData( "Viewing the Add Group page", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Group Link",true);
			fnLoadingPageWait();
			

			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Group button",true);
			
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_ItemsSearchBox_xp, "Group Search Query Input", true, true);
			fnCheckFieldDisplayByXpath(objRWModules.Groups_AddGroup_ItemsSearchBtn_xp, "Group Search button", true, true);
			
			//need to adjust this
			driver.findElement(By.xpath(objRWModules.Groups_AddGroup_ItemsSearchBox_xp)).sendKeys("testString");
			ClickByXpath(objRWModules.Groups_AddGroup_ItemsClearBtn_xp,"Clear Button",true);
			String s = driver.findElement(By.xpath(objRWModules.Groups_AddGroup_ItemsSearchBox_xp)).getText();
			if (!s.equals("")) {
				obj.repAddData("Check for clear search input", "Expected search input to be cleared", "Search input was not clear!", "Fail");
			}
			
			
			obj.repAddData("Located all elements","","","");
		}
		catch (Exception e) {
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC37277 Failed!", e );
		}
		return obj;
	}

	
	//38647 SEE TC35902
	
	public Reporter TC38649(Reporter obj) throws Exception
	{
		try {
			obj.repAddData( "Viewing the Add Group page", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Group Link",true);
			fnLoadingPageWait();
			

			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Group button",true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Groups_AddGroup_ItemList_DragAndDropInstructions_xp,"Drag and drop instructions",true,true);
			
		}
		catch (Exception e){
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC38649 Failed!", e );
		}
		return obj;
	}
	
	public Reporter TC38650(Reporter obj) throws Exception {
		try {
			obj.repAddData( "Viewing the Add Group page", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Common_AllModules_ComboOfficeSelect_xp, "Office Select",false);
			ClickByXpath("//li[@id='officeOption5']","Fifth office option (Should have 0 items and 0 groups)",true);
			fnLoadingPageWait();
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Group Link",true);
			fnLoadingPageWait();
			

			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Group button",true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Groups_AddGroup_NoItemsMessage_xp,"No Items message",true,true);
			
			ClickByXpath(objRWModules.Common_AllModules_ComboOfficeSelect_xp, "Office Select",false);
			ClickByXpath("//li[@id='officeOption1']","Fifth office option (Should have 0 items and 0 groups)",true);
			fnLoadingPageWait();
		}
		catch (Exception e){
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC38650 Failed!", e );
		}
		return obj;
	}
	
	public Reporter TC38651(Reporter obj) throws Exception {
		try {
			obj.repAddData( "Viewing the Add Group page", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Group Link",true);
			fnLoadingPageWait();
			

			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Group button",true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Groups_AddGroup_FirstItemVisible_xp,"Items list shown",true,true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Groups_AddGroup_SortableItemList_xp,"Draggable list shown",true,true);
			ClickElementDragTo(RenowalkModules.Groups_AddGroup_FirstItemVisible_xp,RenowalkModules.Groups_AddGroup_SortableItemList_xp,"xpath","xpath");
			
			
			
		} catch (Exception e){
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC38651 Failed!", e );
		}
		return obj;
	}
	
	public Reporter TC38654(Reporter obj) throws Exception {
		try {
			obj.repAddData( "Viewing the Add Group page", "", "", "");
			fnSelectCorpOffice(sCorporation, sOffice);
			ClickByXpath(objRWModules.Groups_GenGroups_LinkGroupOption_xp, "Group Link",true);
			fnLoadingPageWait();
			
			String groupName = "GTGT"+ String.valueOf(fnRandomNum(2,1000)) + "";
			ClickByXpath(objRWModules.Groups_ViewGroups_BtnAddGroup_xp, "Add Group button",true);
			
			driver.findElement(By.xpath(RenowalkModules.Groups_AddGroup_InputGroupName_xp)).sendKeys(groupName);
			driver.findElement(By.xpath(RenowalkModules.Groups_AddGroup_InputDescription_xp)).sendKeys(groupName);
			driver.findElement(By.xpath(RenowalkModules.Groups_AddGroup_InputMaxNumberperHouse_xp)).sendKeys("1");

			
			fnCheckFieldDisplayByXpath(RenowalkModules.Groups_AddGroup_FirstItemVisible_xp,"Items list shown",true,true);
			fnCheckFieldDisplayByXpath(RenowalkModules.Groups_AddGroup_SortableItemList_xp,"Draggable list shown",true,true);
			ClickElementDragTo(RenowalkModules.Groups_AddGroup_FirstItemVisible_xp,RenowalkModules.Groups_AddGroup_SortableItemList_xp,"xpath","xpath");
			
			ClickByXpath(objRWModules.Common_AddModule_BtnSave_xp, "Save button",false);
			
			
			fnLoadingPageWait();
			
			fnCheckFieldDisplayByXpath(RenowalkModules.Flow_AddGroup_GroupNameFindInList_xp.replaceAll("TOKEN", groupName),"Saved test name in list",true,true);
			
			
		} catch (Exception e){
			e.printStackTrace();
			testCaseStatus = false;
			//bLoginFlag=false;
			obj.repAddData( "Error Handler ", "There should not be any error/exception in the test", "Exception found in current test.", "Fail");
			log.error( "Function TC38654 Failed!", e );
		}
		return obj;
	}
	
	
}