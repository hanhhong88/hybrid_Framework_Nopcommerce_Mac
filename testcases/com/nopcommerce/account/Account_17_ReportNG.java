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

public class Account_17_ReportNG extends BaseTest {
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
	public void Register_01_UserToAdmin_Validate() {
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
		verifyEquals(registerPage.getLastNameErrorMsgText(), "Last name is required.");
	}
	
	@Test
	public void Register_02_UserToAdmin_Success() {		
				log.info("Account - Step 01 : Verify enter First Name is " + firstName);
				registerPage.enterToFirstNameTextbox(firstName);
				
				log.info("Account - Step 02 : Verify enter Last Name is " + lastName);
				registerPage.enterToLastNameTextbox(lastName);
				
				log.info("Account - Step 03 : Verify enter Email is " + emailAddress);
				registerPage.enterToEmailTextbox(emailAddress);
				
				log.info("Account - Step 04 : Verify enter Password is " + passwd);
				registerPage.enterToPasswordTextbox(passwd);
				
				log.info("Account - Step 05 : Verify enter Confirm Passwd");
				registerPage.enterToConfirmPasswordTextbox(passwd);
				
				log.info("Account - Step 06 : click to Register button");
				registerPage.clicktoRegisterButton();

				//Verify success mess at Last Name textbox -> FAILED:  -> still run cont
				log.info("Account - Step 07 : Verify success msg");
				verifyEquals(registerPage.getSuccessMsgText(), "Your registration completed.");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
