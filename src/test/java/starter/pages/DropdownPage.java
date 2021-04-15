package starter.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;

public class DropdownPage extends BasePage {

    @FindBy(id = "dropdown")
    private WebElementFacade dropdown;

    @FindBy(xpath = "//option[@selected]")
    private WebElementFacade dropdownOption;

    public void select_option(String option) {
        dropdown.selectByVisibleText(option);
    }

    public void should_see_that_option_is_selected(String optionExpected) {
        String actual = dropdownOption.getText();
        assertEquals("Options do not much to actual", optionExpected, actual);
    }
}
