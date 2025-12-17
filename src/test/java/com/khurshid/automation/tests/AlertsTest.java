package com.khurshid.automation.tests;

import com.khurshid.automation.base.BaseTest;
import com.khurshid.automation.pages.AlertsPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AlertsTest extends BaseTest {

    @Test
    public void jsAlertTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        AlertsPage alertsPage = new AlertsPage(driver, waitUtils);
        alertsPage.openJsAlert();

        assertEquals("I am a JS Alert", alertsPage.getAlertText());
        alertsPage.acceptAlert();

        assertEquals("You successfully clicked an alert",
                alertsPage.getResultText());
    }

    @Test
    public void jsConfirmDismissTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        AlertsPage alertsPage = new AlertsPage(driver, waitUtils);
        alertsPage.openJsConfirm();
        alertsPage.dismissAlert();

        assertTrue(alertsPage.getResultText().contains("Cancel"));
    }

    @Test
    void jsPromptTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        AlertsPage alertsPage = new AlertsPage(driver, waitUtils);
        alertsPage.openJsPrompt();
        alertsPage.enterTextInPrompt("Hiya");

        assertTrue(alertsPage.getResultText().contains("Hiya"));
    }
}
