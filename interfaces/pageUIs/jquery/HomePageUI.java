package pageUIs.jquery;

public class HomePageUI {
	public static final String COLUMN_TXT_BY_NAME = "//div[text() = '%s']//parent::div//following-sibling::input";
	public static final String PAGING_BY_NUMBER = "//a[@class = 'qgrd-pagination-page-link' and text() = '%s']";
	public static final String PAGING_BY_NUMBER_ACTIVE = "//a[@class = 'qgrd-pagination-page-link active' and text() = '%s']";
	public static final String ROW_DYNAMIC_VALUE = "//td[@data-key = 'females'  and text() = '%s']//following-sibling::td[@data-key = 'country' and text() = '%s']//following-sibling::td[@data-key = 'males' and text() = '%s']//following-sibling::td[@data-key = 'total' and text() = '%s']";
	public static final String BUTTON_DYNAMIC = "//td[@data-key = 'country' and text() = '%s']/preceding-sibling::td[@class = 'qgrd-actions']/button[contains(@class, '%s')]";
	public static final String ALL_PAGE_LINKS = "//a[contains(@class, 'qgrd-pagination-page-link')]";
	public static final String COLUMN_INDEX_BY_COLUMN_NAME = "//div[text() = '%s'] / ancestor::th/preceding-sibling::th";
	
	public static final String ALL_VALUE_BY_COLUMN_INDEX= "//tr/td[%s]";
	
	public static final String DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME = "//th[text() = '%s']//preceding-sibling::th";
	public static final String DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX = "//tr[%s]//td[%s]//input";
	public static final String DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX = "//tr[%s]//td[%s]//select";
	public static final String DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX = "//tr[%s]//td[%s]//input[@type='checkbox']";
}
