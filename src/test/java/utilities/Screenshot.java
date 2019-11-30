package utilities;

import java.io.File;
import java.util.Date;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Screenshot {
	
	public static void takeScreenshot(WebDriver driver, String myfileName) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String fileName = timeStamp + myfileName + ".png";
		System.out.println ("ScreenshotName is: "+fileName);
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File("./src/test/resources/screenshots/"+fileName));
	}

}