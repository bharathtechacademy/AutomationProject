package com.application.steps;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.application.elements.RegistrationPageElements;
import com.framework.base.Reports;
import com.framework.utilities.ReadDB;

public class RegistrationPageSteps extends RegistrationPageElements{	
	
	public RegistrationPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}		

	public void verifyRegistrationPageIsLaunched() {
		waitForElement(regPageHeaderLoc,10);
		Reports.logger.pass("Registration Page is Launched Successfully");
	}
	
	public void updateRegistrationDetails() {
		Map<String,String> data = ReadDB.readData("Select * from verifyNewRegistration").get(0);	
		enterInfo(firstName,data.get("firstname"));
		enterInfo(lastName,data.get("lastname"));
		enterInfo(address,data.get("address"));
		enterInfo(city,data.get("city"));
		enterInfo(state,data.get("state"));
		enterInfo(zip,data.get("zip"));
		enterInfo(phone,data.get("phone"));
		enterInfo(ssn,data.get("ssn"));
		enterInfo(usernameTxtb,data.get("username"));
		enterInfo(passwordTxtb,data.get("password"));
		enterInfo(confirmPasswordTxtb,data.get("password"));
		Reports.logger.pass("Registration details updated");
	}
	
	public void completeRegistration() {
		click(registerBtn);
		Reports.logger.pass("Clicked on Register button");
	}
	
	public void verifyRegistrationIsSuccessful() {
		waitForElement(accountServices,10);
		Reports.logger.pass("Registration is Successfully completed");
	}

}
