package testcases;

import org.testng.annotations.Test;

import pages.TourBookFlightsPage;
import pages.TourFindFlightsPage;
import pages.TourFlightConfirmationPage;
import pages.TourReserveFlightsPage;
import pages.TourSignonPage;
import pages.TourWelcomePage;
import utilities.Screenshot;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class TestCase_TourSignon {
	WebDriver driver;
	TourWelcomePage twp;
	TourSignonPage tsp;
	TourFindFlightsPage tffp;
	TourReserveFlightsPage trfp;
	TourBookFlightsPage tbfp;
	TourFlightConfirmationPage tfcp;	
	
  @Test
  public void welcomePageLinks() {
	  System.out.println("------In welcomePageLinks method");
	  twp.linkCount();
  }
  
  @Test(priority=1)
  public void singon() throws Exception {
	  System.out.println("------In signon method");
	  twp.signonlink.click();
	  tsp = new TourSignonPage(driver);
	  tsp.doLogin("tutorial", "tutorial");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  Assert.assertEquals(driver.getTitle(), tsp.expected);
  }
  
  @Test(priority=2, description = "find available flights with provided search criteria")
  public void findAvailableFlights() throws Exception {
	  System.out.println("-- In findAvailableFlights method");
	  tffp = new TourFindFlightsPage(driver);
	  tffp.selectfindAvailableFlights("roundtrip", "1", "Frankfurt", "11", "28",
				"London", "12", "16", "business", "Blue Skies Airlines");
	  Assert.assertEquals(driver.getTitle(), tffp.expected);
  }
	
  @Test (priority=3, description = "Select and sreserve available flight(s)")
  public void reserveFlights() {
	  trfp = new TourReserveFlightsPage(driver);
	  trfp.reserveFlights();
	  Assert.assertEquals(driver.getTitle(), trfp.expected);
  }
  
  @Test (priority=4, description = "Book reserved flight(s)")
  public void bookFlights() {
	  tbfp = new TourBookFlightsPage(driver);
	  tbfp.orderFlightsSameBillAddress ("fname","lname","American Express","1234098723458765",10,"2000",
			  "bfname","blname","111 test road","unit101", "New York","Washington", "109872");
	  
	  Assert.assertEquals(driver.getTitle(), tbfp.expected);
  }
  
  @BeforeSuite
  public void setup() {
		System.out.println("-- In Setup method");
	  	System.setProperty("webdriver.chrome.driver", "c:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		twp = new TourWelcomePage(driver);
				
		System.out.println("ALL Page objects are initialized");
		
		driver.get("http://newtours.demoaut.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Browser is opened for the landing page");
		
	}

  @AfterSuite
  public void tearDown() throws Exception {
		System.out.println("-- In tearDown method");
		Screenshot.takeScreenshot(driver, "tearDown"); 
		driver.quit();	
	}
}
