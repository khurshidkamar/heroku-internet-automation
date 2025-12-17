package com.khurshid.automation.tests;

import com.khurshid.automation.base.BaseTest;
import com.khurshid.automation.pages.CheckBoxesPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CheckboxesTest extends BaseTest{

    @Test
    public void testCheckboxes(){
        //Navigate
        getDriver().get("https://the-internet.herokuapp.com/checkboxes");

        //page object
        CheckBoxesPage checkBoxesPage = new CheckBoxesPage(getDriver(), waitUtils);

        //Actions
        checkBoxesPage.selectCheckBox1();
        checkBoxesPage.deselectCheckBox2();

        //Assertions
        assertTrue(checkBoxesPage.isCheckbox1Selected(), "Checkbox 1 should be selected");
        assertFalse(checkBoxesPage.isCheckbox2Selected(), "Checkbox 2 should be deselected");

    }
}
