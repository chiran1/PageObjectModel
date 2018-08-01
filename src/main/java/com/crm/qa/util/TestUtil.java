package com.crm.qa.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import com.crm.qa.base.TestBase;



public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	public static void modalPopUps() {
		driver.switchTo().frame("intercom-borderless-frame");
		Actions axn = new Actions(driver);
		axn.moveToElement(driver.findElement(By.xpath("//div[contains(@class, 'intercom-author-summary-name-from')]"))).build().perform();
		driver.findElement(By.xpath("//div[contains(@class, 'intercom-borderless-dismiss-button')]//span")).click();
		driver.switchTo().defaultContent();
	}
	
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\CB\\Desktop\\Selenium\\seleniumWork\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCrmTestData.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][]getTestData(String sheetName){
		FileInputStream file = null;
		try {
			file = new FileInputStream (TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet= book.getSheet(sheetName);
		Object[][]data = new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		//system.out.println(shet.getLastRowNum() + ".........." +
		//sheet.getRow(0).getLastCellNum());
		
		for(int i=0; i<sheet.getLastRowNum();i++) {
			for (int k=0; k<sheet.getRow(0).getLastCellNum();k++) {
				data [i][k]=sheet.getRow(i+1).getCell(k).toString();
				//System.out.println(data[i][k]);
						
			}
		}
		
		return data;
		
		
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}
