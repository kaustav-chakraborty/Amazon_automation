package ApiTests;

import Apis.apiClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Getpost_test {

    @Test
    public void getAllPost(){
        Response response= apiClient.get("/posts/1");
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.jsonPath().getInt("id"), 1);
    }
}
