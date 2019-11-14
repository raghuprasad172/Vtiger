package com.vtiger.generics;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public static int getRow(String path, String sheet) {
		FileInputStream fis;
		int rc = -1;
		try {
			fis = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			rc=wb.getSheet(sheet).getLastRowNum();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rc;
		
	}
	public static int getColumn(String path, String sheet ) {
		FileInputStream fis;
		int cc = 0;
		try {
			fis = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			cc=wb.getSheet(sheet).getLastRowNum();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cc;
		
	}
	public static String getData(String path, String sheet, int row, int column ) {
		String value = " ";
		FileInputStream fis;
		try {
			fis= new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			value=wb.getSheet(sheet).getRow(row).getCell(column).toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
		
	}
	public static void createFile(String path, String sheet) {
		FileInputStream fis;
		try {
			fis = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			wb.getSheet(sheet).createRow(0).createCell(0).setCellValue("Testcase name");
			wb.getSheet(sheet).getRow(0).createCell(1).setCellValue("Testcase status");
			FileOutputStream fos = new FileOutputStream(path);
			wb.write(fos);
			fos.close();
			wb.close();
		} catch (Exception e) {
			System.out.println("File not found exception");
			e.printStackTrace();
		}
	}


	public static void report(String name, String path, String sheet, int row, int column, int status) {
		FileInputStream fis;
		int col = column;
		try {
			fis = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			wb.getSheet(sheet).createRow(row).createCell(col).setCellValue(name);
			col++;
			wb.getSheet(sheet).getRow(row).createCell(col).setCellValue(status);
			FileOutputStream fos = new FileOutputStream(path);
			wb.write(fos);
			fos.close();
			wb.close();
		} catch (Exception e) {
			System.out.println("File not found exception");
			e.printStackTrace();
		}
	}
}
