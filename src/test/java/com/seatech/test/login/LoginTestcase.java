package com.seatech.test.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.seatech.ivbautomation.common.common;
import com.seatech.page.dashboard.DashboardPage;
import com.seatech.page.login.LoginPage;
import io.qameta.allure.*;
public class LoginTestcase extends common{

	private WebDriver driver;
	public LoginPage loginpage;
	public DashboardPage dashboardpage;
	common com = new common();
	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test(priority=0, description="Login - Verify Login")
	@Step("Login - Verify Login")
	public void LoginTestcase() throws InterruptedException{
		System.out.println(driver);
		loginpage = new LoginPage(driver);
		try {
			//Login
			dashboardpage = loginpage.Login("6285889_maker", "111111");
			//Verify Login
			String uidLabel = dashboardpage.getUsernameDashboard();
			Assert.assertTrue(uidLabel.toUpperCase().contains(loginpage.getLbluId().toUpperCase()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority=1, description="Click choose sub menu")
	@Step("Click sub menu")
	public void DashboardTestcase() throws InterruptedException {
		try {
			//subMenu1/subMenu2/subMenu3
			dashboardpage.runAll("Tài khoản", "Sao Kê Tài Khoản", "");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	@Test(priority=2, description="Verify Title")
	@Step("Verify Title")
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

