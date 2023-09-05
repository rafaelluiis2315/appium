package pages;

import core.BasePage;

public class AbasPage extends BasePage {
    public boolean isAba1(){
        return isElementPresentByText("Este é o conteúdo da Aba 1");
    }

    public boolean isAba2(){
        return isElementPresentByText("Este é o conteúdo da Aba 2");
    }

    public void selectAba2(){
        clickByText("Aba 2");
    }
}
