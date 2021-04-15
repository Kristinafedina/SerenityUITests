
Feature: Disappearing Elements

  Scenario: Verify that some elements are disappearing
    Given I open heroku site
    And I navigate to Disappearing Elements page
    When I click About element
    Then I should see words Not Found
    And I come back to previous page
    When I click Contact Us element
    Then I should see words Not Found
    And I come back to previous page
    When I click Portfolio element
    Then I should see words Not Found
    And I come back to previous page
    When I click Home element
    Then I should see words Welcome to the-internet


