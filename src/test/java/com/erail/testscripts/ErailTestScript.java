package com.erail.testscripts;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.erail.base.BaseTest;
import com.erail.pages.ErailHomePage;
import com.erail.utils.ExcelUtils;

public class ErailTestScript extends BaseTest{

	@Test
	public void ErailTest() throws IOException, InterruptedException {
		ErailHomePage erailHP =  new ErailHomePage(webUtil);
		erailHP.enterStationName();
		Thread.sleep(5000);
		List<String> stationNames = erailHP.getAllOptions();		
		String expectedFilePath = System.getProperty("user.dir")+"\\src\\test\\resources\\expectedStations.xlsx";
		String actualFilePath = System.getProperty("user.dir")+"\\src\\test\\resources\\actualStations.xlsx";
        ExcelUtils.writeToExcel(stationNames.toArray(new String[0]), actualFilePath);
        List<String> expectedStationNames = ExcelUtils.getCellValuesInList(expectedFilePath);
        List<String> actualStationNames = ExcelUtils.getCellValuesInList(actualFilePath);
        
        if (expectedStationNames.containsAll(actualStationNames)) {
			System.out.println("The Actual :-" +actualStationNames+"\n && Expected :-"+expectedStationNames+" is Matched ");
			extTest.log(Status.PASS, "The Actual :-" +actualStationNames+"\n && Expected :-"+expectedStationNames+" is Matched ");
		} else {
			System.out.println("The Actual :-" +actualStationNames+"\n && Expected :-"+expectedStationNames+" is NOT Matched ");
			extTest.log(Status.FAIL, "The Actual :-" +actualStationNames+"\n && Expected :-"+expectedStationNames+" is NOT Matched ");

		}
		Assert.assertEquals(actualStationNames, expectedStationNames, "Comparing Expected Station Names With Actual Station Names");
		
		String fourthStatinName = erailHP.selectStationAndReturnStationName();
		extTest.log(Status.INFO, "Station at 4th Position "+fourthStatinName);
		Thread.sleep(3000);
		
		erailHP.select30DaysAfterDate();
		Thread.sleep(15000);
	}
}

