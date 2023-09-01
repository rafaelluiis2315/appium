package pages;

import core.BasePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import static core.BaseTests.driver;

public class ClickPage extends BasePage {

    public void clickLong(){
        new TouchAction<>(driver).longPress(PointOption.point(driver.findElement(By.xpath("//*[@text='Clique Longo']")).getCenter())).perform();
    }

    public String getInputClickText(){
        return driver.findElement(By.xpath("//*[@text='Clique duplo']/following-sibling::android.widget.TextView")).getText();
    }

    public void doubleClick() {
        clickByText("Clique duplo");
        clickByText("Clique duplo");
    }
}
