package Homeworks.Homework13;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.UserPojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Homework_13Delete {
    //Write an automation test that will create a 'user' then read, update and delete the created user using the
    // "https://petstore.swagger.io/" document. (Create a classes for each request.)

    String url = "https://petstore.swagger.io/v2/user";
    @Test
    public void DeleteUser() {
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

        Response response = given().delete(url+"/"+expectedData.getUsername());
        response.prettyPrint();

        response
                .then()
                .body("code",equalTo(response.getStatusCode())
                        , "type",equalTo("unknown")
                        ,"message",equalTo(expectedData.getUsername()));

    }

}
