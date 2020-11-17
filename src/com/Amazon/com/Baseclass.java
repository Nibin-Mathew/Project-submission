package com.Amazon.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class Baseclass {
	/**
	 * Constructor for a Page object that represents an entire page. We rely on
	 * the PageFactory to instantiate the instance of the PageObject.
	 * https://code.google.com/p/selenium/wiki/PageFactory
	 *
	 * @param driver
	 *            the web driver instance.
	 */
	public Baseclass(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Returns the page URL.
	 *
	 * @return String representation of the URL.
	 */
	public abstract String getPageURL();
}
