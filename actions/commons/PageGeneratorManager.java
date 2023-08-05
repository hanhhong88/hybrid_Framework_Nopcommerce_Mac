package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.AddressPageObject;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.OrderPageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.RewardPointObject;

public class PageGeneratorManager {
	public static HomePageObject GetHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static UserLoginPageObject GetUserLoginPageObject(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	
	public static RegisterPageObject GetRegisterPageObject(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static CustomerPageObject GetCustomerPageObject(WebDriver driver) {
		return new CustomerPageObject(driver);
	}
	
	public static AddressPageObject GetAddressPageObject(WebDriver driver) {
		return new AddressPageObject(driver);
	}
	
	public static OrderPageObject GetOrderPageObject(WebDriver driver) {
		return new OrderPageObject(driver);
	}
	
	public static RewardPointObject GetRewardPointObject(WebDriver driver) {
		return new RewardPointObject(driver);
	}
	
	public static AdminLoginPageObject GetAdminLoginPageObject(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	public static AdminDashboardPageObject GetAdminDashboardPageObject(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}

}
