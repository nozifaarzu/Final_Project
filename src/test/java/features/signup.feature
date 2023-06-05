Feature: Signup Feature

  @smoke1
  Scenario: user should be able to create a brand new account with unique email address
    Given User in Para Bank homepage
    And user clicks on Register link
    And user enters first and last name
    And user enters address, city,state, and zipcode
    And user enters phone number
    And user enters social security number
    And user enters username
    And user enters password and confirm password
    When user clicks on Register button
    Then user should be successfully registered and logged in