@SEAMLES10-435 @wip
Feature: Login functionality

  Background:
    Given user is on the login page

  @wip @SEAMLES10-434
  Scenario: user login with valid credentials by clicking login button
    When user enters valid username
    And user enters valid password
    And user click on the login button
    Then user land on dashboard page

  @wip @SEAMLES10-453
  Scenario: user login with valid credentials by hitting enter key
    When user enters valid username
    And user enters valid password
    And user hit the enter key
    Then user land on dashboard page

  @wip @SEAMLES10-445
  Scenario Outline: user can not login with any invalid credentials
    When user enters "<username>"
    And user enters a "<password>"
    And user click on the login button
    Then user observe "<message>"
    Examples:
      | username   | password    | message                     |
      | EMPLOYEE30 | Employee123 | Wrong username or password. |
      | EMPLOYEE30 | Employee    | Wrong username or password. |
      | Employee3  | Employee    | Wrong username or password. |


  @wip @SEAMLES10-446
  Scenario Outline: user can not login with any blank credentials
    When user enters "<username>"
    And user enters a "<password>"
    And user click on the login button
    Then user observe blank "<message>"
    Examples:
      | username   | password    | message                     |
      || Employee123    | Please fill out this field. |
      | Employee30  || Please fill out this field. |
      ||| Please fill out this field. |

  @wip @SEAMLES10-447
  Scenario: user can see the password in a form of dots by default
    When user enters valid password
    Then user observe password in a form of dots

  @wip @SEAMLES10-448
  Scenario: user can see the password explicitly
    When user enters valid password
    And user click on toggle password
    Then user observe password itself

  @wip @SEAMLES10-449
  Scenario: User can see the "Forgot password?" link on the login page
    Then user observe forgot password link

  @wip @SEAMLES10-450
  Scenario: user can see the "Reset Password" button on the next page after clicking on forget password link
    When user click on forget password link
    Then user observe reset password button

  @wip @SEAMLES10-451
  Scenario: user can see valid placeholders on Username and Password fields
    Then user observe valid placeholder "Username or email" on username inputbox
    And user observe valid placeholder "Password" on password inputbox
