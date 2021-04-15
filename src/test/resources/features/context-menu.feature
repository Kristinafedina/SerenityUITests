
Feature: Context menu

  Scenario: Verify that modal window appears after doble cklick mouse
    Given I open heroku site
    And I navigate to Context Menu page
    When I open context menu
    Then I should see that modal window is present
    And I accept allert
    Then I should see that modal window is not present


