package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class ImmigrationPageObject  extends BaseAction{
	WebDriver driver;
	
	public ImmigrationPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
