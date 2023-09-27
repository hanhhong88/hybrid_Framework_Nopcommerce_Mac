package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.user.HomePageObject;
import pageUIs.user.BaseElementUI;
import pageUIs.user.CustomerPageUI;
import pageUIs.user.HomePageUI;
import pageUIs.user.RegisterPageUI;

public class BaseElement extends BasePage {
	WebDriver driver;

	public BaseElement(WebDriver driver) {
		this.driver = driver;
	}

	public HomePageObject clickToNopCommerceImg() {
		waitForElementToClickable(driver, BaseElementUI.NOP_COMMERCE_LOGO);
		clickToElement(driver, BaseElementUI.NOP_COMMERCE_LOGO);
		return PageGeneratorManager.GetHomePageObject(driver);

	}

	public void clickToHeaderLinkByName(String pageName) {
		waitForElementToClickable(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);
		clickToElement(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);
	}

//	Thao tac voi bat ky button nao o bat ky page nao
	public void clickToButtonByText(String buttonName) {
		waitForElementToClickable(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, buttonName);
		clickToElement(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, buttonName);

	}
	
// Get ra error msg cua cac truong trong bat ky page nao.
	public String getTxbErrorMsgByID(String ErrorMsgID) {
		waitForElementToVisibilite(driver,BaseElementUI.DYNAMIC_ERROR_TXB_BY_ID, ErrorMsgID);
		return getElementText(driver,BaseElementUI.DYNAMIC_ERROR_TXB_BY_ID, ErrorMsgID);
	}
	

	public void enterToTxbByID(String txbID, String value) {
		waitForElementToVisibilite(driver, BaseElementUI.DYNAMIC_INPUT_TXB_BY_ID, txbID );
		sendKey(driver, BaseElementUI.DYNAMIC_INPUT_TXB_BY_ID, value, txbID);
		
	}
// Get ra atribute cua Txb tai bat ky page nao
	public String getAtributeByID(String txbID) {
		waitForElementToVisibilite(driver, BaseElementUI.DYNAMIC_INPUT_TXB_BY_ID, txbID);
		return getElementAttribute(driver, BaseElementUI.DYNAMIC_INPUT_TXB_BY_ID, "value", txbID);
		
	}
}
