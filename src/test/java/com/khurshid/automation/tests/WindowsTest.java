package com.khurshid.automation.tests;

import com.khurshid.automation.base.BaseTest;
import com.khurshid.automation.pages.WindowsPage;
import com.khurshid.automation.utils.RetryAnalyzer;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WindowsTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void multipleWindowsTest() {
        getDriver().get("https://the-internet.herokuapp.com/windows");

        WindowsPage windowsPage = new WindowsPage(getDriver(), waitUtils);

        String parentWindow = getDriver().getWindowHandle();

        windowsPage.openNewWindow();
        windowsPage.switchToNewWindow(parentWindow);

        assertEquals("New Window", windowsPage.getHeaderText());

        getDriver().switchTo().window(parentWindow);
    }
}
