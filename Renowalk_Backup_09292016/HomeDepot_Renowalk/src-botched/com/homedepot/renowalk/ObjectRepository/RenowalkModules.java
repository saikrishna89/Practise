package com.homedepot.renowalk.ObjectRepository;

public class RenowalkModules {

	/**
	 * @param args
	 */
	
	public static final String Common_BtnSorting_xp = "./img[@src='images/sort-arrows.png']";
	public static final String Common_ViewModules_Table_xp = "//table[@class='table table-striped table-hover']";
	
	public static final String Common_ViewModules_ComboPageSize_xp = "//select[@name='pageSize']";
	//public static final String Common_ViewModules_BtnPreviousLink_xp = "//button[@class='btn btn-xs btn-orange pageSelect' and @ng-click='previousPage()']";
	public static final String Common_ViewModules_BtnPreviousLink_xp = "//button[contains(@class,'btn-orange') and @ng-click='previousPage()']";
	//public static final String Common_ViewModules_BtnNextLink_xp = "//button[@class='btn btn-xs btn-orange pageSelect' and @ng-click='nextPage()']";
	public static final String Common_ViewModules_BtnNextLink_xp = "//button[contains(@class,'btn-orange') and @ng-click='nextPage()']";
	public static final String Common_ViewModules_InputPageNum_xp = "//input[@name='currentPage' and @type='number' and @ng-model='currentPage']";
	public static final String Common_ViewModules_LabelPageNum_xp = "//label[@for='currentPage' and @class='sr-only']";
	public static final String Common_ViewModules_LabelTotalPages_xp = "//span[@class='totalPages ng-binding']";
	
	public static final String Common_AddModule_BtnSave_xp = "//button[@type='submit' and text()=' SAVE']";
	public static final String Common_AddModule_BtnCancel_xp = "//button[@type='button' and text()=' CANCEL']";
	//public static final String Common_AllModules_ComboCorporateName_xp = "//select[@name='corporationSelect']";
	//public static final String Common_AllModules_ComboOfficeCode_xp = "//select[@name='officeSelect']";
	
	public static final String Common_AllModules_ComboCorporateName_xp = "//ul[@class='dropdown-menu contextSelect corporationSelect ng-isolate-scope' and @aria-labelledby='dropdownMenu1']";
	public static final String Common_AllModules_ComboOfficeCode_xp = "//ul[@class='dropdown-menu contextSelect officeSelect ng-isolate-scope' and @aria-labelledby='dropdownMenu1']";
	public static final String Common_AllModules_ComboOfficeSelect_xp = "//div[@id='officeSelect']";
	public static final String Common_AllModules_ComboCorporateSelect_xp = "//*[@id='corporationSelect']";
	public static final String Common_AllModules_ComboOfficeText_xp = "//*[@id='officeName']";
	public static final String Common_AllModules_ComboCorporateText_xp = "//*[@id='corporationSelect']/div";
	
	//public static final String Common_AddModule_TextDialogBox = "//div[@class='confirmSaveContent']/p[@class='saveText']";
	//public static final String Common_AddModule_BtnDialogBox = "//div[@class='confirmSaveContent']/button[@class='btn btn-default closeButtonOk']";
	 
	 public static final String Common_AddModule_TextDialogBox = "//div[@class='appDialogContent']/p[@class='popupText']";
	 public static final String Common_AddModule_BtnDialogBox = "//div[@class='popupButtonContainer']/button[@class='btn btn-default alertButton']";
	 
	 
	 
	 public static final String Common_CancelModule_TextDialogBox = "//div[@class='popupButtonContainer']/button[@class='btn btn-default alertButton']";
	 public static final String Common_CancelModule_BtnYes = "//div[@class='popupButtonContainer']/button[@class='btn btn-default alertButtonRight']";
	 public static final String Common_CancelModule_BtnNo = "//div[@class='popupButtonContainer']/button[@class='btn btn-default alertButtonLeft']";
	 
	 
	///////////////////////////////////////Users Objects////////////////////////////////////////////
	
	//By Id
	public static final String Users_BtnDummy_id = "Dummy_Id";
	
	//By Name
	public static final String Users_InputDummy_nm = "Dummy_Name";
	//By XPath
	
	public static final String Users_LinkUsersOption_xp = "//*[@id='menu_bar']/li/a[text()='Users']";
	
	//By Tag Name
	public static final String Users_LabelDummy_tn = "Dummy_TagName";
	
	///////////////////////////////////////Users Object End/////////////////////////////////////////
	
	
	
	///////////////////////////////////////Property Objects////////////////////////////////////////
	public static final String Property_AddProperty_BtnCancel_xp = "//button[@type='button' and text()='CANCEL']";
	
	
	public static final String Property_GenProp_LinkPropertyOption_xp = "//a[text()= ' Property ']";
	
	//By Id
	public static final String Property_GenProp_ImagePageLoading_id =  "loading-image";  // page loading Icon
	public static final String Property_GenProp_MsgPageLoading_id = "loading-message";  //Page loading message
	public static final String Property_ViewProp_BtnAddProperty_id = "btn_addApplication";  //Add Property
	
	public static final String Property_AddProp_BtnAddProperty_id = "add_property";   //Add Property button
	public static final String Property_UpdateProp_BtnUpdateProperty_id = "update_property";   //Update Property button
	public static final String Property_GenProp_BtnCancelProperty_id = "cancel_property";   //Cancel Property button

	public static final String Property_ViewProp_ComboStatus_id = "propertyStatusSearch";  //Property Status Search
	public static final String Property_ViewProp_InputSearchValue_id = "SearchValue";
	
	//By Name
	public static final String Property_InputDummy_nm = "Dummy_Name";
	//By XPath
	
	//public static final String Property_GenProp_LinkPropertyOption_xp = "//*[@id='menu_bar']/li/a[text()='Property']";
	public static final String Property_ViewProp_LabelProperties_xp = "/html/body/div[2]/div[3]/div[2]/div[4]/div[3]/h3";
	//public static final String  Property_ViewProp_TableListItem_xp = "//*[@id='list_item']/tbody";
	public static final String  Property_ViewProp_TableListItem_xp = "//*[@class='table table-striped table-hover']";
	
	
	public static final String Property_GenProperty_LinkPropertyOption_xp = "//a[text()= ' Property ']"; 
	 public static final String Property_ViewOffice_BtnAddProperty_xp = "//button[@class='btn btn-orange ng-scope' and text()=' ADD PROPERTY']";
	 public static final String Property_AddProperty_PropertyWalkTab_xp = "//*[@id='propertyWalkTab']/a";
	 public static final String Property_AddProperty_PropertyBudgetTab_xp = "//*[@id='budgetTab']/a";
	 public static final String Property_AddProperty_PropertyProjectTools_xp = "//*[@id='projectToolsTab']/a";
	 public static final String Property_AddProperty_AddForm_xp = "//*[@id='addForm']";
	 
