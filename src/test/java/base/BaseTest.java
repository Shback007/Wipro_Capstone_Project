package base;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

import utilities.ConfigReader;

import utilities.DriverFactory;

public class BaseTest {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected Logger logger = LogManager.getLogger(this.getClass());

    @BeforeMethod

    public void setup() {

        driver.set(DriverFactory.initializeDriver());

        getDriver().get(ConfigReader.getProperty("url"));
    }

    @AfterMethod

    public void tearDown() {

        DriverFactory.quitDriver();
    }

    public WebDriver getDriver() {

        return driver.get();
    }
}