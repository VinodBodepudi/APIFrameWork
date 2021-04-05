/****
 * This is the TestSuite Base for Company Setup configuration.
 * This Class extends the Test Base Class
 * Class has Before & After Suite method to connect/Disconnect Database
 * Class has Before Suite method to get Company setup jersey Client.
 * This is a must file for Company setup testNg script to execute & should not be deleted.
 */
package com.atmecs.test.testsuite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 *	SampletestSuiteBase class holds the services common for all the
 * 	scripts in the suite
 */
public class SampleTestSuiteBase {


	@BeforeSuite
	public void preSetup() {
		// USE THIS METHOD TO WRITE PRESETUP OPERATIONS IF ANY TO DO BEFORE
		// SUITE RUNS
	}

	@AfterSuite
	public void teardown() {
		// USE THIS METHOD TO WRITE OPERATIONS IF ANY TO DO AFTER SUITE
	}

}