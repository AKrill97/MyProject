package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonActionsOnElements {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWaitLow, webDriverWaitHigh;
    protected Logger logger = Logger.getLogger(getClass());
    protected Actions actions = new Actions(webDriver);

    public CommonActionsOnElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWaitLow = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        webDriverWaitHigh = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    protected void openPage(String url) {
        try {
            webDriver.get(url);
            logger.info("[" + url + "] was opened");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void enterTextIntoElement(WebElement webElement, String textForInput) {
        try {
            webElement.clear();
            webElement.sendKeys(textForInput);
            logger.info("'" + textForInput + "' was inputted into '" + getElementName(webElement) + "'");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void clickOnElement(WebElement webElement) {
        try {
            webDriverWaitLow.withMessage("Button is not clickable").until(ExpectedConditions.elementToBeClickable(webElement));
            String webElementName = getElementName(webElement);
            webElement.click();
            logger.info("Element '" + webElementName + "' was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void contextClickOnElement(WebElement webElement) {
        try {
            webDriverWaitLow.withMessage("Button is not clickable").until(ExpectedConditions.elementToBeClickable(webElement));
            String webElementName = getElementName(webElement);
            actions.contextClick(webElement).perform();
            logger.info("Element '" + webElementName + "' was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected boolean isElementDisplayed(WebElement webElement) {
        try {
            boolean isElementDisplayedStatus = webElement.isDisplayed();
            if (isElementDisplayedStatus) {
                logger.info("Element '" + getElementName(webElement) + "' is displayed");
            } else {
                logger.info("Element is not displayed");
            }
            return isElementDisplayedStatus;
        } catch (Exception e) {
            logger.error("Element is not displayed: " + e);
            return false;
        }
    }

    private String getElementName(WebElement webElement) {
        try {
            return webElement.getAccessibleName();
        } catch (Exception e) {
            return "";
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Cannot work with element: " + e);
        Assert.fail("Cannot work with element: " + e);
    }
}
