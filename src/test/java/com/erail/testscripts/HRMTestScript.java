package com.erail.testscripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.erail.base.BaseTest;
import com.erail.base.DataProviders;
import com.erail.pages.HRMLoginPage;

public class HRMTestScript extends BaseTest{

	@Test(dataProvider = "LoginTestData", dataProviderClass = DataProviders.class)
	public void HRMTest(String username, String password) {
		HRMLoginPage hrmPage = new HRMLoginPage(webUtil);
		hrmPage.performLogin(username, password);
		extTest.log(Status.INFO, "Perform Login In Application ");
	}
}
