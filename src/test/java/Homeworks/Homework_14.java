package Homeworks;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Homework_14 {
    /*
    Given
        https://dummy.restapiexample.com/api/v1/employees
    When
        User sends Get Request to the Url
    Then
        Status code is 200
    And
        There are 24 employees
    And
        "Tiger Nixon" and "Garrett Winters" are among the employees
    And
        The greatest age is 66
    And
        The name of the lowest age is "Tatyana Fitzpatrick"
    And
        Total salary of all employees is 6,644,770
 */
    String url = "https://dummy.restapiexample.com/api/v1/employees";

   @Test
   public void Homework14(){
       Response response = given().get(url);
       response.prettyPrint();

       response
               .then()
               .statusCode(200)  //Satus code is 200
               .body("data.size()",equalTo(24), //There are 24 employees
                       "data.employee_name", hasItems("Tiger Nixon", "Garrett Winters"), //"Tiger Nixon" and "Garrett Winters" are among the employees
                       "data.max { it.employee_age }.employee_age", equalTo(66), //The greatest age is 66
                       "data.min { it.employee_age }.employee_name", equalTo("Tatyana Fitzpatrick"), //The name of the lowest age is "Tatyana Fitzpatrick"
                       "data.collect { it.employee_salary }.sum()", equalTo(6644770)); // Total salary of all employees is 6,644,770
   }
}
