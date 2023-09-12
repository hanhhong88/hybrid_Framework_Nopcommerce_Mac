package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.user.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click to Register Link")
	public RegisterPageObject clickToRegisterlink() {
		waitForElementToClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.GetRegisterPageObject(driver);
	}

	@Step("Click to Login Link")
	public UserLoginPageObject clickToLoginlink() {
		waitForElementToClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.GetUserLoginPageObject(driver);
	}

	@Step("Click to MyAccount Link")
	public CustomerPageObject clicktoMyAccoutnLink() {
		waitForElementToClickable(driver, HomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MYACCOUNT_LINK);
		return PageGeneratorManager.GetCustomerPageObject(driver);
	}

	@Step("Click to Loggin Button")
	public HomePageObject clickToLogoutButton() {
		waitForElementToClickable(driver, HomePageUI.LOGOUT_LINK);
		clickToElement(driver, HomePageUI.LOGOUT_LINK);
		return PageGeneratorManager.GetHomePageObject(driver);
	}

	@Step("Verify Register Link is displayed")
	public boolean isRegisterLinkDisplayed() {
		waitForElementToVisibilite(driver, HomePageUI.REGISTER_LINK);
		return isElementDisplayed(driver, HomePageUI.REGISTER_LINK);
	}

}
