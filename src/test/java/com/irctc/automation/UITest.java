package com.irctc.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class UITest {

    @Test
    public void testUI() {
        // 1️⃣ Disable browser notifications
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // 2️⃣ Open IRCTC
        driver.get("https://www.irctc.co.in/nget/train-search");

        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
    }
}
