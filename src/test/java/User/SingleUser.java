package User;

import BaseTest.BaseTestClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class SingleUser extends BaseTestClass {

    @Test
    public void successLoadSingleUsers(ITestContext context){

        RequestSpecification request = RestAssured.given();

        String userSchemaPath = "src\\resources\\schema\\users\\user.json";

        Response response = request.get("/api/users/"+context.getAttribute("idUserList"));

        response.then().assertThat()
                .statusCode(200);
    }
}
