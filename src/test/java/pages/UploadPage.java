package pages;

import java.io.File;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.ScrollUtil;

public class UploadPage {

    private WebDriver driver;



    public UploadPage(WebDriver driver) {

        this.driver = driver;
    }


    // Single File Upload Locators

    private By singleFileUpload = By.id("singleFileInput");


    private By uploadSingleButton = By.xpath("//button[text()='Upload Single File']");


    private By singleUploadMessage = By.id("singleFileStatus");


    // Multiple File Upload Locators

    private By multipleFileUpload = By.id("multipleFilesInput");


    private By uploadMultipleButton = By.xpath("//button[text()='Upload Multiple Files']");


    private By multipleUploadMessage = By.id("multipleFilesStatus");


    // Single File Upload

    public String uploadSingleFile(String fileName) {


        String filePath = System.getProperty("user.dir")
                          + "/src/test/resources/"
                          + fileName;

        WebElement singleUpload = driver.findElement(singleFileUpload);
        
        ScrollUtil.scrollToElement(driver, singleUpload);

        singleUpload.sendKeys(filePath);

        WebElement uploadButton = driver.findElement(uploadSingleButton);
        
        uploadButton.click();

        return driver.findElement(singleUploadMessage).getText();
    }


    // Multiple File Upload
    public String uploadMultipleFiles(
            String[] fileNames) {

        StringBuilder files = new StringBuilder();

        for(int i = 0; i < fileNames.length; i++) {

            String filePath = System.getProperty("user.dir")
                    		  + "/src/test/resources/"
                              + fileNames[i];

            // Verify Email Exists

            File file = new File(filePath);

            if(!file.exists()) {
                throw new RuntimeException("File Not Found : " + filePath);
            }

            files.append(file.getAbsolutePath());

            if(i != fileNames.length - 1) {
                files.append("\n");
            }
        }
        
        WebElement multiUpload = driver.findElement(multipleFileUpload);
        
        ScrollUtil.scrollToElement(driver, multiUpload);
        
        multiUpload.sendKeys(files.toString());

        driver.findElement(uploadMultipleButton).click();

        return driver.findElement(multipleUploadMessage).getText();
    }
}