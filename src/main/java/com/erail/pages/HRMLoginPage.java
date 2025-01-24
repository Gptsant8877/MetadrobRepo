package com.erail.pages;

import com.erail.pages_or.HRMLoginPageOR;
import com.erail.utils.WebUtils;

public class HRMLoginPage extends HRMLoginPageOR{

	private WebUtils webUtil;
	
	public HRMLoginPage(WebUtils webUtil) {
		super(webUtil);
		this.webUtil = webUtil;
	}

	public void performLogin(String username, String password) {
		webUtil.sendkeys(getUsername(), username);
		webUtil.sendkeys(getPassword(), password);
		webUtil.click(getLodin());
	}
	
}
