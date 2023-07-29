package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.CustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

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

}
