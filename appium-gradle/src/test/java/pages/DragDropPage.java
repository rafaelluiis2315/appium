package pages;

import core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.util.List;

import static core.BaseTests.driver;

public class DragDropPage extends BasePage {
    public void dragDrop(String origem, String destino) {
        MobileElement inicio = driver.findElement(By.xpath("//*[@text='"+origem+"']"));
        MobileElement fim = driver.findElement(By.xpath("//*[@text='"+destino+"']"));

        new TouchAction<>(driver)
                .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(inicio)))
                .moveTo(PointOption.point(fim.getCenter()))
                .release()
                .perform();
    }

    public String[] getList() {
        List<MobileElement> elements = driver.findElements(By.className("android.widget.TextView"));
        String[] textsFound = new String[elements.size()];
        for(int i = 0; i < elements.size(); i++){
            textsFound[i] = elements.get(i).getText();
        }
        return textsFound;
    }
}
