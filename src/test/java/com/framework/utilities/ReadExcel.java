package com.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static String [][] readData (String fileName, String sheetName){
		String [][]  data = null;
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\"+fileName);
			XSSFWorkbook workbook = new XSSFWorkbook(fis); //read the excel file
			XSSFSheet sh = workbook.getSheet(sheetName); //get the specific sheet from excel file
			int totalRows = sh.getPhysicalNumberOfRows(); //get total rows having test data
			int totalColumns = sh.getRow(0).getPhysicalNumberOfCells();//get total columns having data
			
			data = new String [totalRows-1][totalColumns];
			
			for ( int row = 1; row <totalRows ; row++) { //iterate over rows by excluding 1st row as we are having column headers
				for(int col=0; col <totalColumns; col++) { //iterate over columns
					data [row-1][col] = sh.getRow(row).getCell(col).getStringCellValue(); //get value from each row and cell and store in 2D array
				}
			}	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return data;		
	}

}