	 public static final String Property_AddProperty_InputProjectName_xp = "//input[@name='ProjectName' and @type='text']";
	 public static final String Property_AddProperty_InputAddress_xp = "//input[@name='Address' and @type='text']";
	 public static final String Property_AddProperty_InputCity_xp = "//input[@name='City' and @type='text']";
	 public static final String Property_AddProperty_InputState_xp = "//input[@name='State' and @type='text']";
	 public static final String Property_AddProperty_InputZipCode_xp = "//input[@name='ZipCode' and @type='text']";
	 public static final String Property_AddProperty_InputCounty_xp = "//input[@name='County' and @type='text']";
	 public static final String Property_AddProperty_InputMainSquareFT_xp = "//input[@name='MainSqFt' and @type='text']";
	 public static final String Property_AddProperty_InputNumberBedrooms_xp = "//input[@name='NumberBedroom' and @type='text']";
	 public static final String Property_AddProperty_ComboNumberBathroom_xp = "//select[@name='NumberBathroom']";
	 public static final String Property_AddProperty_InputYearBuilt_xp = "//input[@name='YearBuilt' and @type='text']";
	 public static final String Property_AddProperty_InputComment_xp = "//textarea[@name='Comment' and @type='text']";
	 public static final String Property_AddProperty_ComboWalkAssigned_xp = "//select[@name='walkUserAssigned']";
	 public static final String Property_AddProperty_InputGateCode_xp = "//input[@name='GateCode' and @type='text']";
	 public static final String Property_AddProperty_InputLockBox_xp = "//input[@name='LockBox' and @type='text']";
	 
	 public static final String Property_AddProperty_InputProjectNameRequired_xp = "//*[@id='ProjectNameLabel']/i"; 
	 public static final String Property_AddProperty_InputAddressRequired_xp = "//*[@id='AddressLabel']/i";
	 public static final String Property_AddProperty_InputCityFieldRequired_xp = "//*[@id='CityLabel']/i";
	 public static final String Property_AddProperty_InputStateFieldRequired_xp = "//*[@id='StateLabel']/i";
	 public static final String Property_AddProperty_InputZipCodeFieldRequired_xp = "//*[@id='ZipCodeLabel']/i";
	 
	 public static final String Property_AddProperty_ProjectNameErrorMsgRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.ProjectName.$error.required']";
	 public static final String Property_AddProperty_AddressErrorMsgRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.Address.$error.required']";
	 public static final String Property_AddProperty_CityErrorMsgRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.City.$error.required']";
	 public static final String Property_AddProperty_StateErrorMsgRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.State.$error.required']";
	 public static final String Property_AddProperty_ZipCodeErrorMsgRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.ZipCode.$error.required']";
	 public static final String Property_AddProperty_notPreviousYearErrorMsgRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.YearBuilt.$error.notPreviousYear']";
	 public static final String Property_AddProperty_NumberBedroomErrorMsgRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.NumberBedroom.$error.pattern']";
	
	 public static final String Property_ToolOptions_SelectPropertyNotWalked_xp = "//*[@id='listTable']/tbody/tr[@class='ng-scope']/td[text()='Not Assigned']/following-sibling::td/b";
	 public static final String Property_ToolOptions_ProjectToolsTab_xp = "//*[@id='projectToolsTab']/a";
	 
	 
	 public static final String Property_ProjectTools_ExportCSV_xp = "//button[@class='btn btn-orange btn-block' and text()='Export CSV']";
	 public static final String Property_ProjectTools_PDF_xp = "//button[@class='btn btn-orange btn-block' and text()='PDF']";
	 public static final String Property_ProjectTools_ScopeAndPhotos_xp = "//button[@class='btn btn-orange btn-block' and text()='Scope and Photos']";
	 public static final String Property_ProjectTools_ApprovedScope_xp = "//button[@class='btn btn-orange btn-block' and text()='Approved Scope']";
	 public static final String Property_ProjectTools_PhotoLink_xp = "//button[@class='btn btn-orange btn-block' and text()='Photo Link']";
	 public static final String Property_ProjectTools_BidPhotoPDF_xp = "//button[@class='btn btn-orange btn-block' and text()='Bid Photo PDF']";
	 public static final String Property_ProjectTools_PhotosZip_xp = "//button[@class='btn btn-orange btn-block' and text()='Photos Zip']";
	 public static final String Property_ProjectTools_BuildHDQuote_xp = "//button[@class='btn btn-orange btn-block' and text()='Build HD Quote']";
	 public static final String Property_ProjectTools_SubmitBid_xp = "//button[@class='btn btn-orange btn-block' and text()='Submit Bid']";
	 
	 //should not be shown in app:
	 public static final String Property_ProjectTools_ExportCSV2_xp = "//button[@class='btn btn-orange btn-block' and text()='Export CSV 2']";
	 public static final String Property_ProjectTools_ExportCSV3_xp = "//button[@class='btn btn-orange btn-block' and text()='Export CSV 3']";
	 public static final String Property_ProjectTools_FinalPhotosPDF_xp = "//button[@class='btn btn-orange btn-block' and text()='Final Photos PDF']";
	 public static final String Property_ProjectTools_PunchList_xp = "//button[@class='btn btn-orange btn-block' and text()='Punch List']";
	 public static final String Property_ProjectTools_InvoiceProject_xp = "//button[@class='btn btn-orange btn-block' and text()='Invoice Project']";
	 
	 //Headers
	 public static final String Property_ProjectTools_PropertyDocsHeader_xp = "//*[@id='pageTitle' and text() = 'Property Docs']";
	 public static final String Property_ProjectTools_PhotoDocsHeader_xp = "//*[@id='pageTitle' and text() = 'Photo Docs']";
	 public static final String Property_ProjectTools_ProductOrderingHeader_xp =  "//*[@id='pageTitle' and text() = 'Product Ordering']";
	 public static final String Property_ProjectTools_HomeDepotBidsHeader_xp = "//*[@id='pageTitle' and text() = 'Home Depot Bids']";
	 
