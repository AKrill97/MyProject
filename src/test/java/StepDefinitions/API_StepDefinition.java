package StepDefinitions;

import api.ApiHelper;
import api.PrivatApiDTO;
import cucumber.api.java.en.When;

public class API_StepDefinition {
    ApiHelper helper = new ApiHelper();

    @When("^Get current exchange rates via Privat24 API for '(.*)' currency and save them in local storage$")
    public void get_current_exchange_curs_via_Privat24_API_for_currency(String currency) {
        PrivatApiDTO[] response = helper.getExchangeRatesFromAPI();
        helper.parseExchangeRatesByCurrencyAndSaveInLocalStorage(response, currency);
    }
}
