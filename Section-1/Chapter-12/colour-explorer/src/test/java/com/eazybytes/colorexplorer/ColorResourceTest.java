package com.eazybytes.colorexplorer;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class ColorResourceTest {

    @Test
    void returnsTwentyColors() {
        given()
                .when().get("/api/colors")
                .then()
                .statusCode(200)
                .body("$", hasSize(20))
                .body("[0].name", is("Sunset Coral"))
                .body("[0].hex", is("#FF6B6B"));
    }

    @Test
    void recordingAViewReturnsRecentList() {
        given()
                .contentType("application/json")
                .body("{\"name\":\"Test Blue\",\"hex\":\"#0000FF\"}")
                .when().post("/api/colors/view")
                .then()
                .statusCode(200)
                .body("[0].hex", is("#0000FF"));
    }

    @Test
    void indexPageIsServed() {
        given()
                .when().get("/")
                .then()
                .statusCode(200)
                .contentType("text/html");
    }
}
