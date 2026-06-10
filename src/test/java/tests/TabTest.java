package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.TabPage;


public class TabTest extends BaseTest {
	
	@Test(priority=1,
			description = "Verify Wikipedia Search Functionality and Result Count Validation",
			groups = {"smoke","regression"})
	public void verifyWikiPediaSearch() {
		
		logger.info("Wiki Pedia Search Test");
		
		TabPage tp = new TabPage(getDriver());
		
		tp.enterSearchText("Selenium");
	
		tp.clickSearchButton();
		
		int count = tp.getResultCount();
		
		logger.info("Total Result Found: " + count);
		
		Assert.assertTrue(count > 0 , "No results found.");
	}

}
