package com.qa.testing.orange;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeDetails {

	@FindBy(id = "firstName")
	private WebElement firstName;

	@FindBy(id = "lastName")
	private WebElement lastName;
	
	@FindBy(id = "employeeId")
	private WebElement employeeId;

	@FindBy(id = "btnSave")
	private WebElement saveBtn;
	
	public void fillEmployeeDetails() {
		
	}
}
