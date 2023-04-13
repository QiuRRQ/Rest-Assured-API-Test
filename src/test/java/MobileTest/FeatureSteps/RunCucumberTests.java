package MobileTest.FeatureSteps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\java\\MobileTest\\Features\\Login.feature",
        glue = "MobileTest.FeatureSteps.Login")
public class RunCucumberTests {

}
