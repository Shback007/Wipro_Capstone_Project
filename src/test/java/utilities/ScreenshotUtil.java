package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

public class ScreenshotUtil {
	
	public static String captureScreenShot(WebDriver driver, String testName) 
			throws IOException{
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = 
				System.getProperty("user.dir")
				+ "/screenshots/"
				+ testName
				+ ".png";
		
		File finalDestination = new File(destination);
		
		FileUtils.copyFile(source, finalDestination);
		
		return destination;
				
		
	}

}
