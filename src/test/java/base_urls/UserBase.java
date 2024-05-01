package base_urls;

import Homeworks.Homework15.Homework_15Post;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class UserBase {
    protected RequestSpecification spec;

    @BeforeMethod
    public void setUp(){
        String Token = Homework_15Post.Token;
        System.out.println("token= " +Token);
        spec = new RequestSpecBuilder()
                .setBaseUri("https://thinking-tester-contact-list.herokuapp.com")
                .addHeader("Authorization", "Bearer " + Token)
                .setContentType(ContentType.JSON)
                .build();
    }
}
