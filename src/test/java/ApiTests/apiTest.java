package ApiTests;

import Apis.apiClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listener.TestApiListener;

@Listeners(TestApiListener.class)
public class apiTest {
    private static final String resource="/v4/areas/2001";

    @Test
    public void GetApirequest(ITestContext context) {

        Response response = apiClient.get(resource);

        // 🔑 THIS is how listener gets the response
        context.setAttribute("apiResponse", response);

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
