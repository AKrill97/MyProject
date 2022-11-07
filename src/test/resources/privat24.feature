Feature: Privat24 curses

  @R001
 Scenario Outline: R001 Compare curses from UI and API
    Given Open Privat24 site
    When Open all curses page
    And Read '<Ticker>' on page
    And Get the '<Ticker>' curse by API
    Then Compare both curses


    Examples:
    | Ticker |
    | usd    |