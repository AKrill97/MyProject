package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicPropertiesPage extends Menu {
    @FindBy(xpath = ".//p[text()='This text has random Id']")
    private WebElement textWithRandomId;
    @FindBy(xpath = ".//button[@id='enableAfter']")
    private WebElement enableAfterButton;
    @FindBy(xpath = ".//button[@id='colorChange']")
    private WebElement colorChangeButton;
    @FindBy(xpath = ".//button[@id='visibleAfter']")
    private WebElement visibleAfterButton;

    public DynamicPropertiesPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "dynamic-properties";
    }

    public DynamicPropertiesPage checkIsRedirectToDynamicPropertiesPage() {
        checkUrl();
        Assert.assertTrue("Page does not loaded", textWithRandomId.isDisplayed());
        return this;
    }

    public DynamicPropertiesPage checkEnableAfterButton() {
        webDriverWaitLow.until(ExpectedConditions.elementToBeClickable(enableAfterButton));
        Assert.assertTrue("Button is not Enabled", isElementClickable(enableAfterButton));
        return this;
    }

    public DynamicPropertiesPage checkVisibleAfterButton() {
        webDriverWaitLow.until(ExpectedConditions.visibilityOf(visibleAfterButton));
        Assert.assertTrue("Button is not visible ", isElementDisplayed(visibleAfterButton));
        return this;
    }
}
