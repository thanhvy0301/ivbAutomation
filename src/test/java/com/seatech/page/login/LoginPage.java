package com.seatech.page.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seatech.page.dashboard.DashboardPage;

public class LoginPage{
	WebDriver driver;
	public DashboardPage dashboardPage;
	@FindBy(xpath = "//input[@name='t_userName']")
	private WebElement txbUserName;
	@FindBy(xpath = "//input[@id='t_password']")
	private WebElement txbPassword;
	@FindBy(css=".xanh:nth-child(5)")
	private WebElement btnLogin;
	@FindBy(css="span:nth-child(5)")
	private WebElement txtNotice;
	@FindBy(xpath="//input[@name='button']")
	private WebElement btnAgree;
	@FindBy(xpath = "//input[@id='vcode']")
	private WebElement txbCaptcha;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	public DashboardPage Login(String username, String password, String captcha) throws InterruptedException {
		try {
			// Các bước đăng nhập
			enterUserName(username);
			enterPassword(password);
			enterCaptcha(captcha);
			clickLogin();
			boolean textnoti = (txtNotice).isDisplayed();
			if (textnoti) {
				System.out.println("Trang noti hiển thị");
				Thread.sleep(3000);
				(btnAgree).click();
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
		(txbUserName).sendKeys(username);	
		Thread.sleep(3000);
		return username;
	}
	public void enterPassword(String password) throws InterruptedException {
		(txbPassword).sendKeys(password);	
		Thread.sleep(3000);
	}
	public void clickLogin() {
		(btnLogin).click();
	}
	public void enterCaptcha(String captcha) {
		(txbCaptcha).sendKeys(captcha);
	}
}