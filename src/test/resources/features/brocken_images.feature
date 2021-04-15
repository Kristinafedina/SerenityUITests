
Feature: Check that some images are broken

  Scenario: Check that some images are broken
    Given I open heroku site
    When I navigate to Broken Images page
    Then I should see that 2 images are broken


