package com.irctc.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.commonActions;

import java.time.Duration;

public class BrowsingHistoryPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public BrowsingHistoryPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By browsingHistoryTab = By.xpath("//span[text()='Browsing History']");
    private By arrowButton = By.xpath("//span[contains(@class,'nav-feed-arrow')]");
    private By historyButton = By.xpath("//div[@id='nav-timeline-view-history']");

    public void openBrowsingHistory(){

        // 1️⃣ Hover on Browsing History
        WebElement browserTab = wait.until(
                ExpectedConditions.visibilityOfElementLocated(browsingHistoryTab)
        );

        commonActions.hover(driver, browserTab);
        /*WebElement arrow = wait.until(
                ExpectedConditions.elementToBeClickable(arrowButton)
        );
        try {
            wait.until(ExpectedConditions.elementToBeClickable(arrow)).click();
        } catch (Exception e) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", arrow);
        }*/

        WebElement history = wait.until(
                ExpectedConditions.presenceOfElementLocated(historyButton)
        );
        //history.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", history);
    }
}
