package alertsTests;

import baseTest.BaseTest;
import org.junit.Test;

public class AlertsTests extends BaseTest {
    private String keys = "qwerty";

    @Test
    public void checkSimpleAlert() {
        homePage.openHomePage()
                .isHomePageOpened()
                .clickOnAlertsButton()
                .openAlertsPage()
                .checkIsRedirectToAlertsPage()
                .clickAlertButtonAndSwitchToOpenedPopUp()
                .checkSimpleAlert()
                .acceptAlert()
        ;
    }

    @Test
    public void checkTimerAlert() {
        homePage.openHomePage()
                .isHomePageOpened()
                .clickOnAlertsButton()
                .openAlertsPage()
                .checkIsRedirectToAlertsPage()
                .clickTimerAlertButtonAndSwitchToOpenedPopUp()
                .checkTimerAlert()
                .acceptAlert()
        ;
    }

    @Test
    public void checkConfirmAlert() {
        homePage.openHomePage()
                .isHomePageOpened()
                .clickOnAlertsButton()
                .openAlertsPage()
                .checkIsRedirectToAlertsPage()
                .clickConfirmButtonAndSwitchToOpenedPopUp()
                .checkConfirmAlert()
                .acceptAlert()
                .checkConfirmTextFromConfirmAlert()
        ;
    }

    @Test
    public void checkDismissAlert() {
        homePage.openHomePage()
                .isHomePageOpened()
                .clickOnAlertsButton()
                .openAlertsPage()
                .checkIsRedirectToAlertsPage()
                .clickConfirmButtonAndSwitchToOpenedPopUp()
                .checkDismissAlert()
                .dismissAlert()
                .checkDismissTextFromConfirmAlert()
        ;
    }

    @Test
    public void checkPromptAlert() {
        homePage.openHomePage()
                .isHomePageOpened()
                .clickOnAlertsButton()
                .openAlertsPage()
                .checkIsRedirectToAlertsPage()
                .clickPromtButtonAndSwitchToOpenedPopUp()
                .checkPromtAlert(keys)
                .acceptAlert()
                .checkTextFromPromtAlert(keys)
        ;
    }
}
