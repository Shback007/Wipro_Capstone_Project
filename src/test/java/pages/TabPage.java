package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.WaitUtil;

public class TabPage {

    private WebDriver driver;

    public TabPage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchBox =
            By.id("Wikipedia1_wikipedia-search-input");

    private By searchButton =
            By.xpath("//input[@type='submit']");

    private By searchResults =
            By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']//a");

    public void enterSearchText(String text) {

        WaitUtil.waitForVisibility(driver, searchBox)
                 .sendKeys(text);
    }

    public void clickSearchButton() {

        WaitUtil.waitForClickable(driver, searchButton)
                 .click();
    }

    public int getResultCount() {

        try {

            WaitUtil.pause(3);
        	
            List<WebElement> results = driver.findElements(searchResults);

            return results.size();

        } catch (Exception e) {

            return 0;
        }
    }
}