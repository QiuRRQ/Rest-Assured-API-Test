package APITest;


import APITest.BaseTest.BaseTestClass;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\java\\APITest\\features\\login.feature",
        glue = {"APITest.stepDefinition.login"},
        monochrome = true

)
public class testcase_login {

}
