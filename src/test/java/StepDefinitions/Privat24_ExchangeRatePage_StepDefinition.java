package StepDefinitions;

import cucumber.api.java.en.When;
import libs.DriverHelper;
import libs.TestData;
import pages.Privat24ExchangeRatePage;

public class Privat24_ExchangeRatePage_StepDefinition {
    Privat24ExchangeRatePage exchangeRatePage = new Privat24ExchangeRatePage(DriverHelper.getWebDriver());

    @When("^User clicks on NBU tab$")
    public void user_clicks_on_NBU_tab() {
        exchangeRatePage.clickOnNBUtab();
    }

    @When("^Get the '(.*)' exchange rate on page$")
    public void get_the_currencies_exchange_rate(String currency) {
        TestData.exchangeCurseFromUI = exchangeRatePage.getExchangeRatesByCurrency(currency);
    }
}
