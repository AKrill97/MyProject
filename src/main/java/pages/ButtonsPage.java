package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ButtonsPage extends Menu {
    @FindBy(xpath = ".//button[@id='doubleClickBtn']")
    private WebElement doubleClickButton;
    @FindBy(xpath = ".//button[@id='rightClickBtn']")
    private WebElement rightClickButton;
    @FindBy(xpath = ".//button[text()='Click Me']")
    private WebElement clickMeButton;
    @FindBy(xpath = ".//p[@id='doubleClickMessage']")
    private WebElement doubleClickMessage;
    @FindBy(xpath = ".//p[@id='rightClickMessage']")
    private WebElement rightClickMessage;
    @FindBy(xpath = ".//p[@id='dynamicClickMessage']")
    private WebElement clickMeMessage;

    public ButtonsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "buttons";
    }

    public ButtonsPage checkIsRedirectToButtonsPage() {
        checkUrl();
        Assert.assertTrue("Page does not loaded", doubleClickButton.isDisplayed());
        return this;
    }

    public ButtonsPage clickOnDoubleClickButton() {
        webDriverWaitLow.until(ExpectedConditions.visibilityOf(banner));
        doubleClickOnElement(doubleClickButton);
        return this;
    }

    public ButtonsPage clickOnRightClickButton() {
        webDriverWaitLow.until(ExpectedConditions.visibilityOf(banner));
        contextClickOnElement(rightClickButton);
        return this;
    }

    public ButtonsPage clickOnClickMeButton() {
        webDriverWaitLow.until(ExpectedConditions.visibilityOf(banner));
        clickOnElement(clickMeButton);
        return this;
    }

    public ButtonsPage checkDoubleClickMessage() {
        isElementDisplayed(doubleClickMessage);
        Assert.assertEquals("Unexpected text ", "You have done a double click", doubleClickMessage.getText());
        return this;
    }

    public ButtonsPage checkRightClickMessage() {
        isElementDisplayed(rightClickMessage);
        Assert.assertEquals("Unexpected text ", "You have done a right click", rightClickMessage.getText());
        return this;
    }

    public ButtonsPage checkClickMeMessage() {
        isElementDisplayed(clickMeMessage);
        Assert.assertEquals("Unexpected text ", "You have done a dynamic click", clickMeMessage.getText());
        return this;
    }
}
