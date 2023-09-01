package tests;

import core.BaseTests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.AlertaPage;
import pages.FormularioPage;

import static junit.framework.TestCase.assertEquals;

public class AlertTeste extends BaseTests {
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
}
