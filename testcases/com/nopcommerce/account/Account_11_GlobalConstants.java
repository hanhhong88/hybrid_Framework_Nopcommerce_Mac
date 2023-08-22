package com.nopcommerce.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.UserLoginPageObject;

public class Account_11_GlobalConstants extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private UserLoginPageObject userLoginPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private String adminUrl, userUrl;
	
	private String emailAddress = getEmailrandom();
	private String adminURL = GlobalConstants.DEV_ADMIN_URL;
	private String userURL = GlobalConstants.DEV_USER_URL; 

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName, userUrl);
		homePage = PageGeneratorManager.GetHomePageObject(driver);
	}
	
	@Test
	public void Register_01_UserToAdmin() {
		registerPage = homePage.clickToRegisterlink();
		
		registerPage.enterToFirstNameTextbox("hanh");
		registerPage.enterToLastNameTextbox("nguyen");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");
		registerPage.clicktoRegisterButton();

		Assert.assertEquals(registerPage.getSuccessMsgText(), "Your registration completed");
		homePage = registerPage.clickToNopCommerceImg();
		userLoginPage = homePage.clickToLoginlink();
		homePage = userLoginPage.loginToUser(emailAddress,"123456");
		homePage.clickToLogoutButton();
		
		
		
		//From User to Admin page login
		homePage.openPageUrl(driver, adminUrl);
		adminLoginPage = PageGeneratorManager.GetAdminLoginPageObject(driver);

		adminDashboardPage = adminLoginPage.loginToAdmin(GlobalConstants.DEV_ADMIN_USERNAME, GlobalConstants.DEV_ADMIN_PASS);
		Assert.assertTrue(adminDashboardPage.isPageLoadedSuccess(driver));
	}

	@Test
	public void Register_02_AdminToUser() {
		adminLoginPage = adminDashboardPage.clickToLogoutButton();
		
		//admin Login page to User page
		adminLoginPage.openPageUrl(driver,userUrl);
		
		homePage = PageGeneratorManager.GetHomePageObject(driver);
		userLoginPage = homePage.clickToLoginlink();
		homePage = userLoginPage.loginToUser(emailAddress,"123456");
	
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
