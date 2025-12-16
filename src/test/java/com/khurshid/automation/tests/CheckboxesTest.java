package com.khurshid.automation.tests;

import com.khurshid.automation.base.BaseTest;
import com.khurshid.automation.pages.CheckBoxesPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CheckboxesTest extends BaseTest{

    @Test
    void testCheckboxes(){
        //Navigate
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //page object
        CheckBoxesPage checkBoxesPage = new CheckBoxesPage(driver);

        //Actions
        checkBoxesPage.selectCheckBox1();
        checkBoxesPage.deselectCheckBox2();

        //Assertions
        assertTrue(checkBoxesPage.isCheckbox1Selected(), "Checkbox 1 should be selected");
        assertFalse(checkBoxesPage.isCheckbox2Selected(), "Checkbox 2 should be deselected");

    }
}
