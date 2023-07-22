package pageObject.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class CustomerPageObject extends BasePageFactory {
	WebDriver driver;
	
	@CacheLookup
	@FindBy(id = "FirstName")
	private WebElement firstNameTextbox;
	
	@FindBy(id = "LastName")
	private WebElement lastNameTextbox;

	@FindBy(id = "Email")
	private WebElement emailTextbox;
	
	public CustomerPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public String getAtributeFirstName() {
		waitForElementToVisibilite(driver, firstNameTextbox);
		return getAtribute(driver, firstNameTextbox, "value");
	}

	public String getAtributeLastName() {
		waitForElementToVisibilite(driver, lastNameTextbox);
		return getAtribute(driver, lastNameTextbox, "value");
	}

	public String getAtributeEmail() {
		waitForElementToVisibilite(driver, emailTextbox);
		return getAtribute(driver, emailTextbox, "value");
	}

}
