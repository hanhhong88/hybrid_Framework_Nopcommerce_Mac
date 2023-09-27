package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BaseElement;
import commons.PageGeneratorManager;
import pageUIs.user.UserLoginPageUI;

public class UserLoginPageObject extends BaseElement {
	WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void entertoEmailTextbox(String emailAddress) {
		waitForElementToVisibilite(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendKey(driver, UserLoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void entertoPassWordTextbox(String password) {
		waitForElementToVisibilite(driver, UserLoginPageUI.PASS_TEXTBOX);
		sendKey(driver, UserLoginPageUI.PASS_TEXTBOX, password);
	}

	public HomePageObject clickToLoginButton() {
		waitForElementToClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.GetHomePageObject(driver);
	}
	
	public HomePageObject loginToUser(String emailAddress, String password) {
		entertoEmailTextbox(emailAddress);
		entertoPassWordTextbox(password);
		return clickToLoginButton();
		
		
	}

}
