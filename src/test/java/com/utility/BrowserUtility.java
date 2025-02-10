package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public abstract class BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {
		return driver.get();// used in myAccountLogin 
	}

	public void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}

	public BrowserUtility(WebDriver driver) {// If we create more constructors then its the code is more elegent.
		super();
		this.driver.set(driver);// Initialize the instance of variable driver!!
	}

	public BrowserUtility(Browser browserName) {
		logger.info("Launching Browser for" + browserName);
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
		} else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
		} else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		} else {
			logger.error("Invaild Browser Name..... please sekect Chrome or Edge or Firefox");
			System.err.println("Invaild Browser Name..... please sekect Chrome or Edge or Firefox");
		}

	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching Browser for" + browserName);
		if (browserName == Browser.CHROME) {
			if (isHeadless) {

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless"); // headless
				//options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
			} else {
				driver.set(new ChromeDriver());
			}
		} else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old"); // headless
				options.addArguments("disable -gpu");
				driver.set(new EdgeDriver(options));

			} else {
				driver.set(new EdgeDriver());
			}

		} else if (browserName == Browser.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old"); // headless

				driver.set(new FirefoxDriver(options));
			} else {

				driver.set(new FirefoxDriver());
			}
		} else {
			logger.error("Invaild Browser Name..... please sekect Chrome or Edge or Firefox");
			System.err.println("Invaild Browser Name..... please sekect Chrome or Edge or Firefox");
		}
	}

	public void goToWebsite(String url) {
		logger.info("Visiting the website" + url);
		driver.get().get(url);

	}

	public void maximizeWindow() {
		logger.info("Maximizing the broswe Window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding Element with the locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now performing Click" + locator);
		element.click();

	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding Element with the locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now enter the text" + textToEnter);
		element.sendKeys(textToEnter);
	}

	public String getVisibleText(By locator) {
		logger.info("Finding Element with the locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and returing the visibleText" + element.getText());
		return element.getText();

	}

	public static void highlightElement(WebDriver driver, String emailAdress) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Change the element's style to highlight it
		js.executeScript("arguments[0].style.border='2px solid green'", emailAdress);
	}

	public String takeScreenShort(String name) {
		TakesScreenshot screenshort = (TakesScreenshot) driver.get();
		File screenShortData = screenshort.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = (System.getProperty("user.dir") + "//screenshorts//" + name + "-" + timeStamp + ".png");
		File screenshortFile = new File(path);
		try {
			FileUtils.copyFile(screenShortData, screenshortFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

}
