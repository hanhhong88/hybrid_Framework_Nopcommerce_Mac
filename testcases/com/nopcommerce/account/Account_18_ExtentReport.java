package com.nopcommerce.account;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;

public class Account_18_ExtentReport extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;

	private String emailAddress = getEmailrandom();
	String firstName = "hanh";
	String lastName = "nguyen";
	String passwd = "123456";
	


	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.GetHomePageObject(driver);
	}
	
	@Test
	public void User_01_Register(Method method) {
	ExtentTestManager.startTest(method.getName(), "Register to system with valid Email and Password");
	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to 'Register' page");
	registerPage = homePage.openRegisterPage();

	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
	registerPage.inputToFirstnameTextbox(firstName);

	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
	registerPage.inputToLastnameTextbox(lastName);

	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter to Email textbox with value is '" + emailAddress + "'");
	registerPage.inputToEmailTextbox(emailAddress);

	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter to Password textbox with value is '" + validPassword + "'");
	registerPage.inputToPasswordTextbox(validPassword);

	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Enter to Confirm Password textbox with value is '" + validPassword + "'");
	registerPage.inputToConfirmPasswordTextbox(validPassword);

	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to 'Register' button");
	registerPage.clickToRegisterButton();

	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08: Verify register success message is displayed");
	Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@Test
	public void User_02_Login(Method method) {
	ExtentTestManager.startTest(method.getName(), "Login to system successfully");
	ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Navigate to Login page");
	homePage = registerPage.clickToLogoutLink();
	loginPage = homePage.openLoginPage();

	ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Enter to Email textbox with value is '" + emailAddress + "'");
	loginPage.inputToEmailTextbox(emailAddress);

	ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Enter to Password textbox with value is '" + validPassword + "'");
	loginPage.inputToPasswordTextbox(validPassword);

	ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to Login button");
	homePage = loginPage.clickToLoginButton();

	ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify 'My Account' link is displayed");
	Assert.assertFalse(homePage.isMyAccountLinkDisplayed());

	ExtentTestManager.getTest().log(Status.INFO, "Login - Step 06: Navigate to 'My Account' page");
	customerInforPage = homePage.openMyAccountPage();

	ExtentTestManager.getTest().log(Status.INFO, "Login - Step 06: Verify 'Customer Infor' page is displayed");
	Assert.assertFalse(customerInforPage.isCustomerInforPageDisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
