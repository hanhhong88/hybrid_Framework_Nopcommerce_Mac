package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class ReportPageObject extends BaseAction{
	WebDriver driver;
	
	public ReportPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
