package com.seatech.page.dashboard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	WebDriver driver;
	WebDriverWait wait;
	String lblTitleMenu;
	public String getlblTitleMenu() {
		return lblTitleMenu;
	}
	public void setlblTitleMenu(String lblTitleMenu) {
		this.lblTitleMenu = lblTitleMenu;
	}
	@FindBy(xpath="//li[1]/span[1]/span[1]")
	private WebElement uId;
	@FindBy(xpath="//span[@class='nomall']")
	private WebElement title;
	@FindBy(xpath="//div[2]/iframe[1]")
	private WebElement iframe;
	public DashboardPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void runAll(String subName1, String subName2, String subName3) throws InterruptedException {
		getSubMenu1(subName1);
		getSubMenu2(subName2);
		Thread.sleep(2000);
		if(subName3!="") {
			getSubMenu3(subName3);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
			setlblTitleMenu(subName3);
		}
		else {
			setlblTitleMenu(subName2);
		}
	}
	public void getSubMenu1(String subName1) throws InterruptedException {
		WebElement elName = driver.findElement(By.xpath("//span[contains(.,'"+subName1+"')]"));
		elName.click();
		Thread.sleep(3000);
	}
	public void getSubMenu2(String subName2) {
		try {
			WebElement elName2 = driver.findElement(By.xpath("//a[contains(.,'"+subName2+"')]"));
			Actions builder = new Actions(driver);
			Action mouseOverHome = builder
					.moveToElement(elName2)
					.click()
					.build();
			mouseOverHome.perform();
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
	public void getSubMenu3(String subName3) {
		try {
			WebElement elName3 = driver.findElement(By.linkText(subName3));
			Actions builder = new Actions(driver);
			Action mouseOverHome = builder
					.moveToElement(elName3)
					.click()
					.build();
			mouseOverHome.perform();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public String getUsernameDashboard() {
		return uId.getText();
	}
	public String getTitle() {
		String getTitle = (title).getText();
		System.out.println("Tên danh mục: " + getTitle);
		return getTitle;
	}

}
