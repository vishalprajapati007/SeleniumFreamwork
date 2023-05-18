package VishalPrajapati;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import VishalPrajapati.pageobjects.CartPage;
import VishalPrajapati.pageobjects.CheckoutPage;
import VishalPrajapati.pageobjects.ConformationPage;
import VishalPrajapati.pageobjects.LandingPage;
import VishalPrajapati.pageobjects.Products;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Submitorder {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		String Productname = "IPHONE 13 PRO";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();	
	    LandingPage landingPage = new LandingPage(driver);
	    landingPage.goTo();
	    Products P1= landingPage.apllication("Vp123@gmail.com", "Vishal@123");
	   
	    List<WebElement> products= P1.getproducts();
	    P1.AddtoCart(Productname);  
	    CartPage C1 = P1.goToCartPage();	   
	    Boolean match =   C1.VerifyProduct(Productname);
	    Assert.assertTrue(match);
	    CheckoutPage C2=  C1.goTocheckout();
//	    JavascriptExecutor js = (JavascriptExecutor)driver;
//	    js.executeScript("window.scrollBy(1180, 520)");
	    C2.SelectCountry("india");
	    ConformationPage C3= C2.Submitorder();
	    
	    
	    
	    	       	    
	    // in small resoultions scrolling
//	    JavascriptExecutor js = (JavascriptExecutor)driver;
//	    js.executeScript("window.scrollBy(1180, 520)");
	    
	    	     
	     
	          
	         
	    
	     
	   // simple way to Do
	      
        
//	     
//	      driver.findElement(By.cssSelector("[placeholder*='Select Country']")).sendKeys("ind");
//	      Thread.sleep(3000);
//	      driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
	      
	      // using with action 
	      
	      
	    
	      
	      String print= C3.getconfromation();
	      Assert.assertTrue(print.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
}