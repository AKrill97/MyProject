package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public abstract class Privat24ParentPage extends CommonActionsOnElements {
    protected String baseUrl = "https://next.privat24.ua/";

    public Privat24ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

    protected void checkUrl() {
        Assert.assertEquals("Invalid page", baseUrl + getRelativeUrl(), webDriver.getCurrentUrl());
    }

    protected abstract String getRelativeUrl();
}
