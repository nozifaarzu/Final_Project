Feature: Login Feature


  Scenario: user should be able to login with valid credentials
    Given User in Saks Fifth Avenue homepage
    And user clicks on Sign In button
    And user enters valid email address
    And user enters valid password
    When user clicks on Sign In button again
    Then user should be able to successfully login