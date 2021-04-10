package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	//Screenshots, Alrets, frames, windows, sync issues, javascript executer
	public static String captureScreenshot(WebDriver driver) {
		
		String current_date_time = getCurrentDateTime();
		String screenshot_path = System.getProperty("user.dir")+
				"/Screenshots/LoginTest_"+current_date_time+".png";
		try {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File(screenshot_path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return screenshot_path;
	}
	
	public static String getCurrentDateTime() {
		DateFormat format = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDateTime = new Date();
		return format.format(currentDateTime);
	}
	
	
}
