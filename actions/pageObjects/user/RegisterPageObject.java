package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;
	

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clicktoRegisterButton() {
		waitForElementToClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.GetRegisterPageObject(driver);
	}

	public String getFirstNameErrorMsgText() {
		waitForElementToVisibilite(driver, RegisterPageUI.FIRSTNAME_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.FIRSTNAME_ERROR_MSG);
	}

	public String getLastNameErrorMsgText() {
		waitForElementToVisibilite(driver, RegisterPageUI.LASTNAME_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.LASTNAME_ERROR_MSG);
	}

	public String getEmailErrorMsgText() {
		waitForElementToVisibilite(driver, RegisterPageUI.EMAIL_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MSG);
	}

	public String getPasswordErrorMsgText() {
		waitForElementToVisibilite(driver, RegisterPageUI.PASSWORD_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MSG);
	}

	public HomePageObject clickToNopCommerceImg() {
		waitForElementToClickable(driver, RegisterPageUI.NOP_COMMERCE_LOGO);
		clickToElement(driver, RegisterPageUI.NOP_COMMERCE_LOGO);
		return PageGeneratorManager.GetHomePageObject(driver);
		
	}

	public void enterToFirstNameTextbox(String firstName) {
		waitForElementToVisibilite(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKey(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
		
	}

	public void enterToLastNameTextbox(String lastName) {
		waitForElementToVisibilite(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendKey(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}

	public void enterToEmailTextbox(String Email) {
		waitForElementToVisibilite(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKey(driver, RegisterPageUI.EMAIL_TEXTBOX, Email);
	}

	public void enterToPasswordTextbox(String passWord) {
		waitForElementToVisibilite(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKey(driver, RegisterPageUI.PASSWORD_TEXTBOX, passWord);
	}

	public void enterToConfirmPasswordTextbox(String passWord) {
		waitForElementToVisibilite(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKey(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, passWord);	
	}

	public String getSuccessMsgText() {
		waitForElementToVisibilite(driver, RegisterPageUI.REGISTER_MSG);
		return getElementText(driver, RegisterPageUI.REGISTER_MSG);
	}

	public String getConfirm_PasswordErrorMsgText() {
		waitForElementToVisibilite(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);
	}

}
