package com.homedepot.renowalk.ObjectRepository;

import org.openqa.selenium.By;

import io.appium.java_client.ios.IOSElement;

public class RenowalkIpad {
	

	
	////////////////////////////////////////Renowalk Ipad Login/Myproperties Page Objects/////////////////////////////////////////////////// 
	
	//By Name
	public static final String LoginBtn_nm = "Login";  
	public static final String LogoutBtn_nm = "Logout";
	public static final String HomeBtn_nm = "home.png";
	public static final String RemindMeNextBtn_nm = "Remind Me Next Time";  
	public static final String Main_ComboBox_SelectOffice_xp = "//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]";
	public static final String MyPropertiesHeading_nm = "My Properties"; 
	public static final String SettingIcon_nm = "SettingIcon"; 
	public static final String SyncIcon_nm = "sync"; 
	public static final String PropertyDetailsProjectNameLabel_nm = "Project Name  :";
	public static final String PropertyDetailsAddressLabel_nm = "Address  :";
	public static final String PropertyDetailsCountyLabel_nm = "County :";
	public static final String PropertyDetailsSQFTLabel_nm = "Main SQFT  :";
	public static final String PropertyDetailsNumBedroomsLabel_nm = "# Bedrooms  :";
	public static final String PropertyDetailsNumBathroomsLabel_nm = "# Bathrooms  :";
	public static final String PropertyDetailsYearBuiltLabel_nm = "Year Built  :";
	public static final String PropertyDetailsGarageLabel_nm = "Garage Size  :";
	public static final String PropertyDetailsGaragePapopTitle_nm = "Garage Size";
	public static final String PropertyDetailsGarageSize_NoGarage_nm = "No Garage";
	public static final String PropertyDetailsGarageSize_1Car_nm = "1 Car";
	public static final String PropertyDetailsGarageSize_2Car_nm = "2 Car";
	public static final String PropertyDetailsGarageSize_3Car_nm = "3 Car";
	public static final String PropertyDetailsHomeStyleLabel_nm = "Home Style  :";
	public static final String PropertyDetailsHomeStylePapopTitle_nm = "Home Style";
	public static final String PropertyDetailsHomeStyle_1Story_nm = "Single Story";
	public static final String PropertyDetailsHomeStyle_2Story_nm = "2 Story";
	public static final String PropertyDetailsHomeStyle_3Story_nm = "3 Story";
	public static final String PropertyDetailsHomeStyle_Trilevel_nm = "Tri-Level";
	public static final String PropertyDetailsBasementLabel_nm = "Basement";
	public static final String PropertyDetailsExteriorLabel_nm = "Exterior Type  :";
	public static final String PropertyDetailsExteriorPapopTitle_nm = "Exterior Type";
	public static final String PropertyDetailsExterior_BrickFront_nm = "Brick - Front";
	public static final String PropertyDetailsExterior_Brick3Sides_nm = "Brick - 3 Sides";
	public static final String PropertyDetailsExterior_Brick4Sides_nm = "Brick - 4 Sides";
	public static final String PropertyDetailsExterior_BrickCinder_nm = "Cinder Block";
	public static final String PropertyDetailsExterior_FrameAluminumSiding_nm = "Frame - Aluminum Siding";
	public static final String PropertyDetailsExterior_FrameAsbestosSiding_nm = "Frame - Asbestos Siding";
	public static final String PropertyDetailsExterior_FrameVinylSiding_nm = "Frame - Vinyl Siding";
	public static final String PropertyDetailsExterior_FrameWoodSiding_nm = "Frame - Wood Siding";
	public static final String PropertyDetailsExterior_Stucco_nm = "Stucco";
	public static final String PropertyDetailsGateCodeLabel_nm = "Gate Code  :";
	public static final String PropertyDetailsLockBoxLabel_nm = "Lock Box  :";
	public static final String PropertyDetailsDimensionsLabel_nm = "House Dimensions :";
	public static final String PropertyDetailsDepthLabel_nm = "Approximate Depth :";
	public static final String PropertyDetailsWidthLabel_nm = "Approximate Width :";
	public static final String PropertyDetailsNotesLabel_nm = "Notes :";
	public static final String PropertyDetailsHomepng_nm = "Dimensions.png";
	public static final String PropertyDetailsBackBtn_nm ="Back";
	public static final String PropertyDetailsToolbox_nm = "toolbox";
	public static final String CompassPicture_nm = "compass.png";
	public static final String ToolboxToolBackButton_nm = "Back";
	public static final String ToolboxToolNextButton_nm = "Next";
	public static final String CompassHeader_nm = "Compass";
	public static final String CalculatorHeader_nm = "Calculator";
	public static final String PhotoAnnotateHeader_nm = "Photo Annotate";
	public static final String PhotoAnnotateCameraIcon_nm = "camera";
	
	public static final String Properties_BtnNavigation_nm = "MapIcon";
	
	
	//KeyBoard members
	public static final String KeyBoard_HideKeyBoard_nm = "Hide keyboard";
	
	
	
