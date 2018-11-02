package com.utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTestDataQM {
	
		private static XSSFWorkbook workbook ;
		
		public String Category=null;
		public String MostCommonQueries = null;
		public String QueriesCategory = null;
		
		
		
		public ExcelTestDataQM() throws IOException {
			
			Category = getvalue(0);
			MostCommonQueries = getvalue(1);
			QueriesCategory = getvalue(2);
			
		}
		
		public static String getvalue(int columnNumber) throws IOException
		{
			try {
				String value = null;
				
				FileInputStream file = new FileInputStream("./test-input/TestDataQM.xlsx"); 
				 workbook = new XSSFWorkbook(file);
				 XSSFSheet sheet = workbook.getSheetAt(0);
				 
				 int startrow = 2;
				 int totalrow = sheet.getLastRowNum();
				 for(int m = startrow; m<=totalrow; m++){
					 value = getcolumnvalue(sheet, columnNumber, m);
					 
				 }
					 
						 
			return value;
				 
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return null;
			} 
		}


		@SuppressWarnings("deprecation")
		public static String getcolumnvalue(XSSFSheet sheet, int columnNumber, int rownumber)
		{
			XSSFRow row = sheet.getRow(rownumber); //row is static since only one row of data is in excel, can be modified to loop through the rows of data if more data are added
			XSSFCell cell = row.getCell(columnNumber);
			
			
			if (cell.getCellTypeEnum() == CellType.NUMERIC) {
				Double doubleVal = cell.getNumericCellValue();
				int intVal = doubleVal.intValue();
				return Integer.toString(intVal);
			} 
			else if (cell.getCellTypeEnum() == CellType.STRING) {
				return cell.getStringCellValue();
			} 
			return null; 
		}
		
			
		public void close() throws IOException
		{
			workbook.close(); 
		}
		
		}

