package com.qa.testing.orange;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmployee {

	@FindBy(id = "firstName")
	private WebElement firstName;

	@FindBy(id = "lastName")
	private WebElement lastName;
	
	@FindBy(id = "employeeId")
	private WebElement employeeId;

	@FindBy(id = "btnSave")
	private WebElement saveBtn;
	
	
	public void addEmployee() {
		
		firstName.sendKeys("Roberto");
		lastName.sendKeys("Firmino");
		employeeId.sendKeys("002");
		//saveBtn.click();
	}
	
}
