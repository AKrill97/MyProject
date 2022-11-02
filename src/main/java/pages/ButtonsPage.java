package pages;

import org.openqa.selenium.WebDriver;

public class ButtonsPage extends ParentPage {
    //WebElements

    public ButtonsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/buttons";
    }
}
