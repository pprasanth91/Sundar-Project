package com.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageobjectsSRDashboard {

	private static WebElement element = null;
	
	//Employee ADFS User name
		public static WebElement txt_employee_uname(WebDriver driver)
		   {
		      element = driver.findElement(By.id("userNameInput"));
		      return element;
		   }
		
		//Employee ADFS Password
		public static WebElement txt_employee_pwd(WebDriver driver)
		   {
		      element = driver.findElement(By.id("passwordInput"));
		      return element;
		   }
		
		//Employee ADFS Login button
		public static WebElement btn_employee_adfs_login(WebDriver driver)
		   {
		      element = driver.findElement(By.id("submitButton"));
		      return element;
		   }
		
		
		//Image Icon to expand the home nodes
		public static WebElement img_expand_home(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("//form[contains(@id,'Form1')]//img"));
		      return element;
		   }
		
		//SR link
		public static WebElement lnk_sr(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='TreeControl1_mtrvDsasList1t7']"));
		      return element;
		   }
		
		//Search/Edit SR New Link
		public static WebElement lnk_search_edir_sr_new(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='TreeControl1_mtrvDsasList1t9']"));
		      return element;
		   }
		
		//BASIC SEARCH Link
		public static WebElement lnk_basic_search(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='BASIC SEARCH']/span"));
		      return element;
		   }
		
		//SR/RRD Link
		public static WebElement lnk_sr_rrd_search(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='SR/RRD']/span"));
		      return element;
		   }
		
		//GENERAL Link
		public static WebElement lnk_general_search(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='GENERAL']/span"));
		      return element;
		   }
		
		//SLL / Career track Link
		public static WebElement lnk_sll_search(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='SLL / Career track']/span"));
		      return element;
		   }
		
		/*
		 * BASIC SEARCH Page Elements
		 */
		
		//Target Type Dropdown - Select
		public static WebElement dd_target_type(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='cboTargetType']"));
		      return element;
		   }
		
		//JD Complete Dropdown - Select
		public static WebElement dd_jd_complete(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='cboJDComplete']"));
		      return element;
		   }
		
		//SR No. From Textbox
		public static WebElement txt_sr_from(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='srFrom']"));
		      return element;
		   }
		
		//SR No. To Textbox
		public static WebElement txt_sr_to(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/app-root/app-sr-dashboard-home/div[2]/div/div/div/form/app-sr-dashboard-basic/div/div[1]/div[4]/div/input"));
		      return element;
		   }
		
		//Sourcing Planner Dropdown
		public static WebElement dd_sourcing_planner(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='cboSourcingPlanner']"));
		      return element;
		   }
		
		//SR Flagged with Exception Dropdown
		public static WebElement dd_sr_flagged_with_exception(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='cboSRFlagExcp']"));
		      return element;
		   }
		
		//DFD From Textbox
		public static WebElement txt_dfd_from(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/app-root/app-sr-dashboard-home/div[2]/div/div/div/form/app-sr-dashboard-basic/div/div[2]/div[2]/div/div/input"));
		      return element;
		   }
		
		//DFD From Calendar Icon
		public static WebElement img_dfd_from_calendar(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/app-root/app-sr-dashboard-home/div[2]/div/div/div/form/app-sr-dashboard-basic/div/div[2]/div[2]/div/a[1]/span"));
		      return element;
		   }
		
		//DFD From Clear
		public static WebElement lnk_dfd_from_clear(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/app-root/app-sr-dashboard-home/div[2]/div/div/div/form/app-sr-dashboard-basic/div/div[2]/div[2]/div/a[2]"));
		      return element;
		   }
		
		//DFD To Textbox
		public static WebElement txt_dfd_to(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/app-root/app-sr-dashboard-home/div[2]/div/div/div/form/app-sr-dashboard-basic/div/div[2]/div[3]/div/div/input"));
		      return element;
		   }
		
		//DFD To Calendar Icon
		public static WebElement img_dfd_to_calendar(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/app-root/app-sr-dashboard-home/div[2]/div/div/div/form/app-sr-dashboard-basic/div/div[2]/div[3]/div/a[1]/span"));
		      return element;
		   }
		
		//DFD To Clear
		public static WebElement lnk_dfd_to_clear(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/app-root/app-sr-dashboard-home/div[2]/div/div/div/form/app-sr-dashboard-basic/div/div[2]/div[3]/div/a[2]"));
		      return element;
		   }
		
		//View All SR's Radio Button
		public static WebElement btn_view_all_srs(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/app-root/app-sr-dashboard-home/div[2]/div/div/div/form/app-sr-dashboard-basic/div/div[2]/div[4]/form/label[1]"));
		      return element;
		   }
		
		//View My SR's Radio Button		
		public static WebElement btn_view_my_srs(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/app-root/app-sr-dashboard-home/div[2]/div/div/div/form/app-sr-dashboard-basic/div/div[2]/div[4]/form/label[2]"));
		      return element;
		   }
		
		//Apply Button
		public static WebElement btn_apply(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//button[@class='btn apply-btn btn-primary btn-sm btn-info' and text()='APPLY']"));
		      return element;
		   }
		
		//Clear Button
		public static WebElement btn_clear(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//button[@class='btn btn-link btn-sm btn-info' and text()='CLEAR']"));
		      return element;
		   }
		
		//Search Results Grid
		public static WebElement grid_results(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/app-root/app-sr-dashboard-home/div[2]/div/div/div/xd-component-container"));
		      return element;
		   }
		
		/*
		 * SEARCH RESULTS GRID ELEMENTS
		 */
		
		//OPEN Hyperlink
		public static WebElement lnk_open(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='openID']/a/span[2]"));
		      return element;
		   }
		
		//CLOSED Hyperlink		
		public static WebElement lnk_closed(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/app-root/app-sr-dashboard-home/div[2]/div/div/div/colour-grid/table/tbody/tr/td[2]/a/span[2]"));
		      return element;
		   }
		
		//FULFILLED Hyperlink
		public static WebElement lnk_fulfilled(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/app-root/app-sr-dashboard-home/div[2]/div/div/div/colour-grid/table/tbody/tr/td[3]/a/span[2]"));
		      return element;
		   }
		
		//WITHDRAWN Hyperlink
		public static WebElement lnk_withdrawn(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath("html/body/app-root/app-sr-dashboard-home/div[2]/div/div/div/colour-grid/table/tbody/tr/td[4]/a/span[2]"));
		      return element;
		   }
		
		//COLUMN NAMES - Default
		//SR NO Column
		public static WebElement lnk_sr_no_column(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//span[@class='ag-header-cell-text' and text()='SR No']"));
		      return element;
		   }
		
		//JOB CODE Column
		public static WebElement lnk_job_code_column(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//span[@class='ag-header-cell-text' and text()='Job Code']"));
		      return element;
		   }
		
		//CHANNEL Column
		public static WebElement lnk_channel_column(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//span[@class='ag-header-cell-text' and text()='Channel']"));
		      return element;
		   }
		
		//SKILL Column
		public static WebElement lnk_skill_column(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//span[@class='ag-header-cell-text' and text()='Channel']"));
		      return element;
		   }
		
		
		
		
		

	}