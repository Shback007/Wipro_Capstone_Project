package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.ScrollUtil;

public class AlertPage {
	
	private WebDriver driver;
	
	public AlertPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By normal_alert=By.id("alertBtn");
	
	private By conf_alert = By.id("confirmBtn");
	
	private By promt_alert = By.id("promptBtn");
	
	private By result = By.id("demo");
	
	public void clickAndAcceptSimpleAlert() {
		
		WebElement alertButton =driver.findElement(normal_alert);
		 
		ScrollUtil.scrollToElement(driver,alertButton);
		 
		alertButton.click();
		
		Alert myalert =driver.switchTo().alert();
		
		myalert.accept();
	}
	
	public String clickAndAcceptOrConfAlert(String op) {
		WebElement alertButton =driver.findElement(conf_alert);
		
		ScrollUtil.scrollToElement(driver, alertButton);
		
		alertButton.click();
		
		Alert myalert = driver.switchTo().alert();
		
		if(op.equalsIgnoreCase("accept"))
			myalert.accept();
		else if(op.equalsIgnoreCase("dismiss"))
			myalert.dismiss();
		
		return driver.findElement(result).getText();
	}
	
	public String clickAndPassPromtAlert(String text,String op) {
		
		WebElement alertButton =driver.findElement(promt_alert);
		
		ScrollUtil.scrollToElement(driver, alertButton);
		
		alertButton.click();
		
		Alert mypromt = driver.switchTo().alert();
		
		mypromt.sendKeys(text);
		
		if(op.equalsIgnoreCase("accept"))
			mypromt.accept();
		
		else if(op.equalsIgnoreCase("dismiss"))
			mypromt.dismiss();
		
		return driver.findElement(result).getText();
	}

}
