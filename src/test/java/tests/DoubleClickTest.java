package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DoubleClickPage;


public class DoubleClickTest extends BaseTest {

    @Test(priority = 1,
    		description = "Testing Double Click Copy Button",
    		groups= {"smoke"})
    public void testDoubleClickCopyText() {
    	
    	logger.info("Double Click Test Started");

        DoubleClickPage mousePage = new DoubleClickPage(getDriver());

        String originalText = mousePage.getField1Text();

        mousePage.doubleClickCopyButton();

        Assert.assertTrue(
                mousePage.verifyCopiedText(),
                "Text was not copied correctly!"
        );

        logger.info("Original Text : " + originalText);
        logger.info("Copied Text   : "
                + mousePage.getField2Text());

        logger.info("Double Click Test Passed");
    }
}