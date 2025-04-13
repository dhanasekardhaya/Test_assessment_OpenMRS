Feature: Delete Patient Record and Verify Deletion

  Scenario: Delete a patient and ensure the patient is no longer listed
    Given the user clicks on Delete Patient
    And the user enters the reason for deletion as "Test"
    And the user clicks on the Confirm button
    Then a toaster message should appear confirming the deletion
    When the user is redirected to the Find Patient Record page
    And the user searches for the deleted patient using the patients "honey"
    Then the patient should not be listed in the search results