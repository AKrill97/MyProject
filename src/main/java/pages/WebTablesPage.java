package pages;

import org.openqa.selenium.WebDriver;

public class WebTablesPage extends Menu {
    //WebElements

    public WebTablesPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/webtables";
    }
}
