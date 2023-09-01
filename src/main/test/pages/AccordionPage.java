package pages;

import core.BasePage;
import org.openqa.selenium.By;

public class AccordionPage extends BasePage {
    public void selectOption(String nameOption){
        clickByText(nameOption);
    }

    public String getValueByOption(String nameOption) {
        return getText(By.xpath(String.format("//android.view.ViewGroup[./android.widget.TextView[@text='%s']]/../following-sibling::*//android.widget.TextView",nameOption)));
    }
}
