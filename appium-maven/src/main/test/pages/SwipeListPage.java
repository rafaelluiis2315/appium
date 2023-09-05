package pages;

import core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;

import static core.BaseTests.driver;

public class SwipeListPage extends BasePage {
    public void swipeElementLeft(String opcao) {
        swipeElement(driver.findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.1, 0.9);
    }

    public void swipeElementRight(String opcao) {
        swipeElement(driver.findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.9, 0.1);
    }

    public void chooseMoreOrLess(String option){
        MobileElement botao = driver.findElement(By.xpath("//android.widget.TextView[@text='("+option+")']/.."));
        new TouchAction<>(driver)
                .tap(TapOptions.tapOptions().withElement(ElementOption.element(botao, 50, 0)))
                .perform();
    }
}
