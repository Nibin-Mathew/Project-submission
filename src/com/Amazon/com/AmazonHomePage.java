package com.Amazon.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonHomePage extends Baseclass {
	private WebDriver driver;
	public static final String URL = "https://www.amazon.co.ca/";

	public AmazonHomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	// Object repository for AmazonHomepage
	@FindBy(how = How.CSS, using = "#searchDropdownBox")
	private WebElement dropselect;
	@FindBy(how = How.ID, using = "twotabsearchtextbox")
	private WebElement Searchbox;
	@FindBy(how = How.CLASS_NAME, using = "nav-input")
	private WebElement SearchButton;
	@FindBy(how = How.TAG_NAME, using = "h2")
	public static List<WebElement> TotalImages;

	@Override
	public String getPageURL() {
		return URL;
	}

	public String sendText(String text) {
		Searchbox.sendKeys(text);
		System.out.println(text);
		SearchButton.submit();
		return text;
	}

	public List<WebElement> printsearchitem() {
		// print the product details
		System.out.println(TotalImages.size());
		for(int i=1;i<TotalImages.size();i++){
			System.out.println(TotalImages.get(i).getText());
		}
		return TotalImages;
		
		
		
	}}
 