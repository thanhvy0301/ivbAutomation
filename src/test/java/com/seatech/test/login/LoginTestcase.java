package com.seatech.test.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.seatech.page.common.common;
import com.seatech.page.dashboard.DashboardPage;
import com.seatech.page.login.LoginPage;
import io.qameta.allure.*;
@Owner("Vy Doan")
public class LoginTestcase extends common{

	private WebDriver driver;
	public LoginPage loginpage;
	public DashboardPage dashboardpage;
	@BeforeClass
	public void setUp() {		
		driver = getDriver();
	}	
	@Test(priority=0, description="Login")	
	@Step("Login with username - password ") 
	@Feature("Login") //feature's name
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
	@Step("Verify login")	
	@Feature("Login")
	@Severity(SeverityLevel.BLOCKER) //specify the severity level of a test method
	public void verifyUsername(){
		String uidLabel = dashboardpage.getUsernameDashboard();
		Assert.assertTrue(uidLabel.toUpperCase().contains(loginpage.getLbluId().toUpperCase()));		
	}
	
	@Test(priority=2, description="Click choose sub menu")
	@Step("Click sub menu")
	@Feature("Menu")
	@Severity(SeverityLevel.NORMAL)
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
	@Feature("Menu")
	@Severity(SeverityLevel.NORMAL)
	public void verifyTitle() {
		try {
			Assert.assertTrue(dashboardpage
					.getTitle()
					.contains(dashboardpage.getlblTitleMenu()));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

