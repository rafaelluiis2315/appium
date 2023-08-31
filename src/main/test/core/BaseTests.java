package core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import tests.FormTest;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    public static AndroidDriver<MobileElement> driver;
    @Rule
    public TestName testName = new TestName();
    private static final URL apkPath = FormTest.class.getResource("/CTAppium_2_0.apk");

    @BeforeClass
    public static void setUp() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Pixel 7");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");

        Serializable appPath  = (apkPath != null) ? apkPath.getPath() : new NullPointerException("APK not found");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, appPath.toString());

        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = null;
        try {
            remoteUrl = new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        driver = new AndroidDriver<>(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) driver.quit();
    }

    public void createScreenShot(){
        try {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            Path screenshotPath = Paths.get("target/screenshots", testName.getMethodName() + ".png");
            Files.write(screenshotPath, screenshotBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
