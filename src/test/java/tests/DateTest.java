package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DatePage;



public class DateTest extends BaseTest {
	
	@Test(priority =1,
			description = "Verify Date Picker 1 Calendar Selection Functionality",
			groups= {"smoke", "regression"})
	public void handleDatePicker1() {
		
		logger.info("Date Picker 1 started");
		
		DatePage dp = new DatePage(getDriver());
		
		dp.SelectDateFromDatepicker1("September", "2028","20");
		
		String selectedDate = getDriver().findElement(dp.date_Picker1).getAttribute("value");


        verifyDateSelection(selectedDate, "9/20/2028", "Date Picker 1 Assertion");
			
	}
	
	@Test(priority =2,
			description = "Verify Date Picker 2 Dropdown Calendar Selection Functionality",
			groups= {"smoke", "regression"})
	public void handleDatePicker2() {
		
		logger.info("Date Picker 2 started");
		
		DatePage dp = new DatePage(getDriver());
		
		dp.SelectDateFromDatepicker2("August", "2029", "21");
		
		String selectedDate =getDriver().findElement(dp.date_Picker2).getAttribute("value");

	    verifyDateSelection(selectedDate, "21/08/2029", "Date Picker 2 Assertion");
		
	}
	
	@Test(priority =3,
			description = "Verify Date Range Selection Functionality Using Date Picker 3",
			groups= {"regression"})
	public void handleDatePicker3() {
		
		logger.info("Date Picker 3 started");
		
		DatePage dp = new DatePage(getDriver());
		
		String result = dp.SelectDateFromDatepicker3("05-08-2026", "20-08-2026");
		
		logger.info("Date Range Result :\n"	+result	);
		
		verifyDateSelection(result, "15", "Date Picker 3 Assertion"
        );
	}
	
	//Assertion Method
	
	 public void verifyDateSelection(
	            String actualValue,
	            String expectedValue,
	            String message) {

	        Assert.assertTrue(
	                actualValue.contains(expectedValue),
	                message
	        );

	        logger.info(message + " Passed");
	    }
	
}
