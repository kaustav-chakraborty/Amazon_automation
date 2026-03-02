package com.irctc.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Addtocart {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public Addtocart(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public By searchBar=By.xpath("//input[@id='twotabsearchtextbox']");
    private By searchButton=By.xpath("//input[@id='nav-search-submit-button']");
    private By sortdropdown=By.xpath("//select[@id='s-result-sort-select']");
    private By phone=By.xpath("//span[contains(text(),'Galaxy A07 5G Smartphone')]");
    private By AddtocartButton=By.xpath("//input[@id='add-to-cart-button']");
    private By addedToCartMsg = By.xpath("//*[contains(text(),'Added to cart')]");


    public void EnterTextandSearch(){
        driver.findElement(searchBar).sendKeys("samsung 5g mobile phone");
        driver.findElement(searchButton).click();
    }
    public void clickCheapestPhone(){
        WebElement dropdown= driver.findElement(sortdropdown);
        Select select=new Select(dropdown);
        select.selectByVisibleText("Price: Low to High");
        wait.until(ExpectedConditions.elementToBeClickable(phone)).click();
    }
    public void SwitchTabs(){
        for (String Window: driver.getWindowHandles()) {
            driver.switchTo().window(Window);
        }
    }
    public void AddtoCart(){
        WebElement addBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(AddtocartButton));

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", addBtn);

        wait.until(ExpectedConditions.elementToBeClickable(addBtn));
        addBtn.click();
    }
    public boolean isProductAddedToCart(){
        return driver.findElement(addedToCartMsg).isDisplayed();
    }

}
