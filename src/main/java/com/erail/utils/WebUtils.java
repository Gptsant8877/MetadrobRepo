package com.erail.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
	
	public class WebUtils {
	private WebDriver driver;
	private ExtentTest extTest ;
	private Properties prop;
		public void lounchBrowser() {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		
		public WebDriver getDriver() {
			
			return this.driver;
		}
		public void setExtentTestObject(ExtentTest extTest) {
			this.extTest=extTest;
		}
		
		public ExtentTest getExtentTestObject() {
			return this.extTest;
		}
		
		
		public String readConfig(String filePath, String propName) {
			if(prop==null) {
				prop=new Properties();
			}
			try {
				prop.load(new FileInputStream(filePath));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return prop.getProperty(propName);
		}
		
		public void hitUrl() {
			String url=readConfig("config.properties", "erailURL");
			driver.get(url);

		}
		public void click(WebElement we) {
			we.click();
			extTest.log(Status.INFO, "Click perform Successfully");

		}
		public void sendkeys(WebElement we,String value) {
			we.sendKeys(value);
			extTest.log(Status.INFO, "Enter Value Successfully");
		}
		
		public void sendkeysByJavascript(WebElement we, String date) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].value = arguments[1];", we, date);
	        extTest.log(Status.INFO, "enter ");
		}
		
		public void clear(WebElement we) {
			we.clear();
			extTest.log(Status.INFO, "Clear Text Field Successfully");
		}
		
		public String getAttributeValue(WebElement we, String attributeName) {
			extTest.log(Status.INFO, "Featched and Returing Element Text Value Successfully");
			return we.getDomAttribute(attributeName);
		}
		
		public void WebDriverWaitFor(WebElement we) {
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(we));
		}
		
		public void tearDown() {
			driver.quit();
			extTest.log(Status.INFO, "Browser Close Successfully");

		}
	
	
}
