package com.ui.pages;



import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;

import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

import static com.utility.PropertiesUtil.*;

public class HomePage extends BrowserUtility{
	//we have mention browserUtility class as "Abstract" so we can not create objects for browserUility class instead 
	//we use "Inheritance concept by extends keyword and calling parent constructor
	Logger logger= LoggerUtility.getLogger(this.getClass());
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(), \"Sign in\")]");
	
	
	public HomePage(Browser browserName, boolean isheadless) {
		super(browserName, isheadless);
		//To call the parent class constructor from the child constructor with the help of super keyword.
		//Abstract class can have constructor and that constructor can be called when you create a object of child class
		//So the constructor of child class can called the parent class by using Super() keyword.
		
		maximizeWindow();
		goToWebsite(JSONUtility.readJson(QA).getUrl());
		//goToWebsite(readproperty(QA, "URL"));
	}
	

	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JSONUtility.readJson(QA).getUrl());
	}


	public LoginPage goLoginPage()  {//Page functions-->In page function we cannot use void type
		logger.info("Trying to performing click to go to sign in Page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		
		LoginPage loginPage = new LoginPage(getDriver());
		//Here it needs driver, and we created object because once Home page session is completed to give to the
		//login page and other page....
		return loginPage;
		
	}


	public void quit() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
