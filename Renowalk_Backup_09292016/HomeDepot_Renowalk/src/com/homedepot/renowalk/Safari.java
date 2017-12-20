package com.homedepot.renowalk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.homedepot.renowalk.ObjectRepository.RenowalkModules;

public class Safari {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.safari.noinstall", "true");
		  driver = new SafariDriver();
		
		try {
			  WebDriverWait wait = new WebDriverWait(driver,20);
			  driver.manage().window().maximize();
			  driver.get("https://webapps-qa.homedepot.com/RenoWalk/#/renoWalk");
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));	
			  driver.findElement(By.id("username")).sendKeys("test");
			  driver.findElement(By.id("password")).sendKeys("test");
			  driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/input")).click();
			  Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
		//  driver.quit();
		}
	}

}
