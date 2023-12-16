package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.BaseActionPageUI;
import pageUIs.orangehrm.PersonalDetailsPageUI;

public class PersonalDetailsPageObject  extends BaseAction{
	WebDriver driver;
	
	public PersonalDetailsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getFirstName() {
		waitForElementToVisibilite(driver, PersonalDetailsPageUI.FIRSTNAME_TXB);
		return getElementAttribute(driver, PersonalDetailsPageUI.FIRSTNAME_TXB, "value");
	}

	public String getLastName() {
		waitForElementToVisibilite(driver, PersonalDetailsPageUI.LASTNAME_TXB);
		return getElementAttribute(driver, PersonalDetailsPageUI.LASTNAME_TXB, "value");
	}

	public String getEmployeeID() {
		waitForElementToVisibilite(driver, PersonalDetailsPageUI.EMPLOYEE_ID);
		return getElementAttribute(driver, PersonalDetailsPageUI.EMPLOYEE_ID, "value");
	}

	public EmployeeListPageObject clickToEmployeeListButton() {
		waitForElementToClickable(driver, PersonalDetailsPageUI.EMPLOYEE_LIST_BTN);
		clickToElement(driver, PersonalDetailsPageUI.EMPLOYEE_LIST_BTN);
		waitForSpinnerIconInvisibile();
		return pageObjectManager.getEmployeeListPage(driver);
	}

	public boolean isPersonalDetailHeaderDisplayed() {
		waitForElementToVisibilite(driver, PersonalDetailsPageUI.PERSONAL_DETAILED_HEADER);
		return isElementDisplayed(driver, PersonalDetailsPageUI.PERSONAL_DETAILED_HEADER);
	} 

}
