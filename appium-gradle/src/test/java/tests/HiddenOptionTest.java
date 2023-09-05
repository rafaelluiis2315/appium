package tests;

import core.BaseTests;
import org.junit.After;
import org.junit.Test;
import pages.MenuPage;

import static junit.framework.TestCase.assertEquals;

public class HiddenOptionTest extends BaseTests {
    private MenuPage page = new MenuPage();

    @After
    public void tearDownForm() {
        createScreenShot();
        driver.resetApp();
    }

    @Test
    public void mustFindHiddenOption(){
        page.waitElementPresentByText("Formulário",10);

        page.scroll(0.9, 0.1);

        page.clickByText("Opção bem escondida");

        assertEquals("Você achou essa opção", page.getMessageAlert());

        page.clickByText("OK");
    }
}
