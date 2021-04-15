
Feature: Checkboxes

  Scenario: Verify that checkbox are checked
    Given I open heroku site
    And I navigate to Checkboxes page
    When I check checkbox
    Then I should see that all are checked


