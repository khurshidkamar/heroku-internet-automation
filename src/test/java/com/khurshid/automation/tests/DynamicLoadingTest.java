package com.khurshid.automation.tests;

import com.khurshid.automation.base.BaseTest;
import com.khurshid.automation.pages.DynamicLoadingPage;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class DynamicLoadingTest extends BaseTest {

    @Test
    public void dynamicLoadingExample1() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        DynamicLoadingPage page = new DynamicLoadingPage(driver, waitUtils);
        page.clickStart();

        String text = page.getFinishText();
        assertEquals("Hello World!", text);
    }

    @Test
    public void dynamicLoadingExample2() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        DynamicLoadingPage page = new DynamicLoadingPage(driver, waitUtils);
        page.clickStart();

        String text = page.getFinishText();
        assertEquals("Hello World!", text);
    }
}
