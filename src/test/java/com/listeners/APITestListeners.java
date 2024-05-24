package com.listeners;

import java.io.File;
import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.constants.Env;
import com.utility.TestUtility;

public class APITestListeners implements ITestListener{
	
	private ExtentReports extentReports;
	private ExtentSparkReporter extentSparkReporter;
	private ExtentTest extentTest;
	private static final File REPORT_DIRECTORY = new File(System.getProperty("user.dir")+"//reports");
	
	public void onTestStart(ITestResult result) {
	    System.out.println("Test started");
	    System.out.println(result.getMethod().getMethodName());
	    System.out.println(result.getMethod().getDescription());
	    System.out.println(Arrays.toString(result.getMethod().getGroups()));
	    extentTest = extentReports.createTest(result.getMethod().getMethodName())
	    		.assignCategory(result.getMethod().getGroups())
	    		.assignDevice(System.getProperty("os.name"))
	    		.assignDevice(System.getProperty("user.name"));
	    		
	  }
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed");
		extentTest.pass("Test passed");
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed");
		extentTest.fail("Test failed");
		extentTest.fail(result.getThrowable());
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped");
		extentTest.skip("Test skipped");
		extentTest.skip(result.getThrowable());
	}
	
	public void onStart(ITestContext context) {
	    System.out.println("Test suite started");
	    
	    if(REPORT_DIRECTORY.exists()) {
	    	TestUtility.deleteDirectory(REPORT_DIRECTORY);
	    }
	    TestUtility.createDirectory(REPORT_DIRECTORY);
	    extentSparkReporter = new ExtentSparkReporter(REPORT_DIRECTORY+"//"+TestUtility.readConfigFile(Env.QA,"REPORT_NAME")+" "+TestUtility.getTimeStamp()+".html");
	    extentSparkReporter.config().setTheme(Theme.DARK);
	    extentSparkReporter.config().setReportName("Pheonix Automation Report");
	    extentSparkReporter.config().setDocumentTitle("Pheonix API report");
	    
	    extentReports = new ExtentReports();
	    extentReports.attachReporter(extentSparkReporter);
	    
	  }
	
	public void onFinish(ITestContext context) {
		System.out.println("Test suite finished");
		extentReports.flush();
	  }
	

}
