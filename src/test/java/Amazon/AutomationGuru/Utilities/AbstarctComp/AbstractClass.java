package Amazon.AutomationGuru.Utilities.AbstarctComp;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;


public class AbstractClass {
	
	WebDriver driver;

	public AbstractClass(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void scrollDowntoElement() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollBy(0,300)", "");
	}
	
	public void scrollUptoElement() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("scroll(0, -350);");
	       js.executeScript("window.scrollBy(0,-350)", "");
	}
	
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;		
	       js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void waitForElementToAppear(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

}
