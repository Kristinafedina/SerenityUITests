
Feature: Select dropdown option

  Background:
    Given I open heroku site
    And I navigate to Dropdown page
    And I should see words Please select an option

  Scenario: Select option 1
    When I select Option 1
    Then I should see that Option 1 is selected

  Scenario: Select option 2
    When I select Option 2
    Then I should see that Option 2 is selected