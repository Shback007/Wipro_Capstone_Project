package tests;

import java.util.List;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.SvgPage;
import utilities.WaitUtil;


public class SvgTest extends BaseTest {
	
	@Test(priority =1,
			description = "Verify SVG Elements Visibility and Validation Functionality",
			groups = {"smoke","regression"})
	public void veriFySVGElement() {
		
		logger.info("Starting Svg Element Test");
		
		SvgPage page = new SvgPage(getDriver());
		
		WaitUtil.pause(1);
		
		 List<String> results = page.verifySvgElements();
		 
		 for(String result:results)
			 logger.info(result);
		 
		 logger.info("Svg Element Test Completed");
		
	}

}
