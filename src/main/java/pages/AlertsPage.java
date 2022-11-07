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
        return "/alertsWindows";
    }

    public AlertsPage checkIsRedirectToAlertsPage() {
        checkUrl();
        Assert.assertTrue("Page does not loaded", alertButton.isDisplayed());
        return this;
    }

    public AlertsPage clickAlertButton() {
        clickOnElement(alertButton);
        webDriverWaitLow.until(ExpectedConditions.alertIsPresent());
        webDriver.switchTo().alert();
        return this;
    }

    public AlertsPage clickTimerAlertButton() {
        clickOnElement(timerAlertButton);
        webDriverWaitLow.until(ExpectedConditions.alertIsPresent());
        webDriver.switchTo().alert();
        return this;
    }

    public AlertsPage clickConfirmButton() {
        clickOnElement(confirmButton);
        webDriverWaitLow.until(ExpectedConditions.alertIsPresent());
        webDriver.switchTo().alert();
        return this;
    }

    public AlertsPage clickPromtButton() {
        clickOnElement(promptButton);
        webDriverWaitLow.until(ExpectedConditions.alertIsPresent());
        webDriver.switchTo().alert();
        return this;
    }

    public AlertsPage checkSimpleAlert() {
        webDriverWaitLow.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("Message ", "You clicked a button", getTextFromAlert());
        acceptAlert();
        return this;
    }

    public AlertsPage checkTimerAlert() {
        webDriverWaitLow.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("Message ", "This alert appeared after 5 seconds", getTextFromAlert());
        acceptAlert();
        return this;
    }

    public AlertsPage checkConfirmAlert() {
        webDriverWaitLow.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("Message ", "Do you confirm action?", getTextFromAlert());
        acceptAlert();
        Assert.assertEquals("Message", "You selected Ok", confirmResult.getText());
        return this;
    }

    public AlertsPage checkDismissAlert() {
        webDriverWaitLow.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("Message ", "Do you confirm action?", getTextFromAlert());
        dismissAlert();
        Assert.assertEquals("Message", "You selected Cancel", confirmResult.getText());
        return this;
    }

    public AlertsPage checkPromtAlert(String keys) {
        webDriverWaitLow.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("Message ", "Please enter your name", getTextFromAlert());
        sendKeysToAlert(keys);
        acceptAlert();
        Assert.assertEquals("Message ", "You entered " + keys, promptResult.getText());
        return this;
    }
}
