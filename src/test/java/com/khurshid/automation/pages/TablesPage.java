package com.khurshid.automation.pages;

import com.khurshid.automation.base.BasePage;
import com.khurshid.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TablesPage extends BasePage {

    private final By table = By.id("table1");

    public TablesPage(WebDriver driver, WaitUtils waitUtils) {
        super(driver, waitUtils);
    }

    // Wait for table to be visible
    private WebElement getTableElement() {
        return waitUtils.waitForVisibility(table);
    }

    // Get all rows (excluding header)
    public List<WebElement> getRows() {
        return getTableElement().findElements(By.cssSelector("tbody tr"));
    }

    // Get cell value by row index and column name
    public String getCellValue(int rowIndex, String columnName) {
        int columnIndex = getColumnIndex(columnName);
        WebElement row = getRows().get(rowIndex);
        return row.findElements(By.tagName("td")).get(columnIndex).getText();
    }

    // Resolve column index dynamically using header text
    private int getColumnIndex(String columnName) {
        List<WebElement> headers = getTableElement().findElements(By.tagName("th"));
        for (int i = 0; i < headers.size(); i++) {
            if (headers.get(i).getText().equalsIgnoreCase(columnName)) {
                return i;
            }
        }
        throw new RuntimeException("Column not found: " + columnName);
    }

    public int getRowIndexByColumnValue(String columnName, String expectedValue) {
        int columnIndex = getColumnIndex(columnName);
        List<WebElement> rows = getRows();
        for (int i = 0; i < rows.size(); i++) {
            String cellText = rows.get(i).findElements(By.tagName("td")).get(columnIndex).getText();
            if (cellText.equalsIgnoreCase(expectedValue)) {
                return i;
            }
        }
        throw new RuntimeException("Row not found for value: " + expectedValue);
    }
}
