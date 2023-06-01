package APITest.BaseTest;

import io.restassured.RestAssured;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;

public class BaseTestClass {

    private String baseUrl = "https://jsonplaceholder.typicode.com";

    protected RequestSpecification getRequestSpecification() {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .baseUri(baseUrl);
    }
}
