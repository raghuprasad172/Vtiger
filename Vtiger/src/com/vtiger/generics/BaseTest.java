package com.vtiger.generics;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;




public class BaseTest implements IAutoConst {
public static Properties con;
public static FileInputStream fis;
public static WebDriver driver;
public static String b_name = " ";
static {
	try {
		fis = new FileInputStream(CON_FIG);
		con = new Properties();
		con.load(fis);
		b_name=con.getProperty("browser");
		if (b_name.contains("chrome")) {
			System.setProperty(CHROME_KEY, CHROME_VALUE);
		}
		else {
			System.setProperty(FIREFOX_KEY, FIREFOX_VALUE);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	
	@BeforeMethod
	public static void before() {
		if (b_name.contains("chrome")) {
			driver = new ChromeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
	}

	@AfterMethod
	public static void afterM(ITestResult result) {
		String name=result.getName();
		int status=result.getStatus();
		if (status==1) {
			Reporter.log("Pass", false);
			//Excel.createFile(XL,SH);
			Excel.report(name, XL, SH, 1, 0, status);
			
		}
		else {
			Reporter.log("Fail", true);
			//Excel.createFile(XL,SH);
			Excel.report(name, XL, SH, 1, 0, status);
		}
		driver.close();

}
}

