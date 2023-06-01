Feature: typicode.com API test
  make sure the response has the correct response compared to the
  inputted payload

  Scenario Outline: Post Method and check response data input value

    Given set the end point
    Then  access the end point with param "<title>" and "<body>" and <userId>
    And   validate response code
    And   validate response has the correct response compared to the inputted payload

    Examples:
    |title|body|userId|
    |recommendation|motorcycle|12|