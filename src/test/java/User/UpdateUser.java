package User;

import BaseTest.BaseTestClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.core.Is;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class UpdateUser extends BaseTestClass {

    @Test
    public void successUpdateUser(ITestContext context){
        BaseTestClass baseT = new BaseTestClass();
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

        Response response = request.put("/api/users/"+context.getAttribute("idUser"));
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
}
