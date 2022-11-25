package User;

import BaseTest.BaseTestClass;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.io.File;

public class CreateUser extends BaseTestClass {

    @Test
    public void successCreateUser(ITestContext context){
        BaseTestClass bastT = new BaseTestClass();
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
//        ITestContext context = null;  ///context null
        context.setAttribute("idUser", response.jsonPath().getInt("id"));
//        bastT.BaseTest(context);
        System.out.println(response.getBody().asString());
        System.out.println(response.time());
    }
}
