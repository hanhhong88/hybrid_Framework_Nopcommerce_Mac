package pageObjects.jquery;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jquery.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToColumnTextBoxByName(String valueToSend, String ColumnName) {
		waitForElementToVisibilite(driver, HomePageUI.COLUMN_TXT_BY_NAME, ColumnName);
		sendKey(driver, HomePageUI.COLUMN_TXT_BY_NAME, valueToSend, ColumnName);
	}

	public void clickToPageByNumber(String pageNumber) {
		waitForElementToClickable(driver, HomePageUI.PAGING_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGING_BY_NUMBER, pageNumber);
	}

	public boolean isPageActive(String pageNumber) {
		waitForElementToVisibilite(driver, HomePageUI.PAGING_BY_NUMBER_ACTIVE, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGING_BY_NUMBER_ACTIVE, pageNumber);
	}
	
	public boolean isRowDisplayed(String females, String country, String male, String total) {
		waitForElementToVisibilite(driver, HomePageUI.ROW_DYNAMIC_VALUE, females, country, male, total);
		return isElementDisplayed(driver, HomePageUI.ROW_DYNAMIC_VALUE, females, country, male, total);
	}
	
	public void clickToAction(String country, String buttonName) {
		waitForElementToClickable(driver, HomePageUI.BUTTON_DYNAMIC, country, buttonName);
		clickToElement(driver, HomePageUI.BUTTON_DYNAMIC, country, buttonName);
	}
	
}
