package com.seatech.page.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.seatech.page.dashboard.DashboardPage;

public class LoginPage{
	WebDriver driver;
	public DashboardPage dashboardPage;
	private By txbUserName = By.xpath("//input[@id='t_userName']");
	private By txbPassword = By.xpath("//input[@id='t_password']");
	private By btnLogin = By.cssSelector(".xanh:nth-child(5)");
	private By txtNotice = By.cssSelector("span:nth-child(5)");
	private By btnAgree = By.xpath("//input[@name='button']");
	private By txbCaptcha = By.xpath("//input[@id='vcode']");
	
	//String idUser;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	public DashboardPage Login(String username, String password, String captcha) throws InterruptedException {
		try {
	        // Các bước đăng nhập
	        enterUserName(username);
	        enterPassword(password);
	        enterCaptcha(captcha);
	        clickLogin();
	        boolean textnoti = driver.findElement(txtNotice).isDisplayed();
	        if (textnoti) {
	            System.out.println("Trang noti hiển thị");
	            Thread.sleep(3000);
	            driver.findElement(btnAgree).click();
	            return new DashboardPage(driver);
	        } else {
	            System.out.println("Trang noti không hiển thị");
	            return new DashboardPage(driver);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return new DashboardPage(driver);
	}
	public String enterUserName(String username) throws InterruptedException {
		driver.findElement(txbUserName).sendKeys(username);	
		Thread.sleep(3000);
		return username;
	}
	public void enterPassword(String password) throws InterruptedException {
		driver.findElement(txbPassword).sendKeys(password);	
		Thread.sleep(3000);
	}
	public void clickLogin() {
		driver.findElement(btnLogin).click();
	}
	public void enterCaptcha(String captcha) {
		driver.findElement(txbCaptcha).sendKeys(captcha);
	}
}