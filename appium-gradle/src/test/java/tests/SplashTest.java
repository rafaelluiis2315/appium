package tests;

import core.BaseTests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.SplashPage;

import static junit.framework.TestCase.assertTrue;

public class SplashTest extends BaseTests {
    private SplashPage page = new SplashPage();
    @Before
    public void setUpForm(){
        page.clickByText("Splash");
    }

    @After
    public void tearDownForm() {
        createScreenShot();
    }
    @Test
    public void shouldWaitSplashDisappear(){
        page.isVisibleSplashScreen();

        page.waitSplashDisappear();

        assertTrue(page.isElementPresentByText("Formulário"));
    }
}
