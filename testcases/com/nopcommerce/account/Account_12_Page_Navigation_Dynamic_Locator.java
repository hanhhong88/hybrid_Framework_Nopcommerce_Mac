package com.nopcommerce.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.AddressPageObject;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageUIs.user.MyAccountSideBarPageUI;
import pageObjects.user.OrderPageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.RewardPointObject;

public class Account_12_Page_Navigation_Dynamic_Locator extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private CustomerPageObject customPage;
	private AddressPageObject addressPage;
	private OrderPageObject orderPage;
	private RewardPointObject rewardPointpage;
	
	private String emailAddress = getEmailrandom();

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.GetHomePageObject(driver);
	}
	
	@Test
	public void Register_05_ValidData() {
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
	
	@Test
	public void Register_07_SwitchPage() {
		addressPage = (AddressPageObject) customPage.openDynamicPage("Addresses");
		
		orderPage = (OrderPageObject) customPage.openDynamicPage("Orders");
		
		rewardPointpage = (RewardPointObject) customPage.openDynamicPage("Reward points");
		
	}
	
	@Test
	public void Register_08_SwitchPage_NoCast() {
	 
		rewardPointpage.openDynamicPage_NoReturn("Addresses");
		addressPage = PageGeneratorManager.GetAddressPageObject(driver);
		
		
		addressPage.openDynamicPage("Orders");
		orderPage = PageGeneratorManager.GetOrderPageObject(driver);
		
		orderPage.openDynamicPage("Reward points");
		rewardPointpage = PageGeneratorManager.GetRewardPointObject(driver);
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
