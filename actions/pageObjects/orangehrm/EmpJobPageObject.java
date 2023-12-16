package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class EmpJobPageObject extends BaseAction{
	WebDriver driver;
	
	public EmpJobPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}