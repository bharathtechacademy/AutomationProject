package com.framework.listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.framework.base.BasePage;
import com.framework.base.Reports;
import com.framework.commons.WebCommons;

public class TestListeners extends Reports implements ITestListener {

	public void onTestStart(ITestResult result) {
		startReporting(result.getMethod().getMethodName());
		logger.info("Test Execution Started for the testcase "+result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		logger.pass("Test Execution Successfully completed for the testcase "+result.getMethod().getMethodName());
		stopReporting();
	}

	public void onTestFailure(ITestResult result) {
		logger.fail("Test Execution is failed for the testcase "+result.getMethod().getMethodName());
		logger.fail("Test Execution failed due to "+result.getThrowable().getMessage());
		try {
			logger.addScreenCaptureFromPath(new WebCommons().takeWindowScreenshot(new BasePage().getDriver(), result.getMethod().getMethodName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		stopReporting();
	}
	
	public void onTestSkip(ITestResult result) {
		logger.fail("Test Execution is skipped for the testcase "+result.getMethod().getMethodName());
		logger.fail("Test Execution skipped due to "+result.getThrowable().getMessage());
		try {
			logger.addScreenCaptureFromPath(new WebCommons().takeWindowScreenshot(new BasePage().getDriver(), result.getMethod().getMethodName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		stopReporting();
	}

}
