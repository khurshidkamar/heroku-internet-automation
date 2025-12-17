package com.khurshid.automation.tests;

import com.khurshid.automation.base.BaseTest;
import com.khurshid.automation.pages.FramesPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FramesTest extends BaseTest {

    @Test
    public void iframeTest() {
        getDriver().get("https://the-internet.herokuapp.com/iframe");

        FramesPage framesPage = new FramesPage(getDriver(), waitUtils);

        framesPage.switchToIframe();
//        framesPage.clearAndTypeText("Hello from Selenium");
//        assertEquals("Hello from Selenium", framesPage.getEditorText());
        assertTrue(framesPage.frameIsDisplayed());

        framesPage.switchBackToMainPage();
    }
}