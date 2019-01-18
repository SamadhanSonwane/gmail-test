package com.example.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.example.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static int PAGE_LOAD_TIMEOUT = 60;
	public static int IMPLICIT_WAIT = 30;

	public static String DATA_SHEET_PATH = System.getProperty("user.dir")
			+ "/src/main/java/com/example/qa/testdata/AccountsTestData.xls";

	static Workbook wb;
	static Sheet sheet;

	public static Object[][] getTestData(String sheetName) {
		
		FileInputStream file = null;
		try {
			file = new FileInputStream(DATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			wb = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		sheet = wb.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}
}
