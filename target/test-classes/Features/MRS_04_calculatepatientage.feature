@dashboard
Feature: To validate the patient age in system based

  Scenario: Verify patient age is correctly
    Given The user should be in Patient details page
    When The user should be correctly calculated based on data of birth "23 November 1992"
    Then validate the given input and output are matches
