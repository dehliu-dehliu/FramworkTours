package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Screenshot;

public class TourBookFlightsPage {
	WebDriver driver;
	public String expected = "Flight Confirmation: Mercury Tours";
		
	public TourBookFlightsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Locate web element
	@FindBy(xpath="//font[contains(text(),'Summary')]")
	public WebElement reservesummary;
	
	@FindBy(name="passFirst0")
	public WebElement firstname1;
	@FindBy(name="passLast0")
	public WebElement lastname1;
	@FindBy(name="pass.0.meal")
	public WebElement meal1;
	
	@FindBy(name="creditCard")
	public WebElement creditcard;
	@FindBy(name="creditnumber")
	public WebElement creditnumber;
	@FindBy(name="cc_exp_dt_mn")
	public WebElement expirymonth;
	@FindBy(name="cc_exp_dt_yr")
	public WebElement expiryyear;
	@FindBy(xpath ="//input[@name='cc_frst_name']")
	public WebElement billfirstname;
	@FindBy(xpath="//input[@name='cc_mid_name']")
	public WebElement billmidname;
	@FindBy(xpath="//input[@name='cc_last_name']")
	public WebElement billlastname;
	
	@FindBy(xpath ="//font[contains(text(),'Ticketless Travel')]")
	public WebElement ticketlesscheck;
	
	@FindBy(name="billAddress1")
	public WebElement billaddress1;
	@FindBy(name="billAddress2")
	public WebElement billaddress2;
	@FindBy(name="billCity")
	public WebElement billcity;
	@FindBy(name="billState")
	public WebElement billstate;
	@FindBy(name="billZip")
	public WebElement billzip;
	
	@FindBy(xpath ="//font[contains(text(),'Same as Billing Address')]")
	public WebElement sameasbillcheck;
	
	@FindBy(name="delAddress1")
	public WebElement deladdress1;
	@FindBy(name="delAddress2")
	public WebElement deladdress2;
	@FindBy(name="delCity")
	public WebElement delcity;
	@FindBy(name="delState")
	public WebElement delstate;
	@FindBy(name="delZip")
	public WebElement delzip;
	
	@FindBy(name="buyFlights")
	public WebElement buyflightsbtn;
	
	
	//create a method
	public void orderFlightsSameBillAddress(String myfirstname, String mylastname,
			String mycreditcard, String mycreditnumber, int myexpirymonth, String myexpiryyear, 
			String mybillfirstname, String mybilllastname,
			String mybilladdress1, String mybilladdress2, String mybillcity, String mybillstate, String mybillzip) {
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(reservesummary));
		
		firstname1.sendKeys(myfirstname);
		lastname1.sendKeys(mylastname);
//		meal1.sendKeys(my);
		Select creditcards = new Select(creditcard);
		creditcards.selectByVisibleText(mycreditcard);
			creditnumber.sendKeys(mycreditnumber);

		Select expirymonths = new Select(expirymonth);
			expirymonths.selectByIndex(myexpirymonth);

		Select expiryyears = new Select(expiryyear);
			expiryyears.selectByVisibleText(myexpiryyear);
		
		billfirstname.sendKeys(mybillfirstname);
//		billmidname.sendKeys(mybillmidname);
		billlastname.sendKeys(mybilllastname);
//		ticketlesscheck.click();
		billaddress1.sendKeys(mybilladdress1);
		billaddress2.sendKeys(mybilladdress2);
		billcity.sendKeys(mybillcity);
		billstate.sendKeys(mybillstate);
		billzip.sendKeys(mybillzip);
		sameasbillcheck.click();
		
		try {
			Screenshot.takeScreenshot(driver, "OrderInfo");
		} catch (IOException ioe) {
			System.out.println("Exception to take screenshot: ioe");
		}
	
		buyflightsbtn.click();
		System.out.println("Purchase is submitted");
	  
	}

}
