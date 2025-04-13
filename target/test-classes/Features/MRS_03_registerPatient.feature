Feature: The user Register a new patient in OpenMRS

  Scenario: Validate the register a patient with demographic and contact information
    When The user click on Register a patient
    And The user has fill to following details
      | givenName        | Dhana      |
      | middleName       | Sekar      |
      | familyName       | Honey      |
      | gender           | Male       |
      | birthDay         |         23 |
      | birthMonth       | November   |
      | birthYear        |       1992 |
      | address          |        145 |
      | address2         | MKS street |
      | city             | Salem      |
      | state            | Tamil nadu |
      | country          | India      |
      | post             |     636006 |
      | phone            | 9345161642 |
      | relationshipType | Doctor     |
      | personname       | radhi      |
    Then The user should see the confrim page with the entered patient details
      | givenName        | Dhana      |
      | middleName       | Sekar      |
      | familyName       | Honey      |
      | gender           | Male       |
      | birthDay         |         23 |
      | birthMonth       | November   |
      | birthYear        |       1992 |
      | address          |        145 |
      | address2         | MKS street |
      | city             | Salem      |
      | state            | Tamil nadu |
      | country          | India      |
      | post             |     636006 |
      | phone            | 9345161642 |
      | relationshipType | Doctor     |
      | personname       | radhi      |
