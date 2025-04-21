@dashboard
Feature: BMI Calculation in Patient Vitals

  Scenario: Calculate and verify BMI after entering height and weight
    Given The user starts a new visit
    And The user navigates to the Capture Vitals section
    And The user enters height as "145" cm and weight as "87" kg
    Then The system should display the calculated BMI
    When The user saves the vitals form
    And The user ends the visit
    Then The user should be redirected to the patient details page
    And The patient details should display height as "145" cm, weight as "87" kg, and the correct BMI
