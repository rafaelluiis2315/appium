import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTest {

    private AndroidDriver<MobileElement> driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Pixel 3");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:appPackage", "com.android.calculator2");
        desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");

        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723");

        driver = new AndroidDriver<>(remoteUrl, desiredCapabilities);
    }

    @Test
    public void sampleTest() {
        MobileElement el1 =  driver.findElementById("com.android.calculator2:id/digit_2");
        el1.click();
        MobileElement el2 = driver.findElementByAccessibilityId("plus");
        el2.click();
        MobileElement el3 = driver.findElementById("com.android.calculator2:id/digit_2");
        el3.click();
        MobileElement el4 =  driver.findElementById("com.android.calculator2:id/result");
        assertEquals("4", el4.getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
