
Feature: Basic Authentication

  Scenario: Verify that I am able to sign in
    Given I open heroku site
    And I navigate to Basic Auth page
    When I enter my credentials
    Then I should see words Congratulations! You must have the proper credentials
