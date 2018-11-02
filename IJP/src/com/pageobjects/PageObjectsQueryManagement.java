package com.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObjectsQueryManagement {

	private static WebElement element = null;
	
	//Need Help?
	
	//Write to Us Hyperlink
	public static WebElement lnk_write_to_us(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='indexdivcontentview']/ng-view/section/div/div[2]/div/div[1]/ul/li/a"));
	      return element;
	   }
	
	//Replies Hyperlink
	public static WebElement lnk_replies(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='indexdivcontentview']/ng-view/section/div[1]/div[2]/div/div[1]/ul/li/span/a"));
	      return element;
	   }
	
	
	//Write to Us Heading visiblity
	public static WebElement txt_write2us_visi(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[1]/h2"));
	      return element;
	   }
	
	//Category of Queries - List
	public static WebElement dd_category_list(WebDriver driver)
	   {
	      element = (WebElement) driver.findElements(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[1]/ul/li/a"));
	      return element;
	   }
	
	//List of Questions in Joining Related Category
	public static WebElement dd_questions_joining_related_list(WebDriver driver)
	   {
	      element = (WebElement) driver.findElements(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li/a"));
	      return element;
	   }
	
	
	//Answer Body Part	
	public static WebElement txt_answer(WebDriver driver)
	   {
	      element = (WebElement) driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[2]"));
	      return element;
	   }
	
	
	//Write to Us Button	
	public static WebElement btn_write_to_us(WebDriver driver)
	   {
	      element = (WebElement) driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[3]/button"));
	      return element;
	   }
	
	//What's your query about?
	public static WebElement dd_query_abt(WebDriver driver)
	   {
	      element = (WebElement) driver.findElement(By.xpath(".//*[@id='queryCat']/div[1]/span/i"));
	      return element;
	   }
	
	
	
	//Tell us about it...
	public static WebElement txt_tell_us_abt_it(WebDriver driver)
	   {
	      element = (WebElement) driver.findElement(By.xpath(".//*[@id='query_comment']"));
	      return element;
	   }
	
	//Upload Document
	public static WebElement btn_upload_document(WebDriver driver)
	   {
	      element = (WebElement) driver.findElement(By.xpath("//*[@id='incidentModal']/div/div/div[2]/div/div/div/div/div[4]/div/label/strong"));
	      return element;										//*[@id="incidentModal"]/div/div/div[2]/div/div/div/div/div[3]/div/label/strong
	   }
	
	//Post your query
	public static WebElement btn_post_ur_query(WebDriver driver)
	   {
	      element = (WebElement) driver.findElement(By.xpath(".//*[@id='incidentModal']/div/div/div[2]/div/div/div/div/div[5]/button"));
	      return element;
	   }
	
	/*
	 * 
	 ******************************************* Status Section *************************************************************
	 * 
	 * 
	*/
	//Status Hyperlink Query
	public static WebElement lnk_status(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[1]/ul[1]/li/a"));
	      return element;
	   }
	
	//What is my Current Status?
	public static WebElement lnk_status_q1(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[1]/a"));
	      return element;
	   }
	
	//What is my Current Status? Answer
	public static WebElement txt_status_q1_ans(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[2]"));
	      return element;
	   }
		
	//What is my Current Status? Answer - Didn't help?
	public static WebElement lnk_status_q1_ans_q(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[3]/button"));
	      return element;
	   }
	
	//What is my next step?
	public static WebElement lnk_status_q2(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[2]/a"));
	      return element;
	   }
	
	//What is my next step? Answer
	public static WebElement txt_status_q2_ans(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[2]"));
	      return element;
	   }
	
	//What is my next step? Answer - Didn't help?
	public static WebElement lnk_status_q2_ans_q(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[3]/button"));
	      return element;
	   }	
	
	//My Latest Status shows "Pending Offer Letter", but i have not received my Offer Yet?
	public static WebElement lnk_status_q3(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[3]/a"));
	      return element;
	   }
	
	//My Latest Status shows "Pending Offer Letter", but i have not received my Offer Yet? Answer
	public static WebElement txt_status_q3_ans(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[2]"));
	      return element;
	   }
	
	//My Latest Status shows "Pending Offer Letter", but i have not received my Offer Yet? Answer - Didn't help?
	public static WebElement lnk_status_q3_ans_q(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[3]/button"));
	      return element;
	   }
	
	//Why is my status shown incorrect in portal?
	public static WebElement lnk_status_q4(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[4]/a"));
	      return element;
	   }
	
	//Why is my status shown incorrect in portal? Answer
	public static WebElement txt_status_q4_ans(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[2]"));
	      return element;
	   }
	
	//Why is my status shown incorrect in portal? Answer - Didn't help?
	public static WebElement lnk_status_q4_ans_q(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[3]/button"));
	      return element;
	   }
	
	//Who can I talk directly to about a job I have applied for?
	public static WebElement lnk_status_q5(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[5]/a"));
	      return element;
	   }
	
	//Who can I talk directly to about a job I have applied for? Answer
	public static WebElement lnk_status_q5_ans(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[2]"));
	      return element;
	   }
	
	//Who can I talk directly to about a job I have applied for? Answer - Didnt help? Write to us button
	public static WebElement lnk_status_q5_ans_q(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[3]/button"));
	      return element;
	   }
	
	//Other
	public static WebElement lnk_status_q6(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[5]/a"));
	      return element;
	   }
	
	/*
	 * 
	 ******************************************* Referral Bonus *************************************************************
	 * 
	 * 
	*/
	
	//Referral Bonus hyperlink
	public static WebElement lnk_referral_bonus(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[1]/ul[2]/li/a"));
	      return element;
	   }
	
	//What's the criteria for referral bonus?
	public static WebElement lnk_ref_bonus_q1(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[1]/a"));
	      return element;
	   }
	
	
	/*
	 * 
	 ******************************************* Hiring Process *************************************************************
	 * 
	 * 
	*/
	
	//Hiring Process hyperlink
	public static WebElement lnk_hiring_process(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[1]/ul[2]/li/a"));
	      return element;
	   }
	
	//I am unable to apply to Other Opportunities?
	public static WebElement lnk_hiring_process_q1(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[1]/a"));
	      return element;
	   }
	
	//I am unable to apply to Other Opportunities? Answer
	public static WebElement txt_hiring_process_q1_ans(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[2]"));
	      return element;
	   }
	
	//I am unable to apply to Other Opportunities? Answer - Didn't help?
	public static WebElement lnk_hiring_process_q1_ans_q(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[3]/button"));
	      return element;
	   }
	
	//What is the guideline for Accenture to hire employees who are physically challenged?
	public static WebElement lnk_hiring_process_q2(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[2]/a"));
	      return element;
	   }
	
	//What is the guideline for Accenture to hire employees who are physically challenged? Answer
	public static WebElement txt_hiring_process_q2_ans(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[2]"));
	      return element;
	   }
		
	//What is the guideline for Accenture to hire employees who are physically challenged? Answer - Didn't help?
	public static WebElement lnk_hiring_process_q2_ans_q(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[3]/button"));
	      return element;
	   }
	
	//I am facing job code invalid error on Employee Referral Portal?
	public static WebElement lnk_hiring_process_q3(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[3]/a"));
	      return element;
	   }
	
	//I am facing job code invalid error on Employee Referral Portal? Answer
	public static WebElement txt_hiring_process_q3_ans(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[2]"));
	      return element;
	   }
	
	//I am facing job code invalid error on Employee Referral Portal? Answer - Didn't help?
	public static WebElement lnk_hiring_process_q3_ans_q(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[3]/button"));
	      return element;
	   }
	
	//Others in Hiring Process
	public static WebElement lnk_hiring_process_q4(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[4]/a"));
	      return element;
	   }
	
	/*
	 * 
	 ******************************************* Profile Updation *************************************************************
	 * 
	 * 
	*/
	
	//Profile Updation Hyperlink
	public static WebElement lnk_profile_updation(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[1]/ul[3]/li/a"));
	      return element;
	   }
	
	//How do I update my CV?
	public static WebElement lnk_profile_updation_q1(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[1]/a"));
	      return element;
	   }
	
	//How do I update my CV? Answer
	public static WebElement txt_profile_updation_q1_ans(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[2]"));
	      return element;
	   }
	
	//How do I update my CV? Answer - Didn't help?
	public static WebElement lnk_profile_updation_q1_ans_q(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[3]/button"));
	      return element;
	   }
	
	//Why does the applied opportunity show my CV as incomplete?
	public static WebElement lnk_profile_updation_q2(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[2]/a"));
	      return element;
	   }
	
	//Why does the applied opportunity show my CV as incomplete? Answer
	public static WebElement txt_profile_updation_q2_ans(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[2]"));
	      return element;
	   }
	
	//Why does the applied opportunity show my CV as incomplete? Answer - Didn't help?
	public static WebElement lnk_profile_updation_q2_ans_q(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[3]/button"));
	      return element;
	   }
	
	//How do I update my skill profile?
	public static WebElement lnk_profile_updation_q3(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[3]/a"));
	      return element;
	   }
	
	//How do I update my skill profile? Answer
	public static WebElement txt_profile_updation_q3_ans(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[2]"));
	      return element;
	   }
	
	//How do I update my skill profile? Answer - Didn't help?
	public static WebElement lnk_profile_updation_q3_ans_q(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[3]/button"));
	      return element;
	   }
	
	//Where can I update my mobile number/email address?
	public static WebElement lnk_profile_updation_q4(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[4]/a"));
	      return element;
	   }
	
	//Where can I update my mobile number/email address? Answer
	public static WebElement txt_profile_updation_q4_ans(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[2]"));
	      return element;
	   }
	
	//Where can I update my mobile number/email address? Answer - Didn't help?
	public static WebElement lnk_profile_updation_q4_ans_q(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[3]/button"));
	      return element;
	   }
	
	//How do I reset my password?
	public static WebElement lnk_profile_updation_q5(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[5]/a"));
	      return element;
	   }
	
	//How do I reset my password? Answer
	public static WebElement txt_profile_updation_q5_ans(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[2]"));
	      return element;
	   }
	
	//How do I reset my password? Answer - Didn't help?
	public static WebElement lnk_profile_updation_q5_ans_q(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[3]/button"));
	      return element;
	   }
	
	//Where do I update my personal details?
	public static WebElement lnk_profile_updation_q6(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[6]/a"));
	      return element;
	   }
	
	//Where do I update my personal details? Answer
	public static WebElement txt_profile_updation_q6_ans(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[2]"));
	      return element;
	   }
	
	//Where do I update my personal details? Answer - Didn't help?
	public static WebElement lnk_profile_updation_q6_ans_q(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[3]/button"));
	      return element;
	   }
	
	//Others in Profile Updation
	public static WebElement lnk_profile_updation_q7(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[7]/a"));
	      return element;
	   }
	
	/*
	 * 
	 ******************************************* Interview *************************************************************
	 * 
	 * 
	*/
	
	//Interview Hyperlink
	public static WebElement lnk_interview(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[1]/ul[4]/li/a"));
	      return element;
	   }
	
	//Can I know the date of my next round of interview?
	public static WebElement lnk_interview_q1(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[1]/a"));
	      return element;
	   }
	
	//Can I know the date of my next round of interview? Answer
	public static WebElement txt_interview_q1_ans(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[2]"));
	      return element;
	   }
	
	//Can I know the date of my next round of interview? Answer - Didn't help?
	public static WebElement lnk_interview_q1_ans_q(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[3]/button"));
	      return element;
	   }
	
	//How do I schedule/reschedule my interview?
	public static WebElement lnk_interview_q2(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[2]/a"));
	      return element;
	   }
	
	//How do I schedule/reschedule my interview? Answer
	public static WebElement txt_interview_q2_ans(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[2]"));
	      return element;
	   }
	
	//How do I schedule/reschedule my interview? Answer - Didn't help?
	public static WebElement lnk_interview_q2_ans_q(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[3]/button"));
	      return element;
	   }
	
	//How do I cancel my interview ?
	public static WebElement lnk_interview_q3(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[3]/a"));
	      return element;
	   }
	
	//How do I cancel my interview ? Answer
	public static WebElement txt_interview_q3_ans(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[2]"));
	      return element;
	   }
	
	//How do I cancel my interview ? Answer - Didn't help?
	public static WebElement lnk_interview_q3_ans_q(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[3]/button"));
	      return element;
	   }
	
	//How do I see my interview details?
	public static WebElement lnk_interview_q4(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[4]/a"));
	      return element;
	   }
	
	//How do I see my interview details? Answer
	public static WebElement txt_interview_q4_ans(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[2]"));
	      return element;
	   }
	
	//How do I see my interview details? Answer - Didn't help?
	public static WebElement lnk_interview_q4_ans_q(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[3]/button"));
	      return element;
	   }
	
	//I need confirmation on my Interview status?
	public static WebElement lnk_interview_q5(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[5]/a"));
	      return element;
	   }
	
	//I need confirmation on my Interview status? Answer
	public static WebElement txt_interview_q5_ans(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[2]"));
	      return element;
	   }
	
	//I need confirmation on my Interview status? Answer - Didn't help?
	public static WebElement lnk_interview_q5_ans_q(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[3]/button"));
	      return element;
	   }
	
	//I am looking for my Interview venue details?
	public static WebElement lnk_interview_q6(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[6]/a"));
	      return element;
	   }
	
	//I am looking for my Interview venue details? Answer
	public static WebElement txt_interview_q6_ans(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[3]"));
	      return element;
	   }
	
	//I am looking for my Interview venue details? Answer - Didn't help?
	public static WebElement lnk_interview_q6_ans_q(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[3]/button"));
	      return element;
	   }
	
	//Where can I change my Interview Venue?
	public static WebElement lnk_interview_q7(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[7]/a"));
	      return element;
	   }
	
	//Where can I change my Interview Venue? Answer
	public static WebElement txt_interview_q7_ans(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[2]"));
	      return element;
	   }
	
	//Where can I change my Interview Venue? Answer - Didn't help?
	public static WebElement lnk_interview_q7_ans_q(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[3]/button"));
	      return element;
	   }
	
	//Can my next round of interview be telephonic?
	public static WebElement lnk_interview_q8(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[8]/a"));
	      return element;
	   }
	
	//Can my next round of interview be telephonic? Answer
	public static WebElement txt_interview_q8_ans(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[8]/a"));
	      return element;
	   }
	
	//Can my next round of interview be telephonic? Answer - Didn't help?
	public static WebElement lnk_interview_q8_ans_q(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[3]/button"));
	      return element;
	   }
	
	//Can my next round of interview be telephonic?
	public static WebElement lnk_interview_q9(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[8]/a"));
	      return element;
	   }
	
	//Can my next round of interview be telephonic? Answer
	public static WebElement txt_interview_q9_ans(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[2]"));
	      return element;
	   }
	
	//Can my next round of interview be telephonic? Answer - Didn't help?
	public static WebElement lnk_interview_q9_ans_q(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[3]/div[1]/div[3]/button"));
	      return element;
	   }
	
	//Others
	public static WebElement lnk_interview_q10(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li[9]/a"));
	      return element;
	   }
	
	/*
	 * 
	 ******************************************* Others and Didn't help section popup *************************************************************
	 * 
	 * 
	*/
	//Write to us...
	//We are here to help you! Choose the category and post your query... heading visiblity
	public static WebElement para_new_query_visi(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//h2[@class='page-title' and text()='Write to us...']"));
	      return element;
	   }
	
	//What's your query about?
	public static WebElement dd_query_about(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='queryCat']/div[1]/span/i"));
	      return element;
	   }
	
	//What's your query about? Input
	public static WebElement dd_query_about_input(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='queryCat']/input[1]"));
	      return element;
	   }
	
	//What's your query about? Input Select
	public static WebElement dd_query_about_input_select(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='ui-select-choices-row-38-']/a"));
	      return element;
	   }
	
	//Tell us about it...
	public static WebElement txt_tell_us_about_it(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='query_comment']"));
	      return element;
	   }
	
	//Upload Document
	public static WebElement btn1_upload_doc(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentModal']/div/div/div[2]/div/div/div/div/div[3]/div/label"));
	      return element;
	   }	
	
	public static WebElement btn2_upload_doc(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='incidentModal']/div/div/div[2]/div/div/div/div/div[4]/div/label/strong"));
	      return element;
	   }
	
	//Post your query button
	public static WebElement btn_post_query(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//button[@class='btn btn-ice' and text()='Post your query']"));
	      return element;
	   }
	
	//Replies Hyperlink
	public static WebElement lnk_replies_raise_queries(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentModal']/div/div/div[2]/div/div/div/div/div[1]/div/a"));
	      return element;
	   }
	
	/*
	 * 
	 ******************************************* Replies Dashboard *************************************************************
	 * 
	 * 
	*/
	
	//Replies Dashboard Heading Visibility
	public static WebElement txt_replies_dash_visi(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentModal']/div/div/div[1]/h2"));
	      return element;
	   }
	
	//Open tab
	public static WebElement lnk_open(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='modalList']/li[1]/a"));
	      return element;
	   }
	
	//Responded tab
	public static WebElement lnk_responded(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='RespondedLi']/a"));
	      return element;
	   }
	
	//Closed tab
	public static WebElement lnk_closed(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='modalList']/li[3]/a"));
	      return element;
	   }
	
	//Categories Tab
	public static WebElement lnk_open_category_list(WebDriver driver)
	   {
	      element = (WebElement) driver.findElements(By.xpath(".//*[@id='incidentModal']/div/div/div[2]/div/div/div/div[2]/div[1]/ul/li/a"));
	      return element;
	   }
	
	//Incident Number Visibility
	public static WebElement txt_incident_num_visi(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentModal']/div/div/div[2]/div/div/div/div[2]/div[2]/span"));
	      return element;
	   }
	
	//Post extra Query messages
	public static WebElement txt_post_extra(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='txtcandresponse']"));
	      return element;
	   }
	
	//Post button
	public static WebElement btn_post(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath("//*[@id='incidentModal']/div/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div[2]/button"));
	      return element;
	   }
	
	//Post a new Query Hyperlink
	public static WebElement lnk_post_new_query(WebDriver driver) 
	   {
	      element = driver.findElement(By.xpath(".//*[@id='modalList']/li[4]/div/a"));
	      return element;
	   }
	
	//Close the query Page
	public static WebElement btn_close_page(WebDriver driver) 
	   {
	      element = driver.findElement(By.xpath(".//*[@id='incidentModal']/div/div/div[1]/button"));
	      return element;
	   }
	
	
}
