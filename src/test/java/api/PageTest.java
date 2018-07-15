package api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PageTest {
    @BeforeClass
    @Parameters({"baseURL"})
    public void setUpClass(String baseURL) {
        RestAssured.baseURI = baseURL;
    }

    @Test
    public void collectionResourceOK() {
        given()
                .param("limit", 20)
                .when()
                .get("/api/pages")
                .then()
                .statusCode(200);
    }

    @Test
    public void createPage() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("charset", "UTF-8");
        JSONObject requestParam = new JSONObject();
        requestParam.put("title", "Page11");
        requestParam.put("isTest", false);
        requestParam.put("features", "[]");
        request.body(requestParam.toJSONString());

        Response response = request.post("/api/pages");

        Assert.assertEquals(200, response.getStatusCode());

    }

    @DataProvider(name = "login")
    public Object[][] loginTestData() {
        return new Object[][]{
                {"joe", "joe"}
        };
    }

    @Test(dataProvider = "login")
    public void login(String email, String password) {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("charset", "UTF-8");
        JSONObject requestParam = new JSONObject();
        requestParam.put("username", email);
        requestParam.put("password", password);
        request.body(requestParam.toJSONString());

        Response response = request.post("/login");

//        Assert.assertEquals(304, response.getStatusCode());
        JsonPath str = response.jsonPath();
        System.out.println(str.get("roles"));
        System.out.println(str.getString("roles"));
    }


}
