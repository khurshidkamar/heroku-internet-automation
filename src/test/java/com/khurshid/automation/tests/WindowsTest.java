package com.khurshid.automation.tests;

import com.khurshid.automation.base.BaseTest;
import com.khurshid.automation.pages.WindowsPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WindowsTest extends BaseTest {

    @Test
    public void multipleWindowsTest() {
        driver.get("https://the-internet.herokuapp.com/windows");

        WindowsPage windowsPage = new WindowsPage(driver, waitUtils);

        String parentWindow = driver.getWindowHandle();

        windowsPage.openNewWindow();
        windowsPage.switchToNewWindow(parentWindow);

        assertEquals("New Window", windowsPage.getHeaderText());

        driver.switchTo().window(parentWindow);
    }
}
