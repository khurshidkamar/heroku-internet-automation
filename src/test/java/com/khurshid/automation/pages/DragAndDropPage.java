package com.khurshid.automation.pages;

import com.khurshid.automation.base.BasePage;
import com.khurshid.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage extends BasePage {

    private By columnA = By.id("column-a");
    private By columnB = By.id("column-b");

    public DragAndDropPage(WebDriver driver, WaitUtils waitUtils) {
        super(driver, waitUtils);
    }

    public void dragAToB() {
        WebElement source = waitUtils.waitForVisibility(columnA);
        WebElement target = waitUtils.waitForVisibility(columnB);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }

    public String getColumnAText() {
        return waitUtils.waitForVisibility(columnA).getText();
    }

    public String getColumnBText() {
        return waitUtils.waitForVisibility(columnB).getText();
    }
}
