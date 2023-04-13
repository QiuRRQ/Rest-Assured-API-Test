package MobileTest.FeatureSteps.Login;

import MobileTest.FeatureSteps.BaseClassDefinition;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginTest{
    public MobileDriver<MobileElement> MyDriver;

    @Given("^the user is on the login screen$")
    public void the_user_is_on_the_login_screen() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "vivo 1938");
        desiredCapabilities.setCapability("appPackage", "com.aboitizceh");
        desiredCapabilities.setCapability("appActivity", ".MainActivity");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        MyDriver = new AndroidDriver(remoteUrl, desiredCapabilities);

        MobileElement LoginButton = MyDriver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Log in\"]"));
        Assert.assertEquals("Di halaman Login",LoginButton.isDisplayed(), true);
    }

    @When("^input (.*) on username field$")
    public void input_on_username_field(String username) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        MobileElement userField = MyDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView/android.widget.ScrollView/android.widget.EditText[1]"));

        userField.setValue("username_");
    }

    @When("^input (.*) on password field$")
    public void input_on_password_field(String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        MobileElement passField = MyDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView/android.widget.ScrollView/android.widget.EditText[2]"));

        passField.setValue("username_");
    }

    @Then("^the user should be redirected to the home screen$")
    public void the_user_should_be_redirected_to_the_home_screen() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        MobileElement homeButton = MyDriver.findElement(By.id("Home\n" +
                "Tab 1 of 4"));

        Assert.assertEquals("berada di homePage",homeButton.isDisplayed(), true);
    }



}
