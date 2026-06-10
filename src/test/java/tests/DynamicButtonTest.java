package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DynamicButtonPage;
import utilities.WaitUtil;



public class DynamicButtonTest extends BaseTest {

    @Test(priority=1,
    		description= "Verify Dynamic START and STOP Button Functionality",
    		groups = {"smoke","regression"})
    public void verifyDynamicButton() {

        logger.info("Dynamic Button Test Started");

        DynamicButtonPage page = new DynamicButtonPage(getDriver());

        logger.info("Clicking START Button");

        page.clickStartButton();

        Assert.assertTrue(
                page.isStopButtonDisplayed(),
                "STOP Button Not Displayed");

        logger.info("STOP Button Displayed");

        WaitUtil.pause(2);

        logger.info("Clicking STOP Button");

        page.clickStopButton();

        Assert.assertTrue(

                page.isStartButtonDisplayed(),

                "START Button Not Displayed Again");

        logger.info("START Button Displayed Again");

        logger.info("Dynamic Button Test Passed");
    }
}