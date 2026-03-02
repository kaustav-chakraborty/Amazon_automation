package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class webDriverFactory {
    public webDriverFactory(){}
    public static  String remote=System.getProperty("remote");

    // Entry point
    public static WebDriver createWebDriver( browser browser) {

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

            default:
                driver=new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        return driver;
    }

    // Remote driver (stub for now)
    private static WebDriver getRemoteDriver(browser browser) {
        throw new UnsupportedOperationException("Remote execution not implemented yet");
    }
}
