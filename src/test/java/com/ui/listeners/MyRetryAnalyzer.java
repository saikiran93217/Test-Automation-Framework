package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer {

	//Properties file
	private static final int MAX_NUMBER_OF_ATTEMPTS = Integer.parseInt(PropertiesUtil.readproperty(Env.QA, "MAX_NUMBER_OF_ATTEMPTS"));
	
	//JSON file
	//private static final int MAX_NUMBER_OF_ATTEMPTS = JSONUtility.readJson(Env.QA).getMAX_NUMBER_OF_ATTEMPTS();
	private static int currentAttempt = 1;

	@Override
	public boolean retry(ITestResult result) {
		if (currentAttempt <= MAX_NUMBER_OF_ATTEMPTS) {
			currentAttempt++;
			return true;
		}
		return false;
	}

}

// MyRetryAnalyer: It will call when the test is failing ex: if we have 10 tests
// 2 are failed the MyRetryAnalyzer will be executed
// ITestResult : It will give information about test
// If retry method returns true- go head re-run the failed test
// If retry method returns false - testNG will mark the test as failed
//We can run the with failed test case with retryanalayzer or in project we will find test-failed suite we can run it as well using jenkins.
//1<=3(true),2<=3(true), 3<=3(true)4<=3(false) return false.