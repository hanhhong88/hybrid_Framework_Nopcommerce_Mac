package com.nopcommerce.account;

import org.testng.annotations.Test;

import commons.BasePage;

import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Account_02_BasePage_2_Static {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	private BasePage basePage;
	
	
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
	  driver = new FirefoxDriver();

	  driver.manage().window().maximize();
	  basePage = new BasePage();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  
  }
	

  @Test
  public void Register_01_Empty() {
	  basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
	  
	  basePage.clickToElement(driver, "//a[@class = 'ico-register']");
	  basePage.clickToElement(driver, "//button[@id = 'register-button']");
	  
	  Assert.assertEquals(basePage.getElementText(driver, "//span[@id = 'FirstName-error']"), "First name is required.");
	  Assert.assertEquals(basePage.getElementText(driver, "//span[@id = 'LastName-error']"), "Last name is required.");
	  Assert.assertEquals(basePage.getElementText(driver, "//span[@id = 'Password-error']"), "Password is required.");
	  Assert.assertEquals(basePage.getElementText(driver, "//span[@id = 'ConfirmPassword-error']"), "Password is required.");
  }
  
  @Test
  public void Register_02_InvalidEmail() {
	  basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
	  basePage.clickToElement(driver, "//a[@class = 'ico-register']");
	  
	  basePage.sendKey(driver, "//input[@id = 'FirstName']", "hanh");
	  basePage.sendKey(driver, "//input[@id = 'LastName']", "nguyen");
	  basePage.sendKey(driver, "//input[@id = 'Email']", "hanh@gdf#@");
	  basePage.sendKey(driver, "//input[@id = 'Password']", "123456");
	  basePage.sendKey(driver, "//input[@id = 'ConfirmPassword']", "123456");
	  basePage.clickToElement(driver, "//button[@id = 'register-button']");
	 
	  Assert.assertEquals(basePage.getElementText(driver, "//span[@id = 'Email-error']"), "Wrong email");
  }
  
  @Test
  public void Register_03_InvalidPassword() {
	  basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
	  basePage.clickToElement(driver, "//a[@class = 'ico-register']");

	  basePage.sendKey(driver, "//input[@id = 'FirstName']", "hanh");
	  basePage.sendKey(driver, "//input[@id = 'LastName']", "nguyen");
	  basePage.sendKey(driver, "//input[@id = 'Email']", "hanh234@gmail.com");
	  basePage.sendKey(driver, "//input[@id = 'Password']", "123");
	  basePage.sendKey(driver, "//input[@id = 'ConfirmPassword']", "123");
	  basePage.clickToElement(driver, "//button[@id = 'register-button']");
	  
	  Assert.assertEquals(basePage.getElementText(driver, "//span[@id = 'Password-error']"), "Password must meet the following rules:\n"
		  		+ "must have at least 6 characters");
  }
  
  @Test
  public void Register_04_InvalidConfirmPassword() {
	  basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
	  basePage.clickToElement(driver, "//a[@class = 'ico-register']");

	  basePage.sendKey(driver, "//input[@id = 'FirstName']", "hanh");
	  basePage.sendKey(driver, "//input[@id = 'LastName']", "nguyen");
	  basePage.sendKey(driver, "//input[@id = 'Email']", "hanh234@gmail.com");
	  basePage.sendKey(driver, "//input[@id = 'Password']", "123456");
	  basePage.sendKey(driver, "//input[@id = 'ConfirmPassword']", "123");
	  basePage.clickToElement(driver, "//button[@id = 'register-button']");
	  
	  Assert.assertEquals(basePage.getElementText(driver, "//span[@id = 'ConfirmPassword-error']"), "The password and confirmation password do not match.");
  }
  
  @Test
  public void Register_05_ValidData() {
	  basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
	  basePage.clickToElement(driver, "//a[@class = 'ico-register']");

	  basePage.sendKey(driver, "//input[@id = 'FirstName']", "hanh");
	  basePage.sendKey(driver, "//input[@id = 'LastName']", "nguyen");
	  basePage.sendKey(driver, "//input[@id = 'Email']", getEmailrandom());
	  basePage.sendKey(driver, "//input[@id = 'Password']", "123456");
	  basePage.sendKey(driver, "//input[@id = 'ConfirmPassword']", "123456");
	 
	  basePage.clickToElement(driver, "//button[@id = 'register-button']");
	  Assert.assertEquals(basePage.getElementText(driver, "//div[@class = 'result']"), "Your registration completed");
	  
  }
  
  public String getEmailrandom() {
	  Random rand = new Random();
	  return "hanh" + rand.nextInt(9999) + "@gmail.com";
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
