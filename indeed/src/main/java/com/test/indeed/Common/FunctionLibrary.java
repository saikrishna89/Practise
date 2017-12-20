package com.test.indeed.Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.test.indeed.ConfigManager.FileLocSetter;

public class FunctionLibrary {
	
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", FileLocSetter.sProjectPath+"chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("www.google.com");
		driver.manage().window().maximize();
	}	
}
