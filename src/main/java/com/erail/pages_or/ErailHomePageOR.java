package com.erail.pages_or;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.erail.utils.WebUtils;

public class ErailHomePageOR {

	public ErailHomePageOR(WebUtils webUtil) {
		PageFactory.initElements(webUtil.getDriver(), this);
	}
	
	@FindBy(id = "txtStationFrom")
	private WebElement fromField;
	
	@FindBys(@FindBy (xpath = "//div[@class='autocomplete']//div[@title='Delhi Azadpur']"))
	private WebElement stationName;
	
	@FindBy(xpath = "//input[@title='Select Departure date for availability']")
	private WebElement dateField;
	
    @FindBys({
       
        @FindBy(xpath = "//div[@class='autocomplete']/div")
    })
    private List<WebElement> dropdownOptions;
	

	public WebElement getFromField() {
		return fromField;
	}
	
	public WebElement getStationName() {
		return stationName;
	}
	
	public WebElement getdataField() {
		return dateField;
	}
	
	public List<WebElement> getDropDownOptions() {
		
		return dropdownOptions;
	}
}
