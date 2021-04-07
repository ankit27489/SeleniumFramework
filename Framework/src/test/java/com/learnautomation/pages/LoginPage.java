package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id="CustomerEmail")
	WebElement email;
	
	@FindBy(xpath="//input[@id='CustomerPassword']")
	WebElement pwd;
	
	@FindBy(xpath="//input[@value='Sign In']")
	WebElement login_button;
	
	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	
	public void loginApp(String uname, String password) {
		email.sendKeys(uname);
		pwd.sendKeys(password);
		login_button.click();
	}

}
