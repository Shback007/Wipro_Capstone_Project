package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverFactory {

    // Thread Safe Driver

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Initialize Driver

    public static WebDriver initializeDriver() {

        String browser = ConfigReader.getProperty("browser");
        
        String headless = ConfigReader.getProperty("headless");

        switch(browser.toLowerCase()) {

        case "chrome":
        	
        	ChromeOptions chromeOptions = new ChromeOptions();
        	
        	if(headless.equalsIgnoreCase("true")) {
        		
        		chromeOptions.addArguments("--headless=new");
        		
        		chromeOptions.addArguments("--disable-gpu");
        		
        		chromeOptions.addArguments("--window-size=1920,1080");
        	}
        	
            driver.set(new ChromeDriver(chromeOptions));

            break;

        case "edge":
        	
        	EdgeOptions edgeOptions = new EdgeOptions();
        	
        	if(headless.equalsIgnoreCase("true")) {
        		
        		edgeOptions.addArguments("--headless=new");
        		
        		edgeOptions.addArguments("--disable-gpu");
        		
        		edgeOptions.addArguments("--window-size=1920,1080");
        	}

            driver.set(new EdgeDriver(edgeOptions));

            break;

        default:

            throw new RuntimeException("Invalid Browser : " + browser);
        }


        getDriver().manage().window().maximize();


        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return getDriver();
    }


    public static WebDriver getDriver() {

        return driver.get();
    }


    public static void quitDriver() {

        if(getDriver() != null) {

            WaitUtil.pause(1);

            getDriver().quit();

            driver.remove();
        }
    }
}