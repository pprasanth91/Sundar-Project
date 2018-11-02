	package com.utilities;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;

	import org.apache.poi.ss.usermodel.CellType;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTestDataAgencyCheckCandStatus {

		private static XSSFWorkbook workbook ;		
		public String entity=null;		
		public String firstname = null;	
		public String lastname = null;
		public String candEmailID = null;
		public String CID = null;
		public String refFromDate = null;
		public String refToDate = null;
		public String workforce = null;
		public String candStatus = null;
		public String speciality = null;
		public String skill = null;
		public String location = null;
		public String mobile_num = null;
		public String wannaChangeCIDDet =   null;
		public String ISD = null;
		public String STD = null;
		public String landline = null;
		public String mobile = null;
		public String newComments = null;
		public String uploadResume = null;
		public String viewIntDetails = null;
		public String exportResults = null;
		public String passwordForExport = null;
		public String position_no = null;
			
		
		public ExcelTestDataAgencyCheckCandStatus() throws IOException {
			entity = getvalue(0);
			firstname = getvalue(1);
			lastname = getvalue(2);
			candEmailID = getvalue(3);
			CID = getvalue(4);
			refFromDate = getvalue(5);
			refToDate = getvalue(6);
			workforce = getvalue(7);
			candStatus = getvalue(8);
			speciality = getvalue(9);
			skill = getvalue(10);
			location = getvalue(11);
			mobile_num = getvalue(12);
			wannaChangeCIDDet = getvalue(13);
			ISD = getvalue(14);
			//year = Long.parseLong(getvalue(15));
			STD = getvalue(15);
			landline = getvalue(16);
			mobile = getvalue(17);
			newComments = getvalue(18);
			uploadResume = getvalue(19);
			viewIntDetails = getvalue(20);
			exportResults = getvalue(21);
			passwordForExport = getvalue(22);
			position_no = getvalue(23);
		}
		
		public static String getvalue(int columnNumber) throws IOException
		{
			try {
				String value = null;
				
				FileInputStream file = new FileInputStream("./test-input/TestDataJobApplyAgency.xlsx"); 
				 workbook = new XSSFWorkbook(file);
				 XSSFSheet sheet = workbook.getSheetAt(2);
				 
				 int startrow = 1;
				 int totalrow = sheet.getLastRowNum();
				 for(int m = startrow; m<=totalrow; m++){
					 value = getcolumnvalue(sheet, columnNumber, m);
					 
				 }
					 
						 
			return value.trim();
				 
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
			else if(cell.getCellTypeEnum() == CellType.BLANK){
				return "";
			}
			return null; 
		}
		
			
		public void close() throws IOException
		{
			workbook.close(); 
		}
		
		}


