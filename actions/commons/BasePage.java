package commons;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageUIs.user.BaseElementUI;

public class BasePage {
	
	public static BasePage getBasePage() {
		return new BasePage();
	}
	
	
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
		return new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.alertIsPresent());
		
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
	
	public Set<Cookie> getBrowserCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}
	
	public void setCookies(WebDriver driver, Set<Cookie> cookies) {
		for(Cookie cookie:cookies) {
		driver.manage().addCookie(cookie);
		System.out.println(cookie);
		}
	}
	
	public void deleteAllCookie(WebDriver driver) {
		driver.manage().deleteAllCookies();
	}
	
	public By getByLocator(String locatorValue) {
		By by = null;
		if (locatorValue.startsWith("xpath=") || locatorValue.startsWith("Xpath=") || locatorValue.startsWith("XPATH=") || locatorValue.startsWith("XPath=")){
		by = By.xpath(locatorValue.substring(6));
		} else if (locatorValue.startsWith("css=") || locatorValue.startsWith("CSS=") || locatorValue.startsWith("Css=")){
		by = By.cssSelector(locatorValue.substring(4));
		} else if (locatorValue.startsWith("id=") || locatorValue.startsWith("ID=") || locatorValue.startsWith("Id=")){
		by = By.id(locatorValue.substring(3));
		} else if (locatorValue.startsWith("name=") || locatorValue.startsWith("Name=") || locatorValue.startsWith("NAME=")){
		by = By.name(locatorValue.substring(5));
		} else if (locatorValue.startsWith("class=") || locatorValue.startsWith("Class= ") || locatorValue.startsWith("CLASS=")){
		by = By.className(locatorValue.substring(6));
		} else if (locatorValue.startsWith("tagname =") || locatorValue.startsWith("Tagname= ") || locatorValue.startsWith("TAGNAME=")){
			by = By.tagName(locatorValue.substring(8));
		} else {
			throw new RuntimeException("Locator is invalid");
		}
		return by;
	}
	
	
	/* Web Element*/
	public By getXpath(String locator) {
		return By.xpath(locator);
	}
	public String getDynamicLocator(String locator, String...params) {
		return String.format(locator, (Object[])params);
	}
	
	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByLocator(locator));
	}
	
	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByLocator(locator));
	}
	
	public List<WebElement> getElements(WebDriver driver, String locator, String...params) {
		return driver.findElements(getByLocator(getDynamicLocator(locator, params)));
	}
	
	
	public void clickToElement(WebDriver driver, String locator) {
		driver.findElement(getByLocator(locator)).click();
	}
	
	public void clickToElement(WebDriver driver, String locator, String...params) {
		driver.findElement(getByLocator(getDynamicLocator(locator, params))).click();
	}
	
	public void sendKey(WebDriver driver, String locator, String valueToSend) {
		driver.findElement(getByLocator(locator)).clear();
		driver.findElement(getByLocator(locator)).sendKeys(valueToSend);
	}
	
	public void sendKey(WebDriver driver, String locator, String valueToSend, String...params) {
		driver.findElement(getByLocator(getDynamicLocator(locator, params))).clear();
		driver.findElement(getByLocator(getDynamicLocator(locator, params))).sendKeys(valueToSend);
	}
	
	public String getElementText(WebDriver driver, String locator) {
		return driver.findElement(getByLocator(locator)).getText();
	}
	
	public String getElementText(WebDriver driver, String locator, String...params) {
		return driver.findElement(getByLocator(getDynamicLocator(locator, params))).getText();
	}
	
	public void selectItemInDefaultDropdown(WebDriver driver, String locator, String item) {
		new Select(getElement(driver, locator)).selectByValue(item);	
	}
	
	public void selectItemInDefaultDropdown(WebDriver driver, String locator, String item, String...params) {
		new Select(getElement(driver, getDynamicLocator(locator, params))).selectByValue(item);	
	}
	
	public String getFirstSelectedInDefaultDropdown(WebDriver driver, String locator) {
		return new Select(getElement(driver, locator)).getFirstSelectedOption().getText();
	}

	public boolean isDefaultDropdown(WebDriver driver, String locator) {
		return new Select(getElement(driver, locator)).isMultiple();
	}
	
	public void selectItemInDropdown(WebDriver driver, String parentLocator, String childLocator, String expectedItem) {
		getElement(driver, parentLocator).click();
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childLocator)));
		List<WebElement> allItems = getElements(driver, childLocator);
		for (WebElement tempItem : allItems) {			
			if(tempItem.getText().trim().equals(expectedItem) ){
				tempItem.click();
				break;
			}
		}
	}
	
	public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		return getElement(driver, locator).getAttribute(attributeName);
	}
	
	public String getElementAttribute(WebDriver driver, String locator, String attributeName, String...params) {
		return getElement(driver, getDynamicLocator(locator, params)).getAttribute(attributeName);
	}
	
	public String getElementCssValue(WebDriver driver, String locator, String cssPropertyName) {
		return getElement(driver, locator).getCssValue(cssPropertyName);
	}
	
	public String convertRGBAToHexa(WebDriver driver, String locator) {
		return Color.fromString(getElementCssValue(driver, locator, "background-color")).asHex();
	}
	
	public int getElementSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}
	
	public int getElementSize(WebDriver driver, String locator, String...params) {
		return getElements(driver, getDynamicLocator(locator, params)).size();
	}
	
	
	/**Apply for Radio and Check box buttons
	 * @param driver
	 * @param locator
	 */
	public void checkElement(WebDriver driver, String locator) {
		if(!getElement(driver, locator).isSelected()) {
			getElement(driver, locator).click();
		}
	}
	
	public void checkElement(WebDriver driver, String locator, String...params) {
		if(!getElement(driver, getDynamicLocator(locator, params)).isSelected()) {
			getElement(driver, getDynamicLocator(locator, params)).click();
		}
	}
	
	/**Only Apply for Check box buttons
	 * @param driver
	 * @param locator
	 */
	public void unCheckElement(WebDriver driver, String locator) {
		if(getElement(driver, locator).isSelected()) {
			getElement(driver, locator).click();
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator) {
		boolean status = true;
		try {
//			 case 1: element is visible and in DOM -> true
//			case 2: element is invisible and in DOM -> false
			status = getElement(driver, locator).isDisplayed();
	} catch (NoSuchElementException e) {
//		case 3: element is not in DOM -> false
		 status = false;
	}
		return status;
	}
	
	public boolean isElementUnDisplayed(WebDriver driver, String locator) {
//		truoc khi tim thi set timeout ngan thoi
		setImplicitWait(driver, shortTimeout);
		List<WebElement> elements = getElements(driver, locator);
		setImplicitWait(driver, longTimeout);
		if(elements.size() > 0 && elements.get(0).isDisplayed() ) {
			System.out.println("04- Element khong co trong DOM va ko hien thi");
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("04- Element co trong DOM va ko hien thi");
			return true;
		} else {
			System.out.println("04- Element co trong DOM va hien thi");
			return false;
		}
	}
	
	public void setImplicitWait(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator, String...params) {
		return getElement(driver, getDynamicLocator(locator, params)).isDisplayed();
	}
	
	public boolean isElementEnable(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}
	
	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}
	
	public void switchToIframe(WebDriver driver, String locator) {
		new WebDriverWait (driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getByLocator(locator)));
	}
	
	public void switchToDefaultContent(WebDriver driver, String locator) {
		driver.switchTo().defaultContent();
	}
	
	public void hoverAndMovetoElement(WebDriver driver, String locator) {
		new Actions(driver).clickAndHold(getElement(driver, locator)).perform();
	}
	
	public void rightClickElement(WebDriver driver, String locator) {
		new Actions(driver).contextClick(getElement(driver, locator)).perform();
	}
	
	public void doubleClickElement(WebDriver driver, String locator) {
		new Actions(driver).doubleClick(getElement(driver, locator)).perform();
	}
	
	public void dragAndDropElement(WebDriver driver, String sourcelocator, String targetLocator) {
		new Actions(driver).dragAndDrop(getElement(driver, sourcelocator), getElement(driver, targetLocator)).perform();
	}
	
	public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
		new Actions(driver).sendKeys(getElement(driver, locator), key).perform();
		
	}
	
	public Object executeForBrowser(WebDriver driver, String javaScript) {
		return ((JavascriptExecutor) driver).executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		String textActual = (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
	}

	public void hightlightElement(WebDriver driver, String locator) {
		WebElement element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		Sleepinsecond(1);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, locator));
	}

	public void scrollToElementOnTop(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver,locator));
	}

	public void scrollToElementOnDown(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver,locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver,locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver,locator));
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver,locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		return (boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getElement(driver, locator));
	}
	
	public void waitForElementToVisibilite(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
	}
	
	public void waitForElementToVisibilite(WebDriver driver, String locator, String...params) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locator, params))));
	}
	
	public void waitForAllElementToVisibilite(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfAllElements(getElements(driver, locator)));
	}
	
	public void waitForElementToInVisibilite(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
	}
	
	public void waitForAllElementToInVisibilite(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.invisibilityOfAllElements(getElements(driver, locator)));
	}
	
	public void waitForElementToClickable(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(getElement(driver, locator)));
	}
	
	public void waitForElementToClickable(WebDriver driver, String locator, String...params) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(getElement(driver, getDynamicLocator(locator, params))));
	}
	
	public boolean isPageLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}
		
	public void Sleepinsecond(long Timeinseconds) {
		try {
			Thread.sleep(Timeinseconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
	private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;
	
	public void uploadMutileFiles(WebDriver driver, String...fileNames) {
		String filePath = System.getProperty("user.dir") + File.pathSeparator + "uploadFile" + File.pathSeparator;
		String fullNameFile = "";
		for(String file:fileNames) {
			fullNameFile = fullNameFile + filePath + file + "\n";
		}
		fullNameFile = fullNameFile.trim();
		getElement(driver, BaseElementUI.UPLOAD_FILE_TYPE).sendKeys(fullNameFile);
		
	}
	
	
	
	
	
}
