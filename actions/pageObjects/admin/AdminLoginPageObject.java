package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage{
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForElementToVisibilite(driver, AdminLoginPageUI.EMAIL_ADDRESS_LINK);
		sendKey(driver, AdminLoginPageUI.EMAIL_ADDRESS_LINK, emailAddress);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementToVisibilite(driver, AdminLoginPageUI.PASSWORD_TXT);
		sendKey(driver, AdminLoginPageUI.PASSWORD_TXT, password);
	}

	public AdminDashboardPageObject clickToLoginButton() {
		waitForElementToClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.GetAdminDashboardPageObject(driver);
	}
	
	public AdminDashboardPageObject loginToAdmin(String emailAddress, String password) {
		enterToEmailTextbox(emailAddress);
		enterToPasswordTextbox(password);
		return clickToLoginButton();
	}

}
