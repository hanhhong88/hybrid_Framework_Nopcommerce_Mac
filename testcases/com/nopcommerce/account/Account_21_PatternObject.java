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

public class Account_21_PatternObject extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private CustomerPageObject customPage;
	private String emailAddress = getEmailrandom();

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.GetHomePageObject(driver);
	}

	@Test
	public void Register_01_Empty() {
//		registerPage = homePage.clickToRegisterlink();
		
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.GetRegisterPageObject(driver);
	
		registerPage.clickToButtonByText("Register");
	
		Assert.assertEquals(registerPage.getTxbErrorMsgByID("FirstName"), "First name is required.");
		Assert.assertEquals(registerPage.getTxbErrorMsgByID("LastName"), "Last name is required.");
		Assert.assertEquals(registerPage.getTxbErrorMsgByID("Email"), "Email is required.");
		Assert.assertEquals(registerPage.getTxbErrorMsgByID("Password"), "Password is required.");
		
	}

	@Test
	public void Register_02_InvalidEmail() {
		homePage = registerPage.clickToNopCommerceImg();
		
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.GetRegisterPageObject(driver);
		
		registerPage.enterToTxbByID("FirstName", "hanh");
		registerPage.enterToTxbByID("LastName", "nguyen");
		registerPage.enterToTxbByID("Email", "hanh@gdf#@");
		registerPage.enterToTxbByID("Password", "123456");
		registerPage.enterToTxbByID("ConfirmPassword", "123456");
		
		registerPage.clickToButtonByText("Register");
		
		Assert.assertEquals(registerPage.getTxbErrorMsgByID("Email"), "Wrong email");
		
	}

	@Test
	public void Register_03_InvalidPassword() {
		homePage = registerPage.clickToNopCommerceImg();
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.GetRegisterPageObject(driver);
		
		registerPage.enterToTxbByID("FirstName", "hanh");
		registerPage.enterToTxbByID("LastName", "nguyen");
		registerPage.enterToTxbByID("Email", "hanh234@gmail.com");
		registerPage.enterToTxbByID("Password", "123");
		registerPage.enterToTxbByID("ConfirmPassword", "123");

		registerPage.clickToButtonByText("Register");

		Assert.assertEquals(registerPage.getTxbErrorMsgByID("Password"),
				"Password must meet the following rules:\n" + "must have at least 6 characters");
	}

	@Test
	public void Register_04_InvalidConfirmPassword() {
		homePage = registerPage.clickToNopCommerceImg();
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.GetRegisterPageObject(driver);
		
		
		registerPage.enterToTxbByID("FirstName", "hanh");
		registerPage.enterToTxbByID("LastName", "nguyen");
		registerPage.enterToTxbByID("Email", "hanh234@gmail.com");
		registerPage.enterToTxbByID("Password", "123456");
		registerPage.enterToTxbByID("ConfirmPassword", "123");
		
		registerPage.clickToButtonByText("Register");

		Assert.assertEquals(registerPage.getTxbErrorMsgByID("ConfirmPassword"),
				"The password and confirmation password do not match.");
	}

	@Test
	public void Register_05_ValidData() {
		homePage = registerPage.clickToNopCommerceImg();
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.GetRegisterPageObject(driver);
		
		
		registerPage.enterToTxbByID("FirstName", "hanh");
		registerPage.enterToTxbByID("LastName", "nguyen");
		registerPage.enterToTxbByID("Email", emailAddress);
		registerPage.enterToTxbByID("Password", "123456");
		registerPage.enterToTxbByID("ConfirmPassword", "123456");
		
		registerPage.clickToButtonByText("Register");

		Assert.assertEquals(registerPage.getSuccessMsgText(), "Your registration completed");

	}

	@Test
	public void Register_06_LoginSuccess() {
		homePage = registerPage.clickToNopCommerceImg();
		
		homePage.clickToHeaderLinkByName("Log in");
		loginPage = PageGeneratorManager.GetUserLoginPageObject(driver);

		loginPage.enterToTxbByID("Email", emailAddress);
		loginPage.enterToTxbByID("Password", "123456");
		
		loginPage.clickToButtonByText("Log in");
		homePage = PageGeneratorManager.GetHomePageObject(driver);
		
		homePage.clickToHeaderLinkByName("My account");
		customPage = PageGeneratorManager.GetCustomerPageObject(driver);
		
		Assert.assertEquals(customPage.getAtributeByID("FirstName"), "hanh");
		Assert.assertEquals(customPage.getAtributeByID("LastName"), "nguyen");
		Assert.assertEquals(customPage.getAtributeByID("Email"), emailAddress);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
