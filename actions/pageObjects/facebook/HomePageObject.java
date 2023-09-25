package pageObjects.facebook;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clicktoCreateNewAccountButton() {
		// TODO Auto-generated method stub
		waitForElementToClickable(driver, HomePageUI.CREAT_NEW_ACC_BTN);
		clickToElement(driver, HomePageUI.CREAT_NEW_ACC_BTN);
	}

	public boolean isFirstNametxbDisplayed() {
		waitForElementToVisibilite(driver, HomePageUI.FIRST_NAME_TXB);
		return isElementDisplayed(driver, HomePageUI.FIRST_NAME_TXB);
	}

	public boolean isSureNametxbDisplayed() {
		waitForElementToVisibilite(driver, HomePageUI.SURE_NAME_TXB);
		return isElementDisplayed(driver, HomePageUI.SURE_NAME_TXB);
	}

	public boolean isEmailtxbDisplayed() {
		waitForElementToVisibilite(driver, HomePageUI.EMAIL_TXB);
		return isElementDisplayed(driver, HomePageUI.EMAIL_TXB);
	}

	public boolean isPasswdtxbDisplayed() {
		waitForElementToVisibilite(driver, HomePageUI.PASSWORD_TXB);
		return isElementDisplayed(driver, HomePageUI.PASSWORD_TXB);
	}

	public void enterToEmailtxb(String emailAddress) {
		waitForElementToVisibilite(driver, HomePageUI.EMAIL_TXB);
		sendKey(driver, HomePageUI.EMAIL_TXB, emailAddress);

	}

	public boolean isConfirmEmailTxtboxDisplayed() {
		waitForElementToVisibilite(driver, HomePageUI.CONFIRM_EMAIL_TXB);
		return isElementDisplayed(driver, HomePageUI.CONFIRM_EMAIL_TXB);
	}

	public void clicktoCloseSignUpPopup() {
		waitForElementToClickable(driver, HomePageUI.CLOSE_BTN);
		clickToElement(driver, HomePageUI.CLOSE_BTN);

	}

	public boolean isFirstNametxbUnDisplayed() {
		return isElementUnDisplayed(driver, HomePageUI.FIRST_NAME_TXB);
	}

	public boolean isSureNametxbUnDisplayed() {
		return isElementUnDisplayed(driver, HomePageUI.SURE_NAME_TXB);
	}

	public boolean isEmailtxbUnDisplayed() {
		return isElementUnDisplayed(driver, HomePageUI.EMAIL_TXB);
	}

	public boolean isPasswdtxbUnDisplayed() {
		return isElementUnDisplayed(driver, HomePageUI.PASSWORD_TXB);
	}
	


}
