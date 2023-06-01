package APITest.stepDefinition.get_method_test;


import APITest.BaseTest.BaseTestClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.File;

public class get_method_test_step extends BaseTestClass {
    private Response response;
    private RequestSpecification request;

    @Given("^access the end point$")
    public void access_the_end_point(){
        request = getRequestSpecification();
        request.header("Content-Type", "application/json");
    }

    @Then("^get response data$")
    public void get_response_data(){
        response = request.get("/posts");
    }

    @And("^validate response schema to check response data type$")
    public void validate_response_schema_to_check_response_data_type(){
        String validJSONSchema = "src/resources/schema/get_method_test.json";
        response.then().assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(new File(validJSONSchema)));
    }

}
