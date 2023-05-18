package VishalPrajapati.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import VishalPrajapati.Reusable.Reused;

public class CartPage extends Reused{

	WebDriver driver;
	
	@FindBy(css=".totalRow button")
	  WebElement checkoutEL;
	
	@FindBy(css=".cartSection h3")
	private List<WebElement> cart;
	  
	 
	 public CartPage(WebDriver driver)
	 {
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	 }
		public Boolean VerifyProduct(String ProductName)
		{
	    Boolean match = cart.stream().anyMatch(c-> c.getText().equalsIgnoreCase(ProductName));
	    return match;
		}
		
		public CheckoutPage goTocheckout() {
			
			checkoutEL.click();
			return new CheckoutPage(driver);
			
			
		}
	  
	  
	  
	 }

