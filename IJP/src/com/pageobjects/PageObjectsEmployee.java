package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectsEmployee {

	private static WebElement element = null;	

	/*
	 * ********************************* Agency Page Objects*****************************************************
	 */
	
	//Welcome to Talent Scout - now providing more career opportunities
	public static WebElement visi_welcome_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='block-accenturecareers']/div/div/div/section/div[2]/h2"));
	      return element;
	   }
	
	//Home Hyperlink
	public static WebElement lnk_home_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Home"));
	      return element;
	   }
	
	//Manage Hot Jobs Hyperlink
	public static WebElement lnk_manage_hot_jobs_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Manage Hot Jobs"));
	      return element;
	   }
	
	//Reports Hyperlink
	public static WebElement lnk_reports_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Reports"));
	      return element;
	   }
	
	//Campaign Reports Hyperlink
	public static WebElement lnk_campaign_reports_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Campaign Reports"));
	      return element;
	   }
	
	//User Management Hyperlink
	public static WebElement lnk_user_management_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("User Management"));
	      return element;
	   }
	
	//Search Admin User Hyperlink
	public static WebElement lnk_search_admin_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Search Admin User"));
	      return element;
	   }
	
	//Search Roles Hyperlink
	public static WebElement lnk_search_roles_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Search Roles"));
	      return element;
	   }
	
	//Manage Profile Hyperlink
	public static WebElement lnk_manage_profile_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Manage Profile"));
	      return element;
	   }
	
	//Search Candidate Profile Hyperlink
	public static WebElement lnk_srch_cand_prof_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Search Candidate Profile"));
	      return element;
	   }
	
	//Search Agency Profile Hyperlink
	public static WebElement lnk_srch_agency_prof_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Search Agency Profile"));
	      return element;
	   }
	
	//Reset Password Hyperlink
	public static WebElement lnk_reset_password_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Reset Password"));
	      return element;
	   }
	
	//Email Hyperlink
	public static WebElement lnk_email_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Email"));
	      return element;
	   }
	
	//View Email Content Hyperlink
	public static WebElement lnk_view_email_cont_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("View Email Content"));
	      return element;
	   }
	
	//Master Hyperlink
	public static WebElement lnk_master_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Master"));
	      return element;
	   }
	
	//Search Source Hyperlink
	public static WebElement lnk_srch_source_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Search Source"));
	      return element;
	   }
	
	//Search Event hyperlink	
	public static WebElement lnk_srch_event_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Search Event"));
	      return element;
	   }
	
	//Search Admin Updates Hyperlink
	public static WebElement lnk_srch_admin_updates_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Search Admin Updates"));
	      return element;
	   }
	
	//Queries Hyperlink
	public static WebElement lnk_queries_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Queries"));
	      return element;
	   }
	
	//Search Queries Hyperlink
	public static WebElement lnk_search_queries_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Search Queries"));
	      return element;
	   }
	
	//View Export Results Hyperlink
	public static WebElement lnk_export_results_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("View Export Results"));
	      return element;
	   }
	
	//Query Management Heading Visibility
	public static WebElement visi_query_manage_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@class='page-title' and text()='Query Management']"));
	      return element;
	   }
	
	//Filter By:
	
	//ENTITY Dropdown 
	public static WebElement dd_entity_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='EntityTitle']/div[1]/span"));
	      return element;
	   }
	
	//Entity Dropdown List
	public static WebElement dd_entity_list_emp(WebDriver driver)
	   {
	      element = (WebElement) driver.findElements(By.xpath(".//*[@id='EntityTitle']/ul/li/div"));
	      return element;
	   }
	
	//CATEGORY Dropdown
	public static WebElement dd_cate_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='IncAdmCtgryTitle']/div[1]/span/span[1]"));
	      return element;
	   }
	
	//CATEGORY Dropdown List
	public static WebElement dd_cate_list_emp(WebDriver driver)
	   {
	      element = (WebElement) driver.findElements(By.xpath(".//*[@id='IncAdmCtgryTitle']/ul/li/div"));
	      return element;
	   }
	
	//Status Dropdown
	public static WebElement dd_status_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='IncAdmStsTitle']/div[1]/span/span[1]"));
	      return element;
	   }
	
	//Status Dropdown List
	public static WebElement list_status_emp(WebDriver driver)
	   {
	      element = (WebElement) driver.findElements(By.xpath(".//*[@id='IncAdmStsTitle']/ul/li/div"));
	      return element;
	   }
	
	
	//CREATED BY TextBox
	public static WebElement txt_created_by_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='txtcreatedby']"));
	      return element;
	   }
	
	//BY DATE RANGE Calender Range
	public static WebElement btn_date_range_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='dob']"));
	      return element;
	   }
	
	//From Input Date
	public static WebElement txt_date_from_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[3]/div[1]/div[1]/input"));
	      return element;
	   }
	
	//To Input Date
	public static WebElement txt_date_to_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[3]/div[2]/div[1]/input"));
	      return element;
	   }
	
	//Clicking Outside the Date Input box
	public static WebElement visi_outside_date_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/section/div[1]/div/div/div[1]/div[5]"));
	      return element;
	   }
	
	
	//Previous Navigator Button
	public static WebElement btn_prev_navig_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//i[@class='fa fa-chevron-left glyphicon glyphicon-chevron-left']"));
	      return element;
	   }
	
	//Next Navigator Button
	public static WebElement btn_next_navig_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//i[@class='fa fa-chevron-right glyphicon glyphicon-chevron-right']"));
	      return element;
	   }
	
	//Fetch Month in Calendar
	public static WebElement txt_month_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/div[3]/div[1]/div[2]/table/thead/tr[1]/th[2]"));
	      return element;
	   }	
	
	
	//SLA Breach Dropdown
	public static WebElement dd_sla_breach_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='slabreach']/div[1]/span/span[1]"));
	      return element;
	   }
		
	//SLA Breach Dropdown List
	public static WebElement list_sla_breach_emp(WebDriver driver)
	   {
	      element = (WebElement) driver.findElements(By.xpath(".//*[@id='slabreach']/ul/li/div"));
	      return element;
	   }
	
	//IG Dropdown
	public static WebElement dd_ig_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ig']/div[1]/span/span[1]"));
	      return element;
	   }
	
	//IG Dropdown List
	public static WebElement dd_ig_list_emp(WebDriver driver)
	   {
	      element = (WebElement) driver.findElements(By.xpath(".//*[@id='ig']/ul/li/div"));
	      return element;
	   }
	
	//CID TextBox	
	public static WebElement txt_CID_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='txtCID']"));
	      return element;
	   }
	
	//Incident Number Text Box
	public static WebElement txt_incident_num_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='txtINC']"));
	      return element;
	   }
	
	//Clear Button
	public static WebElement btn_clear_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//button[@class='btn btn-ice' and text()='Clear']"));
	      return element;
	   }
	
	//Search Button
	public static WebElement btn_search_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//button[@class='btn btn-ice' and text()='Search']"));
	      return element;
	   }
	
	//Open Queries Hyperlink	
	public static WebElement lnk_open_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/section/div[2]/div/div/ul/li[1]/a"));
	      return element;
	   }
	
	//Responded Queries Hyperlink
	public static WebElement lnk_responded_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/section/div[2]/div/div/ul/li[2]/a"));
	      return element;
	   }
	
	//Closed Queries Hyperlink
	public static WebElement lnk_closed_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/section/div[2]/div/div/ul/li[3]/a"));
	      return element;  
	   }
	
	//First Query Answer Hyperlink	
	public static WebElement lnk_first_query_ans_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("html/body/section/div[2]/div/div/div/div[1]/a/h2"));
	      return element;  
	   }
	
	//Incident No : Visibility in Response Query Popup
	public static WebElement visi_inci_num_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentAdminModal']/div/div/div[1]/h2"));
	      return element;  
	   }
	
	//Message.. Text Box
	public static WebElement txt_message_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentAdminModal']/div/div/div[2]/div/div/div/div/div/div/div[2]/textarea"));
	      return element;  
	   }
	
	//Post Button
	public static WebElement btn_post_message_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//button[@class='btn btn-ice' and text()='Post']"));
	      return element;  
	   }
	
	//Close the current Query Opened Popup
	public static WebElement btn_close_query_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentAdminModal']/div/div/div[1]/button"));
	      return element;  
	   }
	
	//Export to Queue Button
	public static WebElement btn_export_to_queue_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//button[@class='btn btn-ice' and text()='Export to Queue']"));
	      return element;  
	   }
	
	//View Export Results Heading Visibility
	public static WebElement visi_export_results_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_lblViewExportResults']"));
	      return element;
	   }
	
	//Queued From Calendar Button
	public static WebElement btn_que_from_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtSentAfter']"));
	      return element;
	   }
	
	//Queued From Calendar Select Date
	public static WebElement btn_que_from_date_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_calExtSentAter_today']"));
	      return element;
	   }
	
	//Queued From Calendar Clear Button
	public static WebElement btn_que_from_clear_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_img_ClearSentAfter']"));
	      return element;
	   }	
	
	//Queued To Calendar button
	public static WebElement btn_que_to_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_txtSentBefore']"));
	      return element;
	   }
	
	//Queued From Calendar Select Date
	public static WebElement btn_que_to_date_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_calExtSentBefore_today']"));
	      return element;
	   }
	
	//Queued To Calendar Clear button
	public static WebElement btn_que_to_clear_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_img_ClearSentBefore']"));
	      return element;
	   }
	
	//Calendar clicked outside	
	public static WebElement visi_calendar_export_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_Searchqueryblock']/div[2]"));
	      return element;
	   }
	
	//Search Button in View Export Results Page
	public static WebElement btn_search_exp_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_imgBtnSearch']"));
	      return element;
	   }
	
	//Search Results Heading Visibility
	public static WebElement visi_search_results_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_lblSearchResults']"));
	      return element;
	   }
	
	//Download Hyperlink
	public static WebElement lnk_download_export_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_Main_gvwSearchResults_ctl02_lbtFileName']"));
	      return element;
	   }
	
	
	//Logout Hyperlink
	public static WebElement lnk_logout_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_LoginStatus1']"));
	      return element;
	   }
	
	//Contact Us Hyperlink
	public static WebElement lnk_contact_us_emp(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_hlContactUs']"));
	      return element;
	   }
	
	
}
