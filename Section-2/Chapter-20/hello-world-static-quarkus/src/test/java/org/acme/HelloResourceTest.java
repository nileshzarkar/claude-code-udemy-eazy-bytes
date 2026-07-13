package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
class HelloResourceTest {

    @Test
    void helloEndpointReturnsHtml() {
        given()
            .when().get("/hello")
            .then()
                .statusCode(200)
                .contentType("text/html")
                .body(containsString("Hello"));
    }
}
