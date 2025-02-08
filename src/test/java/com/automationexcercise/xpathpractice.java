package com.automationexcercise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class xpathpractice {
	
	private static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       chapter7();
     // driver.quit();
	}
	
	public static void highlight(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='3px solid green'", element);
	
	}
	public static void chapter2() {
		driver.get("https://www.w3schools.com/");
highlight(driver.findElement(By.xpath("/html/body/div[3]/a[2]")));

	}
	
	public static void chapter4() {
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		// '=' operator
//		driver.findElement(By.xpath("//input[@maxlength=10]")).sendKeys("Name");
//		// '!=' operator
//		driver.findElement(By.xpath("//input[@maxlength!=10]")).sendKeys("Class");
		// '<=' operator
		List<WebElement> element =driver.findElements(By.xpath("//input[@maxlength<=15]"));
		for (WebElement elements : element) {
			highlight(elements);
		}
		}
		public static void chapter5() {
			driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
			//invaild
			List<WebElement> element =driver.findElements(By.xpath("//input[@maxlength<=15 and @name='ne' and @type=\"tt\"]"));
			System.out.println(element.size());
			//vaid 
			List<WebElement> elements =driver.findElements(By.xpath("//input[@maxlength<=15 and @name='name' and @type=\"text\"]"));
			System.out.println(elements.size());
			//invaild
			List<WebElement> elementor =driver.findElements(By.xpath("//input[@maxlength<=1 or @name='ne' or @type=\"tt\"]"));
			System.out.println(elementor.size());
			//vaid 
			List<WebElement> elementsors =driver.findElements(By.xpath("//input[@maxlength<=15 or @name='namee' or @type=\"texgfdt\"]"));
			System.out.println(elementsors.size());
			driver.findElement(By.xpath("//input[not(@maxlength=10)]"));
			System.out.println(element.size());
			driver.findElement(By.xpath("//input[@maxlength!=10]"));
			System.out.println(element.size());
		
	}
		public static void chapter6() {
			driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
			highlight(driver.findElement(By.xpath("//table[@id='contactList']/tbody/tr[2]")));
			highlight(driver.findElement(By.xpath("(//table[@id='contactList']/tbody/tr/td)[2]")));
			
		}
		public static void chapter7() {
			driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
			highlight(driver.findElement(By.xpath("//a[text()='Sign in']")));
			highlight(driver.findElement(By.xpath("//a[contains(text(),'account')]")));
			highlight(driver.findElement(By.xpath("//div[contains(@class,'signin')]")));
			highlight(driver.findElement(By.xpath("//a[starts-with(text(),'Sign in into')]")));
			highlight(driver.findElement(By.xpath("//label[normalize-space(text()='FirstName')]")));
			highlight(driver.findElement(By.xpath("(//table[@id='contactList']/tbody/tr)[last()]")));
			highlight(driver.findElement(By.xpath("(//table[@id='contactList']/tbody/tr)[position()=2]")));
			
		}
}
