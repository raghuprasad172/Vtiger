package com.vtiger.testpom;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.vtiger.generics.BaseTest;
import com.vtiger.generics.Excel;
import com.vtiger.pom.Administrator_HomePage;
import com.vtiger.pom.LoginPage;

public class CreateProjectTaskWithName extends BaseTest {
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
	WebElement more = driver.findElement(By.xpath("//table[@class='hdrTabBg']/descendant::a[contains(.,'More')]"));
	Actions a = new Actions(driver);
	a.moveToElement(more).build().perform();
	driver.findElement(By.xpath("//table[@class='allMnuTable']/descendant::a[@name='Project Tasks']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//table[@class='lvt small']/descendant::td[@class='small']/descendant::a[1]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@name='projecttaskname']")).sendKeys("testcase");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//img[@title='Select']")).click();
	String parent = driver.getWindowHandle();
	Set<String> allwh = driver.getWindowHandles();
	for(String wh:allwh) {
		//System.out.println(driver.getTitle());
		driver.switchTo().window(wh);
	//	driver.findElement(By.xpath("//tr[@bgcolor='white']/descendant::a[contains(.,'TestDrive_01')]")).click();
		//System.out.println(driver.getTitle());
		}
	driver.findElement(By.xpath("//tr[@bgcolor='white']/descendant::a[contains(.,'TestDrive_01')]")).click();
	driver.switchTo().window(parent);
	driver.findElement(By.xpath("//form[@method='POST']/descendant::table/descendant::input[@title='Save [Alt+S]'][1]")).click();
	
	}
}
