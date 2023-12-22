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

	public void enterToNickNameTextBox(String nickname) {
		waitForElementToVisibilite(driver, PersonalDetailsPageUI.NICK_NAME_TXB);
		sendKey(driver, PersonalDetailsPageUI.NICK_NAME_TXB, nickname);
	}

	public void enterToDriverLicenseNumberTextBox(String DriverLicenseNumber) {
		waitForElementToVisibilite(driver, PersonalDetailsPageUI.DRIVER_LICENSE_NUMBER_TXB);
		sendKey(driver, PersonalDetailsPageUI.DRIVER_LICENSE_NUMBER_TXB, DriverLicenseNumber);
	}

	public void enterToLicenseExpiryDatePicker(String LicenseExpiryDate) {
		waitForElementToVisibilite(driver, PersonalDetailsPageUI.DRIVER_LICENSE_EXPIRY_DATE_PICKER);
		sendKey(driver, PersonalDetailsPageUI.DRIVER_LICENSE_EXPIRY_DATE_PICKER, LicenseExpiryDate);
	}

	public void enterToSecuritySocialNumberTextBox(String SocialSecurityDate) {
		waitForElementToVisibilite(driver, PersonalDetailsPageUI.SOCIAL_SECURITY_NUMBER_TXB);
		sendKey(driver, PersonalDetailsPageUI.SOCIAL_SECURITY_NUMBER_TXB, SocialSecurityDate);
	}

	public void enterToSocialInsuranceNumberTextBox(String SocialInsuranceNumber) {
		waitForElementToVisibilite(driver, PersonalDetailsPageUI.SOCIAL_INSURANCE_TXB);
		sendKey(driver, PersonalDetailsPageUI.SOCIAL_INSURANCE_TXB, SocialInsuranceNumber);
	}

	public void enterToNationalityDropdown(String Nationality) {
		waitForElementToClickable(driver, PersonalDetailsPageUI.NATIONAL_STATUS_DROPDOWN_ICON);
		selectItemInDropdown(driver, PersonalDetailsPageUI.NATIONAL_STATUS_DROPDOWN_ICON, PersonalDetailsPageUI.NATIONAL_STATUS_DROPDOWN_OPTION, Nationality);
	}

	public void enterToMartialDropdown(String MartialStatus) {
		waitForElementToClickable(driver, PersonalDetailsPageUI.MARTIAL_STATUS_DROPDOWN_ICON);
		selectItemInDropdown(driver, PersonalDetailsPageUI.MARTIAL_STATUS_DROPDOWN_ICON, PersonalDetailsPageUI.MARTIAL_STATUS_DROPDOWN_OPTION, MartialStatus);
	}

	public void enterToDateofBirthPicker(String DateofBirth) {
		waitForElementToVisibilite(driver, PersonalDetailsPageUI.DATE_OF_BIRTH);
		sendKey(driver, PersonalDetailsPageUI.DATE_OF_BIRTH, DateofBirth);
	}

	public void clickToSaveButtonAtPersonalDetailPart() {
		waitForElementToClickable(driver, PersonalDetailsPageUI.SAVE_BUTTON_AT_PERSONAL_DETAILED);
		clickToElement(driver, PersonalDetailsPageUI.SAVE_BUTTON_AT_PERSONAL_DETAILED);
	}

	public String getNationalDropdownTxb() {
		return getElementText(driver, PersonalDetailsPageUI.NATIONAL_STATUS_SELECTED);
	}

	public String getMartialDropdownTxb() {
		return getElementText(driver, PersonalDetailsPageUI.MARTIAL_STATUS_SELECTED);
	}



}
