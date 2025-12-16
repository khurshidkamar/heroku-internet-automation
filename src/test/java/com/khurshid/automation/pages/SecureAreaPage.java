package com.khurshid.automation.pages;

import com.khurshid.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage {

    private final By successMessage = By.id("flash");
    private final By logoutButton = By.cssSelector("a[href='/logout']");

    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public void logout() {
        driver.findElement(logoutButton).click();
    }
}