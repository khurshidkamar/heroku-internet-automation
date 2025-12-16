package com.khurshid.automation.tests;

import com.khurshid.automation.base.BaseTest;
import com.khurshid.automation.pages.AlertsPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlertsTest extends BaseTest {

    @Test
    void jsAlertTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.openJsAlert();

        assertEquals("I am a JS Alert", alertsPage.getAlertText());
        alertsPage.acceptAlert();

        assertEquals("You successfully clicked an alert",
                alertsPage.getResultText());
    }

    @Test
    void jsConfirmDismissTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.openJsConfirm();
        alertsPage.dismissAlert();

        assertTrue(alertsPage.getResultText().contains("Cancel"));
    }

    @Test
    void jsPromptTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.openJsPrompt();
        alertsPage.enterTextInPrompt("Hiya");

        assertTrue(alertsPage.getResultText().contains("Hiya"));
    }
}
