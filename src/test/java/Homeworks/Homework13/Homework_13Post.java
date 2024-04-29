package Homeworks.Homework13;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.UserPojo;
import utilities.ObjectMapperUtils;


import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class Homework_13Post {

    //Write an automation test that will create a 'user' then read, update and delete the created user using the
    // "https://petstore.swagger.io/" document. (Create a classes for each request.)
    //body  {
    //  "id": 303,
    //  "username": "shatha3",
    //  "firstName": "shatha",
    //  "lastName": "aziz",
    //  "email": "shatha@hotmail.com",
    //  "password": "147852",
    //  "phone": "057894613",
    //  "userStatus": 0
    //}
    String url = "https://petstore.swagger.io/v2/user";

    @Test
    public void PostUser() {

        String strJson = """
                {
                     "id": 303,
                     "username": "shatha3",
                      "firstName": "shatha",
                      "lastName": "aziz",
                      "email": "shatha@hotmail.com",
                      "password": "147852",
                      "phone": "057894613",
                       "userStatus": 0
                      }
                                     """;


        UserPojo expectedData = ObjectMapperUtils.convertJsonToJava
                (strJson, UserPojo.class);
        System.out.println("expectedData = " + expectedData);


        Response response = given()
                .body(expectedData)
                .contentType(ContentType.JSON)
                .post(url);
        response.prettyPrint();

        response
                .then()
                .statusCode(200)
                .body("code",equalTo(response.getStatusCode())
                        , "type",equalTo("unknown")
                        ,"message",equalTo(expectedData.getId()+""));




    }

    }

