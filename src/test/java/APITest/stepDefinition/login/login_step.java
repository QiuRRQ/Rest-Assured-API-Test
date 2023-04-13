package APITest.stepDefinition.login;


import APITest.BaseTest.BaseTestClass;
import cucumber.api.java.en.Then;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class login_step {

    @Then("^login with \"([^\"]*)\" and Password \"([^\"]*)\" with response code \"([^\"]*)\"$")
    public void login_with_and_Password_with_response_code(String username, String password, String outcome) {

        RestAssured.baseURI = "https://mobileap-uat.aboitizpower.com";
        RequestSpecification request = RestAssured.given()
                .auth().basic("login","1fff24a1-93d7-476b-a1db-734a0af64305")
                .filter(new AllureRestAssured());

        request.header("Content-Type", "application/json");
        JSONObject userDevicesObject = new JSONObject();
        JSONObject postBodyParam = new JSONObject();
        userDevicesObject.put("type", "SmartPhone");
        userDevicesObject.put("model", "vivo 1938");
        userDevicesObject.put("deviceIdentifier", "18f52d24c27a3f1c");
        userDevicesObject.put("platform", "Android");
        userDevicesObject.put("appVersion", "2.3.0+387");
        userDevicesObject.put("appName", "endUser");

        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        assert digest != null;
        byte[] hash = digest.digest(
                password.getBytes(StandardCharsets.UTF_8));
        String hasedPassword = new String(Hex.encodeHex(hash));
        System.out.println(hasedPassword);
        System.out.println(outcome);
        postBodyParam.put("username",username);
        postBodyParam.put("password",hasedPassword);
        postBodyParam.put("userDevice",userDevicesObject);

        Response response = request.body(postBodyParam.toJSONString()).post("/v1/login");
        response.then().assertThat()
                .statusCode(200);

    }

}
