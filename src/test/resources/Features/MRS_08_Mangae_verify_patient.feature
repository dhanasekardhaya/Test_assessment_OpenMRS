@dashboard
Feature: Manage and Verify Patient Visits

  Scenario: Merge visits and verify recent visit tags
    Given the user is on the Patient Details page
    When the user verifies that the Recent Visits section has two entries for today's date with tags "Vitals" and "Attachment Upload"
    And the user clicks on "Merge Visits"
    And the user selects the two visits and clicks on "Merge Selected Visits"
    And the user clicks on the "Return" button
    Then the Recent Visits section should display one entry for today's date with tags "Vitals, Attachment Upload"

  Scenario: Add past visit and verify future dates are not selectable
    Given the user is on the Patient Details page
    When the user clicks on "Add Past Visit"
    Then the date picker should not allow selection of future dates
    And the user clicks on the "Cancel" button to return to the Patient Details page