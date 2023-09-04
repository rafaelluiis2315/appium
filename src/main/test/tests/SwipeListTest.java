package tests;

import core.BaseTests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.SwipeListPage;

import static junit.framework.TestCase.assertTrue;

public class SwipeListTest extends BaseTests {
    private SwipeListPage page = new SwipeListPage();
    @Before
    public void setUpForm(){
        page.clickByText("Swipe List");
    }

    @After
    public void tearDownForm() {
        createScreenShot();
    }

    @Test
    public void deveResolverDesafio(){
        page.swipeElementRight("Opção 1");

        page.chooseMoreOrLess("+");

        assertTrue(page.isElementPresentByText("Opção 1 (+)"));

        page.swipeElementRight("Opção 4");

        page.chooseMoreOrLess("-");

        assertTrue(page.isElementPresentByText("Opção 4 (-)"));

        page.swipeElementLeft("Opção 5 (-)");

        assertTrue(page.isElementPresentByText("Opção 5"));
    }
}
