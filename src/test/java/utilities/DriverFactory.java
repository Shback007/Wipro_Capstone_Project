package utilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    // Thread Safe Driver

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();



    // Initialize Driver

    public static WebDriver initializeDriver() {

        String browser = ConfigReader.getProperty("browser");

        String headless = ConfigReader.getProperty("headless");

        String execution_env = ConfigReader.getProperty("execution_env");



        try {

            switch(browser.toLowerCase()) {

            case "chrome":

                ChromeOptions chromeOptions =
                        new ChromeOptions();


                // Headless Configuration

                if(headless.equalsIgnoreCase("true")) {

                    chromeOptions.addArguments("--headless=new");

                    chromeOptions.addArguments("--disable-gpu");

                    chromeOptions.addArguments("--window-size=1920,1080");

                    chromeOptions.addArguments("--remote-allow-origins=*");

                    chromeOptions.addArguments("--no-sandbox");

                    chromeOptions.addArguments("--disable-dev-shm-usage");

                    chromeOptions.addArguments("--disable-extensions");

                    chromeOptions.addArguments("--disable-popup-blocking");
                }



                // Local Execution

                if(execution_env.equalsIgnoreCase("local")) {

                    driver.set( new ChromeDriver(chromeOptions));
                }


                // Remote Execution

                else if(execution_env.equalsIgnoreCase("remote")) {

                    driver.set(new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), chromeOptions));
                }

                break;



            case "edge":

                EdgeOptions edgeOptions = new EdgeOptions();


                // Headless Configuration

                if(headless.equalsIgnoreCase("true")) {
                	
                    edgeOptions.addArguments("--headless=new");

                    edgeOptions.addArguments("--disable-gpu");

                    edgeOptions.addArguments("--window-size=1920,1080");

                    edgeOptions.addArguments("--remote-allow-origins=*");

                    edgeOptions.addArguments("--no-sandbox");

                    edgeOptions.addArguments("--disable-dev-shm-usage");

                    edgeOptions.addArguments("--disable-extensions");

                    edgeOptions.addArguments("--disable-popup-blocking");
                }



                // Local Execution

                if(execution_env.equalsIgnoreCase("local")) {

                    driver.set(new EdgeDriver(edgeOptions));
                }


                // Remote Execution

                else if(execution_env.equalsIgnoreCase("remote")) {

                    driver.set(new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), edgeOptions));
                }

                break;



            default:

                throw new RuntimeException("Invalid Browser : " + browser);
            }

        }

        catch(MalformedURLException e) {

            e.printStackTrace();
        }

       // Common Browser Configuration

        getDriver().manage().window().maximize();

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return getDriver();
    }



    // Get Driver

    public static WebDriver getDriver() {

        return driver.get();
    }



    // Quit Driver

    public static void quitDriver() {

        if(getDriver() != null) {

            WaitUtil.pause(1);

            getDriver().quit();

            driver.remove();
        }
    }
}