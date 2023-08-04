package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.AddressPageObject;
import pageObjects.CustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.OrderPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.RewardPointObject;

public class PageGeneratorManager {
	public static HomePageObject GetHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static LoginPageObject GetLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
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

}
