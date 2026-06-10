package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.ScrollUtil;
import utilities.WaitUtil;

public class SliderPage {

    private WebDriver driver;
    private Actions actions;

    public SliderPage(WebDriver driver) {

        this.driver = driver;
        this.actions = new Actions(driver);
    }

    // Slider Handle
    private By left_slider = By.xpath("//span[contains(@class,'ui-slider-handle')][1]");
    private By right_slider = By.xpath("//span[contains(@class,'ui-slider-handle')][2]");

    // Price Range Text
    private By priceRange = By.id("amount");

    public void moveSliderRight(int pixels) {

        WebElement sliderElement = WaitUtil.waitForVisibility(driver,right_slider);
        
        ScrollUtil.scrollToElement(driver, sliderElement);

        actions.clickAndHold(sliderElement).moveByOffset(pixels, 0).release().perform();
    }

    public void moveSliderLeft(int pixels) {

        WebElement sliderElement = WaitUtil.waitForVisibility(driver,left_slider);
        
        ScrollUtil.scrollToElement(driver, sliderElement);

        actions.clickAndHold(sliderElement).moveByOffset(-pixels, 0).release().perform();
    }

    public String getPriceRange() {

        return driver.findElement(priceRange).getText();
    }
}