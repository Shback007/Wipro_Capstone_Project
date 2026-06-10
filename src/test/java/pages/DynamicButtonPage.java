package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import utilities.WaitUtil;

public class DynamicButtonPage {

    private WebDriver driver;

    public DynamicButtonPage(WebDriver driver) {

        this.driver = driver;
    }

    // Start Button

    private By startButton = By.xpath("//button[text()='START']");

    // Stop Button

    private By stopButton = By.xpath("//button[text()='STOP']");

    // Click Start

    public void clickStartButton() {
    	WebElement start = WaitUtil.waitForVisibility(driver,startButton);

        ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block:'center'});", start);

        start.click();
    }

    // Verify Stop Displayed

    public boolean isStopButtonDisplayed() {
        try {

            WaitUtil.waitForVisibility(driver,stopButton);
            return true;
        }
        catch(Exception e) {

            return false;
        }
    }

    // Click Stop

    public void clickStopButton() {
        WebElement stop =
                WaitUtil.waitForVisibility(driver,stopButton);

        ((JavascriptExecutor) driver).executeScript(
        		"arguments[0].scrollIntoView({block:'center'});",stop);

        stop.click();
    }

    // Verify Start Displayed Again

    public boolean isStartButtonDisplayed() {
        try {
            WaitUtil.waitForVisibility(driver,startButton);

            return true;
        }
        catch(Exception e) {

            return false;
        }
    }
}