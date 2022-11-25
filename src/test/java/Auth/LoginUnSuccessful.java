package Auth;

import BaseTest.BaseTestClass;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;

public class LoginUnSuccessful extends BaseTestClass {

    @Test
    public void UnSuccessLogin(){
        RequestSpecification request = RestAssured.given();

        String email = "peter@klaven";
        String loginSchemaPath = "src\\resources\\schema\\users\\loginFailed.json";
//        initiate JSON object
        JSONObject bodyParam = new JSONObject();
        request.header("Content-Type", "application/json");
        bodyParam.put("email", email);
        request.body(bodyParam.toString());

        Response response = request.post("/api/login");
//        Assert.assertEquals(response.getStatusCode(), 201);
//        Assert.assertEquals(response.jsonPath().getString("name"), name);
//        Assert.assertEquals(response.jsonPath().getString("job"), job);
        response.then().assertThat()
                .statusCode(400)
                .body(JsonSchemaValidator.matchesJsonSchema(new File(loginSchemaPath)));
        System.out.println(response.getBody().asString());
        System.out.println(response.time());
    }
}
