package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DropDownPage;


public class DropDownTest extends BaseTest {
	
	@Test(priority=1,
			description = "Verify Scrollable Dropdown Selection Functionality",
			groups = {"smoke","regression"})
	public void verifyScrollingDropdown() {
		
		logger.info("Scrolling Dropdown Test Started");
		
		DropDownPage dp = new DropDownPage(getDriver());
		
		String selectedOption = dp.selectValue("Item 59");
		
		logger.info("Selected Option: " + selectedOption);
		
		Assert.assertEquals(selectedOption, "Item 59", "Dropdown Selection Assertion Failed");
		
		logger.info("Scrolling Dropdown Test Passed");
	}

}
