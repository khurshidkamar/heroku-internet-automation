package com.khurshid.automation.tests;

import com.khurshid.automation.base.BaseTest;
import com.khurshid.automation.pages.KeyPressesPage;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.Keys;
import com.khurshid.automation.utils.RetryAnalyzer;
public class KeyPressesTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void pressEnterKeyTest() {
        getDriver().get("https://the-internet.herokuapp.com/key_presses");

        KeyPressesPage page = new KeyPressesPage(getDriver(), waitUtils);

        page.pressKey(Keys.ENTER);

        assertTrue(page.getResultText().contains("ENTER"));
        System.out.println(page.getResultText());
    }
}
