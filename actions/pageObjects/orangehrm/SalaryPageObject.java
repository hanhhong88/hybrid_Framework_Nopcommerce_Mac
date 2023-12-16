package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class SalaryPageObject extends BaseAction{
	WebDriver driver;
	
	public SalaryPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
