package tests;

import core.BaseTests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.SwipePage;

import static junit.framework.TestCase.assertTrue;

public class SwipeTest extends BaseTests {
    private SwipePage page = new SwipePage();
    @Before
    public void setUpForm(){
        page.clickByText("Swipe");
    }

    @After
    public void tearDownForm() {
        createScreenShot();
    }

    @Test
    public void deveResolverDesafio(){
        assertTrue(page.isElementPresentByText("a esquerda"));

        page.swipeRight();

        assertTrue(page.isElementPresentByText("E veja se"));

        page.clickByText("›");

        assertTrue(page.isElementPresentByText("Chegar até o fim!"));

        page.swipeLeft();

        page.clickByText("‹");

        assertTrue(page.isElementPresentByText("a esquerda"));
    }
}
