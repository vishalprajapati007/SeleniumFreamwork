package VishalPrajapati.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import VishalPrajapati.Reusable.Reused;

public class ConformationPage extends Reused {

	WebDriver driver;

	public ConformationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css =".hero-primary")
	WebElement ConMessage;

	public String getconfromation()
	{
	  return ConMessage.getText();
	}
}
