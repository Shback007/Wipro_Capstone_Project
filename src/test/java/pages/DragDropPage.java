package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.ScrollUtil;
import utilities.WaitUtil;

public class DragDropPage {

    private WebDriver driver;
    private Actions actions;

    public DragDropPage(WebDriver driver) {

        this.driver = driver;
        this.actions = new Actions(driver);
    }

    //Locators

    private By sourceElement = By.id("draggable");

    private By targetElement = By.id("droppable");

  //Drag and Drop

    public void performDragAndDrop() {

        WebElement source = WaitUtil.waitForVisibility(driver, sourceElement);

        WebElement target = WaitUtil.waitForVisibility(driver, targetElement);
        
        ScrollUtil.scrollToElement(driver, target);

        actions.dragAndDrop(source, target).perform();
    }


    //Validation

    public String getDropMessage() {

        return driver.findElement(targetElement).getText();
    }

    public boolean isDroppedSuccessfully() {

        return getDropMessage().equalsIgnoreCase("Dropped!");
    }
}