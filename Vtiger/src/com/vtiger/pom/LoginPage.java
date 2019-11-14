package com.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(name = "user_name")
	private WebElement un;
	@FindBy(name = "user_password")
	private WebElement pw;
	@FindBy(xpath = "//div[@class='button']/input")
	private WebElement loginbutton;

	public LoginPage(WebDriver driver) {
		 
		PageFactory.initElements(driver, this);
	}

	public void inputUn(String text) {
		un.sendKeys(text);
	}

	public void inputPw(String text) {
		pw.sendKeys(text);
	}

	public void loginClick() {
		loginbutton.click();
}
}
