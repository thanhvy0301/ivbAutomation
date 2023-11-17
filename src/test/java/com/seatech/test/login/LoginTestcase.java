package com.seatech.test.login;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.seatech.page.common.common;
import com.seatech.page.dashboard.DashboardPage;
import com.seatech.page.login.LoginPage;
import io.qameta.allure.*;
public class LoginTestcase extends common{

	private WebDriver driver;
	public LoginPage loginpage;
	public DashboardPage dashboardpage;
	@BeforeClass
	public void setUp() {		
		driver = getDriver();
	}
	@Test(priority=0, description="Login")
	@Step("Login with username - password")
	public void LoginTestcase() throws InterruptedException{
		System.out.println(driver);
		loginpage = new LoginPage(driver);
		try {
			//Login
			dashboardpage = loginpage.Login("6285889_maker", "111111");
			//Verify Login			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=1, description="Verify Login")
	@Step("Login with username {0} - password {1}")
//	@Severity(SeverityLevel.BLOCKER)
	public void verifyUsername(){
		String uidLabel = dashboardpage.getUsernameDashboard();
		Assert.assertTrue(uidLabel.toUpperCase().contains(loginpage.getLbluId()));
	}
	
	@Test(priority=2, description="Click choose sub menu")
	@Step("Click sub menu")
//	@Severity(SeverityLevel.BLOCKER)
	public void DashboardTestcase() throws InterruptedException {
		try {
			//subMenu1/subMenu2/subMenu3
			dashboardpage.runAll("Giao dịch", "Thanh Toán Lương", "Thanh Toán Lương");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test(priority=3, description="Verify Title")
	@Step("Verify Title")
	public void verifyTitle() {
		try {
			Assert.assertTrue(dashboardpage
					.getTitle()
					.contains("ABC"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

