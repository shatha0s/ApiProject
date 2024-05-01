package Homeworks.Homework15;

import base_urls.UserBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import pojos.UserPojoHomework15;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class Homework_15Post extends UserBase {
    public static String id ;
    public static String Token="";


    @Test
    void createBookingTest() {
        //Set the url
        spec.pathParams("first","users");

        //Set the expected data
        String strJson = """ 
                {
                    "firstName": "Test",
                    "lastName": "User",
                    "email": "shathaaziz@gmail.com",
                    "password": "15874000000"
        
                }""";

        UserPojoHomework15 expectedData = convertJsonToJava(strJson, UserPojoHomework15.class);
        System.out.println("expectedData = " + expectedData);

        Response response = given(spec)
                .body(expectedData).post("{first}");
        response.prettyPrint();

        response .then()
                .statusCode(201)
                .body("user.firstName",equalTo(expectedData.getFirstName())
                        ,"user.lastName",equalTo(expectedData.getLastName())
                        ,"user.email",equalTo(expectedData.getEmail())) ;

        id =response.jsonPath().getString("user._id");
        System.out.println(id);

        Token = response.jsonPath().getString("token");
        System.out.println(Token);

    }


    }
