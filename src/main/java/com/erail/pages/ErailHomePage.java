package com.erail.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erail.pages_or.ErailHomePageOR;
import com.erail.utils.WebUtils;

public class ErailHomePage extends ErailHomePageOR{

	private WebUtils webUtil;
	
	public ErailHomePage(WebUtils webUtil) {
		super(webUtil);
		this.webUtil = webUtil;
	}

	public void enterStationName() {
		webUtil.click(getFromField());
		webUtil.clear(getFromField());
		webUtil.sendkeys(getFromField(), "DEL");
	}
	
	public String selectStationAndReturnStationName() {
		
		webUtil.click(getStationName());
		return webUtil.getAttributeValue(getStationName(), "title");
		
	}
	
	public List<String> getAllOptions() {
        List<String> stationNames =  new ArrayList<>();
      
        for (WebElement option :  getDropDownOptions()) {
           stationNames.add(option.getText());
        }
        return stationNames;
    }
	
	public void select30DaysAfterDate() {
        LocalDate currentDate = LocalDate.now();
        
        LocalDate futureDate = currentDate.plusDays(30);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yy EEE");
        String formattedDate = futureDate.format(formatter);
        
        webUtil.sendkeysByJavascript(getdataField(), formattedDate);
        

	}
}
