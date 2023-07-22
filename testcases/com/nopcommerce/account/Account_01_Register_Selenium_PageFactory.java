package com.nopcommerce.account;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.factory.CustomerPageObject;
import pageObject.factory.HomePageObject;
import pageObject.factory.LoginPageObject;
import pageObject.factory.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Account_01_Register_Selenium_PageFactory extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerPageObject customPage;
	private String emailAddress = getEmailrandom();

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		homePage = new HomePageObject(driver);

	}

	@Test
	public void Register_01_Empty() {
		homePage.clickToRegisterlink();
		registerPage = new RegisterPageObject(driver);
		registerPage.clicktoRegisterButton();
		registerPage = new RegisterPageObject(driver);

		Assert.assertEquals(registerPage.getFirstNameErrorMsgText(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMsgText(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMsgText(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMsgText(), "Password is required.");
	}

	@Test
	public void Register_02_InvalidEmail() {
		registerPage.clickToNopCommerceImg();

		homePage = new HomePageObject(driver);
		homePage.clickToRegisterlink();
		registerPage = new RegisterPageObject(driver);

		registerPage = new RegisterPageObject(driver);
		registerPage.enterToFirstNameTextbox("hanh");
		registerPage.enterToLastNameTextbox("nguyen");
		registerPage.enterToEmailTextbox("hanh@gdf#@");
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");
		registerPage.clicktoRegisterButton();

		Assert.assertEquals(registerPage.getEmailErrorMsgText(), "Wrong email");
	}

	@Test
	public void Register_03_InvalidPassword() {
		registerPage.clickToNopCommerceImg();

		homePage = new HomePageObject(driver);
		homePage.clickToRegisterlink();
		registerPage = new RegisterPageObject(driver);

		registerPage = new RegisterPageObject(driver);
		registerPage.enterToFirstNameTextbox("hanh");
		registerPage.enterToLastNameTextbox("nguyen");
		registerPage.enterToEmailTextbox("hanh234@gmail.com");
		registerPage.enterToPasswordTextbox("123");
		registerPage.enterToConfirmPasswordTextbox("123");
		registerPage.clicktoRegisterButton();

		Assert.assertEquals(registerPage.getPasswordErrorMsgText(),
				"Password must meet the following rules:\n" + "must have at least 6 characters");
	}

	@Test
	public void Register_04_InvalidConfirmPassword() {
		registerPage.clickToNopCommerceImg();

		homePage = new HomePageObject(driver);
		homePage.clickToRegisterlink();
		registerPage = new RegisterPageObject(driver);

		registerPage = new RegisterPageObject(driver);
		registerPage.enterToFirstNameTextbox("hanh");
		registerPage.enterToLastNameTextbox("nguyen");
		registerPage.enterToEmailTextbox("hanh234@gmail.com");
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123");
		registerPage.clicktoRegisterButton();

		Assert.assertEquals(registerPage.getConfirm_PasswordErrorMsgText(),
				"The password and confirmation password do not match.");
	}

	@Test
	public void Register_05_ValidData() {
		registerPage.clickToNopCommerceImg();

		homePage = new HomePageObject(driver);
		homePage.clickToRegisterlink();
		registerPage = new RegisterPageObject(driver);

		registerPage = new RegisterPageObject(driver);
		registerPage.enterToFirstNameTextbox("hanh");
		registerPage.enterToLastNameTextbox("nguyen");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");
		registerPage.clicktoRegisterButton();

		Assert.assertEquals(registerPage.getSuccessMsgText(), "Your registration completed");

	}

	@Test
	public void Register_06_LoginSuccess() {
		registerPage.clickToNopCommerceImg();

		homePage = new HomePageObject(driver);
		homePage.clickToLoginlink();
		loginPage = new LoginPageObject(driver);

		loginPage.entertoEmailTextbox(emailAddress);
		loginPage.entertoPassWordTextbox("123456");
		loginPage.clickToLoginButton();

		homePage = new HomePageObject(driver);
		homePage.clicktoMyAccoutnLink();

		customPage = new CustomerPageObject(driver);
		Assert.assertEquals(customPage.getAtributeFirstName(), "hanh");
		Assert.assertEquals(customPage.getAtributeLastName(), "nguyen");
		Assert.assertEquals(customPage.getAtributeEmail(), emailAddress);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
