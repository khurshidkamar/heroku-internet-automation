package com.khurshid.automation.pages;

import com.khurshid.automation.base.BasePage;
import com.khurshid.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecureAreaPage extends BasePage {

    private final By successMessage = By.id("flash");
    private final By logoutButton = By.cssSelector("a[href='/logout']");

    public SecureAreaPage(WebDriver driver, WaitUtils waitUtils) {
        super(driver, waitUtils);
    }

    public String getSuccessMessage() {
        WebElement msg = waitUtils.waitForVisibility(successMessage);
        return msg.getText();
    }

    public void logout() {
        waitUtils.waitForClickable(logoutButton).click();
    }
}
