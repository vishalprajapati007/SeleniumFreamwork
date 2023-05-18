package VishalPrajapati.Reusable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import VishalPrajapati.pageobjects.CartPage;
import io.netty.handler.timeout.TimeoutException;

public class Reused {
	
	
	WebDriver driver;
	
	public Reused(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css="[routerlink*='cart']")
	WebElement CartHeader;
	
	
	public void waitforElement(By findBy) throws InterruptedException
	{
		//Thread.sleep(3000);
     	  WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
          w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	    
//	    try {
//	    	WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
//	        w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
//	        // Perform actions on the visible element
//	    } catch (TimeoutException e) {
//	        // Handle the timeout exception
//	        e.printStackTrace();
	    }
	
	
	public CartPage goToCartPage()
	{
		CartHeader.click();
		CartPage C1 = new CartPage(driver);
		return C1;
	}
	
	
	
	public void waitforElementDisappear(WebElement tst ) throws InterruptedException
	{
		Thread.sleep(3000);
//		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
//		w.until(ExpectedConditions.invisibilityOf(tst));	
	}
	
}
