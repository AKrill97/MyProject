package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Privat24ExchangeRatePage extends Privat24ParentPage {
    @FindBy(xpath = ".//button[@data-qa-node='exchange']")
    private WebElement exchangeButton;

    public Privat24ExchangeRatePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/exchange-rates";
    }

    public Privat24ExchangeRatePage isExchangeRatePageOpened() {
        Assert.assertTrue("Page does not opened ", isElementDisplayed(exchangeButton));
        return this;
    }

    public void getExchangeRatesByCurrency(String currency) {
        //todo
    }
}
