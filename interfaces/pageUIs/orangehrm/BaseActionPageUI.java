package pageUIs.orangehrm;

public class BaseActionPageUI {
	public static final String SPINNER_ICON = "css= div.oxd-loading-spiner-container";
	public static final String DYNAMIC_SUCCESS_MESS = "xpath= //p[contains(@class,'oxd-text--toast-message') and text() = '%s']";
	public static final String DYNAMIC_INDEX_BY_COLUMN_NAME = "xpath= //div[text() = '%s']/preceding-sibling::div";
	public static final String ROW_VALUE_BY_COLUMN_INDEX_ROW_INDEX = "xpath=//div[@class = 'oxd-table-card']/div[@role = 'row']['%s']/div['%s']/div[contains(text(), '%s')]";
}
