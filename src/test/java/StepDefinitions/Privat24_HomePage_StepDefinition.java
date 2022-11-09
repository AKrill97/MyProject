package StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import libs.DriverHelper;
import pages.Privat24HomePage;

public class Privat24_HomePage_StepDefinition {
    Privat24HomePage homePage = new Privat24HomePage(DriverHelper.getWebDriver());

    @Given("^User opens Privat24 'Main' page$")
    public void user_opens_Privat24_Main_page() {
        homePage.openHomePage()
                .isHomePageOpened()
        ;
    }

    @When("^User clicks on 'Exchange' page$")
    public void user_clicks_on_Exchange_page() {
        homePage.clickOnExchangeRatesButton();
    }
}
