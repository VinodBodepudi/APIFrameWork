package com.atmecs.test.testscript;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class PostUserTest extends SampleTestSuiteBase {
	
	private ReportLogService report = new ReportLogServiceImpl(PostUserTest.class);
	
	@Test
	public void testGetUser() {
		String apiUrl = "https://reqres.in/api/users";
		
		report.info("Preparing a request");
		RequestBuilder builder = new RequestBuilder();
//		ResponseOptions responseOptions = builder.build();
		
		Map<String,String> reqbody=new HashMap<String, String>();
		reqbody.put("name", "riyaan02");
		reqbody.put("job", "sportsman");
		report.info("Making POST API call to get single user");
		ResponseService responseService = builder.body(reqbody).build().post(apiUrl);
		
		int statusCode = responseService.getStatusCode();
		VerificationManager.verifyInteger(statusCode, 201, "Verify Status code");
		System.out.println(responseService.getResponseBody());
		
		String firstName = responseService.getJsonPath().get("name");
		String job = responseService.getJsonPath().get("job");
		
		VerificationManager.verifyString(firstName, "riyaan01", "Verify firstname of user");
		VerificationManager.verifyString(job, "sportsman", "Verify lastname of user");

	}
	
}
