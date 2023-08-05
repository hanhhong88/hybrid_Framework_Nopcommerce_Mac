package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.admin.AdminDashboardPageUI;
import pageUIs.user.HomePageUI;

public class AdminDashboardPageObject extends BasePage{
	WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public AdminLoginPageObject clickToLogoutButton() {
		waitForElementToClickable(driver, AdminDashboardPageUI.LOGOUT_LINK);
		clickToElement(driver, AdminDashboardPageUI.LOGOUT_LINK);
		return PageGeneratorManager.GetAdminLoginPageObject(driver);
		
	}
	

}
