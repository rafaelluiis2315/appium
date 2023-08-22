import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.*;

public class FormTest {
    private AndroidDriver<MobileElement> driver;
    private final URL apkPath = FormTest.class.getResource("/CTAppium_2_0.apk");

    @Before
    public void setUp() throws MalformedURLException {
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

        URL remoteUrl = new URL("http://127.0.0.1:4723");

        driver = new AndroidDriver<>(remoteUrl, desiredCapabilities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement buttonGoForm =  driver.findElementByXPath("//android.widget.TextView[@text='Formulário']");
        buttonGoForm.click();
    }

    @Test
    public void typeInInputName() {
        MobileElement inputNome = driver.findElement(MobileBy.AccessibilityId("nome"));
        inputNome.sendKeys("Test");

        assertEquals("Test", inputNome.getText());
    }


    @Test
    public void chooseItemFromCombo() {
        driver.findElement(MobileBy.AccessibilityId("console")).click();

        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();

        MobileElement itemChoose = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView"));

        assertEquals("PS4", itemChoose.getText());
    }

    @Test
    public void clickInCheckBox() {
        By checkedLocation = By.xpath("//android.widget.CheckBox[@content-desc='check']");

        driver.findElement(checkedLocation).click();

        boolean isChecked = driver.findElement(checkedLocation).getAttribute("checked").equals("true");

        assertTrue(isChecked);
    }

    @Test
    public void clickInSwitch() {
        By switchLocation = By.xpath("//android.widget.Switch[@content-desc='switch']");

        driver.findElement(switchLocation).click();

        boolean isChecked = driver.findElement(switchLocation).getAttribute("checked").equals("false");

        assertTrue(isChecked);
    }

    @Test
    public void filedAllForm() {
        String textInputForm = "Test Form";
        driver.findElement(MobileBy.AccessibilityId("nome")).sendKeys(textInputForm);

        driver.findElement(MobileBy.AccessibilityId("console")).click();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

        driver.findElement(By.xpath("//android.widget.CheckBox[@content-desc='check']")).click();

        driver.findElement(By.xpath("//android.widget.Switch[@content-desc='switch']")).click();

        driver.findElement(By.xpath("//android.widget.Button[@content-desc='save']")).click();

        MobileElement showingNome = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
        MobileElement showingConsole = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
        MobileElement showingSwitch = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
        MobileElement showingCheckbox = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));

        assertEquals("Nome: " + textInputForm , showingNome.getText());
        assertEquals("Console: switch", showingConsole.getText());
        assertEquals("Switch: Off", showingSwitch.getText());
        assertEquals("Checkbox: Marcado", showingCheckbox.getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
