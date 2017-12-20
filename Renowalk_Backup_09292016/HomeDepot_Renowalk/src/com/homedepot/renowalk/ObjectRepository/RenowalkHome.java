package com.homedepot.renowalk.ObjectRepository;

public class RenowalkHome {
	

	
	////////////////////////////////////////Renowalk Login/Home Page Objects////////////////////////////////////////////////////
		
	//By Id
	public static final String Main_InputUserId_id = "username";						//Username
	public static final String Main_InputPassword_id = "password";						//Password
	public static final String Main_BtnSignIn_id = "submit_form";                       //Login Button	

	
	public static final String Main_MsgSignInError_id = "InfoMessage";     
	public static final String Main_BtnSignInError_id = "InfoOK";     
	
	
	//By Name
	public static final String Main_TitleRenowalkPage_nm = "The Home Depot Mobile Application";  //Window title of Renowalk login page
	
	//By Xpath
	//public static final String Main_labelHomePageWelcome_xp =  "/html/body/div[2]/div[3]/div[2]/div[4]/div[1]/h1";
	public static final String Main_labelHomePageWelcome_xp =  "//h2[@id='pageTitle' and text()='Welcome to RenoWalk!']";
	
	//<a ui-sref="login" href="#/login">Logout</a>
	//public static final String Main_LogoutLink_xp =  "/html/body/div[2]/div[2]/div/div/a[3]";
	public static final String Main_LogoutLink_xp =  "//a[@ui-sref='login' and @href='#/login' and text()='Logout']";
	
	public static final String Main_BtnSignIn_xp = "//input[@type='submit' and @value='LOGIN']";                       //Login Button
	
	
	//By Tag Name

	
}
