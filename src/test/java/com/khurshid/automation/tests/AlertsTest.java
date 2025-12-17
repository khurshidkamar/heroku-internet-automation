package com.khurshid.automation.tests;

import com.khurshid.automation.base.BaseTest;
import com.khurshid.automation.pages.AlertsPage;
import com.khurshid.automation.utils.RetryAnalyzer;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AlertsTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void jsAlertTest() {
        getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");

        AlertsPage alertsPage = new AlertsPage(getDriver(), waitUtils);
        alertsPage.openJsAlert();

        assertEquals("I am a JS Alert", alertsPage.getAlertText());
        alertsPage.acceptAlert();

        assertEquals("You successfully clicked an alert",
                alertsPage.getResultText());
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void jsConfirmDismissTest() {
        getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");

        AlertsPage alertsPage = new AlertsPage(getDriver(), waitUtils);
        alertsPage.openJsConfirm();
        alertsPage.dismissAlert();

        assertTrue(alertsPage.getResultText().contains("Cancel"));
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    void jsPromptTest() {
        getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");

        AlertsPage alertsPage = new AlertsPage(getDriver(), waitUtils);
        alertsPage.openJsPrompt();
        alertsPage.enterTextInPrompt("Hiya");

        assertTrue(alertsPage.getResultText().contains("Hiya"));
    }
}
