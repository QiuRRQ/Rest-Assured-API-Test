package Auth;

import BaseTest.BaseTestClass;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;

public class LoginSuccess extends BaseTestClass {

    @Test
    public void SuccessLogin(){
        RequestSpecification request = RestAssured.given();

        String email = "eve.holt@reqres.in";
        String pass = "cityslicka";
        String loginSchemaPath = "src\\resources\\schema\\users\\loginSuccess.json";
//        initiate JSON object
        JSONObject bodyParam = new JSONObject();
        request.header("Content-Type", "application/json");
        bodyParam.put("email", email);
        bodyParam.put("password", pass);
        request.body(bodyParam.toString());

        Response response = request.post("/api/login");
//        Assert.assertEquals(response.getStatusCode(), 201);
//        Assert.assertEquals(response.jsonPath().getString("name"), name);
//        Assert.assertEquals(response.jsonPath().getString("job"), job);
        response.then().assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(new File(loginSchemaPath)));
        System.out.println(response.getBody().asString());
        System.out.println(response.time());
    }
}
