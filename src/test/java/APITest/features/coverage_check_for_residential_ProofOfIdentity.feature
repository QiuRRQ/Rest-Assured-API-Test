Feature: Proof of identity check response of UtilityConnection_GetRequirements
  checking the API response and match it with pseudo code on Utility Connection application specification

  Scenario Outline: Checking proof of identity based on Utility Connection Application specification

    Given requirement of <DocumentName> with <APIParameter> <APIValue> <Required>

    Examples:
    |DocumentName|APIParameter|APIValue|Required|
    |Barangay Clearance (urban poor) |propertyOwnershipTypeId|POT_URBP| false |
    |Barangay Clearance (urban poor) | propertyOwnershipTypeId,titleHolderTypeId|POT_URBP,THT_GOVT|true|


