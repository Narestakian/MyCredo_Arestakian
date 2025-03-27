package org.credoBank.testAutomation.myCredo.api;

import io.restassured.response.Response;
import org.credoBank.testAutomation.myCredo.utils.ApiConfig;

import static io.restassured.RestAssured.given;

public class TokenCalls_CardsName {

    public Response getCardsByNickName(String token) {
            return given()
                    .spec(ApiConfig.getRequestSpec())
                    .header("Authorization", "Bearer " + token) // ტოკენის გადაცემა
                    .when()
                    .get("/api/v1/customer/cards")
                    .then()
                    .log().all() // დეტალური ლოგირება
                    .extract()
                    .response();
        }
    }

