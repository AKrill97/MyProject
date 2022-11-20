package pages;

import libs.TestData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Privat24ExchangeRatePage extends Privat24ParentPage {
    @FindBy(xpath = ".//button[@data-qa-node='exchange']")
    private WebElement exchangeButton;
    private String xpathForCurrencyBuyRate = ".//div[text()='%s']/../../../div[@class='rate_kx9iSqCXBH'][1]";
    private String xpathForCurrencySaleRate = ".//div[text()='%s']/../../../div[@class='rate_kx9iSqCXBH'][2]";

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

    public void getExchangeRatesByCurrencyAndSaveInLocalStorage(String currency) {
        WebElement webElementBuyRate = webDriver.findElement(By.xpath(String.format(xpathForCurrencyBuyRate, currency)));
        WebElement webElementSaleRate = webDriver.findElement(By.xpath(String.format(xpathForCurrencySaleRate, currency)));
        TestData.exchangeBuyCurseFromUI = Float.parseFloat(webElementBuyRate.getText());
        TestData.exchangeSaleCurseFromUI = Float.parseFloat(webElementSaleRate.getText());
        logger.info(String.format("Currency %s, buy rate = %s, sale rate = %s",
                currency, TestData.exchangeBuyCurseFromUI, TestData.exchangeSaleCurseFromUI));
    }
}
