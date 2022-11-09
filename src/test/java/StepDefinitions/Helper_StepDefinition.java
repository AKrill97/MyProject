package StepDefinitions;

import cucumber.api.java.en.Then;
import libs.TestData;
import org.junit.Assert;

public class Helper_StepDefinition {
    @Then("^Compare '(.*)' exchange rates from UI and API$")
    public void compare_exchange_rates_from_UI_and_API(String currency) {
        Assert.assertTrue(String.format("%s exchange rates are not equals. CurseFromUI = %s, CurseFromAPI = %s",
                        currency, TestData.exchangeCurseFromUI, TestData.exchangeCurseFromAPI),
                (TestData.exchangeCurseFromUI == TestData.exchangeCurseFromAPI));
    }
}
