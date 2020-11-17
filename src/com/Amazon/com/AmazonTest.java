package com.Amazon.com;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import jdk.nashorn.internal.runtime.PrototypeObject;

public class AmazonTest {
	public static void main(String[] args) throws InterruptedException {
		try {
			// Create a new instance of a driver
			System.setProperty("webdriver.chrome.driver", "F:/SeleniumRepository/SeleniumBrowserjars/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.amazon.ca/"); 
			// Navigate to the right place
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			/*Signin S=PageFactory.initElements(driver, Signin.class);
			S.getPageURL();
			S.Signin();*/
			AmazonHomePage page = PageFactory.initElements(driver, AmazonHomePage.class);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			page.getPageURL();
			page.sendText("Pirates of caribbean");
			page.printsearchitem();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}