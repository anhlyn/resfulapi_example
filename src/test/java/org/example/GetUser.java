package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetUser extends BaseTest {
    @Test
    public void TC_GetAllUsers(){
        Response res = RestAssured.given()
                .basePath("/api/users")
                .headers("Content-Type", ContentType.JSON, "x-api-key", "reqres-free-v1")
                .when()
                .get();

        res.then().statusCode(200);
        res.then().header("Content-Type", "application/json; charset=utf-8");
    }

    @Test
    public void TC_GetUserById(){
        String idStr = "2";

        Response res = RestAssured.given()
                .basePath("/api/users/" + idStr)
                .headers("Content-Type", ContentType.JSON, "x-api-key", "reqres-free-v1")
                .when()
                .get();

        res.then().statusCode(200);
        System.out.println(res.jsonPath().getString("data.email"));
        System.out.println(res.jsonPath().getString("data.first_name") + " " + res.jsonPath().getString("data.last_name"));
        System.out.println(res.jsonPath().getString("support.url"));
    }

    @Test
    public void TC_UserNotFound(){
        Response res = RestAssured.given()
                .basePath("/api/users/23")
                .headers("Content-Type", ContentType.JSON, "x-api-key", "reqres-free-v1")
                .when()
                .get();

        res.then().statusCode(404);
        System.out.println(res.getStatusLine());
    }

}
