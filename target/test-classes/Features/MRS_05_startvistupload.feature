Feature: Upload patient Attachement

  Scenario: Uploading a valid attachment
    Given The user on the patient's dashboard
    When The user click the start a vist and confrim
    And The user validate the text in alert "Start a visit"
    And The user navigate to the attachment section
    And The user has upload a valid file (e.g, JPEG, PNG or PDF)
    Then The user see a success message confrim the upload "The attachment was successfully uploaded."
