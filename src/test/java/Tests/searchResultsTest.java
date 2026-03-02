package Tests;

import com.irctc.automation.pages.searchResults;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.commonActions;

import java.time.Duration;

public class searchResultsTest extends baseTest{

    @Test
    public void testsearchResults ()throws InterruptedException {
        commonActions.ScrollBottom(driver);
        Thread.sleep(1500);
        searchResults search=new searchResults(driver);

        Assert.assertTrue(search.hasImages(),"No Images found");
        Assert.assertTrue(search.isImageDisplayed(),"one or more images not found");
        Assert.assertTrue(search.isWidgetClickable(),"widget is not clickable");
        String oldurl=driver.getCurrentUrl();
        search.clickButton();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.titleContains("Online Shopping site in India"));
        String title=driver.getTitle();
        System.out.println(driver.getTitle());
        Assert.assertTrue(
                title.contains("Online Shopping site in India"),
                "Not navigated to Amazon home page"
        );
    }
}
