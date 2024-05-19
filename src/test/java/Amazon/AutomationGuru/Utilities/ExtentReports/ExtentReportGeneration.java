package Amazon.AutomationGuru.Utilities.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportGeneration {

	
	public WebDriver driver;
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest logger;
	
	@Test
	public void beforeSuite(){
		
		 extent = new ExtentReports();
		 spark  = new ExtentSparkReporter(System.getProperty("user.dir")+"/Extenttest-output/STMExtentReport.htmll");		        
         spark.config().setDocumentTitle("Amazon Automation ");    
               // Name of the report
        spark.config().setReportName("Automation Report through Extent ");
               // Dark Theme
         spark.config().setTheme(Theme.STANDARD);      
         extent.attachReporter(spark);
         System.out.println("Hello");
         extent.flush();
	}
}
