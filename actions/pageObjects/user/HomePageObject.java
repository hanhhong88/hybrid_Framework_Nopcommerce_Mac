package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterlink() {
		waitForElementToClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.GetRegisterPageObject(driver);
	}

	public UserLoginPageObject clickToLoginlink() {
		waitForElementToClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.GetUserLoginPageObject(driver);
	}

	public CustomerPageObject clicktoMyAccoutnLink() {
		waitForElementToClickable(driver, HomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MYACCOUNT_LINK);
		return PageGeneratorManager.GetCustomerPageObject(driver);
	}

	public HomePageObject clickToLogoutButton() {
		waitForElementToClickable(driver, HomePageUI.LOGOUT_LINK);
		clickToElement(driver, HomePageUI.LOGOUT_LINK);
		return PageGeneratorManager.GetHomePageObject(driver);
	}

	public boolean isRegisterLinkDisplayed() {
		waitForElementToVisibilite(driver, HomePageUI.REGISTER_LINK);
		return isElementDisplayed(driver, HomePageUI.REGISTER_LINK);
	}

}
