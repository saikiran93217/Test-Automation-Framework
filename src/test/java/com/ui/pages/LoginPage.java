package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class LoginPage extends BrowserUtility {
	
	
	private static final By EMAIL_ENTER_TEXT_LOCATOR = By.id("email");
	private static final By PASSWORD_ENTER_TEXT_LOCATOR= By.id("passwd");
	private static final By SUBMIT_LOGIN_BUTTON_LOCATOR =By.id("SubmitLogin");

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	public MyAccountPage dologinwith(String emailAdress, String password) {

		enterText(EMAIL_ENTER_TEXT_LOCATOR, emailAdress);
		enterText(PASSWORD_ENTER_TEXT_LOCATOR, password);
		clickOn(SUBMIT_LOGIN_BUTTON_LOCATOR);
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		return myAccountPage;
		
	}
}
