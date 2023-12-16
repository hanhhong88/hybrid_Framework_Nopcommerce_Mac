package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.LoginPageUI;

public class LoginPageObject  extends BaseAction{
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void inputToUsername(String username) {
		waitForElementToVisibilite(driver, LoginPageUI.USERNAME);
		sendKey(driver, LoginPageUI.USERNAME, username);
		
		
	}

	public void inputToPassword(String password) {
		waitForElementToVisibilite(driver, LoginPageUI.PASSWORD);
		sendKey(driver, LoginPageUI.PASSWORD, password);
		
	}

	public DashboardPageObject clickToLogin() {
		waitForElementToClickable(driver, LoginPageUI.LOGINBTN);
		clickToElement(driver, LoginPageUI.LOGINBTN);
		waitForSpinnerIconInvisibile();
		return pageObjectManager.getDashboardPage(driver);
	} 

}
