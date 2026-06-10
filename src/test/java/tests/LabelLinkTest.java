package tests;

import java.util.List;

import java.util.Map;

import org.testng.Assert;

import org.testng.annotations.Test;

import base.BaseTest;


import pages.LabelLinkPage;



public class LabelLinkTest extends BaseTest {

    @Test(priority = 1,
    		description="Verify Mobile Labels Displayed Correctly",
    		groups = {"smoke","regression"})

    public void verifyMobileLabels() {

        logger.info("Mobile Labels Test Started");

        LabelLinkPage page = new LabelLinkPage(getDriver());

        List<String> labels =  page.getMobileLabels();

        for(String label : labels) {

            logger.info("Mobile Label : " + label);
        }

        Assert.assertTrue(labels.contains("Samsung"), "Samsung Label Missing");

        Assert.assertTrue(labels.contains("Real Me"), "Real Me Label Missing");

        Assert.assertTrue(labels.contains("Moto"), "Moto Label Missing");

        logger.info("Mobile Labels Test Passed");
    }

    @Test(priority = 2,
    		description = "Verify Laptop Links Displayed Correctly",
    		groups = {"smoke","regression"})
    public void verifyLaptopLinks() {

        logger.info("Laptop Links Test Started");

        LabelLinkPage page =  new LabelLinkPage(getDriver());

        List<String> links = page.getLaptopLinks();

        for(String link : links) {

            logger.info("Laptop Link : " + link);
        }

        Assert.assertTrue(links.contains("Apple"),"Apple Link Missing");

        Assert.assertTrue(links.contains("Lenovo"),"Lenovo Link Missing");

        Assert.assertTrue(links.contains("Dell"), "Dell Link Missing");

        logger.info("Laptop Links Test Passed");
    }

    @Test(priority = 3,
    		description = "Verify Broken Links Validation Functionality",
    		groups = {"regression"})

    public void verifyBrokenLinks() {
    	
        logger.info("Broken Links Test Started");
        
        LabelLinkPage page = new LabelLinkPage(getDriver());

        Map<String,Integer> results = page.validateBrokenLinks();

        for(Map.Entry<String,Integer> entry : results.entrySet()) {

            logger.info(entry.getKey() + " -> " + entry.getValue());

            Assert.assertTrue(entry.getValue() >= 400, "Valid Link Found Instead Of Broken Link");
        }

        logger.info("Broken Links Test Passed");
    }
}