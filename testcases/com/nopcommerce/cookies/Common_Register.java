package com.nopcommerce.cookies;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.RegisterPageObject;

public class Common_Register extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private String password;
	public static String emailAddress, firstName, lastName;
	public static Set<Cookie> cookies;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.GetHomePageObject(driver);
		
		emailAddress = getEmailrandom();
		password = "123456";
		firstName = "hanh";
		lastName = "nguyen";
		
		registerPage = homePage.clickToRegisterlink();
		
		registerPage.enterToFirstNameTextbox(firstName);
		registerPage.enterToLastNameTextbox(lastName);
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.clicktoRegisterButton();

		Assert.assertEquals(registerPage.getSuccessMsgText(), "Your registration completed");
		
		homePage = registerPage.clickToNopCommerceImg();
		loginPage = homePage.clickToLoginlink();

		loginPage.entertoEmailTextbox(emailAddress);
		loginPage.entertoPassWordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		homePage.Sleepinsecond(5);
		homePage.refresh(driver);
		
		cookies = registerPage.getBrowserCookies(driver);

	}

	@Test
	public void Register_05_ValidData() {
		

	}
	
	@AfterTest
	public void afterClass() {
		driver.quit();
	}

}
