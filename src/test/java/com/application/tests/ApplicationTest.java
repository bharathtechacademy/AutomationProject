package com.application.tests;

import org.testng.annotations.Test;

import com.framework.base.BaseTest;

public class ApplicationTest extends BaseTest {

	@Test(priority=1)
	public void verifyApplicationLogo() {
		loginPage.launchApplication();
		loginPage.verifyLogo();
	}
	
	@Test(priority=2)
	public void verifyApplicationCaption() {
		loginPage.launchApplication();
		loginPage.verifyCaption();
	}
	
	@Test(priority=3)
	public void verifyLoginPageHeader() {
		loginPage.launchApplication();
		loginPage.verifyLoginHeader();
	}
	
	@Test(priority=4)
	public void verifyNewRegistration() {
		loginPage.launchApplication();
		loginPage.navigateToRegistrationPage();
		registrationPage.verifyRegistrationPageIsLaunched();
		registrationPage.updateRegistrationDetails();
		registrationPage.completeRegistration();
		registrationPage.verifyRegistrationIsSuccessful();
	}

	@Test(dataProvider="testdata",priority=5)
	public void verifyLoginIsSuccessful(String username,String password) {
		loginPage.launchApplication();
		loginPage.enterCredentials(username, password);
		loginPage.clickOnLogInButton();
		loginPage.verifyLoginIsSuccessful();
	}
	
	@Test(dataProvider="testdata",priority=6)
	public void verifyFundTransferFeature(String username,String password,String amount) {
		loginPage.launchApplication();
		loginPage.enterCredentials(username, password);
		loginPage.clickOnLogInButton();
		loginPage.verifyLoginIsSuccessful();
		homePage.navigateToFundTransferPage();
		homePage.transferTheFunds(amount);
		homePage.verifyAmountTransferIsSuccessful();
	}

}
