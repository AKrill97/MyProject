package StepDefinitions;

import api.ApiHelper;
import cucumber.api.java.en.When;
import libs.TestData;

public class API_StepDefinition {
    ApiHelper helper = new ApiHelper();
    @When("^Get current exchange rate via Privat24 API for '(.*)' currency$")
    public void get_current_exchange_curs_via_Privat24_API_for_currency(String currency) {
        TestData.exchangeCurseFromAPI = helper.parseRateByCurrency(currency);
    }
}
