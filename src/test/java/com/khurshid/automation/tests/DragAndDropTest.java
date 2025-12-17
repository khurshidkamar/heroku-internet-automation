package com.khurshid.automation.tests;

import com.khurshid.automation.base.BaseTest;
import com.khurshid.automation.pages.DragAndDropPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DragAndDropTest extends BaseTest {

    @Test
    public void dragAndDropTest() {
        getDriver().get("https://the-internet.herokuapp.com/drag_and_drop");

        DragAndDropPage page = new DragAndDropPage(getDriver(), waitUtils);

        page.dragAToB();

        assertEquals("B", page.getColumnAText());
        assertEquals("A", page.getColumnBText());
    }
}
