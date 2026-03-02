package Tests;

import com.irctc.automation.pages.signupPage;
import org.testng.annotations.Test;

public class SignUp_test extends baseTest{

    @Test
    public void testSignupFLow()  {
        signupPage signupPage=new signupPage(driver);
        signupPage.HoverAndClick();
        signupPage.enterDetails(
                reader.getProperty("user.email"),
                reader.getProperty("user.phone"),
                reader.getProperty("user.password"),
                reader.getProperty("user.firstname")
        );
    }
}
