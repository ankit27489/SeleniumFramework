package com.learnautomation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.learnautomation.pages.LoginPage;
import com.learnautomation.utility.Helper;

public class LoginTestPoster extends BaseClass {

	@Test
	public void loginApp() {
		
		logger = report.createTest("PosterGullyLoginTest");
		
////		SoftAssert softAssert = new SoftAssert();
		String uname = edp.getStringData("Login", 0, 0);
		String pwd = edp.getStringData("Login", 0, 1);
		
		logger.info("Starting Application");
		LoginPage login_page = PageFactory.initElements(driver,  LoginPage.class);
		System.out.println("Ready to call login function. with uname="+uname+" and password = "+pwd);
		login_page.loginApp(uname, pwd);
		
		if("MY ACCOUN".equals(driver.findElement(By.xpath("//h1")).getText()))
			logger.pass("Login Test Successful");
		else
			logger.fail("Login Test Failed");
		Assert.assertEquals("MY ACCOUNT", driver.findElement(By.xpath("//h1")).getText());		
	}
}
