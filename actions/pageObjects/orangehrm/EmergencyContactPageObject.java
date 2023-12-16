package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class EmergencyContactPageObject extends BaseAction{
	WebDriver driver;
	
	public EmergencyContactPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
