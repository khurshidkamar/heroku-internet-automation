package com.khurshid.automation.pages;

import com.khurshid.automation.base.BasePage;
import com.khurshid.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class WindowsPage extends BasePage {

    private final By clickHereLink = By.linkText("Click Here");
    private final By headerText = By.tagName("h3");

    public WindowsPage(WebDriver driver, WaitUtils waitUtils) {
        super(driver, waitUtils);
    }

    public void openNewWindow() {
        waitUtils.waitForClickable(clickHereLink).click();
    }

    public void switchToNewWindow(String parentHandle) {
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public String getHeaderText() {
        WebElement header = waitUtils.waitForVisibility(headerText);
        return header.getText();
    }
}
