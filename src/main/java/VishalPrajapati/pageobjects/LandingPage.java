package VishalPrajapati.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import VishalPrajapati.Reusable.Reused;

public class LandingPage extends Reused{

	WebDriver driver;
	 
	 public LandingPage(WebDriver driver)
	 {
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	 }
		
	 // WebElement userEmail = driver.findElement(By.id("userEmail"));
	  
	  //pageFactory
	  
	  @FindBy(id="userEmail")
	  WebElement usermail;
	  
	  @FindBy(id="userPassword")
	  WebElement PasswordAL;
	  
	  @FindBy(id="login")
	  WebElement submit;
	  
	  public Products apllication(String email, String Password)
	  {
		  usermail.sendKeys(email);
		  PasswordAL.sendKeys(Password);
		  submit.click();
		  Products P1 = new Products(driver);
		  return P1;

	  }
	  
	  public void goTo()
	  {
		  driver.get("https://rahulshettyacademy.com/client");
	  }
}

