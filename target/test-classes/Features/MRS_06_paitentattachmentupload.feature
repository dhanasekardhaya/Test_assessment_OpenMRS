Feature: Patient Attachment uploaded Verification

  Scenario: Verify uploaded attachment and recent visit entry
    Given The user navigates back to the patient details page
    Then The uploaded attachment should be visible in the attachment section
    And A recent visit with today's date and tag "Attachment Upload" should be listed
