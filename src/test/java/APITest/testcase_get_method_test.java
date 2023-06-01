package APITest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\java\\APITest\\features\\get_method_test.feature",
        glue = {"APITest.stepDefinition.get_method_test"},
        plugin = {"pretty"}

)
@ExtendWith(AllureJunit5.class)
public class testcase_get_method_test {

}
