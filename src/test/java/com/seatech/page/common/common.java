package com.seatech.page.common;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class common {
	String baseUrl="http://192.168.1.232:9999/IBSCorporateIDVN/Request";
	String browser;
	public static WebDriver driver;
	int sleep = 3000;
	public static WebDriver getDriver() {
		return driver;
	}
	@BeforeClass
	@Parameters("browser") //Change browser -> testng.xml -> parameter <name> -> chrome/edge
	public void beforeTest(@Optional("edge") String browser) {
		setDriver(browser);
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	private void setDriver(String browser) {
		switch (browser.toLowerCase()) 
		{
		case "chrome":
			driver = new ChromeDriver();			
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":			
			driver = new FirefoxDriver();
			break;
		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}