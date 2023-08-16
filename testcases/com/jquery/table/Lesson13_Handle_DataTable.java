package com.jquery.table;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;

public class Lesson13_Handle_DataTable extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	List<String> allValuesUI = new ArrayList<String>();

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserName(browserName, url);
		
		homePage = PageGeneratorManager.getHomePage(driver);
	}
	
//	@Test
	public void TC_01_Search() {
//		Search data
		homePage.inputToColumnTextBoxByName("283821", "Females");
		homePage.Sleepinsecond(2);
		
		homePage.inputToColumnTextBoxByName("295140", "Males");
		homePage.Sleepinsecond(2);
		
		homePage.inputToColumnTextBoxByName("Afghanistan", "Country");
		homePage.Sleepinsecond(2);
		
		homePage.inputToColumnTextBoxByName("49397", "Total");
		homePage.Sleepinsecond(2);
	}

//	@Test
	public void TC_02_Paging() {
		homePage.clickToPageByNumber("10");
		homePage.Sleepinsecond(2);
		homePage.isPageActive("10");
	}
	
//	@Test
	public void TC_03_Row_Data_Display() {
		Assert.assertTrue(homePage.isRowDisplayed("384187", "Afghanistan", "407124", "791312"));
	}
	
//	@Test
	public void TC_04_ClickToEdit_DeleteButton() {
		homePage.clickToAction("Afghanistan", "remove");
		homePage.Sleepinsecond(2);
		homePage.refresh(driver);
		
		homePage.clickToAction("AFRICA", "edit");
		homePage.refresh(driver);
	}
	
//	@Test
	public void TC_05_Get_All_Column_Values() {
		allValuesUI = homePage.getAllPageValuesByColumnName("Country");
	}
	
	@Test
	public void TC_06_Action_By_Index() {
		homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		
//		homePage.enterToTextboxByColumnNameAndRowIndex("Contact Person", "2", "Messi");
//		homePage.enterToTextboxByColumnNameAndRowIndex("Company", "1", "US");
		
		homePage.selectDropdownByColumnNameAndRowIndex("Country", "2", "United Kingdom");
		homePage.selectDropdownByColumnNameAndRowIndex("Country", "3", "Japan");
		homePage.selectCheckBoxByRowIndex("NPO?", "2");
	
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
