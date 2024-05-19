package Amazon.AutomationGuru.SeleniumTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Amazon.AutomationGuru.pages.BaseClass;
import Amazon.AutomationGuru.pages.ProductCategory;
import Amazon.AutomationGuru.pages.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class ValidateCartList extends BaseClass{
	
	@Test(enabled=true)
	public void validateCartforMonitor() throws IOException, InterruptedException {
		ProductCategory pc =  landingPage.getProductsList();
		pc.searchForProduct("Monitor");
		String priceOfFirstElemt = pc. addFirstItemToCart();
		Thread.sleep(5000);		
		String priceFromSubCart = pc.priceOfSubCart();
		 Assert.assertEquals(priceOfFirstElemt,priceFromSubCart,"Comparing the Two Prices from the List and Sub Total Page");
	}
	
	@Test(enabled=true)
	public void validateCartforLaptop() throws IOException, InterruptedException {
		ProductCategory pc =  landingPage.getProductsList();
	//	int addSecItem=2;
		pc.searchForProduct("Laptop");
		String priceOfFirstElemt = pc. addSecItemToCart();
		Thread.sleep(5000);		
		 String priceFromSubCart = pc.priceOfSubCart();
		 Assert.assertEquals(priceOfFirstElemt,priceFromSubCart,"Comparing the Two Prices from the List and Sub Total Page");
	}

	
	@Test(enabled=true)
	public void validateHeadPhonenKeyBoard() throws IOException, InterruptedException {
		ProductCategory pc =  landingPage.getProductsList();
		pc.searchForProduct("Headphones");
		String priceOfHeadPh = pc. addFirstItemToCart();	
		Thread.sleep(5000);
		
		String priceOfHeadPhtrim = priceOfHeadPh.replaceAll(",", "");
		int priceOfHeadPhone = Integer.parseInt(priceOfHeadPhtrim);
		//System.out.println(priceOfHeadPhone);
				
		
		pc.searchForProduct("Keyboard");
		String priceKeyboard = pc. addFirstItemToCart();	
		Thread.sleep(5000);
		
		String priceKeyboardtrim = priceKeyboard.replaceAll(",", "");
		int priceOfKeyBoard= Integer.parseInt(priceKeyboardtrim);
		//System.out.println(priceOfKeyBoard);
		
		int TotalPrice = priceOfHeadPhone+priceOfKeyBoard;
		//System.out.println(TotalPrice);
		
		Thread.sleep(2000);	
		String priceFromSubCart = pc.priceOfSubCart();
		
		String priceOfHeadPhoneFromAddedList = pc.getPriceOfProduct("HeadPhone");
		//System.out.println(priceOfHeadPhoneFromAddedList);
		
		Thread.sleep(2000);	
		String priceOfKeyBoardFromAddedList = pc.getPriceOfProduct("KeyBoard");
		//System.out.println(priceOfKeyBoardFromAddedList);
		
		priceFromSubCart = priceFromSubCart.replaceAll(",", "");
		int priceFrmSubCart =  Integer.parseInt(priceFromSubCart);
		
		Assert.assertEquals(priceOfKeyBoardFromAddedList,priceKeyboard,"Comparing the KeyBoard from Search Page and Cart Page");
		Assert.assertEquals(priceOfHeadPhoneFromAddedList,priceOfHeadPh,"Comparing the Two Prices from the List and Sub Total Page");
		 Assert.assertEquals(TotalPrice,priceFrmSubCart,"Comparing the Two Prices from the List and Sub Total Page");
	}
}
