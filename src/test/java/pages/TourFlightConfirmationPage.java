package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TourFlightConfirmationPage {
	WebDriver driver;
	public String expected = "Flight Confirmation: Mercury Tours";
		
	public TourFlightConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Locate web element
	@FindBy(xpath="//font[contains(text(),'itinerary has been booked!')]")
	public WebElement confirmorder;

}