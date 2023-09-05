package pages.seuBarriga;

import core.BasePage;
import org.openqa.selenium.By;
import io.appium.java_client.MobileElement;

import static core.BaseTests.driver;

public class SBSummaryPage extends BasePage {

    public void deleteMovement(String desc) {
        MobileElement el = driver.findElement(By.xpath("//*[@text='"+desc+"']/../.."));
        swipeElement(el, 0.9, 0.1);
        clickByText("Del");
    }
}
