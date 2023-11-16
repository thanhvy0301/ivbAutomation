package com.seatech.page.login;

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
	String lbluId;
	public String getLbluId() {
		return lbluId;
	}
	public void setLbluId(String lbluId) {
		this.lbluId = lbluId;
	}
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	public DashboardPage Login(String username, String password) throws InterruptedException {
		try {
			txbUserName.sendKeys(username);
			setLbluId(username);
			Thread.sleep(2000);
			txbPassword.sendKeys(password);
			Thread.sleep(10000);
//			txbCaptcha.sendKeys(captcha);
			btnLogin.click();
			boolean textnoti = (txtNotice).isDisplayed();
			if (textnoti) {
				System.out.println("Trang noti hiển thị");
				Thread.sleep(3000);
				btnAgree.click();
				return new DashboardPage(driver);
			}
			else{
				System.out.println("Trang noti không hiển thị");
				//return new DashboardPage(driver);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new DashboardPage(driver);
	}
}