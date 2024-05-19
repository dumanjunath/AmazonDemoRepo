package Amazon.AutomationGuru.Utilities.ExtentReports;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportIntegrationwithTesttNg {

	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest extenttest;

	@BeforeSuite
	public static ExtentReports beforeSuite() {
		System.out.println("Hello");
		extent = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/Extenttest-output/STMExtentReport.html");
		System.out.println(spark.toString());
		spark.config().setDocumentTitle("Amazon Automation ");
		System.out.println("Hello");
		// Name of the report
		spark.config().setReportName("Automation Report through Extent ");
		System.out.println("Hello");
		// Dark Theme
		spark.config().setTheme(Theme.STANDARD);
		System.out.println("Hello");
		extent.attachReporter(spark);
		System.out.println("Hello");
		return extent;
	}

	@AfterSuite
	private void afterSuite() {
		// TODO Auto-generated method stub
	                          	extent.flush();

	}

	@BeforeMethod
	public void beforeMethod() {
		extenttest = extent.createTest("Demo Test").assignCategory("Regression").assignDevice("Chrome");
		extenttest.pass("Test Case runnin started");
		System.out.println("Test Case runnin started...");
	}

	@Test
	public void duringTest() {
		extenttest.log(Status.PASS, "Hello Worldt");
		System.out.println("Hello World this is...");

	}
	
	@Test
	public void duringTestFail() {
		extenttest.log(Status.FAIL, "Hello World This Test Case Failed");
		System.out.println("Hello World this is...");

	}
}
