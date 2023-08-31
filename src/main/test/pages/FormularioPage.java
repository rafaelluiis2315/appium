package pages;

import core.BasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class FormularioPage extends BasePage {
    public void writeNome(String nome) {
        write(MobileBy.AccessibilityId("nome"), nome);
    }

    public String getNome() {
        return getText(MobileBy.AccessibilityId("nome"));
    }

    public void selectCombo(String valor) {
        selectCombo(MobileBy.AccessibilityId("console"), valor);
    }

    public String getValueCombo(){
        return getText(By.xpath("//android.widget.Spinner/android.widget.TextView"));
    }

    public void clickInCheck(){
        click(By.className("android.widget.CheckBox"));
    }

    public void clickSwitch(){
        click(MobileBy.AccessibilityId("switch"));
    }

    public boolean isChecked(){
        return isChecked(By.className("android.widget.CheckBox"));
    }

    public boolean isSwitchChecked() {
        return isChecked(MobileBy.AccessibilityId("switch"));
    }

    public void save(){
        clickByText("SALVAR");
    }

    public void saveSlowly(){
        clickByText("SALVAR DEMORADO");
    }

    public String getNomeRegistered(){
        return getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
    }

    public String getConsoleRegistered(){
        return getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
    }

    public String getCheckRegistered(){
        return getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
    }

    public String getSwitchRegistered(){
        return getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
    }
}
