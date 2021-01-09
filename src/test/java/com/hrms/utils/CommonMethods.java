package com.hrms.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CommonMethods {
    public static WebDriver driver;
    public static ChromeOptions options;
    public static FirefoxOptions options1;
    /**
     * This method will open the browser, set up configuration and navigate to the URL
     */
    @BeforeMethod(alwaysRun = true)
    public static void setUp(){
        ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

        switch (ConfigsReader.getPropertyValue("browser").toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                /*options.addArguments("--disable-dev-shm-usage");
                options.addArguments("start-maximized"); // open Browser in maximized mode
                options.addArguments("disable-infobars"); // disabling infobars
                options.addArguments("--disable-extensions"); // disabling extensions
                options.addArguments("--disable-gpu"); // applicable to windows os only
                options.addArguments("--no-sandbox"); // Bypass OS security model*/
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                /*options1 = new FirefoxOptions();
                options1.addArguments("--disable-dev-shm-usage");
                options1.addArguments("start-maximized"); // open Browser in maximized mode
                options1.addArguments("disable-infobars"); // disabling infobars
                options1.addArguments("--disable-extensions"); // disabling extensions
                options1.addArguments("--disable-gpu"); // applicable to windows os only
                options1.addArguments("--no-sandbox"); // Bypass OS security model*/
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser");
        }
        driver.get(ConfigsReader.getPropertyValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    /**
     * This method will close any open browser
     */
    @AfterMethod(alwaysRun = true)
    public static void tearDown(){
        if (driver!=null){
            driver.quit();
        }
    }
}