	 //Property Search
	 public static final String Property_SearchProperty_PropertyStatusSelect_xp = "//select[@id='filterStatus']";
	 public static final String Property_SearchProperty_PropertySearchInput_xp = "//input[@id='filterValue']";
	 public static final String Property_SearchProperty_PropertySearchButton_xp = "//button[@id='filterSearchBtn']";
	 
	public static final String Property_SearchProperty_ListPropertyFirst_xp = "//tr[@class='ng-scope'][1]";
	public static final String Property_SearchProperty_ListPropertySecond_xp = "//tr[@class='ng-scope'][2]";
	public static final String Property_SearchProperty_ListPropertyThird_xp = "//tr[@class='ng-scope'][3]";
	
	public static final String Property_SearchProperty_FirstPropertyStatus_xp = "//tr[1]/td[@class='ng-binding' and @ng-bind='property.PropertyStatus']";
	public static final String Property_SearchProperty_FirstProjectName_xp = "//tr[1]/td/b[@class='clickable ng-binding' and @ng-bind='property.ProjectName']";
	public static final String Property_SearchProperty_FirstAddress_xp = "//tr[1]/td[@class='ng-binding' and @ng-bind='property.Address']";
	public static final String Property_SearchProperty_FirstCity_xp = "//tr[1]/td[@class='ng-binding' and @ng-bind='property.City']";
	public static final String Property_SearchProperty_FirstCounty_xp = "//tr[1]/td[@class='ng-binding' and @ng-bind='property.County']";
	public static final String Property_SearchProperty_FirstWalkUserAssigned_xp = "//tr[1]/td[@class='ng-binding' and @ng-bind='property.walkUserAssigned']";
	public static final String Property_SearchProperty_FirstLastActivity_xp = "//tr[1]/td[@class='ng-binding'][6]";
	
	public static final String Property_SearchProperty_SecondPropertyStatus_xp = "//tr[2]/td[@class='ng-binding' and @ng-bind='property.PropertyStatus']";
	public static final String Property_SearchProperty_SecondProjectName_xp = "//tr[2]/td/b[@class='clickable ng-binding' and @ng-bind='property.ProjectName']";
	public static final String Property_SearchProperty_SecondAddress_xp = "//tr[2]/td[@class='ng-binding' and @ng-bind='property.Address']";
	public static final String Property_SearchProperty_SecondCity_xp = "//tr[2]/td[@class='ng-binding' and @ng-bind='property.City']";
	public static final String Property_SearchProperty_SecondCounty_xp = "//tr[2]/td[@class='ng-binding' and @ng-bind='property.County']";
	public static final String Property_SearchProperty_SecondWalkUserAssigned_xp = "//tr[2]/td[@class='ng-binding' and @ng-bind='property.walkUserAssigned']";
	public static final String Property_SearchProperty_SecondLastActivity_xp = "//tr[2]/td[@class='ng-binding'][6]";
	
	public static final String Property_SearchProperty_FirstEditButton_xp = "//tr[1]/td/div/span[@title='Edit']";
	public static final String Property_SearchProperty_FirstDeleteButton_xp = "//tr[1]/td/div/span[@title='Delete']";
	
	public static final String Property_SearchProperty_CountySort_xp = "//th[text()='County ']/span[@title='Edit' and @class='glyphicon glyphicon-sort clickable']";
	public static final String Property_SearchProperty_LastActivitySort_xp = "//th[text()='Last Activity ']/span[@title='Edit' and @class='glyphicon glyphicon-sort clickable']";
	
	public static final String Property_SearchProperty_NoResultMsg_xp = "//div[@id='listNoResults']";
	
	

	public static final String Property_SearchProperty_BtnDeleteSelected_xp = "//*[@id='bulkDeleteBtn']";
	
	public static final String Property_EditProperty_BtnUpdateProperty_xp = "//button[@id='saveBtn' and @ng-click='editProperty()']";
	
	public static final String Property_PropertyWalk_PropertWalkTab_xp = "//a[@ui-sref='app.properties.edit.propertyWalk']";
	public static final String Property_PropertyWalk_FirstGroupInList_xp = "//button[@class='list-group-item ng-scope'][1]";
	public static final String Property_PropertyWalk_FirstItemCommentField_xp = "//tr[1]/td/textarea[@options='item.ItemComment']";
	
	public static final String Property_PropertyWalk_AddNewWalkButton_xp = "//button[@id='addWalkBtn']";
	
	public static final String Property_PropertyWalk_CommentPopupBox_xp = "//div[@class='popover-content']";
	public static final String Property_PropertyWalk_AddCommentFromPopup_xp = "//span[@ng-click='addToModel(comment.Comment); addToPrice(comment.DefaultPrice);']";
	
	public static final String Property_PropertyWalk_MeasurementsArea_xp = "//tbody[@class='products']";
	
	public static final String Property_PropertyWalk_AddMeasurement_xp = "//span[@ng-click='addMeasurement()']";
	///////////////////////////////////////Property Object End/////////////////////////////////////
	
	///////////////////////////////////////Corporations Objects/////////////////////////////////////////
		
	//By Id
	public static final String Corporations_AddCorporation_InputCorpName_id = "CorporateName";
	
	//By Name
	
	//By XPath
	//public static final String Corporations_GenCorp_LinkCorporationsOption_xp = "//a[@ui-sref='app.corporations' and @href='#/renoWalk']/span[text()= ' Corporations']";
	public static final String Corporations_GenCorp_LinkCorporationsOption_xp = "//a[text()= ' Corporations ']";
	
	public static final String Corporations_ViewCorporation_LabelCurrentCorporations_xp = "//h3[text()= 'Current Corporations']";
	
	public static final String Corporations_ViewCorporation_BtnAddCorporation_xp = "//button[@class='btn btn-orange ng-scope' and text()=' ADD CORPORATION']";
	
	//public static final String Corporations_AddCorporation_InputCorpName_xp = "//input[@name='CorporateName' and @type='text']";
	
