package com.Amazon.com;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchResults {
	
	List<String> Str = new ArrayList<String>();
	
	@FindBy(how = How.TAG_NAME, using = "h2")
    List<WebElement> Totalproducts;
	@FindBy(how = How.CLASS_NAME, using = "a-price-whole")
	List<WebElement> value;
	
	public ArrayList<String> printsearchresults(){
		System.out.println("The Total count is "+Totalproducts.size());
		for(WebElement item:Totalproducts){
			if (item.getText().length()>25);
			Str.add(item.getText().substring(0, 23)+ "...");
		
		}
		System.out.println("The Diapers are "+Str);
		return (ArrayList<String>) Str;
		
	}
	}

