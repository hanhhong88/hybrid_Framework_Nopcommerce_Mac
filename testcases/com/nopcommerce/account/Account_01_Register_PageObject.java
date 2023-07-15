package com.nopcommerce.account;

import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.CustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Account_01_Register_PageObject{
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerPageObject customPage;
	private String emailAddress = getEmailrandom();

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
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
		Assert.assertEquals(customPage.getAtributeFirstName(),"hanh");
		Assert.assertEquals(customPage.getAtributeLastName(),"nguyen");
		Assert.assertEquals(customPage.getAtributeEmail(),emailAddress);
	}

	public String getEmailrandom() {
		Random rand = new Random();
		return "hanh" + rand.nextInt(9999) + "@gmail.com";
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
