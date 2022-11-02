package pages;

import org.openqa.selenium.WebDriver;

public class DynamicPropertiesPage extends ParentPage {
    //WebElements

    public DynamicPropertiesPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/dynamic-properties";
    }
}
