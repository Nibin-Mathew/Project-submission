package com.Amazon.com;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.STRING;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonHomePage {

	// Object repository for AmazonHomepage
	@FindBy(how = How.CSS, using = "#searchDropdownBox")
	private static WebElement departmentSelectBox;
	@FindBy(how = How.ID, using = "twotabsearchtextbox")
	private static WebElement Searchbox;
	@FindBy(how = How.CLASS_NAME, using = "nav-input")
	private static WebElement SearchButton;	
	@FindBy(how = How.CLASS_NAME, using = "a-icon.*")
    List<WebElement> Totalproducts;

	public static String selectbyvalue(String value){
		Select objSelect=new Select(departmentSelectBox);
		objSelect.selectByVisibleText(value);
		System.out.println("The Department item is "+value);
		return value;
		
	}
	public static String sendText(String text) {
		Searchbox.sendKeys(text);
		System.out.println("The Search item is "+text);
		SearchButton.submit();
		return text;
	}

	
	}
 