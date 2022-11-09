package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Privat24ExchangeRatePage extends Privat24ParentPage {
    @FindBy(xpath = ".//button[@data-qa-node='exchange']")
    private WebElement exchangeButton;
    @FindBy(xpath = ".//div[@data-qa-value='nbu']")
    private WebElement NBUtab;

    private String xpathForCurrenciesRate = ".//div[text()='%s']/../../../div[@class='rate_kx9iSqCXBH']";
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

    public void clickOnNBUtab() {
        isElementClickable(NBUtab);
        clickOnElement(NBUtab);
    }

    public float getExchangeRatesByCurrency(String currency) {
        WebElement webElement = webDriver.findElement(By.xpath(String.format(xpathForCurrenciesRate, currency)));
        logger.info(String.format("Currency %s, rate = %s", currency, webElement.getText()));
        return Float.parseFloat(webElement.getText());
    }
}
