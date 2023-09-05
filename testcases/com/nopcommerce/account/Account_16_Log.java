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

public class Account_16_Log extends BaseTest {
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
		log.info("Account - Step 01 : Verify Register link is displayed");
		verifyFalse(homePage.isRegisterLinkDisplayed());
		
		log.info("Account - Step 02 : Verify click to Register link");
		registerPage = homePage.clickToRegisterlink();
		
		log.info("Account - Step 03 : Verify click to Register button");
		registerPage.clicktoRegisterButton();
		
		//Verify error mess at First Name textbox -> PASS
		log.info("Account - Step 04 : Verify First Name error message");
		verifyEquals(registerPage.getFirstNameErrorMsgText(), "First name is required.");
		
		//Verify error mess at Last Name textbox -> FAILED:  -> still run cont
		log.info("Account - Step 05 : Verify Last Name error message");
		verifyEquals(registerPage.getLastNameErrorMsgText(), "Last name is required");
		
		log.info("Account - Step 06 : Verify enter First Name");
		registerPage.enterToFirstNameTextbox("hanh");
		
		log.info("Account - Step 07 : Verify enter Last Name");
		registerPage.enterToLastNameTextbox("nguyen");
		
		log.info("Account - Step 08 : Verify enter Email");
		registerPage.enterToEmailTextbox(emailAddress);
		
		log.info("Account - Step 09 : Verify enter Password");
		registerPage.enterToPasswordTextbox("123456");
		
		log.info("Account - Step 10 : Verify enter Confirm Passwd");
		registerPage.enterToConfirmPasswordTextbox("123456");
		
		log.info("Account - Step 11 : click to Register button");
		registerPage.clicktoRegisterButton();

		//Verify success mess at Last Name textbox -> FAILED:  -> still run cont
		log.info("Account - Step 12 : Verify success msg");
		verifyEquals(registerPage.getSuccessMsgText(), "Your registration completed.");

	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
