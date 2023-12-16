package com.orangehrm_pim;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.orangehrm.AddEmployeePageObject;
import pageObjects.orangehrm.DashboardPageObject;
import pageObjects.orangehrm.EmployeeListPageObject;
import pageObjects.orangehrm.LoginPageObject;
import pageObjects.orangehrm.PersonalDetailsPageObject;
import pageObjects.orangehrm.pageObjectManager;

public class PIM_01_Employee extends BaseTest{
	String browserName;
	WebDriver driver;
	private LoginPageObject LoginPage;
	private DashboardPageObject DashBoardPage;
	private EmployeeListPageObject EmployeeListPage;
	private AddEmployeePageObject AddEmployeePage;
	private String EmployeeID, firstname, lastname;
	private PersonalDetailsPageObject PersonalDetailsPage;
	
	@Parameters({"url", "browser"})
	@BeforeClass
		public void before_Class(String Url, String BrowserName) {
		
		driver = getBrowserName(BrowserName, Url);
		this.browserName = browserName;
		firstname = "Taylor";
		lastname = "Swift";
		
		LoginPage = pageObjectManager.getLoginPage(driver);
		
		LoginPage.inputToUsername(GlobalConstants.ADMIN_ORHRM_USERNAME);
		LoginPage.inputToPassword(GlobalConstants.ADMIN_ORHRM_PASSWORD);
		DashBoardPage = LoginPage.clickToLogin();
		
		EmployeeListPage =  DashBoardPage.openPIM_Module();
		EmployeeListPage.waitForSpinnerIconInvisibile();
	}
	
	
	@Test
	
	public void Employees_01_Add_New(Method method) {
		AddEmployeePage = EmployeeListPage.clickToAddEmployeeButton();
		
		AddEmployeePage.enterToFirstName(firstname);
		AddEmployeePage.enterToLastName(lastname);
		EmployeeID = AddEmployeePage.getEmployeeID();
		
		AddEmployeePage.clickSaveButton();
		Assert.assertTrue(AddEmployeePage.isSuccessMessageDisplayed("Successfully Saved"));
		AddEmployeePage.waitForSpinnerIconInvisibile();
		
		PersonalDetailsPage = pageObjectManager.getPersonalDetailsPage(driver);
		Assert.assertTrue(PersonalDetailsPage.isPersonalDetailHeaderDisplayed());
		PersonalDetailsPage.waitForSpinnerIconInvisibile();
		
		
		Assert.assertEquals(PersonalDetailsPage.getFirstName(), firstname);
		Assert.assertEquals(PersonalDetailsPage.getLastName(), lastname);
		Assert.assertEquals(PersonalDetailsPage.getEmployeeID(), EmployeeID);
		
		EmployeeListPage = PersonalDetailsPage.clickToEmployeeListButton();
		EmployeeListPage.inputToEmployeeIDtxb(EmployeeID);
		EmployeeListPage.clickToSearchBtn();
		
		Assert.assertTrue(EmployeeListPage.isDisplayedValueAtColumn("ID", "1", EmployeeID));
		Assert.assertTrue(EmployeeListPage.isDisplayedValueAtColumn("First (& Middle) Name", "1", firstname));
		Assert.assertTrue(EmployeeListPage.isDisplayedValueAtColumn("Last Name", "1", lastname));
		
	}
	
	@Test
	public void Employees_02_Personal_Details(Method method) {
		System.out.println("test");
	}
	
	@Test
	public void Employees_03_Contact_Details(Method method) {
		System.out.println("test");
	}
	
	@Test
	public void Employees_04_Emergency_Contact(Method method) {
		System.out.println("test");
	}
	
	@Test
	public void Employees_05_Dependent(Method method) {
		System.out.println("test");
	}
	
	@Test
	public void Employees_06_Immigration(Method method) {
		System.out.println("test");
	}
	
	@Test
	public void Employees_07_Job(Method method) {
		System.out.println("test");
		}
	
	@Test
	public void Employees_08_Salary(Method method) {
		System.out.println("test");
	}
	
	@Test
	public void Employees_09_Report(Method method) {
		System.out.println("test");	
	}
	
	@Test
	public void Employees_10_Qualification(Method method) {
		System.out.println("test");
	}
	
	
	@AfterClass
	public void after_Class() {
		driver.quit();
	}
	

}