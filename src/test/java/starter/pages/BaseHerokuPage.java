package starter.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("http://the-internet.herokuapp.com/")
public class BaseHerokuPage extends BasePage {

    public void navigate_to_page(String linkName) {
        WebElementFacade pageNameLink = find(By.xpath(String.format("//a[.='%s']", linkName)));
        pageNameLink.click();
    }
}
