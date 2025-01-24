package com.erail.base;

import org.testng.annotations.DataProvider;

import com.erail.utils.ExcelUtils;

public class DataProviders {

	@DataProvider( name = "LoginTestData")
	public Object[][] loginDataprovider() {
		
		String fileName = System.getProperty("user.dir")+"\\src\\test\\resources\\LoginData.xlsx";
		
		int ttlRowCont = ExcelUtils.getRowCount(fileName, "Sheet1");
		
		int ttlColumCont = ExcelUtils.getColumCount(fileName, "Sheet1");
		
		String [][] userData = new String[ttlRowCont-1][ttlColumCont];
		
		for (int rowNo = 1; rowNo < ttlRowCont; rowNo++) {
			
			for (int columNo = 0; columNo < ttlColumCont; columNo++) {
				
				userData[rowNo-1][columNo] = ExcelUtils.getCellValue(fileName, "Sheet1", rowNo, columNo);
			}
		}
		
		return userData;
		
	}
}
