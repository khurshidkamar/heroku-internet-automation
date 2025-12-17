package com.khurshid.automation.pages;

import com.khurshid.automation.base.BasePage;
import com.khurshid.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FramesPage extends BasePage {

    private By iframe = By.id("mce_0_ifr");
    private By textBox = By.id("tinymce");

    public FramesPage(WebDriver driver, WaitUtils waitUtils) {
        super(driver, waitUtils);
    }

    public void switchToIframe() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
    }

    public void clearAndTypeText(String text) {
        WebElement editor = waitUtils.waitForVisibility(textBox);
        editor.clear();
        editor.sendKeys(text);
    }

    public String getEditorText() {
        return waitUtils.waitForVisibility(textBox).getText();
    }

    public boolean frameIsDisplayed() {
        return waitUtils.waitForVisibility(textBox).isDisplayed();
    }

    public void switchBackToMainPage() {
        driver.switchTo().defaultContent();
    }
}
