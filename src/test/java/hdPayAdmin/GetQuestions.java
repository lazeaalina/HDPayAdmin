package hdPayAdmin;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetQuestions {
    private String baseURI = "https://pay.dev.app.hd.digital/";
    private String basePath = "api/questions";
    @Test
    public void get_Questions() {
        Response response = given().header("Accept","application/json").when().get(baseURI + basePath);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
