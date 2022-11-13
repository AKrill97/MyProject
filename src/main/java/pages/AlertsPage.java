package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsPage extends Menu {
    @FindBy(xpath = ".//button[@id='alertButton']")
    private WebElement alertButton;
    @FindBy(xpath = ".//button[@id='timerAlertButton']")
    private WebElement timerAlertButton;
    @FindBy(xpath = ".//button[@id='confirmButton']")
    private WebElement confirmButton;
    @FindBy(xpath = ".//button[@id='promtButton']")
    private WebElement promptButton;
    @FindBy(xpath = ".//span[@id='confirmResult']")
    private WebElement confirmResult;
    @FindBy(xpath = ".//span[@id='promptResult']")
    private WebElement promptResult;

    public AlertsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "alerts";
    }

    public AlertsPage checkIsRedirectToAlertsPage() {
        checkUrl();
        Assert.assertTrue("Page does not loaded", alertButton.isDisplayed());
        return this;
    }

    public AlertsPage clickAlertButtonAndSwitchToOpenedPopUp() {
        clickOnElement(alertButton);
        switchToOpenedAlert();
        return this;
    }

    public AlertsPage clickTimerAlertButtonAndSwitchToOpenedPopUp() {
        clickOnElement(timerAlertButton);
        switchToOpenedAlert();
        return this;
    }

    public AlertsPage clickConfirmButtonAndSwitchToOpenedPopUp() {
        clickOnElement(confirmButton);
        switchToOpenedAlert();
        return this;
    }

    public AlertsPage clickPromtButtonAndSwitchToOpenedPopUp() {
        clickOnElement(promptButton);
        switchToOpenedAlert();
        return this;
    }

    public AlertsPage checkSimpleAlert() {
        webDriverWaitLow.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("Unexpected text ", "You clicked a button", getTextFromAlert());
        return this;
    }

    public AlertsPage checkTimerAlert() {
        webDriverWaitLow.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("Unexpected text ", "This alert appeared after 5 seconds", getTextFromAlert());
        return this;
    }

    public AlertsPage checkConfirmAlert() {
        webDriverWaitLow.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("Unexpected text ", "Do you confirm action?", getTextFromAlert());
        return this;
    }

    public AlertsPage checkConfirmTextFromConfirmAlert() {
        Assert.assertEquals("Unexpected text ", "You selected Ok", confirmResult.getText());
        return this;
    }

    public AlertsPage checkDismissAlert() {
        webDriverWaitLow.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("Unexpected text ", "Do you confirm action?", getTextFromAlert());
        return this;
    }

    public AlertsPage checkDismissTextFromConfirmAlert() {
        Assert.assertEquals("Unexpected text ", "You selected Cancel", confirmResult.getText());
        return this;
    }

    public AlertsPage checkPromtAlert(String keys) {
        webDriverWaitLow.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("Unexpected text ", "Please enter your name", getTextFromAlert());
        sendKeysToAlert(keys);
        return this;
    }

    public AlertsPage checkTextFromPromtAlert(String keys) {
        Assert.assertEquals("Unexpected text ", "You entered " + keys, promptResult.getText());
        return this;
    }

    public AlertsPage acceptAlert() {
        acceptAlertPopUp();
        return this;
    }

    public AlertsPage dismissAlert() {
        dismissAlertPopUp();
        return this;
    }

}
