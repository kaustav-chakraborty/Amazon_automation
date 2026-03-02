package Tests;

import com.irctc.automation.pages.amazonWindowHandles;
import org.testng.annotations.Test;

public class amazonWindowTest extends baseTest{

    @Test
    public void windowTest(){
        amazonWindowHandles amazonWindowHandles=new amazonWindowHandles(driver);
        amazonWindowHandles.clickMobilesAndFilter();
        amazonWindowHandles.clickIphoneAndSwitchTab();
        amazonWindowHandles.clickAddToCart();
    }
}
