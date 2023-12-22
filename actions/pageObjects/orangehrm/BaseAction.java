package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.BaseActionPageUI;
import pageUIs.orangehrm.PersonalDetailsPageUI;

public class BaseAction extends BasePage{
	 
	WebDriver driver;

	public BaseAction(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitForSpinnerIconInvisibile() {
		waitForAllElementToInVisibilite(driver, BaseActionPageUI.SPINNER_ICON);
	}
	
	public boolean isSuccessMessageDisplayed(String dynamic_message) {
		waitForElementToVisibilite(driver, BaseActionPageUI.DYNAMIC_SUCCESS_MESS, dynamic_message);
		return isElementDisplayed(driver, BaseActionPageUI.DYNAMIC_SUCCESS_MESS, dynamic_message);
		// TODO Auto-generated method stub
		
	}
	
	public boolean isDisplayedValueAtColumn(String colum_name, String rowIndex, String row_value) {
		int column_index = getElementSize(driver, BaseActionPageUI.DYNAMIC_INDEX_BY_COLUMN_NAME, colum_name) + 1;
		return isElementDisplayed(driver, BaseActionPageUI.ROW_VALUE_BY_COLUMN_INDEX_ROW_INDEX, rowIndex,String.valueOf(column_index),row_value);
	}
	
	public void enterToSmokerCheckbox(String radioLabelName) {
		clickToElementByJS(driver, BaseActionPageUI.CLICK_TO_SMOKER_CHECKBOX_BY_LABEL_NAME, radioLabelName);
		
	}
	
	public void enterToMaleRadioButton(String checkboxByName) {
		if(!isElementSelected(driver, BaseActionPageUI.CLICK_TO_RADIO_BTN_BY_LABEL_NAME, checkboxByName)) {
			clickToElementByJS(driver, BaseActionPageUI.CLICK_TO_RADIO_BTN_BY_LABEL_NAME, checkboxByName);
		};
		
	}
	
	public boolean isGenderStatusSelected(String GenderStatus) {
		return isElementDisplayed(driver, BaseActionPageUI.RADIO_BTN_BY_LABEL_NAME, GenderStatus);
	}

	public boolean isSmokerSelected(String SmokerStatus) {
		return isElementDisplayed(driver, BaseActionPageUI.SMOKER_CHECKBOX_BY_LABEL_NAME, SmokerStatus);
	} 

}
