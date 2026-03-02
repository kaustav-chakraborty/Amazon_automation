package Tests;

import com.irctc.automation.pages.BrowsingHistoryPage;
import com.irctc.automation.pages.loginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class loginTest extends baseTest{

    @Test
    public void testLoginFlow(){
        loginPage login=new loginPage(driver);
        login.hoverAndClickSignIn();
        login.login("9874915574","Netaji92@");
        BrowsingHistoryPage historyPage =
                new BrowsingHistoryPage(driver);

        historyPage.openBrowsingHistory();
    }

}
