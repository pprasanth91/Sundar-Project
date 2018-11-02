package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PageObjectsAgency {
	
private static WebElement element = null;
	
	//Welcome User Name Visibility at the top of the page
	public static WebElement visi_agency_home(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ltlWelcome']"));
	      return element;
	   }
	
	//Search for Demands
	public static WebElement lnk_search_demands(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Search Demands"));
	      return element;
	   }
	
	//Search for Demands
	public static WebElement lnk_refer_candidate(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Refer Candidate"));
	      return element;
	   }
	
	//Solutions
	public static WebElement lnk_solutions(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Solutions"));
	      return element;
	   }
	
	//
		public static WebElement lnk_services(WebDriver driver)
		   {
		      element = driver.findElement(By.linkText("Services"));
		      return element;
		   }
	
	//Enterprise
	public static WebElement lnk_enterprise(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Enterprise"));
	      return element;
	   }
	
	//Consulting
	public static WebElement lnk_consulting(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Consulting"));
	      return element;
	   }
	
	
	//Job Search Heading Visibility
	public static WebElement visi_job_search(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText(".//*[@id='ctl00_Main_lblHead']"));
	      return element;
	   }
	
	//Job Search value
	public static WebElement lnk_job_search(WebDriver driver)
	   {
	      element = driver.findElement(By.cssSelector("#ctl00_Main_gvwSearchResultsForAgency_ctl00_lbtJobTitleAgency"));
	      return element;
	   }
	
	//Job Search Refer Button
	public static WebElement btn_refer(WebDriver driver)
	   {
	      element = driver.findElement(By.cssSelector("#ctl00_Main_gvwSearchResultsForAgency_ctl01_lbtApplyReferAgency"));
	      return element;								
	   }
	
	//IDC Resume Upload Page
	//Chose Resume CV Button
	public static WebElement btn_choose_resume_cv(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_DivControl']/div/span/label"));
	      return element;									
	   }
		
	//Upload Button
	public static WebElement btn_upload_resume_cv(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_btnSave']"));
	      return element;								
	   }
	
	//Basic Details Heading Visibility
	public static WebElement visi_basic_details(WebDriver driver)
	   {
	      element = driver.findElement(By.cssSelector(".font-black.module-heading"));
	      return element;
	   }
	
	//Basic Details Scroll to First Prefered Location
	public static WebElement first_prefered_loca(WebDriver driver)
	   {
	      element = driver.findElement(By.cssSelector("#ctl00_Main_P1>strong"));
	      return element;
	   }
	
	//First Name
	public static WebElement txt_first_name(WebDriver driver)
	   {
	      element = driver.findElement(By.cssSelector("#ctl00_Main_txtFirstName"));
	      return element;
	   }
	
	//Middle Name
	public static WebElement txt_middle_name(WebDriver driver)
	   {
	      element = driver.findElement(By.cssSelector("#ctl00_Main_txtMiddleName"));
	      return element;
	   }
	
	//Last Name
	public static WebElement txt_last_name(WebDriver driver)
	   {
	      element = driver.findElement(By.cssSelector("#ctl00_Main_txtLastName"));
	      return element;
	   }
	
	//Gender
	public static WebElement dd_gender(WebDriver driver)
	   {
	      element = driver.findElement(By.cssSelector(".btn.dropdown-toggle.selectpicker.btn-default"));
	      return element;
	   }
	
	//Gender Male
	public static WebElement dd_gender_male(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset[2]/div[4]/div/div/div/ul/li[2]/a/span[1]"));
	      return element;
	   }
	
	//Gender Female
	public static WebElement dd_gender_female(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset[2]/div[4]/div/div/div/ul/li[3]/a/span[1]"));
	      return element;
	   }
	
	//Date Of Birth
	public static WebElement btn_dob(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_spncalendar']/i"));
		return element;
	}
	
	public static WebElement btn_dob1(WebDriver driver)
	{
		element = driver.findElement(By.xpath("html/body/div[1]/div/div[1]/table/thead/tr[1]/th[2]"));
		return element;
	}
	
	public static WebElement btn_dob2(WebDriver driver)
	{
		element = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/table/thead/tr/th[2]"));
		return element;
	}
	
	public static WebElement btn_dob3(WebDriver driver)
	{
		element = driver.findElement(By.xpath("html/body/div[1]/div/div[3]/table/thead/tr/th[1]"));
		return element;
	}
	
	public static WebElement btn_dob4(WebDriver driver)
	{
		element = driver.findElement(By.xpath("html/body/div[1]/div/div[3]/table/thead/tr/th[1]"));
		return element;
	}
	
	public static WebElement btn_dob5(WebDriver driver)
	{
		element = driver.findElement(By.xpath("html/body/div[1]/div/div[3]/table/tbody/tr/td/span[6]"));
		return element;
	}
	
	public static WebElement btn_dob6(WebDriver driver)
	{
		element = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/table/tbody/tr/td/span[4]"));
		return element;
	}
	
	public static WebElement btn_dob7(WebDriver driver)
	{
		element = driver.findElement(By.xpath("html/body/div[1]/div/div[1]/table/tbody/tr[3]/td[6]"));
		return element;
	}
	
	//button to move next in calendar
	public static WebElement nextLink(WebDriver driver)
	{
		element = driver.findElement(By.xpath("html/body/div[1]/div/div[1]/table/thead/tr[1]/th[3]"));
		return element;
	}
	
	//button to click in center of calendar header
	public static WebElement midLink(WebDriver driver)
	{
		element = driver.findElement(By.xpath("html/body/div[1]/div/div[1]/table/thead/tr[1]/th[2]"));
		return element;
	}
	
	//button to move previous month in calendar
	public static WebElement previousLink(WebDriver driver)
	{
		element = driver.findElement(By.xpath("html/body/div[1]/div/div[1]/table/thead/tr[1]/th[1]"));
		return element;
	}
	
	//Email
	public static WebElement lnk_email(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtMail']"));
		return element;
	}
	
	//Previously worked at Accenture
	public static WebElement dd_prev_acc(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_dvPrevAccEmp']/div/div/button"));
		return element;
	}
	
	//Previously worked at Accenture Yes
	public static WebElement dd_prev_acc_yes(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_dvPrevAccEmp']/div/div/div/ul/li[2]/a/span[1]"));
		return element;
	}
	
	//Previously worked at Accenture No
	public static WebElement dd_prev_acc_no(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_dvPrevAccEmp']/div/div/div/ul/li[3]/a/span[1]"));
		return element;
	}
	
	//Address of Correspondence
	public static WebElement txt_add_corres(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtAddress']"));
		return element;
	}
	
	//PIN Code
	public static WebElement txt_pincode(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtPINCode']"));
		return element;
	}
	
	//Residential Tel. No Area Code
	public static WebElement txt_resi_no1(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtLandLineArea']"));
		return element;
	}
	
	//Residential Tel. No Std Code
	public static WebElement txt_resi_no2(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtLandLineStdCode']"));
		return element;
	}
	
	//Residential Tel. No
	public static WebElement txt_resi_no3(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtLandLine']"));
		return element;
	}
	
	//Mobile(Don't prefix '0')
	public static WebElement txt_mobile_no(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtMobile']"));
		return element;//*[@id=\"ctl00_Main_txtmobileNo\"]
	}
	
	//Mobile number
	public static WebElement txt_mobile_no_after(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id=\"ctl00_Main_txtmobileNo\"]"));
		return element;
	}
	
	//Next Button
	public static WebElement btn_next(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_imgNext']"));
		return element;
	}
	
	
	//Advance Details Page
	
	//Advance Details page visi
	public static WebElement visi_advance(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/h2"));
		return element;
	}
	
	//ScrollIntoView Till Residential Tele Number in Advance Details Page
	public static WebElement scroll_resi(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtResTelNo']"));
		return element;
	}
	
	//Country
	public static WebElement dd_country(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[13]/div/div/button"));
		return element;								
	}
	
	public static WebElement dd_country_swf(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id=\"block-accenturecareers\"]/div/div/div/div/section/fieldset[2]/div[2]/div/div/button"));
		return element;								
	}
	
	public static WebElement dd_country_bpo(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[14]/div/div/button"));
		return element;								
	}
	
	//Country List
	public static WebElement dd_country_list(WebDriver driver)
	{
		element = (WebElement) driver.findElements(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[13]/div/div/div/ul/li"));
		return element;
	}
	
	//State
	public static WebElement dd_state(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[14]/div/div/button"));
		return element;							
	}
	
	public static WebElement dd_state_swf(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id=\"block-accenturecareers\"]/div/div/div/div/section/fieldset[2]/div[3]/div/div[1]/button"));
		return element;							
	}
	
	public static WebElement dd_state_bpo(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[15]/div/div/button"));
		return element;							
	}
	
	//State List
	public static WebElement dd_state_list(WebDriver driver)
	{
		element = (WebElement) driver.findElements(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[14]/div/div/div/ul/li"));
		return element;											
	}
	
	public static WebElement dd_state_list_swf(WebDriver driver)
	{
		element = (WebElement) driver.findElements(By.xpath("//*[@id=\"block-accenturecareers\"]/div/div/div/div/section/fieldset[2]/div[3]/div/div[1]/div/ul/li"));
		return element;											
	}
	
	//City
	public static WebElement dd_city(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[16]/div/div/button"));
		return element;
	}
	
	public static WebElement dd_city_swf(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id=\"block-accenturecareers\"]/div/div/div/div/section/fieldset[2]/div[4]/div/div[1]/button/span[1]"));
		return element;
	}
	
	public static WebElement dd_city_bpo(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[17]/div/div/button"));
		return element;
	}
	
	//City List
	public static WebElement dd_city_list(WebDriver driver)
	{
		element =  (WebElement) driver.findElements(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[16]/div/div/div/ul/li"));
		return element;
	}
	
	//Nationality
	public static WebElement dd_nationality(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[18]/div/div/button"));
		return element;
	}
	
	public static WebElement dd_nationality_swf(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id=\"block-accenturecareers\"]/div/div/div/div/section/fieldset[2]/div[5]/div/div/button/span[1]"));
		return element;
	}
	
	public static WebElement dd_nationality_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[19]/div/div/button"));
		return element;
	}
	
	//Nationality List
	public static WebElement dd_nationality_list(WebDriver driver)
	{
		element =  (WebElement) driver.findElements(By.xpath("//*[@id=\"block-accenturecareers\"]/div/div/div/div/section/fieldset[2]/div[5]/div/div/div/ul/li"));
		return element;
	}
	
	//Citizenship
	public static WebElement dd_citizenship(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[19]/div/div/button"));
		return element;
	}
	
	public static WebElement dd_citizenship_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[20]/div/div/button"));
		return element;
	}
	
	//Citizenship List
	public static WebElement dd_citizenship_list(WebDriver driver)
	{
		element =  (WebElement) driver.findElements(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[19]/div/div/div/ul/li"));
		return element;
	}
	
	//Fact Sheet Details: BPO
	//Notice Period
	public static WebElement dd_notice_period_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_FactSheetDetails']/div/div/div/button"));
		return element;										
	}
	
	//Notice Period List BPO
	public static WebElement dd_notice_period__list_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElements(By.xpath(".//*[@id='ctl00_Main_FactSheetDetails']/div/div/div/div/ul/li"));
		return element;
	}

	//Qualification BPO
	public static WebElement dd_qualification_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[22]/div/div/button"));
		return element;
	}
	
	//Qualification List BPO
	public static WebElement dd_qualification_list_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElements(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[22]/div/div/div/ul/li"));
		return element;
	}
	
	// Year of Passing BPO
	public static WebElement txt_year_of_passing_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtYearOfPassing']"));
		return element;
	}
	
	//Passport No BPO
	public static WebElement txt_passport_number_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtPassportNo']"));
		return element;
	}
	
	//Total Experience BPO
	public static WebElement dd_total_exp_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[26]/div/div/button"));
		return element;
	}
	
	//Total Experience Input BPO
	public static WebElement dd_total_exp_list_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElements(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[26]/div/div/div/ul/li"));
		return element;
	}
	
	//BPO Experience (in years) 
	public static WebElement txt_bpo_exp_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtBPOExp']"));
		return element;
	}
	
	//Specialization BPO
	public static WebElement dd_specialization_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[28]/div/div/button"));
		return element;
	}
	
	//Specialization List BPO
	public static WebElement dd_specialization_list_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElements(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[28]/div/div/div/ul/li"));
		return element;
	}
	
	//College BPO
	public static WebElement dd_college_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtcoll']"));
		return element;
	}
	
	//College Input BPO
	public static WebElement dd_college_input_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElements(By.xpath(".//*[@id='ctl00_Main_txtcoll']"));
		return element;
	}
	
	//College Input Select BPO
	public static WebElement dd_college_input_select_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_dvCollege']/div[1]"));
		return element;
	}
	
	//Willing to be considered for other Talent Segment
	public static WebElement chk_other_talent_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_chkWillAddTS']"));
		return element;
	}
	
	//Resume Choose File
	public static WebElement btn_resume_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[32]/div/div/span/label"));
		return element;
	}
	
	//Marital Status
	public static WebElement dd_marital_status(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_divMS']/div/div/button"));
		return element;											
	}
	
	public static WebElement dd_marital_status_swf(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id=\"ctl00_Main_divMS\"]/div/div/button/span[1]"));
		return element;											
	}
	
	public static WebElement dd_marital_status_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id=\"ctl00_Main_divMS\"]/div/div/button/span[1]"));
		return element;											
	}
	
	
	//Marital Status List
	public static WebElement dd_marital_status_list(WebDriver driver)
	{
		element =  (WebElement) driver.findElements(By.xpath("//*[@id=\"ctl00_Main_divMS\"]/div/div/div/ul/li"));
		return element;
	}
	
	//Face Sheet Details
	
	//Face Sheet Details Visi
	public static WebElement visi_face_sheet(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_divFactSheetDetails_block']/p/strong"));
		return element;
	}
	
	//Relevant Experience(yrs.)
	public static WebElement txt_relevant_exp(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtRelevantExp']"));
		return element;
	}
	
	public static WebElement txt_relevant_exp_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtBPOExp']"));
		return element;
	}
	
	//Current Annual CTC(Fixed)
	public static WebElement txt_ctc(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtCurrentAnnualCTC']"));
		return element;												   
	}
	
	public static WebElement txt_ctc_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtCurrentCTC']"));
		return element;												   
	}
	
	public static WebElement dd_specialization_bpo1(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[34]/div/div/button"));
		return element;												   
	}
	
	//Expected Annual CTC(Fixed)
	public static WebElement txt_ctc_expected(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtExpectedAnnualCTC']"));
		return element;										
	}
	
	public static WebElement txt_ctc_expected_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtExpectedCTC']"));
		return element;										
	}
			
	//Notice Period
	public static WebElement dd_notice_period(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_divFactSheetDetails_block']/div[4]/div/div/button"));
		return element;										 
	}
	
	public static WebElement dd_notice_period_bpo1(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id='ctl00_Main_FactSheetDetails']/div/div/div/button"));
		return element;										 
	}
	
	//Notice Period List
	public static WebElement dd_notice_period_list(WebDriver driver)
	{
		element =  (WebElement) driver.findElements(By.xpath(".//*[@id='ctl00_Main_divFactSheetDetails_block']/div[4]/div/div/div/ul/li"));
		return element;
	}
	
	//Name of the Agency POC
	public static WebElement txt_name_poc(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtAgencyPOC']"));
		return element;
	}
	
	//Referrer Information:
	//Channel Scroll
	public static WebElement scroll_channel(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_divFactSheetDetails_block']/div[7]/div/div"));
		return element;
	}
	
	public static WebElement scroll_channel_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id='ctl00_Main_RefferInfo_block']/div[1]/div/div"));
		return element;
	}
	
	//SR Number
	public static WebElement txt_SR_num(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtSrNumber']"));
		return element;
	}
	
	//Qualification and Experience
	
	//Qualification
	public static WebElement dd_qualification_bpo1(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[23]/div/div/button"));
		return element;
	}
	
	//Year of Passing
	public static WebElement txt_year_of_passing_bpo1(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id='ctl00_Main_txtYearOfPassing']"));
		return element;
	}
	
	//Total Experience Scroll
	public static WebElement scroll_total_exp(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_lblTotalExp']"));
		return element;
	}
	
	//Total Experience
	public static WebElement dd_total_exp(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset[2]/div[9]/div/div"));
		return element;
	}
	
	//Highest Degree
	public static WebElement dd_high_deg(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset[2]/div[10]/div/div/button"));
		return element;										
	}
	
	//Highest Degree List
	public static WebElement dd_high_deg_list(WebDriver driver)
	{
		element =  (WebElement) driver.findElements(By.xpath("//*[@id=\"block-accenturecareers\"]/div/div/div/div/section/fieldset[2]/div[10]/div/div/div/ul/li"));
		return element;
	}
	
	//Highest Education (%)
	public static WebElement txt_highest_edu(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtGraduationPrecent']"));
		return element;
	}

	//Highest Degree(Subject)
	public static WebElement dd_highest_degree(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset[2]/div[14]/div/button"));
		return element;										
	}
	
	//Highest Degree(Subject) List
	public static WebElement dd_highest_degree_list(WebDriver driver)
	{
		element =  (WebElement) driver.findElements(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset[2]/div[14]/div/div/ul/li"));
		return element;
	}
	
	//PAN
	public static WebElement dd_pan(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_divPANYN']/div/div/div/button"));
		return element;										 
	}
	
	public static WebElement dd_pan_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id='ctl00_Main_divPan']/div/div/div/button"));
		return element;										 
	}
	
	public static WebElement txt_pan_no_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id='ctl00_Main_txtPAN']"));
		return element;										 
	}
		   	
	//PAN List
	public static WebElement dd_pan_list(WebDriver driver)
	{
		element =  (WebElement) driver.findElements(By.xpath(".//*[@id='ctl00_Main_divPANYN']/div/div/div/div/ul/li"));
		return element;										  
	}
	
	//PAN No.
	public static WebElement dd_pan_no(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.cssSelector("#ctl00_Main_txtPanNo"));
		return element;
	}
	
	//Passport
	public static WebElement dd_passport(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_divpanpass']/div[1]/div/div/button"));
		return element;										
	}
	
	public static WebElement txt_passport_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id='ctl00_Main_txtPassportNo']"));
		return element;										
	}
	
	//Passport List
	public static WebElement dd_passport_list(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_divpanpass']/div[1]/div/div/div/ul/li"));
		return element;
	}
	
	//Passport No
	public static WebElement txt_passport_no(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.cssSelector("#ctl00_Main_txtPassportNo"));
		return element;
	}
	
	//Aadhar Card Dropdown
	public static WebElement dd_aadhar_swf(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.cssSelector("#ctl00_Main_divpanpass > div:nth-child(3) > div > div > button"));
		return element;
	}
	
	public static WebElement dd_aadhar_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.cssSelector("#block-accenturecareers > div > div > div > div > section > fieldset > div:nth-child(32) > div > div > button"));
		return element;
	}
	
	//Aadhar Number
	public static WebElement txt_aadhar_num_swf(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.name("ctl00$Main$txtAadhaarNo"));
		return element;
	}
	
	public static WebElement txt_aadhar_num_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.name("ctl00$Main$txtAadhaarNo"));
		return element;
	}
	
	//Aadhar Number Name
	public static WebElement txt_aadhar_name_swf(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.name("ctl00$Main$txtAadhaarName"));
		return element;
	}
	
	public static WebElement txt_aadhar_name_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.name("ctl00$Main$txtAadhaarName"));
		return element;
	}
	
	//Total Experience BPO
	public static WebElement dd_total_exp_bpo1(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[32]/div/div/button"));
		return element;
	}
	
	//National Skill Registry IT PIN
	public static WebElement txt_NSR(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.cssSelector("#ctl00_Main_txtNasscomPinID"));
		return element;
	}
	
	//National Skill Registry IT PIN Hyperlink
	public static WebElement txt_NSR_hyperlink(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id=\"ctl00_Main_divpanpass\"]/div[3]/div/p/a"));
		return element;
	}
	
	//College
	public static WebElement txt_college(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtColl']"));
		return element;													
	}
	
	public static WebElement txt_college_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtcoll']"));
		return element;
	}
	
	//College Input Select
	public static WebElement txt_college_input_select(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_dvCollege']/div"));
		return element;
	}
	
	//How many organizations has the candidate worked for?
	public static WebElement dd_no_org(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_divOrg']/div[1]/div/div/button"));
		return element;											
	}
	
	//How many organizations has the candidate worked for? List
	public static WebElement dd_no_org_list(WebDriver driver)
	{
		element =  (WebElement) driver.findElements(By.xpath(".//*[@id='ctl00_Main_divOrg']/div[1]/div/div/div/ul/li"));
		return element;
	}
	
	//Current Organization
	public static WebElement dd_current_org(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtCurrOrg']"));
		return element;											
	}
	
	//Current Organization List
	public static WebElement dd_current_org_first(WebDriver driver)
	{
		element =  (WebElement) driver.findElements(By.xpath(".//*[@id='ctl00_Main_dvCurrOrg']/div[1]"));
		return element;
	}
	
	//If others,please specify Current Organization name
	public static WebElement txt_current_org_name(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtOtherCurrentOrg']"));
		return element;
	}
	
	//Speciality
	public static WebElement visi_speciality(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_divcapability']/div[2]/label"));
		return element;
	}
	
	//Industry alignment
	public static WebElement dd_ind_align(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_divcapability']/div[3]/div/div/button"));
		return element;
	}
	
	//Industry alignment List
	public static WebElement dd_ind_align_list(WebDriver driver)
	{
		element =  (WebElement) driver.findElements(By.xpath(".//*[@id='ctl00_Main_divcapability']/div[3]/div/div/div/ul/li"));
		return element;
	}
	
	//Comments
	public static WebElement txt_comments(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtComments']"));
		return element;
	}
	
	//Primary Skill
	public static WebElement dd_primary_skill(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset[2]/div[23]/div[1]/div/button"));
		return element;										 
	}
	
	//Primary Skill Select First Value
	public static WebElement dd_primary_skill_first(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset[2]/div[23]/div[1]/div/div/ul/li/a"));
		return element;										 
	}
	
	//Primary Skill List
	public static WebElement dd_primary_skill_list(WebDriver driver)
	{
		element =  (WebElement) driver.findElements(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset[2]/div[23]/div/div/div/ul/li"));
		return element;										  
	}
	
	//Last year put in practice
	public static WebElement dd_last_year_practise_primary_skill(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset[2]/div[23]/div[2]/div/button"));
		return element;										 
	}
	
	//Optional Skills 1
	public static WebElement dd_opt_skills1(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtOptionalSkill1']"));
		return element;
	}
	
	//Optional Skills 1 Select First Value
	public static WebElement dd_opt_skills1_first(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_dvOptionalSkill1']/div[1]"));
		return element;
	}
	
	//Optional Skills 1 List 
	public static WebElement dd_opt_skills1_list(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_divOptionalSkills']/div[1]/div[1]/div/div/div/ul/li"));
		return element;
	}
	
	//Experience (months) Optional Skill1
	public static WebElement txt_exp_opt_skills1(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtExp1']"));
		return element;
	}
	
	//Optional Skills 1 Last used Dropdown
	public static WebElement dd_last_used_opt_skills1(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_ddlOptionalLastUsed1']"));
		return element;
	}
	
	//Optional Skills 1 Last used First Option
	public static WebElement dd_last_used_first_opt_skills1(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_ddlOptionalLastUsed1']/option[2]"));
		return element;
	}
	
	//Optional Skills 2
	public static WebElement dd_opt_skills2(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_divOptionalSkills']/div[1]/div[2]/div/div/button"));
		return element;
	}
	
	public static WebElement dd_opt_skills2_first(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id=\"ctl00_Main_divOptionalSkills\"]/div[1]/div[2]/div/div/div/ul/li[4]/a/span[1]"));
		return element;										 
	}
	
	//Optional Skills 2 List 
	public static WebElement dd_opt_skills2_list(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_divOptionalSkills']/div[1]/div[2]/div/div/div/ul/li"));
		return element;
	}
	
	//Optional Skills 3
	public static WebElement dd_opt_skills3(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_divOptionalSkills']/div[1]/div[3]/div/div/button"));
		return element;
	}
	
	//Optional Skills 3 Select First Value
	public static WebElement dd_opt_skills3_first(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id=\"ctl00_Main_divOptionalSkills\"]/div[1]/div[3]/div/div/div/ul/li[6]/a/span[1]"));
		return element;
	}
	
	//Optional Skills 3 List 
	public static WebElement dd_opt_skills3_list(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_divOptionalSkills']/div[1]/div[3]/div/div/div/ul/li"));
		return element;
	}
	
	//Optional Skills 4
	public static WebElement dd_opt_skills4(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_divOptionalSkills']/div[1]/div[4]/div/div/button"));
		return element;
	}
	
	//Optional Skills 4 First Value 
	public static WebElement dd_opt_skills4_first(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id=\"ctl00_Main_divOptionalSkills\"]/div[1]/div[4]/div/div/div/ul/li[8]/a/span[1]"));
		return element;
	}
	//Optional Skills 4 List 
	public static WebElement dd_opt_skills4_list(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_divOptionalSkills']/div[1]/div[4]/div/div/div/ul/li"));
		return element;
	}
		
	//Willing to be considered for other Talent Segment Checkbox
	public static WebElement chk_other_talent_seg(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_chkWillAddTS']"));
		return element;
	}
	
	//We agree that we have spoken to the Candidate firstname lastname and confirm that the details provided on the IJP are accurate Checkbox
	public static WebElement chk_agree(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_chkAgencyAgree']"));
		return element;
	}
	
	//I am willing to be considered for other roles Checkbox
	public static WebElement chk_other_roles(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.cssSelector("#ctl00_Main_chkWillAddTS"));
		return element;
	}
	
	public static WebElement chk_other_roles_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.cssSelector("#ctl00_Main_chkWillAddTS"));
		return element;
	}
	
	//We agree that we have spoken to the Candidate adshfgjh shfdfgj and confirm that the details
	//provided here accurate Checkbox
	public static WebElement chk_accurate_details(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.cssSelector("#ctl00_Main_chkAgencyAgree"));
		return element;
	}
	
	//Resume Choose File
	public static WebElement btn_choose(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.cssSelector(".btn.browsebtn.btn-primary.btn-cta"));
		return element;
	}
	
	//Save Button
	public static WebElement btn_save(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.cssSelector("#ctl00_Main_ibtnSave"));
		return element;
	}
	
	//Save Button BPO
	public static WebElement btn_save_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.cssSelector("#ctl00_Main_btnSave"));
		return element;												
	}
	
	//Statement of Compliance
	public static WebElement btn_yes_statement_complaince_bpo(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.cssSelector("#ctl00_Main_btnOK"));
		return element;
	}
	
	//Confirmation Message	
	public static WebElement visi_confirmation_candidate(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//[@class='font-black module-heading' and text()='Confirmation']"));
		return element;
	}
	
	//Confirmation MessageBPO
		public static WebElement visi_confirmation_candidate_bpo(WebDriver driver)
		{
			element =  (WebElement) driver.findElement(By.xpath("//*[@id=\"block-accenturecareers\"]/div/div/div/div/section/h2"));
			return element;
		}
		
		//Confirmation MessageICF
				public static WebElement visi_confirmation_candidate_icf(WebDriver driver)
				{
					element =  (WebElement) driver.findElement(By.xpath("//*[@id='block-accenturecareers']/div/div/div/div/section/h2"));
					return element;
				}
	
	//CID Display
	public static WebElement visi_cid_display(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.id("ctl00_Main_lblCandidateNumberDisplay"));
		return element;
	}
	
	//CID Display BPO
		public static WebElement visi_cid_display_bpo(WebDriver driver)
		{
			element =  (WebElement) driver.findElement(By.id("ctl00_Main_lblCandidateNumberDisplay"));
			return element;
		}		
		
		//CID Display ICF
				public static WebElement visi_cid_display_icf(WebDriver driver)
				{
					element =  (WebElement) driver.findElement(By.id("ctl00_Main_lblCandidateNumberDisplay"));
					return element;
				}
	
	//Upload Documents
	
	//Upload Documents Hyperlink
	public static WebElement lnk_upload_docs(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.linkText("Upload Documents"));
		return element;
	}
	
	//Upload Documents Heading Visi
	public static WebElement visi_upload_documents(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_divdocupload']/section/h2"));
		return element;
	}
	
	//CID Dropdown
	public static WebElement dd_cid(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_divCid']/div/button"));
		return element;
	}
		
	//CID Dropdown List
	public static WebElement dd_cid_list(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_divCid']/div/div/ul/li"));
		return element;
	}
		
	//Document Type
	public static WebElement dd_doc_type(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_divdocupload']/section/fieldset/div[2]/div/div/button"));
		return element;
	}
	
	//Select Document Button
	public static WebElement btn_select_doc(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_divdocupload']/section/fieldset/div[3]/div/div/span/label"));
		return element;
	}
	
	//Comments
	public static WebElement txt_comments_doc(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtComments']"));
		return element;
	}
	
	//Save Button
	public static WebElement btn_save_doc(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_ibtnSave']"));
		return element;
	}
	
	//Uploaded successfully Message Visibility
	public static WebElement visi_doc_upload_success_message(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_lblmessage']"));
		return element;
	}
	
	//Verification after successful job apply
	public static WebElement visi_doc_list(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_divList']/h2"));
		return element;
	}
	
	//Document Upload Status
	public static WebElement chc_doc_upload_status(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_chkDocUploadStatus']"));
		return element;
	}
	
	
	
	//*********************************************   EWF/ICO JOB APPLY   *********************************************************************************
	
	//Job Title Visi
	public static WebElement visi_job_title(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.cssSelector("#ctl00_Main_lblJobName"));
		return element;
	}
	
	//Gender Scroll
	public static WebElement scroll_gender_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_lblGender']"));
		return element;
	}
	
	//Marital Status
	public static WebElement dd_marital_status_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_divMaritalStatus']/div/div/div/button"));
		return element;											
	}
	
	//Marital Status List
	public static WebElement dd_marital_status_list_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_divMaritalStatus']/div/div/div/div/ul/li"));
		return element;											
	}
	
	//Email ID
	public static WebElement scroll_email_id(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtEmail']"));
		return element;											
	}
	
	//Alternate Email ID
	public static WebElement txt_alt_email_id(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtAltEmail']"));
		return element;											
	}
	
	//Nationality
	public static WebElement dd_nationality_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[16]/div/div/button"));
		return element;											
	}
	
	//Nationality List
	public static WebElement dd_nationality_list_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[16]/div/div/div/ul/li"));
		return element;											
	}
	
	//Previously worked at Accenture Scroll
	public static WebElement scroll_prev_acc(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_Label2']"));
		return element;											
	}
	
	//County
	public static WebElement dd_country_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[17]/div/div/button"));
		return element;											
	}
	
	//Country List
	public static WebElement dd_country_list_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[17]/div/div/div/ul/li"));
		return element;											
	}
	
	//Citizenship
	public static WebElement dd_citizenship_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[17]/div/div/button/span[1]"));
		return element;											
	}
	
	//Citizenship List
	public static WebElement dd_citizenship_list_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[17]/div/div/div/ul/li"));
		return element;											
	}
	//State
	public static WebElement dd_state_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//button[@title='Select State']"));
		return element;											
	}
	
	//State List
	public static WebElement dd_state_list_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[18]/div/div/div/ul/li"));
		return element;											
	}
	
	//City
	public static WebElement dd_city_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[20]/div/div/button"));
		return element;											
	}
	
	//City List
	public static WebElement dd_city_list_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElements(By.xpath("//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[20]/div/div/div/ul/li"));
		return element;											
	}
	
	//Total Experience
	public static WebElement dd_total_exp_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[21]/div/div/button/span[1]"));
		return element;											
	}

	//Total Experience List
	public static WebElement dd_total_exp_list_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[21]/div/div/div/ul/li"));
		return element;											
	}
	
	//Relevant Experience in Months
	public static WebElement txt_rel_exp_months_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtITExp']"));
		return element;											
	}
	
	//Notice Period (days)*
		public static WebElement dd_notice_period_ent(WebDriver driver)
		{
			element =  (WebElement) driver.findElement(By.xpath("//*[@id=\"ctl00_Main_divOthrDA\"]/div[2]/div/div/button/span[1]"));
			return element;											
		}
		//*[@id="ctl00_Main_divOthrDA"]/div[2]/div/div/div/ul/li[2]/a/span[1]
		
				
	//Current Annual Salary
		public static WebElement txt_current_salary_ent(WebDriver driver)
		{
			element =  (WebElement) driver.findElement(By.name("ctl00$Main$txtCurrentCTC"));
			return element;											
		}
		
	//Expected Annual salary
		public static WebElement txt_expected_salary_ent(WebDriver driver)
		{
			element =  (WebElement) driver.findElement(By.name("ctl00$Main$txtExpectedCTC"));
			return element;											
		}
		
	//Management Level
	public static WebElement dd_manage_level_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id='ctl00_Main_divOthrDA']/div[5]/div/div/button"));
		return element;											
	}
	
	//Management Level List
	public static WebElement dd_manage_level_list_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_divOthrDA']/div[2]/div/div/div/ul/li"));
		return element;											
	}
	
	//Current Organization Search Image
	public static WebElement img_search_current_org_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_hypCurrentOrganization']/img"));
		return element;											
	}
	
	//Current Organization Clear 
	public static WebElement img_clear_current_org_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_hypclearCurrentorg']/img"));
		return element;											
	}
		
	//Highest Education Search Image
	public static WebElement img_search_high_edu_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_HypHighestEducation']/img"));
		return element;											
	}

	//Highest Education Clear 
	public static WebElement img_clear_high_edu_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_HypClearEducation']/img"));
		return element;											
	}
	
	//Search Organization
	
	//Enter your search Criteria here
	public static WebElement txt_search_box(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='txtSearch']"));
		return element;											
	}
	
	//Search Button
	public static WebElement btn_search(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='btnSearch']"));
		return element;											
	}
	
	//Clear Button
	public static WebElement btn_clear(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='btnClear']"));
		return element;											
	}
	
	//Close Button
	public static WebElement btn_close(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='btnClose']"));
		return element;											
	}
	
	//Search Results
	public static WebElement lnk_search_results(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='dtgresults_ctl02_lnkOrganization' and text()='Synechron Technology']"));
		return element;											
	}
	
	//Search Education
	
	//Enter your search Criteria here Search Education 
	public static WebElement txt_search_box_high(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='txtSearch']"));
		return element;											
	}
	
	//Search Button Search Education
	public static WebElement btn_search_high(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='btnSearch']"));
		return element;											
	}
		
	//Clear Button Search Education
	public static WebElement btn_clear_high(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='btnClear']"));
		return element;											
	}
		
	//Close Button Search Education
	public static WebElement btn_close_high(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='btnClose']"));
		return element;											
	}
		
	//Search Results Search Education B.E (Electronics & Communication)
	public static WebElement lnk_search_results_high(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='dtgresults_ctl02_lnkEducationName' and text()='B.E (Electronics & Communication)']"));
		return element;											
	}
	
	//PAN Number	
	public static WebElement dd_pan_num(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.cssSelector("#block-accenturecareers > div > div > div > div.form-horizontal.acn-form.bv-form > section > fieldset > div:nth-child(31) > div > div > button"));
		return element;											
	}
	
	//PAN Number Yes
	public static WebElement dd_pan_num_Yes(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id='block-accenturecareers']/div/div/div/div[1]/section/fieldset/div[28]/div/div/div/ul/li[2]/a/span[1]"));
		return element;											
	}
	
	public static WebElement txt_pan_num(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtPanNo']"));
		return element;											
	}
	
	//Passport
	public static WebElement dd_passport_num(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.cssSelector("#block-accenturecareers > div > div > div > div.form-horizontal.acn-form.bv-form > section > fieldset > div:nth-child(33) > div > div > button > span.filter-option.pull-left"));
		return element;											
	}
	
	public static WebElement txt_passport_num(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.cssSelector("#ctl00_Main_txtPassportNo"));
		return element;											
	}
	
	//Is Aadhaar card available Dropdown
	public static WebElement dd_aadhar_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id=\"block-accenturecareers\"]/div/div/div/div[1]/section/fieldset/div[32]/div/div/button/span[1]"));
		return element;											
	}
	
	//Aadhaar Number TextBox
	public static WebElement txt_aadhar_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id=\"ctl00_Main_txtAadhaarNo\"]"));
		return element;											
	}
	
	//Name as on Aadhaar
	public static WebElement txt_name_aadhar_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id=\"ctl00_Main_txtAadhaarName\"]"));
		return element;											
	}
	
	//Aadhaar enrollment number
	public static WebElement txt_aadhar_enrollment_num_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id=\"ctl00_Main_txtEnrollNo\"]"));
		return element;											
	}
	
	//Current Location
	public static WebElement dd_current_loca(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//button[@title='Select Current Location']"));
		return element;											
	}
	
	//Current Location List
	public static WebElement dd_current_loca_list(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//button[@title='Select Current Location']"));
		return element;											
	}
	
	//Upload resume
	
	//Channel Scroll
	public static WebElement scroll_channel_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_RefferInfo_block']/div[3]/div/div"));
		return element;											
	}
	
	//Comments
	public static WebElement txt_comments_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtComments']"));
		return element;											
	}
	
	//Willing to be considered for other Talent Segments Check box
	public static WebElement chk_other_talent_seg_ent(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.xpath("//*[@id=\"ctl00_Main_chkWillAddTS\"]"));
		return element;											
	}
	
	//Resume Button
	public static WebElement btn_resume(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.cssSelector(".btn.browsebtn.btn-primary.btn-cta"));
		return element;											
	}

	//Submit Button
	public static WebElement btn_submit(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.cssSelector("#ctl00_Main_btnSave"));
		return element;											
	}
	
	
	//***************************************CHECK STATUS*************************************************************//
	
	//Check Status Hyper link
	public static WebElement lnk_chk_status(WebDriver driver)
	{
		element =  (WebElement) driver.findElement(By.linkText("Check Status"));
		return element;											
	}
	
	//Solutions Check Status Hyper link
	public static WebElement lnk_solutions_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Solutions"));
	      return element;
	   }
	
	//Services Check Status Hyper link
	public static WebElement lnk_services_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Services"));
	      return element;
	   }
	
	//Enterprise Check Status Hyper link
	public static WebElement lnk_enterprise_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Enterprise"));
	      return element;
	   }
	
	//Consulting Check Status Hyper link
	public static WebElement lnk_consulting_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Consulting"));
	      return element;
	   }
	
	//View Export Results Check Status Hyper link
	public static WebElement lnk_view_export_results_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("View Export Results"));
	      return element;
	   }
	
	/*** SOLUTIONS ******
	 */
	
	//Solutions Search Candidate Status Visibility
	public static WebElement visi_sol_srch_cand_stat(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_lblSearchAddRoles']"));
	      return element;
	   }
	
	//First Name Text Box
	public static WebElement txt_fname_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtBoxFName']"));
	      return element;
	   }
	
	//Last Name Text Box
	public static WebElement txt_lname_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtBoxLName']"));
	      return element;
	   }
	
	//Candidate Email ID Text Box
	public static WebElement txt_cand_emailid_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtBoxCEmailID']"));
	      return element;
	   }
	
	//Candidate ID Text Box
	public static WebElement txt_cid_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtBoxCID']"));
	      return element;
	   }
	
	//Referred From Calendar Pick Up
	public static WebElement btn_cal_ref_frm_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtSentAfter']"));
	      return element;
	   }
	
	//Referred To Calendar Pick Up
	public static WebElement btn_cal_ref_to_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtSentBefore']"));
	      return element;
	   }
	
	//Workforce Dropdown
	public static WebElement dd_workforce_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_ddlWorkforce']"));
	      return element;
	   }
	
	//Status Dropdown
	public static WebElement dd_status_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_ddlStatus']"));
	      return element;
	   }
	
	//Specialty TextBox
	public static WebElement txt_speciality_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtSpecialty']"));
	      return element;
	   }
	
	//Specialty Search Button
	public static WebElement img_search_speciality_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_hypSpecialty']/img"));
	      return element;
	   }
	
	//Specialty Clear Result Button
	public static WebElement img_clear_speciality_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_hypSpecialty']/img"));
	      return element;
	   }
	
	
	//New Popup Page Opens Speciality Search Button
	//Skill Search
	//Enter Search Criteria
	public static WebElement txt_search_criteria_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='txtSearchCriteria']"));
	      return element;
	   }
	
	//Skill Levels Check boxes
	
	//Skill Type Check box
	public static WebElement chk_skill_type_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='chkSkillType']"));
	      return element;
	   }
	
	//Skill Category Check Box
	public static WebElement chk_skill_cate_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='chkSkillGroup']"));
	      return element;
	   }
	
	//Capability Check Box
	public static WebElement chk_capa_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='chkCapability']"));
	      return element;
	   }
	
	//Specialty Check Box
	public static WebElement chk_speciality_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='chkSpeciality']"));
	      return element;
	   }
	
	//Skill Check Box
	public static WebElement chk_skill_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='chkSubskills']"));
	      return element;
	   }
	
	//Search Button in Skill Search Popup Page
	public static WebElement btn_search_skill_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='btnSearch']"));
	      return element;
	   }
	
	//Clear Button in Skill Search Popup Page
	public static WebElement btn_clear_skill_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='btnClear']"));
	      return element;
	   }
	
	//Search Results - Speciality Hyperlink
	public static WebElement lnk_srch_rslt_CS_spec(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='dtgResult']/tbody/tr[3]/td[4]/a"));
	      return element;
	   }
	
	//Search Results - Skill Hyperlink
	public static WebElement lnk_srch_rslt_CS_skill(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='dtgResult']/tbody/tr[3]/td[5]/a"));
	      return element;
	   }
		
	
	//Skill TextBox
	public static WebElement txt_skill_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtskill']"));
	      return element;
	   }
	
	//Skill Search Button Image
	public static WebElement img_search_skill_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_hypSkill']/img"));
	      return element;
	   }
	
	//Skill Clear Button Image
	public static WebElement img_clear_skill_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_hypClearSkill']/img"));
	      return element;
	   }
	
	//Location Dropdown
	public static WebElement dd_location_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_ddlLocation']"));
	      return element;
	   }
	
	//Location Dropdown List
	public static WebElement dd_location_list_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_ddlLocation']/option"));
	      return element;
	   }
	
	//Mobile No TextBox
	public static WebElement txt_mobile_no_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtMobileNo']"));
	      return element;
	   }
	
	//Search Button in Search Candidate Status
	public static WebElement btn_srch_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_imgbtnSearch']"));
	      return element;
	   }
	
	//SEARCH RESULTS
	
	//Search Results Visibility
	public static WebElement visi_search_results_CS(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_hide_show_results']/div[1]"));
	      return element;
	   }
	
	//Candidate ID Hyperlink
	public static WebElement lnk_cand_id_results(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='ctl00_Main_gvSearchResults_ctl02_LblCID']"));
	      return element;
	   }
	
	//Resume Upload Hyperlink
	public static WebElement lnk_resume_upload_results(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Upload Resume"));
	      return element;
	   }
	
	//Interview Status Hyperlink
	public static WebElement lnk_int_status_results(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("View Interview Status"));
	      return element;
	   }
	
	//Interview Status Heading Visibility
	public static WebElement visi_int_status_results(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='lblHeading']"));
	      return element;
	   }
	
	//Close button for Popup Page opening on clicking Interview Status Hyperlink
	public static WebElement btn_close_CS_Int_stat(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='imgCloseBtn']"));
	      return element;
	   }
	
	//
	//Send To Queue Button / Export Button
	public static WebElement btn_export_results(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_imgBtnExport']"));
	      return element;
	   }
	
	//Popup on clicking the CID Hyperlink
	
	//Land Line First Text Box ISD
	public static WebElement txt_ISD_CS_CID(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='txtISD']"));
	      return element;
	   }
	
	//Land Line Second Text Box STD
	public static WebElement txt_STD_CS_CID(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='txtSTD']"));
	      return element;
	   }
	
	//Land Line Third Text Box STD
	public static WebElement txt_Lnumber_CS_CID(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='txtNumber']"));
	      return element;
	   }
	
	//Mobile Number Text Box
	public static WebElement txt_mobileno_CS_CID(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='txtMobileNo']"));
	      return element;
	   }
	
	//Existing Comments Text Box
	public static WebElement txt_existing_comments_CS_CID(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='txtComments']"));
	      return element;
	   }
	
	//New Comments Text Box
	public static WebElement txt_new_comments_CS_CID(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='txtNewComments']"));
	      return element;
	   }
	
	//Submit Button
	public static WebElement btn_submit_CS_CID(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='btnUpdate']"));
	      return element;
	   }
	
	//Close Button
	public static WebElement btn_close_CS_CID(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='btnclose']"));
	      return element;
	   }
	
	//Popup on clicking the Send to Queue Button/ Export
	//Please enter Export Password Text Box
	public static WebElement txt_export_pwd_results_popup(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtExportpwd']"));
	      return element;
	   }
	
	//Ok Button
	public static WebElement btn_ok_results_popup(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_btnOK']"));
	      return element;
	   }
	
	//Cancel Button
	public static WebElement btn_cancel_results_popup(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_btnCancel']"));
	      return element;
	   }

	//Enterprise Entity
	//Additional Elements
	
	//Position Number
	public static WebElement txt_position_num(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtposition']"));
	      return element;
	   }
	
	
	//Change Password Tab
	
	//Change Password Hyperlink
	public static WebElement lnk_change_pwd(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Change Password"));
	      return element;
	   }
	
	//Change Password Heading Visibility
	public static WebElement visi_change_pwd(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='main']/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr/td/div[2]"));
	      return element;
	   }
	
	//Old Password Text Box
	public static WebElement txt_old_pwd(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtOldPassword']"));
	      return element;
	   }
	
	//New Password Text Box
	public static WebElement txt_new_pwd(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtNewPassword']"));
	      return element;
	   }
	
	//Confirm Password Text Box
	public static WebElement txt_cfm_new_pwd(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtConfirmPassword']"));
	      return element;
	   }
	
	//Submit Button
	public static WebElement btn_submit_CP(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_imgbtnSubmit']"));
	      return element;
	   }
	
	//Cancel Button
	public static WebElement btn_cancel_CP(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_btnCanCel']"));
	      return element;
	   }
	
	//Your Password has been changed Message	
	public static WebElement visi_changed_password_cp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_lblMessage']"));
	      return element;
	   }
	
	//Contact Us Hyperlink
	public static WebElement lnk_contact_us(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_hlContactUs']"));
	      return element;
	   }
	
	//Logout Button
	public static WebElement lnk_logout(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_LoginStatus1']"));
	      return element;
	   }
	
}
