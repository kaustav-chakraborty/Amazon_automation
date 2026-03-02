
package Tests;

import com.irctc.automation.pages.BrowsingHistoryPage;
import org.testng.annotations.Test;

public class openBrowsingHistoryTest extends baseTest{

    @Test
    public void openBrowsingHistoryTest() {
        BrowsingHistoryPage browsingHistoryPage=new BrowsingHistoryPage(driver);
        browsingHistoryPage.openBrowsingHistory();
    }
}

