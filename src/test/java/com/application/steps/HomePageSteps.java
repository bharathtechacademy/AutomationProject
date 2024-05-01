package com.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.application.elements.HomePageElements;
import com.framework.base.Reports;

public class HomePageSteps extends HomePageElements{
	
	public HomePageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToFundTransferPage() {
		click(transferFundsLink);
		waitForElement(transferFundsPageHeader,10);
		Reports.logger.pass("Navigated to fund transfer page");
	}
	
	public void transferTheFunds(String amount) {
		enterInfo(amountTxtb, amount);
		click(transferButton);
		Reports.logger.pass("Updated the amount and clicked on transfer button");
	}
	
	public void verifyAmountTransferIsSuccessful() {
		waitForElement(transferSuccessMsg,10);
		Reports.logger.pass("Fund transfer is successful");
	}
}
