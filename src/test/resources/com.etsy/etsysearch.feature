@search
Feature: Etsy Search Functionality

  Background: Navigate to Etsy
    Given user navigates to "https://www.etsy.com/"

    @hat @tc1 @smoke @regression
  Scenario: Validation of etsy search Hat
    When user search with "hat"
    When user should see the title "Hat | Etsy"

    @key @tc2 @smoke @regression
  Scenario: Validation of etsy search Key
    When user search with "key"
    When user should see the title "Key | Etsy"

    @pin @tc3 @regression
  Scenario: Validation of etsy search Pin
    When user search with "pin"
    When user should see the title "Pin | Etsy"