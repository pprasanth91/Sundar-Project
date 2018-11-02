package com.utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelTestData_BPO {

	private static XSSFWorkbook workbook ;
	
	public String Job_Title =null;
	public String First_Name = null;
	public String Middle_Name = null;
	public String Last_Name = null;
	public String Gender = null;
	public String DOB = null;
	public String Email = null;
	public String Previously_Worked_In_Accenture = null;
	public String Pincode = null;
	public String Present_Address = null;
	public String Mobile = null;
	public String Country_Code = null;
	public String Area_Code = null;
	public String Residential_Number = null;
	public String Country = null;
	public String State =   null;
	public String City = null;
	public String Other_City = null;
	public String Nationality = null;
	public String Citizenship = null;
	public String Notice_Period = null;
	public String Relevant_Experience_In_Years = null;
	public String Current_Annual_Salary =   null;
	public String Expected_Annual_Salary = null;
	public String Is_Aadhar_Card_Available = null;
	public String Aadhar_Number = null;
	public String Aadhar_Enroll_Num = null;
	public String Passport_Number = null;
	public String Total_Experience = null;
	public String Highest_Educational_Qualification =   null;
	public String Year_Graduated = null;
	public String Specialization = null;
	public String Is_Pan_Card_Available = null;
	public String Pan_Number = null;
	public String Is_Passport_Available = null;
	public String College_Name = null;
	public String How_Did_You_Hear_About_Us =   null;
	public String Chk_willing_other_roles = null;
	
	
	public ExcelTestData_BPO() throws IOException {
		Job_Title = getvalue(0);
		First_Name = getvalue(1);
		Middle_Name = getvalue(2);
		Last_Name = getvalue(3);
		Gender = getvalue(4);
		DOB = getvalue(5);
		Email = getvalue(6);
		Previously_Worked_In_Accenture = getvalue(7);
		Pincode = getvalue(8);
		Present_Address = getvalue(9);
		Mobile = getvalue(10);
		Country_Code = getvalue(11);
		Area_Code = getvalue(12);
		Residential_Number = getvalue(13);
		Country = getvalue(14);
		//year = Long.parseLong(getvalue(15));
		State = getvalue(15);
		City = getvalue(16);
		Other_City = getvalue(17);
		Nationality = getvalue(18);
		Citizenship=getvalue(19);
		Notice_Period=getvalue(20);
		Relevant_Experience_In_Years=getvalue(21);
		Current_Annual_Salary=getvalue(22);
		Expected_Annual_Salary=getvalue(23);
		Is_Aadhar_Card_Available=getvalue(24);
		Aadhar_Number=getvalue(25);
		Aadhar_Enroll_Num=getvalue(26);
		Passport_Number=getvalue(27);
		Total_Experience=getvalue(28);
		Highest_Educational_Qualification=getvalue(29);
		Year_Graduated=getvalue(30);
		Specialization=getvalue(31);
		Is_Pan_Card_Available=getvalue(32);
		Pan_Number=getvalue(33);
		Is_Passport_Available=getvalue(34);
		College_Name=getvalue(35);
		How_Did_You_Hear_About_Us=getvalue(36);
		Chk_willing_other_roles=getvalue(37);
			
	}
	
	public static String getvalue(int columnNumber) throws IOException
	{
		try {
			String value = null;
			
			FileInputStream file = new FileInputStream("./test-input/TestDataJobApply.xlsx"); 
			 workbook = new XSSFWorkbook(file);
			 XSSFSheet sheet = workbook.getSheet("Job Apply BPO");
			 
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


