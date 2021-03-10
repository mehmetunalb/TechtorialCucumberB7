Feature: Validation of Products Page

  @products
  Scenario: Validation of New Product Creation
    Given user is on product website home page
    Then user enters product info "MyMoney" and "4"
    And user enters the address info "Techtorial", "2200 E Devon Ave", "Des Plaines", "IL", "60018"
    * user enters card info "Visa", "1234123412341234", "04/22"
    And user validates success message
    Then user validates product details "MyMoney", "4", "Techtorial", "2200 E Devon Ave", "Des Plaines", "IL", "60018", "Visa", "1234123412341234", "04/22"

  @products @outline
  Scenario Outline: Validation of New Product Creation
    Given user is on product website home page
    Then user enters product info "<productName>" and "<quantity>"
    And user enters the address info "<name>", "<street>", "<city>", "<state>", "<zipcode>"
    * user enters card info "<cardType>", "<cardNumber>", "<expireDate>"
    And user validates success message
    Then user validates product details "<productName>", "<quantity>", "<name>", "<street>", "<city>", "<state>", "<zipcode>", "<cardType>", "<cardNumber>", "<expireDate>"
    Examples:
    | productName | quantity | name       | street       | city        | state | zipcode | cardType         | cardNumber   | expireDate |
    | MyMoney     | 4        | Techtorial | 2200 E Devon | Des Plaines | IL    | 60018   | Visa             | 123412341234 | 04/22      |
    | FamilyAlbum | 2        | Academy    | 2200 E Devon | Austin      | TX    | 90011   | MasterCard       | 124521541254 | 08/21      |
    | ScreenSaver | 5        | Techtorial | 2200 E Devon | Chicago     | IL    | 60101   | American Express | 321654987112 | 04/22      |