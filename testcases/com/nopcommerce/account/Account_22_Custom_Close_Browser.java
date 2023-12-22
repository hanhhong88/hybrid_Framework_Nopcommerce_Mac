package com.nopcommerce.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageUIs.user.HomePageUI;
import pageObjects.user.RegisterPageObject;

public class Account_22_Custom_Close_Browser extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.GetHomePageObject(driver);
		
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.GetRegisterPageObject(driver);
	
		registerPage.clickToButtonByText("Register");
	
		Assert.assertEquals(registerPage.getTxbErrorMsgByID("FirstName"), "First name is required...");
		Assert.assertEquals(registerPage.getTxbErrorMsgByID("LastName"), "Last name is required.");
		Assert.assertEquals(registerPage.getTxbErrorMsgByID("Email"), "Email is required.");
		Assert.assertEquals(registerPage.getTxbErrorMsgByID("Password"), "Password is required.");
	}

	@Test
	public void Register_01_Empty() {

		
		
		
	}

	@Test
	public void Register_02_InvalidEmail() {
		
	}

	@Test
	public void Register_03_InvalidPassword() {
		
	}

	@Test
	public void Register_04_InvalidConfirmPassword() {
		
	}

	@Test
	public void Register_05_ValidData() {
		

	}

	@Test
	public void Register_06_LoginSuccess() {
		
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
//		closeBrowser();
	}
}


