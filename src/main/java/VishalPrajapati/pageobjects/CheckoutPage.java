package VishalPrajapati.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import VishalPrajapati.Reusable.Reused;

public class CheckoutPage extends Reused {
	
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css =".action__submit")
	WebElement Submit;
	
	
	@FindBy(css="[placeholder*='Select Country']")
	WebElement countery;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selectCountry;
	
	By results = By.cssSelector(".ta-results");
	
	public void SelectCountry(String countryName) throws InterruptedException
	{
		 Actions a = new Actions(driver);
	     a.sendKeys("countery",countryName ).build().perform();
	     waitforElement(By.cssSelector(".ta-results"));
	     
//	     try {
//	         WebElement element = w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//	         // Perform actions on the visible element
//	     } catch (TimeoutException e) {
//	         // Handle the timeout exception
//	         e.printStackTrace();
//	     }
//	  
	     selectCountry.click();
	}
	
	public ConformationPage Submitorder()
	{
		Submit.click();
		return new ConformationPage(driver);
	}
	
}
