package com.seatech.test.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.seatech.pages.DashboardPage;
import com.seatech.pages.LoginPage;
import com.seatech.pages.common.ExcelHelpers;
import com.seatech.pages.common.common;

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
		try {
			//			dashboardpage = loginpage.Login("6285889_maker", "111111");
			int i = 1; //Chưa xong
			if (excel.getCellData("username", i) != null && excel.getCellData("password", i) != null) {				
				while (excel.getCellData("username", i) != null && excel.getCellData("password", i) != null) {
					dashboardpage = loginpage.login(excel.getCellData("username", i), excel.getCellData("password", i));
					verifyUsername();
					dashboardpage.Logout();
					dashboardpage.changeAccount();
					i++;
				}	
			}
			else {				
				driver.quit();
			}			
			//Verify Login			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (dashboardpage != null) {
				dashboardpage.Logout(); 
			}
		}
	}

	@Test(description="Verify Login")
	@Step("Verify login")	
	@Feature("Login")
	@Severity(SeverityLevel.BLOCKER) //specify the severity level of a test method
	public void verifyUsername(){
		String uidLabel = dashboardpage.getUsernameDashboard();
		Assert.assertTrue(uidLabel.toUpperCase().contains(loginpage.getLbluId().toUpperCase()));		
	}
	//	@Test(priority=2, description="Logout")
	//	@Step("Logout")	
	//	@Feature("Login")
	//	@Severity(SeverityLevel.BLOCKER) //specify the severity level of a test method
	//	public void Logout(){
	//			try {
	//				dashboardpage.Logout();				
	//			}catch (Exception e){
	//				e.printStackTrace();
	//			}
	//	}
	@Test(priority=2, description="Click choose sub menu", enabled = false)
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

