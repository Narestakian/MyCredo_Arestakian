package org.credoBank.testAutomation.myCredo.api;
import io.restassured.response.Response;
import org.credoBank.testAutomation.myCredo.models.CurrencyRateRequest;
import org.credoBank.testAutomation.myCredo.utils.ApiConfig;
import static io.restassured.RestAssured.given;

public class CurrencyRateService {

    public Response getCurrencyRates(CurrencyRateRequest request) {
        return given()
                .spec(ApiConfig.getTestApiRequestSpec())
                .body(request)
                .when()
                .post("/api/Core/CurrencyRateList")
                .then()
                .extract()
                .response();
    }
}
