package com.utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTestDataEAF {

	private static XSSFWorkbook workbook ;
	
	public String username = null;
	public String password = null;
	public String salutation=null;
	public String first_name = null;	
	public String middlename = null;
	public String lastname = null;
	public String gender = null;
	public String primary_skill = null;
	public String source = null;
	public String cfn_source = null;
	public String candidate_name = null;
	public String rel_with_ref = null;
	public String place_of_birth = null;
	public String nationality = null;
	public String citizenship = null;
	public String marital_status =   null;
	public String spouse = null;
	public String maiden = null;
	public String father = null;
	public String mother = null;
	public String guardian = null;
	public String perm_phone_num = null;
	public String alt_phone_num = null;
	public String emailID = null;
	public String alt_emailID = null;
	public String current_add = null;
	public String pincode = null;
	public String pref_work_location = null;
	public String held_passport = null;
	public String passport_num = null;
	public String visa_reject = null;
	public String visa_reject_country = null;
	public String visa_reject_reason = null;
	public String PAN = null;
	public String NSR = null;
	public String driving_license = null;
	public String ref_name = null;
	public String ref_designation = null;
	public String ref_org = null;
	public String ref_telephone = null;
	public String ref_email = null;
	public String ref_address = null;
	public String ref_relationship = null;
	public String ref2_name = null;
	public String ref2_designation = null;
	public String ref2_org = null;
	public String ref2_telephone = null;
	public String ref2_email = null;
	public String ref2_adddress = null;
	public String ref2_rel = null;
	public String ex_acc = null;
	public String ex_entity = null;
	public String ex_old_emp_id = null;
	public String apply_acc_6months = null;
	public String previous_cid = null;
	public String edu1_qua = null;
	public String edu1_spe = null;
	public String edu1_inst_name = null;
	public String edu1_univ_name = null;
	public String edu1_prgtype = null;
	public String edu1_marks = null;
	public String edu2_qua = null;
	public String edu2_spe = null;
	public String edu2_inst_name = null;
	public String edu2_univ_name = null;
	public String edu2_prgtype = null;
	public String edu2_marks = null;
	public String edu3_qua = null;
	public String edu3_spe = null;
	public String edu3_inst_name = null;
	public String edu3_univ_name = null;
	public String edu3_prgtype = null;
	public String edu3_marks = null;
	public String edu_reason_gap = null;
	public String comp_name = null;
	public String other_comp_name = null;
	public String position_held = null;
	public String emp_type = null;
	public String rep_to = null;
	public String address_tele = null;
	public String emp_code = null;
	public String last_drawn_salary = null;
	public String pf = null;
	public String pf_num = null;
	public String reason_for_leaving = null;
	public String mode_separation1 = null;
	public String other_mode_seperation1 = null;
	public String reason_fr_gap_exp = null;
	public String foreign_passport = null;
	public String country_of_issue = null;
	public String aadhaar_card = null;
	public String aadhaar_num = null;
	public String name_aadhaar = null;
	public String enrollment_num = null;
	public String deg_status = null;
	
	public ExcelTestDataEAF() throws IOException {
		username = getvalue(0);
		password = getvalue(1);
		salutation=getvalue(2);
		first_name = getvalue(3);	
		middlename = getvalue(4);
		lastname = getvalue(5);
		gender = getvalue(6);
		primary_skill = getvalue(7);
		source = getvalue(8);
		cfn_source = getvalue(9);
		candidate_name = getvalue(10);
		rel_with_ref = getvalue(11);
		place_of_birth = getvalue(12);
		nationality = getvalue(13);
		citizenship = getvalue(14);
		marital_status = getvalue(15);
		spouse = getvalue(16);
		maiden = getvalue(17);
		father = getvalue(18);
		mother = getvalue(19);
		guardian = getvalue(20);
		perm_phone_num = getvalue(21);
		alt_phone_num = getvalue(22);
		emailID = getvalue(23);
		alt_emailID = getvalue(24);
		current_add = getvalue(25);
		pincode = getvalue(26);
		pref_work_location = getvalue(27);
		held_passport = getvalue(28);
		passport_num = getvalue(29);
		visa_reject = getvalue(30);
		visa_reject_country = getvalue(31);
		visa_reject_reason = getvalue(32);
		PAN = getvalue(33);
		NSR = getvalue(34);
		driving_license = getvalue(35);
		ref_name = getvalue(36);
		ref_designation = getvalue(37);
		ref_org = getvalue(38);
		ref_telephone = getvalue(39);
		ref_email = getvalue(40);
		ref_address = getvalue(41);
		ref_relationship = getvalue(42);
		ref2_name = getvalue(43);
		ref2_designation = getvalue(44);
		ref2_org = getvalue(45);
		ref2_telephone = getvalue(46);
		ref2_email = getvalue(47);
		ref2_adddress = getvalue(48);
		ref2_rel = getvalue(49);
		ex_acc = getvalue(50);
		ex_entity = getvalue(51);
		ex_old_emp_id = getvalue(52);
		apply_acc_6months = getvalue(53);
		previous_cid = getvalue(54);
		edu1_qua = getvalue(55);
		edu1_spe = getvalue(56);
		edu1_inst_name = getvalue(57);
		edu1_univ_name = getvalue(58);
		edu1_prgtype = getvalue(59);
		edu1_marks = getvalue(60);
		edu2_qua = getvalue(61);
		edu2_spe = getvalue(62);
		edu2_inst_name = getvalue(63);
		edu2_univ_name = getvalue(64);
		edu2_prgtype = getvalue(65);
		edu2_marks = getvalue(66);
		edu3_qua = getvalue(67);
		edu3_spe = getvalue(68);
		edu3_inst_name = getvalue(69);
		edu3_univ_name = getvalue(70);
		edu3_prgtype = getvalue(71);
		edu3_marks = getvalue(72);
		edu_reason_gap = getvalue(73);
		comp_name = getvalue(74);
		other_comp_name = getvalue(75);
		position_held = getvalue(76);
		emp_type = getvalue(77);
		rep_to = getvalue(78);
		address_tele = getvalue(79);
		emp_code = getvalue(80);
		last_drawn_salary = getvalue(81);
		pf = getvalue(82);
		pf_num = getvalue(83);
		reason_for_leaving = getvalue(84);
		mode_separation1 = getvalue(85);
		other_mode_seperation1 = getvalue(86);
		reason_fr_gap_exp = getvalue(87);
		foreign_passport = getvalue(88);
		country_of_issue = getvalue(89);
		aadhaar_card = getvalue(90);
		aadhaar_num = getvalue(91);
		name_aadhaar = getvalue(92);
		enrollment_num = getvalue(93);
		deg_status = getvalue(94);
		//year = Long.parseLong(getvalue(15));
						
	}
	
	public static String getvalue(int columnNumber) throws IOException
	{
		try {
			String value = null;
			
			FileInputStream file = new FileInputStream("./test-input/TestDataEAF.xlsx"); 
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


