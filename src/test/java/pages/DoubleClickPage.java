package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.ScrollUtil;
import utilities.WaitUtil;

public class DoubleClickPage {

    private WebDriver driver;
    private Actions actions;

    public DoubleClickPage(WebDriver driver) {

        this.driver = driver;
        this.actions = new Actions(driver);
    }


    // Double Click Locators
    private By field1 = By.id("field1");

    private By field2 = By.id("field2");

    private By copyTextButton = By.xpath("//button[contains(text(),'Copy Text')]");


    public void doubleClickCopyButton() {

        WebElement button = WaitUtil.waitForClickable(driver,copyTextButton);
        
        ScrollUtil.scrollToElement(driver, button);

        actions.doubleClick(button).perform();
    }

    public String getField1Text() {

        return driver.findElement(field1).getAttribute("value");
    }

    public String getField2Text() {

        return driver.findElement(field2).getAttribute("value");
    }

    public boolean verifyCopiedText() {

        return getField1Text().equals(getField2Text());
    }

}