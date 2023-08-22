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

public class Account_15_Assert_Verify extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;

	private String emailAddress = getEmailrandom();


	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.GetHomePageObject(driver);
	}
	
	@Test
	public void Register_01_UserToAdmin() {
		//Fail 1 -> still run cont
		verifyFalse(homePage.isRegisterLinkDisplayed());
		
		registerPage = homePage.clickToRegisterlink();
		
		registerPage.clicktoRegisterButton();
		
		//Verify error mess at First Name textbox -> PASS
		verifyEquals(registerPage.getFirstNameErrorMsgText(), "First name is required.");
		
		//Verify error mess at Last Name textbox -> FAILED:  -> still run cont
		verifyEquals(registerPage.getLastNameErrorMsgText(), "Last name is required");
		
		registerPage.enterToFirstNameTextbox("hanh");
		registerPage.enterToLastNameTextbox("nguyen");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");
		
		registerPage.clicktoRegisterButton();

		//Verify success mess at Last Name textbox -> FAILED:  -> still run cont
		verifyEquals(registerPage.getSuccessMsgText(), "Your registration completed.");

	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
