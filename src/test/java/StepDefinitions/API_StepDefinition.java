package StepDefinitions;

import api.ApiHelper;
import cucumber.api.java.en.When;

public class API_StepDefinition {
    ApiHelper helper = new ApiHelper();
    @When("^Get current exchange rate via Privat24 API for '(.*)' currency$")
    public void get_current_exchange_curs_via_Privat24_API_for_currency(String currency) {
        helper.parseRateByCurrency(currency);
    }
}
