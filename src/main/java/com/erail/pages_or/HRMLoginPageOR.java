package com.erail.pages_or;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.erail.utils.WebUtils;

public class HRMLoginPageOR {

	public HRMLoginPageOR(WebUtils webUtil) {
		PageFactory.initElements(webUtil.getDriver(), this);
	}
	
	@FindBy(xpath = "//label[text()='Username']//parent::div//parent::div//div//input[@name='username']")
	private WebElement username;
	
	@FindBy(xpath = "//label[text()='Password']//parent::div//parent::div//div//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement login;
	
	public WebElement getUsername() {
		
		return username;
	}
	
    public WebElement getPassword() {
		
		return password;
	}

    public WebElement getLodin() {
	
	return login;
}
}
