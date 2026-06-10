package tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import base.BaseTest;

import pages.AlertPage;

public class AlertTest extends BaseTest {

    @Test(priority = 1 ,
    		description = "Verify Simple ALert Accept Functionality",
    		groups = {"smoke", "regression"})
    public void handleSimpleAlert() {

        logger.info("Simple Alert Test Started");

        AlertPage ap =  new AlertPage(getDriver());

        ap.clickAndAcceptSimpleAlert();

        logger.info("Simple Alert Accepted Successfully");
    }

    @Test(priority = 2,
    		description = "Verify Confirm Alert Accept Functionality",
    		groups = {"smoke", "regression"})
    public void handleConfirmAlertAccept() {

        logger.info("Confirm Alert Accept Test Started");

        AlertPage ap =  new AlertPage(getDriver());

        String result = ap.clickAndAcceptOrConfAlert("accept");

        logger.info("Confirm Alert Result : " + result);

        Assert.assertEquals(
                result,
                "You pressed OK!",
                "Confirm Alert Accept Assertion Failed");
    }

    @Test(priority = 3,
    		description = "Verify Confirm Alert Dismiss Functionality",
    		groups = {"regression"})
    public void handleConfirmAlertDismiss() {

        logger.info("Confirm Alert Dismiss Test Started");

        AlertPage ap =  new AlertPage(getDriver());

        String result = ap.clickAndAcceptOrConfAlert("dismiss");

        logger.info("Confirm Alert Result : " + result);

        Assert.assertEquals(
                result,
                "You pressed Cancel!",
                "Confirm Alert Dismiss Assertion Failed");
    }

    @Test(priority = 4,
    		description = "Verify Prompt Alert Accept Functionality",
    		groups= {"regression"})
    public void handlePromptAlertAccept() {

        logger.info( "Prompt Alert Accept Test Started");

        AlertPage ap =  new AlertPage(getDriver());

        String result =
                ap.clickAndPassPromtAlert(
                        "David",
                        "accept");
        
        logger.info("Prompt Alert Result : " + result);

        Assert.assertTrue(result.contains("David"),
                "Prompt Alert Accept Assertion Failed");
    }

    @Test(priority = 5,
    		description = "Verify Prompt Alert Dismiss Functionality",
    		groups = {"regression"})
    public void handlePromptAlertDismiss() {

        logger.info("Prompt Alert Dismiss Test Started");

        AlertPage ap =  new AlertPage(getDriver());

        String result =
                ap.clickAndPassPromtAlert(
                        "David",
                        "dismiss");

        logger.info("Prompt Alert Result : " + result);

        Assert.assertEquals(
                result,
                "User cancelled the prompt.",
                "Prompt Alert Dismiss Assertion Failed");
    }
}