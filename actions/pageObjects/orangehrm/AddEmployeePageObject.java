package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.AddEmployeePageUI;

public class AddEmployeePageObject extends BaseAction{
	WebDriver driver;
	
	public AddEmployeePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToFirstName(String firstname) {
		waitForElementToVisibilite(driver, AddEmployeePageUI.FISTNAME_TBX);
		sendKey(driver, AddEmployeePageUI.FISTNAME_TBX, firstname);
		
	}

	public void enterToLastName(String lastname) {
		waitForElementToVisibilite(driver, AddEmployeePageUI.LASTNAME_TBX);
		sendKey(driver, AddEmployeePageUI.LASTNAME_TBX, lastname);// TODO Auto-generated method stub
		
	}

	public String getEmployeeID() {
		waitForElementToVisibilite(driver, AddEmployeePageUI.EMPLOYEE_ID);
	
		return getElementAttribute(driver, AddEmployeePageUI.EMPLOYEE_ID, "value");
	}

	public void clickSaveButton() {
		waitForElementToClickable(driver, AddEmployeePageUI.SAVE_BTN);
		clickToElement(driver, AddEmployeePageUI.SAVE_BTN);
	}


}
