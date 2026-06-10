package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DownloadFilesPage;
import utilities.WaitUtil;



public class DownloadFilesTest extends BaseTest {

    @Test(priority=1,
    		description="Verify Text and PDF File Generation and Download Functionality",
    		groups= {"smoke", "regression"})
    public void automateDownloadFiles(){
    	
    	
    	logger.info("Download File Test Started");
    	getDriver().navigate().to(
        "https://testautomationpractice.blogspot.com/p/download-files_25.html");

        DownloadFilesPage page = new DownloadFilesPage(getDriver());

        page.enterText("Selenium Automation Testing");

        WaitUtil.pause(3);

        page.generateTextFile();

        WaitUtil.pause(3);

        page.generatePdfFile();

        WaitUtil.pause(3);

        Assert.assertTrue( page.isPdfLinkDisplayed(),
                "PDF download link was not generated");

        System.out.println("PDF Download Link Generated Successfully");

        page.clickPdfLink();

        logger.info("Current URL : " + getDriver().getCurrentUrl());

        Assert.assertTrue( getDriver().getCurrentUrl().length() > 0);

        logger.info("Download Files Test Passed");
    }
}