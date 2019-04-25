package com.pages;


import java.time.Duration;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;

import org.openqa.selenium.interactions.Actions;


import com.flip.Assertion;

import com.flip.Base;



public class Page1 extends Base{

	
	
 

WebDriver driver;

Actions action = new Actions(driver);

	
 By search = By.xpath("//*[@title="Search for products, brands and more");
	 
By item = By.name("Apple iPhone 7 (Silver, 32 GB)");

By add = By.xpath("//*[contains(text(),'ADD TO CART')]")
By logout = By.name("")
	 
	 
	 
	
 public void clickAccess()
	 {
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	 driver.findElement(search).sendKeys("iphone7");
	
 }

public void itemclick(){

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	 driver.findElement(item).click();
}

public void Addtocart(){
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	 WebElement navigationclick = driver.findElement(By.id("logoutMenu"));
    WebElement logout = driver.findElement(By.xpath("//div[@id='u_d_1']/div/div/div/div/div/ul/li[12]/a/span/span"));
    navigationclick.click();
    if(logout.isEnabled() && logout.isDisplayed()) {
        logout.click();
    }
    else {
        System.out.println("Element not found");
    }
}


public void mouseover(){
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	 driver.findElement(add).click();
}
 public void verify(Boolean result)
	 {
	
	 Base.scrollRight(100);
		
 driver.findElement(By.id("com.climate.farmrise:id/hourlyWeatherForecastLayout")).isDisplayed();
		 Assertion.assertTrue(result);
		 
	 }
	
}


