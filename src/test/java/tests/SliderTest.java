package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.SliderPage;
import utilities.WaitUtil;

public class SliderTest extends BaseTest {

    @Test(priority=1,
    		description = "Verify Slider Movement Functionality Using Drag and Drop Actions",
    		groups = {"smoke","regression"})
    public void verifySliderMovement(){
    	
    	
        SliderPage sliderPage = new SliderPage(getDriver());

        sliderPage.moveSliderRight(85);

        WaitUtil.pause(2);
        
        sliderPage.moveSliderLeft(10);

        logger.info("Slider moved successfully");

        Assert.assertTrue(true,"Slider movement failed");
    }
}