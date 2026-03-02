package com.irctc.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Category_dropdown {

    private WebDriver driver;

    private By dropdown=By.xpath("//div[@class='nav-search-scope nav-sprite']//select[@id='searchDropdownBox']");
    private By searchButton=By.xpath("//input[@id='nav-search-submit-button']");
    public Category_dropdown(WebDriver driver){
        this.driver=driver;
    }
    public void select_dropdown(){
        Select select=new Select(driver.findElement(dropdown));
        select.selectByVisibleText("Electronics");
        driver.findElement(searchButton).click();
    }

}
