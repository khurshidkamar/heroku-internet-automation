package com.khurshid.automation.tests;

import com.khurshid.automation.base.BaseTest;
import com.khurshid.automation.pages.DropdownPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTest extends BaseTest {

    @Test
    public void testDropdownSelection() {
        getDriver().get("https://the-internet.herokuapp.com/dropdown");

        DropdownPage dropdownPage = new DropdownPage(getDriver(), waitUtils);

        dropdownPage.selectByVisibleText("Option 1");
        assertEquals("Option 1", dropdownPage.getSelectedOption());

        dropdownPage.selectByValue("2");
        assertEquals("Option 2", dropdownPage.getSelectedOption());
    }
}