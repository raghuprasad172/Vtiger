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

public class ModifyTestsuiteProjectTaskName extends BaseTest {
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
	driver.findElement(By.id("8")).click();
	driver.findElement(By.xpath("//form[@id='massdelete']/descendant::table[6]/descendant::td/descendant::input[2]")).click();
	driver.findElement(By.xpath("//input[@id='projecttaskname_mass_edit_check']")).click();
	driver.findElement(By.xpath("//input[@name='projecttaskname']")).sendKeys("testng");
	driver.findElement(By.xpath("//img[@title='Select']")).click();
	String parent = driver.getWindowHandle();
	Set<String> child = driver.getWindowHandles();
	for (String chw : child) {
		driver.switchTo().window(chw);
	}
	driver.findElement(By.xpath("//tr[@bgcolor='white']/descendant::a[contains(.,'TestDrive_01')]")).click();
	driver.switchTo().window(parent);
	Thread.sleep(1000);
	driver.findElement(By.xpath("//form[@id='massedit_form']/descendant::table[@cellspacing=\"0\"][6]/descendant::td/input[1]")).click();
	}
}
