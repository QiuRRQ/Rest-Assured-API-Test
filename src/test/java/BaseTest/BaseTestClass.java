package BaseTest;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeClass;
import org.testng.xml.XmlTest;

import javax.naming.Context;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

public class BaseTestClass {

    public ITestContext globalContext;

    @BeforeClass
    public void BaseTest(ITestContext context){
        RestAssured.baseURI = "https://reqres.in";
        this.globalContext = context;
    }
}
