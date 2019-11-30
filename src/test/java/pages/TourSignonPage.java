package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Screenshot;

public class TourSignonPage {
WebDriver driver;
public String expected = "Find a Flight: Mercury Tours:";
	
	public TourSignonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Locate web element
	@FindBy(name="userName")
	public WebElement username;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(name="login")
	public WebElement submitbtn;
	
	//create a method
	public void doLogin(String myusername, String mypassword) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(submitbtn));
		username.sendKeys(myusername);
		password.sendKeys(mypassword);
		Screenshot.takeScreenshot(driver, "TourSignon"); 
		submitbtn.click();
	}	

}
