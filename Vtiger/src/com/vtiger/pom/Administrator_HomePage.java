package com.vtiger.pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.vtiger.generics.ScreenShot;


public class Administrator_HomePage {
	public Administrator_HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyHomePageIsDisplayed(WebDriver driver, long ETO, String title) throws IOException {
		try {
			WebDriverWait ww = new WebDriverWait(driver, ETO);
			ww.until(ExpectedConditions.titleContains(title));
			Reporter.log("Homepage is Displayed", true);
		} catch (Exception e) {
			Reporter.log("Homepage is not Displayed", true);
			ScreenShot.screenShotAs(driver, title);
			Assert.fail();
		}
	}
			
		}
	

