package Homeworks.Homework13;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.UserPojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Homework_13Get {
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
    public void GetUser() {
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
                (strJson, UserPojo.class);//This readValue method works with two parameters. First one is String formatted Json, second one is the data type you want to convert the json to.
        System.out.println("expectedData = " + expectedData);

        Response response = given().get(url+"/"+expectedData.getUsername());
        response.prettyPrint();

        response
                .then()
                .statusCode(200)
                .body("id",equalTo(303)
                        , "username",equalTo("shatha3")
                        ,"firstName",equalTo("shatha")
                        ,"lastName",equalTo("aziz")
                        ,"email",equalTo("shatha@hotmail.com")
                        ,"password",equalTo("147852")
                        ,"phone",equalTo("057894613")
                        ,"userStatus",equalTo(0));


    }
}
