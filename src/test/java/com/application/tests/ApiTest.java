package com.application.tests;

import org.testng.annotations.Test;

import com.api.pages.ApiPage;
import com.framework.commons.ApiCommons;

import io.restassured.response.Response;

public class ApiTest extends ApiCommons{
	
	
	@Test (priority=1)
	public void verifyCreateRepoRequest() {
		Response response = getResponse("POST", "/user/repos", ApiPage.createRepoRequestBody);
		verifyStatusCode(response, 201);
		verifyStatusMesage(response, "Created");
		verifyResponseTime(response, 2000);
		verifyResponseBody(response, "name", "TestProjectFromRestAssured");
		verifyResponseBody(response, "description", "Sample Project to test API");
		verifyResponseBody(response, "private", true);
	}
	
	@Test (priority=2)
	public void verifyGetRepoRequest() {
		Response response = getResponse("GET", "/repos/bharathtechacademy/TestProjectFromRestAssured", "");
		verifyStatusCode(response, 200);
		verifyStatusMesage(response, "OK");
		verifyResponseTime(response, 2000);	
		verifyResponseBody(response, "name", "TestProjectFromRestAssured");
		verifyResponseBody(response, "description", "Sample Project to test API");
		verifyResponseBody(response, "private", true);
	}
	
	@Test (priority=3)
	public void verifyDeleteRepoRequest() {
		Response response = getResponse("DELETE", "/repos/bharathtechacademy/TestProjectFromRestAssured", "");
		verifyStatusCode(response, 204);
		verifyStatusMesage(response, "No Content");
		verifyResponseTime(response, 2000);	
	}

}
