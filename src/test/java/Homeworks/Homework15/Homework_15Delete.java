package Homeworks.Homework15;

import base_urls.UserBase;
import groovyjarjarantlr4.runtime.Token;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Homework_15Delete extends UserBase {



    @Test
    void deleteUserTest(){
        spec.pathParams("first","users","second","me");

        Response response = given(spec).delete("{first}/{second}");
        response.prettyPrint();
        
        response.then()
                .statusCode(200);


    }
}
