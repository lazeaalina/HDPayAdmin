package hdPayAdmin;

import dataProviders.LanguageDataProvider;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetTest {
    private String baseURI = "https://pay.dev.app.hd.digital/";
    private String basePath = "api/test/";

    @Test(dataProvider = "languageDataProvider", dataProviderClass = LanguageDataProvider.class)
    public void get_with_valid_data(String langShort, String lang) {

        Response response = given().pathParam("name", "test").contentType("application/json").header("Accept-Language", langShort).when().get(baseURI + basePath + "{name}");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getBody().asString(), lang);
    }

    @Test
    public void get_with_invalid_header_ISO() {
        String invalidISO = "ES";
        Response response = given().pathParam("name", "test").contentType("application/json").header("Accept-Language", invalidISO).when().get(baseURI + basePath + "{name}");
        Assert.assertEquals(response.getStatusCode(), 404);
    }

    @Test
    public void get_with_invalid_header_type() {
        int intValue = 2154;
        Response response = given().pathParam("name", "test").contentType("application/json").header("Accept-Language", intValue).when().get(baseURI + basePath + "{name}");
        Assert.assertEquals(response.getStatusCode(), 400);
    }

    @Test
    public void get_with_invalid_path_param_name() {
        int intValue = 2154;
        Response response = given().pathParam("name", intValue).contentType("application/json").header("Accept-Language", "EN").when().get(baseURI + basePath + "{name}");
        Assert.assertEquals(response.getStatusCode(), 400);
    }

}
