package com.pageobjects;

import org.openqa.selenium.*;

public class PageObjectsJobApply {

	private static WebElement element = null;
	
	//Sign In as Candidate Login
	public static WebElement lnk_candidate_login(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='btnCandLogin']"));
	      return element;
	   }
	
	//Search for Jobs link in IJP home page
	public static WebElement lnk_search_jobs(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Search for Jobs"));
	      return element;
	   }
	
	//Input text box for searching job
	public static WebElement txt_search_input(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='search-input-txt']"));
	      return element;
	   }
	
	//Find button for searching job
	public static WebElement btn_search_inputjobs(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='search-btn']"));
	      return element;
	   }
	
	//The first Abap Professional New hyperlink
	public static WebElement lnk_searched_keyword(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='job-seach-results']/div[1]/h2/a"));
	      return element;
	   }
	
	//Job Listing Heading Visibility
	public static WebElement visi_job_listing(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='maincontent-hero']"));
	      return element;
	   }
	
	
	//Apply for Job hyperlink
	public static WebElement lnk_apply(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("APPLY"));
	      return element;
	   }
	
	//Save this job hyperlink
	public static WebElement lnk_save_this_job(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("SAVE THIS JOB"));
	      return element;
	   }
	
	//Share this job hyperlink
	public static WebElement lnk_share_this_job(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText(" SHARE THIS JOB"));
	      return element;
	   }
	
	//Terms and conditions Heading Visibility
	public static WebElement visi_terms_cond(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='applyJobModal']/div/div/div[1]/h2"));
	      return element;
	   }
	
	//Terms and conditions Cancel button
	public static WebElement btn_terms_cancel(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='applyJobModal']/div/div/div[2]/div/div/div/div/div[2]/button[2]"));
	      return element;
	   }
	
	//Terms and Conditions Agree button
	public static WebElement btn_terms_agree(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//button[@class='btn btn-ice' and text()='Yes']"));
	      return element;
	   }
	
	
	/*
	 * *************************************************************************************************************************************
	 * 									Apply for Job - Resume Upload PAGE ELEMENTS
	 * *************************************************************************************************************************************
	 */
	
	//Resume Upload Link Visiblity	
	public static WebElement lnk_resume_upload(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='resume']/a"));
	      return element;
	   }
	
	//Browse resume/CV Browse Button
	public static WebElement btn_browse_resume(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='IdcApplyJobAdvnController']/div[2]/div[3]/div/div/div[1]/div/label/strong"));
	      return element;
	   }
	
	//Upload resume/CV Browse Button
	public static WebElement btn_upload_resume(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//button[@class='btn btn-ice' and text()='Upload']"));
	      return element;
	   }
	
	
	/*
	 * *************************************************************************************************************************************
	 * 									BASIC DETAILS PAGE ELEMENTS
	 * *************************************************************************************************************************************
	 */
	
	//Basic Details Page Heading Visibility
	public static WebElement visi_basic_details(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='basic']/a"));
	      return element;
	   }
	
	//First Name Field
	public static WebElement txt_first_name(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtFirstName']"));
	      return element;
	   }
	
	//Middle name field
	public static WebElement txt_middle_name(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='middleName']"));
	      return element;
	   }
	
	//Last Name Field
	public static WebElement txt_last_name(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='lastName']"));
	      return element;
	   }
	
	//Gender
	public static WebElement dd_gender(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='genderTitle']/div/span"));
	      return element;
	   }
	
	//Date of Birth
	public static WebElement txt_dob(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='dob']"));
	      return element;
	   }
	
	//Previously worked at Accenture
	public static WebElement dd_previously_wiacc(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='prevAccEmployee']/div/span"));
	      return element;
	   }
	
	//Email
	public static WebElement txt_email(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtMail']"));
	      return element;
	   }
	
	//Present Address
	public static WebElement txt_present_address(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='presentAddress']"));
	      return element;
	   }
	
	//Pincode
	public static WebElement txt_pincode(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='pincode']"));
	      return element;
	   }
	
	//Residential Number (Landline Number - Country Code)
	public static WebElement txt_res_countrycode(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='CountryCode']"));
	      return element;
	   }
	
	//Residential Number (Landline Number - Area Code)
	public static WebElement txt_res_areacode(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='AreaCode']"));
		  return element;
	   }
	
	//Residential Number (Landline Number)
	public static WebElement txt_res_num(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='Landline']"));
		  return element;
	   }
	
	//Mobile Number 
	public static WebElement txt_mobile_num(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='mobile']"));
		  return element;
	   }
	
	//Next button for navigating to advance details page
	public static WebElement btn_next_adv(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_imgNext']"));
		  return element;
	   }
	
	/*
	 * *************************************************************************************************************************************
	 * 									ADVANCED DETAILS PAGE ELEMENTS
	 * *************************************************************************************************************************************
	 */
	
	//BPO Advanced Details Page Elements
	//Country
	public static WebElement dd_country_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='countryTitle']/div/span"));
		  return element;
	   }
	
	//Country Input
	public static WebElement dd_country_input_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='countryTitle']/input[1]"));
		  return element;
	   }
	
	//Country Input Value Select
	public static WebElement dd_country_input_select_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-0-'][1]/a/span"));
		  return element;
	   }
	
	//State
	public static WebElement dd_state_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='stateTitle']/div/span"));
		  return element;
	   }
	
	//State Input
	public static WebElement dd_state_input_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='stateTitle']/input[1]"));
		  return element;
	   }
	
	//State Input Value Select
	public static WebElement dd_state_input_select_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-1-'][1]/a/span"));
		  return element;
	   }
	
	//City
	public static WebElement dd_city_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='cityTitle']/div/span"));
		  return element;
	   }
	
	//City Input
	public static WebElement dd_city_input_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='cityTitle']/input[1]"));
		  return element;
	   }
	
	//City Input Value Select
	public static WebElement dd_city_input_select_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-2-'][1]/a/span"));
		  return element;
	   }
	
	//Other City *
	public static WebElement txt_other_city_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='otherCity']"));
		  return element;
	   }
	
	//Nationality
	public static WebElement dd_nationality_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='nationalityTitle']/div/span"));
		  return element;
	   }
	
	//Nationality Input
	public static WebElement dd_nationality_input_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='nationalityTitle']/input[1]"));
		  return element;
	   }
	
	//Nationality Input Value Select
	public static WebElement dd_nationality_input_select_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-3-'][1]/a/span"));
		  return element;
	   }
	
	//Citizenship
	public static WebElement dd_citizenship_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='citizenshipTitle']/div/span"));
		  return element;
	   }
	
	//Citizenship Input
	public static WebElement dd_citizenship_input_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='citizenshipTitle']/input[1]"));
		  return element;
	   }
	
	//Citizenship Input Value Select
	public static WebElement dd_citizenship_input_select_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-4-'][1]/a/span"));
		  return element;
	   }
	
	//Notice Period
	public static WebElement dd_notice_period_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='noticePeriod']/div/span"));
		  return element;
	   }
	
	//Notice Period Input
	public static WebElement dd_notice_period_input_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='noticePeriod']/input[1]"));
		  return element;
	   }
	
	//Notice Period Input Select
	public static WebElement dd_notice_period_input_select_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-5-'][1]/a/span"));
		  return element;
	   }
	
	//Relevant Experience(in Years) *
	public static WebElement txt_relevant_experience_in_years_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='RelExpTitle']"));
		  return element;
	   }
	
	//Current_Annual_Salary
	public static WebElement txt_Current_Annual_Salary_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='CurrentCtc']"));
		  return element;
	   }
	
	//Expected Annual Salary
	public static WebElement txt_Expected_Annual_Salary_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='ExpCtc']"));
		  return element;
	   }
	
	//Primary skill*
	public static WebElement txt_Primary_Skill_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='PrimarySkill']"));
		  return element;
	   }
	
	//Is Aadhaar card available*
	public static WebElement dd_is_aadhaar_card_available_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='IsAadharAvaTitle']/div/span"));
		  return element;
	   }
	
	//Is Aadhaar card available* Input
	public static WebElement dd_is_aadhaar_card_available_input_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='IsAadharAvaTitle']/input[1]"));
		  return element;
	   }
	
	//Is Aadhaar card available* Input Select
	public static WebElement dd_is_aadhaar_card_available_input_select_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-12-'][1]/a/span"));
		  return element;
	   }
	
	//Aadhaar Number*
	public static WebElement txt_aadhaar_number_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='AadhaarNum']"));
		  return element;
	   }
	
	//Name as on Aadhaar*
	public static WebElement txt_aadhaar_name_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='AadhaarName']"));
		  return element;
	   }
	
	//Aadhaar enrollment number*
	public static WebElement txt_aadhaar_enroll_num_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='AadhaarEnNum']"));
		  return element;
	   }
	
	//Passport No
	public static WebElement txt_passport_no_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='PassportNo']"));
		  return element;
	   }
		
	//Total Experience
	public static WebElement dd_total_exp_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='ExpTitle']/div/span"));
		  return element;
	   }
	
	//Total Experience Input
	public static WebElement dd_total_exp_input_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='ExpTitle']/input[1]"));
		  return element;
	   }
	
	//Total Experience Input Select
	public static WebElement dd_total_exp_input_select_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-6-'][1]/a/span"));
		  return element;
	   }
	
	//Highest Degree
	public static WebElement dd_highdeg_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='graduationTitle']/div/span"));
		  return element;
	   }
	
	//Highest Degree Input
	public static WebElement dd_highdeg_input_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='graduationTitle']/input[1]"));
		  return element;
	   }
	
	//Highest Degree Input Select
	public static WebElement dd_highdeg_input_select_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-7-'][1]/a/span"));
		  return element;
	   }
	
	//Year Gradudated
	public static WebElement txt_year_graduated_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='yearGraduated']"));
		  return element;
	   }
	
	//Specialization
	public static WebElement dd_specialization_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='specializationTitle']/div/span"));
		  return element;
	   }
	
	//Specialization Input
	public static WebElement dd_specialization_input_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='specializationTitle']/input[1]"));
		  return element;
	   }
	
	//Specialization Input Value Select
	public static WebElement dd_specialization_input_select_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-9-'][1]/a/span"));
		  return element;
	   }
	
	//Pancard
	public static WebElement dd_pancard_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='IsPanAvaTitle']/div/span"));
		  return element;
	   }
	
	//Pancard Input
	public static WebElement dd_pancard_input_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='IsPanAvaTitle']/input[1]"));
		  return element;
	   }
	
	//Pancard Input Select
	public static WebElement dd_pancard_input_select_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-13-'][1]/a/span"));
		  return element;
	   }
	
	//Pan Number
	public static WebElement txt_Pan_Number_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='panNo']"));
		  return element;
	   }
		
	//College Name
	public static WebElement dd_college_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='idcOrgName']"));
		  return element;
	   }
	
	//College Name Input
	public static WebElement dd_college_input_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='idcOrgName']"));
		  return element;
	   }
	
	//College Name Input Select
	public static WebElement dd_college_input_select_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='BpoApplyJobAdvnController']/div[2]/div[3]/div/div/div[29]/div/ul/li/a/strong"));
		  return element;
	   }
	
	//How Did You Hear About Us?
	public static WebElement dd_hear_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='sourceTitle']/div/span"));
		  return element;
	   }
	
	//How Did You Hear Us About Input
	public static WebElement dd_hear_input_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='sourceTitle']/input[1]"));
		  return element;
	   }
	
	//How Did you Hear About Us Input Select
	public static WebElement dd_hear_input_select_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-11-'][1]/a/span"));
		  return element;
	   }
	
	//I am willing to be considered for other roles.
	public static WebElement chk_consider_other_roles_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='BpoApplyJobAdvnController']/div[2]/div[3]/div/div/div[33]/div/label"));
		  return element;
	   }	
	
	//Apply For This Opportunity
	public static WebElement btn_apply_ft_oppur_b(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='Main_imgbtnSubmit']"));
		  return element;
	   }
	
	//Confirmation BPO
	public static WebElement visi_confirmation_bpo(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//h2[@class='page-title' and text()='Almost There..']"));
		  return element;
	   }
	
