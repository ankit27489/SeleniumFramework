package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;
	public ConfigDataProvider() {
		
		try {
			File src = new File(System.getProperty("user.dir")+"/Config/Config.properties");
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getBrowser() {
		return pro.getProperty("Browser");
	}
	
	public String getURL() {
		return pro.getProperty("qaURL");
	}
	
	public String getLoginExcelPath() {
		return pro.getProperty("loginTestDataExcel");
	}
	
	public String getLocators(String key) {
		return pro.getProperty(key);
	}
}
