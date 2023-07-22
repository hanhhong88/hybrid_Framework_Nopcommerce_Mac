package pageObject.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class HomePageObject extends BasePageFactory {
	WebDriver driver;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//a[@class = 'ico-register']")
	private WebElement registerLink;
	
	@FindBy(className = "ico-login")
	private WebElement loginLink;
	
	@FindBy(how = How.XPATH, using = "//a[@class = 'ico-account']")
	private WebElement myAccountLink;
	

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void clickToRegisterlink() {
		waitForElementToClickable(driver, registerLink);
		clickToElement(driver, registerLink);
		
	}

	public void clickToLoginlink() {
		waitForElementToClickable(driver, loginLink);
		clickToElement(driver, loginLink);
		
	}

	public void clicktoMyAccoutnLink() {
		waitForElementToClickable(driver, myAccountLink);
		clickToElement(driver, myAccountLink);
		
	}

}
