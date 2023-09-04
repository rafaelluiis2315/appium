package pages;

import core.BasePage;
import org.openqa.selenium.By;

import java.util.Set;

import static core.BaseTests.driver;

public class WebViewPage extends BasePage {
    public void entrarContextoWeb(){
        Set<String> contextHandles = driver.getContextHandles();
        for(String valor: contextHandles) {
            System.out.println(valor);
        }
        driver.context((String) contextHandles.toArray()[1]);
    }

    public void setEmail(String valor) {
        driver.findElement(By.id("email")).sendKeys(valor);
    }

    public void setSenha(String senha) {
        driver.findElement(By.id("senha")).sendKeys(senha);
    }

    public void entrar(){
        click(By.xpath("//button[@type='submit']"));
    }

    public String getMensagem(){
        return getText(By.xpath("//div[@class='alert alert-success']"));
    }

    public void sairContextoWeb(){
        driver.context((String) driver.getContextHandles().toArray()[0]);
    }
}
