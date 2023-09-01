package tests;

import core.BaseTests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.AccordionPage;

import static org.junit.Assert.assertEquals;

public class AccordionTeste extends BaseTests {
    private AccordionPage page = new AccordionPage();
    @Before
    public void setUpForm(){
        page.clickByText("Accordion");
    }
    @After
    public void tearDownForm() {
        createScreenShot();
        driver.resetApp();
    }

    @Test
    public void deveInteragirComAccordion(){
        page.selectOption("Opção 1");

        pause(1000);

        assertEquals("Esta é a descrição da opção 1", page.getValueByOption("Opção 1"));
    }
}
