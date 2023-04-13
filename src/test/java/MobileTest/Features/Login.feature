Feature: Login
  Scenario Outline: : Login with valid credentials
    Given the user is on the login screen
    When  input "<username>" on username field
    And   input "<pass>" on password field
    Then the user should be redirected to the home screen

    Examples:
    |username|pass|
    |username_|password|