package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Screenshot;

public class TourReserveFlightsPage {
	WebDriver driver;
	public String expected = "Book a Flight: Mercury Tours";
		
	public TourReserveFlightsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Locate web element
	@FindBy(xpath="//input[@name='outFlight'][@value='Pangea Airlines$362$274$9:17']")
	public WebElement outflightselect;
	@FindBy(xpath="//input[@name='inFlight'][@value='Blue Skies Airlines$631$273$14:30']")
	public WebElement inflightselect;	
	@FindBy(name="reserveFlights")
	public WebElement reserveflightsbtn;
	@FindBy(xpath="//font[contains(text(),'Select your departure']")
	public WebElement selectdescription;
	
	//create a method
	public void reserveFlights() {
	outflightselect.click();
	inflightselect.click();
	
	try {
		  Screenshot.takeScreenshot(driver, "reserveFlights");
	  } catch (IOException ioe) {
		  System.out.println("Exception to take screenshot: ioe");
	  }
	
	reserveflightsbtn.click();
	System.out.println("Reserve is submitted");
	  
	}

}
