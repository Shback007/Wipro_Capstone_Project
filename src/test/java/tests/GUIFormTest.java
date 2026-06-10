package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.GUIFormPage;
import utilities.ExcelUtility;



public class GUIFormTest extends BaseTest {



    @Test(priority=1,dataProvider = "formData",
    		description = "Verify GUI Form Submission Using Excel Data Driven Testing",
    		groups= {"smoke","regression"})
    public void verifyFormSubmission(String name,
                                     String email,
                                     String phone,
                                     String address,
                                     String gender,
                                     String days,
                                     String country) {
    	
    	logger.info("Form Test Started");

        GUIFormPage form = new GUIFormPage(getDriver());
        
        logger.info("Entering Name");
        
        form.enterName(name);
        
        logger.info("Entering Email");

        form.enterEmail(email);
        
        logger.info("Entering Phone");

        form.enterPhone(phone);
        
        logger.info("Entering Address");
        
        form.enterAddress(address);
        
        logger.info("Entering Gender");

        form.selectGender(gender);
        
        logger.info("Entering Days");

        form.selectDays(days);
        
        logger.info("Entering Country");

        form.selectCountry(country);
        
        //Assertions 
        verifyFieldValue(form.getNameValue(), name, "Name Assertion");
        verifyFieldValue(form.getEmailValue(), email, "Email Assertion");
        verifyFieldValue(form.getPhoneValue(), phone, "Phone Assertion");
        verifyFieldValue(form.getAddressValue(), address, "Address Assertion");
        verifyFieldValue(form.getSelectedCountry(), country, "Country Assertion");

        logger.info("Form Test Completed");
    }

    
    //Assertion Helper
    
    public void verifyFieldValue(

            String actualValue,

            String expectedValue,

            String message) {


        Assert.assertEquals(

                actualValue,

                expectedValue,

                message
        );
        logger.info(message + " Passed");
    }


    // DataProvider Method

    @DataProvider(name = "formData")
    public Object[][] getFormData()throws Exception {

        return ExcelUtility.getTestData("FormData");
    }
}