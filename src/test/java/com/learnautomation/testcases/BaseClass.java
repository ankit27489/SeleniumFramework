package com.learnautomation.testcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider edp;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void suiteSetUp() {
		System.out.println("In BeforeSuite Function.");
		edp = new ExcelDataProvider();
		config = new ConfigDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(
				System.getProperty("user.dir")+"/Reports/LoginTestReport_"+Helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeClass
	public void setup() {
		
		String browser = config.getBrowser();
		String URL = config.getURL();
		driver = BrowserFactory.startApplication(driver, browser, URL);
	}
	
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			try {
				String screenshot_path = Helper.captureScreenshot(driver);
				logger.fail("Test case ended due to failure.", 
						MediaEntityBuilder.createScreenCaptureFromPath(screenshot_path).build());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("In After Method");
		report.flush();
	}
}
