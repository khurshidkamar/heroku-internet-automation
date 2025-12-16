package com.khurshid.automation.tests;

import com.khurshid.automation.base.BaseTest;
import com.khurshid.automation.pages.FramesPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FramesTest extends BaseTest {

    @Test
    void iframeTest() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        FramesPage framesPage = new FramesPage(driver);

        framesPage.switchToIframe();
//        framesPage.clearAndTypeText("Hello from Selenium");
//        assertEquals("Hello from Selenium", framesPage.getEditorText());
        assertTrue(framesPage.frameIsDisplayed());

        framesPage.switchBackToMainPage();
    }
}