@ui @auth
Feature: Practice Test Automation login
  As a quality engineer
  I want to validate the public login form
  So that I can demonstrate frontend automation coverage with Serenity BDD

  @smoke @regression
  Scenario: Successful authentication with valid credentials
    Given the practice login page is opened
    When the user logs in with the "validUser" credentials
    Then the secure area should be displayed
    And the logout action should be available

  @negative @regression
  Scenario: Authentication should fail with an invalid password
    Given the practice login page is opened
    When the user logs in with the "invalidPasswordUser" credentials
    Then an authentication error should be displayed
