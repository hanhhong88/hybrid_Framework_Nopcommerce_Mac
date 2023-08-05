package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.MyAccountSideBarPageUI;

public class MyAccountSideBarPage extends BasePage {
	WebDriver driver;

	public MyAccountSideBarPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public AddressPageObject openAddressPage() {
		waitForElementToClickable(driver, MyAccountSideBarPageUI.ADDRESS_LINK);
		clickToElement(driver, MyAccountSideBarPageUI.ADDRESS_LINK);
		return PageGeneratorManager.GetAddressPageObject(driver);
	}

	public OrderPageObject openOrderPage() {
		waitForElementToClickable(driver, MyAccountSideBarPageUI.ORDER_LINK);
		clickToElement(driver, MyAccountSideBarPageUI.ORDER_LINK);
		return PageGeneratorManager.GetOrderPageObject(driver);

	}

	public RewardPointObject openRewardPointPage() {
		waitForElementToClickable(driver, MyAccountSideBarPageUI.REWARD_POINT_LINK);
		clickToElement(driver, MyAccountSideBarPageUI.REWARD_POINT_LINK);
		return PageGeneratorManager.GetRewardPointObject(driver);
	}
}
