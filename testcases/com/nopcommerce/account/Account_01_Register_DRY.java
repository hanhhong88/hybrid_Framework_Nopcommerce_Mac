package com.nopcommerce.account;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Account_01_Register_DRY {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
	  driver = new FirefoxDriver();

	  driver.manage().window().maximize();
	  
	  
  }
	

  @Test
  public void Register_01_Empty() {
	  driver.get("https://demo.nopcommerce.com/");
	  driver.findElement(By.cssSelector("a.ico-register")).click();
	  driver.findElement(By.cssSelector("button#register-button")).click();
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getText(), "First name is required.");
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(), "Last name is required.");
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Email is required.");
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password is required.");
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "Password is required.");
	  
  }
  
  @Test
  public void Register_02_InvalidEmail() {
	  driver.get("https://demo.nopcommerce.com/");
	  driver.findElement(By.cssSelector("a.ico-register")).click();

	  driver.findElement(By.cssSelector("input#FirstName")).sendKeys("hanh");
	  driver.findElement(By.cssSelector("input#LastName")).sendKeys("nguyen");
	  driver.findElement(By.cssSelector("input#Email")).sendKeys("hanh@gdf#@");
	  driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
	  driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
	  driver.findElement(By.cssSelector("button#register-button")).click();
	  
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Wrong email");
  }
  
  @Test
  public void Register_03_InvalidPassword() {
	  driver.get("https://demo.nopcommerce.com/");
	  driver.findElement(By.cssSelector("a.ico-register")).click();

	  driver.findElement(By.cssSelector("input#FirstName")).sendKeys("hanh");
	  driver.findElement(By.cssSelector("input#LastName")).sendKeys("nguyen");
	  driver.findElement(By.cssSelector("input#Email")).sendKeys("hanh234@gmail.com");
	  driver.findElement(By.cssSelector("input#Password")).sendKeys("123");
	  driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123");
	  driver.findElement(By.cssSelector("button#register-button")).click();
	  
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password must meet the following rules:\n"
	  		+ "must have at least 6 characters");
  }
  
  @Test
  public void Register_04_InvalidConfirmPassword() {
	  driver.get("https://demo.nopcommerce.com/");
	  driver.findElement(By.cssSelector("a.ico-register")).click();

	  driver.findElement(By.cssSelector("input#FirstName")).sendKeys("hanh");
	  driver.findElement(By.cssSelector("input#LastName")).sendKeys("nguyen");
	  driver.findElement(By.cssSelector("input#Email")).sendKeys("hanh234@gmail.com");
	  driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
	  driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123");
	  driver.findElement(By.cssSelector("button#register-button")).click();
	  
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "The password and confirmation password do not match.");
  }
  
  @Test
  public void Register_05_ValidData() {
	  driver.get("https://demo.nopcommerce.com/");
	  driver.findElement(By.cssSelector("a.ico-register")).click();

	  driver.findElement(By.cssSelector("input#FirstName")).sendKeys("hanh");
	  driver.findElement(By.cssSelector("input#LastName")).sendKeys("nguyen");
	  driver.findElement(By.cssSelector("input#Email")).sendKeys(getEmailrandom());
	  driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
	  driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
	  driver.findElement(By.cssSelector("button#register-button")).click();
	  
	  Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
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
