package com.framework.commons;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.base.BasePage;
import com.framework.utilities.ReadProp;

public class WebCommons {
	
	//This class will have all common methods to perform different actions on web application
	
	public WebDriver driver = new BasePage().getDriver();
	public Properties prop = ReadProp.readData("Config.properties");
	
	//method to launch the application
	public void launchApplication() {
		driver.get(prop.getProperty("url"));
		Assert.assertEquals(driver.getTitle(), prop.getProperty("title"));
	}
	
	//click on element
	public void click(WebElement element) {
		element.click();
	}
	
	//Scroll to element
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	//enter information in textbox
	public void enterInfo(WebElement element, String value) {
		scrollToElement(element);
		element.clear();
		element.sendKeys(value);
	}
	
	//method to check checkbox
	public void selectCheckbox(WebElement element) {
		scrollToElement(element);
		if(!element.isSelected())
			element.click();
	}
	
	//method to select option from dropdown
	
	
	//method to wait (java wait)
	public void wait (int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//implicit wait
	public void implicitWait(int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	//explicit wait
	public void waitForElement(By locator, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
	}
	
	//method to take screenshot of window
		public static String takeWindowScreenshot(WebDriver driver,String name) throws IOException {
			String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + name + ".jpeg";
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File(screenshotPath));
			return screenshotPath;
		}
		
		//method to take screenshot of element
		public static String takeElementScreenshot(WebElement element,String name) throws IOException {
			String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + name + ".jpeg";
			File screenshotFile = element.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File(screenshotPath));
			return screenshotPath;
		}
		
		//method to get text from element
		public String getText(WebElement element) {
			return element.getText();
		}
		
		//method to get title 
		public String getTitle() {
			return driver.getTitle();
		}
		
		//method to check is element displayed 
		public boolean isDisplayed(WebElement element) {
			return element.isDisplayed();
		}
	

}
