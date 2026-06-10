package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.ScrollUtil;

public class DownloadFilesPage {

    private WebDriver driver;

    public DownloadFilesPage(WebDriver driver) {
        this.driver = driver;
    }

    private By textArea = By.tagName("textarea");

    private By generateTxtBtn = By.id("generateTxt");

    private By generatePdfBtn = By.id("generatePdf");

    private By pdfDownloadLink = By.id("pdfDownloadLink");

    private By browserPdfBtn = By.xpath("//button[text()='Download PDF File']");

    public void enterText(String text) {
        driver.findElement(textArea).clear();
        driver.findElement(textArea).sendKeys(text);
    }

    public void generateTextFile() {
        WebElement txtButton = driver.findElement(generateTxtBtn);
        
        ScrollUtil.scrollToElement(driver, txtButton);
        
        txtButton.click();
    }

    public void generatePdfFile() {
        driver.findElement(generatePdfBtn).click();
    }

    public boolean isPdfLinkDisplayed() {
        return driver.findElement(pdfDownloadLink).isDisplayed();
    }

    public void clickPdfLink() {
        driver.findElement(pdfDownloadLink).click();
    }

    public void openPdfInBrowser() {

        WebElement button =
                driver.findElement(browserPdfBtn);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();",
                        button);
    }
}