package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	private WebDriver driver;
//	private String projectPath = System.getProperty("user.dir");
	protected WebDriver getBrowserName(String browserName) {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		
		
//		use SeleniumrManager
		if (browser == BrowserList.FIREFOX) {
		driver = new FirefoxDriver();
	} else if (browser == BrowserList.CHROME) {
		driver = new ChromeDriver();
	} else if (browser == BrowserList.EDGE) {
		driver = new EdgeDriver();
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
		driver.get("https://demo.nopcommerce.com/");
		return driver;
	}
	protected String getEmailrandom() {
		Random rand = new Random();
		return "hanh" + rand.nextInt(9999) + "@gmail.com";
	}


}
