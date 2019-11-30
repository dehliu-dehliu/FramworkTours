package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TourWelcomePage {
WebDriver driver;
	
	public TourWelcomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Locate web element
	@FindBy(xpath = "//a[contains(text(),'SIGN-ON')]")
	public WebElement signonlink;
	
	public void linkCount() {
		  System.out.println("-- In linkAccount method");
		  
		  List<WebElement> links = driver.findElements(By.tagName("a"));
		  int i =links.size();
		  System.out.println("Totle links on the NewTours Home page is "+i);	
		  String link;
		  String linkTxt;
		  for (int j=0; j<i; j++){
				link = links.get(j).getAttribute("href");
				//Print out all links
				System.out.println("Link "+(j+1)+": "+link);
				//Navigate to each of the links
				linkTxt = links.get(j).getText();
				System.out.println("``````The link Text is: "+linkTxt);
//				driver.navigate().to(link);
		  }
	}
}
