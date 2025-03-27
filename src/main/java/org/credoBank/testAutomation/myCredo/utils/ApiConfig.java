package org.credoBank.testAutomation.myCredo.utils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class ApiConfig {
    final static String Base_URL = "http://10.195.105.64:5030";
    public static final String TEST_API_URL = "http://test.api.css.credo.ge";

    // RequestSpecification: სტანდარტული მოთხოვნის კონფიგურაცია
    public static RequestSpecification getRequestSpec() {
        return given()
                .baseUri(Base_URL)
                .header("Content-Type", "application/json");
    }

    // ResponseSpecification: სტანდარტული პასუხის კონფიგურაცია
    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .build();
    }

    public static RequestSpecification getTestApiRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(TEST_API_URL)
                .addHeader("Content-Type", "application/json")
                .build();
    }
}

