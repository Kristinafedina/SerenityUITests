package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.*;
import static org.junit.Assert.assertTrue;

public class BasePage extends PageObject {

   protected static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    private final long WAIT_FOR_TIMEOUT_IN_SECONDS = 5;
    private final String adminUserName = "";
    private final String adminUserPass = "";
    private final String URI_FOR_AUTH = "@the-internet.herokuapp.com/basic_auth";
    private final String HTTP = "http://";
    private final String ALERT_IS_PRESENT = "present";
    private final String ALERT_IS_NOT_PRESENT = "not present";

    public void enter_my_credentials() {
        String userName = System.getProperty("userName", adminUserName);
        String userPass = System.getProperty("userPass", adminUserPass);

        getDriver().get(HTTP + userName + ":" + userPass + URI_FOR_AUTH);
    }

    public boolean is_text_currently_displayed_on_the_page(String words) {
        WebElementFacade wholePage = find(By.xpath("//*"));
        withTimeoutOf(Duration.ofSeconds(WAIT_FOR_TIMEOUT_IN_SECONDS)).waitForText(words);
        return wholePage.getText().contains(words);
    }

    public long select_elements_by_attribute_value(List<WebElementFacade> list, String atrributeValue, String param) {
        return list.stream()
                .filter(elem -> elem.getAttribute(atrributeValue).equals(param))
                .count();
    }

    public void open_elements_context_menu(WebElement element) {
        Actions action = new Actions(getDriver()).contextClick(element);
        action.perform();
    }

    public void alert_is_or_not_present(String alertCondition) {
        boolean presenseOfAlert = false;
            try {
                waitFor(ExpectedConditions.alertIsPresent());
                presenseOfAlert = true;
            } catch (TimeoutException e) {
                presenseOfAlert = false;
            }

        boolean statusOfAlert = true;
        switch (alertCondition) {
            case ALERT_IS_PRESENT: statusOfAlert = true;
                break;
            case ALERT_IS_NOT_PRESENT: statusOfAlert = false;
                break;
            default: logger.info("There is an incorrect status for allert", BasePage.class.getSimpleName());
                break;
        }
        assertTrue(statusOfAlert == presenseOfAlert);
    }

    public void acceptAlert() {
        getAlert().accept();
    }

    public void click_element_by_element_name(String elementText) {
        WebElementFacade element = find(By.xpath("//*[.='"+ elementText +"']"));
        element.click();
    }

    public void come_back_to_previos_page() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.history.go(-1)");
    }


    public void drag_and_drop_eement(WebElementFacade source, WebElementFacade target ) {
        /*Actions a = new Actions(getDriver());
        a.dragAndDrop(source, target).build().perform();*/

        String script = "(function( $ ) {" +
                "    $.fn.simulateDragDrop = function(options) {" +
                "        return this.each(function() {" +
                "            new $.simulateDragDrop(this, options);" +
                "        });" +
                "    };" +
                "    $.simulateDragDrop = function(elem, options) {" +
                "        this.options = options;" +
                "        this.simulateEvent(elem, options);" +
                "    };" +
                "    $.extend($.simulateDragDrop.prototype, {" +
                "        simulateEvent: function(elem, options) {" +
                "            /*Simulating drag start*/" +
                "            var type = 'dragstart';" +
                "            var event = this.createEvent(type);" +
                "            this.dispatchEvent(elem, type, event);" +
                "            /*Simulating drop*/" +
                "            type = 'drop';" +
                "            var dropEvent = this.createEvent(type, {});" +
                "            dropEvent.dataTransfer = event.dataTransfer;" +
                "            this.dispatchEvent($(options.dropTarget)[0], type, dropEvent);" +
                "            /*Simulating drag end*/" +
                "            type = 'dragend';" +
                "            var dragEndEvent = this.createEvent(type, {});" +
                "            dragEndEvent.dataTransfer = event.dataTransfer;" +
                "            this.dispatchEvent(elem, type, dragEndEvent);" +
                "        }," +
                "        createEvent: function(type) {" +
                "            var event = document.createEvent(\"CustomEvent\");" +
                "            event.initCustomEvent(type, true, true, null);" +
                "            event.dataTransfer = {" +
                "                data: {" +
                "                }," +
                "                setData: function(type, val){" +
                "                    this.data[type] = val;" +
                "                }," +
                "                getData: function(type){" +
                "                    return this.data[type];" +
                "                }" +
                "            };" +
                "            return event;" +
                "        }," +
                "        dispatchEvent: function(elem, type, event) {" +
                "            if(elem.dispatchEvent) {" +
                "                elem.dispatchEvent(event);" +
                "            }else if( elem.fireEvent ) {" +
                "                elem.fireEvent(\"on\"+type, event);" +
                "            }" +
                "        }" +
                "    });" +
                "})(jQuery);";

        ((JavascriptExecutor)getDriver()).executeScript(script+"$('#column-a').simulateDragDrop({ dropTarget: '#column-b'});" );
        /*Actions actions = new Actions(getDriver());

       actions.dragAndDrop(source, target).perform();*/
        //actions.clickAndHold(source).moveToElement(target, 250, 100).release().build().perform();


       /* Actions builder = new Actions(getDriver());

        Action dragAndDrop = builder.clickAndHold(source)
                .moveToElement(target)
                .release(target)
                .build();

        dragAndDrop.perform();*/
        /*js.executeScript("function createEvent(typeOfEvent)" +
                " {\n" +"var event =document.createEvent" +
                "(\"CustomEvent\");" +
                "\n" +"event.initCustomEvent(typeOfEvent,true, true, null);" +
                "n" +"event.dataTransfer = {\n" +"data: {},\n" +"setData: " +
                "function (key, value) {\n" +"this.data[key] = value;\n" +"},\n"
                +"getData: function (key) {\n" +"return this.data[key];\n" +"}\n" +"};\n" +
                "return event;\n" +"}\n" +"\n" +"function dispatchEvent(element, event,transferData)" +
                " {\n" +"if (transferData !== undefined) {\n" +"event.dataTransfer = transferData;\n" +"}\n"
                +"if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" +"} " +
                "else if (element.fireEvent) {\n" +"element.fireEvent(\"on\" + event.type, event);" +
                "\n" +"}\n" +"}\n" +"\n" +"function simulateHTML5DragAndDrop(element, destination)" +
                " {\n" +"var dragStartEvent =createEvent('dragstart');\n"
                +"dispatchEvent(element, dragStartEvent);\n" +"var dropEvent " +
                "= createEvent('drop');\n" +"dispatchEvent(destination," +
                " dropEvent,dragStartEvent.dataTransfer);\n" +"var dragEndEvent" +
                " = createEvent('dragend');\n" +"dispatchEvent(element," +
                " dragEndEvent,dropEvent.dataTransfer);\n" +"}\n"
                +"\n" +"var source = arguments[0];\n" +"var destination = arguments[1];" +
                "\n" +"simulateHTML5DragAndDrop(source,destination);",source, target);*/
        try {
            sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
