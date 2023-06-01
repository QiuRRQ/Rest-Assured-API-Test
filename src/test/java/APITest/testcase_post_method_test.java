package APITest;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\java\\APITest\\features\\post_method_test.feature",
        glue = {"APITest.stepDefinition.post_method_test"}

)
public class testcase_post_method_test{

}
