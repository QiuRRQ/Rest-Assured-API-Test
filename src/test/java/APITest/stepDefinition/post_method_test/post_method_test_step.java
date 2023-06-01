package APITest.stepDefinition.post_method_test;


import APITest.BaseTest.BaseTestClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.json.JSONException;
import org.junit.Assert;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;


public class post_method_test_step extends BaseTestClass {

    private Response response;
    private RequestSpecification request;
    private JSONObject postBodyParam;

    @Given("^set the end point$")
    public void access_the_end_point(){
        request = getRequestSpecification();
        request.header("Content-Type", "application/json");
    }

    @Then("^access the end point with param \"([^\"]*)\" and \"([^\"]*)\" and (\\d+)$")
    public void get_response_data(String title, String body, int userId){
        postBodyParam = new JSONObject();
        postBodyParam.put("tittle",title);
        postBodyParam.put("body",body);
        postBodyParam.put("userId",userId);

        response = request.body(postBodyParam.toJSONString()).post("/posts");
    }

    @And("^validate response code$")
    public void validate_response_code(){
        response.then().assertThat()
                .statusCode(201);
    }

    @And("^validate response has the correct response compared to the inputted payload$")
    public void validate_response_has_the_correct_response_compared_to_the_inputted_payload(){
        String JsonResponse = response.getBody().asString();
        String postBody = postBodyParam.toJSONString();

        try {
            // Membandingkan objek JSON
            JSONAssert.assertEquals(JsonResponse, postBody, JSONCompareMode.STRICT);
        } catch (JSONException e) {
            Assert.fail("Error during JSON comparison : " + e.getMessage());
        }
    }



}
