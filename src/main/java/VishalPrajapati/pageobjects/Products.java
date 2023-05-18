package VishalPrajapati.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import VishalPrajapati.Reusable.Reused;

public class Products extends Reused {

	WebDriver driver;
	 
	 public Products(WebDriver driver)
	 {
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	 }
		
	 //  List<WebElement> product = driver.findElements(By.cssSelector(".mb-3"));
	  
	  //pageFactory
	  
	  @FindBy(css=".mb-3")
	  List<WebElement> product;
	  
	  @FindBy(css=".ng-animating")
	  WebElement spin;
	  
	  By productBy = By.cssSelector(".mb-3");
	  By AddtoCart = By.cssSelector(".card-body button:last-of-type");
	  By Message = By.cssSelector("#toast-container");
	  
	  public List<WebElement> getproducts() throws InterruptedException
	  {
		  waitforElement(productBy);
		  return product;
	  }
	  
	  public WebElement getproductByName(String ProductName) throws InterruptedException
	  {
		  WebElement pro=getproducts().stream().filter(p->p.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
		  return pro;
	  }
	  	  
	  public void AddtoCart(String ProductName) throws InterruptedException
	  {
		 WebElement pro = getproductByName(ProductName);
		  pro.findElement(AddtoCart).click();
		  waitforElement(Message);
		  waitforElementDisappear(spin);
	  }
	  
	  }

