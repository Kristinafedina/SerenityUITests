package starter.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class CheckboxesPage extends BasePage {

    public void check_checkbox() {
        List<WebElementFacade> checkboxes  = findAll("input:not(:checked)[type='checkbox']");
        checkboxes.forEach(ch -> ch.click());
    }

    public void should_see_that_all_are_checked() {
        List<WebElementFacade> allCheckboxes = findAll(By.tagName("input"));
        assertTrue("some checkboxes are not checked", allCheckboxes.stream().allMatch(e -> e.isSelected()));

    }
}
