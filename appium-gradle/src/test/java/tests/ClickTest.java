package tests;

import core.BaseTests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.ClickPage;

import static junit.framework.TestCase.assertEquals;

public class ClickTest extends BaseTests {
    private ClickPage page = new ClickPage();
    @Before
    public void setUpForm(){
        page.clickByText("Cliques");
    }

    @After
    public void tearDownForm() {
        createScreenShot();
        driver.resetApp();
    }
    @Test
    public void mustClickLong(){
        page.clickLong();

        assertEquals("Clique Longo",page.getInputClickText());
    }

    @Test
    public void mustDoubleClick(){
        page.doubleClick();

        assertEquals("Duplo Clique",page.getInputClickText());
    }
}
