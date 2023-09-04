package pages.seuBarriga;

import core.BasePage;
import org.openqa.selenium.By;

public class SBLoginPage extends BasePage {

    public void setEmail(String email) {
        write(By.className("android.widget.EditText"), email);
    }

    public void setPassword(String password) {
        write(By.xpath("//android.widget.EditText[2]"), password);
    }

    public void enter(){
        clickByText("ENTRAR");
    }
}