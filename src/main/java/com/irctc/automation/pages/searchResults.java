package com.irctc.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class searchResults {
    private WebDriver driver;

    public searchResults(WebDriver driver){
        this.driver=driver;
    }
    private By WidgetContainer=By.xpath("//div[contains(@class,'a-cardui')][.//h2[contains(normalize-space(text()),'home')]]");
    private By images=By.xpath(".//img");
    private By links=By.xpath(".//a");
    private By exploreallbutton=By.xpath("//span[text()='Explore all']");


    private WebElement waitForWidget() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(WidgetContainer));
    }


    public boolean hasImages() {
        WebElement widget = waitForWidget();
        return widget.findElements(images).size() > 0;
    }

    public boolean isImageDisplayed(){
        List<WebElement>imageElements =driver.findElement(WidgetContainer).findElements(images);
        for (WebElement img:imageElements){
            if (!img.isDisplayed()){
                return false;
            }
        }
        return true;
    }
    public boolean isWidgetClickable() {
        List<WebElement> linkstobeclicked =
                driver.findElement(WidgetContainer).findElements(links);

        return linkstobeclicked.size() > 0 && linkstobeclicked.get(0).isEnabled();
    }
    public  void clickButton(){
        WebElement widget = waitForWidget();
        widget.findElement(exploreallbutton);
    }


}
