package com.framework.base;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports {
	
	//This class will have all the methods to setup report and print test results
	
	public static ExtentHtmlReporter html = null; //it will generate empty html report	(paper)
	public static ExtentReports extent = null; //it will print the messages in the report (printer)
	public static ExtentTest logger = null; //print messages with different colors (ink)
	
	@BeforeSuite(alwaysRun=true)
	public static void setupReport() {
		 html = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\TestReport.html"); //generate empty html report
		 extent = new ExtentReports();
		 extent.attachReporter(html);//insert report to start printing
		 extent.setSystemInfo("Project Name", "Parabank");
	}
	
	public static void startReporting(String testcase) {
		logger = extent.createTest(testcase);//start printing process for specific test
	}	
	
	public static void stopReporting() {
		extent.flush();
	}

}
