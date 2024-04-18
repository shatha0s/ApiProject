package Homeworks;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Homework_05 {
    /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */

    @Test
    public void Homework5() {
      // When User send a GET Request to the url
        Response response = RestAssured.get("https://reqres.in/api/users/23");
        response.prettyPrint();

        //  HTTP Status code should be 404
        // And Status Line should be HTTP/1.1 404 Not Found
        // And Server is "cloudflare"
        response
                .then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .header("Server", "cloudflare");


        //And  Response body should be empty
        String stringBody = response.asString();
        System.out.println("stringBody = " + stringBody);
        boolean isEmpty =stringBody.isEmpty();
        assertEquals(stringBody,"{}");

    }

    }




