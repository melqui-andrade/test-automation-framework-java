@ui @forms
Feature: Selenium demo web form submission
  As a quality engineer
  I want to validate a simple frontend form flow
  So that I can show maintainable UI automation for public demo applications

  @smoke @regression
  Scenario: Submit the web form with a valid data set
    Given the Selenium demo web form is opened
    When the user submits the form with the "defaultSubmission" data set
    Then the form submission should be accepted
    And the checkbox should remain selected
