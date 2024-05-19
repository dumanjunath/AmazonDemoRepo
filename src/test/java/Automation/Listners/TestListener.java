package Automation.Listners;

import Amazon.AutomationGuru.Utilities.ExtentReports.ReportIntegrationwithTesttNg;
//import Amazon.AutomationGuru.pages.TestNg;
import Amazon.AutomationGuru.pages.BaseClass;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;

public class TestListener extends BaseClass  implements ITestListener  {

	public static ExtentTest extenttest;
	public static ExtentReports extent;
	
	 
	
	  @SuppressWarnings("unused")
	private static String getTestMethodName(ITestResult iTestResult) {
	        return iTestResult.getMethod().getConstructorOrMethod().getName();
	    }
	  
	  
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 extent = ReportIntegrationwithTesttNg.beforeSuite();
		 //extenttest= extent.createTest(method.getName());
		extenttest=extent.createTest(result.getMethod().getMethodName());
		System.out.println(result.getName()+ "is Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extenttest.log(Status.PASS, "Test Executed Successfully");
		System.out.println(result.getName()+ "Test is successfully executed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extenttest.log(Status.FAIL, "Test Failed Error in the Code");
		System.out.println(result.getName()+ "Test is failed on execution");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		extenttest.log(Status.SKIP, "Test Skipped Due to the dependency on other code");
		System.out.println(result.getName()+ "Test is Skipped on execution");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Start of an Execution");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Stop of an Execution");
	}

}
