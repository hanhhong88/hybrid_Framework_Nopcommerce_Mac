package pageObject.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory {
	WebDriver driver;
	
	@CacheLookup
	@FindBy(id = "Email")
	private WebElement emailTextbox;
	
	@FindBy(id = "Password")
	private WebElement passwordTextbox;
	
	@FindBy(xpath = "//button[text() = 'Log in']")
	private WebElement loginButton;
	

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void entertoEmailTextbox(String emailAddress) {
		waitForElementToVisibilite(driver, emailTextbox);
		sendKey(driver, emailTextbox, emailAddress);
		
	}

	public void entertoPassWordTextbox(String password) {
		waitForElementToVisibilite(driver, passwordTextbox);
		sendKey(driver, passwordTextbox, password);
		
	}

	public void clickToLoginButton() {
		waitForElementToClickable(driver, loginButton);
		clickToElement(driver, loginButton);
		
	}

}
