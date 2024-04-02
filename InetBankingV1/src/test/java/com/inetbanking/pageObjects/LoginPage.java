package com.inetbanking.pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//a[text()='Log out']")
	private WebElement logout;
	
	@FindBy(xpath = "//input[@name='uid']")
	private WebElement userid;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;

	@FindBy(xpath = "//input[@name='btnLogin']")
	private WebElement loginButton;

	@FindBy(xpath = "//title[text()=' Guru99 Bank Manager HomePage ']")
	private WebElement actualTitleText;

	public void sendUserid(String Userid) {

		userid.sendKeys(Userid);

	}

	public void sendPassword(String Password) {

		password.sendKeys(Password);

	}

	public void clickOnLoginButton() {

		loginButton.click();
	}
	
	public void clickOnLogoutButton() {

		logout.click();
	}

	public String getActualTitleText() {

		String actualTitletext = ldriver.getTitle();

		return actualTitletext;

	}

	public String getTextOFAlert() {

		Alert alt = ldriver.switchTo().alert();
		String alertText = alt.getText();
		return alertText;
	}

	public void clickOnAcceptAlert() {
		Alert alt = ldriver.switchTo().alert();
		alt.accept();
	}

}
