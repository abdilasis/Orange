package com.qa.testing.orange;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.TestCase;

public class OrangeTest  {
	
	WebDriver driver;

	String url;
	
	public ExtentReports report;
	public ExtentTest test;
	
	@Before
	public void setup() {
		
		report = new ExtentReports("C:\\Users\\Admin\\BasicReport.html", true);
		test = report.startTest("Add employee to the CRM");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\development\\web-driver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser started");
		url = "http://opensource.demo.orangehrmlive.com/index.php/auth/login";
		driver.get(url);
		
		LogInPage page = PageFactory.initElements(driver, LogInPage.class);
		
		page.login();
		
		 

	}
	
	@Given("^the Add Employee Tab$")
	public void the_Add_Employee_Tab() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		
		Thread.sleep(3000);
	    
	}

	@When("^I fill out the Employee Details correctly$")
	public void i_fill_out_the_Employee_Details_correctly() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		AddEmployee page = PageFactory.initElements(driver, AddEmployee.class);
		page.addEmployee();
		
//		driver.findElement(By.id("firstName")).sendKeys("John");
//		driver.findElement(By.id("lasttName")).sendKeys("Doe");
//		driver.findElement(By.id("employeeId")).sendKeys("003");
		
		driver.findElement(By.id("chkLogin")).click();
		
		
	
	    
	}

	@When("^I choose to create Login Details$")
	public void i_choose_to_create_Login_Details() throws Throwable {
	   
		
		driver.findElement(By.id("user_name")).sendKeys("Test100");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.id("re_password")).sendKeys("password");
		
		
		
	   
	}

	@When("^I fill out the Login Details correctly$")
	public void i_fill_out_the_Login_Details_correctly() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@When("^I click the Save button$")
	public void i_click_the_Save_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
		driver.findElement(By.id("btnSave")).click();
		
	}

	@Then("^I can see information about the user$")
	public void i_can_see_information_about_the_user() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		String expected = "Roberto Firmino";
		//String pageName = driver.findElement(By.id("personal_txtEmpFirstName")).getText();
		String result = driver.findElement(By.xpath("//*[@id=\"profile-pic\"]/h1")).getText();
		
		if (!result.equals(expected)) {
			test.log(LogStatus.FAIL, "failed to add employee");
			report.endTest(test);
			report.flush();
			
		}
		
		assertEquals(expected,result);
		test.log(LogStatus.PASS, "employee added");
		
		report.endTest(test);
		report.flush();
	    
	    Thread.sleep(3000);
	}
  
	@After
	public void tearDown() {
		
		driver.close();
		driver.quit();
	}


}
