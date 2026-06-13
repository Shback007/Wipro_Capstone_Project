package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.DropdownUtil;
import utilities.ScrollUtil;
import utilities.WaitUtil;

public class DatePage {
	
	private WebDriver driver;
	 
	 public DatePage(WebDriver driver) {
		 this.driver=driver;
	 }
	
	//Date Picker 1 Selectors
	
	 public By date_Picker1 = By.id("datepicker");
	
	By date_Picker1_Month = By.cssSelector(".ui-datepicker-month");
	
	By date_Picker1_Year = By.cssSelector(".ui-datepicker-year");
	
	By next = By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']");
	
	By prev = By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']");
	
	By date_locator = By.xpath("//table[@class='ui-datepicker-calendar']/tbody//td/a");
	
	//Date Picker 2 Selctors
	
	 public By date_Picker2= By.xpath("//input[@id='txtDate']");
	
	By date_Picker2_Month = By.cssSelector(".ui-datepicker-month");
	
	By date_Picker2_Year = By.cssSelector(".ui-datepicker-year");
	
	//Date Picker 3 Selectors
	
	By start_Date = By.id("start-date");
	
	By end_Date = By.id("end-date");
	
	By submit_button = By.xpath("//button[@class='submit-btn']");
	
	By result = By.id("result");
	
	
	// Date Picker 1
	
	public void SelectDateFromDatepicker1(String month, String year, String date) {
		
		WebElement picker1 = driver.findElement(date_Picker1);
		
		ScrollUtil.scrollToElement(driver, picker1);
		
		picker1.click();
		
		while(true) {
			
			String currentMonth = driver.findElement(date_Picker1_Month).getText();
			
			String currentYear = driver.findElement(date_Picker1_Year).getText();
			
			if(currentMonth.equals(month) && currentYear.equals(year))
				break;
			
			int currentYearValue = Integer.parseInt(currentYear);
			
			int targetYearValue = Integer.parseInt(year);
			
			if(targetYearValue >= currentYearValue)
				driver.findElement(next).click();
			
			else driver.findElement(prev).click();				
		}
		
		selectDate(date);
	}
	
	//Date Picker 2
	
	public void SelectDateFromDatepicker2(String month, String year, String date) {
		
		WebElement picker2 = driver.findElement(date_Picker2);
		
		ScrollUtil.scrollToElement(driver, picker2);
		
		picker2.click();
		
		WebElement monthDrop = driver.findElement(date_Picker2_Month);
		
		DropdownUtil.selectByVisibleText(monthDrop, month.substring(0,3));
		
		WebElement yearDrop = driver.findElement(date_Picker2_Year);
			
		DropdownUtil.selectByVisibleText(yearDrop, year);
		
		selectDate(date);
	}
	
	// Date Picker 3
	
	public String SelectDateFromDatepicker3(String startDate, String endDate) {

			    WebElement start = driver.findElement(start_Date);

			    WebElement end = driver.findElement(end_Date);

			    ScrollUtil.scrollToElement(driver, start);

			    JavascriptExecutor js = (JavascriptExecutor) driver;

			    // Set Start Date

			    js.executeScript("arguments[0].value = arguments[1];", start, startDate);

			    // Set End Date

			    js.executeScript("arguments[0].value = arguments[1];", end, endDate);

			    // DEBUG VALUES

			    System.out.println("START FIELD VALUE : " + start.getAttribute("value"));

			    System.out.println("END FIELD VALUE : "  + end.getAttribute("value"));

			    WaitUtil.pause(1);

			    // Submit
			    driver.findElement(submit_button).click();

			    WaitUtil.pause(2);

			    String actualResult = driver.findElement(result).getText();

			    System.out.println("ACTUAL RESULT : " + actualResult);

			    return actualResult;
			}
		

	
	//Helper Method
	public void selectDate(String date) {

	    List<WebElement> dates =driver.findElements(date_locator);

	    for(WebElement dt : dates) {
	        if(dt.getText().equals(date)) {
	            dt.click();
	            break;
	        }
	    }
	}
	
	
	
	

}
