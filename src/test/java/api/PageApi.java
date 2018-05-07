package api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PageApi {
    @Test
    public void collectionResourceOK() {
        given()
                .param("limit", 20)
                .when()
                .get("http://localhost:3030/api/pages")
                .then()
                .statusCode(200);
    }


}
