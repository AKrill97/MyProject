package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
    protected Actions actions;

    public CommonActionsOnElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWaitLow = new WebDriverWait(webDriver, Duration.ofSeconds(6));
        webDriverWaitHigh = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        actions = new Actions(webDriver);
    }

    protected void openPage(String url) {
        try {
            webDriver.get(url);
            logger.info("[" + url + "] was opened");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void acceptAlertPopUp() {
        webDriverWaitLow.until(ExpectedConditions.alertIsPresent());
        webDriver.switchTo().alert().accept();
    }

    protected void dismissAlertPopUp() {
        webDriverWaitLow.until(ExpectedConditions.alertIsPresent());
        webDriver.switchTo().alert().dismiss();
    }

    protected String getTextFromAlert() {
        webDriverWaitLow.until(ExpectedConditions.alertIsPresent());
        return webDriver.switchTo().alert().getText();
    }

    protected void sendKeysToAlert(String keys) {
        webDriverWaitLow.until(ExpectedConditions.alertIsPresent());
        webDriver.switchTo().alert().sendKeys(keys);
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

    protected void clickOnElement(String xpathLocator) {
        try {
            WebElement element = webDriver.findElement(By.xpath(xpathLocator));
            clickOnElement(element);
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void doubleClickOnElement(WebElement webElement) {
        try {
            webDriverWaitLow.withMessage("Button is not clickable").until(ExpectedConditions.elementToBeClickable(webElement));
            String webElementName = getElementName(webElement);
            actions.doubleClick(webElement).perform();
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

    protected boolean isElementDisplayed(String xpathLocator) {
        try {
            boolean isElementDisplayedStatus = webDriver.findElement(By.xpath(xpathLocator)).isDisplayed();
            if (isElementDisplayedStatus) {
                logger.info("Element is displayed");
            } else {
                logger.info("Element is not displayed");
            }
            return isElementDisplayedStatus;
        } catch (Exception e) {
            logger.error("Element is not displayed: " + e);
            return false;
        }
    }

    protected boolean isElementClickable(WebElement webElement) {
        try {
            webDriverWaitLow.until(ExpectedConditions.elementToBeClickable(webElement));
            return true;
        } catch (Exception e) {
            printErrorAndStopTest(e);
            return false;
        }
    }

    protected void switchToOpenedAlert() {
        try {
            webDriverWaitLow.until(ExpectedConditions.alertIsPresent());
            webDriver.switchTo().alert();
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected boolean isElementExist(String xpathLocator) {
        try {
            webDriver.findElement(By.xpath(xpathLocator));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void moveToElement (WebElement element) {
        actions.moveToElement(element);
        actions.perform();
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
