package Amazon.AutomationGuru.pages;
import java.time.Duration;
import java.util.List;

import  Amazon.AutomationGuru.Utilities.AbstarctComp.AbstractClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ProductCategory extends AbstractClass{
	
	WebDriver driver;
	WebElement element;
	
	 public ProductCategory(WebDriver driver) {
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(xpath="//div[@id='nav-search']//input[@id='twotabsearchtextbox']")
	public  WebElement navBar;
	 
	 @FindBy(xpath="//input[@type='submit']")
	 public  WebElement searchButton;
	
	 @FindBy(xpath="(//div[contains(@class,'puisg-row')]//button[text()='Add to cart'])[1]")
	 public  WebElement firstaddToCart;
	 
	 @FindBy(xpath="(//div[contains(@class,'puisg-row')]//button[text()='Add to cart'])[2]")
	 public  WebElement secaddToCart;
	 
	 //@FindBy(xpath="//a[@id='nav-cart']//span[contains(text(),'Cart')]")
	 
	 @FindBy(xpath="//a[@id='nav-cart']")
	 public WebElement cartLink;
	 
	 @FindBy(xpath="(//div[contains(@class,'puisg-row')]//span[@class='a-price-whole'])[1]")
	 public WebElement firstElementintheCart;
	 
	 @FindBy(xpath="(//div[contains(@class,'puisg-row')]//span[@class='a-price-whole'])[2]")
	 public WebElement secElementintheCart;
	 
	 @FindBy(xpath="(//form[@id='gutterCartViewForm']//span[contains(@class,'sc-price')])[2]")
	 public WebElement priceinSubCart;
	 
	 @FindBy(xpath="//input[@value='Delete']")
	 public WebElement removeElement;
	 
	 @FindBy(xpath="//div[@data-name ='Active Items']//span[contains(text(),'Headphone')][2]")
	 public WebElement HeadPhone;
	 
	 @FindBy(xpath="//span[contains(text(),'Headphone')]/ancestor::div[@class='sc-item-content-group']//span[contains(@class,'sc-product-price')]")
	 public WebElement priceofHeadPhone;
	 
	 @FindBy(xpath="//span[contains(text(),'Keyboard')]/ancestor::div[@class='sc-item-content-group']//span[contains(@class,'sc-product-price')]")
	 public WebElement priceofKeyBoard;
	 
	 public void searchForProduct(String searchElement) {
		 waitForElementToAppear(navBar);
		 navBar.clear();
		 navBar.sendKeys(searchElement);
		 searchButton.click();
	 }

	 public String addFirstItemToCart() {		
		 int i=1;
		 waitForElementToAppear(firstElementintheCart);
		 
		 List<WebElement>productList = driver.findElements(By.xpath("(//div[contains(@class,'puisg-row')]//span[@class='a-price-whole'])"));
		 
		 for(WebElement element:productList) {
			String priceList =element.getText();
		
		 }
		//String PriceOfIteminList= driver.findElement(By.xpath("(//div[contains(@class,'puisg-row')]//span[@class='a-price-whole'])[i]")).getText();
		//System.out.println(PriceOfIteminList);
		 String priceOfItem = firstElementintheCart.getText();
		 System.out.println(priceOfItem);
		 scrollToElement(firstaddToCart);		
		 waitForElementToAppear(firstaddToCart);		
		 firstaddToCart.click();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		 
		 scrollDowntoElement();
		 scrollUptoElement();
		 waitForElementToAppear(cartLink);
		 scrollToElement(cartLink);	
		 return priceOfItem;
	 }
	 
	 public String addSecItemToCart() {		
		 waitForElementToAppear(secElementintheCart);
		 scrollToElement(secElementintheCart);	
		 String priceOfItem = secElementintheCart.getText();
		 System.out.println(priceOfItem);
		 scrollToElement(secaddToCart);		
		 waitForElementToAppear(secaddToCart);		
		 secaddToCart.click();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		 
		 scrollDowntoElement();
		 scrollUptoElement();
		 waitForElementToAppear(cartLink);
		 scrollToElement(cartLink);	
		 return priceOfItem;
	 }
	 
public String getPriceOfProduct(String priceToBegetofElement) {
	String result = null;
	if (priceToBegetofElement.equals("HeadPhone"))
			{			
	              result = priceofHeadPhone.getText();	

			}
	else
	{
		System.out.println("Hellooo");
				 result =priceofKeyBoard.getText();
				System.out.println(result);
				
			}
    result = result.trim();
    result = result.replaceAll(".00", "");
	return result;

}

	public String priceOfSubCart() throws InterruptedException {			 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		 
		 cartLink.click();
		 waitForElementToAppear(priceinSubCart);
		 String priceFromSubCart= priceinSubCart.getText();
		 priceFromSubCart = priceFromSubCart.trim();		 
			priceFromSubCart = priceFromSubCart.replaceAll(".00", "");	
		 System.out.println(priceFromSubCart);
	//	 removeElementFromString();
		 return priceFromSubCart;
	 }
	
	public void getPriceOfProduct() {
		
	}
	 
	 public void removeElementFromString() throws InterruptedException {
		 waitForElementToAppear(removeElement);
		 removeElement.click();
	 }
	 
	 public void openUrl(String Url) {
		 driver.get(Url);
		 driver.manage().window().maximize();
		 String titleName = driver.getTitle();
		 System.out.println(titleName);
	 }
	 
	 public void closeWindow() {
		 driver.close();
		 driver.quit();
	 }
}
