package com.nopcommerce.share;

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

public class Order extends BaseTest {
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

		loginPage.entertoEmailTextbox(Common_Register.emailAddress);
		loginPage.entertoPassWordTextbox(Common_Register.password);
		homePage = loginPage.clickToLoginButton();
		customPage = homePage.clicktoMyAccoutnLink();
		
		Assert.assertEquals(customPage.getAtributeFirstName(), Common_Register.firstName);
		Assert.assertEquals(customPage.getAtributeLastName(), Common_Register.lastName);
		Assert.assertEquals(customPage.getAtributeEmail(), Common_Register.emailAddress);
		
		System.out.println("Email at Order" + Common_Register.emailAddress);
		System.out.println("Password at Order" + Common_Register.password);
	}

	@Test
	public void Order_WrongEmail() {
		
	}
	
	
	@Test
	public void Order_WrongAddress() {
		
	}
	
	@Test
	public void Order_WrongNumber() {
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
