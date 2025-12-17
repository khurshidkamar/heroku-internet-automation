package com.khurshid.automation.tests;

import com.khurshid.automation.base.BaseTest;
import com.khurshid.automation.pages.DynamicControlsPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void testRemoveAndAddCheckbox() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        DynamicControlsPage page = new DynamicControlsPage(driver, waitUtils);

        page.clickRemove();
        assertFalse(page.isCheckboxPresent(), "Checkbox should be removed");
        assertTrue(page.getMessage().contains("It's gone"));

        page.clickAdd();
        assertTrue(page.isCheckboxPresent(), "Checkbox should be added back");
        assertTrue(page.getMessage().contains("It's back"));
    }

    @Test
    public void testEnableAndDisableInput() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        DynamicControlsPage page = new DynamicControlsPage(driver, waitUtils);

        page.clickEnable();
        assertTrue(page.isInputEnabled(), "Input should be enabled");
        assertTrue(page.getMessage().contains("enabled"));

        page.clickDisable();
        assertFalse(page.isInputEnabled(), "Input should be disabled");
        assertTrue(page.getMessage().contains("disabled"));
    }
}
