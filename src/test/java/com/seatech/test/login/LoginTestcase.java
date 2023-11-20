package com.seatech.test.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.seatech.pages.DashboardPage;
import com.seatech.pages.LoginPage;
import com.seatech.pages.common.ExcelHelpers;
import com.seatech.pages.common.common;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
@Owner("Vy Doan")
public class LoginTestcase extends common{

	private WebDriver driver;
	public LoginPage loginpage;
	public DashboardPage dashboardpage;
	private ExcelHelpers excel;

	@BeforeClass
	public void setUp() {		
		driver = getDriver();
		excel = new ExcelHelpers();
	}	
	@Test(description="Login")	
	@Step("Login with username - password ") 
	@Feature("Login") //feature's name
	public void LoginTestcase() throws Exception{
		excel.setExcelFile("resources\\excelFiles\\login.xlsx", "Sheet1");
		System.out.println(driver);
		loginpage = new LoginPage(driver);
		int i = 1; 
		try {
			while (excel.getCellData("username", i) != null && excel.getCellData("password", i) != null) {
				dashboardpage = loginpage.login(excel.getCellData("username", i), excel.getCellData("password", i));	
				loginpage.checkNotiDisplayed();
				verifyUsername();
				dashboardpage.logout();
				i++;
//				if(loginpage.getTxtSupport()==false) {
//					loginpage.checkNotiDisplayed();
//					dashboardpage.logout();
//					i++;
//				}
//				else {					
//					System.err.println("Error logging in with username: " + excel.getCellData("username", i));
//					i++;
//				}				
			}		
		} catch (Exception e) {
			//System.err.println("Error logging in with username: " + excel.getCellData("username", i));
			e.printStackTrace();
		}				
	}
	public void verifyUsername() {
		String uidLabel = dashboardpage.getUsernameDashboard();
		Assert.assertTrue(uidLabel.toUpperCase().contains(loginpage.getLbluId().toUpperCase()));	
	}
	//	@Test(description="Verify Login", enabled =false)
	//	@Step("Verify login")	
	//	@Feature("Login")
	//	@Severity(SeverityLevel.BLOCKER) //specify the severity level of a test method
	//	public void verifyUsername(){
	//		String uidLabel = dashboardpage.getUsernameDashboard();
	//		Assert.assertTrue(uidLabel.toUpperCase().contains(loginpage.getLbluId().toUpperCase()));		
	//	}
	@Test(description="Click choose sub menu", enabled=false)
	@Step("Click sub menu")
	@Feature("Menu")
	@Severity(SeverityLevel.NORMAL)
	public void clickSubMenu() throws InterruptedException {
		try {
			//subMenu1/subMenu2/subMenu3
			dashboardpage.runAll("Giao dịch", "Thanh Toán Lương", "Thanh Toán Lương");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	@Test(priority=3, description="Verify Title", enabled = false)
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

