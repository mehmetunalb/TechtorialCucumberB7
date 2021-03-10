Feature: WebOrder Page Food Order
  Scenario: Validation of Food Order For Office
    Given user is on WebOrder home page
    When user selects "Office" option
    And user is on the group order page
    Then user sends invitees note "Test"
    And user send invite list "Kushal@gmail.com" and "Priyanka@gmail.com"
    And user validates "View Group Order" text
    * user validates total participant is 1
