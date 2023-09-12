package com.nopcommerce.account;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;

@Epic("Account")
@Feature("Create Account")
public class Account_19_AllureReport extends BaseTest {
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
	
	@Description("Account_01 - Validate register form ")
	@Story("register")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Account_01_Validate() {
		
		Assert.assertFalse(homePage.isRegisterLinkDisplayed());
		
		
		registerPage = homePage.clickToRegisterlink();
		
	
		registerPage.clicktoRegisterButton();
		
		//Verify error mess at First Name textbox -> PASS
	
		Assert.assertEquals(registerPage.getFirstNameErrorMsgText(), "First name is required.");
		
		//Verify error mess at Last Name textbox -> FAILED:  -> still run cont
		
		Assert.assertEquals(registerPage.getLastNameErrorMsgText(), "Last name is required.");
	}

	@Description("Account_02 - Register success ")
	@Story("register")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void Account_02_Success() {
		registerPage = homePage.clickToRegisterlink();
		
		registerPage.enterToFirstNameTextbox(firstName);
		
		
		registerPage.enterToLastNameTextbox(lastName);
		
		
		registerPage.enterToEmailTextbox(emailAddress);
		
		
		registerPage.enterToPasswordTextbox(passwd);
		
	
		registerPage.enterToConfirmPasswordTextbox(passwd);
		
		
		registerPage.clicktoRegisterButton();

		//Verify success mess at Last Name textbox -> FAILED:  -> still run cont
		
		Assert.assertEquals(registerPage.getSuccessMsgText(), "Your registration completed");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
