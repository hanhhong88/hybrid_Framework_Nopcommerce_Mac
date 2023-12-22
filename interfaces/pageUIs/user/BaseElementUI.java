package pageUIs.user;

public class BaseElementUI {
	public static final String NOP_COMMERCE_LOGO = "xpath= //img[@alt = 'nopCommerce demo store']";
	public static final String UPLOAD_FILE_TYPE = "xpath= //input[@name = 'files']";
	// dai dien cho 6 links tren Header truoc va sau login
	public static final String DYNAMIC_HEADER_LINK_BY_NAME = "xpath= //div[@class = 'header-links']//a[contains(string(), '%s')]";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath= //button[text() = '%s']";
	public static final String DYNAMIC_ERROR_TXB_BY_ID = "xpath= //span[@id = '%s-error']";
	public static final String DYNAMIC_INPUT_TXB_BY_ID = "xpath= //input[@id = '%s']";
	
}
