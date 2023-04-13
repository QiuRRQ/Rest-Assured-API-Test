package APITest.BaseTest;

import io.restassured.RestAssured;

import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;

public class BaseTestClass {

    public ITestContext globalContext;


    @BeforeClass
    public void BaseTest(ITestContext context){
//        RestAssured.baseURI = "https://api.punkapi.com/v2";
        RestAssured.baseURI = "https://mobileap-uat.aboitizpower.com";

        this.globalContext = context;
    }
}
