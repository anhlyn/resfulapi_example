package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class PostUser extends BaseTest{

    @Test
    public void TC_PostUser(){
        String bodyStr = "{ \"name\": \"Lina 3\", \"job\": \"Tester 3\" }";
        Response response = RestAssured.given()
                .basePath("/api/users")
                .header("x-api-key", "reqres-free-v1")
                .contentType(ContentType.JSON)
                .body(bodyStr)
                .when()
                .post();

        response.then().statusCode(201);
    }

    @Test
    public void TC_PutUser(){
        String bodyStr = "{ \"name\": \"Lina\", \"job\": \"Tester\" }";
        String userId = "2";
        Response response = RestAssured.given()
                .basePath("/api/users/" + userId)
                .header("x-api-key", "reqres-free-v1")
                .contentType(ContentType.JSON)
                .body(bodyStr)
                .when()
                .put();

        response.then().statusCode(200);
    }

}
