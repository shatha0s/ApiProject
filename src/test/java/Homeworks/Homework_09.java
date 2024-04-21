package Homeworks;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Homework_09 {
    /*
Write an automation test that will create a 'user'
using the "https://petstore.swagger.io/" document
*/

@Test
    public void createUser(){
    String url = "https://petstore.swagger.io/v2/user";

    Map<String, Object> expectedData = new HashMap<>();
    expectedData.put("code", 200);
    expectedData.put("type", "unknown");
    expectedData.put("message", "303");

    Map<String, Object> Data = new HashMap<>();
    Data.put("id", 303);
    Data.put("username", "shatha21");
    Data.put("firstName", "shatha");
    Data.put("lastName", "aziz");
    Data.put("email", "sh@out.sa");
    Data.put("password", "123");
    Data.put("phone", "0765");
    Data.put("userStatus", "0");


    Response response = given()
            .body(Data)
            .contentType(ContentType.JSON)
            .post(url);
    response.prettyPrint();


    response.then()
        .body("code",equalTo((int) expectedData.get("code")),
                "type" , equalTo((String) expectedData.get("type")),
                "message" , equalTo((String) expectedData.get("message")));

}


}
