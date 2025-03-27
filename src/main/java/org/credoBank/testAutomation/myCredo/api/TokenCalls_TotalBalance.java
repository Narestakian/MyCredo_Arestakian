package org.credoBank.testAutomation.myCredo.api;
import io.restassured.response.Response;
import org.credoBank.testAutomation.myCredo.utils.ApiConfig;
import static io.restassured.RestAssured.given;

public class TokenCalls_TotalBalance {

    public Response getTotalBalance(String token) {
        return given()
                .spec(ApiConfig.getRequestSpec())
                .header("Authorization", "Bearer " + token) // ტოკენის გადაცემა
                .when()
                .get("/api/v1/customer/accounts")
                .then()
                .log().all() // დეტალური ლოგირება
                .extract()
                .response();
    }
}

