import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class UploadFile {

    @DataProvider(name = "data-users")
    Object[][] DataUsers(){
        Object[][] Users = new Object[][]{
                {"aziz", "Backend"},
                {"rohim", "mobile"},
        };

        return Users;
    }

    @Test(dataProvider = "data-users")
    public void successCreateDataUser(String name, String job){
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = RestAssured.given();

        String userSchemaPath = "src\\resources\\schema\\users\\user.json";
//        initiate JSON object
        JSONObject bodyParam = new JSONObject();
        request.header("Content-Type", "application/json");
        bodyParam.put("name", name);
        bodyParam.put("job", job);
        request.body(bodyParam.toString());

        Response response = request.post("/api/users");
        response.then().assertThat()
                .statusCode(201)
                .body(JsonSchemaValidator.matchesJsonSchema(new File(userSchemaPath)));

        System.out.println(response.getBody().asString());
        System.out.println(response.time());
    }
}
