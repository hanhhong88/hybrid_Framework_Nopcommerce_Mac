package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BaseElement;
import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.MyAccountSideBarPageUI;

public class MyAccountSideBarPage extends BaseElement {
	WebDriver driver;

	public MyAccountSideBarPage(WebDriver driver) {
		super(driver);
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
	
	public MyAccountSideBarPage openDynamicPage(String pageName) {
		waitForElementToClickable(driver, MyAccountSideBarPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, MyAccountSideBarPageUI.DYNAMIC_LINK, pageName);
		switch(pageName) {
		case "Addresses":
			return PageGeneratorManager.GetAddressPageObject(driver);
		case "Orders":
			return PageGeneratorManager.GetOrderPageObject(driver);
		case "Reward points":
			return PageGeneratorManager.GetRewardPointObject(driver);
		default:
			new RuntimeException("Side bar is invalid");
			return null;
		}
	}
	
	public void openDynamicPage_NoReturn(String pageName) {
		waitForElementToClickable(driver, MyAccountSideBarPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, MyAccountSideBarPageUI.DYNAMIC_LINK, pageName);
	}
	
	
	
	
}
