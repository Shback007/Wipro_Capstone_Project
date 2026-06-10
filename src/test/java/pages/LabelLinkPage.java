package pages;

import java.net.HttpURLConnection;

import java.net.URL;

import java.util.ArrayList;

import java.util.LinkedHashMap;

import java.util.List;

import java.util.Map;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import utilities.ScrollUtil;

public class LabelLinkPage {

    private WebDriver driver;

  
    public LabelLinkPage(WebDriver driver) {

        this.driver = driver;
    }

    // Mobile Labels

    private By mobileLabels = By.xpath("//h4[text()='Mobile Labels']/following-sibling::label");

        
    // Laptop Links

    private By laptopLinks = By.xpath("//h4[text()='Laptop Links']/following-sibling::a");


    // Broken Links

    private By brokenLinks = By.xpath("//h4[text()='Broken Links']/following-sibling::a");

             
    // Get Mobile Label Texts

    public List<String> getMobileLabels() {

        WebElement firstLabel = driver.findElements(mobileLabels).get(0);

        ScrollUtil.scrollToElement(driver,firstLabel);

        List<String> labels = new ArrayList<>();


        List<WebElement> allLabels = driver.findElements(mobileLabels);

        for(WebElement label : allLabels) 

            labels.add(label.getText());
        
        return labels;
    }

    // Get Laptop Links Text

    public List<String> getLaptopLinks() {

        WebElement firstLink = driver.findElements(laptopLinks).get(0);

        ScrollUtil.scrollToElement(driver, firstLink);

        List<String> links =  new ArrayList<>();

        List<WebElement> allLinks = driver.findElements(laptopLinks);

        for(WebElement link : allLinks) 

            links.add(link.getText());
        return links;
    }




    // Validate Broken Links

    @SuppressWarnings("deprecation")
	public Map<String,Integer> validateBrokenLinks() {

        WebElement firstBrokenLink = driver.findElements(brokenLinks).get(0);

        ScrollUtil.scrollToElement(driver,firstBrokenLink);

        Map<String,Integer> results = new LinkedHashMap<>();

        List<WebElement> links = driver.findElements(brokenLinks);

        for(WebElement link : links) {

            String url = link.getAttribute("href");

            String linkText = link.getText();

            try {

				URL brokenUrl =  new URL(url);

                HttpURLConnection connection =(HttpURLConnection) brokenUrl.openConnection();

                connection.connect();

                int responseCode = connection.getResponseCode();

                results.put(linkText, responseCode);

            } catch (Exception e) {

                results.put(linkText, -1);
            }
        }

        return results;
    }
}