package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Privat24HomePage extends Privat24ParentPage {
    @FindBy(xpath = ".//div[@data-qa-value='transfer_money']")
    private WebElement transferMoneyButton;
    @FindBy(xpath = ".//a[@href='/exchange-rates']")
    private WebElement exchangeRatesButton;


    public Privat24HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "";
    }

    public Privat24HomePage openHomePage() {
        openPage(baseUrl);
        return this;
    }

    public Privat24HomePage isHomePageOpened() {
        Assert.assertTrue("Page does not opened ", isElementDisplayed(transferMoneyButton));
        return this;
    }

    public Privat24ExchangeRatePage clickOnExchangeRatesButton() {
        clickOnElement(exchangeRatesButton);
        return new Privat24ExchangeRatePage(webDriver);
    }
}
