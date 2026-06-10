package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.ScrollUtil;
import utilities.WaitUtil;


public class HiddenAjaxPage {
	
	private WebDriver driver;

    public HiddenAjaxPage(WebDriver driver) {
        this.driver = driver;
    }
    
    private By inputBox1 = By.id("input1");
    private By inputBox2 = By.id("input2");

    private By checkbox1 = By.id("checkbox1");
    private By checkbox2 = By.id("checkbox2");

    private By toggleInput2 = By.xpath("//button[contains(text(),'Toggle Input Box 2')]");

    private By toggleCheckbox2 = By.xpath("//button[contains(text(),'Toggle Checkbox 2')]");

    private By ajaxButton = By.xpath("//button[contains(text(),'Load AJAX Content')]");

    private By status = By.id("statusLabel");
    
    
    public void enterInput1(String text) {
        driver.findElement(inputBox1).sendKeys(text);
    }

    public void showInput2() {
    	
        driver.findElement(toggleInput2).click();
    }

    public void enterInput2(String text) {
        driver.findElement(inputBox2).sendKeys(text);
    }

    public void selectCheckbox1() {

        WebElement cb =
                driver.findElement(checkbox1);

        if(!cb.isSelected()) {
            cb.click();
        }
    }

    public void showCheckbox2() {
        driver.findElement(toggleCheckbox2).click();
    }

    public void selectCheckbox2() {

        WebElement cb =
                driver.findElement(checkbox2);

        if(!cb.isSelected()) {
            cb.click();
        }
    }

    public void loadAjaxContent() {
        WebElement ajax = driver.findElement(ajaxButton);
        
        ScrollUtil.scrollToElement(driver, ajax);
        
        ajax.click();
        
        WaitUtil.waitForText(driver, status, "AJAX content loaded", 10);
    }

    public String getStatus() {
        return driver.findElement(status).getText();
    }

}
