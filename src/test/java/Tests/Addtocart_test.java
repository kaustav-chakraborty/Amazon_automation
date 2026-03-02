package Tests;

import com.irctc.automation.pages.Addtocart;
import org.testng.annotations.Test;

import java.time.Duration;

public class Addtocart_test extends baseTest{

    @Test
    public void testaddtocart(){
        Addtocart addtocart=new Addtocart(driver);
        addtocart.EnterTextandSearch();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        addtocart.clickCheapestPhone();
        addtocart.SwitchTabs();
        addtocart.AddtoCart();
        addtocart.isProductAddedToCart();
    }
}
