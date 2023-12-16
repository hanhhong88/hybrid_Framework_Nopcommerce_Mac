package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class DependencePageObject extends BaseAction{
	WebDriver driver;
	
	public DependencePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
