package com.seatech.ivbautomation.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class common {
	String baseUrl="http://192.168.1.232:9999/IBSCorporateIDVN/Request";		
	private WebDriver driver;
	int sleep = 3000;
	public WebDriver getDriver() {
		return driver;
	}
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}