package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class GUIFormPage {

	private WebDriver driver;

    // Constructor
    public GUIFormPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By txtName = By.id("name");

    private By txtEmail = By.id("email");

    private By txtPhone = By.id("phone");
    
    private By txtAddress = By.id("textarea");

    private By countryDropdown = By.id("country");



    // Enter Name
    public void enterName(String name) {

        driver.findElement(txtName).sendKeys(name);
    }


    // Enter Email
    public void enterEmail(String email) {

        driver.findElement(txtEmail).sendKeys(email);
    }


    // Enter Phone
    public void enterPhone(String phone) {

        driver.findElement(txtPhone).sendKeys(phone);
    }
    
    //Enter Address 
    public void enterAddress(String address) {
    	driver.findElement(txtAddress).sendKeys(address);
    }


    // Select Gender
    public void selectGender(String gender) {

        driver.findElement(
                By.id(gender.toLowerCase()))
                .click();
    }


    // Select Multiple Days
    public void selectDays(String days) {

        String[] dayArray = days.split(",");

        for(String day : dayArray) {

            driver.findElement(
                    By.id(day.trim().toLowerCase()))
                    .click();
        }
    }


    // Select Country
    public void selectCountry(String country) {

        Select drp = new Select(driver.findElement(countryDropdown));

        drp.selectByVisibleText(country);
    }
    
    //Getter Helpers
    public String getNameValue() {

        return driver.findElement(txtName)
                     .getAttribute("value");
    }



    public String getEmailValue() {

        return driver.findElement(txtEmail)
                     .getAttribute("value");
    }



    public String getPhoneValue() {

        return driver.findElement(txtPhone)
                     .getAttribute("value");
    }



    public String getAddressValue() {

        return driver.findElement(txtAddress)
                     .getAttribute("value");
    }



    public String getSelectedCountry() {

        Select drp =

                new Select(

                    driver.findElement(
                            countryDropdown));



        return drp.getFirstSelectedOption()
                  .getText();
    }
    
}