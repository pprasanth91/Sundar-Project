package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTestDataEmployee {

private static XSSFWorkbook workbook ;
	
	public String enterpriseid=null;
	public String password = null;
	public String entity = null;
	public String category = null;
	public String status = null;
	public String created_by = null;
	public String date_from = null;
	public String date_to = null;
	public String select_ig = null;
	public String cid = null;
	public String incident_number = null;
	public String message = null;
	public String sla_breach = null;


public ExcelTestDataEmployee() throws IOException {
	enterpriseid = getvalue(0);
	password = getvalue(1);
	entity = getvalue(2);
	category = getvalue(3);
	status = getvalue(4);
	created_by = getvalue(5);
	date_from = getvalue(6);
	date_to = getvalue(7);
	select_ig = getvalue(8);
	cid = getvalue(9);
	incident_number = getvalue(10);
	message = getvalue(11);
	sla_breach = getvalue(12);
	
	
}

public static String getvalue(int columnNumber) throws IOException
{
	try {
		String value = null;
		
		FileInputStream file = new FileInputStream("./test-input/TestDataEmployee.xlsx"); 
		 workbook = new XSSFWorkbook(file);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 
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
	return null; 
}

	
public void close() throws IOException
{
	workbook.close(); 
}

}