	public static final String Corporations_AddCorporation_ErrorMsgRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.CorporateName.$error.required']";
	public static final String Corporations_AddCorporation_ErrorMsgPattern_xp = "//div[@class='errorMessage' and @ng-show='addForm.CorporateName.$error.pattern']";
	public static final String Corporations_AddCorporation_ErrorMsgMaxLength_xp = "//div[@class='errorMessage' and @ng-show='addForm.CorporateName.$error.maxlength']";
	public static final String Corporations_AddCorporation_ErrorMsgDuplicate_xp = "//div[@class='errorMessage' and @ng-show='addForm.CorporateName.$error.duplicate']";

	

	
	/*public static final String Corporations_ViewCorporations_ComboPageSize_xp = "//select[@name='pageSize']";
	public static final String Corporations_ViewCorporation_BtnPreviousLink_xp = "//button[@class='btn btn-xs btn-orange pageSelect' and @ng-click='previousPage()']";
	public static final String Corporations_ViewCorporation_BtnNextLink_xp = "//button[@class='btn btn-xs btn-orange pageSelect' and @ng-click='nextPage()']";
	public static final String Corporations_ViewCorporation_InputPageNum_xp = "//input[@name='currentPage' and @type='text' and @ng-model='currentPage']";
	public static final String Corporations_ViewCorporation_LabelPageNum_xp = "//label[@for='currentPage' and @class='sr-only']";
	public static final String Corporations_ViewCorporation_LabelTotalPages_xp = "//span[@class='totalPages ng-binding']";*/
	//By Tag Name
	
	///////////////////////////////////////Corporations Object End//////////////////////////////////////
	
	
	///////////////////////////////////////Regions Objects/////////////////////////////////////////
		
	//By Id
	public static final String Regions_AddRegion_InputRegionName_id = "RegionName";
	
	//By Name
	
	//By XPath
	//public static final String Regions_GenRegion_LinkRegionsOption_xp = "//a[@ui-sref='app.regions' and @href='#/renoWalk']/span[text()= ' Regions']";
	public static final String Regions_GenRegion_LinkRegionsOption_xp = "//a[text()= ' Regions']";
	
	public static final String Regions_ViewRegion_LabelCurrentRegions_xp = "//h3[text()= 'Current Regions']";
	
	public static final String Regions_ViewRegion_BtnAddRegion_xp = "//button[@class='btn btn-orange ng-scope' and text()=' ADD REGION']";
	
	public static final String Regions_AddRegion_ErrorMsgRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.RegionName.$error.required']";
	public static final String Regions_AddRegion_ErrorMsgPattern_xp = "//div[@class='errorMessage' and @ng-show='addForm.RegionName.$error.pattern']";
	public static final String Regions_AddRegion_ErrorMsgMaxLength_xp = "//div[@class='errorMessage' and @ng-show='addForm.RegionName.$error.maxlength']";
	public static final String Regions_AddRegion_ErrorMsgDuplicate_xp = "//div[@class='errorMessage' and @ng-show='addForm.RegionName.$error.duplicate']";

	//By Tag Name
	
	///////////////////////////////////////Regions Object End//////////////////////////////////////
	
	
	///////////////////////////////////////Offices Objects/////////////////////////////////////////
				
	//By Id
	
	
	//By Name
	
	
	//By XPath
	//public static final String Offices_GenOffice_LinkOfficesOption_xp = "//a[@ui-sref='app.offices' and @href='#/renoWalk']/span[text()= ' Offices']";
	public static final String Offices_GenOffice_LinkOfficesOption_xp = "//a[text()= ' Offices ']";
	public static final String Offices_ViewOffice_LabelCurrentOffices_xp = "//h3[text()= 'Current Offices']";
	
	public static final String Offices_ViewOffice_BtnAddOffice_xp = "//button[@class='btn btn-orange ng-scope' and text()=' ADD OFFICE']";
	public static final String Offices_AddOffice_ComboRegion_xp = "//select[@name='region']";
	
	public static final String Offices_AddOffice_InputOfficeName_xp = "//input[@name='OfficeName' and @type='text']";
	public static final String Offices_AddOffice_InputDefaultStoreNumber_xp = "//input[@name='storeNum' and @type='text']";
	public static final String Offices_AddOffice_InputAddress_xp = "//input[@name='address' and @type='text']";
	public static final String Offices_AddOffice_InputCity_xp = "//input[@name='city' and @type='text']";
	public static final String Offices_AddOffice_InputState_xp = "//input[@name='state' and @type='text']";
	public static final String Offices_AddOffice_InputZipCode_xp = "//input[@name='zip' and @type='text']";
	public static final String Offices_AddOffice_InputPhoneNumber_xp = "//input[@name='phoneNumber' and @type='text']";
	public static final String Offices_AddOffice_InputQuoteEmailAddress_xp = "//input[@name='quoteEmailAddress' and @type='email']";
	public static final String Offices_AddOffice_Input_InputPropertyWalkSubmitEmailAddress_xp = "//input[@name='pwSubmitEmailAddress' and @type='email']";
	 
	public static final String Offices_AddOffice_OfficeNameErrorMsgRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.OfficeName.$error.required']";
	public static final String Offices_AddOffice_DefaultStoreNumberErrorMsgRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.storeNum.$error.required']";
	public static final String Offices_AddOffice_AddressErrorMsgRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.address.$error.required']";
	public static final String Offices_AddOffice_CityErrorMsgRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.city.$error.required']";
	public static final String Offices_AddOffice_StateErrorMsgRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.state.$error.required']";
	public static final String Offices_AddOffice_ZipCodeErrorMsgRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.zip.$error.required']";
	public static final String Offices_AddOffice_PhoneNumberErrorMsgRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.phoneNumber.$error.required']";
	public static final String Offices_AddOffice_QuoteEmailAddressErrorMsgRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.quoteEmailAddress.$error.required']";
	 
	public static final String Offices_AddOffice_ErrorMsgDuplicateOfficeName_xp = "//div[@class='errorMessage' and @ng-show='addForm.OfficeName.$error.duplicate']";

	/*public static final String Offices_ViewOffice_ComboPageSize_xp = "//select[@name='pageSize']";
	public static final String Offices_ViewOffice_BtnPreviousLink_xp = "//button[@class='btn btn-xs btn-orange pageSelect' and @ng-click='previousPage()']";
	public static final String Offices_ViewOffice_BtnNextLink_xp = "//button[@class='btn btn-xs btn-orange pageSelect' and @ng-click='nextPage()']";
	public static final String Offices_ViewOffice_InputPageNum_xp = "//input[@name='currentPage' and @type='text' and @ng-model='currentPage']";
	public static final String Offices_ViewOffice_LabelPageNum_xp = "//label[@for='currentPage' and @class='sr-only']";
	
	
	public static final String Offices_ViewOffice_LabelTotalPages_xp = "//span[@class='totalPages ng-binding']";*/
	
	
	//table table-striped table-hover
	//By Tag Name
	
