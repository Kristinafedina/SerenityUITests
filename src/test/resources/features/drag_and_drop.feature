
Feature: Drag and Drop

  Scenario: Drag and Drop Elements
    Given I open heroku site
    And I navigate to Drag and Drop page
    When I replace element A with B
    Then I should see that element B is replaced with A

