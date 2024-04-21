package Homeworks;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.greaterThan;


public class Homework_10 {
    /* Using the https://petstore.swagger.io/ document,
     write an automation test that finds the number of "pets"
     with the status "available" and asserts that there are more than 100.
     */


    @Test
    public void petsTest(){
        String url = "https://petstore.swagger.io/v2/pet/findByStatus?status=available";

        Response response = given().get(url);
        response.prettyPrint();

        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("",hasSize(greaterThan(100)));
    }


}