	///////////////////////////////////////Offices Object End//////////////////////////////////////
			
	///////////////////////////////////////Utilities Objects/////////////////////////////////////////
	
	//By Id
	
	
	//By Name
	
	//By XPath
	
	//By Tag Name
	
	///////////////////////////////////////Utilities Object End//////////////////////////////////////
	
	
	
	///////////////////////////////////////Product Tiers Objects/////////////////////////////////////
	
	//By Id
	 public static final String ProductTiers_AddProductTier_InputProductTier_id = "TierName";
	 
	 //By Name
	 
	 //By XPath
	 public static final String ProductTiers_GenProd_LinkProductTiersOption_xp = "//a[text()= ' Product Tiers ']";
	 public static final String ProductTiers_ViewProductTiers_BtnAddProductTier_xp = "//button[@class='btn btn-orange ng-scope' and text()=' ADD PRODUCT TIER']";
	 
	 public static final String ProductTiers_AddProductTier_ErrorMsgRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.TierName.$error.required']";
	 public static final String ProductTiers_AddProductTier_ErrorMsgMaxLength_xp = "//div[@class='errorMessage' and @ng-show='addForm.TierName.$error.maxlength']";
	 public static final String ProductTiers_AddProductTier_ErrorMsgDuplicate_xp = "//div[@class='errorMessage' and @ng-show='addForm.TierName.$error.duplicate']";
	 
	 //By Tag Name
	
	///////////////////////////////////////Product Tiers Object End//////////////////////////////////
	
	
	
	///////////////////////////////////////Items Objects/////////////////////////////////////////////
	
	//By Id	
	
	 //THIS IS MISSPELLED IN THE SOURCE 'BUGDET' SHOULD BE 'BUDGET'!!
	public static final String Items_AddItem_NonBudgetCheckbox_id = "NonBugdetItem";
	
	//By Name
	public static final String Items_AddItem_ItemName_nm = "ItemName";
	public static final String Items_AddItem_RowTypeSelector_nm = "RowType";
	public static final String Items_AddItem_RequiredCheckbox_nm = "Required";
	public static final String Items_AddItem_DefaultMaterial_nm = "DefaultMaterial";
	public static final String Items_AddItem_MaterialRate_nm = "MaterialRate";
	public static final String Items_AddItem_DefaultLabor_nm = "DefaultLabor";
	public static final String Items_AddItem_LaborRate_nm = "LaborRate";
	public static final String Items_AddItem_DefaultHours_nm = "DefaultHours";
	public static final String Items_AddItem_PercentBudget_nm = "PercentBudget";
	
	public static final String Items_AddItem_GLCode_nm = "GLCode";
	public static final String Items_AddItem_Category_nm = "Category";
	public static final String Items_AddItem_Subcategory_nm = "SubCategory";
	public static final String Items_AddItem_ItemComment_nm = "ItemComment0";
	public static final String Items_AddItem_DefaultPrice_nm = "DefaultPrice0";
	public static final String Items_AddItem_SecondItemComment_nm = "ItemComment1";
	public static final String Items_AddItem_DefaultQty_nm = "DefaultQty0";
	public static final String Items_AddItem_SKU_nm = "ProductSKU0";
	public static final String Items_AddItem_MultiPakSKU_nm = "ProductMultiPackSKU0";
	public static final String Items_AddItem_MultiPakQty_nm = "ProductMultiPackQty0";
	public static final String Items_AddItem_DefaultStoreNumber_nm = "ProductDefaultStoreNumber0";
	public static final String Items_AddItem_Description_nm = "ProductDescription0";
	public static final String Items_AddItem_ProductPrice_nm = "ProductPrice0";
	public static final String Items_AddItem_ProductTierID_nm = "ProductTierID0";
	public static final String Items_AddItem_ProductDefaultLabor_nm = "ProductDefaultLabor0";
	public static final String Items_AddItem_ProductDefaultHours_nm = "ProductDefaultHours0";
	public static final String Items_AddItem_ProductGLCode_nm = "ProductGLCode0";
	
	
	
	
	public static final String Items_AddItem_BudgetPercent_nm = "PercentBudget";
	public static final String Items_AddItem_RateNameComment_nm = "DefaultPrice0";
	 
	//By XPath
	public static final String Items_AddItem_ComboRowType_xp = "//select[@name='RowType']";
	

	public static final String Items_AddItem_CheckBoxRequired_xp = "//input[@name='Required' and @type='checkbox']";
	public static final String Items_AddItem_CheckBoxPriceOverride_xp = "//input[@name='PriceOverride' and @type='checkbox']";
	public static final String Items_AddItem_CheckBoxPictureRequired_xp = "//input[@name='PictureRequired' and @type='checkbox']";
	public static final String Items_AddItem_CheckBoxNonBudgetItem_xp = "//input[@name='NonBugdetItem' and @type='checkbox']";
	
	
	public static final String Items_GenItem_LinkItemsOption_xp = "//a[text()= ' Items ']";
	//public static final String Items_GenItem_LinkItemsOption_xp = "//a[text()= ' Product Tiers']";
	public static final String Items_ViewItem_BtnDeleteSelected_xp = "//button[@class='btn btn-red pull-right' and text()=' DELETE SELECTED']";
	public static final String Items_ViewItem_BtnAddItem_xp = "//button[@class='btn btn-orange ng-scope' and text()=' ADD ITEM']";
	public static final String Items_ViewItem_LabelCurrentItems_xp = "//h3[text()= 'Current Items']";
	public static final String Items_AddItem_OpenCommentsSection_xp = "//i[@class='btn btn-xs glyphicon glyphicon-plus' and @ng-show='!showComments']";
	public static final String Items_AddItem_ProductsPanelHeader_xp = "//i[@class='btn btn-xs glyphicon glyphicon-plus' and @ng-show='!showProducts']";
	public static final String Items_AddItem_InputItemName_xp = "//input[@name='ItemName' and @type='text']";
	public static final String Items_AddItem_BtnAddComment_xp = "//button[@class='btn btn-orange btn-block' and @ng-click='addComment()']";
	public static final String Items_AddItem_BtnAddCommentDisabled_xp = "//button[@class='btn btn-orange btn-block' and @ng-click='addComment()' and @ng-disabled='hasBlankComment()']";
	public static final String Items_AddItem_BtnAddProduct_xp = "//button[@class='btn btn-orange btn-block' and @ng-click='addProduct()']";
	
