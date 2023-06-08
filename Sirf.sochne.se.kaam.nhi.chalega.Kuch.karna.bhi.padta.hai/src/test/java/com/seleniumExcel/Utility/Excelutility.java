package com.seleniumExcel.Utility;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
public class Excelutility 
{
	
	public static WritableSheet writableSh;
	public static WritableWorkbook workbookcopy;
	
	public static void main(String[] args) throws Exception
	{
		FileInputStream testfile = new FileInputStream("C:\\Users\\Computer\\Desktop\\Data.xls");
		
		//Now get Workbook
		Workbook wbook=Workbook.getWorkbook(testfile);
		
		//Now get Workbook Sheet
		Sheet sheet=wbook.getSheet("people");
		
		int norows = sheet.getRows();
		
		//Read rows and Columns and save it in String two dimensional array
		String inputdata[][] = new String[sheet.getRows()][sheet.getColumns()];
		System.out.println("Number of rows present in data xlsx file is - - - - >" +norows);
		
		//For Writing the data into excel we will use FileOutputStream class
		
		FileOutputStream	testoutput = new FileOutputStream("C:\\Users\\Computer\\Desktop\\Data1.xls");
		System.out.println("Creating File one");
		
		//To Create Writable workbook
		workbookcopy =Workbook.createWorkbook(testoutput);
		System.out.println("Creating file 2");
		
		//To create Writable sheet in Writable workbook
		writableSh = workbookcopy.createSheet("people",0);
		System.out.println("Creating file 3");
		
		//Using for loop to write all the data to new sheet
		for(int i=0;i<sheet.getRows();i++)
		{
			for(int k =0;k<sheet.getColumns();k++)
			{
				inputdata[i][k] = sheet.getCell(k,i).getContents();
				Label l = new Label(k,i,inputdata[i][k]);
				Label l2 = new Label(2,0,"Status");
				writableSh.addCell(l);
				writableSh.addCell(l2);
			}
			
		}
		
	}

}
