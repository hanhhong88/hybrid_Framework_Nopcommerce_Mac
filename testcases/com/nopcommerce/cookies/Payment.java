package com.nopcommerce.cookies;

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

public class Payment extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private UserLoginPageObject loginPage;
	private CustomerPageObject customPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.GetHomePageObject(driver);
	
		loginPage = homePage.clickToLoginlink();

		loginPage.setCookies(driver, Common_Register.cookies);
		loginPage.Sleepinsecond(5);
		loginPage.refresh(driver);
	
		customPage = homePage.openMyAccoutnLink();
		
		Assert.assertEquals(customPage.getAtributeFirstName(), Common_Register.firstName);
		Assert.assertEquals(customPage.getAtributeLastName(), Common_Register.lastName);
		Assert.assertEquals(customPage.getAtributeEmail(), Common_Register.emailAddress);
	
	}

	@Test
	public void Pay_Visa() {
		
	}
	
	
	@Test
	public void Pay_Checque() {
		
	}
	
	@Test
	public void Pay_Paypal() {
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
