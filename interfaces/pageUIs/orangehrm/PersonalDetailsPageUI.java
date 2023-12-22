package pageUIs.orangehrm;

public class PersonalDetailsPageUI {
	public final static String FIRSTNAME_TXB = "css= input[name='firstName']";
	public final static String LASTNAME_TXB = "css= input[name='lastName']";
	public final static String EMPLOYEE_ID = "xpath= //label[text()='Employee Id']//parent::div//following-sibling::div/input";
	public static final String EMPLOYEE_LIST_BTN = "xpath= //a[text() = 'Employee List']";
	public static final String PERSONAL_DETAILED_HEADER = "xpath= //h6[text() = 'Personal Details']";
	public static final String SAVE_BUTTON_AT_PERSONAL_DETAILED = "xpath= //div[contains(@class, 'orangehrm-horizontal-padding orangehrm-vertical-padding')]//button[contains(string(), 'Save')]";
	public static final String NICK_NAME_TXB = "xpath= //label[text()='Nickname']//parent::div//following-sibling::div/input";
	public static final String DRIVER_LICENSE_NUMBER_TXB = "xpath= //label[contains(text(),\"Driver's License Number\")]//parent::div//following-sibling::div/input";
	public static final String DRIVER_LICENSE_EXPIRY_DATE_PICKER = "xpath= //label[contains(text(),'License Expiry Date')]//parent::div//following-sibling::div//input";
	public static final String SOCIAL_SECURITY_NUMBER_TXB = "xpath= //label[contains(text(),'SSN Number')]//parent::div//following-sibling::div//input";
	public static final String SOCIAL_INSURANCE_TXB = "xpath= //label[contains(text(),'SIN Number')]//parent::div//following-sibling::div//input";
	public static final String NATIONAL_STATUS_DROPDOWN_ICON= "xpath= //label[contains(text(),'Nationality')]//parent::div//following-sibling::div//i";
	public static final String NATIONAL_STATUS_DROPDOWN_OPTION = "xpath= //label[contains(text(),'Nationality')]//parent::div//following-sibling::div//div[@class = 'oxd-select-option']/span";
	public static final String NATIONAL_STATUS_SELECTED = "xpath= //label[contains(text(),'Nationality')]//parent::div//following-sibling::div//div[@class = 'oxd-select-text-input']";
	public static final String MARTIAL_STATUS_DROPDOWN_ICON = "xpath= //label[contains(text(),'Marital Status')]//parent::div//following-sibling::div//i";
	public static final String MARTIAL_STATUS_DROPDOWN_OPTION = "xpath= //label[contains(text(),'Marital Status')]//parent::div//following-sibling::div//div[@class = 'oxd-select-option']/span";
	public static final String MARTIAL_STATUS_SELECTED = "xpath= //label[contains(text(),'Marital Status')]//parent::div//following-sibling::div//div[@class = 'oxd-select-text-input']";
	public static final String DATE_OF_BIRTH = "xpath= //label[contains(text(),'Date of Birth')]//parent::div//following-sibling::div//input";
}
