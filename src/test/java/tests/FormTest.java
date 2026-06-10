package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.FormPage;


public class FormTest extends BaseTest {
	
    @Test(priority = 1,
    		description="Verify Multi Section Form Input and Submission Functionality",
    		groups= {"smoke","regression"})
    public void testForm() {

        logger.info("Form Test Started");

        FormPage formPage = new FormPage(getDriver());

        formPage.fillAndSubmitForm();

        // ASSERTIONS
        verifyText(
                formPage.getSection1Value(),
                "Automation Section 1",
                "Section 1 Assertion"
        );

        verifyText(
                formPage.getSection2Value(),
                "Automation Section 2",
                "Section 2 Assertion"
        );

        verifyText(
                formPage.getSection3Value(),
                "Automation Section 3",
                "Section 3 Assertion"
        );

        logger.info("Form Test Completed");
    }


    // Assertion
    public void verifyText(
            String actualText,
            String expectedText,
            String message) {

        Assert.assertEquals(
                actualText,
                expectedText,
                message
        );

        logger.info(message + " Passed");
    }
}