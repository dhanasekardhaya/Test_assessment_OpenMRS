Feature: Validate the dashboard page

  Scenario: Verify the dashboard after logging in with valid credentials
    Given The user is on the dashboard page
    When The user click the register a patient button
    Then The user should be taken to the Register Patient page
