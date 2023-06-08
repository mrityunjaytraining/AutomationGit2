package com.seleniumExcel.Utility;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ComparingAge_Factors 
{
	public static void main(String[] args) throws Exception
	{
		// Attach a file to a FileInputStream as this will enable us to read data from the file & providing the path where file is kept
				FileInputStream fis = new FileInputStream("C:\\Users\\Computer\\Desktop\\Hyderabad1.xlsx");
				
				//creating workbook instance that refers to .xlsx file
				XSSFWorkbook wb = new XSSFWorkbook(fis);

				// Get the desired sheet from the workbook
				XSSFSheet sheet = wb.getSheet("people");
				
				// Get the desired row from the sheet
				XSSFRow row = sheet.getRow(0);
				
		/*		int rowTotal = sheet.getLastRowNum()+1;   //it counts from 0 that's why i gave +1
				System.out.println(rowTotal);   */
					
	        	// for declaring variables because local variable must declare
				// here cellNum is getting initialized by integer 0, means we are storing integer '0' in cellNum.
				int cellNum = 0;
				for(int i=0;i<row.getLastCellNum();i++)  //Returns the cell at the given (0 based) index, with the specified Row.
				{
					if(row.getCell(i).getStringCellValue().trim().equals("Status"))
						cellNum = i;
				}		
				 for (int i = 1;i<=sheet.getLastRowNum(); i++)
				{
					row = sheet.getRow(i);
					
					XSSFCell cell = row.getCell(cellNum);
					
					if(row.getCell(cellNum-1).getNumericCellValue()<18)
						{
								cell.setCellValue("Minor");
								
						}
					else
					{
						cell.setCellValue("Major");
					}
				}			
				//Creates a file output stream to write to the file represented by the specified File object.
				FileOutputStream	fos = new FileOutputStream("C:\\Users\\Computer\\Desktop\\Hyderabad1.xlsx");
				
				wb.write(fos);
				
				wb.close();
				
				fos.close();

				fis.close();	
	}
}
