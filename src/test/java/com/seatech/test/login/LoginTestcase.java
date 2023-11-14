package com.seatech.test.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.seatech.page.dashboard.DashboardPage;
import com.seatech.page.login.LoginPage;
import com.seatech.ivbautomation.common.common;
public class LoginTestcase extends common{
	private WebDriver driver;
	public LoginPage loginpage;
	public DashboardPage dashboardpage;

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}
	@Test(priority=0, description="Login - Verify Login")
	public void LoginTestcase() throws InterruptedException{
		System.out.println(driver);
		loginpage = new LoginPage(driver);
		try {
			//Login
			dashboardpage = loginpage.Login("6285889_checker", "111111", "12345");
			//Verify Login		
			String uidLabel = dashboardpage.getUsernameDashboard();	
			Assert.assertTrue(uidLabel.toUpperCase().contains("6285889_CHECKER"));
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	@Test(priority=1, description="Click choose sub menu")
	public void DashboardTestcase() throws InterruptedException {
		try {
			//subMenu1/subMenu2/subMenu3
			dashboardpage.runAll("Quản lý thông tin","Phê duyệt Giao dịch", "Thanh Toán Lương");			
		}
		catch (Exception e) {
			System.out.println(e);
		}		
	}
	@Test(priority=2, description="Verify Title")
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

