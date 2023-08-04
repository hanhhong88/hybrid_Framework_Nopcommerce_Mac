package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.CustomerPageUI;

public class RewardPointObject extends BasePage{
	WebDriver driver;

	public RewardPointObject(WebDriver driver) {
		this.driver = driver;
	}
}
