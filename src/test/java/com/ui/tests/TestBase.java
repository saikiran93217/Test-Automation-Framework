package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaUtility;
import com.utility.LoggerUtility;

public class TestBase {
	// It is the parent of all tests classes
	protected HomePage homepage;
	// It will access it in only child classes
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest;
	

	
	@Parameters({"browser","isLambdaTest","isHeadless"})//we can use it in terminal by using parameters.
	@BeforeMethod(description = "Load the homepage of the website")
	//Below parameters are taken from the above @parameters({"browser", "isLambdaTest"}) this are all local variable
	public void setup(
			
			@Optional("chrome") String browser, 
			@Optional("false") boolean isLambdaTest,
			@Optional("true") boolean isHeadless, ITestResult result) {
		//We write it because if we want to run the only this particular test we use optional or if we want to run all test we no requires optional instead we can run in xml.file
		
		this.isLambdaTest = isLambdaTest;//local variable that is assign to the instance variable "this.isLambdaTest"
		WebDriver lambdaDriver;

		if (isLambdaTest) {
			lambdaDriver = LambdaUtility.inializeLambaTestSession(browser, result.getMethod().getMethodName());
			homepage = new HomePage(lambdaDriver);

		} else {
			// Running the test on local machine
			logger.info("Load the HomePage of the website");
			//homepage = new HomePage(Browser.valueOf(browser), isHeadless);
			homepage = new HomePage(Browser.CHROME, isHeadless);
			// (Browser.CHROME) when there is no static in import
			// and it is a local variable
			// it will call the parent class like browserutility
		}
	}

	// When we are returning something it should always parent Class
	public BrowserUtility getInstance() {
		return homepage;
	}

	@AfterMethod(description = "Tear Down the browser")
	public void tearDown() {
		if(isLambdaTest) {
			LambdaUtility.quitSession();//Quit or close the browser session on LT
		}else {
			homepage.quit();//Close in local machine
		}
		
	}
}

//XML file:
//It will run on local machine
		//because it is false
		//It should run on headless mode on local machine and it should run on chrome
		//browser cause it is true