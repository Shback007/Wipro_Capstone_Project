package tests;

import java.util.Set;

import org.testng.Assert;

import org.testng.annotations.Test;

import base.BaseTest;

import pages.ListPage;
import utilities.WaitUtil;


public class ListTest extends BaseTest {
		
	@Test(priority =1,
			description = "Verify Single Selection Functionality For Color and Animal Dropdown Lists",
			groups = {"smoke","regression"})
	public void verifyDropdownList() {
		ListPage lp = new ListPage(getDriver());
				
		logger.info("Single Color Test");
		
		lp.selectColor("Red");
		
		WaitUtil.pause(2);
		
		logger.info("Single Animal Test");
		
		lp.selectAnimal("Cat");
		
		//Assertions
		
		verifySelection(lp.getSelectedColors(), Set.of("Red"), "Single color Assertion");
		
		verifySelection(lp.getSelectedAnimals(), Set.of("Cat"), "Single Animal Assertion");
	}
	@Test(priority =2,
			description = "Verify Multiple Selection Functionality For Color and Animal Dropdown Lists",
			groups = {"regression"})
	public void verifyDropdownLists() {
		ListPage lp = new ListPage(getDriver());
		String [] colors = {
				"Red","Blue","Green",};
		
		logger.info("Multiple Color Test");
		
		lp.selectMultipleColors(colors);
		
		WaitUtil.pause(2);
		
		String[] animals= { 
				"Dog","Lion","Rabbit" 
				};
		
		logger.info("Multiple Animal Test");
		
		lp.selectMultipleAnimals(animals);
		
		
		//Assertions
		verifySelection(lp.getSelectedColors(), Set.of(colors), "Multiple color Assertion");
		
		verifySelection(lp.getSelectedAnimals(), Set.of(animals), "Multiple Animal Assertion");
		
		
	}
	
	
	// COMMON ASSERTION METHOD

    public void verifySelection(
            Set<String> actualList,
            Set<String> expectedList,
            String message) {

        Assert.assertEquals(
                actualList,
                expectedList,
                message
        );

        logger.info(message + " Passed");
    }

}
