package com.erail.base;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.erail.utils.WebUtils;

public class BaseTest {

	private ExtentSparkReporter extspark;
	private ExtentReports ext;
	protected ExtentTest extTest;
	protected WebUtils webUtil;

	@BeforeClass
	public void beforeClass() {
		String timeStamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		extspark = new ExtentSparkReporter("Reports/" + timeStamp + "SimpleReport.html");
		ext = new ExtentReports();
		ext.attachReporter(extspark);
	}
	@BeforeMethod
	public void beforeMathod(Method mt) {
		webUtil = new WebUtils();
		webUtil.lounchBrowser();
		webUtil.hitUrl();
		extTest = ext.createTest(mt.getName());
		webUtil.setExtentTestObject(extTest);
	}
	@AfterMethod
	public void afterMathad() {
		webUtil.tearDown();
	}
	@AfterClass
	public void afterClass() {
		ext.flush();
	}
}

