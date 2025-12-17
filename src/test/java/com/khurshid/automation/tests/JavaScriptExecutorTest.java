package com.khurshid.automation.tests;

import com.khurshid.automation.base.BaseTest;
import com.khurshid.automation.pages.JavaScriptDemoPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class JavaScriptExecutorTest extends BaseTest {

    @Test
    public void javascriptExecutorDemoTest() {
        getDriver().get("https://the-internet.herokuapp.com/dynamic_controls");

        JavaScriptDemoPage page = new JavaScriptDemoPage(getDriver(), waitUtils);

        page.scrollToInput();

        // Initially disabled
        assertTrue(page.isInputDisabled(), "Input should initially be disabled");

        // Remove disabled attribute via JS
        page.enableInputUsingJS();

        // Type text
        page.typeText("JS Executor works!");

        // Verify input is now enabled
        assertFalse(page.isInputDisabled(), "Input should now be enabled");
    }

}
