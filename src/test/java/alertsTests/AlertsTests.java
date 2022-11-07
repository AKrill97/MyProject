package alertsTests;

import baseTest.BaseTest;
import org.junit.Test;

public class AlertsTests extends BaseTest {
    @Test
    public void checkSimpleAlert() {
        homePage.openHomePage()
                .isHomePageOpened()
                .clickOnAlertsButton()
                .openAlertsPage()
                .checkIsRedirectToAlertsPage()
                .clickAlertButton()
                .checkSimpleAlert()
                ;
    }

    @Test
    public void checkTimerAlert() {
        homePage.openHomePage()
                .isHomePageOpened()
                .clickOnAlertsButton()
                .openAlertsPage()
                .checkIsRedirectToAlertsPage()
                .clickTimerAlertButton()
                .checkTimerAlert()
        ;
    }

    @Test
    public void checkConfirmAlert() {
        homePage.openHomePage()
                .isHomePageOpened()
                .clickOnAlertsButton()
                .openAlertsPage()
                .checkIsRedirectToAlertsPage()
                .clickConfirmButton()
                .checkConfirmAlert()
        ;
    }

    @Test
    public void checkDismissAlert() {
        homePage.openHomePage()
                .isHomePageOpened()
                .clickOnAlertsButton()
                .openAlertsPage()
                .checkIsRedirectToAlertsPage()
                .clickConfirmButton()
                .checkDismissAlert()
        ;
    }

    @Test
    public void checkPromptAlert() {
        homePage.openHomePage()
                .isHomePageOpened()
                .clickOnAlertsButton()
                .openAlertsPage()
                .checkIsRedirectToAlertsPage()
                .clickPromtButton()
                .checkPromtAlert("qwerty")
        ;
    }
}
