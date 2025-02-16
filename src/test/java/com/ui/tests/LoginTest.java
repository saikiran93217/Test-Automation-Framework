package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;
import com.ui.pojo.Users;
import com.utility.LoggerUtility;

@Listeners({ com.ui.listeners.TestListener.class })
public class LoginTest extends TestBase {

	
	Logger logger = LoggerUtility.getLogger(this.getClass());

	
	@Test(description = "Verify with the vaild user is able to login into the application", groups = { "e2e",
	"Sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LogintestDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
public void loginTest(Users user)  {

assertEquals(homepage.goLoginPage().dologinwith(user.getEmailAddress(), user.getPassword()).getUserName(),
		"Sai Kiran");

}
	@Test(description = "Verify with the vaild user is able to login into the application", groups = { "e2e",
	"Sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LogintestCSVDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
public void LoginCSVTest(Users user)  {

assertEquals(homepage.goLoginPage().dologinwith(user.getEmailAddress(), user.getPassword()).getUserName(),
		"Sai Kiran");

}

	@Test(description = "Verify with the vaild user is able to login into the application", groups = { "e2e",
			"Sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void LoginExcelTest(Users user)  {
		
		assertEquals(homepage.goLoginPage().dologinwith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Sai Kiran2");

	}

}
