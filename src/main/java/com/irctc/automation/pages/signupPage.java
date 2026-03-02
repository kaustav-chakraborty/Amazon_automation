package com.irctc.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class signupPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public signupPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions=new Actions(driver);
    }
    private By accountList = By.id("nav-link-accountList");
    private By startHere=By.xpath("//a[contains(text(),'Start here.')]");
    private By email = By.id("ap_email_login");
    private By continueButton=By.id("continue");

    private By proceedButton = By.id("intention-submit-button");


    private By phoneNumber=By.xpath("//input[@id='ap_phone_number']");
    private By userName=By.xpath("//input[@id='ap_customer_name']");
    private By getpass=By.xpath("//input[@id='ap_password']");
    private By verifyMobile=By.xpath("//input[@id='continue']");


    public void HoverAndClick(){
        WebElement account=wait.until(ExpectedConditions.visibilityOfElementLocated(accountList));
        actions.moveToElement(account).perform();
        wait.until(ExpectedConditions.elementToBeClickable(startHere)).click();
        /*if (driver.getCurrentUrl().contains("ap/register")) {
            throw new RuntimeException("Signup flow blocked by Amazon. Phone field not reachable.");
        }*/

    }
    public void enterDetails(String user, String number, String pass, String firstName)  {

        wait.until(ExpectedConditions.visibilityOfElementLocated(email))
                .sendKeys(user);
        driver.findElement(continueButton).click();



        try {
            wait.until(ExpectedConditions.elementToBeClickable(proceedButton)).click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // IMPORTANT: wait for phone field to appear
        WebElement phone = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//input[contains(@id,'phone')]")
                )
        );
        phone.sendKeys(number);

        wait.until(ExpectedConditions.visibilityOfElementLocated(userName))
                .sendKeys(firstName);

        wait.until(ExpectedConditions.visibilityOfElementLocated(getpass))
                .sendKeys(pass);

        wait.until(ExpectedConditions.elementToBeClickable(verifyMobile)).click();
    }

}
