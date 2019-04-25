package com.Farm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.base.Function;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Base {

	public static WebDriver driver;
	public static WebDriverWait wait;
	static SoftAssert sAssert = new SoftAssert();
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;	
	
	WebDriver driver(){
		return driver;
	}
	
	
	@BeforeSuite
	public void setUp() throws InterruptedException, MalformedURLException {
		try
		{
		if(browserName.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\user\\Desktop\\jars\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else{
			driver=new FirefoxDriver();
		}
		}
		catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		}
	}
	
		
	public static void webElementToBeVisibleByID(String locator){
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(locator))));
	}
	
	
	public static void webElementToBeVisibleByPartialLink(String locator){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locator)));
	}
	
	
	public static void webElementToBeVisibleByXpath(String locator){
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locator))));
	}
	
	public static void webElementToBeVisibleBycssSelector(String locator){
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(locator))));
	}
	
	public static void visibliltyOfElementToBeInDomById(String locator){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
	}
	
	
	public static void visibliltyOfElementToBeInDomByName(String locator){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
	}
	
	
	public static void visibliltyOfElementToBeInDomByCss(String locator){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
	}
	
	

}
