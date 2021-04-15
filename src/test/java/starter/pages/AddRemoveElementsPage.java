package starter.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class AddRemoveElementsPage extends BasePage {

    public void add_a_new_element(String buttonName) {
        WebElementFacade elementButton = find(By.xpath("//*[.='" + buttonName + "']"));
        elementButton.click();
    }
}
