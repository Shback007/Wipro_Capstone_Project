package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HiddenAjaxPage;


public class HiddenAjaxTest extends BaseTest {

    @Test(priority=1,
    		description="Verify Hidden Elements and AJAX Content Loading Functionality",
    		 groups = {"smoke","regression"})
    public void verifyHiddenAjaxPage() {

        logger.info("Hidden Ajax Test Started");

        // NAVIGATE TO PAGE

        getDriver().navigate().to(
            "https://testautomationpractice.blogspot.com/p/gui-elements-ajax-hidden.html"
        );

        HiddenAjaxPage hp = new HiddenAjaxPage(getDriver());

        hp.enterInput1("Automation 1");

        hp.showInput2();

        hp.enterInput2("Automation 2");

        hp.selectCheckbox1();

        hp.showCheckbox2();

        hp.selectCheckbox2();

        hp.loadAjaxContent();

        // Assertion

        Assert.assertEquals(
                hp.getStatus(),
                "AJAX content loaded",
                "Ajax Status Assertion Failed"
        );

        logger.info("Ajax Status Assertion Passed");

        logger.info("Hidden Ajax Test Completed");
    }
}