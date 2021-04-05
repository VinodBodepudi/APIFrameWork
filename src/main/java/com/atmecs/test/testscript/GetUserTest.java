package com.atmecs.test.testscript;


import java.util.List;

import org.testng.annotations.Test;


import com.atmecs.falcon.automation.rest.endpoint.RequestBuilder;
import com.atmecs.falcon.automation.rest.endpoint.ResponseOptions;
import com.atmecs.falcon.automation.rest.endpoint.ResponseService;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.falcon.automation.verifyresult.VerificationManager;

import com.atmecs.test.testsuite.SampleTestSuiteBase;

/**
 * 
 *         GetUserTest class is to test the services using End point.
 * 
 *         Sample TestSuiteBase is extended. The common functions required for
 *         all the scripts under this suite to be defined in the TestSuiteBase.
 * 
 */
public class GetUserTest extends SampleTestSuiteBase {
	
	private ReportLogService report = new ReportLogServiceImpl(GetUserTest.class);
	
	@Test
	public void testGetUser() {
		String apiUrl = "https://reqres.in/api/users/540";
		
		report.info("Preparing a request");
		RequestBuilder builder = new RequestBuilder();
		ResponseOptions responseOptions = builder.build();

		report.info("Making GET API call to get single user");
		ResponseService responseService = responseOptions.get(apiUrl);
		
		int statusCode = responseService.getStatusCode();
		VerificationManager.verifyInteger(statusCode, 200, "Verify Status code");
		
		
//		String firstName = responseService.getJsonPath().get("data.first_name");
//		String lastName = responseService.getJsonPath().get("data.last_name");
		
		List<String> firstNameList = responseService.getJsonPath().get("data.first_name");
		List<String> lirstNameList = responseService.getJsonPath().get("data.last_name");
		
		for(String abbc:firstNameList) {
			System.out.println(abbc);
		}
//		VerificationManager.verifyString(firstName, "Janet", "Verify firstname of user");
//		VerificationManager.verifyString(lastName, "Weaver", "Verify lastname of user");

	}
	
}
