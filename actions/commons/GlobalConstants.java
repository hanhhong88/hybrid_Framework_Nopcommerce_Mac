package commons;

import java.io.File;

public class GlobalConstants {
	public static final String DEV_ADMIN_URL = "https://admin-demo.nopcommerce.com";
	public static final String DEV_USER_URL = "https://demo.nopcommerce.com";
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final String DEV_ADMIN_USERNAME= "admin@yourstore.com";
	public static final String DEV_ADMIN_PASS = "admin";
	public static final String ADMIN_ORHRM_USERNAME = "automationfc_Hanhmac";
	public static final String ADMIN_ORHRM_PASSWORD = "automationfc_Hanhmac@123";
	
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String RELATIVE_PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_PATH = System.getProperty("user.dir") + "/uploadFile/";
	public static final String DOWNLOAD_PATH = System.getProperty("user.dir") + "/downloadFiles/";
	public static final String REPORTING_IMAGE_PATH = RELATIVE_PROJECT_PATH + File.separator + "ReportNGScreenShots" + File.separator;
}
