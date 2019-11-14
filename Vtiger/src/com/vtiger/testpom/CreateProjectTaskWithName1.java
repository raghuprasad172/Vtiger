package com.vtiger.testpom;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.vtiger.generics.BaseTest;
import com.vtiger.generics.Excel;
import com.vtiger.pom.Administrator_HomePage;
import com.vtiger.pom.LoginPage;

public class CreateProjectTaskWithName1 extends BaseTest {
	@Test
	public static void createTaskWithName() throws InterruptedException {
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
	driver.findElement(By.id("qccombo")).click();
	WebElement quickcreate = driver.findElement(By.id("qccombo"));
	Select s= new Select(quickcreate);
	s.selectByVisibleText("New Project Task");
	driver.findElement(By.xpath("//input[@name='projecttaskname']")).sendKeys("Test suite");
	driver.findElement(By.xpath("//img[@title='Select']")).click();
	String parent=driver.getWindowHandle();
	Set<String> child = driver.getWindowHandles();
	for (String ch : child) {
		driver.switchTo().window(ch);
	}
	driver.findElement(By.xpath("//tr[@bgcolor='white']/descendant::a[contains(.,'TestDrive_01')]")).click();
	driver.switchTo().window(parent);
	driver.findElement(By.xpath("//form[@method='POST']/descendant::table/descendant::input[@title='Save [Alt+S]'][1]")).click();
	
	
	
	}
}
