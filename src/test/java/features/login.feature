Feature: Login Feature

@smoke2
  Scenario: user should be able to login with valid credentials
    Given User in Para Bank homepage
    And user enters username and password
    When user clicks on login button
    Then user should be able to successfully login