Feature: Privat24 rates

  @R001
 Scenario Outline: R001 Compare rates from UI and API
    Given User opens Privat24 'Main' page
    When User clicks on 'Exchange' page
    And Get the '<Ticker>' exchange rate on page and save them in local storage
    And Get current exchange rates via Privat24 API for '<Ticker>' currency and save them in local storage
    Then Compare '<Ticker>' exchange rates from local storage for UI and API

    Examples:
    | Ticker |
    | USD    |
    | EUR    |