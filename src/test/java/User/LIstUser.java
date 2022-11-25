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

public class LIstUser extends BaseTestClass {

    @Test
    public void successLoadListUsers(ITestContext context){

        RequestSpecification request = RestAssured.given();

        String userSchemaPath = "src\\resources\\schema\\users\\user.json";

        request.param("page", 2);

        Response response = request.get("/api/users");

        response.then().assertThat()
                .statusCode(200);
        context.setAttribute("idUserList", response.jsonPath().getInt("data[0].id"));
    }
}
