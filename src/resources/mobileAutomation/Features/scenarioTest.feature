Feature: AppiumTest

  @DoTest
  Scenario: Buy Product, add to chart and checkout product
    Given Input Data and Do Calculate Price
    Given Input Wrong Data and Do Calculate Price