package buttonTests;

import baseTest.BaseTest;
import org.junit.Test;

public class ButtonTests extends BaseTest {
    @Test
    public void checkButtonsOnPage() {
        homePage.openHomePage()
                .isHomePageOpened()
                .clickOnElementsButton()
                .openButtonsPage()
                .checkIsRedirectToButtonsPage()
                .clickOnDoubleClickButton()
                .checkDoubleClickMessage()
                .clickOnRightClickButton()
                .checkRightClickMessage()
                .clickOnClickMeButton()
                .checkClickMeMessage()
        ;
    }
}
