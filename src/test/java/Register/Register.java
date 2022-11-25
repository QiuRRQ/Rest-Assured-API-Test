package Register;

import BaseTest.BaseTestClass;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;

public class Register extends BaseTestClass {

    @Test
    public void successRegister(){
        RequestSpecification request = RestAssured.given();

        String email = "eve.holt@reqres.in";
        String password = "pistol";
        String registerSchemaPath = "src\\resources\\schema\\users\\registerSchemaSuccess.json";
//        initiate JSON object
        JSONObject bodyParam = new JSONObject();
        request.header("Content-Type", "application/json");
        bodyParam.put("email", email);
        bodyParam.put("password", password);
        request.body(bodyParam.toString());

        Response response = request.post("/api/register");
//        Assert.assertEquals(response.getStatusCode(), 201);
//        Assert.assertEquals(response.jsonPath().getString("name"), name);
//        Assert.assertEquals(response.jsonPath().getString("job"), job);
        response.then().assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(new File(registerSchemaPath)));
        System.out.println(response.getBody().asString());
        System.out.println(response.time());
    }
}
