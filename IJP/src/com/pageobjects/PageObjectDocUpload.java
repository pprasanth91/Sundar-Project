package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;

public class PageObjectDocUpload {

	private static WebElement element = null;
	
	
	/*
	 * ********************************* BPO Document Upload Page Objects*****************************************************
	 */
	
		//Upload Documents Link in IJP page
		public static WebElement lnk_doc_up_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.linkText("Upload Documents"));
		      return element;
		   }
		
		
		//Progress Bar
		public static WebElement img_progress_bar_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@class='progress']"));
		      return element;
		   }
		
		//Navigate to Frame inside the top window
				
		//Document Upload heading visibility
		public static WebElement visi_doc_upload_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@class='page-title' and text()='Documents Upload']"));
		      return element;
		   }
		
		
		//Let's Get Started Button BPO
		public static WebElement btn_lets_get_started_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//button[@class='btn btn-ice' and text()='LET’S GET STARTED']"));
		      return element;
		   }
		
		//Terms and Conditions Heading Visibility		
		public static WebElement visi_terms_and_cond_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@class='page-title' and text()='TERMS & CONDITIONS']"));
		      return element;
		   }
		
		//Agree Button		
		public static WebElement btn_agree_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//button[@class='btn btn-ice' and text()='AGREE']"));
		      return element;
		   }
		
		//Cancel Button
		public static WebElement btn_cancel_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//button[@class='btn btn-ice' and text()='CANCEL']"));
		      return element;
		   }
		
		//Upload Documents Heading visibility after clicking all required buttons
		public static WebElement visi_doc_up_page_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@class='page-title' and text()='Upload Documents']"));
		      return element;
		   }
		
		//Progress Bar inside the Document Upload Page		
		public static WebElement bar_progress_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@class='progress-bar']"));
		      return element;
		   }
		
		//Progress Bar % value inside the Document Upload Page
		public static WebElement value_percentage_progress_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("//*[@class='prof-message ng-binding']"));
		      return element;
		   }
		
		//ID Proof Documents
		
		//PAN Card
		public static WebElement lnk_pan_card_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.linkText("PAN Card"));
		      return element;
		   }
		
		//PAN Card Heading Visiblity
		public static WebElement visi_pan_card_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("//*[@id='contents']/div[2]/div[2]/div/div[4]/div/div/h3"));
		      return element;
		   }
		
		//+ button		
		public static WebElement btn_plus_pan_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//i[@class='acn-plus']"));
		      return element;
		   }
		
		//Invalid File Popup Ok Button
		public static WebElement btn_aadhar_invalid_file_ok_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[4]/div/div/div[3]/button"));
		      return element;
		   }
		
		//Invalid File Popup Message
		public static WebElement msg_aadhar_invalid_file_ok_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[4]/div/div/div[2]/p"));
		      return element;
		   }
		
		//Right now I do not have one Check Box
		public static WebElement chk_pan_i_dont_have_one_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@class='checkbox-custom-label' and text()='Right now I do not have one']"));
		      return element;
		   }
		
		//Yes Button - Right now I do not have one Check Box
		public static WebElement chk_pan_yes_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[4]/div/div/div[2]/div[1]"));
		      return element;
		   }
		
		//No Button - Right now I do not have one Check Box
		public static WebElement chk_pan_no_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[4]/div/div/div[2]"));
		      return element;
		   }
		
		//Upload the attached file(s) now
		public static WebElement btn_pan_upload_attached_files(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='uploadpancard']"));
		      return element;
		   }
		
		//Image Displayed
		public static WebElement img_image_pan_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='listpancopy']/div/img"));
		      return element;
		   }
		
		//Navigate to Next Section Aadhar Card		
		public static WebElement lnk_pan_next_section_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@class='next' and @aria-label='Next section']"));
		      return element;
		   }
		
				
		//Aadhar Card
		public static WebElement lnk_aadhar_card_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.linkText("Aadhar Card"));
		      return element;
		   }
		
		//Aadhar Card Heading Visiblity
		public static WebElement visi_aadhar_card_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("//*[@id='contents']/div[2]/div[2]/div/div[5]/div/div/h3"));
		      return element;
		   }
		
		//+ button		
		public static WebElement btn_plus_aadhar_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//i[@class='acn-plus']"));
			  return element;
		   }
				
		//Right now I do not have one Check Box
		public static WebElement chk_aadhar_i_dont_have_one_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@class='checkbox-custom-label' and text()='Right now I do not have one']"));
			  return element;
		   }
		
		//Yes Button - Right now I do not have one Check Box
		public static WebElement chk_aadhar_yes_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[4]/div/div/div[2]/div[1]"));
		      return element;
		   }
		
		//No Button - Right now I do not have one Check Box
		public static WebElement chk_aadhar_no_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[4]/div/div/div[2]"));
		      return element;
		   }	
		
		//Upload the attached file(s) now
		public static WebElement btn_aadhar_upload_attached_files(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='uploadaadharcard']"));
			  return element;
		   }
		
		//Upload In Progress Button
		public static WebElement btn_aadhar_upload_inprogress(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='processingdiv']"));
			  return element;
		   }
		
				
		//Image Displayed
		public static WebElement img_image_aadhar_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='listaadharcopy']/div/img"));
			  return element;
		   }
				
		//Navigate to Next Section Aadhar Card		
		public static WebElement lnk_aadhar_next_section_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[5]/div/div/div/div/div[2]/div/div/a[2]"));
		      return element;
		   }
		
		
		//Educational Documents
		
		//Highest Qualification
		public static WebElement lnk_high_qua_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.linkText("Highest Qualification"));
		      return element;
		   }
		
		//Highest Qualification Heading Visibility
		public static WebElement visi_high_qua_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@class='ng-binding' and text()='Highest Qualification']"));
		      return element;
		   }
		
		//Degree Certificate
		public static WebElement visi_deg_cert_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//span[@class='item-subtitle ng-binding ng-scope' and text()='Degree Certificate']"));
		      return element;
		   }
		
		//+ button for Degree Certificate		
		public static WebElement btn_plus_deg_cert_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='degreecertificate']/i"));
			  return element;
		   }
		
		//Final Semester Marksheet
		public static WebElement visi_final_sem_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//span[@class='item-subtitle ng-binding ng-scope' and text()='Final Semester Marksheet']"));
		      return element;
		   }
		
		//+ button for Final Semester Marksheet
		public static WebElement btn_plus_final_sem_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='finalsemestermarksheet']/i"));
			  return element;
		   }
		
		//Consolidated Marksheet
		public static WebElement visi_cons_marksheet_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//span[@class='item-subtitle ng-binding ng-scope' and text()='Consolidated Marksheet']"));
		      return element;
		   }
		
		//+ button for Consolidated Marksheet
		public static WebElement btn_plus_cons_marksheet_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='consolidatedmarksheet']/i"));
			  return element;
		   }
		
		//All Semester/Year Marksheet
		public static WebElement visi_allsem_marksheet_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//span[@class='item-subtitle ng-binding ng-scope' and text()='All Semester/Year Marksheet']"));
		      return element;
		   }
		
		//+ button for All Semester/Year Marksheet
		public static WebElement btn_plus_allsem_marksheet_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='allsemestermarksheets']/i"));
			  return element;
		   }
		
		//Provisional Degree Certificate
		public static WebElement visi_provisional_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//span[@class='item-subtitle ng-binding ng-scope' and text()='Provisional Degree Certificate']"));
		      return element;
		   }
		
		//+ button for Provisional Degree Certificate
		public static WebElement btn_plus_provisional_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='provisionalcertificate']/i"));
			  return element;
		   }
				
		//Upload the attached file(s) now
		public static WebElement btn_high_qua_upload_attached_files(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='uploadhighestqualification']"));
			  return element;
		   }
				
		//Image Displayed - Degree Certificate
		public static WebElement img_image_deg_cert_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='listdegreecertificate']/div/img"));
			  return element;
		   }
		
		//Image Displayed - Final Semester Marksheet
		public static WebElement img_image_final_sem_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='listfinalsemestermarksheet']/div/img"));
			  return element;
		   }
		
		//Image Displayed - Consolidated Marksheet
		public static WebElement img_image_cons_marksheet_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='listconsolidatedmarksheet']/div/img"));
			  return element;
		   }
		
		//Image Displayed - All Semester/Year Marksheet
		public static WebElement img_image_allsem_marksheet_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='listallsemestermarksheets']/div/img"));
			  return element;
		   }
		
		//Image Displayed - Provisional Degree Certificate
		public static WebElement img_image_provisional_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='listprovisionalcertificate']/div/img"));
			  return element;
		   }
		
		//Navigate to Next Section 12th Marksheet	
		public static WebElement lnk_high_qua_next_section_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[7]/div/div[6]/div/div/a[2]"));
		      return element;
		   }
		
		//12th Marksheet
		public static WebElement lnk_12th_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.linkText("12th Marksheet"));
		      return element;
		   }
		
		//12th Marksheet Heading Visi
		public static WebElement visi_12th_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[8]/div/h3"));
		      return element;
		   }
		
		//+ button		
		public static WebElement btn_plus_12th_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='xiithmarksheet']/i"));
			  return element;
		   }
				
		//Upload the attached file(s) now
		public static WebElement btn_12th_upload_attached_files(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='upload12thmarksheet']"));
			  return element;
		   }
				
		//Image Displayed
		public static WebElement img_image_12th_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='listxiithmarksheet']/div/img"));
			  return element;
		   }
		
		//Navigate to Next Section 12th Marksheet	
		public static WebElement lnk_12th_next_section_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[8]/div/div[2]/div/div/a[2]"));
		      return element;
		   }
		
		//10th Marksheet
		public static WebElement lnk_10th_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.linkText("10th Marksheet"));
		      return element;
		   }
		
		//10th Marksheet Heading Visibility
		public static WebElement visi_10th_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[9]/div/h3"));
		      return element;
		   }
		
		//+ button		
		public static WebElement btn_plus_10th_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='xthmarksheet']/i"));
			  return element;
		   }
				
		//Upload the attached file(s) now
		public static WebElement btn_10th_upload_attached_files(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='upload10thmarksheet']"));
			  return element;
		   }
				
		//Image Displayed
		public static WebElement img_image_10th_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='listxthmarksheet']/div/img"));
			  return element;
		   }
		
		//Navigate to Next Section 10th Marksheet	
		public static WebElement lnk_10th_next_section_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[9]/div/div[2]/div/div/a[2]"));
		      return element;
		   }
		
		//Employment Documents
		
		//I have no prior experience Check Box
		public static WebElement chk_prior_exp_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("//*[@id='contents']/div[2]/div[1]/div/div[2]/div[10]/label"));
		      return element;
		   }
		
		//Current/Most Recent Employment
		public static WebElement lnk_cur_emp_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.linkText("Current/Most Recent Employment"));
		      return element;
		   }
		
		//Current/Most Recent Employment Heading Visibility
		public static WebElement visi_cur_emp_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[10]/div/h3"));
		      return element;
		   }
		
		//+ Button
		public static WebElement btn_plus_recent_emp_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='currentorganizationsofferletter']/i"));
			  return element;
		   }
				
		//Upload the attached file(s) now
		public static WebElement btn_recent_emp_upload_attached_files(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='uploadcurrentmostrecentemployment']"));
			  return element;
		   }
				
		//Image Displayed
		public static WebElement img_image_recent_emp_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='listcurrentorganizationsofferletter']/div/img "));
			  return element;
		   }
		
		//Navigate to Next Section Compensation proof
		public static WebElement lnk_recent_emp_next_section_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[11]/div/div[2]/div/div/a[2]"));
		      return element;
		   }
				
		
		//Compensation Proof
		public static WebElement lnk_comp_proof_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.linkText("Compensation Proof"));
		      return element;
		   }

		//Compensation Proof Heading Visibility
		public static WebElement visi_comp_proof_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[12]/div/h3"));
		      return element;
		   }
		
		//+ Button
		public static WebElement btn_plus_comp_proof_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='payslip']/i"));
			  return element;
		   }
				
		//Upload the attached file(s) now
		public static WebElement btn_comp_proof_upload_attached_files(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='uploadcompensationproof']"));
			  return element;
		   }
				
		//Confirm Files to Upload
		
		//Yes Button
		public static WebElement btn_conf_files_yes(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@class='btn btn-ice ng-binding' and text()='Yes']"));
			  return element;
		   }
		
		//No Button
		public static WebElement btn_conf_files_no(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@class='btn btn-ice ng-binding' and text()='No']"));
			  return element;
		   }
		
		//Image Displayed
		public static WebElement img_image_comp_proof_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='listpayslip']/div/img"));
			  return element;
		   }
		
		//Navigate to Next Section Compensation Proof
		public static WebElement lnk_comp_proof_next_section_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[12]/div/div[2]/div/div/a[2]"));
		      return element;
		   }
		
		//Increment Letter
		public static WebElement lnk_incr_letter_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.linkText("Increment Letter"));
		      return element;
		   }
		
		//Increment Letter Heading Visibility
		public static WebElement visi_incre_letter_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[13]/div/h3"));
		      return element;
		   }
		
		//+ Button
		public static WebElement btn_plus_incre_letter_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='incrementletter']/i"));
			  return element;
		   }
				
		//Upload the attached file(s) now
		public static WebElement btn_incre_letter_upload_attached_files(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='uploadincrementletter']"));
			  return element;
		   }
		
		//Image Displayed
		public static WebElement img_image_incre_letter_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='listincrementletter']/div/img"));
			  return element;
		   }
		
		//Navigate to Next Section Increment Letter
		public static WebElement lnk_incre_letter_next_section_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[13]/div/div[2]/div/div/a[2]"));
		      return element;
		   }
		
		//Last Working Day Proof
		public static WebElement lnk_last_wrk_day_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.linkText("Last Working Day Proof"));
		      return element;
		   }
		
		//Last Working Day Proof Heading Visibility
		public static WebElement visi_last_wrk_day_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[14]/div/h3"));
		      return element;
		   }
		
		//+ Button
		public static WebElement btn_plus_last_wrk_day_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='lastworkingdayproof']/i"));
			  return element;
		   }
				
		//Upload the attached file(s) now
		public static WebElement btn_last_wrk_day_upload_attached_files(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='uploadlastworkingdayproof']"));
			  return element;
		   }
		
		//Image Displayed
		public static WebElement img_image_last_wrk_day_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='listlastworkingdayproof']/div/img"));
			  return element;
		   }
		
		//Navigate to Next Section Compensation Proof
		public static WebElement lnk_last_wrk_day_next_section_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[14]/div/div[2]/div/div/a[2]"));
		      return element;
		   }
		
		//Previous Employment
		public static WebElement lnk_prev_emp_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.linkText("Previous Employment"));
		      return element;
		   }
		
		//Previous Employment Heading Visibility
		public static WebElement visi_prev_emp_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[16]/div/h3"));
		      return element;
		   }
		
		//+ Button - Relieving Letter OR Experience Letter 
		public static WebElement btn_plus_exp_letter_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='relievingletterorexperienceletter']/i"));
			  return element;
		   }
		
		//+ Button - Last Employer Offer Letter
		public static WebElement btn_plus_last_off_letter_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='lastemployerofferletter']/i"));
			  return element;
		   }
		
		//Upload the attached file(s) now
		public static WebElement btn_prev_emp_upload_attached_files(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='uploaduploaddocumentsforhdconstruction']"));
			  return element;
		   }
		
		//Image Displayed
		public static WebElement img_image_exp_letter_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='listrelievingletterorexperienceletter']/div/img"));
			  return element;
		   }
		
		//Image Displayed
		public static WebElement img_image_last_off_letter_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='listlastemployerofferletter']/div/img"));
			  return element;
		   }
				
		//Navigate to Next Section Previous Employment
		public static WebElement lnk_prev_emp_next_section_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[16]/div/div[3]/div/div/a[2]"));
		      return element;
		   }		
		
		//Other Previous Employment
		public static WebElement lnk_other_prev_emp_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.linkText("Other Previous Employment"));
		      return element;
		   }
		
		//Other Previous Employment Heading Visibility
		public static WebElement visi_other_prev_emp_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[17]/div/h3"));
		      return element;
		   }
		
		//+ Button
		public static WebElement btn_plus_other_prev_emp_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='otherpreviousemployment']/i"));
			  return element;
		   }
				
		//Upload the attached file(s) now
		public static WebElement btn_other_prev_emp_upload_attached_files(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='uploadotherpreviousemployment']"));
			  return element;
		   }
		
		//Image Displayed
		public static WebElement img_image_other_prev_emp_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='listotherpreviousemployment']/div/img"));
			  return element;
		   }
		
		//Navigate to Next Section Passport
		public static WebElement lnk_passport_next_section_bpo(WebDriver driver)
			{
				element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[17]/div/div[2]/div/div/a[2]"));
				return element;
			}	
		
		//Passport Heading Visibility
		public static WebElement visi_passport_bpo(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[18]/div/h3"));
		      return element;
		   }
		
		//+ Button
		public static WebElement btn_plus_passport_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='passportcopy']/i"));
			  return element;
		   }
		
		//Upload the attached file(s) now
		public static WebElement btn_passport_upload_attached_files(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='uploadpassport']"));
			  return element;
		   }
		
		//Image Displayed
		public static WebElement img_image_passport_bpo(WebDriver driver)
		   {
			  element = driver.findElement(By.cssSelector("#listpassportcopy > div > img"));
			  return element;
		   }
		
		
		//Navigate to Next Section PIO/OCI Card
				public static WebElement lnk_pio_next_section_bpo(WebDriver driver)
					{
						element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[18]/div/div[2]/div/div/a[2]"));
						return element;
					}	
				
				//PIO Heading Visibility
				public static WebElement visi_pio_bpo(WebDriver driver)
				   {
				      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[18]/div/h3"));
				      return element;
				   }
				
				//+ Button
				public static WebElement btn_plus_pio_bpo(WebDriver driver)
				   {
					  element = driver.findElement(By.xpath(".//*[@id='pioocicardcopy']/i"));
					  return element;
				   }
				
				//Upload the attached file(s) now
				public static WebElement btn_pio_upload_attached_files(WebDriver driver)
				   {
					  element = driver.findElement(By.xpath(".//*[@id='uploadpioocicard']"));
					  return element;
				   }
				
				//Image Displayed
				public static WebElement img_image_pio_bpo(WebDriver driver)
				   {
					  element = driver.findElement(By.xpath(".//*[@id='listpioocicardcopy']/div/img"));
					  return element;
				   }
				
			//Navigate to Next Section Voter ID
			public static WebElement lnk_voter_id_next_section_bpo(WebDriver driver)
			{
				element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[19]/div/div[2]/div/div/a[2]"));
				return element;
			}	
			
			//Passport Heading Visibility
			public static WebElement visi_voter_id_bpo(WebDriver driver)
			   {
			      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[20]/div/h3"));
			      return element;
			   }
			
			//+ Button
			public static WebElement btn_plus_voter_id_bpo(WebDriver driver)
			   {
				  element = driver.findElement(By.xpath(".//*[@id='voteridcopy']/i"));
				  return element;
			   }
			
			//Upload the attached file(s) now
			public static WebElement btn_voter_id_upload_attached_files(WebDriver driver)
			   {
				  element = driver.findElement(By.xpath(".//*[@id='uploadvoterid']"));
				  return element;
			   }
			
			//Image Displayed
			public static WebElement img_image_voter_id_bpo(WebDriver driver)
			   {
				  element = driver.findElement(By.xpath(".//*[@id='listvoteridcopy']/div/img"));
				  return element;
			   }
			
			//Navigate to Next Section Citizenship Certificate
			public static WebElement lnk_citizenship_certificate_next_section_bpo(WebDriver driver)
			{
				element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[20]/div/div[2]/div/div/a[2]"));
				return element;
			}	
			

			//Citizenship Certificate Heading Visibility
			public static WebElement visi_citi_id_bpo(WebDriver driver)
			   {
			      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[21]/div/h3"));
			      return element;
			   }
			
			//+ Button
			public static WebElement btn_plus_citi_bpo(WebDriver driver)
			   {
				  element = driver.findElement(By.xpath(".//*[@id='citizenshipcertificatecopy']/i"));
				  return element;
			   }
			
			//Upload the attached file(s) now
			public static WebElement btn_citi_upload_attached_files(WebDriver driver)
			   {
				  element = driver.findElement(By.xpath(".//*[@id='uploadcitizenshipcertificate']"));
				  return element;
			   }
			
			//Image Displayed
			public static WebElement img_image_citi_bpo(WebDriver driver)
			   {
				  element = driver.findElement(By.xpath(".//*[@id='listcitizenshipcertificatecopy']/div/img"));
				  return element;
			   }
			
			//Navigate to Next Section Work Permit
			public static WebElement lnk_work_permit_next_section_bpo(WebDriver driver)
			{
				element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[21]/div/div[2]/div/div/a[2]"));
				return element;
			}	
			
			
			
		//Work Permit Heading Visibility
			public static WebElement visi_work_permit_bpo(WebDriver driver)
			   {
			      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[21]/div/h3"));
			      return element;
			   }
			
			//+ Button
			public static WebElement btn_plus_work_permit_bpo(WebDriver driver)
			   {
				  element = driver.findElement(By.xpath(".//*[@id='workpermitcopy']/i"));
				  return element;
			   }
			
			//Upload the attached file(s) now
			public static WebElement btn_work_permit_upload_attached_files(WebDriver driver)
			   {
				  element = driver.findElement(By.xpath(".//*[@id='uploadworkpermit']"));
				  return element;
			   }
			
			//Image Displayed
			public static WebElement img_image_work_permit_bpo(WebDriver driver)
			   {
				  element = driver.findElement(By.xpath(".//*[@id='listworkpermitcopy']/div/img"));
				  return element;
			   }
			
			//Navigate to Next Section Work Permit
			public static WebElement lnk_coc_next_section_bpo(WebDriver driver)
			{
				element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[22]/div/div[2]/div/div/a[2]"));
				return element;
			}	
			
			
		//Certificate of Coverage Heading Visibility
			public static WebElement visi_coc_bpo(WebDriver driver)
			   {
			      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[23]/div/h3"));
			      return element;
			   }
			
			//+ Button
			public static WebElement btn_plus_coc_bpo(WebDriver driver)
			   {
				  element = driver.findElement(By.xpath(".//*[@id='certificateofcoveragecopy']/i"));
				  return element;
			   }
			
			//Upload the attached file(s) now
			public static WebElement btn_coc_upload_attached_files(WebDriver driver)
			   {
				  element = driver.findElement(By.xpath(".//*[@id='uploadcertificateofcoverage']"));
				  return element;
			   }
			
			//Image Displayed
			public static WebElement img_image_coc_bpo(WebDriver driver)
			   {
				  element = driver.findElement(By.xpath(".//*[@id='listcertificateofcoveragecopy']/div/img"));
				  return element;
			   }
			
			
				
		/*
		 * ICF/ICO Entity Document Upload Page Elements
		 */		
		
		//Candidate documents upload Heading Visibility
		public static WebElement visi_docs_upload_icf(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='divdocupload']/section/h2"));
			  return element;
		   }
		
		//Document Type Dropdown
		public static WebElement dd_doc_type_icf(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ddlDocType']"));
			  return element;
		   }
		
		//Document Type Dropdown List
		public static WebElement dd_doc_type_list_icf(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ddlDocType']/option"));
			  return element;
		   }
		
		//Browse Button		
		public static WebElement btn_browse_icf(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='fileupload']"));
			  return element;
		   }
		
		//Comments Text Box		
		public static WebElement txt_comments_icf(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='txtComments']"));
			  return element;
		   }
				
		//Document Upload Complete Check Box
		public static WebElement chk_doc_upload_comp_icf(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='lblICFDocUploadComplete']"));
			  return element;
		   }
		
		//Save Button		
		public static WebElement btn_save_icf(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='ibtnSave']"));
			  return element;
		   }
		
		//List of candidate document uploaded Grid
		public static WebElement visi_doc_list(WebDriver driver)
		   {
			  element = driver.findElement(By.xpath(".//*[@id='divList']/h2"));
			  return element;
		   }
		
		
		/*
		 * *****************************************SWF Document Upload Page Elements**********************************************
		 */
		
		
		//Upload Documents Hyperlink
		public static WebElement lnk_upload_docs_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//a[@href=\"#/uploadDoc\"]"));
		      return element;
		   }
		
		//Document Upload heading visibility
		public static WebElement visi_doc_upload_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@class='page-title' and text()='Documents Upload']"));
			  return element;
		   }
		
		//Let's Get Started Button SWF
		public static WebElement btn_lets_get_started_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//button[@class='btn btn-ice']"));
		      return element;
		   }
		
		//Terms and Conditions Heading Visibility
		public static WebElement visi_terms_cond_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@class='page-title' and text()='Terms & Conditions']"));
		      return element;
		   }
		
		//Agree Button		
		public static WebElement btn_agree_terms_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//button[@class='btn btn-ice' and text()='AGREE']"));
		      return element;
		   }
		
		//Cancel Button
		public static WebElement btn_cancel_terms_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//button[@class='btn btn-ice' and text()='CANCEL']"));
		      return element;
		   }
		
		//PAN Card Heading Visibility		
		public static WebElement visi_PAN_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@class='ng-binding' and text()='PAN Card']"));
		      return element;
		   }
		
		//PAN Card Link
		public static WebElement lnk_PAN_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.linkText(" PAN Card"));
		      return element;
		   }
		
		//+ Button in Pan Card		
		public static WebElement btn_plus_PAN_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//i[@class='acn-plus']"));
		      return element;
		   }
		
		//Image After Attaching the File
		public static WebElement img_attach_pan_swf(WebDriver driver)
		{
			element = driver.findElement(By.xpath(".//*[@id='imgpancopy0']"));
			return element;			
		}
		
		//Go back to Attach File Page
		public static WebElement lnk_go_back_pan_swf(WebDriver driver)
		{
			element = driver.findElement(By.xpath(".//a[@class='acn-angle-left' and text()='Go Back']"));
			return element;							
		}
				
		//Pan Card Heading Visibility
		public static WebElement visi_pan_copy_swf(WebDriver driver)
		{
			element = driver.findElement(By.xpath(".//h5[@class='ng-binding' and text()='PAN Copy']"));
			return element;			
		}
		
		//Edit the attached file
		public static WebElement btn_edit_pan_attach_swf(WebDriver driver)
		{
			element = driver.findElement(By.xpath(".//*[@id='0']"));
			return element;			
		}
		
		//Delete the attached file
		public static WebElement btn_delete_pan_attach_swf(WebDriver driver)
		{
			element = driver.findElement(By.xpath(".//*[@id='A1']"));
			return element;			
		}
		
		//Upload the attached files now
		public static WebElement btn_upload_PAN_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='uploadpancard']"));
		      return element;
		   }
		
		//Image Displayed
		public static WebElement img_image_pan_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='listpancopy']/div/img"));
		      return element;
		   }
		//Next Section Navigator
		public static WebElement lnk_nxt_session_pan_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//a[@class='next' and @aria-label='Next section']"));
		      return element;
		   }
		
		//Confirm
		//Have you selected all the files you wish to Upload?
		//Yes Button
		public static WebElement btn_yes_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[4]/div/div/div[2]/div[1]"));
		      return element;
		   }
		
		//No Button
		public static WebElement btn_no_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/div[4]/div/div/div[2]/div[3]"));
		      return element;
		   }
		
		
		//Aadhar Card
		public static WebElement lnk_aadhar_card_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.linkText("Aadhar Card"));
		      return element;
		   }
		
		//Aadhar Card Heading Visibility
		public static WebElement visi_aadhar_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[4]/div/div/h3"));
		      return element;
		   }
		
		//+ Button in Aadhar Card
		public static WebElement btn_plus_aadhar_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//i[@class='acn-plus']"));
		      return element;
		   }
		
		//Right now I do not have one Check Box
		public static WebElement chk_i_dnt_have_aadhar_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='aadharspanaadharcard']/label"));
		      return element;
		   }
		
		//Upload the attached Files now
		public static WebElement btn_upload_aadhar_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='uploadaadharcard']"));
		      return element;
		   }
		
		//Image Displayed
		public static WebElement img_image_aadhar_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='listaadharcopy']/div/img"));
		      return element;
		   }
		
		//Next Section Navigator
		public static WebElement lnk_nxt_session_aadhar_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[4]/div/div/div/div/div[2]/div/div/a[2]"));
		      return element;
		   }
		
		//Current Employment Details Heading Visibility
		public static WebElement visi_current_emp_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[5]/div/h3"));
		      return element;
		   }
		
		//+ Button in Current Employment Details
		public static WebElement btn_plus_current_emp_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='currentorganizationsofferletter']/i"));
		      return element;
		   }
		
		//Upload the attached files now
		public static WebElement btn_upload_current_emp_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='uploadcurrentemploymentdetails']"));
		      return element;
		   }
		
		//Image Displayed
		public static WebElement img_image_current_emp_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='listcurrentorganizationsofferletter']/div/img"));
		      return element;
		   }
		
		//Next Section Navigator
		public static WebElement lnk_nxt_session_current_emp_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[5]/div/div[2]/div/div/a[2]"));
		      return element;
		   }
		
		//Last 3 Payslips Heading Visibility
		public static WebElement visi_payslips_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[5]/div/h3"));
		      return element;
		   }
		
		//+ Button in Current Employment Details
		public static WebElement btn_plus_payslips_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='payslip']/i"));
		      return element;
		   }
		
		//Upload the attached files now
		public static WebElement btn_upload_payslips_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='uploadlast3payslips']"));
		      return element;
		   }
		
		//Image Displayed
		public static WebElement img_image_3payslips_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='listpayslip']/div/img"));
		      return element;
		   }
		
		//Next Section Navigator
		public static WebElement lnk_nxt_session_payslips_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[6]/div/div[2]/div/div/a[2]"));
		      return element;
		   }
		
		//Increment Letter Heading Visibility
		public static WebElement visi_incre_letter_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[7]/div/h3"));
		      return element;
		   }
		
		//+ Button in Current Employment Details
		public static WebElement btn_plus_incre_letter_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='incrementletter']/i"));
		      return element;
		   }
		
		//Upload the attached files now
		public static WebElement btn_upload_incre_letter_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='uploadincrementletter']"));
		      return element;
		   }
		
		//Image Displayed
		public static WebElement img_image_increment_letter_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='listincrementletter']/div/img"));
		      return element;
		   }
		
		//Next Section Navigator
		public static WebElement lnk_nxt_session_incre_letter_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[7]/div/div[2]/div/div/a[2]"));
		      return element;
		   }
		
		//Immediate Last Employment Heading Visibility
		public static WebElement visi_immi_last_emp_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[8]/div/h3"));
		      return element;
		   }
		
		//No Previous work experience other than current employment
		public static WebElement chk_no_work_exp_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[8]/div/span/label"));
		      return element;
		   }
		
		//Relieving Letter + Button
		public static WebElement btn_plus_relieving_letter_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='relievingletter']/i"));
		      return element;
		   }
		
		//Experience Letter + Button
		public static WebElement btn_plus_experience_letter_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='experienceletter']/i"));
		      return element;
		   }
		
		//Upload the attached files now
		public static WebElement btn_upload_immi_last_emp_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='uploadimmediatelastemployment']"));
		      return element;
		   }
		
		//Image Displayed
		public static WebElement img_image_relieving_letter_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='listrelievingletter']/div/img"));
		      return element;
		   }
		
		//Image Displayed
		public static WebElement img_image_experience_letter_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='listexperienceletter']/div/img"));
		      return element;
		   }
		
		
		//Next Section Navigator
		public static WebElement lnk_nxt_session_immi_last_emp_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[8]/div/div[3]/div/div/a[2]"));
		      return element;
		   }
		
		//Photo ID with Address Proof Heading Visibility
		public static WebElement visi_photo_id_address_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[9]/div/h3"));
		      return element;
		   }
		
		//Voter ID Copy + Button
		public static WebElement btn_plus_voterid_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='voteridcopy']/i"));
		      return element;
		   }
		
		//Driving License copy + Button
		public static WebElement btn_plus_drive_license_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='drivinglicensecopy']/i"));
		      return element;
		   }
		
		//Passport Copy copy + Button
		public static WebElement btn_plus_passport_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='passportcopy']/i"));
		      return element;
		   }
		
		//Upload the attached files now
		public static WebElement btn_upload_photo_id_address_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='uploadphotoidwithaddressproof']"));
		      return element;
		   }
		
		//Image Displayed - Voter ID Copy
		public static WebElement img_image_voterid_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='listvoteridcopy']/div/img"));
		      return element;
		   }
		
		//Image Displayed - Driving License copy
		public static WebElement img_image_driving_license_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='listdrivinglicensecopy']/div/img"));
		      return element;
		   }
		
		//Image Displayed - Passport Copy
		public static WebElement img_image_passport_swf(WebDriver driver) 
		   {
		      element = driver.findElement(By.xpath(".//*[@id='listpassportcopy']/div/img"));
		      return element;
		   }
		
		//Next Section Navigator
		public static WebElement lnk_nxt_session_photo_id_address_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[9]/div/div[4]/div/div/a[2]"));
		      return element;
		   }
		
		//Highest Full Time Qualification Heading Visibility
		public static WebElement visi_high_full_qua_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[10]/div/h3"));
		      return element;
		   }
		
		//Degree Certificate + Button
		public static WebElement btn_plus_deg_certif_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='degreecertificate']/i"));
		      return element;
		   }
		
		//Driving License copy + Button
		public static WebElement btn_plus_final_sem_marksheet_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='finalsemestermarksheet']/i"));
		      return element;
		   }
		
		//Passport Copy + Button
		public static WebElement btn_plus_provisional_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='provisionalcertificate']/i"));
		      return element;
		   }
		
		//All Semester Marksheets + Button
		public static WebElement btn_plus_all_sem_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='allsemestermarksheets']/i"));
		      return element;
		   }
				
		//Upload the attached files now
		public static WebElement btn_upload_high_ful_qua_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='uploadhighestfulltimequalification']"));
		      return element;
		   }
		
		//Image Displayed - Degree Certificate
		public static WebElement img_image_deg_certificate_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='listdegreecertificate']/div/img"));
		      return element;
		   }
		
		//Image Displayed - Final Semester Mark Sheet
		public static WebElement img_image_final_sem_marksheet_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='listfinalsemestermarksheet']/div/img"));
		      return element;
		   }
		
		//Image Displayed - Provisional Certificate
		public static WebElement img_image_provisional_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='listprovisionalcertificate']/div/img"));
		      return element;
		   }
		
		//Image Displayed - All Semester Marksheets
		public static WebElement img_image_allsem_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='listallsemestermarksheets']/div/img"));
		      return element;
		   }
		
		//Next Section Navigator
		public static WebElement lnk_nxt_session_high_ful_qua_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[10]/div/div[5]/div/div/a[2]"));
		      return element;
		   }
		
		//Letter of Authorization Heading Visibility
		public static WebElement visi_letter_auth_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[2]/div/div[11]/div/h3"));
		      return element;
		   }
		
		//Degree Certificate + Button
		public static WebElement btn_plus_letter_auth_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='letterofauthorization']/i"));
		      return element;
		   }
		
		//Upload the attached files now
		public static WebElement btn_upload_loa_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='uploadletterofauthorization']"));
		      return element;
		   }
		
		//Image Displayed - Degree Certificate
		public static WebElement img_image_loa_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='listletterofauthorization']/div/img"));
		      return element;
		   }
		
		//Clicking the Ok Button and the thank you message displaying
		public static WebElement txt_thanks_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@class='tc-head ng-binding' and text()='Thank You']"));
		      return element;
		   }
		
		//Thanks Message OK Button
		public static WebElement btn_ok_thanks_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.cssSelector("body > div.modal.fade.ng-isolate-scope.docUpload.in > div > div > div.modal-body.ng-scope > div > button"));
		      return element;
		   }
		
		//Logout Button
		public static WebElement btn_logout_swf(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("//*[@id=\"rightTopSection\"]/li/a"));
		      return element;
		   }
		
		
} 
