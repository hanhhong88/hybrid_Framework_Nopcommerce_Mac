package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.EmployeeListPageUI;

public class EmployeeListPageObject  extends BaseAction{
	WebDriver driver;
	
	public EmployeeListPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public AddEmployeePageObject clickToAddEmployeeButton() {
		waitForElementToClickable(driver, EmployeeListPageUI.ADD_EMPLOYEE_BTN);
		clickToElement(driver, EmployeeListPageUI.ADD_EMPLOYEE_BTN);
		waitForSpinnerIconInvisibile();
		return pageObjectManager.getEmployeePage(driver);
	}

	public void inputToEmployeeIDtxb(String employeeID) {
		waitForElementToVisibilite(driver, EmployeeListPageUI.EMPLOYEE_ID_TXB);		
		sendKey(driver, EmployeeListPageUI.EMPLOYEE_ID_TXB, employeeID);
	}

	public void clickToSearchBtn() {
		waitForElementToClickable(driver, EmployeeListPageUI.SEARCH_BTN);
		clickToElement(driver, EmployeeListPageUI.SEARCH_BTN);
		waitForSpinnerIconInvisibile();
		
	}

	public PersonalDetailsPageObject clicktoEditEmployeeButton(String employeeID) {
		waitForElementToClickable(driver, EmployeeListPageUI.EDIT_BUTTON_BY_EMPLOYEE_ID, employeeID );
		clickToElement(driver, EmployeeListPageUI.EDIT_BUTTON_BY_EMPLOYEE_ID, employeeID);
		waitForSpinnerIconInvisibile();	
		return pageObjectManager.getPersonalDetailsPage(driver);
	} 

}
