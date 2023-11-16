package com.seatech.page.common;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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