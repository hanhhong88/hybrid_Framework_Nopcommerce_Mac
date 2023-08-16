package com.jquery.table;

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
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
