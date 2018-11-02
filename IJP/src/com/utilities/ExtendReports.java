package com.utilities;

 import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
	 
	public class ExtendReports {
	    public static ExtentHtmlReporter htmlReporter;
	    public static ExtentReports extent;
	    public static ExtentTest test;
	    public static WebDriver driver;
	     
	    @BeforeSuite
	    public void setUp()
	    {
	        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/MyOwnReport.html");
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	         
	        extent.setSystemInfo("OS", "Windows 10");
	        extent.setSystemInfo("Host Name", "Accenture Office");
	        extent.setSystemInfo("Environment", "QA");
	        extent.setSystemInfo("User Name", "Sundaramoorthy S");
	         
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setDocumentTitle("AutomationTesting.in IJP");
	        htmlReporter.config().setReportName("My Own Report");
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	        htmlReporter.config().setTheme(Theme.DARK);
	    }
	     
	    @AfterMethod
	    public void getResult(ITestResult result) throws Exception
	    {
	        if(result.getStatus() == ITestResult.FAILURE)
	        {
	            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
	            test.fail(result.getThrowable());
	            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
	            test.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\Screenshots\\"+timeStamp+".jpg");
	                
	        }
	        else if(result.getStatus() == ITestResult.SUCCESS)
	        {
	            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
	            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
	            test.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\Screenshots\\"+timeStamp+".jpg");
	        }
	        else
	        {
	            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
	            test.skip(result.getThrowable());
	        }
	    }
	     
	    @AfterSuite
	    public void tearDown()
	    {
	        extent.flush();
	        
	        System.out.println("View the automation report in " + System.getProperty("user.dir") +"/test-output/MyOwnReport.html");
	    }
	}
