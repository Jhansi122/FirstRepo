package com.org.maventest.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class MavenTest {
	
	WebDriver driver;
	
	@Test(priority=1)
 public void browser() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","C:\\Program Files\\Selenium\\Geckodriver\\geckodriver.exe\\");
		driver= new FirefoxDriver();
		driver.get("http://www.starbucks.in/");
		Thread.sleep(1000);
	}
		@Test(priority=2)
		public void image  () throws InterruptedException 
		{
		    WebElement img= driver.findElement(By.xpath("//img[@alt='Logo']"));
		      if(img.isDisplayed())
		         {
			       System.out.println("Image is displayed");
			       System.out.println("Image test is " +img.getText());
		          }
		      Thread.sleep(1000);
		}
		
		@Test(priority=3)
		public void selection() throws InterruptedException {
			
		WebElement menu = driver.findElement(By.xpath("//a[@class='tab' and @href='/menu-list']"));
		Actions action = new Actions(driver);
		action.moveToElement(menu).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@href='/menu-list/drinks/Espresso_Beverages']")).click();
		
		Thread.sleep(3000);
		String str= driver.findElement(By.xpath("//a[@class='tab' and @href='/menu-list']")).getText();
		
		}
		
		@Test(priority=4)
		public void scroll() throws InterruptedException 
		{
			
		((JavascriptExecutor)driver).executeScript("scroll(0,800)");
		Thread.sleep(1000);
		driver.navigate().back();
		List<WebElement> ele =driver.findElements(By.xpath("//li[@id='menu_1']//ol[@class='blocks blocks-four-up']"));
		for (WebElement menu_item : ele) 
		{
			String inner = menu_item.getAttribute("inner HTML");
			
			/*if (inner.contentEquals("Menu")) {
				menu_item.click();
				break;
			}*/
			System.out.println("Text in the menu is "+inner);
		
		}
		}
		
		@AfterTest
		public void close() {
			driver.close();
		}
		
		
		
		
		
		
		
		/*List<WebElement> ele =driver.findElements(By.xpath("//li[@id='menu_1']//ol[@class='blocks blocks-four-up']"));
		for (WebElement menu_item : ele) 
		{
			String inner = menu_item.getAttribute("inner HTML");
			
			/*if (inner.contentEquals("Drinks")) {
				menu_item.click();
				break;
			}
			System.out.println("Text in the menu is "+inner);*/
		}


