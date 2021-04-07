package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	public ExcelDataProvider() {
		//Loading Excel Sheet and making it ready to use
		try {
			
			File src = new File(System.getProperty("user.dir")+"/TestData/LoginData.xlsx");
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Overloaded Function
	public String getStringData(int index, int row, int col) {
		return wb.getSheetAt(index).getRow(row).getCell(col).getStringCellValue();
	}
	
	//Overloaded Function
	public String getStringData(String sheetName, int row, int col) {
		return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
	}
	
	public double getNumericData(String sheetName, int row, int col) {
		return wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
	}
}
