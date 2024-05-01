package Homeworks.Homework15;

import base_urls.UserBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.UserPojoHomework15;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class Homework_15Git extends UserBase {
    @Test
    void getUserTest() {
        spec.pathParams("first","users","second","me");
        String strJson = """ 
                {
                    "firstName": "Test",
                    "lastName": "User",
                    "email": "shathaaziz@gmail.com",
                    "password": "15874000000"
        
                }""";

        UserPojoHomework15 expectedData = convertJsonToJava(strJson, UserPojoHomework15.class);
        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        response.then()
                .statusCode(200)
                .body("firstName",equalTo(expectedData.getFirstName())
                        ,"lastName",equalTo(expectedData.getLastName())
                        ,"email",equalTo(expectedData.getEmail())) ;



    }
    }

