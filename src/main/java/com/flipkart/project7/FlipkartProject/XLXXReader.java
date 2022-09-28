package com.flipkart.project7.FlipkartProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLXXReader {

//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//
//		
//		particularData();
//		
//	}

	static String value;

	
	
	public static String particularData(String name, int row,int cell) throws IOException {
	
	File f=new File("C:\\Users\\devaa\\eclipse-workspace\\AmazonProject\\Datadriven\\project7.xlsx");
	FileInputStream fi=new FileInputStream(f);  //FileNotFoundException
	Workbook w=new XSSFWorkbook(fi); //IOException
//	Sheet s=w.getSheet("amazon");
	Sheet s=w.getSheet(name);
	Row r=s.getRow(row);
	Cell c=r.getCell(cell);
	CellType ce= c.getCellType();	
	if (ce.equals(CellType.STRING)) {
	
		value =c.getStringCellValue();
//		String ss=c.getStringCellValue();
//		System.out.println(ss);
		
	} else if(ce.equals(CellType.NUMERIC)){
		double d=c.getNumericCellValue();
		int a=(int) d;
		Integer.toString(a);
//		System.out.println(a);	
	}
	
	return value;
	}
}
