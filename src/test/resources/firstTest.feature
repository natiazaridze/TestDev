Feature: Web login

#  @Authentication2
#  Scenario: User should be able to go to registration page with valid email
#    Given Landing page is opened
#    And the user clicks the sign in button
#    When user enters valid email
#    Then user is located to registration page
#
#  @Registration
#    Scenario: User should be able to register with valid info
#      Given Authentication page is opened
#      And the user enters valid info
#      When user clicks Register button
#      Then user should see success message


  @Authentication
  Scenario: User should be able to register with valid data
    Given Landing page is opened
    And the user clicks the sign in button
    And the user enters valid email
    When user enters valid info to register
    Then succes message shown

