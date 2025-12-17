package com.khurshid.automation.tests;

import com.khurshid.automation.base.BaseTest;
import com.khurshid.automation.pages.TablesPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TablesTest extends BaseTest {

    @Test
    public void readTableData() {
        driver.get("https://the-internet.herokuapp.com/tables");

        TablesPage table = new TablesPage(driver, waitUtils);

        String lastName = table.getCellValue(0, "Last Name");
        String email = table.getCellValue(0, "Email");

        assertEquals("Smith", lastName);
        assertEquals("jsmith@gmail.com", email);
    }
    @Test
    public void verifyRowDataByLastName() {
        driver.get("https://the-internet.herokuapp.com/tables");

        TablesPage table = new TablesPage(driver, waitUtils);

        int rowIndex = table.getRowIndexByColumnValue("Last Name", "Bach");

        String email = table.getCellValue(rowIndex, "Email");
        String due = table.getCellValue(rowIndex, "Due");

        assertEquals("fbach@yahoo.com", email);
        assertEquals("$51.00", due);
    }

}
