Feature: API test for checking response of UtilityConnection_GetRequirements
  checking the API response and match it with pseudo code on Utility Connection application specification

  Scenario Outline: Checking based on Utility Connection Application specification

    Given requirement of <CustomerType> with <PropertyOwnerShip> <TitleHolder> <Representative> <PropertyUnderConstruction> <PropertyNotYetSubDivided> <TraversingWire> <MaritalStatus> <LoadOver8KWH>

    Examples:
    |CustomerType|PropertyOwnerShip|TitleHolder|Representative|PropertyUnderConstruction|PropertyNotYetSubDivided|MaritalStatus|
    |Residential |Purchased        |Myself     |Null          |   True                  |         True           |Single       |
