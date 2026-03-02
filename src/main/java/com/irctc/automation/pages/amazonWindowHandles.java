package com.irctc.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class amazonWindowHandles {

    private WebDriver driver;
    private WebDriverWait wait;

    private By mobileXpath = By.xpath("//a[normalize-space()='Mobiles']");
    private By mobilesOver20000 = By.xpath("//span[contains(text(),'Over ₹20,000')]");
    private By iphone = By.xpath("//span[text()='Apple iPhone 15 (128 GB) - Blue']");
    private By addToCartButton=By.xpath("//input[@id='add-to-cart-button']");

    public amazonWindowHandles(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Step 1: Click Mobiles & filter
    public void clickMobilesAndFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(mobileXpath)).click();
        wait.until(ExpectedConditions.elementToBeClickable(mobilesOver20000)).click();
    }

    // Step 2: Click product and switch to new tab
    public void clickIphoneAndSwitchTab() {

        String parentTab = driver.getWindowHandle();

        wait.until(ExpectedConditions.elementToBeClickable(iphone)).click();

        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(parentTab)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }
    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

}
