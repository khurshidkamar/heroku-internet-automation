package com.khurshid.automation.tests;

import com.khurshid.automation.base.BaseTest;
import com.khurshid.automation.pages.WindowsPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WindowsTest extends BaseTest {

    @Test
    void multipleWindowsTest() {
        driver.get("https://the-internet.herokuapp.com/windows");

        WindowsPage windowsPage = new WindowsPage(driver);

        String parentWindow = driver.getWindowHandle();

        windowsPage.openNewWindow();
        windowsPage.switchToNewWindow(parentWindow);

        assertEquals("New Window", windowsPage.getHeaderText());

        driver.switchTo().window(parentWindow);
    }
}