	//By Xpath
	public static final String InputUserName_xp =  "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIATextField[1]";
	public static final String InputPassword_xp =  "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIASecureTextField[1]";
	public static final String GridViewProperties_xp =  "//UIAApplication[1]/UIAWindow[1]/UIAButton[11]";
	public static final String ListViewProperties_xp =  "//UIAApplication[1]/UIAWindow[1]/UIAButton[12]";
	public static final String Name_property1_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAStaticText[1]";
	public static final String HomeIocn_property1_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAImage[1]";
	public static final String Name_property2_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAStaticText[5]";
	public static final String HomeIocn_property2_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAImage[2]";
	public static final String propertyStatus1_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAStaticText[4]";
	public static final String propertyStatus2_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAStaticText[8]";
	public static final String cloudDownload_property1_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAButton[3]";
	public static final String cloudDownload_property2_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAButton[6]";
	public static final String ListViewDisplayTable_xp = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]";
	public static final String GridViewDisplayTable_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]";
	public static final String ListViewProperty1Name_xp = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]";
	public static final String PropertyDetailsPagePropertyName_xp = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[5]";
	public static final String ListViewProperty2Name_xp = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]";
	public static final String PropertyDetails_ScrollView_xp = "/UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]";
	public static final String PropertyDetailsPageProjectNameTextbox_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]";
	public static final String PropertyDetailsProjectNameTextbox_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]";
	public static final String PropertyDetailsAddress1_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[5]";
	public static final String PropertyDetailsAddress2_xp = "/UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[7]";
	public static final String PropertyDetailsCountryTextbox_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[3]";
	public static final String PropertyDetailsSQFTTextbox_xp= "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[4]";
	public static final String PropertyDetailsNumBedroomsTextbox_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[5]";
	public static final String PropertyDetailsNumBathroomsSelector_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[4]";
	public static final String PropertyDetailsYearBuiltTextbox_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[6]";
	public static final String PropertyDetailsGarageSelector_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[5]";
	public static final String PropertyDetailsPopover_Table_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]";  //common popover in property details page
	
	public static final String PropertyDetailsPopoverTable_Cell1_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]";
	public static final String PropertyDetailsPopoverTable_Cell2_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]";
	public static final String PropertyDetailsPopoverTable_Cell3_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[1]";
	public static final String PropertyDetailsPopoverTable_Cell4_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[4]/UIAStaticText[1]";
	
	public static final String PropertyDetailsGarageSize_NoGarage_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]";
	public static final String PropertyDetailsGarageSize_1Car_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]";
	public static final String PropertyDetailsGarageSize_2Car_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[1]";
	public static final String PropertyDetailsGarageSize_3Car_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[4]/UIAStaticText[1]";
	
	public static final String PropertyDetailsExterior_BrickFront_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]";
	public static final String PropertyDetailsExterior_Brick3Sides_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]";
	public static final String PropertyDetailsExterior_Brick4Sides_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[1]";
	public static final String PropertyDetailsExterior_BrickCinder_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[4]/UIAStaticText[1]";
	 
	public static final String PropertyDetailsHomeStyleSelector_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[6]";
	public static final String PropertyDetailsBasementCheckbox_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[8]";
	
	
	public static final String PropertyDetailsBasement_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[7]";
	public static final String PropertyDetailsBasementTextbox_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[8]";

	public static final String PropertyDetailsExteriorSelector_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[10]";
	public static final String PropertyDetailsGateCodeTextbox_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[9]";
	public static final String PropertyDetailsLockBoxTextbox_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[10]";
	public static final String PropertyDetailsDepthTextbox_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[11]";
	public static final String PropertyDetailsWidthTextbox_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[12]";
	public static final String PropertyDetailsNotesTextbox_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[1]";
	public static final String PropertyDetailsToolboxCompass_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]";
	public static final String PropertyDetailsToolboxCalc_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]";
	public static final String PropertyDetailsToolboxPhoto_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[1]";
	public static final String PropertyDetailsToolboxLevel_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[4]/UIAStaticText[1]";
	public static final String PropertyDetailsToolboxRoof_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[5]/UIAStaticText[1]";
	public static final String PropertyDetailsToolboxSave_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[6]/UIAStaticText[1]";
	public static final String CalcEquationViewer_xp = "//UIAApplication[1]/UIAWindow[1]/UIATextView[1]";
	public static final String PhotoAnnotatePropertyName_xp="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAStaticText[1]";
	
	//My Properties 
	public static final String Property_myProperties_BtnGridView_xp = "//UIAApplication[1]/UIAWindow[1]/UIAButton[11]";
	public static final String Property_myProperties_BtnListView_xp = "//UIAApplication[1]/UIAWindow[1]/UIAButton[12]";
	public static final String Property_myProperties_myPropertiesTxt_nm = "My Properties";
	
	
	//Level Module
	public static final String Property_Settings_Level_LevelHeader_name = "Level";
	public static final String Property_Settings_Level_LevelClienometer_name = "Clienometer.png";
	
	//Roof Pitch Module
	public static final String Property_Settings_RoofPitch_BtnCancel_name = "Cancel";
	
	//Compass Module
	//By Name
	public static final String Property_Settings_Compass_Title_name = "Compass";
	
	//By XPath
	public static final String Property_Settings_Compass_BtnBack_xp = "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]";
	public static final String Property_Settings_PhotoAnnotate_BtnBack_xp = "//UIAApplication[1]/UIAWindow[1]/UIAButton[7]";
	
	//Save Photos
	public static final String Property_Settings_SavePhotos_BtnCancel_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIAActionSheet[1]/UIAButton[1]";
	
	//Photos
	//By name
	public static final String Property_Photos_nm = "Photos";
	public static final String Property_Photos_AddPhotos_nm = "+";
	public static final String Property_Photos_TakePicture_nm = "Take Picture";
	public static final String Property_Photos_ChoosePicture_nm = "Choose Picture";
	public static final String Property_Photos_BtnCamera_nm = "cameraIcon";
	public static final String Property_Photos_CameraRoll_nm = "Camera Roll";
	
	//Edit
	public static final String Property_Photos_BtnEdit_nm = "Edit";
	public static final String Property_Photos_BtnDone_nm = "Done";
	
	//By XPath
	public static final String Property_Photos_BtnSave_xp = "//UIAApplication[1]/UIAWindow[1]/UIAToolbar[1]/UIAButton[4]";
	public static final String Property_Photos_SelectPhoto_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIACollectionView[1]/UIACollectionCell[1]";
	
	public static final String Property_Photos_BtnMinus_xp = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]";
	public static final String Property_Photos_BtnDelete_xp = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[3]";
	
	//Property Page
	public static final String Property_ProjectName_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]";
	public static final String Property_Address_xp = "";
	
	public static final String Property_County_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[3]";
	public static final String Property_MainSqFt_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[4]";
	public static final String Property_NumberBedRooms_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[5]";
	public static final String Property_BtnNumberBathRooms_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[4]";
	public static final String Proerty_PopUpNumberBathRooms_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[1]";
	public static final String Property_YearBuilt_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[6]";
	public static final String Property_BtnGarageSize_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[5]";
	public static final String Property_GarageSizePopUp_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]";
	public static final String Property_BtnHomeStyle_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[6]";
	public static final String Property_PopUpHomeStyle_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]";
	public static final String Property_CheckBoxBasement_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[8]";
	public static final String Property_Basement_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[8]";
	public static final String Property_BtnExteriorType_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[10]";
	public static final String Property_PopUpExteriorType_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]";
	public static final String Property_GateCode_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[9]";
	public static final String Property_LockBox_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[10]";
	public static final String Property_ApproxDepth_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[11]";
	public static final String Property_ApproxWidth_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[12]";
	public static final String Property_Notes_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[1]";
	
	//Address field
	public static final String Property_BtnAddress_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[5]";
	public static final String Property_Address_Address1_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]";
	public static final String Property_Address_Address2_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[2]";
	public static final String Property_Address_City_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[3]";
	public static final String Property_Address_State_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[4]";
	public static final String Property_Address_ZipCode_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[5]";
	
	
	//Group Page
	public static final String Group_AddGroup_BtnAdd_xp = "//UIAApplication[1]/UIAWindow[1]/UIAButton[7]";
	
	//Group Page popUp
	public static final String Group_AddGroup_ExteriorPopUp_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]";
	public static final String Group_AddGroup_InteriorPopUp_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]";
	
	//Group page Dialog Box PopOver
	public static final String Group_AddGroup_DialogBoxName_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATextField[1]";
	public static final String Group_AddGroup_BtnAddGroup_nm = "Add";
	
	//Group Page Table Views
	public static final String Group_TableViewExterior_xp = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextField[1]";
	public static final String Group_TableViewInterior_xp = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]";
	
	public static final String Group_ViewGroup_ExteriorHeading_nm = "Exterior";
	public static final String Group_ViewGroup_TotalEstimate_xp = "//UIAApplication[1]/UIAWindow[1]/UIAButton[4]";
	
	//Table cell for Groups
	public static final String Group_ViewGroup_Exterior_nm = "0";
	
	public static final String Group_ViewGroup_PressureWashHeading_nm = "Pressure Wash";
	public static final String Group_ViewGroup_PressureWashDeleteComment_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]";
	
	public static final String Group_ViewGroup_PressureWashTextArea_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextView[1]";
	public static final String Group_ViewGroup_PressureWashComment_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]";
	public static final String Group_ViewGroup_PressureWashPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[1]";
	
	
	public static final String Group_ViewGroup_ExteriorPaintAllHeading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[2]";
	public static final String Group_ViewGroup_ExteriorPaintAllUpArrow_nm = "UpArrow";
	public static final String Group_ViewGroup_ExteriorPaintAllDownArrow_nm = "DownArrow";

	public static final String Group_ViewGroup_ExteriorPaintPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[4]";
	
	//MailBox
	public static final String Group_ViewGroup_ExteriorMailboxHeading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[10]";
	public static final String Group_ViewGroup_ExteriorMailboxTotal_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[11]";
	public static final String Group_ViewGroup_ExteriorMailboxArrow_nm = "arrow1";
	public static final String Group_ViewGroup_ExteriorMailboxDownArrow_nm = "ArrowDown";
	
	public static final String Group_ViewGroup_ExteriorMailbox_SKUBlackHorizontalWallMount_nm = "812593";
	public static final String Group_ViewGroup_ExteriorMailbox_SKUBlackHorizontalWallMountQty_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIAScrollView[1]/UIATextField[1]";
	
	public static final String Group_ViewGroup_ExteriorMailbox_SKUBlackTownHouseWallMount_nm = "812596";
	public static final String Group_ViewGroup_ExteriorMailbox_SKUBlackTownHouseWallMountQty_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIAScrollView[1]/UIATextField[3]";
	
	
	
	
	
	//SCOPE OF WORK
	
	public static final String Total_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[17]";
	
	//Exterior
	public static final String Exterior_ExteriorHeading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[18]";
	public static final String Exterior_ExteriorItemsList_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[22]";
	public static final String Exterior_ExteriorPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[26]";
	public static final String Exterior_ExteriorPricePaintAll_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[25]";
	
	public static final String Exterior_ExteriorMailbox_SKUBlackHorizontalWallMountText_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[22]";
	public static final String Exterior_ExteriorMailbox_SKUBlackHorizontalWallMountPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[25]";
	
	public static final String Exterior_ExteriorMailbox_SKUBlackTownHouseWallMountText_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[26]";
	public static final String Exterior_ExteriorMailbox_SKUBlackTownHouseWallMountPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[29]";
	
	//Interior
	public static final String Interior_InteriorHeading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[27]";
	public static final String Interior_InteriorHeadingPaintAll_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[26]";
	public static final String Interior_InteriorItemsList_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[31]";
	public static final String Interior_InteriorItemsListPaintAll_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[30]";
	public static final String Interior_InteriorPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[34]";
	public static final String Interior_InteriorPricePaintAll_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[33]";
	
	public static final String Interior_InteriorMailboxHeading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[30]";
	public static final String Interior_InteriorMailboxList_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[34]";
	public static final String Interior_InteriorMailboxPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[37]";
	
	//PostCondition
	public static final String Exterior_ExteriorButtonDownKeypad_nm = "down";
	public static final String Exterior_ExteriorButtonClearKeypad_nm = "C";
	
	
	//NEW
	//Properties page
	//My Properties
	public static final String Properties_MyProperties_ListCloudDownloadButton_nm = "ListCloudDownload";
	public static final String Properties_MyProperties_PropertiesNameTableCells_xp = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]";
	
	public static final String Group_ViewGroup_Total_xp = "//UIAApplication[1]/UIAWindow[1]/UIAButton[4]";
	
	
	//Group Page
	public static final String Groups_ViewGroups_GroupNameTableCells_xp = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]";
	public static final String Groups_ViewGroups_GroupNameHeading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[5]";
	public static final String Groups_ViewGroups_BtnAddGroup_xp = "//UIAApplication[1]/UIAWindow[1]/UIAButton[7]";
	public static final String Groups_ViewGroups_TxtBxGroupNamePopOver_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATextField[1]";
	public static final String Groups_ViewGroup_BtnAdd_nm = "Add";
	public static final String Groups_ViewGroup_BtnCancel_nm = "Cancel";
	public static final String Groups_ViewGroup_BtnEdit_nm = "Edit";
	public static final String Groups_ViewGroup_BtnMinus_xp = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[15]/UIAButton[1]";
	public static final String Groups_ViewGroup_BtnDelete_xp = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[15]/UIAButton[2]";
	public static final String Groups_ViewGroup_BtnDone_nm = "Done";
	public static final String Groups_EditGroup_TxtBxGroupName_xp = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[15]/UIATextField[1]";
	public static final String Groups_ViewGroup_BtnAddComment_nm = "CommentIcon";
	public static final String Groups_ViewGroup_CommentArea_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATextView[1]";
	public static final String Groups_ViewGroup_PaintIcon_nm = "GroupPaint";
	public static final String Groups_ViewGroup_PaintIconAdd_nm = "GroupPaintAdd";
	public static final String Groups_ViewGroup_CompassIcon_nm = "compass Icon";
	public static final String Groups_ViewGroup_CompassText_nm = "Compass";
	public static final String Groups_ViewGroup_CameraOptionsTableCells_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[2]/UIATableView[1]";
	
	//Camera Option for Group
	public static final String Groups_ViewGroup_Camera_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIAButton[5]";
	public static final String Groups_ViewGroup_CameraNew_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIAButton[6]";

	public static final String Groups_ViewGroup_CameraPlusBtn_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIAButton[3]";
	public static final String Groups_ViewGroup_CameraIcon_nm = "cameraIcon";
	public static final String Groups_ViewGroup_BtnSaveCameraPic_xp = "//UIAApplication[1]/UIAWindow[1]/UIAToolbar[1]/UIAButton[4]";
	
	//SCOPE OF WORK
	public static final String ScopeOfWork_Email_nm = "email";
	public static final String ScopeOfWork_MyProperties_nm = "My Properties";
	public static final String ScopeOfWork_SubmitForReview_nm = "Submit For Review";
	
	//GENERAL
	public static final String Groups_TableView_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]";
	
	//Service Type
	public static final String Groups_ServiceType_nm = "Service Type";
	public static final String Groups_ServiceType_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIAButton[6]";
	public static final String Groups_ServiceType_ServiceTypeTableCells_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]";
	
	//EXTERIOR GROUP
	//By name
	public static final String Groups_ViewGroups_ExteriorTitle_nm = "Exterior";
	public static final String Groups_Exterior_PressureWash_Title_nm = "Pressure Wash";
	public static final String Groups_Exterior_ExteriorPaintAll_UpArrow_nm = "UpArrow";
	public static final String Groups_Exterior_LanscapeTitle_nm = "Landscape";
	public static final String Groups_Exterior_MailBox_SKUSideArrow_nm = "arrow1";
	public static final String Groups_Exterior_MailBox_BlackHorizontalWallMount_nm = "812593";
	public static final String Groups_Exterior_MailBox_BlackTownHouseWallMount_nm = "812596";
	public static final String Groups_Exterior_MailBox_SKUDownArrow_nm = "ArrowDown";

	
	//By XPath
	public static final String Groups_Exterior_PressureWash_TextView_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextView[1]";
	public static final String Groups_Exterior_PressureWash_Comment_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]";
	public static final String Groups_Exterior_PressureWash_Price_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[1]";
	
	public static final String Groups_Exterior_ExteriorPaintAll_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[3]";
	public static final String Groups_Exterior_ExteriorPaintAll_Price_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[5]";
	
	public static final String Groups_Exterior_Landscape_TextView_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextView[7]";
	public static final String Groups_Exterior_Landscape_Price_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[11]";
	
	public static final String Groups_Exterior_MailBox_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[15]";
	
	//SCOPE OF WORK
	//By name
	public static final String ScopeOfWork_Title_nm = "Scope of Work";

	//By xpath
	public static final String ScopeOfWork_Exterior_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[17]";
	public static final String ScopeOfWork_ExteriorTitle_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[18]";
	public static final String ScopeOfWork_Exterior_PressureWash_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[22]";
	public static final String ScopeOfWork_Exterior_PressureWash_Price_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[26]";
	public static final String ScopeOfWork_Exterior_ExteriorPaintAll_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[27]";
	public static final String ScopeOfWork_Exterior_ExteriorPaintAll_Price_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[30]";
	public static final String ScopeOfWork_Exterior_LandScape_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[31]";
	public static final String ScopeOfWork_Exterior_LandScape_Price_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[34]";
	public static final String ScopeOfWork_Exterior_BlackHorizontalWallMount_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[36]";
	public static final String ScopeOfWork_Exterior_BlackHorizontalWallMount_Price_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[39]";
	public static final String ScopeOfWork_Exterior_BlackTownHouseWallMount_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[40]";
	public static final String ScopeOfWork_Exterior_BlackTownHouseWallMount_Price_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[43]";

	public static final String ScopeOfWork_Exterior_InteriorTitle_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[44]";
	public static final String ScopeOfWork_Exterior_Interior_TrimBucket_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[48]";
	public static final String ScopeOfWork_Exterior_Interior_TrimBucket_Price_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[51]";

	//INTERIOR GROUP
	//By name
	public static final String Groups_ViewGroups_InteriorTitle_nm = "Interior";
	public static final String Groups_Interior_InteriorPaint_UpArrow_nm = "UpArrow";
	public static final String Groups_Interior_PaintMaterials_SideArrow_nm = "arrow1";
	public static final String Groups_Interior_PaintMaterials_SKUPaint1_nm = "193093";
	public static final String Groups_Interior_PaintMaterials_SKUPaint2_nm = "923794";
	public static final String Groups_Interior_PaintMaterials_DownArrow_nm = "ArrowDown";
	public static final String Groups_Interior_Flooring_BtnReplaceWith_nm = "Replace With";
	
	//By xpath
	public static final String Groups_Interior_PaintMaterials_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[9]";
	public static final String Groups_Interior_InteriorPaint_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[1]";
	public static final String Groups_Interior_InteriorPaint_Price_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[3]";
	public static final String Groups_Interior_Tenant_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[12]";
	public static final String Groups_Interior_Tenant_TextView_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextView[7]";
	public static final String Groups_Interior_Tenant_TextArea_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[13]";
	
	public static final String Groups_Interior_Flooring_Width_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAToolbar[1]/UIATextField[1]";
	public static final String Groups_Interior_Flooring_Length_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAToolbar[1]/UIATextField[2]";
	public static final String Groups_Interior_Flooring_BtnCurrentFlooring_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAToolbar[1]/UIAButton[1]";
	public static final String Groups_Interior_Flooring_CurrentFlooringTableCells_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]";
	public static final String Groups_Interior_Flooring_BtnNewFlooring_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAToolbar[1]/UIAButton[4]";
	public static final String Groups_Interior_Flooring_NewFlooringTableCells_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]";
	

	//SCOPE OF WORK
	public static final String ScopeOfWork_Interior_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[17]";
	
	public static final String ScopeOfWork_Interior_Flooring_Heading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[18]";
	public static final String ScopeOfWork_Interior_Flooring_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[22]";
	public static final String ScopeOfWork_Interior_Flooring_Area_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[23]";
	public static final String ScopeOfWork_Interior_Flooring_Unit_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[24]";
	public static final String ScopeOfWork_Interior_Flooring_Price_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[25]";
	public static final String ScopeOfWork_Interior_Heading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[26]";
	
	
	//APPLIANCES GROUP
	//By name
	public static final String Groups_ViewGroups_AppliancesTitle_nm = "Appliances";
	
	
	//By xpath
	public static final String Groups_Appliances_ApplianceInstallation_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIAStaticText[2]";
	public static final String Groups_Appliances_TextView_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextView[1]";
	public static final String Groups_Appliances_TextViewComment_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]";
	public static final String Groups_Appliances_TextArea_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[1]";
	
	//SCOPE OF WORK
	public static final String ScopeOfWork_Appliances_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[17]";
	
	public static final String ScopeOfWork_Appliance_Interior_Heading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[18]";
	public static final String ScopeOfWork_Appliance_TrimBucket_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[22]";
	public static final String ScopeOfWork_Appliance_TrimBucket_Price_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[25]";
	public static final String ScopeOfWork_Appliance_ApplianceInstallation_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[30]";
	public static final String ScopeOfWork_Appliance_ApplianceInstallation_Price_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[34]";
	
	//ENTRY GROUP
	//By name
	public static final String Groups_ViewGroups_EnrtyTitle_nm = "Entry";
	public static final String Groups_Entry_ExteriorDoors_Arrow1_nm = "arrow1";
	public static final String Groups_Entry_ExteriorDoors_SKU1_nm = "776781";
	public static final String Groups_Entry_ExteriorDoors_DOwnArrow_nm = "ArrowDown";
	
	//By xpath
	public static final String Groups_Entry_ExteriorDoors_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[1]";
	public static final String Groups_Entry_ExteriorDoors_Price_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[2]";
	
	//SCOPE OF WORK
	public static final String ScopeOfWork_Entry_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[17]";
	public static final String ScopeOfWork_Entry_FlooringHeading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[18]";
	public static final String ScopeOfWork_Entry_FlooringTitle_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[22]";
	public static final String ScopeOfWork_Entry_FlooringPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[25]";
	public static final String ScopeOfWork_Entry_InteriorHeading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[26]";
	public static final String ScopeOfWork_Entry_InteriorTitle_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[30]";
	public static final String ScopeOfWork_Entry_InteriorPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[33]";
	public static final String ScopeOfWork_Entry_EntryHeading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[34]";
	public static final String ScopeOfWork_Entry_EntryTitle_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[40]";
	public static final String ScopeOfWork_Entry_EntryPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[43]";
	
	
	//LIVING ROOM GROUP
	//By name
	public static final String Groups_ViewGroups_LivingRoomTitle_nm = "Living Room";
	public static final String Groups_LivingRoom_CeilingSKU1_nm = "270614";
	
	
	
	//By xpath
	public static final String Groups_LivingRoom_CeilingFan_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[1]";
	
	public static final String Groups_MasterBedroom_BedroomLighting_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[4]";
	public static final String Groups_MasterBedroom_SKUArrow_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIAButton[16]";
	
	//SCOPE OF WORK
	public static final String ScopeOfWork_LivingRoom_InteriorPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[32]";
	public static final String ScopeOfWork_LivingRoom_LivingRoomHeading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[34]";
	public static final String ScopeOfWork_LivingRoom_LivingRoomTitle_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[40]";
	public static final String ScopeOfWork_LivingRoom_LivingRoomPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[43]";
	
	//BEDROOM GROUP
	//By name
	public static final String Groups_ViewGroups_BedRoomTitle_nm = "Bedroom 3";
	public static final String Groups_BedRoom_CeilingSKU1_nm = "270614";
	
	//By xpath
	public static final String Groups_BedroomRoom_CeilingFan_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[1]";
	public static final String Groups_BedroomRoom_AcrylicLightPanels_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[3]";
	public static final String Groups_BedroomRoom_BedroomLighting_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIAStaticText[6]";
	public static final String Groups_BedroomRoom_BedroomLighting_TextView_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextView[3]";
	public static final String Groups_BedroomRoom_BedroomLighting_TextComment_xp = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]";
	
	
	//SCOPE OF WORK
	public static final String ScopeOfWork_Bedroom_InteriorPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[33]";
	public static final String ScopeOfWork_Bedroom_Heading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[34]";
	public static final String ScopeOfWork_Bedroom_SKUPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[43]";
	public static final String ScopeOfWork_Bedroom_Acrylic_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[44]";
	public static final String ScopeOfWork_Bedroom_Acrylic_Price_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[47]";
	
	
	//FAMILY ROOM
	//By name
	public static final String Groups_ViewGroups_FamilyRoomTitle_nm = "Family Room";
	
	
	//By xpath
	public static final String Groups_FamilyRoom_CeilingFan_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[1]";
	public static final String Groups_FamilyRoom_DrywallRepair_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[9]";
	
	
	//SCOPE OF WORK
	public static final String ScopeOfWork_FamilyRoom_Heading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[26]";
	public static final String ScopeOfWork_FamilyRoom_Drywall_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[30]";
	public static final String ScopeOfWork_FamilyRoom_Drywall_Price_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[33]";
	
	//DINING ROOM GROUP
	
	//By name
	public static final String Groups_ViewGroups_DiningRoomTitle_nm = "Dining Room";
	public static final String Groups_DiningRoom_KitchenDiningSKU2_nm = "385740";
	public static final String Groups_DiningRoom_SmokeCODetectorsSKU1_nm = "182262";
	
	
	//By xpath
	public static final String Groups_DiningRoom_KitchenDining_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[1]";
	public static final String Groups_DiningRoom_SmokeCODetectors_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[3]";
	public static final String Groups_DiningRoom_DrywallRepair_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[7]";
	
	//SCOPE OF WORK
	public static final String ScopeOfWork_DiningRoom_Heading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[26]";
	public static final String ScopeOfWork_KitchenDining_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[30]";
	public static final String ScopeOfWork_KitchenDining_Price_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[33]";
	public static final String ScopeOfWork_DryWallRepair_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[34]";
	public static final String ScopeOfWork_DryWallRepair_Price_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[37]";
	
	
	//KITCHEN GROUP
	//By name
	public static final String Groups_ViewGroups_KitchenTitle_nm = "Kitchen";
	public static final String Groups_Kitchen_KitchenDiningSKU1_nm = "596148";
	
	//By xpath
	public static final String Groups_Kitchen_KitchenDining_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[1]";
	
	//SCOPE OF WORK
	public static final String ScopeOfWork_Kitchen_Heading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[26]";
	public static final String ScopeOfWork_Kitchen_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[30]";
	public static final String ScopeOfWork_Kitchen_Price_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[33]";
	
	//MASTER BEDROOM GROUP
	//By name
	public static final String Groups_ViewGroups_MasterBedroomTitle_nm = "Master Bedroom";
	public static final String Groups_ViewGroups_MasterBedroom_BedroomLighting_xp = "";
	public static final String Groups_MasterBedRoom_LightingSKU1_nm = "370830";
	
	
	//SCOPE OF WORK
	public static final String ScopeOfWork_MasterBedroom_Heading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[26]";
	public static final String ScopeOfWork_MasterBedroomCeilingFan_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[30]";
	public static final String ScopeOfWork_MasterBedroomCeilingFan_Price_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[33]";
	
	
	//MASTER BATHROOM GROUP
	
	//By name
	public static final String Groups_ViewGroups_MasterBathroomTitle_nm = "Master Bathroom";
	public static final String Groups_MasterBathroom_SKU1_nm = "588533";
	
	//By xpath
	public static final String Groups_MasterBathroom_ShowerBathWalls_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[9]";
	public static final String Groups_MasterBathroom_SKUArrow_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIAButton[32]";
	
	//SCOPE OF WORK
	public static final String ScopeOfWork_MasterBathroom_Heading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[26]";
	public static final String ScopeOfWork_MasterBathroom_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[30]";
	public static final String ScopeOfWork_MasterBathroom_Price_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[33]";
	
	
	//HALLWAYS GROUP
	
	//By name
	public static final String Groups_ViewGroups_HallwaysTitle_nm = "Hallways";
	public static final String Groups_Hallways_SKU1_nm = "370830";
	
	//By xpath
	public static final String Groups_Hallways_HallLight_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[1]";
	
	//SCOPE OF WORK
	public static final String ScopeOfWork_Hallways_Heading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[26]";
	public static final String ScopeOfWork_Hallways_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[17]";
	public static final String ScopeOfWork_Hallways_Light_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[30]";
	public static final String ScopeOfWork_Hallways_Light_Price_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[33]";
	public static final String ScopeOfWork_Hallways_Drywall_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[34]";
	public static final String ScopeOfWork_Hallways_Drywall_Price_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[37]";
	
	
	//LAUNDRY GROUP
	//By name
	public static final String Groups_ViewGroups_LaundryTitle_nm = "Laundry Room";
	public static final String Groups_Laundry_SKU1_nm = "151373";
	
	//By xpath
	public static final String Groups_Laundry_Lighting_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[1]";
	
	//SCOPE OF WORK
	public static final String ScopeOfWork_Laundry_Heading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[26]";
	public static final String ScopeOfWork_Laundry_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[17]";
	public static final String ScopeOfWork_Laundry_Light_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[30]";
	public static final String ScopeOfWork_Laundry_Light_Price_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[33]";
	public static final String ScopeOfWork_Laundry_Drywall_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[34]";
	public static final String ScopeOfWork_Laundry_Drywall_Price_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[37]";
	
	//GARAGE GROUP
	//By name
	public static final String Groups_ViewGroups_GarageTitle_nm = "Garage or Carport";
	public static final String Groups_Garage_SKU1_nm = "804417";

	//By xpath
	public static final String Groups_Garage_Door_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[7]";

	//SCOPE OF WORK
	public static final String ScopeOfWork_Garage_Heading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[26]";
	public static final String ScopeOfWork_Garage_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[17]";
	public static final String ScopeOfWork_Garage_Price_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[33]";
	

	//BASEMENT GROUP
	//By name
	public static final String Groups_ViewGroups_BasementTitle_nm = "Basement";
	
	//By xpath
	public static final String Groups_Basement_InteriorPaint_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIAScrollView[1]/UIATextField[1]";
	
	
	//Scope of Work
	public static final String ScopeOfWork_Basement_Heading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[26]";
	public static final String ScopeOfWork_Basement_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[17]";
	public static final String ScopeOfWork_Basement_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[30]";
	public static final String ScopeOfWork_Basement_Price_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[33]";
	
	//SCOPE OF WORK GENERAL
	public static final String ScopeOfWork_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[17]";
	public static final String ScopeOfWork_Heading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[26]";
	public static final String ScopeOfWork_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[30]";
	
	public static final String ScopeOfWork_QtyWithComment_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[32]";
	public static final String ScopeOfWork_UnitPriceWithComment_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[33]";
	public static final String ScopeOfWork_PriceWithComment_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[34]";
	
	
	public static final String ScopeOfWork_QtyWithNoComment_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[31]";
	public static final String ScopeOfWork_UnitPriceWithNoComment_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[32]";
	public static final String ScopeOfWork_PriceWithNoComment_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[33]";
	
	//POST CONDITIONS
	public static final String PropertyName_xp = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]";
	public static final String General_BtnDelete_nm = "Delete";
	public static final String General_BtnOk_nm = "Ok";
	
	
	//OverAll Scope Of Work
	//Budget
	//EXTERIOR GROUP
	public static final String Budget_Exterior_ExteriorHeading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[18]";
	
	//Item 1
	public static final String Budget_Exterior_ExteriorOne_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[22]";
	public static final String Budget_Exterior_ExteriorOne_Comments_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[23]";
	public static final String Budget_Exterior_ExteriorOne_Qty_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[24]";
	public static final String Budget_Exterior_ExteriorOne_UnitPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[25]";
	public static final String Budget_Exterior_ExteriorOne_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[26]";
	
	//Item 2
	public static final String Budget_Exterior_ExteriorTwo_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[27]";
	public static final String Budget_Exterior_ExteriorTwo_Comments_xp = null;
	public static final String Budget_Exterior_ExteriorTwo_Qty_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[28]";
	public static final String Budget_Exterior_ExteriorTwo_UnitPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[29]";
	public static final String Budget_Exterior_ExteriorTwo_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[30]";
	
	//Item 3
	public static final String Budget_Exterior_ExteriorThree_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[31]";
	public static final String Budget_Exterior_ExteriorThree_Comments_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[32]";
	public static final String Budget_Exterior_ExteriorThree_Qty_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[33]";
	public static final String Budget_Exterior_ExteriorThree_UnitPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[34]";
	public static final String Budget_Exterior_ExteriorThree_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[35]";
	
	//Item 4
	public static final String Budget_Exterior_ExteriorFour_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[36]";
	public static final String Budget_Exterior_ExteriorFour_Comments_xp = null;
	public static final String Budget_Exterior_ExteriorFour_Qty_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[37]";
	public static final String Budget_Exterior_ExteriorFour_UnitPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[38]";
	public static final String Budget_Exterior_ExteriorFour_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[39]";
	
	//Item 5
	public static final String Budget_Exterior_ExteriorFive_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[40]";
	public static final String Budget_Exterior_ExteriorFive_Comments_xp = null;
	public static final String Budget_Exterior_ExteriorFive_Qty_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[41]";
	public static final String Budget_Exterior_ExteriorFive_UnitPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[42]";
	public static final String Budget_Exterior_ExteriorFive_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[43]";
	
	//INTERIOR GROUP
	public static final String Budget_Interior_InteriorHeading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[44]";

	//Item 1
	public static final String Budget_Interior_InteriorOne_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[48]";
	public static final String Budget_Interior_InteriorOne_Comments_xp = null;
	public static final String Budget_Interior_InteriorOne_Qty_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[49]";
	public static final String Budget_Interior_InteriorOne_UnitPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[50]";
	public static final String Budget_Interior_Interior_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[51]";

	//Item 2
	public static final String Budget_Interior_InteriorTwo_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[52]";
	public static final String Budget_Interior_InteriorTwo_Comments_xp = null;
	public static final String Budget_Interior_InteriorTwo_Qty_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[53]";
	public static final String Budget_Interior_InteriorTwo_UnitPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[54]";
	public static final String Budget_Interior_InteriorTwo_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[55]";

	//Item 3
	public static final String Budget_Interior_InteriorThree_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[56]";
	public static final String Budget_Interior_InteriorThree_Comments_xp = null;
	public static final String Budget_Interior_InteriorThree_Qty_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[57]";
	public static final String Budget_Interior_InteriorThree_UnitPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[58]";
	public static final String Budget_Interior_InteriorThree_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[59]";
	
	//APPLIANCES GROUP
	public static final String Budget_Appliances_AppliancesHeading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[60]";

	//Item 1
	public static final String Budget_Appliances_AppliancesOne_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[64]";
	public static final String Budget_Appliances_AppliancesOne_Comments_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[65]";
	public static final String Budget_Appliances_AppliancesOne_Qty_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[66]";
	public static final String Budget_Appliances_AppliancesOne_UnitPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[67]";
	public static final String Budget_Appliances_AppliancesOne_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[68]";

	//ENTRY GROUP
	public static final String Budget_Entry_EntryHeading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[69]";

	//Item 1
	public static final String Budget_Entry_EntryOne_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[73]";
	public static final String Budget_Entry_EntryOne_Comments_xp = null;
	public static final String Budget_Entry_EntryOne_Qty_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[74]";
	public static final String Budget_Entry_EntryOne_UnitPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[75]";
	public static final String Budget_Entry_EntryOne_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[76]";

	//LIVING ROOM GROUP
	public static final String Budget_LivingRoom_LivingRoomHeading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[77]";

	//Item 1
	public static final String Budget_LivingRoom_LivingRoomOne_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[81]";
	public static final String Budget_LivingRoom_LivingRoomOne_Comments_xp = null;
	public static final String Budget_LivingRoom_LivingRoomOne_Qty_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[82]";
	public static final String Budget_LivingRoom_LivingRoomOne_UnitPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[83]";
	public static final String Budget_LivingRoom_LivingRoomOne_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[84]";

	//FAMILY ROOM GROUP
	public static final String Budget_FamilyRoom_FamilyRoomHeading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[85]";

	//Item 1
	public static final String Budget_FamilyRoom_FamilyRoomOne_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[89]";
	public static final String Budget_FamilyRoom_FamilyRoomOne_Comments_xp = null;
	public static final String Budget_FamilyRoom_FamilyRoomOne_Qty_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[90]";
	public static final String Budget_FamilyRoom_FamilyRoomOne_UnitPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[91]";
	public static final String Budget_FamilyRoom_FamilyRoomOne_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[92]";
	
	//Item 2
	public static final String Budget_FamilyRoom_FamilyRoomTwo_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[93]";
	public static final String Budget_FamilyRoom_FamilyRoomTwo_Comments_xp = null;
	public static final String Budget_FamilyRoom_FamilyRoomTwo_Qty_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[94]";
	public static final String Budget_FamilyRoom_FamilyRoomTwo_UnitPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[95]";
	public static final String Budget_FamilyRoom_FamilyRoomTwo_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[96]";

	//DINING ROOM GROUP
	public static final String Budget_DiningRoom_DiningRoomHeading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[97]";

	//Item 1
	public static final String Budget_DiningRoom_DiningRoomOne_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[101]";
	public static final String Budget_DiningRoom_DiningRoomOne_Comments_xp = null;
	public static final String Budget_DiningRoom_DiningRoomOne_Qty_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[102]";
	public static final String Budget_DiningRoom_DiningRoomOne_UnitPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[103]";
	public static final String Budget_DiningRoom_DiningRoomOne_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[104]";

	//Item 2
	public static final String Budget_DiningRoom_DiningRoomTwo_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[105]";
	public static final String Budget_DiningRoom_DiningRoomTwo_Comments_xp = null;
	public static final String Budget_DiningRoom_DiningRoomTwo_Qty_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[106]";
	public static final String Budget_DiningRoom_DiningRoomTwo_UnitPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[107]";
	public static final String Budget_DiningRoom_DiningRoomTwo_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[108]";
	
	//KITCHEN GROUP
	public static final String Budget_Kitchen_KitchenHeading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[109]";

	//Item 1
	public static final String Budget_Kitchen_KitchenOne_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[113]";
	public static final String Budget_Kitchen_KitchenOne_Comments_xp = null;
	public static final String Budget_Kitchen_KitchenOne_Qty_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[114]";
	public static final String Budget_Kitchen_KitchenOne_UnitPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[115]";
	public static final String Budget_Kitchen_KitchenOne_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[116]";
	
	//MASTER BEDROOM GROUP
	public static final String Budget_MasterBedroom_MasterBedroomHeading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[117]";

	//Item 1
	public static final String Budget_MasterBedroom_MasterBedroomOne_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[121]";
	public static final String Budget_MasterBedroom_MasterBedroomOne_Comments_xp = null;
	public static final String Budget_MasterBedroom_MasterBedroomOne_Qty_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[122]";
	public static final String Budget_MasterBedroom_MasterBedroomOne_UnitPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[123]";
	public static final String Budget_MasterBedroom_MasterBedroomOne_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[124]";

	//MASTER BATHROOM GROUP
	public static final String Budget_MasterBathroom_MasterBathroomHeading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[125]";

	//Item 1
	public static final String Budget_MasterBathroom_MasterBathroomOne_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[129]";
	public static final String Budget_MasterBathroom_MasterBathroomOne_Comments_xp = null;
	public static final String Budget_MasterBathroom_MasterBathroomOne_Qty_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[130]";
	public static final String Budget_MasterBathroom_MasterBathroomOne_UnitPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[131]";
	public static final String Budget_MasterBathroom_MasterBathroomOne_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[132]";
	
	//DINING ROOM GROUP
	public static final String Budget_Hallway_HallwayHeading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[133]";

	//Item 1
	public static final String Budget_Hallway_HallwayOne_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[137]";
	public static final String Budget_Hallway_HallwayOne_Comments_xp = null;
	public static final String Budget_Hallway_HallwayOne_Qty_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[138]";
	public static final String Budget_Hallway_HallwayOne_UnitPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[139]";
	public static final String Budget_Hallway_HallwayOne_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[140]";

	//Item 2
	public static final String Budget_Hallway_HallwayTwo_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[141]";
	public static final String Budget_Hallway_HallwaymTwo_Comments_xp = null;
	public static final String Budget_Hallway_HallwayTwo_Qty_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[142]";
	public static final String Budget_Hallway_HallwayTwo_UnitPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[143]";
	public static final String Budget_Hallway_HallwayTwo_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[144]";
	
	//LAUNDRY ROOM GROUP
	public static final String Budget_LaundryRoom_LaundryRoomHeading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[145]";

	//Item 1
	public static final String Budget_LaundryRoom_LaundryRoomOne_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[149]";
	public static final String Budget_LaundryRoom_LaundryRoomOne_Comments_xp = null;
	public static final String Budget_LaundryRoom_LaundryRoomOne_Qty_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[150]";
	public static final String Budget_LaundryRoom_LaundryRoomOne_UnitPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[151]";
	public static final String Budget_LaundryRoom_LaundryRoomOne_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[152]";

	//GARAGE OR CARPORT GROUP
	public static final String Budget_Garage_GarageHeading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[153]";

	//Item 1
	public static final String Budget_Garage_GarageOne_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[157]";
	public static final String Budget_Garage_GarageOne_Comments_xp = null;
	public static final String Budget_Garage_GarageOne_Qty_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[158]";
	public static final String Budget_Garage_GarageOne_UnitPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[159]";
	public static final String Budget_Garage_GarageOne_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[160]";

	//BASEMENT GROUP
	public static final String Budget_Basement_BasementHeading_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[161]";

	// Item 1
	public static final String Budget_Basement_BasementOne_Title_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[165]";
	public static final String Budget_Basement_BasementOne_Comments_xp = null;
	public static final String Budget_Basement_BasementOne_Qty_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[166]";
	public static final String Budget_Basement_BasementOne_UnitPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[167]";
	public static final String Budget_Basement_BasementOne_TotalPrice_xp = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[168]";

}
