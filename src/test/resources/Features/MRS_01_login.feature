Feature: To vaild the login functionality of OpenMRS

  Scenario: To valid the login Functionality with valid credentials
    Given The user should be in login page
    When The user has to fill the username "Admin" and password "Admin123"
    And The user select a location and click the login button
    Then The user should be redirected the dashboard page