	public static final String Items_AddItem_FirstItemComment_xp = "//input[@name='ItemComment0']";
	
	public static final String Items_AddItem_ErrorMsgBudgetPercentRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.PercentBudget.$error.required']";
	public static final String Items_AddItem_ErrorMsgItemNameRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.ItemName.$error.required']";
	public static final String Items_AddItem_ErrorMsgDefaultMaterialRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.DefaultMaterial.$error.required']";
	public static final String Items_AddItem_ErrorMsgDefaultLaborRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.DefaultLabor.$error.required']";
	public static final String Items_AddItem_ErrorMsgMaterialRateRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.MaterialRate.$error.required']";
	public static final String Items_AddItem_ErrorMsgLaborRateRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.LaborRate.$error.required']";
	public static final String Items_AddItem_ErrorMsgRowTypeRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.RowType.$error.required']";
	public static final String Items_AddItem_NonBudgetCheckbox_xp = "//input[@type='checkbox' and @id='NonBugdetItem']"; //Spelling error in site id for Budget -> "Bugdet"
	public static final String Items_AddItem_PriceOverride_xp = "//input[@type='checkbox' and @id='PriceOverride']";
	
	public static final String Items_AddItem_ErrorMsgDefaultMaterialNumber_xp = "//div[@class='errorMessage' and ng-show='addForm.DefaultMaterial.$error.number']";
	public static final String Items_AddItem_ErrorMsgDefaultLaborNumber_xp = "//div[@class='errorMessage' and ng-show='addForm.DefaultLabor.$error.number']";
	public static final String Items_AddItem_ErrorMsgDefaultHoursNumber_xp = "//div[@class='errorMessage' and ng-show='addForm.DefaultHours.$error.number']";
	
	public static final String Items_AddItem_CloseProductSKUSearchBox_xp = "//button[@class='close searchSkuCloseButton']";
	

	public static final String Items_AddItem_FirstProductRow_xp = "//tr[@ng-repeat='product in addItemObj.ItemSKU' and @jqyoui-draggable='{index: 0, animate: true}']";
	public static final String Items_AddItem_SecondProductRow_xp = "//tr[@ng-repeat='product in addItemObj.ItemSKU' and @jqyoui-draggable='{index: 1, animate: true}']";
	
	public static final String Items_AddItem_ProductSearchIcon_xp = "//span[@class='glyphicon glyphicon-search btn btn-xs search']";
	
	public static final String Items_AddItem_SearchSKUBox_xp = "//div[@class='searchSku ng-scope']";
	public static final String Items_AddItem_SearchSKUSearchField_xp = "//input[@name='SkuItemSearch' and @ng-model='skuItemNumber']";
	
	public static final String Items_AddItem_BtnDeleteComment_xp = "//span[@class='glyphicon glyphicon-remove-circle btn btn-xs delete' and @ng-click='removeComment(comment)']";
	//By Tag Name
	
	///////////////////////////////////////Items Object End///////////////////////////////////////////
	
	
	
	///////////////////////////////////////Groups Objects/////////////////////////////////////////////
	
	//By Id
	
	//By Name

	//By XPath
	
	public static final String Groups_GenGroups_LinkGroupOption_xp = "//a[text()= ' Groups ']";
	
	public static final String Groups_ViewGroup_BtnAddGroup_xp = "//*[@id='addToggleBtn']";
	public static final String Groups_ViewGroup_BtnDeleteSelected_xp = "//*[@id='bulkDeleteBtn']";
	public static final String Groups_ViewGroups_BtnAddGroup_xp = "//button[@class='btn btn-orange ng-scope' and text()=' ADD GROUP']";
	
	
	
	public static final String Groups_AddGroup_AddForm_xp = "//*[@id='addForm']";
	
	public static final String Groups_AddGroup_InputGroupName_xp = "//input[@name='GroupName' and @type='text']";
	public static final String Groups_AddGroup_InputDescription_xp = "//input[@name='Description' and @type='text']";
	public static final String Groups_AddGroup_InputMaxNumberperHouse_xp = "//input[@name='MaxNumberPerHouse' and @type='text']";
	public static final String Groups_AddGroup_InputGLCode_xp = "//input[@name='GLCode' and @type='text']";
	public static final String Groups_AddGroup_InputPhotoFolderName_xp = "//input[@name='PhotoFolderName' and @type='text']";
	public static final String Groups_AddGroup_CheckBoxIncludeFlooring_xp = "//input[@name='IncludeMeasurements' and @type='checkbox']";
	public static final String Groups_AddGroup_CheckBoxIncludeComment_xp = "//input[@name='IncludeComment' and @type='checkbox']";
	public static final String Groups_AddGroup_CheckBoxDefaultPhotoGroup_xp = "//input[@name='DefaultPhotoGroup' and @type='checkbox']";
	public static final String Groups_AddGroup_CheckBoxIncludePaint_xp = "//input[@name='IncludePaint' and @type='checkbox']";
	
	
	public static final String Groups_AddGroup_InputGroupNameFieldRequired_xp = "//*[@id='GroupNameLabel']/i";
	public static final String Groups_AddGroup_InputDescriptionFieldRequired_xp = "//*[@id='DescriptionLabel']/i";
	public static final String Groups_AddGroup_InputMaxNumberPerHouseFieldRequired_xp = "//*[@id='MaxNumberPerHouseLabel']/i";
	
