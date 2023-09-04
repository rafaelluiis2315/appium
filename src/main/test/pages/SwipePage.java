package pages;

import core.BasePage;

public class SwipePage extends BasePage {
    public void swipeLeft(){
        swipe(0.1, 0.9);
    }

    public void swipeRight(){
        swipe(0.9, 0.1);
    }
}
