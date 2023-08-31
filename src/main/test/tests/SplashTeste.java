package tests;

import core.BaseTests;
import org.junit.Test;
import pages.SplashPage;

import static junit.framework.TestCase.assertTrue;

public class SplashTeste extends BaseTests {
    private SplashPage page = new SplashPage();
    @Test
    public void deveAguardarSplashSumir(){
        page.clickByText("Splash");

        page.isVisibleSplashScreen();

        page.waitSplashDisappear();

        assertTrue(page.isElementPresentByText("Formulário"));
    }
}
