package StepDefinitions;

import cucumber.api.java.en.Then;
import libs.TestData;
import org.assertj.core.api.SoftAssertions;


public class Helper_StepDefinition {
    @Then("^Compare '(.*)' exchange rates from local storage for UI and API$")
    public void compare_exchange_rates_from_UI_and_API(String currency) {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(TestData.exchangeBuyCurseFromAPI).isEqualTo(TestData.exchangeBuyCurseFromUI);
        softAssertions.assertThat(TestData.exchangeSaleCurseFromAPI).isEqualTo(TestData.exchangeSaleCurseFromUI);
        softAssertions.assertAll();
    }
}
