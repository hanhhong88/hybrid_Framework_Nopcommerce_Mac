package pageUIs.jquery;

public class HomePageUI {
	public static final String COLUMN_TXT_BY_NAME = "//div[text() = '%s']//parent::div//following-sibling::input";
	public static final String PAGING_BY_NUMBER = "//a[@class = 'qgrd-pagination-page-link' and text() = '%s']";
	public static final String PAGING_BY_NUMBER_ACTIVE = "//a[@class = 'qgrd-pagination-page-link active' and text() = '%s']";
	public static final String ROW_DYNAMIC_VALUE = "//td[@data-key = 'females'  and text() = '%s']//following-sibling::td[@data-key = 'country' and text() = '%s']//following-sibling::td[@data-key = 'males' and text() = '%s']//following-sibling::td[@data-key = 'total' and text() = '%s']";
	public static final String BUTTON_DYNAMIC = "//td[@data-key = 'country' and text() = '%s']/preceding-sibling::td[@class = 'qgrd-actions']/button[contains(@class, '%s')]";
}
