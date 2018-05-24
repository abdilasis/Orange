package com.qa.testing.orange;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage {
	
	@FindBy(xpath = "//*[@id=\"txtUsername\"]")
	private WebElement username;

	@FindBy(xpath = "//*[@id=\"txtPassword\"]")
	private WebElement password;

	@FindBy(xpath = "//*[@id=\"btnLogin\"]")
	private WebElement loginBtn;
	
	
	public void login() {
		
		username.sendKeys("Admin");
		password.sendKeys("admin");
		
		loginBtn.click();
	}


}
