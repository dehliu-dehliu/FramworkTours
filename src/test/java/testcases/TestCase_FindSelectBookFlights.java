package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.TourFindFlightsPage;
import pages.TourWelcomePage;

public class TestCase_FindSelectBookFlights {
	
	WebDriver driver;
	TourFindFlightsPage tffp;
	
	@Test(priority=2, description = "find available flights with provided search criteria")
	  public void findAvailableFlights() throws Exception {
		  System.out.println("-- In findAvailableFlights method");
		  tffp = new TourFindFlightsPage(driver);
		  tffp.selectfindAvailableFlights("roundtrip", "1", "Frankfurt", "11", "28",
					"London", "12", "16", "business", "Blue Skies Airlines");
	  }
}
