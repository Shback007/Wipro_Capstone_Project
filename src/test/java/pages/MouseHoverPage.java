package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.ScrollUtil;
import utilities.WaitUtil;

public class MouseHoverPage {

    private WebDriver driver;
    private Actions actions;

    public MouseHoverPage(WebDriver driver) {

        this.driver = driver;
        this.actions = new Actions(driver);
    }

    // Mouse Hover Button
    private By pointMeButton =
            By.xpath("//button[text()='Point Me']");

    private By mobilesOption =
            By.linkText("Mobiles");

    private By laptopsOption =
            By.linkText("Laptops");

    public void hoverOnPointMe() {

        WebElement element =
                WaitUtil.waitForVisibility(
                        driver,
                        pointMeButton);
        
        ScrollUtil.scrollToElement(driver, element);
        
        WaitUtil.pause(0.5);
        actions.moveToElement(element)
               .perform();
    }

    public void clickMobiles() {

        hoverOnPointMe();

        WaitUtil.waitForClickable(
                driver,
                mobilesOption)
                .click();
    }

    public void clickLaptops() {

        hoverOnPointMe();

        WaitUtil.waitForClickable(
                driver,
                laptopsOption)
                .click();
    }
}