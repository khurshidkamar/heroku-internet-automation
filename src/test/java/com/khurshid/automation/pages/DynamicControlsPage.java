package com.khurshid.automation.pages;

import com.khurshid.automation.base.BasePage;
import com.khurshid.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicControlsPage extends BasePage {

    private By checkbox = By.id("checkbox");
    private By removeButton = By.xpath("//button[text()='Remove']");
    private By addButton = By.xpath("//button[text()='Add']");
    private By enableButton = By.xpath("//button[text()='Enable']");
    private By disableButton = By.xpath("//button[text()='Disable']");
    private By inputField = By.cssSelector("#input-example input");
    private By message = By.id("message");

    public DynamicControlsPage(WebDriver driver, WaitUtils waitUtils) {
        super(driver, waitUtils);
    }

    // ----- Checkbox section -----
    public void clickRemove() {
        waitUtils.waitForClickable(removeButton).click();
        waitUtils.waitForInvisibility(checkbox);
    }

    public void clickAdd() {
        waitUtils.waitForClickable(addButton).click();
        waitUtils.waitForVisibility(checkbox);
    }

    public boolean isCheckboxPresent() {
        return !driver.findElements(checkbox).isEmpty();
    }

    // ----- Input section -----
    public void clickEnable() {
        waitUtils.waitForClickable(enableButton).click();
        waitUtils.waitForClickable(inputField);
    }

    public void clickDisable() {
        waitUtils.waitForClickable(disableButton).click();
        waitUtils.waitForDisabled(inputField);
    }

    public boolean isInputEnabled() {
        return driver.findElement(inputField).isEnabled();
    }

    public String getMessage() {
        return waitUtils.waitForVisibility(message).getText();
    }
}
