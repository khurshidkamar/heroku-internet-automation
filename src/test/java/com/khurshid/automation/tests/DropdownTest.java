package com.khurshid.automation.tests;

import com.khurshid.automation.base.BaseTest;
import com.khurshid.automation.pages.DropdownPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropdownTest extends BaseTest {

    @Test
    void testDropdownSelection() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        DropdownPage dropdownPage = new DropdownPage(driver);

        dropdownPage.selectByVisibleText("Option 1");
        assertEquals("Option 1", dropdownPage.getSelectedOption());

        dropdownPage.selectByValue("2");
        assertEquals("Option 2", dropdownPage.getSelectedOption());
    }
}