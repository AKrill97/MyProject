package StepDefinitions;

import cucumber.api.java.en.When;
import libs.DriverHelper;
import pages.Privat24ExchangeRatePage;

public class Privat24_ExchangeRatePage_StepDefinition {
    Privat24ExchangeRatePage exchangeRatePage = new Privat24ExchangeRatePage(DriverHelper.getWebDriver());

    @When("^Get the '(.*)' exchange rate on page$")
    public void get_the_currencies_exchange_rate(String currency) {
        //todo
    }
}
