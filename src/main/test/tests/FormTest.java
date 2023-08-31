package tests;

import core.BaseTests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FormularioPage;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.*;

public class FormTest extends BaseTests {

    private FormularioPage page = new FormularioPage();
    @Before
    public void setUpForm(){
        page.clickByText("Formulário");
    }

    @After
    public void tearDownForm() {
        createScreenShot();
        driver.resetApp();
    }

    @Test
    public void typeInInputName() {
        page.writeNome("Wagner");
        assertEquals("Wagner", page.getNome());
    }


    @Test
    public void chooseItemFromCombo() {
        page.selectCombo("PS4");

        assertEquals("PS4", page.getValueCombo());
    }

    @Test
    public void clickInCheckBox() {
        assertFalse(page.isChecked());
        assertTrue(page.isSwitchChecked());

        page.clickInCheck();

        assertTrue(page.isChecked());

    }

    @Test
    public void clickInSwitch() {
        assertTrue(page.isSwitchChecked());

        page.clickSwitch();

        assertFalse(page.isSwitchChecked());
    }

    @Test
    public void filedAllForm() {
        page.writeNome("Rafael");
        page.clickInCheck();
        page.clickSwitch();
        page.selectCombo("Nintendo Switch");

        page.save();

        assertEquals("Nome: Rafael", page.getNomeRegistered());
        assertEquals("Console: switch", page.getConsoleRegistered());
        assertEquals("Switch: Off", page.getCheckRegistered());
        assertEquals("Checkbox: Marcado", page.getSwitchRegistered());
    }

    @Test()
    public void deveRealizarCadastroDemorado(){
        page.writeNome("Wagner");

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        page.saveSlowly();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Wagner']")));

        assertEquals("Nome: Wagner", page.getNomeRegistered());

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
