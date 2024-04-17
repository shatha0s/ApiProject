package Homeworks;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class Homework_04 {
    /*
       Given
           https://reqres.in/api/users/2
       When
           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response format should be "application/json"
       And
           "email" is "janet.weaver@reqres.in",
       And
           "first_name" is "Janet"
       And
           "last_name" is "Weaver"
       And
           "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
    */
@Test
    public static void Homework04() {
        // https://reqres.in/api/users/2
        // User sends a GET Request to the url
        Response response = RestAssured.get("https://reqres.in/api/users/2");
        response.prettyPrint();
        response.then()
                .statusCode(200) // HTTP Status Code should be 200
                .contentType("application/json") //Response format should be "application/json"
                .body("data.email",equalTo("janet.weaver@reqres.in")) //"email" is "janet.weaver@reqres.in"
                .body("data.first_name",equalTo("Janet")) //"first_name" is "Janet"
                .body("data.last_name",equalTo("Weaver"))  //"last_name" is "Weaver"
                .body("support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));//"text" is "To keep ReqRes free, contributions towards server costs are appreciated!"

    }}

