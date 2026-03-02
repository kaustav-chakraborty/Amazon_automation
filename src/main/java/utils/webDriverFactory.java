package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class webDriverFactory {

    public webDriverFactory() {}

    public static String remote = System.getProperty("remote");

    // Entry point
    public static WebDriver createWebDriver(browser browser) {

        if ("true".equalsIgnoreCase(remote)) {
            return getRemoteDriver(browser);
        } else {
            return getLocalDriver(browser);
        }
    }

    // Local driver creation
    private static WebDriver getLocalDriver(browser browser) {

        WebDriver driver;

        switch (browser) {

            case EDGE:
                driver = new EdgeDriver();
                break;

            case FIREFOX:
                driver = new FirefoxDriver();
                break;

            case CHROME:
            default:
                ChromeOptions options = new ChromeOptions();

                // Headless settings for CI (GitHub Actions / Linux)
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--disable-notifications");

                driver = new ChromeDriver(options);
                break;
        }

        // Common settings
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Set window size explicitly (works in headless)
        driver.manage().window().setSize(new Dimension(1920, 1080));

        return driver;
    }

    // Remote driver (for Selenium Grid / cloud - future use)
    private static WebDriver getRemoteDriver(browser browser) {
        throw new UnsupportedOperationException("Remote execution not implemented yet");
    }
}