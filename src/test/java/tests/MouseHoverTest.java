package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.MouseHoverPage;


public class MouseHoverTest extends BaseTest {

    @Test(priority=1,
    		description = "Verify Mouse Hover Functionality and Mobiles Option Selection",
    		groups = {"smoke","regression"})
    public void verifyMouseHover1() {
    	
    	logger.info("Mouse Hover Test 1");

        MouseHoverPage page = new MouseHoverPage(getDriver());

        page.hoverOnPointMe();

        page.clickMobiles();

        logger.info("Mouse Hover and Mobiles Click Successful");
    }
    
    @Test(priority=2,
    		description = "Verify Mouse Hover Functionality and Laptops Option Selection",
    		groups = {"regression"})
    public void verifyMouseHover2() {
    	
    	logger.info("Mouse Hover Test 2");

        MouseHoverPage page = new MouseHoverPage(getDriver());

        page.hoverOnPointMe();

        page.clickLaptops();

        logger.info("Mouse Hover and Laptops Click Successful");
    }
}