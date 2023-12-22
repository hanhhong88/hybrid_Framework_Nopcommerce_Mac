package pageUIs.orangehrm;

public class EmployeeListPageUI {
	public static final String ADD_EMPLOYEE_BTN = "xpath= //a[text() = 'Add Employee']";
	public static final String EMPLOYEE_ID_TXB = "xpath= //label[text()='Employee Id']//parent::div//following-sibling::div/input";
	public static final String SEARCH_BTN = "xpath= //button[@type = 'submit']";
	public static final String EDIT_BUTTON_BY_EMPLOYEE_ID = "xpath= //div[text() = '%s']//parent::div//following-sibling::div//div[@class = 'oxd-table-cell-actions']//i[contains(@class,'oxd-icon bi-pencil-fill')]";
}