	public static final String Groups_AddGroup_ItemsColumnName_xp = "//*[@id='itemsTitle']";
	public static final String Groups_AddGroup_GroupItemsColumnName_xp = "//*[@id='groupItemsTitle']";
	public static final String Groups_AddGroup_InputItemSearch_xp = "//*[@id='filterValue']";
	public static final String Groups_AddGroup_BtnSearchItems_xp = "//*[@id='filterSearchBtn']";
	
	
	public static final String Groups_AddGroup_ErrorMsgGroupNameRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.GroupName.$error.required']";
	public static final String Groups_AddGroup_ErrorMsgDescriptionRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.Description.$error.required']";
	public static final String Groups_AddGroup_ErrorMsgMaxNumberPerHouseRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.MaxNumberPerHouse.$error.required']";
	public static final String Groups_AddGroup_ErrorMsgNumericValueRequired_xp = "//div[@class='errorMessage' and @ng-show='addForm.MaxNumberPerHouse.$error.pattern']";
	public static final String Groups_AddGroup_ErrorMsgDuplicate_xp = "//div[@class='errorMessage' and @ng-show='addForm.GroupName.$error.duplicate']";
	public static final String Groups_AddGroup_ErrorMsgMaximumLengthGroupName_xp = "//div[@class='errorMessage' and @ng-show='addForm.GroupName.$error.maxlength']";
	public static final String Groups_AddGroup_ErrorMsgMaximumLengthDescription_xp = "//div[@class='errorMessage' and @ng-show='addForm.Description.$error.maxlength']";
	public static final String Groups_AddGroup_ErrorMsgMaximumLengthMaxNumberPerHouse_xp = "//div[@class='errorMessage' and @ng-show='addForm.MaxNumberPerHouse.$error.maxlength']";
	public static final String Groups_AddGroup_ErrorMsgMaximumLengthGLCode_xp = "//div[@class='errorMessage' and @ng-show='addForm.GLCode.$error.maxlength']";
	public static final String Groups_AddGroup_ErrorMsgMaximumLength_PhotoFolderName_xp = "//div[@class='errorMessage' and @ng-show='addForm.PhotoFolderName.$error.maxlength']";
	
	public static final String Groups_AddGroup_ItemList_DragAndDropInstructions_xp = "//div[@class='dragDropInfo']";
	public static final String Groups_AddGroup_FirstItemVisible_xp = "//li[@class='list-group-item sortableListContentDraggableRow ng-binding ng-scope ui-draggable ui-draggable-handle' and @jqyoui-draggable='{index: 0, animate: true}']";
	public static final String Groups_AddGroup_SecondItemVisible_xp = "//li[@class='list-group-item sortableListContentDraggableRow ng-binding ng-scope ui-draggable ui-draggable-handle' and @jqyoui-draggable='{index: 1, animate: true}']";
	public static final String Groups_AddGroup_SortableItemList_xp = "//ul[@class='sortableListContentSibling ui-sortable']";
	public static final String Groups_AddGroup_SeachableItemList_xp = "//ul[@class='sortableListContent ui-sortable']";
	
	public static final String Groups_AddGroup_FirstItemDragSpace_xp = "//li[@class='list-group-item sortableListContentSiblingDraggableRow ng-binding ng-scope ui-draggable ui-draggable-handle' and @jqyoui-draggable='{index: 0, animate: true}']";
	public static final String Groups_AddGroup_FirstItemDragBedroomRadio_xp = "//input[@id='bedroomGroupRadio0' and @value='BedroomGroup']";
	public static final String Groups_AddGroup_FirstItemDragBathroomRadio_xp = "//input[@id='bathroomGroupRadio0' and @value='BathroomGroup']";
	
	public static final String Groups_AddGroup_ItemsSearchBox_xp = "//input[@id='filterValue' and @ng-model='itemFilterQuery']";
	public static final String Groups_AddGroup_ItemsSearchBtn_xp = "//button[@id='filterSearchBtn' and @ng-click='performSearchItems(itemFilterQuery)']";
	public static final String Groups_AddGroup_ItemsClearBtn_xp = "//button[@id='filterClearBtn' and @ng-click='resetSearchItems()']";
	
	public static final String Groups_AddGroup_NoItemsMessage_xp = "//div[@class='noDraggableRowsMessage' and text()='No Items']";
	
	public static final String Flow_AddGroup_GroupNameFindInList_xp = "//table[@id='listTable']/tbody/tr/td/b[@ng-bind='group.Name' and text()='TOKEN']";
	
	
	//By Tag Name
	
	///////////////////////////////////////Groups Object End//////////////////////////////////////////
	
	
	///////////////////////////////////////Flow Objects///////////////////////////////////////////////
	
	//By Id
	
	
	//By Name
	
	public static final String Flow_AddFlow_DeleteBeforeCheck_nm = "DeleteBeforeImport";
	public static final String Flow_AddFlow_FlowNameInput_nm = "FlowName";
	public static final String Flow_AddFlow_FlowDescriptionInput_nm = "Description";
	public static final String Flow_AddFlow_FlowHourlyRate_nm = "HourlyLaborRate";
	//public static final String Flow_AddFlow_
	//public static final String Flow_AddFlow_
	
	
	//By XPath
	
	
	public static final String Flow_AddFlow_LinkFlowOption_xp = "//a[text()= ' Flow ']";
	public static final String Flow_AddFlow_BtnAddFlow_xp = "//button[@class='btn btn-orange ng-scope' and @ui-sref='app.flows.add']";
	
	public static final String Flow_AddFlow_JsonUploadLabel_xp = "//label[@class='sr-only' and @for='AppFlowJson']";
	public static final String Flow_AddFlow_ImportJson_xp = "//button[@name='btn_import' and @class='btn btn-orange']";
	public static final String Flow_AddFlow_FirstCurrentFlows_xp = "//tr[@ng-repeat='flow in flows']/td[1]";
	public static final String Flow_AddFlow_FirstFlowOptions_xp = "//tr[@ng-repeat='flow in flows']/td[3]/div[@class='pull-right']";
	public static final String Flow_AddFlow_FirstFlowExport_xp = "//tr[@ng-repeat='flow in flows']/td[3]/div[@class='pull-right']/span[@title='Export']";
	public static final String Flow_AddFlow_FirstFlowEdit_xp = "//tr[@ng-repeat='flow in flows']/td[3]/div[@class='pull-right']/span[@title='Edit']";
	public static final String Flow_AddFlow_FirstFlowDelete_xp = "//tr[@ng-repeat='flow in flows']/td[3]/div[@class='pull-right']/span[@title='Delete']";
	
	
	
