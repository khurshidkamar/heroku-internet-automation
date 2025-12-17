package com.khurshid.automation.tests;

import com.khurshid.automation.base.BaseTest;
import com.khurshid.automation.pages.HoversPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import com.khurshid.automation.utils.RetryAnalyzer;
public class HoversTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void hoverOverFirstUser() {
        getDriver().get("https://the-internet.herokuapp.com/hovers");

        HoversPage page = new HoversPage(getDriver(), waitUtils);

        page.hoverOverUser(0);

        assertEquals("name: user1", page.getUserName(0));
        assertTrue(page.isProfileLinkVisible(0));
    }
}