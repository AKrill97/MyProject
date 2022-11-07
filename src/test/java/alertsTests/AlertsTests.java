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
                .clickPromtButton()
                .checkPromtAlert("qwerty")
        ;
    }
}
