package pages;

import libs.Util;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class LinksPage extends Menu {
    @FindBy(xpath = ".//a[@id='simpleLink']")
    private WebElement simpleLink;
    @FindBy(xpath = ".//a[@id='dynamicLink']")
    private WebElement dynamicLink;
    @FindBy(xpath = ".//a[@id='created']")
    private WebElement createdLink;
    @FindBy(xpath = ".//a[@id='no-content']")
    private WebElement noContentLink;
    @FindBy(xpath = ".//a[@id='moved']")
    private WebElement movedLink;
    @FindBy(xpath = ".//a[@id='bad-request']")
    private WebElement badRequestLink;
    @FindBy(xpath = ".//a[@id='unauthorized']")
    private WebElement unauthorizedLink;
    @FindBy(xpath = ".//a[@id='forbidden']")
    private WebElement forbiddenLink;
    @FindBy(xpath = ".//a[@id='invalid-url']")
    private WebElement invalidUrlLink;
    @FindBy(xpath = ".//p[@id='linkResponse']")
    private WebElement linkResponse;

    public LinksPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "links";
    }

    public HomePage checkSimpleLink() {
        clickOnElement(simpleLink);
        userOpensNewTab();
        Assert.assertEquals("Message", baseUrl, webDriver.getCurrentUrl());
        return new HomePage(webDriver);
    }

    public HomePage checkDynamicLink() {
        clickOnElement(dynamicLink);
        userOpensNewTab();
        Assert.assertEquals("Message", baseUrl, webDriver.getCurrentUrl());
        return new HomePage(webDriver);
    }

    public LinksPage checkCreatedLink() {
        clickOnElement(createdLink);
        Util.waitABit(1);
        Assert.assertEquals("Message ", "Link has responded with staus 201 and status text Created", linkResponse.getText());
        return this;
    }

    public LinksPage checkNoContentLink() {
        clickOnElement(noContentLink);
        Util.waitABit(1);
        Assert.assertEquals("Message ", "Link has responded with staus 204 and status text No Content", linkResponse.getText());
        return this;
    }

    public LinksPage checkMovedLink() {
        clickOnElement(movedLink);
        Util.waitABit(1);
        Assert.assertEquals("Message ", "Link has responded with staus 301 and status text Moved Permanently", linkResponse.getText());
        return this;
    }

    public LinksPage checkBadRequestLink() {
        clickOnElement(badRequestLink);
        Util.waitABit(1);
        Assert.assertEquals("Message ", "Link has responded with staus 400 and status text Bad Request", linkResponse.getText());
        return this;
    }

    public LinksPage checkUnauthorizedLink() {
        clickOnElement(unauthorizedLink);
        Util.waitABit(1);
        Assert.assertEquals("Message ", "Link has responded with staus 401 and status text Unauthorized", linkResponse.getText());
        return this;
    }

    public LinksPage checkForbiddenLink() {
        clickOnElement(forbiddenLink);
        Util.waitABit(1);
        Assert.assertEquals("Message ", "Link has responded with staus 403 and status text Forbidden", linkResponse.getText());
        return this;
    }

    public LinksPage checkInvalidUrlLink() {
        clickOnElement(invalidUrlLink);
        Util.waitABit(1);
        Assert.assertEquals("Message ", "Link has responded with staus 404 and status text Not Found", linkResponse.getText());
        return this;
    }

    private void userOpensNewTab() {
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
    }
}
