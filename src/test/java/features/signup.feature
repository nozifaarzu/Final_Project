Feature: Signup Feature

  @signup
  Scenario: user should be able to create a brand new account with unique email address
    Given User in Saks Fifth Avenue homepage
    And user clicks close button of pop up
    And user clicks on Create Account button by hovering over sign in button
    And user enters first and last name
    And user enters their valid and unique email address
    And user enters password and confirm password
    And user enters zipcode and phone number
    When user clicks on Create An Account button
    Then user should be navigated to their My Account page