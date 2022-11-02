package pages;

import org.openqa.selenium.WebDriver;

public class AlertsPage extends ParentPage {
    //WebElements

    public AlertsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/alertsWindows";
    }
}
