package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectsEAF {

	private static WebElement element = null;
	
	//EAF Link in IJP page
	public static WebElement lnk_EAF(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//a[@href='#/EAF']"));
	      return element;
	   }
	//EAF Link Visiblity Check
	public static WebElement lnk_EAF_visi(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//a[@href='#/EAF']"));
	      return element;
	   }
	
	//Cookies Close Button
	public static WebElement btn_close_cookies(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[2]/div[1]/div/a"));
	      return element;
	   }
	
	public static WebElement btn_close_cookies_careers(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='body-id']/div[4]/div[1]/div/a"));
	      return element;
	   }
	
	public static WebElement btn_close_cookies_careers1(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='body-id']/div[4]/div[1]/div/a"));
	      return element;
	   }
	
	//Select CID Dropdown
	public static WebElement dd_CID(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id=\"cid\"]/div/span/span[1]"));
	      return element;
	   }
	
	//Selecting the first CID
	public static WebElement dd_CID_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id=\"ui-select-choices-row-0-\"]/a"));
	      return element;
	   }
	
	//Clicking OK Button for the selected CID	
	public static WebElement btn_ok_CID_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id=\"TermsMessage\"]/div/button"));
	      return element;
	   }
	
	//Terms and Conditions Popup Title	
	public static WebElement h_Terms_Conditions(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id=\"tcModal\"]/div/div/div[1]/h2"));
	      return element;
	   }
	
	//Terms and Conditions Popup - Yes Button
	public static WebElement btn_ok_Terms_Conditions(WebDriver driver)
	   {
	      element = driver.findElement(By.cssSelector("#tcModal > div > div > div.modal-body > div > div > div > div > div:nth-child(2) > button.btn.btn-ice"));
	      return element;
	   }
	
	/*
	 * *************************************************************************************************************************************
	 * 									PRIMARY DETAILS TAB PAGE ELEMENTS
	 * *************************************************************************************************************************************
	 */
	
	//Primary Details Tab
	public static WebElement lnk_Primary_Det(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Primary Details"));
	      return element;
	   }
	
	
	//Primary Details Tab Heading
		public static WebElement Primary_Det_visi(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='PrimaryDetails']/h3"));
		      return element;
		   }
	
	//Primary Details Tab ICF
	public static WebElement lnk_Primary_Det_icf(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='EAFForm']/div[2]/div[1]/div/div[2]/ul/li[1]/a/span/i"));
	      return element;
	   }
	
	//Primary Details Tab BPO
	public static WebElement lnk_Primary_Det_bpo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='EAFForm']/div[2]/div[1]/div/div[2]/ul/li[1]/a"));
	      return element;
	   }
	
	//Frequently Asked Questions (FAQ) - click here
	public static WebElement lnk_faq_bpo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='EAFForm']/div[1]/div/div/div/div/a"));
	      return element;
	   }
	
	//Download Link in FAQ Page
	public static WebElement lnk_download_faq_bpo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='download']"));
	      return element;
	   }
	
	//Add Photo button
	public static WebElement btn_prmy_photo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='PrimaryDetails']/div[1]/div[1]/div/div/label/span/i"));
	      return element;						 	
	   }
	
	//Salutation
	public static WebElement dd_salutation(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='title']/div[1]/span"));
	      return element;
	   }
	
	//Salutation Input
	public static WebElement dd_salutation_input(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='title']/input[1]"));
	      return element;
	   }
	
	//Salutation Input Select
	public static WebElement dd_salutation_input_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='ui-select-choices-row-38-']/a/span"));
	      return element;						 	//*[@id="ui-select-choices-row-39-0"]/a/span
	   }

	//Salutation Input Select BPO
	public static WebElement dd_salutation_input_select_bpo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id=\"ui-select-choices-row-39-\"]/a/span"));
	      return element;						 	
	   }
	
	//First Name
	public static WebElement dd_fname(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='firstName']"));
	      return element;
	   }

	//Middle Name
	public static WebElement dd_mname(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='middleName']"));
	      return element;
	   }
	
	//Last Name
	public static WebElement dd_lname(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='lastName']"));
	      return element;
	   }
	
	//Gender
	public static WebElement dd_gender(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='gender']/div[1]/span"));
	      return element;
	   }
	
	//Gender Input
	public static WebElement dd_gender_input(WebDriver driver)
		{
		element = driver.findElement(By.xpath(".//*[@id='gender']/input[1]"));
		return element;								
		}
	
	//Gender Input Select
	public static WebElement dd_gender_input_select(WebDriver driver)
		{
	element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-39-']/a/span"));
	return element;
		}
	
	//Gender Input Select BPO
		public static WebElement dd_gender_input_select_bpo(WebDriver driver)
			{
		element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-40-']/a/span"));
		return element;
			}
		
	//Date of Birth
	public static WebElement dd_dob(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='dob']"));
	      return element;
	   }
	
	//Date of Birth Navigators
	public static WebElement dd_dob_1(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='dobContainer']/div[2]/div[1]/table/thead/tr[2]/th[2]"));
	      return element;						 
	   }
	
	public static WebElement dd_dob_2(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='dobContainer']/div[2]/div[2]/table/thead/tr[2]/th[2]"));
	      return element;						 
	   }
	public static WebElement dd_dob_3(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='dobContainer']/div[2]/div[3]/table/thead/tr[2]/th[1]"));
	      return element;						 //2
	   }
	
	public static WebElement dd_dob_4(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='dobContainer']/div[2]/div[3]/table/tbody/tr/td/span[6]"));
	      return element;
	   }
	
	public static WebElement dd_dob_5(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='dobContainer']/div[2]/div[2]/table/tbody/tr/td/span[4]"));
	      return element;
	   }
	
	public static WebElement dd_dob_6(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='dobContainer']/div[2]/div[1]/table/tbody/tr[4]/td[1]"));
	      return element;
	   }
	
	
	
	//Primary Skill / Competency
	public static WebElement txt_pskill(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='primarySkill']"));
	      return element;
	   }
	
	//Source / Channel to Accenture
	public static WebElement txt_source(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='source']"));
	      return element;
	   }
	
	//Confirm Source / Channel to Accenture
	public static WebElement dd_cf_sourcechannel(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='confirmSource']/div[1]/span"));
	      return element;						
	   }
	
	//Confirm Source / Channel to Accenture Input
	public static WebElement dd_cf_sourcechannel_input(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='confirmSource']/input[1]"));
	      return element;						 	
	   }	
	
	//Confirm Source / Channel to Accenture Input Select
	public static WebElement dd_cf_sourcechannel_input_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-40-']/a/span"));
	      return element;						 
	   }
	
	//Employee Name
	public static WebElement txt_emp_name(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='employee']"));
	      return element;
	   }
	
	//Your Relationship with Referral
	public static WebElement txt_rel_ref(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='relationRef']"));
	      return element;
	   }
	
	//Next Section Navigator
	public static WebElement btn_next_section(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='PrimaryDetails']/div[2]/div/div/a"));
	      return element;
	   }
	
	
	/*
	 * *************************************************************************************************************************************
	 * 									PERSONAL DETAILS TAB PAGE ELEMENTS
	 * *************************************************************************************************************************************
	 */
	
	//Personal Details Heading
	public static WebElement lnk_personal_detail_heading(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='PersonalDetails']/h3"));
	      return element;
	   }
	
	//Personal Details  
	public static WebElement lnk_personal_details(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Personal Details "));
	      return element;
	   }
	
	//Place of Birth
	public static WebElement txt_place_of_birth(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='pob']"));
	      return element;
	   }
	
	//Nationality
	public static WebElement dd_nationality(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='nationality']/div[1]/span"));
	      return element;
	   }
	
	//Nationality Input
	public static WebElement dd_nationality_input(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='nationality']/input[1]"));
	      return element;
	   }
	
	//Nationality Input Select
	public static WebElement dd_nationality_input_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-40-']/a/span"));
	      return element;
	   }
	
	
	//Nationality Input Select BPO
	public static WebElement dd_nationality_input_select_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-41-']/a/span"));
		      return element;							
		   }
	
	//Citizenship
	public static WebElement dd_citizenship(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='addiCitizenship']/div[1]/span"));
	      return element;
	   }
	
	//Citizenship Input
	public static WebElement dd_citizenship_input(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='addiCitizenship']/input[1]"));
	      return element;
	   }
	
	//Citizenship Input Select
	public static WebElement dd_citizenship_input_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-41-']/a/span"));
	      return element;
	   }
	
	
	//Citizenship Input Select BPO
	public static WebElement dd_citizenship_input_select_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-42-']/a/span"));
		      return element;
		   }
	
	//Any foreign passport other than Indian passport?
	public static WebElement dd_foreign_passport(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='foreignPassportYN']/div[1]/span"));
	      return element;
	   }
	
	//Any foreign passport other than Indian passport? Input
	public static WebElement dd_foreign_passport_input(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='foreignPassportYN']/input[1]"));
	      return element;
	   }
	
	//Any foreign passport other than Indian passport? Input Select
	public static WebElement dd_foreign_passport_input_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id=\"ui-select-choices-row-43-\"]/a/span"));
	      return element;
	   }
	
	//Any foreign passport other than Indian passport? Input Select BPO
	public static WebElement dd_foreign_passport_input_select_bpo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-43-']/a/span"));
	      return element;
	   }
	
	//Country of Issue
	public static WebElement dd_country_of_issue(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='foreignPassportCountry']/div[1]/span"));
	      return element;
	   }
	
	//Country of Issue Input
	public static WebElement dd_country_of_issue_input(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='foreignPassportCountry']/input[1]"));
	      return element;
	   }
	
	//Country of Issue Input Select
	public static WebElement dd_country_of_issue_input_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-44-']/a/span"));
	      return element;
	   }
		
	//Country of Issue Input Select
		public static WebElement dd_country_of_issue_input_select_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-44-']/a/span"));
		      return element;
		   }
		
		
	//Work Permit to Work in India? *
		public static WebElement dd_work_permit_india_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='wpmtIndia']/div/span/span[2]"));
		      return element;
		   }	
		
	//Work Permit to Work in India? * Input
		public static WebElement dd_work_permit_india_input_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='wpmtIndia']/input[1]"));
		      return element;
		   }
		
	//Work Permit to Work in India? * Input Select
		public static WebElement dd_work_permit_india_input_select_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-45-']/a/span"));
		      return element;
		   }
		
	//PIO/OCI Card by Government of India?
		public static WebElement dd_pio_card_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='validPIO']/div/span/span[2]"));
		      return element;
		   }
	
	//PIO/OCI Card by Government of India? Input
		public static WebElement dd_pio_card_input_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='validPIO']/input[1]"));
		      return element;
		   }
	
	//PIO/OCI Card by Government of India? Input Select
		public static WebElement dd_pio_card_input_select_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-46-']/a/span"));
		      return element;
		   }
		
	//Work Permit Valid Upto
		public static WebElement dd_work_permit_valid_date_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='wpmtIndiaDate']"));
		      return element;
		   }
		
		public static WebElement dd_work_permit_valid_date1_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='wpmtContainer']/div/div[1]/table/thead/tr[2]/th[2]"));
		      return element;
		   }
		
		public static WebElement dd_work_permit_valid_date2_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='wpmtContainer']/div/div[2]/table/thead/tr[2]/th[3]"));
		      return element;
		   }
		
		public static WebElement dd_work_permit_valid_date3_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='wpmtContainer']/div/div[2]/table/tbody/tr/td/span[7]"));
		      return element;
		   } 
		
		public static WebElement dd_work_permit_valid_date4_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='wpmtContainer']/div/div[1]/table/tbody/tr[2]/td[4]"));
		      return element;
		   } 
		
	//PIO/OCI Valid Upto Date
		public static WebElement dd_pio_card_valid_date_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='validPIODate']"));
		      return element;
		   }
		
		public static WebElement dd_pio_card_valid_date1_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='validPIOContainer']/div/div[1]/table/thead/tr[2]/th[2]"));
		      return element;
		   }
		
		public static WebElement dd_pio_card_valid_date2_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='validPIOContainer']/div/div[2]/table/thead/tr[2]/th[3]"));
		      return element;
		   }
		
		public static WebElement dd_pio_card_valid_date3_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='validPIOContainer']/div/div[2]/table/tbody/tr/td/span[7]"));
		      return element;
		   }
		
		public static WebElement dd_pio_card_valid_date4_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='validPIOContainer']/div/div[1]/table/tbody/tr[2]/td[3]"));
		      return element;
		   }
	
	//If No, Please provide reason * Work Permit
		public static WebElement txt_work_permit_provide_reason_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='wpmtReason']"));
		      return element;
		   }	
	
		//If No, Please provide reason * PIO/OCI Card
		public static WebElement txt_pio_card_provide_reason_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='validPIOReason']"));
		      return element;
		   }	
	//Marital Status
	public static WebElement dd_mstatus(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='PersonalDetails']/div[8]/div[1]/div/div/div[1]/span"));
	      return element;
	   }
	
	//Marital Status Input
	public static WebElement dd_mstatus_input(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='PersonalDetails']/div[8]/div[1]/div/div/input[1]"));
	      return element;
	   }
	
	//Marital Status Input Select
	public static WebElement dd_mstatus_input_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='ui-select-choices-row-47-']/a/span"));
	      return element;
	   }
	
	//Marital Status Input Select BPO
	public static WebElement dd_mstatus_input_select_bpo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-47-']/a/span"));
	      return element;
	   }
	
	//Spouse Name
	public static WebElement txt_spousename(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='spouseName']"));
	      return element;
	   }
	
	//Maiden Name
	public static WebElement txt_maidenname(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='maiden']"));
	      return element;
	   }
	
	//Father's Name
	public static WebElement txt_fathername(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='fatherName']"));
	      return element;
	   }
	
	//Mother's Name
	public static WebElement txt_mothername(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='motherName']"));
	      return element;
	   }
	
	//Guardian Name (if applicable)
	public static WebElement txt_guardianname(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='guardian']"));
	      return element;
	   }
	
	//Next Section Navigator
	public static WebElement lnk_navigator_contact(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='PersonalDetails']/div[9]/div/div/a[2]"));
	      return element;
	   }
	
	/*
	 * *************************************************************************************************************************************
	 * 									CONTACT DETAILS TAB PAGE ELEMENTS
	 * *************************************************************************************************************************************
	 */
	
	//Contact Details link
	public static WebElement lnk_contact_details(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='EAFForm']/div[2]/div[1]/div/div[2]/ul/li[3]/a/span/i"));
	      return element;
	   }
	
	//Contact Details Heading
	public static WebElement lnk_contact_details_heading(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='ContactDetails']/h3"));
	      return element;
	   }
	
	//Permanent Phone Number(Mobile No)
	public static WebElement txt_perm_phone(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='phoneNumber']"));
	      return element;
	   }
	
	//Alternate Phone Number
	public static WebElement txt_alt_phone(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='altPhoneNumber']"));
	      return element;
	   }
	
	//Email ID 
	public static WebElement txt_email(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='emailID']"));
	      return element;
	   }
	
	//Alternate Email ID
	public static WebElement txt_alt_email(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='altEmailID']"));
	      return element;
	   }
	
	//Current Address 
	public static WebElement txt_current_address(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='currentAddress']"));
	      return element;
	   }
	
	//Stay at current address From
	public static WebElement txt_stay_current_from(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='currentFromDate']"));
	      return element;
	   }
	
	public static WebElement txt_stay_current_from1(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='currentFromDatePicker']/div[2]/div[1]/table/thead/tr[2]/th[2]"));
	      return element;
	   }
	
	public static WebElement txt_stay_current_from2(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='currentFromDatePicker']/div[2]/div[2]/table/thead/tr[2]/th[2]"));
	      return element;
	   }
	
	public static WebElement txt_stay_current_from3(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='currentFromDatePicker']/div[2]/div[3]/table/thead/tr[2]/th[1]"));
	      return element;						 //2
	   }
	
	public static WebElement txt_stay_current_from4(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='currentFromDatePicker']/div[2]/div[3]/table/tbody/tr/td/span[6]"));
	      return element;
	   }
	
	public static WebElement txt_stay_current_from5(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='currentFromDatePicker']/div[2]/div[2]/table/tbody/tr/td/span[8]"));
	      return element;
	   }
	
	public static WebElement txt_stay_current_from6(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='currentFromDatePicker']/div[2]/div[1]/table/tbody/tr[4]/td[1]"));
	      return element;
	   }
	
	//Stay at current address To
	public static WebElement txt_stay_current_to(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='currentToDate']"));
	      return element;
	   }
	
	public static WebElement txt_stay_current_to1(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='currentToDatePicker']/div[2]/div[1]/table/tbody/tr[3]/td[5]"));
	      return element;
	   }
	
	//PIN Code
	public static WebElement txt_pincode_current(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='currentPinCode']"));
	      return element;
	   }
	
	//Same as Current Address
	public static WebElement chck_same_current_address(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ContactDetails']/div[1]/div[9]/div/label"));
	      return element;
	   }
	
	//Permanent Address
	public static WebElement txt_perm_address(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='permanentAddress']"));
	      return element;
	   }
	
	//Stay at permanent address From
	public static WebElement txt_stay_perm_from(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='permanentFromDate']"));
	      return element;
	   }
	
	//Stay at permanent address To
	public static WebElement txt_stay_perm_to(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='permanentToDate']"));
	      return element;
	   }
	
	//PIN Code Permanent Address
	public static WebElement txt_pincode_permanent(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='permanentPinCode']"));
	      return element;
	   }
	
	//Preferred Work Location
	public static WebElement dd_pref_location(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='preferredLocation']/div/span"));
	      return element;
	   }
		
		
	//Preferred Work Location Input
	public static WebElement dd_pref_location_input(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='preferredLocation']/input[1]"));
	      return element;						 
	   }
	
	//Preferred Work Location Input
	public static WebElement dd_pref_location_input_value(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='preferredLocationBPO']/div"));
	      return element;						 
	   }
	
	//Preferred Work Location Input Select
	public static WebElement dd_pref_location_input_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='ui-select-choices-row-48-']/a"));
	      return element;						 
	   }
	
	//Preferred Work Location Input Select ICF
	public static WebElement dd_pref_location_input_select_icf(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-69-'][1]/a/span"));
	      return element;						 
	   }
	//Preferred Work Location ICF
	public static WebElement dd_pref_location_icf(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='preferredLocation']/div[1]/span"));
	      return element;						 
	   }
	
	//Preferred Work Location BPO
	public static WebElement dd_pref_location_bpo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='preferredLocationBPO']/div[1]/input"));
	      return element;
	   }
	
	//Preferred Work Location Input BPO
	public static WebElement dd_pref_location_input_bpo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='preferredLocationBPO']/div[1]/input"));
	      return element;						 
	   }
	
	//Preferred Work Location Input Select BPO
	public static WebElement dd_pref_location_input_select_bpo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-49-']/a/span"));
	      return element;						 
	   }
	
	//Preferred Work Location Input Select Click BPO
	public static WebElement dd_pref_location_input_select_click_bpo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ContactDetails']/div[1]"));
	      return element;						 
	   }
	
	//Next Section Navigator
	public static WebElement btm_navigator_poip(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='ContactDetails']/div[2]/div/div/a[2]"));
	      return element;
	   }
	
	
	/*
	 * *************************************************************************************************************************************
	 * 									 PASSPORT & OTHER IDENTITY PROOF TAB PAGE ELEMENTS
	 * *************************************************************************************************************************************
	 */
	
	//FAQ
	public static WebElement lnk_faq(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='EAFForm']/div[1]/div/div/div/div/a"));
	      return element;
	   }
	
	//Passport & Other Identity Proof link
	public static WebElement lnk_passport_tab(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='EAFForm']/div[2]/div[1]/div/div[2]/ul/li[4]/a"));
	      return element;
	   }
	
	//Passport & Other Identity Heading
	public static WebElement lnk_passport_tab_visi(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='IdentityDetails']/h3"));
	      return element;
	   }

	//Have you ever held a passport
	public static WebElement dd_passportheld(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='isPassport']/div[1]/span"));
	      return element;						 
	   }
	
	//Have you ever held a passport Input
	public static WebElement dd_passportheld_input(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='isPassport']/input[1]"));
	      return element;
	   }
	
	//Have you ever held a passport Input Select
	public static WebElement dd_passportheld_input_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='ui-select-choices-row-50-']/a/span"));
	      return element;
	   }
	
	//Have you ever held a passport Input Select BPO
	public static WebElement dd_passportheld_input_select_bpo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-50-']/a/span"));
	      return element;
	   }
	
	//Passport Number
	public static WebElement txt_passportnum(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='passportNo']"));
	      return element;
	   }

	//Passport Expiry Date
	public static WebElement txt_passportexpdate(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='passportExpiry']"));
	      return element;
	   }
	
	public static WebElement txt_passportexpdate1(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='expContainer']/div/div[1]/table/thead/tr[2]/th[2]"));
	      return element;
	   }
	
	public static WebElement txt_passportexpdate2(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='expContainer']/div/div[2]/table/thead/tr[2]/th[2]"));
	      return element;
	   }
	
	public static WebElement txt_passportexpdate3(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='expContainer']/div/div[3]/table/thead/tr[2]/th[1]"));
	      return element;//2
	   }
	
	public static WebElement txt_passportexpdate4(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='expContainer']/div/div[3]/table/tbody/tr/td/span[6]"));
	      return element;
	   }
	
	public static WebElement txt_passportexpdate5(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='expContainer']/div/div[2]/table/tbody/tr/td/span[4]"));
	      return element;
	   }
	
	public static WebElement txt_passportexpdate6(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='expContainer']/div/div[1]/table/tbody/tr[4]/td[1]"));
	      return element;
	   }
	

	//Has your visa ever been rejected?
	public static WebElement dd_visareject(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='visaRejected']/div[1]/span"));
	      return element;
	   }
	
	//Has your visa ever been rejected? Input
	public static WebElement dd_visareject_input(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='visaRejected']/input[1]"));
	      return element;
	   }
	
	//Has your visa ever been rejected? Input Select
	public static WebElement dd_visareject_input_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='ui-select-choices-row-51-']/a"));
	      return element;
	   }
	
	//Has your visa ever been rejected? Input Select BPO
	public static WebElement dd_visareject_input_select_bpo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-51-']/a/span"));
	      return element;
	   }
	
	//Date of Rejection
	public static WebElement txt_visarejectdate(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='rejPassportDate']"));
	      return element;
	   }
	
	public static WebElement txt_visarejectdate1(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='calContainer']/div/div[1]/table/thead/tr[2]/th[2]"));
	      return element;							
	   }
	
	public static WebElement txt_visarejectdate2(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='calContainer']/div/div[2]/table/tbody/tr/td/span[2]"));
	      return element;							
	   }
	
	public static WebElement txt_visarejectdate3(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='calContainer']/div/div[1]/table/tbody/tr[1]/td[4]"));
	      return element;							
	   }
	
	//For which country
	public static WebElement dd_rejectedcountry(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='rejCountry']/div[1]/span"));
	      return element;
	   }
	
	//For which country input
	public static WebElement dd_rejectedcountryinput(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='rejCountry']/input[1]"));
	      return element;
	   }
	
	//For which country input select
	public static WebElement dd_rejectedcountryinput_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='ui-select-choices-row-52-']/a/span"));
	      return element;
	   }
		
	//For which country input select BPO
	public static WebElement dd_rejectedcountryinput_select_bpo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-52-']/a/span"));
	      return element;
	   }
	
	//Reason
	public static WebElement txt_rejreason(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='rejReason']"));
	      return element;
	   }
	
	//Do You Have PAN Card? BPO
	public static WebElement dd_pancard(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id=\"panYN\"]/div/span/span[2]/span"));
	      return element;
	   }
	
	//Do You Have PAN Card? Input BPO
	public static WebElement dd_pancard_input_bpo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='panYN']/input[1]"));
	      return element;
	   }
	
	//Do You Have PAN Card? Input Select BPO
	public static WebElement dd_pancard_input_select_bpo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-53-']/a/span"));
	      return element;
	   }
	
	//Do You Have PAN Card? *
	public static WebElement dd_PANnum(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id=\"panYN\"]/div/span"));
	      return element;
	   }
	
	//Do You Have PAN Card? * Input	
	public static WebElement dd_PANnum_input(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id=\"panYN\"]/input[1]"));
	      return element;
	   }
	
	//Do You Have PAN Card? * Input	Select
	public static WebElement dd_PANnum_input_select(WebDriver driver)
		{
		   element = driver.findElement(By.xpath("//*[@id=\"ui-select-choices-row-53-\"]/a/span"));
		   return element;
		}
	
	//Permanent Account Number (PAN)
	public static WebElement txt_PANnum(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='panNo']"));
	      return element;
	   }
	
	//NASSCOM NSR IT PIN Number
	public static WebElement txt_NSRITPINnum(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='nasscomPin']"));
	      return element;
	   }
	
	//Driving License Number
	public static WebElement txt_drivinglicense(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='dlNumber']"));
	      return element;
	   }
	
	//Driving License Valid upto
	public static WebElement dd_LicenseValidUpto(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='validDL']"));
	      return element;
	   }
	
	public static WebElement dd_LicenseValidUpto1(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='expDL']/div[2]/div[1]/table/thead/tr[2]/th[2]"));
	      return element;
	   }
		
	public static WebElement dd_LicenseValidUpto2(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='expDL']/div[2]/div[2]/table/thead/tr[2]/th[2]"));
	      return element;
	   }
	
	public static WebElement dd_LicenseValidUpto3(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='expDL']/div[2]/div[3]/table/thead/tr[2]/th[3]"));
	      return element;
	   }
	
	public static WebElement dd_LicenseValidUpto4(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='expDL']/div[2]/div[3]/table/tbody/tr/td/span[11]"));
	      return element;
	   }
	
	public static WebElement dd_LicenseValidUpto5(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='expDL']/div[2]/div[2]/table/tbody/tr/td/span[8]"));
	      return element;
	   }
	
	public static WebElement dd_LicenseValidUpto6(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='expDL']/div[2]/div[1]/table/tbody/tr[4]/td[5]"));
	      return element;
	   }
	
	//Do You Have Aadhaar Card?
	public static WebElement dd_aadhaar_card(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='aadhaarYN']/div[1]/span"));
	      return element;
	   }
	
	//Do You Have Aadhaar Card? Input
	public static WebElement dd_aadhaar_card_input(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='aadhaarYN']/input[1]"));
	      return element;
	   }
	
	//Do You Have Aadhaar Card? Input Select
	public static WebElement dd_aadhaar_card_input_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='ui-select-choices-row-54-']/a/span"));
	      return element;
	   }
		
	//Do You Have Aadhaar Card? Input Select BPO
	public static WebElement dd_aadhaar_card_input_select_bpo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-54-']/a/span"));
	      return element;
	   }
	
	//Aadhaar Number 
	public static WebElement txt_aadhaar_card(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='aadhaarNo']"));
	      return element;
	   }
	
	//Name as on Aadhaar 
	public static WebElement txt_aadhaar_name(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='aadhaarName']"));
	      return element;
	   }
	
	//Enrollment Number 
	public static WebElement txt_enrollment_num(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='aadhaarEnrollNo']"));
	      return element;
	   }
	
	//Next Section Navigator
	public static WebElement btm_navigator_ref(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='IdentityDetails']/div[2]/div/div/a[2]"));
	      return element;
	   }
	
	/*
	 * *************************************************************************************************************************************
	 * 									 REFERNCE TAB PAGE ELEMENTS
	 * *************************************************************************************************************************************
	 */
	
	//Reference Proof link
	public static WebElement lnk_ref_tab(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='EAFForm']/div[2]/div[1]/div/div[2]/ul/li[5]/a"));
	      return element;
	   }
	
	//Reference Heading Visibility
	public static WebElement lnk_ref_tab_visi(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ReferenceDetails']/h3"));
	      return element;
	   }
	
	//Add Reference Button
	public static WebElement btn_add_ref(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='addRefData']"));
	      return element;
	   }
	
	//Reference Name 
	public static WebElement txt_ref_name(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='refName']"));
	      return element;
	   }
	
	//Designation
	public static WebElement txt_ref_desig(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='refDesignation']"));
	      return element;
	   }
	
	//Organization/Institute
	public static WebElement txt_ref_org(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='refOrganization']"));
	      return element;
	   }
	
	//Organization/Institute Input
	public static WebElement txt_ref_org_input(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='refOrganization']"));
	      return element;
	   }
	
	//Organization/Institute Input Select
	public static WebElement txt_ref_org_input_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='refAddModal']/div/form/div/div[2]/div/div/div[3]/div[1]/div/ul/li/a"));
	      return element;
	   }
	
	//Telephone
	public static WebElement txt_ref_tele(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='refTelephone']"));
	      return element;
	   }
	
	//Email ID 
	public static WebElement txt_ref_emailid(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='refEmailID']"));
	      return element;
	   }
	
	//Address 
	public static WebElement txt_ref_address(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='refAddress']"));
	      return element;
	   }
	
	//Relationship
	public static WebElement txt_ref_relationship(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='refRelationship']"));
	      return element;
	   }
	
	//OK Button
	public static WebElement btn_ref_ok(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='refAddModal']/div/form/div/div[2]/div/div/div[6]/button"));
	      return element;
	   }
	
	//Next Section Navigator
	public static WebElement btm_navigator_exacc(WebDriver driver)
	   {
	      element = driver.findElement(By.cssSelector("#IdentityDetails > div:nth-child(3) > div > div > a.next"));
	      return element;
	   }

	//Next Section Navigator	
	public static WebElement btm_navigator_exacc_bpo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='ReferenceDetails']/div[3]/div/a[2]"));
	      return element;
	   }
	
	
	/*
	 * *************************************************************************************************************************************
	 * 									 EX-ACCENTURE TAB PAGE ELEMENTS
	 * *************************************************************************************************************************************
	 */
	
	//Ex-Accenture Heading Visibility
	public static WebElement dd_exacc_visi(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ExAccentureDetails']/h3"));
	      return element;
	   }
	
	//Have you worked with Accenture before?
	public static WebElement dd_exacc(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='prevEmployee']/div[1]/span"));
	      return element;
	   }
	
	//Have you worked with Accenture before? Input
	public static WebElement dd_exacc_input(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='prevEmployee']/input[1]"));
	      return element;
	   }
	
	//Have you worked with Accenture before? Input Select
	public static WebElement dd_exacc_input_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='ui-select-choices-row-55-']/a/span"));
	      return element;
	   }
	
	
	//Have you worked with Accenture before? Input Select
		public static WebElement dd_exacc_input_select1(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-54-']/a/span"));
		      return element;
		   }
	//Period From
	public static WebElement txt_period_from(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='exAccFromDate']"));
	      return element;
	   }
	
	public static WebElement txt_period_from1(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='exAccFromDatePicker']/div[2]/div[1]/table/thead/tr[2]/th[2]"));
	      return element;							
	   }
	
	public static WebElement txt_period_from2(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='exAccFromDatePicker']/div[2]/div[2]/table/thead/tr[2]/th[2]"));
	      return element;							
	   }
	
	
	public static WebElement txt_period_from3(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='exAccFromDatePicker']/div[2]/div[3]/table/tbody/tr/td/span[7]"));
	      return element;							
	   }
	
	public static WebElement txt_period_from4(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='exAccFromDatePicker']/div[2]/div[2]/table/tbody/tr/td/span[4]"));
	      return element;
	   }
	
	public static WebElement txt_period_from5(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='exAccFromDatePicker']/div[2]/div[1]/table/tbody/tr[1]/td[4]"));
	      return element;
	   }
	
	//Period To
	public static WebElement txt_period_to(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='exAccToDate']"));
	      return element;
	   }
	
	public static WebElement txt_period_to1(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='exAccToDatePicker']/div[2]/div[1]/table/thead/tr[2]/th[2]"));
	      return element;
	   }
	
	public static WebElement txt_period_to2(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='exAccToDatePicker']/div[2]/div[2]/table/tbody/tr/td/span[4]"));
	      return element;
	   }
	
	public static WebElement txt_period_to3(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='exAccToDatePicker']/div[2]/div[1]/table/tbody/tr[1]/td[7]"));
	      return element;
	   }
	
	//Entity that you worked for
	public static WebElement dd_prev_entity(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='prevEntity']/div[1]/span"));
	      return element;
	   }
	
	//Entity that you worked for Input
	public static WebElement dd_prev_entity_input(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='prevEntity']/input[1]"));
	      return element;
	   }
	
	//Entity that you worked for Input Select
	public static WebElement dd_prev_entity_input_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='ui-select-choices-row-56-']/a/span"));
	      return element;
	   }
	
	
	//Entity that you worked for Input Select
		public static WebElement dd_prev_entity_input_select1(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-55-']/a/span"));
		      return element;
		   }
	
	
	//Old Employee ID 
	public static WebElement txt_old_emp_id(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='oldID']"));
	      return element;
	   }
	
	//Next Section Navigator
	public static WebElement btn_navigator_prev_interview(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='ExAccentureDetails']/div[2]/div/div/a[2]"));
	      return element;
	   }
	
		
	/*
	 * *************************************************************************************************************************************
	 * 									 PREVIOUS INTERVIEWS TAB PAGE ELEMENTS
	 * *************************************************************************************************************************************
	 */
	
	//Previous Interview Heading Visibility
	public static WebElement prev_heading_visi(WebDriver driver)
	{
	  element = driver.findElement(By.xpath(".//*[@id='PreInterviewDetails']/h3"));
	  return element;
	}
	
	//Have you applied to Accenture in last 6 months
	public static WebElement dd_apply_6months(WebDriver driver)
	{
	  element = driver.findElement(By.xpath(".//*[@id='alreadyApplied']/div[1]/span"));
	  return element;
	}
	
	//Have you applied to Accenture in last 6 months Input
	public static WebElement dd_apply_6months_input(WebDriver driver)
	{
	  element = driver.findElement(By.xpath("//*[@id='alreadyApplied']/input[1]"));
	  return element;
	}
	
	
	//Have you applied to Accenture in last 6 months Input Select
	public static WebElement dd_apply_6months_input_select(WebDriver driver)
	{
	  element = driver.findElement(By.xpath("//*[@id='ui-select-choices-row-57-']/a/span"));
	  return element;
	}
	
	//Have you applied to Accenture in last 6 months Input Select
		public static WebElement dd_apply_6months_input_select1(WebDriver driver)
		{
		  element = driver.findElement(By.xpath("//*[@id='ui-select-choices-row-56-']/a/span"));
		  return element;
		}
		
	
	//Please mention the date
	public static WebElement txt_interview_date(WebDriver driver)
	{
	  element = driver.findElement(By.xpath(".//*[@id='interwPeriod']"));
	  return element;
	}
	
	public static WebElement txt_interview_date1(WebDriver driver)
	{
	  element = driver.findElement(By.xpath(".//*[@id='picker-container']/div[2]/div[1]/table/thead/tr[2]/th[2]"));
	  return element;
	}
	
	public static WebElement txt_interview_date2(WebDriver driver)
	{
	  element = driver.findElement(By.xpath(".//*[@id='picker-container']/div[2]/div[2]/table/tbody/tr/td/span[6]"));
	  return element;
	}
	
	public static WebElement txt_interview_date3(WebDriver driver)
	{
	  element = driver.findElement(By.xpath(".//*[@id='picker-container']/div[2]/div[1]/table/tbody/tr[1]/td[5]"));
	  return element;
	}
	
	//Previous CID
	public static WebElement txt_prev_cid(WebDriver driver)
	{
	  element = driver.findElement(By.xpath(".//*[@id='prevCID']"));
	  return element;
	}
	
	//Next Section Navigator
	public static WebElement btm_navigator_edu_details(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='PreInterviewDetails']/div[2]/div/div/a[2]"));
	      return element;
	   }
	
	/*
	 * *************************************************************************************************************************************
	 * 									 EDUCATION DETAILS TAB PAGE ELEMENTS
	 * *************************************************************************************************************************************
	 */
	
	//Education Details Page Link
	public static WebElement lnk_edu_details(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='EAFForm']/div[2]/div[1]/div/div[2]/ul/li[8]/a"));
	      return element;
	   }
	
	//Education Details Heading Visibility
	public static WebElement lnk_edu_details_visi(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='EduDetails']/h3"));
	      return element;
	   }
	
	//Education Details Static Message
	public static WebElement visi_education_static1(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='EduDetails']/div[3]/div[1]"));
	      return element;
	   }
	
	public static WebElement visi_education_static2(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='EduDetails']/div[3]/div[2]"));
	      return element;
	   }
	
	
	//SSC/10TH Link
	public static WebElement lnk_ssc(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='EduDetails']/div[1]/div[1]/div[2]/div[1]/div[5]/a[1]/img"));
	      return element;
	   }
	
	//HSC/ 12th/Equivalent
	public static WebElement lnk_hsc(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='EduDetails']/div[1]/div[1]/div[2]/div[2]/div[5]/a[1]/img"));
	      return element;
	   }
	
	//Post Graduation
	public static WebElement lnk_pg(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='EduDetails']/div[1]/div[1]/div[2]/div[3]/div[5]/a[1]/img"));
	      return element;
	   }
	
	//Graduation/ Degree
	public static WebElement lnk_ug(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='EduDetails']/div[1]/div[1]/div[2]/div[3]/div[5]/a[1]/img"));
	      return element;
	   }
	
	//Reasons for gap in education (if any)
	public static WebElement txt_reasonforgap(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='EduDetails']/div[1]/div[2]/div/textarea"));
	      return element;
	   }
	
	//Add Education Button
	public static WebElement btn_add_edu(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='button2']"));
	      return element;
	   }
	
	//Edit Education Details
	
	//Highest Education Check Box
	public static WebElement chk_high_edu(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='eduEditModal']/div/form/div/div[2]/div/div/div[1]/div/div[2]/label"));
	      return element;						 
	   }
	
	//Degree Status BPO
	public static WebElement dd_deg_status_bpo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='degreeEdit']/div[1]/span"));
	      return element;						 
	   }
	
	//Degree Status Input BPO
	public static WebElement dd_deg_status_input_bpo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='degreeEdit']/input[1]"));
	      return element;						 
	   }
	
	//Degree Status Input Select BPO
	public static WebElement dd_deg_status_input_select_bpo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='ui-select-choices-row-23-']/a"));
	      return element;						 
	   }
	
	//Qualification
	public static WebElement dd_qualification(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='qualificationEdit']/div[1]/span"));
	      return element;						 
	   }
	
	//Qualification Input
	public static WebElement dd_qualification_input(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='qualificationEdit']/input[1]"));
	      return element;
	   }
	
	//Qualification Input Select
	public static WebElement dd_qualification_input_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-24-']/a/span"));
	      return element;					
	   }
	
	//Qualification - ICF
		public static WebElement dd_qualification_icf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='qualificationEditBPO']"));
		      return element;						 		
		   }
		
	//Qualification - BPO
		public static WebElement dd_qualification_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='qualificationEditBPO']"));
		      return element;						 		
		   }	
	
	//Qualification - BPO Input Select
		public static WebElement dd_qualification_input_select_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='eduEditModal']/div/form/div/div[2]/div/div/div[2]/div[3]/div/ul/li/a"));
		      return element;						 		
		   }
		
		//Qualification - BPO
				public static WebElement dd_specialization_bpo(WebDriver driver)
				   {
				      element = driver.findElement(By.xpath(".//*[@id='specializationEditBPO']"));
				      return element;						 		
				   }
		
	//Others Qualification - BPO
		public static WebElement txt_other_specialization(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='specializationOthersEditBPO']"));
		      return element;						 		
		   }
		
		
		
	//Specialization
	public static WebElement dd_spec(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='specializationEdit']/div/span"));
	      return element;							
	   }
	
	//Specialization Value Populated
	public static WebElement dd_spec_populated(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='specializationEdit']/div/span/span[2]/span"));
	      return element;							
	   }
	
	//Specialization Input
	public static WebElement dd_spec_input(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='specializationEdit']/input[1]"));
	      return element;
	   }
	
	//Specialization Input Select
	public static WebElement dd_spec_input_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='ui-select-choices-row-25-']/a/span"));
	      return element;						 //*[@id="ui-select-choices-row-25-"]/a/span
	   }
	
	//Specialization - ICF
	public static WebElement dd_spec_icf(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='specializationEditBPO']"));
	      return element;							
	   }
	
	//Specialization - BPO
	public static WebElement dd_spec_bpo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='specializationEditBPO']"));
	      return element;							
	   }
	
	//Specialization Input Select - BPO
		public static WebElement dd_spec_input_select_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("//*[@id='eduEditModal']/div/form/div/div[2]/div/div/div[3]/div[2]/div/ul/li[1]/a"));
		      return element;							
		   }
	
		//Other Specialization Input - ICF
		public static WebElement txt_spec_input_select_others_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.id("specializationOthersEditBPO"));
		      return element;							
		   }
		
		
	//Institution Name & City (School/College)
	public static WebElement txt_insti_name(WebDriver driver)
	   {
	      element = driver.findElement(By.id("institutionEditBPO"));
	      return element;
	   }
	
	//Institution Name & City (School/College) ICF
		public static WebElement txt_insti_name_icf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='institutionEdit']"));
		      return element;
		   }
	 
	//Institution Name & City (School/College) BPO
	public static WebElement dd_insit_name_bpo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='institutionEditBPO']"));
	      return element;
	   }
	
	//Institution Name & City (School/College) BPO Input Select
	public static WebElement dd_insit_name_input_select_bpo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='eduEditModal']/div/form/div/div[2]/div/div/div[3]/div[5]/div/ul/li[1]/a"));
	      return element;						
	   }
	
	//University Name/Board Affiliated To
	public static WebElement txt_affili_to(WebDriver driver)
	   {
	      element = driver.findElement(By.id("universityEditBPO"));
	      return element;							
	   }
	
	//University Name/Board Affiliated To ICF
	public static WebElement txt_affili_to_icf(WebDriver driver)
	   {
	      element = driver.findElement(By.id("universityEdit"));
	      return element;							
	   }
	
	//University Name/Board Affiliated To ICF Input Select
	public static WebElement txt_affili_to_input_select_icf(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='eduEditModal']/div/form/div/div[2]/div/div/div[3]/div[5]/div/ul/li[1]/a"));
	      return element;							
	   }
		
	//University Name/Board Affiliated To BPO
	public static WebElement dd_affili_to_bpo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='universityEditBPO']"));
	      return element;							
	   }
	
	//University Name/Board Affiliated To BPO Input Select
	public static WebElement dd_affili_to_input_select_bpo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='eduEditModal']/div/form/div/div[2]/div/div/div[3]/div[8]/div/ul/li[1]/a"));
	      return element;							
	   }
	
	//SWF Period From and To
	
	//Period From
	public static WebElement txt_edu_period_froms(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='periodFromEdit']"));
	      return element;
	   }
	
	public static WebElement txt_edu_period_from1s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[1]/table/thead/tr[2]/th[2]"));
	      return element;						
	   }
	
	public static WebElement txt_edu_period_from2s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[2]/table/thead/tr[2]/th[2]"));
	      return element;	
	   }
	
	public static WebElement txt_edu_period_from3s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[3]/table/thead/tr[2]/th[1]"));
	      return element;
	   }
	
	public static WebElement txt_edu_period_from4s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[3]/table/tbody/tr/td/span[10]"));
	      return element;
	   }
	
	public static WebElement txt_edu_period_from5s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[2]/table/tbody/tr/td/span[7]"));
	      return element;
	   }
	
	public static WebElement txt_edu_period_from6s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[1]/table/tbody/tr[1]/td[3]"));
	      return element;
	   }
	
	
	//Period From - HSC
	public static WebElement txt_edu_period_from_hscs(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='periodFromEdit']"));
	      return element;						
	   }
	
	public static WebElement txt_edu_period_from_hsc1s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/thead/tr[2]/th[2]"));
	      return element;						
	   }
	
	public static WebElement txt_edu_period_from_hsc2s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("/html/body/div[9]/div[2]/table/thead/tr[2]/th[2]"));
	      return element;						
	   }
	
	public static WebElement txt_edu_period_from_hsc3s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("/html/body/div[9]/div[3]/table/tbody/tr/td/span[12]"));
	      return element;						
	   }	
	
	public static WebElement txt_edu_period_from_hsc4s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("/html/body/div[9]/div[2]/table/tbody/tr/td/span[7]"));
	      return element;						
	   }
	
	public static WebElement txt_edu_period_from_hsc5s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/tbody/tr[3]/td[5]"));
	      return element;							
	   }
	
	
	//Period From - UG
	public static WebElement txt_edu_period_from_ugs(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='periodFromEdit']"));
	      return element;						
	   }
	
	public static WebElement txt_edu_period_from_ug1s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/thead/tr[2]/th[2]"));
	      return element;						
	   }
	
	public static WebElement txt_edu_period_from_ug1_bpos(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/thead/tr[2]/th[2]"));
	      return element;						
	   }
	
	public static WebElement txt_edu_period_from_ug2s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("/html/body/div[9]/div[2]/table/thead/tr[2]/th[3]"));
	      return element;						
	   } 
	
	public static WebElement txt_edu_period_from_ug2_bpos(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("/html/body/div[9]/div[2]/table/thead/tr[2]/th[3]"));
	      return element;						
	   } 		
		
	public static WebElement txt_edu_period_from_ug3s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("/html/body/div[9]/div[2]/table/tbody/tr/td/span[7]"));
	      return element;						
	   }
	
	public static WebElement txt_edu_period_from_ug3_bpos(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("/html/body/div[9]/div[2]/table/tbody/tr/td/span[7]"));
	      return element;						
	   }
		
	public static WebElement txt_edu_period_from_ug4s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/tbody/tr[3]/td[6]"));
	      return element;						
	   }
	
	public static WebElement txt_edu_period_from_ug4_bpos(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/tbody/tr[3]/td[6]"));
	      return element;						
	   }
		
	public static WebElement txt_edu_period_from_ug5s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[2]/table/tbody/tr/td/span[6]"));
	      return element;						
	   }
	
	public static WebElement txt_edu_period_from_ug6s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[1]/table/tbody/tr[1]/td[5]"));
	      return element;						
	   }
	
	//Period To
	public static WebElement txt_edu_period_tos(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='periodToEdit']"));
	      return element;
	   }
	
	public static WebElement txt_edu_period_to1s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[1]/table/thead/tr[2]/th[2]"));
	      return element;
	   }
	
	public static WebElement txt_edu_period_to2s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[2]/table/thead/tr[2]/th[2]"));
	      return element;
	   }
	
	public static WebElement txt_edu_period_to3s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[3]/table/thead/tr[2]/th[1]"));
	      return element;
	   }
	
	public static WebElement txt_edu_period_to4s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[3]/table/tbody/tr/td/span[11]"));
	      return element;
	   }
	
	public static WebElement txt_edu_period_to5s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[2]/table/tbody/tr/td/span[6]"));
	      return element;
	   }
	
	public static WebElement txt_edu_period_to6s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[1]/table/tbody/tr[4]/td[4]"));
	      return element;
	   }
	
	//Period To HSC
	public static WebElement txt_edu_period_to_hscs(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='periodToEdit']"));
	      return element;
	   }
	
	public static WebElement txt_edu_period_to_hsc1s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[1]/table/thead/tr[2]/th[2]"));
	      return element;						
	   }	
	
	public static WebElement txt_edu_period_to_hsc1_bpos(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/thead/tr[2]/th[2]"));
	      return element;						
	   }
	
	public static WebElement txt_edu_period_to_hsc2s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[2]/table/thead/tr[2]/th[2]"));
	      return element;						
	   }
	
	public static WebElement txt_edu_period_to_hsc2_bpos(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("/html/body/div[9]/div[2]/table/thead/tr[2]/th[3]"));
	      return element;						
	   }
	
	public static WebElement txt_edu_period_to_hsc3s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[3]/table/thead/tr[2]/th[3]"));
	      return element;						
	   }
	
	public static WebElement txt_edu_period_to_hsc3_bpos(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("/html/body/div[9]/div[2]/table/tbody/tr/td/span[4]"));
	      return element;						
	   }
	
	public static WebElement txt_edu_period_to_hsc4s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[3]/table/tbody/tr/td/span[3]"));
	      return element;
	   }
	   
	public static WebElement txt_edu_period_to_hsc4_bpos(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/tbody/tr[4]/td[3]"));
	      return element;
	   }
	
	public static WebElement txt_edu_period_to_hsc5s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[2]/table/tbody/tr/td/span[4]"));
	      return element;
	   }
	
	public static WebElement txt_edu_period_to_hsc6s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[1]/table/tbody/tr[1]/td[6]"));
	      return element;
	   }
	
	//Period To - UG
	public static WebElement txt_edu_period_to_ugs(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='periodToEdit']"));
	      return element;
	   }
	
	public static WebElement txt_edu_period_to_ug1s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[1]/table/thead/tr[2]/th[2]"));
	      return element;					
	   }
	
	public static WebElement txt_edu_period_to_ug1_bpos(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/thead/tr[2]/th[2]"));
	      return element;					
	   }	
		
	public static WebElement txt_edu_period_to_ug2s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[2]/table/thead/tr[2]/th[2]"));
	      return element;
	   }
	
	public static WebElement txt_edu_period_to_ug2_bpos(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("/html/body/div[9]/div[2]/table/thead/tr[2]/th[2]"));
	      return element;
	   }
		
	public static WebElement txt_edu_period_to_ug3s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[3]/table/tbody/tr/td/span[7]"));
	      return element;
	   }
	
	public static WebElement txt_edu_period_to_ug3_bpos(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("/html/body/div[9]/div[3]/table/tbody/tr/td/span[7]"));
	      return element;
	   }
		
	public static WebElement txt_edu_period_to_ug4s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[2]/table/tbody/tr/td/span[4]"));
	      return element;
	   }		
	
	public static WebElement txt_edu_period_to_ug4_bpos(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("/html/body/div[9]/div[2]/table/tbody/tr/td/span[4]"));
	      return element;
	   }
	
	public static WebElement txt_edu_period_to_ug5s(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[1]/table/tbody/tr[2]/td[6]"));
	      return element;
	   }
	
	public static WebElement txt_edu_period_to_ug5_bpos(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/tbody/tr[5]/td[5]"));
	      return element;
	   }
	
	//BPO Period From And To Objects
	//Period From
		public static WebElement txt_edu_period_from(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='periodFromEdit']"));
		      return element;
		   }
		
		public static WebElement txt_edu_period_from1(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[1]/table/thead/tr[2]/th[2]"));
		      return element;						
		   }
		
		public static WebElement txt_edu_period_from2(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[2]/table/thead/tr[2]/th[2]"));
		      return element;	
		   }
		
		public static WebElement txt_edu_period_from3(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[3]/table/thead/tr[2]/th[1]"));
		      return element;
		   }
		
		public static WebElement txt_edu_period_from4(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[3]/table/tbody/tr/td/span[10]"));
		      return element;
		   }
		
		public static WebElement txt_edu_period_from5(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[2]/table/tbody/tr/td/span[7]"));
		      return element;
		   }
		
		public static WebElement txt_edu_period_from6(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[1]/table/tbody/tr[1]/td[3]"));
		      return element;
		   }
		
		
		//Period From - HSC
		public static WebElement txt_edu_period_from_hsc(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='periodFromEdit']"));
		      return element;						
		   }
		
		public static WebElement txt_edu_period_from_hsc1(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/thead/tr[2]/th[2]"));
		      return element;						
		   }
		
		public static WebElement txt_edu_period_from_hsc2(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("/html/body/div[9]/div[2]/table/thead/tr[2]/th[2]"));
		      return element;						
		   }
		
		public static WebElement txt_edu_period_from_hsc3(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("/html/body/div[9]/div[3]/table/tbody/tr/td/span[12]"));
		      return element;						
		   }	
		
		public static WebElement txt_edu_period_from_hsc4(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("/html/body/div[9]/div[2]/table/tbody/tr/td/span[7]"));
		      return element;						
		   }
		
		public static WebElement txt_edu_period_from_hsc5(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/tbody/tr[3]/td[5]"));
		      return element;							
		   }
		
		
		//Period From - UG
		public static WebElement txt_edu_period_from_ug(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='periodFromEdit']"));
		      return element;						
		   }
		
		public static WebElement txt_edu_period_from_ug1(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/thead/tr[2]/th[2]"));
		      return element;						
		   }
		
		public static WebElement txt_edu_period_from_ug1_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/thead/tr[2]/th[2]"));
		      return element;						
		   }
		
		public static WebElement txt_edu_period_from_ug2(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("/html/body/div[9]/div[2]/table/thead/tr[2]/th[3]"));
		      return element;						
		   } 
		
		public static WebElement txt_edu_period_from_ug2_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("/html/body/div[9]/div[2]/table/thead/tr[2]/th[3]"));
		      return element;						
		   } 		
			
		public static WebElement txt_edu_period_from_ug3(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("/html/body/div[9]/div[2]/table/tbody/tr/td/span[7]"));
		      return element;						
		   }
		
		public static WebElement txt_edu_period_from_ug3_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("/html/body/div[9]/div[2]/table/tbody/tr/td/span[7]"));
		      return element;						
		   }
			
		public static WebElement txt_edu_period_from_ug4(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/tbody/tr[3]/td[6]"));
		      return element;						
		   }
		
		public static WebElement txt_edu_period_from_ug4_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/tbody/tr[3]/td[6]"));
		      return element;						
		   }
			
		public static WebElement txt_edu_period_from_ug5(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[2]/table/tbody/tr/td/span[6]"));
		      return element;						
		   }
		
		public static WebElement txt_edu_period_from_ug6(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[1]/table/tbody/tr[1]/td[5]"));
		      return element;						
		   }
		
		//Period To
		public static WebElement txt_edu_period_to(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='periodToEdit']"));
		      return element;
		   }
		
		public static WebElement txt_edu_period_to1(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[1]/table/thead/tr[2]/th[2]"));
		      return element;
		   }
		
		public static WebElement txt_edu_period_to2(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[2]/table/thead/tr[2]/th[2]"));
		      return element;
		   }
		
		public static WebElement txt_edu_period_to3(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[3]/table/thead/tr[2]/th[1]"));
		      return element;
		   }
		
		public static WebElement txt_edu_period_to4(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[3]/table/tbody/tr/td/span[11]"));
		      return element;
		   }
		
		public static WebElement txt_edu_period_to5(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[2]/table/tbody/tr/td/span[6]"));
		      return element;
		   }
		
		public static WebElement txt_edu_period_to6(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[1]/table/tbody/tr[4]/td[4]"));
		      return element;
		   }
		
		//Period To HSC
		public static WebElement txt_edu_period_to_hsc(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='periodToEdit']"));
		      return element;
		   }
		
		public static WebElement txt_edu_period_to_hsc1(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[1]/table/thead/tr[2]/th[2]"));
		      return element;						
		   }	
		
		public static WebElement txt_edu_period_to_hsc1_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/thead/tr[2]/th[2]"));
		      return element;						
		   }
		
		public static WebElement txt_edu_period_to_hsc2(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[2]/table/thead/tr[2]/th[2]"));
		      return element;						
		   }
		
		public static WebElement txt_edu_period_to_hsc2_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("/html/body/div[9]/div[2]/table/thead/tr[2]/th[3]"));
		      return element;						
		   }
		
		public static WebElement txt_edu_period_to_hsc3(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[3]/table/thead/tr[2]/th[3]"));
		      return element;						
		   }
		
		public static WebElement txt_edu_period_to_hsc3_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("/html/body/div[9]/div[2]/table/tbody/tr/td/span[4]"));
		      return element;						
		   }
		
		public static WebElement txt_edu_period_to_hsc4(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[3]/table/tbody/tr/td/span[3]"));
		      return element;
		   }
		   
		public static WebElement txt_edu_period_to_hsc4_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/tbody/tr[4]/td[3]"));
		      return element;
		   }
		
		public static WebElement txt_edu_period_to_hsc5(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[2]/table/tbody/tr/td/span[4]"));
		      return element;
		   }
		
		public static WebElement txt_edu_period_to_hsc6(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[1]/table/tbody/tr[1]/td[6]"));
		      return element;
		   }
		
		//Period To - UG
		public static WebElement txt_edu_period_to_ug(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='periodToEdit']"));
		      return element;
		   }
		
		public static WebElement txt_edu_period_to_ug1(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[1]/table/thead/tr[2]/th[2]"));
		      return element;					
		   }
		
		public static WebElement txt_edu_period_to_ug1_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/thead/tr[2]/th[2]"));
		      return element;					
		   }	
			
		public static WebElement txt_edu_period_to_ug2(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[2]/table/thead/tr[2]/th[2]"));
		      return element;
		   }
		
		public static WebElement txt_edu_period_to_ug2_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("/html/body/div[9]/div[2]/table/thead/tr[2]/th[2]"));
		      return element;
		   }
			
		public static WebElement txt_edu_period_to_ug3(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[3]/table/tbody/tr/td/span[7]"));
		      return element;
		   }
		
		public static WebElement txt_edu_period_to_ug3_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("/html/body/div[9]/div[3]/table/tbody/tr/td/span[7]"));
		      return element;
		   }
			
		public static WebElement txt_edu_period_to_ug4(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[2]/table/tbody/tr/td/span[4]"));
		      return element;
		   }		
		
		public static WebElement txt_edu_period_to_ug4_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("/html/body/div[9]/div[2]/table/tbody/tr/td/span[4]"));
		      return element;
		   }
		
		public static WebElement txt_edu_period_to_ug5(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[1]/table/tbody/tr[2]/td[6]"));
		      return element;
		   }
		
		public static WebElement txt_edu_period_to_ug5_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/tbody/tr[5]/td[5]"));
		      return element;
		   }
	
	
	//Program Type
	public static WebElement dd_prgm_type(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='programTypeEdit']/div/span"));
	      return element;
	   }
	
	//Program Type Input
	public static WebElement dd_prgm_type_input(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='programTypeEdit']/input[1]"));
	      return element;
	   }
	
	//Program Type Input Select
	public static WebElement dd_prgm_type_input_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-26-']/a/span"));
	      return element;							
	   }
	
	//Marks(%)/CGPA
	public static WebElement txt_cgpa(WebDriver driver)
	   {
	      element = driver.findElement(By.id("marksEdit"));
	      return element;
	   }
	
	//OK Button in Edit Educational Details Tab
	public static WebElement btn_ok_edu(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='eduEditModal']/div/form/div/div[2]/div/div/div[6]/button"));
	      return element;						 
	   }
	
	//Next Section Navigator
	public static WebElement btn_navigator_emp_details(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='EduDetails']/div[4]/div/div/a[2]"));
	      return element;						 
	   }
	
	/*
	 * *************************************************************************************************************************************
	 * 									 EMPLOYMENT DETAILS TAB PAGE ELEMENTS
	 * *************************************************************************************************************************************
	 */
	
	//Employment Details Link
	public static WebElement lnk_emp_details(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='EAFForm']/div[2]/div[1]/div/div[2]/ul/li[9]/a"));
	      return element;						 
	   }
	//Employment Details Heading Visibility
	public static WebElement lnk_emp_details_visi(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='EmplDetails']/h3"));
	      return element;						 
	   }
		
	//Add Employment Button
	public static WebElement btn_add_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='Button1']"));
	      return element;						 
	   }
	
	//Existing Employment Details Edit Link
	public static WebElement lnk_emp_details_edit(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='EmplDetails']/div[1]/div[1]/div[2]/div/div[4]/a[1]/img"));
	      return element;						 
	   }
	
	//Edit Employment
	//Current Employment Check Box
	public static WebElement chk_current_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='employmentModal']/div/form/div/div[2]/div/div/div[1]/div[1]/div[2]/label"));
	      return element;						 
	   }
	
	//Current Employment Check Box ICF
		public static WebElement chk_current_emp_icf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='employmentAddModal']/div/form/div/div[2]/div/div/div[1]/div[1]/div[2]/label"));
		      return element;						 
		   }
	
	//Company Name
	public static WebElement dd_comp_name(WebDriver driver)
	   {
	      element = driver.findElement(By.id("companyNameEdit"));
	      return element;						 
	   }
	
	//Company Name Input
	public static WebElement dd_comp_name_input(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='companyNameEdit']"));
	      return element;						 
	   }
	
	//Company Name Input Select
	public static WebElement dd_comp_name_input_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='employmentModal']/div/form/div/div[2]/div/div/div[1]/div[2]/div/ul/li[1]/a"));
	      return element;						 
	   }
	
	//companyName Others
	public static WebElement txt_comp_name_others(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id=\"otherCompanyNameEdit\"]"));
	      return element;						 
	   }
	
	//Company Name ICF
	public static WebElement dd_comp_name_icf(WebDriver driver)
	   {
	      element = driver.findElement(By.id("companyName"));
	      return element;						 
	   }
	
	//Get Text Company Name
	public static WebElement dd_comp_name_text_icf(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='employmentAddModal']/div/form/div/div[2]/div/div/div[1]/div[2]/div/ul/li/a/strong"));
	      return element;						 
	   }
	
	public static WebElement dd_comp_name_icf_input_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='employmentAddModal']/div/form/div/div[2]/div/div/div[1]/div[2]/div/ul/li[1]/a"));
	      return element;						 
	   }

	//Other Company Name
	public static WebElement txt_other_comp_name(WebDriver driver)
	   {
	      element = driver.findElement(By.name("otherCompanyName"));
	      return element;						 
	   }
	
	//Other Company Name
	public static WebElement txt_other_comp_name_icf(WebDriver driver)
	   {
	      element = driver.findElement(By.name("otherCompanyNameEdit"));
	      return element;						 
	   }
	
	//Designation/Position Held
	public static WebElement txt_designation(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='designationEdit']"));
	      return element;						 
	   }
	
	//Designation/Position Held ICF
		public static WebElement txt_designation_icf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='designation']"));
		      return element;						 
		   }
	
	//Employment Type 
	public static WebElement dd_emp_type(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='emplTYpeEdit']/div[1]/span"));
	      return element;						 
	   }
	
	public static WebElement dd_emp_type_input(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='emplTYpeEdit']/input[1]"));
	      return element;						 
	   }
	
	public static WebElement dd_emp_type_input_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='ui-select-choices-row-32-']/a/span"));
	      return element;						
	   }
	
	//Employment Type 
		public static WebElement dd_emp_type_icf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='emplTYpe']/div[1]/span"));
		      return element;						 
		   }
		
		public static WebElement dd_emp_type_icf_input(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='emplTYpe']/input[1]"));
		      return element;						 
		   }
		
		public static WebElement dd_emp_type_icf_input_select(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-26-']/a/span"));
		      return element;
		   }
	
	//Reported To (Name & Position & contact number)
	public static WebElement txt_reported_to(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='reportedToEdit']"));
	      return element;						 
	   }
	
	//Reported To (Name & Position & contact number) ICF
		public static WebElement txt_reported_to_icf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='reportedTo']"));
		      return element;						 
		   }
		
	//Address with Company Telephone
	public static WebElement txt_compaddress(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='addressEdit']"));
	      return element;						 
	   }
	
	//Address with Company Telephone ICF
		public static WebElement txt_compaddress_icf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='address']"));
		      return element;						 
		   }
	
	//Employment Period From
	public static WebElement txt_emp_period_from(WebDriver driver)
	   {
		  element = driver.findElement(By.xpath(".//*[@id='employmentFromEdit']"));
	      return element;						 
	   }
	
	//Employment Period From ICF
		public static WebElement txt_emp_period_from_icf(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath("//*[@id=\"employmentFrom\"]"));
		      return element;						 
		   }
	
	public static WebElement txt_emp_period_from1(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[1]/table/thead/tr[2]/th[2]"));
	      return element;						 
	   }
	
	
	public static WebElement txt_emp_period_from2(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[2]/table/thead/tr[2]/th[2]"));
	      return element;						 
	   }
	
	
	public static WebElement txt_emp_period_from3(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[3]/table/tbody/tr/td/span[7]"));
	      return element;						 
	   }
	
	
	public static WebElement txt_emp_period_from4(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[2]/table/tbody/tr/td/span[11]"));
	      return element;						 
	   }
	
	public static WebElement txt_emp_period_from5(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[1]/table/tbody/tr[5]/td[5]"));
	      return element;						 
	   }
	
	//Employment Period To
	public static WebElement txt_emp_period_to(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='employmentToEdit']"));
	      return element;						 
	   }
	
	//Employment Period To ICF
		public static WebElement txt_emp_period_to_icf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("//*[@id=\"employmentTo\"]"));
		      return element;						 
		   }
		
	public static WebElement txt_emp_period_to1(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[9]/div[1]/table/tbody/tr[1]/td[6]"));
	      return element;						 
	   }
	
	//Period selected cannot exceed gap of 1 year for 10th and 12th records Message
	public static WebElement txt_date_diff_static(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='eduEditModal']/div/form/div/div[2]/div/div/div[4]/div[2]/div/div/p[3]"));
	      return element;						 
	   }
	
	//SWF Period From and To
	public static WebElement txt_emp_period_from1s(WebDriver driver)
	   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[1]/table/thead/tr[2]/th[2]"));
		      return element;						 
		   }
		
		
		public static WebElement txt_emp_period_from2s(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[2]/table/thead/tr[2]/th[2]"));
		      return element;						 
		   }
		
		
		public static WebElement txt_emp_period_from3s(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[3]/table/tbody/tr/td/span[7]"));
		      return element;						 
		   }
		
		
		public static WebElement txt_emp_period_from4s(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[2]/table/tbody/tr/td/span[11]"));
		      return element;						 
		   }
		
		public static WebElement txt_emp_period_from5s(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[1]/table/tbody/tr[5]/td[5]"));
		      return element;						 
		   }
		
		//Employment Period To
		public static WebElement txt_emp_period_tos(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='employmentToEdit']"));
		      return element;						 
		   }
		
		//Employment Period To ICF
			public static WebElement txt_emp_period_to_icfs(WebDriver driver)
			   {
			      element = driver.findElement(By.xpath(".//*[@id='employmentTo']"));
			      return element;						 
			   }
			
		public static WebElement txt_emp_period_to1s(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[9]/div[1]/table/tbody/tr[1]/td[6]"));
		      return element;						 
		   }
	
	//Do You Have Employee code/Personnel no./Social Security no(Mandatory if worked in USA)? - BPO
	public static WebElement dd_emp_code(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='emplCodeYN']/div[1]/span"));
	      return element;						 
	   }
	
	//Do You Have Employee code/Personnel no./Social Security no(Mandatory if worked in USA)? Input - BPO
	public static WebElement dd_emp_code_input(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='emplCodeYN']/input[1]"));
	      return element;						 
	   }
	
	//Do You Have Employee code/Personnel no./Social Security no(Mandatory if worked in USA)? Input Select - BPO
	public static WebElement dd_emp_code_input_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id=\"ui-select-choices-row-28-\"]/a/span"));
	      return element;						 
	   }
	
	//Employee code/Personnel no./Social Security no(Mandatory if worked in USA)
	public static WebElement txt_emp_code(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='emplCodeEdit']"));
	      return element;						 
	   }
	 
	//Employee code/Personnel no./Social Security no(Mandatory if worked in USA) ICF
		public static WebElement txt_emp_code_icf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("//*[@id=\"emplCode\"]"));
		      return element;						 
		   }
	
	 //Last Drawn Salary (INR)
	public static WebElement txt_last_drawn(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='lastSalEdit']"));
	      return element;						 
	   }
	
	//Last Drawn Salary (INR) ICF
		public static WebElement txt_last_drawn_icf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='lastSal']"));
		      return element;						 
		   }
	
	//Do you have a PF A/C No.?
	public static WebElement dd_pf_ac(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='accPFEditYN']/div[1]/span"));
	      return element;						 
	   }
	
	public static WebElement dd_pf_ac_input(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='accPFEditYN']/input[1]"));
	      return element;						 
	   }
	
	public static WebElement dd_pf_ac_input_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='ui-select-choices-row-34-']/a/span"));
	      return element;						 
	   }
	
	//Do you have a PF A/C No.? BPO
		public static WebElement dd_pf_ac_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='accPFYN']/div[1]/span"));
		      return element;						 
		   }
		
		public static WebElement dd_pf_ac_input_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='accPFYN']/input[1]"));
		      return element;						 
		   }
		
		public static WebElement dd_pf_ac_input_select_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-28-']/a/span"));
		      return element;						 
		   }
	//PF A/C No.
	public static WebElement dd_pf_num(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='accPFEdit']"));
	      return element;						 
	   }
	
	//PF A/C No. ICF
		public static WebElement dd_pf_num_icf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("//*[@id=\"accPF\"]"));
		      return element;						 
		   }
		
	//Reason for Leaving
	public static WebElement dd_reason_for_leaving(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='reasonEdit']/div[1]/span"));
	      return element;						 
	   }
	
	//Reason for Leaving Input
	public static WebElement dd_reason_for_leaving_input(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='reasonEdit']/input[1]"));
	      return element;						 
	   }
	
	//Reason for Leaving Input Select
	public static WebElement dd_reason_for_leaving_input_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='ui-select-choices-row-35-']/a/span"));
	      return element;						 
	   }
	
	//Reason for Leaving ICF
		public static WebElement dd_reason_for_leaving_icf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='reason']/div[1]/span"));
		      return element;						 
		   }
		
		//Reason for Leaving Input ICF
		public static WebElement dd_reason_for_leaving_input_icf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='reason']/input[1]"));
		      return element;						 
		   }
		
		//Reason for Leaving Input Select ICF
		public static WebElement dd_reason_for_leaving_input_select_icf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("//*[@id='ui-select-choices-row-36-']/a/span"));
		      return element;						 
		   }
		
		//Reason for Leaving Input Select BPO
				public static WebElement dd_reason_for_leaving_input_select_bpo(WebDriver driver)
				   {
				      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-30-']/a/span"));
				      return element;						 
				   }
				
		
	//Other Reason for Leaving from the organization
		public static WebElement txt_other_reason_for_leaving(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='otherReason']"));
		      return element;						 
		   }	
		
		
		//Other Reason for Leaving from the organization
		public static WebElement txt_other_reason_for_leaving_icf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='otherReasonEdit']"));
		      return element;						 
		   }	
	
	//Mode of separation from the organization
	public static WebElement dd_mode_separation(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='seperationModeEdit']/div[1]/span"));
	      return element;						 
	   }
	
	//Mode of separation from the organization Input
	public static WebElement dd_mode_separation_input(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='seperationModeEdit']/input[1]"));
	      return element;						 
	   }
	
	//Mode of separation from the organization Input Select
	public static WebElement dd_mode_separation_input_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-36-']/a/span"));
	      return element;						 
	   }
	
	//Mode of separation from the organization ICF
		public static WebElement dd_mode_separation_icf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='seperationMode']/div[1]/span"));
		      return element;						 
		   }
		
		//Mode of separation from the organization Input ICF
		public static WebElement dd_mode_separation_input_icf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='seperationMode']/input[1]"));
		      return element;						 
		   }
		
		//Mode of separation from the organization Input Select ICF
		public static WebElement dd_mode_separation_input_select_icf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-30-']/a/span"));
		      return element;						 
		   }
		
		//Mode of separation from the organization Input Select BPO
				public static WebElement dd_mode_separation_input_select_bpo(WebDriver driver)
				   {
				      element = driver.findElement(By.xpath(".//*[@id='ui-select-choices-row-31-']/a/span"));
				      return element;						 	
				   }
	
	//Other Mode of separation from the organization
	public static WebElement txt_other_mode_sep(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='otherSeperationModeEdit']"));
	      return element;						 
	   }
	
	//Other Mode of separation from the organization ICF
		public static WebElement txt_other_mode_sep_icf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='otherSeperationMode']"));
		      return element;						 
		   }
		
	//OK Button
	public static WebElement btn_edit_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='employmentModal']/div/form/div/div[2]/div/div/div[5]/div[8]/button"));
	      return element;						 
	   }
	
	//OK Button ICF
		public static WebElement btn_edit_emp_icf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='employmentAddModal']/div/form/div/div[2]/div/div/div[5]/div[8]/button"));
		      return element;						 
		   }
	
	//Edit Employment Details Delete Link     
	public static WebElement btn_delete_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='EmplDetails']/div[1]/div[1]/div[2]/div/div[4]/a[2]/img"));
	      return element;						 
	   }
	
	//Reason for gap in experience(If any)
	public static WebElement txt_reason_for_gap(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='EmplDetails']/div[1]/div[2]/div/textarea"));
	      return element;						 
	   }
	
	//Completion Progress Bar
	public static WebElement txt_progress_bar(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='EAFForm']/div[1]/div/div/div/div"));
		return element;
		
	}
	
	
	/*
	 * *************************************************************************************************************************************
	 * 									 BUTTON ELEMENTS
	 * *************************************************************************************************************************************
	 */
	
	
	//Submit Button
	public static WebElement btn_submit(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='submitClick1']"));
	      return element;
	   }
		
	//Save As Draft Button
	public static WebElement btn_save_draft(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='saveClick1']"));
	      return element;
	   }
	
	//Submit EAF - LOA Alert - Agree Button	
	public static WebElement btn_agree_submiteaf(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("/html/body/div[8]/div/div/div[6]/button[1]"));
	      return element;
	   }		
	
	//Submit EAF =- LOA Alert - Cancel Button	
	public static WebElement btn_cancel_submiteaf(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("/html/body/div[8]/div/div/div[6]/button[2]"));
	      return element;
	   }
	
	//Sign Out Button - EAF Page
	public static WebElement btn_sign_out_eaf(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id=\"rightTopSection\"]/li/a"));
	      return element;
	   }
	
	
	
}
