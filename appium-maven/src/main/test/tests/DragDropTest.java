package tests;

import core.BaseTests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.DragDropPage;
import pages.MenuPage;

import static org.junit.Assert.assertArrayEquals;

public class DragDropTest extends BaseTests {
    private MenuPage menu = new MenuPage();
    private DragDropPage page = new DragDropPage();
    private final String[] starState = new String[]{"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado."};
    private final String[] midState = new String[]{"é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "Esta", "qualquer local desejado."};
    private final String[] endState = new String[]{"Faça um clique longo,", "é uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado."};

    @Before
    public void setUpForm(){
        menu.clickDragNDrop();
    }
    @After
    public void tearDownForm() {
        createScreenShot();
    }

    @Test
    public void mustInteractionWithDragNDrop(){
        pause(1000);
        assertArrayEquals(starState, page.getList());

        page.dragDrop("Esta", "e arraste para");

        assertArrayEquals(midState, page.getList());

        page.dragDrop("Faça um clique longo,", "é uma lista");

        assertArrayEquals(endState, page.getList());
    }
}
