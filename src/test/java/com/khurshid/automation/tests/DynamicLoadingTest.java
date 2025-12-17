package com.khurshid.automation.tests;

import com.khurshid.automation.base.BaseTest;
import com.khurshid.automation.pages.DynamicLoadingPage;

import com.khurshid.automation.utils.RetryAnalyzer;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class DynamicLoadingTest extends BaseTest {

    @Test (retryAnalyzer = RetryAnalyzer.class)
    public void dynamicLoadingExample1() {
        getDriver().get("https://the-internet.herokuapp.com/dynamic_loading/1");

        DynamicLoadingPage page = new DynamicLoadingPage(getDriver(), waitUtils);
        page.clickStart();

        String text = page.getFinishText();
        assertEquals("Hello World!", text);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void dynamicLoadingExample2() {
        getDriver().get("https://the-internet.herokuapp.com/dynamic_loading/2");

        DynamicLoadingPage page = new DynamicLoadingPage(getDriver(), waitUtils);
        page.clickStart();

        String text = page.getFinishText();
        assertEquals("Hello World!", text);
    }
}
