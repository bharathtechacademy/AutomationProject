package com.framework.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.framework.base.Reports;

public class ApiListeners extends Reports implements ITestListener{
	
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
		stopReporting();
	}
	
	public void onTestSkip(ITestResult result) {
		logger.fail("Test Execution is skipped for the testcase "+result.getMethod().getMethodName());
		logger.fail("Test Execution skipped due to "+result.getThrowable().getMessage());	
		stopReporting();
	}

}
