package dynamicPropertiesTests;

import baseTest.BaseTest;
import org.junit.Test;

public class DynamicPropertiesTests extends BaseTest {
    @Test
    public void checkButtonsDynamicProperties() {
        homePage.openHomePage()
                .isHomePageOpened()
                .clickOnElementsButton()
                .openDynamicPropertiesPage()
                .checkIsRedirectToDynamicPropertiesPage()
                .checkEnableAfterButton()
                //.checkColorChangeButton()
                .checkVisibleAfterButton()
        ;
    }
}
