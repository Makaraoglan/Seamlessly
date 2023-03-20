@SEAMLES10-503 @wipp
Feature: Logout Functionality

  Background:
  Given User login the app successfully

  @SEAMLES10-501 @wip
  Scenario: Verify user can log out and ends up in login page
    When user click on the avatar icon dropdown
    And user click on the Log out button
    Then user can go back to the login page

  @SEAMLES10-502  @wip
  Scenario: Verify user can not go to home page again by clicking step back button after successfully logged out
    When user successfully logged out
    And user click on step back button
    Then can not go to home page