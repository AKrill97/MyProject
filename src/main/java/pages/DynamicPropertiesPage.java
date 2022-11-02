package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicPropertiesPage extends ParentPage {
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
        return "/dynamic-properties";
    }

    public DynamicPropertiesPage checkIsRedirectToDynamicPropertiesPage() {
        checkUrl();
        Assert.assertTrue("Page does not loaded", textWithRandomId.isDisplayed());
        return this;
    }

    public DynamicPropertiesPage checkEnableAfterButton() {
        //TODO
        return this;
    }

    public DynamicPropertiesPage checkColorChangeButton() {
        //TODO
        return this;
    }

    public DynamicPropertiesPage checkVisibleAfterButton() {
        //TODO
        return this;
    }
}
