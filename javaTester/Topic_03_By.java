import javax.management.RuntimeErrorException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Topic_03_By {
	@Test
	public void TC_01_Locator_Lower_Case() {
		String locatorValue = "xpath=//input[@id = 'name']";
		Assert.assertEquals(getByLocator(locatorValue), By.xpath("//input[@id = 'name']"));
	}
	
	@Test
	public void TC_02_Locator_Camel_Case() {
		String locatorValue = "Xpath=//input[@id = 'name']";
		Assert.assertEquals(getByLocator(locatorValue), By.xpath("//input[@id = 'name']"));
	}
	
	@Test
	public void TC_03_Locator_Upper_Case() {
		String locatorValue = "XPATH=//input[@id = 'name']";
		Assert.assertEquals(getByLocator(locatorValue), By.xpath("//input[@id = 'name']"));
	}
	
//	@Test
//	public void TC_04_Locator_Invalid() {
//		String locatorValue = "classname=email";
//		Assert.assertEquals(getByLocator(locatorValue), null);
//	}
	
	public By getByLocator(String locatorValue) {
		By by = null;
		if(locatorValue.startsWith("xpath=") || locatorValue.startsWith("XPath=") || locatorValue.startsWith("XPATH=") || locatorValue.startsWith("Xpath=")) {
			by = By.xpath(locatorValue.substring(6));
		} else if(locatorValue.startsWith("css=") || locatorValue.startsWith("Css=") || locatorValue.startsWith("CSS=")){
			by = By.xpath(locatorValue.substring(4));
		} else if(locatorValue.startsWith("id=") || locatorValue.startsWith("ID=") || locatorValue.startsWith("Id=")){
			by = By.xpath(locatorValue.substring(3));
		} else if(locatorValue.startsWith("name=") || locatorValue.startsWith("Name=") || locatorValue.startsWith("NAME=")){
			by = By.xpath(locatorValue.substring(5));
		} else if(locatorValue.startsWith("class=") || locatorValue.startsWith("Class=") || locatorValue.startsWith("CLASS=")){
			by = By.xpath(locatorValue.substring(6));
		} else if(locatorValue.startsWith("tagname=") || locatorValue.startsWith("Tagname=") || locatorValue.startsWith("TAGNAME=")){
			by = By.xpath(locatorValue.substring(8));
		} else {
			throw new RuntimeException("Locator is invalid.");
		}
		System.out.println(by);
		return by;
		
	}

}
