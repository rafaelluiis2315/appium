package pages;

import core.BasePage;

public class MenuPage extends BasePage {

    public void clickDragNDrop(){
        waitElementPresentByText("Formulário", 10);
        scrollDown();
        clickByText("Drag and drop");
    }
}
