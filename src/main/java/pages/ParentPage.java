package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public abstract class ParentPage extends CommonActionsOnElements {
    protected String baseUrl = "https://demoqa.com/";

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

    protected void checkUrl() {
        Assert.assertEquals("Invalid page", baseUrl + getRelativeUrl(), webDriver.getCurrentUrl());
    }

    protected abstract String getRelativeUrl();
}
