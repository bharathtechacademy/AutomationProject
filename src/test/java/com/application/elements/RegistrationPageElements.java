package com.application.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.commons.WebCommons;

public class RegistrationPageElements extends WebCommons {
	
	protected By regPageHeaderLoc = By.xpath("//h1[text()='Signing up is easy!']");
	
	@FindBy(xpath="//h1[text()='Signing up is easy!']")
	protected WebElement regPageHeader;
	
	@FindBy(xpath="//input[@name='customer.firstName']")
	protected WebElement firstName;
	
	@FindBy(xpath="//input[@name='customer.lastName']")
	protected WebElement lastName;
	
	@FindBy(xpath="//input[@name='customer.address.street']")
	protected WebElement address;
	
	@FindBy(xpath="//input[@name='customer.address.city']")
	protected WebElement city;
	
	@FindBy(xpath="//input[@name='customer.address.state']")
	protected WebElement state;
	
	@FindBy(xpath="//input[@name='customer.address.zipCode']")
	protected WebElement zip;
	
	@FindBy(xpath="//input[@name='customer.phoneNumber']")
	protected WebElement phone;
	
	@FindBy(xpath="//input[@name='customer.ssn']")
	protected WebElement ssn;
	
	@FindBy(xpath="//input[@name='customer.username']")
	protected WebElement usernameTxtb;
	
	@FindBy(xpath="//input[@name='customer.password']")
	protected WebElement passwordTxtb;
	
	@FindBy(xpath="//input[@name='repeatedPassword']")
	protected WebElement confirmPasswordTxtb;
	
	@FindBy(xpath="//input[@value='Register']")
	protected WebElement registerBtn;
	
	protected By accountServices = By.xpath("//h2[text()='Account Services']");
	
}
