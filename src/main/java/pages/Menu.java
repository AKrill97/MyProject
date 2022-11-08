package pages;

import libs.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Menu extends ParentPage {
    @FindBy(xpath = ".//div[text()='Please select an item from left to start practice.']")
    private WebElement emptyText;
    @FindBy(xpath = ".//span[text()='Buttons']")
    private WebElement buttonsTab;
    @FindBy(xpath = ".//span[text()='Web Tables']")
    private WebElement webTablesTab;
    @FindBy(xpath = ".//*[text()='Dynamic Properties']")
    private WebElement dynamicPropertiesTab;
    @FindBy(xpath = ".//span[text()='Links']")
    private WebElement linksTab;
    @FindBy(xpath = ".//span[text()='Alerts']")
    private WebElement alertsTab;
    @FindBy(xpath = ".//div[text()='Widgets']")
    private WebElement widgetsMainTab;

    public Menu(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return null;
    }

    public AlertsPage openAlertsPage() {
        clickOnElement(alertsTab);
        return new AlertsPage(webDriver);
    }

    public ButtonsPage openButtonsPage() {
        clickOnElement(buttonsTab);
        return new ButtonsPage(webDriver);
    }

    public DynamicPropertiesPage openDynamicPropertiesPage() {
        moveToElement(widgetsMainTab);      //Enter this line to avoid ElementClickInterceptedException while clicking on dynamicPropertiesTab
        clickOnElement(dynamicPropertiesTab);
        return new DynamicPropertiesPage(webDriver);
    }

    public LinksPage openLinksPage() {
        clickOnElement(linksTab);
        return new LinksPage(webDriver);
    }

    public WebTablesPage openWebTablesPage() {
        clickOnElement(webTablesTab);
        return new WebTablesPage(webDriver);
    }
}
