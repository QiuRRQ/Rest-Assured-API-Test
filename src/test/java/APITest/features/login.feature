Feature: login testcase
  user should be able to login

  Scenario Outline: "<ScenarioDetail>"

    Then login with "<Username>" and Password "<password>" with response code "<Outcome>"

    Examples:
      | Username        | password  | ScenarioDetail                                           | Outcome     |
#      | usernametest    | passwor   | User login with username and insufficient password       | RedLabel    |
#      | usernametest    | password1 | User login with username or email and incorrect password | InvalidUser |
#      | usernametest    | passwor   | User login with email and insufficient password          | RedLabel    |
      | usernametest    | 12345678  | User can login with username and password                | Success     |
#      | test@rungel.net | 12345678  | User login with email and password                       | Success     |
#      | bye@rungel.net  | 12345678  | User login with secondary email and password             | Success     |