package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.CustomerPageUI;

public class RewardPointObject extends MyAccountSideBarPage{
	WebDriver driver;

	public RewardPointObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
