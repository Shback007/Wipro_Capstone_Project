package tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import base.BaseTest;

import pages.UploadPage;



public class UploadTest extends BaseTest {

    // Common Assertion Method
    public void verifyUpload(
            String actualMessage,
            String expectedValue,
            String message) {
        Assert.assertTrue(
        		actualMessage.contains(expectedValue)
        		,message
        );

        logger.info(message + " Passed");
    }

    @Test(priority = 1,
    		description = "Verify Single File Upload Functionality",
    		groups = {"smoke","regression"})
    public void verifySingleFileUpload() {

        UploadPage up = new UploadPage(getDriver());

        logger.info("Single File Upload Started");

        String message = up.uploadSingleFile("sample.txt");

        logger.info("Upload Message : " + message);

        // ASSERTION
        verifyUpload(
                message,
               "sample.txt",
               "Single File Upload Assertion"
        );
    }

    @Test(priority = 2,
    		description = "Verify Multiple File Upload Functionality",
    		groups = {"regression"})

    public void verifyMultipleFileUpload() {

        UploadPage up = new UploadPage(getDriver());

        logger.info("Multiple File Upload Started");

        String[] files = {
                "demo.txt",
                "sample.txt"
        };

        String message = up.uploadMultipleFiles(files);

        logger.info(
                "Upload Message : "
                + message);
        
        // ASSERTIONS

        verifyUpload(
                message,
                "demo.txt",
                "Multiple File Upload Assertion 1"
        );

        verifyUpload(
                message,
                "sample.txt",
                "Multiple File Upload Assertion 2"
        );

        logger.info("Multiple File Upload Completed");
    }
}