package com.vtiger.testpom;


import org.testng.annotations.Test;

import com.vtiger.generics.BaseTest;
import com.vtiger.generics.Excel;
import com.vtiger.pom.Administrator_HomePage;
import com.vtiger.pom.LoginPage;



public class TestValidLogin extends BaseTest {
	@Test
	public static void validLogin() {
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
	
	}
}
