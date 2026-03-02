package Tests;

import com.irctc.automation.pages.Category_dropdown;
import org.testng.annotations.Test;

public class categoryDropdownTest extends baseTest{
    @Test
    public void test_dropdown(){
        Category_dropdown categoryDropdown=new Category_dropdown(driver);
        categoryDropdown.select_dropdown();
    }
}
