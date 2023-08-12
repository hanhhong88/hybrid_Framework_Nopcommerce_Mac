package pageObjects.user;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.CustomerPageUI;

public class CustomerPageObject extends MyAccountSideBarPage {
	WebDriver driver;

	public CustomerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public CustomerPageObject(WebDriver driver, long timeout ) {
		super(driver);
		this.driver = driver;
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
	}

	public String getAtributeFirstName() {
		waitForElementToVisibilite(driver, CustomerPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getAtributeLastName() {
		waitForElementToVisibilite(driver, CustomerPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getAtributeEmail() {
		waitForElementToVisibilite(driver, CustomerPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.EMAIL_TEXTBOX, "value");
	}
}