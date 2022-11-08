Feature: Privat24 rates

  @R001
 Scenario Outline: R001 Compare rates from UI and API
    Given User opens Privat24 'Main' page
    When Get current exchange rate via Privat24 API for '<Ticker>' currency
    And User opens 'Exchange' page
    And Get the '<Ticker>' exchange rate on page
    Then Compare exchange rates from UI and API

    Examples:
    | Ticker |
    | USD    |