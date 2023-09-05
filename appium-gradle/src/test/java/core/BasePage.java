package core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static core.BaseTests.driver;

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
        new TouchAction<>(driver)
                .press(PointOption.point(x, y))
                .perform();
    }

    public void scroll(double start, double end) {
        Dimension size = driver.manage().window().getSize();

        int x = size.width / 2;

        int startY = (int) (size.height * start);
        int endY = (int) (size.height * end);

        new TouchAction<>(driver)
                .press(PointOption.point(new Point(x, startY)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(new Point(x, endY)))
                .release()
                .perform();
    }

    public void scrollDown(){
        scroll(0.9, 0.1);
    }

    public String getAlertTitle() {
        return getText(By.id("android:id/alertTitle"));
    }

    public String getMessageAlert() {
        By messageLocator = By.id("android:id/message");
        waitElementPresent(messageLocator, 10);
        return getText(messageLocator);
    }

    public void waitElementPresentByText(String text, int time){
        WebDriverWait wai = new WebDriverWait(driver, time);
        wai.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(String.format("//*[@text='%s']",text))
        ));
    }

    public void waitElementPresent(By element, int time){
        WebDriverWait wai = new WebDriverWait(driver, time);
        wai.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void swipe(double start, double end) {
        Dimension size = driver.manage().window().getSize();

        int y = size.height / 2;

        int start_x = (int) (size.width * start);
        int end_x = (int) (size.width * end);

        new TouchAction<>(driver)
                .press(PointOption.point(new Point(start_x, y)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(new Point(end_x, y)))
                .release()
                .perform();
    }

    public void swipeElement(MobileElement element, double start, double end) {
        int y = element.getLocation().y + (element.getSize().height / 2);

        int start_x = (int) (element.getSize().width * start);
        int end_x = (int) (element.getSize().width * end);

        new TouchAction<>(driver)
                .press(PointOption.point(new Point(start_x, y)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(new Point(end_x, y)))
                .release()
                .perform();
    }

    public void clickLong(By by) {
        new TouchAction<>(driver)
                .longPress(PointOption.point(driver.findElement(by).getCenter()))
                .release()
                .perform();
    }
}
