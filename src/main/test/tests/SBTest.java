package tests;

import core.BaseTests;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.MenuPage;
import pages.seuBarriga.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


public class SBTest extends BaseTests {
    private MenuPage menu = new MenuPage();
    private SBLoginPage login = new SBLoginPage();
    private SBMenuPage menuSB = new SBMenuPage();
    private SBAccountsPage accounts = new SBAccountsPage();
    private SBMovementPage mov = new SBMovementPage();
    private SBHomePage home = new SBHomePage();
    private SBSummaryPage summary = new SBSummaryPage();

    @Before
    public void setupSB(){
        menu.accessSBNativo();
        login.setEmail("a@a");
        login.setPassword("a");
        login.enter();
    }
    @After
    public void tearDownSB(){
        createScreenShot();
        driver.resetApp();
    }

    @Test
    public void mustEnterAccountSuccessfully(){
        menuSB.accessAccounts();

        accounts.setConta("Conta de Teste");

        accounts.save();

        assertTrue(accounts.isElementPresentByText("Conta adicionada com sucesso"));
    }

    @Test
    public void mustDeleteAccount(){
        menuSB.accessAccounts();

        accounts.selectAccount("Conta mesmo nome");

        accounts.delete();

        assertTrue(accounts.isElementPresentByText("Conta excluída com sucesso"));
    }

    @Test
    public void mustValidateMovInclusion(){
        menuSB.accessMovements();

        mov.save();
        assertTrue(mov.isElementPresentByText("Descrição é um campo obrigatório"));

        mov.setDescription("Desc");
        mov.save();
        assertTrue(mov.isElementPresentByText("Interessado é um campo obrigatório"));

        mov.setInterested("interess");
        mov.save();
        assertTrue(mov.isElementPresentByText("Valor é um campo obrigatório"));

        mov.setValue("123");
        mov.save();
        assertTrue(mov.isElementPresentByText("Conta é um campo obrigatório"));

        mov.setAccount("Conta para alterar");
        mov.save();
        assertTrue(mov.isElementPresentByText("Movimentação cadastrada com sucesso"));
    }

    @Test
    public void mustUpdateBalanceWhenDeletingMovement(){
        Assert.assertEquals("534.00", home.getAccountBalance("Conta para saldo"));

        menuSB.accessSummary();

        summary.deleteMovement("Movimentacao 3, calculo saldo");

        assertTrue(summary.isElementPresentByText("Movimentação removida com sucesso!"));

        menuSB.accessHome();

        pause(1000);
        home.scroll(0.2, 0.9);

        assertEquals("-1000.00", home.getAccountBalance("Conta para saldo"));

        menuSB.reset();
    }
}
