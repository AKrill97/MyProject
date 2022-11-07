package pages;

import org.openqa.selenium.WebDriver;

public class LinksPage extends Menu {
    //WebElements

    public LinksPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/links";
    }
}
