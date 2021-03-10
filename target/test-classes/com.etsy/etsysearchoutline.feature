@outline
Feature: Etsy Search With Scenario Outline

  Background: Navigate
    Given user navigates to "https://www.etsy.com"

  Scenario Outline: Etsy Search Validation
    When user search with "<searchValue>"
    Then user should see the title "<title>"
    Examples:
      | searchValue | title       |
      | Hat         | Hat \| Etsy |
      | Key         | Key \| Etsy |
      | Pin         | Pin \| Etsy |

