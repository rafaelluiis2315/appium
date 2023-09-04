package tests;

import core.BaseTests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.WebViewPage;

import static junit.framework.TestCase.assertEquals;

public class WebViewTest extends BaseTests {
    private WebViewPage page = new WebViewPage();

    @Before
    public void setUpForm(){
        page.clickByText("SeuBarriga Híbrido");
    }
    @After
    public void tearDownWebView(){
        createScreenShot();
        page.sairContextoWeb();
    }
    @Test
    public void deveFazerLogin(){
        pause(3000);
        page.entrarContextoWeb();

        //preencher email
        page.setEmail("a@a");

        //senha
        page.setSenha("a");

        //entrar
        page.entrar();

        //verificar
        assertEquals("Bem vindo, Wagner!", page.getMensagem());
    }
}
