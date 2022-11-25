import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.core.Is;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;

public class CreateUserTest {

    public int id;

    @Test
    public void successCreateUser(){
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = RestAssured.given();

        String name = "aziz";
        String job = "staff";
        String userSchemaPath = "src\\resources\\schema\\users\\user.json";
//        initiate JSON object
        JSONObject bodyParam = new JSONObject();
        request.header("Content-Type", "application/json");
        bodyParam.put("name", name);
        bodyParam.put("job", job);
        request.body(bodyParam.toString());

        Response response = request.post("/api/users");
//        Assert.assertEquals(response.getStatusCode(), 201);
//        Assert.assertEquals(response.jsonPath().getString("name"), name);
//        Assert.assertEquals(response.jsonPath().getString("job"), job);
        response.then().assertThat()
                .statusCode(201)
                .body(JsonSchemaValidator.matchesJsonSchema(new File(userSchemaPath)));
        id = response.jsonPath().getInt("id");
        System.out.println("id user : " + id);
        System.out.println(response.getBody().asString());
        System.out.println(response.time());
    }

    @Test
    public void successUpdateUser(){
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = RestAssured.given();

        String name = "aziz update";
        String job = "staff update";
        String userSchemaPath = "src\\resources\\schema\\users\\user.json";
//        initiate JSON object
        JSONObject bodyParam = new JSONObject();
        request.header("Content-Type", "application/json");
        bodyParam.put("name", name);
        bodyParam.put("job", job);
        request.body(bodyParam.toString());

        Response response = request.put("/api/users/"+id);
//        Assert.assertEquals(response.getStatusCode(), 201);
//        Assert.assertEquals(response.jsonPath().getString("name"), name);
//        Assert.assertEquals(response.jsonPath().getString("job"), job);
        response.then().assertThat()
                .statusCode(200)
//                .body(JsonSchemaValidator.matchesJsonSchema(new File(userSchemaPath))) ini di comment karena beda schema response
                .body("name", Is.is(name))
                .body("job", Is.is(job));
        System.out.println(response.getBody().asString());
        System.out.println(response.time());
    }

    @Test
    public void successUploadFile()
    {
       RestAssured.baseURI = "https://httpbin.org";
       RequestSpecification request = RestAssured.given();

       request.multiPart("attachment", new File("src\\resources\\dataFile\\exampleText.text"));

       Response response = request.post("/post");
       Assert.assertEquals(response.getStatusCode(), 200, "upload file failed");

       System.out.println(response.asString());
    }


}
