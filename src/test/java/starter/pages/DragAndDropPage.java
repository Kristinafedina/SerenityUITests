package starter.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class DragAndDropPage extends BasePage{

    public void replace_elements(String sourceElName, String targetElName) {
        WebElementFacade source = find(By.xpath("//*[.='" + sourceElName + "']"));
        WebElementFacade target = find(By.xpath("//*[.='" + targetElName + "']"));
        drag_and_drop_eement(source, target);
    }

    public void should_see_that_elements_are_replaced(String firstElement, String secondElement) {
        List <WebElementFacade> list = findAll("//div[@class='column']");
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(list.get(0).getText().equals(firstElement));
        assertions.assertThat(list.get(1).getText().equals(secondElement));
       logger.info(String.valueOf(list));
    }
}
