package pages.seuBarriga;

import core.BasePage;
import org.openqa.selenium.By;

public class SBAccountsPage extends BasePage {

    public void setConta(String nome) {
        write(By.className("android.widget.EditText"), nome);
    }

    public void save(){
        clickByText("SALVAR");
    }

    public void delete(){
        clickByText("EXCLUIR");
    }

    public void selectAccount(String account) {
        clickLong(By.xpath("//*[@text='"+ account +"']"));
    }
}