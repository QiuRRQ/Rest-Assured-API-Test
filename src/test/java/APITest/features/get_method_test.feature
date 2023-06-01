Feature: typicode.com API test
  Make sure the response have he correct data type

  Scenario: Get Method and check response data schema

    Given access the end point
    Then  get response data
    And   validate response schema to check response data type