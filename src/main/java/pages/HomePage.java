package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends ParentPage {
    //WebElements

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "";
    }
}
