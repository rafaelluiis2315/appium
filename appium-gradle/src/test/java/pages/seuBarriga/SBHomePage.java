package pages.seuBarriga;

import core.BasePage;
import org.openqa.selenium.By;

public class SBHomePage extends BasePage {

    public String getAccountBalance(String account) {
        return getText(By.xpath("//*[@text='"+ account +"']/following-sibling::android.widget.TextView"));
    }
}