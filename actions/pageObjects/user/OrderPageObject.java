package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.CustomerPageUI;

public class OrderPageObject extends MyAccountSideBarPage{
	WebDriver driver;

	public OrderPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
