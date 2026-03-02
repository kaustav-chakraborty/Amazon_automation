package Tests;

import com.irctc.automation.pages.productPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class productTest extends baseTest{

    @Test
    public void testWheyProtein(){
        productPage product=new productPage(driver);
        product.clickWhey();
        Assert.assertTrue(
                product.isProduct(),
                "Whey product is NOT displayed in search results"
        );
    }
}
