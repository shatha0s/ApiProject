package Homeworks;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class Homework_11 {
    /*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends a GET request
    Then
        Assert that the number of "Women" user type is 12

    Note: Print using JsonPath: response.jsonPath().prettyPrint();

*/


    @Test
    public void Test() {

        String url = "https://automationexercise.com/api/productsList";

        //User sends a GET request
        Response response = RestAssured.get(url);
        JsonPath jsonPath = response.jsonPath();

       // Assert that the number of "Women" user type is 12
        List<String> womenUserTypeList = jsonPath.setRootPath("products.category.usertype").
                getList("findAll { it.usertype == 'Women' }");
        int womenUserTypeCount = womenUserTypeList.size();

        assertEquals(womenUserTypeCount, 12);
        response.jsonPath().prettyPrint();

    }


}
