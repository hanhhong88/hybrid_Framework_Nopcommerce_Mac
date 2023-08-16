package pageObjects.jquery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToColumnTextBoxByName(String valueToSend, String ColumnName) {
		waitForElementToVisibilite(driver, HomePageUI.COLUMN_TXT_BY_NAME, ColumnName);
		sendKey(driver, HomePageUI.COLUMN_TXT_BY_NAME, valueToSend, ColumnName);
	}

	public void clickToPageByNumber(String pageNumber) {
		waitForElementToClickable(driver, HomePageUI.PAGING_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGING_BY_NUMBER, pageNumber);
	}

	public boolean isPageActive(String pageNumber) {
		waitForElementToVisibilite(driver, HomePageUI.PAGING_BY_NUMBER_ACTIVE, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGING_BY_NUMBER_ACTIVE, pageNumber);
	}
	
	public boolean isRowDisplayed(String females, String country, String male, String total) {
		waitForElementToVisibilite(driver, HomePageUI.ROW_DYNAMIC_VALUE, females, country, male, total);
		return isElementDisplayed(driver, HomePageUI.ROW_DYNAMIC_VALUE, females, country, male, total);
	}
	
	public void clickToAction(String country, String buttonName) {
		waitForElementToClickable(driver, HomePageUI.BUTTON_DYNAMIC, country, buttonName);
		clickToElement(driver, HomePageUI.BUTTON_DYNAMIC, country, buttonName);
	}

	public List<String> getAllPageValuesByColumnName(String columnName) {
		List<String> allValues = new ArrayList<String>();
		
		List<WebElement> allPageLInks = getElements(driver, HomePageUI.ALL_PAGE_LINKS);
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		
		for (WebElement page : allPageLInks) {
			page.click();
			Sleepinsecond(2);
			
			List<WebElement> allRowValues = getElements(driver, HomePageUI.ALL_VALUE_BY_COLUMN_INDEX, String.valueOf(columnIndex));
			
			for (WebElement rowValue:allRowValues) {
				allValues.add(rowValue.getText());
			}
		}
		return allValues;
	}

	public void enterToTextboxByColumnNameAndRowIndex(String columnName, String rowIndex, String valuetoSendKey) {
		int columnIndex = getElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		
		waitForElementToVisibilite(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		
		sendKey(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, valuetoSendKey, rowIndex, String.valueOf(columnIndex));
	}

	public void selectDropdownByColumnNameAndRowIndex(String columnName, String rowIndex, String dropDownOption) {
		int columnIndex = getElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		
		waitForElementToClickable(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, dropDownOption,rowIndex, String.valueOf(columnIndex));
	}

	public void selectCheckBoxByRowIndex(String columnName, String rowIndex) {
		int columnIndex = getElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		waitForElementToClickable(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		checkElement(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		
	}
	
	
	
}
