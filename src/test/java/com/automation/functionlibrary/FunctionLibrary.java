package com.automation.functionlibrary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.automation.objectrepository.ObjectRepository;

public class FunctionLibrary {
	
	public WebDriver driver = null;
	
	ObjectRepository OR = new ObjectRepository();
	
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Elite\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.indeed.com/");
	}
	
	public WebElement findElementById(String Id){
		WebElement ele = null;
		if(driver != null){
			try{
				ele = driver.findElement(By.id(Id));
			}catch(Exception E){
				System.out.println(E.getMessage());
			}
		}
		return ele;
		}
	
	public WebElement findElementByLink(String LinkText){
		WebElement ele = null;
		if(driver != null){
			try{
				ele = driver.findElement(By.linkText(LinkText));
			}catch(Exception E){
				System.out.println(E.getMessage());
			}
		}
		return ele;
		}
	
	public void sleep(int seconds){
		if(driver != null){
			try{
				Thread.sleep(seconds);
			}catch(Exception E){
				System.out.println(E.getMessage());
			}
		}
	}
	
	public void selectValuesDynamicDropDown(WebElement ele, String selectValue){
		if(driver != null){
			try{
				Select sel = new Select(ele);
				List<WebElement> dropDownOptions = sel.getOptions();
				Iterator<WebElement> ite = dropDownOptions.iterator();
				while(ite.hasNext()){
					String value = ite.next().toString();
					if(value.equalsIgnoreCase(selectValue)){
						sel.selectByVisibleText(selectValue);
					}
				}
			}catch(Exception E){
				System.out.println(E.getMessage());
			}
		}
	}
	
	public void clearFields(WebElement ele){
		if(driver != null){
			try{
				ele.clear();
			}catch(Exception E){
				System.out.println(E.getMessage());
			}
		}
	}
	
	public boolean isElementPresent(WebElement ele){
		boolean result = false;
		if(driver != null){
			try{
				result = ele.isDisplayed();
			}catch(Exception E){
				System.out.println(E.getMessage());
			}
		}
		return result;
	}
	
	public void actionsClass(){
		if(driver != null){
			try{
				Actions act = new Actions(driver);
				act.sendKeys(Keys.ESCAPE).build().perform();
			}catch(Exception E){
				System.out.println(E.getMessage());
			}
		}
	}
	
	@SuppressWarnings("static-access")
	public void linksOnPage(){
		if(driver != null){
			try{
		//		String homeWindow = driver.getWindowHandle();
				String part1 = "html/body/table[2]/tbody/tr/td/table/tbody/tr/td[2]/div[";
				String part2 = "]/h2/a";	
				List<String> setting = new ArrayList<>();;
				for(int i = 5; i <= 12; i++){
					setting.add(part1+i+part2);
				}  
				Iterator<String> ite = setting.iterator();
				while(ite.hasNext()){
					String nextLink = ite.next();
					if(isElementPresent(driver.findElement(By.xpath(nextLink)))){
					driver.findElement(By.xpath(nextLink)).click();
					sleep(2000);
					driver.findElement(By.linkText(OR.ApplyNow_LinkText)).click();
					sleep(2000);
				//	driver.switchTo().window(homeWindow);
					}
				}
			}catch(Exception E){
				System.out.println(E.getMessage());
			}
		}
	}
}
