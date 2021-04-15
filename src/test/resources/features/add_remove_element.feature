
Feature: Add Remove Element

  Scenario: Add Element
    Given I open heroku site
    And I navigate to Add/Remove Elements page
    When I Add Element element
    Then I should see words Delete
    And I Delete element
    Then I should not see Delete words

