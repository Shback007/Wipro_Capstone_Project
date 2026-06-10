package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.TablePage;
import utilities.WaitUtil;


public class TableTest extends BaseTest {
	
	private static int PAGE_NUMBER=2;
	private static int ROW_NUMBER = 3;

    @Test(priority=1,
    		description = "Verify Maximum Price Book Details Retrieval From Static Web Table",
    		groups = {"smoke","regression"})
    public void verifyMaximumPriceBook() {

        TablePage tp = new TablePage(getDriver());
        
        logger.info("Book Detail Fetch Start");

        List<String> rowDetail = tp.getMAximumPriceBookDetails();
        
        logger.info("Maximum Price Book Details:\n "
        		+ rowDetail);
        
        //Assertion
        verifyRowCount(rowDetail.size(), 4, "Maximum Price Book Assertion");

        logger.info("Book Details Fetched Successfully");
    }
    
    @Test(priority=2,
    		description = "Verify Dynamic Web Table Data Retrieval Functionality",
    		groups = {"regression"})
    public void verifyDynamicTableDetails() {
    	
    	TablePage tp = new TablePage(getDriver());
    	
    	List<String> details = tp.getDynamicTableDetails();
    	
    	logger.info("Verifying Dynamic Table Details");
    	
    	for(String detail: details) {
    		logger.info(detail);
    	}
    	
    	//Assertion
        verifyRowCount(details.size(), 4, "Dynamic Table Assertion");
    	logger.info("Dynamic Table Details Fetched");
    }
    
    @Test(priority=3,
    		description =  "Verify Pagination Web Table Row Selection and Data Retrieval",
    		groups = {"regression"})
    public void verifyPaginationTable() {
    	
    	TablePage tp = new TablePage(getDriver());
    	
    	logger.info("Verifying Pagination Table Details");
    	
    	List<String> rowDetails = tp.selectPaginationTableRow(PAGE_NUMBER,ROW_NUMBER);
    	
    	WaitUtil.pause(0.5);
    	
    	logger.info(
    			"Selected Row Details: "
    			
    			+rowDetails);
    	
    	//Assertion
        verifyRowCount(rowDetails.size(), 4, "Pagination Table Assertion");
    	
    	
    	logger.info("Pagination Table Details Fetched");
    	
    }
    
    //Assertion Helper
    
    public void verifyRowCount(
            int actualCount,
            int expectedCount,
            String message) {

        Assert.assertEquals(
                actualCount,
                expectedCount,
                message
        );

        logger.info(message + " Passed");
    }
    
}