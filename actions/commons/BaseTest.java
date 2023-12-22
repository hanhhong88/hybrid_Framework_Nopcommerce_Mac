package commons;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	protected final Logger log;
	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	@BeforeSuite
	public void deleteAllFilesInReport() {
		deleteAllFileInFolder("allure-json");
	}

	public void deleteAllFileInFolder(String folderName) {
		try {
			String pathFolderDownload = GlobalConstants.RELATIVE_PROJECT_PATH + File.separator + folderName;
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					System.out.println(listOfFiles[i].getName());
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	public BaseTest() {
		log = LogManager.getLogger(getClass());
	}

//	private String projectPath = System.getProperty("user.dir");
	@SuppressWarnings("deprecation")
	protected WebDriver getBrowserName(String browserName) {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

////		use SeleniumrManager
//		if (browser == BrowserList.FIREFOX) {
//		driver = new FirefoxDriver();
//	} else if (browser == BrowserList.CHROME) {
//		driver = new ChromeDriver();
//	} else if (browser == BrowserList.EDGE) {
//		driver = new EdgeDriver();
//	} else {
//		throw new RuntimeException("Wrong browser Name");
//	}

//		use WebDriverManager
//		if (browser == BrowserList.FIREFOX) {
//		driver = WebDriverManager.firefoxdriver().create();
//	} else if (browser == BrowserList.CHROME) {
//		driver = WebDriverManager.chromedriver().create();
//	} else if (browser == BrowserList.EDGE) {
//		driver = WebDriverManager.edgedriver().create();
//	} else {
//		throw new RuntimeException("Wrong browser Name");
//	}	

//		Use Enum
//		if (browser == BrowserList.FIREFOX) {
//			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//			driver = new FirefoxDriver();
//		} else if (browser == BrowserList.CHROME) {
//			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
//			driver = new ChromeDriver();
//		} else if (browser == BrowserList.EDGE) {
//			System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
//			driver = new EdgeDriver();
//		} else {
//			throw new RuntimeException("Wrong browser Name");
//		}

//		do not use Enum		
//		if (browserName.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//			driver = new FirefoxDriver();
//		} else if (browserName.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
//			driver = new ChromeDriver();
//		} else if (browserName.equalsIgnoreCase("edge")) {
//			System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
//			driver = new EdgeDriver();
//		} else {
//			throw new RuntimeException("Wrong browser Name");
//		}

//		do not use Enum
		switch (browserName) {
		case "firefox":
//			tu tai ve + tu setting
//			System.setProperty("webdriver.gecko.driver", GlobalConstants.RELATIVE_PROJECT_PATH + "\\browserDrivers\\geckodriver.exe");

//			WebDriverManager 5.x: Tai ve driver + setting bien moi truong va khoi tao browser len
//			driver = WebDriverManager.firefoxdriver().create();

//			Selenium manager (Selenium version 4.6.0 tro len)
//			FirefoxProfile profile = new FirefoxProfile();
//			File browserExtention = new File(GlobalConstants.BROWSER_EXTENTION_PATH + "wappalyzer-6.10.67.xpi");
//			profile.addExtension(browserExtention);
//			FirefoxOptions option = new FirefoxOptions();
//			option.setProfile(profile);
//			driver = new FirefoxDriver(option);
			
			driver = new FirefoxDriver();
			Path xpipath = Paths.get(GlobalConstants.BROWSER_EXTENTION_PATH + "wappalyzer-6.10.67.xpi");
			FirefoxDriver ffdriver = (FirefoxDriver) driver;
			ffdriver.installExtension(xpipath);
			driver = ffdriver;
			
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					GlobalConstants.RELATIVE_PROJECT_PATH + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "edge":
			System.setProperty("webdriver.edge.driver",
					GlobalConstants.RELATIVE_PROJECT_PATH + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		
		case "FIREFOX_HEADLESS":
			FirefoxOptions ffoption = new FirefoxOptions();
			ffoption.addArguments("--headless");
			ffoption.addArguments("window-size=1600x900");
			driver = new FirefoxDriver(ffoption);
		break;
			
//
		default:
			throw new RuntimeException("Wrong browser Name");
		}

//		use Enum
//		
//		switch (browser) {
//		case FIREFOX:
//			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//			driver = new FirefoxDriver();
//			break;
//		case CHROME:
//			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
//			driver = new ChromeDriver();
//			break;
//			
//		case EDGE:
//			System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
//			driver = new EdgeDriver();
//			break;
//
//		default:
//			throw new RuntimeException("Wrong browser Name");
//		}

		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(1920, 1080));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		return driver;
	}

	protected WebDriver getBrowserName(String browserName, String url) {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

//		use SeleniumrManager
		if (browser == BrowserList.FIREFOX) {
			driver = new FirefoxDriver();
		} else if (browser == BrowserList.CHROME) {
			driver = new ChromeDriver();
		} else if (browser == BrowserList.EDGE) {
			driver = new EdgeDriver();
		}else if (browser == BrowserList.FIREFOX_HEADLESS) {
			driver = new FirefoxDriver();
		} else {
			throw new RuntimeException("Wrong browser Name");
		}

//		use WebDriverManager
//		if (browser == BrowserList.FIREFOX) {
//		driver = WebDriverManager.firefoxdriver().create();
//	} else if (browser == BrowserList.CHROME) {
//		driver = WebDriverManager.chromedriver().create();
//	} else if (browser == BrowserList.EDGE) {
//		driver = WebDriverManager.edgedriver().create();
//	} else {
//		throw new RuntimeException("Wrong browser Name");
//	}	

//		Use Enum
//		if (browser == BrowserList.FIREFOX) {
//			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//			driver = new FirefoxDriver();
//		} else if (browser == BrowserList.CHROME) {
//			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
//			driver = new ChromeDriver();
//		} else if (browser == BrowserList.EDGE) {
//			System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
//			driver = new EdgeDriver();
//		} else {
//			throw new RuntimeException("Wrong browser Name");
//		}

//		do not use Enum		
//		if (browserName.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//			driver = new FirefoxDriver();
//		} else if (browserName.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
//			driver = new ChromeDriver();
//		} else if (browserName.equalsIgnoreCase("edge")) {
//			System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
//			driver = new EdgeDriver();
//		} else {
//			throw new RuntimeException("Wrong browser Name");
//		}

//		do not use Enum
//		switch (browserName) {
//		case "firefox":
//			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//			driver = new FirefoxDriver();
//			break;
//		case "chrome":
//			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
//			driver = new ChromeDriver();
//			break;
//			
//		case "edge":
//			System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
//			driver = new EdgeDriver();
//			break;
//
//		default:
//			throw new RuntimeException("Wrong browser Name");
//		}

//		use Enum
//		
//		switch (browser) {
//		case FIREFOX:
//			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//			driver = new FirefoxDriver();
//			break;
//		case CHROME:
//			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
//			driver = new ChromeDriver();
//			break;
//			
//		case EDGE:
//			System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
//			driver = new EdgeDriver();
//			break;
//
//		default:
//			throw new RuntimeException("Wrong browser Name");
//		}

		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(1920, 1080));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}

	protected String getEmailrandom() {
		Random rand = new Random();
		return "hanh" + rand.nextInt(9999) + "@gmail.com";
	}

	protected void closeBrowser() {
//		Tao ra 1 bien cmd = null
		String cmd = null;
		try {
			String osName = GlobalConstants.OS_NAME.toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI 'IMAGENAME eq " + browserDriverName + "*'";
			} else {
				cmd = "pkill " + browserDriverName;
			}
			
			log.info("Command line = " + cmd);

//			dong browser
			if (driver != null) {

				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
//			2 -quit driver (executable)
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			log.info("----PASSED----");
		} catch (Throwable e) {
			log.info("----FAILED----");
			pass = false;

			// ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			// TestNG
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			log.info("----PASSED----");
		} catch (Throwable e) {
			log.info("----FAILED----");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info("----PASSED----");
		} catch (Throwable e) {
			log.info("----FAILED----");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

}
