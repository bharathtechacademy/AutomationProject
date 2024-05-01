package com.application.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.commons.WebCommons;

public class LoginPageElements extends WebCommons{
	
	@FindBy(xpath="//img[@class='logo']")
	protected WebElement logo;
	
	@FindBy(xpath="//p[@class='caption']")
	protected WebElement caption;
	
	@FindBy(xpath="//h2")
	protected WebElement loginPageHeader;
	
	@FindBy(xpath="//input[@name='username']")
	protected WebElement usernameTxtb;
	
	@FindBy(xpath="//input[@name='password']")
	protected WebElement passwordTxtb;
	
	@FindBy(xpath="//input[@type='submit']")
	protected WebElement loginBtn;
	
	@FindBy(linkText="Forgot login info?")
	protected WebElement forgotLoginLink;
	
	@FindBy(xpath="//a[text()='Register']")
	protected WebElement registrationLink;
	
	protected By accountOverviewPageHeader = By.xpath("//h2[text()='Account Services']");

}
