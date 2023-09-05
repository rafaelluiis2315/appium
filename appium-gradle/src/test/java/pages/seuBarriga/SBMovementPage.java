package pages.seuBarriga;

import core.BasePage;
import org.openqa.selenium.By;


public class SBMovementPage extends BasePage {

    public void save(){
        clickByText("SALVAR");
    }

    public void setDescription(String desc){
        write(By.className("android.widget.EditText"), desc);
    }

    public void setInterested(String interested){
        write(By.xpath("//android.widget.EditText[2]"), interested);
    }

    public void setValue(String value){
        write(By.xpath("//android.widget.EditText[3]"), value);
    }

    public void setAccount(String account) {
        selectCombo(By.xpath("//android.widget.Spinner[2]"), account);
    }
}
