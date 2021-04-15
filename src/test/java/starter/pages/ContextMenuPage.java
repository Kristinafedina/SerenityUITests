package starter.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends BasePage {

    @FindBy(id = "hot-spot")
    private WebElementFacade divThatTriggerAlert;

    public void open_context_menu() {
        open_elements_context_menu(divThatTriggerAlert);
    }
}