//CID ICO		
public static WebElement visi_CID_bpo(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath("//*[@id='Main_lblCandidateNumberDisplay']"));
		  return element;
	   }

//Timestamp ICO
public static WebElement visi_timestamp_bpo(WebDriver driver)
{
	  element = driver.findElement(By.xpath(".//*[@id='lblMessage']"));
	  return element;
}
	

//SWF Advanced Details Page Elements
	
	//Advanced Details Head Visibility
	public static WebElement lnk_advanced_details(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='advn']/a"));
		  return element;
	   }
	
	//Country
		public static WebElement dd_country(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='country']/div/span"));
			  return element;
		   }
		
		//Country Input
		public static WebElement dd_country_input(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='country']/input[1]"));
			  return element;
		   }
		
		//Country Input Value Select
		public static WebElement dd_country_input_select(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-0-'][1]/a/span"));
			  return element;
		   }
		
		//State
		public static WebElement dd_state(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='state']/div/span"));
			  return element;
		   }
		
		//State Input
		public static WebElement dd_state_input(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='state']/input[1]"));
			  return element;
		   }
		
		//State Input Value Select
		public static WebElement dd_state_input_select(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-1-'][1]/a/div[1]"));
			  return element;
		   }
		
		//City
		public static WebElement dd_city(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='city']/div/span"));
			  return element;
		   }
		
		//City Input
		public static WebElement dd_city_input(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='city']/input[1]"));
			  return element;
		   }
		
		//City Input Value Select
		public static WebElement dd_city_input_select(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-2-'][1]/a/div[1]/span"));
			  return element;
		   }
		
		//Others City
		public static WebElement txt_others_city(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='IdcApplyJobAdvnController']/div[2]/div[3]/div/div/div[5]/div/input"));
			  return element;
		   }
		
		//Nationality
		public static WebElement dd_nationality(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='nationalityTitle']/div/span"));
			  return element;
		   }
		
		//Nationality Input
		public static WebElement dd_nationality_input(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='nationalityTitle']/input[1]"));
			  return element;
		   }
		
		//Nationality Input Value Select
		public static WebElement dd_nationality_input_select(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-3-'][1]/a/span"));
			  return element;
		   }
		
		//Notice Period
		public static WebElement dd_notice_period(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='NoticePeriod']/div/span"));
			  return element;
		   }
		
		//Notice Period Input
		public static WebElement dd_notice_period_input(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='NoticePeriod']/input[1]"));
			  return element;
		   }
		
		//Notice Period Input Select
		public static WebElement dd_notice_period_input_select(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-4-'][1]/a/div"));
			  return element;
		   }
		
		//Relevant Experience (in months)*
		public static WebElement txt_relevant_exp_in_months(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='txtRelevantExperience']"));
			  return element;
		   }
		
		//Current Annual Salary
		public static WebElement txt_current_annual_salary(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='txtCurrentSalary']"));
			  return element;
		   }
		
		//Expected Annual salary
		public static WebElement txt_expected_annual_salary(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='txtExpectedSalary']"));
			  return element;
		   }
		
		//Primary skill
		public static WebElement txt_primary_skill(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='PrimarySkill']"));
			  return element;
		   }
		
		//Year it was last put in practice
		public static WebElement dd_year_put_in_practice(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='IdcApplyJobAdvnController']/div[2]/div[3]/div/div/div[12]/div/div/div/span"));
			  return element;
		   }
		
		//Year it was last put in practice Input
		public static WebElement dd_year_put_in_practice_input(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='IdcApplyJobAdvnController']/div[2]/div[3]/div/div/div[12]/div/div/input[1]"));
			  return element;
		   }
		
		//Year it was last put in practice Input Select
		public static WebElement dd_year_put_in_practice_input_select(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-5-'][1]/a/div/span"));
			  return element;
		   }
		
		//Additional Skill 1
		public static WebElement txt_optional_skill(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='optionalskillName1']"));
			  return element;
		   }
	
		
		//Experience (months)
		public static WebElement txt_experience_in_months(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@name='Experiences1']"));
			  return element;
		   }
		
		//Year it was last put in practice Additional Skill 1
		public static WebElement dd_year_put_in_practice_opt(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath("//*[@id=\"IdcApplyJobAdvnController\"]/div[2]/div[3]/div/div/div[15]/div/div/div/span"));
			  return element;
		   }
		
		//Year it was last put in practice opt Input
		public static WebElement dd_year_put_in_practice_input_opt(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath("//*[@id=\"IdcApplyJobAdvnController\"]/div[2]/div[3]/div/div/div[15]/div/div/input[1]"));
			  return element;
		   }
		
		//Year it was last put in practice opt Input Select
		public static WebElement dd_year_put_in_practice_input_Select_opt(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-6-'][1]/a/div/span"));
			  return element;
		   }
		
		//Total experience
		public static WebElement dd_total_experience(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ExpTitle']/div/span"));
			  return element;
		   }
		
		//Highest Educational Qualification 
		public static WebElement dd_highdeg(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='graduationTitle']/div/span"));
			  return element;
		   }
		
		//Highest Educational Qualification Input
		public static WebElement dd_highdeg_input(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='graduationTitle']/input[1]"));
			  return element;
		   }
		
		//Highest Educational Qualification Input Select
		public static WebElement dd_highdeg_input_select(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-13-'][1]/a/div[1]"));
			  return element;
		   }
		
		//Year Gradudated
		public static WebElement txt_year_graduated(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='yearGraduated']"));
			  return element;
		   }
		
		//Specialization
		public static WebElement dd_specialization(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='specializationTitle']/div/span"));
			  return element;
		   }
		
		//Specialization Input
		public static WebElement dd_specialization_input(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='specializationTitle']/input[1]"));
			  return element;
		   }
		
		//Specialization Input Value Select
		public static WebElement dd_specialization_input_select(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-15-'][1]/a/div[1]"));
			  return element;
		   }
		
		//Is PAN card available*
		public static WebElement dd_is_pancard_available(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='IsPANAvaTitle']/div/span"));
			  return element;
		   }
		
		//Is PAN card available* Input
		public static WebElement dd_is_pancard_available_input(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='IsPANAvaTitle']/input[1]"));
			  return element;
		   }
		
		//Is PAN card available* Input Select
		public static WebElement dd_is_pancard_available_input_select(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-18-'][1]/a/span"));
			  return element;
		   }
		
		//Pancard
		public static WebElement txt_pancard(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='panNo']"));
			  return element;
		   }
		
		//Is Aadhaar card available*
		public static WebElement dd_is_aadhaar_card_available(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='IsAadharAvaTitle']/div/span"));
			  return element;
		   }
		
		//Is Aadhaar card available* Input
		public static WebElement dd_is_aadhaar_card_available_input(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='IsAadharAvaTitle']/input[1]"));
			  return element;
		   }
		
		//Is Aadhaar card available* Input Select
		public static WebElement dd_is_aadhaar_card_available_input_select(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-19-'][1]/a/span"));
			  return element;
		   }
		
		//Aadhaar Number*
		public static WebElement txt_aadhaar_number(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='AadhaarNum']"));
			  return element;
		   }
		
		//Name as on Aadhaar*
		public static WebElement txt_aadhaar_name(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='AadhaarName']"));
			  return element;
		   }
		
		//Aadhaar enrollment number*
		public static WebElement txt_aadhaar_enroll_num(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='AadhaarEnNum']"));
			  return element;
		   }
		
		//Is Passport available
		public static WebElement dd_passport_available(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='IsPassportAvaTitle']/div/span"));
			  return element;
		   }
		
		//Is Passport available Input
		public static WebElement dd_passport_available_input(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='IsPassportAvaTitle']/input[1]"));
			  return element;
		   }
		
		//Is Passport available Input Select
		public static WebElement dd_passport_available_input_select(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-20-'][1]/a/span"));
			  return element;
		   }
		
		//Passport No
		public static WebElement txt_passport_no(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='PassportNo']"));
			  return element;
		   }
		
		//College Name (new graduate)/Organization Name *
		public static WebElement dd_college_name(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='idcOrgName']"));
			  return element;
		   }
		
		//College Name (new graduate)/Organization Name * Input Select
		public static WebElement dd_college_name_input_select(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='IdcApplyJobAdvnController']/div[2]/div[3]/div/div/div[34]/div/ul/li/a"));
			  return element;
		   }
		
		//College Name No
		public static WebElement dd_college(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='idcOrgName']"));
			  return element;
		   }
		
		//College Name Input No
		public static WebElement dd_college_input(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='idcOrgName']"));
			  return element;
		   }
		
		//College Name Input Select No
		public static WebElement dd_college_input_select(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='IdcApplyJobAdvnController']/div[2]/div[3]/div/div/div[16]/div/ul/li/a"));
			  return element;
		   }
		
		//College Name for Others othercollegeName
		public static WebElement txt_other_college_name(WebDriver driver)
		   {
			  element = driver.findElement(By.name("othercollegeName"));
			  return element;
		   }
		
		//Organization Name* (previous/current organization) Please enter 'Others' if it is not applicable
		public static WebElement dd_org_name(WebDriver driver)
		   {
			  element = driver.findElement(By.id("idcOrgName"));
			  return element;
		   }
		
		//Organization Name* (previous/current organization) Please enter 'Others' if it is not applicable Input
		public static WebElement dd_org_name_input(WebDriver driver)
		   {
			  element = driver.findElement(By.id("idcOrgName"));
			  return element;
		   }
		
		//Organization Name* (previous/current organization) Please enter 'Others' if it is not applicable Input Select
		public static WebElement dd_org_name_input_select(WebDriver driver)
		   {
			  element = driver.findElement(By.id("idcOrgName"));
			  return element;
		   }
		
		//Other Organization Name
		public static WebElement dd_org_name_others(WebDriver driver)
		   {
			  element = driver.findElement(By.name("OtherOrganizationName"));
			  return element;
		   }
		
		//How Did You Hear About Us?
		public static WebElement dd_hear(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='sourceTitle']/div/span"));
			  return element;
		   }
		
		//How Did You Hear Us About Input
		public static WebElement dd_hear_input(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='sourceTitle']/input[1]"));
			  return element;
		   }
		
		//How Did you Hear About Us Input Select
		public static WebElement dd_hear_input_select(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-17-'][1]/a/div[1]"));
			  return element;
		   }
		
		//Upload Resume Button No
		public static WebElement btn_resume(WebDriver driver)
		   {
			  element = driver.findElement(By.cssSelector(".form-group>label>strong"));
			  return element;
		   }
		
		//I am willing to be considered for other roles.
		public static WebElement chk_willing_other_roles(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//label[@class='checkbox-custom-label' and text()='I am willing to be considered for other roles.']"));
			  return element;
		   }
		
		//Apply For This Opportunity
		public static WebElement btn_apply_ft_oppur(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//button[@class='btn btn-ice' and text()='Apply for this opportunity']"));
			  return element;
		   }
		
		//Confirmation Heading
		public static WebElement visi_confirmation_swf(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//h2[@class='page-title' and text()='Confirmation']"));
			  return element;
		   }
		
		//Time Stamp 
		public static WebElement visi_timestamp_swf(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath("//*[@id='CandidateConfirmation']/div[1]/div/div/div"));
			  return element;
		   }
		
	//ICO Advanced Details Page Elements
	//Country
		public static WebElement dd_country_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='countryTitle']/div[1]/span/span[2]/span"));
			  return element;
		   }
			
	//Country Input
		public static WebElement dd_country_input_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='countryTitle']/input[1]"));
			  return element;
		   }
				
	//Country Input Value Select
		public static WebElement dd_country_input_select_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-0-1']/a/span"));
			  return element;
		   }
		
	//State
		public static WebElement dd_state_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='stateTitle']/div[1]/span"));
			  return element;
		   }
				
	//State Input
		public static WebElement dd_state_input_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='stateTitle']/input[1]"));
			  return element;
		   }
				
	//State Input Value Select
		public static WebElement dd_state_input_select_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-1-0']/a/span"));
			  return element;
		   }
				
	//City
		public static WebElement dd_city_i(WebDriver driver)
		  {
			  element = driver.findElement(By.xpath(".//*[@id='cityTitle']/div[1]/span"));
			  return element;
		  }
				
	//City Input
		public static WebElement dd_city_input_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath("//*[@id='cityTitle']/input[1]"));
			  return element;
		   }
				
	//City Input Value Select
		public static WebElement dd_city_input_select_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-2-0']/a/span"));
			  return element;
		   }
				
	//Nationality
		public static WebElement dd_nationality_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='nationalityTitle']/div[1]/span/span[1]"));
			  return element;
		   }
				
	//Nationality Input
		public static WebElement dd_nationality_input_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='nationalityTitle']/input[1]"));
			  return element;
		   }
			
	//Nationality Input Value Select
		public static WebElement dd_nationality_input_select_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-3-0']/a/span"));
			  return element;
		   }
		
	//Total Experience
		public static WebElement dd_total_exp_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ExpTitle']/div[1]/span"));
			  return element;
		   }
	
	//Total Experience Input
		public static WebElement dd_total_exp_input_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ExpTitle']/input[1]"));
			  return element;
		   }
		
	//Total Experience Input Select
		public static WebElement dd_total_exp_input_select_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-4-0']/a"));
			  return element;
		   }
						
	//Highest Degree
		public static WebElement dd_highdeg_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='graduationTitle']/div[1]/span/span[1]"));
			  return element;
		   }
				
	//Highest Degree Input
		public static WebElement dd_highdeg_input_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='graduationTitle']/input[1]"));
			  return element;
		   }
				
	//Highest Degree Input Select
		public static WebElement dd_highdeg_input_select_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-5-0']/a/span"));
			  return element;
		   }
				
	//Year Gradudated
		public static WebElement txt_year_graduated_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='yearGraduated']"));
			  return element;
		   }
				
	//Specialization
		public static WebElement dd_specialization_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='specializationTitle']/div[1]/span/span[1]"));
			  return element;
		   }
				
	//Specialization Input
		public static WebElement dd_specialization_input_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='specializationTitle']/input[1]"));
			  return element;
		   }
				
	//Specialization Input Value Select
		public static WebElement dd_specialization_input_select_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-6-0']/a/span"));
			  return element;
		   }
				
	//Pancard
		public static WebElement txt_pancard_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='panNo']"));
			  return element;
		   }
				
	//College Name
		public static WebElement dd_college_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ewfOrg']"));
			  return element;
		   }
				
	//College Name Input
		public static WebElement dd_college_input_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ewfOrg']"));
			  return element;
		   }
			
	//College Name Input Select
		public static WebElement dd_college_input_select_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='EwfApplyJobAdvnController']/div[2]/div[3]/div/div/div[12]/div/ul/li[1]/a"));
			  return element;
		   }
				
	//How Did You Hear About Us?
		public static WebElement dd_hear_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='sourceTitle']/div[1]/span"));
			  return element;
		   }
				
	//How Did You Hear Us About Input
		public static WebElement dd_hear_input_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='sourceTitle']/input[1]"));
			  return element;
		   }
			
	//How Did you Hear About Us Input Select
		public static WebElement dd_hear_input_select_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-7-0']/a/span"));
			  return element;
		   }
				
	//Upload Resume Button
		public static WebElement btn_resume_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='EwfApplyJobAdvnController']/div[2]/div[3]/div/div/div[14]/div/label/strong"));
			  return element;
		   }
			
	//Apply For This Opportunity
		public static WebElement btn_apply_ft_oppur_i(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='EwfApplyJobAdvnController']/div[2]/div[3]/div/div/div[16]/button"));
			  return element;
		   }
		
	//ICF Advanced Details Page Elements
		
		
	//Job Title
		public static WebElement txt_job_title(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath("//*[@id='EwfApplyJobAdvnController']/div[1]/div/div[1]/div/strong"));
			  return element;
		   }
			
	//Country
		public static WebElement dd_country_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='countryTitle']/div/span"));
			  return element;
		   }
			
	//Country Input
		public static WebElement dd_country_input_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='countryTitle']/input[1]"));
			  return element;
		   }
				
	//Country Input Value Select
		public static WebElement dd_country_input_select_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-0-'][1]/a/span"));
			  return element;
		   }
		
	//State
		public static WebElement dd_state_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='stateTitle']/div/span"));
			  return element;
		   }
				
	//State Input
		public static WebElement dd_state_input_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='stateTitle']/input[1]"));
			  return element;
		   }
				
	//State Input Value Select
		public static WebElement dd_state_input_select_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-1-'][1]/a/span"));
			  return element;
		   }
				
	//City
		public static WebElement dd_city_e(WebDriver driver)
		  {
			  element = driver.findElement(By.xpath(".//*[@id='cityTitle']/div/span"));
			  return element;
		  }
				
	//City Input
		public static WebElement dd_city_input_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='cityTitle']/input[1]"));
			  return element;
		   }
				
	//City Input Value Select
		public static WebElement dd_city_input_select_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-2-'][1]/a/span"));
			  return element;
		   }
					
	//Nationality
		public static WebElement dd_nationality_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='nationalityTitle']/div/span"));
			  return element;
		   }
				
	//Nationality Input
		public static WebElement dd_nationality_input_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='nationalityTitle']/input[1]"));
			  return element;
		   }
			
	//Nationality Input Value Select
		public static WebElement dd_nationality_input_select_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-3-'][1]/a/span"));
			  return element;
		   }
		
	//Citizenship
		public static WebElement dd_citizenship_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='citizenshipTitle']/div/span"));
			  return element;
		   }
	
	//Citizenship Input
		public static WebElement dd_citizenship_input_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='citizenshipTitle']/input[1]"));
			  return element;
		   }
		
	//Citizenship Input Value Select
		public static WebElement dd_citizenship_input_select_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-4-'][1]/a/span"));
			  return element;
		   }
	
	//Relevant Experience(in months)*
		public static WebElement txt_relevant_exp_in_months_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='relevantexp']"));
			  return element;
		   }
	
	//Total Experience
		public static WebElement dd_total_exp_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ExpTitle']/div/span"));
			  return element;
		   }
	
	//Total Experience Input
		public static WebElement dd_total_exp_input_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ExpTitle']/input[1]"));
			  return element;
		   }
		
	//Total Experience Input Select
		public static WebElement dd_total_exp_input_select_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-5-'][1]/a/span"));
			  return element;
		   }
		
	//Notice Period
		public static WebElement dd_notice_period_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='noticePeriod']/div/span"));
			  return element;
		   }
		
	//Notice Period Input
		public static WebElement dd_notice_period_input_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='noticePeriod']/input[1]"));
			  return element;
		   }
		
	//Notice Period Input Select
		public static WebElement dd_notice_period_input_select_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-6-'][1]/a/span"));
			  return element;
		   }
						
	//Highest Educational Qualification
		public static WebElement dd_highdeg_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='graduationTitle']/div/span"));
			  return element;
		   }
				
	//Highest Educational Qualification Input
		public static WebElement dd_highdeg_input_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='graduationTitle']/input[1]"));
			  return element;
		   }
				
	//Highest Educational Qualification Input Select
		public static WebElement dd_highdeg_input_select_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-7-'][1]/a/span"));
			  return element;
		   }
				
	//Year Gradudated
		public static WebElement txt_year_graduated_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='yearGraduated']"));
			  return element;
		   }
				
	//Specialization
		public static WebElement dd_specialization_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='specializationTitle']/div/span"));
			  return element;
		   }
				
	//Specialization Input
		public static WebElement dd_specialization_input_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='specializationTitle']/input[1]"));
			  return element;
		   }
				
	//Specialization Input Value Select
		public static WebElement dd_specialization_input_select_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-8-'][1]/a/span"));
			  return element;
		   }
				
	//Current Annual Salary
		public static WebElement txt_current_annual_salary_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='txtCurrentCTC']"));
			  return element;
		   }
		
	//Expected Annual Salary
		public static WebElement txt_expected_annual_salary_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='txtExpectedCTC']"));
			  return element;
		   }		
			
	//The salary can be mentioned as fixed annual pay
		public static WebElement label_fixed_annual_pay1_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='EwfApplyJobAdvnController']/div[2]/div[3]/div/div/div[14]/label[2]"));
			  return element;
		   }
		
	//The salary can be mentioned as fixed annual pay
		public static WebElement label_fixed_annual_pay2_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='EwfApplyJobAdvnController']/div[2]/div[3]/div/div/div[14]/label[2]"));
			  return element;
		   }
	
	//Pancard
		public static WebElement dd_pancard_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='IsPanAvaTitle']/div/span"));
			  return element;
		   }
		
	//Pancard Input
		public static WebElement dd_pancard_input_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='IsPanAvaTitle']/input[1]"));
			  return element;
		   }
		
	//Pancard Input Select
		public static WebElement dd_pancard_input_select_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-9-'][1]/a/span"));
			  return element;
		   }
		
	//PAN Number
		public static WebElement txt_pan_number_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='panNo']"));
			  return element;
		   }
		
	//Passport
		public static WebElement dd_passport_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='IsPassportAvaTitle']/div/span"));
			  return element;
		   }
		
	//Passport Input
		public static WebElement dd_passport_input_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='IsPassportAvaTitle']/input[1]"));
			  return element;
		   }
		
	//Passport Input Select
		public static WebElement dd_passport_input_select_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-10-'][1]/a/span"));
			  return element;
		   }
		
	//Passport Number
		public static WebElement txt_passport_number_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='passportNo']"));
			  return element;
		   }
	
	//Is Aadhaar card available
		public static WebElement dd_aadhar_card_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='Ui-select1']/div/span"));
			  return element;
		   }
		
	//Passport Input
		public static WebElement dd_aadhar_card_input_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='Ui-select1']/input[1]"));
			  return element;
		   }
		
	//Passport Input Select
		public static WebElement dd_aadhar_card_input_select_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-11-'][1]/a/span"));
			  return element;
		   }
	
	//Aadhaar Number*
		public static WebElement txt_aadhar_number_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='AadhaarNum']"));
			  return element;
		   }
		
	//Name as on Aadhaar
		public static WebElement txt_aadhar_name_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='AadhaarName']"));
			  return element;
		   }
		
	//Aadhaar enrollment number*
		public static WebElement txt_aadhaar_enroll_num_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='AadhaarEnNum']"));
			  return element;
		   }
		
	//Sub Function*
		public static WebElement txt_sub_function_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='Function']"));
			  return element;
		   }
		
					
	//College Name
		public static WebElement dd_college_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ewfOrg']"));
			  return element;
		   }
				
	//College Name Input
		public static WebElement dd_college_input_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ewfOrg']"));
			  return element;
		   }
			
	//College Name Input Select
		public static WebElement dd_college_input_select_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='EwfApplyJobAdvnController']/div[2]/div[3]/div/div/div[25]/div/ul/li[1]/a[1]"));
			  return element;
		   }
				
	//How Did You Hear About Us?
		public static WebElement dd_hear_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='sourceTitle']/div/span"));
			  return element;
		   }
				
	//How Did You Hear Us About Input
		public static WebElement dd_hear_input_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='sourceTitle']/input[1]"));
			  return element;
		   }
			
	//How Did you Hear About Us Input Select
		public static WebElement dd_hear_input_select_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-12-'][1]/a/span"));
			  return element;
		   }
		
	//I am willing to be considered for other roles.
		public static WebElement chk_willing_to_be_cosnider_for_other_roles(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='EwfApplyJobAdvnController']/div[2]/div[3]/div/div/div[27]/div/label"));
			  return element;
		   }
				
	//Apply For This Opportunity
		public static WebElement btn_apply_ft_oppur_e(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='EwfApplyJobAdvnController']/div[2]/div[3]/div/div/div[28]/button"));
			  return element;
		   }
		
	//Confirmation
		public static WebElement visi_confirmation_ico(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath("//*[@id=\"CandidateConfirmation\"]/div[1]/div/div/h2"));
			  return element;
		   }
		
	//CID ICO		
	public static WebElement visi_CID_ico(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath("//*[@id=\"Main_lblCandidateNumberDisplay\"]"));
			  return element;
		   }
	
	//Timestamp ICO
	public static WebElement visi_timestamp_ico(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath("//*[@id=\"CandidateConfirmation\"]/div[1]/div/div/div"));
		  return element;
	   }
		
		
	
}
