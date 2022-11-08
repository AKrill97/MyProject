package linksTests;

import baseTest.BaseTest;
import org.junit.Test;

public class LinksTests extends BaseTest {
    @Test
    public void checkSimpleLink() {
        homePage.openHomePage()
                .isHomePageOpened()
                .clickOnElementsButton()
                .openLinksPage()
                .checkSimpleLink()
        ;
    }

    @Test
    public void checkDynamicLink() {
        homePage.openHomePage()
                .isHomePageOpened()
                .clickOnElementsButton()
                .openLinksPage()
                .checkDynamicLink()
        ;
    }

    @Test
    public void checkResponsesFromLinks() {
        homePage.openHomePage()
                .isHomePageOpened()
                .clickOnElementsButton()
                .openLinksPage()
                .checkCreatedLink()
                .checkNoContentLink()
                .checkMovedLink()
                .checkBadRequestLink()
                .checkUnauthorizedLink()
                .checkForbiddenLink()
                .checkInvalidUrlLink()
        ;
    }
}
