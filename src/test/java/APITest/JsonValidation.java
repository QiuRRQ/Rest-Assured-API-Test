package APITest;

import APITest.BaseTest.BaseTestClass;
import com.jayway.jsonpath.JsonPath;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONArray;
import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import java.io.File;

public class JsonValidation extends BaseTestClass {

    @Test
    public void jsonSchemaValidation(){
        RequestSpecification request = RestAssured.given().filter(new AllureRestAssured());

        String beerSchemaPath = "src/resources/schema/beers.json";

        request.header("Content-Type", "application/json");
        Response response = request.get("/beers");
        response.then().assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(new File(beerSchemaPath)))
                .and().body("size()", Is.is(25));

        System.out.println("response size : "+response.getBody().jsonPath().getList("$").size());

        JSONArray data = JsonPath.read(response.asString(),"$..name");

        for (int i =0; i<data.size(); i++) {
            System.out.println(data.get(i));
        }

        System.out.println("response time :"+ response.time());
    }
}
