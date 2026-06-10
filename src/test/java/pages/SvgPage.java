package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.ScrollUtil;

public class SvgPage {

    private WebDriver driver;

    public SvgPage(WebDriver driver) {
        this.driver = driver;
    }

    private By redCircle = By.xpath("//*[name()='circle']");

    private By greenRect = By.xpath("//*[name()='rect']");

    private By blueTriangle = By.xpath("//*[name()='polygon']");

    public List<String> verifySvgElements() {
    	
    	WebElement redCricle = driver.findElement(redCircle);
    	
    	ScrollUtil.scrollToElement(driver, redCricle);
    	
    	 List<String> results = new ArrayList<>();

         results.add("Red Circle Displayed : " + redCricle.isDisplayed());

         results.add("Green Rectangle Displayed : " + driver.findElement(greenRect).isDisplayed());

         results.add("Blue Triangle Displayed : " + driver.findElement(blueTriangle).isDisplayed());

         return results;
    }
}