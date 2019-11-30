package pages;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Screenshot;

public class TourFindFlightsPage {
	WebDriver driver;
	public String expected = "Select a Flight: Mercury Tours";
		
	public TourFindFlightsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Locate web element
	@FindBy(xpath="//input[@name='tripType'][@value='roundtrip']")
	public WebElement roundtrip;
	@FindBy(xpath="//input[@name='tripType'][@value='oneway']")
	public WebElement onewaytrip;
	
	@FindBy(name="passCount")
	public WebElement passengernum;
	@FindBy(name="fromPort")
	public WebElement fromport;	
	@FindBy(name="fromMonth")
	public WebElement frommonth;
	@FindBy(name="fromDay")
	public WebElement fromday;
	@FindBy(name="toPort")
	public WebElement toport;
	@FindBy(name="toMonth")
	public WebElement tomonth;
	@FindBy(name="toDay")
	public WebElement today;
	
	@FindBy(xpath="//input[@name='servClass'][@value='Coach']")
	public WebElement economyclass;
	@FindBy(xpath="//input[@name='servClass'][@value='Business']")
	public WebElement businessclass;
	@FindBy(xpath="//input[@name='servClass'][@value='First']")
	public WebElement firstclass;
	
	@FindBy(name="airline")
	public WebElement airline;
	@FindBy(xpath="//input[@name='findFlights']")
	public WebElement findflightsbtn;
	
	//create a method
	public void selectfindAvailableFlights(String tripType, String mycount, 
			String myfromport, String myfrommonth, String myfromday,
			String mytoport, String mytomonth, String mytoday, 
			String myserviceclass, String myairline) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(findflightsbtn));

		if (tripType.equals("roundtrip")) {
			roundtrip.click();
		} else {
			onewaytrip.click();
		} 	
	  
	  	Select passengerNum = new Select(passengernum);
	  	passengerNum.selectByValue(mycount);
	  
		Select fromPort = new Select(fromport);
		fromPort.selectByValue(myfromport);

		Select fromMonth = new Select(frommonth);
		fromMonth.selectByValue(myfrommonth);

		Select fromDay = new Select(fromday);
		fromDay.selectByValue(myfromday);

		Select toPort = new Select(toport);
		toPort.selectByValue(mytoport);

		Select toMonth = new Select(tomonth);
		toMonth.selectByValue(mytomonth);

		Select toDay = new Select(today);
		toDay.selectByValue(mytoday);
		
		Select airlines = new Select(airline);
		airlines.selectByVisibleText(myairline);
		
		if (myserviceclass.equals("first")) {
			firstclass.click();
		} else if (tripType.equals("business")) {
			businessclass.click();
		} else {
			economyclass.click();
		}
	  
		Screenshot.takeScreenshot(driver, "FinfFlights"); 
		findflightsbtn.click();
		System.out.println("The flight search criteria submitted");
	
	}	
}
