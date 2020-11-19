package com.Amazon.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Signin  {

	private String URL="https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3Fref_%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&";
	private WebDriver driver;

	public Signin(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(how = How.ID, using = "ap_email")
	private WebElement ap_email;
	@FindBy(how = How.ID, using = "continue")
	private WebElement Searchbox;
	@FindBy(how = How.ID, using = "ap_password")
	private WebElement ap_password;
	@FindBy(how = How.ID, using = "signInSubmit")
	private WebElement SignInSubmit;
	@FindBy(how = How.CSS, using = "#nav-link-accountList > span.nav-line-2.nav-long-width")
	private WebElement Accountlist;
	@FindBy(how = How.CSS, using ="#authportal-main-section > div:nth-child(2) > div > div.a-section > form > div > div > div > h1")
	private WebElement SigninPage;

	public void Signin(){
		Accountlist.click();
		if(SigninPage.getText().equals("Sign-In")){
			System.out.println("You are in Sign in Page");
		}
		else{
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		ap_email.sendKeys("Babinibin1989@gmail.com");
		Searchbox.submit();
		ap_password.sendKeys("Jonathan@2017");
		SignInSubmit.submit();
	}
}
