package com.nopcommerce.account;

import org.testng.annotations.Test;

import commons.BasePage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Account_01_Register_BasePage_Inherit extends BasePage {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
	  driver = new FirefoxDriver();

	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  
  }
	

  @Test
  public void Register_01_Empty() {
	  openPageUrl(driver, "https://demo.nopcommerce.com/");
	  
	  clickToElement(driver, "//a[@class = 'ico-register']");
	  clickToElement(driver, "//button[@id = 'register-button']");
	  
	  Assert.assertEquals(getElementText(driver, "//span[@id = 'FirstName-error']"), "First name is required.");
	  Assert.assertEquals(getElementText(driver, "//span[@id = 'LastName-error']"), "Last name is required.");
	  Assert.assertEquals(getElementText(driver, "//span[@id = 'Password-error']"), "Password is required.");
	  Assert.assertEquals(getElementText(driver, "//span[@id = 'ConfirmPassword-error']"), "Password is required.");
  }
  
  @Test
  public void Register_02_InvalidEmail() {
	  openPageUrl(driver, "https://demo.nopcommerce.com/");
	  clickToElement(driver, "//a[@class = 'ico-register']");
	  
	  sendKey(driver, "//input[@id = 'FirstName']", "hanh");
	  sendKey(driver, "//input[@id = 'LastName']", "nguyen");
	  sendKey(driver, "//input[@id = 'Email']", "hanh@gdf#@");
	  sendKey(driver, "//input[@id = 'Password']", "123456");
	  sendKey(driver, "//input[@id = 'ConfirmPassword']", "123456");
	  clickToElement(driver, "//button[@id = 'register-button']");
	 
	  Assert.assertEquals(getElementText(driver, "//span[@id = 'Email-error']"), "Wrong email");
  }
  
  @Test
  public void Register_03_InvalidPassword() {
	  openPageUrl(driver, "https://demo.nopcommerce.com/");
	  clickToElement(driver, "//a[@class = 'ico-register']");

	  sendKey(driver, "//input[@id = 'FirstName']", "hanh");
	  sendKey(driver, "//input[@id = 'LastName']", "nguyen");
	  sendKey(driver, "//input[@id = 'Email']", "hanh234@gmail.com");
	  sendKey(driver, "//input[@id = 'Password']", "123");
	  sendKey(driver, "//input[@id = 'ConfirmPassword']", "123");
	  clickToElement(driver, "//button[@id = 'register-button']");
	  
	  Assert.assertEquals(getElementText(driver, "//span[@id = 'Password-error']"), "Password must meet the following rules:\n"
		  		+ "must have at least 6 characters");
  }
  
  @Test
  public void Register_04_InvalidConfirmPassword() {
	  openPageUrl(driver, "https://demo.nopcommerce.com/");
	  clickToElement(driver, "//a[@class = 'ico-register']");

	  sendKey(driver, "//input[@id = 'FirstName']", "hanh");
	  sendKey(driver, "//input[@id = 'LastName']", "nguyen");
	  sendKey(driver, "//input[@id = 'Email']", "hanh234@gmail.com");
	  sendKey(driver, "//input[@id = 'Password']", "123456");
	  sendKey(driver, "//input[@id = 'ConfirmPassword']", "123");
	  clickToElement(driver, "//button[@id = 'register-button']");
	  
	  Assert.assertEquals(getElementText(driver, "//span[@id = 'ConfirmPassword-error']"), "The password and confirmation password do not match.");
  }
  
  @Test
  public void Register_05_ValidData() {
	  openPageUrl(driver, "https://demo.nopcommerce.com/");
	  clickToElement(driver, "//a[@class = 'ico-register']");

	  sendKey(driver, "//input[@id = 'FirstName']", "hanh");
	  sendKey(driver, "//input[@id = 'LastName']", "nguyen");
	  sendKey(driver, "//input[@id = 'Email']", getEmailrandom());
	  sendKey(driver, "//input[@id = 'Password']", "123456");
	  sendKey(driver, "//input[@id = 'ConfirmPassword']", "123456");
	 
	  clickToElement(driver, "//button[@id = 'register-button']");
	  Assert.assertEquals(getElementText(driver, "//div[@class = 'result']"), "Your registration completed");
	  
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
