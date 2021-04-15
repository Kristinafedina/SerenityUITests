package starter.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.pages.*;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseSteps {

    private BaseHerokuPage baseHerokuPage;
    private AddRemoveElementsPage addRemoveElementsPage;
    private BasePage basePage;
    private BrokenImagesPage brokenImagesPage;
    private CheckboxesPage checkboxesPage;
    private ContextMenuPage contextMenuPage;
    private DragAndDropPage dragAndDropPage;
    private DropdownPage dropdownPage;

    @Given("I open heroku site")
    public void i_open_heroku_site() {
        baseHerokuPage.open();
    }

    @And("^I navigate to (.*) page")
    public void i_navigate_to_page(String linkName) {
        baseHerokuPage.navigate_to_page(linkName);
    }

    @And("^I (Add Element|Delete) element$")
    public void i_add_a_new_element(String elementName) {
        addRemoveElementsPage.add_a_new_element(elementName);
    }

    @Then("^I should see words (.*)")
    public void i_should_see_words(String words) {
        assertThat(basePage.is_text_currently_displayed_on_the_page(words)).isTrue();
    }

    @And("^I should not see (Delete) words")
    public void i_should_not_see_delete_words(String words) {
        assertThat(basePage.containsAllText(words)).isFalse();
    }

    @When("I enter my credentials")
    public void i_enter_my_credentials() {
      basePage.enter_my_credentials();
    }

    @Then("^I should see that (\\d+) images are broken")
    public void i_should_see_that_some_of_images_are_broken(Integer int1) {
       brokenImagesPage.should_see_that_some_of_images_are_broken(int1);
    }

    @When("I check checkbox")
    public void i_check_checkbox() {
        checkboxesPage.check_checkbox();
    }

    @Then("I should see that all are checked")
    public void i_should_see_that_all_are_checked() {
        checkboxesPage.should_see_that_all_are_checked();
    }

    @When("I open context menu")
    public void i_open_context_menu() {
        contextMenuPage.open_context_menu();
    }

    @Then("^I should see that modal window is (present|not present)")
    public void i_should_see_that_modal_window_is_present(String presenseOfAlert) {
        basePage.alert_is_or_not_present(presenseOfAlert);
    }

    @Then("I accept allert")
    public void i_accept_allert() {
        basePage.acceptAlert();
    }

    @When("^I click (Home|Contact Us|Portfolio|About) element")
    public void i_click_element(String elementText) {
        basePage.click_element_by_element_name(elementText);
    }

    @Then("I come back to previous page")
    public void i_come_back_to_previos_page() {
        basePage.come_back_to_previos_page();
    }


    @When("^I replace element (.*) with (.*)")
    public void i_replace_elements(String firstEl, String secondEl) {
        dragAndDropPage.replace_elements(firstEl, secondEl);
    }

    @Then("I should see that element (.*) is replaced with (.*)$")
    public void i_should_see_that_elements_are_replaced(String firstElement, String secondElement) {
        dragAndDropPage.should_see_that_elements_are_replaced(firstElement,secondElement);
    }

    @When("^I select (.*)")
    public void i_select_option(String option) {
        dropdownPage.select_option(option);
    }

    @When("^I should see that (.*) is selected")
    public void i_should_see_that_option_is_selected(String option) {
        dropdownPage.should_see_that_option_is_selected(option);
    }




}
