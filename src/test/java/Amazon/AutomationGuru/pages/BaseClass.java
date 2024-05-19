package Amazon.AutomationGuru.pages;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Amazon.AutomationGuru.Utilities.DataProvider.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class BaseClass {

	public WebDriver driver; 
	public LandingPage landingPage;
	String Url;
	String browser;
	
	public WebDriver initializeAutomation() throws IOException {
		Url = ConfigFileReader.getApplicationUrl();
		browser = ConfigFileReader.getBrowserl();
		if(browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			
		//	 ChromeOptions options = new ChromeOptions();
		//	  String chromeProfilePath = "C:\\Users\\duman\\AppData\\Local\\Google\\Chrome\\User Data";
		//	  options.addArguments("user-data-dir=" +chromeProfilePath);
			  driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}
		else {			
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	
	        


	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException, InterruptedException
	{		
		 driver = initializeAutomation();
		  landingPage = new LandingPage(driver);
		landingPage.goTo(Url);
		return landingPage;
	
		
	}
	
	@AfterMethod(alwaysRun=true)
	
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
	
	
}
