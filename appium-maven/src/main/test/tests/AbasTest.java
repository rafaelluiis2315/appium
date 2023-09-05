package tests;

import core.BaseTests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.AbasPage;

import static junit.framework.TestCase.assertTrue;

public class AbasTest extends BaseTests {
    private AbasPage page = new AbasPage();
    @Before
    public void setUpForm(){
        page.clickByText("Abas");
    }
    @After
    public void tearDownForm() {
        createScreenShot();
        driver.resetApp();
    }
    @Test
    public void shouldInteractWithAbas(){
        assertTrue(page.isAba1());

        page.selectAba2();

        assertTrue(page.isAba2());
    }
}
