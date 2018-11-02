package com.utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTestDataAgencyJobApply {

	private static XSSFWorkbook workbook ;
	
	public String agencyid=null;
	public String password = null;
	public String firstname = null;
	public String middlename = null;
	public String lastname = null;
	public String gender = null;
	public String dob = null;
	public String email = null;
	public String prev_acc_emp = null;
	public String address = null;
	public String pincode = null;
	public String resi_num_city_code = null;
	public String resi_num_area_code = null;
	public String resi_num_landline = null;
	public String mobile_num = null;
	public String country =   null;
	public String state = null;
	public String city = null;
	public String nationality = null;
	public String marital_status = null;
	public String relevant_exp = null;
	public String ctc = null;
	public String ctc_expected = null;
	public String notice_period = null;
	public String agency_name_poc = null;
	public String sr_num = null;
	public String highest_degree = null;
	public String highest_edu_perc = null;
	public String subject = null;
	public String pan = null;
	public String pan_num = null;
	public String passport = null;
	public String passport_num = null;
	public String nsr_num = null;
	public String college = null;
	public String prev_worked_no_org = null;
	public String current_org = null;
	public String current_org1 = null;
	public String industry_alignment = null;
	public String comments = null;
	public String primary_skill = null;
	public String opt_skill1 = null;
	public String opt_skill2 = null;
	public String opt_skill3 = null;
	public String opt_skill4 = null;
	public String entity = null;
	public String alt_email_id = null;
	public String nationality_ent_key = null;
	public String nationality_ent = null;
	public String total_exp_ent = null;
	public String rel_exp_months_ent = null;
	public String management_level = null;
	public String current_org_ent = null;
	public String higher_edu_ent = null;
	public String current_location_ent = null;
	public String comments_ent = null;
	public String citizenship = null;
	public String qualification = null;
	public String year_of_passing=null;
	public String total_exp_bpo=null;
	public String bpo_exp_bpo=null;
	public String specialization=null;
	
	
	public ExcelTestDataAgencyJobApply() throws IOException {
		agencyid = getvalue(0);
		password = getvalue(1);
		firstname = getvalue(2);
		middlename = getvalue(3);
		lastname = getvalue(4);
		gender = getvalue(5);
		dob = getvalue(6);
		email = getvalue(7);
		prev_acc_emp = getvalue(8);
		address = getvalue(9);
		pincode = getvalue(10);
		resi_num_city_code = getvalue(11);
		resi_num_area_code = getvalue(12);
		resi_num_landline = getvalue(13);
		mobile_num = getvalue(14);
		//year = Long.parseLong(getvalue(15));
		country = getvalue(15);
		state = getvalue(16);
		city = getvalue(17);
		nationality = getvalue(18);
		marital_status = getvalue(19);
		relevant_exp = getvalue(20);
		ctc = getvalue(21);
		ctc_expected = getvalue(22);
		notice_period = getvalue(23);
		agency_name_poc = getvalue(24);
		sr_num = getvalue(25);
		highest_degree = getvalue(26);
		highest_edu_perc = getvalue(27);
		subject = getvalue(28);
		pan = getvalue(29);
		pan_num = getvalue(30);
		passport = getvalue(31);
		passport_num = getvalue(32);
		nsr_num = getvalue(33);
		college = getvalue(34);
		prev_worked_no_org = getvalue(35);
		current_org = getvalue(36);
		current_org1 = getvalue(37);
		industry_alignment = getvalue(38);
		comments = getvalue(39);
		primary_skill = getvalue(40);
		opt_skill1 = getvalue(41);
		opt_skill2 = getvalue(42);
		opt_skill3 = getvalue(43);
		opt_skill4 = getvalue(44);
		entity = getvalue(45);
		alt_email_id = getvalue(46);
		nationality_ent_key = getvalue(47);
		nationality_ent = getvalue(48);		
		total_exp_ent = getvalue(49);
		rel_exp_months_ent = getvalue(50);
		management_level = getvalue(51);
		current_org_ent = getvalue(52);
		higher_edu_ent = getvalue(53);
		current_location_ent = getvalue(54);
		comments_ent = getvalue(55);
		citizenship= getvalue(56);
		qualification= getvalue(57);
		year_of_passing=getvalue(58);
		total_exp_bpo=getvalue(59);
		bpo_exp_bpo=getvalue(60);
		specialization=getvalue(61);
		
	}
	
	public static String getvalue(int columnNumber) throws IOException
	{
		try {
			String value = null;
			
			FileInputStream file = new FileInputStream("./test-input/TestDataJobApplyAgency.xlsx"); 
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
