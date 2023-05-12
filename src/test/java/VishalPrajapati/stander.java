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

import io.github.bonigarcia.wdm.WebDriverManager;

public class stander {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		String Productname = "IPHONE 13 PRO";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();	
	    driver.get("https://rahulshettyacademy.com/client");
	    driver.findElement(By.id("userEmail")).sendKeys("Vp123@gmail.com");
	    driver.findElement(By.id("userPassword")).sendKeys("Vishal@123");
	    driver.findElement(By.id("login")).click();
	    WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
	    w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
	    
	    
	    
	    List<WebElement> product = driver.findElements(By.cssSelector(".mb-3"));
	    	    
	    // in small resoultions scrolling
//	    JavascriptExecutor js = (JavascriptExecutor)driver;
//	    js.executeScript("window.scrollBy(1180, 520)");
	    
	     WebElement pro= product.stream().filter(p->p.findElement(By.cssSelector("b")).getText().equals(Productname)).findFirst().orElse(null);
	     pro.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	     
	     w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	     w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));	     
	     driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	     
	     List<WebElement> cart =  driver.findElements(By.cssSelector(".cartSection h3"));
	     Boolean match = cart.stream().anyMatch(c-> c.getText().equalsIgnoreCase(Productname));
	     Assert.assertTrue(match);
	   // simple way to Do
	      
         driver.findElement(By.cssSelector(".totalRow button")).click();
//	     
//	      driver.findElement(By.cssSelector("[placeholder*='Select Country']")).sendKeys("ind");
//	      Thread.sleep(3000);
//	      driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
	      
	      // using with action 
	      
	      Actions a = new Actions(driver);
	      a.sendKeys(driver.findElement(By.cssSelector("[placeholder*='Select Country']")), "ind").build().perform();
	      w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	      driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
	      driver.findElement(By.cssSelector(".actions a")).click();
	      
	      String print=  driver.findElement(By.cssSelector(".hero-primary")).getText();
	      Assert.assertTrue(print.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
}