	public static final String Flow_AddFlow_ItemList_DragAndDropInstructions_xp = "//div[@class='dragDropInfo']";
	public static final String Flow_AddFlow_FirstItemVisible_xp = "//li[@class='list-group-item sortableListContentDraggableRow ng-binding ng-scope ui-draggable ui-draggable-handle' and @jqyoui-draggable='{index: 0, animate: true}']";
	public static final String Flow_AddFlow_SecondItemVisible_xp = "//li[@class='list-group-item sortableListContentDraggableRow ng-binding ng-scope ui-draggable ui-draggable-handle' and @jqyoui-draggable='{index: 1, animate: true}']";
	public static final String Flow_AddFlow_SearchableItemList_xp = "//ul[@class='sortableListContent ui-sortable']";
	public static final String Flow_AddFlow_SortableItemList_xp = "//ul[@class='sortableListContentSibling ui-sortable']";
	
	public static final String Flow_AddFlow_FirstItemDragSpace_xp = "//li[@class='list-group-item sortableListContentSiblingDraggableRow ng-binding ng-scope ui-draggable ui-draggable-handle' and @jqyoui-draggable='{index: 0, animate: true}']";
	public static final String Flow_AddFlow_FirstItemDragBedroomRadio_xp = "//input[@id='bedroomGroupRadio0' and @value='BedroomGroup']";
	public static final String Flow_AddFlow_FirstItemDragBathroomRadio_xp = "//input[@id='bathroomGroupRadio0' and @value='BathroomGroup']";
	
	
	public static final String Flow_AddFlow_FlowFlooringSection_xp = "//table[@class='table flowAddGrid']/tbody/tr/td[text()='Carpet Per SqYd :']";
	
	public static final String Flow_AddFlow_FlowNameReqIndicator_xp = "//label[@id='FlowNameLabel']/i[@class='requiredIndicator']";
	public static final String Flow_AddFlow_FlowDescReqIndicator_xp = "//label[@id='DescriptionLabel']/i[@class='requiredIndicator']";
	

	public static final String Flow_AddFlow_PaintColorInput_xp = "//input[@name='WallPaintFiveGallonColor']";
	public static final String Flow_AddFlow_FlowCarpetWastePctInput_xp = "//input[@name='CarpetWasteFactor']";
	public static final String Flow_AddFlow_FlowCarpetRemovalInput_xp = "//input[@name='CarpetRemovalCost']";
	public static final String Flow_AddFlow_FlowCarpetLaborInput_xp = "//input[@name='CarpetLabor']";
	public static final String Flow_AddFlow_CarpetPadCoveragePerSkuInput_xp = "//input[@name='CarpetPadSqYdPerSKU']";
	public static final String Flow_AddFlow_PaintSkuInput_xp = "//input[@name='WallPaintFiveGallonSKU']";
	public static final String Flow_AddFlow_CarpetStoreNumberInput_xp = "//input[@name='CarpetStoreNumber']";
	public static final String Flow_AddFlow_CarpetMaterialInput_xp = "//input[@name='CarpetMaterial']";
	
	
	
	
	public static final String Flow_AddFlow_FlowNameRequiredMsg_xp = "//div[@class='errorMessage' and @ng-show='addForm.FlowName.$error.required']";
	public static final String Flow_AddFlow_FlowDescRequiredMsg_xp = "//div[@class='errorMessage' and @ng-show='addForm.Description.$error.required']";
	public static final String Flow_AddFlow_FlowNameLengthMsg_xp = "//div[@class='errorMessage' and @ng-show='addForm.FlowName.$error.maxlength']";
	public static final String Flow_AddFlow_FlowDescLengthMsg_xp = "//div[@class='errorMessage' and @ng-show='addForm.Description.$error.maxlength']";
	public static final String Flow_AddFlow_FlowLaborRateLengthMsg_xp = "//div[@class='errorMessage' and @ng-show='addForm.HourlyLaborRate.$error.decimal']";
	public static final String Flow_AddFlow_FlowCarpetWastePctLengthMsg_xp = "//div[@class='errorMessage' and @ng-show='addForm.CarpetWasteFactor.$error.decimal']";
	public static final String Flow_AddFlow_PaintColorLengthMsg_xp = "//div[@class='errorMessage' and @ng-show='addForm.WallPaintFiveGallonColor.$error.maxlength']";
	public static final String Flow_AddFlow_CarpetRemovalLengthMsg_xp = "//div[@class='errorMessage' and @ng-show='addForm.CarpetRemovalCost.$error.decimal']";
	public static final String Flow_AddFlow_CarpetLaborLengthMsg_xp = "//div[@class='errorMessage' and @ng-show='addForm.CarpetLabor.$error.decimal']";
	public static final String Flow_AddFlow_CarpetPadCoveragePerSkuLengthMsg_xp = "//div[@class='errorMessage' and @ng-show='addForm.CarpetPadSqYdPerSKU.$error.decimal']";
	public static final String Flow_AddFlow_PaintColorSkuLengthMsg_xp = "//div[@class='errorMessage' and @ng-show='addForm.WallPaintFiveGallonSKU.$error.maxlength']";
	public static final String Flow_AddFlow_CarpetStoreLengthMsg_xp = "//div[@class='errorMessage' and @ng-show='addForm.CarpetStoreNumber.$error.maxlength']";
	public static final String Flow_AddFlow_CarpetMaterialLengthMsg_xp = "//div[@class='errorMessage' and @ng-show='addForm.CarpetMaterial.$error.decimal']";
	
	public static final String Flow_AddFlow_GroupsSearchBox_xp = "//input[@id='filterValue' and @ng-model='groupFilterQuery']";
	public static final String Flow_AddFlow_GroupsSearchBtn_xp = "//button[@id='filterSearchBtn' and @ng-click='performSearchGroups(groupFilterQuery)']";
	public static final String Flow_AddFlow_GroupsClearBtn_xp = "//button[@id='filterClearBtn' and @ng-click='resetSearchGroups()']";
	
	public static final String Flow_AddFlow_NoGroupsMessage_xp = "//div[@class='noDraggableRowsMessage' and text()='No Items']";
	
	
	
	
	
	
	public static final String Flow_AddFlow_SaveButtonDisabled_xp = "//button[@id='saveBtn' and @disabled='disabled']";
	
	//Replacable TOKEN in string
	public static final String Flow_AddFlow_FlowNameFindInList_xp = "//table[@id='listTable']/tbody/tr/td/b[@ng-bind='flow.Name' and text()='TOKEN']";
	
	//By Tag Name
	
	///////////////////////////////////////Groups Object End//////////////////////////////////////////
}
