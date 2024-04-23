package Homeworks;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import pojos.petPojo;
import pojos.petcategoryPojo;
import pojos.pettagPojo;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Homework_12 {
    //Write an automation test that will create, read, update, delete a 'pet' using the "https://petstore.swagger.io/" document
//(All actions must be done on same pet)
//            (Use Pojo)
    private petPojo expectedData;
    String url = "https://petstore.swagger.io/v2/pet";

@Test
public void Test() {
    

    int id = 48545;
    petcategoryPojo category = new petcategoryPojo(3,"sese");
    ArrayList<String> photoUrlsList = new ArrayList<>();
    photoUrlsList.add("ssss");
    pettagPojo tags = new pettagPojo(55,"sese");
    ArrayList<pettagPojo> tagsList = new ArrayList<>();
    tagsList.add(tags);
    expectedData = new petPojo(id,category,"rer",photoUrlsList,tagsList,"available");

    //Send the request and get the response  {Create}
    Response response = given()
            .body(expectedData)
            .contentType(ContentType.JSON)
            .post(url);


   //do assertion
    response
            .then()
            .statusCode(200)
            .body("id",equalTo(expectedData.getId())
                    ,"category.id",equalTo(expectedData.getCategory().getId())
                    ,"category.name",equalTo(expectedData.getCategory().getName())
                    ,"name",equalTo(expectedData.getName())
                    ,"photoUrls",equalTo(expectedData.getPhotoUrls())
                    ,"tags.id[0]",equalTo(expectedData.getTags().getFirst().getId())
                    ,"tags.name[0]",equalTo(expectedData.getTags().getFirst().getName())
                    ,"status",equalTo(expectedData.getStatus()));


    //send the request and get the response  {Read}
   response = given().get(url+"/48545");
    response.prettyPrint();

    //do assertion
    response
            .then()
            .statusCode(200)
            .body("id",equalTo(expectedData.getId())
                    ,"category.id",equalTo(expectedData.getCategory().getId())
                    ,"category.name",equalTo(expectedData.getCategory().getName())
                    ,"name",equalTo(expectedData.getName())
                    ,"photoUrls",equalTo(expectedData.getPhotoUrls())
                    ,"tags.id[0]",equalTo(expectedData.getTags().getFirst().getId())
                    ,"tags.name[0]",equalTo(expectedData.getTags().getFirst().getName())
                    ,"status",equalTo(expectedData.getStatus()));



    //send the request and get the response  {Update}
    expectedData.getCategory().setName("juuj");
    expectedData.setName("lele");

    response = given().body(expectedData)
            .contentType(ContentType.JSON)
            .put(url);
     response.prettyPrint();


    //do assertion
    response
            .then()
            .statusCode(200)
            .body("id",equalTo(expectedData.getId())
                    ,"category.id",equalTo(expectedData.getCategory().getId())
                    ,"category.name",equalTo(expectedData.getCategory().getName())
                    ,"name",equalTo(expectedData.getName())
                    ,"photoUrls",equalTo(expectedData.getPhotoUrls())
                    ,"tags.id[0]",equalTo(expectedData.getTags().getFirst().getId())
                    ,"tags.name[0]",equalTo(expectedData.getTags().getFirst().getName())
                    ,"status",equalTo(expectedData.getStatus()));



    //Send the request and get the response  {Delete}
    response = given().delete(url+"/48545");
    response.prettyPrint();

    //do assertion
    response
            .then()
            .statusCode(200)
            .body("code",equalTo(response.getStatusCode())
                    , "type",equalTo("unknown")
                    ,"message",equalTo(expectedData.getId()+""));


}

}
