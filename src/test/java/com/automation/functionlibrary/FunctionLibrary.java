package com.automation.functionlibrary;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FunctionLibrary {
	
	public WebDriver driver = null;
	
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("User.dir")+"//src//test//java//com//automation//drivers//chromedriver.exe");
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
	
	public void linksOnPage(){
		if(driver != null){
			try{
				String homeWindow = driver.getWindowHandle();
				String part1 = "html/body/table[2]/tbody/tr/td/table/tbody/tr/td[2]/div[4]/div[";
				String part2 = "]/a";
				for(int i = 1; i <= 10; i++){
					driver.findElement(By.xpath(part1+i+part2)).click();
					sleep(2000);
					driver.switchTo().window(homeWindow);
				}
			}catch(Exception E){
				System.out.println(E.getMessage());
			}
		}
	}
}
