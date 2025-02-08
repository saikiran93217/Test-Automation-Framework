package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public class TestBase {
	//It is the parent of all tests classes
	protected HomePage homepage;
	//It will access it in only child classes
	Logger logger = LoggerUtility.getLogger(this.getClass());

	@BeforeMethod(description = "Load the homepage of the website")
	public void setup() {
		logger.info("Load the HomePage of the website");
		homepage = new HomePage(CHROME, true);// (Browser.CHROME) when there is no static in import and it is a local
										// variable

	}
	//When we are returning something it should always parent Class
	public BrowserUtility getInstance() {
		return homepage;
	}
}
