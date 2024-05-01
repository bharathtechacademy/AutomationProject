package com.application.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.commons.WebCommons;

public class HomePageElements extends WebCommons {
	
	@FindBy(xpath="//a[text()='Transfer Funds']")
	protected WebElement transferFundsLink;
	
	protected By transferFundsPageHeader = By.xpath("//h1[text()='Transfer Funds']");

	@FindBy(xpath="//input[@id='amount']")
	protected WebElement amountTxtb;
	
	@FindBy(xpath="//input[@value='Transfer']")
	protected WebElement transferButton;
	
	protected By transferSuccessMsg = By.xpath("//h1[text()='Transfer Complete!']");

}
