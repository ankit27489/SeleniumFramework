package ReportDemo;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemo {

	@Test
	public void loginTest() {
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/learn_automation.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("LoginTest");
		logger.log(Status.INFO, "Login to Amazon");
		logger.log(Status.PASS, "Title Verified");
		
		extent.flush();
		
	}
}
