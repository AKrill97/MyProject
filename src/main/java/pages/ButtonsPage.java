package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends ParentPage {
    @FindBy(xpath = ".//button[@id='doubleClickBtn']")
    private WebElement doubleClickButton;
    @FindBy(xpath = ".//button[@id='rightClickBtn']")
    private WebElement rightClickButton;
    @FindBy(xpath = ".//button[@id='aToxe']")
    private WebElement clickMeButton;
    @FindBy(xpath = ".//button[@id='doubleClickMessage']")
    private WebElement doubleClickMessage;
    @FindBy(xpath = ".//button[@id='rightClickMessage']")
    private WebElement rightClickMessage;
    @FindBy(xpath = ".//button[@id='dynamicClickMessage']")
    private WebElement clickMeMessage;

    public ButtonsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/buttons";
    }

    public ButtonsPage checkIsRedirectToButtonsPage() {
        checkUrl();
        Assert.assertTrue("Page does not loaded", doubleClickButton.isDisplayed());
        return this;
    }

    public ButtonsPage clickOnDoubleClickButton() {
        clickOnElement(doubleClickButton);
        clickOnElement(doubleClickButton);
        return this;
    }

    public ButtonsPage clickOnRightClickButton() {
        contextClickOnElement(rightClickButton);
        return this;
    }

    public ButtonsPage clickOnClickMeButton() {
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
