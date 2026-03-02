package com.irctc.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public loginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    // Locators
    private By accountList = By.id("nav-link-accountList");
    private By signInBtn = By.xpath("//span[text()='Sign in']");
    private By email = By.id("ap_email_login");
    private By continueBtn = By.xpath("//input[@class='a-button-input']");
    private By password = By.id("ap_password");
    private By signInSubmit = By.id("signInSubmit");

    // Hover + click sign in
    public void hoverAndClickSignIn() {
        WebElement account =
                wait.until(ExpectedConditions.visibilityOfElementLocated(accountList));

        actions.moveToElement(account).perform();

        wait.until(ExpectedConditions.elementToBeClickable(signInBtn)).click();
        wait.until(ExpectedConditions.urlContains("ap/signin"));
    }

    public void login(String user, String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(user);
        driver.findElement(continueBtn).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
        driver.findElement(signInSubmit).click();
    }
    public productPage clickLogin() {
        driver.findElement(signInSubmit).click();
        return new productPage(driver);
    }
}
