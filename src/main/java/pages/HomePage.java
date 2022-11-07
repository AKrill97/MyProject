package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {
    @FindBy(xpath = ".//*[@class='banner-image']")
    private WebElement mainBanner;
    @FindBy(xpath = ".//h5[text()='Elements']")
    private WebElement elementsButton;
    @FindBy(xpath = ".//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertsButton;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "";
    }

    public HomePage openHomePage() {
        openPage(baseUrl);
        return this;
    }

    public HomePage isHomePageOpened() {
        isElementDisplayed(mainBanner);
        return this;
    }

    public Menu clickOnElementsButton() {
        clickOnElement(elementsButton);
        return new Menu(webDriver);
    }

    public Menu clickOnAlertsButton () {
        clickOnElement(alertsButton);
        return new Menu(webDriver);
    }
}
