package Homeworks;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Homework_03 {
     /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

    public static void main(String[] args) {
        // https://reqres.in/api/users/3
        // User sends a GET Request to the url
        Response response = RestAssured.get("https://reqres.in/api/users/3");

        // HTTP Status Code should be 200
        int statusCode = response.statusCode();
        System.out.println("statusCode = " + statusCode);

        //Content Type should be JSON
        String contentType = response.contentType();
        System.out.println("contentType = " + contentType);

        // Status Line should be HTTP/1.1 200 OK
        String statusLine = response.statusLine();
        System.out.println("statusLine = " + statusLine);

    }

}
