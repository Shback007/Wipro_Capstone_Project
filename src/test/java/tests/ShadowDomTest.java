package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ShadowDomPage;

public class ShadowDomTest extends BaseTest{
	
	@Test(priority=1,
			description = "Verify Shadow DOM and Nested Shadow DOM Element Interactions",
			groups = {"smoke","regression"})
	public void verifyShadowDomElements() {
		
		logger.info("Shadow DOM Test Started");
		
		ShadowDomPage sdp = new ShadowDomPage(getDriver());
		
		//Mobile Label
		String mobileLabel = sdp.getMobileLabel();
		
		logger.info("Mobile Label : " + mobileLabel);
		
		Assert.assertEquals(mobileLabel, "Mobiles", "Mobile Label Assertion Failed");
		
		
		//Laptop label Nested Shadow 
		String laptopLabel = sdp.getLaptopLabel();
		
		logger.info("Laptop Label : " + laptopLabel);
		
		Assert.assertEquals(laptopLabel, "Laptops", "Laptop Label Assertion Failed");
		
		//Blog Link
		String blogLink = sdp.getBlogLinkText();
		
		logger.info("Blog Link : " + blogLink);
		
		Assert.assertEquals(blogLink, "Blog", "Blog Link Assertion Failed");
		
		//Textbox
		String enteredText = sdp.enterText("Shadow DOM Testing");
		
		logger.info("Entered Text : " + enteredText);
		
		Assert.assertEquals(enteredText, "Shadow DOM Testing", "Textbox Assertion Failed");
		
		//Checkbox
		boolean checkBoxSelected = sdp.selectCheckBox();
		
		logger.info("CheckBox Selected : " + checkBoxSelected);
		
		Assert.assertTrue(checkBoxSelected, "CheckBox Assertion Failed");
		
		//File Upload
		String uploadedFile = sdp.uploadFile("sample.txt");
		
		logger.info("Uploaded File : " +uploadedFile);
		
		Assert.assertTrue(uploadedFile.contains("sample.txt"), "File Upload Assertion Failed");
		
		//Youtube Link Outside Dom
		String youtubeText = sdp.getYoutubeText();
		
		logger.info("Youtube Link : " + youtubeText);
		
		Assert.assertEquals(youtubeText,"Youtube", "Youtube Link Assertion Failed");

		logger.info("Shadow DOM Test Passed");
		
		
	}

}
