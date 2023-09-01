package pages;

import core.BasePage;
import org.openqa.selenium.By;

public class AlertaPage extends BasePage {
    public String obterTituloAlerta() {
        return getText(By.id("android:id/alertTitle"));
    }

    public String obterMensagemAlerta() {
        return getText(By.id("android:id/message"));
    }
}
