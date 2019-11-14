package com.vtiger.testpom;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vtiger.generics.BaseTest;
import com.vtiger.generics.Excel;
import com.vtiger.generics.ScreenShot;
import com.vtiger.pom.Administrator_HomePage;
import com.vtiger.pom.LoginPage;

public class SearchProjectTasListInSearchTextField extends BaseTest {
	@Test
	public static void displayTask() throws InterruptedException, Exception {
	String un=Excel.getData(XL_PATH, SHEET, 1, 0);
	String pw=Excel.getData(XL_PATH, SHEET, 1, 1);
	String title=Excel.getData(XL_PATH, SHEET, 1, 2);
	System.out.println(un+" "+pw+" "+title);
	LoginPage lp = new LoginPage(driver);
	lp.inputUn(un);
	lp.inputPw(pw);
	lp.loginClick();
	Administrator_HomePage ah = new Administrator_HomePage(driver);
	try {
		ah.verifyHomePageIsDisplayed(driver, 5, title);		
	} catch (Exception e) {
		e.printStackTrace();
	}
	driver.findElement(By.xpath("//img[@align='left']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@value='ProjectTask']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@value='Apply']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@class='searchBtn']")).click();
	String displaytask = driver.findElement(By.xpath("//td[@class='searchResultsRow']")).getText();
	if(displaytask.equals("No Data Found"))
	{
		ScreenShot.screenShotAs(driver, displaytask);
		Assert.fail();
	}
	else
	{
		Reporter.log("Pass",true);
	}
	
	}	
	
}
	
	

