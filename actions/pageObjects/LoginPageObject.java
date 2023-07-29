package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void entertoEmailTextbox(String emailAddress) {
		waitForElementToVisibilite(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKey(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void entertoPassWordTextbox(String password) {
		waitForElementToVisibilite(driver, LoginPageUI.PASS_TEXTBOX);
		sendKey(driver, LoginPageUI.PASS_TEXTBOX, password);
	}

	public HomePageObject clickToLoginButton() {
		waitForElementToClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.GetHomePageObject(driver);
	}

}
