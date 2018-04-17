package com.crm.qa.testUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
public static long implicit_Wait=60;
public static long PageLoadTime_wait=70;
static String TestData_sheet_path="G:\\FreeCrmProject\\FreeCrm\\src\\main\\java\\com\\crm\\qa\\tesData\\FreeCrmTestData.xlsx";
static Workbook book;
static Sheet sheet;
public  void switchToFrame() {
	driver.switchTo().frame("mainpanel");
}
public static Object[][]  getTestdata(String sheetName) {
	try {
		book=WorkbookFactory.create(new FileInputStream(TestData_sheet_path));
	}catch(InvalidFormatException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}
	sheet=book.getSheet(sheetName);
	Object data[][]=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i=0;i<sheet.getLastRowNum();i++)
	{
		for(int k=0;k<sheet.getRow(i).getLastCellNum();k++) {
			data[i][k]=sheet.getRow(i+1).getCell(k).toString();
		}
	}
	return data;
}
public static void takeScreenshotAtEndOfTest() throws IOException {
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String currentDir = System.getProperty("user.dir");
	
	FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	
	}
}
