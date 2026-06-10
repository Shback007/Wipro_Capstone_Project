package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
	
	//Pause Execution
	private static final int WAIT_TIME=20;
	
	
	public static void pause(double seconds) {
		try {
			Thread.sleep((int)(seconds *1000));
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	 // EXPLICIT WAIT

	public static boolean waitForText(

	        WebDriver driver,
	        By locator,
	        String expectedText,
	        int seconds) {
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));

	    return wait.until(ExpectedConditions.textToBe(locator,expectedText));
	}
	
	 public static WebElement waitForClickable(WebDriver driver, By locator) {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));

	        return wait.until(ExpectedConditions.elementToBeClickable(locator));
	  }
	 
	 public static WebElement waitForVisibility(WebDriver driver, By locator) {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));

	        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }

}
