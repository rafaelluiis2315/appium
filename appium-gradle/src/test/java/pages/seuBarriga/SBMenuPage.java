package pages.seuBarriga;

import core.BasePage;

public class SBMenuPage extends BasePage {

    public void accessAccounts(){
        clickByText("Contas");
    }

    public void accessMovements(){
        clickByText("Mov...");
    }

    public void accessSummary(){
        clickByText("Resumo");
    }

    public void accessHome(){
        clickByText("Home");
    }

    public void reset() {
        clickByText("RESET");
    }
}
