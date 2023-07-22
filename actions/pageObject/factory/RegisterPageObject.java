package pageObject.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {
	WebDriver driver;
	
	@CacheLookup
	@FindBy(id = "FirstName")
	private WebElement firstNameTextbox;
	
	@FindBy(id = "LastName")
	private WebElement lastNameTextbox;
	
	@FindBy(id = "Email")
	private WebElement emailAdress;
	
	@FindBy(id = "Password")
	private WebElement passwordTextbox;
	
	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPasswordTextbox;
	
	@FindBy(id = "register-button")
	private WebElement registerButton;
	
	@FindBy(id = "FirstName-error")
	private WebElement firstNameError;
	
	@FindBy(id = "LastName-error")
	private WebElement lastNameError;
	
	@FindBy(id = "Email-error")
	private WebElement emailError;
	
	@FindBy(id = "Password-error")
	private WebElement passwordError;
	
	@FindBy(id = "ConfirmPassword-error")
	private WebElement confirmPasswordError;
	
	@FindBy(xpath = "//div[@class = 'result']")
	private WebElement registertMsg;
	
	@FindBy(xpath = "//img[@alt = 'nopCommerce demo store']")
	private WebElement nopCommerceLogo;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void clicktoRegisterButton() {
		waitForElementToClickable(driver, registerButton);
		clickToElement(driver, registerButton);	
	}

	public String getFirstNameErrorMsgText() {
		waitForElementToVisibilite(driver, firstNameError);
		return getElementText(driver, firstNameError);
	}

	public String getLastNameErrorMsgText() {
		waitForElementToVisibilite(driver, lastNameError);
		return getElementText(driver, lastNameError);
	}

	public String getEmailErrorMsgText() {
		waitForElementToVisibilite(driver, emailError);
		return getElementText(driver, emailError);
	}

	public String getPasswordErrorMsgText() {
		waitForElementToVisibilite(driver, passwordError);
		return getElementText(driver, passwordError);
	}

	public void clickToNopCommerceImg() {
		waitForElementToClickable(driver, nopCommerceLogo);
		clickToElement(driver, nopCommerceLogo);
	}

	public void enterToFirstNameTextbox(String stringFN) {
		waitForElementToVisibilite(driver, firstNameTextbox);
		sendKey(driver, firstNameTextbox, stringFN);	
	}

	public void enterToLastNameTextbox(String stringLN) {
		waitForElementToVisibilite(driver, lastNameTextbox);
		sendKey(driver, lastNameTextbox, stringLN);
	}

	public void enterToEmailTextbox(String stringE) {
		waitForElementToVisibilite(driver, emailAdress);
		sendKey(driver, emailAdress, stringE);
	}

	public void enterToPasswordTextbox(String stringPW) {
		waitForElementToVisibilite(driver, passwordTextbox);
		sendKey(driver, passwordTextbox, stringPW);
	}

	public void enterToConfirmPasswordTextbox(String stringCPW) {
		waitForElementToVisibilite(driver, confirmPasswordTextbox);
		sendKey(driver, confirmPasswordTextbox, stringCPW);
	}

	public String getConfirm_PasswordErrorMsgText() {
		waitForElementToVisibilite(driver, confirmPasswordError);
		return getElementText(driver, confirmPasswordError);
	}

	public String getSuccessMsgText() {
		waitForElementToVisibilite(driver, registertMsg);
		return getElementText(driver, registertMsg);
	}

}
