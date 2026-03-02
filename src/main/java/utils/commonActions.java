package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class commonActions {
    public static void Scroll(WebDriver driver,int pixels){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, arguments[0]);",pixels);
    }
    public static  void ScrollBottom(WebDriver driver){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript(
                "window.scrollTo({top: document.body.scrollHeight, behavior: 'smooth'});"
        );
    }
    public static void hover(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);

        actions.moveToElement(element, 0, 20) // 🔥 move slightly DOWN
                .pause(Duration.ofMillis(600))
                .perform();
    }

}
