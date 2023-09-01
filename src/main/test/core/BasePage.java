package core;

import static core.BaseTests.driver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.util.List;

public class BasePage {

    public void write(By by, String texto) {
        driver.findElement(by).sendKeys(texto);
    }

    public String getText(By by) {
        return driver.findElement(by).getText();
    }

    public void click(By by) {
        driver.findElement(by).click();
    }

    public void clickByText(String texto) {
        click(By.xpath("//*[@text='"+texto+"']"));
    }

    public void selectCombo(By by, String valor) {
        driver.findElement(by).click();
        clickByText(valor);
    }

    public boolean isChecked(By by) {
        return driver.findElement(by).getAttribute("checked").equals("true");
    }

    public boolean isElementPresentByText(String texto) {
        List<MobileElement> elementos = driver.findElements(By.xpath("//*[@text='"+texto+"']"));
        return !elementos.isEmpty();
    }

    public void tap(int x, int y) {
        new TouchAction<>(driver).press(PointOption.point(x, y)).perform();
    }
}
