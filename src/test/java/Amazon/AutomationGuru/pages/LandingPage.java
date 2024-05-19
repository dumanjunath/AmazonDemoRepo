package Amazon.AutomationGuru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Amazon.AutomationGuru.Utilities.AbstarctComp.AbstractClass;

public class LandingPage extends AbstractClass {

	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public void goTo(String Url)
	{
		driver.get(Url);
	}
	
	
	public ProductCategory getProductsList() {
		ProductCategory pc = new ProductCategory(driver);
		return pc;
	}

}
