package com.facebook_home;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.HomePageObject;
import pageObjects.facebook.PageGeneratorManager;

public class Level_20_Element_Undisplayed extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserName(browserName, urlValue);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void FacebookHome_01_Element_Displayed() {
		homePage.clicktoCreateNewAccountButton();

		verifyTrue(homePage.isFirstNametxbDisplayed());

		verifyTrue(homePage.isSureNametxbDisplayed());

		verifyTrue(homePage.isEmailtxbDisplayed());

		verifyTrue(homePage.isPasswdtxbDisplayed());

		homePage.enterToEmailtxb("automationFC@gmail.com");
		log.info("Verify confirm Email Txb is displayed");
		verifyTrue(homePage.isConfirmEmailTxtboxDisplayed());

	}

//	@Test
	public void FacebookHome_02_Element_Undisplayed_In_HTML() {
		homePage.enterToEmailtxb("");
		homePage.Sleepinsecond(5);
		
		log.info("Verify confirm Email Txb is not displayed");
		verifyFalse(homePage.isConfirmEmailTxtboxDisplayed());
	}

//	@Test
	public void FacebookHome_03_Element_Undisplayed_Not_In_HTML() {
		homePage.clicktoCloseSignUpPopup();
		log.info("Verify FirstName Txb is not displayed");
		verifyFalse(homePage.isFirstNametxbDisplayed());

		log.info("Verify SureName Txb is not displayed");
		verifyFalse(homePage.isSureNametxbDisplayed());

		log.info("Verify Email Txb is not displayed");
		verifyFalse(homePage.isEmailtxbDisplayed());

		log.info("Verify Password Txb is not displayed");
		verifyFalse(homePage.isPasswdtxbDisplayed());

	}
	

	@Test
	public void FacebookHome_04_Element_Undisplayed_Not_In_HTML_2() {
		homePage.clicktoCloseSignUpPopup();
		log.info("Verify FirstName Txb is not displayed");
		verifyTrue(homePage.isFirstNametxbUnDisplayed());

		log.info("Verify SureName Txb is not displayed");
		verifyTrue(homePage.isSureNametxbUnDisplayed());

		log.info("Verify Email Txb is not displayed");
		verifyTrue(homePage.isEmailtxbUnDisplayed());

		log.info("Verify Password Txb is not displayed");
		verifyTrue(homePage.isPasswdtxbUnDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
