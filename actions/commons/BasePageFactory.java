package commons;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
	
	protected static BasePageFactory getBasePage() {
		return new BasePageFactory();
	}
	
	
	/* Web Browser*/
	protected void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	protected String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	protected String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
		
	}
	
	protected String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	protected void back(WebDriver driver) {
		driver.navigate().back();
	}
	
	protected void forward(WebDriver driver) {
		driver.navigate().forward();
	}
	
	protected void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	protected Alert waitForAlertPresence(WebDriver driver) {
		return new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent());
		
	}
	
	protected void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}
	
	protected void canceltAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}
	
	protected String getTextAlert(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}
	
	protected void sendKeyAlert(WebDriver driver, String textToSend) {
		waitForAlertPresence(driver).sendKeys(textToSend);;
	}
	
	protected void Swith_To_Windows_By_ID(WebDriver driver, String window_ID) {
		Set<String> all_ID_windows = driver.getWindowHandles();
		
		for(String ID : all_ID_windows) {
			if(!ID.equals(window_ID)) {
				driver.switchTo().window(ID);		
				Sleepinsecond(1);
			}
		}
	}
	
	protected void Swith_To_Windows_By_Title(WebDriver driver, String page_Title) {
		Set<String> all_ID_windows = driver.getWindowHandles();
		
		for(String ID : all_ID_windows) {
			driver.switchTo().window(ID);		
			Sleepinsecond(1);
			String actual_Page_Title = driver.getTitle();
			if(actual_Page_Title.equals(page_Title)) {
				break;
			}
		}
	}
	
	protected void Close_All_Windows_Tabs(WebDriver driver, String parent_ID) {
		Set<String> all_ID_windows = driver.getWindowHandles();
		
		for(String ID_3 : all_ID_windows) {
			if(!ID_3.equals(parent_ID))	{
			driver.switchTo().window(ID_3);
			driver.close();
			}
		}
		driver.switchTo().window(parent_ID);
	}
	
	protected Set<Cookie> getBrowserCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}
	
	protected void setCookies(WebDriver driver, Set<Cookie> cookies) {
		for(Cookie cookie:cookies) {
		driver.manage().addCookie(cookie);
		}
	}
	
	protected void deleteAllCookie(WebDriver driver) {
		driver.manage().deleteAllCookies();
	}
	
	/* Web Element*/
	protected void clickToElement(WebDriver driver,WebElement element) {
		element.click();
	}
	
	protected void sendKey(WebDriver driver, WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	
	protected String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
	}
	
	protected String getAtribute(WebDriver driver, WebElement element, String Atributename) {
		return element.getAttribute(Atributename);
	}
	
	protected void waitForElementToVisibilite(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
	}
	
	protected void waitForElementToClickable(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	
	
	protected void Sleepinsecond(long Timeinseconds) {
		try {
			Thread.sleep(Timeinseconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
