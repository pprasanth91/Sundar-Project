package com.utilities;
import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils_ICO {
	 
	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;

public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   

   String[][] tabArray = null;

   try {

	   FileInputStream ExcelFile = new FileInputStream(FilePath);

	   // Access the required test data sheet

	   ExcelWBook = new XSSFWorkbook(ExcelFile);

	   ExcelWSheet = ExcelWBook.getSheet(SheetName);

	   int startRow = 1;

	   int startCol = 1;

	   int ci,cj;

	   int totalRows = ExcelWSheet.getLastRowNum();

	   // you can write a function as well to get Column count

	   int totalCols = 39 ;//Total rows -1

	   tabArray=new String[totalRows][totalCols];

	   ci=0;

	   for (int i=startRow;i<=totalRows;i++, ci++) {           	   

		  cj=0;

		   for (int j=startCol;j<=totalCols;j++, cj++){

			   tabArray[ci][cj]=getCellData(i,j);

			   System.out.println(tabArray[ci][cj]);  

				}

			}

		}

	catch (FileNotFoundException e){

		System.out.println("Could not read the Excel sheet");

		e.printStackTrace();

		}

	catch (IOException e){

		System.out.println("Could not read the Excel sheet");

		e.printStackTrace();

		}

	return(tabArray);

	}

private static String getCellData(int RowNum, int ColNum) {
	
	try {
		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		int dataType = Cell.getCellType();
		String CellData = null;
		
		if (Cell.getCellTypeEnum() == CellType.NUMERIC) {
			Double doubleVal = Cell.getNumericCellValue();
			int intVal = doubleVal.intValue();
			CellData = Integer.toString(intVal);
			
		} 
		else if (Cell.getCellTypeEnum() == CellType.STRING) {
			CellData = Cell.getStringCellValue();
			
		} 
		
		return CellData;
//	}
//		if  (dataType == 3) {
//			 
//			return "";
//
//		}else{
//			String CellData = Cell.getStringCellValue();
//			 
//			return CellData;
//		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
		 
		throw (e);
	}
		
}

}