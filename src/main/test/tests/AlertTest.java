package tests;

import core.BaseTests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.AlertaPage;

import static junit.framework.TestCase.*;

public class AlertTest extends BaseTests {
    private AlertaPage page = new AlertaPage();
    @Before
    public void setUpForm(){
        page.clickByText("Alertas");
    }
    @After
    public void tearDownForm() {
        createScreenShot();
        driver.resetApp();
    }
    @Test
    public void confirmAlert(){
        page.clickByText("ALERTA CONFIRM");

        assertEquals("Info", page.obterTituloAlerta());
        assertEquals("Confirma a operação?", page.obterMensagemAlerta());

        page.clickByText("CONFIRMAR");

        assertEquals("Confirmado", page.obterMensagemAlerta());

        page.clickByText("SAIR");
    }

    @Test
    public void mustClickOutsideAlert(){
        page.clickByText("ALERTA SIMPLES");

        assertTrue(page.isElementPresentByText("Pode clicar no OK ou fora da caixa para sair"));

        pause(1000);
        page.tap(200,150);

        assertFalse(page.isElementPresentByText("Pode clicar no OK ou fora da caixa para sair"));
    }
}
