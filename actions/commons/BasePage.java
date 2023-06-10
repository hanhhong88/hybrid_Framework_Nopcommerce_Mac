package commons;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	
	/* Web Browser*/
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
		
	}
	
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void back(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forward(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public Alert waitForAlertPresence(WebDriver driver) {
		return new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
		
	}
	
	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}
	
	public void canceltAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}
	
	public String getTextAlert(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}
	
	public void sendKeyAlert(WebDriver driver, String textToSend) {
		waitForAlertPresence(driver).sendKeys(textToSend);;
	}
	
	public void Swith_To_Windows_By_ID(WebDriver driver, String window_ID) {
		Set<String> all_ID_windows = driver.getWindowHandles();
		
		for(String ID : all_ID_windows) {
			if(!ID.equals(window_ID)) {
				driver.switchTo().window(ID);		
				Sleepinsecond(1);
			}
		}
	}
	
	public void Swith_To_Windows_By_Title(WebDriver driver, String page_Title) {
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
	
	public void Close_All_Windows_Tabs(WebDriver driver, String parent_ID) {
		Set<String> all_ID_windows = driver.getWindowHandles();
		
		for(String ID_3 : all_ID_windows) {
			if(!ID_3.equals(parent_ID))	{
			driver.switchTo().window(ID_3);
			driver.close();
			}
		}
		driver.switchTo().window(parent_ID);
	}
	

	public void Sleepinsecond(long Timeinseconds) {
		try {
			Thread.sleep(Timeinseconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
