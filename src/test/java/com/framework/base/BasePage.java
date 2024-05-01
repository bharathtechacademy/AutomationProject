package com.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BasePage extends Reports {

	// This class will have all methods related to browser

	private static WebDriver driver = null;

	//method to launch the browser
	@BeforeMethod(alwaysRun = true)
	@Parameters(value = "browser")
	public void launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else if (browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	//method to close browser window
	@AfterMethod(alwaysRun=true)
	public void tearDownBrowser() {
		driver.quit();
	}
	
	//method to share driver value with other classes
	public WebDriver getDriver() {
		return driver;
	}
	

}
