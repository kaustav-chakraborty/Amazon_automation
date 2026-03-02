package com.irctc.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class productPage {
    private WebDriver driver;

    public By searchBar=By.xpath("//input[@id='twotabsearchtextbox']");
    public By selectWhey=By.xpath("//span[@class='s-heavy' and normalize-space()='isolate 1kg']");

    public productPage(WebDriver driver){
        this.driver=driver;
    }
    public boolean isProduct() {
        return !driver.findElements(selectWhey).isEmpty();
    }
    public void clickWhey() {
        driver.findElement(searchBar).sendKeys("whey protein" + Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.visibilityOfElementLocated(selectWhey));
        List<WebElement> products =
                driver.findElements(By.xpath("//span[contains(@class,'a-text-normal')]"));

        System.out.println("Products found: " + products.size());

        driver.findElement(selectWhey).click();
    }
}
