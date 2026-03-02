package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.browser;
import utils.configuration;
import utils.webDriverFactory;

public class baseTest {

    protected WebDriver driver;
    configuration reader = new configuration();

    @BeforeClass(alwaysRun = true)
    public void setUp() {

        String name = "CHROME"; // or read from properties
        browser browserType  = browser.valueOf(name.toUpperCase());

        driver = webDriverFactory.createWebDriver(browserType );

        driver.get(reader.getProperty("app.url"));
        driver.manage().window().maximize();
    }
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
