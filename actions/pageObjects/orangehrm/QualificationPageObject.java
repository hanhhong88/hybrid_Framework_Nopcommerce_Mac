package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class QualificationPageObject extends BaseAction{
	WebDriver driver;
	
	public QualificationPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
