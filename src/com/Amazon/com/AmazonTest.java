package com.Amazon.com;

import java.util.concurrent.TimeUnit;

import javax.naming.directory.SearchResult;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import jdk.nashorn.internal.runtime.PrototypeObject;

public class AmazonTest  {
	public static final String URL = "https://www.amazon.ca/";
	public static void main(String[] args) throws InterruptedException, ArrayIndexOutOfBoundsException {
		try {
			
			// Create a new instance of a driver
			System.setProperty("webdriver.chrome.driver", "F:/SeleniumRepository/SeleniumBrowserjars/chromedriver.exe");
			WebDriver driver = new ChromeDriver();		
			driver.get(URL);
			AmazonHomePage page = PageFactory.initElements(driver, AmazonHomePage.class);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			page.selectbyvalue("Baby");
			page.sendText("Diapers");
			SearchResults results = PageFactory.initElements(driver, SearchResults.class);
			results.printsearchresults();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
}