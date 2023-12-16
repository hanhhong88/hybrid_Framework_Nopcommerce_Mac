package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.DashboardPageUI;

public class DashboardPageObject extends BaseAction{
	WebDriver driver;
	
	public DashboardPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public EmployeeListPageObject openPIM_Module() {
		waitForElementToClickable(driver, DashboardPageUI.PIM_MODULE);
		clickToElement(driver, DashboardPageUI.PIM_MODULE);
		waitForSpinnerIconInvisibile();
		return pageObjectManager.getEmployeeListPage(driver);
	} 

}
