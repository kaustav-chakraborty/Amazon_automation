package Apis;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.configuration;

import static io.restassured.RestAssured.given;

public class apiClient {

    private static final configuration configFile = new configuration();
    private static final String baseUrl = configFile.getProperty("api.base.url");

    private apiClient() {
        // prevent object creation
    }

    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setContentType("application/json")
                .build();
    }

    public static Response get(String resource) {
        return given()
                .spec(getRequestSpec())
                .log().all()
                .when()
                .get(resource);
    }
    public static Response post(String resource,Object body){
        return given()
                .spec(getRequestSpec())
                .body(body)
                .log().all()
                .when()
                .put(resource);
    }
}
