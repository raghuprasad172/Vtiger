package com.vtiger.testpom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.vtiger.generics.BaseTest;
import com.vtiger.generics.Excel;
import com.vtiger.pom.Administrator_HomePage;
import com.vtiger.pom.LoginPage;

public class DeleteTestProjectTask extends BaseTest {
	@Test
	public static void deleteTask() throws InterruptedException {
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
	WebElement more = driver.findElement(By.xpath("//table[@class='hdrTabBg']/descendant::a[contains(.,'More')]"));
	Actions a = new Actions(driver);
	a.moveToElement(more).build().perform();
	driver.findElement(By.xpath("//table[@class='allMnuTable']/descendant::a[@name='Project Tasks']")).click();
	driver.findElement(By.id("16")).click();
	driver.findElement(By.xpath("//form[@id='massdelete']/descendant::table[7]/descendant::tr[4]/descendant::td[10]/a[2]")).click();
	driver.switchTo().alert().accept();
	}
}
