package com.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.application.elements.LoginPageElements;
import com.framework.base.Reports;

public class LoginPageSteps extends LoginPageElements {
	
	public LoginPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void verifyLogo() {
		Assert.assertTrue(isDisplayed(logo));
		Reports.logger.pass("Application logo displayed successfully");
	}

	public void verifyCaption() {
		Assert.assertEquals(getText(caption), prop.getProperty("caption"));
		Reports.logger.pass("Application caption displayed correctly");
	}

	public void verifyLoginHeader() {
		Assert.assertEquals(getText(loginPageHeader), prop.getProperty("header"));
		Reports.logger.pass("Application login page header displayed correctly");
	}

	public void enterCredentials(String username, String password) {
		enterInfo(usernameTxtb, username);
		enterInfo(passwordTxtb, password);
		Reports.logger.pass("Credentials entered are " + username + " , " + password);
	}

	public void clickOnLogInButton() {
		click(loginBtn);
		Reports.logger.pass("Clicked on Login button");
	}

	public void verifyLoginIsSuccessful() {
		waitForElement(accountOverviewPageHeader, 10);
		Reports.logger.pass("Account overview page is displayed");
	}
	
	
	public void navigateToRegistrationPage() {
		click(registrationLink);
		Reports.logger.pass("Clicked on Registration link");
	}
	

}
