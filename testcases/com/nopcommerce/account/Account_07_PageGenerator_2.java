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
import pageObjects.user.RegisterPageObject;

public class Account_01_Register_PageGenerator_2 extends BaseTest {
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
		registerPage = homePage.clickToRegisterlink();
		registerPage.clicktoRegisterButton();
		
		Assert.assertEquals(registerPage.getFirstNameErrorMsgText(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMsgText(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMsgText(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMsgText(), "Password is required.");
	}

	@Test
	public void Register_02_InvalidEmail() {
		homePage = registerPage.clickToNopCommerceImg();
		registerPage = homePage.clickToRegisterlink();
		
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
		homePage = registerPage.clickToNopCommerceImg();
		registerPage = homePage.clickToRegisterlink();

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
		homePage = registerPage.clickToNopCommerceImg();
		registerPage = homePage.clickToRegisterlink();

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
		homePage = registerPage.clickToNopCommerceImg();
		registerPage = homePage.clickToRegisterlink();
		
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
		homePage = registerPage.clickToNopCommerceImg();
		loginPage = homePage.clickToLoginlink();

		loginPage.entertoEmailTextbox(emailAddress);
		loginPage.entertoPassWordTextbox("123456");
		homePage = loginPage.clickToLoginButton();
		customPage = homePage.clicktoMyAccoutnLink();
		
		Assert.assertEquals(customPage.getAtributeFirstName(), "hanh");
		Assert.assertEquals(customPage.getAtributeLastName(), "nguyen");
		Assert.assertEquals(customPage.getAtributeEmail(), emailAddress);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
