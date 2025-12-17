package com.khurshid.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowsPage {

    private WebDriver driver;

    private By clickHereLink = By.linkText("Click Here");
    private By headerText = By.tagName("h3");

    public WindowsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openNewWindow() {
        driver.findElement(clickHereLink).click();
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
        return driver.findElement(headerText).getText();
    }
}
