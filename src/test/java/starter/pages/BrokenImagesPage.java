package starter.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class BrokenImagesPage extends BasePage {

    @FindBys({@FindBy(css = "img")})
    List<WebElementFacade> listOfImages;

    private final String WIDTH_ATTRIBUTE = "naturalWidth";
    private final String WIDTH_ATTRIBUTE_FOR_BROKEN_IMG = "0";


    public void should_see_that_some_of_images_are_broken(long int1) {

        long brokenImages = select_elements_by_attribute_value(listOfImages, WIDTH_ATTRIBUTE, WIDTH_ATTRIBUTE_FOR_BROKEN_IMG);
        Assert.assertEquals(brokenImages,int1);
    }
}
