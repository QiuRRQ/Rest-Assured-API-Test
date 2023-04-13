package MobileTest.FeatureSteps;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseClassDefinition {

    public MobileDriver<MobileElement> MyDriver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "vivo 1938");
        desiredCapabilities.setCapability("appPackage", "com.aboitizceh");
        desiredCapabilities.setCapability("appActivity", ".MainActivity");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        MyDriver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @After
    public void teardown() {
        if (MyDriver != null) {
            MyDriver.quit();
        }
    }
}
